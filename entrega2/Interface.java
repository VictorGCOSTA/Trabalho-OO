// TODO: Calcular valor a pagar ao invés de só escrever com set.
// TODO: Se o usuário errar o nome do evento em inserirVeiculo() ou atualizarVeiculo(), ele pode ficar "preso" sem conseguir sair do loop.
// TODO: Talvez seja interessante mostrar o estacionamento do veículo quando for procurado.
// TODO: Excluir ou editar um evento não exclui ou edita os veículos que estão nele.
// TODO: Verificar formatos de data e hora.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Excecoes.DescricaoEmBrancoException;
import Excecoes.ValorAcessoInvalidoException;

public class Interface {
	private static List<Estacionamento> estacionamentos = new ArrayList<>();
    private static List<Evento> eventos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        boolean continuar = true;
        while (continuar){
            try{
                continuar = Menu();
            } catch (DescricaoEmBrancoException e){
                System.out.println(e.getMessage());
            } catch (ValorAcessoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static boolean Menu() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        int opcao;
        System.out.println("Selecione uma opção:");
        System.out.println("-- INSERIR --");
        System.out.println("1 - Criar estacionamento");
        System.out.println("2 - Incluir veiculo");
        System.out.println("3 - Criar evento");
        System.out.println();

        System.out.println("-- PESQUISAR --");
        System.out.println("4 - Pesquisar estacionamento");
        System.out.println("5 - Pesquisar veiculo");
        System.out.println("6 - Pesquisar evento");
        System.out.println();

        System.out.println("-- ATUALIZAR --");
        System.out.println("7 - Atualizar estacionamento");
        System.out.println("8 - Atualizar veiculo");        
        System.out.println("9 - Atualizar evento");
        System.out.println();

        System.out.println("-- Excluir --");
        System.out.println("10 - Excluir estacionamento");
        System.out.println("11 - Excluir veiculo");
        System.out.println("12 - Excluir evento");
        System.out.println();

        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                inserirEstacionamento();
                break;
            case 2:
                inserirVeiculo();
                break;
            case 3:
                inserirEvento();
                break;

            case 4:
                pesquisarEstacionamento();
                break;
            case 5: 
                pesquisarVeiculo();
                break;
            case 6:
                pesquisarEvento();
                break;

            case 7:
                atualizarEstacionamento();
                break;
            case 8:
                atualizarVeiculo();
                break;
            case 9:
                atualizarEvento();
                break;

            case 10:
                excluirEstacionamento();
                break;
            case 11:
                excluirVeiculo();
                break;
            case 12:
                excluirEvento();
                break;
            case 0:
                System.out.println("Encerrando o programa...");
                return false;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        return true;
}
/*********************
        Adições
 
*********************/
    private static void inserirEstacionamento() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        System.out.println("Digite o nome do estacionamento");
        String nomeEstacionamento = lerStringValida();
        System.out.println("Digite a quantidade de vagas totais:");
        int vagasTotais = lerInteiroValido();
        System.out.println("Digite a porcentagem do contratante:");
        double porcentagemContratante = lerDoubleValido();
        System.out.println("Digite o horario de funcionamento:");
        String horarioFuncionamento = lerStringValida();
        System.out.println("Digite o horario de periodo noturno: ");
        String horarioPeriodoNoturno = lerStringValida();
        System.out.println("Digite o valor da fracao:");
        double valorFracao = lerDoubleValido();
        System.out.println("Digite o valor por hora:");
        double valorHora = lerDoubleValido();
        System.out.println("Digite o valor da diurna:");
        double valorDiurna = lerDoubleValido();
        System.out.println("Digite o valor da noturna:");
        double valorNoturna = lerDoubleValido();
        System.out.println("Digite o valor mensalista:");
        double valorMensalista = lerDoubleValido();
        System.out.println("Digite o valor evento:");
        double valorEvento = lerDoubleValido();

        Estacionamento estacionamento = new Estacionamento(nomeEstacionamento, vagasTotais,
        porcentagemContratante, horarioFuncionamento, horarioPeriodoNoturno,
        valorFracao, valorHora, valorDiurna, valorNoturna, valorMensalista, valorEvento);

        estacionamentos.add(estacionamento);
        System.out.println("Estacionamento criado com sucesso!");
    }

