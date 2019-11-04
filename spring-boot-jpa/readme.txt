1、添加jpa和mysql依赖
2、配置username、password、url、driver
3、实现类继承JpaRepository<T,V>
4、添加映射数据库表中的类，例如User，使用注解@Entity、@Id、@Column、@GeneratedValue
5、测试：注解@Resource 获取实例，调用增删改成
