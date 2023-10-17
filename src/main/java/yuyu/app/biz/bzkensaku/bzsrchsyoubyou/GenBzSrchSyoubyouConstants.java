package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 傷病検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchSyoubyouConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchsyoubyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHSYOUBYOUCD = new Item("bzsrchsyoubyou", "searchConditions", "srchsyoubyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHSYOUBYOUNM = new Item("bzsrchsyoubyou", "searchConditions", "srchsyoubyounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSYOUBYOUCD = new Item("bzsrchsyoubyou", "searchResults", "dispsyoubyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSYOUBYOUNM = new Item("bzsrchsyoubyou", "searchResults", "dispsyoubyounm", null, ErrorMsgKbn.DISP);
}
