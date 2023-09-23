package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NkSyoumetuCd;

/**
 * 契約保全 契約保全共通 年金支払索引結果Beanクラス
 */
public class NenkinSakuinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kykNkSysyNo;

    private BizDate kykNkShrsYMD;

    private C_NkSyoumetuCd kykNkSymtJiyuu;

    private BizDate kykNkSymtYMD;

    public String getKykNkSysyNo() {
        return this.kykNkSysyNo;
    }

    public void setKykNkSysyNo(String pKykNkSysyNo) {
        this.kykNkSysyNo = pKykNkSysyNo;
    }

    public BizDate getKykNkShrsYMD() {
        return this.kykNkShrsYMD;
    }

    public void setKykNkShrsYMD(BizDate pKykNkShrsYMD) {
        this.kykNkShrsYMD = pKykNkShrsYMD;
    }

    public C_NkSyoumetuCd getKykNkSymtJiyuu() {
        return this.kykNkSymtJiyuu;
    }

    public void setKykNkSymtJiyuu(C_NkSyoumetuCd pKykNkSymtJiyuu) {
        this.kykNkSymtJiyuu = pKykNkSymtJiyuu;
    }

    public BizDate getKykNkSymtYMD() {
        return this.kykNkSymtYMD;
    }

    public void setKykNkSymtYMD(BizDate pKykNkSymtYMD) {
        this.kykNkSymtYMD = pKykNkSymtYMD;
    }
}
