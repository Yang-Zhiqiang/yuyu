package yuyu.app.direct.dskokyakukanri.dskokyakutouroku;

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
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 顧客登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenDsKokyakuTourokuUiBean extends AbstractUiBean {

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

    private String tougoumaedskokno;

    public String getTougoumaedskokno() {
        return tougoumaedskokno;
    }

    public void setTougoumaedskokno(String pTougoumaedskokno) {
        tougoumaedskokno = pTougoumaedskokno;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String kyknmkj;

    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String kyknmkn;

    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    @ValidDate
    private BizDate kykseiymd;

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    @Length(length=7)
    @SingleByteStrings
    @Digit
    private String tsinyno;

    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String dskokyakunmkj;

    public String getDskokyakunmkj() {
        return dskokyakunmkj;
    }

    public void setDskokyakunmkj(String pDskokyakunmkj) {
        dskokyakunmkj = pDskokyakunmkj;
    }

    @HostInvalidCharacter
    private String dskokyakunmkn;

    public String getDskokyakunmkn() {
        return dskokyakunmkn;
    }

    public void setDskokyakunmkn(String pDskokyakunmkn) {
        dskokyakunmkn = pDskokyakunmkn;
    }

    private BizDate dskokyakuseiymd;

    public BizDate getDskokyakuseiymd() {
        return dskokyakuseiymd;
    }

    public void setDskokyakuseiymd(BizDate pDskokyakuseiymd) {
        dskokyakuseiymd = pDskokyakuseiymd;
    }

    private String dskokyakuyno;

    public String getDskokyakuyno() {
        return dskokyakuyno;
    }

    public void setDskokyakuyno(String pDskokyakuyno) {
        dskokyakuyno = pDskokyakuyno;
    }

    private C_DsSyoriKbn dssyorikbn;

    public C_DsSyoriKbn getDssyorikbn() {
        return dssyorikbn;
    }

    public void setDssyorikbn(C_DsSyoriKbn pDssyorikbn) {
        dssyorikbn = pDssyorikbn;
    }

    private C_DsKanyuuKeiroKbn dskanyuukeirokbn;

    public C_DsKanyuuKeiroKbn getDskanyuukeirokbn() {
        return dskanyuukeirokbn;
    }

    public void setDskanyuukeirokbn(C_DsKanyuuKeiroKbn pDskanyuukeirokbn) {
        dskanyuukeirokbn = pDskanyuukeirokbn;
    }

    @Length(length=10)
    @SingleByteStrings
    @Digit
    private String tougousakidskokno;

    public String getTougousakidskokno() {
        return tougousakidskokno;
    }

    public void setTougousakidskokno(String pTougousakidskokno) {
        tougousakidskokno = pTougousakidskokno;
    }
}
