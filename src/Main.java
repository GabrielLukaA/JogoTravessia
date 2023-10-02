import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Personagem filho1 = new Personagem("Filho");
    static Personagem filho2 = new Personagem("Filho");
    static Personagem filha1 = new Personagem("Filha");
    static Personagem filha2 = new Personagem("Filha");
    static Personagem criminosa = new Personagem("Criminosa");
    static Personagem mae = new Personagem("Mãe");
    static Personagem pai = new Personagem("Pai");
    static Personagem policial = new Personagem("Policial");
    static Lado direito = new Lado();
    static Lado esquerdo = new Lado();
    static Scanner sc = new Scanner(System.in);
    static Jangada jangada = new Jangada(esquerdo);

    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao desafio. Passe todos os personagens para o lado direito.");
        esquerdo.getPersonagens().add(filho1);
        esquerdo.getPersonagens().add(filho2);
        esquerdo.getPersonagens().add(filha1);
        esquerdo.getPersonagens().add(filha2);
        esquerdo.getPersonagens().add(criminosa);
        esquerdo.getPersonagens().add(mae);
        esquerdo.getPersonagens().add(pai);
        esquerdo.getPersonagens().add(policial);
        printarLadoDoRio(esquerdo);

        do {

            System.out.println("Lado esquerdo");
            System.out.println(esquerdo.getPersonagens());
            System.out.println("\n\n");
            System.out.println("Lado direito");
            System.out.println(direito.getPersonagens());

            boolean bool;
            boolean bool2;
            if (direito.getPersonagens().size() != 8) {
                do {
                    jangada.setLadoAtual(esquerdo);
                    bool = menu(direito);
                } while (bool != true);
                if (direito.getPersonagens().size() != 8) {
                    do {
                        jangada.setLadoAtual(direito);
                        bool2 = menu(esquerdo);
                    } while (bool2 != true);
                } else {
                    System.out.println("Você ganhou, parabéns!!!");
                    System.exit(0);
                }
            } else {
                System.out.println("Você ganhou, parabéns!!!");
                System.exit(0);
            }
        } while (true);
    }

    private static boolean menu(Lado outroLado) {
        boolean jogar = false;
        System.out.println("Lado esquerdo");
        System.out.println(esquerdo.getPersonagens());
        System.out.println("\n\n");
        System.out.println("Lado direito");
        System.out.println(direito.getPersonagens());
        do {
            System.out.println("Escolha os personagens que irão estar na jangada: ");
            String personagem = sc.next();
            Personagem personagemObject = jangada.getLadoAtual().buscaPersonagem(personagem);
            if (personagemObject != null) {
                System.out.println("To aqui e o meu lado é " + jangada.getLadoAtual().getPersonagens());
                jangada.getNaJangada().add(personagemObject);
                jangada.getLadoAtual().getPersonagens().remove(personagemObject);
            }

            System.out.println("""
                    Satisfeito?
                    1 - Sim
                    Outros - Não
                    """);
            if (sc.nextInt() == 1) {
                jogar = true;
            }
        } while (!jogar);

        try {
            System.out.println("Vou tentar");
            jangada.atravessar();
            System.out.println("consegui tentar");
            jangada.getLadoAtual().verificar();
            System.out.println("Tentei man");
            outroLado.getPersonagens().addAll(jangada.getNaJangada());
            jangada.getNaJangada().removeAll(jangada.getNaJangada());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            jangada.getLadoAtual().getPersonagens().addAll(jangada.getNaJangada());
            jangada.getNaJangada().removeAll(jangada.getNaJangada());
            return false;
        }
        return true;
    }


    private static void printarLadoDoRio(Lado lado) {
        System.out.println(lado.getPersonagens().toString());
    }


}
