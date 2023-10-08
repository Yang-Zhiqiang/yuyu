package yuyu.app.siharai.simakefile.simakeseikyuuinfof;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn;

/**
 * 請求情報ファイル作成 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSiMakeSeikyuuInfoFUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private C_SiharaiSyoriJyoutaiKbn siharaisyorijyoutaikbn;

    public C_SiharaiSyoriJyoutaiKbn getSiharaisyorijyoutaikbn() {
        return siharaisyorijyoutaikbn;
    }

    public void setSiharaisyorijyoutaikbn(C_SiharaiSyoriJyoutaiKbn pSiharaisyorijyoutaikbn) {
        siharaisyorijyoutaikbn = pSiharaisyorijyoutaikbn;
    }

    @ValidDate
    private BizDate sibouymdfrom;

    public BizDate getSibouymdfrom() {
        return sibouymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymdfrom(BizDate pSibouymdfrom) {
        sibouymdfrom = pSibouymdfrom;
    }

    @ValidDate
    private BizDate sibouymdto;

    public BizDate getSibouymdto() {
        return sibouymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymdto(BizDate pSibouymdto) {
        sibouymdto = pSibouymdto;
    }

    @ValidDate
    private BizDate siboukariymdfrom;

    public BizDate getSiboukariymdfrom() {
        return siboukariymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiboukariymdfrom(BizDate pSiboukariymdfrom) {
        siboukariymdfrom = pSiboukariymdfrom;
    }

    @ValidDate
    private BizDate siboukariymdto;

    public BizDate getSiboukariymdto() {
        return siboukariymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiboukariymdto(BizDate pSiboukariymdto) {
        siboukariymdto = pSiboukariymdto;
    }

    @ValidDate
    private BizDate syoruiukeymdfrom;

    public BizDate getSyoruiukeymdfrom() {
        return syoruiukeymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymdfrom(BizDate pSyoruiukeymdfrom) {
        syoruiukeymdfrom = pSyoruiukeymdfrom;
    }

    @ValidDate
    private BizDate syoruiukeymdto;

    public BizDate getSyoruiukeymdto() {
        return syoruiukeymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymdto(BizDate pSyoruiukeymdto) {
        syoruiukeymdto = pSyoruiukeymdto;
    }

    @ValidDate
    private BizDate shrymdfrom;

    public BizDate getShrymdfrom() {
        return shrymdfrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymdfrom(BizDate pShrymdfrom) {
        shrymdfrom = pShrymdfrom;
    }

    @ValidDate
    private BizDate shrymdto;

    public BizDate getShrymdto() {
        return shrymdto;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymdto(BizDate pShrymdto) {
        shrymdto = pShrymdto;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
    }
}
