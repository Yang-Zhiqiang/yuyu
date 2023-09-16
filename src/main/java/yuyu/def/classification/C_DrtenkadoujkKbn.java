
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店稼働状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtenkadoujkKbn</td><td colspan="3">代理店稼働状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITAKU}</td><td>&quot;1&quot;</td><td>委託中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_DrtenkadoujkKbn extends Classification<C_DrtenkadoujkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtenkadoujkKbn BLNK = new C_DrtenkadoujkKbn("0");

    public static final C_DrtenkadoujkKbn ITAKU = new C_DrtenkadoujkKbn("1");

    public static final C_DrtenkadoujkKbn KAIYAKU = new C_DrtenkadoujkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITAKU, "ITAKU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_DrtenkadoujkKbn.class);
    }

    private C_DrtenkadoujkKbn(String value) {
        super(value);
    }

    public static C_DrtenkadoujkKbn valueOf(String value) {
        return valueOf(C_DrtenkadoujkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtenkadoujkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtenkadoujkKbn.class, patternId, value);
    }
}
