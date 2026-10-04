
/**###################################################################*/
/*########################## I N S E R T S ###########################*/
/*####################################################################*/

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

/*Tabela Tipo Vinculo */
INSERT INTO TipoVinculo(descricao) VALUES
('Assitido'),
('Contribuinte'),
('Novo Convertido'),
('Congregado'),
('Membro');

/*Tabela Sexo*/
INSERT INTO Sexo(Descricao) VALUES
('Masculino'),
('Feminino');

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

/*Tabela Profissão*/
/*Insert em arquivo separado devido a quantidade*/

/*Tabela EstadoCivil*/
INSERT INTO EstadoCivil(Descricao) VALUES
('Solteiro(a)'),
('Casado(a)'),
('Divorciado(a)'),
('Viúvo(a)');

/*Tabela Setor*/
INSERT INTO Setor(Nome, Sigla, Descricao, CidadeId) VALUES
('Setor 1', 'ADBC-SET01', 'Grupo de Congregações', 144),
('Setor 2', 'ADBC-SET02', 'Grupo de Congregações', 144),
('Setor 3', 'ADBC-SET03', 'Grupo de Congregações', 144),
('Setor 4', 'ADBC-SET04', 'Grupo de Congregações', 144),
('Setor 5', 'ADBC-SET05', 'Grupo de Congregações', 219),
('Setor 6', 'ADBC-SET06', 'Grupo de Congregações', 123);

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

/*Tabela CargoMinisterial */
INSERT INTO CargoMinisterial(Descricao) VALUES
('Membro'),
('Auxiliar de Trabalho'),
('Diacono'),
('Diaconisa'),
('Missionário(a)'),
('Presbitero'),
('Evangelista'),
('Pastor(a)'),
('Bispo(a)');


/**###################################################################*/
/*########################## I N S E R T S ###########################*/
/*####################################################################*/

/* TIPO REUNIAO */
INSERT INTO TipoReuniao(descricao) VALUES
('Reunião de Dirigentes'),
('Reunião de Obreiros');

/* REUNIAO MINISTERIAL */
INSERT INTO ReuniaoMinisterial (tipoReuniaoId, congregacaoId, dataReuniao, situacaoId)
SELECT
    1,
    1,
    '2026-01-05',
    s.situacaoId
FROM Situacao s
WHERE s.contexto = 'REUNIAO_EVENTO'
  AND s.descricao = 'Pendente';

/* BATISMO */
INSERT INTO Batismo(congregacaoId, dataBatismo, situacaoId)
SELECT 1, '2026-01-10', s.situacaoId
FROM Situacao s
WHERE s.contexto = 'BATISMO_EVENTO'
AND s.descricao  = 'Pendente';

/* CANDIDATO BATISMO */
INSERT INTO CandidatoBatismo (
  batismoId,
  congregacaoId,
  pessoaId,
  situacaoId
)
SELECT
  b.batismoId,
  m.congregacaoId,
  m.pessoaId,
  s.situacaoId
FROM Batismo b
JOIN Pessoa m ON m.pessoaId = 1
JOIN Situacao s 
  ON s.contexto = 'BATISMO_CANDIDATO'
 AND s.descricao = 'Pendente'
WHERE b.dataBatismo = '2026-01-10';


/* TIPO SOLICITACAO */
INSERT INTO TipoSolicitacao(descricao) VALUES
('União'),
('União por Mudança'),
('União por Batismo'),
('Reconciliação'),
('Tranferencia'),
('Desligamento');

/* MOTIVO DESLIGAMENTO */
INSERT INTO MotivoDesligamento(descricao) VALUES
('Abandono'),
('Exclusão'),
('Falecimento'),
('Mudança'),
('Suspensão');


/* TIPO HISTORICO */
INSERT INTO TipoHistorico(descricao) VALUES
('Conversão'),
('Batismo'),
('União'),
('Transferência'),
('Desligamento'),
('Administrativo'),
('Ministerial'),
('Disciplinar'),
('Confidencial');

/**###################################################################*/
/*########################## I N S E R T S ###########################*/
/*####################################################################*/

/* TIPO EVENTO */
INSERT INTO TipoEvento(descricao)
VALUES
('Culto da Familia'),
('Culto de Ensino'),
('Tarde da Benção'),
('Culto em Casa'),
('Culto Ar Livre'),
('Evangelismo'),
('Escola Biblica Dominical');


/* EVENTO */
INSERT INTO Evento(congregacaoId, tipoEventoId, descricao, participantes, dataEvento, situacaoId) VALUES
(7, 1, 'Culto com a Familia', 40, '2026-01-04', 44),
(7, 2, 'Culto de Ensino', 15, '2026-01-06', 44),
(7, 4, 'Culto Casa Irmã Tereza', 10, '2026-01-09', 44),
(7, 5, 'Culto Quadra Esportes Pq. Esther 2', 50, '2026-01-10', 44);

/* TIPO OCORRENCIA */
INSERT INTO TipoOcorrencia(descricao)VALUES
('Conversao'),
('Reconciliacao'),  
('Batismo Espirito Santo');

/*  OCORRENCIA */
INSERT INTO Ocorrencia(eventoId, tipoOcorrenciaId, quantidade)VALUES
(1, 2, 3),
(3, 1, 1),
(4, 1, 3);

