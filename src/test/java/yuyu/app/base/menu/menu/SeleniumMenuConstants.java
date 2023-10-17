package yuyu.app.base.menu.menu;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

public class SeleniumMenuConstants {

    public static final String LOGINUSERID            = "administrator";
    public static final String LOGINPASSWORD          = "password";

    public static final String LOGINGAMENHELINK       = "a";

    public static final Item DDID_LOGININPUT_USERID   = new Item("login", "loginInput", "userId", null, ErrorMsgKbn.DISP);
    public static final Item DDID_LOGININPUT_PASSWORD = new Item("login", "loginInput", "password", null, ErrorMsgKbn.DISP);

    public static final String LOGINBTN               = "loginBtn";
    public static final String ROLETOUROKULINK        = "menuContents[0].kinouNmSpan";
}
