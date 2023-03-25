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
        }
    }
    
    public void desligarMotor() {
        this.motorLigado = false;
        if (numeroPassageiros > 0){
            this.alturaDoVidro = AlturaDoVidro.ABERTO_APENAS_UMA_FRESTA;
        }
    }

    public boolean isMotorLigado() {
        return this.motorLigado;
    }

    public void abrirPortas() {
        if (!motorLigado){
        this.portasAbertas = true;
        }
    }

    public void fecharPortas() {
        this.portasAbertas = false;
    }

    public boolean isPortasAbertas() {
        return this.portasAbertas;
    }

    public void ativarAlarme() {
        if(!motorLigado && numeroPassageiros == 0){
        this.alarmeAtivado = true;
        if(numeroPassageiros == 0) {
            this.alturaDoVidro = AlturaDoVidro.FECHADO;
        }
        if(isRadioLigado()) {
            this.radioLigado = false;
        }
        }
    }

    public void desativarAlarme() {
        this.alarmeAtivado = false;
    }

    public boolean isAlarmeAtivado() {
        return this.alarmeAtivado;
    }

    public void engatarMarcha(Marcha marcha) {
        if (!portasAbertas) {
            if (marcha != Marcha.RE) {
                if (velocidade >= 0) {
                    this.marchaEngatada = marcha;
                } else {
                    this.marchaEngatada = Marcha.RE;
                }
            } else {
                this.marchaEngatada = Marcha.RE;
            }
        }
    }

    public void desengatarMarcha() {
        this.marchaEngatada = null;
    }

    public Marcha marchaEngatada() {
        return this.marchaEngatada;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public void acelerar(double kilometrosHora) {
        if (this.marchaEngatada == Marcha.RE) {
            this.velocidade -= kilometrosHora;
        } else {
        this.velocidade += kilometrosHora;
        }
    }

    public void colocaPassageiros(int quantidade) {
        if (this.numeroPassageiros + quantidade <= this.numeroMaximoDePassageiros){
            this.numeroPassageiros += quantidade;
        } else {
            System.out.println("Nao ha mais lugares disponiveis no carro");
        }
    }

    public void removePassageiros(int quantidade) {
        if (this.numeroPassageiros - quantidade >= 0){
            this.numeroPassageiros -= quantidade;
        } else {
            System.out.println("Nao existe essa quantidade de pessoas no carro");
        }
    }
    
    public int getNumeroPassageiros() {
        return this.numeroPassageiros;
    }

    public void setNumeroMaximoDePassageiros(int numeroMaximoDePassageiros) {
        this.numeroMaximoDePassageiros = numeroMaximoDePassageiros;
    }

    public int getNumeroMaximoDePassageiros() {
        return this.numeroMaximoDePassageiros;
    }

    public void ligarRadio() {
        this.radioLigado = true;
    }

    public void desligarRadio() {
        this.radioLigado = false;
    }

    public boolean isRadioLigado() {
        return this.radioLigado;
    }

    public void setAlturaDoVidro(AlturaDoVidro alturaDoVidro) {
        this.alturaDoVidro = alturaDoVidro;
    }

    public AlturaDoVidro getAlturaDoVidro() {
        return this.alturaDoVidro;
    }

    public void colocaCinto(int quantidadePassageiros) {
        if (this.numeroPassageiros >= quantidadePassageiros) {
            this.quantidadePassageirosComCinto += quantidadePassageiros;
        } else {
            System.out.println("Nao existe essa quantidade de passageiros no carro.");
        }
    }

    public void removeCinto(int quantidadePassageiros) {
        if (this.quantidadePassageirosComCinto >= quantidadePassageiros) {
            this.quantidadePassageirosComCinto -= quantidadePassageiros;
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
        }
    }

    public void fecharPortaMalas() {
        this.portaMalaAberto = false;
    }

    public boolean isPortaMalasAberto() {
        return this.portaMalaAberto;
    }

    public void adicionarBagagem(double pesoDaBagagem) {
        if (this.pesoBagagem + pesoDaBagagem <= this.limiteDePesoDaBagagem){
            this.pesoBagagem += pesoDaBagagem;
        } else {
            System.out.println("Peso maximo excedido de bagagem");
        }
    }

    public void removerBagagem(double pesoDaBagagem) {
        if (this.pesoBagagem - pesoDaBagagem >= 0){
            this.pesoBagagem -= pesoDaBagagem;
        } else {
            System.out.println("Nao ha mais bagagem no carro");
        }
    }

    public double pesoDaBagagem() {
        return this.pesoBagagem;
    }

    public void setLimiteDePesoDaBagagem(double limiteDePesoDaBagagem) {
        this.limiteDePesoDaBagagem = limiteDePesoDaBagagem;
    }

    public double getLimiteDePesoDaBagagem() {
        return this.limiteDePesoDaBagagem;
    }

    public void pararCarro() {
        this.velocidade = 0;
    }
}