public class Carro implements CarroInteligente {
    private boolean motorLigado = false;
    private boolean portasAbertas = false;
    private boolean alarmeAtivado = false;
    private Marcha marchaEngatada = null;
    private double velocidade = 0;
    private int numeroPassageiros = 0;
    private int numeroMaximoDePassageiros = 5;
    private int quantidadePassageirosComCinto = 0;
    private double pesoBagagem = 0;
    private double limiteDePesoDaBagagem = 100;
    private boolean radioLigado = false;
    private AlturaDoVidro alturaDoVidro = AlturaDoVidro.FECHADO;
    private boolean portaMalaAberto = false;

    public void ligarMotor() {
        if (numeroPassageiros == quantidadePassageirosComCinto && !portasAbertas && numeroPassageiros <= numeroMaximoDePassageiros && pesoBagagem <= limiteDePesoDaBagagem && !portaMalaAberto) {
        this.motorLigado = true;
        System.out.println("Motor ligado com sucesso.");
        } else {
            System.out.println("Nao foi possivel ligar o motor.");
        }
    }
    
    public void desligarMotor() {
        this.motorLigado = false;
        if (numeroPassageiros > 0){
            this.alturaDoVidro = AlturaDoVidro.ABERTO_APENAS_UMA_FRESTA;
            System.out.println("Motor desligado com sucesso. | ATENCAO: Os vidros foram mantidos abertos com apenas uma fresta pois ha passageiros no carro!");
        } else {
            System.out.println("Motor desligado com sucesso.");
        }
    }

    public boolean isMotorLigado() {
        return this.motorLigado;
    }

    public void abrirPortas() {
        if (!motorLigado){
        this.portasAbertas = true;
        System.out.println("Portas abertas com sucesso.");
        } else {
            System.out.println("Nao foi possivel abrir as portas.");
        }
    }

    public void fecharPortas() {
        this.portasAbertas = false;
        System.out.println("Portas fechadas com sucesso.");
    }

    public boolean isPortasAbertas() {
        return this.portasAbertas;
    }

    public void ativarAlarme() {
        if(!motorLigado && numeroPassageiros == 0){
            this.alarmeAtivado = true;
            if(numeroPassageiros == 0) {
                this.alturaDoVidro = AlturaDoVidro.FECHADO;
                System.out.println("Alarme ativado com sucesso e o vidro foi fechado automaticamente.");
            } else {
                if(isRadioLigado()) {
                    this.radioLigado = false;
                    System.out.println("Alarme ativado com sucesso e o radio foi desligado automaticamente.");
                } else {
                    System.out.println("Alarme ativado com sucesso.");
                }
            }
        } else {
            System.out.println("Nao foi possivel ativar o alarme.");
        }
    }

    public void desativarAlarme() {
        this.alarmeAtivado = false;
        System.out.println("Alarme desativado com sucesso.");
    }

    public boolean isAlarmeAtivado() {
        return this.alarmeAtivado;
    }

    public void engatarMarcha(Marcha marcha) {
        if (!portasAbertas) {
            if (marcha != Marcha.RE) {
                if (this.velocidade >= 0) {
                    this.marchaEngatada = marcha;
                    System.out.println("Marcha " + this.marchaEngatada + " engatada com sucesso.");
                } else {
                    System.out.println("Nao foi possivel engatar a marcha selecionada.");
                }
            } else {
                if (this.velocidade > 0) {
                    System.out.println("Nao foi possivel engatar a marcha RE.");
                } else {
                    this.marchaEngatada = Marcha.RE;
                    System.out.println("Marcha RE engatada com sucesso.");
                }
            }
        } else {
            System.out.println("Nao foi possivel engatar nenhuma marcha.");
        }
    }

    public void desengatarMarcha() {
        this.marchaEngatada = null;
        System.out.println("Marcha desengatada com sucesso.");
    }

