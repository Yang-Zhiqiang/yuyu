package yuyu.app.siharai.sisatei.sisinsatyuuisetei;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_SetteiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 審査注意設定 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiSinsaTyuuiSeteiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String sinsatyuuisetnm;

    public String getSinsatyuuisetnm() {
        return sinsatyuuisetnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSinsatyuuisetnm(String pSinsatyuuisetnm) {
        sinsatyuuisetnm = pSinsatyuuisetnm;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String sosikinm;

    public String getSosikinm() {
        return sosikinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSosikinm(String pSosikinm) {
        sosikinm = pSosikinm;
    }

    private C_SetteiKbn sinsatyuuisetkbn;

    public C_SetteiKbn getSinsatyuuisetkbn() {
        return sinsatyuuisetkbn;
    }

    public void setSinsatyuuisetkbn(C_SetteiKbn pSinsatyuuisetkbn) {
        sinsatyuuisetkbn = pSinsatyuuisetkbn;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String sinsatyuui;

    public String getSinsatyuui() {
        return sinsatyuui;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSinsatyuui(String pSinsatyuui) {
        sinsatyuui = pSinsatyuui;
    }
}
