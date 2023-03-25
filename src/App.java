public class App {
    public static void main(String[] args) throws Exception {
        Carro meuCarro = new Carro();

        System.out.println("\nO carro atualmente esta nas seguintes condicoes:\n");

        if (meuCarro.isAlarmeAtivado()) {
            System.out.println("Alarme: ativado");
        } else {
            System.out.println("Alarme: desativado");
        }

        if (meuCarro.isPortasAbertas()) {
            System.out.println("Portas: abertas");
        } else {
            System.out.println("Portas: fechadas");
        }
        
        if (meuCarro.isMotorLigado()) {
            System.out.println("Motor: ligado");
        } else {
            System.out.println("Motor: desligado");
        }

        System.out.println("Velocidade: " + meuCarro.getVelocidade() + " km/h");

        if (meuCarro.isPortaMalasAberto()) {
            System.out.println("Porta-malas: aberto");
        } else {
            System.out.println("Porta-malas: fechado");
        }

        System.out.println("Peso das bagagens: " + meuCarro.pesoDaBagagem() + " kg");
        System.out.println("Peso limite das bagagens: " + meuCarro.getLimiteDePesoDaBagagem() + " kg");
        System.out.println("Passageiros: " + meuCarro.getNumeroPassageiros());
        System.out.println("Passageiros com cinto: " + meuCarro.getNumeroPassageirosComCinto());
        System.out.println("Limite de passageiros: " + meuCarro.getNumeroMaximoDePassageiros());

        if (meuCarro.marchaEngatada() != null) {
            if (meuCarro.marchaEngatada() == Marcha.PRIMEIRA) {System.out.println("Marcha: PRIMEIRA");}
            if (meuCarro.marchaEngatada() == Marcha.SEGUNDA) {System.out.println("Marcha: SEGUNDA");}
            if (meuCarro.marchaEngatada() == Marcha.TERCEIRA) {System.out.println("Marcha: TERCEIRA");}
            if (meuCarro.marchaEngatada() == Marcha.QUARTA) {System.out.println("Marcha: QUARTA");}
            if (meuCarro.marchaEngatada() == Marcha.QUINTA) {System.out.println("Marcha: QUINTA");}
            if (meuCarro.marchaEngatada() == Marcha.RE) {System.out.println("Marcha: RE");}
        } else {
            System.out.println("Marcha: desengatada");
        }

        if (meuCarro.isRadioLigado()) {
            System.out.println("Radio: ligado");
        } else {
            System.out.println("Radio: desligado");
        }

        System.out.println("Altura do vidro: " + meuCarro.getAlturaDoVidro());
    }
}
