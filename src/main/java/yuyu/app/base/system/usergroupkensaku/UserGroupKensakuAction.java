package yuyu.app.base.system.usergroupkensaku;

import static yuyu.app.base.system.usergroupkensaku.GenUserGroupKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ユーザーグループ検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,    page=PAGENO_INIT,   path="/base/system/usergroupkensaku/UserGroupKensaku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                     path="/base/system/usergroupkensaku/user_group_kensaku.jsp"),
    @Forward(name=FORWARDNAME_SEARCH,  page=PAGENO_SEARCH, path="/base/system/usergroupkensaku/user_group_kensaku.jsp"),
})
@Input("/base/system/usergroupkensaku/user_group_kensaku.jsp")
@UIBean(beanClass=UserGroupKensakuUiBean.class)
@Roles("usergroupkensaku")
public class UserGroupKensakuAction {

    @Inject
    private UserGroupKensakuBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SEARCH;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.searchUserGroup();
        return FORWARDNAME_SEARCH;
    }

    public String userGroupInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
