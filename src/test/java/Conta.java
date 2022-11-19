import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Conta {

	/**
	 * Criação de uma variável booleana que definirá se o cliente é especial ou não
	 * ("true" para clientes especiais e "false" para clientes comuns)
	 */
	public boolean Especial = false;

	/**
	 * Criação de uma variável que armazenará os valores do saldo das contas
	 */
	public Double saldo;

	/**
	 * Criação de uma variável que armazenará os valores dos saques solicitados
	 * pelos clientes
	 */
	public Double saque;

	/** Getters e Setters das variáveis criadas */

	public boolean isTipo() {
		return Especial;
	}

	public void setTipo(boolean tipo) {
		this.Especial = tipo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaque() {
		return saque;
	}

	public void setSaque(Double saque) {
		this.saque = saque;
	}

	/** --------------------------- TESTES COM CLIENTES ESPECIAIS --------------------------- */

	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int saldo) throws Throwable {

		/**
		 * Se o cliente for reconhecido como Especial, o valor de saldo assumirá o valor
		 * da variável recebida como parâmetro pelo método
		 * "um_cliente_especial_com_saldo_atual_de_reais", que corresponde ao valor
		 * declarado no Given do primeiro cenario do arquivo conta_bdd.feature
		 */
		
		if (this.Especial == true) {
			this.saldo = new Double(saldo).doubleValue();
			
		/**
		 * Caso o cliente não seja reconhecido como Especial, indicando que o método não
		 * recebeu os valores da variável Especial conforme esperado e não funcionou
		 * corretamente, o teste retornará um erro
		 */
			
		} else { 
			throw new PendingException();
		}
	}

	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(int saque) throws Throwable {

		/**
		 * Se o cliente for reconhecido como Especial, o valor do saque assumirá o valor
		 * da variável recebida como parâmetro pelo método
		 * "for_solicitado_um_saque_no_valor_de_reais", que corresponde ao valor
		 * declarado no When do primeiro cenario do arquivo conta_bdd.feature
		 */
		
		if (this.Especial == true) {
			this.saque = new Double(saque).doubleValue();
			
		/**
		 * Caso o cliente não seja reconhecido como Especial, indicando que o método não
		 * recebeu os valores da variável Especial conforme esperado e não funcionou
		 * corretamente, o teste retornará um erro
		*/
			
		} else { 
			throw new PendingException();
		}
	}

	@Then("^deve efutuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	public void deve_efutuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int saque) throws Throwable {

		/**
		 * Se o cliente for reconhecido como Especial, o saque deverá ser efetuado e o
		 * saldo atualizado de acordo com o valor do saque solicitado, que será
		 * subtraído independente do saldo anterior estar negativo ou zerado
		 */

		if (this.Especial == true) {
			this.saldo += -1*(this.saque);

		/**
		 * Caso o cliente não seja reconhecido como Especial, indicando que o método não
		 * recebeu os valores da variável Especial conforme esperado e não funcionou
		 * corretamente, o teste retornará um erro
		 */

		} else {
			throw new PendingException();
		}

	}

	/** --------------------------- TESTES COM CLIENTES COMUNS --------------------------- */

	@Given("^Um cliente comum com saldo atual de -(\\d+) reais$")
	public void um_cliente_comum_com_saldo_atual_de_reais(int saldo) throws Throwable {

		/**
		 * O valor do saldo assumirá o valor da variável recebida como parâmetro pelo
		 * método "um_cliente_comum_com_saldo_atual_de_reais", que corresponde ao valor
		 * declarado no Given do segundo cenario do arquivo conta_bdd.feature
		 */

		if (this.Especial == false) {
			this.saldo = (new Double(saldo).doubleValue()) * -1;

		/**
		 * Caso o cliente seja reconhecido como Especial, indicando que o método não
		 * recebeu os valores da variável Especial conforme esperado e não funcionou
		 * corretamente, o teste retornará um erro
		 */

		} else {
			throw new PendingException();
		}
	}

	/** O cliente solicita um determinado valor inteiro de saque em sua conta */
	@When("^solicitar um saque no valor de (\\d+) reais$")
	public void solicitar_um_saque_no_valor_de_reais(int saque) throws Throwable {

		/**
		 * O valor do saque assumirá o valor da variável recebida como parâmetro pelo
		 * método "solicitar_um_saque_no_valor_de_reais", que corresponde ao valor
		 * declarado no When do segundo cenario do arquivo conta_bdd.feature
		 */

		if (this.Especial == false) {
			this.saque = new Double(saque).doubleValue();

		/**
		 * Caso o cliente seja reconhecido como Especial, indicando que o método não
		 * recebeu os valores da variável Especial conforme esperado e não funcionou
		 * corretamente, o teste retornará um erro
		 */

		} else {
			throw new PendingException();
		}
	}

	@Then("^não deve efutuar o saque e deve retornar a mensagem Saldo Insuficiente$")
	public void não_deve_efutuar_o_saque_e_deve_retornar_a_mensagem_Saldo_Insuficiente() throws Throwable {
		
		/**
		 * A condicional abaixo testará se o saldo é maior que zero, se o valor do saque
		 * é maior ou igual ao valor do saldo atual e se o cliente é do tipo Comum. Caso
		 * as três premissas sejam verdadeiras, o saldo será atualizado de acordo com o
		 * valor de saque solicitado, que será subtraído
		 */
		if (this.saldo > 0 && this.saque <= this.saldo && this.Especial == false) {
			this.saldo += -(this.saque);
			System.out.println("Valor do saldo: " + this.saldo);

		/**
		 * Caso o valor solicitado para o saque seja maior que o valor disponível na
		 * conta, o saque não é efetuado, e deve ser retornada uma mensagem de aviso de
		 * saldo insuficiente
		 */

		} else if (this.saldo < this.saque || this.saldo < 0) {
			System.out.println("Saldo insuficiente!");

		/**
		 * Caso nenhum dos testes acima seja bem sucedido, indicando que o método não
		 * funcionou conforme esperado, o teste retornará um erro
		 */

		} else {
			throw new PendingException();
		}
	}
}