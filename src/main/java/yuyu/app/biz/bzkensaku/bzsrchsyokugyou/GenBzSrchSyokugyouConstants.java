package yuyu.app.biz.bzkensaku.bzsrchsyokugyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 職業検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchSyokugyouConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchsyokugyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHSYOKUGYOUCD = new Item("bzsrchsyokugyou", "searchConditions", "srchsyokugyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHSYOKUGYOUNM = new Item("bzsrchsyokugyou", "searchConditions", "srchsyokugyounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSYOKUGYOUCD = new Item("bzsrchsyokugyou", "searchResults", "dispsyokugyoucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSYOKUGYOUNM = new Item("bzsrchsyokugyou", "searchResults", "dispsyokugyounm", null, ErrorMsgKbn.DISP);
}
