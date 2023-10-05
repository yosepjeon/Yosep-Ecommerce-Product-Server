create table yosep_product
(
    id               bigint auto_increment primary key comment '상품 ID',
    product_name     varchar(100) not null comment '상품 이름',
    seller_id        varchar(50)  not null comment '셀러 코드',
    product_price    decimal      not null comment '상품 가격',
    product_quantity int          not null comment '상품 재고',
    category_id      bigint       not null comment '상품 카테고리'
) charset = utf8;

create table yosep_product_category
(
    id               bigint auto_increment primary key comment '상품 ID',

) charset = utf8