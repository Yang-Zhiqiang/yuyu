
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送付案内区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShannaiKbn</td><td colspan="3">送付案内区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAISKSI}</td><td>&quot;1&quot;</td><td>案内作成</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_HK HK}<br />(保険金給付金支払用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>作成なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAISKSI}</td><td>&quot;1&quot;</td><td>案内作成</td></tr>
 * </table>
 */
public class C_ShannaiKbn extends Classification<C_ShannaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShannaiKbn BLNK = new C_ShannaiKbn("0");

    public static final C_ShannaiKbn ANNAISKSI = new C_ShannaiKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANNAISKSI, "ANNAISKSI", false);


        addPattern(PATTERN_HK, BLNK, "BLNK", true);
        addPattern(PATTERN_HK, ANNAISKSI, "ANNAISKSI", false);


        lock(C_ShannaiKbn.class);
    }

    private C_ShannaiKbn(String value) {
        super(value);
    }

    public static C_ShannaiKbn valueOf(String value) {
        return valueOf(C_ShannaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShannaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShannaiKbn.class, patternId, value);
    }
}
