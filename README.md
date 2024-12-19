# Lojinha Automação API

Este projeto consiste em um conjunto de testes automatizados para a aplicação web "Lojinha". Ele foi desenvolvido para garantir a qualidade e a confiabilidade das funcionalidades do módulo de produtos da aplicação.

## Tecnologias Utilizadas

 - **Java**: Linguagem principal para os testes.
 - https://www.oracle.com/java/technologies/downloads/
 - **JUnit 5**: Framework para execução de testes unitários e de integração.
 - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
 -  **Selenium WebDriver**: Ferramenta para automação de navegadores web. https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
 - **Maven**: Gerenciador de dependências e automação de build.
https://mvnrepository.com/

## Estrutura do Projeto

 -   **`ProdutosTest.java`**: Contém os testes para validar as funcionalidades relacionadas ao módulo de produtos.
-   **`paginas`**: Contém as classes Page Object, que representam as páginas da aplicação web (formulários, lista de produtos, login, etc.).
-   **`pom.xml`**: Arquivo de configuração do Maven, onde estão especificadas as dependências do projeto.


## O que foi feito

- Configuração do ambiente de testes utilizando o Selenium WebDriver e o JUnit 5.
- Desenvolvimento de testes para o módulo de produtos, incluindo:
  - Abertura da página inicial da aplicação.
  - Testes de adição, edição e listagem de produtos.
  - Validação de funcionalidades específicas, como login e navegação.
- Estruturação do projeto utilizando o padrão Page Object Model (POM) para facilitar a manutenção e a escalabilidade.
- Dados estes que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$7.000,00.

## Notas Gerais

 -   **Ambiente de Testes**: Certifique-se de configurar corretamente o ambiente de execução, especialmente o caminho do **Chromedriver** no sistema.
-   **Responsividade da Aplicação**: Os testes foram desenvolvidos e validados para navegadores desktop. O comportamento em dispositivos móveis não foi avaliado neste projeto.
-   **Validação dos Dados**: Certifique-se de que as informações no banco de dados estejam consistentes antes de executar os testes para evitar falhas inesperadas.
-   **Limpeza dos Dados**: É recomendável rodar scripts para limpar ou reiniciar o banco de dados antes e depois de cada execução de teste para garantir um ambiente isolado e consistente.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

