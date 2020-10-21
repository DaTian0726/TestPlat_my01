package com.juhe.my01.web.model.dudect;

import lombok.Data;

/**
 * ClassName: SignMode
 * Description:
 * date: 2020/9/8 15:17
 *
 * @author ZouQi
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class SignModelQuery extends SignModel {

    public SignModelQuery(){

    }
    private String mhtContractCode = "";
    private String contractId = "";

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getMhtContractCode() {
        return mhtContractCode;
    }

    public void setMhtContractCode(String mhtContractCode) {
        this.mhtContractCode = mhtContractCode;
    }
}
