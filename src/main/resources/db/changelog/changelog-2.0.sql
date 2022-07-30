--liquibase formatted sql

--changeset fullstackbook:2
alter table todos add column completed boolean not null default false;