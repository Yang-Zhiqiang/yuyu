package yuyu.app.siharai.sihubikanri.sihubinaiyoukensaku;

/**
 * 保険金給付金不備内容検索 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSiHubiNaiyouKensakuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String SEARCHCONDITIONS = "'#searchConditions'";

    public static final String DISPJIMUTETUZUKINM_SEARCHCONDITIONS = "'#dispjimutetuzukinm'";

    public static final String DISPSYORUINMSNTK_SEARCHCONDITIONS = "'#dispsyoruinmsntk'";


    public static final String SEARCHBUTTONS = "'#searchButtons'";

    public static final String SEARCHBTN_SEARCHBUTTONS = "'#searchBtn'";


    public static final String HUBINAIYOULIST = "'#hubinaiyouList'";

    public static final String DISPHUBINAIYOU_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.disphubinaiyou'";
    }

    public static final String DISPHUBINAIYOUMSG_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.disphubinaiyoumsg'";
    }

    public static final String SYORUICD_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.syoruiCd'";
    }

    public static final String SYORUINM_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.syoruinm'";
    }

    public static final String HUBINAIYOUCD_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.hubinaiyoucd'";
    }

    public static final String SENTAKULINK_HUBINAIYOULIST(int index) {
        return "'#hubinaiyouList\\\\[" + index + "\\\\]\\\\.sentakulink'";
    }
}
