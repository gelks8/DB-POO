import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.util.Properties;

public class PersistenciaCSV {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa1 = new Pessoa("Gerson", 27);

        PessoaCSVDAO dao = new PessoaCSVDAO("pessoas.csv");
        dao.salvarPessoa(pessoa1);
    }
}

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

class PessoaCSVDAO {
    private String arquivoCSV;

    public PessoaCSVDAO(String arquivoCSV) {
        this.arquivoCSV = arquivoCSV;
    }

    public void salvarPessoa(Pessoa pessoa) {
        try (FileWriter writer = new FileWriter(arquivoCSV, true)) {
            writer.write(pessoa.getNome() + "," + pessoa.getIdade() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





