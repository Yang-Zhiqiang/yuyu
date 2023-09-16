
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納統計リスト区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennouToukeiListKbn</td><td colspan="3">前納統計リスト区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;0&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_MKKP}</td><td>&quot;1&quot;</td><td>前納未経過Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKA_ZENNOUBUN_MKKP}</td><td>&quot;2&quot;</td><td>追加前納分未経過Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANRYOUBUN_MKKP}</td><td>&quot;3&quot;</td><td>満了分未経過Ｐ</td></tr>
 * </table>
 */
public class C_ZennouToukeiListKbn extends Classification<C_ZennouToukeiListKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennouToukeiListKbn OTHER = new C_ZennouToukeiListKbn("0");

    public static final C_ZennouToukeiListKbn ZENNOU_MKKP = new C_ZennouToukeiListKbn("1");

    public static final C_ZennouToukeiListKbn TUIKA_ZENNOUBUN_MKKP = new C_ZennouToukeiListKbn("2");

    public static final C_ZennouToukeiListKbn MANRYOUBUN_MKKP = new C_ZennouToukeiListKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", true);
        addPattern(PATTERN_DEFAULT, ZENNOU_MKKP, "ZENNOU_MKKP", false);
        addPattern(PATTERN_DEFAULT, TUIKA_ZENNOUBUN_MKKP, "TUIKA_ZENNOUBUN_MKKP", false);
        addPattern(PATTERN_DEFAULT, MANRYOUBUN_MKKP, "MANRYOUBUN_MKKP", false);


        lock(C_ZennouToukeiListKbn.class);
    }

    private C_ZennouToukeiListKbn(String value) {
        super(value);
    }

    public static C_ZennouToukeiListKbn valueOf(String value) {
        return valueOf(C_ZennouToukeiListKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennouToukeiListKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennouToukeiListKbn.class, patternId, value);
    }
}
