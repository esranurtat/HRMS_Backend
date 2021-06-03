package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.adapter.MernisServiceAdapter;

@Service
public class MernisCheckManager {
	 MernisCheckService mernisCheckService;
		
	 @Autowired
    public MernisCheckManager() {

		mernisCheckService = new MernisServiceAdapter();
	}
}