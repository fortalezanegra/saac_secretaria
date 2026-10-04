/*####################################################################################################################
#########################    S C R I P T   D A T A B A S E   S A A C   S E C R E T A R I A   #########################
####################################################################################################################*/

/* Removendo banco se existir */
DROP DATABASE IF EXISTS saac_secretaria;

/* Criando Banco de Dados */
CREATE DATABASE saac_secretaria 
  DEFAULT CHARACTER SET utf8mb4 
  COLLATE utf8mb4_unicode_ci;

/* Selecionando Banco */
USE saac_secretaria;

/*========================================================*/
/*                     TABELA SITUACAO                    */
/*========================================================*/
CREATE TABLE Situacao (
  situacaoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  contexto VARCHAR(50) NOT NULL,
  ativo BOOL DEFAULT 1,
  ordem INT DEFAULT 0,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE(descricao, contexto)
) ENGINE=InnoDB;

/*Tabela Situacao*/
INSERT INTO Situacao (descricao, contexto, ativo, ordem) VALUES
-- MEMBRO
('Candidato(a) União',             'MEMBRO', 1, 1),
('Candidato(a) Batismo',           'MEMBRO', 1, 2),
('Ativo',                          'MEMBRO', 1, 3),
('Inativo',                        'MEMBRO', 1, 4),
('Falecido',                       'MEMBRO', 1, 5),
('Aguardando Batismo',             'MEMBRO', 1, 6),
('Aguardando Reuniao Ministerial', 'MEMBRO', 1, 7),

-- REUNIAO_EVENTO
('Pendente',  'REUNIAO_EVENTO', 1, 1),
('Concluido', 'REUNIAO_EVENTO', 1, 2),
('Cancelado', 'REUNIAO_EVENTO', 1, 3),

-- ATA_REUNIAO
('Aguardando Redação',    'ATA_REUNIAO', 1, 1),
('Em Analise',            'ATA_REUNIAO', 1, 2),
('Aguardando Aprovação',  'ATA_REUNIAO', 1, 3),
('Aprovada',              'ATA_REUNIAO', 1, 4),
('Consolidada',           'ATA_REUNIAO', 1, 5),

-- BATISMO_EVENTO
('Pendente',  'BATISMO_EVENTO', 1, 1),
('Concluido', 'BATISMO_EVENTO', 1, 2),
('Cancelado', 'BATISMO_EVENTO', 1, 3),

-- BATISMO_CANDIDATO
('Pendente',       'BATISMO_CANDIDATO', 1, 1),
('Concluido',      'BATISMO_CANDIDATO', 1, 2),
('Cancelado',      'BATISMO_CANDIDATO', 1, 3),
('Nao Compareceu', 'BATISMO_CANDIDATO', 1, 4),

-- SOLICITACAO_UNIAO
('Aguardando Reuniao', 'SOLICITACAO_UNIAO', 1, 1),
('Aprovada',           'SOLICITACAO_UNIAO', 1, 2),
('Reprovada',          'SOLICITACAO_UNIAO', 1, 3),
('Cancelada',          'SOLICITACAO_UNIAO', 1, 4),
('Consolidada',        'SOLICITACAO_UNIAO', 1, 5),

-- SOLICITACAO_UNIAO_BATISMO
('Aguardando Reuniao', 'SOLICITACAO_UNIAO_BATISMO', 1, 1),
('Aprovada',           'SOLICITACAO_UNIAO_BATISMO', 1, 2),
('Reprovada',          'SOLICITACAO_UNIAO_BATISMO', 1, 3),
('Cancelada',          'SOLICITACAO_UNIAO_BATISMO', 1, 4),
('Consolidada',        'SOLICITACAO_UNIAO_BATISMO', 1, 5),

-- SOLICITACAO_UNIAO_MUDANCA
('Aguardando Reuniao', 'SOLICITACAO_UNIAO_MUDANCA', 1, 1),
('Aprovada',           'SOLICITACAO_UNIAO_MUDANCA', 1, 2),
('Reprovada',          'SOLICITACAO_UNIAO_MUDANCA', 1, 3),
('Cancelada',          'SOLICITACAO_UNIAO_MUDANCA', 1, 4),
('Consolidada',        'SOLICITACAO_UNIAO_MUDANCA', 1, 5),

