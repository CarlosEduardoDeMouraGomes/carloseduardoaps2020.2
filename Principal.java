import br.com.empresa.loja.*;
import java.util.Scanner;

public class Principal {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        
        try {
            int tamanho;
            System.out.print("Digite A Quantidade Máxima De Produtos Suportados Pelo Estoque: ");
            tamanho = Integer.parseInt(input.nextLine());
            RevendaComArray estoque = new RevendaComArray(tamanho);
        
            String opcao;
            do{
                System.out.println("1 - Adicionar Produto");
                System.out.println("2 - Comprar Produtos");
                System.out.println("3 - Vender Produtos");
                System.out.println("4 - Consultar Preço");
                System.out.println("5 - Listar Preços");
                System.out.println("6 - Consultar Produto");
                System.out.println("7 - Atualizar Produto");
                System.out.println("8 - Sair");
            
                System.out.print("Opção: ");
                opcao = input.nextLine();
                if(opcao.compareTo("1") == 0) {
                    System.out.println("1 - Criar Produto Com Código E Descrição");
                    System.out.println("2 - Criar Produto Com Código, Descrição, Valor de Compra, Custo E Margem de Lucro");
                    System.out.println("3 - Criar Produto Com Código, Descrição, Valor de Compra, Custo, Margem De Lucro E Quantidade");
                
                    String opcaoAdicao;
                    System.out.print("Opção: ");
                    opcaoAdicao = input.nextLine();
                    if(opcaoAdicao.compareTo("1") == 0) {
                        try {
                            int codigo;
                            System.out.print("Código: ");
                            codigo = Integer.parseInt(input.nextLine());
                            String descricao;
                            System.out.print("Descrição: ");
                            descricao = input.nextLine();
                    
                            Produto produto = new Produto(codigo, descricao);
                            estoque.inserirProduto(produto);
                        } catch(Exception ex) {
                            System.out.println("Erro Ao Passar Valores Para Produto");
                        }
                    }
                    else if(opcaoAdicao.compareTo("2") == 0) {
                        try {
                            int codigo;
                            System.out.print("Código: ");
                            codigo = Integer.parseInt(input.nextLine());
                            String descricao;
                            System.out.print("Descrição: ");
                            descricao = input.nextLine();
                            double preco;
                            System.out.print("Preço: ");
                            preco = Double.parseDouble(input.nextLine());
                            double custo;
                            System.out.print("Custo: ");
                            custo = Double.parseDouble(input.nextLine());
                            double lucro;
                            System.out.print("Margem De Lucro: ");
                            lucro = Double.parseDouble(input.nextLine());
                    
                            Produto produto = new Produto(codigo, descricao, preco, custo, lucro);
                            estoque.inserirProduto(produto);
                        } catch(Exception ex) {
                            System.out.println("Erro Ao Passar Valores Para Produto");
                        }
                    }
                    else if(opcaoAdicao.compareTo("3") == 0) {
                        try {
                            int codigo;
                            System.out.print("Código: ");
                            codigo = Integer.parseInt(input.nextLine());
                            String descricao;
                            System.out.print("Descrição: ");
                            descricao = input.nextLine();
                            double preco;
                            System.out.print("Preço: ");
                            preco = Double.parseDouble(input.nextLine());
                            double custo;
                            System.out.print("Custo: ");
                            custo = Double.parseDouble(input.nextLine());
                            double lucro;
                            System.out.print("Margem De Lucro: ");
                            lucro = Double.parseDouble(input.nextLine());
                            int quantidade;
                            System.out.print("Quantidade: ");
                            quantidade = Integer.parseInt(input.nextLine());
                        
                            Produto produto = new Produto(codigo, descricao, preco, custo, lucro, quantidade);
                            estoque.inserirProduto(produto);
                        } catch(Exception ex) {
                            System.out.println("Erro Ao Passar Valores Para Produto");
                        }
                    } else {
                        System.out.println("Opção Inválida");
                    }
                }
                else if(opcao.compareTo("2") == 0) {
                    try {
                        int codigo, quantidade;
                        System.out.print("Código: ");
                        codigo = Integer.parseInt(input.nextLine());
                        System.out.print("Quantidade: ");
                        quantidade = Integer.parseInt(input.nextLine());
                
                        estoque.comprar(codigo, quantidade);
                    } catch(Exception ex) {
                        System.out.println("Erro Ao Passar Valores");
                    }
                }
                else if(opcao.compareTo("3") == 0) {
                    try {
                        int codigo, quantidade;
                        System.out.print("Código: ");
                        codigo = Integer.parseInt(input.nextLine());
                        System.out.print("Quantidade: ");
                        quantidade = Integer.parseInt(input.nextLine());
                    
                        estoque.vender(codigo, quantidade);
                    } catch(Exception ex) {
                        System.out.println("Erro Ao Passar Valores");
                    }
                }
                else if(opcao.compareTo("4") == 0) {
                    try {
                        int codigo;
                        System.out.print("Código: ");
                        codigo = Integer.parseInt(input.nextLine());
                
                        estoque.consultaPrecoVenda(codigo);
                    } catch(Exception ex) {
                        System.out.println("Erro Ao Passar Valor");
                    }
                }
                else if(opcao.compareTo("5") == 0) {
                    estoque.listaPrecos();
                }
                else if(opcao.compareTo("6") == 0) {
                    try {
                        int codigo;
                        System.out.print("Código: ");
                        codigo = Integer.parseInt(input.nextLine());
                        
                        boolean encontrado = false;
                        for(Produto produto : estoque.getProdutos()) {
                            if(codigo == produto.getCodigo()) {
                                encontrado = true;
                                String opcaoConsulta;
                                do {
                                    System.out.println("1 - Consultar Preço");
                                    System.out.println("2 - Consultar Custo");
                                    System.out.println("3 - Consultar Margem De Lucro");
                                    System.out.println("4 - Voltar");
                                
                                    System.out.print("Opção: ");
                                    opcaoConsulta = input.nextLine();
                                    if(opcaoConsulta.compareTo("1") == 0) {
                                        System.out.println("Preço: " + produto.getPreco());
                                    }
                                    else if(opcaoConsulta.compareTo("2") == 0) {
                                        System.out.println("Custo: " + produto.getCusto());
                                    }
                                    else if(opcaoConsulta.compareTo("3") == 0) {
                                        System.out.println("Margem De Lucro: " + produto.getLucro());
                                    }
                                    else if(opcaoConsulta.compareTo("4") != 0) {
                                        System.out.println("Opção Inválida");
                                    }
                                }while(opcaoConsulta.compareTo("4") != 0);
                            }
                        }
                        if(encontrado == false) {
                            System.out.println("Produto Não Encontrado");
                        }
                    } catch(Exception ex) {
                        System.out.println("Erro Ao Passar Valor");
                    }
                }
                else if(opcao.compareTo("7") == 0) {
                    try {
                        int codigo;
                        System.out.print("Código: ");
                        codigo = Integer.parseInt(input.nextLine());
                        
                        boolean encontrado = false;
                        for(Produto produto : estoque.getProdutos()) {
                            if(codigo == produto.getCodigo()) {
                                encontrado = true;
                                String opcaoAtualiza;
                                do {
                                    System.out.println("1 - Atualizar Preço");
                                    System.out.println("2 - Atualizar Custo");
                                    System.out.println("3 - Atualizar Margem De Lucro");
                                    System.out.println("4 - Voltar");
                                
                                    System.out.print("Opção: ");
                                    opcaoAtualiza = input.nextLine();
                                    if(opcaoAtualiza.compareTo("1") == 0) {
                                        System.out.print("Novo Preço: ");
                                        produto.setPreco(Double.parseDouble(input.nextLine()));
                                    }
                                    else if(opcaoAtualiza.compareTo("2") == 0) {
                                        System.out.print("Novo Custo: ");
                                        produto.setCusto(Double.parseDouble(input.nextLine()));
                                    }
                                    else if(opcaoAtualiza.compareTo("3") == 0) {
                                        System.out.print("Nova Margem De Lucro: ");
                                        produto.setLucro(Double.parseDouble(input.nextLine()));
                                    }
                                    else if(opcaoAtualiza.compareTo("4") != 0) {
                                        System.out.println("Opção Inválida");
                                    }
                                }while(opcaoAtualiza.compareTo("4") != 0);
                            }
                        }
                        if(encontrado == false) {
                            System.out.println("Produto Não Encontrado");
                        }
                    } catch(Exception ex) {
                        System.out.println("Erro Ao Passar Valor");
                    }
                }
                else if(opcao.compareTo("8") == 0) {
                    System.out.println("Programa Encerrado");
                } else {
                    System.out.println("Opção Inválida");
                }
            }while(opcao.compareTo("8") != 0);
        } catch(Exception ex) {
            System.out.println("Tamanho De Estoque Inválido");
        }
    }
}
