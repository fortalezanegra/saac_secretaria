
/**###################################################################*/
/*########################## I N S E R T S ###########################*/
/*####################################################################*/

/*Tabela Situacao*/
INSERT INTO Situacao (descricao, contexto, ativo, ordem) VALUES

-- MEMBRO
('Ativo',                          'MEMBRO', 1, 1),
('Inativo',                        'MEMBRO', 1, 2),
('Falecido',                       'MEMBRO', 1, 3),
('Aguardando Batismo',             'MEMBRO', 1, 4),
('Aguardando Reuniao Ministerial', 'MEMBRO', 1, 5),
('N/A',                            'MEMBRO', 1, 6),

-- REUNIAO_MINISTERIAL
('Pendente',  'REUNIAO_MINISTERIAL', 1, 1),
('Concluida', 'REUNIAO_MINISTERIAL', 1, 2),
('Cancelada', 'REUNIAO_MINISTERIAL', 1, 3),

-- ATA_REUNIAO
('Aguardando Redação',    'ATA_REUNIAO', 1, 1),
('Em Analise',            'ATA_REUNIAO', 1, 2),
('Aguardando Aprovação',  'ATA_REUNIAO', 1, 3),
('Aprovada',              'ATA_REUNIAO', 1, 4),
('N/A',                   'ATA_REUNIAO', 1, 5),

-- BATISMO_EVENTO
('Pendente',  'BATISMO_EVENTO', 1, 1),
('Concluido', 'BATISMO_EVENTO', 1, 2),
('Cancelado', 'BATISMO_EVENTO', 1, 3),

-- BATISMO_CANDIDATO
('Pendente',       'BATISMO_CANDIDATO', 1, 1),
('Concluido',      'BATISMO_CANDIDATO', 1, 2),
('Cancelado',      'BATISMO_CANDIDATO', 1, 3),
('Nao Compareceu', 'BATISMO_CANDIDATO', 1, 4),

-- SOLICITACAO
('Aguardando Reuniao', 'SOLICITACAO', 1, 1),
('Aprovada',           'SOLICITACAO', 1, 2),
('Reprovada',          'SOLICITACAO', 1, 3),
('Cancelada',          'SOLICITACAO', 1, 4),
('Reagendada',         'SOLICITACAO', 1, 5),

-- DOCUMENTO
('Aguardando Envio',     'DOCUMENTO', 1, 1),
('Enviado',              'DOCUMENTO', 1, 2),
('Aguardando Revisao',   'DOCUMENTO', 1, 3),
('Revisado',             'DOCUMENTO', 1, 4),
('Aguardando Aprovacao', 'DOCUMENTO', 1, 5),
('Aprovado',             'DOCUMENTO', 1, 6),
('Aguardando Liberacao', 'DOCUMENTO', 1, 7),
('Liberado',             'DOCUMENTO', 1, 8),

-- ATIVIDADES
('Pendente',  'ATIVIDADES', 1, 1),
('Concluido', 'ATIVIDADES', 1, 2),
('Cancelado', 'ATIVIDADES', 1, 3),

-- DECISAO_MINISTERIAL
('Aguardando Reuniao', 'DECISAO_MINISTERIAL', 1, 1),
('Aprovada',           'DECISAO_MINISTERIAL', 1, 2),
('Reprovada',          'DECISAO_MINISTERIAL', 1, 3),
('Cancelada',          'DECISAO_MINISTERIAL', 1, 4),
('Reagendada',         'DECISAO_MINISTERIAL', 1, 5);

/*Tabela Tipo Vinculo */
INSERT INTO TipoVinculo(descricao) VALUES
('Assitido'),
('Contribuinte'),
('Novo Convertido'),
('Congregado'),
('Membro');

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
('N/A'),
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

/* REUNIAO MINISTERIAL */
INSERT INTO ReuniaoMinisterial (tipoReuniao, congregacaoId, dataReuniao, situacaoId) VALUES
('PASTORES', 1, '2026-11-15', 1),
('DIRIGENTES', 1, '2026-11-26', 1),
('OBREIROS', 1, '2026-11-27', 1),
('EXTRAORDINARIA', 1, '2026-11-28', 1);

/* BATISMO */
INSERT INTO Batismo(congregacaoId, dataBatismo, situacaoId) VALUES
(1, '2026-12-12', 1);

/* IGREJA ORIGEM */
INSERT INTO IgrejaOrigem(descricao) VALUES
('Assembleia de Deus - Ministério Madureira'),
('Assembleia de Deus - Ministério Belem'),
('Igreja do Evangelho Quadrangular'),
('Batista'),
('Deus é Amor'),
('Família de Jesus');

/* MOTIVO DESLIGAMENTO */
INSERT INTO MotivoDesligamento(descricao) VALUES
('Abandono'),
('Exclusão'),
('Falecimento'),
('Mudança'),
('Suspensão');

/* TIPO HISTORICO */
INSERT INTO TipoHistorico(descricao) VALUES
('Informativo'),
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


/* ATIVIDADES */
INSERT INTO Atividades(congregacaoId, tipoCulto, descricao, participantes, dataCulto, situacaoId) VALUES
(7, 'FAMILIA', 'Culto da Familia', 40, '2026-01-04', 36),
(7, 'ENSINO', 'Culto Ensino', 15, '2026-01-06', 36),
(7, 'LAR', 'Tereza', 10, '2026-01-09', 36),
(7, 'AR_LIVRE', 'Quadra de Esportes Pq. Esther 2', 50, '2026-01-10', 36);

/*  OCORRENCIA */
INSERT INTO Ocorrencia(atividadeId, tipoOcorrencia, quantidade)VALUES
(1, 'CONVERSAO', 3),
(3, 'BATISMO_ESPIRITO_SANTO', 1),
(4, 'RECONCILIACAO', 3);

