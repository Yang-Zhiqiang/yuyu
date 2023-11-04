package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * 契約保全 UiBean設定 配当金情報設定UiBean
 */
public class SetHaitoukinExecUiBeanParamImpl implements SetHaitoukinExecUiBeanParam {

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    private C_HaitoukinuketorihouKbn vhthaitoukinuketorihoukbn;

    public C_HaitoukinuketorihouKbn getVhthaitoukinuketorihoukbn() {
        return vhthaitoukinuketorihoukbn;
    }

    @Override
    public void setVhthaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pVhthaitoukinuketorihoukbn) {
        vhthaitoukinuketorihoukbn = pVhthaitoukinuketorihoukbn;
    }

    private BizDateY vhthaitounendo;

    public BizDateY getVhthaitounendo() {
        return vhthaitounendo;
    }

    @Override
    public void setVhthaitounendo(BizDateY pVhthaitounendo) {
        vhthaitounendo = pVhthaitounendo;

    }

    private BizCurrency vhttounendod;

    public BizCurrency getVhttounendod() {
        return vhttounendod;
    }

    @Override
    public void setVhttounendod(BizCurrency pVhttounendod) {
        vhttounendod = pVhttounendod;
    }

    private C_NaiteiKakuteiKbn vhtnaiteikakuteikbn;

    public C_NaiteiKakuteiKbn getVhtnaiteikakuteikbn() {
        return vhtnaiteikakuteikbn;
    }

    @Override
    public void setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn pVhtnaiteikakuteikbn) {
        vhtnaiteikakuteikbn = pVhtnaiteikakuteikbn;
    }

    private BizDateY vhttumitatenendo;

    public BizDateY getVhttumitatenendo() {
        return vhttumitatenendo;
    }

    @Override
    public void setVhttumitatenendo(BizDateY pVhttumitatenendo) {
        vhttumitatenendo = pVhttumitatenendo;

    }

    private BizCurrency vhttumitated;

    public BizCurrency getVhttumitated() {
        return vhttumitated;
    }

    @Override
    public void setVhttumitated(BizCurrency pVhttumitated) {
        vhttumitated = pVhttumitated;
    }

    private BizDate vhttumitatedtumitateymd;

    public BizDate getVhttumitatedtumitateymd() {
        return vhttumitatedtumitateymd;
    }

    @Override
    public void setVhttumitatedtumitateymd(BizDate pVhttumitatedtumitateymd) {
        vhttumitatedtumitateymd = pVhttumitatedtumitateymd;
    }

    private BizDate vhttumitatedshrkrkymd;

    @Override
    public void setVhttumitatedshrkrkymd(BizDate pVhttumitatedshrkrkymd) {
        vhttumitatedshrkrkymd = pVhttumitatedshrkrkymd;
    }

    public BizDate getVhttumitatedshrkrkymd() {
        return vhttumitatedshrkrkymd;
    }
}
