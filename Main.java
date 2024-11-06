//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public abstract class Bolla {


        private float hp;
        private float poder;
        private int nivel;
        private Treinador treinador;

        public Bolla(int nivel, float hp, float poder){
            this.nivel = nivel;
            this.hp = hp;
            this.poder = poder;
        }

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

        public Treinador getTreinador() {
            return treinador;
        }

    }


}