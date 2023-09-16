
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyorikahiKbn</td><td colspan="3">処理可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIKANOU}</td><td>&quot;1&quot;</td><td>処理可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIHUKA}</td><td>&quot;2&quot;</td><td>処理不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUITRATKIKA}</td><td>&quot;3&quot;</td><td>注意取扱可</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DISPANSYUU DISPANSYUU}<br />(案内収納表示用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIKANOU}</td><td>&quot;1&quot;</td><td>処理可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIHUKA}</td><td>&quot;2&quot;</td><td>処理不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUITRATKIKA}</td><td>&quot;3&quot;</td><td>注意取扱有り</td></tr>
 * </table>
 */
public class C_SyorikahiKbn extends Classification<C_SyorikahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyorikahiKbn BLNK = new C_SyorikahiKbn("0");

    public static final C_SyorikahiKbn SYORIKANOU = new C_SyorikahiKbn("1");

    public static final C_SyorikahiKbn SYORIHUKA = new C_SyorikahiKbn("2");

    public static final C_SyorikahiKbn TYUUITRATKIKA = new C_SyorikahiKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DISPANSYUU = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORIKANOU, "SYORIKANOU", false);
        addPattern(PATTERN_DEFAULT, SYORIHUKA, "SYORIHUKA", false);
        addPattern(PATTERN_DEFAULT, TYUUITRATKIKA, "TYUUITRATKIKA", false);


        addPattern(PATTERN_DISPANSYUU, BLNK, "BLNK", false);
        addPattern(PATTERN_DISPANSYUU, SYORIKANOU, "SYORIKANOU", false);
        addPattern(PATTERN_DISPANSYUU, SYORIHUKA, "SYORIHUKA", false);
        addPattern(PATTERN_DISPANSYUU, TYUUITRATKIKA, "TYUUITRATKIKA", false);


        lock(C_SyorikahiKbn.class);
    }

    private C_SyorikahiKbn(String value) {
        super(value);
    }

    public static C_SyorikahiKbn valueOf(String value) {
        return valueOf(C_SyorikahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyorikahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyorikahiKbn.class, patternId, value);
    }
}
