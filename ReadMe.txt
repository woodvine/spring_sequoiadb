一个SpringMVC整合SequoiaDB数据库的例子。

首先，在src目录下创建config/sequoiaDBConfig.xml配置，改成自己的巨杉数据库的配置。
其次，自定义的DAO类继承GenericDao<T>，比如：
```java
class UserDao extends GenericDao<User>{

}
```
第三，直接使用注解来为实体设置SpaceName，CollectionName以及PrimaryKey。