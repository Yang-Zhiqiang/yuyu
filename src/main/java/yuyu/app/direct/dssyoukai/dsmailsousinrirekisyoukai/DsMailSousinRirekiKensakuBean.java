package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;

/**
 * ダイレクトサービス ＤＳメール送信履歴照会 ＤＳメール送信履歴照会検索Beanクラス<br/>
 */
public class DsMailSousinRirekiKensakuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dsKokNo;

    private String syoNo;

    private String dsSousinNo;

    private C_DsSousinMailSyubetuKbn dsSousinMailSyubetuKbn;

    private BizDate sousinYmdFrom;

    private BizDate sousinYmdTo;

    private int kensakuResultMaxKensuu;

    public String getDsKokNo() {
        return dsKokNo;
    }

    public void setDsKokNo(String pDsKokNo) {
        this.dsKokNo = pDsKokNo;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        this.syoNo = pSyoNo;
    }

    public String getDsSousinNo() {
        return dsSousinNo;
    }

    public void setDsSousinNo(String pDsSousinNo) {
        this.dsSousinNo = pDsSousinNo;
    }

    public C_DsSousinMailSyubetuKbn getDsSousinMailSyubetuKbn() {
        return dsSousinMailSyubetuKbn;
    }

    public void setDsSousinMailSyubetuKbn(C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn) {
        this.dsSousinMailSyubetuKbn = pDsSousinMailSyubetuKbn;
    }

    public BizDate getSousinYmdFrom() {
        return sousinYmdFrom;
    }

    public void setSousinYmdFrom(BizDate pSousinYmdFrom) {
        this.sousinYmdFrom = pSousinYmdFrom;
    }

    public BizDate getSousinYmdTo() {
        return sousinYmdTo;
    }

    public void setSousinYmdTo(BizDate pSousinYmdTo) {
        this.sousinYmdTo = pSousinYmdTo;
    }

    public int getKensakuResultMaxKensuu() {
        return kensakuResultMaxKensuu;
    }

    public void setKensakuResultMaxKensuu(int pKensakuResultMaxKensuu) {
        this.kensakuResultMaxKensuu = pKensakuResultMaxKensuu;
    }

}
