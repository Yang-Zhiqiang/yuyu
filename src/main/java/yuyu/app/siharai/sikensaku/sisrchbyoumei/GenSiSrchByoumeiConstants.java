package yuyu.app.siharai.sikensaku.sisrchbyoumei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 病名検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSiSrchByoumeiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sisrchbyoumei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_BYOUMEIKJ = new Item("sisrchbyoumei", "searchConditions", "byoumeikj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_BYOUMEIKN = new Item("sisrchbyoumei", "searchConditions", "byoumeikn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_BYOUMEICD = new Item("sisrchbyoumei", "searchConditions", "byoumeicd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_BYOUMEICD = new Item("sisrchbyoumei", "searchResults", "byoumeicd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_BYOUMEIKJ = new Item("sisrchbyoumei", "searchResults", "byoumeikj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_BYOUMEIKN = new Item("sisrchbyoumei", "searchResults", "byoumeikn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_GAITOUKBN2 = new Item("sisrchbyoumei", "searchResults", "gaitoukbn2", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_BYOUMEITOUROKUNO = new Item("sisrchbyoumei", "searchResults", "byoumeitourokuno", null, ErrorMsgKbn.DD);
}
