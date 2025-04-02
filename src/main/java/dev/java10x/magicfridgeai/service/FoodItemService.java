package dev.java10x.magicfridgeai.service;

import dev.java10x.magicfridgeai.model.FoodItem;
import dev.java10x.magicfridgeai.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItem salvar(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> listarTodos() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> buscarPorId(Long id) {
        return foodItemRepository.findById(id);
    }

    public FoodItem atualizar(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public void excluir(Long id) {
        foodItemRepository.deleteById(id);
    }
}
