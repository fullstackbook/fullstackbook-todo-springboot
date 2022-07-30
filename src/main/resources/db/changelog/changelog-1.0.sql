--liquibase formatted sql

--changeset fullstackbook:1
create table todos (
  id bigserial primary key,
  name text
);