-- SOLICITACAO_RECONCILIACAO
('Aguardando Reuniao', 'SOLICITACAO_RECONCILIACAO', 1, 1),
('Aprovada',           'SOLICITACAO_RECONCILIACAO', 1, 2),
('Reprovada',          'SOLICITACAO_RECONCILIACAO', 1, 3),
('Cancelada',          'SOLICITACAO_RECONCILIACAO', 1, 4),
('Consolidada',        'SOLICITACAO_RECONCILIACAO', 1, 5),

-- SOLICITACAO_TRANSFERENCIA
('Aguardando Reuniao', 'SOLICITACAO_TRANSFERENCIA', 1, 1),
('Aprovada',           'SOLICITACAO_TRANSFERENCIA', 1, 2),
('Reprovada',          'SOLICITACAO_TRANSFERENCIA', 1, 3),
('Cancelada',          'SOLICITACAO_TRANSFERENCIA', 1, 4),
('Consolidada',        'SOLICITACAO_TRANSFERENCIA', 1, 5),

-- SOLICITACAO_DESLIGAMENTO
('Aguardando Reuniao', 'SOLICITACAO_DESLIGAMENTO', 1, 1),
('Aprovada',           'SOLICITACAO_DESLIGAMENTO', 1, 2),
('Reprovada',          'SOLICITACAO_DESLIGAMENTO', 1, 3),
('Cancelada',          'SOLICITACAO_DESLIGAMENTO', 1, 4),
('Consolidada',        'SOLICITACAO_DESLIGAMENTO', 1, 5),

-- EVENTO
('Pendente',  'EVENTO', 1, 1),
('Concluido', 'EVENTO', 1, 2),
('Cancelado', 'EVENTO', 1, 3),

-- DOCUMENTO
('Aguardando Envio',     'DOCUMENTO', 1, 1),
('Enviado',              'DOCUMENTO', 1, 2),
('Aguardando Revisao',   'DOCUMENTO', 1, 3),
('Revisado',             'DOCUMENTO', 1, 4),
('Aguardando Aprovacao', 'DOCUMENTO', 1, 5),
('Aprovado',             'DOCUMENTO', 1, 6),
('Aguardando Liberacao', 'DOCUMENTO', 1, 7),
('Liberado',             'DOCUMENTO', 1, 8);

