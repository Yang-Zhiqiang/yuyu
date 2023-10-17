package yuyu.app.sinkeiyaku.sknyuukin.sktoujitufbhenkintorikesi;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 当日ＦＢ返金取消 - ●返金情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHenkinJyouhouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dummykmk;

    public String getDummykmk() {
        return dummykmk;
    }

    public void setDummykmk(String pDummykmk) {
        dummykmk = pDummykmk;
    }


    private BizCurrency disphnkngk;

    public BizCurrency getDisphnkngk() {
        return disphnkngk;
    }

    public void setDisphnkngk(BizCurrency pDisphnkngk) {
        disphnkngk = pDisphnkngk;
    }


    private BizDate disphnknymd;

    public BizDate getDisphnknymd() {
        return disphnknymd;
    }

    public void setDisphnknymd(BizDate pDisphnknymd) {
        disphnknymd = pDisphnknymd;
    }


    private C_HnknhouKbn disphnknhoukbn;

    public C_HnknhouKbn getDisphnknhoukbn() {
        return disphnknhoukbn;
    }

    public void setDisphnknhoukbn(C_HnknhouKbn pDisphnknhoukbn) {
        disphnknhoukbn = pDisphnknhoukbn;
    }


    private C_UmuKbn dispsrgohnknumu;

    public C_UmuKbn getDispsrgohnknumu() {
        return dispsrgohnknumu;
    }

    public void setDispsrgohnknumu(C_UmuKbn pDispsrgohnknumu) {
        dispsrgohnknumu = pDispsrgohnknumu;
    }


    private String dispbankcd;

    public String getDispbankcd() {
        return dispbankcd;
    }

    public void setDispbankcd(String pDispbankcd) {
        dispbankcd = pDispbankcd;
    }


    private String dispbanknmkj;

    public String getDispbanknmkj() {
        return dispbanknmkj;
    }

    public void setDispbanknmkj(String pDispbanknmkj) {
        dispbanknmkj = pDispbanknmkj;
    }


    private String dispsitencd;

    public String getDispsitencd() {
        return dispsitencd;
    }

    public void setDispsitencd(String pDispsitencd) {
        dispsitencd = pDispsitencd;
    }


    private String dispsitennmkj;

    public String getDispsitennmkj() {
        return dispsitennmkj;
    }

    public void setDispsitennmkj(String pDispsitennmkj) {
        dispsitennmkj = pDispsitennmkj;
    }


    private C_YokinKbn dispyokinkbn;

    public C_YokinKbn getDispyokinkbn() {
        return dispyokinkbn;
    }

    public void setDispyokinkbn(C_YokinKbn pDispyokinkbn) {
        dispyokinkbn = pDispyokinkbn;
    }


    private String dispkouzano;

    public String getDispkouzano() {
        return dispkouzano;
    }

    public void setDispkouzano(String pDispkouzano) {
        dispkouzano = pDispkouzano;
    }


    private String dispkzmeiginmkn;

    public String getDispkzmeiginmkn() {
        return dispkzmeiginmkn;
    }

    public void setDispkzmeiginmkn(String pDispkzmeiginmkn) {
        dispkzmeiginmkn = pDispkzmeiginmkn;
    }


    private String sentakulink;

    public String getSentakulink() {
        return sentakulink;
    }

    public void setSentakulink(String pSentakulink) {
        sentakulink = pSentakulink;
    }

}
