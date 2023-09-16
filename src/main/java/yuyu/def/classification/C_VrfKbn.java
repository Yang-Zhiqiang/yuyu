
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ベリファイ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_VrfKbn</td><td colspan="3">ベリファイ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #VRF_NONE}</td><td>&quot;0&quot;</td><td>ベリファイ未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VRF_1JI}</td><td>&quot;1&quot;</td><td>1次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VRF_2JI}</td><td>&quot;2&quot;</td><td>2次</td></tr>
 * </table>
 */
public class C_VrfKbn extends Classification<C_VrfKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_VrfKbn VRF_NONE = new C_VrfKbn("0");

    public static final C_VrfKbn VRF_1JI = new C_VrfKbn("1");

    public static final C_VrfKbn VRF_2JI = new C_VrfKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, VRF_NONE, "VRF_NONE", true);
        addPattern(PATTERN_DEFAULT, VRF_1JI, "VRF_1JI", false);
        addPattern(PATTERN_DEFAULT, VRF_2JI, "VRF_2JI", false);


        lock(C_VrfKbn.class);
    }

    private C_VrfKbn(String value) {
        super(value);
    }

    public static C_VrfKbn valueOf(String value) {
        return valueOf(C_VrfKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_VrfKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_VrfKbn.class, patternId, value);
    }
}
