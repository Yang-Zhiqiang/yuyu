package yuyu.app.base.system.userkensaku;

import static yuyu.app.base.system.userkensaku.GenUserKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ユーザー検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/base/system/userkensaku/UserKensaku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/base/system/userkensaku/user_kensaku.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/base/system/userkensaku/user_kensaku.jsp"),
})
@Input("/base/system/userkensaku/user_kensaku.jsp")
@UIBean(beanClass=UserKensakuUiBean.class)
@Roles("userkensaku")
public class UserKensakuAction {

    @Inject
    private UserKensakuBizLogic bizLogic;

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
        bizLogic.searchUser();
        return FORWARDNAME_INPUTKEY;
    }

    public String userInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
