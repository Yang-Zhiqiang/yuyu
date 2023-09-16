
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 親権者後見人変更事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SksKknHnkJiyuuKbn</td><td colspan="3">親権者後見人変更事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;1&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>設定・変更</td></tr>
 * </table>
 */
public class C_SksKknHnkJiyuuKbn extends Classification<C_SksKknHnkJiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SksKknHnkJiyuuKbn BLNK = new C_SksKknHnkJiyuuKbn("0");

    public static final C_SksKknHnkJiyuuKbn KAISEIKAIMEI = new C_SksKknHnkJiyuuKbn("1");

    public static final C_SksKknHnkJiyuuKbn HENKOU = new C_SksKknHnkJiyuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAISEIKAIMEI, "KAISEIKAIMEI", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);


        lock(C_SksKknHnkJiyuuKbn.class);
    }

    private C_SksKknHnkJiyuuKbn(String value) {
        super(value);
    }

    public static C_SksKknHnkJiyuuKbn valueOf(String value) {
        return valueOf(C_SksKknHnkJiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SksKknHnkJiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SksKknHnkJiyuuKbn.class, patternId, value);
    }
}
