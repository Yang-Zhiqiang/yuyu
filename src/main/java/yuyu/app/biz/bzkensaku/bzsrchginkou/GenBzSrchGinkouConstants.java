package yuyu.app.biz.bzkensaku.bzsrchginkou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 銀行検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchGinkouConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchginkou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHBANKCD = new Item("bzsrchginkou", "searchConditions", "srchbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHBANKNMKN = new Item("bzsrchginkou", "searchConditions", "srchbanknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBANKCD = new Item("bzsrchginkou", "searchResults", "dispbankcd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBANKNMKN = new Item("bzsrchginkou", "searchResults", "dispbanknmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBANKNMKJ = new Item("bzsrchginkou", "searchResults", "dispbanknmkj", null, ErrorMsgKbn.DISP);
}
