package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

/**
 * 決定理由一覧 JavaScript(jQuery)用の 画面項目Selector 定数定義です。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSkKetteiRiyuuSelector {


    public static final String HEADERBUTTONS = "'#headerButtons'";

    public static final String TOJIRUBTN_HEADERBUTTONS = "'#tojiruBtn'";


    public static final String KETTEIRIYUULIST = "'#ketteiriyuuList'";

    public static final String DISPKETTEIRIYUUCD_KETTEIRIYUULIST(int index) {
        return "'#ketteiriyuuList\\\\[" + index + "\\\\]\\\\.dispketteiriyuucd'";
    }

    public static final String DISPKETTEIRIYUUNAIYOU_KETTEIRIYUULIST(int index) {
        return "'#ketteiriyuuList\\\\[" + index + "\\\\]\\\\.dispketteiriyuunaiyou'";
    }
}
