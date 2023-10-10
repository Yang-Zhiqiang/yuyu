package yuyu.app.base.system.usertouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザー登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserTourokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTKEY      = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTKEY      = "inputKey";

    static final String FORWARDNAME_INPUTCONTENTS = "inputContents";

    static final String FORWARDNAME_CONFIRM       = "confirm";

    static final String FORWARDNAME_RESULT        = "result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("usertouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOINPUT_USERID = new Item("usertouroku", "keyInfoInput", "userId", "user", ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOINPUT_USERNM = new Item("usertouroku", "keyInfoInput", "userNm", "user", ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOCONFIRM_USERID = new Item("usertouroku", "keyInfoConfirm", "userId", "user", ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOCONFIRM_USERNM = new Item("usertouroku", "keyInfoConfirm", "userNm", "user", ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOSOSIKICDCONFIRM_SRCHSOSIKICD = new Item("usertouroku", "keyInfoSosikicdConfirm", "srchsosikicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_CHECKBUTTONS_ALLCHECKBTN = new Item("usertouroku", "checkButtons", "allCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_CHECKBUTTONS_ALLUNCHECKBTN = new Item("usertouroku", "checkButtons", "allUnCheckBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_ROLEINFO_COMMONCHECKBOX = new Item("usertouroku", "roleInfo", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_ROLEINFO_ROLECD = new Item("usertouroku", "roleInfo", "roleCd", null, ErrorMsgKbn.DD);

    static final Item DDID_ROLEINFO_ROLENM = new Item("usertouroku", "roleInfo", "roleNm", null, ErrorMsgKbn.DD);

    static final Item DDID_ROLEINFO_ROLESETUMEI = new Item("usertouroku", "roleInfo", "roleSetumei", null, ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("usertouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("usertouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
