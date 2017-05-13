import java.util.ArrayList;

public class Empregado {
    private String nome;
    private String endereco;
    private int matricula;
    private boolean id_funcionario; //usado para undo e redo
    private int tipo_funcionario; // 1 - horistas, 2 - assalariado, 3 - comissionado
    private int tipo_pagamento; //1 - cheque pelos correios, 2 - cheque em mãos, 3 - depósito
    private int salario;
    private double comissao = 0;
    private int descontos = 0;
    boolean sindicato = false;
    private int hora_entrada=0;
    private int hora_saida;
    private ArrayList<Integer> dias_receber = new ArrayList<Integer>();


    public int getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(int hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public int getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(int hora_saida) {
        this.hora_saida = hora_saida;
    }



    public Ponto ponto = new Ponto();

    public void addDiaPagamento(int dia){
        dias_receber.add(dia);
    }

    public boolean verDiaPagamento(int dia){
        if (dias_receber.contains(dia)){
            return true;
        }else{
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(boolean id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getTipo_funcionario() {
        return tipo_funcionario;
    }

    public void setTipo_funcionario(int tipo_funcionario) {
        this.tipo_funcionario = tipo_funcionario;
    }

    public int getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(int tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public int getDescontos() {
        return descontos;
    }

    public void setDescontos(int descontos) {
        this.descontos = descontos;
    }

}
