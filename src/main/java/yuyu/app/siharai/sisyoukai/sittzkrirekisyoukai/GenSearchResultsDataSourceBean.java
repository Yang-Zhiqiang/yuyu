package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_SeikyuuSyubetu;

/**
 * 手続履歴照会 - searchResults の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSearchResultsDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }


    private String disphhknnmkn;

    public String getDisphhknnmkn() {
        return disphhknnmkn;
    }

    public void setDisphhknnmkn(String pDisphhknnmkn) {
        disphhknnmkn = pDisphhknnmkn;
    }


    private String disphhknnmkj;

    public String getDisphhknnmkj() {
        return disphhknnmkj;
    }

    public void setDisphhknnmkj(String pDisphhknnmkj) {
        disphhknnmkj = pDisphhknnmkj;
    }


    private C_SeikyuuSyubetu dispsksyubetu;

    public C_SeikyuuSyubetu getDispsksyubetu() {
        return dispsksyubetu;
    }

    public void setDispsksyubetu(C_SeikyuuSyubetu pDispsksyubetu) {
        dispsksyubetu = pDispsksyubetu;
    }


    @ValidDate
    private BizDate dispsyoruiukeymd;

    public BizDate getDispsyoruiukeymd() {
        return dispsyoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispsyoruiukeymd(BizDate pDispsyoruiukeymd) {
        dispsyoruiukeymd = pDispsyoruiukeymd;
    }

}
