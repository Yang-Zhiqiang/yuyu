
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 機能ＩＤ機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KinouIdKinouModeIdKbn</td><td colspan="3">機能ＩＤ機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KINOUID}</td><td>&quot;0&quot;</td><td>機能ＩＤ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINOUMODEID}</td><td>&quot;1&quot;</td><td>機能モードＩＤ</td></tr>
 * </table>
 */
public class C_KinouIdKinouModeIdKbn extends Classification<C_KinouIdKinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KinouIdKinouModeIdKbn KINOUID = new C_KinouIdKinouModeIdKbn("0");

    public static final C_KinouIdKinouModeIdKbn KINOUMODEID = new C_KinouIdKinouModeIdKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KINOUID, "KINOUID", true);
        addPattern(PATTERN_DEFAULT, KINOUMODEID, "KINOUMODEID", false);


        lock(C_KinouIdKinouModeIdKbn.class);
    }

    private C_KinouIdKinouModeIdKbn(String value) {
        super(value);
    }

    public static C_KinouIdKinouModeIdKbn valueOf(String value) {
        return valueOf(C_KinouIdKinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KinouIdKinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KinouIdKinouModeIdKbn.class, patternId, value);
    }
}