/*========================================================*/
/*                       TABELA PAIS                      */
/*========================================================*/
CREATE TABLE Pais (
  paisId INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  sigla VARCHAR(10) DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                      TABELA ESTADO                     */
/*========================================================*/
CREATE TABLE Estado (
  estadoId INT PRIMARY KEY AUTO_INCREMENT,
  paisId INT NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sigla VARCHAR(10) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE (paisId, nome),
  INDEX IDX_ESTADO_PAIS (paisId),

  CONSTRAINT FK_ESTADO_PAIS FOREIGN KEY (paisId) 
    REFERENCES Pais(paisId) ON DELETE RESTRICT

) ENGINE=InnoDB;

/*========================================================*/
/*                     TABELA CIDADE                      */
/*========================================================*/
CREATE TABLE Cidade (
  cidadeId BIGINT PRIMARY KEY AUTO_INCREMENT,
  estadoId INT NOT NULL,
  nome VARCHAR(150) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE (estadoId, nome),

  CONSTRAINT FK_CIDADE_ESTADO FOREIGN KEY (estadoId) 
    REFERENCES Estado(estadoId) ON DELETE RESTRICT

) ENGINE=InnoDB;

/*========================================================*/
/*                      TABELA SETOR                      */
/*========================================================*/
CREATE TABLE Setor (
  setorId INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  sigla VARCHAR(10) DEFAULT NULL,
  descricao VARCHAR(100) DEFAULT NULL,
  cidadeId BIGINT DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE (cidadeId, nome),

  CONSTRAINT FK_SETOR_X_CIDADE
  FOREIGN KEY (cidadeId) REFERENCES Cidade(cidadeId) ON DELETE RESTRICT

) ENGINE=InnoDB;

/*Tabela Setor*/
INSERT INTO Setor(Nome, Sigla, Descricao, CidadeId) VALUES
('Setor 1', 'ADBC-SET01', 'Grupo de Congregações', null),
('Setor 2', 'ADBC-SET02', 'Grupo de Congregações', null),
('Setor 3', 'ADBC-SET03', 'Grupo de Congregações', null),
('Setor 4', 'ADBC-SET04', 'Grupo de Congregações', null),
('Setor 5', 'ADBC-SET05', 'Grupo de Congregações', null),
('Setor 6', 'ADBC-SET06', 'Grupo de Congregações', null);

/*========================================================*/
/*                   TABELA CONGREGACAO                   */
/*========================================================*/
CREATE TABLE Congregacao (
  congregacaoId INT PRIMARY KEY AUTO_INCREMENT,
  setorId INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  sigla VARCHAR(50) DEFAULT NULL,
  endereco VARCHAR(255),
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE (setorId, nome),

  CONSTRAINT FK_CONGREGACAO_SETOR FOREIGN KEY (setorId)
    REFERENCES Setor(setorId) ON DELETE RESTRICT

) ENGINE=InnoDB;

/*Tabela Congregacao*/
INSERT INTO Congregacao(setorId, nome, sigla, endereco)VALUES
((SELECT setorId FROM Setor WHERE nome ='Setor 1'), 'Catedral da Fonte', 'CAF', 'Rua Moacir do Amaral, 767 Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 1'), 'Rosamélia', 'RSA', 'Rua Walter Zacarias, 33 Rosamélia Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 1'), 'Laranjeiras', 'LRJ', 'Rua Camilo Stucki, 202 Recanto das Laranjeiras Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 1'), 'Colibri', 'CLB', 'Rua Frederico Decresci, 339 Colibri Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 1'), 'Novo Cosmopolis', 'NCM', 'Rua Paulo de Azevedo Filho, 397 Novo Cosmopolis Cosmopolis-SP'),

((SELECT setorId FROM Setor WHERE nome ='Setor 2'), 'Parque Esther 1', 'PQE1', 'Rua Paulo Leivas Macalão, 101 Parque Esther 1 Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 2'), 'Parque Esther 2', 'PQR2', 'Rua Antonio Bordin, 145 Pq. Esther 2 Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 2'), 'Bader José AUN', 'BDR', 'Rua Adolpho Neumann, 02 Bader José AUN Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 2'), 'Jd. Eldorado', 'ELD', 'Rua Alberto Stuki, 328 Jd. Eldorado Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 2'), 'Souza Queiroz', 'SZQ', 'Rua ? Souza Queiroz Cosmopolis-SP'),

((SELECT setorId FROM Setor WHERE nome ='Setor 3'), 'Andorinhas', 'AND', 'Rua Luiz V. de Camões, 550 Andorinhas Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 3'), 'Jd. de Lourdes', 'JDL', 'Rua José Luis Bernardo da Silva,82 Cosmopolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 3'), 'Nosso Teto', 'NST', 'Rua Bortolo Caron, 37 Cosmopolis-SP'),

((SELECT setorId FROM Setor WHERE nome ='Setor 4'), 'Uirapuru', 'URP', 'Rua Tomaz Antonio Gonzaga, 371 Uirapuru Cosmopolis-SP'),

((SELECT setorId FROM Setor WHERE nome ='Setor 5'), 'Groot', 'GRT', 'Rua ? Holambra-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 5'), 'Imigrantes', 'IMT', 'Rua ? Holambra-SP'),

