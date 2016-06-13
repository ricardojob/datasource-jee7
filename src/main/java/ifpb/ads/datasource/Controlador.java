package ifpb.ads.datasource;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 13/06/2016, 09:42:54
 */
@Named
@RequestScoped
public class Controlador {

    private  Pessoa pessoa = new Pessoa();

    @Inject
    private Servico servico;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public List<Pessoa> getPessoas() {
        return servico.pessoas();
    }

    public String salvar() {
        servico.salvar(pessoa);
        pessoa = new Pessoa();
        return null;
    }

}
