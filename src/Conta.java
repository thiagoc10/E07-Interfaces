abstract class Conta implements ITaxa {

    private int numero;
protected double limiteMin,limiteMax;
    private Cliente dono;

    private double saldo;

    private final double limite;

    private final Operacao[] operacoes;

    private int proximaOperacao;

    private static int totalContas = 0;

    public Conta(int numero, Cliente dono, double saldo, double limite) {
        this.numero = numero;
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;

        this.operacoes = new Operacao[1000];
        this.proximaOperacao = 0;

        Conta.totalContas++;
    }
    public Operacao[] getOperacoes() {
        return operacoes;
    }
public String toString(){
        String Conta = "Conta " + this.getNumero() + "\n" + "Saldo " + this.getSaldo() + "\n" + "Limite " + this.getLimite() + "\n";
        return Conta;
}
    public boolean equals(Object obj){
        Conta cComparada = (Conta) obj;
        return cComparada.getNumero() == this.numero;
    }

    public boolean sacar(double valor) {
        if (valor >= 0 && valor <= this.limite) {
            this.saldo -= valor;

            this.operacoes[proximaOperacao] = new OperacaoSaque(valor);
            this.proximaOperacao++;
            return true;
        }

        return false;
    }

    public void depositar(double valor) {
        this.saldo += valor;

        this.operacoes[proximaOperacao] = new OperacaoDeposito(valor);
        this.proximaOperacao++;
    }

    public boolean transferir(Conta destino, double valor) {
        boolean valorSacado = this.sacar(valor);
        if (valorSacado) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }



    public void imprimirExtrato() {
        System.out.println("======= Extrato Conta " + this.numero + "======");
        for(Operacao atual : this.operacoes) {
            if (atual != null) {
                atual.toString();
            }
        }
        System.out.println("====================");
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getDono() {
        return dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }
    public double getLimiteMax() {
        return limiteMax;
    }
    public double getLimiteMin() {
        return limiteMin;}
    public abstract void setLimite(double limite);
    public void imprimirExtratoTaxas() {
        double taxas = calculaTaxas();
        System.out.print("============Extrato de Taxas============\nTaxa de Manunteção: " +calculaTaxas());
        Operacao[] operation = getOperacoes();
        for (int i = 0; i < operation.length; ++i) {if (operation[i] !=null && operation[i].getTipo() == 's') {
            System.out.println("Saque: R$" + operation[i].calculaTaxas() + "\n");
            taxas+= operation[i].calculaTaxas();
            }
        }
        System.out.println("Taxa de Saque Total: R$" + taxas);
    }
}
