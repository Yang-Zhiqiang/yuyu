package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 入力差異照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkNyuuryokuSaiSyoukaiConstants {

    public static final int PAGENO_INIT               = 1;

    public static final int PAGENO_NYURYOKUSAISYOUKAI = 1;

    static final String FORWARDNAME_INIT               = "init";

    static final String FORWARDNAME_NYURYOKUSAISYOUKAI = "NyuryokuSaiSyoukai";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("sknyuuryokusaisyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_MOSNOINFO_MOSNO = new Item("sknyuuryokusaisyoukai", "mosNoInfo", "mosno", null, ErrorMsgKbn.DD);

    static final Item DDID_MOSNOINFO_AITEMOSNO = new Item("sknyuuryokusaisyoukai", "mosNoInfo", "aitemosno", null, ErrorMsgKbn.DD);

    static final Item DDID_NYUURYOKUSOUILIST_DISPNRKSOUIKM = new Item("sknyuuryokusaisyoukai", "nyuuryokuSouiList", "dispnrksouikm", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUURYOKUSOUILIST_DISPITIJINRK = new Item("sknyuuryokusaisyoukai", "nyuuryokuSouiList", "dispitijinrk", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUURYOKUSOUILIST_DISPNIJINRK = new Item("sknyuuryokusaisyoukai", "nyuuryokuSouiList", "dispnijinrk", null, ErrorMsgKbn.DISP);

    static final Item DDID_NYUURYOKUSOUILIST_COMMONCHECKBOX = new Item("sknyuuryokusaisyoukai", "nyuuryokuSouiList", "commonCheckBox", null, ErrorMsgKbn.DISP);

    static final Item DDID_INSATUYOUCOMMENT_COMMENTGAMEN = new Item("sknyuuryokusaisyoukai", "insatuYouComment", "commentgamen", null, ErrorMsgKbn.DISP);

    static final Item DDID_SEIGYOGROUP_UNIQUEID = new Item("sknyuuryokusaisyoukai", "seigyoGroup", "uniqueId", null, ErrorMsgKbn.DD);
}
