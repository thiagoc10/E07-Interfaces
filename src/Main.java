import java.util.Date;
public class Main {
    public static void main(String[] args) {
        PessoaFisica p1 = new PessoaFisica("thiago", "antonio carlos", new Date(), "15784392550", 15, 'm');
        PessoaFisica p2 = new PessoaFisica("thiago", "antonio carlos", new Date(), "15784392550", 15, 'm');
        System.out.println(p1.equals(p2));
        PessoaJuridica p3 = new PessoaJuridica("thiago", "antonio carlos", new Date(), "342789", 50, "Roupas");
        PessoaJuridica p4 = new PessoaJuridica("thiago", "antonio carlos", new Date(), "342789", 50, "Roupas");
        System.out.println(p3.equals(p4));
        System.out.println(p1.autenticar("15784392550"));

    }
}