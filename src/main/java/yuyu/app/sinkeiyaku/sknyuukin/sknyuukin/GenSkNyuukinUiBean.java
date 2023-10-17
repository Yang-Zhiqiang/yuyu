package yuyu.app.sinkeiyaku.sknyuukin.sknyuukin;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入金入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkNyuukinUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    @ValidDate
    private BizDate tyakkinymd;

    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Tuukasyu rstuukasyu;

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency rsgaku;

    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
    }

    @ValidDate
    private BizDate ryosyuymd;

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private C_NyknsyubetuKbn nyknsyubetu;

    public C_NyknsyubetuKbn getNyknsyubetu() {
        return nyknsyubetu;
    }

    public void setNyknsyubetu(C_NyknsyubetuKbn pNyknsyubetu) {
        nyknsyubetu = pNyknsyubetu;
    }

    private Boolean tokusyujmum;

    public Boolean getTokusyujmum() {
        return (tokusyujmum == null) ? Boolean.FALSE : tokusyujmum;
    }

    public void setTokusyujmum(Boolean pTokusyujmum) {
        tokusyujmum = (pTokusyujmum == null) ? Boolean.FALSE : pTokusyujmum;
    }

    private C_UmuKbn tokusyujmumkbn;

    public C_UmuKbn getTokusyujmumkbn() {
        return tokusyujmumkbn;
    }

    public void setTokusyujmumkbn(C_UmuKbn pTokusyujmumkbn) {
        tokusyujmumkbn = pTokusyujmumkbn;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
