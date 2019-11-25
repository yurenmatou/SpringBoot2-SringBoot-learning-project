《Redis练习》

一、配置
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=localhost
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.lettuce.pool.max-active=8
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.lettuce.pool.max-wait=-1
# 连接池中的最大空闲连接 默认 8
spring.redis.lettuce.pool.max-idle=8
# 连接池中的最小空闲连接 默认 0
spring.redis.lettuce.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=0

2、@EnableCaching 开启缓存 ，重写keyGenerator

3、@Cacheable 接口请求时，加注解，表示缓存当前数据

4、@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 6000)
maxInactiveIntervalInSeconds: 设置 Session 失效时间，会替换原来的server.session.timeout 属性。



二、
