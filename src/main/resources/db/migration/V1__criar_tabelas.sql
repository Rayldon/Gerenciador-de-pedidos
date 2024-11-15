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

CREATE TABLE tb_tipo_situacao (
   id INT AUTO_INCREMENT PRIMARY KEY,
   descricao VARCHAR(100) NOT NULL  -- Descrição da situação (ex: "Pendente")
);

CREATE TABLE tb_pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT,
    id_produto BIGINT,
    quantidade INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_situacao INT,
    FOREIGN KEY (id_cliente) REFERENCES tb_cliente(id),
    FOREIGN KEY (id_produto) REFERENCES tb_produto(id),
    FOREIGN KEY (id_situacao) REFERENCES tb_tipo_situacao(id)
);