package yuyu.app.base.log.accesslogsyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * アクセスログ照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenAccessLogSyoukaiConstants {

    public static final int PAGENO_INIT    = 1;

    public static final int PAGENO_SEARCH  = 1;

    public static final int PAGENO_DETAIL  = 2;

    static final String FORWARDNAME_INIT    = "init";

    static final String FORWARDNAME_CURRENT = "current";

    static final String FORWARDNAME_SEARCH  = "search";

    static final String FORWARDNAME_DETAIL  = "detail";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("accesslogsyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SUBSYSTEMID = new Item("accesslogsyoukai", "searchConditions", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_CATEGORYID = new Item("accesslogsyoukai", "searchConditions", "categoryId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_KINOUKBN = new Item("accesslogsyoukai", "searchConditions", "kinouKbn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_KINOUID = new Item("accesslogsyoukai", "searchConditions", "kinouId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_USERID = new Item("accesslogsyoukai", "searchConditions", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_IPADDRESS = new Item("accesslogsyoukai", "searchConditions", "ipAddress", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SYORIYMDFROM = new Item("accesslogsyoukai", "searchConditions", "syoriYmdFrom", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SYORITIMEFROM = new Item("accesslogsyoukai", "searchConditions", "syoriTimeFrom", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_SYORIYMDTO = new Item("accesslogsyoukai", "searchConditions", "syoriYmdTo", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SYORITIMETO = new Item("accesslogsyoukai", "searchConditions", "syoriTimeTo", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHCONDITIONS_LOGKINDCD = new Item("accesslogsyoukai", "searchConditions", "logKindCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHCONDITIONS_SESSIONID = new Item("accesslogsyoukai", "searchConditions", "sessionId", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_SYORITIME = new Item("accesslogsyoukai", "accessLogInfoList", "syoriTime", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_SYORIUSERID = new Item("accesslogsyoukai", "accessLogInfoList", "syoriUserId", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFOLIST_USERNM = new Item("accesslogsyoukai", "accessLogInfoList", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_LOGKINDCD = new Item("accesslogsyoukai", "accessLogInfoList", "logKindCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFOLIST_IPADDRESS = new Item("accesslogsyoukai", "accessLogInfoList", "ipAddress", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_SESSIONID = new Item("accesslogsyoukai", "accessLogInfoList", "sessionId", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_TRANSACTIONID = new Item("accesslogsyoukai", "accessLogInfoList", "transactionId", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_SUBSYSTEMNM = new Item("accesslogsyoukai", "accessLogInfoList", "subSystemNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFOLIST_KINOUNM = new Item("accesslogsyoukai", "accessLogInfoList", "kinouNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFOLIST_SYOUSAILINK = new Item("accesslogsyoukai", "accessLogInfoList", "syousaiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFOLIST_LOGDATA = new Item("accesslogsyoukai", "accessLogInfoList", "logData", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFO_SYORITIME = new Item("accesslogsyoukai", "accessLogInfo", "syoriTime", null, ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFO_SYORIUSERID = new Item("accesslogsyoukai", "accessLogInfo", "syoriUserId", "accessLog", ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFO_USERNM = new Item("accesslogsyoukai", "accessLogInfo", "userNm", "user", ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFO_LOGKINDCD = new Item("accesslogsyoukai", "accessLogInfo", "logKindCd", "accessLog", ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFO_IPADDRESS = new Item("accesslogsyoukai", "accessLogInfo", "ipAddress", "accessLog", ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFO_TRANSACTIONID = new Item("accesslogsyoukai", "accessLogInfo", "transactionId", "accessLog", ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFO_SESSIONID = new Item("accesslogsyoukai", "accessLogInfo", "sessionId", "accessLog", ErrorMsgKbn.DD);

    static final Item DDID_ACCESSLOGINFO_SUBSYSTEMNM = new Item("accesslogsyoukai", "accessLogInfo", "subSystemNm", "kinou.subSystem", ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFO_KINOUNM = new Item("accesslogsyoukai", "accessLogInfo", "kinouNm", "kinou", ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSLOGINFO_LOGDATA = new Item("accesslogsyoukai", "accessLogInfo", "logData", "accessLog", ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSDETAILLOGINFO_SYOUSAIEDANO = new Item("accesslogsyoukai", "accessDetailLogInfo", "syousaiEdaNo", null, ErrorMsgKbn.DISP);

    static final Item DDID_ACCESSDETAILLOGINFO_LOGSYOUSAIDATA = new Item("accesslogsyoukai", "accessDetailLogInfo", "logSyousaiData", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYSYOUSAI = new Item("accesslogsyoukai", "footerButtons", "modoruBtnBySyousai", null, ErrorMsgKbn.DD);
}
