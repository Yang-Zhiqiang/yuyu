
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医務査定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ImusateijyouKbn</td><td colspan="3">医務査定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIZUMI}</td><td>&quot;1&quot;</td><td>医務査定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_KANI_UW}</td><td>&quot;2&quot;</td><td>査定待ち（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_KANI_MD}</td><td>&quot;3&quot;</td><td>査定待ち（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIZUMI}</td><td>&quot;1&quot;</td><td>医務査定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_KANI_UW}</td><td>&quot;2&quot;</td><td>簡易（ＵＷ）待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_KANI_MD}</td><td>&quot;3&quot;</td><td>簡易（ＭＤ）待ち</td></tr>
 * </table>
 */
public class C_ImusateijyouKbn extends Classification<C_ImusateijyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ImusateijyouKbn NONE = new C_ImusateijyouKbn("0");

    public static final C_ImusateijyouKbn SATEIZUMI = new C_ImusateijyouKbn("1");

    public static final C_ImusateijyouKbn SATEIMATI_KANI_UW = new C_ImusateijyouKbn("2");

    public static final C_ImusateijyouKbn SATEIMATI_KANI_MD = new C_ImusateijyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RYAKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SATEIZUMI, "SATEIZUMI", false);
        addPattern(PATTERN_DEFAULT, SATEIMATI_KANI_UW, "SATEIMATI_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, SATEIMATI_KANI_MD, "SATEIMATI_KANI_MD", false);


        addPattern(PATTERN_RYAKU, NONE, "NONE", false);
        addPattern(PATTERN_RYAKU, SATEIZUMI, "SATEIZUMI", false);
        addPattern(PATTERN_RYAKU, SATEIMATI_KANI_UW, "SATEIMATI_KANI_UW", false);
        addPattern(PATTERN_RYAKU, SATEIMATI_KANI_MD, "SATEIMATI_KANI_MD", false);


        lock(C_ImusateijyouKbn.class);
    }

    private C_ImusateijyouKbn(String value) {
        super(value);
    }

    public static C_ImusateijyouKbn valueOf(String value) {
        return valueOf(C_ImusateijyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ImusateijyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ImusateijyouKbn.class, patternId, value);
    }
}
