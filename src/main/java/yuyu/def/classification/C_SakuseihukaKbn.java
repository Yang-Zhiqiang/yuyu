
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 作成不可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuseihukaKbn</td><td colspan="3">作成不可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SAKUSEIKA}</td><td>&quot;0&quot;</td><td>作成可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIHUKA}</td><td>&quot;1&quot;</td><td>作成不可</td></tr>
 * </table>
 */
public class C_SakuseihukaKbn extends Classification<C_SakuseihukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuseihukaKbn SAKUSEIKA = new C_SakuseihukaKbn("0");

    public static final C_SakuseihukaKbn SAKUSEIHUKA = new C_SakuseihukaKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SAKUSEIKA, "SAKUSEIKA", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIHUKA, "SAKUSEIHUKA", false);


        lock(C_SakuseihukaKbn.class);
    }

    private C_SakuseihukaKbn(String value) {
        super(value);
    }

    public static C_SakuseihukaKbn valueOf(String value) {
        return valueOf(C_SakuseihukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuseihukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuseihukaKbn.class, patternId, value);
    }
}
