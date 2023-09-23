package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;


/**
 * 保険金給付金支払 保険金給付金支払帳票編集 請求者情報Bean
 */
public class SeikyuusyaInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String seikyuusyaNmKj ;

    private String seikyuusyaNmKn;

    private String tsinyNo;

    private String tsinAdr1kj;

    private String tsinAdr2kj;

    private String tsinAdr3kj;

    private String tsinTelno;

    public SeikyuusyaInfoBean() {
        super();
    }

    public String getSeikyuusyanmKj () {
        return seikyuusyaNmKj ;
    }

    public void setSeikyuusyanmKj (String pSeikyuusyaNmKj ) {
        seikyuusyaNmKj  = pSeikyuusyaNmKj ;
    }


    public String getSeikyuusyanmKn() {
        return seikyuusyaNmKn;
    }

    public void setSeikyuusyanmKn(String seikyuusyaNmKn) {
        this.seikyuusyaNmKn = seikyuusyaNmKn;
    }

    public String getTsinyno() {
        return tsinyNo;
    }

    public void setTsinyno(String pTsinyNo) {
        tsinyNo = pTsinyNo;
    }

    public String getTsinadr1kj() {
        return tsinAdr1kj;
    }

    public void setTsinadr1kj(String pTsinAdr1kj) {
        tsinAdr1kj = pTsinAdr1kj;
    }

    public String getTsinadr2kj() {
        return tsinAdr2kj;
    }

    public void setTsinadr2kj(String pTsinaAdr2kj) {
        tsinAdr2kj = pTsinaAdr2kj;
    }

    public String getTsinadr3kj() {
        return tsinAdr3kj;
    }

    public void setTsinadr3kj(String pTsinAdr3kj) {
        tsinAdr3kj = pTsinAdr3kj;
    }

    public String getTsintelno() {
        return tsinTelno;
    }

    public void setTsintelno(String pTsinTelno) {
        tsinTelno = pTsinTelno;
    }

}
