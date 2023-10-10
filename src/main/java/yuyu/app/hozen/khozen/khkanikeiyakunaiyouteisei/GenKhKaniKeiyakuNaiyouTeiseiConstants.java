package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全簡易契約内容訂正 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhKaniKeiyakuNaiyouTeiseiConstants {

    public static final int PAGENO_INIT      = 1;

    public static final int PAGENO_INPUTKEY  = 1;

    public static final int PAGENO_REFERENCE = 2;

    public static final int PAGENO_CONFIRM   = 3;

    public static final int PAGENO_RESULT    = 4;

    static final String FORWARDNAME_INIT      = "init";

    static final String FORWARDNAME_INPUTKEY  = "InputKey";

    static final String FORWARDNAME_REFERENCE = "Reference";

    static final String FORWARDNAME_CONFIRM   = "Confirm";

    static final String FORWARDNAME_RESULT    = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khkanikeiyakunaiyouteisei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUNAIYOUTEISEIINFO_SYONO = new Item("khkanikeiyakunaiyouteisei", "keiyakuNaiyouTeiseiInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_KEIYAKUNAIYOUTEISEIINFO_KYKNAIYOUTEISEISYORIKBN = new Item("khkanikeiyakunaiyouteisei", "keiyakuNaiyouTeiseiInfo", "kyknaiyouteiseisyorikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUNAIYOUTEISEIINFO_DISPKYKNYTSSYORIKBN = new Item("khkanikeiyakunaiyouteisei", "keiyakuNaiyouTeiseiInfo", "dispkyknytssyorikbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUNAIYOUTEISEIINFO_YENDTHNKYMD = new Item("khkanikeiyakunaiyouteisei", "keiyakuNaiyouTeiseiInfo", "yendthnkymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEIYAKUNAIYOUTEISEIINFO_TMTTKNKOURYOKUKAISIYMD = new Item("khkanikeiyakunaiyouteisei", "keiyakuNaiyouTeiseiInfo", "tmttknkouryokukaisiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYSYOUKAI = new Item("khkanikeiyakunaiyouteisei", "footerButtons2", "modorubtnbysyoukai", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("khkanikeiyakunaiyouteisei", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("khkanikeiyakunaiyouteisei", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("khkanikeiyakunaiyouteisei", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
