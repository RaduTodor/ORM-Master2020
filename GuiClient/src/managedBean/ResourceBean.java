package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.ResourceDAORemote;
import com.example.dto.ResourceDTO;


@ManagedBean
@SessionScoped
public class ResourceBean {

	ResourceDTO resourceDTO = new ResourceDTO();

	@EJB(beanInterface = ResourceDAORemote.class, name = "resourceDao")
	ResourceDAORemote resourceDAORemote;

	public ResourceDTO getResourceDTO() {
		return this.resourceDTO;
	}

	public void setResourceDTO(ResourceDTO resourceDTO) {
		this.resourceDTO = resourceDTO;
	}
	
	public String goToNewResourcePage() {
		return "/addNewResource.xhtml?faces-redirect=true";
	}
	
	public String addNewResource() {
		this.resourceDAORemote.addNewResource(this.resourceDTO);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}