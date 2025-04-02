package dev.java10x.magicfridgeai.controller;

import dev.java10x.magicfridgeai.model.FoodItem;
import dev.java10x.magicfridgeai.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<FoodItem> criar (@RequestBody FoodItem fooditem) {
        FoodItem foodItemSalvo = service.salvar(fooditem);
        return ResponseEntity.ok(foodItemSalvo);
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> listar() {
        List<FoodItem> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        return service.buscarPorId(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = service.atualizar(foodItem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
