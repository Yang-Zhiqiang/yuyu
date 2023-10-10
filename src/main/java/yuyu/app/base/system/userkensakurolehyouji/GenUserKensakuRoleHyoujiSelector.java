package yuyu.app.base.system.userkensakurolehyouji;

/**
 * ユーザー検索（ロール表示用） JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUserKensakuRoleHyoujiSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String USERID_SEARCHINFO = "'#userId'";

    public static final String USERNM_SEARCHINFO = "'#userNm'";

    public static final String SRCHSOSIKICD_SEARCHINFO = "'#srchsosikicd'";


    public static final String BUTTONSERCH = "'#buttonSerch'";

    public static final String SEARCHBTN_BUTTONSERCH = "'#searchBtn'";


    public static final String USERANDUSERROLEINFO = "'#userAndUserRoleInfo'";

    public static final String USERID_USERANDUSERROLEINFO(int index) {
        return "'#userAndUserRoleInfo\\\\[" + index + "\\\\]\\\\.userId'";
    }

    public static final String USERNM_USERANDUSERROLEINFO(int index) {
        return "'#userAndUserRoleInfo\\\\[" + index + "\\\\]\\\\.userNm'";
    }

    public static final String ROLECD_USERANDUSERROLEINFO(int index) {
        return "'#userAndUserRoleInfo\\\\[" + index + "\\\\]\\\\.roleCd'";
    }

    public static final String ROLENM_USERANDUSERROLEINFO(int index) {
        return "'#userAndUserRoleInfo\\\\[" + index + "\\\\]\\\\.roleNm'";
    }
}
