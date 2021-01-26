package com.juhe.my01.web.model.dudect;

/**
 * ClassName: DeductModelQuery
 * Description:
 * date: 2020/9/9 16:07
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
public class DeductModelQuery extends DeductModel {

    public  DeductModelQuery(){

    }

    private  String transId;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }
}
