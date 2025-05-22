-- Adiciona coluna de data de criação
ALTER TABLE lancamentos ADD COLUMN data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- Cria índice para melhorar buscas
CREATE INDEX idx_lancamento_pessoa ON lancamentos(pessoa_id);