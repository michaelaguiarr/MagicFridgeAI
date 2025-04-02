package dev.java10x.magicfridgeai.model;

public enum Categoria {
    LATICINIOS("Laticínios"),
    FRUTAS("Frutas"),
    LEGUMES("Legumes"),
    CARNES("Carnes"),
    BEBIDAS("Bebidas"),
    CONGELADOS("Congelados"),
    ENLATADOS("Enlatados"),
    PERECIVEIS("Perecíveis"),
    SECOS("Secos");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