    private static void inserirVeiculo() throws DescricaoEmBrancoException{
        System.out.println("Digite o nome do estacionamento em que deseja incluir");
        String nomeEstacionamento = lerStringValida();
        Estacionamento estacionamentoEncontrado = encontrarEstacionamento(nomeEstacionamento);
        
        if (estacionamentoEncontrado != null) {
            System.out.println("Digite a placa do veículo");
            String placa = lerStringValida();
            System.out.println("Digite o horario de entrada");
            String horarioEntrada = lerStringValida();
            System.out.println("Digite o horario de saida");
            String horarioSaida = lerStringValida();
            System.out.println("Digite a data de entrada");
            String dataEntrada = lerStringValida();
            System.out.println("Digite a data de saida");
            String dataSaida = lerStringValida();
            System.out.println("O veículo está em um evento?");
            System.out.println("Digite 's' para sim e 'n' para não");
            String evento = null;
            String resposta = lerStringValida();
            if (resposta.equals("s") || resposta.equals("S")){
                System.out.println("Digite o nome do evento");
                boolean novoEventoValido = false;
                while (!novoEventoValido){
                    evento = lerStringValida();
                    novoEventoValido = eventoExiste(evento);
                        if (!novoEventoValido){
                            System.out.println("Evento não encontrado. Insira um evento válido.");
                        }
                }
            }

            boolean veiculoIncluido = estacionamentoEncontrado.incluirVeiculo(placa, horarioEntrada, horarioSaida,
                    dataEntrada, dataSaida, evento);
            if (veiculoIncluido) {
                System.out.println("Veículo incluído com sucesso!");
            } else {
                System.out.println("Não foi possível incluir o veículo, não existem vagas disponíveis.");
            }
        } else {
            System.out.println("Estacionamento não encontrado.");
        }
    }

    private static void inserirEvento() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        System.out.println("Digite o nome do evento");
        String nomeEvento = lerStringValida();
        System.out.println("Digite a data de início do evento");
        String dataInicioEvento = lerStringValida();
        System.out.println("Digite a data de fim do evento");
        String dataFimEvento = lerStringValida();
        System.out.println("Digite o horario de início ");
        String horarioInicioEvento = lerStringValida();
        System.out.println("Digite o horario de fim");
        String horarioFimEvento = lerStringValida();
        System.out.println("Digite o valor do evento");
        double valorEvento = lerDoubleValido();

        Evento evento = new Evento(nomeEvento, dataInicioEvento, dataFimEvento, horarioInicioEvento, horarioFimEvento, valorEvento);
        
        eventos.add(evento);
        System.out.println("Evento incluído com sucesso!");
    }

