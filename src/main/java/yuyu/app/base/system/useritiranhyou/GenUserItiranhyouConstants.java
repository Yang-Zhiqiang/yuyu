package yuyu.app.base.system.useritiranhyou;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザー一覧表 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserItiranhyouConstants {

    public static final int PAGENO_INIT    = 1;

    public static final int PAGENO_CONFIRM = 1;

    public static final int PAGENO_RESULT  = 2;

    static final String FORWARDNAME_INIT    = "init";

    static final String FORWARDNAME_CONFIRM = "Confirm";

    static final String FORWARDNAME_RESULT  = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("useritiranhyou", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);
}
