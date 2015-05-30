/*
 * Created by norman on 30.05.15.
 */
package faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean for JSF.
 */
@ManagedBean(name = "hellobean")
public class JsfBean {

    public JsfBean() {

    }

    public String getName() {
        return "Hello JSF";
    }
}