/*********************
        Pesquisas
 
*********************/
    private static void pesquisarEstacionamento() throws DescricaoEmBrancoException{
        System.out.println("Digite o nome do estacionamento que deseja pesquisar:");
        String nomeEstacionamento = lerStringValida();
        Estacionamento estacionamentoEncontradoLeitura = encontrarEstacionamento(nomeEstacionamento);
        if (estacionamentoEncontradoLeitura != null) {
            System.out.println("Nome: " + estacionamentoEncontradoLeitura.getNome());
            System.out.println("Vagas totais: " + estacionamentoEncontradoLeitura.getVagasTotais());
            System.out.println("Vagas ocupadas: " + estacionamentoEncontradoLeitura.getVagasOcupadas());
            System.out.println(
                    "Porcentagem contratante: "
                            + estacionamentoEncontradoLeitura.getPorcentagemContratante());
            System.out.println("Lucro: " + estacionamentoEncontradoLeitura.getLucro());
            System.out.println(
                    "Horário de funcionamento: "
                            + estacionamentoEncontradoLeitura.getHorarioFuncionamento());
            System.out.println(
                    "Horário período noturno: "
                            + estacionamentoEncontradoLeitura.getHorarioPeriodoNoturno());
            System.out.println("Valor fração: " + estacionamentoEncontradoLeitura.getValorFracao());
            System.out.println("Valor hora: " + estacionamentoEncontradoLeitura.getValorHora());
            System.out.println("Valor diurna: " + estacionamentoEncontradoLeitura.getValorDiurna());
            System.out.println("Valor noturna: " + estacionamentoEncontradoLeitura.getValorNoturna());
            System.out.println("Valor mensalista: " + estacionamentoEncontradoLeitura.getValorMensalista());
            System.out.println("Valor evento: " + estacionamentoEncontradoLeitura.getValorEvento());
            System.out.println(
                    "Vagas disponíveis: " + estacionamentoEncontradoLeitura.verificaVagasDisponiveis());
            estacionamentoEncontradoLeitura.verVeiculos();
        } else {
            System.out.println("Estacionamento não encontrado.");
        }
    }

    private static void pesquisarVeiculo() throws DescricaoEmBrancoException{
        System.out.println("Digite a placa do veículo que deseja procurar:");
        String placaVeiculo = lerStringValida();
        Veiculo veiculoEncontrado = encontrarVeiculo(placaVeiculo);
        if (veiculoEncontrado==null) {
            System.out.println("Veículo não encontrado.");
        }
        else {
            System.out.println("Placa: " + veiculoEncontrado.getPlaca());
            System.out.println("Horário de entrada: " + veiculoEncontrado.getHorarioEntrada());
            System.out.println("Data de entrada: " + veiculoEncontrado.getDataEntrada());
            System.out.println("Horário de saída: " + veiculoEncontrado.getHorarioSaida());
            System.out.println("Data de saída: " + veiculoEncontrado.getDataSaida());
            if (veiculoEncontrado.getEvento() == null){
                System.out.println("Evento: Não está em um evento.");
            } else {
                System.out.println("Evento: " + veiculoEncontrado.getEvento());
            }
        }
    }

    private static void pesquisarEvento() throws DescricaoEmBrancoException{
        System.out.println("Digite o nome do evento que deseja pesquisar:");
        String nomeEvento = lerStringValida();
        Evento eventoEncontrado = encontrarEvento(nomeEvento);
        if (eventoEncontrado==null) {
            System.out.println("Evento não encontrado.");
        }
        else {
            System.out.println("Nome: " + eventoEncontrado.getNome());
            System.out.println("Data de início: " + eventoEncontrado.getDataInicio());
            System.out.println("Data de fim: " + eventoEncontrado.getDataFim());
            System.out.println("Horário de início: " + eventoEncontrado.getHorarioInicio());
            System.out.println("Horário de fim: " + eventoEncontrado.getHorarioFim());
            System.out.println("Valor: " + eventoEncontrado.getValor());
        }
    }
