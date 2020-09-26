# JDBC:



jdbc概念：

```
java database Connectivity (java 数据库连接)

```

jdbc连接数据库步骤：

```
1、加载驱动(数据库连接实现类)
2、获取数据库连接
```

连接mysql的代码实现：

```java
		
        	//加载驱动  com.mysql.jdbc.Driver(mysql驱动名称)
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			/*
			jdbc:mysql://localhost:3306/test  : 连接数据的url地址
			root  ： 用户名
			root   :密码
			*/
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
```

​	

```
注意： 如果连接的mysql在本机，且端口没有改变(3306)
	url： jdbc:mysql:///数据库名称
```

常用类或者接口的介绍：	

```java
DriverManager作用：
	1、注册驱动
		Class.forName("com.mysql.jdbc.Driver");强制加载字节码文件到内存中
		static {
        try {
                    java.sql.DriverManager.registerDriver(new Driver());
                } catch (SQLException E) {
                    throw new RuntimeException("Can't register driver!");
                }
   		 }
   		 
		注： mysql5以后：可以不去添加Class.forName("com.mysql.jdbc.Driver");
	2、获取数据库连接
	
	
Connection作用： 连接数据库会话
	1、执行sql
		createStatement() ：  创建一个 Statement 对象来将 SQL 语句发送到数据库。
		prepareCall(String sql) : 执行存储过程
		prepareStatement(String sql) ：
	2、执行事务操作
		setAutoCommit(boolean autoCommit)  : 设置是否自动提交事务
		commit()  ：  提交事务
		rollback() : 回滚事务
	
		close()  ： 关闭资源
Statement作用:
		addBatch(String sql) : 将sql语句添加到批处理
		close()  ： 关闭资源
		executeBatch() :执行批处理
 		executeQuery(String sql)  ： 执行 DQL语句 - sql查询语句
 		executeUpdate(String sql)  :执行DML  增删改
		close()： 关闭资源


 ResultSet作用： 返回查询结果集对象
 		next()  ： 将光标向下进行移动，如果返回true：代表行有数据  false：代表行没有数据
		getXxx(int a) ：  Xxx ： java中的数据类型  a： 列号
		getXxx(String a)  ：  a： 列名称
		getObject()
		close() ： 关闭资源

```



通过JDBC 执行 增、删、改操作：

```java
	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		//String sql = "delete from account where id=4";
        //String sql = "insert into account(name,balance) values('刘德华',2500)";
        String sql = "update account set name='黄飞鸿',balance=3000 where id=1";
			Statement stat = conn.createStatement();
			int rows = stat.executeUpdate(sql);
			System.out.println(rows);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



注意事项： executeUpdate在执行sql返回的是数据受影响的行数。

```

JDBC实现查询：

```java
Connection conn = null;
		Statement statement = null; 
		ResultSet rs  = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = 	DriverManager.getConnection("jdbc:mysql:///test", "root", "root");
			String sql = "select * from emp";
			statement= conn.createStatement();
			 rs = statement.executeQuery(sql);
			 // 迭代行数据
			 while(rs.next()) {
				 //获取行中列数据
				/* int id = rs.getInt(1);
				 String name = rs.getString(2);
				 String sex = rs.getString(3);
				 double salary = rs.getDouble(4);
				 Date joinTime = rs.getDate(5);
				 int deptId = rs.getInt(6);*/
				 
				 int id = rs.getInt("id");
				 double salary = rs.getDouble("salary");
				 Date joinTime = rs.getDate("join_date");
				 String name = rs.getString("name");
				 String sex = rs.getString("gender");
				 int deptId = rs.getInt("dept_id");
				 
				 System.out.println(id+":"+name+":"+sex+":"+salary+":"+joinTime+":"+deptId);
			 }
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
```

JDBC工具类的提取：

```java
package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @author tosit
 *	JDBC工具类
 */
public class JdbcUtil {

	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PWD;
	
	/**
	 *   使用静态代码块 读取配置信息
	 */
	static {
		Properties pro = new Properties();
		InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		DRIVER = pro.getProperty("Driver");
		URL = pro.getProperty("Url");
		USER =pro.getProperty("UserName");
		PWD=pro.getProperty("UserPwd");
	}
	
	
	
	/**
	 *   获取数据库连接
	 */
	public static Connection getConn() {
		Connection conn = null;
		//注册驱动
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	
	/**
	 *   释放资源(ResultSet Statement Connection)
	 */
	
	public static void closeAll(ResultSet rs,Statement s,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		
		if(s!=null) {
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			s=null;
		}
		
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
	}
	
}

```

SQL注入：

```java
 用户输入的内容，动态的拼接在sql语句中。从而改变sql语句结构。得到非法的数据-sql注入
 
 @Test
	public void r2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入你要查询的员工编号");
		String id = sc.nextLine();
		
		String sql = "select * from account where id = ?";
		Connection conn = JdbcUtil.getConn();
		ResultSet rs= null;
		PreparedStatement ptp = null;
		try {
	
			ptp = conn.prepareStatement(sql);
		//	System.out.println(sql);
			/*
			 *   使用变量去替换sql语句中问号
			 */
			ptp.setObject(1, id);
			rs= ptp.executeQuery();
			  while(rs.next()) {
				  Object name = rs.getObject("name");
				  Object balance = rs.getObject("balance");
				  System.out.println(name+":"+balance);
			  }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.coseAll(rs, ptp, conn);
		}
		
```

登录案例：

​	

```
DatabaseMetaData:
ResultSetMetaData: 结果集的源对象
	getColumnCount() ： 获取查询结果集中总共有多少列
	getColumnName(int column)  ： 获取结果集中每一列的名称 
ResultSet：
	getObject(列名称)          : 获取列对应的值
```

​	