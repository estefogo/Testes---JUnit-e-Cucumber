# Testes: JUnit-e-Cucumber

<h2>Projeto: Implementação das <i>frameworks</i> JUnit e Cucumber para a realização de testes orientados  a comportamentos.</h2>
<h2>Autor: Rafaela Mendonça Estefogo</h2>

</hr>

<h3>Sobre o projeto:</h3>
<p>O sistema foi desenvolvido com o intuito de testar cenários de saques bancários de clientes especiais e comuns. No caso dos clientes especiais, os mesmos podem realizar saques independente de terem saldo disponível em suas contas. Os clientes comuns só podem realizar saques de tiverem saldo disponível.</p>

<h3>Desenvolvimento:</h3>
<p>A classe <i>classe_bdd.feature</i> declara dois cenários de execução, um para clietes especiais e outro para clientes comuns. Em cada um deles, são declarados o <i>Given</i>, <i>When</i> e <i>Then</i>; o <i>Given</i> é referente às condições iniciais do cenário (no caso, o saldo inicial do cliente). O <i>When</i> é a hipótese de teste implementada (no caso, o valor do sque solicitado). O <i>Then</i> é referente ao comportamento esperado diante das condições aplicadas.</p>

![image](https://user-images.githubusercontent.com/79616452/202819478-158f246f-9eb3-4162-af40-3200d5acb345.png)

<p>A classe <i>pom</i> implementa as versões das <i>frameworks</i> utilizadas:</p>

![image](https://user-images.githubusercontent.com/79616452/202819653-ebbb1f78-3f8a-4c39-afbc-009d51ea8793.png)

<p>A classe <i>Conta.java</i> implementa a lógica de testes dos cenários criados. Nela, está presente a variável booleana <i>Especial</i>, sendo que, caso o cliente seja especial, a variável é declarada como verdadeira (true), e caso seja um cliente comum, a variável é declarada como falsa (false).</p>

<p>No primeiro teste realizado, o método <i>um_cliente_especial_com_saldo_atual_de_reais(int saldo)</i>, presente no <i>Given</i> do primeiro cenário, recebe o valor de saldo inicial e de saque solicitado, e realiza o saque caso verifique que o cliente é Especial. No console, observa-se que os três testes do cliente especial (primeiro cenário) são bem sucedidos, enquanto que os testes do cliente comum (segundo cenário) não são executados, pois identificam que a variável <i>Especial</i> é verdadeira:</p>

![image](https://user-images.githubusercontent.com/79616452/202821118-73a67a55-c332-4f34-baa1-33ff717479f5.png)
