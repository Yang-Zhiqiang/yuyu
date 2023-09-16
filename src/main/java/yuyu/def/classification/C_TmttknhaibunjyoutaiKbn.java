
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 積立金配分状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TmttknhaibunjyoutaiKbn</td><td colspan="3">積立金配分状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITU_ONLY}</td><td>&quot;1&quot;</td><td>定率のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUU_ONLY}</td><td>&quot;2&quot;</td><td>指数のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUUTEIRITU}</td><td>&quot;3&quot;</td><td>指数定率あり</td></tr>
 * </table>
 */
public class C_TmttknhaibunjyoutaiKbn extends Classification<C_TmttknhaibunjyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TmttknhaibunjyoutaiKbn BLNK = new C_TmttknhaibunjyoutaiKbn("0");

    public static final C_TmttknhaibunjyoutaiKbn TEIRITU_ONLY = new C_TmttknhaibunjyoutaiKbn("1");

    public static final C_TmttknhaibunjyoutaiKbn SISUU_ONLY = new C_TmttknhaibunjyoutaiKbn("2");

    public static final C_TmttknhaibunjyoutaiKbn SISUUTEIRITU = new C_TmttknhaibunjyoutaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TEIRITU_ONLY, "TEIRITU_ONLY", false);
        addPattern(PATTERN_DEFAULT, SISUU_ONLY, "SISUU_ONLY", false);
        addPattern(PATTERN_DEFAULT, SISUUTEIRITU, "SISUUTEIRITU", false);


        lock(C_TmttknhaibunjyoutaiKbn.class);
    }

    private C_TmttknhaibunjyoutaiKbn(String value) {
        super(value);
    }

    public static C_TmttknhaibunjyoutaiKbn valueOf(String value) {
        return valueOf(C_TmttknhaibunjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TmttknhaibunjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TmttknhaibunjyoutaiKbn.class, patternId, value);
    }
}
