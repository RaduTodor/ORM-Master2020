package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.example.dao.UserDAORemote;
import com.example.dao.UserRoleResourceDAORemote;
import com.example.dao.ResourceDAORemote;
import com.example.dao.RoleDAORemote;
import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.RightDTO;
import com.example.dto.RoleDTO;
import com.example.dto.UserDTO;
import com.example.dto.UserRoleResourceDTO;


@ManagedBean
@SessionScoped
public class UserRoleResourceBean {

	List<UserRoleResourceDTO> relations;
	
	List<UserDTO> users;
	
	UserDTO user;
	
	int userId;
	
	int roleId;
	
	int resourceId;
	
	List<ResourceDTO> resources;
	
	List<RoleDTO> roles;

	@EJB(beanInterface = UserRoleResourceDAORemote.class, name = "UserRoleResourceDao")
	UserRoleResourceDAORemote UserRoleResourceDAORemote;
	
	@EJB(beanInterface = UserDAORemote.class, name = "UserDao")
	UserDAORemote UserDAORemote;
	
	@EJB(beanInterface = ResourceDAORemote.class, name = "ResourceDao")
	ResourceDAORemote ResourceDAORemote;
	
	@EJB(beanInterface = RoleDAORemote.class, name = "RoleDao")
	RoleDAORemote RoleDAORemote;

	public void handleChange() {		
		this.user = UserDAORemote.findById(this.userId);
		
		this.relations = this.user.getUserRoleResource();
	}
	
	public List<UserRoleResourceDTO> getRelations() {
		return this.relations;
	}
	
	public void setRelations(List<UserRoleResourceDTO> relations) {
		this.relations = relations;
	}
	
	public List<UserDTO> getUsers() {
		this.users = UserDAORemote.findAllWithDetails();
		return this.users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
	public UserDTO getUser() {
		return this.user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int id) {
		this.userId = id;
	}
	
	public int getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(int id) {
		this.roleId = id;
	}
	
	public int getResourceId() {
		return this.resourceId;
	}
	
	public void setResourceId(int id) {
		this.resourceId = id;
	}
	
	public List<ResourceDTO> getResources() {
		return ResourceDAORemote.findAll();
	}

	public void setResource(List<ResourceDTO> resources) {
		this.resources = resources;
	}
	
	public List<RoleDTO> getRoles() {
		return RoleDAORemote.findAll();
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	public String goToManageUserRoleResourceRelationPage() {
		return "/manageUserRoleResourceRelation.xhtml?faces-redirect=true";
	}
	
	public String addNewUserRoleResourceRelation() {
		this.UserRoleResourceDAORemote.addNewCombination(new UserRoleResourceDTO(this.userId, this.roleId, this.resourceId));
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}