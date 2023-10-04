package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 売上結果データ差替ソート項目用Beanクラスです。<br />
 */
public class UriageKekkaDataSasikaeSortBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syoNo;

    private String creditKessaiyouNo;

    private BizDate uriageNengappi;

    private Integer renNo3Keta;

    private Integer creditUriageNgJiyuu;

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String syoNo) {
        this.syoNo = syoNo;
    }

    public String getCreditKessaiyouNo() {
        return creditKessaiyouNo;
    }

    public void setCreditKessaiyouNo(String pCreditKessaiyouNo) {
        this.creditKessaiyouNo = pCreditKessaiyouNo;
    }

    public BizDate getUriageNengappi() {
        return uriageNengappi;
    }

    public void setUriageNengappi(BizDate pUriageNengappi) {
        this.uriageNengappi = pUriageNengappi;
    }

    public Integer getRenNo3Keta() {
        return renNo3Keta;
    }

    public void setRenNo3Keta(Integer pRenNo3Keta) {
        this.renNo3Keta = pRenNo3Keta;
    }

    public Integer getCreditUriageNgjiyuu() {
        return creditUriageNgJiyuu;
    }

    public void setCreditUriageNgjiyuu(Integer pCreditUriageNgJiyuu) {
        this.creditUriageNgJiyuu = pCreditUriageNgJiyuu;
    }
}
