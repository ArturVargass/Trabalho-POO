import java.io.Serializable;
import java.util.Objects;

public abstract class Bolla implements Serializable {

    public void setHp(float hp) {
        this.hp = hp;
    }
    private String nome;
    private float hp;
    private float poder;
    private int nivel;
    private String imagePath;

    public Bolla(int nivel, float hp, float poder, String imagePath, String nome){
        this.nivel = nivel;
        this.hp = hp;
        this.poder = poder;
        this.imagePath = imagePath;
        this.nome = nome;
    }

    public abstract void atacarBasico(Bolla b);

    public abstract void ataqueEspecial(Bolla b);

    public abstract void atacar(Bolla b);

    public abstract void defender(float danoRecebido);

    public float getHp() {
        return hp;
    }

    public int getNivel() {
        return nivel;
    }

    public float getPoder() {
        return poder;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bolla bolla = (Bolla) obj;
        return nome.equals(bolla.nome); // ou outra propriedade que identifique a Bolla
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome); // ou outra propriedade que identifique a Bolla
    }

}

