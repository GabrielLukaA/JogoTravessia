public class MaeComFilhosException extends RuntimeException{
    public MaeComFilhosException(Jangada jangada){
        super("A mãe não pode transportar um filho pela jangada");
    }

    public MaeComFilhosException(){
        super("A mãe não pode estar com  filhos sem a presença do pai.");
    }
}
