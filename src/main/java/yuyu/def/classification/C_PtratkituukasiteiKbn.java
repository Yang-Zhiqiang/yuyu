
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料取扱通貨指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PtratkituukasiteiKbn</td><td colspan="3">保険料取扱通貨指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUUKA}</td><td>&quot;1&quot;</td><td>指定通貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKTUUKA}</td><td>&quot;2&quot;</td><td>払込通貨</td></tr>
 * </table>
 */
public class C_PtratkituukasiteiKbn extends Classification<C_PtratkituukasiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PtratkituukasiteiKbn BLNK = new C_PtratkituukasiteiKbn("0");

    public static final C_PtratkituukasiteiKbn SITEITUUKA = new C_PtratkituukasiteiKbn("1");

    public static final C_PtratkituukasiteiKbn HRKTUUKA = new C_PtratkituukasiteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SITEITUUKA, "SITEITUUKA", false);
        addPattern(PATTERN_DEFAULT, HRKTUUKA, "HRKTUUKA", false);


        lock(C_PtratkituukasiteiKbn.class);
    }

    private C_PtratkituukasiteiKbn(String value) {
        super(value);
    }

    public static C_PtratkituukasiteiKbn valueOf(String value) {
        return valueOf(C_PtratkituukasiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PtratkituukasiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PtratkituukasiteiKbn.class, patternId, value);
    }
}
