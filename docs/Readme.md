# Grammar

## 创建数据源(DataSource)

### 创建 Postgres 数据源

- 语法

  > **`postgres`**(_host_, _port_, _database_, _user_, _passwd_)
  > 
  > - host: 数据库主机地址
  > - port: 数据库端口
  > - database: 数据库名称
  > - user: 登录用户名
  > - passwd: 登录用户密码

- 用例

```groovy
// 创建 Postgres 数据源
def postgresDs = postgres("192.168.0.1", 5432, "postgres", "postgres");
```

### 创建 MySQL 数据源

- 语法

  > **`mysql`**(_host_, _port_, _database_, _user_, _passwd_)
  >
  > - host: 数据库主机地址
  > - port: 数据库端口
  > - database: 数据库名称
  > - user: 登录用户名
  > - passwd: 登录用户密码

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
```

### 创建 Oracle 数据源

- 语法

  > **`oracle`**(_host_, _port_, _database_, _user_, _passwd_)
  >
  > - host: 数据库主机地址
  > - port: 数据库端口
  > - database: 数据库名称
  > - user: 登录用户名
  > - passwd: 登录用户密码

- 用例

```groovy
// 创建 Oracle 数据源
def oracleDs = oracle("192.168.0.1", 1521, "root", "123456");
```

## 数据集(DataSet)操作

### 创建数据集

#### 由数据源创建数据集

数据集是后续一切数据操作入口。

- 语法

  > **`from`**(_dataSource_, _tableName_)
  > 
  > - dataSource: 数据源对象
  > - tableName: 表名

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 通过 from 命令创建数据集
from(mysqlDs, "t_table");
```

#### 由数据集创建新数据集

可以使用原有的数据集创建新的数据集。

- 语法

  > **`from`**(_dataSet_)
  >
  > - dataSet: 数据源对象
  > - tableName: 表名

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 通过 from 命令创建数据集
def dataSet = from(mysqlDs, "t_table");
// 通过原有数据集创建一个新的数据集，原有的数据集保持不变
from(dataSet);
```

#### 由查询语句创建数据集

通过使用数据源原生的 SQL 查询语句创建数据集

- 语法

  > DataSource.**`query`**(_sql_)
  > 
  > - sql: 数据源对应的原生查询语句

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 通过使用数据源原生的 SQL 查询语句创建数据集
mysqlDs.query("select * from t_table");
```

### 重命名数据集

对数据集进行重命名，后续针对数据集中字段的操作均使用重命名后的新名称

- 语法

  > DataSet.**`alias`**(_newName_)
  >
  > - newName: 新名称

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
from(mysqlDs, "t_table")
// 重命名数据集
.alias("t_new_table");
```

### 数据集过滤

- 语法

  > DataSet.**`where`**(_condition_)
  > 
  > - condition: 过滤条件，遵循 SQL99 WHERE 子句的条件规范

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet = from(mysqlDs, "t_table")
             // 指定数据集过滤条件
             .where("col1 > 10 and col1 < 100");
```

### 数据集关联

- 语法

  > DataSet.[**`join`**|**`leftJoin`**|**`rightJoin`**|**`fullJoin`**|**`innerJoin`**](_dataSet_, _condition_)
  > 
  > - dataSet: 另一个数据集
  > - condition: 关联条件，遵循 SQL99 JOIN ON 子句的关联条件规范

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet1 = from(mysqlDs, "t_table1");
def dataSet2 = from(mysqlDs, "t_table2")
               // 左外关联
              .leftJoin(dataSet1, "t_table1.id = t_table2.id");
```

### 数据集集合运算

集合运算需要保证两个运算的数据集的对应字段的数据类型相同

#### 交集运算

- 语法

  > DataSet.**`intersect`**(_dataSet_ [, _relFields_])
  > 
  > - dataSet: 另一个数据集
  > - relFields: 取交关联字段，只要关联字段相等，则认为两个集合中的记录相等，如果不填，则以整条记录作为比较条件

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet1 = from(mysqlDs, "t_table1");
def dataSet2 = from(mysqlDs, "t_table2");
// 交集运算，不指定关联字段
dataSet1.intersect(dataSet2);
// 交集运算，指定关联字段
dataSet1.intersect(dataSet2, "id, name");
```

