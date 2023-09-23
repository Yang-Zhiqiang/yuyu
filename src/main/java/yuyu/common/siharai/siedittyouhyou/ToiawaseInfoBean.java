package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;


/**
 * 保険金給付金支払 保険金給付金支払帳票編集 問合せ先情報Bean
 */
public class ToiawaseInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sosikiNm;

    private String tsinyNo;

    private String tsinAdr1kj;

    private String tsinAdr2kj;

    private String tsinAdr3kj;

    private String tsinTelno;

    private String telUktkKanouTime;

    private String telUktkkanouTimeHigou;

    public ToiawaseInfoBean() {
        super();
    }

    public String getSosikiNm() {
        return sosikiNm;
    }

    public void setSosikiNm(String pSosikiNm) {
        sosikiNm = pSosikiNm;
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

    public void setTsinadr2kj(String pTsinAdr2kj) {
        tsinAdr2kj = pTsinAdr2kj;
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

    public String getTelUktkKanouTime() {
        return telUktkKanouTime;
    }

    public void setTelUktkKanouTime(String pTelUktkKanouTime) {
        telUktkKanouTime = pTelUktkKanouTime;
    }

    public String getTelUktkkanouTimeHigou() {
        return telUktkkanouTimeHigou;
    }

    public void setTelUktkkanouTimeHigou(String pTelUktkkanouTimeHigou) {
        telUktkkanouTimeHigou = pTelUktkkanouTimeHigou;
    }

}
