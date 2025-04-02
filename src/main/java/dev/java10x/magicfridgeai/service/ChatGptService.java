package dev.java10x.magicfridgeai.service;

import dev.java10x.magicfridgeai.model.FoodItem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;

    private String apiKey = System.getenv("API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateRecipe(List<FoodItem> foodItems) {
        String alimentos = foodItems.stream()
                .map(item -> String.format("%s (%s) - Quantidade: %d, Validade: %s",
                        item.getNome(), item.getCategoria(), item.getQuantidade(), item.getValidade()))
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado nos seguintes alimentos, sugira uma receita criativa e prática:\n" + alimentos;


        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "instructions", "Você é um assistente que cria receitas.",
                "input", prompt
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    // Acessa a lista 'output'
                    List<Map<String, Object>> output = (List<Map<String, Object>>) response.get("output");
                    if (output != null && !output.isEmpty()) {
                        // Acessa o primeiro item do 'output' e o 'content' dentro dele
                        List<Map<String, Object>> content = (List<Map<String, Object>>) output.get(0).get("content");
                        if (content != null && !content.isEmpty()) {
                            // Acessa o 'text' dentro do primeiro item do 'content'
                            String text = (String) content.get(0).get("text");
                            return text;
                        }
                    }
                    return "Nenhuma receita foi gerada.";
                });
    }
}