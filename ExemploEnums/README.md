# Utilizando ENUMS com spring boot  

API criada com o intuito de mostrar o uso de enums no spring boot e salvá-los em um banco de dados.  
O banco de dados utilizados na aplicação foi o h2. É possível testar a API através do swagger.

Suponha que seja um sistema cadastra pessoas e registram se no atual momento a pessoa trabalha ou está de folga.
Foi utilizando Enums para representar esses dois estados
```java
public enum StatusTrabalhoEnum {
    TRABALHA("Trabalha"),
    FOLGA("Não trabalha");
    private String trabalha;
    // .
    // .
    // .
}
```
Esta api fornece três endpoints, um para salvar uma pessoa, outro para listar todas as pessoas e um para listar os tipos de status de trabalho disponíveis .  
 
sendo eles:  
/pessoas [método post]  
/pessoas [método get]  
/pessoas/tipos [método get]

para o post, o modelo json de usuário a ser enviado é:
```json
{
    "id": number,
    "nome": string,
    "statusTrabalho": string
}
```

Os possíveis valores para statusTrabalho são: "TRABALHA" e "FOLGA" - assim como o atributo do enum. 
O getTrabalha() será utilizado para formatar o DTO de retorno.
```java

public enum StatusTrabalhoEnum {
    TRABALHA("Trabalha"),
    FOLGA("Não trabalha");
    private String trabalha;

    StatusTrabalhoEnum(String trabalha) {
        this.trabalha = trabalha;
    }
    
    public String getTrabalha() {
        return trabalha;
    }
    
}
```
Vai ser verificado se o texto passando no json bate com algum dos valores passados no construtor do enum. Senão, retorna null (essa verificação podem fazer da forma que quiser).  

## Armazenando no BD

Para armazenar no banco de dados, basta declarar em alguma classe o tipo do enum como atributo da classe:

```java
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //@Enumerated(EnumType.ORDINAL) os enums são armazenados de forma ordinal, então trocar a ordem
    //dos valores do enum, pode impactar no sistema

    // o STRING, armazena no bd na forma que os valores estão nomeados, então a ordem não influencia,
    @Enumerated(EnumType.STRING)
    private StatusTrabalhoEnum statusTrabalho;
    
    //getters, setters, construtores omitidos.
}
```

A anotação utilizada para dizer ao jpa como lidar com o armazenamento é o @Enumerated, 
os valores possíveis São STRING e ORDINAL, que estão descritas como comentário no código


localhost:8080/h2   **acessar o h2**  
localhost:8080/swagger-ui/index.html   **acessar o swagger**

Links externos:   
[Baeldung Enum Jpa](https://www.baeldung.com/jpa-persisting-enums-in-jpa)  
[Baeldung Serializar Enum](https://www.baeldung.com/jackson-serialize-enums)