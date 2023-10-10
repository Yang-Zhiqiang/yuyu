package yuyu.app.base.menu.menu;

import static yuyu.app.base.menu.menu.GenMenuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * メニュー 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/menu/menu/Menu.do", redirect=true),
    @Forward(name=FORWARDNAME_MENU,          page=PAGENO_MENU,          path="/base/menu/menu/menu.jsp"),
    @Forward(name=FORWARDNAME_MYMENUTOUROKU, page=PAGENO_MYMENUTOUROKU, path="/base/menu/menu/menu.jsp"),
})
@Input("/base/menu/menu/menu.jsp")
@UIBean(beanClass=MenuUiBean.class)
public class MenuAction {

    @Inject
    private MenuBizLogic bizLogic;

    public String init() {

        bizLogic.createMenu();
        return FORWARDNAME_MENU;
    }

    public String tojiruBtnOnClick() {
        bizLogic.close();
        return null;
    }

    @Begin(join=true)
    public String myMenuTourokuBtnOnClick() {
        bizLogic.createMenu();
        return FORWARDNAME_MYMENUTOUROKU;
    }

    @End
    public String torikesiBtnOnClick() {
        return FORWARDNAME_MENU;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.registerMyMenu();
        return FORWARDNAME_MENU;
    }
}
