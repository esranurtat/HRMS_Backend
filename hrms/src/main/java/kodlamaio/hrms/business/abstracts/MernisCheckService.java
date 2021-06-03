package kodlamaio.hrms.business.abstracts;

import java.util.Date;

public interface MernisCheckService {

	//Result checkRealPerson(Candidates candidates);
	
	boolean checkVirtualPerson(String nationalityId,String firstName,String lastName,Date birthday);
}
