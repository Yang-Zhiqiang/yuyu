
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医務査定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ImusateikekkaKbn</td><td colspan="3">医務査定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_UW}</td><td>&quot;2&quot;</td><td>転送（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_MD}</td><td>&quot;3&quot;</td><td>転送（簡易（ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;5&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANI_UW}</td><td>&quot;6&quot;</td><td>依頼（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANI_MD}</td><td>&quot;7&quot;</td><td>依頼（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SATEITENSOU SATEITENSOU}<br />(査定転送)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_UW}</td><td>&quot;2&quot;</td><td>転送（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_MD}</td><td>&quot;3&quot;</td><td>転送（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SATEIIRAI SATEIIRAI}<br />(査定依頼)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANI_UW}</td><td>&quot;6&quot;</td><td>依頼（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_KANI_MD}</td><td>&quot;7&quot;</td><td>依頼（簡易（ＭＤ））</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_IMUSATEI IMUSATEI}<br />(医務査定)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_UW}</td><td>&quot;2&quot;</td><td>転送（簡易（ＵＷ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_KANI_MD}</td><td>&quot;3&quot;</td><td>転送（簡易（ＭＤ））</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;5&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_ImusateikekkaKbn extends Classification<C_ImusateikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ImusateikekkaKbn NONE = new C_ImusateikekkaKbn("0");

    public static final C_ImusateikekkaKbn KANRYOU = new C_ImusateikekkaKbn("1");

    public static final C_ImusateikekkaKbn TENSOU_KANI_UW = new C_ImusateikekkaKbn("2");

    public static final C_ImusateikekkaKbn TENSOU_KANI_MD = new C_ImusateikekkaKbn("3");

    public static final C_ImusateikekkaKbn HORYUU = new C_ImusateikekkaKbn("5");

    public static final C_ImusateikekkaKbn IRAI_KANI_UW = new C_ImusateikekkaKbn("6");

    public static final C_ImusateikekkaKbn IRAI_KANI_MD = new C_ImusateikekkaKbn("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SATEITENSOU = "2";

    public static final String PATTERN_SATEIIRAI = "3";

    public static final String PATTERN_IMUSATEI = "4";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, TENSOU_KANI_UW, "TENSOU_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, TENSOU_KANI_MD, "TENSOU_KANI_MD", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, IRAI_KANI_UW, "IRAI_KANI_UW", false);
        addPattern(PATTERN_DEFAULT, IRAI_KANI_MD, "IRAI_KANI_MD", false);


        addPattern(PATTERN_SATEITENSOU, NONE, "NONE", true);
        addPattern(PATTERN_SATEITENSOU, TENSOU_KANI_UW, "TENSOU_KANI_UW", false);
        addPattern(PATTERN_SATEITENSOU, TENSOU_KANI_MD, "TENSOU_KANI_MD", false);


        addPattern(PATTERN_SATEIIRAI, NONE, "NONE", true);
        addPattern(PATTERN_SATEIIRAI, IRAI_KANI_UW, "IRAI_KANI_UW", false);
        addPattern(PATTERN_SATEIIRAI, IRAI_KANI_MD, "IRAI_KANI_MD", false);


        addPattern(PATTERN_IMUSATEI, NONE, "NONE", true);
        addPattern(PATTERN_IMUSATEI, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_IMUSATEI, TENSOU_KANI_UW, "TENSOU_KANI_UW", false);
        addPattern(PATTERN_IMUSATEI, TENSOU_KANI_MD, "TENSOU_KANI_MD", false);
        addPattern(PATTERN_IMUSATEI, HORYUU, "HORYUU", false);


        lock(C_ImusateikekkaKbn.class);
    }

    private C_ImusateikekkaKbn(String value) {
        super(value);
    }

    public static C_ImusateikekkaKbn valueOf(String value) {
        return valueOf(C_ImusateikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ImusateikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ImusateikekkaKbn.class, patternId, value);
    }
}
