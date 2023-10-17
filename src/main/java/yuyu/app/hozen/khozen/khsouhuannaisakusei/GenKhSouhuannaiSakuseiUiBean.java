package yuyu.app.hozen.khozen.khsouhuannaisakusei;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 送付案内作成 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhSouhuannaiSakuseiUiBean extends AbstractUiBean {

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
    private String shsnmkj;

    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    @Length(length=7)
    @Digit
    private String shskyno;

    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr1kj;

    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr2kj;

    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String shsadr3kj;

    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String hanyoushannaityouhyounm;

    public String getHanyoushannaityouhyounm() {
        return hanyoushannaityouhyounm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHanyoushannaityouhyounm(String pHanyoushannaityouhyounm) {
        hanyoushannaityouhyounm = pHanyoushannaityouhyounm;
    }

    @ValidTextArea(length=50, rows=30)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String hanyoushannaiinjinaiyou;

    public String getHanyoushannaiinjinaiyou() {
        return hanyoushannaiinjinaiyou;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHanyoushannaiinjinaiyou(String pHanyoushannaiinjinaiyou) {
        hanyoushannaiinjinaiyou = pHanyoushannaiinjinaiyou;
    }
}
