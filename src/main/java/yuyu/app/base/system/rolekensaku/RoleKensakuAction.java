package yuyu.app.base.system.rolekensaku;

import static yuyu.app.base.system.rolekensaku.GenRoleKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ロール検索 機能のアクションクラスです。
 */

@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/base/system/rolekensaku/RoleKensaku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/base/system/rolekensaku/role_kensaku.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/base/system/rolekensaku/role_kensaku.jsp"),
})
@Input("/base/system/rolekensaku/role_kensaku.jsp")
@UIBean(beanClass=RoleKensakuUiBean.class)
@Roles("rolekensaku")
public class RoleKensakuAction {

    @Inject
    private RoleKensakuBizLogic bizLogic;

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

        bizLogic.searchRole();
        return FORWARDNAME_INPUTKEY;
    }

    public String roleInfoPagerOnClick() {

        return FORWARDNAME_CURRENT;
    }
}
