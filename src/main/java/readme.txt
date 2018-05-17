spring boot web 一

***
	所有在application.properties中出现的配置项都可以在org.springframework.boot.autoconfigure包下找对应
	的Java的配置文件
***

1、spring boot 默认不支持jsp模板技术，如需要添加jsp技术，按照如下操作
	1.1、引入如下依赖：
			<dependency>
				<groupId>org.apache.tomcat.embed</groupId>
				<artifactId>tomcat-embed-jasper</artifactId>
			</dependency>
	1.2、在application.properties中添加如下配置：
			#默认参见org.springframework.boot.autoconfigure.web.WebMvcProperties.view(View内部类)
			spring.mvc.view.prefix=/WEB-INF
			spring.mvc.view.suffix=.jsp
			
2、spring boot添加freemarker模板引擎支持
	2.1、添加依赖
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-freemarker</artifactId>
			</dependency>
	2.2、可选配置在application.properties中添加如下配置
			#默认参见org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties
			spring.freemarker.DEFAULT_TEMPLATE_LOADER_PATH=classpath:/ftl/
			
3、更改spring boot web提供的tomcat默认容器，更改成jetty容器
	3.1、去除默认的依赖，配置如下：添加<exclusions>子标签
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-web</artifactId>
				<exclusions>
					<!-- 排除默认的tomcat容器支持 -->
					<exclusion>
						<groupId>org.springframework.boot</groupId>
						<artifactId>spring-boot-starter-tomcat</artifactId>
					</exclusion>
				</exclusions>
			</dependency>
	3.2、添加jetty依赖
			<dependency>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-jetty</artifactId>
			</dependency>
		
		