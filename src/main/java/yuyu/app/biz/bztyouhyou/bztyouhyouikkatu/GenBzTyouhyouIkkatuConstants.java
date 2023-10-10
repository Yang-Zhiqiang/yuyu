package yuyu.app.biz.bztyouhyou.bztyouhyouikkatu;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 帳票一括出力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzTyouhyouIkkatuConstants {

    public static final int PAGENO_INIT              = 1;

    public static final int PAGENO_INPUTKEY          = 1;

    public static final int PAGENO_KENSAKURESULT     = 2;

    public static final int PAGENO_CONFIRM           = 3;

    public static final int PAGENO_RESULT            = 4;

    public static final int PAGENO_OUTPUTKENGENERROR = 5;

    static final String FORWARDNAME_INIT              = "init";

    static final String FORWARDNAME_INPUTKEY          = "InputKey";

    static final String FORWARDNAME_KENSAKURESULT     = "KensakuResult";

    static final String FORWARDNAME_CONFIRM           = "Confirm";

    static final String FORWARDNAME_RESULT            = "Result";

    static final String FORWARDNAME_OUTPUTKENGENERROR = "OutputKengenError";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bztyouhyouikkatu", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SUBSYSTEMID = new Item("bztyouhyouikkatu", "keyInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_TYOUHYOUSAKUSEIYMD = new Item("bztyouhyouikkatu", "keyInfo", "tyouhyousakuseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_SYORUINM = new Item("bztyouhyouikkatu", "keyInfo", "syoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_MISYUTURYOKUKENSUU = new Item("bztyouhyouikkatu", "keyInfo", "misyuturyokukensuu", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SAKUSEISOUKENSUU = new Item("bztyouhyouikkatu", "keyInfo", "sakuseisoukensuu", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTLIST_DISPSYORUINM = new Item("bztyouhyouikkatu", "searchResultList", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTLIST_DISPMISYUTURYOKUKENSUU = new Item("bztyouhyouikkatu", "searchResultList", "dispmisyuturyokukensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTLIST_DISPSAKUSEISOUKENSUU = new Item("bztyouhyouikkatu", "searchResultList", "dispsakuseisoukensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHKEYLIST_KNSKKMKNM1 = new Item("bztyouhyouikkatu", "searchKeyList", "knskkmknm1", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYLIST_KNSKKMKNM2 = new Item("bztyouhyouikkatu", "searchKeyList", "knskkmknm2", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYLIST_KNSKKMKNM3 = new Item("bztyouhyouikkatu", "searchKeyList", "knskkmknm3", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYLIST_KNSKKMKNM4 = new Item("bztyouhyouikkatu", "searchKeyList", "knskkmknm4", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHKEYLIST_KNSKKMKNM5 = new Item("bztyouhyouikkatu", "searchKeyList", "knskkmknm5", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYKENSAKU = new Item("bztyouhyouikkatu", "footerButtons2", "modorubtnbykensaku", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_MODORUBTNBYCONFIRM = new Item("bztyouhyouikkatu", "footerButtons3", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS3_KAKUTEIBTN = new Item("bztyouhyouikkatu", "footerButtons3", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SYOKIGAMENHEBTN = new Item("bztyouhyouikkatu", "footerButtons4", "syokigamenheBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS4_SEARCHRESULTHEMDRBTNBYKEKKA = new Item("bztyouhyouikkatu", "footerButtons4", "searchresulthemdrbtnbykekka", null, ErrorMsgKbn.DD);
}
