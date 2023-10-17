package yuyu.app.sinkeiyaku.sksonota.skseikyuusyosakusei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 新契約請求書作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkSeikyuusyoSakuseiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skseikyuusyosakusei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTKEY_MOSNO = new Item("skseikyuusyosakusei", "inputKey", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTKEY_SKSAKUSEISYORUIKBN = new Item("skseikyuusyosakusei", "inputKey", "sksakuseisyoruikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTKEY_KZSYURUIKBN = new Item("skseikyuusyosakusei", "inputKey", "kzsyuruikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("skseikyuusyosakusei", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skseikyuusyosakusei", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skseikyuusyosakusei", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