((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Americo de Campos', 'AMC', 'Rua ? Americo de Campos-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Ouroeste', 'OUR', 'Rua ? Ouroeste-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Riolândia', 'RIL', 'Rua ? Riolândia-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Santa Albertina', 'SAL', 'Rua ? SantaAlbertina-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Mesópolis', 'MSP', 'Rua ? Mesópolis-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Populina', 'PPL', 'Rua ? Populina-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Nipoã', 'NPA', 'Rua ? Nipoã-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Monte Aprazivel', 'MAP', 'Rua ? Monte Aprazivel-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Cosmorama', 'CMR', 'Rua ? Cosmorama-SP'),
((SELECT setorId FROM Setor WHERE nome ='Setor 6'), 'Cardoso', 'CRD', 'Rua ? Cardoso-SP');

/*========================================================*/
/*                 TABELA CARGO MINISTERIAL               */
/*========================================================*/
CREATE TABLE CargoMinisterial (
  cargoMinisterialId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*Tabela CargoMinisterial */
INSERT INTO CargoMinisterial(descricao) VALUES
('Nenhum'),
('Membro'),
('Auxiliar de Trabalho'),
('Diacono'),
('Diaconisa'),
('Missionário(a)'),
('Presbitero'),
('Evangelista'),
('Pastor(a)'),
('Bispo(a)');

/*========================================================*/
/*                        TABELA SEXO                     */
/*========================================================*/
CREATE TABLE Sexo (
  sexoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(10) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*Tabela Sexo*/
INSERT INTO Sexo(Descricao) VALUES
('Masculino'),
('Feminino');

/*========================================================*/
/*                    TABELA ESTADO CIVIL                 */
/*========================================================*/
CREATE TABLE EstadoCivil (
  estadoCivilId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(50) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*Tabela EstadoCivil*/
INSERT INTO EstadoCivil(Descricao) VALUES
('Solteiro(a)'),
('Casado(a)'),
('Divorciado(a)'),
('Viúvo(a)');

/*========================================================*/
/*                     TABELA FORMACAO                    */
/*========================================================*/
CREATE TABLE Formacao (
  formacaoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*Tabela Formacao*/
INSERT INTO Formacao(Descricao) VALUES
('Ensino Fundamental Incompleto'),
('Ensino Fundamental Completo'),
('Ensino Medio Incompleto'),
('Ensino Medio Completo'),
('Ensino Superior Incompleto'),
('Ensino Superior Completo'),
('Pós Graduação'),
('Mestrado'),
('Doutorado');

/*========================================================*/
/*                     TABELA PROFISSAO                   */
/*========================================================*/
CREATE TABLE Profissao (
  profissaoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*========================================================*/
/*                   TABELA TIPO VINCULO                  */
/*========================================================*/
CREATE TABLE TipoVinculo (
  tipoVinculoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE (descricao)

) ENGINE=InnoDB;

/*Tabela Tipo Vinculo */
INSERT INTO TipoVinculo(descricao) VALUES
('Assitido'),
('Contribuinte'),
('Novo Convertido'),
('Congregado'),
('Membro');

/*========================================================*/
/*                       TABELA PESSOA                    */
/*========================================================*/
CREATE TABLE Pessoa (
  pessoaId BIGINT PRIMARY KEY AUTO_INCREMENT,
  tipoVinculoId INT NOT NULL,

  nome VARCHAR(100) NOT NULL,
  sexoId INT DEFAULT NULL,
  dataNascimento DATE DEFAULT NULL,
  telefone VARCHAR(20),
  email VARCHAR(50),

  rg VARCHAR(15) DEFAULT NULL,
  cpf VARCHAR(15) DEFAULT NULL,
  formacaoId INT DEFAULT NULL,
  profissaoId INT DEFAULT NULL,

  pai VARCHAR(100) DEFAULT NULL,
  mae VARCHAR(100) DEFAULT NULL,
  estadoCivilId INT DEFAULT NULL,
  conjuge VARCHAR(100) DEFAULT NULL,
  certidao VARCHAR(100) DEFAULT NULL,
  tipoSanguineo VARCHAR(10) DEFAULT NULL,

  congregacaoId INT DEFAULT NULL,
  cargoMinisterialId INT DEFAULT NULL,
  dataBatismo DATE DEFAULT NULL,
  situacaoId INT DEFAULT NULL,

  foto VARCHAR(300) DEFAULT NULL,

  dataConversao DATE DEFAULT NULL,

  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_PESSOA_NOME (nome),
  INDEX IDX_PESSOA_CONGREGACAO (congregacaoId),
  INDEX IDX_PESSOA_TIPO_VINCULO (tipoVinculoId),
  
  CONSTRAINT FK_MEMBRO_X_TIPO_VINCULO FOREIGN KEY (tipoVinculoId)
    REFERENCES TipoVinculo(tipoVinculoId) ON DELETE RESTRICT,

  CONSTRAINT FK_MEMBRO_X_SEXO FOREIGN KEY (sexoId)
    REFERENCES Sexo(sexoId) ON DELETE SET NULL,

    CONSTRAINT FK_MEMBRO_X_FORMACAO FOREIGN KEY (formacaoId)
    REFERENCES Formacao(formacaoId) ON DELETE SET NULL,
    
  CONSTRAINT FK_MEMBRO_X_PROFISSAO FOREIGN KEY (profissaoId)
    REFERENCES Profissao(profissaoId) ON DELETE SET NULL,

  CONSTRAINT FK_MEMBRO_X_ESTADO_CIVIL FOREIGN KEY (estadoCivilId)
    REFERENCES EstadoCivil(estadoCivilId) ON DELETE SET NULL,

  CONSTRAINT FK_MEMBRO_X_CONGREGACAO FOREIGN KEY (congregacaoId)
    REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT,
    
  CONSTRAINT FK_MEMBRO_X_CARGO_MINISTERIAL FOREIGN KEY (cargoMinisterialId)
    REFERENCES CargoMinisterial(cargoMinisterialId) ON DELETE RESTRICT,
    
  CONSTRAINT FK_MEMBRO_X_SITUACAO FOREIGN KEY (situacaoId)
    REFERENCES Situacao(situacaoId) ON DELETE SET NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                      TABELA ENDERECO                   */
/*========================================================*/
CREATE TABLE Endereco (
  enderecoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  pessoaId BIGINT NOT NULL,
  logradouro VARCHAR(255) NOT NULL,
  numero INT DEFAULT NULL,
  complemento VARCHAR(255) DEFAULT NULL,
  bairro VARCHAR(255) DEFAULT NULL,
  cep VARCHAR(50) DEFAULT NULL,
  cidadeId BIGINT DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_ENDERECO_PESSOA (pessoaId),
  INDEX IDX_ENDERECO_CIDADE (cidadeId),

  CONSTRAINT FK_ENDERECO_MEMBRO FOREIGN KEY (pessoaId)
    REFERENCES Pessoa(pessoaId) ON DELETE CASCADE,

  CONSTRAINT FK_ENDERECO_CIDADE FOREIGN KEY (cidadeId)
    REFERENCES Cidade(cidadeId) ON DELETE SET NULL

) ENGINE=InnoDB;

/*#############################################################################*/
/*############## S C R I P T   R E U N I A O   M I N I S T E R I A L ##########*/
/*#############################################################################*/

/*========================================================*/
/*                  TABELA TIPO REUNIAO                   */
/*========================================================*/
CREATE TABLE TipoReuniao(
  tipoReuniaoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(255) UNIQUE NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL

) ENGINE=InnoDB;

/*========================================================*/
/*               TABELA REUNIAO MINISTEIRAL               */
/*========================================================*/
CREATE TABLE ReuniaoMinisterial(
  reuniaoMinisterialId BIGINT PRIMARY KEY AUTO_INCREMENT,
  tipoReuniaoId INT NOT NULL,
  congregacaoId INT NOT NULL,
  dataReuniao DATE NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_REUNIAO_TIPO_REUNIAO (tipoReuniaoId),
  INDEX IDX_REUNIAO_CONGREGACAO (congregacaoId),
  INDEX IDX_REUNIAO_DATA (dataReuniao),

  CONSTRAINT FK_REUNIAO_MINISTERIAL_X_TIPO_REUNIAO
  FOREIGN KEY(tipoReuniaoId) REFERENCES TipoReuniao(tipoReuniaoId)  ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_REUNIAO_MINISTERIAL_X_CONGREGACAO
  FOREIGN KEY(congregacaoId) REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_REUNIAO_MINISTERIAL_X_SITUACAO
  FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                   TABELA ATA REUNIAO                   */
/*========================================================*/
CREATE TABLE AtaReuniao(
  ataReuniaoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  reuniaoMinisterialId BIGINT NOT NULL,
  descricao VARCHAR(255) DEFAULT NULL,
  dataAta DATE DEFAULT NULL,
  urlAta VARCHAR(255) DEFAULT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_ATA_REUNIAO_REUNIAO (reuniaoMinisterialId),
  INDEX IDX_ATA_REUNIAO_SITUACAO (situacaoId),
  INDEX IDX_ATA_REUNIAO_DATA (dataAta),

  CONSTRAINT FK_ATA_REUNIAO_X_REUNIAO_MINISTERIAL
    FOREIGN KEY(reuniaoMinisterialId) REFERENCES ReuniaoMinisterial(reuniaoMinisterialId) 
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_ATA_REUNIAO_X_SITUACAO
    FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId) 
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                     TABELA BATISMO                     */
/*========================================================*/
CREATE TABLE Batismo (
  batismoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  congregacaoId INT NOT NULL,
  dataBatismo DATE NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_BATISMO_CONGREGACAO (congregacaoId),
  INDEX IDX_BATISMO_DATA (dataBatismo),
  INDEX IDX_BATISMO_SITUACAO (situacaoId),

  CONSTRAINT FK_BATISMO_X_CONGREGACAO
    FOREIGN KEY (congregacaoId) REFERENCES Congregacao(congregacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_BATISMO_X_SITUACAO
    FOREIGN KEY (situacaoId) REFERENCES Situacao(situacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                TABELA CANDIDATO BATISMO                */
/*========================================================*/
CREATE TABLE CandidatoBatismo (
  candidatoBatismoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  batismoId BIGINT NOT NULL,
  congregacaoId INT NOT NULL,
  pessoaId BIGINT NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE(batismoId, pessoaId),

  INDEX IDX_CANDIDATO_BATISMO_BATISMO (batismoId),
  INDEX IDX_CANDIDATO_BATISMO_CONGREGACAO (congregacaoId),
  INDEX IDX_CANDIDATO_BATISMO_PESSOA (pessoaId),
  INDEX IDX_CANDIDATO_BATISMO_SITUACAO (situacaoId),

  CONSTRAINT FK_CANDIDATO_BATISMO_X_BATISMO
    FOREIGN KEY(batismoId) REFERENCES Batismo(batismoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_CANDIDATO_BATISMO_X_CONGREGACAO
    FOREIGN KEY(congregacaoId) REFERENCES Congregacao(congregacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_CANDIDATO_BATISMO_X_MEMBRO
    FOREIGN KEY(pessoaId) REFERENCES Pessoa(pessoaId)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  
  CONSTRAINT FK_CANDIDATO_BATISMO_X_SITUACAO
    FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                       TIPO SOLICITACAO                 */
/*========================================================*/
CREATE TABLE TipoSolicitacao (
  tipoSolicitacaoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) UNIQUE NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL

) ENGINE=InnoDB;

/*========================================================*/
/*               TABELA MOTIVO DESLIGAMENTO               */
/*========================================================*/
CREATE TABLE MotivoDesligamento (
  motivoDesligamentoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) UNIQUE NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                   TABELA IGREJA ORIGEM                 */
/*========================================================*/
CREATE TABLE IgrejaOrigem (
  igrejaOrigemId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) UNIQUE NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                  TABELA SOLICITACAO                    */
/*========================================================*/
CREATE TABLE Solicitacao (
  solicitacaoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  reuniaoMinisterialId BIGINT DEFAULT NULL,

  /* Identificação */
  congregacaoSolicitanteId INT NOT NULL,
  tipoSolicitacaoId INT NOT NULL,
  pessoaId BIGINT NOT NULL,

  /* Solicitação de União por Batismo */
  candidatoBatismoId BIGINT DEFAULT NULL,
  
  /* Solicitação União/Mudança */
  igrejaOrigemId INT DEFAULT NULL,
  cargoIgrejaOrigemId INT DEFAULT NULL,
  cargoRecebidoId INT DEFAULT NULL,
  
  /* Solicitação Transferência */
  congregacaoOrigemId INT DEFAULT NULL,
  congregacaoDestinoId INT DEFAULT NULL,

  /* Solicitação Desligamento */
  motivoDesligamentoId INT DEFAULT NULL,

  historico TEXT,
  situacaoId INT NOT NULL,

  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  /* Índices para consultas */
  INDEX IDX_SOLIC_PESSOA (pessoaId),
  INDEX IDX_SOLIC_CONGREGACAO_SOLICITANTE (congregacaoSolicitanteId),
  INDEX IDX_SOLIC_TIPO_SOLICITACAO (tipoSolicitacaoId),
  INDEX IDX_SOLIC_SITUACAO (situacaoId),

  /* Foreign Keys */
  CONSTRAINT FK_SOLIC_REUNIAO_MINISTERIAL
    FOREIGN KEY (reuniaoMinisterialId) 
    REFERENCES ReuniaoMinisterial(reuniaoMinisterialId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_TIPO_SOLICITACAO
    FOREIGN KEY (tipoSolicitacaoId) 
    REFERENCES TipoSolicitacao(tipoSolicitacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CONGREGACAO_SOLICITANTE
    FOREIGN KEY (congregacaoSolicitanteId) 
    REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_PESSOA
    FOREIGN KEY (pessoaId) 
    REFERENCES Pessoa(pessoaId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_UNIAO_BATISMO
    FOREIGN KEY (candidatoBatismoId) 
    REFERENCES CandidatoBatismo(candidatoBatismoId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_IGREJA_ORIGEM
    FOREIGN KEY (igrejaOrigemId) 
    REFERENCES IgrejaOrigem(igrejaOrigemId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CARGO_ORIGEM
    FOREIGN KEY (cargoIgrejaOrigemId) 
    REFERENCES CargoMinisterial(cargoMinisterialId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CARGO_RECEBIDO
    FOREIGN KEY (cargoRecebidoId) 
    REFERENCES CargoMinisterial(cargoMinisterialId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CONGREGACAO_ORIGEM
    FOREIGN KEY (congregacaoOrigemId) 
    REFERENCES Congregacao(congregacaoId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CONGREGACAO_DESTINO
    FOREIGN KEY (congregacaoDestinoId) 
    REFERENCES Congregacao(congregacaoId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_MOTIVO_DESLIGAMENTO
    FOREIGN KEY (motivoDesligamentoId) 
    REFERENCES MotivoDesligamento(motivoDesligamentoId) ON DELETE SET NULL ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_SITUACAO
    FOREIGN KEY (situacaoId) 
    REFERENCES Situacao(situacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                     DECISAO MINISTERIAL                */
/*========================================================*/
CREATE TABLE DecisaoMinisterial (
  decisaoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  reuniaoMinisterialId BIGINT NOT NULL,
  solicitacaoId BIGINT NOT NULL,
  situacaoId INT NOT NULL,
  
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE (reuniaoMinisterialId, solicitacaoId),

  /* Índices para consultas */
  INDEX IDX_DECISAO_REUNIAO (reuniaoMinisterialId),
  INDEX IDX_DECISAO_SOLICITACAO (solicitacaoId),
  INDEX IDX_DECISAO_SITUACAO (situacaoId),

  /* Foreign Keys */
  CONSTRAINT FK_DECISAO_X_REUNIAO_MINISTERIAL
    FOREIGN KEY (reuniaoMinisterialId) 
    REFERENCES ReuniaoMinisterial(reuniaoMinisterialId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_DECISAO_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId) 
    REFERENCES Solicitacao(solicitacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_DECISAO_X_SITUACAO
    FOREIGN KEY (situacaoId) 
    REFERENCES Situacao(situacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                     TABELA HISTORICO                   */
/*========================================================*/
CREATE TABLE Historico (
  historicoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  pessoaId BIGINT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_HISTORICO_PESSOA (pessoaId),

  CONSTRAINT FK_HISTORICO_MEMBRO
    FOREIGN KEY (pessoaId) REFERENCES Pessoa(pessoaId) ON DELETE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                  TIPO HISTORICO                        */
/*========================================================*/
CREATE TABLE TipoHistorico (
  tipoHistoricoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(100) NOT NULL UNIQUE,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                  ITEM HISTORICO                        */
/*========================================================*/
CREATE TABLE ItemHistorico (
  itemHistoricoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  historicoId BIGINT NOT NULL,
  tipoHistoricoId INT NOT NULL,
  descricao TEXT NOT NULL,
  dataHistorico DATETIME DEFAULT CURRENT_TIMESTAMP,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  CONSTRAINT FK_ITEM_HISTORICO_HISTORICO
  FOREIGN KEY (historicoId) REFERENCES Historico(historicoId) ON DELETE CASCADE,

  CONSTRAINT FK_ITEM_HISTORICO_TIPO
  FOREIGN KEY (tipoHistoricoId) REFERENCES TipoHistorico(tipoHistoricoId) ON DELETE CASCADE

) ENGINE=InnoDB;




/*#############################################################################*/
/*### S C R I P T   R E L A T O R I O   G E R A L   C O N G R E G A Ç Õ E S ###*/
/*#############################################################################*/

/*========================================================*/
/*                 TABELA TIPO EVENTO                     */
/*========================================================*/
CREATE TABLE TipoEvento (
  tipoEventoId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(255) UNIQUE NOT NULL, 
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                      TABELA EVENTO                     */
/*========================================================*/
CREATE TABLE Evento (
  eventoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  congregacaoId INT NOT NULL,
  tipoEventoId INT NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  participantes INT DEFAULT 0,
  visitantes INT DEFAULT 0, 
  dataEvento DATE NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_EVENTO_TIPO_EVENTO (tipoEventoId),
  INDEX IDX_EVENTO_CONGREGACAO (congregacaoId),
  INDEX IDX_EVENTO_SITUACAO (situacaoId),

  CONSTRAINT FK_EVENTO_X_CONGREGACAO
    FOREIGN KEY(congregacaoId) REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_EVENTO_X_TIPO_EVENTO
    FOREIGN KEY(tipoEventoId) REFERENCES TipoEvento(tipoEventoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_EVENTO_X_SITUACAO
    FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;


/*========================================================*/
/*                     TIPO OCORRENCIA                    */
/*========================================================*/
CREATE TABLE TipoOcorrencia(
  tipoOcorrenciaId INT PRIMARY KEY AUTO_INCREMENT,
  descricao VARCHAR(255) UNIQUE NOT NULL, 
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL
) ENGINE=InnoDB;

/*========================================================*/
/*                    TABELA OCORRENCIA                   */
/*========================================================*/
CREATE TABLE Ocorrencia (
  ocorrenciaId BIGINT PRIMARY KEY AUTO_INCREMENT,
  eventoId BIGINT NOT NULL,
  tipoOcorrenciaId INT NOT NULL,
  quantidade INT DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE(eventoId, tipoOcorrenciaId),

  CONSTRAINT FK_OCORRENCIA_X_EVENTO
    FOREIGN KEY(eventoId) REFERENCES Evento(eventoId) ON DELETE CASCADE ON UPDATE CASCADE,

  CONSTRAINT FK_OCORRENCIA_X_TIPO_OCORRENCIA
    FOREIGN KEY(tipoOcorrenciaId) REFERENCES TipoOcorrencia(tipoOcorrenciaId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;


