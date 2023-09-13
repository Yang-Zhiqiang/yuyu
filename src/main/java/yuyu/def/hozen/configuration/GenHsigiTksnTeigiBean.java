package yuyu.def.hozen.configuration;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 被災害特伸定義BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenHsigiTksnTeigiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenHsigiTksnTeigiBean() {
    }

    @NotNull
    private String saigainm;

    public String getSaigainm() {
        return saigainm;
    }

    public void setSaigainm(String pSaigainm) {
        saigainm = pSaigainm;
    }

    @NotNull
    @ValidDate
    private BizDate hsgymd;

    public BizDate getHsgymd() {
        return hsgymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHsgymd(BizDate pHsgymd) {
        hsgymd = pHsgymd;
    }

    @NotNull
    private C_HsigiTkbtTaiouSyuruiKbn hsigitkbttaiousyurui;

    public C_HsigiTkbtTaiouSyuruiKbn getHsigitkbttaiousyurui() {
        return hsigitkbttaiousyurui;
    }

    public void setHsigitkbttaiousyurui(C_HsigiTkbtTaiouSyuruiKbn pHsigitkbttaiousyurui) {
        hsigitkbttaiousyurui = pHsigitkbttaiousyurui;
    }

    @NotNull
    private BizDate bnktannaikaisiymd;

    public BizDate getBnktannaikaisiymd() {
        return bnktannaikaisiymd;
    }

    public void setBnktannaikaisiymd(BizDate pBnktannaikaisiymd) {
        bnktannaikaisiymd = pBnktannaikaisiymd;
    }

    @NotNull
    private BizDate bnktannaiendymd;

    public BizDate getBnktannaiendymd() {
        return bnktannaiendymd;
    }

    public void setBnktannaiendymd(BizDate pBnktannaiendymd) {
        bnktannaiendymd = pBnktannaiendymd;
    }

    @NotNull
    private C_UmuKbn koujyosyoumeitkbttaiouumu;

    public C_UmuKbn getKoujyosyoumeitkbttaiouumu() {
        return koujyosyoumeitkbttaiouumu;
    }

    public void setKoujyosyoumeitkbttaiouumu(C_UmuKbn pKoujyosyoumeitkbttaiouumu) {
        koujyosyoumeitkbttaiouumu = pKoujyosyoumeitkbttaiouumu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
