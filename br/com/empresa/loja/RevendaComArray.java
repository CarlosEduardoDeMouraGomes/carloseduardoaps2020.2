package br.com.empresa.loja;

import java.util.ArrayList;

public class RevendaComArray {
    private int tamanho;
    private ArrayList<Produto> produtos;
    
    public RevendaComArray(int quantidade) throws Exception{
        if(quantidade <= 0) {
            throw new Exception();
        } else {
            this.tamanho = quantidade;
            this.produtos = new ArrayList<>(quantidade);
        }
    }
   
    public ArrayList<Produto> getProdutos() {
        return (this.produtos);
    }
    
    public int calculaQuantidade() {
        int quantidade = 0;
        for(Produto produto : this.produtos) {
            quantidade += produto.getQuantidade();
        }
        return (quantidade);
    }
    
    public void inserirProduto(Produto produto) {
        boolean encontrado = false;
        for(Produto i : this.produtos) {
            if(produto.getCodigo() == i.getCodigo()) {
                encontrado = true;
                System.out.println("Produto Não Pode Ser Adicionado: Código De Produto Já Existente");
                break;
            }
        }
        int quantidade = this.calculaQuantidade();
        if(encontrado == false) {
            if((quantidade + produto.getQuantidade()) <= this.tamanho) {
                this.produtos.add(produto);
            } else {
                System.out.println("Produto Não Pode Ser Adicionado: Tamanho Disponivel Do Estoque Insuficiente");
                System.out.println("Tamanho Disponivel: " + (this.tamanho - quantidade));
            }
        }
    }
    
    public void comprar(int codigo, int quantidade) {
        boolean encontrado = false;
        for(Produto produto : this.produtos) {
            if(codigo == produto.getCodigo()) {
                encontrado = true;
                int quantidadeEstoque = this.calculaQuantidade();
                if((quantidadeEstoque + produto.getQuantidade()) <= this.tamanho) {
                    produto.compra(quantidade);
                } else {
                    System.out.println("Produtos Não Podem Ser Comprados: Tamanho Disponivel Do Estoque Insuficiente");
                    System.out.println("Tamanho Disponivel: " + (this.tamanho - quantidadeEstoque));
                }
                break;
            }
        }
        if(encontrado == false) {
            System.out.println("Produto Não encontrado");
        }
    }
    
    public void vender(int codigo, int quantidade) {
        boolean encontrado = false;
        for(Produto produto : this.produtos) {
            if(codigo == produto.getCodigo()) {
                encontrado = true;
                if((produto.getQuantidade() - quantidade) < 0) {
                    System.out.println("Produtos Não Podem Ser Vendidos: Quantidade Em Estoque Insuficiente");
                    System.out.println("Quantidade em Estoque: " + produto.getQuantidade());
                }
                else if((produto.getQuantidade() - quantidade > 0)){
                    produto.venda(quantidade);
                } else {
                    this.produtos.remove(produto);
                }
                break;
            }
        }
        if(encontrado == false) {
            System.out.println("Produto Não Encontrado");
        }
    }
    
    public void consultaPrecoVenda(int codigo) {
        boolean encontrado = false;
        for(Produto produto : this.produtos) {
            if(codigo == produto.getCodigo()) {
                encontrado = true;
                System.out.println("Preço Do Produto: " + produto.calculaPrecoVenda());
            }
        }
        if(encontrado == false) {
            System.out.println("Produto Não Encontrado");
        }
    }
    
    public void listaPrecos() {
        System.out.println("-------------------------------------------");
        for(Produto produto : this.produtos) {
            System.out.println("Produto:");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("-------------------------------------------");
        }
    }
}
