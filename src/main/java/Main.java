import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Funcionalidades funcionalidades = new Funcionalidades();
        Base base = new Base();
        boolean flag = true;

        while (flag) {
            System.out.println("---------- Folha de Pagamento ----------");
            System.out.println("1 - Adcionar Empregado\n" +
                    "2 - Remover empregado\n" +
                    "3 - Lançar Cartão de Ponto\n" +
                    "4 - Lançar Resultado de Venda\n" +
                    "5 - Sindicato\n" +
                    "6 - Editar empregado\n" +
                    "7 - Rodar folha\n" +
                    "8 - Readmitir funcionário (Undo/Redo)\n" +
                    "9 - Pagar Empregado\n" +
                    "0 - Sair");

            int opcao = Integer.parseInt(scan.nextLine());

            if (opcao == 1) {
                funcionalidades.addEmpregado(base);
            } else if (opcao == 2) {
                funcionalidades.removerEmpregado(base);
            } else if (opcao == 3) {
                funcionalidades.lancarPonto(base);
            } else if (opcao == 4) {
                funcionalidades.addComissão(base);
            } else if (opcao == 5) {
                funcionalidades.sindicato(base);
            } else if (opcao == 6) {
                funcionalidades.editarEmpregado(base);
            } else if (opcao == 7) {
                funcionalidades.rodarFolha(base);
            } else if (opcao == 8) {
                funcionalidades.undoRedo(base);
            } else if (opcao == 9) {
                funcionalidades.pagarEmpregado(base);
            } else if (opcao == 0) {
                flag = false;
            }
        }
    }
}
