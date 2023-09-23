package yuyu.common.hozen.setuibean;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * 契約保全 UiBean設定 配当金情報設定UiBeanパラメータインターフェース
 */
public interface SetHaitoukinExecUiBeanParam {

    String getSyono();

    public void setVhthaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pVhthaitoukinuketorihoukbn);

    public void setVhthaitounendo(BizDateY pVhthaitounendo);

    public void setVhttounendod(BizCurrency pVhttounendod);

    public void setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn pVhtnaiteikakuteikbn);

    public void setVhttumitatenendo(BizDateY pVhttumitatenendo);

    public void setVhttumitated(BizCurrency pVhttumitated);

    public void setVhttumitatedtumitateymd(BizDate pVhttumitatedtumitateymd);

    public void setVhttumitatedshrkrkymd(BizDate pVhttumitatedshrkrkymd);
}
