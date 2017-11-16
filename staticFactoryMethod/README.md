# 简单工厂模式

## 定义

又叫静态工厂方法模式，由一个工厂对象决定创建出哪一种产品类的实例。

## 结构

![这里写图片描述](http://img.blog.csdn.net/20171116171432870?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTW9vbl9DYWk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 优劣

- 优点

  - 可以决定在什么时候创建哪一个具体类的实例，而调用者则可以免除直接创建对象的责任，实现了对责任的分割。
  - 当系统引入新的方式的时候无需修改调用者。

- 缺点

  工厂类集合所有的创建逻辑，当有复杂的多层次等级结构时，工厂类代码逻辑会变得很复杂，可读性差，而且容易书写错误。