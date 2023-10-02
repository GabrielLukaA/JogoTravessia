import java.util.ArrayList;

public class Jangada {
    private ArrayList<Personagem> naJangada = new ArrayList<>();
    private Lado ladoAtual;


    public Jangada(Lado ladoAtual) {
        this.ladoAtual = ladoAtual;
    }

    public void setLadoAtual(Lado ladoAtual) {
        this.ladoAtual = ladoAtual;
    }


    public ArrayList<Personagem> getNaJangada() {
        return naJangada;
    }

    public Lado getLadoAtual() {
        return ladoAtual;
    }

    public void atravessar() throws JangadaException, NaoSabeManobrarException {
        String policial = "Policial";
        String mae = "Mãe";
        String pai = "Pai";
        if (this.getNaJangada().size() > 0) {
            if (this.getNaJangada().size() < 3) {
                    if (buscaPersonagem("Mãe") || buscaPersonagem("Pai") || buscaPersonagem("Policial")) {
                        if (buscaPersonagem("Mãe") && buscaPersonagem("Filho")){
                            getNaJangada().removeAll(getNaJangada());
                            throw new MaeComFilhosException(this);
                        } else if (buscaPersonagem("Pai") && buscaPersonagem("Filha")){
                            getNaJangada().removeAll(getNaJangada());
                            throw new PaiComFilhasException(this);
                        }
                        return;
                    }

                throw new NaoSabeManobrarException();
            }
            throw new JangadaException(this.getNaJangada().size());
        }
        throw new JangadaException();
    }



    public boolean buscaPersonagem(String tipo){
        for (Personagem personagem: naJangada){
            if (personagem.getTipo().equals(tipo)){
                return true;
            }
        }
        return false;
    }
}
