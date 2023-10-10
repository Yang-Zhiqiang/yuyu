package yuyu.app.base.system.rolekensaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ロール検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenRoleKensakuConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "inputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("rolekensaku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_ROLECD = new Item("rolekensaku", "searchInfo", "roleCd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_ROLENM = new Item("rolekensaku", "searchInfo", "roleNm", null, ErrorMsgKbn.DD);

    static final Item DDID_ROLEINFO_ROLECD = new Item("rolekensaku", "roleInfo", "roleCd", null, ErrorMsgKbn.DD);

    static final Item DDID_ROLEINFO_ROLENM = new Item("rolekensaku", "roleInfo", "roleNm", null, ErrorMsgKbn.DD);
}
