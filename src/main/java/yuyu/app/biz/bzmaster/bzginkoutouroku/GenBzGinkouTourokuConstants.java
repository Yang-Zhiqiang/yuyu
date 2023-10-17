package yuyu.app.biz.bzmaster.bzginkoutouroku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 銀行登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzGinkouTourokuConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_INPUTKEY       = 1;

    public static final int PAGENO_INPUTCONTENTS1 = 2;

    public static final int PAGENO_INPUTCONTENTS2 = 3;

    public static final int PAGENO_CONFIRM        = 4;

    public static final int PAGENO_RESULT         = 5;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_INPUTKEY       = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS1 = "InputContents1";

    static final String FORWARDNAME_INPUTCONTENTS2 = "InputContents2";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzginkoutouroku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_BANKTRKTAISYOUKBN = new Item("bzginkoutouroku", "searchConditions", "banktrktaisyoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_GINKOUINFO_BANKCD = new Item("bzginkoutouroku", "ginkouInfo", "bankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_GINKOUINFO_BANKNMKJ = new Item("bzginkoutouroku", "ginkouInfo", "banknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_GINKOUINFO_BANKNMKN = new Item("bzginkoutouroku", "ginkouInfo", "banknmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_SITENINFO_SITENCD = new Item("bzginkoutouroku", "sitenInfo", "sitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SITENINFO_SITENNMKJ = new Item("bzginkoutouroku", "sitenInfo", "sitennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_SITENINFO_SITENNMKN = new Item("bzginkoutouroku", "sitenInfo", "sitennmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("bzginkoutouroku", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("bzginkoutouroku", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("bzginkoutouroku", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("bzginkoutouroku", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
