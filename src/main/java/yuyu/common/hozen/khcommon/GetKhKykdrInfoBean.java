package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;

/**
 * 契約保全 契約保全共通 契約者代理人情報取得用Bean
 */
public class GetKhKykdrInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kkdairinmKn;

    private String kkdairinmKj;

    private C_KjkhukaKbn kkdairinmKjkhukaKbn;

    private String kykdryNo;

    private String kykdradr1;

    private String kykdradr2;

    private String kykdradr3;

    private String kykdrtelno;

    private BizDate kykdrseiymd ;

    private C_UktKbn kykdruktKbn;

    public GetKhKykdrInfoBean() {

        super();
        this.kkdairinmKn = "";
        this.kkdairinmKj = "";
        this.kkdairinmKjkhukaKbn = C_KjkhukaKbn.BLNK;
        this.kykdryNo = "";
        this.kykdradr1 = "";
        this.kykdradr2 = "";
        this.kykdradr3 = "";
        this.kykdrtelno = "";
        this.kykdrseiymd = null;
        this.kykdruktKbn = C_UktKbn.BLNK;
    }

    public String getKkdairinmKn() {
        return kkdairinmKn;
    }

    public void setKkdairinmKn(String pKkdairinmKn) {
        this.kkdairinmKn = pKkdairinmKn;
    }

    public String getKkdairinmKj() {
        return kkdairinmKj;
    }

    public void setKkdairinmKj(String pKkdairinmKj) {
        this.kkdairinmKj = pKkdairinmKj;
    }

    public C_KjkhukaKbn getKkdairinmKjkhukaKbn() {
        return kkdairinmKjkhukaKbn;
    }

    public void setKkdairinmKjkhukaKbn(C_KjkhukaKbn pKkdairinmKjkhukaKbn) {
        this.kkdairinmKjkhukaKbn = pKkdairinmKjkhukaKbn;
    }

    public String getKykdryNo() {
        return kykdryNo;
    }

    public void setKykdryNo(String pKykdryNo) {
        this.kykdryNo = pKykdryNo;
    }

    public String getKykdradr1() {
        return kykdradr1;
    }

    public void setKykdradr1(String pKykdradr1) {
        this.kykdradr1 = pKykdradr1;
    }

    public String getKykdradr2() {
        return kykdradr2;
    }

    public void setKykdradr2(String pkykdradr2) {
        this.kykdradr2 = pkykdradr2;
    }

    public String getKykdradr3() {
        return kykdradr3;
    }

    public void setKykdradr3(String pkykdradr3) {
        this.kykdradr3 = pkykdradr3;
    }

    public String getKykdrtelno() {
        return kykdrtelno;
    }

    public void setKykdrtelno(String pkykdrtelno) {
        this.kykdrtelno = pkykdrtelno;
    }

    public BizDate getkykdrseiymd () {
        return kykdrseiymd;
    }

    public void setKykdrseiymd (BizDate pKykdrseiymd) {
        this.kykdrseiymd = pKykdrseiymd;
    }

    public C_UktKbn getKykdruktKbn() {
        return kykdruktKbn;
    }

    public void setKykdruktKbn(C_UktKbn pKykdruktKbn) {
        this.kykdruktKbn = pKykdruktKbn;
    }

}
