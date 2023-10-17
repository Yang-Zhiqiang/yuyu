package yuyu.app.siharai.sisatei.sisinsatyuuisetei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 審査注意設定 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiSinsaTyuuiSeteiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sisinsatyuuisetei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HKTSKKIHONINFO_SYONO = new Item("sisinsatyuuisetei", "hktskKihonInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SINSATYUUIINFO_SINSATYUUISETNM = new Item("sisinsatyuuisetei", "sinsaTyuuiInfo", "sinsatyuuisetnm", null, ErrorMsgKbn.DD);

    static final Item DDID_SINSATYUUIINFO_SOSIKINM = new Item("sisinsatyuuisetei", "sinsaTyuuiInfo", "sosikinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SINSATYUUIINFO_SINSATYUUISETKBN = new Item("sisinsatyuuisetei", "sinsaTyuuiInfo", "sinsatyuuisetkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SINSATYUUIINFO_SINSATYUUI = new Item("sisinsatyuuisetei", "sinsaTyuuiInfo", "sinsatyuui", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("sisinsatyuuisetei", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("sisinsatyuuisetei", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("sisinsatyuuisetei", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("sisinsatyuuisetei", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
