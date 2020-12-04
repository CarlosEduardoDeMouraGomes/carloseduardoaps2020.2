package br.com.empresa.loja;

public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    private double custo;
    private double lucro;
    private int quantidade;
    
    public Produto(int codigo, String descricao) throws Exception{
        if((preco < 0) || (custo < 0) || (lucro < 0)) {
            throw new Exception();
        } else {
            this.codigo = codigo;
            this.descricao = descricao;
            this.preco = preco;
            this.custo = custo;
            this.lucro = lucro;
            this.quantidade = 1;
        }
    }
    
    public Produto(int codigo, String descricao, double preco, double custo, double lucro) throws Exception{
        if((preco < 0) || (custo < 0) || (lucro < 0)) {
            throw new Exception();
        } else {
            this.codigo = codigo;
            this.descricao = descricao;
            this.preco = preco;
            this.custo = custo;
            this.lucro = lucro;
            this.quantidade = 1;
        }
    }
    
    public Produto(int codigo, String descricao, double preco, double custo, double lucro, int quantidade) throws Exception{
        if((preco < 0) || (custo < 0) || (lucro < 0) || (quantidade < 0)) {
            throw new Exception();
        } else {
            this.codigo = codigo;
            this.descricao = descricao;
            this.preco = preco;
            this.custo = custo;
            this.lucro = lucro;
            this.quantidade = quantidade;
        }
    }
    
    public void compra(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }
    
    public void venda(int quantidade) {
        this.quantidade = this.quantidade - quantidade;
    }
    
    public double calculaPrecoVenda() {
        return (this.preco + this.custo + this.lucro * (this.preco + this.custo));
    }
    
    public int getCodigo() {
        return (this.codigo);
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getDescricao() {
        return (this.descricao);
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getPreco() {
        return (this.preco);
    }
    
    public void setPreco(double preco) {
        if(preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço Inválido");
        }
    }
    
    public double getCusto() {
        return (this.custo);
    }
    
    public void setCusto(double custo) {
        if(custo >= 0) {
            this.custo = custo;
        } else {
            System.out.println("Custo Inválido");
        }
    }
    
    public double getLucro() {
        return (this.lucro);
    }
    
    public void setLucro(double lucro) {
        if(lucro >= 0) {
            this.lucro = lucro;
        } else {
            System.out.println("Margem De Lucro Inválida");
        }
    }
    
    public int getQuantidade() {
        return (this.quantidade);
    }
    
    public void setQuantidade(int quantidade) {
        if(quantidade > 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Quantidade Inválida");
        }
    }
}
