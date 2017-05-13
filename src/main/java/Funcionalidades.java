import java.util.Scanner;

public class Funcionalidades {
    Scanner scan = new Scanner(System.in);

    public void addEmpregado(Base base){
        System.out.println("Insira o nome do empregado: ");
        String nome = scan.nextLine();
        System.out.println("Insira o endereço: ");
        String endereco = scan.nextLine();
        System.out.println("Insira a matricula: ");
        int matricula = Integer.parseInt(scan.nextLine());
        System.out.println("Insira o tipo do funcionário\n"+
                            "1 - Horista\n"+
                            "2 - Assalariado\n"+
                            "3 - Comissionado");
        int tipo_funcionario = Integer.parseInt(scan.nextLine());
        System.out.println("Insira o tipo de pagamento\n"+
                            "1 - cheque pelos correios\n"+
                            "2 - cheque em mãos\n"+
                            "3 - depósito bancário");
        int tipo_pagamento = Integer.parseInt(scan.nextLine());

        Empregado empregado = new Empregado();
        empregado.setNome(nome);
        empregado.setEndereco(endereco);
        empregado.setMatricula(matricula);
        empregado.setId_funcionario(true);
        empregado.setTipo_funcionario(tipo_funcionario);
        empregado.setTipo_pagamento(tipo_pagamento);

        if (tipo_funcionario == 1){
            empregado.addDiaPagamento(5);
            empregado.addDiaPagamento(12);
            empregado.addDiaPagamento(19);
            empregado.addDiaPagamento(26);
        }
        else if (tipo_funcionario == 2){
            empregado.addDiaPagamento(30);
            System.out.println("Insira o salário do funcionário assalariado");
            int salario = Integer.parseInt(scan.nextLine());
            empregado.setSalario(salario);
        }else if(tipo_funcionario ==3){
            empregado.addDiaPagamento(15);
            empregado.addDiaPagamento(30);
            System.out.println("Insira o salario base quinzenal do comissionado");
            int salario = Integer.parseInt(scan.nextLine());
            empregado.setSalario(salario);
        }
        base.todos_empregados.add(empregado);

    }

