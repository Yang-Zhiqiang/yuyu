package yuyu.app.base.system.rolekensaku;

/**
 * ロール検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenRoleKensakuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String ROLECD_SEARCHINFO = "'#roleCd'";

    public static final String ROLENM_SEARCHINFO = "'#roleNm'";


    public static final String BUTTONSERCH = "'#buttonSerch'";

    public static final String SEARCHBTN_BUTTONSERCH = "'#searchBtn'";


    public static final String ROLEINFO = "'#roleInfo'";

    public static final String ROLECD_ROLEINFO(int index) {
        return "'#roleInfo\\\\[" + index + "\\\\]\\\\.roleCd'";
    }

    public static final String ROLENM_ROLEINFO(int index) {
        return "'#roleInfo\\\\[" + index + "\\\\]\\\\.roleNm'";
    }
}
