package register;

public class UserDAO {
	public String login(String name, String Pw) {
		userDO user = new userDO();
		boolean login = (name==user.getName()&& Pw==user.getPw());
		String view = "";
		if(login)
			view="로그인에 성공하였습니다.";
		else
			view="시스템 정보와 일치하지 않습니다.";
		
		return view;
	}
	
	public void register(userDO userData) {
		userDO user = new userDO();
		
		user.setName(userData.getName());
		user.setPw(userData.getPw());
		user.setEmail(userData.getEmail());
		user.setGrade(userData.getGrade());
		user.setTel(userData.getTel());
		
		user.putInform();
		
		
	} 
}
