
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ユニットファンド区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UnitFundKbn</td><td colspan="3">ユニットファンド区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDFUND}</td><td>&quot;100&quot;</td><td>米ドルファンド</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EURFUND}</td><td>&quot;200&quot;</td><td>ユーロファンド</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDFUND}</td><td>&quot;300&quot;</td><td>豪ドルファンド</td></tr>
 * </table>
 */
public class C_UnitFundKbn extends Classification<C_UnitFundKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UnitFundKbn BLNK = new C_UnitFundKbn("0");

    public static final C_UnitFundKbn USDFUND = new C_UnitFundKbn("100");

    public static final C_UnitFundKbn EURFUND = new C_UnitFundKbn("200");

    public static final C_UnitFundKbn AUDFUND = new C_UnitFundKbn("300");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, USDFUND, "USDFUND", false);
        addPattern(PATTERN_DEFAULT, EURFUND, "EURFUND", false);
        addPattern(PATTERN_DEFAULT, AUDFUND, "AUDFUND", false);


        lock(C_UnitFundKbn.class);
    }

    private C_UnitFundKbn(String value) {
        super(value);
    }

    public static C_UnitFundKbn valueOf(String value) {
        return valueOf(C_UnitFundKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UnitFundKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UnitFundKbn.class, patternId, value);
    }
}
