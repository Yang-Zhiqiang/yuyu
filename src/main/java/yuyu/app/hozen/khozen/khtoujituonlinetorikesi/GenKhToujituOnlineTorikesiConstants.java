package yuyu.app.hozen.khozen.khtoujituonlinetorikesi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全当日オンライン取消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhToujituOnlineTorikesiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khtoujituonlinetorikesi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIKESISYORIINFO_SYONO = new Item("khtoujituonlinetorikesi", "torikesiSyoriInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIKESISYORIINFO_TRKSKINOUID = new Item("khtoujituonlinetorikesi", "torikesiSyoriInfo", "trkskinouid", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("khtoujituonlinetorikesi", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("khtoujituonlinetorikesi", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("khtoujituonlinetorikesi", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
