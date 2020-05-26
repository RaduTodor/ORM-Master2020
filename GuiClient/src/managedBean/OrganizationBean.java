package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.OrganizationDAORemote;
import com.example.dto.OrganizationDTO;


@ManagedBean
@SessionScoped
public class OrganizationBean {

	OrganizationDTO organizationDTO = new OrganizationDTO();

	@EJB(beanInterface = OrganizationDAORemote.class, name = "OrganizationDao")
	OrganizationDAORemote organizationDAORemote;

	public OrganizationDTO getOrganizationDTO() {
		return this.organizationDTO;
	}

	public void setOrganizationDTO(OrganizationDTO orgDTO) {
		this.organizationDTO = orgDTO;
	}
	
	public String goToNewOrganizationPage() {
		System.out.println("ce pushca mea");
		return "/addNewOrganization.xhtml?faces-redirect=true";
	}
	
	public String addNewOrganization() {
		this.organizationDAORemote.addNewOrganization(this.organizationDTO);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}