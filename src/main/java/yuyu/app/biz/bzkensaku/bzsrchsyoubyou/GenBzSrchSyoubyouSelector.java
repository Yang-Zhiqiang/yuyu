package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

/**
 * 傷病検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchSyoubyouSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SRCHSYOUBYOUCD_SEARCHCONDITIONS = "'#srchsyoubyoucd'";

    public static final String SRCHSYOUBYOUNM_SEARCHCONDITIONS = "'#srchsyoubyounm'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String DISPSYOUBYOUCD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsyoubyoucd'";
    }

    public static final String DISPSYOUBYOUNM_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsyoubyounm'";
    }
}
