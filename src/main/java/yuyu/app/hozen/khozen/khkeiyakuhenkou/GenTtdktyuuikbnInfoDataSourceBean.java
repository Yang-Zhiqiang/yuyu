package yuyu.app.hozen.khozen.khkeiyakuhenkou;

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
 * 契約変更 - 手続注意区分内容 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTtdktyuuikbnInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_TtdktyuuiKbn ttdktyuuikbn;

    public C_TtdktyuuiKbn getTtdktyuuikbn() {
        return ttdktyuuikbn;
    }

    public void setTtdktyuuikbn(C_TtdktyuuiKbn pTtdktyuuikbn) {
        ttdktyuuikbn = pTtdktyuuikbn;
    }


    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String ttdktyuuikbnhsknaiyou;

    public String getTtdktyuuikbnhsknaiyou() {
        return ttdktyuuikbnhsknaiyou;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou(String pTtdktyuuikbnhsknaiyou) {
        ttdktyuuikbnhsknaiyou = pTtdktyuuikbnhsknaiyou;
    }


    @ValidDate
    private BizDate ttdktyuuikbnsetymd;

    public BizDate getTtdktyuuikbnsetymd() {
        return ttdktyuuikbnsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd(BizDate pTtdktyuuikbnsetymd) {
        ttdktyuuikbnsetymd = pTtdktyuuikbnsetymd;
    }

}
