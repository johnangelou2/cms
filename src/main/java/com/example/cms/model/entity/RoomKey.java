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

    @Column(name = "roomNumber")
    Long roomNum;

    @Column(name = "resId")
    Long roomResId;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(roomNum.hashCode()) + String.valueOf(roomResId.hashCode());
        return concatString.hashCode();
    }
    public RoomKey(){}

    public RoomKey(Long Num, Long Res){
        this.setRoomNum(Num);
        this.setRoomResId(Res);
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
        return roomNum.equals(other.roomNum) && roomResId.equals(other.roomResId);
    }

    private static final long serialVersionUID = 1354271798359243697L;
}
