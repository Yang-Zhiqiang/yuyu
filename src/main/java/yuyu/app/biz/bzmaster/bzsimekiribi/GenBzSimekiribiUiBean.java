package yuyu.app.biz.bzmaster.bzsimekiribi;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.web.ui.AbstractUiBean;

/**
 * 締切日登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSimekiribiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @ValidDateYm
    private BizDateYM bosyuuym;

    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    @ValidDate
    private BizDate mossimefromymd;

    public BizDate getMossimefromymd() {
        return mossimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossimefromymd(BizDate pMossimefromymd) {
        mossimefromymd = pMossimefromymd;
    }

    @ValidDate
    private BizDate mossimetoymd;

    public BizDate getMossimetoymd() {
        return mossimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMossimetoymd(BizDate pMossimetoymd) {
        mossimetoymd = pMossimetoymd;
    }

    @ValidDate
    private BizDate mosnrksimefromymd;

    public BizDate getMosnrksimefromymd() {
        return mosnrksimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosnrksimefromymd(BizDate pMosnrksimefromymd) {
        mosnrksimefromymd = pMosnrksimefromymd;
    }

    @ValidDate
    private BizDate mosnrksimetoymd;

    public BizDate getMosnrksimetoymd() {
        return mosnrksimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosnrksimetoymd(BizDate pMosnrksimetoymd) {
        mosnrksimetoymd = pMosnrksimetoymd;
    }

    @ValidDate
    private BizDate nyknsimefromymd;

    public BizDate getNyknsimefromymd() {
        return nyknsimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNyknsimefromymd(BizDate pNyknsimefromymd) {
        nyknsimefromymd = pNyknsimefromymd;
    }

    @ValidDate
    private BizDate nyknsimetoymd;

    public BizDate getNyknsimetoymd() {
        return nyknsimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNyknsimetoymd(BizDate pNyknsimetoymd) {
        nyknsimetoymd = pNyknsimetoymd;
    }

    @ValidDate
    private BizDate syorisimefromymd;

    public BizDate getSyorisimefromymd() {
        return syorisimefromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyorisimefromymd(BizDate pSyorisimefromymd) {
        syorisimefromymd = pSyorisimefromymd;
    }

    @ValidDate
    private BizDate syorisimetoymd;

    public BizDate getSyorisimetoymd() {
        return syorisimetoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyorisimetoymd(BizDate pSyorisimetoymd) {
        syorisimetoymd = pSyorisimetoymd;
    }
}
