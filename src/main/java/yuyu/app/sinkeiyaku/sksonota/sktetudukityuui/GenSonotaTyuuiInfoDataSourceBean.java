package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約手続注意設定 - ●その他注意情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSonotaTyuuiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String skeittdktyuistnaiyo;

    public String getSkeittdktyuistnaiyo() {
        return skeittdktyuistnaiyo;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkeittdktyuistnaiyo(String pSkeittdktyuistnaiyo) {
        skeittdktyuistnaiyo = pSkeittdktyuistnaiyo;
    }


    private Boolean dispsttratkityuuidel;

    public Boolean getDispsttratkityuuidel() {
        return dispsttratkityuuidel == null ? Boolean.FALSE : dispsttratkityuuidel;
    }

    public void setDispsttratkityuuidel(Boolean pDispsttratkityuuidel) {
        dispsttratkityuuidel = pDispsttratkityuuidel == null ? Boolean.FALSE : pDispsttratkityuuidel;
    }


    private C_YesNoKbn linehyoujiflag;

    public C_YesNoKbn getLinehyoujiflag() {
        return linehyoujiflag;
    }

    public void setLinehyoujiflag(C_YesNoKbn pLinehyoujiflag) {
        linehyoujiflag = pLinehyoujiflag;
    }

}
