package yuyu.app.siharai.simouside.simousideuketuke;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 申出受付 - ●同時請求可能別契約情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBetukeiyakuListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean commonCheckBox;

    public Boolean getCommonCheckBox() {
        return commonCheckBox == null ? Boolean.FALSE : commonCheckBox;
    }

    public void setCommonCheckBox(Boolean pCommonCheckBox) {
        commonCheckBox = pCommonCheckBox == null ? Boolean.FALSE : pCommonCheckBox;
    }


    private String dispsyono;

    public String getDispsyono() {
        return dispsyono;
    }

    public void setDispsyono(String pDispsyono) {
        dispsyono = pDispsyono;
    }


    private C_SysCdKbn syscdkbn;

    public C_SysCdKbn getSyscdkbn() {
        return syscdkbn;
    }

    public void setSyscdkbn(C_SysCdKbn pSyscdkbn) {
        syscdkbn = pSyscdkbn;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String uktnmkj;

    public String getUktnmkj() {
        return uktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }


    private BizDate dispsyoumetuymd;

    public BizDate getDispsyoumetuymd() {
        return dispsyoumetuymd;
    }

    public void setDispsyoumetuymd(BizDate pDispsyoumetuymd) {
        dispsyoumetuymd = pDispsyoumetuymd;
    }


    private C_Syoumetujiyuu dispsyoumetujiyuu;

    public C_Syoumetujiyuu getDispsyoumetujiyuu() {
        return dispsyoumetujiyuu;
    }

    public void setDispsyoumetujiyuu(C_Syoumetujiyuu pDispsyoumetujiyuu) {
        dispsyoumetujiyuu = pDispsyoumetujiyuu;
    }


    private String dispsyouhnnm;

    public String getDispsyouhnnm() {
        return dispsyouhnnm;
    }

    public void setDispsyouhnnm(String pDispsyouhnnm) {
        dispsyouhnnm = pDispsyouhnnm;
    }

}
