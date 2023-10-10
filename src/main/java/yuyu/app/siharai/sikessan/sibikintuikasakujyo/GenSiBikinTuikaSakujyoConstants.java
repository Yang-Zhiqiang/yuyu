package yuyu.app.siharai.sikessan.sibikintuikasakujyo;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 保険金給付金備金追加削除 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiBikinTuikaSakujyoConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sibikintuikasakujyo", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SIBIKINTUIKASAKUJYOINFO_SYONO = new Item("sibikintuikasakujyo", "siBikinTuikaSakujyoInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SIBIKINTUIKASAKUJYOINFO_SKNO = new Item("sibikintuikasakujyo", "siBikinTuikaSakujyoInfo", "skno", null, ErrorMsgKbn.DD);

    static final Item DDID_SIBIKINTUIKASAKUJYOINFO_BKNSYORIKBN = new Item("sibikintuikasakujyo", "siBikinTuikaSakujyoInfo", "bknsyorikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SIBIKINTUIKASAKUJYOINFO_BKNCDKBN = new Item("sibikintuikasakujyo", "siBikinTuikaSakujyoInfo", "bkncdkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SIBIKINTUIKASAKUJYOINFO_KESSANKIJYUNYMD = new Item("sibikintuikasakujyo", "siBikinTuikaSakujyoInfo", "kessankijyunymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_BKNRIGIKBN = new Item("sibikintuikasakujyo", "bikouInfo", "bknrigikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_BKNGK = new Item("sibikintuikasakujyo", "bikouInfo", "bkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_BKNKKTYMD = new Item("sibikintuikasakujyo", "bikouInfo", "bknkktymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_CALCKIJYUNYMD = new Item("sibikintuikasakujyo", "bikouInfo", "calckijyunymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_SHRUMU = new Item("sibikintuikasakujyo", "bikouInfo", "shrumu", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_SOUKIUMUKBN = new Item("sibikintuikasakujyo", "bikouInfo", "soukiumukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_SHRSYORIYMD = new Item("sibikintuikasakujyo", "bikouInfo", "shrsyoriymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_TYAKKINYMD = new Item("sibikintuikasakujyo", "bikouInfo", "tyakkinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_BIKOUINFO_SHRTUUKASYU = new Item("sibikintuikasakujyo", "bikouInfo", "shrtuukasyu", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKOUINFO_SYORUIUKEYMD = new Item("sibikintuikasakujyo", "bikouInfo", "syoruiukeymd", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sibikintuikasakujyo", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sibikintuikasakujyo", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sibikintuikasakujyo", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sibikintuikasakujyo", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
