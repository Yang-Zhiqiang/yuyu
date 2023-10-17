package yuyu.app.sinkeiyaku.sknyuukin.sknyuukin;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 入金入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkNyuukinConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sknyuukin", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("sknyuukin", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_TYAKKINYMD = new Item("sknyuukin", "baseInfo", "tyakkinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_BASEINFO_RSTUUKASYU = new Item("sknyuukin", "baseInfo", "rstuukasyu", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONINFO_MOSNO = new Item("sknyuukin", "kihonInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_RSGAKU = new Item("sknyuukin", "kihonInfo", "rsgaku", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_RYOSYUYMD = new Item("sknyuukin", "kihonInfo", "ryosyuymd", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_NYKNSYUBETU = new Item("sknyuukin", "kihonInfo", "nyknsyubetu", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_TOKUSYUJMUM = new Item("sknyuukin", "kihonInfo", "tokusyujmum", null, ErrorMsgKbn.DD);

    static final Item DDID_KIHONINFO_TOKUSYUJMUMKBN = new Item("sknyuukin", "kihonInfo", "tokusyujmumkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("sknyuukin", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sknyuukin", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sknyuukin", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sknyuukin", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sknyuukin", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_NAIYOUNYUURYOKUGAMENHEBTN = new Item("sknyuukin", "footerButtons", "naiyounyuuryokugamenheBtn", null, ErrorMsgKbn.DD);
}
