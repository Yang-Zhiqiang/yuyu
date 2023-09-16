
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金受取方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SUketoriHouhouKbn</td><td colspan="3">保険金受取方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENGAKU_ITIJIKN}</td><td>&quot;1&quot;</td><td>全額一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENGAKU_NENKIN}</td><td>&quot;2&quot;</td><td>全額年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBU_NENKIN}</td><td>&quot;3&quot;</td><td>一部年金</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_ZENGAKU_ITIJIKN ZENGAKU_ITIJIKN}<br />(全額一時金)</td><td align="center">○</td><td>{@link #ZENGAKU_ITIJIKN}</td><td>&quot;1&quot;</td><td>全額一時金</td></tr>
 * </table>
 */
public class C_SUketoriHouhouKbn extends Classification<C_SUketoriHouhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SUketoriHouhouKbn BLNK = new C_SUketoriHouhouKbn("0");

    public static final C_SUketoriHouhouKbn ZENGAKU_ITIJIKN = new C_SUketoriHouhouKbn("1");

    public static final C_SUketoriHouhouKbn ZENGAKU_NENKIN = new C_SUketoriHouhouKbn("2");

    public static final C_SUketoriHouhouKbn ITIBU_NENKIN = new C_SUketoriHouhouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_ZENGAKU_ITIJIKN = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENGAKU_ITIJIKN, "ZENGAKU_ITIJIKN", false);
        addPattern(PATTERN_DEFAULT, ZENGAKU_NENKIN, "ZENGAKU_NENKIN", false);
        addPattern(PATTERN_DEFAULT, ITIBU_NENKIN, "ITIBU_NENKIN", false);


        addPattern(PATTERN_ZENGAKU_ITIJIKN, ZENGAKU_ITIJIKN, "ZENGAKU_ITIJIKN", true);


        lock(C_SUketoriHouhouKbn.class);
    }

    private C_SUketoriHouhouKbn(String value) {
        super(value);
    }

    public static C_SUketoriHouhouKbn valueOf(String value) {
        return valueOf(C_SUketoriHouhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SUketoriHouhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SUketoriHouhouKbn.class, patternId, value);
    }
}
