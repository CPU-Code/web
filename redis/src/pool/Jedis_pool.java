package pool;

//jedis连接池使用

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Jedis_pool {
    public static void main(String[] args){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();

        //最大活动对象数
        config.setMaxTotal(50);
        //最大能够保持idel状态的对象数
        config.setMaxIdle(10);

        //1.创建Jedis连接池对象
        JedisPool  jedisPool = new JedisPool(config, "localhost", 6379);

        //2.获取连接
        Jedis jedis = jedisPool.getResource();
        //3. 使用
        jedis.set("name", "cpu_code");

        //4. 关闭 归还到连接池中
        jedis.close();
    }
}

/*
    #最大活动对象数
    redis.pool.maxTotal=1000

    #最大能够保持idel状态的对象数
    redis.pool.maxIdle=100

    #最小能够保持idel状态的对象数
    redis.pool.minIdle=50

    #当池内没有返回对象时，最大等待时间
    redis.pool.maxWaitMillis=10000
    #当调用borrow Object方法时，是否进行有效性检查
    redis.pool.testOnBorrow=true
    #当调用return Object方法时，是否进行有效性检查
    redis.pool.testOnReturn=true
    #“空闲链接”检测线程，检测的周期，毫秒数。如果为负值，表示不运行“检测线程”。默认为-1.
    redis.pool.timeBetweenEvictionRunsMillis=30000
    #向调用者输出“链接”对象时，是否检测它的空闲超时；
    redis.pool.testWhileIdle=true
    # 对于“空闲链接”检测线程而言，每次检测的链接资源的个数。默认为3.
    redis.pool.numTestsPerEvictionRun=50
    #redis服务器的IP
    redis.ip=xxxxxx
    #redis服务器的Port
    redis1.port=6379
* */