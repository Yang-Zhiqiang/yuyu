
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 海外居住者識別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KgkyojusikibetuKbn</td><td colspan="3">海外居住者識別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KOKUNAI}</td><td>&quot;0&quot;</td><td>国内居住者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_TKT}</td><td>&quot;1&quot;</td><td>海外居住者（租税条約締結国）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_HITKT}</td><td>&quot;2&quot;</td><td>海外居住者（租税条約非締結国）</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(SYOUKAI)</td><td align="center">○</td><td>{@link #KOKUNAI}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_TKT}</td><td>&quot;1&quot;</td><td>海外居住者（租税条約締結国）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_HITKT}</td><td>&quot;2&quot;</td><td>海外居住者（租税条約非締結国）</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_TYOUSYO TYOUSYO}<br />(調書用)</td><td align="center">○</td><td>{@link #KOKUNAI}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_TKT}</td><td>&quot;1&quot;</td><td>（非）租税条約締結国</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAI_HITKT}</td><td>&quot;2&quot;</td><td>（非）租税条約非締結国</td></tr>
 * </table>
 */
public class C_KgkyojusikibetuKbn extends Classification<C_KgkyojusikibetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KgkyojusikibetuKbn KOKUNAI = new C_KgkyojusikibetuKbn("0");

    public static final C_KgkyojusikibetuKbn KAIGAI_TKT = new C_KgkyojusikibetuKbn("1");

    public static final C_KgkyojusikibetuKbn KAIGAI_HITKT = new C_KgkyojusikibetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";

    public static final String PATTERN_TYOUSYO = "3";


    static {

        addPattern(PATTERN_DEFAULT, KOKUNAI, "KOKUNAI", true);
        addPattern(PATTERN_DEFAULT, KAIGAI_TKT, "KAIGAI_TKT", false);
        addPattern(PATTERN_DEFAULT, KAIGAI_HITKT, "KAIGAI_HITKT", false);


        addPattern(PATTERN_SYOUKAI, KOKUNAI, "KOKUNAI", true);
        addPattern(PATTERN_SYOUKAI, KAIGAI_TKT, "KAIGAI_TKT", false);
        addPattern(PATTERN_SYOUKAI, KAIGAI_HITKT, "KAIGAI_HITKT", false);


        addPattern(PATTERN_TYOUSYO, KOKUNAI, "KOKUNAI", true);
        addPattern(PATTERN_TYOUSYO, KAIGAI_TKT, "KAIGAI_TKT", false);
        addPattern(PATTERN_TYOUSYO, KAIGAI_HITKT, "KAIGAI_HITKT", false);


        lock(C_KgkyojusikibetuKbn.class);
    }

    private C_KgkyojusikibetuKbn(String value) {
        super(value);
    }

    public static C_KgkyojusikibetuKbn valueOf(String value) {
        return valueOf(C_KgkyojusikibetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KgkyojusikibetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KgkyojusikibetuKbn.class, patternId, value);
    }
}
