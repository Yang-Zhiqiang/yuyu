package yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai;

import static yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai.GenSkStyjksyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 進捗状況照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/sksyoukai/skstyjksyoukai/SkStyjksyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/sinkeiyaku/sksyoukai/skstyjksyoukai/sk_styjksyoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/sksyoukai/skstyjksyoukai/sk_styjksyoukai.jsp"),
})
@Input("/sinkeiyaku/sksyoukai/skstyjksyoukai/sk_styjksyoukai.jsp")
@UIBean(beanClass=SkStyjksyoukaiUiBean.class)
public class SkStyjksyoukaiAction {

    @Inject
    private SkStyjksyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}