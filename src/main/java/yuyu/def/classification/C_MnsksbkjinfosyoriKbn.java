
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 免責・死亡解除情報取得処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MnsksbkjinfosyoriKbn</td><td colspan="3">免責・死亡解除情報取得処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURITOUKEIYM_MATUIZEN_ALL}</td><td>&quot;1&quot;</td><td>数理統計年月末日以前全て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURITOUKEIYM_NAI_ONLY}</td><td>&quot;2&quot;</td><td>数理統計年月内のみ</td></tr>
 * </table>
 */
public class C_MnsksbkjinfosyoriKbn extends Classification<C_MnsksbkjinfosyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MnsksbkjinfosyoriKbn BLNK = new C_MnsksbkjinfosyoriKbn("0");

    public static final C_MnsksbkjinfosyoriKbn SUURITOUKEIYM_MATUIZEN_ALL = new C_MnsksbkjinfosyoriKbn("1");

    public static final C_MnsksbkjinfosyoriKbn SUURITOUKEIYM_NAI_ONLY = new C_MnsksbkjinfosyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SUURITOUKEIYM_MATUIZEN_ALL, "SUURITOUKEIYM_MATUIZEN_ALL", false);
        addPattern(PATTERN_DEFAULT, SUURITOUKEIYM_NAI_ONLY, "SUURITOUKEIYM_NAI_ONLY", false);


        lock(C_MnsksbkjinfosyoriKbn.class);
    }

    private C_MnsksbkjinfosyoriKbn(String value) {
        super(value);
    }

    public static C_MnsksbkjinfosyoriKbn valueOf(String value) {
        return valueOf(C_MnsksbkjinfosyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MnsksbkjinfosyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MnsksbkjinfosyoriKbn.class, patternId, value);
    }
}
