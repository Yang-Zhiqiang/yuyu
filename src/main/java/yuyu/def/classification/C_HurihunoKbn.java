
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替不能理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HurihunoKbn</td><td colspan="3">振替不能理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINHUSOKU}</td><td>&quot;1&quot;</td><td>資金不足</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOKOZA}</td><td>&quot;2&quot;</td><td>口座なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKNSYATUGOU}</td><td>&quot;3&quot;</td><td>預金者都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOKOUHURIIRAI}</td><td>&quot;4&quot;</td><td>口座振替依頼書なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITKTUGOU}</td><td>&quot;8&quot;</td><td>委託者都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_HurihunoKbn extends Classification<C_HurihunoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HurihunoKbn BLNK = new C_HurihunoKbn("0");

    public static final C_HurihunoKbn SIKINHUSOKU = new C_HurihunoKbn("1");

    public static final C_HurihunoKbn NOKOZA = new C_HurihunoKbn("2");

    public static final C_HurihunoKbn YKNSYATUGOU = new C_HurihunoKbn("3");

    public static final C_HurihunoKbn NOKOUHURIIRAI = new C_HurihunoKbn("4");

    public static final C_HurihunoKbn ITKTUGOU = new C_HurihunoKbn("8");

    public static final C_HurihunoKbn OTHER = new C_HurihunoKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIKINHUSOKU, "SIKINHUSOKU", false);
        addPattern(PATTERN_DEFAULT, NOKOZA, "NOKOZA", false);
        addPattern(PATTERN_DEFAULT, YKNSYATUGOU, "YKNSYATUGOU", false);
        addPattern(PATTERN_DEFAULT, NOKOUHURIIRAI, "NOKOUHURIIRAI", false);
        addPattern(PATTERN_DEFAULT, ITKTUGOU, "ITKTUGOU", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        lock(C_HurihunoKbn.class);
    }

    private C_HurihunoKbn(String value) {
        super(value);
    }

    public static C_HurihunoKbn valueOf(String value) {
        return valueOf(C_HurihunoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HurihunoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HurihunoKbn.class, patternId, value);
    }
}
