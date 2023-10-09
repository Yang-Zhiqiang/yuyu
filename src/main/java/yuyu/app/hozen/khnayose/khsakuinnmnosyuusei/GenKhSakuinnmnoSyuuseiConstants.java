package yuyu.app.hozen.khnayose.khsakuinnmnosyuusei;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * 契約保全索引名番号修正 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenKhSakuinnmnoSyuuseiConstants {

    public static final int PAGENO_INIT          = 1;

    public static final int PAGENO_INPUTKEY      = 1;

    public static final int PAGENO_INPUTCONTENTS = 2;

    public static final int PAGENO_CONFIRM       = 3;

    public static final int PAGENO_RESULT        = 4;

    static final String FORWARDNAME_INIT          = "init";

    static final String FORWARDNAME_INPUTKEY      = "InputKey";

    static final String FORWARDNAME_INPUTCONTENTS = "InputContents";

    static final String FORWARDNAME_CONFIRM       = "Confirm";

    static final String FORWARDNAME_RESULT        = "Result";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("khsakuinnmnosyuusei", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTGROUP_SYONO = new Item("khsakuinnmnosyuusei", "inputGroup", "syono", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTGROUP_SYUUSEITAISYOUKBN = new Item("khsakuinnmnosyuusei", "inputGroup", "syuuseitaisyoukbn", null, ErrorMsgKbn.DD);

    static final Item DDID_INPUTGROUP_TAISYOUDOUITUHYOUJI = new Item("khsakuinnmnosyuusei", "inputGroup", "taisyoudouituhyouji", null, ErrorMsgKbn.DD);

    static final Item DDID_TAISYOUSYAINFOGROUP_TAISYOUNMKN = new Item("khsakuinnmnosyuusei", "taisyousyainfoGroup", "taisyounmkn", null, ErrorMsgKbn.DD);

    static final Item DDID_TAISYOUSYAINFOGROUP_TAISYOUNMKJ = new Item("khsakuinnmnosyuusei", "taisyousyainfoGroup", "taisyounmkj", null, ErrorMsgKbn.DD);

    static final Item DDID_TAISYOUSYAINFOGROUP_TAISYOUSEIYMD = new Item("khsakuinnmnosyuusei", "taisyousyainfoGroup", "taisyouseiymd", null, ErrorMsgKbn.DD);

    static final Item DDID_TAISYOUSYAINFOGROUP_TAISYOUSAKUINNMNO = new Item("khsakuinnmnosyuusei", "taisyousyainfoGroup", "taisyousakuinnmno", null, ErrorMsgKbn.DD);

    static final Item DDID_SYUUSEIGOSAKUINNMNOGROUP_SYUUSEIGOSAKUINNMNO = new Item("khsakuinnmnosyuusei", "syuuseigosakuinnmnoGroup", "syuuseigosakuinnmno", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYINPUTCONTENTS = new Item("khsakuinnmnosyuusei", "footerButtons", "modoruBtnByInputContents", null, ErrorMsgKbn.DD);

    static final Item DDID_FOOTERBUTTONS_MODORUBTNBYCONFIRM = new Item("khsakuinnmnosyuusei", "footerButtons", "modoruBtnByConfirm", null, ErrorMsgKbn.DD);
}
