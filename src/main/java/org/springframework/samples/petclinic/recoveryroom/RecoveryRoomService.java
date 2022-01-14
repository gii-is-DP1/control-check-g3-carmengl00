package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	private RecoveryRoomRepository recoveryRoomRepository;
	
    public List<RecoveryRoom> getAll(){
        List<RecoveryRoom> r = recoveryRoomRepository.findAll();
        return r;
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
    	List<RecoveryRoomType> productType = recoveryRoomRepository.findAllRecoveryRoomTypes();
    	return productType;
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
    	RecoveryRoomType type = recoveryRoomRepository.getRecoveryRoomType(typeName);
    	return type;
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
    	List<RecoveryRoom> r = this.recoveryRoomRepository.findBySizeMoreThan(size);
        return r;
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return this.recoveryRoomRepository.save(p);
    }

    
}
