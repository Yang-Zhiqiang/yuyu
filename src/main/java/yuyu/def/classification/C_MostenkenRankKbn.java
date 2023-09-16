
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込点検ランク区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MostenkenRankKbn</td><td colspan="3">申込点検ランク区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;2&quot;</td><td>１次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJI}</td><td>&quot;3&quot;</td><td>２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;5&quot;</td><td>点検後不備</td></tr>
 * </table>
 */
public class C_MostenkenRankKbn extends Classification<C_MostenkenRankKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MostenkenRankKbn BLNK = new C_MostenkenRankKbn("0");

    public static final C_MostenkenRankKbn NONE = new C_MostenkenRankKbn("1");

    public static final C_MostenkenRankKbn ITIJI = new C_MostenkenRankKbn("2");

    public static final C_MostenkenRankKbn NIJI = new C_MostenkenRankKbn("3");

    public static final C_MostenkenRankKbn HUBI = new C_MostenkenRankKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, NIJI, "NIJI", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);


        lock(C_MostenkenRankKbn.class);
    }

    private C_MostenkenRankKbn(String value) {
        super(value);
    }

    public static C_MostenkenRankKbn valueOf(String value) {
        return valueOf(C_MostenkenRankKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MostenkenRankKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MostenkenRankKbn.class, patternId, value);
    }
}
