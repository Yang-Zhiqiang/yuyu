package yuyu.app.hozen.khozen.khonlinekensuusyoukai;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全オンライン処理件数照会 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhOnlineKensuuSyoukaiConstants {

    public static final int PAGENO_INIT      = 1;

    public static final int PAGENO_INPUTKEY  = 1;

    public static final int PAGENO_REFERENCE = 2;

    static final String FORWARDNAME_INIT      = "init";

    static final String FORWARDNAME_INPUTKEY  = "InputKey";

    static final String FORWARDNAME_REFERENCE = "Reference";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khonlinekensuusyoukai", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SYORIYMDINFO_SYORIYMD = new Item("khonlinekensuusyoukai", "syoriYmdInfo", "syoriYmd", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORIKENSUULIST_DISPKINOUNM = new Item("khonlinekensuusyoukai", "syoriKensuuList", "dispkinounm", null, ErrorMsgKbn.DISP);

    static final Item DDID_SYORIKENSUULIST_DISPKENSUU = new Item("khonlinekensuusyoukai", "syoriKensuuList", "dispkensuu", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("khonlinekensuusyoukai", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
