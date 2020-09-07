package com.directrent.house.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HouseBaseInfo implements Serializable {
    private Long id;

    private String name;

    private BigDecimal area;

    private String towards;

    private String unitType;

    private String position;

    private String floor;

    private Byte elevator;

    private Integer buildYear;

    private String doorLockType;

    private Integer greeningRate;

    private String description;

    private BigDecimal price;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getTowards() {
        return towards;
    }

    public void setTowards(String towards) {
        this.towards = towards == null ? null : towards.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public Byte getElevator() {
        return elevator;
    }

    public void setElevator(Byte elevator) {
        this.elevator = elevator;
    }

    public Integer getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    public String getDoorLockType() {
        return doorLockType;
    }

    public void setDoorLockType(String doorLockType) {
        this.doorLockType = doorLockType == null ? null : doorLockType.trim();
    }

    public Integer getGreeningRate() {
        return greeningRate;
    }

    public void setGreeningRate(Integer greeningRate) {
        this.greeningRate = greeningRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", area=").append(area);
        sb.append(", towards=").append(towards);
        sb.append(", unitType=").append(unitType);
        sb.append(", position=").append(position);
        sb.append(", floor=").append(floor);
        sb.append(", elevator=").append(elevator);
        sb.append(", buildYear=").append(buildYear);
        sb.append(", doorLockType=").append(doorLockType);
        sb.append(", greeningRate=").append(greeningRate);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HouseBaseInfo other = (HouseBaseInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getTowards() == null ? other.getTowards() == null : this.getTowards().equals(other.getTowards()))
            && (this.getUnitType() == null ? other.getUnitType() == null : this.getUnitType().equals(other.getUnitType()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getFloor() == null ? other.getFloor() == null : this.getFloor().equals(other.getFloor()))
            && (this.getElevator() == null ? other.getElevator() == null : this.getElevator().equals(other.getElevator()))
            && (this.getBuildYear() == null ? other.getBuildYear() == null : this.getBuildYear().equals(other.getBuildYear()))
            && (this.getDoorLockType() == null ? other.getDoorLockType() == null : this.getDoorLockType().equals(other.getDoorLockType()))
            && (this.getGreeningRate() == null ? other.getGreeningRate() == null : this.getGreeningRate().equals(other.getGreeningRate()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getTowards() == null) ? 0 : getTowards().hashCode());
        result = prime * result + ((getUnitType() == null) ? 0 : getUnitType().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getFloor() == null) ? 0 : getFloor().hashCode());
        result = prime * result + ((getElevator() == null) ? 0 : getElevator().hashCode());
        result = prime * result + ((getBuildYear() == null) ? 0 : getBuildYear().hashCode());
        result = prime * result + ((getDoorLockType() == null) ? 0 : getDoorLockType().hashCode());
        result = prime * result + ((getGreeningRate() == null) ? 0 : getGreeningRate().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}