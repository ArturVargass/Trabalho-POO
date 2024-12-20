
import java.io.*;


class SalveTreinador implements Serializable {

    Treinador t;

    public SalveTreinador(Treinador t) {
        this.t=t;
    }

    public void salvarTreinador() throws IOException {

        FileOutputStream fos = new FileOutputStream("treinador.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(t);
        os.close();
        fos.close();
    }
    public Treinador carregarTreinador() throws IOException,
        ClassNotFoundException {

            FileInputStream fis = new FileInputStream("treinador.txt");
            ObjectInputStream is = new ObjectInputStream(fis);

            Treinador p = (Treinador) is.readObject();
            is.close();
            fis.close();

        return p;
    }

}
