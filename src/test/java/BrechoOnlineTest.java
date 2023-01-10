import br.ufjf.model.BrechoOnline;
import br.ufjf.model.Cliente;
import br.ufjf.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BrechoOnlineTest {

    private Cliente cliente;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    public void setUp() {
        produto1 = new Produto("Blusinha de miçangas",30.0);
        produto2 = new Produto("Vestido de festa",150.0);
        BrechoOnline.getInstance().adicionarProduto(produto1);
        BrechoOnline.getInstance().adicionarProduto(produto2);

        cliente = new Cliente("Maria do Rosário","Rua das Couves");
    }

    @Test
    public void compraConcluidaTest() {
        cliente.setSaldo(50.0);
        cliente.comprarProduto("Blusinha de miçangas");

        assertEquals(1,cliente.getProdutosComprados().size());
    }

    @Test
    public void produtoNaoEncontradoTest() {
        try {
            cliente.setSaldo(50.0);
            cliente.comprarProduto("Bio Whey 909g Performance");

            fail();
        } catch (RuntimeException e) {
            assertEquals("Produto Bio Whey 909g Performance não encontrado.", e.getMessage());
        }
    }

    @Test
    public void saldoInsuficienteTest() {
        try {
            cliente.setSaldo(50.0);
            cliente.comprarProduto("Vestido de festa");

            fail();
        } catch (RuntimeException e) {
            assertEquals("Saldo insuficiente para compra. Valor do produto: 150.0", e.getMessage());
        }
    }
}
