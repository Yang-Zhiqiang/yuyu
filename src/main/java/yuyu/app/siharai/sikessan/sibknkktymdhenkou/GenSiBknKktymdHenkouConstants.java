package yuyu.app.siharai.sikessan.sibknkktymdhenkou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 備金確定日変更 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiBknKktymdHenkouConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sibknkktymdhenkou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_SYONO = new Item("sibknkktymdhenkou", "kihonInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_SKNO = new Item("sibknkktymdhenkou", "kihonInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUSYAINFO_KYKNMKN = new Item("sibknkktymdhenkou", "keiyakusyaInfo", "kyknmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUSYAINFO_KYKNMKJ = new Item("sibknkktymdhenkou", "keiyakusyaInfo", "kyknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUSYAINFO_KYKSEIYMD = new Item("sibknkktymdhenkou", "keiyakusyaInfo", "kykseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUSYAINFO_KYKSEI = new Item("sibknkktymdhenkou", "keiyakusyaInfo", "kyksei", null, ErrorMsgKbn.DISP);

    static final Item DDID_HIHOKENSYAINFO_HHKNNMKN = new Item("sibknkktymdhenkou", "hihokensyaInfo", "hhknnmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIHOKENSYAINFO_HHKNNMKJ = new Item("sibknkktymdhenkou", "hihokensyaInfo", "hhknnmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_HIHOKENSYAINFO_HHKNSEIYMD = new Item("sibknkktymdhenkou", "hihokensyaInfo", "hhknseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_HIHOKENSYAINFO_HHKNSEI = new Item("sibknkktymdhenkou", "hihokensyaInfo", "hhknsei", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFOBEFORE_SIBOUKARITRKYMD = new Item("sibknkktymdhenkou", "bikouInfoBefore", "siboukaritrkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_BIKOUINFOAFTER_BKNKKTYMD = new Item("sibknkktymdhenkou", "bikouInfoAfter", "bknkktymd", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sibknkktymdhenkou", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sibknkktymdhenkou", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sibknkktymdhenkou", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sibknkktymdhenkou", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
