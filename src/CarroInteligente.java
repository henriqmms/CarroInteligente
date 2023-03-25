/* Copyright Marcos Henrique Fedato 2015
 * Uso restrito com autoriza��o do autor
 */
public interface CarroInteligente 
{
	
	
	/**
	 * Liga o motor do carro
	 */
	void ligarMotor();
	
	/**
	 * Desliga o motor do carro
	 */
	void desligarMotor();
	
	/**
	 * Verifica se o motor est� ligado
	 * @return True se o motor estiver ligado e False se estiver desligado
	 */
	boolean isMotorLigado();

	/**
	 * Abre as portas do carro
	 */
	void abrirPortas();
	
	/**
	 * Fecha as portas do carro
	 */
	void fecharPortas();
	
	/**
	 * Verifica se as portas est�o abertas
	 * @return True se as portas estiverem abertas e False se estiverem fechadas
	 */
	boolean isPortasAbertas();
	
	/**
	 * Ativa o alarme
	 */
	void ativarAlarme();
	
	/**
	 * Desativa o alarme
	 */
	void desativarAlarme();
	
	/**
	 * Verifica se o alarme est� ativado
	 * @return True se o alarme estiver ativado e False se n�o estiver
	 */
	boolean isAlarmeAtivado();
	
	/**
	 * Engata uma marcha
	 * @param marcha
	 */
	void engatarMarcha(Marcha marcha);
	
	/**
	 * Desengata a marcha
	 */
	void desengatarMarcha();
	
	/**
	 * Marcha engatada no momento
	 * @return a Marcha engatada ou null, caso n�o exita marcha engatada
	 */
	Marcha marchaEngatada();
	
	/**
	 * Retorna a velocidade atual do ve�culo
	 * @return
	 */	
	double getVelocidade();
	
	/**
	 * Incrementa a velocidade
	 * @param kilometrosHora
	 */
	void acelerar(double kilometrosHora);
	
	/**
	 * Incrementa o n�mero de passageiros no carro
	 * @param quantidade
	 */
	void colocaPassageiros(int quantidade);

	/**
	 * Decrementa o n�mero de passageiros no carro
	 * @param quantidade
	 */
	void removePassageiros(int quantidade);
	
	/**
	 * Retorna o n�mero de passageiros no carro
	 * @return
	 */
	int getNumeroPassageiros();
	
	/**
	 * Define o limite de passageiros que o carro pode aceitar
	 * @param numeroMaximoDePassageiros
	 */
	void setNumeroMaximoDePassageiros(int numeroMaximoDePassageiros);
	
	/**
	 * Retorna o limite de passageiros que o carro pode aceitar
	 * @return numeroMaximoDePassageiros
	 */
	int getNumeroMaximoDePassageiros();
	
	/**
	 * Liga o r�dio
	 */
	void ligarRadio();
	
	/**
	 * Desliga o r�dio
	 */
	void desligarRadio();
	
	/**
	 * Verifica se o radio est� ligado
	 * @return True se o radio est� ligado e False se n�o estiver ligado
	 */
	boolean isRadioLigado();
	
	/**
	 * Ajusta a altura do vidro
	 */
	void setAlturaDoVidro(AlturaDoVidro alturaDoVidro);
	
	/**
	 * Devolve a altura atual do vidro
	 * @return a altura do vidro
	 */
	AlturaDoVidro getAlturaDoVidro();
	

	/**
	 * Incrementa o n�mero de passageiros com cinto
	 * @param quantidade
	 */
	void colocaCinto(int quantidadePassageiros);

	/**
	 * Decrementa o n�mero de passageiros com cinto
	 * @param quantidade
	 */
	void removeCinto(int quantidadePassageiros);
	
	/**
	 * Retorna o n�mero de passageiros com cinto no carro
	 * @return
	 */
	int getNumeroPassageirosComCinto();
	
	/**
	 * Abre o porta malas do carro
	 */
	void abrirPortaMalas();
	
	/**
	 * Fecha o porta malas do carro
	 */
	void fecharPortaMalas();
	
	/**
	 * Verifica se o porta malas est� aberto
	 * @return True se o porta malas est� aberto, False se n�o estiver aberto
	 */
	boolean isPortaMalasAberto();

	/**
	 * Adiciona bagagem dentro do carro com o peso definido
	 * @param pesoDaBagagem
	 */
	void adicionarBagagem(double pesoDaBagagem);

	/**
	 * Remove bagagem com o peso definido de dentro do porta malas
	 * @return
	 */
	void removerBagagem(double pesoDaBagagem);

	/**
	 * Retorna o peso de toda a bagagem j� adicionada ao carro
	 * @return
	 */
	double pesoDaBagagem();
	
	/**
	 * Define o limite de peso que o porta malas aceita
	 * @param limiteDePesoDaBagagem
	 */
	void setLimiteDePesoDaBagagem(double limiteDePesoDaBagagem);
	
	/**
	 * Freia o carro at� ele parar
	 */
	void pararCarro();
	
}
