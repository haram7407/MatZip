package design;

import java.util.ArrayList;
import java.util.List;

public class MemberController {

	public static List<Member> members = new ArrayList<Member>();
	
	public String append(Member m) {
		String msg = "�����Ͱ� ���������� ����Ǿ����ϴ�.";
		try {
			members.add(m);
		}catch(Exception ex) {
			ex.printStackTrace();//�����ڸ� ���� �޽���
			msg = "������ ������ ���� �߻�";
		}
		return msg;
	}
	
	public String update(Member m) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			for(int index=0 ; index<members.size() ; index++) {
				Member target = members.get(index);
				
				if(target.getName().equals(m.getName()) ) {
					members.set(index, m);
					break;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			msg="������ ������ ���� �߻�.";
		}
		
		return msg;
	}
	
	public String delete(Member m) {
		String msg = "�����Ͱ� ���������� �����Ǿ����ϴ�.";
		try {
			for(int i=members.size()-1; i>=0; i--) {
				if(members.get(i).getName().equals(m.getName())) {
					members.remove(i);
					break;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
			msg = "������ ���� �� ���� �߻�";
		}
		return msg;
	}
	
	public List<Member> search(String findStr) {
		List<Member> returnList = new ArrayList<Member>();
		
		for(int index=0 ; index<members.size() ; index++) {
			Member target = members.get(index);
			if(target.getName().indexOf(findStr)>-1    || 
			   target.getMenu().indexOf(findStr)>-1  ||
			   target.getPrice().indexOf(findStr)>-1 ||
			   target.getStar().indexOf(findStr)>-1 ||
			   target.getCategory().indexOf(findStr)>-1 ) {
				returnList.add(target);
			}
		}
		
		return returnList;
	}

	public Member selectOne(String id) {
		Member m = null;
		for(int i=0 ;i<members.size() ; i++) {
			Member target = members.get(i);
			if(id.equals(target.getName())) {
				m= target;
				break;
			}
		}
		
		return m;
	}

	
}
