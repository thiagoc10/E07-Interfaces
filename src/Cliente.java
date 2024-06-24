import java.util.Date;


abstract class Cliente {


    private String nome;


    private String endereco;


    private Date data;


    public Cliente(String nome, String endereco, Date data) {
        this.nome = nome;
        this.endereco = endereco;
        this.data = data;
    }


    public void imprimir() {
        System.out.println("CLIENTE INVÁLIDO!");
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public Date getData() {
        return data;
    }


    public void setData(Date data) {
        this.data = data;
    }

    abstract boolean autenticar(String chave);
   public abstract double calculaTaxas();
}