/*********************
        Atualizações

*********************/
    private static void atualizarEstacionamento() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        System.out.println("Digite o nome do estacionamento que deseja atualizar os registros:");
        String nomeEstacionamento = lerStringValida();
        Estacionamento estacionamentoEncontradoAtualizacao = encontrarEstacionamento(nomeEstacionamento);
        if (estacionamentoEncontradoAtualizacao != null) {
            String editarNome, editarVagasTotais, editarPorcentagemContratante, editarHorarioFuncionamento,
                    editarHorarioPeriodoNoturno, editarValorFracao, editarValorHora, editarValorDiurna,
                    editarValorNoturna, editarValorMensalista, editarValorEvento;
            
            System.out.println("Deseja editar o nome do estacionamento? (s/n)");
            editarNome = lerStringValida();
            if (editarNome.equals("s") || editarNome.equals("S")){
                System.out.println("Digite o novo nome do estacionamento");
                String novoNomeEstacionamento = lerStringValida();
                estacionamentoEncontradoAtualizacao.setNome(novoNomeEstacionamento);
                System.out.println("Nome do estacionamento atualizado com sucesso!");
            }
            System.out.println("Deseja editar a quantidade de vagas totais? (s/n)");
            editarVagasTotais = lerStringValida();
            if (editarVagasTotais.equals("s") || editarVagasTotais.equals("S")){
                System.out.println("Digite a nova quantidade de vagas totais");
                int novaVagasTotais = lerInteiroValido();
                estacionamentoEncontradoAtualizacao.setVagasTotais(novaVagasTotais);
                System.out.println("Quantidade de vagas totais atualizada com sucesso!");
            }
            System.out.println("Deseja editar a porcentagem contratante? (s/n)");
            editarPorcentagemContratante = lerStringValida();
            if (editarPorcentagemContratante.equals("s") || editarPorcentagemContratante.equals("S")){
                System.out.println("Digite a nova porcentagem contratante");
                double novaPorcentagemContratante = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setPorcentagemContratante(novaPorcentagemContratante);
                System.out.println("Porcentagem contratante atualizada com sucesso!");
            }
            System.out.println("Deseja editar o horário de funcionamento? (s/n)");
            editarHorarioFuncionamento = lerStringValida();
            if (editarHorarioFuncionamento.equals("s") || editarHorarioFuncionamento.equals("S")){
                System.out.println("Digite o novo horário de funcionamento");
                String novoHorarioFuncionamento = lerStringValida();
                estacionamentoEncontradoAtualizacao.setHorarioFuncionamento(novoHorarioFuncionamento);
                System.out.println("Horário de funcionamento atualizado com sucesso!");
            }
            System.out.println("Deseja editar o horário do período noturno? (s/n)");
            editarHorarioPeriodoNoturno = lerStringValida();
            if (editarHorarioPeriodoNoturno.equals("s") || editarHorarioPeriodoNoturno.equals("S")){
                System.out.println("Digite o novo horário do período noturno");
                String novoHorarioPeriodoNoturno = lerStringValida();
                estacionamentoEncontradoAtualizacao.setHorarioPeriodoNoturno(novoHorarioPeriodoNoturno);
                System.out.println("Horário do período noturno atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor da fração? (s/n)");
            editarValorFracao = lerStringValida();
            if (editarValorFracao.equals("s") || editarValorFracao.equals("S")){
                System.out.println("Digite o novo valor da fração");
                double novoValorFracao = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorFracao(novoValorFracao);
                System.out.println("Valor da fração atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor da hora? (s/n)");
            editarValorHora = lerStringValida();
            if (editarValorHora.equals("s") || editarValorHora.equals("S")){
                System.out.println("Digite o novo valor da hora");
                double novoValorHora = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorHora(novoValorHora);
                System.out.println("Valor da hora atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor da diurna? (s/n)");
            editarValorDiurna = lerStringValida();
            if (editarValorDiurna.equals("s") || editarValorDiurna.equals("S")){
                System.out.println("Digite o novo valor da diurna");
                double novoValorDiurna = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorDiurna(novoValorDiurna);
                System.out.println("Valor da diurna atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor da noturna? (s/n)");
            editarValorNoturna = lerStringValida();
            if (editarValorNoturna.equals("s") || editarValorNoturna.equals("S")){
                System.out.println("Digite o novo valor da noturna");
                double novoValorNoturna = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorNoturna(novoValorNoturna);
                System.out.println("Valor da noturna atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor do mensalista? (s/n)");
            editarValorMensalista = lerStringValida();
            if (editarValorMensalista.equals("s") || editarValorMensalista.equals("S")){
                System.out.println("Digite o novo valor do mensalista");
                double novoValorMensalista = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorMensalista(novoValorMensalista);
                System.out.println("Valor do mensalista atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor do evento? (s/n)");
            editarValorEvento = lerStringValida();
            if (editarValorEvento.equals("s") || editarValorEvento.equals("S")){
                System.out.println("Digite o novo valor do evento");
                double novoValorEvento = lerDoubleValido();
                estacionamentoEncontradoAtualizacao.setValorEvento(novoValorEvento);
                System.out.println("Valor do evento atualizado com sucesso!");
            }   
        } else {
            System.out.println("Estacionamento não encontrado.");
        }
    }

    private static void atualizarVeiculo() throws DescricaoEmBrancoException{
        System.out.println("Digite a placa do veículo que deseja atualizar");
        String placaVeiculo = lerStringValida();
        Veiculo veiculoEncontradoAtualizacao = encontrarVeiculo(placaVeiculo);
        if (veiculoEncontradoAtualizacao != null) {
            String editarPlaca, editarHorarioEntrada, editarHorarioSaida,
            editarDataEntrada, editarDataSaida, editarNomeEvento;
            System.out.println("Deseja editar a placa do veículo? (s/n)");
            editarPlaca = lerStringValida();
        	if(editarPlaca.equals("s") || editarPlaca.equals("S")) {
        		 System.out.println("Digite o nova Placa");
                 String novaPlaca = lerStringValida();
                 veiculoEncontradoAtualizacao.setPlaca(novaPlaca);
                 System.out.println("Placa atualizada com sucesso!");
        	}
        	System.out.println("Deseja editar o horario de entrada do veículo? (s/n)");
            editarHorarioEntrada = lerStringValida();
            if(editarHorarioEntrada.equals("s") || editarHorarioEntrada.equals("S")) {
            	System.out.println("Digite o novo horario de entrada do veículo");
                String novoHorarioEntrada = lerStringValida();
                veiculoEncontradoAtualizacao.setHorarioEntrada(novoHorarioEntrada);
                System.out.println("Horario de entrada atualizado com sucesso!");
            }
            System.out.println("Deseja editar o horario de saída do veículo? (s/n)");
            editarHorarioSaida = lerStringValida();
            if(editarHorarioSaida.equals("s") || editarHorarioSaida.equals("S")) {
       		 	System.out.println("Digite o novo horario de saída do veículo");
                String novoHorarioSaida = lerStringValida();
                veiculoEncontradoAtualizacao.setHorarioEntrada(novoHorarioSaida);
                System.out.println("Horario de saída atualizado com sucesso!");
            }
            System.out.println("Deseja editar a data de entrada do veículo? (s/n)");
            editarDataEntrada = lerStringValida();
            if(editarDataEntrada.equals("s") || editarDataEntrada.equals("S")) {
            	System.out.println("Digite a nova data de entrada do veículo");
                String novoDataEntrada = lerStringValida();
                veiculoEncontradoAtualizacao.setDataEntrada(novoDataEntrada);
                System.out.println("Data de entrada atualizada com sucesso!");
            }
            System.out.println("Deseja editar a data de saída do veículo? (s/n)");
            editarDataSaida = lerStringValida();
            if(editarDataSaida.equals("s") || editarDataSaida.equals("S")) {
       		 	System.out.println("Digite a nova data de saída do veículo");
                String novoDataSaida = lerStringValida();
                veiculoEncontradoAtualizacao.setHorarioEntrada(novoDataSaida);
                System.out.println("Data de saída atualizado com sucesso!");
            }
            System.out.println("Deseja editar o evento do veículo? (s/n)");
            editarNomeEvento = lerStringValida();
            if(editarNomeEvento.equals("s") || editarNomeEvento.equals("S")) {
                boolean novoEventoValido = false;
       		 	while (!novoEventoValido) {
                    System.out.println("Digite o novo evento do veículo");
                    String novoEvento = lerStringValida();
                    novoEventoValido = eventoExiste(novoEvento);
                    if (!novoEventoValido){
                        System.out.println("Evento não encontrado. Insira um evento válido.");
                    }
                    else {
                        veiculoEncontradoAtualizacao.setEvento(novoEvento);                 
                        System.out.println("Evento atualizado com sucesso!");
                    }
                }
            }
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void atualizarEvento() throws DescricaoEmBrancoException, ValorAcessoInvalidoException{
        System.out.println("Digite o nome do evento que deseja atualizar");
        String nomeEvento = lerStringValida();
        Evento eventoEncontradoAtualizacao = encontrarEvento(nomeEvento);
        if (eventoEncontradoAtualizacao != null) {
            String editarNome, editarDataInicio, editarDataFim, editarHorarioInicio, editarHorarioFim, editarValor;
            System.out.println("Deseja editar o nome do evento? (s/n)");
            editarNome = lerStringValida();
            if(editarNome.equals("s") || editarNome.equals("S")) {
                System.out.println("Digite o novo nome do evento");
                String novoNome = lerStringValida();
                eventoEncontradoAtualizacao.setNome(novoNome);
                System.out.println("Nome do evento atualizado com sucesso!");
            }
            System.out.println("Deseja editar a data de início  do evento? (s/n)");
            editarDataInicio = lerStringValida();
            if(editarDataInicio.equals("s") || editarDataInicio.equals("S")) {
                System.out.println("Digite a nova data de início  do evento");
                String novaData = lerStringValida();
                eventoEncontradoAtualizacao.setDataInicio(novaData);
                System.out.println("Data do evento atualizado com sucesso!");
            }
            System.out.println("Deseja editar a data de fim do evento? (s/n)");
            editarDataFim = lerStringValida();
            if(editarDataFim.equals("s") || editarDataFim.equals("S")) {
                System.out.println("Digite a nova data de fim do evento");
                String novaData = lerStringValida();
                eventoEncontradoAtualizacao.setDataFim(novaData);
                System.out.println("Data do evento atualizado com sucesso!");
            }
            System.out.println("Deseja editar o horario de início do evento? (s/n)");
            editarHorarioInicio = lerStringValida();
            if(editarHorarioInicio.equals("s") || editarHorarioInicio.equals("S")) {
                System.out.println("Digite o novo horario de início do evento");
                String novoHorario = lerStringValida();
                eventoEncontradoAtualizacao.setHorarioInicio(novoHorario);
                System.out.println("Horario do evento atualizado com sucesso!");
            }
            System.out.println("Deseja editar o horario de fim do evento? (s/n)");
            editarHorarioFim = lerStringValida();
            if(editarHorarioFim.equals("s") || editarHorarioFim.equals("S")) {
                System.out.println("Digite o novo horario de fim do evento");
                String novoHorario = lerStringValida();
                eventoEncontradoAtualizacao.setHorarioFim(novoHorario);
                System.out.println("Horario do evento atualizado com sucesso!");
            }
            System.out.println("Deseja editar o valor do evento? (s/n)");
            editarValor = lerStringValida();
            if(editarValor.equals("s") || editarValor.equals("S")) {
                System.out.println("Digite o novo valor do evento");
                double novoValor = lerDoubleValido();
                eventoEncontradoAtualizacao.setValor(novoValor);
                System.out.println("Valor do evento atualizado com sucesso!");
            }
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

/*********************
        Exclusões
 
*********************/
    private static void excluirEstacionamento() throws DescricaoEmBrancoException{
        System.out.println("Digite o nome do estacionamento que deseja excluir:");
        String nomeEstacionamento = lerStringValida();
        Estacionamento estacionamentoEncontradoExclusao = encontrarEstacionamento(nomeEstacionamento);
        if (estacionamentoEncontradoExclusao != null) {
            estacionamentos.remove(estacionamentoEncontradoExclusao);
            System.out.println("Estacionamento excluído com sucesso!");
        } else {
            System.out.println("Estacionamento não encontrado.");
        }
    }

    private static void excluirVeiculo() throws DescricaoEmBrancoException{
        System.out.println("Digite a placa do veículo que deseja excluir:");
        String placaVeiculo = lerStringValida();
        Veiculo veiculoEncontradoExclusao = encontrarVeiculo(placaVeiculo);
        if (veiculoEncontradoExclusao != null) {
            for (Estacionamento estacionamento : estacionamentos) {
                estacionamento.getVeiculos().remove(veiculoEncontradoExclusao);
            }
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Veículo não encontrado.");
        }
    }

    private static void excluirEvento() throws DescricaoEmBrancoException{
        System.out.println("Digite o nome do evento que deseja excluir:");
        String nomeEvento = lerStringValida();
        Evento eventoEncontradoExclusao = encontrarEvento(nomeEvento);
        if (eventoEncontradoExclusao != null) {
            eventos.remove(eventoEncontradoExclusao);
            System.out.println("Evento excluído com sucesso!");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

/*********************
        Auxiliares
        
*********************/
    private static Estacionamento encontrarEstacionamento(String nomeEstacionamento) {
    	Estacionamento estacionamentoEncontradoAtualizacao = null;
        for (Estacionamento estacionamento : estacionamentos) {
            if (estacionamento.getNome().equals(nomeEstacionamento)) {
                estacionamentoEncontradoAtualizacao = estacionamento;
                break;
            }
        }
        return estacionamentoEncontradoAtualizacao;
    }

    private static Veiculo encontrarVeiculo(String placaVeiculo) {
        for (Estacionamento estacionamento : estacionamentos) {
            for (Veiculo veiculo: estacionamento.getVeiculos()){
                if (veiculo.getPlaca().equals(placaVeiculo)) {
                    return veiculo;
                }
            }
        }
        return null;
    }

    private static Evento encontrarEvento(String nomeEvento) {
    	Evento eventoEncontradoAtualizacao = null;
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nomeEvento)) {
                eventoEncontradoAtualizacao = evento;
                break;
            }
        }
        return eventoEncontradoAtualizacao;
    }

    private static boolean eventoExiste(String nomeEvento){
        for (Evento evento : eventos) {
            if (evento.getNome().equals(nomeEvento)) {
                return true;
            }
        }
        return false;
    }

    private static String lerStringValida() throws DescricaoEmBrancoException{
        String entrada = scanner.nextLine();
        if(entrada == null || entrada.trim().isEmpty()){
            throw new DescricaoEmBrancoException();
        }
        return entrada;
    }

    private static Double lerDoubleValido() throws ValorAcessoInvalidoException{
        Double entrada = scanner.nextDouble();
        scanner.nextLine();
        if(entrada<=0){
            throw new ValorAcessoInvalidoException();
        }
        return entrada;
    }

    private static int lerInteiroValido() throws ValorAcessoInvalidoException{
        int entrada = scanner.nextInt();
        scanner.nextLine();
        if(entrada<=0){
            throw new ValorAcessoInvalidoException();
        }
        return entrada;
    }

}
