package test

/**
  * Created by zhangyinglong on 2018/11/28.
  */
abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree
