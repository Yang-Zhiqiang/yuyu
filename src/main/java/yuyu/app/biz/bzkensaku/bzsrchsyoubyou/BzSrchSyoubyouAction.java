package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

import static yuyu.app.biz.bzkensaku.bzsrchsyoubyou.GenBzSrchSyoubyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 傷病検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchsyoubyou/BzSrchSyoubyou.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchsyoubyou/bz_srch_syoubyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchsyoubyou/bz_srch_syoubyou.jsp"),
})
@Input("/biz/bzkensaku/bzsrchsyoubyou/bz_srch_syoubyou.jsp")
@UIBean(beanClass=BzSrchSyoubyouUiBean.class)
@Roles("bzsrchsyoubyou")
public class BzSrchSyoubyouAction {

    @Inject
    private BzSrchSyoubyouBizLogic bizLogic;

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
        bizLogic.doSearchBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
