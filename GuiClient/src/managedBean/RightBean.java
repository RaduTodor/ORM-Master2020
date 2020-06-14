package managedBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.example.dao.RightDAORemote;
import com.example.dto.RightDTO;


@ManagedBean
@SessionScoped
public class RightBean {

	RightDTO rightDTO = new RightDTO();

	@EJB(beanInterface = RightDAORemote.class, name = "rightDao")
	RightDAORemote rightDAORemote;

	public RightDTO getRightDTO() {
		return this.rightDTO;
	}

	public void setRightDTO(RightDTO rightDTO) {
		this.rightDTO = rightDTO;
	}
	
	public String goToNewRightPage() {
		return "/addNewRight.xhtml?faces-redirect=true";
	}
	
	public String addNewRight() {
		this.rightDAORemote.addNewRight(this.rightDTO);
		return "/adminFilter/admin.xhtml?faces-redirect=true";
	}

}