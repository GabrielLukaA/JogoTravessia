public class Personagem {
    private String tipo;

    public Personagem(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


    @Override
    public String toString() {
        return "Personagem - " + tipo;
    }
}
