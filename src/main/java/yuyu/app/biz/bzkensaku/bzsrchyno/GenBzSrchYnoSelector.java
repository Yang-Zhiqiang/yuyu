package yuyu.app.biz.bzkensaku.bzsrchyno;

/**
 * 郵便番号検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenBzSrchYnoSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHINFO = "'#searchInfo'";

    public static final String SRCHYNO_SEARCHINFO = "'#srchyno'";

    public static final String TODOUHUKENKBN_SEARCHINFO = "'#todouhukenKbn'";

    public static final String SRCHKNADR_SEARCHINFO = "'#srchknadr'";

    public static final String SRCHKJADR_SEARCHINFO = "'#srchkjadr'";


    public static final String SEARCHBUTTONS = "'#searchbuttons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULT = "'#searchResult'";

    public static final String DISPYNO_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.dispyno'";
    }

    public static final String DISPKJADR_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.dispkjadr'";
    }

    public static final String DISPKNADR_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.dispknadr'";
    }

    public static final String DISPTODOUHUKENNMKJ_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.disptodouhukennmkj'";
    }

    public static final String DISPSIKUTYOUSONNMKJ_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.dispsikutyousonnmkj'";
    }

    public static final String DISPTYOUIKINMKJ_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.disptyouikinmkj'";
    }

    public static final String TODOUFUKENSIKUTYOUSONNM_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.todoufukenSikutyousonNm'";
    }

    public static final String TODOUFUKENSIKUTYOUSONNMKN_SEARCHRESULT(int index) {
        return "'#searchResult\\\\[" + index + "\\\\]\\\\.todoufukenSikutyousonNmKn'";
    }
}
