
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosKbn</td><td colspan="3">申込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAIMEN}</td><td>&quot;1&quot;</td><td>対面</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITAIMENA}</td><td>&quot;2&quot;</td><td>非対面A</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITAIMENB}</td><td>&quot;3&quot;</td><td>非対面B</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITAIMENWEB}</td><td>&quot;4&quot;</td><td>非対面Web</td></tr>
 * </table>
 */
public class C_MosKbn extends Classification<C_MosKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosKbn BLNK = new C_MosKbn("0");

    public static final C_MosKbn TAIMEN = new C_MosKbn("1");

    public static final C_MosKbn HITAIMENA = new C_MosKbn("2");

    public static final C_MosKbn HITAIMENB = new C_MosKbn("3");

    public static final C_MosKbn HITAIMENWEB = new C_MosKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TAIMEN, "TAIMEN", false);
        addPattern(PATTERN_DEFAULT, HITAIMENA, "HITAIMENA", false);
        addPattern(PATTERN_DEFAULT, HITAIMENB, "HITAIMENB", false);
        addPattern(PATTERN_DEFAULT, HITAIMENWEB, "HITAIMENWEB", false);


        lock(C_MosKbn.class);
    }

    private C_MosKbn(String value) {
        super(value);
    }

    public static C_MosKbn valueOf(String value) {
        return valueOf(C_MosKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosKbn.class, patternId, value);
    }
}
