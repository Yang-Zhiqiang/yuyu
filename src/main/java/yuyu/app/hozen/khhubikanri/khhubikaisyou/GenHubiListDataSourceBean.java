package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KaisyoutaisyouKbn;

/**
 * 契約保全不備解消 - ●不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean dispkaisyoutaisyou;

    public Boolean getDispkaisyoutaisyou() {
        return dispkaisyoutaisyou == null ? Boolean.FALSE : dispkaisyoutaisyou;
    }

    public void setDispkaisyoutaisyou(Boolean pDispkaisyoutaisyou) {
        dispkaisyoutaisyou = pDispkaisyoutaisyou == null ? Boolean.FALSE : pDispkaisyoutaisyou;
    }


    private C_KaisyoutaisyouKbn dispkaisyoutaisyoukbn;

    public C_KaisyoutaisyouKbn getDispkaisyoutaisyoukbn() {
        return dispkaisyoutaisyoukbn;
    }

    public void setDispkaisyoutaisyoukbn(C_KaisyoutaisyouKbn pDispkaisyoutaisyoukbn) {
        dispkaisyoutaisyoukbn = pDispkaisyoutaisyoukbn;
    }


    private BizDate disptrkymd;

    public BizDate getDisptrkymd() {
        return disptrkymd;
    }

    public void setDisptrkymd(BizDate pDisptrkymd) {
        disptrkymd = pDisptrkymd;
    }


    private String disphubisyoruimsg;

    public String getDisphubisyoruimsg() {
        return disphubisyoruimsg;
    }

    public void setDisphubisyoruimsg(String pDisphubisyoruimsg) {
        disphubisyoruimsg = pDisphubisyoruimsg;
    }


    private BizDate disphassinymd;

    public BizDate getDisphassinymd() {
        return disphassinymd;
    }

    public void setDisphassinymd(BizDate pDisphassinymd) {
        disphassinymd = pDisphassinymd;
    }


    private BizDate dispkaisyouymd;

    public BizDate getDispkaisyouymd() {
        return dispkaisyouymd;
    }

    public void setDispkaisyouymd(BizDate pDispkaisyouymd) {
        dispkaisyouymd = pDispkaisyouymd;
    }


    private C_HassinsakiKbn disphassinsakikbn;

    public C_HassinsakiKbn getDisphassinsakikbn() {
        return disphassinsakikbn;
    }

    public void setDisphassinsakikbn(C_HassinsakiKbn pDisphassinsakikbn) {
        disphassinsakikbn = pDisphassinsakikbn;
    }


    private String dispnyuryokutantounm;

    public String getDispnyuryokutantounm() {
        return dispnyuryokutantounm;
    }

    public void setDispnyuryokutantounm(String pDispnyuryokutantounm) {
        dispnyuryokutantounm = pDispnyuryokutantounm;
    }


    private String disphubinaiyoumsg;

    public String getDisphubinaiyoumsg() {
        return disphubinaiyoumsg;
    }

    public void setDisphubinaiyoumsg(String pDisphubinaiyoumsg) {
        disphubinaiyoumsg = pDisphubinaiyoumsg;
    }

}
