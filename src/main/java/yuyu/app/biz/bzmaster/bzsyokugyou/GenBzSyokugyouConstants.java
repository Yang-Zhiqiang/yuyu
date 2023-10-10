package yuyu.app.biz.bzmaster.bzsyokugyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 職業登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSyokugyouConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTKEY      = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTKEY      = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsyokugyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SYOKUGYOUCD = new Item("bzsyokugyou", "keyInfo", "syokugyoucd", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SYOKUGYOUNM = new Item("bzsyokugyou", "keyInfo", "syokugyounm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("bzsyokugyou", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("bzsyokugyou", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("bzsyokugyou", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("bzsyokugyou", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
