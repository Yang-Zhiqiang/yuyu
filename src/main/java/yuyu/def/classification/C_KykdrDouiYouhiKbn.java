
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者代理人同意要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykdrDouiYouhiKbn</td><td colspan="3">契約者代理人同意要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 * </table>
 */
public class C_KykdrDouiYouhiKbn extends Classification<C_KykdrDouiYouhiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykdrDouiYouhiKbn BLNK = new C_KykdrDouiYouhiKbn("0");

    public static final C_KykdrDouiYouhiKbn YOU = new C_KykdrDouiYouhiKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, YOU, "YOU", false);


        lock(C_KykdrDouiYouhiKbn.class);
    }

    private C_KykdrDouiYouhiKbn(String value) {
        super(value);
    }

    public static C_KykdrDouiYouhiKbn valueOf(String value) {
        return valueOf(C_KykdrDouiYouhiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykdrDouiYouhiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykdrDouiYouhiKbn.class, patternId, value);
    }
}
