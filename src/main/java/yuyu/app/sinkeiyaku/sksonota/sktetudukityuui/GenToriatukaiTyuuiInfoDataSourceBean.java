package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約手続注意設定 - ●新契約取扱注意情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenToriatukaiTyuuiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    private String skeittdktyuitrtnaiyo;

    public String getSkeittdktyuitrtnaiyo() {
        return skeittdktyuitrtnaiyo;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkeittdktyuitrtnaiyo(String pSkeittdktyuitrtnaiyo) {
        skeittdktyuitrtnaiyo = pSkeittdktyuitrtnaiyo;
    }


    private Boolean disptratkityuuidel;

    public Boolean getDisptratkityuuidel() {
        return disptratkityuuidel == null ? Boolean.FALSE : disptratkityuuidel;
    }

    public void setDisptratkityuuidel(Boolean pDisptratkityuuidel) {
        disptratkityuuidel = pDisptratkityuuidel == null ? Boolean.FALSE : pDisptratkityuuidel;
    }


    private C_YesNoKbn linehyoujiflag;

    public C_YesNoKbn getLinehyoujiflag() {
        return linehyoujiflag;
    }

    public void setLinehyoujiflag(C_YesNoKbn pLinehyoujiflag) {
        linehyoujiflag = pLinehyoujiflag;
    }

}
