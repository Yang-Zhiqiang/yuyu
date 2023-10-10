package yuyu.app.biz.bzkensaku.bzsrchketteisya;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 決定者検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchKetteisyaConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchketteisya", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SRCHKETSYACD = new Item("bzsrchketteisya", "searchConditions", "srchketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SRCHKETSYANM = new Item("bzsrchketteisya", "searchConditions", "srchketsyanm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPKETSYACD = new Item("bzsrchketteisya", "searchResults", "dispketsyacd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTS_DISPKETSYANM = new Item("bzsrchketteisya", "searchResults", "dispketsyanm", null, ErrorMsgKbn.DISP);
}
