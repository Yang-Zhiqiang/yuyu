package yuyu.app.hozen.khozen.khsouhuannaisakusei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 送付案内作成 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhSouhuannaiSakuseiConstants {

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

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khsouhuannaisakusei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SYONO = new Item("khsouhuannaisakusei", "keyInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SOUHUSAKIMEI_SHSNMKJ = new Item("khsouhuannaisakusei", "souhusakimei", "shsnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUHUSAKIJYUUSYOINFO_SHSKYNO = new Item("khsouhuannaisakusei", "souhusakiJyuusyoInfo", "shskyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUHUSAKIJYUUSYOINFO_SHSADR1KJ = new Item("khsouhuannaisakusei", "souhusakiJyuusyoInfo", "shsadr1kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SOUHUSAKIJYUUSYOINFO_SHSADR2KJ = new Item("khsouhuannaisakusei", "souhusakiJyuusyoInfo", "shsadr2kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SOUHUSAKIJYUUSYOINFO_SHSADR3KJ = new Item("khsouhuannaisakusei", "souhusakiJyuusyoInfo", "shsadr3kj", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SOUHUANNAIINJINAIYOU_HANYOUSHANNAITYOUHYOUNM = new Item("khsouhuannaisakusei", "souhuAnnaiInjiNaiyou", "hanyoushannaityouhyounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUHUANNAIINJINAIYOU_HANYOUSHANNAIINJINAIYOU = new Item("khsouhuannaisakusei", "souhuAnnaiInjiNaiyou", "hanyoushannaiinjinaiyou", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("khsouhuannaisakusei", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("khsouhuannaisakusei", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_KAKUTEIBTN = new Item("khsouhuannaisakusei", "footerButtons", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_SYOKIGAMENHEBTN = new Item("khsouhuannaisakusei", "footerButtons", "syokigamenheBtn", null, ErrorMsgKbn.DD);
}
