--liquibase formatted sql

--changeset fullstackbook:1
create table todos (
  id int primary key,
  name text
);