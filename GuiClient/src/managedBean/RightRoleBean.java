package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.RightRoleDAORemote;
import com.example.dao.OrganizationDAORemote;
import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;


@ManagedBean
@SessionScoped
public class RightRoleBean {

	List<RightDTO> rights;
	
	List<RoleDTO> roles;
	
	int rightId;
	
	int roleId;

	@EJB(beanInterface = RightRoleDAORemote.class, name = "RightRoleDao")
	RightRoleDAORemote RightRoleDAORemote;

	public List<RightDTO> getrights() {
		return RightRoleDAORemote.getAllRights();
	}

	public void setrights(List<RightDTO> rights) {
		this.rights = rights;
	}
	
	public List<RoleDTO> getroles() {
		return RightRoleDAORemote.getAllRoles();
	}

	public void setroles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	public int getRightId() {
		return this.rightId;
	}
	
	public void setRightId(int id) {
		this.rightId = id;
	}
	
	public int getRoletId() {
		return this.roleId;
	}
	
	public void setRoleId(int id) {
		this.roleId = id;
	}
	
	public String goToManageRightRoleRelationPage() {
		return "/manageRightRoleRelation.xhtml?faces-redirect=true";
	}
	
	public String addNewRightRoleRelation() {
		this.RightRoleDAORemote.addNewRightRoleRelation(this.rightId, this.roleId);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}