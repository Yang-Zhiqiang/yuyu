package yuyu.app.biz.bzkensaku.bzsrchginkousiten;

/**
 * 銀行支店検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchGinkouSitenSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String SRCHBANKCD_SEARCHCONDITIONS = "'#srchbankcd'";

    public static final String SRCHSITENCD_SEARCHCONDITIONS = "'#srchsitencd'";

    public static final String SRCHBANKNMKN_SEARCHCONDITIONS = "'#srchbanknmkn'";

    public static final String SRCHSITENNMKN_SEARCHCONDITIONS = "'#srchsitennmkn'";

    public static final String SRCHBANKNMKJ_SEARCHCONDITIONS = "'#srchbanknmkj'";

    public static final String SRCHSITENNMKJ_SEARCHCONDITIONS = "'#srchsitennmkj'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String DISPBANKCD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispbankcd'";
    }

    public static final String DISPSITENCD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsitencd'";
    }

    public static final String DISPBANKNMKJ_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispbanknmkj'";
    }

    public static final String DISPSITENNMKJ_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.dispsitennmkj'";
    }
}
