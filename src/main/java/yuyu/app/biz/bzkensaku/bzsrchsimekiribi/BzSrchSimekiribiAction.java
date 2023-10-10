package yuyu.app.biz.bzkensaku.bzsrchsimekiribi;

import static yuyu.app.biz.bzkensaku.bzsrchsimekiribi.GenBzSrchSimekiribiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 締切日検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchsimekiribi/BzSrchSimekiribi.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchsimekiribi/bz_srch_simekiribi.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchsimekiribi/bz_srch_simekiribi.jsp"),
})
@Input("/biz/bzkensaku/bzsrchsimekiribi/bz_srch_simekiribi.jsp")
@UIBean(beanClass=BzSrchSimekiribiUiBean.class)
@Roles("bzsrchsimekiribi")
public class BzSrchSimekiribiAction {

    @Inject
    private BzSrchSimekiribiBizLogic bizLogic;

    @Begin(renew = true)
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.doSearchBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}