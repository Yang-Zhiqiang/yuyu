package yuyu.app.biz.bzmaster.bzketteisya;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 決定者登録 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzKetteisyaConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzketteisya", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_KETSYACD = new Item("bzketteisya", "keyInfo", "ketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_PALKETSYACD = new Item("bzketteisya", "keyInfo", "palketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_KETSYANM = new Item("bzketteisya", "keyInfo", "ketsyanm", null, ErrorMsgKbn.DD);

    static final Item DDID_KETTEISYAINFO_MOSTENKENRANKKBN = new Item("bzketteisya", "ketteisyaInfo", "mostenkenrankkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEISYAINFO_KNKSATEIRANKKBN = new Item("bzketteisya", "ketteisyaInfo", "knksateirankkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEISYAINFO_KNKSATEIJYGNS = new Item("bzketteisya", "ketteisyaInfo", "knksateijygns", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEISYAINFO_IMUSATEIRANKKBN = new Item("bzketteisya", "ketteisyaInfo", "imusateirankkbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEISYAINFO_IMUSATEIJYGNS = new Item("bzketteisya", "ketteisyaInfo", "imusateijygns", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("bzketteisya", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("bzketteisya", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("bzketteisya", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("bzketteisya", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
