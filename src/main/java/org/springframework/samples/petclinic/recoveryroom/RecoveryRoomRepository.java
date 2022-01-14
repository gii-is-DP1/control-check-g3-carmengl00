package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
    
    @Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name=:n")
    RecoveryRoomType getRecoveryRoomType(@Param("n")String name);
    
    @Query("SELECT r FROM RecoveryRoom r WHERE r.size>:size")
    List<RecoveryRoom> findBySizeMoreThan(@Param("size")Double size);
    
    List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
}
