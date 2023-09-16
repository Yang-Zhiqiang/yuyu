
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約既契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkeikikeiyakuKbn</td><td colspan="3">新契約既契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;1&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKEIYAKU}</td><td>&quot;2&quot;</td><td>既契約</td></tr>
 * </table>
 */
public class C_SkeikikeiyakuKbn extends Classification<C_SkeikikeiyakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkeikikeiyakuKbn BLNK = new C_SkeikikeiyakuKbn("0");

    public static final C_SkeikikeiyakuKbn SKEI = new C_SkeikikeiyakuKbn("1");

    public static final C_SkeikikeiyakuKbn KIKEIYAKU = new C_SkeikikeiyakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, KIKEIYAKU, "KIKEIYAKU", false);


        lock(C_SkeikikeiyakuKbn.class);
    }

    private C_SkeikikeiyakuKbn(String value) {
        super(value);
    }

    public static C_SkeikikeiyakuKbn valueOf(String value) {
        return valueOf(C_SkeikikeiyakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkeikikeiyakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkeikikeiyakuKbn.class, patternId, value);
    }
}
