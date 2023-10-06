package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 決定理由一覧 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenSkKetteiRiyuuConstants {

    public static final int PAGENO_INIT              = 1;

    public static final int PAGENO_KETTEIRIYUUITIRAN = 1;

    static final String FORWARDNAME_INIT              = "init";

    static final String FORWARDNAME_KETTEIRIYUUITIRAN = "Ketteiriyuuitiran";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("skketteiriyuu", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KETTEIRIYUULIST_DISPKETTEIRIYUUCD = new Item("skketteiriyuu", "ketteiriyuuList", "dispketteiriyuucd", null, ErrorMsgKbn.DISP);

    static final Item DDID_KETTEIRIYUULIST_DISPKETTEIRIYUUNAIYOU = new Item("skketteiriyuu", "ketteiriyuuList", "dispketteiriyuunaiyou", null, ErrorMsgKbn.DISP);
}
