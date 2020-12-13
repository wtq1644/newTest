






## 注解说明
-@Autowird:自动装配通过类型,名字
    如果Autowired不能唯一自动装配上属性,则需要通过@Qualifier(value="xxx")
-@Nullable 字段标记了这个注解,说明这个字段可以为null
-@Resource : 自动装配通过名字,类型
-@Component : 组件,放在类上,说明这个类被Spring管理了,这就说bean!

## 衍生的注解
@Component有几个衍生注解,我们在web开发中,会按照mvc三层架构分层
    . dao [@Repository]
    . service [@Service]
    . controller [@Controller]
      这个四个注解功能都是一样的,都是代表将某个类注册到Srping中,装配Bean

## 作用域
 @Scope("prototype")



