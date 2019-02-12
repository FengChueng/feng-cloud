package test


import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by zhangyinglong on 2018/12/5.
  */
class UserTest extends Simulation {

    val httpProtocol = http // 4
            .baseUrl("http://www.lytxmd.com/quickwash/api") // 5
//      .baseUrl("http://web.lytxmd.com/quickwash/api") // 5
      .acceptHeader("text/html,application/xhtml+xml,application/xml,application/json;q=0.9,*/*;q=0.8") // Here are the common headers
      //      .header("Content-Type", "application/json")
      .doNotTrackHeader("1")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

    val assert_rsp_status = status.is(200) // 正常HTTP响应码为200

    var headers_body = // 设置默认的请求头
        Map(
            "Content-Type" -> "application/json; charset=UTF-8"
        )

    val user_feeder = Array(
        Map("account" -> "admin", "password" -> "admin")/*,
        Map("account" -> "admin1", "password" -> "123456"),
        Map("account" -> "admin2", "password" -> "123456")*/
    ).random

    object Login {
        var login = feed(user_feeder)
        //          .repeat(10) {
          .exec(
            http("manager-login")
              .post("/manager/login")
              //                .headers(headers_body)
              .body(ElFileBody("login.json")).asJson
              .check(assert_rsp_status)
              .check(jsonPath("$.code").is("0"))
              .check(jsonPath("$.data").exists.saveAs("response"))
              .check(jsonPath("$.data.token.accessToken").exists.saveAs("accessToken"))
        )
          .exec { session => {
              //                    println("response:" + session("response").as[String])
              println("accessToken:" + session("accessToken").as[String])
              session
          }
          }
        //          }
    }

    val user = scenario("user").exec(Login.login)

//    setUp(
//        user.inject(atOnceUsers(1000))
//    ).protocols(httpProtocol)

    //600秒跑1000个用户
//    setUp(user.inject(rampUsers(100000) over (600 seconds)).protocols(httpProtocol))

    //10分钟内从每秒250个用户增长到每秒300个用户
//    setUp(user.inject(rampUsersPerSec(250) to 300 during(10 minutes)).protocols(httpProtocol))

    //一次并发每秒300用户
    setUp(user.inject(atOnceUsers(600)).protocols(httpProtocol))

}
