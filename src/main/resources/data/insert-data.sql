INSERT INTO users (username, password, name, status, delete_at)
values ('test1', '', 'active user', '00', null),
       ('test2', '', 'withdrawal pending user1', '10', '2024-05-05 00:00:00'),
       ('test3', '', 'withdrawal pending user2', '10', '2024-04-01 00:00:00'),
       ('test4', '', 'withdrawal pending user3', '10', '2024-05-10 00:00:00');


INSERT INTO product (code, name, status, sale_start_at, sale_end_at, amount)
values ('P01', 'on sale product', '00', '2024-05-01 00:00:00', '9999-12-31 00:00:00', 100000),
       ('P02', 'sale pending product1', '01', '2024-05-05 00:00:00', '9999-12-31 00:00:00', 100000),
       ('P03', 'sale pending product2', '01', '2024-05-05 00:00:00', '9999-12-31 00:00:00', 100000),
       ('P04', 'sale pending product3', '01', '2024-06-01 00:00:00', '9999-12-31 00:00:00', 100000),
       ('P05', 'sale end test1', '00', '2024-05-01 00:00:00', '2024-05-05 00:00:00', 100000),
       ('P06', 'sale end test2', '00', '2024-05-01 00:00:00', '2024-06-01 00:00:00', 100000);
