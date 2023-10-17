package yuyu.app.biz.bzmaster.bzsimekiribi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 締切日登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSimekiribiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsimekiribi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_BOSYUUYM = new Item("bzsimekiribi", "keyInfo", "bosyuuym", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SEARCHBTN = new Item("bzsimekiribi", "keyInfo", "searchBtn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SIMEKIRIBIINFO_MOSSIMEFROMYMD = new Item("bzsimekiribi", "simekiribiInfo", "mossimefromymd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SIMEKIRIBIINFO_MOSSIMETOYMD = new Item("bzsimekiribi", "simekiribiInfo", "mossimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SIMEKIRIBIINFO_MOSNRKSIMEFROMYMD = new Item("bzsimekiribi", "simekiribiInfo", "mosnrksimefromymd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SIMEKIRIBIINFO_MOSNRKSIMETOYMD = new Item("bzsimekiribi", "simekiribiInfo", "mosnrksimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SIMEKIRIBIINFO_NYKNSIMEFROMYMD = new Item("bzsimekiribi", "simekiribiInfo", "nyknsimefromymd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SIMEKIRIBIINFO_NYKNSIMETOYMD = new Item("bzsimekiribi", "simekiribiInfo", "nyknsimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SIMEKIRIBIINFO_SYORISIMEFROMYMD = new Item("bzsimekiribi", "simekiribiInfo", "syorisimefromymd", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SIMEKIRIBIINFO_SYORISIMETOYMD = new Item("bzsimekiribi", "simekiribiInfo", "syorisimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("bzsimekiribi", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("bzsimekiribi", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("bzsimekiribi", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("bzsimekiribi", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
