
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 生保Ｗｅｂ操作者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeihowebsousasyaKbn</td><td colspan="3">生保Ｗｅｂ操作者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUPPORTDESK}</td><td>&quot;1&quot;</td><td>サポートデスク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRTNBSYNN}</td><td>&quot;2&quot;</td><td>代理店募集人</td></tr>
 * </table>
 */
public class C_SeihowebsousasyaKbn extends Classification<C_SeihowebsousasyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeihowebsousasyaKbn BLNK = new C_SeihowebsousasyaKbn("0");

    public static final C_SeihowebsousasyaKbn SUPPORTDESK = new C_SeihowebsousasyaKbn("1");

    public static final C_SeihowebsousasyaKbn DIRTNBSYNN = new C_SeihowebsousasyaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, SUPPORTDESK, "SUPPORTDESK", false);
        addPattern(PATTERN_DEFAULT, DIRTNBSYNN, "DIRTNBSYNN", false);


        lock(C_SeihowebsousasyaKbn.class);
    }

    private C_SeihowebsousasyaKbn(String value) {
        super(value);
    }

    public static C_SeihowebsousasyaKbn valueOf(String value) {
        return valueOf(C_SeihowebsousasyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeihowebsousasyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeihowebsousasyaKbn.class, patternId, value);
    }
}
