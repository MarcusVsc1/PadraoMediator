package br.ufjf.model;

import java.util.HashMap;

public class BrechoOnline {

    private static BrechoOnline instance = new BrechoOnline();
    private BrechoOnline() {}

    public static BrechoOnline getInstance(){return instance;}

    private HashMap<String, Produto> produtosVendidos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtosVendidos.putIfAbsent(produto.getNomeProduto(), produto);
    }

    public Produto venderProduto(String nomeProduto, Double saldo) {
        Produto produto = produtosVendidos.get(nomeProduto);
        if (!(produto == null)) {
            if(saldo >= produto.getPrecoProduto()) {
                return produto;
            } else {
                throw new RuntimeException("Saldo insuficiente para compra. " +
                        "Valor do produto: "+produto.getPrecoProduto());
            }
        } else {
            throw new RuntimeException("Produto " + nomeProduto +
                    " não encontrado.");
        }
    }
}
