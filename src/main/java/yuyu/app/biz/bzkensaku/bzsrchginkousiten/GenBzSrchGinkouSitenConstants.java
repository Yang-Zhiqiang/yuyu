package yuyu.app.biz.bzkensaku.bzsrchginkousiten;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 銀行支店検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchGinkouSitenConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchginkousiten", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHBANKCD = new Item("bzsrchginkousiten", "searchConditions", "srchbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHSITENCD = new Item("bzsrchginkousiten", "searchConditions", "srchsitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHBANKNMKN = new Item("bzsrchginkousiten", "searchConditions", "srchbanknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHSITENNMKN = new Item("bzsrchginkousiten", "searchConditions", "srchsitennmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHBANKNMKJ = new Item("bzsrchginkousiten", "searchConditions", "srchbanknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHSITENNMKJ = new Item("bzsrchginkousiten", "searchConditions", "srchsitennmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBANKCD = new Item("bzsrchginkousiten", "searchResults", "dispbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSITENCD = new Item("bzsrchginkousiten", "searchResults", "dispsitencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBANKNMKJ = new Item("bzsrchginkousiten", "searchResults", "dispbanknmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSITENNMKJ = new Item("bzsrchginkousiten", "searchResults", "dispsitennmkj", null, ErrorMsgKbn.DISP);
}
