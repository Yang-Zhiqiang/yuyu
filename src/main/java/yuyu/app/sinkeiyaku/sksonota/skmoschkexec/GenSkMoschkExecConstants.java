package yuyu.app.sinkeiyaku.sksonota.skmoschkexec;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 申込内容チェック実行 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkMoschkExecConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skmoschkexec", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("skmoschkexec", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_MOSNO = new Item("skmoschkexec", "keyInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HHKNNMKJ = new Item("skmoschkexec", "keyInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("skmoschkexec", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skmoschkexec", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skmoschkexec", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skmoschkexec", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
