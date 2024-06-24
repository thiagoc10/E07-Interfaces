import java.util.Date;


public class PessoaJuridica extends Cliente implements ITaxa{


    private String cnpj;


    private int numFuncionarios;


    private String setor;


    public PessoaJuridica(String nome, String endereco, Date data, String cnpj, int numFuncionarios, String setor) {
        super(nome, endereco, data);
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;
    }


    @Override
    public String toString(){
        String PJ = "nome " + this.getNome() + "\n" + "data " + this.getData() + "\n" + "endereco " + this.getEndereco() + "\n" + "cnpj " + this.getCnpj() + "\n" + "Numero funcionarios " + this.getNumFuncionarios() + "\n" + "Setor " + this.getSetor() + "\n";
        return PJ;
    }




    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public int getNumFuncionarios() {
        return numFuncionarios;
    }


    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }


    public String getSetor() {
        return setor;
    }


    public void setSetor(String setor) {
        this.setor = setor;
    }
    public boolean equals(Object obj){
        PessoaJuridica pComparada = (PessoaJuridica) obj;
        return pComparada.getCnpj().equals(this.cnpj);
    }
    @Override
    boolean autenticar(String chave) {
        return chave.equals(this.cnpj);
    }
    public double calculaTaxas(){
        return 20;
    }

}


