
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理走行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriSoukouKbn</td><td colspan="3">数理走行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HONBAN}</td><td>&quot;H1&quot;</td><td>本番走行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIZENSOUKOU1}</td><td>&quot;S1&quot;</td><td>事前走行１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIZENSOUKOU2}</td><td>&quot;S2&quot;</td><td>事前走行２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIZENSOUKOU3}</td><td>&quot;S3&quot;</td><td>事前走行３</td></tr>
 * </table>
 */
public class C_SuuriSoukouKbn extends Classification<C_SuuriSoukouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriSoukouKbn HONBAN = new C_SuuriSoukouKbn("H1");

    public static final C_SuuriSoukouKbn JIZENSOUKOU1 = new C_SuuriSoukouKbn("S1");

    public static final C_SuuriSoukouKbn JIZENSOUKOU2 = new C_SuuriSoukouKbn("S2");

    public static final C_SuuriSoukouKbn JIZENSOUKOU3 = new C_SuuriSoukouKbn("S3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HONBAN, "HONBAN", true);
        addPattern(PATTERN_DEFAULT, JIZENSOUKOU1, "JIZENSOUKOU1", false);
        addPattern(PATTERN_DEFAULT, JIZENSOUKOU2, "JIZENSOUKOU2", false);
        addPattern(PATTERN_DEFAULT, JIZENSOUKOU3, "JIZENSOUKOU3", false);


        lock(C_SuuriSoukouKbn.class);
    }

    private C_SuuriSoukouKbn(String value) {
        super(value);
    }

    public static C_SuuriSoukouKbn valueOf(String value) {
        return valueOf(C_SuuriSoukouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriSoukouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriSoukouKbn.class, patternId, value);
    }
}
