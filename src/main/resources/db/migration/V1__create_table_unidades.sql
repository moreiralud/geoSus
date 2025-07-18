    CREATE TABLE unidades_saude (
        id SERIAL PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        tipo VARCHAR(50) NOT NULL,
        endereco VARCHAR(255) NOT NULL,
        latitude DOUBLE PRECISION,
        longitude DOUBLE PRECISION,
        vagas_disponiveis INTEGER NOT NULL
    );

    CREATE TABLE unidade_saude_servicos (
        unidade_saude_id INTEGER NOT NULL,
        servicos VARCHAR(100) NOT NULL,
        FOREIGN KEY (unidade_saude_id) REFERENCES unidades_saude(id) ON DELETE CASCADE
    );
