package register;

public class UserDAO {
	public String login(String name, String Pw) {
		userDO user = new userDO();
		boolean login = (name==user.getName()&& Pw==user.getPw());
		String view = "";
		if(login)
			view="�α��ο� �����Ͽ����ϴ�.";
		else
			view="�ý��� ������ ��ġ���� �ʽ��ϴ�.";
		
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
