package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 事務用コード入力 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenJimuyouCodeNyuuryokuConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTCONTENTS = 1;

    public static final int PAGENO_CONFIRM       = 2;

    public static final int PAGENO_RESULT        = 3;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("jimuyoucodenyuuryoku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("jimuyoucodenyuuryoku", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("jimuyoucodenyuuryoku", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEIBUTTONS_KETTEIBTN = new Item("jimuyoucodenyuuryoku", "ketteiButtons", "ketteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_JIMUYOUCODELIST_MOSNO = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList", "mosno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_JIMUYOUCODELIST_SYONO = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList", "syono", null, ErrorMsgKbn.ERROR);

    static final Item DDID_JIMUYOUCODELIST_NKSYSYNO = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList", "nksysyno", null, ErrorMsgKbn.ERROR);

    static final Item DDID_JIMUYOUCODELIST_JIMUYOUCD = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList", "jimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_JIMUYOUCODELIST2_DISPGYOUMUKEY = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList2", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_JIMUYOUCODELIST2_DISPJIMUYOUCD = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList2", "dispjimuyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_JIMUYOUCODELIST2_DISPHNKMAEJIMUYOUCD = new Item("jimuyoucodenyuuryoku", "jimuyouCodeList2", "disphnkmaejimuyoucd", null, ErrorMsgKbn.DISP);
}
