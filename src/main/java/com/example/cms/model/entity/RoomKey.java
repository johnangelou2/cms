package com.example.cms.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RoomKey implements Serializable {

    @Column(name = "roomN")
    Integer roomN;

    @Column(name = "residenceId")
    Long residenceId;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(roomN.hashCode()) + String.valueOf(residenceId.hashCode());
        return concatString.hashCode();
    }
    public RoomKey(){}

    public RoomKey(Integer Num, Long Res){
        this.setRoomN(Num);
        this.setResidenceId(Res);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof RoomKey))
            return false;
        RoomKey other = (RoomKey) o;
        return roomN.equals(other.roomN) && residenceId.equals(other.residenceId);
    }

    private static final long serialVersionUID = 1354271798359243697L;
}
