
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特別勘定ユニットファンド区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkbtKanjyouUnitFundKbn</td><td colspan="3">特別勘定ユニットファンド区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_TkbtKanjyouUnitFundKbn extends Classification<C_TkbtKanjyouUnitFundKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkbtKanjyouUnitFundKbn BLNK = new C_TkbtKanjyouUnitFundKbn("0");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_TkbtKanjyouUnitFundKbn.class);
    }

    private C_TkbtKanjyouUnitFundKbn(String value) {
        super(value);
    }

    public static C_TkbtKanjyouUnitFundKbn valueOf(String value) {
        return valueOf(C_TkbtKanjyouUnitFundKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkbtKanjyouUnitFundKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkbtKanjyouUnitFundKbn.class, patternId, value);
    }
}
