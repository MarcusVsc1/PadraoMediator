package br.ufjf.model;

public class PlataformaDeVendas {

    private static PlataformaDeVendas instance = new PlataformaDeVendas();
    private PlataformaDeVendas() {}

    public static PlataformaDeVendas getInstance() {return instance;}

    public Produto realizarVenda(String nomeProduto, Double saldo){
        return BrechoOnline.getInstance().venderProduto(nomeProduto,saldo);
    }
}
