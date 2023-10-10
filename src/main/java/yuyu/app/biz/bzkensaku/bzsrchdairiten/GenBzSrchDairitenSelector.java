package yuyu.app.biz.bzkensaku.bzsrchdairiten;

/**
 * 代理店検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchDairitenSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SRCHDRTENCD_SEARCHCONDITIONS = "'#srchdrtencd'";

    public static final String SRCHDRTENNM_SEARCHCONDITIONS = "'#srchdrtennm'";

    public static final String SRCHKANJIDAIRITENNM1_SEARCHCONDITIONS = "'#srchkanjidairitennm1'";

    public static final String SRCHKANJIDAIRITENNM2_SEARCHCONDITIONS = "'#srchkanjidairitennm2'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String DISPDRTENCD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispdrtencd'";
    }

    public static final String DISPDRTENNMKN_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispdrtennmkn'";
    }

    public static final String DISPDRTENNMKJ_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispdrtennmkj'";
    }
}
