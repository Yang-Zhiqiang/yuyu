package yuyu.app.workflow.imagekanri.imagesyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * イメージ照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenImageSyoukaiConstants {

    public static final int PAGENO_INIT       = 1;

    public static final int PAGENO_SELECTDATA = 1;

    static final String FORWARDNAME_INIT       = "init";

    static final String FORWARDNAME_CURRENT    = "current";

    static final String FORWARDNAME_SELECTDATA = "SelectData";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("imagesyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SUBSYSTEMID = new Item("imagesyoukai", "searchInfo", "subSystemId", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_JIMUTETUZUKICD = new Item("imagesyoukai", "searchInfo", "jimutetuzukicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_MOSNO = new Item("imagesyoukai", "searchInfo", "mosno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYONO = new Item("imagesyoukai", "searchInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_NKSYSYNO = new Item("imagesyoukai", "searchInfo", "nksysyno", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_TORIKOMISYORUICD = new Item("imagesyoukai", "searchInfo", "torikomiSyoruiCd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_KOUTEIKANRISTATUS = new Item("imagesyoukai", "searchInfo", "kouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEARCHINFO_SYORUITTYKYMDFROM = new Item("imagesyoukai", "searchInfo", "syoruittykymdfrom", null, ErrorMsgKbn.ERROR);

    static final Item DDID_SEARCHINFO_SYORUITTYKYMDTO = new Item("imagesyoukai", "searchInfo", "syoruittykymdto", null, ErrorMsgKbn.ERROR);

    static final Item DDID_ANKENLIST_DISPJIMUTETUZUKINM = new Item("imagesyoukai", "ankenList", "dispjimutetuzukinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPGYOUMUKEY = new Item("imagesyoukai", "ankenList", "dispGyoumuKey", null, ErrorMsgKbn.DD);

    static final Item DDID_ANKENLIST_DISPSYORUINM = new Item("imagesyoukai", "ankenList", "dispsyoruinm", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_DISPKOUTEIKANRISTATUS = new Item("imagesyoukai", "ankenList", "dispkouteikanristatus", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_SYORUITTYKYMDTIME = new Item("imagesyoukai", "ankenList", "syoruittykymdtime", null, ErrorMsgKbn.DISP);

    static final Item DDID_ANKENLIST_HYOUJILINK = new Item("imagesyoukai", "ankenList", "hyoujilink", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_SELECTINDEX = new Item("imagesyoukai", "hiddeninfo", "selectindex", null, ErrorMsgKbn.DD);

    static final Item DDID_HIDDENINFO_TYOUHYOUSYUTURYOKULINK = new Item("imagesyoukai", "hiddeninfo", "tyouhyouSyuturyokuLink", null, ErrorMsgKbn.DD);
}
