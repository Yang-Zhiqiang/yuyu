
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 危険支払指数区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KikenshrsisuuKbn</td><td colspan="3">危険支払指数区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKENSHRSISUUA}</td><td>&quot;1&quot;</td><td>危険支払指数Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKENSHRSISUUB}</td><td>&quot;2&quot;</td><td>危険支払指数Ｂ</td></tr>
 * </table>
 */
public class C_KikenshrsisuuKbn extends Classification<C_KikenshrsisuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KikenshrsisuuKbn BLNK = new C_KikenshrsisuuKbn("0");

    public static final C_KikenshrsisuuKbn KIKENSHRSISUUA = new C_KikenshrsisuuKbn("1");

    public static final C_KikenshrsisuuKbn KIKENSHRSISUUB = new C_KikenshrsisuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KIKENSHRSISUUA, "KIKENSHRSISUUA", false);
        addPattern(PATTERN_DEFAULT, KIKENSHRSISUUB, "KIKENSHRSISUUB", false);


        lock(C_KikenshrsisuuKbn.class);
    }

    private C_KikenshrsisuuKbn(String value) {
        super(value);
    }

    public static C_KikenshrsisuuKbn valueOf(String value) {
        return valueOf(C_KikenshrsisuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KikenshrsisuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KikenshrsisuuKbn.class, patternId, value);
    }
}
