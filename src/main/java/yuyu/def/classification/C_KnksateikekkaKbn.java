
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 環境査定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KnksateikekkaKbn</td><td colspan="3">環境査定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_1}</td><td>&quot;2&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2A}</td><td>&quot;3&quot;</td><td>転送（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2B}</td><td>&quot;4&quot;</td><td>転送（２次Ｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;6&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_1}</td><td>&quot;7&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2A}</td><td>&quot;8&quot;</td><td>依頼（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2B}</td><td>&quot;9&quot;</td><td>依頼（２次Ｂ）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SATEITENSOU SATEITENSOU}<br />(査定転送)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_1}</td><td>&quot;2&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2A}</td><td>&quot;3&quot;</td><td>転送（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2B}</td><td>&quot;4&quot;</td><td>転送（２次Ｂ）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SATEIIRAI SATEIIRAI}<br />(査定依頼)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_1}</td><td>&quot;7&quot;</td><td>依頼（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2A}</td><td>&quot;8&quot;</td><td>依頼（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI_2B}</td><td>&quot;9&quot;</td><td>依頼（２次Ｂ）</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KNKSATEI KNKSATEI}<br />(環境査定)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_1}</td><td>&quot;2&quot;</td><td>転送（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2A}</td><td>&quot;3&quot;</td><td>転送（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU_2B}</td><td>&quot;4&quot;</td><td>転送（２次Ｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;6&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_KnksateikekkaKbn extends Classification<C_KnksateikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KnksateikekkaKbn BLNK = new C_KnksateikekkaKbn("0");

    public static final C_KnksateikekkaKbn KANRYOU = new C_KnksateikekkaKbn("1");

    public static final C_KnksateikekkaKbn TENSOU_1 = new C_KnksateikekkaKbn("2");

    public static final C_KnksateikekkaKbn TENSOU_2A = new C_KnksateikekkaKbn("3");

    public static final C_KnksateikekkaKbn TENSOU_2B = new C_KnksateikekkaKbn("4");

    public static final C_KnksateikekkaKbn HORYUU = new C_KnksateikekkaKbn("6");

    public static final C_KnksateikekkaKbn IRAI_1 = new C_KnksateikekkaKbn("7");

    public static final C_KnksateikekkaKbn IRAI_2A = new C_KnksateikekkaKbn("8");

    public static final C_KnksateikekkaKbn IRAI_2B = new C_KnksateikekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SATEITENSOU = "2";

    public static final String PATTERN_SATEIIRAI = "3";

    public static final String PATTERN_KNKSATEI = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, TENSOU_1, "TENSOU_1", false);
        addPattern(PATTERN_DEFAULT, TENSOU_2A, "TENSOU_2A", false);
        addPattern(PATTERN_DEFAULT, TENSOU_2B, "TENSOU_2B", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, IRAI_1, "IRAI_1", false);
        addPattern(PATTERN_DEFAULT, IRAI_2A, "IRAI_2A", false);
        addPattern(PATTERN_DEFAULT, IRAI_2B, "IRAI_2B", false);


        addPattern(PATTERN_SATEITENSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SATEITENSOU, TENSOU_1, "TENSOU_1", false);
        addPattern(PATTERN_SATEITENSOU, TENSOU_2A, "TENSOU_2A", false);
        addPattern(PATTERN_SATEITENSOU, TENSOU_2B, "TENSOU_2B", false);


        addPattern(PATTERN_SATEIIRAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SATEIIRAI, IRAI_1, "IRAI_1", false);
        addPattern(PATTERN_SATEIIRAI, IRAI_2A, "IRAI_2A", false);
        addPattern(PATTERN_SATEIIRAI, IRAI_2B, "IRAI_2B", false);


        addPattern(PATTERN_KNKSATEI, BLNK, "BLNK", true);
        addPattern(PATTERN_KNKSATEI, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_KNKSATEI, TENSOU_1, "TENSOU_1", false);
        addPattern(PATTERN_KNKSATEI, TENSOU_2A, "TENSOU_2A", false);
        addPattern(PATTERN_KNKSATEI, TENSOU_2B, "TENSOU_2B", false);
        addPattern(PATTERN_KNKSATEI, HORYUU, "HORYUU", false);


        lock(C_KnksateikekkaKbn.class);
    }

    private C_KnksateikekkaKbn(String value) {
        super(value);
    }

    public static C_KnksateikekkaKbn valueOf(String value) {
        return valueOf(C_KnksateikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KnksateikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KnksateikekkaKbn.class, patternId, value);
    }
}
