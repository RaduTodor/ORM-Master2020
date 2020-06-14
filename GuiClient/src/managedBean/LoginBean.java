package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.example.dao.OrganizationDAORemote;
import com.example.dao.UserDAORemote;
import com.example.dto.LoginDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.UserRoleResourceDTO;
import com.example.dto.UserDTO;
import com.example.exception.LoginException;

@ManagedBean
@SessionScoped
public class LoginBean {

	LoginDTO loginDTO = new LoginDTO();
	
	List<UserRoleResourceDTO> relations;

	@EJB
	UserDAORemote userDAORemote;
	
	@EJB(beanInterface = OrganizationDAORemote.class, name = "OrganizationDao")
	OrganizationDAORemote OrganizationDAORemote;
	
	@EJB(beanInterface = UserDAORemote.class, name = "UserDao")
	UserDAORemote UserDAORemote;

	UserDTO userDTO;

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	public List<UserRoleResourceDTO> getRelations(){
		UserDTO user = UserDAORemote.findById(this.userDTO.getId());	
		this.relations = user.getUserRoleResource();
		return this.relations;
	}
	
	public void setRelations(List<UserRoleResourceDTO> relations) {
		this.relations = relations;
	}

	public String loginUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			userDTO = userDAORemote.loginUser(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
			if (userDTO.getId() == 1) {
			return "/adminFilter/admin.xhtml?faces-redirect=true";
			}
			return "/userFilter/user.xhtml?faces-redirect=true";

		} catch (LoginException e) {
			System.out.println("Invalid username or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
	
	public String goToRegisterPage() {
		List<OrganizationDTO> organizationsDTO = OrganizationDAORemote.findAll();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getSessionMap().put("organizations", organizationsDTO);
		return "/register.xhtml?faces-redirect=true";
	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		userDTO = null;

		return "/index?faces-redirect=true";
	}

}