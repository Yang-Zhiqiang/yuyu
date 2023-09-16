
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当金受取方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitoukinuketorihouKbn</td><td colspan="3">配当金受取方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMIHAI}</td><td>&quot;1&quot;</td><td>積配</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMIHAI}</td><td>&quot;1&quot;</td><td>積立配当</td></tr>
 * </table>
 */
public class C_HaitoukinuketorihouKbn extends Classification<C_HaitoukinuketorihouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitoukinuketorihouKbn BLNK = new C_HaitoukinuketorihouKbn("0");

    public static final C_HaitoukinuketorihouKbn TUMIHAI = new C_HaitoukinuketorihouKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUMIHAI, "TUMIHAI", false);


        addPattern(PATTERN_SYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SYOUKAI, TUMIHAI, "TUMIHAI", false);


        lock(C_HaitoukinuketorihouKbn.class);
    }

    private C_HaitoukinuketorihouKbn(String value) {
        super(value);
    }

    public static C_HaitoukinuketorihouKbn valueOf(String value) {
        return valueOf(C_HaitoukinuketorihouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitoukinuketorihouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitoukinuketorihouKbn.class, patternId, value);
    }
}
