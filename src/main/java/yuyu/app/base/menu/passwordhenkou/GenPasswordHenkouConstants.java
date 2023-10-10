package yuyu.app.base.menu.passwordhenkou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * パスワード変更 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenPasswordHenkouConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTCONTENTS = 1;

    public static final int PAGENO_RESULT        = 2;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("passwordhenkou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_PASSWORDINPUT_USERNM = new Item("passwordhenkou", "passwordInput", "userNm", "user", ErrorMsgKbn.DD);

    static final Item DDID_PASSWORDINPUT_OLDPASSWORD = new Item("passwordhenkou", "passwordInput", "oldPassword", null, ErrorMsgKbn.DD);

    static final Item DDID_PASSWORDINPUT_PASSWORD = new Item("passwordhenkou", "passwordInput", "password", null, ErrorMsgKbn.DD);

    static final Item DDID_PASSWORDINPUT_PASSWORDKAKUNIN = new Item("passwordhenkou", "passwordInput", "passwordKakunin", null, ErrorMsgKbn.DD);

    static final Item DDID_PASSWORDINPUT_PASSWORDKEKKA = new Item("passwordhenkou", "passwordInput", "passwordKekka", null, ErrorMsgKbn.DD);
}
