package yuyu.app.sinkeiyaku.sknyuukin.skhenkin;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 返金入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkHenkinConstants {

    public static final int PAGENO_INIT           = 1;

    public static final int PAGENO_INPUTKEY       = 1;

    public static final int PAGENO_INPUTCONTENTS  = 2;

    public static final int PAGENO_CONFIRM        = 3;

    public static final int PAGENO_RESULT         = 4;

    static final String FORWARDNAME_INIT           = "init";

    static final String FORWARDNAME_INPUTKEY       = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS  = "InputContents";

    static final String FORWARDNAME_CONFIRM        = "Confirm";

    static final String FORWARDNAME_RESULT         = "Result";

    static final String FORWARDNAME_BACKTOWORKLIST = "backToWorkList";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skhenkin", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("skhenkin", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPJIMUTETUZUKINM = new Item("skhenkin", "kouteiInfo", "vktifdispjimutetuzukinm", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUTEIINFO_VKTIFDISPTASKNM = new Item("skhenkin", "kouteiInfo", "vktifdisptasknm", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_MOSNO = new Item("skhenkin", "baseInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_BASEINFO_KYKNMKJ = new Item("skhenkin", "baseInfo", "kyknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_SYORUITTYKYMDTIME = new Item("skhenkin", "syoruiInfoList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_SYORUINM = new Item("skhenkin", "syoruiInfoList", "syoruinm", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HTYSYORUIUMUKBN = new Item("skhenkin", "syoruiInfoList", "htysyoruiumukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINK = new Item("skhenkin", "syoruiInfoList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_HYOUJILINKFLG = new Item("skhenkin", "syoruiInfoList", "hyoujilinkflg", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORUIINFOLIST_IMAGEID = new Item("skhenkin", "syoruiInfoList", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONALLHYOUJI_ALLHYOUJIBTN = new Item("skhenkin", "buttonAllhyouji", "allhyoujibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENGROUP_IMAGEID = new Item("skhenkin", "hiddenGroup", "imageid", null, ErrorMsgKbn.DD);

    static final Item DDID_HENKININFO_HNKNGK = new Item("skhenkin", "henkinInfo", "hnkngk", null, ErrorMsgKbn.DD);

    static final Item DDID_HENKININFO_HNKNHOUKBN = new Item("skhenkin", "henkinInfo", "hnknhoukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_HENKININFO_HNKNKIBOUGK = new Item("skhenkin", "henkinInfo", "hnknkibougk", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_BANKCD = new Item("skhenkin", "bankInfo", "bankcd", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_BANKNMKJ = new Item("skhenkin", "bankInfo", "banknmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_SITENCD = new Item("skhenkin", "bankInfo", "sitencd", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_SITENNMKJ = new Item("skhenkin", "bankInfo", "sitennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_YOKINKBN = new Item("skhenkin", "bankInfo", "yokinkbn", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_KOUZANO = new Item("skhenkin", "bankInfo", "kouzano", null, ErrorMsgKbn.DD);

    static final Item DDID_BANKINFO_KZMEIGINMKN = new Item("skhenkin", "bankInfo", "kzmeiginmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skhenkin", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("skhenkin", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("skhenkin", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skhenkin", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skhenkin", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
