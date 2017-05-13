import java.util.Scanner;

public class Ponto {
    Scanner scan = new Scanner(System.in);
    int opcao, hora, minuto, total;
    private int hora_entrada=0;
    private int hora_saida;
    private int horas_trabalhadas;
    private int dia;

    public Ponto() {
        for (int i = 0; i < 30; i++){
            ponto[i]=0;
        }
    }

    public Integer getPonto(int dia) {
        return ponto[dia];
    }


    private Integer[] ponto = new Integer[30];




    public void addPonto(){
        System.out.println("Insira o dia");
        dia = Integer.parseInt(scan.nextLine());
        System.out.println("Hora entrada: ");

        System.out.println("Insira a hora entrada e depois os minutos");
        hora = Integer.parseInt(scan.nextLine());
        minuto = Integer.parseInt(scan.nextLine());
        total = (hora*60) + minuto;
        hora_entrada = total;

        System.out.println("Hora saída: ");
        System.out.println("Insira a hora entrada e depois os minutos");
        hora = Integer.parseInt(scan.nextLine());
        minuto = Integer.parseInt(scan.nextLine());
        total = (hora*60) + minuto;
        hora_saida = total;


        horas_trabalhadas = hora_saida - hora_entrada;
        ponto[dia] = horas_trabalhadas;
    }

}

