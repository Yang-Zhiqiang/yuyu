package yuyu.app.base.system.userkensakurolehyouji;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.configuration.Item.ErrorMsgKbn;

/**
 * ユーザー検索（ロール表示用） 画面項目ID定義のベースクラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えてはいけません。
 */
public class GenUserKensakuRoleHyoujiConstants {

    public static final int PAGENO_INIT     = 1;

    public static final int PAGENO_INPUTKEY = 1;

    static final String FORWARDNAME_INIT     = "init";

    static final String FORWARDNAME_CURRENT  = "current";

    static final String FORWARDNAME_INPUTKEY = "inputKey";

    static final Item DDID_HEADERBUTTONS_TOJIRUBTN = new Item("userkensakurolehyouji", "headerButtons", "tojiruBtn", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERID = new Item("userkensakurolehyouji", "searchInfo", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_USERNM = new Item("userkensakurolehyouji", "searchInfo", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_SEARCHINFO_SRCHSOSIKICD = new Item("userkensakurolehyouji", "searchInfo", "srchsosikicd", null, ErrorMsgKbn.DISP);

    static final Item DDID_USERANDUSERROLEINFO_USERID = new Item("userkensakurolehyouji", "userAndUserRoleInfo", "userId", null, ErrorMsgKbn.DD);

    static final Item DDID_USERANDUSERROLEINFO_USERNM = new Item("userkensakurolehyouji", "userAndUserRoleInfo", "userNm", null, ErrorMsgKbn.DD);

    static final Item DDID_USERANDUSERROLEINFO_ROLECD = new Item("userkensakurolehyouji", "userAndUserRoleInfo", "roleCd", null, ErrorMsgKbn.DD);

    static final Item DDID_USERANDUSERROLEINFO_ROLENM = new Item("userkensakurolehyouji", "userAndUserRoleInfo", "roleNm", null, ErrorMsgKbn.DD);
}
