package yuyu.app.biz.bzkensaku.bzsrchsyokugyou;

/**
 * 職業検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchSyokugyouSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SRCHSYOKUGYOUCD_SEARCHCONDITIONS = "'#srchsyokugyoucd'";

    public static final String SRCHSYOKUGYOUNM_SEARCHCONDITIONS = "'#srchsyokugyounm'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String DISPSYOKUGYOUCD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsyokugyoucd'";
    }

    public static final String DISPSYOKUGYOUNM_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsyokugyounm'";
    }
}
