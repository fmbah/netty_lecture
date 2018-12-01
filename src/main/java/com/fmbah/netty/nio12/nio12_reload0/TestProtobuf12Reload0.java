package com.fmbah.netty.nio12.nio12_reload0;

/**
 * @ClassName TestProtobuf12Reload0
 * @Description
 *
 *
 *
 * @Author root
 * @Date 18-11-29 下午8:10
 * @Version 1.0
 **/
public class TestProtobuf12Reload0 {
    public static void main(String[] args) throws Exception{
        MessageInfo.AllMessage allMessage = MessageInfo.AllMessage.newBuilder().
                setMessageType(MessageInfo.AllMessage.MessageType.HOUSE).
//                setMessageType(MessageInfo.AllMessage.MessageType.CAR).
                setHouseType(MessageInfo.HouseType.newBuilder().setPrice(999).setSize(300).setVillage("世纪花园").build()).
//                setCarType(MessageInfo.CarType.newBuilder().setBrandName("宝马X5").setLocation("上海").setYears(2017).build()).
                build();

        if (1 == allMessage.getMessageType().getNumber()) {
            MessageInfo.CarType carType = allMessage.getCarType();
            System.out.println(carType.getBrandName() + ", " + carType.getLocation() + ", " + carType.getYears());
        } else if (2 == allMessage.getMessageType().getNumber()) {
            MessageInfo.HouseType houseType = allMessage.getHouseType();
            System.out.println(houseType.getVillage() + ", " + houseType.getSize() + ", " + houseType.getPrice());
        }
    }
}
