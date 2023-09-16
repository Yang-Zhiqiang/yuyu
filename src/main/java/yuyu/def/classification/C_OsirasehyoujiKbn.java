
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * お知らせ表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OsirasehyoujiKbn</td><td colspan="3">お知らせ表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #HIHYOUJI}</td><td>&quot;0&quot;</td><td>非表示</td></tr>
 *  <tr><td align="center">○</td><td>{@link #HYOUJI}</td><td>&quot;1&quot;</td><td>表示</td></tr>
 * </table>
 */
public class C_OsirasehyoujiKbn extends Classification<C_OsirasehyoujiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OsirasehyoujiKbn HIHYOUJI = new C_OsirasehyoujiKbn("0");

    public static final C_OsirasehyoujiKbn HYOUJI = new C_OsirasehyoujiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HIHYOUJI, "HIHYOUJI", false);
        addPattern(PATTERN_DEFAULT, HYOUJI, "HYOUJI", true);


        lock(C_OsirasehyoujiKbn.class);
    }

    private C_OsirasehyoujiKbn(String value) {
        super(value);
    }

    public static C_OsirasehyoujiKbn valueOf(String value) {
        return valueOf(C_OsirasehyoujiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OsirasehyoujiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OsirasehyoujiKbn.class, patternId, value);
    }
}
