package yuyu.app.base.log.batchjyoukyousyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * バッチ状況照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenBatchJyoukyouSyoukaiConstants {

    public static final int PAGENO_INIT    = 1;

    public static final int PAGENO_SUMMARY = 1;

    public static final int PAGENO_DETAIL  = 2;

    public static final int PAGENO_PRINT   = 3;

    static final String FORWARDNAME_INIT    = "init";

    static final String FORWARDNAME_CURRENT = "current";

    static final String FORWARDNAME_SUMMARY = "Summary";

    static final String FORWARDNAME_DETAIL  = "Detail";

    static final String FORWARDNAME_PRINT   = "Print";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("batchjyoukyousyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_HEADERBUTTONS_TOJIRUBTNBYPOPUP = new Item("batchjyoukyousyoukai", "headerButtons", "tojiruBtnByPopup", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUSINBUTTONS_JIDOUKOUSINSURUBTN = new Item("batchjyoukyousyoukai", "kousinButtons", "jidouKousinSuruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KOUSINBUTTONS_JIDOUKOUSINSINAIBTN = new Item("batchjyoukyousyoukai", "kousinButtons", "jidouKousinSinaiBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KEYINFO_SUBSYSTEMID = new Item("batchjyoukyousyoukai", "keyInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_SYORIYMDFROM = new Item("batchjyoukyousyoukai", "keyInfo", "syoriYmdFrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KEYINFO_SYORIYMDTO = new Item("batchjyoukyousyoukai", "keyInfo", "syoriYmdTo", null, ErrorMsgKbn.ERROR);

    static final Item DDID_KEYINFO_BATCHRESULTKBN = new Item("batchjyoukyousyoukai", "keyInfo", "batchResultKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_KEYINFO_BATCHJYOUTAI = new Item("batchjyoukyousyoukai", "keyInfo", "batchJyoutai", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_SUBSYSTEMNM = new Item("batchjyoukyousyoukai", "batchJobinfo", "subSystemNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_CATEGORYNM = new Item("batchjyoukyousyoukai", "batchJobinfo", "categoryNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_KINOUNM = new Item("batchjyoukyousyoukai", "batchJobinfo", "kinouNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHKIDOUKBN = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchKidouKbn", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHSYORIYMD = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchSyoriYmd", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHSTARTTIME = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchStartTime", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHENDTIME = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchEndTime", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHRESULTKBN = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchResultKbn", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_BATCHJYOUTAIKBN = new Item("batchjyoukyousyoukai", "batchJobinfo", "batchJyoutaiKbn", "batchJob", ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBINFO_USERNM = new Item("batchjyoukyousyoukai", "batchJobinfo", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_BATCHJOBLIST_SUBSYSTEMNM = new Item("batchjyoukyousyoukai", "batchJobList", "subSystemNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_CATEGORYNM = new Item("batchjyoukyousyoukai", "batchJobList", "categoryNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_KINOUNM = new Item("batchjyoukyousyoukai", "batchJobList", "kinouNm", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_BATCHKIDOUKBN = new Item("batchjyoukyousyoukai", "batchJobList", "batchKidouKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_BATCHSTARTTIME = new Item("batchjyoukyousyoukai", "batchJobList", "batchStartTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_BATCHENDTIME = new Item("batchjyoukyousyoukai", "batchJobList", "batchEndTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_BATCHRESULTKBN = new Item("batchjyoukyousyoukai", "batchJobList", "batchResultKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_BATCHJYOUTAIKBN = new Item("batchjyoukyousyoukai", "batchJobList", "batchJyoutaiKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHJOBLIST_SYOUSAILINK = new Item("batchjyoukyousyoukai", "batchJobList", "syousaiLink", null, ErrorMsgKbn.DD);

    static final Item DDID_BATCHJOBLIST_TYOUHYOUSYUTURYOKULINK = new Item("batchjyoukyousyoukai", "batchJobList", "tyouhyouSyuturyokuLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHLOGLIST_LOGOUTPUTTIME = new Item("batchjyoukyousyoukai", "batchLogList", "logOutputTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHLOGLIST_LOGLEVELKBN = new Item("batchjyoukyousyoukai", "batchLogList", "logLevelKbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_BATCHLOGLIST_LOGNAIYOU = new Item("batchjyoukyousyoukai", "batchLogList", "logNaiyou", null, ErrorMsgKbn.DD);

    static final Item DDID_FOTTERBUTTONS_KOUSINBTN = new Item("batchjyoukyousyoukai", "fotterButtons", "kousinBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOTTERBUTTONS_MODORUBTNBYGAIYOU = new Item("batchjyoukyousyoukai", "fotterButtons", "modoruBtnByGaiyou", null, ErrorMsgKbn.DD);

    static final Item DDID_FOTTERBUTTONS_INSATUGAMENBTN = new Item("batchjyoukyousyoukai", "fotterButtons", "insatuGamenBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_FOTTERBUTTONS_INSATUBTN = new Item("batchjyoukyousyoukai", "fotterButtons", "insatuBtn", null, ErrorMsgKbn.DD);
}
