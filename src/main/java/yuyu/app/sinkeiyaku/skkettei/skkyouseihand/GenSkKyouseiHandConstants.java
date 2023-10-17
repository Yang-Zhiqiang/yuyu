package yuyu.app.sinkeiyaku.skkettei.skkyouseihand;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 強制ハンド決定入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkKyouseiHandConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_CONFIRM  = 2;

    public static final int PAGENO_RESULT   = 3;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_CONFIRM  = "Confirm";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skkyouseihand", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONHUBISYOUSAI_HUBISYOUSAIBTN = new Item("skkyouseihand", "buttonHubisyousai", "hubisyousaibtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_MOSNO = new Item("skkyouseihand", "keyInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_HHKNNMKJ = new Item("skkyouseihand", "keyInfo", "hhknnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENIRAI_MOSTENKENKEKKAKBN = new Item("skkyouseihand", "mosTenkenIrai", "mostenkenkekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENIRAI_MOSTENKENTNSKETSYACD = new Item("skkyouseihand", "mosTenkenIrai", "mostenkentnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_MOSTENKENIRAI_MOSTENKENCOMMENTGAMEN = new Item("skkyouseihand", "mosTenkenIrai", "mostenkencommentgamen", null, ErrorMsgKbn.DISP);

    static final Item DDID_KNKSATEIIRAI_KNKSATEIKEKKAKBN = new Item("skkyouseihand", "knkSateiIrai", "knksateikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KNKSATEIIRAI_KNKTNSKETSYACD = new Item("skkyouseihand", "knkSateiIrai", "knktnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KNKSATEIIRAI_KNKSATEIIRAICOMMENT = new Item("skkyouseihand", "knkSateiIrai", "knksateiiraicomment", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEIIRAI_IMUSATEIKEKKAKBN = new Item("skkyouseihand", "imuSateiIrai", "imusateikekkakbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEIIRAI_IMUTNSKETSYACD = new Item("skkyouseihand", "imuSateiIrai", "imutnsketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_IMUSATEIIRAI_IMUSATEIIRAICOMMENT = new Item("skkyouseihand", "imuSateiIrai", "imusateiiraicomment", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("skkyouseihand", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("skkyouseihand", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("skkyouseihand", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("skkyouseihand", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
