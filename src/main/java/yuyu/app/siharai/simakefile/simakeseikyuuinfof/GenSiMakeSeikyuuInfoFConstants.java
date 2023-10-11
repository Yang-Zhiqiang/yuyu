package yuyu.app.siharai.simakefile.simakeseikyuuinfof;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 請求情報ファイル作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiMakeSeikyuuInfoFConstants {

    public static final int PAGENO_INIT            = 1;

    public static final int PAGENO_INPUTCONDITIONS = 1;

    public static final int PAGENO_CONFIRM         = 2;

    public static final int PAGENO_RESULT          = 3;

    static final String FORWARDNAME_INIT            = "init";

    static final String FORWARDNAME_INPUTCONDITIONS = "InputConditions";

    static final String FORWARDNAME_CONFIRM         = "Confirm";

    static final String FORWARDNAME_RESULT          = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("simakeseikyuuinfof", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_OUTCONDITIONS_SIHARAISYORIJYOUTAIKBN = new Item("simakeseikyuuinfof", "outConditions", "siharaisyorijyoutaikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_OUTCONDITIONS_SIBOUYMDFROM = new Item("simakeseikyuuinfof", "outConditions", "sibouymdfrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_OUTCONDITIONS_SIBOUYMDTO = new Item("simakeseikyuuinfof", "outConditions", "sibouymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_OUTCONDITIONS_SIBOUKARIYMDFROM = new Item("simakeseikyuuinfof", "outConditions", "siboukariymdfrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_OUTCONDITIONS_SIBOUKARIYMDTO = new Item("simakeseikyuuinfof", "outConditions", "siboukariymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_OUTCONDITIONS_SYORUIUKEYMDFROM = new Item("simakeseikyuuinfof", "outConditions", "syoruiukeymdfrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_OUTCONDITIONS_SYORUIUKEYMDTO = new Item("simakeseikyuuinfof", "outConditions", "syoruiukeymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_OUTCONDITIONS_SHRYMDFROM = new Item("simakeseikyuuinfof", "outConditions", "shrymdfrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_OUTCONDITIONS_SHRYMDTO = new Item("simakeseikyuuinfof", "outConditions", "shrymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTN = new Item("simakeseikyuuinfof", "footerButtons2", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_KAKUTEIBTN = new Item("simakeseikyuuinfof", "footerButtons2", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_SYOKIGAMENHEBTN = new Item("simakeseikyuuinfof", "footerButtons3", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
