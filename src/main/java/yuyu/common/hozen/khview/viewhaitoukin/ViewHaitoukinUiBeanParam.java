package yuyu.common.hozen.khview.viewhaitoukin;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * 契約保全 契約保全画面部品 配当金情報表示 <br />
 */
public interface ViewHaitoukinUiBeanParam extends CommonViewUiBeanParam {

    public C_HaitoukinuketorihouKbn getVhthaitoukinuketorihoukbn();

    public BizDateY getVhthaitounendo();

    public BizCurrency getVhttounendod();

    public C_NaiteiKakuteiKbn getVhtnaiteikakuteikbn();

    public BizDateY getVhttumitatenendo();

    public BizCurrency getVhttumitated();

    public BizDate getVhttumitatedtumitateymd();

    public BizDate getVhttumitatedshrkrkymd();

    public C_HaitoukinsksKbn getVhthaitoukinskskbn();
}