#### 并集运算

- 语法

  > DataSet.**`union`**(_dataSet_)
  >
  > - dataSet: 另一个数据集

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet1 = from(mysqlDs, "t_table1");
def dataSet2 = from(mysqlDs, "t_table2");
// 并集运算
dataSet1.union(dataSet2);
```

#### 差集运算

- 语法

  > DataSet.**`minus`**(_dataSet_ [, _relFields_])
  >
  > - dataSet: 另一个数据集
  > - relFields: 取差关联字段，只要关联字段相等，则认为两个集合中的记录相等，如果不填，则以整条记录作为比较条件

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet1 = from(mysqlDs, "t_table1");
def dataSet2 = from(mysqlDs, "t_table2");
// 差集运算，不指定关联字段
dataSet1.minus(dataSet2);
// 差集运算，指定关联字段
dataSet1.minus(dataSet2, "id, name");
```

### 数据集分组聚合

- 语法

  > DataSet.**`group`**(**`groupKey`**, **`aggCall`**)
  > 
  > - groupKey: 分组条件，如果存在多个分组条件，则使用`','`分隔。遵循 SQL99 GROUP BY 子句的关联条件规范。
  > - aggCall: 聚合函数，如果存在多个聚合函数，则使用`','`分隔。可以使用 AS 为聚合函数设置别名。

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet = from(mysqlDs, "t_table1");
// 分组聚合
dataSet.group("id", "count(mobile) as mobile_cnt")
// 可以使用‘,’分隔多个分组条件或者聚合函数
dataSet.group("id, month", "count(mobile) as mobile_cnt, sum(sales) as sales")
```

### 数据集去重

- 语法

  > DataSet.**`distinct`**([_fields_])
  > - fields: 去重字段列表，如果不指定该去重字段，则使用数据集全部字段去重

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
from(mysqlDs, "t_table1")
// 按照ID和年龄去重
.dictinct("id", "age");
```

### 数据集排序

- 语法

  > DataSet.**`sort`**(_orderFields_)
  > 
  > - orderFields: 排序字段，遵循 SQL99 ORDER BY 子句的书写规范。

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
from(mysqlDs, "t_table1")
// 按照ID降序、age 升序且空值优先的顺序排列
.sort("id desc", "age nulls first");
```

### 数据集迁移

- 语法

  > DataSet.**`to`**(_dataSource_ [, _conflictPolicy_ [, _targetTable_]])
  > 
  > - dataSource: 目标数据源。
  > - conflictPolicy: 主键冲突时的处理策略。`skip`：跳过冲突行, 默认策略；`overwrite`：覆盖冲突行；`upsert`：更新冲突行
  > - targetTable: 接受数据集的目标表名，如果目标表名不存在，则默认写入到与数据集同名的表中。

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet = from(mysqlDs, "t_table").alias("t_new_table")
// 写入到 t_new_table 中
dataSet.to(mysqlDs);
// 写入到 t_table，并覆盖冲突数据
dataSet.to(mysqlDs, "overwrite", "t_table");
```

### 数据集遍历

- 语法

  > DataSet.**`each`**(_script_)
  > 
  > - script: groovy 脚本片段，用于遍历数据集中的行数据

- 用例

```groovy
// 创建 MySQL 数据源
def mysqlDs = msyql("192.168.0.1", 3306, "root", "123456");
// 创建数据集
def dataSet = from(mysqlDs, "t_table")
// 写入到 t_new_table 中
dataSet.each({
  row -> row['mobile'] = '+86' + row['mobile']
  return row
});
```

### 返回数据集

- 语法

  > **`return`**(_dataSet_)
  > 
  > - dataSet: 需要返回的数据集

## DDL 操作

### 创建数据表

DS.create(name, {map})

### 删除数据表

DS.drop(tableName)

### 清空数据表

DS.truncate(tableName)

### 展示元数据信息

- 语法

  > DataSource.**`description`**(_tableName_)
  > 
  > DataSet.**`metadata`**()