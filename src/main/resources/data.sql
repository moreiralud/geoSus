-- Unidade 1 (muito próxima ao ponto -10.9111, -37.0723)
INSERT INTO unidades_saude (nome, tipo, endereco, latitude, longitude, vagas_disponiveis)
VALUES ('UBS Jardim Esperança', 'UBS', 'Rua das Flores, 123, Aracaju-SE', -10.9112, -37.0720, 8);

-- Unidade 2 (um pouco mais distante, mas dentro de 5km)
INSERT INTO unidades_saude (nome, tipo, endereco, latitude, longitude, vagas_disponiveis)
VALUES ('UPA Nova Aracaju', 'UPA', 'Av. Central, 456, Aracaju-SE', -10.9135, -37.0751, 3);

-- Unidade 3 (fora do raio de 5km)
INSERT INTO unidades_saude (nome, tipo, endereco, latitude, longitude, vagas_disponiveis)
VALUES ('Hospital São Vicente', 'Hospital', 'Rua Leste, 789, Aracaju-SE', -10.9500, -37.1200, 15);

-- Serviços para unidade 1
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (1, 'Pediatria');
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (1, 'Clínico Geral');
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (1, 'Vacinação');

-- Serviços para unidade 2
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (2, 'Urgência e Emergência');

-- Serviços para unidade 3
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (3, 'Cirurgia');
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (3, 'Ortopedia');
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos) VALUES (3, 'UTI');
