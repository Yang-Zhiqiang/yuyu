package yuyu.common.siharai.edittbl;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.db.entity.JT_TtdkRireki;

/**
 * 保険金給付金支払 保険金給付金支払共通 手続履歴TBL編集Beanクラス
 */
public class EditRrkTblBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String seiNo;

    private String syoNo;

    private BizDate syoriYmd;

    private C_JimukakuteiKbn jimKakuteiUmuKbn;

    private int seiRrkNo;

    private String shrSkbtKey;

    private String sateiSkbtKey;

    private JT_TtdkRireki ttdkRireki;

    public EditRrkTblBean() {
        super();
        seiNo = "";
        syoNo = "";
        syoriYmd = null;
        jimKakuteiUmuKbn = C_JimukakuteiKbn.MIKAKUTEI;
        seiRrkNo = 0;
        shrSkbtKey = "";
        sateiSkbtKey = "";
        ttdkRireki = new JT_TtdkRireki();
    }

    public String getSeiNo() {
        return seiNo;
    }

    public void setSeiNo(String pSeiNo) {
        seiNo = pSeiNo;
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

    public C_JimukakuteiKbn getJimKakuteiUmuKbn() {
        return jimKakuteiUmuKbn;
    }

    public void setJimKakuteiUmuKbn(C_JimukakuteiKbn pJimKakuteiUmuKbn) {
        jimKakuteiUmuKbn = pJimKakuteiUmuKbn;
    }

    public int getSeiRrkNo() {
        return seiRrkNo;
    }

    public void setSeiRrkNo(int pSeiRrkNo) {
        seiRrkNo = pSeiRrkNo;
    }

    public String getShrSkbtKey() {
        return shrSkbtKey;
    }

    public void setShrSkbtKey(String pShrSkbtKey) {
        shrSkbtKey = pShrSkbtKey;
    }

    public String getSateiSkbtKey() {
        return sateiSkbtKey;
    }

    public void setSateiSkbtKey(String pSateiSkbtKey) {
        sateiSkbtKey = pSateiSkbtKey;
    }

    public JT_TtdkRireki getTtdkRireki() {
        return ttdkRireki;
    }

    public void setTtdkRireki(JT_TtdkRireki pTtdkRireki) {
        ttdkRireki = pTtdkRireki;
    }

}
