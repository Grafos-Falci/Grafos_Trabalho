package matrizadjacente2;

public class FileWriterReader {
    
    String arquivo;
    
    FileWriterReader(String nome){
        this.arquivo = nome;
            }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
    
}
