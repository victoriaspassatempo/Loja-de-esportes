# Crud loja de esportes

**Projeto Nunes Sports em Java**
Este projeto Java foi desenvolvido como parte de um teste prático de programação. O objetivo era criar uma empresa fictícia chamada Nunes Sports.

**Tecnologias Utilizadas**
- Java
- Spring Boot
- H2 Database (*em memória*)
- IntelliJ
- Swagger

### Como Usar o Projeto
**Configuração do Ambiente**
- Certifique-se de ter o Java instalado em sua máquina.
- Recomenda-se utilizar uma IDE Java, como o IntelliJ.
**Clonar o Repositório**
```bash
git clone https://github.com/victoriaspassatempo/Loja-de-esportes.git
````

**Importar o Projeto**
- Abra a IDE e importe o projeto como um projeto Maven.

**Executar o Projeto**
- Execute a classe Principal CrudApplication como um aplicativo Java na porta 8080.
- Abra o navegador de sua preferência e digite http://localhost:8080/products para exibir a lista de produtos já cadastrados. Como o banco de dados está em memória, o primeiro retorno será em branco.
- Para acessar os endpoints, você pode abrir a documentação no Swagger (http://localhost:8080/swagger-ui/index.html) e importar as requisições.
- O banco de dados pode ser acessado através da URL http://localhost:8080/h2.

**Funcionalidades Implementadas**
- Lista a tabela Produtos do banco de dados.
- Cria um novo produto na tabela Produto do banco de dados.
- Deleta um produto existente da tabela Produto do banco de dados.
- Edita um produto existente na tabela Produto do banco de dados.

