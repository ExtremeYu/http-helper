## HTTP-HELPER

### 介绍

Http-Helper是对Apache Httpclient和Fluent API的有效补充，它使得使用Fluent API更加简单方便，它可以直接转换返回的响应体到指定的常用类型数据，使用者不需要手工转换，Http-Helper帮助转换了大多数的数据类型，例如：Xml, Json, Json对象，Json对象数组，私有类型，以及私有类型等。

### 主页

1. 独立主页：http://http-helper.cloudate.net
2. GITHUB：https://github.com/robertleepeak/http-helper.git

### 下载

1. 发布包：[http-helper-0.0.1.jar](http://http-helper.cloudate.net/http-helper/http-helper-0.0.1.jar)
2. 源码包：[http-helper-0.0.1-src.tar.gz](http://http-helper.cloudate.net/http-helper/http-helper-0.0.1-src.tar.gz)

### 使用方法

1.下载源代码后在项目根目录执行如下命令安装打包文件到你的Maven私服。

>./deploy-maven.sh

2.在你的项目pom.xml文件中添加对模块的依赖。

>```xml
		<dependency>
			<groupId>com.robert.httphelper</groupId>
			<artifactId>http-helper</artifactId>
			<version>0.0.1</version>
		</dependency>
```

3.参考下面示例来使用这些简单易用的API。

```java

	// Read String object
	String stringResult = Request.Get("http://ip:port").execute()
			.returnContent().asString();
	System.out.println(stringResult);
	
	// Read String object with Charset
	String stringResultWithCharset = Request.Get("http://ip:port")
			.execute().returnContent().asString(Charset.defaultCharset());
	System.out.println(stringResultWithCharset);
	
	// Read Stream Object
	InputStream is = Request.Get("http://ip:port").execute()
			.returnContent().asStream();
	// Handle the input stream
	is.close();
	
	// Read raw bytes
	byte[] bytes = Request.Get("http://ip:port").execute().returnContent()
			.asBytes();
	System.out.println(bytes.length);
	
	// Read int variable
	int intResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.IntConverter());
	System.out.println(intResult);
	
	// Read long variable
	long longResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.LongConverter());
	System.out.println(longResult);
	
	// Read float variable
	float floatResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.FloatConverter());
	System.out.println(floatResult);
	
	// Read double variable
	double doulbeResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.DoubleConverter());
	System.out.println(doulbeResult);
	
	// Read BigDecimal object
	BigDecimal bitDecimalResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.BitDecimalConverter());
	System.out.println(bitDecimalResult);
	
	// Read XML Document object
	Document documentResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.Xml2DocumentConverter());
	System.out.println(documentResult.toString());
	
	// Read JSONObject object
	JSONObject jsonObjectResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.Json2ObjectConverter());
	System.out.println(jsonObjectResult.toJSONString());
	
	// Read Bean
	Student beanResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.Json2BeanConverter(Student.class));
	System.out.println(beanResult);
	
	// Read Bean List
	List<Student> beanListResult = Request.Get("http://ip:port").execute()
			.handleResponse(HttpHelper.Json2BeansConverter(Student.class));
	System.out.println(beanListResult);
	
```

### 性能

N/A

### TODO

1. 对某一个流行网站进行压测。
2. 提供可配置的长链接和短链接的客户端,参考之前的公司的框架。
3. Fluent API文档的翻译：http://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
4. 增加私有类型数组的API。

## QQ群/微信公众号
- <a target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=ff0d7d34f32c87dbd9aa56499a7478cd93e0e1d44288b9f6987a043818a1ad01"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="云时代网" title="云时代网"></a>
<br>
- <a href="http://cloudate.net/wp-content/uploads/2015/01/cloudate-qrcode.jpg"><img src="http://cloudate.net/wp-content/uploads/2015/01/cloudate-qrcode.jpg" alt="cloudate-qrcode" width="90" height="90" class="alignnone size-full wp-image-1138" /></a>

## 关于作者
- 罗伯特出品   微信： 13436881186