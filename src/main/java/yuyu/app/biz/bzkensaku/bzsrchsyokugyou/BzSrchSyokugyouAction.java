package yuyu.app.biz.bzkensaku.bzsrchsyokugyou;

import static yuyu.app.biz.bzkensaku.bzsrchsyokugyou.GenBzSrchSyokugyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
/**
 * 職業検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchsyokugyou/BzSrchSyokugyou.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchsyokugyou/bz_srch_syokugyou.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchsyokugyou/bz_srch_syokugyou.jsp"),
})
@Input("/biz/bzkensaku/bzsrchsyokugyou/bz_srch_syokugyou.jsp")
@UIBean(beanClass=BzSrchSyokugyouUiBean.class)
@Roles("bzsrchsyokugyou")
public class BzSrchSyokugyouAction {

    @Inject
    private BzSrchSyokugyouBizLogic bizLogic;

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
