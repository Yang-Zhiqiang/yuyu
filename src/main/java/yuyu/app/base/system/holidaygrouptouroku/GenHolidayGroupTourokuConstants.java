package yuyu.app.base.system.holidaygrouptouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 休日グループ登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenHolidayGroupTourokuConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("holidaygrouptouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HOLIDAYGROUPCD = new Item("holidaygrouptouroku", "keyInfo", "holidayGroupCd", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFOLIST_HOLIDAYGROUPCD = new Item("holidaygrouptouroku", "holidayGroupInfoList", "holidayGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFOLIST_HOLIDAYGROUPNM = new Item("holidaygrouptouroku", "holidayGroupInfoList", "holidayGroupNm", null, ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFOLIST_HOLIDAYGROUPDESCRIPTION = new Item("holidaygrouptouroku", "holidayGroupInfoList", "holidayGroupDescription", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYGROUPINFOLIST_HENKOULINK = new Item("holidaygrouptouroku", "holidayGroupInfoList", "henkouLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYGROUPINFOLIST_SAKUJYOLINK = new Item("holidaygrouptouroku", "holidayGroupInfoList", "sakujyoLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD = new Item("holidaygrouptouroku", "holidayGroupInfo", "holidayGroupCd", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM = new Item("holidaygrouptouroku", "holidayGroupInfo", "holidayGroupNm", "holidayGroup", ErrorMsgKbn.DD);

    static final Item DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION = new Item("holidaygrouptouroku", "holidayGroupInfo", "holidayGroupDescription", "holidayGroup", ErrorMsgKbn.DISP);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYINPUTCONTENTS = new Item("holidaygrouptouroku", "buttonInputContents", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("holidaygrouptouroku", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
