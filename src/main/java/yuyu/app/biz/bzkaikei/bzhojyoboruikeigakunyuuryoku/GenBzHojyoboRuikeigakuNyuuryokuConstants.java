package yuyu.app.biz.bzkaikei.bzhojyoboruikeigakunyuuryoku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 補助簿累計額入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzHojyoboRuikeigakuNyuuryokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_SELECTDATA    = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_SELECTDATA    = "SelectData";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzhojyoboruikeigakunyuuryoku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_SYUKANJOKAMOKUCD = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "syukanjokamokucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_KANJYOUKMKNM = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "kanjyoukmknm", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_KARIKATARUIGK = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "karikataruigk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_KASIKATARUIGK = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "kasikataruigk", null, ErrorMsgKbn.DISP);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_KARIKATATEISEIGK = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "karikatateiseigk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_KASIKATATEISEIGK = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "kasikatateiseigk", null, ErrorMsgKbn.DD);

    static final Item DDID_HOJYOBORUIKEIGAKUINFOLIST_TEISEILINK = new Item("bzhojyoboruikeigakunyuuryoku", "hojyoboRuikeigakuInfoList", "teiseilink", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTDATAINFO_DISPKANJYOUKAMOKU = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "dispkanjyoukamoku", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTDATAINFO_INPUTKANJYOUKAMOKU = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "inputkanjyoukamoku", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTDATAINFO_DISPKARIKATARUIGK = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "dispkarikataruigk", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTDATAINFO_DISPKASIKATARUIGK = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "dispkasikataruigk", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTDATAINFO_INPUTKARIKATATEISEIGK = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "inputkarikatateiseigk", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTDATAINFO_INPUTKASIKATATEISEIGK = new Item("bzhojyoboruikeigakunyuuryoku", "inputDataInfo", "inputkasikatateiseigk", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS1_MODORUBTNBYINPUTCONTENTS = new Item("bzhojyoboruikeigakunyuuryoku", "footerButtons1", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYCONFIRM = new Item("bzhojyoboruikeigakunyuuryoku", "footerButtons2", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_KAKUTEIBTN = new Item("bzhojyoboruikeigakunyuuryoku", "footerButtons2", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_SYOKIGAMENHEBTN = new Item("bzhojyoboruikeigakunyuuryoku", "footerButtons3", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BOTTOMBUTTONS_TEISEIGKSAKUJYOBTN = new Item("bzhojyoboruikeigakunyuuryoku", "bottomButtons", "teiseigksakujyobtn", null, ErrorMsgKbn.DD);
}
