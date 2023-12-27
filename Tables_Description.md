
# 数据库表说明文档

## 学生信息表 (`student`)

| 字段名称            | 数据类型          | 描述   | 特性      |
|-----------------|---------------|------|---------|
| `studentId`     | `int`         | 学生ID | 主键，自动增长 |
| `studentName`   | `varchar(20)` | 学生姓名 |         |
| `dormNumber`    | `varchar(10)` | 宿舍号  |         |
| `location`      | `varchar(20)` | 位置信息 |         |
| `bedNumber`     | `int`         | 床位号  |         |
| `phone`         | `varchar(20)` | 电话号码 |         |
| `email`         | `varchar(20)` | 电子邮箱 |         |
| `studentNumber` | `varchar(20)` | 学号   |         |
| `password`      | `varchar(20)` | 密码   |         |

## 宿舍信息表 (`dorm`)

| 字段名称             | 数据类型          | 描述   | 特性      |
|------------------|---------------|------|---------|
| `dormId`         | `int`         | 宿舍ID | 主键，自动增长 |
| `dormNumber`     | `varchar(10)` | 宿舍号  |         |
| `monthWaterBill` | `int`         | 每月水费 |         |
| `monthScore`     | `double`      | 每月得分 |         |
| `dayScore`       | `double`      | 每日得分 |         |

## 水订单表 (`waterOrder`)

| 字段名称               | 数据类型          | 描述    | 特性      |
|--------------------|---------------|-------|---------|
| `waterOrderId`     | `int`         | 水订单ID | 主键，自动增长 |
| `waterOrderNumber` | `varchar(20)` | 水订单号  |         |
| `dormNumber`       | `varchar(10)` | 宿舍号   |         |
| `studentId`        | `int`         | 学生ID  |         |
| `waterOrderTime`   | `datetime`    | 订单时间  |         |
| `waterDeliverTime` | `datetime`    | 送水时间  |         |
| `waterOrderStatus` | `varchar(20)` | 订单状态  |         |
| `waterStationId`   | `int`         | 水站ID  |         |
| `waterCount`       | `int`         | 水的数量  |         |

## 水站信息表 (`waterStation`)

| 字段名称                   | 数据类型          | 描述     | 特性      |
|------------------------|---------------|--------|---------|
| `waterStationId`       | `int`         | 水站ID   | 主键，自动增长 |
| `waterStationName`     | `varchar(20)` | 水站名称   |         |
| `waterStationLocation` | `varchar(20)` | 水站位置   |         |
| `waterStationPhone`    | `varchar(20)` | 水站电话   |         |
| `waterStationEmail`    | `varchar(20)` | 水站电子邮箱 |         |
| `waterPrice`           | `int`         | 水价     |         |
| `waterStationPassword` | `varchar(20)` | 水站密码   |         |
