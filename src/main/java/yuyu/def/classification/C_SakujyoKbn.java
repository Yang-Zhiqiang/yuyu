
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 削除区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakujyoKbn</td><td colspan="3">削除区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MUJYOUKEN}</td><td>&quot;1&quot;</td><td>無条件削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGENTUKI}</td><td>&quot;2&quot;</td><td>期限付削除</td></tr>
 * </table>
 */
public class C_SakujyoKbn extends Classification<C_SakujyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakujyoKbn MUJYOUKEN = new C_SakujyoKbn("1");

    public static final C_SakujyoKbn KIGENTUKI = new C_SakujyoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MUJYOUKEN, "MUJYOUKEN", true);
        addPattern(PATTERN_DEFAULT, KIGENTUKI, "KIGENTUKI", false);


        lock(C_SakujyoKbn.class);
    }

    private C_SakujyoKbn(String value) {
        super(value);
    }

    public static C_SakujyoKbn valueOf(String value) {
        return valueOf(C_SakujyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakujyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakujyoKbn.class, patternId, value);
    }
}
