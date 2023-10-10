package yuyu.app.siharai.sikensaku.sisrchbyoumei;

/**
 * 病名検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSiSrchByoumeiSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String BYOUMEIKJ_SEARCHCONDITIONS = "'#byoumeikj'";

    public static final String BYOUMEIKN_SEARCHCONDITIONS = "'#byoumeikn'";

    public static final String BYOUMEICD_SEARCHCONDITIONS = "'#byoumeicd'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String SEARCHRESULTS = "'#searchResults'";

    public static final String BYOUMEICD_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.byoumeicd'";
    }

    public static final String BYOUMEIKJ_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.byoumeikj'";
    }

    public static final String BYOUMEIKN_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.byoumeikn'";
    }

    public static final String GAITOUKBN2_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.gaitoukbn2'";
    }

    public static final String BYOUMEITOUROKUNO_SEARCHRESULTS(int index) {
        return "'#searchResults\\\\[" + index + "\\\\]\\\\.byoumeitourokuno'";
    }
}
