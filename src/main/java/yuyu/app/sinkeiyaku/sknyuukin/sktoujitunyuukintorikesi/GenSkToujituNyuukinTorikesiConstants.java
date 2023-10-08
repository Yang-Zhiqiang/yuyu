package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 当日入金取消 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkToujituNyuukinTorikesiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sktoujitunyuukintorikesi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("sktoujitunyuukintorikesi", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_MOSNO = new Item("sktoujitunyuukintorikesi", "baseInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_KYKNMKJ = new Item("sktoujitunyuukintorikesi", "baseInfo", "kyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUUKINJYOUHOULIST_DUMMYKMK = new Item("sktoujitunyuukintorikesi", "nyuukinJyouhouList", "dummykmk", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUUKINJYOUHOULIST_RSGAKU = new Item("sktoujitunyuukintorikesi", "nyuukinJyouhouList", "rsgaku", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUUKINJYOUHOULIST_TYAKKINYMD = new Item("sktoujitunyuukintorikesi", "nyuukinJyouhouList", "tyakkinymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUUKINJYOUHOULIST_NYKNSYUBETU = new Item("sktoujitunyuukintorikesi", "nyuukinJyouhouList", "nyknsyubetu", null, ErrorMsgKbn.DD);

    static final Item DDID_NYUUKINJYOUHOULIST_SENTAKULINK = new Item("sktoujitunyuukintorikesi", "nyuukinJyouhouList", "sentakulink", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("sktoujitunyuukintorikesi", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("sktoujitunyuukintorikesi", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("sktoujitunyuukintorikesi", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTNBYCONFIRM = new Item("sktoujitunyuukintorikesi", "footerButtons3", "kakuteibtnbyconfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("sktoujitunyuukintorikesi", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
