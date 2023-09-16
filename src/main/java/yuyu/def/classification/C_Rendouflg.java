
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連動フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Rendouflg</td><td colspan="3">連動フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIRENDOU}</td><td>&quot;0&quot;</td><td>未連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENDOUZUMI}</td><td>&quot;1&quot;</td><td>連動済</td></tr>
 * </table>
 */
public class C_Rendouflg extends Classification<C_Rendouflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Rendouflg MIRENDOU = new C_Rendouflg("0");

    public static final C_Rendouflg RENDOUZUMI = new C_Rendouflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIRENDOU, "MIRENDOU", true);
        addPattern(PATTERN_DEFAULT, RENDOUZUMI, "RENDOUZUMI", false);


        lock(C_Rendouflg.class);
    }

    private C_Rendouflg(String value) {
        super(value);
    }

    public static C_Rendouflg valueOf(String value) {
        return valueOf(C_Rendouflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Rendouflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Rendouflg.class, patternId, value);
    }
}
