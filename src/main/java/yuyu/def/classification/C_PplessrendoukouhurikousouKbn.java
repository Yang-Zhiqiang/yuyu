
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ペーパーレス連動時口振申込書後送区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PplessrendoukouhurikousouKbn</td><td colspan="3">ペーパーレス連動時口振申込書後送区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;0&quot;</td><td>口振扱以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>口振・後送書類あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>口振・後送書類なし</td></tr>
 * </table>
 */
public class C_PplessrendoukouhurikousouKbn extends Classification<C_PplessrendoukouhurikousouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PplessrendoukouhurikousouKbn OTHER = new C_PplessrendoukouhurikousouKbn("0");

    public static final C_PplessrendoukouhurikousouKbn ARI = new C_PplessrendoukouhurikousouKbn("1");

    public static final C_PplessrendoukouhurikousouKbn NONE = new C_PplessrendoukouhurikousouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_PplessrendoukouhurikousouKbn.class);
    }

    private C_PplessrendoukouhurikousouKbn(String value) {
        super(value);
    }

    public static C_PplessrendoukouhurikousouKbn valueOf(String value) {
        return valueOf(C_PplessrendoukouhurikousouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PplessrendoukouhurikousouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PplessrendoukouhurikousouKbn.class, patternId, value);
    }
}
