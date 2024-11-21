INSERT INTO tb_cliente(nome, email, data_cadastro) VALUES
('Pedro Paulo', 'pedro@gmail.com', NOW());

INSERT INTO tb_produto(nome, descricao, preco, data_cadastro) VALUES
    ('Produto 1', 'Produto 1', 10.99, NOW()),
    ('Produto 2', 'Produto 2', 15.99, NOW()),
    ('Produto 3', 'Produto 3', 20.99, NOW()),
    ('Produto 4', 'Produto 4', 25.99, NOW()),
    ('Produto 5', 'Produto 5', 30.99, NOW()),
    ('Produto 6', 'Produto 6', 35.99, NOW()),
    ('Produto 7', 'Produto 7', 40.99, NOW()),
    ('Produto 8', 'Produto 8', 45.99, NOW()),
    ('Produto 9', 'Produto 9', 50.99, NOW()),
    ('Produto 10', 'Produto 10', 1.99, NOW());

INSERT INTO tb_pedido(id_cliente, id_produto, quantidade, data_pedido, id_situacao, pedido_hash) VALUES
(1, 1, 1, NOW(), 0, 'b97bcad16f28446f5acb853629b7269b');