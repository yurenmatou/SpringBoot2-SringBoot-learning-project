1、添加jpa和mysql依赖
2、配置username、password、url、driver
3、实现类继承JpaRepository<T,V>
4、添加映射数据库表中的类，例如User，使用注解@Entity、@Id、@Column、@GeneratedValue
5、测试：注解@Resource 获取实例，调用增删改查

上面是实现简单的增删改查

一、接下来是自定义查询sql
1、语法：findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy  关键字配合Or ，And 例如findByUserNameOrEmail，XX代表对应Entity中的字段
2、删除 deleteById 计算数量：countByUserName
模糊查询 findByEmailLike
忽略查询 findByUserNameIgnoreCase
排序查询 findByUserNameOrderByEmailDesc
具体的我放后面，因为太多了，参考网上


二、简单的自定义查询
1、使用注解@Query，跟mysql写法区别不大，可以看详细代码
2、@Transactional 开启事务控制
3、@Modifying 表示修改，当更新或者删除时使用


三、联表查询
查询User和UserDetail表
UserDetail 有对方User的id
like模糊查询，CONCAT 拼接查询的条件
 @Query( "select u.userName as userName, d.hobby as hobby from User u , UserDetail d where u.id=d.userId and d.hobby like CONCAT('%',:hobby,'%')" )
方法举例：findUserWithUserDetail(@Param("hobby") String hobby);


四、分页实现
Pageable 分页
Sort     排序
int page=1,size=2;
Sort sort = new Sort(Sort.Direction.DESC, "id");
Pageable pageable = PageRequest.of(page, size, sort);




具体的关键字，使用方法和生产成SQL如下表所示
Keyword	                Sample	                                            JPQL snippet
And	                    findByLastnameAndFirstname	                        … where x.lastname = ?1 and x.firstname = ?2
Or	                    findByLastnameOrFirstname	                        … where x.lastname = ?1 or x.firstname = ?2
Is,Equals	            findByFirstnameIs,findByFirstnameEquals	            … where x.firstname = ?1
Between	                findByStartDateBetween	                            … where x.startDate between ?1 and ?2
LessThan	            findByAgeLessThan	                                … where x.age < ?1
LessThanEqual	        findByAgeLessThanEqual	                            … where x.age ⇐ ?1
GreaterThan	            findByAgeGreaterThan	                            … where x.age > ?1
GreaterThanEqual	    findByAgeGreaterThanEqual	                        … where x.age >= ?1
After	                findByStartDateAfter	                            … where x.startDate > ?1
Before	                findByStartDateBefore	                            … where x.startDate < ?1
IsNull	                findByAgeIsNull	                                    … where x.age is null
IsNotNull,NotNull	    findByAge(Is)NotNull	                            … where x.age not null
Like	                findByFirstnameLike	                                … where x.firstname like ?1
NotLike	                findByFirstnameNotLike	                            … where x.firstname not like ?1
StartingWith	        findByFirstnameStartingWith	                        … where x.firstname like ?1 (parameter bound with appended %)
EndingWith	            findByFirstnameEndingWith	                        … where x.firstname like ?1 (parameter bound with prepended %)
Containing	            findByFirstnameContaining	                        … where x.firstname like ?1 (parameter bound wrapped in %)
OrderBy	                findByAgeOrderByLastnameDesc	                    … where x.age = ?1 order by x.lastname desc
Not	                    findByLastnameNot	                                … where x.lastname <> ?1
In	                    findByAgeIn(Collection ages)	                    … where x.age in ?1
NotIn	                findByAgeNotIn(Collection age)	                    … where x.age not in ?1
TRUE	                findByActiveTrue()	                                … where x.active = true
FALSE	                findByActiveFalse()	                                … where x.active = false
IgnoreCase	            findByFirstnameIgnoreCase	                        … where UPPER(x.firstame) = UPPER(?1)
