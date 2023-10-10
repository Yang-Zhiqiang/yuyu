package yuyu.app.hozen.khozen.khkyknaiyouosirase;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ご契約内容のお知らせ 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhKykNaiyouOsiraseConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    public static final int PAGENO_RESULT   = 2;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_INPUTKEY = "InputKey";

    static final String FORWARDNAME_RESULT   = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khkyknaiyouosirase", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_KYKNAIYOUOSIRASESITEIINFO_SYONO = new Item("khkyknaiyouosirase", "kyknaiyouOsiraseSiteiInfo", "syono", null, ErrorMsgKbn.DISP);

    static final Item DDID_FOOTERBUTTONS_MODORUBTN = new Item("khkyknaiyouosirase", "footerButtons", "modorubtn", null, ErrorMsgKbn.DD);
}
