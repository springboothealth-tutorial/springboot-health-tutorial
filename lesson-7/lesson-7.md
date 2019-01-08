---
show: step
version: 1.0
---

# 后台接口开发(用户侧-2)

##  一、实验简介

### 1.1 实验内容
​	本节实验依然是用户端后台接口开发，主要有三大功能

- 记录用户饮食情况
- 记录用户运动情况


- 显示用户主要生理指标与用户饮食、运动关系，以此来指导用户合理饮食和运动

### 1.2 实验知识点

- Spring Boot HTTP开发、常用配置
- Mybatis 常用配置及CURD操作
- Mybatis分页
- Mybatis级联查询

### 1.3 效果展示

​	安装`jq`软件，可以美化`json`数据，为了减少版面，这里演示一个接口，大家在测试的时候可以在`curl`后增加一个管道符`|`使用`jq`

```shell
$ sudo apt-get update
$ sudo apt-get -y install jq
```

​	下图为通过`curl`向后台接口发送请求，后台接口返回给前端的数据。该接口功能为获取`userId=1`用户的生理指标与用户饮食、运动数据，前端可以使用这组数据渲染页面，展示用户体重、血压等指标与用户运动、饮食的关系。

![1-3-1](./pic/1-3-1.JPG)
![1-3-2](./pic/1-3-2.JPG)

​	上面的`json`数据主要字段含义解释如下：

- `userId` ：用户`id`
- `foodEnergies` ：用户饮食情况
  - `energy` ：用户摄入能量，单位千卡
  - `collectDate` ：记录用户摄入能量日期
- `sportEnergies` ：用户运动情况
  - `energy` ：用户运动消耗能量，单位千卡
  - `collectDate` ：记录用户消耗能量日期
- `userIndexs `：用户主要生理指标
  - `id` ：主键`id`
  - `indexType` ：用户生理指标类型
  - `indexContent` ：用户生理指标
  - `collectDate `：记录用户生理指标日期


### 1.4 实验环境

- Eclipse Neon.2 Release (4.6.2)
- Java 1.8
- Maven 3.5
- Spring Boot 2.0.6
- Mybatis 3.4.6
- MySQL 5.7
- curl

## 二、实验步骤

#### 2.1 项目结构





![2-1-1](./pic/2-1-1.JPG)

![2-1-2](./pic/2-1-2.JPG)

#### 2.2 创建项目

在web IDE界面中，选择File -> Open New Terminal，在终端中输入

```shell
$ mvn archetype:generate -DgroupId=com.shiyanlou -DartifactId=lesson7 -DarchetypeArtifactId=maven-archetype-webapp
```

参数介绍：

- `archetype:generate`：表示使用maven创建项目基本骨架
- `DgroupId`：该项目所属组织，一般将域名倒着写，例如：com.shiyanlou
- `DartifactId`：项目名称，例如：clock
- `DarchetypeArtifactId`：指定所用maven项目骨架类型

输入命令后，maven开始创建项目、下载所需的依赖，等待片刻，maven提示我们输入版本号，直接回车，我们使用默认版本号`1.0-SNAPSHOT`即可。随后maven会输出`groupId`、`artifactId`、`version`、`package`这些基本信息，直接输入`Y`确认即可。最后可以看到绿色的`BUILD SUCCESS`项目创建成功的提示。

然后在web IDE界面中，选择File -> Open Workspace切换工作空间，选择lesson7目录，必须切换到该目录下，否则识别不了项目。

最后大家可以根据上图所示的目录结构，自己创建目录、文件，较为简单，无需赘述。



#### 2.3 修改pom文件

`将如下配置文件覆盖到pom.xml中`

- `spring-boot-starter-web`：Spring Boot为Web开发提供支持
- `mybatis-spring-boot-starter`：为Mybatis与Spring Boot整合提供支持
- `mysql-connector-java`：MySQL的JDBC驱动包，连接MySQL数据库时必须使用该jar包。
- `druid`：阿里巴巴开源的数据库连接池

