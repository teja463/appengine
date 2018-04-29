# appengine

## Installing appengine application from google cloud shell

### myjavaproject-187717
```shell
TUTORIALDIR=src/myjavaproject-187717/java_gae_quickstart-2017-12-01-23-24
git clone https://github.com/GoogleCloudPlatform/appengine-try-java.git $TUTORIALDIR
cd $TUTORIALDIR
cat src/main/java/myapp/DemoServlet.java
cat pom.xml
mvn appengine:run
gcloud app create
gcloud config set project myjavaproject-187717
mvn appengine:deploy
http://myjavaproject-187717.appspot.com/
```

### For the second time

```shell
SPRINGDEMOAPP=src/springdemo-187718
git clone https://github.com/teja463/appengine.git $SPRINGDEMOAPP
cd $SPRINGDEMOAPP/springdemo
mvn appengine:run
mvn appengine:deploy
gcloud app browse
```

* If you see below error when deploying go to WEB-INF folder goto appengine-web.xml and add below entry
```xml
 <runtime>java8</runtime>
```
```Java
javax.servlet.UnavailableException: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping#0': Initialization of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.web.servlet.handler.MappedInterceptor#0': Cannot create inner bean '(inner bean)' of type [org.springframework.web.servlet.handler.ConversionServiceExposingInterceptor] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)': Cannot resolve reference to bean 'org.springframework.format.support.FormattingConversionServiceFactoryBean#0' while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.format.support.FormattingConversionServiceFactoryBean#0': Invocation of init method failed; nested exception is java.lang.NoClassDefFoundError: java.time.format.FormatStyle is a restricted class. Please see
the Google  App Engine developer's guide for more details.
```
