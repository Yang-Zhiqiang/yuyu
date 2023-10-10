package yuyu.app.biz.bzkensaku.bzsrchsimekiribi;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 締切日検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchSimekiribiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchsimekiribi", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHBOSYUUYM = new Item("bzsrchsimekiribi", "searchConditions", "srchbosyuuym", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPBOSYUUYM = new Item("bzsrchsimekiribi", "searchResults", "dispbosyuuym", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPMOSSIMEFROMYMD = new Item("bzsrchsimekiribi", "searchResults", "dispmossimefromymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPMOSSIMETOYMD = new Item("bzsrchsimekiribi", "searchResults", "dispmossimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_DISPMOSNRKSIMEFROMYMD = new Item("bzsrchsimekiribi", "searchResults", "dispmosnrksimefromymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPMOSNRKSIMETOYMD = new Item("bzsrchsimekiribi", "searchResults", "dispmosnrksimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_DISPNRKSIMEFROMYMD = new Item("bzsrchsimekiribi", "searchResults", "dispnrksimefromymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPNRKSIMETOYMD = new Item("bzsrchsimekiribi", "searchResults", "dispnrksimetoymd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTS_DISPSYRISIMEFROMYMD = new Item("bzsrchsimekiribi", "searchResults", "dispsyrisimefromymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPSYRISIMETOYMD = new Item("bzsrchsimekiribi", "searchResults", "dispsyrisimetoymd", null, ErrorMsgKbn.DD);
}
