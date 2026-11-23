/*####################################################################################################################
#########################    S C R I P T   D A T A B A S E   S A A C   S E C R E T A R I A   #########################
####################################################################################################################*/

/* Removendo banco se existir */
DROP DATABASE IF EXISTS saac_secretaria_test;

/* Criando Banco de Dados */
CREATE DATABASE saac_secretaria_test
  DEFAULT CHARACTER SET utf8mb4 
  COLLATE utf8mb4_unicode_ci;

/* Selecionando Banco */
USE saac_secretaria_test;

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
/*                       TABELA PESSOA                    */
/*========================================================*/
CREATE TABLE Pessoa (
  pessoaId BIGINT PRIMARY KEY AUTO_INCREMENT,
  tipoVinculo ENUM('ASSISTIDO', 'CONTRIBUINTE', 'NOVO_CONVERTIDO', 'CONGREGADO', 'MEMBRO') NOT NULL,

  nome VARCHAR(100) NOT NULL,
  sexo ENUM('MASCULINO', 'FEMININO') DEFAULT NULL,
  dataNascimento DATE DEFAULT NULL,
  telefone VARCHAR(20),
  email VARCHAR(50),

  rg VARCHAR(15) DEFAULT NULL,
  cpf VARCHAR(15) DEFAULT NULL,
  formacaoId INT DEFAULT NULL,
  profissaoId INT DEFAULT NULL,

  pai VARCHAR(100) DEFAULT NULL,
  mae VARCHAR(100) DEFAULT NULL,
  estadoCivil ENUM('CASADO_A', 'SOLTEIRO_A', 'DIVORCIADO_A', 'VIUVO_A') DEFAULT NULL,
  conjuge VARCHAR(100) DEFAULT NULL,
  certidao VARCHAR(100) DEFAULT NULL,
  tipoSanguineo VARCHAR(10) DEFAULT NULL,

  congregacaoId INT DEFAULT NULL,
  cargoMinisterialId INT DEFAULT NULL,
  dataBatismo DATE DEFAULT NULL,
  situacao ENUM('ATIVO', 'INATIVO', 'FALECIDO', 'NA') DEFAULT NULL,

  foto VARCHAR(300) DEFAULT NULL,

  dataConversao DATE DEFAULT NULL,

  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_PESSOA_NOME (nome),
  INDEX IDX_PESSOA_CONGREGACAO (congregacaoId),
  

    CONSTRAINT FK_MEMBRO_X_FORMACAO FOREIGN KEY (formacaoId)
    REFERENCES Formacao(formacaoId) ON DELETE SET NULL,
    
  CONSTRAINT FK_MEMBRO_X_PROFISSAO FOREIGN KEY (profissaoId)
    REFERENCES Profissao(profissaoId) ON DELETE SET NULL,

  CONSTRAINT FK_MEMBRO_X_CONGREGACAO FOREIGN KEY (congregacaoId)
    REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT,
    
  CONSTRAINT FK_MEMBRO_X_CARGO_MINISTERIAL FOREIGN KEY (cargoMinisterialId)
    REFERENCES CargoMinisterial(cargoMinisterialId) ON DELETE RESTRICT

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
/*               TABELA REUNIAO MINISTEIRAL               */
/*========================================================*/
CREATE TABLE ReuniaoMinisterial(
  reuniaoMinisterialId BIGINT PRIMARY KEY AUTO_INCREMENT,
  tipoReuniao ENUM('PASTORES', 'DIRIGENTES', 'OBREIROS', 'EXTRAORDINARIA') NOT NULL,
  congregacaoId INT NOT NULL,
  dataReuniao DATE NOT NULL,
  situacao ENUM('PENDENTE', 'PAUTADA', 'EM_ANDAMENTO', 'CONCLUIDA', 'CONSOLIDADA', 'CANCELADA') NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_REUNIAO_CONGREGACAO (congregacaoId),
  INDEX IDX_REUNIAO_DATA (dataReuniao),

  CONSTRAINT FK_REUNIAO_MINISTERIAL_X_CONGREGACAO
  FOREIGN KEY(congregacaoId) REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

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
  pessoaId BIGINT NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,
  UNIQUE(batismoId, pessoaId),

  INDEX IDX_CANDIDATO_BATISMO_BATISMO (batismoId),
  INDEX IDX_CANDIDATO_BATISMO_PESSOA (pessoaId),
  INDEX IDX_CANDIDATO_BATISMO_SITUACAO (situacaoId),

  CONSTRAINT FK_CANDIDATO_BATISMO_X_BATISMO
    FOREIGN KEY(batismoId) REFERENCES Batismo(batismoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_CANDIDATO_BATISMO_X_PESSOA
    FOREIGN KEY(pessoaId) REFERENCES Pessoa(pessoaId)
    ON DELETE RESTRICT ON UPDATE CASCADE,
  
  CONSTRAINT FK_CANDIDATO_BATISMO_X_SITUACAO
    FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE

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
  congregacaoSolicitanteId INT NOT NULL,
  tipoSolicitacao ENUM('UNIAO', 'MUDANCA', 'TRANSFERENCIA', 'RECONCILIACAO', 'DESLIGAMENTO') NOT NULL,
  pessoaId BIGINT NOT NULL,
  historico TEXT NOT NULL,
  situacao ENUM('AGUARDANDO_REUNIAO', 'APROVADA', 'REPROVADA', 'CANCELADA', 'REAGENDADA') DEFAULT 'AGUARDANDO_REUNIAO',

  createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_SOLIC_CONGREGACAO_SOLICITANTE (congregacaoSolicitanteId),
  INDEX IDX_SOLIC_PESSOA (pessoaId),
  INDEX IDX_SOLIC_REUNIAO_SITUACAO (reuniaoMinisterialId, situacao),

  CONSTRAINT FK_SOLIC_REUNIAO_MINISTERIAL
    FOREIGN KEY (reuniaoMinisterialId)
    REFERENCES ReuniaoMinisterial(reuniaoMinisterialId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_CONGREGACAO_SOLICITANTE
    FOREIGN KEY (congregacaoSolicitanteId)
    REFERENCES Congregacao(congregacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SOLIC_PESSOA
    FOREIGN KEY (pessoaId)
    REFERENCES Pessoa(pessoaId)
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;


/*========================================================*/
/*            TABELA SOLICITACAO UNIAO                    */
/*========================================================*/
CREATE TABLE SolicitacaoUniao (
  solicitacaoId BIGINT PRIMARY KEY,

  CONSTRAINT FK_SUB_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId)
    REFERENCES Solicitacao(solicitacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;


/*========================================================*/
/*            TABELA SOLICITACAO MUDANCA                  */
/*========================================================*/
CREATE TABLE SolicitacaoMudanca (
  solicitacaoId BIGINT PRIMARY KEY,
  igrejaOrigemId INT NOT NULL,
  cargoIgrejaOrigemId INT DEFAULT NULL,
  cargoRecebidoId INT NOT NULL,

  CONSTRAINT FK_SUM_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId)
    REFERENCES Solicitacao(solicitacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SUM_X_IGREJA_ORIGEM
    FOREIGN KEY (igrejaOrigemId)
    REFERENCES IgrejaOrigem(igrejaOrigemId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SUM_X_CARGO_IGREJA_ORIGEM
    FOREIGN KEY (cargoIgrejaOrigemId)
    REFERENCES CargoMinisterial(cargoMinisterialId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SUM_X_CARGO_RECEBIDO
    FOREIGN KEY (cargoRecebidoId)
    REFERENCES CargoMinisterial(cargoMinisterialId)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;


/*========================================================*/
/*            TABELA SOLICITACAO TRANSFERENCIA            */
/*========================================================*/
CREATE TABLE SolicitacaoTransferencia (
  solicitacaoId BIGINT PRIMARY KEY,
  congregacaoOrigemId INT NOT NULL,
  congregacaoDestinoId INT NOT NULL,

  CONSTRAINT FK_ST_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId)
    REFERENCES Solicitacao(solicitacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_ST_X_CONGREGACAO_ORIGEM
    FOREIGN KEY (congregacaoOrigemId)
    REFERENCES Congregacao(congregacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_ST_X_CONGREGACAO_DESTINO
    FOREIGN KEY (congregacaoDestinoId)
    REFERENCES Congregacao(congregacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;

DELIMITER //

CREATE TRIGGER TRG_SOL_TRANSFERENCIA_BI
BEFORE INSERT ON SolicitacaoTransferencia
FOR EACH ROW
BEGIN
  IF NEW.congregacaoOrigemId = NEW.congregacaoDestinoId THEN
    SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'A congregacao de origem deve ser diferente da congregacao de destino';
  END IF;
END//

CREATE TRIGGER TRG_SOL_TRANSFERENCIA_BU
BEFORE UPDATE ON SolicitacaoTransferencia
FOR EACH ROW
BEGIN
  IF NEW.congregacaoOrigemId = NEW.congregacaoDestinoId THEN
    SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'A congregacao de origem deve ser diferente da congregacao de destino';
  END IF;
END//

DELIMITER ;

/*========================================================*/
/*            TABELA SOLICITACAO RECONCILIACAO            */
/*========================================================*/
CREATE TABLE SolicitacaoReconciliacao (
  solicitacaoId BIGINT PRIMARY KEY,

  CONSTRAINT FK_SR_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId)
    REFERENCES Solicitacao(solicitacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*            TABELA SOLICITACAO DESLIGAMENTO             */
/*========================================================*/
CREATE TABLE SolicitacaoDesligamento (
  solicitacaoId BIGINT PRIMARY KEY,
  motivoDesligamentoId INT NOT NULL,

  CONSTRAINT FK_SD_X_SOLICITACAO
    FOREIGN KEY (solicitacaoId)
    REFERENCES Solicitacao(solicitacaoId)
    ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_SD_X_MOTIVO_DESLIGAMENTO
    FOREIGN KEY (motivoDesligamentoId)
    REFERENCES MotivoDesligamento(motivoDesligamentoId)
    ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB;

/*========================================================*/
/*                     TABELA HISTORICO                   */
/*========================================================*/
CREATE TABLE Historico (
  historicoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  pessoaId BIGINT UNIQUE NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_HISTORICO_PESSOA (pessoaId),

  CONSTRAINT FK_HISTORICO_MEMBRO
    FOREIGN KEY (pessoaId) REFERENCES Pessoa(pessoaId) ON DELETE CASCADE

) ENGINE=InnoDB;


/*========================================================*/
/*                  ITEM HISTORICO                        */
/*========================================================*/
CREATE TABLE ItemHistorico (
  itemHistoricoId BIGINT PRIMARY KEY AUTO_INCREMENT,
  solicitacaoId BIGINT UNIQUE DEFAULT NULL,
  historicoId BIGINT NOT NULL,
  tipoHistorico ENUM('INFORMATIVO', 'CONFIDENCIAL') NOT NULL,
  descricao TEXT NOT NULL,
  dataHistorico DATETIME DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  CONSTRAINT FK_ITEM_HISTORICO_SOLICITACAO
  FOREIGN KEY (solicitacaoId) REFERENCES Solicitacao(solicitacaoId)
  ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_ITEM_HISTORICO_HISTORICO
  FOREIGN KEY (historicoId) REFERENCES Historico(historicoId)
  ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;


/*#############################################################################*/
/*### S C R I P T   R E L A T O R I O   G E R A L   C O N G R E G A Ç Õ E S ###*/
/*#############################################################################*/


/*========================================================*/
/*                      TABELA ATIVIDADES                 */
/*========================================================*/
CREATE TABLE Atividades (
  atividadeId BIGINT PRIMARY KEY AUTO_INCREMENT,
  congregacaoId INT NOT NULL,
  tipoCulto ENUM('AR_LIVRE', 'PUBLICO', 'FAMILIA', 'ENSINO', 'LAR', 'EVANGELISMO', 'ORACAO', 'TARDE_BENCAO', 'ESCOLA_DOMINICAL') NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  participantes INT DEFAULT 0,
  visitantes INT DEFAULT 0, 
  dataCulto DATETIME NOT NULL,
  situacaoId INT NOT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  INDEX IDX_ATIVIDADE_CONGREGACAO (congregacaoId),
  INDEX IDX_ATIVIDADE_SITUACAO (situacaoId),

  CONSTRAINT FK_ATIVIDADE_X_CONGREGACAO
    FOREIGN KEY(congregacaoId) REFERENCES Congregacao(congregacaoId) ON DELETE RESTRICT ON UPDATE CASCADE,

  CONSTRAINT FK_ATIVIDADE_X_SITUACAO
    FOREIGN KEY(situacaoId) REFERENCES Situacao(situacaoId) ON DELETE RESTRICT ON UPDATE CASCADE

) ENGINE=InnoDB;

/*========================================================*/
/*                    TABELA OCORRENCIA                   */
/*========================================================*/
CREATE TABLE Ocorrencia (
  ocorrenciaId BIGINT PRIMARY KEY AUTO_INCREMENT,
  atividadeId BIGINT NOT NULL,
  tipoOcorrencia ENUM('CONVERSAO', 'RECONCILIACAO', 'BATISMO_ESPIRITO_SANTO') NOT NULL,
  quantidade INT DEFAULT NULL,
  createdAt DATETIME DEFAULT CURRENT_TIMESTAMP,
  updatedAt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  deletedAt DATETIME DEFAULT NULL,
  modifiedBy BIGINT DEFAULT NULL,

  UNIQUE(atividadeId, tipoOcorrencia),

  CONSTRAINT FK_OCORRENCIA_X_ATIVIDADE
    FOREIGN KEY(atividadeId) REFERENCES Atividades(atividadeId) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;


