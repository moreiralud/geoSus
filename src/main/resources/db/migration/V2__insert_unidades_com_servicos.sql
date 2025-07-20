-- V2__insert_unidades_com_servicos.sql

-- Inserção da unidade de saúde principal
INSERT INTO unidades_saude (nome, tipo, endereco, latitude, longitude, vagas_disponiveis)
VALUES ('UBS Jardim Esperança', 'UBS', 'Rua das Flores, 123, Aracaju-SE', -10.2915348, -36.6030195, 8);

-- Inserção dos serviços vinculados à unidade criada
INSERT INTO unidade_saude_servicos (unidade_saude_id, servicos)
VALUES
  ((SELECT id FROM unidades_saude WHERE nome = 'UBS Jardim Esperança'), 'Pediatria'),
  ((SELECT id FROM unidades_saude WHERE nome = 'UBS Jardim Esperança'), 'Clínico Geral'),
  ((SELECT id FROM unidades_saude WHERE nome = 'UBS Jardim Esperança'), 'Vacinação');
