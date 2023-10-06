package yuyu.app.workflow.imagekanri.imagesakujyo;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * イメージ削除 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenImageSakujyoConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    public static final int PAGENO_CONFIRM    = 2;

    public static final int PAGENO_RESULT     = 3;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_CURRENT    = "current";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final String FORWARDNAME_CONFIRM    = "Confirm";

    static final String FORWARDNAME_RESULT     = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("imagesakujyo", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("imagesakujyo", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("imagesakujyo", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_MOSNO = new Item("imagesakujyo", "searchInfo", "mosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYONO = new Item("imagesakujyo", "searchInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_NKSYSYNO = new Item("imagesakujyo", "searchInfo", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_TORIKOMISYORUICD = new Item("imagesakujyo", "searchInfo", "torikomiSyoruiCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_KOUTEIKANRISTATUS = new Item("imagesakujyo", "searchInfo", "kouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYORUITTYKYMDFROM = new Item("imagesakujyo", "searchInfo", "syoruittykymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHINFO_SYORUITTYKYMDTO = new Item("imagesakujyo", "searchInfo", "syoruittykymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_ANKENLIST_DISPJIMUTETUZUKINM = new Item("imagesakujyo", "ankenList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPGYOUMUKEY = new Item("imagesakujyo", "ankenList", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST_DISPSYORUINM = new Item("imagesakujyo", "ankenList", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKANRISTATUS = new Item("imagesakujyo", "ankenList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_SYORUITTYKYMDTIME = new Item("imagesakujyo", "ankenList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_HYOUJILINK = new Item("imagesakujyo", "ankenList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST_SAKUJYOLINK = new Item("imagesakujyo", "ankenList", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_DISPJIMUTETUZUKINM = new Item("imagesakujyo", "ankenList2", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPGYOUMUKEY = new Item("imagesakujyo", "ankenList2", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_DISPSYORUINM = new Item("imagesakujyo", "ankenList2", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_DISPKOUTEIKANRISTATUS = new Item("imagesakujyo", "ankenList2", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_SYORUITTYKYMDTIME = new Item("imagesakujyo", "ankenList2", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST2_HYOUJILINK = new Item("imagesakujyo", "ankenList2", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST2_SAKUJYOLINK = new Item("imagesakujyo", "ankenList2", "sakujyoLink", null, ErrorMsgKbn.DD);

    static final Item DDID_BUTTONINPUTCONTENTS_MODORUBTNBYCONFIRM = new Item("imagesakujyo", "buttonInputContents", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_SELECTINDEX = new Item("imagesakujyo", "hiddeninfo", "selectindex", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_TYOUHYOUSYUTURYOKULINK = new Item("imagesakujyo", "hiddeninfo", "tyouhyouSyuturyokuLink", null, ErrorMsgKbn.DD);
}
