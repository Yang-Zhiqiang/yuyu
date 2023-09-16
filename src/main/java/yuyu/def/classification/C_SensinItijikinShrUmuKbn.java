
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 先進医療一時金支払有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SensinItijikinShrUmuKbn</td><td colspan="3">先進医療一時金支払有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIARI}</td><td>&quot;1&quot;</td><td>一時金あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJINASI}</td><td>&quot;2&quot;</td><td>一時金なし</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #ITIJIARI}</td><td>&quot;1&quot;</td><td>一時金あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJINASI}</td><td>&quot;2&quot;</td><td>一時金なし</td></tr>
 * </table>
 */
public class C_SensinItijikinShrUmuKbn extends Classification<C_SensinItijikinShrUmuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SensinItijikinShrUmuKbn BLNK = new C_SensinItijikinShrUmuKbn("0");

    public static final C_SensinItijikinShrUmuKbn ITIJIARI = new C_SensinItijikinShrUmuKbn("1");

    public static final C_SensinItijikinShrUmuKbn ITIJINASI = new C_SensinItijikinShrUmuKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJIARI, "ITIJIARI", false);
        addPattern(PATTERN_DEFAULT, ITIJINASI, "ITIJINASI", false);


        addPattern(PATTERN_SELECT, ITIJIARI, "ITIJIARI", true);
        addPattern(PATTERN_SELECT, ITIJINASI, "ITIJINASI", false);


        lock(C_SensinItijikinShrUmuKbn.class);
    }

    private C_SensinItijikinShrUmuKbn(String value) {
        super(value);
    }

    public static C_SensinItijikinShrUmuKbn valueOf(String value) {
        return valueOf(C_SensinItijikinShrUmuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SensinItijikinShrUmuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SensinItijikinShrUmuKbn.class, patternId, value);
    }
}
