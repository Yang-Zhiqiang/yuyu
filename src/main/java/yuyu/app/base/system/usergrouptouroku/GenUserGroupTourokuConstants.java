package yuyu.app.base.system.usergrouptouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザーグループ登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserGroupTourokuConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("usergrouptouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_USERGROUPINFO_USERGROUPCD = new Item("usergrouptouroku", "userGroupInfo", "userGroupCd", "userGroup", ErrorMsgKbn.DD);

    static final Item DDID_USERGROUPINFO_USERGROUPNM = new Item("usergrouptouroku", "userGroupInfo", "userGroupNm", "userGroup", ErrorMsgKbn.DD);

    static final Item DDID_USERGROUPINFO_USERGROUPSETUMEI = new Item("usergrouptouroku", "userGroupInfo", "userGroupSetumei", "userGroup", ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("usergrouptouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("usergrouptouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
