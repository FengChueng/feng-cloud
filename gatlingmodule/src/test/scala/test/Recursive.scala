package test

/**
  * Created by zhangyinglong on 2018/11/28.
  */
class Recursive {
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

}
