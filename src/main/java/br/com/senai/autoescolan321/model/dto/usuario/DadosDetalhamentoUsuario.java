package br.com.senai.autoescolan321.model.dto.usuario;



import br.com.senai.autoescolan321.domain.Usuario;
import br.com.senai.autoescolan321.enumeration.Perfil;


public record DadosDetalhamentoUsuario(



        Long id,
        String login,
        Perfil perfil,
        String dataCriacao
)

{

    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPerfil(),
                String.valueOf(usuario.getDataCriacao())
        );
    }
}