
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 端数処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HasuusyoriKbn</td><td colspan="3">端数処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGE}</td><td>&quot;1&quot;</td><td>切り上げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUTE}</td><td>&quot;2&quot;</td><td>切り捨て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSYGNY}</td><td>&quot;3&quot;</td><td>四捨五入</td></tr>
 * </table>
 */
public class C_HasuusyoriKbn extends Classification<C_HasuusyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HasuusyoriKbn BLNK = new C_HasuusyoriKbn("0");

    public static final C_HasuusyoriKbn AGE = new C_HasuusyoriKbn("1");

    public static final C_HasuusyoriKbn SUTE = new C_HasuusyoriKbn("2");

    public static final C_HasuusyoriKbn SSYGNY = new C_HasuusyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, AGE, "AGE", false);
        addPattern(PATTERN_DEFAULT, SUTE, "SUTE", false);
        addPattern(PATTERN_DEFAULT, SSYGNY, "SSYGNY", false);


        lock(C_HasuusyoriKbn.class);
    }

    private C_HasuusyoriKbn(String value) {
        super(value);
    }

    public static C_HasuusyoriKbn valueOf(String value) {
        return valueOf(C_HasuusyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HasuusyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HasuusyoriKbn.class, patternId, value);
    }
}
