package main.psoft;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public boolean addLivro(Livro livro){
        return this.livros.add(livro);
    }

    public boolean addUsuario(Usuario usuario){
        return this.usuarios.add(usuario);
    }

    public List<Livro> getLivrosByTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for(Livro l : this.livros) {
            if (l.getNome().contains(titulo)) resultado.add(l);
        }

        return resultado;
    }

    public List<Livro> getLivrosDisponiveis() {
        List<Livro> resultado = new ArrayList<>();
        for(Livro l : this.livros) {
            if (l.isDisponivel()) resultado.add(l);
        }

        return resultado;
    }

    public List<Livro> getLivrosCadastrados() {
        return getLivros();
    }

    public boolean reservarLivro(int codLivro, int codUsuario) throws Exception {
        Livro livro = this.livros.stream().filter(x -> x.getCod() == codLivro).findFirst().orElse(null);
        if (livro == null) {
            throw new OperationNotSupportedException("Reserva nao completada! Livro nao existe na biblioteca");
        } else if (!livro.isDisponivel()){
            throw new OperationNotSupportedException("Reserva nao completada! Livro esta indisponivel");
        }
        Usuario usuario = this.usuarios.stream().filter(u -> u.getCod() == codUsuario).findFirst().orElse(null);
        if (usuario == null) {
            throw new OperationNotSupportedException("Reserva nao completada! Usuario nao existe na biblioteca");
        }
        int idx = this.livros.indexOf(livro);
        livro.setUsuarioReserva(usuario);
        livro.setDisponivel(false);
        this.livros.set(idx, livro);
        return true;
    }
}

