package yuyu.app.base.system.usergroupkensaku;

/**
 * ユーザーグループ検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenUserGroupKensakuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String USERGROUPCD_SEARCHINFO = "'#userGroupCd'";

    public static final String USERGROUPNM_SEARCHINFO = "'#userGroupNm'";


    public static final String BUTTONSERCH = "'#buttonSerch'";

    public static final String SEARCHBTN_BUTTONSERCH = "'#searchBtn'";


    public static final String USERGROUPINFO = "'#userGroupInfo'";

    public static final String USERGROUPCD_USERGROUPINFO(int index) {
        return "'#userGroupInfo\\\\[" + index + "\\\\]\\\\.userGroupCd'";
    }

    public static final String USERGROUPNM_USERGROUPINFO(int index) {
        return "'#userGroupInfo\\\\[" + index + "\\\\]\\\\.userGroupNm'";
    }
}
