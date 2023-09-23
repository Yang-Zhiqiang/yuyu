package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import yuyu.def.classification.C_SyoriKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * 契約保全 契約保全共通 保険契約異動情報履歴TBL編集Bean
 */
public class EditHokenKykIdouRirekiTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private KhozenCommonParam khozenCommonParam;

    private String syoNo;

    private BizDate syoriYmd;

    private C_SyoriKbn syoriKbn;

    private String sysDateTime;

    private BizCurrency mikeikaP;

    private BizCurrency zennouseisanKin;

    private BizCurrency mikeikaPGengkBf;

    private BizCurrency zennouseisanKinGengkBf;

    public KhozenCommonParam getKhozenCommonParam() {
        return khozenCommonParam;
    }

    public void setKhozenCommonParam(KhozenCommonParam pKhozenCommonParam) {
        khozenCommonParam = pKhozenCommonParam;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }

    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    public C_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(C_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public String getSysDateTime() {
        return sysDateTime;
    }

    public void setSysDateTime(String pSysDateTime) {
        sysDateTime = pSysDateTime;
    }

    public BizCurrency getMikeikaP() {
        return mikeikaP;
    }

    public void setMikeikaP(BizCurrency pMikeikaP) {
        mikeikaP = pMikeikaP;
    }

    public BizCurrency getZennouseisanKin() {
        return zennouseisanKin;
    }

    public void setZennouseisanKin(BizCurrency pZennouseisanKin) {
        zennouseisanKin = pZennouseisanKin;
    }

    public BizCurrency getMikeikaPGengkBf() {
        return mikeikaPGengkBf;
    }

    public void setMikeikaPGengkBf(BizCurrency pMikeikaPGengkBf) {
        mikeikaPGengkBf = pMikeikaPGengkBf;
    }

    public BizCurrency getZennouseisanKinGengkBf() {
        return zennouseisanKinGengkBf;
    }

    public void setZennouseisanKinGengkBf(BizCurrency pZennouseisanKinGengkBf) {
        zennouseisanKinGengkBf = pZennouseisanKinGengkBf;
    }
}
