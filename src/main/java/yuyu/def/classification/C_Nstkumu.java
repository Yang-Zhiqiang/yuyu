
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払特約有無 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nstkumu</td><td colspan="3">年金支払特約有無</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ST_ARI}</td><td>&quot;1&quot;</td><td>指定あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ST_NASI}</td><td>&quot;2&quot;</td><td>指定なし</td></tr>
 * </table>
 */
public class C_Nstkumu extends Classification<C_Nstkumu> {

    private static final long serialVersionUID = 1L;


    public static final C_Nstkumu BLNK = new C_Nstkumu("0");

    public static final C_Nstkumu ST_ARI = new C_Nstkumu("1");

    public static final C_Nstkumu ST_NASI = new C_Nstkumu("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ST_ARI, "ST_ARI", false);
        addPattern(PATTERN_DEFAULT, ST_NASI, "ST_NASI", false);


        lock(C_Nstkumu.class);
    }

    private C_Nstkumu(String value) {
        super(value);
    }

    public static C_Nstkumu valueOf(String value) {
        return valueOf(C_Nstkumu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nstkumu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nstkumu.class, patternId, value);
    }
}