    public void removerEmpregado(Base base){
        System.out.println("Insira a matrícula do funcionário a ser removido");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < base.todos_empregados.size(); i++){
            if (base.todos_empregados.get(i).getMatricula() == matricula){
                base.todos_empregados.get(i).setId_funcionario(false);
                System.out.println("Funcionário removido");
            }else {
                count++;
            }
        }
        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void editarEmpregado(Base base){
        System.out.println("Insira a matrícula do funcionário a ser editado");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < base.todos_empregados.size(); i++){
            if (base.todos_empregados.get(i).isId_funcionario() ==true){
                if (base.todos_empregados.get(i).getMatricula() == matricula){
                    System.out.println("O que deseja ser editado:"+
                                        "1 - Nome\n"+
                                        "2 - Endereço\n"+
                                        "3 - Tipo do funcionário\n"+
                                        "4 - Tipo de pagamento");
                    int opcao = Integer.parseInt(scan.nextLine());

                    if (opcao == 1){
                        System.out.println("Insira o nome do empregado: ");
                        String nome = scan.nextLine();
                        base.todos_empregados.get(i).setNome(nome);
                    }else if(opcao == 2){
                        System.out.println("Insira o endereço: ");
                        String endereco = scan.nextLine();
                        base.todos_empregados.get(i).setEndereco(endereco);
                    }else if (opcao ==3) {
                        System.out.println("Insira o tipo do funcionário" +
                                "1 - Horista\n" +
                                "2 - Assalariado\n" +
                                "3 - Comissionado");
                        int tipo_funcionario = Integer.parseInt(scan.nextLine());
                        if (tipo_funcionario == 1){
                            base.todos_empregados.get(i).addDiaPagamento(5);
                            base.todos_empregados.get(i).addDiaPagamento(12);
                            base.todos_empregados.get(i).addDiaPagamento(19);
                            base.todos_empregados.get(i).addDiaPagamento(26);
                        }
                        else if (tipo_funcionario == 2){
                            base.todos_empregados.get(i).addDiaPagamento(30);
                            System.out.println("Insira o salário do funcionário assalariado");
                            int salario = Integer.parseInt(scan.nextLine());
                            base.todos_empregados.get(i).setSalario(salario);
                        }else if(tipo_funcionario ==3){
                            base.todos_empregados.get(i).addDiaPagamento(15);
                            base.todos_empregados.get(i).addDiaPagamento(30);
                            System.out.println("Insira o salario base quinzenal do comissionado");
                            int salario = Integer.parseInt(scan.nextLine());
                            base.todos_empregados.get(i).setSalario(salario);
                        }
                        base.todos_empregados.get(i).setTipo_funcionario(tipo_funcionario);
                    }else if(opcao ==4) {
                        System.out.println("Insira o tipo de pagamento" +
                                "1 - cheque pelos correios" +
                                "2 - cheque em mãos" +
                                "3 - depósito bancário");
                        int tipo_pagamento = Integer.parseInt(scan.nextLine());
                        base.todos_empregados.get(i).setTipo_pagamento(tipo_pagamento);
                    }
                }else {
                    count++;
                }
            }
        }

        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void undoRedo(Base base){
        System.out.println("Insira a matrícula do funcionário a ser inserido novamente no sistema");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;
        for (int i = 0; i < base.todos_empregados.size(); i++){
            if (base.todos_empregados.get(i).getMatricula() == matricula){
                base.todos_empregados.get(i).setId_funcionario(true);
                System.out.println("Funcionário readmitido");
            }else{
                count++;
            }
        }

        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não encontrado");
        }
    }

    public void lancarPonto(Base base) {
        System.out.println("Insira a matrícula do Empregado");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;
        for (int i = 0; i < base.todos_empregados.size(); i++) {
            if (base.todos_empregados.get(i).isId_funcionario() == true) {
                if (base.todos_empregados.get(i).getMatricula() == matricula) {
                    if (base.todos_empregados.get(i).getTipo_funcionario() == 1) {
                        base.todos_empregados.get(i).ponto.addPonto();
                    }else{
                        System.out.println("Apenas horistas cadastram cartão de ponto");
                    }
                }else {
                    count++;
                }
            }
        }
        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void pagarEmpregado(Base base){
        System.out.println("Insira a matrícula do Empregado");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < base.todos_empregados.size(); i++) {
            if (base.todos_empregados.get(i).isId_funcionario() == true) {
                if (base.todos_empregados.get(i).getMatricula() == matricula) {
                    if (base.todos_empregados.get(i).getTipo_funcionario() == 1){
                        System.out.println("Insira o dia do pagamento:");
                        int dia = Integer.parseInt(scan.nextLine());
                        System.out.println("Insira o valor da hora do empregado");
                        int valor_hora = Integer.parseInt(scan.nextLine());
                        pagarHorista(base.todos_empregados.get(i), dia, valor_hora);
                    }else if (base.todos_empregados.get(i).getTipo_funcionario() == 2){
                        pagarAssalariado(base.todos_empregados.get(i));
                    }else if (base.todos_empregados.get(i).getTipo_funcionario() == 3){
                        pagarComissionado(base.todos_empregados.get(i));
                    }
                }else{
                    count++;
                }
            }
        }

        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void pagarHorista(Empregado empregado, int dia, int valor_hora){
        float valor;
        float pagamento = 0;
        int valor_dia = 0;
        if (dia == 5) {
            for (int i = 1; i <= 5; i++) {
                valor_dia = empregado.ponto.getPonto(i);
                valor = (float) valor_dia;
                valor = valor / 60;// de minutos para horas;
                if (valor > 8){
                    pagamento += (8 * valor_hora); // horas
                    pagamento += (1.5 * valor_hora)* (valor %8); // horas extra
                }else{
                    pagamento += (valor * valor_hora);
                }
            }
            pagamento = pagamento - empregado.getDescontos();
            if (empregado.getTipo_pagamento() == 1){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque pelos correios");
            }else if (empregado.getTipo_pagamento() == 2){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque em mãos");
            }else  if (empregado.getTipo_pagamento() == 3){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em depósito bancário");
            }

        }else if (dia == 12){
            for (int i = 6; i <= 12; i++) {
                valor_dia = empregado.ponto.getPonto(i);
                valor = (float) valor_dia;
                valor = valor / 60;// de minutos para horas;
                if (valor > 8){
                    pagamento += (8 * valor_hora); // horas
                    pagamento += (1.5 * valor_hora) *(valor %8); // horas extra
                }else{
                    pagamento += (valor * valor_hora);
                }
            }
            pagamento = pagamento - empregado.getDescontos();
            if (empregado.getTipo_pagamento() == 1){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque pelos correios");
            }else if (empregado.getTipo_pagamento() == 2){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque em mãos");
            }else  if (empregado.getTipo_pagamento() == 3){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em depósito bancário");
            }
        }else if (dia == 19){
            for (int i = 13; i <= 19; i++) {
                valor_dia = empregado.ponto.getPonto(i);
                valor = (float) valor_dia;
                valor = valor / 60;// de minutos para horas;
                if (valor > 8){
                    pagamento += (8 * valor_hora); // horas
                    pagamento += (1.5 * valor_hora)*(valor %8); // horas extra
                }else{
                    pagamento += (valor * valor_hora);
                }
            }
            pagamento = pagamento - empregado.getDescontos();
            if (empregado.getTipo_pagamento() == 1){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque pelos correios");
            }else if (empregado.getTipo_pagamento() == 2){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque em mãos");
            }else  if (empregado.getTipo_pagamento() == 3){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em depósito bancário");
            }
        }else if (dia == 26){
            for (int i = 20; i <= 26; i++) {
                valor_dia = empregado.ponto.getPonto(i);
                valor = (float) valor_dia;
                valor = valor / 60;// de minutos para horas;
                if (valor > 8){
                    pagamento += (8 * valor_hora); // horas
                    pagamento += (1.5 * valor_hora)*(valor %8); // horas extra
                }else{
                    pagamento += (valor * valor_hora);
                }
            }
            pagamento = pagamento - empregado.getDescontos();
            if (empregado.getTipo_pagamento() == 1){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque pelos correios");
            }else if (empregado.getTipo_pagamento() == 2){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em um cheque em mãos");
            }else  if (empregado.getTipo_pagamento() == 3){
                System.out.println("O funcionário " + empregado.getNome() + " rebebeu R$: " + pagamento + " em depósito bancário");
            }
        }else{
            System.out.println("O empregado não pode receber esse dia");
        }

    }

    public void pagarAssalariado(Empregado empregado){
        int salario = empregado.getSalario() - empregado.getDescontos();
        if (empregado.getTipo_pagamento() == 1) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em um cheque pelos correios");
        }else if (empregado.getTipo_pagamento() == 2) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em um cheque em mãos");
        }else if (empregado.getTipo_pagamento() == 3) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em depósito bancário");
        }
    }

    public void pagarComissionado(Empregado empregado){
        int salario = empregado.getSalario() - empregado.getDescontos();
        if (empregado.getTipo_pagamento() == 1) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em um cheque pelos correios");
        }else if (empregado.getTipo_pagamento() == 2) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em um cheque em mãos");
        }else if (empregado.getTipo_pagamento() == 3) {
            System.out.println("O empregado " + empregado.getNome() + "recebeu R$ " + salario + " em depósito bancário");
        }
    }

    public void addComissão(Base base) {
        System.out.println("Insira a matrícula do Empregado");
        int matricula = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < base.todos_empregados.size(); i++) {
            if (base.todos_empregados.get(i).isId_funcionario() == true) {
                if (base.todos_empregados.get(i).getMatricula() == matricula) {
                    if (base.todos_empregados.get(i).getTipo_funcionario() == 3) {
                        System.out.println("Insira o valor da venda ");
                        int venda = Integer.parseInt(scan.nextLine());
                        System.out.println("Insira a porcentagem da comissão no formato inteiro sem o %");
                        int comissao = Integer.parseInt(scan.nextLine());
                        comissao = (venda * comissao) / 100;
                        int novo_salario = base.todos_empregados.get(i).getSalario() + comissao;
                        base.todos_empregados.get(i).setSalario(novo_salario);
                    }else {
                        System.out.println("Apenas empregados comissionados podem ter comissão");
                    }
                }else {
                    count++;
                }
            }
        }

        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void sindicato(Base base){
        System.out.println("1 - Adicionar empregado ao sindicato\n"+
                            "2 - Alterar taxa sindical"+
                            "3 - Remover empregado do sindicato");

        int opcao = Integer.parseInt(scan.nextLine());
        int count = 0;

        System.out.println("Insira a matrícula do Empregado");
        int matricula = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < base.todos_empregados.size(); i++) {
            if (base.todos_empregados.get(i).isId_funcionario() == true) {
                if (base.todos_empregados.get(i).getMatricula() == matricula) {
                    if (opcao == 1){
                        base.todos_empregados.get(i).sindicato = true;
                        taxaSindicato(base.todos_empregados.get(i));
                    }else if (opcao == 2){
                        if (base.todos_empregados.get(i).sindicato == true) {
                            taxaSindicato(base.todos_empregados.get(i));
                        }else {
                            System.out.println("Empregado não faz parte do sindicato");
                        }
                    }else if (opcao == 3){
                        base.todos_empregados.get(i).sindicato = false;
                    }
                }else {
                    count++;
                }
            }
        }

        if (count == base.todos_empregados.size()){
            System.out.println("Empregado não cadastrado");
        }
    }

    public void taxaSindicato(Empregado empregado){
        System.out.println("Insira o valor da taxa sindical");
        int taxa_sindical = Integer.parseInt(scan.nextLine());
        empregado.setDescontos(taxa_sindical);
    }

    public void rodarFolha(Base base){
        int dia;
        System.out.println("Insira o dia desejado: ");
        dia = Integer.parseInt(scan.nextLine());

        System.out.println("Funcionários que recebem no dia "+ dia+ ":");
        for(int i = 0; i < base.todos_empregados.size(); i++){
            if (base.todos_empregados.get(i).isId_funcionario() == true) {
                if (base.todos_empregados.get(i).verDiaPagamento(dia) == true) {
                    System.out.println("Nome: " + base.todos_empregados.get(i).getNome());
                }
            }
        }
    }



}


