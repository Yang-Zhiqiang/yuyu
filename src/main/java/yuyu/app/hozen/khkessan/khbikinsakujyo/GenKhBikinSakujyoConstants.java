package yuyu.app.hozen.khkessan.khbikinsakujyo;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全備金削除 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhBikinSakujyoConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khbikinsakujyo", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SYONO = new Item("khbikinsakujyo", "baseInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_BKNCDKBN = new Item("khbikinsakujyo", "baseInfo", "bkncdkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BASEINFO_BKNKKTYMD = new Item("khbikinsakujyo", "baseInfo", "bknkktymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_BKNSYORIKBN = new Item("khbikinsakujyo", "baseInfo", "bknsyorikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BASEINFO_KESSANKIJYUNYMD = new Item("khbikinsakujyo", "baseInfo", "kessankijyunymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_BKNRIGIKBN = new Item("khbikinsakujyo", "bikinInfo", "bknrigikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_BKNGK = new Item("khbikinsakujyo", "bikinInfo", "bkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_CALCKIJYUNYMD = new Item("khbikinsakujyo", "bikinInfo", "calckijyunymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_KBNKEIRISEGCD = new Item("khbikinsakujyo", "bikinInfo", "kbnkeirisegcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_BIKININFO_SYOUHNCD = new Item("khbikinsakujyo", "bikinInfo", "syouhncd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_SHRSYORIYMD = new Item("khbikinsakujyo", "bikinInfo", "shrsyoriymd", null, ErrorMsgKbn.DD);

    static final Item DDID_BIKININFO_TYAKKINYMD = new Item("khbikinsakujyo", "bikinInfo", "tyakkinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("khbikinsakujyo", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUNINBTN = new Item("khbikinsakujyo", "footerButtons", "kakuninBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("khbikinsakujyo", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("khbikinsakujyo", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("khbikinsakujyo", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
