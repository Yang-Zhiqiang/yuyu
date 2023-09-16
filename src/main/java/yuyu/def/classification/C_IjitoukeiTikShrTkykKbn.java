
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医事統計用定期支払特約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IjitoukeiTikShrTkykKbn</td><td colspan="3">医事統計用定期支払特約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUARISUEOKI5}</td><td>&quot;1&quot;</td><td>特約有（５年据置、支払回数４回）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUARISUEOKI10}</td><td>&quot;2&quot;</td><td>特約有（１０年据置、支払回数９回）</td></tr>
 * </table>
 */
public class C_IjitoukeiTikShrTkykKbn extends Classification<C_IjitoukeiTikShrTkykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IjitoukeiTikShrTkykKbn BLNK = new C_IjitoukeiTikShrTkykKbn("0");

    public static final C_IjitoukeiTikShrTkykKbn TOKUYAKUARISUEOKI5 = new C_IjitoukeiTikShrTkykKbn("1");

    public static final C_IjitoukeiTikShrTkykKbn TOKUYAKUARISUEOKI10 = new C_IjitoukeiTikShrTkykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOKUYAKUARISUEOKI5, "TOKUYAKUARISUEOKI5", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKUARISUEOKI10, "TOKUYAKUARISUEOKI10", false);


        lock(C_IjitoukeiTikShrTkykKbn.class);
    }

    private C_IjitoukeiTikShrTkykKbn(String value) {
        super(value);
    }

    public static C_IjitoukeiTikShrTkykKbn valueOf(String value) {
        return valueOf(C_IjitoukeiTikShrTkykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IjitoukeiTikShrTkykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IjitoukeiTikShrTkykKbn.class, patternId, value);
    }
}
