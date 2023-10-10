package yuyu.app.hozen.khhubikanri.khhubikaisyou;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KaisyoutaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全不備解消 - ●解消済み不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKaisyouzumihubiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

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


    @ValidTextArea(length=30, rows=5)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String disphubinaiyoumsg;

    public String getDisphubinaiyoumsg() {
        return disphubinaiyoumsg;
    }

    @DataConvert("toMultiByte")
    public void setDisphubinaiyoumsg(String pDisphubinaiyoumsg) {
        disphubinaiyoumsg = pDisphubinaiyoumsg;
    }


    private C_UmuKbn dispgenponhnkykumu;

    public C_UmuKbn getDispgenponhnkykumu() {
        return dispgenponhnkykumu;
    }

    public void setDispgenponhnkykumu(C_UmuKbn pDispgenponhnkykumu) {
        dispgenponhnkykumu = pDispgenponhnkykumu;
    }


    private BizDate disphassinymd;

    public BizDate getDisphassinymd() {
        return disphassinymd;
    }

    public void setDisphassinymd(BizDate pDisphassinymd) {
        disphassinymd = pDisphassinymd;
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


    private BizDate dispkaisyouymd;

    public BizDate getDispkaisyouymd() {
        return dispkaisyouymd;
    }

    public void setDispkaisyouymd(BizDate pDispkaisyouymd) {
        dispkaisyouymd = pDispkaisyouymd;
    }


    private String dispsyounintantounm;

    public String getDispsyounintantounm() {
        return dispsyounintantounm;
    }

    public void setDispsyounintantounm(String pDispsyounintantounm) {
        dispsyounintantounm = pDispsyounintantounm;
    }

}
