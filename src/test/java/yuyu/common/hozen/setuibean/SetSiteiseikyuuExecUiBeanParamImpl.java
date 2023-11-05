package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 契約保全 UiBean設定 被保険者代理人情報設定UiBean
 */
public class SetSiteiseikyuuExecUiBeanParamImpl implements SetSiteiseikyuuExecUiBeanParam {

    private String syono;

    private C_UktKbn vstsksiteidruktkbn;

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    private String vstskstdrsknmkn;

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String vstskstdrsknmkj;

    private C_KjkhukaKbn vstskstdrsknmkjhukakbn;

    private BizDate vstskstdrskseiymd;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public C_UktKbn getVstsksiteidruktkbn() {
        return vstsksiteidruktkbn;
    }

    @Override
    public void setVstsksiteidruktkbn(C_UktKbn pVstsksiteidruktkbn) {
        vstsksiteidruktkbn = pVstsksiteidruktkbn;
    }

    public String getVstskstdrsknmkn() {
        return vstskstdrsknmkn;
    }

    @Override
    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVstskstdrsknmkn(String pVstskstdrsknmkn) {
        vstskstdrsknmkn = pVstskstdrsknmkn;
    }

    public String getVstskstdrsknmkj() {
        return vstskstdrsknmkj;
    }

    @Override
    @Trim("right")
    @DataConvert("toMultiByte")
    public void setVstskstdrsknmkj(String pVstskstdrsknmkj) {
        vstskstdrsknmkj = pVstskstdrsknmkj;
    }

    public C_KjkhukaKbn getVstskstdrsknmkjhukakbn() {
        return vstskstdrsknmkjhukakbn;
    }

    @Override
    public void setVstskstdrsknmkjhukakbn(C_KjkhukaKbn pVstskstdrsknmkjhukakbn) {
        vstskstdrsknmkjhukakbn = pVstskstdrsknmkjhukakbn;
    }

    public BizDate getVstskstdrskseiymd() {
        return vstskstdrskseiymd;
    }

    @Override
    public void setVstskstdrskseiymd(BizDate pVstskstdrskseiymd) {
        vstskstdrskseiymd = pVstskstdrskseiymd;
    }
}
