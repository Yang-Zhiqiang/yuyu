package yuyu.app.base.system.userkensaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザー検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserKensakuConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "inputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("userkensaku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERID = new Item("userkensaku", "searchInfo", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERNM = new Item("userkensaku", "searchInfo", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SRCHSOSIKICD = new Item("userkensaku", "searchInfo", "srchsosikicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_USERINFO_USERID = new Item("userkensaku", "userInfo", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_USERINFO_USERNM = new Item("userkensaku", "userInfo", "userNm", null, ErrorMsgKbn.DD);
}
