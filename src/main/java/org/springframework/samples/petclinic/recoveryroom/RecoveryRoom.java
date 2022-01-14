package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="recoveryroom")
public class RecoveryRoom extends BaseEntity{
    
    @NotNull
	@Size(min=3, max=50)
    String name;
    
    @NotNull
    @PositiveOrZero
    double size;
    
    @NotNull
    boolean secure;
    
    @ManyToOne
    @NotNull
    @JoinColumn(name="roomtype_id")
    RecoveryRoomType roomType;
}
