package yuyu.app.direct.dssyoukai.dsmailsousinrirekisyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ＤＳメール送信履歴照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenDsMailSousinRirekiSyoukaiConstants {

    public static final int PAGENO_INIT             = 1;

    public static final int PAGENO_DSSENDMAILSEARCH = 1;

    static final String FORWARDNAME_INIT             = "init";

    static final String FORWARDNAME_CURRENT          = "current";

    static final String FORWARDNAME_DSSENDMAILSEARCH = "DsSendMailSearch";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("dsmailsousinrirekisyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHJYOUKENINFO_SRCHDSKOKNO = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "srchdskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHJYOUKENINFO_SRCHSYONO = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "srchsyono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHJYOUKENINFO_DSGAITOUKOKYAKUKENSAKU = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "dsgaitoukokyakukensaku", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHJYOUKENINFO_SRCHDSSOUSINNO = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "srchdssousinno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHJYOUKENINFO_DSSOUSINMAILSYUBETUKBN = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "dssousinmailsyubetukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHJYOUKENINFO_SOUSINYMDFROM = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "sousinymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHJYOUKENINFO_SOUSINYMDTO = new Item("dsmailsousinrirekisyoukai", "searchjyoukenInfo", "sousinymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_HEADERBUTTONS1_CLEARBTNBYINPUTKEYSELECT = new Item("dsmailsousinrirekisyoukai", "headerButtons1", "clearbtnbyinputkeyselect", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSDATASAKUSEIYMD = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "dsdatasakuseiymd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_DSKOKNO = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "dskokno", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_SYONO = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSSOUSINMAILSYUBETUKBN = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "dssousinmailsyubetukbn", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHRESULTINFO_HAISINJIDSMAILADDRESS = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "haisinjidsmailaddress", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_HAISINERRORCOUNT = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "haisinerrorcount", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHRESULTINFO_DSSOUSINNO = new Item("dsmailsousinrirekisyoukai", "searchResultInfo", "dssousinno", null, ErrorMsgKbn.DD);
}
