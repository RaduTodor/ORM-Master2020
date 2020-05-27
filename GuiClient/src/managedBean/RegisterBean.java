package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.IdentityDAORemote;
import com.example.dto.IdentityDTO;
import com.example.dao.OrganizationDAORemote;
import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;


@ManagedBean
@SessionScoped
public class RegisterBean {
	
	IdentityDTO IdentityDTO = new IdentityDTO();

	@EJB(beanInterface = IdentityDAORemote.class, name = "IdentityDao")
	IdentityDAORemote IdentityDAORemote;
	
	@EJB(beanInterface = OrganizationDAORemote.class, name = "OrganizationDao")
	OrganizationDAORemote OrganizationDAORemote;
	
	List<OrganizationDTO> organizations;
	
	public List<OrganizationDTO> getorganizations() {
		return OrganizationDAORemote.findAll();
	}

	public void setorganizations(List<OrganizationDTO> organizations) {
		this.organizations = organizations;
	}
	
	public IdentityDTO getIdentityDTO() {
		return this.IdentityDTO;
	}

	public void setIdentityDTO(IdentityDTO identityDTO) {
		this.IdentityDTO = identityDTO;
	}
	
	public String registerNewIdentity() {
		this.IdentityDAORemote.registerNewIdentity(this.IdentityDTO);
		return "/index.xhtml?faces-redirect=true";
	}

}