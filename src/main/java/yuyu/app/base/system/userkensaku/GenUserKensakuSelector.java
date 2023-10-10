package yuyu.app.base.system.userkensaku;

/**
 * ユーザー検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUserKensakuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String USERID_SEARCHINFO = "'#userId'";

    public static final String USERNM_SEARCHINFO = "'#userNm'";

    public static final String SRCHSOSIKICD_SEARCHINFO = "'#srchsosikicd'";


    public static final String BUTTONSERCH = "'#buttonSerch'";

    public static final String SEARCHBTN_BUTTONSERCH = "'#searchBtn'";


    public static final String USERINFO = "'#userInfo'";

    public static final String USERID_USERINFO(int index) {
        return "'#userInfo\\\\[" + index + "\\\\]\\\\.userId'";
    }

    public static final String USERNM_USERINFO(int index) {
        return "'#userInfo\\\\[" + index + "\\\\]\\\\.userNm'";
    }
}
