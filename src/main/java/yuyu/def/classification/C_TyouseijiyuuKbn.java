
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 調整事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyouseijiyuuKbn</td><td colspan="3">調整事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUTEISEI}</td><td>&quot;01&quot;</td><td>事務訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REINYUUTYOUSEI}</td><td>&quot;02&quot;</td><td>戻入調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_TyouseijiyuuKbn extends Classification<C_TyouseijiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyouseijiyuuKbn BLNK = new C_TyouseijiyuuKbn("00");

    public static final C_TyouseijiyuuKbn JIMUTEISEI = new C_TyouseijiyuuKbn("01");

    public static final C_TyouseijiyuuKbn REINYUUTYOUSEI = new C_TyouseijiyuuKbn("02");

    public static final C_TyouseijiyuuKbn SONOTA = new C_TyouseijiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIMUTEISEI, "JIMUTEISEI", false);
        addPattern(PATTERN_DEFAULT, REINYUUTYOUSEI, "REINYUUTYOUSEI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_TyouseijiyuuKbn.class);
    }

    private C_TyouseijiyuuKbn(String value) {
        super(value);
    }

    public static C_TyouseijiyuuKbn valueOf(String value) {
        return valueOf(C_TyouseijiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyouseijiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyouseijiyuuKbn.class, patternId, value);
    }
}
