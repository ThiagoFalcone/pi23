package kanban;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Acao {
    String nome;
    String descricao;
    String dataInicio;
    String dataTermino;
    String areaResponsavel;
    String usuarioResponsavel;
    int percentConclusao;
    StatusAcao status;
    Tarefa tarefaAssociada; // Adicionando a referência a Tarefa

    public enum StatusAcao {
        NAO_INICIADA,
        EM_ANDAMENTO,
        CONCLUIDA
    }

    private Tarefa tarefa; // Adicione a declaração da variável tarefa

    public Acao(String nome, String descricao, String dataInicio, String dataTermino,
                String areaResponsavel, String usuarioResponsavel, int percentConclusao, StatusAcao status, Tarefa tarefa) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.areaResponsavel = areaResponsavel;
        this.usuarioResponsavel = usuarioResponsavel;
        this.percentConclusao = percentConclusao;
        this.status = status;
        this.tarefa = tarefa; // Corrigindo para associar a tarefa corretamente
    }
    public boolean podeSerEditadaPorUsuario(Usuario usuario) {
    // Lógica de permissão para editar a ação (pode ser ajustada conforme necessário)
    return true;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public String getAreaResponsavel() {
        return areaResponsavel;
    }

    public String getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    public int getPercentConclusao() {
        return percentConclusao;
    }

    public StatusAcao getStatus() {
        return status;
    }

    public void setPercentConclusao(int novaPorcentagem) {
        this.percentConclusao = novaPorcentagem;

        // Atualizar a porcentagem da tarefa associada, se houver
        if (tarefa != null) {
            tarefa.calcularPercentConclusao();
        }
    }

    public void setStatus(StatusAcao novoStatus) {
        this.status = novoStatus;

        // Atualizar o status da tarefa associada, se houver
        if (tarefa != null) {
            tarefa.calcularStatusTarefa();
        }
    }

    // Adicionar um método para associar a ação a uma tarefa
    public void associarTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public void setConcluida(boolean concluida) {
        if (concluida) {
            this.status = StatusAcao.CONCLUIDA;
        } else {
            this.status = StatusAcao.NAO_INICIADA;
        }
    }
}