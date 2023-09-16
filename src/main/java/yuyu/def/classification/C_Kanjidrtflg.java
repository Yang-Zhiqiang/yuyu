
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 幹事代理店フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kanjidrtflg</td><td colspan="3">幹事代理店フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HIKANJI}</td><td>&quot;0&quot;</td><td>非幹事代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJI}</td><td>&quot;1&quot;</td><td>幹事代理店</td></tr>
 * </table>
 */
public class C_Kanjidrtflg extends Classification<C_Kanjidrtflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Kanjidrtflg HIKANJI = new C_Kanjidrtflg("0");

    public static final C_Kanjidrtflg KANJI = new C_Kanjidrtflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HIKANJI, "HIKANJI", true);
        addPattern(PATTERN_DEFAULT, KANJI, "KANJI", false);


        lock(C_Kanjidrtflg.class);
    }

    private C_Kanjidrtflg(String value) {
        super(value);
    }

    public static C_Kanjidrtflg valueOf(String value) {
        return valueOf(C_Kanjidrtflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kanjidrtflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kanjidrtflg.class, patternId, value);
    }
}