- `pagehelper-spring-boot-starter`用来支持Mybatis分页
- `spring-boot-devtools`用来支持热部署，当配置了`devtools `后，我们在`classpath`修改任何文件，保存后，项目都将会自动重启，方便开发。

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   	<modelVersion>4.0.0</modelVersion>

   	<groupId>com.shiyanlou</groupId>
   	<artifactId>lesson7</artifactId>
   	<version>0.0.1-SNAPSHOT</version>
   	<packaging>jar</packaging>

   	<name>health</name>
   	<description>Demo project for Spring Boot</description>

   	<parent>
   		<groupId>org.springframework.boot</groupId>
   		<artifactId>spring-boot-starter-parent</artifactId>
   		<version>2.0.1.RELEASE</version>
   		<relativePath /> <!-- lookup parent from repository -->
   	</parent>

   	<properties>
   		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
   		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
   		<java.version>1.8</java.version>
   	</properties>

   	<dependencies>
   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-web</artifactId>
   		</dependency>
   		<dependency>
   			<groupId>org.mybatis.spring.boot</groupId>
   			<artifactId>mybatis-spring-boot-starter</artifactId>
   			<version>1.3.2</version>
   		</dependency>

   		<dependency>
   			<groupId>mysql</groupId>
   			<artifactId>mysql-connector-java</artifactId>
   			<scope>runtime</scope>
   		</dependency>

   		<dependency>
   			<groupId>com.alibaba</groupId>
   			<artifactId>druid</artifactId>
   			<version>1.1.6</version>
   		</dependency>

   		<dependency>
   			<groupId>com.github.pagehelper</groupId>
   			<artifactId>pagehelper-spring-boot-starter</artifactId>
   			<version>1.2.3</version>
   		</dependency>

   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-devtools</artifactId>
   			<optional>true</optional>
   		</dependency>

   		<dependency>
   			<groupId>org.springframework.boot</groupId>
   			<artifactId>spring-boot-starter-test</artifactId>
   			<scope>test</scope>
   		</dependency>
   	</dependencies>

   	<build>
   		<plugins>
   			<plugin>
   				<groupId>org.springframework.boot</groupId>
   				<artifactId>spring-boot-maven-plugin</artifactId>
   			</plugin>
   		</plugins>

   		<resources>
               <resource>
                   <directory>src/main/java</directory>
                   <excludes>
                       <exclude>**/*.java</exclude>
                   </excludes>
               </resource>
           </resources>
   	</build>
   </project>
   ```


#### 2.4 创建application文件

`该文件主要介绍关于数据库基本的基本配置十分重要，选中src/main/resources，右键 -> New -> file-> Name填入application.properties -> Finish。`

- `spring.datasource.driver-class-name`：指定driver-class
- `spring.datasource.url`：指定数据库host、port、database、encode
- `spring.datasource.username`：指定用户名
- `spring.datasource.password`：指定密码
- `spring.datasource.type`：指定数据库连接池
- `logging.level`：开启日志，开发时可以打印SQL语句

```properties
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/lesson7?useUnicode=true&characterEncoding=utf-8
spring.datasource.username=root
spring.datasource.password=
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
logging.level.com.shiyanlou.lesson7.mapper=debug
```



#### 2.5 创建数据库和数据表

启动MySQL数据库服务

```sh
$ sudo service mysql start
```

进入MySQL数据库

```sh
$ mysql -uroot
```

创建数据库

```sql
mysql> create database lesson7; 
```
导入数据表

```sh
$ mysql -uroot lesson7 < dump.sql
```

由下图可见五张数据表的关系。

![](./pic/2-5-1.JPG)

#### 2.6 创建mapper目录及文件

`FoodMapper.java`是对`table food`的CRUD，实现对食物的后台管理

```java
package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.Food;

public interface FoodMapper {
	int insert(Food food);
	
	Food getById(int id);
	
	List<Food> getAll();
		
	int update(Food food);
	
	int delete(int id);
}
```



`SportMapper.java`是对`table sport`的CRUD，实现对运动的后台管理

```java
package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.Sport;

public interface SportMapper {
	int insert(Sport drug);
	
	Sport getById(int id);
	
	List<Sport> getAll();
	
	int update(Sport drug);
	
	int delete(int id);
}
```



`UserFoodHistoryMapper.java`

```java
package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.EnergyDate;
import com.shiyanlou.lesson7.domain.UserFoodHistory;

public interface UserFoodHistoryMapper {
	// 记录用户饮食
	public int insert(UserFoodHistory userFoodHistory);
	// 获取指定用户所用饮食记录
	public List<UserFoodHistory> getAll(int userId);
	// 获取指定用户每日的摄入能量
	public List<EnergyDate> getSumFoodEnergy(int userId);
}
```



`UserSportHistoryMapper.java`

```java
package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.EnergyDate;
import com.shiyanlou.lesson7.domain.UserSportHistory;

public interface UserSportHistoryMapper {
	// 记录用户运动
	public int insert(UserSportHistory userSportHistory);
	// 获取指定用户所有运动记录
	public List<UserSportHistory> getAll(int userId);
	//  获取指定用户每日的运动消耗能量
	public List<EnergyDate> getSumConsumeEnergy(int userId);
}
```



`UserIndexMapper.java`

```java
package com.shiyanlou.lesson7.mapper;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserIndex;

public interface UserIndexMapper {
	// 获取指定用户所有生理指标
	List<UserIndex> getById(int userId);
}
```



`FoodMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper 
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.shiyanlou.lesson7.mapper.FoodMapper">
	<select id="getById" parameterType="Integer" resultType="com.shiyanlou.lesson7.domain.Food">
		select id, name, description,
		food_energy as foodEnergy
		from food where id = #{id};
	</select>
	
	<select id="getByIdBreif" parameterType="Integer" resultType="com.shiyanlou.lesson7.domain.Food">
		select id, name,
		food_energy as foodEnergy
		from food where id = #{id};
	</select>
	
	<insert id="insert" parameterType="com.shiyanlou.lesson7.domain.Food"
	useGeneratedKeys="true" keyProperty="id">
		insert into food(name, description, food_energy) 
		values(#{name}, #{description}, #{foodEnergy});
	</insert>
	
	<select id="getAll" resultType="com.shiyanlou.lesson7.domain.Food">
		select id, name, description,
		food_energy as foodEnergy
		from food
	</select>
	
	<update id="update" parameterType="com.shiyanlou.lesson7.domain.Food">
		update food
		<set>
			<if test="name != null and name != ''">
				name = #{name},
			</if>
			<if test="description != null and description != ''">
				description = #{description},
			</if>
			<if test="foodEnergy != null and foodEnergy != ''">
				food_energy = #{foodEnergy},
			</if>
		</set>
		where id = #{id};
	</update>
	
	<delete id="delete" parameterType="Integer">
		delete from food where id = #{id};
	</delete>
</mapper>
```



`SportMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper 
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="com.shiyanlou.lesson7.mapper.SportMapper">
	<select id="getById" parameterType="Integer" resultType="com.shiyanlou.lesson7.domain.Sport">
		select id, name, description, 
		consume_energy as consumeEnergy
		from sport where id = #{id};
	</select>
	
	<select id="getByIdBreif" parameterType="Integer" resultType="com.shiyanlou.lesson7.domain.Sport">
		select id, name,
		consume_energy as consumeEnergy
		from sport where id = #{id};
	</select>
	
	<insert id="insert" parameterType="com.shiyanlou.lesson7.domain.Sport"
	useGeneratedKeys="true" keyProperty="id">
		insert into sport(name, description, consume_energy) 
		values(#{name}, #{description}, #{consumeEnergy});
	</insert>
	
	<select id="getAll" resultType="com.shiyanlou.lesson7.domain.Sport">
		select * from sport
	</select>
	
	<update id="update" parameterType="com.shiyanlou.lesson7.domain.Sport">
		update sport
		<set>
			<if test="name != null and name != ''">
				name = #{name},
			</if>
			<if test="description != null and description != ''">
				description = #{description},
			</if>
			<if test="consumeEnergy != null and consumeEnergy != ''">
				consume_energy = #{consumeEnergy},
			</if>
		</set>
		where id = #{id};
	</update>
	
	<delete id="delete" parameterType="Integer">
		delete from sport where id = #{id};
	</delete>
</mapper>
```



`UserFoodHistoryMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper 
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 <mapper namespace="com.shiyanlou.lesson7.mapper.UserFoodHistoryMapper">
 
 	<resultMap type="com.shiyanlou.lesson7.domain.UserFoodHistory" 
 		id="UserFoodHistoryResultMap">
 		<id column="id" property="id"/>
 		<result column="user_id" property="userId"/>
 		<result column="food_quantity" property="foodQuantity"/>
 		<result column="collect_date" property="collectDate"/>
 		<association property="food" column="food_id"
 			select="com.shiyanlou.lesson7.mapper.FoodMapper.getByIdBreif" />
 	</resultMap>
 
 	<select id="getAll" parameterType="Integer" 
 		resultMap="UserFoodHistoryResultMap">
 		select 
 		id,
 		user_id,
 		food_id,
 		food_quantity,
 		collect_date
 		from user_food_history where user_id = #{userId};
 	</select>
 	
 	<resultMap type="com.shiyanlou.lesson7.domain.EnergyDate" id="EnergyDateMap">
 		<result column="sum_food_energy" property="energy"/>
 		<result column="collect_date" property="collectDate"/>
 	</resultMap>
 	
 	<select id="getSumFoodEnergy" parameterType="Integer" resultMap="EnergyDateMap">
 		select 
	      sum(food_quantity * food_energy / 500) as sum_food_energy, collect_date 
	    from 
	      user_food_history u 
	    join 
	      food f 
	    on 
	      u.food_id = f.id 
	    where 
	      user_id = #{userId}
	    group by 
	      collect_date;
 	</select>
 	
 	<insert id="insert" parameterType="com.shiyanlou.lesson7.domain.UserFoodHistory" 
 		useGeneratedKeys="true" keyProperty="id">
 		insert into 
 			user_food_history
 			(user_id, food_id, food_quantity, collect_date) 
 		values
 			(#{userId}, #{food.id}, #{foodQuantity}, #{collectDate});
 	</insert>
 </mapper>
```



`UserSportHistoryMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper 
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 <mapper namespace="com.shiyanlou.lesson7.mapper.UserSportHistoryMapper">
 
 	<resultMap type="com.shiyanlou.lesson7.domain.UserSportHistory" 
 		id="UserSportHistoryResultMap">
 		<id column="id" property="id"/>
 		<result column="user_id" property="userId"/>
 		<result column="sport_time" property="sportTime"/>
 		<result column="collect_date" property="collectDate"/>
 		<association property="sport" column="sport_id"
 			select="com.shiyanlou.lesson7.mapper.SportMapper.getByIdBreif" />
 	</resultMap>
 
 	<select id="getAll" parameterType="Integer" 
 		resultMap="UserSportHistoryResultMap">
 		select 
 		id,
 		user_id,
 		sport_id,
 		sport_time,
 		collect_date
 		from user_sport_history where user_id = #{userId};
 	</select>
 	
 	<resultMap type="com.shiyanlou.lesson7.domain.EnergyDate" id="EnergyDateMap">
 		<result column="sum_consume_energy" property="energy"/>
 		<result column="collect_date" property="collectDate"/>
 	</resultMap>
 	
 	<select id="getSumConsumeEnergy" parameterType="Integer" resultMap="EnergyDateMap">
 		select 
 			sum(sport_time * consume_energy) as sum_consume_energy, collect_date 
 		from 
 			user_sport_history u 
 		join 
 			sport s 
 		on 
 			u.sport_id = s.id 
 		where 
 			user_id = #{userId}
 		group by 
 			collect_date;
 	</select>
 	
 	<insert id="insert" parameterType="com.shiyanlou.lesson7.domain.UserSportHistory" 
 		useGeneratedKeys="true" keyProperty="id">
 		insert into 
 			user_sport_history
 			(user_id, sport_id, sport_time, collect_date) 
 		values
 			(#{userId}, #{sport.id}, #{sportTime}, #{collectDate});
 	</insert>
 </mapper>
```



`UserIndexMapper.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
 <!DOCTYPE mapper 
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 <mapper namespace="com.shiyanlou.lesson7.mapper.UserIndexMapper">
	<select id="getById" parameterType="Integer" 
	resultType="com.shiyanlou.lesson7.domain.UserIndex">
		select id, 
		index_type as indexType,
		index_content as indexContent,
		collect_date as collectDate
 		from user_index where user_id = #{userId};
	</select>
</mapper> 
```



#### 2.7 创建domain目录及文件

`ResultObject`三个属性分别是

- `code`：后台状态
- `msg`：相关消息
- `result`：结果

```java
package com.shiyanlou.lesson6.domain;

public class ResultObject {

	private int code;
	private String msg;
	private Object result;
	public ResultObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultObject(int code, String msg, Object result) {
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ResultObject [code=" + code + ", msg=" + msg + ", result=" + result + "]";
	}
}
```



`PaginationObject.java`

其中属性含义如下

- `pageNum`：第几页
- `pageSize`：每页记录个数
- `total`：记录总数
- `list`：结果

```java
package com.shiyanlou.lesson6.domain;

public class PaginationObject {

	private Object list;
	private int pageNum;
	private int pageSize;
	private long total;
	public PaginationObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaginationObject(Object list, int pageNum, int pageSize, long total) {
		super();
		this.list = list;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
	}
	public Object getList() {
		return list;
	}
	public void setList(Object list) {
		this.list = list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PaginationObject [list=" + list + ", pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total
				+ "]";
	}
}
```



`EnergyDate.java`

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;

public class EnergyDate {

	private int energy;
  	// 用户摄入能量或消耗能量
	private Date collectDate;
    // 日期
	public EnergyDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EnergyDate(int energy, Date collectDate) {
		super();
		this.energy = energy;
		this.collectDate = collectDate;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public Date getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	@Override
	public String toString() {
		return "EnergyDate [energy=" + energy + ", collectDate=" + collectDate + "]";
	}
}
```



`Food.java`

```java
package com.shiyanlou.lesson7.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Food {

	private int id;
  	// 主键自增id
	private String name;
    // 食物名称
	private String description;
    // 食物描述
	private int foodEnergy;
	// 食物每500g所含能量
  
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, String description, int foodEnergy) {
		super();
		this.name = name;
		this.description = description;
		this.foodEnergy = foodEnergy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFoodEnergy() {
		return foodEnergy;
	}

	public void setFoodEnergy(int foodEnergy) {
		this.foodEnergy = foodEnergy;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", description=" + description + ", foodEnergy=" + foodEnergy
				+ "]";
	}	
}
```



`Sport.java`

```java
package com.shiyanlou.lesson7.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Sport {

	private int id;
  	// 主键自增id
	private String name;
  	// 运动名称
	private String description;
  	// 运动描述
	private int consumeEnergy;
	// 运动每小时所消耗能量
	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sport(String name, String description, int consumeEnergy) {
		super();
		this.name = name;
		this.description = description;
		this.consumeEnergy = consumeEnergy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getConsumeEnergy() {
		return consumeEnergy;
	}

	public void setConsumeEnergy(int consumeEnergy) {
		this.consumeEnergy = consumeEnergy;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", description=" + description + ", consumeEnergy="
				+ consumeEnergy + "]";
	}	
}
```



`UserFoodHistory.java`

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class UserFoodHistory {

	private int id;
  	// 主键自增id
	private int userId;
  	// 用户id
	private Food food;
  	// 食物详情
	private int foodQuantity;
  	// 该食物摄入量，单位g
	private Date collectDate;
	// 饮食日期
	public UserFoodHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserFoodHistory(int userId, Food food, int foodQuantity, Date collectDate) {
		super();
		this.userId = userId;
		this.food = food;
		this.foodQuantity = foodQuantity;
		this.collectDate = collectDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(int foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	@Override
	public String toString() {
		return "UserFoodHistory [id=" + id + ", userId=" + userId + ", food=" + food + ", foodQuantity=" + foodQuantity
				+ ", collectDate=" + collectDate + "]";
	}
}
```



`UserSportHistory.java`

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class UserSportHistory {
	
	private int id;
  	// 主键自增id
	private int userId;
  	// 用户id
	private Sport sport;
  	// 运动详情
	private int sportTime;
  	// 运动时间，单位h
	private Date collectDate;
	// 运动日期
	public UserSportHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserSportHistory(int userId, Sport sport, int sportTime, Date collectDate) {
		super();
		this.userId = userId;
		this.sport = sport;
		this.sportTime = sportTime;
		this.collectDate = collectDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public int getSportTime() {
		return sportTime;
	}

	public void setSportTime(int sportTime) {
		this.sportTime = sportTime;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	@Override
	public String toString() {
		return "UserSportHistory [id=" + id + ", userId=" + userId + ", sport=" + sport + ", sportTime=" + sportTime
				+ ", collectDate=" + collectDate + "]";
	}
}
```



`UserEverydayFoodSituation.java`

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;
import java.util.List;

public class UserEverydayFoodSituation {

	private int userId;
  	// 用户id
	private Date collectDate;
  	// 饮食日期
	private int sumFoodEnergy;
  	// 该日摄入总能量
	private List<UserFoodHistory> userFoodHistories;
	// 该日摄入食物详情
  
	public UserEverydayFoodSituation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEverydayFoodSituation(int userId, Date collectDate, int sumFoodEnergy,
			List<UserFoodHistory> userFoodHistories) {
		super();
		this.userId = userId;
		this.collectDate = collectDate;
		this.sumFoodEnergy = sumFoodEnergy;
		this.userFoodHistories = userFoodHistories;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public int getSumFoodEnergy() {
		return sumFoodEnergy;
	}

	public void setSumFoodEnergy(int sumFoodEnergy) {
		this.sumFoodEnergy = sumFoodEnergy;
	}

	public List<UserFoodHistory> getUserFoodHistories() {
		return userFoodHistories;
	}

	public void setUserFoodHistories(List<UserFoodHistory> userFoodHistories) {
		this.userFoodHistories = userFoodHistories;
	}

	@Override
	public String toString() {
		return "UserEverydayFoodSituation [userId=" + userId + ", collectDate=" + collectDate + ", sumFoodEnergy="
				+ sumFoodEnergy + ", userFoodHistories=" + userFoodHistories + "]";
	}
}
```



`UserEverydaySportSituation.java`

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;
import java.util.List;

public class UserEverydaySportSituation {

	private int userId;
  	// 用户id
	private Date collectDate;
  	// 用户运动日期
	private int sumConsumeEnergy;
  	// 该日总消耗能量
	private List<UserSportHistory> userSportHistories;
  	// 该日用户各项运动详情
	
	public UserEverydaySportSituation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEverydaySportSituation(int userId, Date collectDate, int sumConsumeEnergy,
			List<UserSportHistory> userSportHistories) {
		super();
		this.userId = userId;
		this.collectDate = collectDate;
		this.sumConsumeEnergy = sumConsumeEnergy;
		this.userSportHistories = userSportHistories;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}

	public int getSumConsumeEnergy() {
		return sumConsumeEnergy;
	}

	public void setSumConsumeEnergy(int sumConsumeEnergy) {
		this.sumConsumeEnergy = sumConsumeEnergy;
	}

	public List<UserSportHistory> getUserSportHistories() {
		return userSportHistories;
	}

	public void setUserSportHistories(List<UserSportHistory> userSportHistories) {
		this.userSportHistories = userSportHistories;
	}

	@Override
	public String toString() {
		return "UserEverydaySportSituation [userId=" + userId + ", collectDate=" + collectDate + ", sumConsumeEnergy="
				+ sumConsumeEnergy + ", userSportHistories=" + userSportHistories + "]";
	}
}
```



`UserRelationship.java`

```java
package com.shiyanlou.lesson7.domain;

import java.util.List;
import java.util.Map;

public class UserRelationship {

	private int userId;
  	// 用户id
	private List<EnergyDate> foodEnergies;
  	// 用户每日饮食摄入能量
	private List<EnergyDate> sportEnergies;
  	// 用户每日运动消耗能量
	private Map<Integer, List<UserIndex>> userIndexs;
  	// 用户每日各项生理指标的情况
	public UserRelationship() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRelationship(int userId, List<EnergyDate> foodEnergies, List<EnergyDate> sportEnergies,
			Map<Integer, List<UserIndex>> userIndexs) {
		super();
		this.userId = userId;
		this.foodEnergies = foodEnergies;
		this.sportEnergies = sportEnergies;
		this.userIndexs = userIndexs;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<EnergyDate> getFoodEnergies() {
		return foodEnergies;
	}
	public void setFoodEnergies(List<EnergyDate> foodEnergies) {
		this.foodEnergies = foodEnergies;
	}
	public List<EnergyDate> getSportEnergies() {
		return sportEnergies;
	}
	public void setSportEnergies(List<EnergyDate> sportEnergies) {
		this.sportEnergies = sportEnergies;
	}
	public Map<Integer, List<UserIndex>> getUserIndexs() {
		return userIndexs;
	}
	public void setUserIndexs(Map<Integer, List<UserIndex>> userIndexs) {
		this.userIndexs = userIndexs;
	}
	@Override
	public String toString() {
		return "UserRelationship [userId=" + userId + ", foodEnergies=" + foodEnergies + ", sportEnergies="
				+ sportEnergies + ", userIndexs=" + userIndexs + "]";
	}
}
```



`UserIndex.java`

其中属性含义如下：

- `id`：自增`id`在`delete`和`update`时会使用
- `userId`：用户id
- `indexType`：生理指标类型，包括（体重、血压、血糖、血脂、心率等）
- `indexConent`：生理指标值
- `collectDate`：用户上传日期

```java
package com.shiyanlou.lesson7.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UserIndex {

	private int id;
	@JsonInclude(Include.NON_DEFAULT)
	private int userId;
	@JsonInclude(Include.NON_DEFAULT)
	private int indexType;
	private int indexContent;
	private Date collectDate;
	public UserIndex() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserIndex(int userId, int indexType, int indexContent, Date collectDate) {
		super();
		this.userId = userId;
		this.indexType = indexType;
		this.indexContent = indexContent;
		this.collectDate = collectDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIndexType() {
		return indexType;
	}
	public void setIndexType(int indexType) {
		this.indexType = indexType;
	}
	public int getIndexContent() {
		return indexContent;
	}
	public void setIndexContent(int indexContent) {
		this.indexContent = indexContent;
	}
	public Date getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	@Override
	public String toString() {
		return "UserIndex [id=" + id + ", userId=" + userId + ", indexType=" + indexType + ", indexContent="
				+ indexContent + ", collectDate=" + collectDate + "]";
	}
}
```



#### 2.8 创建service目录及文件

`FoodService.java`

```java
package com.shiyanlou.lesson7.service;

import com.shiyanlou.lesson7.domain.Food;
import com.shiyanlou.lesson7.domain.PaginationObject;

public interface FoodService {
	
	public Food getFoodById(int id);
	
	public int insertFood(Food food);
	
	public PaginationObject getAllFood(int pageNum, int pageSize);
	
	public int updateFood(Food food); 
	
	public int deleteFood(int id);
}
```



`SportService.java`

```java
package com.shiyanlou.lesson7.service;

import com.shiyanlou.lesson7.domain.PaginationObject;
import com.shiyanlou.lesson7.domain.Sport;

public interface SportService {
	
	public Sport getSportById(int id);
	
	public int insertSport(Sport sport);
	
	public PaginationObject getAllSport(int pageNum, int pageSize);
	
	public int updateSport(Sport sport); 
	
	public int deleteSport(int id);
}
```



`UserFoodHistoryService.java`

```java
package com.shiyanlou.lesson7.service;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserEverydayFoodSituation;
import com.shiyanlou.lesson7.domain.UserFoodHistory;


public interface UserFoodHistoryService {

	public int insertUserFoodHistory(UserFoodHistory userFoodHistory);
	
	public List<UserEverydayFoodSituation> getAllUserFoodHistory(int userId);
}
```



`UserRelationshipService.java`

```java
package com.shiyanlou.lesson7.service;

import com.shiyanlou.lesson7.domain.UserRelationship;

public interface UserRelationshipService {
	public UserRelationship getRelationship(int userId);
}
```



`UserSportHistoryService.java`

```java
package com.shiyanlou.lesson7.service;

import java.util.List;

import com.shiyanlou.lesson7.domain.UserEverydaySportSituation;
import com.shiyanlou.lesson7.domain.UserSportHistory;

public interface UserSportHistoryService {

	public int insertUserSportHistory(UserSportHistory userSportHistory);
	
	public List<UserEverydaySportSituation> getAllUserSportHistory(int userId);
}
```



#### 2.9 创建serviceImpl目录及文件

`FoodServiceImpl.java`

```java
package com.shiyanlou.lesson7.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiyanlou.lesson7.domain.Food;
import com.shiyanlou.lesson7.domain.PaginationObject;
import com.shiyanlou.lesson7.mapper.FoodMapper;
import com.shiyanlou.lesson7.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	private FoodMapper foodMapper;
	
	public Food getFoodById(int id) {
		Food food = foodMapper.getById(id);
		return food;
	}
	
	public int insertFood(Food food) {
		int modifyId = foodMapper.insert(food);
		return modifyId;
	}
	
	public PaginationObject getAllFood(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Food> foods = foodMapper.getAll();
		PageInfo<Food> appsPageInfo = new PageInfo<>(foods);
		long total = appsPageInfo.getTotal();
		PaginationObject paginationObject = new PaginationObject(foods, pageNum, pageSize, total);
		return paginationObject;
	}
	
	public int updateFood(Food food) {
		int modifyId = foodMapper.update(food);
		return modifyId;
	} 
	
	public int deleteFood(int id) {
		int modifyId = foodMapper.delete(id);
		return modifyId;
	}
}
```



`SportServiceImpl.java`

```java
package com.shiyanlou.lesson7.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiyanlou.lesson7.domain.PaginationObject;
import com.shiyanlou.lesson7.domain.Sport;
import com.shiyanlou.lesson7.mapper.SportMapper;
import com.shiyanlou.lesson7.service.SportService;

@Service
public class SportServiceImpl implements SportService{

	@Autowired
	private SportMapper sportMapper;
	
	public Sport getSportById(int id) {
		Sport sport = sportMapper.getById(id);
		return sport;
	}
	
	public int insertSport(Sport sport) {
		int modifyId = sportMapper.insert(sport);
		return modifyId;
	}
	
	public PaginationObject getAllSport(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Sport> sports = sportMapper.getAll();
		PageInfo<Sport> appsPageInfo = new PageInfo<>(sports);
		long total = appsPageInfo.getTotal();
		PaginationObject paginationObject = new PaginationObject(sports, pageNum, pageSize, total);
		return paginationObject;	}
	
	public int updateSport(Sport sport) {
		int modifyId = sportMapper.update(sport);
		return modifyId;
	} 
	
	public int deleteSport(int id) {
		int modifyId = sportMapper.delete(id);
		return modifyId;
	}
}
```



`UserFoodHistoryServiceImpl.java`

```java
package com.shiyanlou.lesson7.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson7.domain.UserEverydayFoodSituation;
import com.shiyanlou.lesson7.domain.UserFoodHistory;
import com.shiyanlou.lesson7.mapper.UserFoodHistoryMapper;
import com.shiyanlou.lesson7.service.UserFoodHistoryService;

@Service
public class UserFoodHistoryServiceImpl implements UserFoodHistoryService{

	@Autowired
	private UserFoodHistoryMapper userFoodHistoryMapper;
	
	public int insertUserFoodHistory(UserFoodHistory userFoodHistory) {
		int modifyId = userFoodHistoryMapper.insert(userFoodHistory);
		return modifyId;
	}
	
	public List<UserEverydayFoodSituation> getAllUserFoodHistory(int userId) {
		List<UserFoodHistory> userFoodHistories = userFoodHistoryMapper.getAll(userId);
		Map<Date, List<UserFoodHistory>> userFoodMap = new HashMap<>();
      	// userFoodMap，key为日期，value为用户该日饮食情况
		for(UserFoodHistory userFoodHistory: userFoodHistories) {
			Date cDate = userFoodHistory.getCollectDate();
			if (userFoodMap.containsKey(cDate)) {
				List<UserFoodHistory> userFoodList = userFoodMap.get(cDate);
				userFoodList.add(userFoodHistory);
			} else {
				List<UserFoodHistory> userFoodList = new ArrayList<>();
				userFoodList.add(userFoodHistory);
				userFoodMap.put(cDate, userFoodList);
			}
		}
		
		List<UserEverydayFoodSituation> userEverydayFoodSituations = new ArrayList<>();
		
		for(Entry<Date, List<UserFoodHistory>> entry: userFoodMap.entrySet()) {
			UserEverydayFoodSituation userEverydayFoodSituation = new UserEverydayFoodSituation();
			userEverydayFoodSituation.setUserId(userId);
			userEverydayFoodSituation.setCollectDate(entry.getKey());
			userEverydayFoodSituation.setUserFoodHistories(entry.getValue());
			
			int sumFoodEnergy = 0;
			for(UserFoodHistory userFoodHistory: entry.getValue()) {
				sumFoodEnergy += userFoodHistory.getFoodQuantity() * userFoodHistory.getFood().getFoodEnergy() / 500;
			}
			userEverydayFoodSituation.setSumFoodEnergy(sumFoodEnergy);
			
			userEverydayFoodSituations.add(userEverydayFoodSituation);
		}
		
		return userEverydayFoodSituations;
	}
}
```



`UserRelationshipServiceImpl.java`

```java
package com.shiyanlou.lesson7.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson7.domain.EnergyDate;
import com.shiyanlou.lesson7.domain.UserIndex;
import com.shiyanlou.lesson7.domain.UserRelationship;
import com.shiyanlou.lesson7.mapper.UserFoodHistoryMapper;
import com.shiyanlou.lesson7.mapper.UserIndexMapper;
import com.shiyanlou.lesson7.mapper.UserSportHistoryMapper;

import com.shiyanlou.lesson7.service.UserRelationshipService;

@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {
	
	@Autowired
	private UserFoodHistoryMapper userFoodHistoryMapper;
	
	@Autowired
	private UserSportHistoryMapper userSportHistoryMapper;
	
	@Autowired
	private UserIndexMapper userIndexMapper;
	
	public UserRelationship getRelationship(int userId) {
		UserRelationship relationship = new UserRelationship();
      
		List<EnergyDate> foodEnergies = userFoodHistoryMapper.getSumFoodEnergy(userId);
      	// foodEnergies，用户每天摄入能量和日期
		List<EnergyDate> sportEnergyDates = userSportHistoryMapper.getSumConsumeEnergy(userId);			
     	 // sportEnergyDates，用户每天运动消耗能量和日期
		List<UserIndex> userIndexs = userIndexMapper.getById(userId);
      	// map，用户每天各种生理指标和日期
		Map<Integer, List<UserIndex>> map = new HashMap<>();
		
		for(UserIndex userIndex: userIndexs) {
			int indexType = userIndex.getIndexType();
			if (map.containsKey(indexType)) {
				List<UserIndex> userIndexs2 = map.get(indexType);
				userIndexs2.add(userIndex);
			} else {
				List<UserIndex> userIndexs2 = new ArrayList<>();
				userIndexs2.add(userIndex);
				map.put(indexType, userIndexs2);
			}
		}
		
		relationship.setUserId(userId);
		relationship.setFoodEnergies(foodEnergies);
		relationship.setSportEnergies(sportEnergyDates);
		relationship.setUserIndexs(map);
		return relationship;
	}
}
```



`UserSportHistoryServiceImpl.java`

```java
package com.shiyanlou.lesson7.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiyanlou.lesson7.domain.UserEverydaySportSituation;
import com.shiyanlou.lesson7.domain.UserSportHistory;
import com.shiyanlou.lesson7.mapper.UserSportHistoryMapper;
import com.shiyanlou.lesson7.service.UserSportHistoryService;

@Service
public class UserSportHistoryServiceImpl implements UserSportHistoryService{

	@Autowired
	private UserSportHistoryMapper userSportHistoryMapper;
	
	public int insertUserSportHistory(UserSportHistory userSportHistory) {
		int modifyId = userSportHistoryMapper.insert(userSportHistory);
		return modifyId;
	}
	
	public List<UserEverydaySportSituation> getAllUserSportHistory(int userId) {
		List<UserSportHistory> userSportHistories = userSportHistoryMapper.getAll(userId);
		Map<Date, List<UserSportHistory>> userSportMap = new HashMap<>();
        // userSportMap，key为日期，value为用户该日运动情况

		for(UserSportHistory userSportHistory: userSportHistories) {
			Date cDate = userSportHistory.getCollectDate();
			if (userSportMap.containsKey(cDate)) {
				List<UserSportHistory> userSportList = userSportMap.get(cDate);
				userSportList.add(userSportHistory);
			} else {
				List<UserSportHistory> userSportList = new ArrayList<>();
				userSportList.add(userSportHistory);
				userSportMap.put(cDate, userSportList);
			}
		}
		
		List<UserEverydaySportSituation> userEverydaySportSituations = new ArrayList<>();
		
		for(Entry<Date, List<UserSportHistory>> entry: userSportMap.entrySet()) {
			UserEverydaySportSituation userEverydaySportSituation = new UserEverydaySportSituation();
			userEverydaySportSituation.setUserId(userId);
			userEverydaySportSituation.setCollectDate(entry.getKey());
			userEverydaySportSituation.setUserSportHistories(entry.getValue());
			
			int sumConsumeEnergy = 0;
			for(UserSportHistory userSportHistory: entry.getValue()) {
				sumConsumeEnergy += userSportHistory.getSportTime() * userSportHistory.getSport().getConsumeEnergy();
			}
			userEverydaySportSituation.setSumConsumeEnergy(sumConsumeEnergy);
			
			userEverydaySportSituations.add(userEverydaySportSituation);
		}
		
		return userEverydaySportSituations;
	}
}
```



#### 2.10 创建controller目录及文件



`FoodController.java`

```java
package com.shiyanlou.lesson7.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.Food;
import com.shiyanlou.lesson7.domain.PaginationObject;
import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.service.FoodService;

@RestController
@RequestMapping("api/v1/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@GetMapping("get")
	public ResultObject getFoodById(@RequestParam int id) {
		Food food = foodService.getFoodById(id);
		ResultObject resultObject = new ResultObject(200, "success", food);
		return resultObject;
	}
	
	@PostMapping("add")
	public ResultObject insertFood(@RequestBody Food food) {
		int modifyId = foodService.insertFood(food);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("list")
	public ResultObject getAllFood(@RequestParam int pageNum, @RequestParam int pageSize) {
		PaginationObject paginationObj = foodService.getAllFood(pageNum, pageSize);
		ResultObject resultObject = new ResultObject(200, "success", paginationObj);

		return resultObject;
	}
	
	@DeleteMapping("delete")
	public ResultObject deleteUser(@RequestParam int id) {
		int modifyId = foodService.deleteFood(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@PutMapping("edit")
	public ResultObject updateUser(@RequestBody Food food) {
		int modifyId = foodService.updateFood(food);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
}
```



`SportController.java`

```java
package com.shiyanlou.lesson7.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.PaginationObject;
import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.domain.Sport;
import com.shiyanlou.lesson7.service.SportService;

@RestController
@RequestMapping("api/v1/sport")
public class SportController {

	@Autowired
	private SportService sportService;
	
	@GetMapping("get")
	public ResultObject getSportById(@RequestParam int id) {
		Sport sport = sportService.getSportById(id);
		ResultObject resultObject = new ResultObject(200, "success", sport);
		return resultObject;
	}
	
	@PostMapping("add")
	public ResultObject insertSport(@RequestBody Sport sport) {
		int modifyId = sportService.insertSport(sport);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@GetMapping("list")
	public ResultObject getAllSport(@RequestParam int pageNum, @RequestParam int pageSize) {
		PaginationObject paginationObject = sportService.getAllSport(pageNum, pageSize);
		ResultObject resultObject = new ResultObject(200, "success", paginationObject);
		return resultObject;
	}
	
	@DeleteMapping("delete")
	public ResultObject deleteSport(@RequestParam int id) {
		int modifyId = sportService.deleteSport(id);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
	
	@PutMapping("edit")
	public ResultObject updateSport(@RequestBody Sport sport) {
		int modifyId = sportService.updateSport(sport);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject(200, "success", map);
		return resultObject;
	}
}
```



`UserFoodHistoryController.java`

```java
package com.shiyanlou.lesson7.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.domain.UserEverydayFoodSituation;
import com.shiyanlou.lesson7.domain.UserFoodHistory;
import com.shiyanlou.lesson7.service.UserFoodHistoryService;

@RestController
@RequestMapping("/api/v1/user_food_history")
public class UserFoodHistoryController {

	@Autowired
	private UserFoodHistoryService userFoodHistoryService;
	
	@PostMapping("add")
	public ResultObject insertUserFoodHistory(@RequestBody UserFoodHistory userFoodHistory) {
		int modifyId = userFoodHistoryService.insertUserFoodHistory(userFoodHistory);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject();
		resultObject.setResult(map);
		if (modifyId == 1) {
			resultObject.setCode(1);
			resultObject.setMsg("success");
		} else {
			resultObject.setCode(-1);
			resultObject.setMsg("fail");
		}
		
		return resultObject;
	}
	
	@GetMapping("get")
	public ResultObject getAllUserFoodHistory(@RequestParam int userId) {
		List<UserEverydayFoodSituation> userEverydayFoodSituations = userFoodHistoryService.getAllUserFoodHistory(userId);
		ResultObject resultObject = new ResultObject(200, "success", userEverydayFoodSituations);
		return resultObject;
	}	
}
```



`UserRelationshipController.java`

```java
package com.shiyanlou.lesson7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.domain.UserRelationship;
import com.shiyanlou.lesson7.service.UserRelationshipService;

@RestController
@RequestMapping("api/v1/relationship")
public class UserRelationshipController {

	@Autowired
	private UserRelationshipService relationshipService;
	
	@RequestMapping("get")
	public ResultObject getRelationship(@RequestParam int userId) {
		UserRelationship relationship = relationshipService.getRelationship(userId);
		ResultObject resultObject = new ResultObject(0, "success", relationship);
		return resultObject;
	}
}
```



`UserSportHistoryController.java`

```java
package com.shiyanlou.lesson7.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shiyanlou.lesson7.domain.ResultObject;
import com.shiyanlou.lesson7.domain.UserEverydaySportSituation;
import com.shiyanlou.lesson7.domain.UserSportHistory;
import com.shiyanlou.lesson7.service.UserSportHistoryService;

@RestController
@RequestMapping("/api/v1/user_sport_history")
public class UserSportHistoryController {

	@Autowired
	private UserSportHistoryService userSportHistoryService;
	
	@PostMapping("add")
	public ResultObject insertUserSportHistory(@RequestBody UserSportHistory userSportHistory) {
		int modifyId = userSportHistoryService.insertUserSportHistory(userSportHistory);
		Map<String, Integer> map = new HashMap<>();
		map.put("modifyId", modifyId);
		ResultObject resultObject = new ResultObject();
		resultObject.setResult(map);
		if (modifyId == 1) {
			resultObject.setCode(1);
			resultObject.setMsg("success");
		} else {
			resultObject.setCode(-1);
			resultObject.setMsg("fail");
		}
		
		return resultObject;
	}
	
	@GetMapping("get")
	public ResultObject getAllUserDrugHistory(@RequestParam int userId) {
		List<UserEverydaySportSituation> userEverydaySportSituations = userSportHistoryService.getAllUserSportHistory(userId);
		ResultObject resultObject = new ResultObject(200, "success", userEverydaySportSituations);

		return resultObject;
	}
	
}
```



#### 2.11 创建启动类文件

`MainApplication.java`

```java
package com.shiyanlou.lesson7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiyanlou.lesson7.mapper")

public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
```



#### 2.12 访问测试

​	在终端中输入如下命令，启动web项目

```shell
$ mvn spring-boot:run
```

​	可以看到控制台打印出启动日志，然后打开另外一个`terminal`可以使用`curl`进行测试，下面是接口测试的截图，大家可以仿照测试

​	大家可以再打开一个`teminal`安装`jq`软件，可以美化`json`数据，为了减少版面没有使用`jq`，大家在测试的时候可以在`curl`后增加一个管道符`|`使用`jq`

```shell
$ sudo apt-get update
$ sudo apt-get -y install jq
```

- 分页显示`food`

![2-12-1](./pic/2-12-1.JPG)

- 获取指定`food`的信息

![2-12-2](./pic/2-12-2.JPG)

- 新增`food`

![2-12-3](./pic/2-12-3.JPG)

- `table food`中的数据

![2-12-4](./pic/2-12-4.JPG)

- 修改指定`food`的数据

![2-12-5](./pic/2-12-5.JPG)

- `id=6`的`food`修改后`table food`的数据

![2-12-6](./pic/2-12-6.JPG)

- 删除指定`food`的信息

![2-12-7](./pic/2-12-7.JPG)

- 删除指定`food`后，`table food`中的数据

![2-12-8](./pic/2-12-8.JPG)

- 用户上传饮食数据

![2-12-10](./pic/2-12-10.JPG)

- 显示指定`user`的用户饮食信息

![2-12-11](./pic/2-12-11.JPG)

- 显示指定`sport`

![2-12-12](./pic/2-12-12.JPG)
- 创建`sport`

![2-12-13](./pic/2-12-13.JPG)

- 修改指定`sport`

![2-12-14](./pic/2-12-14.JPG)

- 删除指定`sport`

![2-12-15](./pic/2-12-15.JPG)

- 分页显示`sport`

![2-12-16](./pic/2-12-16.JPG)

- 用户上传运动记录

![2-12-17](./pic/2-12-17.JPG)

- 显示指定用户的运动记录

![2-12-18](./pic/2-12-18.JPG)

## 三、实验总结

​	本节课依然是开发用户健康管理系统的用户端，使用Spring Boot和Mybatis技术栈，开发了包括食物管理、运动管理、用户运动、饮食记录管理、用户生理指标、运动、饮食关系管理四大功能。熟悉了Spring Boot和Mybatis基本CRUD开发、级联查询、分页插件以及MySQL中 `group by`、`order by`、`join`的使用等技术。