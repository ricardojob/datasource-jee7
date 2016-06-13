package ifpb.ads.datasource;

import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 13/06/2016, 09:43:37
 */
@DataSourceDefinition(       
        name = "java:global/jdbc/datasource",
        className = "org.apache.derby.jdbc.ClientDriver",
        url = "jdbc:derby://localhost:1527/stateless",
        password = "stateless",
        user = "stateless"
)
@Stateless
public class Servico {

    @PersistenceContext(unitName = "DataSourcePU")
    private EntityManager em;

    public void salvar(Pessoa pessoa) {
        em.persist(pessoa);
    }

    public List<Pessoa> pessoas() {
        return em.createQuery("Select p From Pessoa p", Pessoa.class)
                .getResultList();
    } 
}
