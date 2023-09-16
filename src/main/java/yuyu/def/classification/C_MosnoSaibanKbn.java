
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込番号採番区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosnoSaibanKbn</td><td colspan="3">申込番号採番区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KIT}</td><td>&quot;1&quot;</td><td>キット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIT2KEN}</td><td>&quot;2&quot;</td><td>キット（２件）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PPLESSNIT}</td><td>&quot;3&quot;</td><td>ペーパーレス（ＮＩＴ）</td></tr>
 * </table>
 */
public class C_MosnoSaibanKbn extends Classification<C_MosnoSaibanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosnoSaibanKbn KIT = new C_MosnoSaibanKbn("1");

    public static final C_MosnoSaibanKbn KIT2KEN = new C_MosnoSaibanKbn("2");

    public static final C_MosnoSaibanKbn PPLESSNIT = new C_MosnoSaibanKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KIT, "KIT", true);
        addPattern(PATTERN_DEFAULT, KIT2KEN, "KIT2KEN", false);
        addPattern(PATTERN_DEFAULT, PPLESSNIT, "PPLESSNIT", false);


        lock(C_MosnoSaibanKbn.class);
    }

    private C_MosnoSaibanKbn(String value) {
        super(value);
    }

    public static C_MosnoSaibanKbn valueOf(String value) {
        return valueOf(C_MosnoSaibanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosnoSaibanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosnoSaibanKbn.class, patternId, value);
    }
}
