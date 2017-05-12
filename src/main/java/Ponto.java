import java.util.Scanner;

public class Ponto {
    Scanner scan = new Scanner(System.in);
    int opcao, hora, minuto, total;
    private int hora_entrada=0;
    private int hora_saida;
    private int horas_trabalhadas;
    private int dia_entrada;
    private int dia_saida;

    public String getPonto(int dia) {
        return ponto[dia];
    }


    private String[] ponto = new String[30];


    public void addPonto(){
        System.out.println("Escolha a opção desejada: \n"+
                            "1 - hora entrada \n"+
                            "2 - hora saída");

        opcao = Integer.parseInt(scan.nextLine());

        if (opcao == 1){
            System.out.println("Insira o dia ");
            dia_entrada = Integer.parseInt(scan.nextLine());
            System.out.println("Insira a hora entrada e depois os minutos");
            hora = Integer.parseInt(scan.nextLine());
            minuto = Integer.parseInt(scan.nextLine());
            total = (hora*60) + minuto;
            hora_entrada = total;
        }else if(opcao ==2){
            System.out.println("Insira o dia ");
            dia_saida = Integer.parseInt(scan.nextLine());
            System.out.println("Insira a hora entrada e depois os minutos");
            hora = Integer.parseInt(scan.nextLine());
            minuto = Integer.parseInt(scan.nextLine());
            total = (hora*60) + minuto;
            hora_saida = total;
        }

        if (dia_entrada == dia_saida){
            horas_trabalhadas = hora_saida - hora_entrada;
            String horas = Integer.toString(horas_trabalhadas);
            ponto[dia_entrada] = horas;
        }else{
            int ponto_entrada = (24*60) - hora_entrada;
            String hora_entrada = Integer.toString(ponto_entrada);
            ponto[dia_entrada] = hora_entrada;
            int ponto_saida = hora_saida;
            String hora_saida = Integer.toString(ponto_saida);
            ponto[dia_saida] = hora_saida;
        }
    }
}
