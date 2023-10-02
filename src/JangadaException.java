public class JangadaException extends RuntimeException{


    public JangadaException(){
        super("Sua Jangada não tem ninguém, impossível atravessar.");
    }
    public JangadaException(int pessoas){
        super("Sua Jangada tem mais de duas pessoas, ela iria afundar.");
    }
}
