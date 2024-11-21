CREATE TABLE tb_cliente (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     email VARCHAR(255) UNIQUE NOT NULL,
     data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_produto (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     descricao TEXT,
     preco DECIMAL(10, 2) NOT NULL,
     data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tb_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT,
    id_produto BIGINT,
    quantidade INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_situacao INT,
    pedido_hash CHAR(35) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id),
    FOREIGN KEY (id_produto) REFERENCES tb_produto(id)
);
