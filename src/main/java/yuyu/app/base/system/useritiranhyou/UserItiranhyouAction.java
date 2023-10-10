package yuyu.app.base.system.useritiranhyou;

import static yuyu.app.base.system.useritiranhyou.GenUserItiranhyouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * ユーザー一覧表 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,    page=PAGENO_INIT,    path="/base/system/useritiranhyou/UserItiranhyou.do", redirect=true),
    @Forward(name=FORWARDNAME_CONFIRM, page=PAGENO_CONFIRM, path="/base/system/useritiranhyou/user_itiranhyou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,  page=PAGENO_RESULT,  path="/base/system/useritiranhyou/user_itiranhyou.jsp"),
})
@Input("/base/system/useritiranhyou/user_itiranhyou.jsp")
@UIBean(beanClass=UserItiranhyouUiBean.class)
@Roles("useritiranhyou")
public class UserItiranhyouAction {

    @Inject
    private UserItiranhyouBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.execPrePrint();

        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print(){
        bizLogic.printOut();
    }
}
