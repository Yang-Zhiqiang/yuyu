package yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 不備メッセージ 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkHubiMsgConstants {

    public static final int PAGENO_INIT    = 1;

    public static final int PAGENO_HUBIMSG = 1;

    static final String FORWARDNAME_INIT    = "init";

    static final String FORWARDNAME_HUBIMSG = "HubiMsg";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skhubimsg", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_MOSNO = new Item("skhubimsg", "baseInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_HHKNNMKJ = new Item("skhubimsg", "baseInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEIHORYUUHUBI_MSGSYUBETU = new Item("skhubimsg", "ketteiHoryuuHubi", "msgsyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEIHORYUUHUBI_DISPHUBIMSGID = new Item("skhubimsg", "ketteiHoryuuHubi", "disphubimsgid", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEIHORYUUHUBI_DISPHUBIMSG = new Item("skhubimsg", "ketteiHoryuuHubi", "disphubimsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIRITUHORYUUHUBI_MSGSYUBETU = new Item("skhubimsg", "seirituHoryuuHubi", "msgsyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIRITUHORYUUHUBI_DISPHUBIMSGID = new Item("skhubimsg", "seirituHoryuuHubi", "disphubimsgid", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIRITUHORYUUHUBI_DISPHUBIMSG = new Item("skhubimsg", "seirituHoryuuHubi", "disphubimsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_WARNING_MSGSYUBETU = new Item("skhubimsg", "warning", "msgsyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_WARNING_DISPHUBIMSGID = new Item("skhubimsg", "warning", "disphubimsgid", null, ErrorMsgKbn.DISP);

    static final Item DDID_WARNING_DISPHUBIMSG = new Item("skhubimsg", "warning", "disphubimsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONHUBI_MSGSYUBETU = new Item("skhubimsg", "kihonHubi", "msgsyubetu", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONHUBI_DISPHUBIMSGID = new Item("skhubimsg", "kihonHubi", "disphubimsgid", null, ErrorMsgKbn.DISP);

    static final Item DDID_KIHONHUBI_DISPHUBIMSG = new Item("skhubimsg", "kihonHubi", "disphubimsg", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skhubimsg", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
