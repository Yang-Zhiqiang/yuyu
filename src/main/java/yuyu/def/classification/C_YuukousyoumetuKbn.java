
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効消滅区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukousyoumetuKbn</td><td colspan="3">有効消滅区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_YuukousyoumetuKbn extends Classification<C_YuukousyoumetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukousyoumetuKbn BLNK = new C_YuukousyoumetuKbn("0");

    public static final C_YuukousyoumetuKbn YUUKOU = new C_YuukousyoumetuKbn("1");

    public static final C_YuukousyoumetuKbn SYOUMETU = new C_YuukousyoumetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_SELECT, SYOUMETU, "SYOUMETU", false);


        lock(C_YuukousyoumetuKbn.class);
    }

    private C_YuukousyoumetuKbn(String value) {
        super(value);
    }

    public static C_YuukousyoumetuKbn valueOf(String value) {
        return valueOf(C_YuukousyoumetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukousyoumetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukousyoumetuKbn.class, patternId, value);
    }
}
