package yuyu.app.direct.dsmailhaisinkanri.dsmailhaisinyoyaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ＤＳメール配信予約 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenDsMailHaisinYoyakuConstants {

    public static final int PAGENO_INIT      = 1;

    public static final int PAGENO_REFERENCE = 1;

    public static final int PAGENO_TOUROKU   = 2;

    public static final int PAGENO_SYOUNIN   = 3;

    public static final int PAGENO_SAKUJYO   = 4;

    public static final int PAGENO_CONFIRM   = 5;

    public static final int PAGENO_RESULT    = 6;

    static final String FORWARDNAME_INIT      = "init";

    static final String FORWARDNAME_CURRENT   = "current";

    static final String FORWARDNAME_REFERENCE = "Reference";

    static final String FORWARDNAME_TOUROKU   = "Touroku";

    static final String FORWARDNAME_SYOUNIN   = "Syounin";

    static final String FORWARDNAME_SAKUJYO   = "Sakujyo";

    static final String FORWARDNAME_CONFIRM   = "Confirm";

    static final String FORWARDNAME_RESULT    = "Result";

    static final Item DDID_HEADERBUTTON_TOJIRUBTN = new Item("dsmailhaisinyoyaku", "headerButton", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_DSSOUSINMAILKENSAKU_SRCHDSSOUSINMAILSYUBETUKBN = new Item("dsmailhaisinyoyaku", "dssousinMailKensaku", "srchdssousinmailsyubetukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_DSSOUSINMAILKENSAKU_SRCHDSHAISINYOTEIYMDFROM = new Item("dsmailhaisinyoyaku", "dssousinMailKensaku", "srchdshaisinyoteiymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_DSSOUSINMAILKENSAKU_SRCHDSHAISINYOTEIYMDTO = new Item("dsmailhaisinyoyaku", "dssousinMailKensaku", "srchdshaisinyoteiymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_DSSOUSINMAILKENSAKU_SRCHDSHAISINYOYAKUSTATUSKBN = new Item("dsmailhaisinyoyaku", "dssousinMailKensaku", "srchdshaisinyoyakustatuskbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSMAILHAISINYOTEIYMD = new Item("dsmailhaisinyoyaku", "searchResultInfo", "dsmailhaisinyoteiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSSOUSINMAILSYUBETUKBN = new Item("dsmailhaisinyoyaku", "searchResultInfo", "dssousinmailsyubetukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSHAISINYOYAKUSTATUSKBN = new Item("dsmailhaisinyoyaku", "searchResultInfo", "dshaisinyoyakustatuskbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_SYOUNINLINK = new Item("dsmailhaisinyoyaku", "searchResultInfo", "syouninlink", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_SAKUJYOLINK = new Item("dsmailhaisinyoyaku", "searchResultInfo", "sakujyoLink", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_GYOUMUKOUSINTIME = new Item("dsmailhaisinyoyaku", "searchResultInfo", "gyoumuKousinTime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_KOSTIME = new Item("dsmailhaisinyoyaku", "searchResultInfo", "kostime", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSMAILHAISINTOUROKUYMD = new Item("dsmailhaisinyoyaku", "searchResultInfo", "dsmailhaisintourokuymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSMAILHAISINSYOUNINYMD = new Item("dsmailhaisinyoyaku", "searchResultInfo", "dsmailhaisinsyouninymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUSINMAILNAIYOU_DSMAILHAISINYOTEIYMD = new Item("dsmailhaisinyoyaku", "sousinMailNaiyou", "dsmailhaisinyoteiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUSINMAILNAIYOU_DSSOUSINMAILSYUBETUKBN = new Item("dsmailhaisinyoyaku", "sousinMailNaiyou", "dssousinmailsyubetukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SOUSINMAILNAIYOU_DSSPIRALSEQUENCEHSNSET = new Item("dsmailhaisinyoyaku", "sousinMailNaiyou", "dsspiralsequencehsnset", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SOUSINMAILNAIYOU_DSSPIRALSEQUENCEHSNSETKBN = new Item("dsmailhaisinyoyaku", "sousinMailNaiyou", "dsspiralsequencehsnsetkbn", null, ErrorMsgKbn.ERROR);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYINPUTCONTENTS = new Item("dsmailhaisinyoyaku", "footerButtons2", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS2_MODORUBTNBYCONFIRM = new Item("dsmailhaisinyoyaku", "footerButtons2", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
