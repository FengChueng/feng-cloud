package test

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class GatlingTest extends Simulation {
    //object GatlingTest {
    //  val httpProtocol = http.base
    //  val scn = scenario("testapi").repeat(100)
    //  def main(args: Array[String]): Unit = {
    //    println("hello": String)
    //  }

    //    setUp(scn.inject(atOnceUsers(30))).maxDuration(FiniteDuration.apply(10, "minutes"))

    val feeder = csv("register.csv").random

    var headers_body = // 设置默认的请求头
        Map(
            "User-Agent" -> "Dalvik/2.1.0 (Linux; U; Android 7.1.1; 1707-A01 Build/NMF26X)",
            "Content-Type" -> "application/json; charset=UTF-8",
        )

    var headers_param = // 设置默认的请求头
        Map(
            "User-Agent" -> "Dalvik/2.1.0 (Linux; U; Android 7.1.1; 1707-A01 Build/NMF26X)",
            "Content-Type" -> "application/x-www-form-urlencoded",
        )

    object Register {
        var register = feed(feeder)
          .exec(
              http("register")
                .post("/test/user/register")
                .headers(headers_param)
                .formParam("name", "${name}")
                .formParam("pwd", "${pwd}"))
          .pause(5) // 10
    }

    object Login {
        var login = feed(feeder)
          .exec(
              http("login")
                .post("/test/user/login")
                .headers(headers_body)
                .body(ElFileBody("login.json")).asJson
                .check(status.is(200))
//                .check(jsonPath("$.body").exists.saveAs("token"))
                .check(bodyString.exists.saveAs("token"))
          )
          .exec { session => {
              println("token:" + session("token").as[String])
              session
          }
          }
    }

    object UserInfo {
        var userInfo = feed(feeder)
            .repeat(10){
                exec(
                    http("userinfo")
                      .get("/test/user/info/${name}")
                      .check(status.is(200))
                      //                .check(jsonPath("$.body").exists.saveAs("userinfo"))
                      .check(bodyString.exists.saveAs("userinfo"))
                )
                  .exec { session => {
                      println("userinfo:" + session("userinfo").as[String])
                      session
                  }
                  }.pause(5)
            }
    }


    val httpProtocol = http // 4
      .baseUrl("http://127.0.0.1:8080") // 5
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
      //      .header("Content-Type", "application/json")
      .doNotTrackHeader("1")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

    //    val scn = scenario("BasicSimulation") // 7
    //      .exec(http("register") // 8
    //          .get("/user/register?name=test&pwd=test")) // 9
    //      .pause(5) // 10
    //      .exec(
    //        http("login")
    //            .post("/user/login")
    //          .body(RawFileBody.apply("login.json")).asJson
    //    )

//    val user = scenario("user").exec(Register.register, Login.login,UserInfo.userInfo)
    val user = scenario("user").exec(Login.login,UserInfo.userInfo)

    setUp(
        user.inject(atOnceUsers(10))
    ).protocols(httpProtocol)


    //    val scn = scenario("BasicSimulation") // 7
    //      .repeat(1000, "n") {
    //        exec(http("request_1") // 8
    //          .get("/user/register?name=test&pwd=test")) // 9
    //          .pause(Duration.apply(5, TimeUnit.MILLISECONDS)) // 10
    //    }.repeat(1000, "test") {
    //        exec(
    //            http("GetPerson-API")
    //              .get("/user/info/${n}")
    //              .check(status.is(200))
    //        )
    //    }

}