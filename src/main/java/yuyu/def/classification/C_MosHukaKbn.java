
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込不可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosHukaKbn</td><td colspan="3">申込不可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;2&quot;</td><td>不可</td></tr>
 * </table>
 */
public class C_MosHukaKbn extends Classification<C_MosHukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosHukaKbn BLNK = new C_MosHukaKbn("0");

    public static final C_MosHukaKbn KA = new C_MosHukaKbn("1");

    public static final C_MosHukaKbn HUKA = new C_MosHukaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);


        lock(C_MosHukaKbn.class);
    }

    private C_MosHukaKbn(String value) {
        super(value);
    }

    public static C_MosHukaKbn valueOf(String value) {
        return valueOf(C_MosHukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosHukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosHukaKbn.class, patternId, value);
    }
}
