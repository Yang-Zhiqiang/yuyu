package yuyu.app.sinkeiyaku.sksonota.sktetudukityuui;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 新契約手続注意設定 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkTetudukiTyuuiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sktetudukityuui", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_MOSNO = new Item("sktetudukityuui", "keyInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_RENRAKUINFO_SKEITTDKKINKYUYOUHI = new Item("sktetudukityuui", "renrakuInfo", "skeittdkkinkyuyouhi", null, ErrorMsgKbn.DISP);

    static final Item DDID_RENRAKUINFO_SKEITTDKTYUUIYOUHI = new Item("sktetudukityuui", "renrakuInfo", "skeittdktyuuiyouhi", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_SKEITTDKTYUITRTNAIYO = new Item("sktetudukityuui", "toriatukaiTyuuiInfo", "skeittdktyuitrtnaiyo", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_DISPTRATKITYUUIDEL = new Item("sktetudukityuui", "toriatukaiTyuuiInfo", "disptratkityuuidel", null, ErrorMsgKbn.DISP);

    static final Item DDID_TORIATUKAITYUUIINFO_LINEHYOUJIFLAG = new Item("sktetudukityuui", "toriatukaiTyuuiInfo", "linehyoujiflag", null, ErrorMsgKbn.DD);

    static final Item DDID_TORIATUKAITYUUIBUTTONS_ADDBTNBYTORIATUKAITYUUIINFO = new Item("sktetudukityuui", "toriatukaiTyuuiButtons", "addbtnbytoriatukaityuuiinfo", null, ErrorMsgKbn.DD);

    static final Item DDID_SONOTATYUUIINFO_SKEITTDKTYUISTNAIYO = new Item("sktetudukityuui", "sonotaTyuuiInfo", "skeittdktyuistnaiyo", null, ErrorMsgKbn.DISP);

    static final Item DDID_SONOTATYUUIINFO_DISPSTTRATKITYUUIDEL = new Item("sktetudukityuui", "sonotaTyuuiInfo", "dispsttratkityuuidel", null, ErrorMsgKbn.DISP);

    static final Item DDID_SONOTATYUUIINFO_LINEHYOUJIFLAG = new Item("sktetudukityuui", "sonotaTyuuiInfo", "linehyoujiflag", null, ErrorMsgKbn.DD);

    static final Item DDID_SONOTATYUUIBUTTONS_ADDBTNBYSONOTATYUUIINFO = new Item("sktetudukityuui", "sonotaTyuuiButtons", "addbtnbysonotatyuuiinfo", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("sktetudukityuui", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("sktetudukityuui", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("sktetudukityuui", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("sktetudukityuui", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
