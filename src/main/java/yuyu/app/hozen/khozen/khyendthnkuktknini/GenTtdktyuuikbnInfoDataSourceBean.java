package yuyu.app.hozen.khozen.khyendthnkuktknini;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 円建変更受付（任意請求） - 手続注意区分内容 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTtdktyuuikbnInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_TtdktyuuiKbn vtdktttdktyuuikbn;

    public C_TtdktyuuiKbn getVtdktttdktyuuikbn() {
        return vtdktttdktyuuikbn;
    }

    public void setVtdktttdktyuuikbn(C_TtdktyuuiKbn pVtdktttdktyuuikbn) {
        vtdktttdktyuuikbn = pVtdktttdktyuuikbn;
    }


    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String vtdktttdktyikbnhsknaiyou;

    public String getVtdktttdktyikbnhsknaiyou() {
        return vtdktttdktyikbnhsknaiyou;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVtdktttdktyikbnhsknaiyou(String pVtdktttdktyikbnhsknaiyou) {
        vtdktttdktyikbnhsknaiyou = pVtdktttdktyikbnhsknaiyou;
    }


    @ValidDate
    private BizDate vtdktttdktyuuikbnsetymd;

    public BizDate getVtdktttdktyuuikbnsetymd() {
        return vtdktttdktyuuikbnsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setVtdktttdktyuuikbnsetymd(BizDate pVtdktttdktyuuikbnsetymd) {
        vtdktttdktyuuikbnsetymd = pVtdktttdktyuuikbnsetymd;
    }


    private String vtdktsetsosikinm;

    public String getVtdktsetsosikinm() {
        return vtdktsetsosikinm;
    }

    public void setVtdktsetsosikinm(String pVtdktsetsosikinm) {
        vtdktsetsosikinm = pVtdktsetsosikinm;
    }

}
