package yuyu.app.direct.dskokyakukanri.dskokyakutouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 顧客登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenDsKokyakuTourokuConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("dskokyakutouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_SYONO = new Item("dskokyakutouroku", "baseInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_TOUGOUMAEDSKOKNO = new Item("dskokyakutouroku", "baseInfo", "tougoumaedskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKNMKJ = new Item("dskokyakutouroku", "hozenInfo", "kyknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKNMKN = new Item("dskokyakutouroku", "hozenInfo", "kyknmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOZENINFO_KYKSEIYMD = new Item("dskokyakutouroku", "hozenInfo", "kykseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOZENINFO_TSINYNO = new Item("dskokyakutouroku", "hozenInfo", "tsinyno", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKINFO_DSKOKYAKUNMKJ = new Item("dskokyakutouroku", "dskokInfo", "dskokyakunmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKINFO_DSKOKYAKUNMKN = new Item("dskokyakutouroku", "dskokInfo", "dskokyakunmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKINFO_DSKOKYAKUSEIYMD = new Item("dskokyakutouroku", "dskokInfo", "dskokyakuseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKINFO_DSKOKYAKUYNO = new Item("dskokyakutouroku", "dskokInfo", "dskokyakuyno", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORISENNTAKU_DSSYORIKBN = new Item("dskokyakutouroku", "syorisenntaku", "dssyorikbn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSKOKYAKUJYOUTAI_DSKANYUUKEIROKBN = new Item("dskokyakutouroku", "dskokyakujyoutai", "dskanyuukeirokbn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOKYAKUTOUGOUSAKI_TOUGOUSAKIDSKOKNO = new Item("dskokyakutouroku", "kokyakutougousaki", "tougousakidskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("dskokyakutouroku", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("dskokyakutouroku", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("dskokyakutouroku", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("dskokyakutouroku", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
