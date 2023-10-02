public class PaiComFilhasException extends RuntimeException{


    public PaiComFilhasException(Jangada jangada){
        super("O pai não pode transportar uma filha pela jangada");
    }

    public PaiComFilhasException(){
        super("O pai não pode estar com  filhas sem a presença da mãe.");
    }


}
