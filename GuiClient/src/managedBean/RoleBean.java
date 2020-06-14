package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.RoleDAORemote;
import com.example.dto.RoleDTO;


@ManagedBean
@SessionScoped
public class RoleBean {

	RoleDTO roleDTO = new RoleDTO();

	@EJB(beanInterface = RoleDAORemote.class, name = "roleDao")
	RoleDAORemote roleDAORemote;

	public RoleDTO getRoleDTO() {
		return this.roleDTO;
	}

	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	
	public String goToNewRolePage() {
		return "/addNewRole.xhtml?faces-redirect=true";
	}
	
	public String addNewRole() {
		this.roleDAORemote.addNewRole(this.roleDTO);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}