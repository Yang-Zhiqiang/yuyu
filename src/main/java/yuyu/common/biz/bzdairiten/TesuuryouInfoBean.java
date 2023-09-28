package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

/**
 * 業務共通 代理店 手数料情報Beanクラス
 */
public class TesuuryouInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String drtenSyouhncdKami3;

    private String tsryshrkbnTougetu;

    private String tsryshrkbnYokugetu;

    private String bntnptnKbn;

    public String getDrtenSyouhncdKami3() {
        return drtenSyouhncdKami3;
    }

    public void setDrtenSyouhncdKami3(String pDrtenSyouhncdKami3) {
        this.drtenSyouhncdKami3 = pDrtenSyouhncdKami3;
    }

    public String getTsryshrkbnTougetu() {
        return tsryshrkbnTougetu;
    }

    public void setTsryshrkbnTougetu(String pTsryshrkbnTougetu) {
        this.tsryshrkbnTougetu = pTsryshrkbnTougetu;
    }

    public String getTsryshrkbnYokugetu() {
        return tsryshrkbnYokugetu;
    }

    public void setTsryshrkbnYokugetu(String pTsryshrkbnYokugetu) {
        this.tsryshrkbnYokugetu = pTsryshrkbnYokugetu;
    }

    public String getBntnptnKbn() {
        return bntnptnKbn;
    }

    public void setBntnptnKbn(String pBntnptnKbn) {
        this.bntnptnKbn = pBntnptnKbn;
    }
}
