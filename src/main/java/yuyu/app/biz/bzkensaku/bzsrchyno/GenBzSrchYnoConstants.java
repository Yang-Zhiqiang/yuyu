package yuyu.app.biz.bzkensaku.bzsrchyno;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 郵便番号検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBzSrchYnoConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_CURRENT    = "current";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("bzsrchyno", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SRCHYNO = new Item("bzsrchyno", "searchInfo", "srchyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_TODOUHUKENKBN = new Item("bzsrchyno", "searchInfo", "todouhukenKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SRCHKNADR = new Item("bzsrchyno", "searchInfo", "srchknadr", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SRCHKJADR = new Item("bzsrchyno", "searchInfo", "srchkjadr", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULT_DISPYNO = new Item("bzsrchyno", "searchResult", "dispyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULT_DISPKJADR = new Item("bzsrchyno", "searchResult", "dispkjadr", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULT_DISPKNADR = new Item("bzsrchyno", "searchResult", "dispknadr", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULT_DISPTODOUHUKENNMKJ = new Item("bzsrchyno", "searchResult", "disptodouhukennmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULT_DISPSIKUTYOUSONNMKJ = new Item("bzsrchyno", "searchResult", "dispsikutyousonnmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULT_DISPTYOUIKINMKJ = new Item("bzsrchyno", "searchResult", "disptyouikinmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULT_TODOUFUKENSIKUTYOUSONNM = new Item("bzsrchyno", "searchResult", "todoufukenSikutyousonNm", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULT_TODOUFUKENSIKUTYOUSONNMKN = new Item("bzsrchyno", "searchResult", "todoufukenSikutyousonNmKn", null, ErrorMsgKbn.DD);
}
