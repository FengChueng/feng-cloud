package test

/**
  * Created by zhangyinglong on 2018/11/28.
  */
object MainTest {
    type Environment = String => Int

    def derive(t: Tree, v: String): Tree = t match {
        case Sum(l, r) => Sum(derive(l, v), derive(r, v))
        case Var(n) if (v == n) => Const(1)
        case _ => Const(0)
    }

    def eval(t: Tree, env: Environment): Int = t match {
        case Sum(l, r) => eval(l, env) + eval(r, env)
        case Var(n) => env(n)
        case Const(v) => v
    }

    def main(args: Array[String]) {
        val exp: Tree = Sum(Sum(Var("x"),Var("x")),Sum(Const(7),Var("y")))
        val env: Environment = { case "x" => 5 case "y" => 7 }
        println("Expression: " + exp)
        println("Evaluation with x=5, y=7: " + eval(exp, env))
        println("Derivative relative to x:\n " + derive(exp, "x"))
        println("Derivative relative to y:\n " + derive(exp, "y"))
    }

}
