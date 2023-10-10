package yuyu.app.biz.bzkensaku.bzsrchdairiten;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 代理店検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchDairitenConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchdairiten", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHDRTENCD = new Item("bzsrchdairiten", "searchConditions", "srchdrtencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHDRTENNM = new Item("bzsrchdairiten", "searchConditions", "srchdrtennm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHKANJIDAIRITENNM1 = new Item("bzsrchdairiten", "searchConditions", "srchkanjidairitennm1", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHKANJIDAIRITENNM2 = new Item("bzsrchdairiten", "searchConditions", "srchkanjidairitennm2", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPDRTENCD = new Item("bzsrchdairiten", "searchResults", "dispdrtencd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPDRTENNMKN = new Item("bzsrchdairiten", "searchResults", "dispdrtennmkn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPDRTENNMKJ = new Item("bzsrchdairiten", "searchResults", "dispdrtennmkj", null, ErrorMsgKbn.DISP);
}
