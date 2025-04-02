# MagicFridgeAI - IA, Tokens e Spring AI

## 1. Parsing de JSON
O parsing de JSON é um processo essencial para manipulação de dados estruturados. No Spring Boot, o uso do **Jackson** ou **Gson** é comum para converter JSON em objetos Java e vice-versa.

Recursos úteis:

- [Tutorial sobre Jackson](#)
- [Tutorial sobre Gson](#)

## 2. Documentação de APIs
Documentação das principais APIs de IA:

- [Documentação do Gemini API](#) **(leia antes da próxima aula)**
- [Documentação da OpenAI API](#) **(leia antes da próxima aula)**

## 3. Preços do Gemini API

| Categoria | Nível Gratuito | Nível Pago |
|-----------|----------------|-------------|
| Preço de entrada | Sem custo financeiro | US$ 0,10 (texto/imagem/vídeo) | US$ 0,70 (áudio) |
| Preço de saída | Sem custo financeiro | US$ 0,40 |
| Armazenamento em cache de contexto | Sem custo financeiro | US$ 0,025 / 1.000.000 tokens (texto/imagem/vídeo) | US$ 0,175 / 1.000.000 tokens (áudio) |
| Armazenamento em cache de contexto (até 31/03/2025) | Sem custo financeiro, até 1.000.000 tokens/hora | US$ 1,00 / 1.000.000 tokens/hora |
| Preço de ajuste | Indisponível | Indisponível |
| Embasamento com a Pesquisa Google | Sem custo financeiro, até 500 RPD | 1.500 RPD sem custo, depois US$ 35 / 1.000 solicitações |
| Usado para melhorar produtos | Sim | Não |

## 4. Introdução à Inteligência Artificial
A Inteligência Artificial (IA) é um campo da ciência da computação focado no desenvolvimento de sistemas capazes de realizar tarefas que normalmente exigiriam inteligência humana, como processamento de linguagem natural, visão computacional e aprendizado de máquina.

Ferramentas populares de IA incluem:

- **ChatGPT** (OpenAI)
- **DeepSeek**
- **Google Gemini**

## 5. Tokens e Modelos de Linguagem (LLMs)
Tokens são as menores unidades de processamento em modelos de linguagem (LLMs). Eles representam palavras, partes de palavras ou até caracteres individuais.

Mais informações sobre tokens e LLMs:

- [Artigo em inglês sobre tokens](#)
- [Artigo em português sobre tokens](#)
- [Sobre tokenização Face](#)

## 6. Bancos de Dados Vetoriais
Os bancos de dados vetoriais armazenam e recuperam informações baseadas em representações numéricas (vetores) de dados. Eles são amplamente usados para busca semântica e IA generativa.

Artigos sobre bancos de dados vetoriais:

- [Artigo em inglês](#)
- [Artigo em português](#)

## 7. Spring AI
O **Spring AI** é um projeto que integra soluções de inteligência artificial ao ecossistema Spring Boot, permitindo integração com modelos de linguagem e serviços de IA.

Mais detalhes podem ser encontrados na documentação oficial: [Spring AI Docs](#).

## 8. WebFlux + OpenAI + Setup do Projeto + Desafio 3

### 8.1 Introdução ao Spring WebFlux
O **Spring WebFlux** é o módulo do Spring Framework projetado para aplicações reativas e não bloqueantes. Ele permite a construção de aplicações altamente escaláveis e eficientes em termos de desempenho.

### 8.2 Diferença entre Spring MVC e Spring WebFlux
Enquanto o **Spring MVC** segue um modelo baseado em threads bloqueantes, o **WebFlux** usa um modelo reativo e assíncrono baseado no **Project Reactor**.

- **Spring MVC:** Baseado em threads bloqueantes (Tomcat).
- **Spring WebFlux:** Baseado em um modelo reativo e assíncrono (Netty).

### 8.3 Principais Conceitos
O WebFlux se baseia nos seguintes conceitos fundamentais:

- **Mono:** Representa um único valor assíncrono.
- **Flux:** Representa uma sequência de valores assíncronos.
- **WebClient:** Cliente reativo para chamadas HTTP.
- **Router Functions:** Abordagem funcional para definir rotas.

### 8.4 Exemplo de Código
Exemplo de um controlador reativo usando WebFlux:

```java
@RestController
@RequestMapping("/api")
public class ReactiveController {
    
    @GetMapping("/hello")
    public Mono<String> sayHello() {
        return Mono.just("Olá, WebFlux!");
    }
}
```

### 8.5 Uso do WebClient
O WebClient substitui o RestTemplate para chamadas HTTP assíncronas:

```java
WebClient client = WebClient.create("https://api.exemplo.com");
Mono<String> response = client.get()
                              .uri("/dados")
                              .retrieve()
                              .bodyToMono(String.class);
```

### 8.6 Recursos Úteis
Links para aprofundamento no WebFlux:

- [Documentação oficial do Spring WebFlux](#)
- [Documentação do Project Reactor](#)
- [Tutorial sobre WebFlux no Baeldung](#)

## 9. WebClient + WebFlux + ChatGPT + Prompt Builder + Desafio 5

### 9.1 O que é WebFlux?
O **Spring WebFlux** é um framework reativo do Spring para construção de aplicações assíncronas e não bloqueantes. Ele permite o processamento eficiente de requisições usando menos recursos do que o modelo tradicional baseado em threads bloqueantes.

Mais detalhes podem ser encontrados na [documentação oficial](#).

### 9.2 O que é Mono e Flux?
WebFlux usa a programação reativa baseada no **Project Reactor**. Ele fornece dois tipos principais de publishers reativos:

- **Mono:** Representa um único elemento ou nenhum.
- **Flux:** Representa uma sequência de múltiplos elementos.

Esses conceitos permitem o manuseio de dados de forma assíncrona e eficiente.

### 9.3 Configuração do application.properties
O arquivo **application.properties** ou **application.yml** pode ser configurado para otimizar a performance do WebFlux. Exemplo:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
```

### 9.4 Spring AI e OpenAI API
O **Spring AI** permite integração com serviços de IA, incluindo a API da OpenAI. Para configurar, adicione ao **application.properties**:

```properties
spring.ai.openai.api-key=SEU_API_KEY
```

Mais informações podem ser encontradas na [documentação do Spring AI](#) e na [documentação da OpenAI](#).