    public Marcha marchaEngatada() {
        return this.marchaEngatada;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public void acelerar(double kilometrosHora) {
        if (this.marchaEngatada == Marcha.RE) {
            if (this.velocidade > 0) {
                this.velocidade = kilometrosHora * (-1);
            } else {
                this.velocidade -= kilometrosHora;
            } 
            System.out.println("Voce acelerou ate "+ this.velocidade +" km/h com sucesso.");
        } else {
        this.velocidade += kilometrosHora;
        System.out.println("Voce acelerou ate "+ this.velocidade +" km/h com sucesso.");
        }
    }

    public void colocaPassageiros(int quantidade) {
        if (this.numeroPassageiros + quantidade <= this.numeroMaximoDePassageiros){
            this.numeroPassageiros += quantidade;
            System.out.println("Colocado "+ this.numeroPassageiros +" passageiros no carro com sucesso.");
        } else {
            System.out.println("Nao ha mais lugares disponiveis no carro");
        }
    }

    public void removePassageiros(int quantidade) {
        if (this.numeroPassageiros - quantidade >= 0){
            this.numeroPassageiros -= quantidade;
            System.out.println("Removido "+ this.numeroPassageiros +" passageiros no carro com sucesso.");
        } else {
            System.out.println("Nao existe essa quantidade de passageiros no carro");
        }
    }
    
    public int getNumeroPassageiros() {
        return this.numeroPassageiros;
    }

    public void setNumeroMaximoDePassageiros(int numeroMaximoDePassageiros) {
        this.numeroMaximoDePassageiros = numeroMaximoDePassageiros;
        System.out.println("Definido o numero maximo de passageiros no carro com sucesso: " + this.numeroMaximoDePassageiros + " passageiros.");
    }

    public int getNumeroMaximoDePassageiros() {
        return this.numeroMaximoDePassageiros;
    }

    public void ligarRadio() {
        this.radioLigado = true;
        System.out.println("Radio ligado com sucesso.");
    }

    public void desligarRadio() {
        this.radioLigado = false;
        System.out.println("Radio desligado com sucesso.");
    }

    public boolean isRadioLigado() {
        return this.radioLigado;
    }

    public void setAlturaDoVidro(AlturaDoVidro alturaDoVidro) {
        this.alturaDoVidro = alturaDoVidro;
        System.out.println("Definido a altura do vidro com sucesso: " + this.alturaDoVidro);
    }

    public AlturaDoVidro getAlturaDoVidro() {
        return this.alturaDoVidro;
    }

    public void colocaCinto(int quantidadePassageiros) {
        if (this.numeroPassageiros >= quantidadePassageiros) {
            this.quantidadePassageirosComCinto += quantidadePassageiros;
            System.out.println("Adicionado o cinto de seguranca em " + quantidadePassageiros + " passageiros.");
        } else {
            System.out.println("Nao existe essa quantidade de passageiros no carro.");
        }
    }

    public void removeCinto(int quantidadePassageiros) {
        if (this.quantidadePassageirosComCinto >= quantidadePassageiros) {
            this.quantidadePassageirosComCinto -= quantidadePassageiros;
            System.out.println("Removido o cinto de seguranca de " + quantidadePassageiros + " passageiros.");
        } else {
            System.out.println("Nao existe essa quantidade de passageiros com cinto no carro.");
        }
    }

    public int getNumeroPassageirosComCinto() {
        return this.quantidadePassageirosComCinto;
    }

    public void abrirPortaMalas() {
        if (velocidade == 0 && !motorLigado) {
        this.portaMalaAberto = true;
        System.out.println("Porta malas aberto com sucesso.");
        } else {
            System.out.println("Nao foi possivel abrir o Porta-malas");
        }
    }

    public void fecharPortaMalas() {
        this.portaMalaAberto = false;
        System.out.println("Porta malas fechado com sucesso.");
    }

    public boolean isPortaMalasAberto() {
        return this.portaMalaAberto;
    }

    public void adicionarBagagem(double pesoDaBagagem) {
        if (this.pesoBagagem + pesoDaBagagem <= this.limiteDePesoDaBagagem){
            this.pesoBagagem += pesoDaBagagem;
            System.out.println("Adicionado " + pesoDaBagagem + " kg de bagagem com sucesso.");
        } else {
            System.out.println("Peso maximo excedido de bagagem");
        }
    }

    public void removerBagagem(double pesoDaBagagem) {
        if (this.pesoBagagem - pesoDaBagagem >= 0){
            this.pesoBagagem -= pesoDaBagagem;
            System.out.println("Removido " + pesoDaBagagem + " kg de bagagem com sucesso.");
        } else {
            System.out.println("Nao ha mais bagagem no carro");
        }
    }

    public double pesoDaBagagem() {
        return this.pesoBagagem;
    }

    public void setLimiteDePesoDaBagagem(double limiteDePesoDaBagagem) {
        this.limiteDePesoDaBagagem = limiteDePesoDaBagagem;
        System.out.println("Definido o novo limite de peso da bagagem com sucesso:  " + this.limiteDePesoDaBagagem + " kg.");
    }

    public double getLimiteDePesoDaBagagem() {
        return this.limiteDePesoDaBagagem;
    }

    public void pararCarro() {
        this.velocidade = 0;
        System.out.println("O carro foi parado com sucesso.");
    }
}