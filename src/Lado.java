import java.util.ArrayList;

public class Lado {
    private ArrayList<Personagem> personagens = new ArrayList<>();

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }


    public void verificar() throws MaeComFilhosException, PaiComFilhasException, CriminosaSoltaException {
        if (this.buscaPersonagem("Pai") == null && this.buscaPersonagem("Mãe") != null && this.buscaPersonagem("Filho") != null) {
            throw new MaeComFilhosException();
        } else if (this.buscaPersonagem("Mãe")==null && this.buscaPersonagem("Pai")!=null && this.buscaPersonagem("Filha")!=null){
            throw new PaiComFilhasException();
        } else if (this.buscaPersonagem("Policial")==null && this.buscaPersonagem("Criminosa")!=null && personagens.size()>1){
            throw new CriminosaSoltaException();
        } else {
            return;
        }
    }


    public Personagem buscaPersonagem(String tipo) {
        for (Personagem personagem : personagens) {
            if (personagem.getTipo().equals(tipo)) {
                return personagem;
            }
        }
        return null;
    }
}
