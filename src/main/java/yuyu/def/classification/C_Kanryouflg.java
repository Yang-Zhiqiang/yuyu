
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 完了フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kanryouflg</td><td colspan="3">完了フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIKANRYOU}</td><td>&quot;0&quot;</td><td>未完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_Kanryouflg extends Classification<C_Kanryouflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Kanryouflg MIKANRYOU = new C_Kanryouflg("0");

    public static final C_Kanryouflg KANRYOU = new C_Kanryouflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIKANRYOU, "MIKANRYOU", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_Kanryouflg.class);
    }

    private C_Kanryouflg(String value) {
        super(value);
    }

    public static C_Kanryouflg valueOf(String value) {
        return valueOf(C_Kanryouflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kanryouflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kanryouflg.class, patternId, value);
    }
}
