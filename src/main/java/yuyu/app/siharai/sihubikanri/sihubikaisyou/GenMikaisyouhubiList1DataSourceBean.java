package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 保険金給付金不備解消 - mikaisyouhubiList1 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenMikaisyouhubiList1DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return commonCheckBox == null ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = pCommonCheckBox == null ? Boolean.FALSE : pCommonCheckBox;
    }


    @ValidDate
    private BizDate trkymd;

    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
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


    private Boolean dispgenponhnkykumuchkbox;

    public Boolean getDispgenponhnkykumuchkbox() {
        return dispgenponhnkykumuchkbox == null ? Boolean.FALSE : dispgenponhnkykumuchkbox;
    }

    public void setDispgenponhnkykumuchkbox(Boolean pDispgenponhnkykumuchkbox) {
        dispgenponhnkykumuchkbox = pDispgenponhnkykumuchkbox == null ? Boolean.FALSE : pDispgenponhnkykumuchkbox;
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
