import java.util.Date;


public class PessoaFisica extends Cliente implements ITaxa{


    private final String cpf;
public String getCPF(){
    return cpf;
    }

    private final int idade;


    private final char genero;


    public PessoaFisica(String nome, String endereco, Date data, String cpf, int idade, char genero) {
        super(nome, endereco, data);
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }


    @Override
    public String toString(){
        String PF = "nome = " + this.getNome() + "\n" + "data = " + this.getData()  + "\n" + "endereco = " + this.getEndereco() + "\n" + "cpf = " + this.cpf + "\n" + "idade = " + this.idade + "\n" + "genero " + this.genero + "\n";
        return PF;
    }
    public boolean equals(Object obj){
        PessoaFisica pComparada = (PessoaFisica) obj;
        return pComparada.cpf.equals(this.cpf);
    }
    @Override
    boolean autenticar(String chave) {
        return chave.equals(this.cpf);
    }
    public double calculaTaxas(){
        return 10;
    }
}
