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
Esta api fornece dois endpoints, um para salvar uma pessoa e outro para listar todas as pessoas.  
 
sendo eles:  
/ [método post]  
/ [método get]

para o post, o modelo json de usuário a ser enviado é:  
obs.: não foi utilizado DTO por motivos de simplificação
```json
{
    "id": number,
    "nome": string,
    "statusTrabalho": string
}
```

Os possíveis valores para statusTrabalho são: "Trabalha" e "Não trabalha" - assim como o atributo do enum.  
Para formatar este tipo de criação de enum, foi utilizada a anotação @JsonCreator na própria classe do enum,
segue classe completa:

```java

public enum StatusTrabalhoEnum {
    TRABALHA("Trabalha"),
    FOLGA("Não trabalha");
    private String trabalha;

    StatusTrabalhoEnum(String trabalha) {
        this.trabalha = trabalha;
    }

    // quando for desserializar o enum, o valor mostrado no json de retorno será  
    // "Trabalha" ou "Não trabalha", como mostrado no swagger.
    @JsonValue
    public String getTrabalha() {
        return trabalha;
    }

    //Você vai instanciar um StatusTrabalhoEnum baseado no texto do teu requestBody
    // os possíveis valores são "Trabalha" ou "Não Trabalha".
    @JsonCreator
    public static StatusTrabalhoEnum fromText(String texto) {
        for (StatusTrabalhoEnum status : StatusTrabalhoEnum.values()) {
            if (status.getTrabalha().equals(texto))
                return status;
        }
        return null;
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