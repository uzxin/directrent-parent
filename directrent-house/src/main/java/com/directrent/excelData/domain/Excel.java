package com.directrent.excelData.domain;

import java.io.Serializable;

public class Excel implements Serializable {
    private Long houseId;

    private String details;

    private String name;

    private String folder;

    private String lable;

    private String area;

    private String towards;

    private String unitType;

    private String position;

    private String floor;

    private String elevator;

    private String buildYear;

    private String doorLockType;

    private String greeningRate;

    private String description;

    private String config;

    private String roommate;

    private String price;

    private static final long serialVersionUID = 1L;

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder == null ? null : folder.trim();
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator == null ? null : elevator.trim();
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear == null ? null : buildYear.trim();
    }

    public String getDoorLockType() {
        return doorLockType;
    }

    public void setDoorLockType(String doorLockType) {
        this.doorLockType = doorLockType == null ? null : doorLockType.trim();
    }

    public String getGreeningRate() {
        return greeningRate;
    }

    public void setGreeningRate(String greeningRate) {
        this.greeningRate = greeningRate == null ? null : greeningRate.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config == null ? null : config.trim();
    }

    public String getRoommate() {
        return roommate;
    }

    public void setRoommate(String roommate) {
        this.roommate = roommate == null ? null : roommate.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", houseId=").append(houseId);
        sb.append(", details=").append(details);
        sb.append(", name=").append(name);
        sb.append(", folder=").append(folder);
        sb.append(", lable=").append(lable);
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
        sb.append(", config=").append(config);
        sb.append(", roommate=").append(roommate);
        sb.append(", price=").append(price);
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
        Excel other = (Excel) that;
        return (this.getHouseId() == null ? other.getHouseId() == null : this.getHouseId().equals(other.getHouseId()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFolder() == null ? other.getFolder() == null : this.getFolder().equals(other.getFolder()))
            && (this.getLable() == null ? other.getLable() == null : this.getLable().equals(other.getLable()))
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
            && (this.getConfig() == null ? other.getConfig() == null : this.getConfig().equals(other.getConfig()))
            && (this.getRoommate() == null ? other.getRoommate() == null : this.getRoommate().equals(other.getRoommate()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHouseId() == null) ? 0 : getHouseId().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFolder() == null) ? 0 : getFolder().hashCode());
        result = prime * result + ((getLable() == null) ? 0 : getLable().hashCode());
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
        result = prime * result + ((getConfig() == null) ? 0 : getConfig().hashCode());
        result = prime * result + ((getRoommate() == null) ? 0 : getRoommate().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }
}