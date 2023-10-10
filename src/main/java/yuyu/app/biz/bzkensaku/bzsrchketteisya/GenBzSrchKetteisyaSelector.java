package yuyu.app.biz.bzkensaku.bzsrchketteisya;

/**
 * 決定者検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchKetteisyaSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SRCHKETSYACD_SEARCHCONDITIONS = "'#srchketsyacd'";

    public static final String SRCHKETSYANM_SEARCHCONDITIONS = "'#srchketsyanm'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String DISPKETSYACD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispketsyacd'";
    }

    public static final String DISPKETSYANM_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispketsyanm'";
    }
}
