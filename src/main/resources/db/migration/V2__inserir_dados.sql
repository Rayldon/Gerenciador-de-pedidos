INSERT INTO tb_tipo_situacao (descricao) VALUES
('Pendente'),
('Confirmado'),
('Em Preparação'),
('Enviado'),
('Entregue'),
('Cancelado');

INSERT INTO tb_cliente(nome, email, data_cadastro) VALUES
('Pedro Paulo', 'pedro@gmail.com', NOW());

INSERT INTO tb_produto(nome, descricao, preco, data_cadastro) VALUES
    ('Produto 1', 'Produto 1', 10.99, NOW());

INSERT INTO tb_pedido(id_cliente, id_produto, quantidade, data_pedido, id_situacao) VALUES
(1, 1, 1, NOW(), 0);