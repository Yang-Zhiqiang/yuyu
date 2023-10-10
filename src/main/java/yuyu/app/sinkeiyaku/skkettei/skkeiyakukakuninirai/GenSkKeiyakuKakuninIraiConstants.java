package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninirai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約確認依頼入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkKeiyakuKakuninIraiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skkeiyakukakuninirai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("skkeiyakukakuninirai", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKIRAIKIHONINFO_MOSNO = new Item("skkeiyakukakuninirai", "kykIraiKihonInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKIRAIKIHONINFO_RENNO = new Item("skkeiyakukakuninirai", "kykIraiKihonInfo", "renno", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKIRAIKIHONINFO_HHKNNMKJ = new Item("skkeiyakukakuninirai", "kykIraiKihonInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKIRAIKAKUNININFO_KYKKAKSYRUI = new Item("skkeiyakukakuninirai", "kykIraiKakuninInfo", "kykkaksyrui", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKIRAIKAKUNININFO_KYKKAKKANYTYMD = new Item("skkeiyakukakuninirai", "kykIraiKakuninInfo", "kykkakkanytymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KYKIRAIKAKUNININFO_KYKKAKCOMMENT = new Item("skkeiyakukakuninirai", "kykIraiKakuninInfo", "kykkakcomment", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skkeiyakukakuninirai", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("skkeiyakukakuninirai", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("skkeiyakukakuninirai", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skkeiyakukakuninirai", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skkeiyakukakuninirai", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
