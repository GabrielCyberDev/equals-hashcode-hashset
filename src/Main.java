import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Pessoa> pessoas = new HashSet<>();

        pessoas.add(new Pessoa("Ana", 25));
        pessoas.add(new Pessoa("Bruno", 30));
        pessoas.add(new Pessoa("Ana", 25));    // duplicada de propósito
        pessoas.add(new Pessoa("Carlos", 40));
        pessoas.add(new Pessoa("Bruno", 30));  // duplicada de propósito
        pessoas.add(new Pessoa("Ana", 31));    // mesmo nome, idade diferente: NÃO é duplicata

        System.out.println("Foram adicionadas 6 pessoas ao HashSet.");
        System.out.println("Quantidade final no conjunto: " + pessoas.size());
        System.out.println("Pessoas no conjunto:");
        for (Pessoa p : pessoas) {
            System.out.println(" - " + p);
        }

        System.out.println();
        System.out.println("===== EXPLICAÇÃO =====");
        System.out.println("Eu adicionei 6 pessoas, mas o conjunto ficou com " + pessoas.size() + ".");
        System.out.println("Ana (25) e Bruno (30) foram adicionados duas vezes, e o HashSet manteve só uma cópia de cada.");
        System.out.println("Isso acontece porque o HashSet não aceita elementos repetidos.");
        System.out.println("Ao chamar add(), ele primeiro usa hashCode() para descobrir em qual 'balde' o objeto deve ficar.");
        System.out.println("Como sobrescrevi hashCode() usando nome e idade, pessoas com os mesmos dados caem no mesmo balde.");
        System.out.println("Dentro do balde, o HashSet usa equals() para confirmar se os objetos são realmente iguais.");
        System.out.println("Como equals() compara nome e idade, a segunda Ana (25) foi considerada igual à primeira e não foi inserida.");
        System.out.println("A Ana de 31 anos tem hash e dados diferentes, então foi considerada outra pessoa e entrou no conjunto.");
        System.out.println("Sem equals() e hashCode() sobrescritos, o Java compararia endereços de memória e as 6 pessoas ficariam no conjunto.");
    }
}