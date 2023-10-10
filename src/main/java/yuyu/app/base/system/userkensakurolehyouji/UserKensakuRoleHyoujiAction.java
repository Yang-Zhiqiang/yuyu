package yuyu.app.base.system.userkensakurolehyouji;

import static yuyu.app.base.system.userkensakurolehyouji.GenUserKensakuRoleHyoujiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * ユーザー検索（ロール表示用） 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/base/system/userkensakurolehyouji/UserKensakuRoleHyouji.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/base/system/userkensakurolehyouji/user_kensaku_role_hyouji.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/base/system/userkensakurolehyouji/user_kensaku_role_hyouji.jsp"),
})
@Input("/base/system/userkensakurolehyouji/user_kensaku_role_hyouji.jsp")
@UIBean(beanClass=UserKensakuRoleHyoujiUiBean.class)
public class UserKensakuRoleHyoujiAction {

    @Inject
    private UserKensakuRoleHyoujiBizLogic bizLogic;

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

    public String userAndUserRoleInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
