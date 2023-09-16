
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ターゲット特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TargetTkHenkouKbn</td><td colspan="3">ターゲット特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUHYOCHIHENKOU}</td><td>&quot;1&quot;</td><td>目標値変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_TargetTkHenkouKbn extends Classification<C_TargetTkHenkouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TargetTkHenkouKbn BLNK = new C_TargetTkHenkouKbn("0");

    public static final C_TargetTkHenkouKbn MOKUHYOCHIHENKOU = new C_TargetTkHenkouKbn("1");

    public static final C_TargetTkHenkouKbn KAIYAKU = new C_TargetTkHenkouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOKUHYOCHIHENKOU, "MOKUHYOCHIHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_TargetTkHenkouKbn.class);
    }

    private C_TargetTkHenkouKbn(String value) {
        super(value);
    }

    public static C_TargetTkHenkouKbn valueOf(String value) {
        return valueOf(C_TargetTkHenkouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TargetTkHenkouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TargetTkHenkouKbn.class, patternId, value);
    }
}
