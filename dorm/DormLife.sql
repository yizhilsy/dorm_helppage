use dormlife;
# 1-宿舍信息表
create table dorm
(
    dormId         int auto_increment
        primary key,
    dormNumber     varchar(10) null,
    monthWaterBill int         null,
    monthScore     double      null,
    location       varchar(20) null,
    dayScore       double      null
)
    comment '宿舍信息表';

# 2-帖子点赞数表
create table likeNumTable
(
    id      int unsigned auto_increment comment 'ID'
        primary key,
    main_id int unsigned null comment '主帖帖子id',
    likeNum int unsigned null comment '喜爱数'
)
    comment '主帖喜爱表';

# 3-帖子喜爱者表
create table likeUserTable
(
    id      int unsigned auto_increment comment 'ID'
        primary key,
    main_id int unsigned null comment '主帖帖子id',
    user_id int unsigned null comment '喜爱者的id'
)
    comment '主帖谁喜爱表';

# 4-主帖信息表
create table mainpage
(
    id          int unsigned auto_increment comment '主键ID'
        primary key,
    username    varchar(45)  not null comment '发起人用户名',
    name        varchar(45)  not null comment '发起人姓名',
    phone       varchar(16)  not null comment '联系电话',
    title       varchar(300) not null comment '标题内容',
    content     varchar(400) not null comment '文本内容',
    image       varchar(300) null comment '图像',
    type_id     int unsigned null comment '互助帖子分类',
    create_time datetime     not null comment '创建时间',
    update_time datetime     not null comment '最近修改时间'
)
    comment '互助发起帖表结构';

# 5-主帖与回复帖对应表
create table mp
(
    id       int unsigned auto_increment comment '主键ID'
        primary key,
    main_id  int unsigned null comment '互助帖子id',
    reply_id int unsigned null comment '回复帖子id'
)
    comment '互助帖和回复贴的映射';

# 6-回复帖表
create table replypage
(
    id         int unsigned auto_increment comment '主键ID'
        primary key,
    username   varchar(45)  not null comment '回复人用户名',
    name       varchar(45)  not null comment '回复人姓名',
    content    varchar(400) not null comment '回复内容',
    reply_time datetime     not null comment '回复时间'
)
    comment '回复贴表';

# 7-学生表
create table student
(
    studentId       int auto_increment
        primary key,
    studentUserName varchar(20) null,
    studentName     varchar(20) null,
    dormNumber      varchar(10) null,
    bedNumber       int         null,
    studentNumber   varchar(20) null
)
    comment '学生信息表';

# 8-学生检查表
create table studentCheck
(
    id              int auto_increment
        primary key,
    studentUserName varchar(20)  null,
    studentNumber   varchar(20)  null,
    checkTime       datetime     null,
    checkReason     varchar(10)  null,
    checkImg        varchar(255) null,
    checkValue      int          null,
    checker         varchar(20)  null,
    appealReason    varchar(255) null,
    appealImg       varchar(255) null,
    status          varchar(10)  null
);

# 9-帖子种类表
create table typepage
(
    id       int unsigned auto_increment comment '主键ID'
        primary key,
    typename varchar(45) not null comment '帖子类型名',
    constraint typename
        unique (typename)
)
    comment '互助发起帖分类';

# 10-用户表
create table user
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)             not null comment '用户名',
    password    varchar(32)             null comment '密码',
    nickname    varchar(45)  default '' null comment '昵称',
    email       varchar(128) default '' null comment '邮箱',
    user_pic    varchar(128) default '' null comment '头像',
    create_time datetime                not null comment '创建时间',
    update_time datetime                not null comment '修改时间',
    role        int                     not null comment '角色权限  0 管理员  1 宿管  2 水站  3 学生',
    constraint username
        unique (username)
)
    comment '用户表';

# 11-订水账单表
create table waterBill
(
    waterBillId     int auto_increment
        primary key,
    waterBillNumber varchar(20) null,
    dormNumber      varchar(10) null,
    waterBillStatus varchar(20) null,
    waterStationId  int         null,
    waterCount      int         null,
    totalPrice      double      null
)
    comment '水账单表';

# 12-订水订单表
create table waterOrder
(
    waterOrderId     int auto_increment
        primary key,
    waterOrderNumber varchar(20) null,
    dormNumber       varchar(10) null,
    studentId        int         null,
    waterOrderTime   datetime    null,
    waterDeliverTime datetime    null,
    waterOrderStatus varchar(20) null,
    waterStationId   int         null,
    waterCount       int         null
)
    comment '水订单表';

# 13-水站信息表
create table waterStation
(
    waterStationId       int auto_increment
        primary key,
    waterStationUsername varchar(20) null,
    waterStationName     varchar(20) null,
    waterStationLocation varchar(20) null,
    waterPrice           int         null
)
    comment '水站信息表';

# 各个数据表的数据，迁移时间2024/3/5
# 1

