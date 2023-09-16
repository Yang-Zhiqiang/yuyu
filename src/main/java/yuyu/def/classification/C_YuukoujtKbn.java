
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukoujtKbn</td><td colspan="3">有効状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MUKOU}</td><td>&quot;0&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 * </table>
 */
public class C_YuukoujtKbn extends Classification<C_YuukoujtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukoujtKbn MUKOU = new C_YuukoujtKbn("0");

    public static final C_YuukoujtKbn YUUKOU = new C_YuukoujtKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", true);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);


        lock(C_YuukoujtKbn.class);
    }

    private C_YuukoujtKbn(String value) {
        super(value);
    }

    public static C_YuukoujtKbn valueOf(String value) {
        return valueOf(C_YuukoujtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukoujtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukoujtKbn.class, patternId, value);
    }
}
