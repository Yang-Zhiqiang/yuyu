package yuyu.app.hozen.khnayose.khsakuinnmnosyuusei;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_SyuuseiTaisyouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全索引名番号修正 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhSakuinnmnoSyuuseiUiBean extends AbstractUiBean {

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

    private C_SyuuseiTaisyouKbn syuuseitaisyoukbn;

    public C_SyuuseiTaisyouKbn getSyuuseitaisyoukbn() {
        return syuuseitaisyoukbn;
    }

    public void setSyuuseitaisyoukbn(C_SyuuseiTaisyouKbn pSyuuseitaisyoukbn) {
        syuuseitaisyoukbn = pSyuuseitaisyoukbn;
    }

    private String taisyoudouituhyouji;

    public String getTaisyoudouituhyouji() {
        return taisyoudouituhyouji;
    }

    public void setTaisyoudouituhyouji(String pTaisyoudouituhyouji) {
        taisyoudouituhyouji = pTaisyoudouituhyouji;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    private String taisyounmkn;

    public String getTaisyounmkn() {
        return taisyounmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTaisyounmkn(String pTaisyounmkn) {
        taisyounmkn = pTaisyounmkn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String taisyounmkj;

    public String getTaisyounmkj() {
        return taisyounmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTaisyounmkj(String pTaisyounmkj) {
        taisyounmkj = pTaisyounmkj;
    }

    @ValidDate
    private BizDate taisyouseiymd;

    public BizDate getTaisyouseiymd() {
        return taisyouseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaisyouseiymd(BizDate pTaisyouseiymd) {
        taisyouseiymd = pTaisyouseiymd;
    }

    private String taisyousakuinnmno;

    public String getTaisyousakuinnmno() {
        return taisyousakuinnmno;
    }

    public void setTaisyousakuinnmno(String pTaisyousakuinnmno) {
        taisyousakuinnmno = pTaisyousakuinnmno;
    }

    @Length(length=10)
    @SingleByteStrings
    @Digit
    private String syuuseigosakuinnmno;

    public String getSyuuseigosakuinnmno() {
        return syuuseigosakuinnmno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuuseigosakuinnmno(String pSyuuseigosakuinnmno) {
        syuuseigosakuinnmno = pSyuuseigosakuinnmno;
    }
}