# 2
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (1, 1, 2);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (2, 2, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (3, 3, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (5, 5, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (6, 6, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (7, 7, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (8, 8, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (9, 9, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (10, 10, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (11, 11, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (12, 12, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (13, 13, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (14, 14, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (15, 15, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (16, 16, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (17, 17, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (18, 18, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (19, 19, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (20, 20, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (21, 21, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (22, 22, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (23, 23, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (24, 24, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (25, 25, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (26, 26, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (27, 27, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (28, 28, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (29, 29, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (30, 32, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (31, 33, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (32, 34, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (33, 36, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (34, 37, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (35, 38, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (38, 43, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (40, 45, 2);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (73, 78, 3);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (74, 79, 2);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (76, 81, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (77, 82, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (78, 83, 0);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (79, 84, 2);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (80, 85, 1);
INSERT INTO dormlife.likeNumTable (id, main_id, likeNum) VALUES (81, 86, 4);

# 3
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (2, 1, 7);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (6, 11, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (9, 43, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (30, 29, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (31, 25, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (38, 78, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (39, 45, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (40, 79, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (42, 45, 7);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (43, 78, 7);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (44, 79, 7);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (46, 78, 73);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (50, 1, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (52, 34, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (54, 84, 80);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (55, 84, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (56, 85, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (57, 86, 1);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (58, 86, 6);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (59, 86, 10);
INSERT INTO dormlife.likeUserTable (id, main_id, user_id) VALUES (60, 86, 80);

# 4
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (1, 'shiyulu', '陆诗雨', '18018641963', 'ICPC济南G题', 'G题用了并查集还是超时，这道题该怎么做？我们目前的思路只是使用普通的并查集。
--纪念ICPC济南站，很棒的比赛！', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/af274b22-d1b7-46be-8cca-e62af317c3b0.jpg', 3, '2024-01-07 00:13:17', '2024-01-25 18:04:12');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (2, 'cheems', '芝士狗狗', '18018888888', '芝士汉堡拼单', '速来速来，有人想拼芝士汉堡吗？', '
https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/65a0fa29-b9fc-4d05-af85-e23d4eb76432.jpg', 2, '2024-01-07 00:13:17', '2024-01-17 20:46:33');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (3, 'user8', 'Sophie Taylor', '555-111-2222', 'Home Repairs Assistance', 'Need assistance with home repairs and maintenance.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/f79ebbe8-7888-4659-8551-6c6152d942e2.jpg', 3, '2024-01-07 11:20:00', '2024-01-07 17:35:58');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (5, 'user10', 'Olivia Martinez', '444-555-6666', 'Babysitting Assistance', 'Looking for a reliable babysitter for occasional help.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/fcdef2d5-827a-4969-9db9-54f7de08019c.jpg', 2, '2024-01-08 15:45:00', '2024-01-18 15:58:36');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (6, 'user11', 'Noah Robinson', '777-888-9999', 'Transportation Help', 'Need a ride to the airport. Any volunteers?', 'https://roy064.oss-cn-shanghai.aliyuncs.com/library/572cdd23-688c-4bb9-a3ed-188d92033a74.JPG', 3, '2024-01-08 17:30:00', '2024-01-08 17:30:00');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (7, 'user12', 'Ava Garcia', '123-456-7890', 'Tech Support Needed', 'Experiencing computer issues. Need technical support.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/d35fc310-695c-4569-b2af-afcf0e5ca0de.jpg', 1, '2024-01-09 09:15:00', '2024-01-18 15:58:10');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (8, 'user13', 'Liam Davis', '987-654-3210', 'Fitness Trainer Wanted', 'Looking for a fitness trainer to help with workout routines.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ed4a0df3-d422-4769-ac55-620b77f24f1a.jpg', 4, '2024-01-09 12:30:00', '2024-01-18 15:57:49');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (9, 'user14', 'Ella Rodriguez', '555-123-4567', 'Gardening Assistance', 'Need help with gardening and landscaping projects.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/5670fe50-b40a-44ce-890d-73bf2cbfa03b.jpg', 2, '2024-01-10 14:00:00', '2024-01-18 15:57:13');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (10, 'user15', 'Mason White', '111-222-3333', 'Language Exchange', 'Offering English lessons in exchange for learning a new language.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/d9c847cc-170b-45d6-ba1e-e9320523095c.jpg', 4, '2024-01-10 16:45:00', '2024-01-18 15:57:04');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (11, 'user16', 'Harper Smith', '444-555-6666', 'Pet Adoption Event', 'Organizing a pet adoption event. Volunteers needed!', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/9b70811d-c7fe-4992-beca-239c82cbf469.jpg', 3, '2024-01-11 10:30:00', '2024-01-18 15:56:43');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (12, 'user17', 'Ethan Johnson', '777-888-9999', 'Community Cleanup', 'Join us for a community cleanup day. Let\'s make our neighborhood cleaner!', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/dee79f50-0b8a-4a80-9925-1016c6d55818.jpg', 3, '2024-01-11 13:15:00', '2024-01-18 16:00:11');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (13, 'user18', 'Aria Brown', '123-987-4561', 'Computer Programming Help', 'Need assistance with coding and programming assignments.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/c822b4b5-bdc1-4dbf-bf0a-c6177fb1e8f5.jpg', 1, '2024-01-12 15:00:00', '2024-01-18 15:56:32');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (14, 'user19', 'Logan Green', '555-111-2222', 'Home Cooking Lessons', 'Offering lessons on cooking delicious and healthy meals at home.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/266f9606-5f8f-4d56-b648-da203522f81d.jpg', 4, '2024-01-12 17:45:00', '2024-01-18 15:56:21');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (15, 'user20', 'Grace Taylor', '111-222-3333', 'Senior Companion Needed', 'Looking for a companion to spend time with a senior citizen.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/be06da4d-26b9-442d-867e-55ecd4f26f00.jpg', 2, '2024-01-13 09:30:00', '2024-01-18 15:56:11');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (16, 'user21', 'William Anderson', '444-555-6666', 'Music Tutor Wanted', 'Searching for a music tutor to help improve piano skills.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/21ba2905-5d64-4410-917f-2971554e986b.jpg', 4, '2024-01-13 12:15:00', '2024-01-18 15:55:54');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (17, 'user22', 'Chloe Martinez', '777-888-9999', 'Car Repair Assistance', 'Car broke down. Need help with repairs or towing.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/393e8147-91ba-4ded-8fc8-0753b197ad81.jpg', 3, '2024-01-14 14:00:00', '2024-01-18 15:55:22');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (18, 'user23', 'James Robinson', '123-456-7890', 'Book Club Formation', 'Starting a book club. Interested readers are welcome to join!', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b286ea1f-2159-4c62-8199-1dc7e46d094f.jpg', 4, '2024-01-14 16:45:00', '2024-01-18 15:55:11');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (19, 'user24', 'Ava Davis', '987-654-3210', 'Math Tutor Needed', 'In need of a math tutor for high school-level mathematics.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/9ccb9805-c1c8-46f2-9710-6889a02e77a1.jpg', 1, '2024-01-15 10:30:00', '2024-01-18 15:55:00');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (20, 'user25', 'Liam Rodriguez', '555-123-4567', 'Art Workshop Organizer', 'Organizing an art workshop. Looking for participants and volunteers.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/0ab7983f-39b5-4756-8f3d-75afe8fce5fc.jpg', 2, '2024-01-15 13:15:00', '2024-01-18 15:54:47');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (21, 'user26', 'Ella White', '111-222-3333', 'Virtual Assistant Needed', 'Hiring a virtual assistant for administrative tasks.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b3e9cdbe-e46d-44bf-af40-408b460050e8.png', 3, '2024-01-16 15:00:00', '2024-01-10 02:12:48');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (22, 'user27', 'Mason Black', '444-555-6666', 'Yoga Instructor Needed', 'Looking for a certified yoga instructor for group sessions.', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/641d14e2-38c9-49ee-872a-9857fcc8adc8.jpg', 4, '2024-01-16 17:45:00', '2024-01-10 02:12:25');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (23, 'user28', '张三', '13812345678', '二手手机出售', '因换新手机，出售一部iPhone X，全新无划痕，有兴趣的朋友请联系我。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/acf86b9d-9a2a-4a8e-b2ac-b6d060382235.jpg', 5, '2024-01-20 10:00:00', '2024-01-15 23:15:29');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (24, 'user29', '李四', '13987654321', '二手自行车转让', '出售一辆山地自行车，使用一年，车况良好，价格可小刀。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b3ee530a-10ba-461f-b772-e701185f892a.jpg', 5, '2024-01-20 11:30:00', '2024-01-15 23:14:22');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (25, 'user30', '王五', '13611112222', '闲置书籍出售', '整理书架，有多本闲置书籍出售，涉及小说、历史等多个领域，有需要的可以联系我。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/d9ce1f48-8fbb-4ce0-973c-811fb742a69a.jpg', 5, '2024-01-20 12:45:00', '2024-01-07 02:17:11');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (26, 'user31', '赵六', '13533334444', '二手电脑交易', '升级了新电脑，出售一台二手台式电脑，配置详见图片，价格可议。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/8c6a0b00-a5d8-46d1-bffc-df203ec69611.jpg', 5, '2024-01-20 14:00:00', '2024-01-10 02:11:58');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (27, 'user32', '孙七', '13755556666', '二手家具转让', '搬家了，有一些二手家具需要转让，包括沙发、桌椅等，有兴趣请联系我。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ee2c787e-8e81-436b-a654-da1a6e502a1d.jpg', 5, '2024-01-20 15:15:00', '2024-01-15 23:04:27');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (28, 'user33', '周八', '13877778888', '二手相机出售', '出售一台佳能相机，附赠镜头和包，成色良好，有意者请速联系。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/5838fbe6-5e6e-49d9-ab18-8098be2ab757.png', 5, '2024-01-20 16:30:00', '2024-01-07 12:22:23');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (29, 'user34', '吴九', '13999990000', '二手衣物闲置', '整理衣橱，有一批二手衣物闲置，男女款式各有，需要的朋友请及时私信我。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/63c74bdf-fae1-4dcc-81c1-dbad31159385.png', 5, '2024-01-20 17:45:00', '2024-01-10 02:07:12');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (32, 'user37', '曹十二', '13565432123', '二手电动车出售', '因购买新车，出售一辆二手电动车，电池健康，续航优秀，有兴趣请联系。', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/6b061ae8-e2bc-4307-b2dc-a940d1fbe6bb.png', 5, '2024-01-20 21:30:00', '2024-01-07 02:22:21');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (33, 'bloodhunter', '寻血猎犬', '17377777777', 'APEX拉人', '我是布洛克亨德尔！！！', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/9d5a1cc5-07f8-4118-83e4-8e5afe27925d.png', 4, '2024-01-07 00:53:46', '2024-01-07 00:53:46');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (34, 'test01', '测试员', '1789179479', '111111', 'adadadadadad', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/fb29e23b-3cde-402b-8f89-57817b816d28.jpg', 1, '2024-01-07 17:21:16', '2024-01-18 18:18:20');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (36, 'shiyulu', '陆诗雨', '17358140811', '使用userInfo绑定article数据模型的测试', '测试啦/测试啦/测试啦', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/1cad68e2-2639-48f0-952d-5378ddfe15ea.jpg', 3, '2024-01-08 15:27:47', '2024-01-10 02:11:03');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (37, 'shiyulu', '陆诗雨', '18018641963', 'vue对象同步数据流讨论', '前后端分离！', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/d2a953e5-b974-4895-8fd9-fb020f9e1ad5.jpg', 3, '2024-01-09 01:46:14', '2024-01-09 01:46:14');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (38, 'shiyulu', '陆诗雨', '18018641963', '1/9号足球赛', '测试不同类别帖子回显', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/2ebecb0e-805a-4841-81e4-ae0ae9cc0fbb.jpg', 4, '2024-01-09 11:22:05', '2024-01-09 11:22:05');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (43, 'shiyulu', '陆诗雨', '18018641963', 'Dorm Life生活轻舍 version_0.8上线 ', '更新内容：
界面使用arco重写
字节浪潮技术
更多的美化
@1.18', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/f618070c-86d7-4c11-9d39-375840d274bd.jpg', 3, '2024-01-18 15:07:55', '2024-01-18 15:07:55');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (45, 'Beluga', '巴鲁卡', '17308110820', '开发团队Elegance-Modernization招募', 'Elegance-Modernization招募:
加入我们的团队：优雅与现代化，一起学习最酷的技术！
', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/2cc5a6be-952c-4249-b38d-e3b2e2f97405.webp', 4, '2024-01-19 22:32:31', '2024-01-19 22:32:31');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (78, 'shiyulu', '陆诗雨', '18018641963', 'dormlife1.0即将上线！', '很高兴与大家见面！经过我们团队持续不断的努力，DormLife1.0版本即将上线与大家见面！
在整个开发中，我负责了SHUer友广场的前后端搭建及DormLife整个Layout的前端设计及美术风格设计，希望大家能够喜欢！
', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/6fb4b950-cdc0-4169-b9ff-5bd6d31cc705.webp', 3, '2024-01-20 12:53:19', '2024-01-20 12:53:19');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (79, 'chennan', '陈楠', '18018641963', 'dormlife1.0上线前瞻', '我是DormLife项目的产品经理并且负责开发了水站和查寝板块的后端。dormlife1.0即将要上线了，希望大家能够喜欢！', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/1744af36-f531-4dc0-9ff5-b528b6937971.webp', 3, '2024-01-20 12:57:20', '2024-01-20 12:57:20');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (81, 'shiyulu', '陆诗雨', '1801864109733', '1111', '11111', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/22d1c16d-d095-4094-909e-eb8c54d4602d.jpg', 2, '2024-01-25 18:05:12', '2024-01-25 18:05:12');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (82, '123456', '', '', '1', '', '', 5, '2024-01-25 18:07:16', '2024-01-25 18:07:16');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (83, 'shiyulu', '陆诗雨', '18018641963', 'aa士大夫', '111', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ffd55736-9921-45e2-bd90-195cb68dbc28.jpg', 3, '2024-01-25 18:28:35', '2024-01-25 18:28:35');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (84, 'shiyulu', '陆诗雨', '18018641963', '24美赛开始啦', '又要熬夜了?', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/49f1c25a-40d9-4384-b5cf-42d346a07721.jpg', 3, '2024-02-02 09:27:36', '2024-02-02 09:27:36');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (85, 'shiyulu', '陆诗雨', '18018641963', '我好想睡觉啊', '真的好困', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/7bf4ac5a-3aa7-4110-b63e-ab02606a9454.png', 1, '2024-02-05 17:59:49', '2024-02-05 17:59:49');
INSERT INTO dormlife.mainpage (id, username, name, phone, title, content, image, type_id, create_time, update_time) VALUES (86, 'shiyulu', '陆诗雨', '18018641963', '2024龙年贺岁帖', '各位SHUer友广场的朋友们大家好，Elegance-Modernization团队祝大家新的一年天天开心，步步高升，bug永远没有，语句越来越优雅！SHUer友广场也会在新的一年里努力继续更新的！期待大家的建议！', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/01544611-eae6-4b2e-bc33-26b61a12338f.webp', 4, '2024-02-09 21:44:34', '2024-02-09 21:44:34');

# 5
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (1, 1, 1);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (2, 2, 2);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (3, 1, 3);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (4, 1, 10);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (7, 32, 4);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (8, 32, 5);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (9, 32, 6);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (10, 33, 7);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (11, 33, 8);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (12, 32, 9);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (13, 25, 10);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (14, 25, 11);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (15, 28, 12);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (16, 30, 13);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (17, 1, 14);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (18, 33, 15);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (19, 30, 16);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (20, 30, 17);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (21, 30, 18);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (22, 2, 19);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (23, 33, 20);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (24, 1, 21);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (25, 1, 22);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (26, 36, 23);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (27, 41, 24);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (28, 2, 25);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (29, 23, 26);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (30, 43, 27);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (31, 45, 28);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (32, 1, 29);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (33, 78, 30);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (34, 79, 31);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (35, 84, 32);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (36, 84, 33);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (37, 84, 34);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (38, 85, 35);
INSERT INTO dormlife.mp (id, main_id, reply_id) VALUES (39, 85, 36);

# 6
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (1, 'chennan', '陈楠', '应该使用正反并查集', '2024-01-07 00:13:27');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (2, 'Beluga', '巴鲁卡', '我来和你拼单！', '2024-01-07 00:13:27');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (3, 'chenxinyu', '陈欣宇', '我看了题解，最后应该是利用图论！', '2024-01-07 00:13:30');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (4, 'robort', '机器人', '123', '2024-01-07 00:21:14');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (5, 'robort', '机器人', '今晚秋明山见', '2024-01-07 00:23:31');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (6, 'robort', '机器人', '我输给了一辆AE86，它的过弯速度很快', '2024-01-07 00:23:54');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (7, 'robort', '机器人', '我可以玩机器人，我们一起打吧！', '2024-01-07 00:56:06');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (8, 'robort', '机器人', '我也想玩！哈哈', '2024-01-07 00:57:01');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (9, 'robort', '机器人', '《电动车》', '2024-01-07 01:20:45');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (10, 'robort', '机器人', '好期待地铁系列的第四部作品呀！', '2024-01-07 02:17:56');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (11, 'robort', '机器人', '测试bug', '2024-01-07 02:28:05');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (12, 'robort', '机器人', '这是相机拍的吗，好清楚！?', '2024-01-07 12:22:51');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (13, 'robort', '机器人', '测试bug', '2024-01-07 17:10:45');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (14, 'robort', '机器人', '一起学习图论呀！', '2024-01-07 17:37:35');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (15, 'robort', '机器人', '111', '2024-01-07 18:01:47');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (16, 'shiyulu', '陆诗雨', '更新头像后的测试', '2024-01-07 18:38:24');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (17, 'shiyulu', '陆诗雨', '我只能说很对', '2024-01-07 18:38:40');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (18, 'wangzhiwei', 'w_cecily', '我也来测试！！！', '2024-01-07 20:06:49');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (19, 'shiyulu', '陆诗雨', '芝士狗狗！', '2024-01-07 20:27:04');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (20, 'shiyulu', '陆诗雨', '2222', '2024-01-07 21:20:06');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (21, 'shiyulu', '陆诗雨', '为上海大学ACM集训队服役！', '2024-01-07 21:21:39');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (22, 'shiyulu', '陆诗雨', '111', '2024-01-08 17:40:11');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (23, 'suguan001', '江城子', '陆老师好帅！', '2024-01-16 00:06:22');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (24, 'shiyulu', '陆诗雨', '组件基于arco会更优雅！', '2024-01-17 16:50:31');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (25, 'chennann', 'cn', '我也要拼单', '2024-01-17 21:38:02');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (26, 'chennann', 'cn', '牛逼', '2024-01-18 15:16:41');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (27, 'shiyulu', '陆诗雨', 'version  1.0版本的更新也已经提上了日程！', '2024-01-18 17:37:37');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (28, 'shiyulu', '陆诗雨', '大家可以来加入我们的组织呀！', '2024-01-20 23:57:42');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (29, 'shiyulu', '陆诗雨', 'aasdf', '2024-01-24 22:46:25');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (30, 'chennann', '陈楠', '你好?', '2024-01-25 16:37:57');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (31, 'shiyulu', '陆诗雨', '1111', '2024-01-25 17:00:40');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (32, 'shiyulu', '陆诗雨', 'qweqwe', '2024-02-02 09:28:51');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (33, 'chennann', '陈楠', '我们早就搞完了，美赛太简单了', '2024-02-04 23:59:26');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (34, 'shiyulu', '陆诗雨', '太厉害了', '2024-02-05 17:58:39');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (35, 'chennann', '陈楠', '这么专业 O奖了咯', '2024-02-07 01:14:53');
INSERT INTO dormlife.replypage (id, username, name, content, reply_time) VALUES (36, 'shiyulu', '陆诗雨', '成功提交就可以了?', '2024-02-07 10:42:10');

# 7
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (6, 'chennann', '陈楠', '1208', 1, '21120987');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (7, 'ljkkk', '李珺恺', '1208', 2, '21120988');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (8, 'zzyyy', '郑志勇', '1208', 3, '21120989');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (9, 'student4', '薛申斯', '1208', 4, '21120990');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (10, 'student5', '雪深武', '1210', 1, '21120991');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (11, 'student6', '雪深溜', '1210', 2, '21120992');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (12, 'student7', '雪深企', '1210', 3, '21120993');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (13, 'student8', '雪深霸', '1210', 4, '21120994');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (14, 'student9', '薛绳酒', '1212', 1, '21120995');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (15, 'student10', '薛绳诗', '1212', 2, '21120996');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (16, 'student11', '薛绳诗意', '1212', 3, '21120997');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (17, 'student12', '薛绳世二', '1212', 4, '21120998');
INSERT INTO dormlife.student (studentId, studentUserName, studentName, dormNumber, bedNumber, studentNumber) VALUES (19, 'user8', '用户8', '1011', 1, '21120310');

# 8
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (63, 'student5', '21120991', '2024-01-20 21:25:48', '阳台', null, 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (64, 'student5', '21120991', '2024-01-20 21:25:48', '垃圾', null, 2, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (65, 'student5', '21120991', '2024-01-20 21:25:48', '桌面', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (66, 'student6', '21120992', '2024-01-20 21:25:48', '阳台', null, 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (67, 'student6', '21120992', '2024-01-20 21:25:48', '地面', null, 2, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (68, 'student7', '21120993', '2024-01-20 21:25:48', '地面', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (69, 'student8', '21120994', '2024-01-20 21:25:48', '被子', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (70, 'student9', '21120995', '2024-01-20 21:25:48', '阳台', null, 0, 'suguan001', '没有图片你问什么扣我分', null, '申诉成功');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (71, 'student9', '21120995', '2024-01-20 21:25:48', '垃圾', null, 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (72, 'student9', '21120995', '2024-01-20 21:25:48', '地面', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (73, 'student10', '21120996', '2024-01-20 21:25:48', '垃圾', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (74, 'student10', '21120996', '2024-01-20 21:25:48', '地面', null, 2, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (75, 'student11', '21120997', '2024-01-20 21:25:48', '被子', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (76, 'student12', '21120998', '2024-01-20 21:25:48', '阳台', null, 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (77, 'chennann', '21120987', '2024-01-23 21:30:13', '桌面', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/22e12702-1ee3-4d55-bbe9-7942c4bb1b0f.jpg', 0, 'suguan001', '这都不是我的桌面啊???我的桌面不至于乱到扣分吧??', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/e266fbfd-72e2-4825-b165-f24d72f08461.jpg', '申诉成功');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (78, 'chennann', '21120987', '2024-01-23 21:30:13', '地面', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/27870507-7f44-46ce-9b84-1654e3de95e3.jpg', 0, 'suguan001', '阿姨 这是还没扔掉的，后来马上扔掉了', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/2cf8dabb-214a-45cb-a1eb-3debf1f91d4b.jpg', '申诉成功');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (79, 'ljkkk', '21120988', '2024-01-23 21:30:13', '垃圾', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/eb4410b5-870d-4116-97ba-0cd16963bf34.jpg', 4, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (80, 'ljkkk', '21120988', '2024-01-23 21:30:13', '桌面', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (81, 'zzyyy', '21120989', '2024-01-23 21:30:13', '被子', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (82, 'student4', '21120990', '2024-01-23 21:30:13', '阳台', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (83, 'chennann', '21120987', '2024-01-24 21:33:13', '垃圾', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/814455ba-2a82-44d6-98ee-c978e8affefe.jpg', 0, 'suguan001', '拍个垃圾桶算什么??', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/43e49324-2a4c-4709-979b-9e54de1a9369.jpg', '申诉成功');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (84, 'ljkkk', '21120988', '2024-01-24 21:33:26', '阳台', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (85, 'ljkkk', '21120988', '2024-01-24 21:33:26', '垃圾', null, 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (86, 'zzyyy', '21120989', '2024-01-24 21:33:33', '地面', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (87, 'student4', '21120990', '2024-01-24 21:33:37', '地面', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (88, 'student4', '21120990', '2024-01-24 21:33:37', '被子', null, 5, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (89, 'student5', '21120991', '2024-01-24 22:50:53', '阳台', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/6311c9b0-9b3e-4f70-8c3b-adfab942e1ce.jpg', 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (90, 'student6', '21120992', '2024-01-24 22:51:07', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (91, 'student7', '21120993', '2024-01-24 22:54:22', '阳台', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ee646ad8-6d79-4711-a78c-b8a1fe55055c.jpg', 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (92, 'student8', '21120994', '2024-01-24 22:54:34', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (93, 'student9', '21120995', '2024-01-25 16:49:10', '阳台', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/76baff81-5c88-490f-9a94-e9414852dd68.jpg', 2, 'suguan001', '拍的什么玩意????', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/83cf48e0-935c-431d-912e-99b46c730f2a.jpg', '申诉失败');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (94, 'student9', '21120995', '2024-01-25 16:49:10', '桌面', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/6f0ddc54-e691-4829-97ac-419e5ea1d31c.jpg', 3, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (95, 'student10', '21120996', '2024-01-25 16:49:37', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (96, 'student11', '21120997', '2024-01-25 16:49:38', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (97, 'student12', '21120998', '2024-01-25 16:49:42', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (102, 'chennann', '21120987', '2024-01-25 18:06:22', '阳台', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/01e3a122-ffd2-4c1d-8233-44e8f83472a9.ico', 1, 'suguan001', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/77b27e4f-9c31-4d8e-8e2a-f12f48781bd2.jpg', '申诉中');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (103, 'chennann', '21120987', '2024-01-25 18:06:22', '垃圾', null, 1, 'suguan001', null, null, '已扣分');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (104, 'ljkkk', '21120988', '2024-01-25 18:06:39', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (105, 'zzyyy', '21120989', '2024-01-25 18:08:26', '不扣分', null, 0, 'suguan001', null, null, '优秀');
INSERT INTO dormlife.studentCheck (id, studentUserName, studentNumber, checkTime, checkReason, checkImg, checkValue, checker, appealReason, appealImg, status) VALUES (106, 'student4', '21120990', '2024-01-25 18:08:27', '不扣分', null, 0, 'suguan001', null, null, '优秀');

# 9
INSERT INTO dormlife.typepage (id, typename) VALUES (5, '二手集市');
INSERT INTO dormlife.typepage (id, typename) VALUES (4, '交友');
INSERT INTO dormlife.typepage (id, typename) VALUES (2, '拼单');
INSERT INTO dormlife.typepage (id, typename) VALUES (1, '求助');
INSERT INTO dormlife.typepage (id, typename) VALUES (3, '讨论');


# 10
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (1, 'shiyulu', 'e10adc3949ba59abbe56e057f20f883e', '陆诗雨', '1937714332@qq.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ddb3fb4f-0d2c-4c6e-bbec-5cfc7c7843c5.jpg', '2024-01-08 22:19:23', '2024-01-09 01:35:13', 0);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (2, 'wangzhiwei', 'e10adc3949ba59abbe56e057f20f883e', 'w_cecily', 'wang@qq.comd', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/2eb9a619-2d38-44db-a0cb-3624503f0099.jpg', '2023-12-29 11:23:12', '2024-01-19 11:17:51', 0);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (5, 'wangwangwang', 'e10adc3949ba59abbe56e057f20f883e', 'wang', '0909@qq.com', 'https://dormitory-group1.oss-cn-beijing.aliyuncs.com/ac2ca26f-ef26-46a2-bafd-7a8f8d0b5a6d.jpg', '2023-12-31 18:57:15', '2024-01-06 15:58:25', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (6, 'Beluga', 'e10adc3949ba59abbe56e057f20f883e', '巴鲁卡', 'manager@qq.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/8080a8f9-ce60-49e8-8d9a-b830e51779ce.jpg', '2024-01-08 22:20:07', '2024-01-08 22:20:07', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (7, 'chennan', 'e10adc3949ba59abbe56e057f20f883e', '陈楠', 'manager@qq.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/2eb9a619-2d38-44db-a0cb-3624503f0099.jpg', '2024-01-08 22:20:07', '2024-01-08 22:20:07', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (8, 'chenxinyu', 'e10adc3949ba59abbe56e057f20f883e', '陈欣宇', 'manager@qq.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/65a0fa29-b9fc-4d05-af85-e23d4eb76432.jpg', '2024-01-08 22:20:07', '2024-01-08 22:20:07', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (9, 'robort', 'e10adc3949ba59abbe56e057f20f883e', '机器人', 'AIrobort@qq.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/deec9534-d169-4798-bc55-8b216ade6765.png', '2024-01-08 22:20:07', '2024-01-08 22:20:07', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (10, 'cheems', 'e10adc3949ba59abbe56e057f20f883e', '芝士狗狗', 'cheems@gmail.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/3f0f4711-4596-46bc-be25-a7a75dcfcffb.png', '2024-01-08 22:20:07', '2024-01-08 22:20:07', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (11, 'user8', 'e10adc3949ba59abbe56e057f20f883e', 'Sophie Taylor', 'test@email.com', 'https://roy064.oss-cn-shanghai.aliyuncs.com/library/196963a0-52ea-4d2d-b4ad-f8cc0efdbb34.jpg', '2024-01-08 22:24:29', '2024-01-18 15:31:25', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (12, 'user9', 'e10adc3949ba59abbe56e057f20f883e', 'Daniel Anderson', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/91b81742-79ac-42b9-ab62-1bd00410db21.jpg', '2024-01-08 22:24:29', '2024-01-18 15:32:01', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (13, 'user10', 'e10adc3949ba59abbe56e057f20f883e', 'Olivia Martinez', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b6593520-ad55-435c-8316-0b772219c3c1.jpg', '2024-01-08 22:24:29', '2024-01-18 15:32:37', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (14, 'user11', 'e10adc3949ba59abbe56e057f20f883e', 'Noah Robinson', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/8e3f7c5c-c789-4685-82e2-184a0b492f4f.jpg', '2024-01-08 22:24:29', '2024-01-18 15:33:10', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (15, 'user12', 'e10adc3949ba59abbe56e057f20f883e', 'Ava Garcia', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/daf28e12-36a5-4a19-b7aa-8ba6696bbd51.jpg', '2024-01-08 22:24:29', '2024-01-18 15:33:28', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (16, 'user13', 'e10adc3949ba59abbe56e057f20f883e', 'Liam Davis', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b5d65f20-09c1-4651-9791-35057fa3ee27.jpg', '2024-01-08 22:24:29', '2024-01-18 15:34:29', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (17, 'user14', 'e10adc3949ba59abbe56e057f20f883e', 'Ella Rodriguez', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/59ddc4ed-2f29-4115-8be5-9a67304ccf89.jpg', '2024-01-08 22:24:29', '2024-01-18 15:34:55', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (18, 'user15', 'e10adc3949ba59abbe56e057f20f883e', 'Mason White', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/beae6a08-de63-4fc7-831b-f4414f655ab8.jpg', '2024-01-08 22:24:29', '2024-01-18 15:35:13', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (19, 'user16', 'e10adc3949ba59abbe56e057f20f883e', 'Harper Smith', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/6eeea8c2-6124-46ec-9e6e-8ada5babffc1.jpg', '2024-01-08 22:24:29', '2024-01-18 15:35:33', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (20, 'user17', 'e10adc3949ba59abbe56e057f20f883e', 'Ethan Johnson', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/257778f8-67e2-4ba0-a248-08f1463d7cf4.jpg', '2024-01-08 22:24:29', '2024-01-18 15:35:53', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (21, 'user18', 'e10adc3949ba59abbe56e057f20f883e', 'Aria Brown', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/f6639de8-063b-41ac-b64a-2160c50fa06d.jpg', '2024-01-08 22:24:29', '2024-01-18 15:36:19', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (22, 'user19', 'e10adc3949ba59abbe56e057f20f883e', 'Logan Green', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/af8d6543-b3f1-484b-81f3-d3b3f078bfe2.jpg', '2024-01-08 22:24:29', '2024-01-18 15:36:40', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (23, 'user20', 'e10adc3949ba59abbe56e057f20f883e', 'Grace Taylor', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ee453b32-e52b-4029-9808-80d7c012b7e3.jpg', '2024-01-08 22:24:29', '2024-01-18 15:37:00', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (24, 'user21', 'e10adc3949ba59abbe56e057f20f883e', 'William Anderson', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b56ee61d-e8f1-4941-99fc-d41b072b374c.jpg', '2024-01-08 22:24:29', '2024-01-18 15:38:22', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (25, 'user22', 'e10adc3949ba59abbe56e057f20f883e', 'Chloe Martinez', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/4cff088d-fe4e-4c35-8568-74bbe9bd0c68.jpg', '2024-01-08 22:24:29', '2024-01-18 15:39:02', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (26, 'user23', 'e10adc3949ba59abbe56e057f20f883e', 'James Robinson', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/80963e08-9312-4fed-aab0-caa34413cec9.jpg', '2024-01-08 22:24:29', '2024-01-18 15:39:42', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (27, 'user24', 'e10adc3949ba59abbe56e057f20f883e', 'Ava Davis', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/8d734463-7f24-456d-af5c-f214d00feac9.jpg', '2024-01-08 22:24:29', '2024-01-18 15:40:35', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (28, 'user25', 'e10adc3949ba59abbe56e057f20f883e', 'Liam Rodriguez', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/387f5205-1a7d-4842-8fc6-b678d93c06f1.jpg', '2024-01-08 22:24:29', '2024-01-18 15:41:29', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (29, 'user26', 'e10adc3949ba59abbe56e057f20f883e', 'Ella White', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/15bc2ca6-4def-45d4-b1d5-66246e12b141.jpg', '2024-01-08 22:24:29', '2024-01-18 15:42:34', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (30, 'user27', 'e10adc3949ba59abbe56e057f20f883e', 'Mason Black', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/f855ece8-db11-4336-82df-cde9bea81ade.jpg', '2024-01-08 22:24:29', '2024-01-18 15:43:25', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (61, 'user28', 'e10adc3949ba59abbe56e057f20f883e', '张三', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/24d8f29a-332b-4b1a-a438-d02d8622ea27.jpg', '2024-01-08 22:54:03', '2024-01-10 01:51:48', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (62, 'user29', 'e10adc3949ba59abbe56e057f20f883e', '李四', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/3741d284-fe98-4fd4-9d44-d99e8357be60.jpg', '2024-01-08 22:54:03', '2024-01-10 01:52:08', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (63, 'user30', 'e10adc3949ba59abbe56e057f20f883e', '王五', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/cfcbbf0f-5bed-48cc-8a64-f40ff887a6b2.jpg', '2024-01-08 22:54:03', '2024-01-10 01:52:33', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (64, 'user31', 'e10adc3949ba59abbe56e057f20f883e', '赵六', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/ed0d1a77-bf5c-41ed-8566-793cd57cd805.jpg', '2024-01-08 22:54:03', '2024-01-10 01:52:50', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (65, 'user32', 'e10adc3949ba59abbe56e057f20f883e', '孙七', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/cf298871-8d8d-42db-90a4-f0843e850c93.jpg', '2024-01-08 22:54:03', '2024-01-10 01:53:13', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (66, 'user33', 'e10adc3949ba59abbe56e057f20f883e', '周八', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/f578b67b-9c55-4f05-833f-15968c1d880f.jpg', '2024-01-08 22:54:03', '2024-01-10 01:53:28', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (67, 'user34', 'e10adc3949ba59abbe56e057f20f883e', '吴九', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/fea817f7-f458-4729-a0e8-7cf98774fddf.jpg', '2024-01-08 22:54:03', '2024-01-10 01:53:50', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (68, 'user35', 'e10adc3949ba59abbe56e057f20f883e', '郑十', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/b416306f-999a-414e-9ff9-1e2cb1f106af.jpg', '2024-01-08 22:54:03', '2024-01-18 15:44:22', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (69, 'user36', 'e10adc3949ba59abbe56e057f20f883e', '孟十一', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/57e56e0e-2a00-4e9e-a48c-0aa7963a57dc.jpg', '2024-01-08 22:54:03', '2024-01-18 15:44:43', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (70, 'user37', 'e10adc3949ba59abbe56e057f20f883e', '曹十二', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/24131ee7-9a7d-4a70-9197-afcecacb0e2a.jpg', '2024-01-08 22:54:03', '2024-01-18 15:45:23', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (71, 'bloodhunter', 'e10adc3949ba59abbe56e057f20f883e', '寻血旺旺', 'apex@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/3aa5f376-efe2-47e3-9738-6c67e16a073d.png', '2024-01-09 00:55:04', '2024-01-09 01:11:02', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (72, 'test01', 'e10adc3949ba59abbe56e057f20f883e', '测试员', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/a64a5558-0d31-4bde-b905-b9413d7a75e8.png', '2024-01-01 00:00:00', '2024-01-09 10:36:06', 0);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (73, 'qqszsz', 'e10adc3949ba59abbe56e057f20f883e', '清泉水站', 'test@email.com', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/a64a5558-0d31-4bde-b905-b9413d7a75e8.png', '2024-01-01 00:00:00', '2024-01-09 10:36:06', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (74, 'suguan001', 'efe6398127928f1b2e9ef3207fb82663', '江城子', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/3c2830be-a753-4f64-96cd-95cbe149ccb6.jpg', '2024-01-14 15:40:55', '2024-01-18 15:46:12', 1);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (75, 'testAdd001', 'e10adc3949ba59abbe56e057f20f883e', '', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/730b56b5-eb4f-4d03-8995-047fc62eb5ba.jpg', '2024-01-17 00:46:37', '2024-01-18 15:46:56', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (76, 'sqszsz', 'efe6398127928f1b2e9ef3207fb82663', '山泉水站', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/1670bd27-d322-41cc-8d15-0020ff223f96.jpg', '2024-01-17 00:46:37', '2024-01-18 15:48:21', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (77, 'glszsz', 'efe6398127928f1b2e9ef3207fb82663', '甘露水站', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/d6325372-567e-4730-863f-71393041c8fb.jpg', '2024-01-17 00:46:37', '2024-01-18 15:49:13', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (78, 'qyszsz', 'efe6398127928f1b2e9ef3207fb82663', '泉源水站', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/c2fde2f0-3e65-44a0-bf18-48c1c8db5ded.jpg', '2024-01-17 00:46:37', '2024-01-18 15:50:12', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (79, 'bqszsz', 'efe6398127928f1b2e9ef3207fb82663', '碧泉水站', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/1ca2b452-1af4-4efc-bcdf-aa373db1cb7e.jpg', '2024-01-17 00:46:37', '2024-01-18 15:50:54', 2);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (80, 'chennann', 'efe6398127928f1b2e9ef3207fb82663', '陈楠', '', 'https://shiyulu-dormhelppage.oss-cn-shanghai.aliyuncs.com/cae40283-8b5b-4aa8-ba89-88d1b78fbad4.jpg', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (81, 'ljkkk', 'efe6398127928f1b2e9ef3207fb82663', '李珺恺', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (82, 'zzyyy', 'efe6398127928f1b2e9ef3207fb82663', '郑志勇', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (83, 'student4', 'efe6398127928f1b2e9ef3207fb82663', '薛申斯', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (84, 'student5', 'efe6398127928f1b2e9ef3207fb82663', '雪深武', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (85, 'student6', 'efe6398127928f1b2e9ef3207fb82663', '雪深溜', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (86, 'student7', 'efe6398127928f1b2e9ef3207fb82663', '雪深企', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (87, 'student8', 'efe6398127928f1b2e9ef3207fb82663', '雪深霸', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (88, 'student9', 'efe6398127928f1b2e9ef3207fb82663', '薛绳酒', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (89, 'student10', 'efe6398127928f1b2e9ef3207fb82663', '薛绳诗', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (90, 'student11', 'efe6398127928f1b2e9ef3207fb82663', '薛绳诗意', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (91, 'student12', 'efe6398127928f1b2e9ef3207fb82663', '薛绳世二', '', '', '2024-01-17 00:46:37', '2024-01-18 15:52:07', 3);
INSERT INTO dormlife.user (id, username, password, nickname, email, user_pic, create_time, update_time, role) VALUES (92, '123456', 'e10adc3949ba59abbe56e057f20f883e', '', '', '', '2024-01-25 18:06:52', '2024-01-25 18:06:52', 1);

# 11
INSERT INTO dormlife.waterBill (waterBillId, waterBillNumber, dormNumber, waterBillStatus, waterStationId, waterCount, totalPrice) VALUES (13, '754638e795', '1210', '已支付', 1, 2, 20);
INSERT INTO dormlife.waterBill (waterBillId, waterBillNumber, dormNumber, waterBillStatus, waterStationId, waterCount, totalPrice) VALUES (14, '899be2fb3a', '1208', '已支付', 1, 3, 30);

# 12
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (11, '2852483189', '1208', 6, '2024-01-17 23:19:03', '2024-01-17 23:18:56', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (12, '73368bde3a', '1208', 6, '2024-01-17 23:19:29', '2024-01-17 23:19:21', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (13, '3ca71b5c9f', '1208', 6, '2024-01-18 11:29:52', '2024-01-19 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (14, '77da40bc5e', '1208', 6, '2024-01-18 11:30:02', '2024-01-20 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (15, '0e1234850a', '1208', 6, '2024-01-18 11:30:07', '2024-01-21 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (16, '67875eb090', '1208', 6, '2024-01-18 11:49:53', '2024-01-18 11:49:52', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (17, '633086516d', '1208', 6, '2024-01-18 11:50:37', '2024-01-18 11:50:37', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (18, '43b067d140', '1208', 6, '2024-01-18 11:51:30', '2024-01-18 11:51:29', '已支付', 1, 4);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (19, 'c35f43459d', '1208', 6, '2024-01-18 17:28:32', '2024-01-25 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (20, '6932c7ca06', '1208', 6, '2024-01-18 17:30:34', '2024-01-25 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (21, 'df7d35c851', '1208', 6, '2024-01-18 17:30:41', '2024-01-26 00:00:00', '运送中', 2, 3);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (22, 'd1a534cf92', '1208', 6, '2024-01-18 17:32:33', '2024-01-19 00:00:00', '已支付', 1, 3);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (23, 'aaa84111f6', '1208', 6, '2024-01-18 17:32:37', '2024-01-19 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (24, '92eaec2d7d', '1208', 6, '2024-01-18 17:32:40', '2024-01-19 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (25, '2c5b4299ce', '1208', 6, '2024-01-19 22:43:45', '2024-01-19 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (26, '296a138f39', '1208', 6, '2024-01-19 22:43:49', '2024-01-19 00:00:00', '已支付', 1, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (27, '557fe87879', '1208', 6, '2024-01-19 22:43:53', '2024-01-19 00:00:00', '运送中', 2, 2);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (28, '44d836449d', '1208', 6, '2024-01-19 22:43:57', '2024-01-19 00:00:00', '未接收', 2, 3);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (29, '39bc22fbda', '1208', 6, '2024-01-19 23:55:00', '2024-01-26 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (30, '00cfb61ca6', '1208', 6, '2024-01-20 00:00:11', '2024-01-24 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (31, '64e0ba8acf', '1208', 6, '2024-01-20 00:05:41', '2024-01-24 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (32, '911e9761a4', '1208', 6, '2024-01-20 00:08:02', '2024-01-22 00:00:00', '已取消', 3, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (33, 'fd4de86a42', '1208', 6, '2024-01-20 11:45:17', '2024-01-23 00:00:00', '已支付', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (34, '9a2d32cd20', '1212', 14, '2024-01-24 23:01:08', '2024-01-28 00:00:00', '运送中', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (35, '3770cf5744', '1210', 11, '2024-01-24 23:48:17', '2024-01-27 00:00:00', '已取消', 1, 3);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (36, 'ef290564c2', '1212', 15, '2024-01-24 23:50:53', '2024-01-26 00:00:00', '未接收', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (37, '3f76fee099', '1212', 15, '2024-01-24 23:52:40', '2024-01-28 00:00:00', '未接收', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (38, '8cd04ea8a3', '1212', 15, '2024-01-24 23:54:08', '2024-01-28 00:00:00', '未接收', 1, 5);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (39, '642da803b8', '1212', 15, '2024-01-24 23:54:21', '2024-01-27 00:00:00', '未接收', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (40, 'a5fc51875e', '1212', 16, '2024-01-24 23:56:43', '2024-01-26 00:00:00', '运送中', 1, 1);
INSERT INTO dormlife.waterOrder (waterOrderId, waterOrderNumber, dormNumber, studentId, waterOrderTime, waterDeliverTime, waterOrderStatus, waterStationId, waterCount) VALUES (41, '70ec44f701', '1208', 6, '2024-01-25 17:10:06', '2024-01-27 00:00:00', '已支付', 1, 1);

# 13
INSERT INTO dormlife.waterStation (waterStationId, waterStationUsername, waterStationName, waterStationLocation, waterPrice) VALUES (1, 'qqszsz', '清泉水站', '新世纪', 10);
INSERT INTO dormlife.waterStation (waterStationId, waterStationUsername, waterStationName, waterStationLocation, waterPrice) VALUES (2, 'sqszsz', '山泉水站', '南区', 11);
INSERT INTO dormlife.waterStation (waterStationId, waterStationUsername, waterStationName, waterStationLocation, waterPrice) VALUES (3, 'glszsz', '甘露水站', '校内', 11);
INSERT INTO dormlife.waterStation (waterStationId, waterStationUsername, waterStationName, waterStationLocation, waterPrice) VALUES (4, 'qyszsz', '泉源水站', '东区', 15);
INSERT INTO dormlife.waterStation (waterStationId, waterStationUsername, waterStationName, waterStationLocation, waterPrice) VALUES (5, 'bqszsz', '碧泉水站', '南区', 8);




