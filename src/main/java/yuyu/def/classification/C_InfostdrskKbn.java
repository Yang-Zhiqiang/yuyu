
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 情報系指定代理請求人区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_InfostdrskKbn</td><td colspan="3">情報系指定代理請求人区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ST_NASI}</td><td>&quot;0&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBONAZI}</td><td>&quot;1&quot;</td><td>死亡返還金受取人と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBBETUZIN}</td><td>&quot;2&quot;</td><td>死亡返還金受取人と別人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ST_ARI}</td><td>&quot;9&quot;</td><td>指定あり</td></tr>
 * </table>
 */
public class C_InfostdrskKbn extends Classification<C_InfostdrskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_InfostdrskKbn ST_NASI = new C_InfostdrskKbn("0");

    public static final C_InfostdrskKbn SBONAZI = new C_InfostdrskKbn("1");

    public static final C_InfostdrskKbn SBBETUZIN = new C_InfostdrskKbn("2");

    public static final C_InfostdrskKbn ST_ARI = new C_InfostdrskKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ST_NASI, "ST_NASI", true);
        addPattern(PATTERN_DEFAULT, SBONAZI, "SBONAZI", false);
        addPattern(PATTERN_DEFAULT, SBBETUZIN, "SBBETUZIN", false);
        addPattern(PATTERN_DEFAULT, ST_ARI, "ST_ARI", false);


        lock(C_InfostdrskKbn.class);
    }

    private C_InfostdrskKbn(String value) {
        super(value);
    }

    public static C_InfostdrskKbn valueOf(String value) {
        return valueOf(C_InfostdrskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_InfostdrskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_InfostdrskKbn.class, patternId, value);
    }
}
