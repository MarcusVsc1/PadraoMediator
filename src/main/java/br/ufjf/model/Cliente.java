package br.ufjf.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cliente extends Usuario{

    private List<Produto> produtosComprados = new ArrayList<>();
    private Double saldo;

    public Cliente(String nomeUsuario, String endereco) {
        super(nomeUsuario, endereco);
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void comprarProduto(String nomeProduto) {
        produtosComprados.add(PlataformaDeVendas.getInstance().realizarVenda(nomeProduto,saldo));
    }
}
