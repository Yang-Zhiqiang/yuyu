
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込点検結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MostenkenkekkaKbn</td><td colspan="3">申込点検結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_1}</td><td>&quot;2&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2}</td><td>&quot;3&quot;</td><td>転送（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_3}</td><td>&quot;4&quot;</td><td>転送（３次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;5&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_1}</td><td>&quot;6&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2}</td><td>&quot;7&quot;</td><td>依頼（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_3}</td><td>&quot;8&quot;</td><td>依頼（３次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_HUBI}</td><td>&quot;9&quot;</td><td>転送（点検後不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_HUBI}</td><td>&quot;10&quot;</td><td>依頼（点検後不備）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_TENKENIRAI TENKENIRAI}<br />(点検依頼)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_1}</td><td>&quot;6&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2}</td><td>&quot;7&quot;</td><td>依頼（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_HUBI}</td><td>&quot;10&quot;</td><td>依頼（点検後不備）</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_MOSTENKEN MOSTENKEN}<br />(申込点検)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_1}</td><td>&quot;2&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2}</td><td>&quot;3&quot;</td><td>転送（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_HUBI}</td><td>&quot;9&quot;</td><td>転送（点検後不備）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;5&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_MostenkenkekkaKbn extends Classification<C_MostenkenkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MostenkenkekkaKbn BLNK = new C_MostenkenkekkaKbn("0");

    public static final C_MostenkenkekkaKbn KANRYOU = new C_MostenkenkekkaKbn("1");

    public static final C_MostenkenkekkaKbn TENSOU_1 = new C_MostenkenkekkaKbn("2");

    public static final C_MostenkenkekkaKbn TENSOU_2 = new C_MostenkenkekkaKbn("3");

    public static final C_MostenkenkekkaKbn TENSOU_3 = new C_MostenkenkekkaKbn("4");

    public static final C_MostenkenkekkaKbn HORYUU = new C_MostenkenkekkaKbn("5");

    public static final C_MostenkenkekkaKbn IRAI_1 = new C_MostenkenkekkaKbn("6");

    public static final C_MostenkenkekkaKbn IRAI_2 = new C_MostenkenkekkaKbn("7");

    public static final C_MostenkenkekkaKbn IRAI_3 = new C_MostenkenkekkaKbn("8");

    public static final C_MostenkenkekkaKbn TENSOU_HUBI = new C_MostenkenkekkaKbn("9");

    public static final C_MostenkenkekkaKbn IRAI_HUBI = new C_MostenkenkekkaKbn("10");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TENKENIRAI = "2";

    public static final String PATTERN_MOSTENKEN = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, TENSOU_1, "TENSOU_1", false);
        addPattern(PATTERN_DEFAULT, TENSOU_2, "TENSOU_2", false);
        addPattern(PATTERN_DEFAULT, TENSOU_3, "TENSOU_3", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, IRAI_1, "IRAI_1", false);
        addPattern(PATTERN_DEFAULT, IRAI_2, "IRAI_2", false);
        addPattern(PATTERN_DEFAULT, IRAI_3, "IRAI_3", false);
        addPattern(PATTERN_DEFAULT, TENSOU_HUBI, "TENSOU_HUBI", false);
        addPattern(PATTERN_DEFAULT, IRAI_HUBI, "IRAI_HUBI", false);


        addPattern(PATTERN_TENKENIRAI, BLNK, "BLNK", true);
        addPattern(PATTERN_TENKENIRAI, IRAI_1, "IRAI_1", false);
        addPattern(PATTERN_TENKENIRAI, IRAI_2, "IRAI_2", false);
        addPattern(PATTERN_TENKENIRAI, IRAI_HUBI, "IRAI_HUBI", false);


        addPattern(PATTERN_MOSTENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_MOSTENKEN, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_MOSTENKEN, TENSOU_1, "TENSOU_1", false);
        addPattern(PATTERN_MOSTENKEN, TENSOU_2, "TENSOU_2", false);
        addPattern(PATTERN_MOSTENKEN, TENSOU_HUBI, "TENSOU_HUBI", false);
        addPattern(PATTERN_MOSTENKEN, HORYUU, "HORYUU", false);


        lock(C_MostenkenkekkaKbn.class);
    }

    private C_MostenkenkekkaKbn(String value) {
        super(value);
    }

    public static C_MostenkenkekkaKbn valueOf(String value) {
        return valueOf(C_MostenkenkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MostenkenkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MostenkenkekkaKbn.class, patternId, value);
    }
}
