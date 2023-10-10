package yuyu.app.base.system.usergroupkensaku;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザーグループ検索 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserGroupKensakuConstants {

    public static final int PAGENO_INIT    = 1;

    public static final int PAGENO_SEARCH  = 1;

    static final String FORWARDNAME_INIT    = "init";

    static final String FORWARDNAME_CURRENT = "current";

    static final String FORWARDNAME_SEARCH  = "search";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("usergroupkensaku", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERGROUPCD = new Item("usergroupkensaku", "searchInfo", "userGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERGROUPNM = new Item("usergroupkensaku", "searchInfo", "userGroupNm", null, ErrorMsgKbn.DD);

    static final Item DDID_USERGROUPINFO_USERGROUPCD = new Item("usergroupkensaku", "userGroupInfo", "userGroupCd", null, ErrorMsgKbn.DD);

    static final Item DDID_USERGROUPINFO_USERGROUPNM = new Item("usergroupkensaku", "userGroupInfo", "userGroupNm", null, ErrorMsgKbn.DD);
}
