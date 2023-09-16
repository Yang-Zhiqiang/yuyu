
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 利用者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RiyousyaKbn</td><td colspan="3">利用者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYPAGEUSER}</td><td>&quot;1&quot;</td><td>マイページユーザ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYANAIUSER}</td><td>&quot;2&quot;</td><td>社内ユーザ</td></tr>
 * </table>
 */
public class C_RiyousyaKbn extends Classification<C_RiyousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RiyousyaKbn BLNK = new C_RiyousyaKbn("0");

    public static final C_RiyousyaKbn MYPAGEUSER = new C_RiyousyaKbn("1");

    public static final C_RiyousyaKbn SYANAIUSER = new C_RiyousyaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MYPAGEUSER, "MYPAGEUSER", false);
        addPattern(PATTERN_DEFAULT, SYANAIUSER, "SYANAIUSER", false);


        lock(C_RiyousyaKbn.class);
    }

    private C_RiyousyaKbn(String value) {
        super(value);
    }

    public static C_RiyousyaKbn valueOf(String value) {
        return valueOf(C_RiyousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RiyousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RiyousyaKbn.class, patternId, value);
    }
}
