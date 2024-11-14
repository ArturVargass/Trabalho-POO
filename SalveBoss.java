
import java.io.*;


class SalveBoss implements Serializable {

    Bolla t;

    public SalveBoss(Bolla t) {
        this.t=t;
    }

    public void salvarBoss() throws IOException {

        FileOutputStream fos = new FileOutputStream("boss.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(t);
        os.close();
        fos.close();
    }
    public Bolla carregarBoss() throws IOException,
        ClassNotFoundException {

            FileInputStream fis = new FileInputStream("boss.txt");
            ObjectInputStream is = new ObjectInputStream(fis);

            Bolla p = (Bolla) is.readObject();
            is.close();
            fis.close();

        return p;
    }

}
