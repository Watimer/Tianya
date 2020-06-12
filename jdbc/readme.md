## Spring boot整合使用JDBC连接MySQL数据库

### 说明

庚子之初，新冠横行。纵使集华夏之力，三月始消。
工作三年有余，因此疫情，方觉唯有学习知识，日益精进，才能在未来不确定的生活中，立于不败之地。

因为最近打算更深入的学习一下MyBatis框架，苦于探索合适的方法而迟迟不进，在此之际，
突然想到大学时高数老师说的一句话：如果这道题你不会做，你就抄例题，如果抄完例题还不会，就继续抄例题，直到抄会为止。后来，我抄了四年的例题，顺利毕业。

扯远了哈，回归正题。既然要学习MyBatis框架,那么原生的JDBC肯定是无法绕过的一个槛，因为MyBatis框架是对JDBC的封装，换句话说就是MyBatis框架是根据JDBC实现的。
对此，以此案例，再次熟悉一下JDBC的内容。

### JDBC是什么
维基百科中对JDBC的解释是：Java 数据库连接，（Java Database Connectivity，简称JDBC）是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，提供了诸如查询和更新数据库中数据的方法。
换句我们能听懂的话是，JDBC是Java语言用来连接数据库的桥梁，是一套规范用来提供对MySQL、Oracle、Sql Server等关系型数据库的连接。JDBC并不执行SQL语句，但是JDBC提供了执行SQL语句的接口。

### 项目搭建

#### 引入相关依赖
上次使用JDBC还是Java初学阶段,这次使用Spring boot整合JDBC。使用Spring boot简化了jar包的引入流程，其他方面并无区别。
新建Spring boot项目的过程这次不做说明，主要说一下比较关键的地方。使用JDBC连接数据库，首先要引入相关依赖，我使用MySQL作为测试数据库，
所以引入的依赖是：
```xml
    <!--JDBC连接mysql数据库-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
```

在此说明一下其他数据库的连接依赖，对自己的知识点也算一种扩展
```xml
    <!--JDBC连接Oracle数据库-->
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc6</artifactId>
        <version>11.2.0</version>
    </dependency> 
    
    <!--JDBC连接SQL Server数据库-->
    <dependency>
        <groupId>com.microsoft.sqlserver</groupId>
        <artifactId>sqljdbc4</artifactId>
        <version>4.0</version>
    </dependency>

```

这里贴出现在的pom.xml文件
```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.3.1.RELEASE</version>
            <relativePath/> <!-- lookup parent from repository -->
        </parent>
        <groupId>com.watimer.study</groupId>
        <artifactId>jdbc</artifactId>
        <version>0.0.1-SNAPSHOT</version>
        <name>jdbc</name>
        <description>Demo project for Spring Boot</description>
    
        <properties>
            <java.version>1.8</java.version>
        </properties>
    
        <dependencies>
            <!--JDBC-->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-jdbc</artifactId>
            </dependency>
    
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
    
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
                <exclusions>
                    <exclusion>
                        <groupId>org.junit.vintage</groupId>
                        <artifactId>junit-vintage-engine</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
        </dependencies>
    
        <build>
            <plugins>
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
            </plugins>
        </build>
    
    </project>

```

#### 添加数据库配置文件和其他参数
在resource文件夹下application.properties文件中添加相关配置参数:
```properties
    # 启动端口号
    server.port=9696
```

### 新建测试类
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/jdbc")
public class TestController {

    @RequestMapping("/user")
    @ResponseBody
    public List<Map> list() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Map> list = new ArrayList<>();
        try {
            // 1、获取Connection
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.15:3306/ivt-city?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull","root","Aa123456");
            // 2、获取Statement
            statement = connection.createStatement();
            // 3、准备SQL
            String sql = "SELECT * FROM jj_lavendy_user_info";
            // 4、执行查询,得到ResultSet
            resultSet = statement.executeQuery(sql);
            // 5、处理ResultSet
            Map map = new ConcurrentHashMap();
            while (resultSet.next()){
                map.put("id",resultSet.getString("userId"));
                map.put("lavendy_user_name",resultSet.getString("lavendy_user_name"));
                list.add(map);
            }
        } catch (SQLException e) {
            // 6、关闭数据库资源
            connection.close();
            e.printStackTrace();
        } finally {
            // 6、关闭数据库资源
            connection.close();
        }

        for (Map map:list){
            System.out.println(map.toString());
        }
        return list;

    }
}

```
    
### 执行结果
#### 接口请求
![fe590f19c9ef9515c5637bd9ebb3ff23.png](en-resource://database/2091:0)

#### 打印结果
![dc53c283f9ce4dd71090a765e52d8bf3.png](en-resource://database/2089:1)



### 相关资料
#### 数据库表信息
![c9897672e53f6a219d6eac5ae7fca222.png](en-resource://database/2087:1)

