package yuyu.app.base.systemsyoukai.tablesyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * テーブル照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenTableSyoukaiConstants {

    public static final int PAGENO_INIT         = 1;

    public static final int PAGENO_SELECTTABLE  = 1;

    public static final int PAGENO_SEARCH       = 2;

    public static final int PAGENO_RESULTDETAIL = 3;

    static final String FORWARDNAME_INIT         = "init";

    static final String FORWARDNAME_SELECTTABLE  = "selectTable";

    static final String FORWARDNAME_SEARCH       = "search";

    static final String FORWARDNAME_RESULTDETAIL = "resultDetail";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("tablesyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTNBYPOPUP = new Item("tablesyoukai", "headerButtons", "tojiruBtnByPopup", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SUBSYSTEMID = new Item("tablesyoukai", "searchConditions", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_BASETABLEID = new Item("tablesyoukai", "searchConditions", "baseTableId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_BASETABLENM = new Item("tablesyoukai", "searchConditions", "baseTableNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_BASESEARCHPTNNM = new Item("tablesyoukai", "searchConditions", "baseSearchPtnNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_BASESELECTLINK = new Item("tablesyoukai", "tableSearchResultList", "baseSelectLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_SUBSYSTEMNM = new Item("tablesyoukai", "tableSearchResultList", "subSystemNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_BASETABLEID = new Item("tablesyoukai", "tableSearchResultList", "baseTableId", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_BASETABLENM = new Item("tablesyoukai", "tableSearchResultList", "baseTableNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_BASESEARCHPTNNM = new Item("tablesyoukai", "tableSearchResultList", "baseSearchPtnNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_TABLESEARCHRESULTLIST_BASESEARCHDDNM = new Item("tablesyoukai", "tableSearchResultList", "baseSearchDdNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTSEARCHCONDITION_BASESEARCHDDNM = new Item("tablesyoukai", "inputSearchCondition", "baseSearchDdNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTSEARCHCONDITION_BASESEARCHCONDITIONKBN = new Item("tablesyoukai", "inputSearchCondition", "baseSearchConditionKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_INPUTSEARCHCONDITION_BASESEARCHCONDITION = new Item("tablesyoukai", "inputSearchCondition", "baseSearchCondition", null, ErrorMsgKbn.DISP);

    static final Item DDID_TOKEN_BASETOKEN = new Item("tablesyoukai", "token", "baseToken", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONS_MODORUBTNBYSYOUSAI = new Item("tablesyoukai", "buttons", "modoruBtnBySyousai", null, ErrorMsgKbn.DISP);

    static final Item DDID_FIELDSLIST_BASECOLNO = new Item("tablesyoukai", "fieldsList", "baseColNo", null, ErrorMsgKbn.DISP);

    static final Item DDID_FIELDSLIST_BASEFIELDNM = new Item("tablesyoukai", "fieldsList", "baseFieldNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTSLIST_BASEROWNO = new Item("tablesyoukai", "resultsList", "baseRowNo", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTSLIST_BASECOLNO = new Item("tablesyoukai", "resultsList", "baseColNo", null, ErrorMsgKbn.DISP);

    static final Item DDID_RESULTSLIST_BASEFIELDVALUE = new Item("tablesyoukai", "resultsList", "baseFieldValue", null, ErrorMsgKbn.DISP);

    static final Item DDID_ONCLICKEVENTS_BASECLICKROWNO = new Item("tablesyoukai", "onClickEvents", "baseClickRowNo", null, ErrorMsgKbn.DISP);

    static final Item DDID_ONCLICKEVENTS_KAKUTEIBTN = new Item("tablesyoukai", "onClickEvents", "kakuteiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTDETAILLIST_BASEFIELDNM = new Item("tablesyoukai", "resultDetailList", "baseFieldNm", null, ErrorMsgKbn.DD);

    static final Item DDID_RESULTDETAILLIST_BASEFIELDVALUE = new Item("tablesyoukai", "resultDetailList", "baseFieldValue", null, ErrorMsgKbn.DD);
}
