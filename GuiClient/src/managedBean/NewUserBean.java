package managedBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.IdentityDAORemote;
import com.example.dao.UserDAORemote;
import com.example.dto.IdentityDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;


@ManagedBean
@SessionScoped
public class NewUserBean {

	UserDTO NewUserDTO = new UserDTO();
	
	List<IdentityDTO> identities;

	@EJB(beanInterface = UserDAORemote.class, name = "UserDao")
	UserDAORemote UserDAORemote;
	
	@EJB(beanInterface = IdentityDAORemote.class, name = "IdentityDao")
	IdentityDAORemote IdentityDAORemote;
	
	public List<IdentityDTO> getidentities() {
		return IdentityDAORemote.findAllNotYetRegistered();
	}

	public void setidentities(List<IdentityDTO> identities) {
		this.identities = identities;
	}
	
	public UserDTO getNewUserDTO() {
		return this.NewUserDTO;
	}

	public void setNewUserDTO(UserDTO userDTO) {
		this.NewUserDTO = userDTO;
	}
	
	public String goToNewUserPage() {
		return "/addNewUsers.xhtml?faces-redirect=true";
	}
	
	public String addNewUser() {
		this.UserDAORemote.addNewUser(this.NewUserDTO);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}