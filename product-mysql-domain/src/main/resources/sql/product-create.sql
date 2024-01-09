create table yosep_product
(
    delete_check       bit,
    price              decimal(15, 2),
    child_category_id  bigint       not null,
    delete_time        datetime(6),
    id                 bigint       not null auto_increment,
    insert_time        datetime(6),
    parent_category_id bigint       not null,
    remain             bigint       not null,
    seller_id          bigint       not null,
    total              bigint       not null,
    update_time        datetime(6),
    currency_code      varchar(255),
    insert_operator    varchar(255),
    product_name       varchar(255) not null,
    update_operator    varchar(255),
    primary key (id)
);

create table yosep_product_parent_category
(
    id            bigint       not null auto_increment,
    category_name varchar(255) not null,
    primary key (id)
);

create table yosep_product_child_category
(
    id                  bigint       not null auto_increment,
    parent_cataegory_id bigint       not null,
    category_name       varchar(255) not null,
    primary key (id)
);