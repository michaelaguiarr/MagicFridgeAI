package dev.java10x.magicfridgeai.controller;

import dev.java10x.magicfridgeai.model.FoodItem;
import dev.java10x.magicfridgeai.service.ChatGptService;
import dev.java10x.magicfridgeai.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private final FoodItemService foodItemService;
    private final ChatGptService chatGptService;

    public RecipeController(FoodItemService foodItemService, ChatGptService chatGptService) {
        this.foodItemService = foodItemService;
        this.chatGptService = chatGptService;
    }

    // Implementar métodos para interagir com o ChatGPT e gerar receitas
    /**
     * Rota para gerar receita baseada nos alimentos cadastrados.
     */
    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe() {
        List<FoodItem> foodItems = foodItemService.listarTodos();
        return chatGptService.generateRecipe(foodItems)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
