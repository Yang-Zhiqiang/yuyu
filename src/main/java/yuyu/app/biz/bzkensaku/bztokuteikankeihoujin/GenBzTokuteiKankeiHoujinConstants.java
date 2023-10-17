package yuyu.app.biz.bzkensaku.bztokuteikankeihoujin;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 特定関係法人照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzTokuteiKankeiHoujinConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_PARAMGROUP_MOSNO = new Item("bztokuteikankeihoujin", "paramGroup", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bztokuteikankeihoujin", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHTKHJNKINYUUCD = new Item("bztokuteikankeihoujin", "searchConditions", "srchtkhjnkinyuucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHTKHJNKJDRTENNM = new Item("bztokuteikankeihoujin", "searchConditions", "srchtkhjnkjdrtennm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHTKHJNNMKJ = new Item("bztokuteikankeihoujin", "searchConditions", "srchtkhjnnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS2_DISPTKHJNKINYUUCD = new Item("bztokuteikankeihoujin", "searchConditions2", "disptkhjnkinyuucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS2_DISPTKHJNKJDRTENNM = new Item("bztokuteikankeihoujin", "searchConditions2", "disptkhjnkjdrtennm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS2_DISPTKHJNNMKJ = new Item("bztokuteikankeihoujin", "searchConditions2", "disptkhjnnmkj", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPTKHJNKINYUUCD = new Item("bztokuteikankeihoujin", "searchResults", "disptkhjnkinyuucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPTKHJNKJDRTENNM = new Item("bztokuteikankeihoujin", "searchResults", "disptkhjnkjdrtennm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPTKHJNNMKJ = new Item("bztokuteikankeihoujin", "searchResults", "disptkhjnnmkj", null, ErrorMsgKbn.DISP);
}
