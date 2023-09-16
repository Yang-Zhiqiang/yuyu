
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店識別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtensikibetuKbn</td><td colspan="3">代理店識別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;01&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;02&quot;</td><td>SMBC</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIIGIN}</td><td>&quot;03&quot;</td><td>地銀</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIN}</td><td>&quot;04&quot;</td><td>信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINDAI}</td><td>&quot;05&quot;</td><td>銀行系代理店</td></tr>
 * </table>
 */
public class C_DrtensikibetuKbn extends Classification<C_DrtensikibetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtensikibetuKbn BLNK = new C_DrtensikibetuKbn("00");

    public static final C_DrtensikibetuKbn SHOP = new C_DrtensikibetuKbn("01");

    public static final C_DrtensikibetuKbn SMBC = new C_DrtensikibetuKbn("02");

    public static final C_DrtensikibetuKbn TIIGIN = new C_DrtensikibetuKbn("03");

    public static final C_DrtensikibetuKbn SINKIN = new C_DrtensikibetuKbn("04");

    public static final C_DrtensikibetuKbn GINDAI = new C_DrtensikibetuKbn("05");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, TIIGIN, "TIIGIN", false);
        addPattern(PATTERN_DEFAULT, SINKIN, "SINKIN", false);
        addPattern(PATTERN_DEFAULT, GINDAI, "GINDAI", false);


        lock(C_DrtensikibetuKbn.class);
    }

    private C_DrtensikibetuKbn(String value) {
        super(value);
    }

    public static C_DrtensikibetuKbn valueOf(String value) {
        return valueOf(C_DrtensikibetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtensikibetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtensikibetuKbn.class, patternId, value);
    }
}
