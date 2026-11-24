# Regras de negócio: consolidação da reunião ministerial

## 1. Objetivo

Aplicar, de forma definitiva, as decisões aprovadas em uma reunião ministerial sobre o cadastro de pessoas e o histórico de cada uma, registrando o resultado no histórico.

## 2. Pré-condições

| Condição | Regra |
|---|---|
| Situação da reunião | Só é processada a reunião com `situacao = CONCLUIDA`. |
| Solicitações | Somente as solicitações com `reuniaoMinisterialId` igual à reunião, `situacao = APROVADA` e `deletedAt IS NULL`. |
| Ordem | A consolidação só pode começar depois que a reunião está `CONCLUIDA`. |

## 3. Fluxo geral

1. Verificar se a reunião está `CONCLUIDA`. Caso contrário, recusar a operação.
2. Buscar as solicitações `APROVADA` vinculadas à reunião.
3. Para cada solicitação, aplicar as alterações conforme o tipo (seção 4).
4. Para cada solicitação processada, criar um `ItemHistorico` com `tipoHistorico = INFORMATIVO` e `solicitacaoId` preenchido.
5. Alterar a situação da reunião para `CONSOLIDADA`.
6. Executar todos os passos em uma única transação. Se qualquer passo falhar, desfazer tudo.

## 4. Regras por tipo de solicitação

### 4.1 Regras comuns

- A pessoa é buscada por `Solicitacao.pessoaId`.
- Todo registro de pessoa alterado recebe `tipoVinculo = MEMBRO`.
- A situação da solicitação continua `APROVADA` após a consolidação.
- Os valores gravados vêm da própria solicitação, salvo quando a regra do tipo define valor fixo (seções 4.2 a 4.6). O valor atual da pessoa não é validado antes da alteração.
- A aplicação preenche `situacao` e `congregacaoId` da pessoa sempre que a regra determinar esses valores.

### 4.2 Desligamento

| Campo | Valor |
|---|---|
| `Pessoa.situacao` | `INATIVO` |
| `Pessoa.tipoVinculo` | `MEMBRO` |

O motivo do desligamento fica registrado em `SolicitacaoDesligamento.motivoDesligamentoId`.

O histórico da pessoa recebe o texto: `Desligamento aprovado por {motivo}, na {tipoReuniao} - {dataReuniao}`, em que `motivo` é a descrição do `MotivoDesligamento`, `tipoReuniao` é o tipo da reunião e `dataReuniao` é a data da reunião.

### 4.3 Transferência

| Campo | Valor |
|---|---|
| `Pessoa.congregacaoId` | `SolicitacaoTransferencia.congregacaoDestinoId` |
| `Pessoa.tipoVinculo` | `MEMBRO` |

- Não há validação de que a pessoa pertence à congregação de origem.
- A regra "origem diferente de destino" é validada pela aplicação, porque os triggers estão comentados no script.

### 4.4 Mudança

| Campo | Valor |
|---|---|
| `Pessoa.cargoMinisterialId` | `SolicitacaoMudanca.cargoRecebidoId` (obrigatório no banco) |
| `Pessoa.tipoVinculo` | `MEMBRO` |
| `Pessoa.congregacaoId` | `Solicitacao.congregacaoSolicitanteId` |

- `cargoIgrejaOrigemId` é opcional e registra o cargo na igreja de origem. Não altera a pessoa.
- `igrejaOrigemId` registra a origem. Não altera a pessoa.

### 4.5 União

| Campo | Valor |
|---|---|
| `Pessoa.situacao` | `ATIVO` |
| `Pessoa.tipoVinculo` | `MEMBRO` |
| `Pessoa.cargoMinisterialId` | `2` (cargo MEMBRO) |

Não há tipos separados para União por Mudança ou União por Batismo. CandidatoBatismo é ignorado nesta etapa.

### 4.6 Reconciliação

| Campo | Valor |
|---|---|
| `Pessoa.situacao` | `ATIVO` |
| `Pessoa.tipoVinculo` | `MEMBRO` |
| `Pessoa.cargoMinisterialId` | `2` (cargo MEMBRO) |

## 5. Histórico da pessoa

- Cada pessoa possui no máximo um `Historico` (`pessoaId` único).
- Se a pessoa ainda não tiver `Historico`, ele é criado antes de inserir o item.
- Cada solicitação aprovada gera um `ItemHistorico`:

| Campo | Regra |
|---|---|
| `solicitacaoId` | Id da solicitação processada. |
| `historicoId` | Histórico da pessoa da solicitação. |
| `tipoHistorico` | `INFORMATIVO`. |
| `descricao` | Desligamento: `Desligamento aprovado por {motivo}, na {tipoReuniao} - {dataReuniao}`. Demais tipos: a definir. |
| `dataHistorico` | Data de referência do registro, preenchida pela aplicação. |

- `createdAt` registra apenas a data técnica de inserção.

## 6. Idempotência e reprocessamento

- A reunião só é processada enquanto estiver `CONCLUIDA`. Depois de `CONSOLIDADA`, não é processada novamente.
- Cada solicitação gera no máximo um `ItemHistorico`, garantido pela constraint `UNIQUE` em `ItemHistorico.solicitacaoId`.
- Se a consolidação for interrompida, a transação é desfeita e a reunião continua `CONCLUIDA`, podendo ser processada de novo.

## 7. Validações

| Validação | Onde |
|---|---|
| Campos obrigatórios da requisição | DTO, com `@NotNull`. |
| Existência do cargo informado | Serviço, antes de alterar a pessoa. |
| Congregação de origem diferente da de destino (transferência) | Aplicação. |
| Reunião em `CONCLUIDA` | Serviço, antes de iniciar a transação. |

## 8. Erros e rollback

- Qualquer erro durante a consolidação desfaz a transação inteira.
- Nenhuma pessoa é alterada parcialmente.
- A reunião permanece `CONCLUIDA` em caso de falha.

## 9. Pontos em aberto

1. Texto de `ItemHistorico.descricao` para União, Mudança, Transferência e Reconciliação (seção 5).
2. Validar que `cargoMinisterialId = 2` corresponde ao cargo MEMBRO no banco (seções 4.5 e 4.6).