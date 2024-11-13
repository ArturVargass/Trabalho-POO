import java.io.*;


class SalveTreinador implements Serializable {

    Treinador t;

    public SalveTreinador(Treinador t) {
        this.t=t;
    }

    public void salvarTreinador(Treinador p) throws IOException {

        FileOutputStream fos = new FileOutputStream("treinador.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(p);
        os.close();
        fos.close();
    }
    public Treinador carregarPessoa() throws IOException,
        ClassNotFoundException {

            FileInputStream fis = new FileInputStream("treinador.txt");
            ObjectInputStream is = new ObjectInputStream(fis);

            Treinador p = (Treinador) is.readObject();
            is.close();
            fis.close();
        return p;
    }

}
