package yuyu.app.base.system.kadoutimegrouptouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 稼働時間グループ登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKadouTimeGroupTourokuConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("kadoutimegrouptouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KADOUTIMEGROUPCD = new Item("kadoutimegrouptouroku", "keyInfo", "kadouTimeGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFOINPUTCONTENTS_KADOUTIMEGROUPCD = new Item("kadoutimegrouptouroku", "keyInfoInputContents", "kadouTimeGroupCd", "kadouTimeGroup", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfoList", "kadouTimeGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPNM = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfoList", "kadouTimeGroupNm", null, ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPDESCRIPTION = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfoList", "kadouTimeGroupDescription", null, ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPINFOLIST_HENKOULINK = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfoList", "henkouLink", null, ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFOLIST_SAKUJYOLINK = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfoList", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfo", "kadouTimeGroupNm", "kadouTimeGroup", ErrorMsgKbn.DD);

    static final Item DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfo", "holidayGroupCd", "kadouTimeGroup", ErrorMsgKbn.DISP);

    static final Item DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION = new Item("kadoutimegrouptouroku", "kadouTimeGroupInfo", "kadouTimeGroupDescription", "kadouTimeGroup", ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("kadoutimegrouptouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("kadoutimegrouptouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
