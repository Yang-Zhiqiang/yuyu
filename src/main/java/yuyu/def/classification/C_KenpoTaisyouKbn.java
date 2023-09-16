
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 健保対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KenpoTaisyouKbn</td><td colspan="3">健保対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNPTGT}</td><td>&quot;1&quot;</td><td>健保対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNPTSG}</td><td>&quot;2&quot;</td><td>健保対象外</td></tr>
 * </table>
 */
public class C_KenpoTaisyouKbn extends Classification<C_KenpoTaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KenpoTaisyouKbn BLNK = new C_KenpoTaisyouKbn("0");

    public static final C_KenpoTaisyouKbn KNPTGT = new C_KenpoTaisyouKbn("1");

    public static final C_KenpoTaisyouKbn KNPTSG = new C_KenpoTaisyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KNPTGT, "KNPTGT", false);
        addPattern(PATTERN_DEFAULT, KNPTSG, "KNPTSG", false);


        lock(C_KenpoTaisyouKbn.class);
    }

    private C_KenpoTaisyouKbn(String value) {
        super(value);
    }

    public static C_KenpoTaisyouKbn valueOf(String value) {
        return valueOf(C_KenpoTaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KenpoTaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KenpoTaisyouKbn.class, patternId, value);
    }
}
