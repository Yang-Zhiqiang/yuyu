
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 該当者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GaitousyaKbn</td><td colspan="3">該当者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTR}</td><td>&quot;1&quot;</td><td>受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #UKTR}</td><td>&quot;1&quot;</td><td>受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 * </table>
 */
public class C_GaitousyaKbn extends Classification<C_GaitousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GaitousyaKbn BLNK = new C_GaitousyaKbn("0");

    public static final C_GaitousyaKbn UKTR = new C_GaitousyaKbn("1");

    public static final C_GaitousyaKbn HHKN = new C_GaitousyaKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UKTR, "UKTR", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);


        addPattern(PATTERN_SELECT, UKTR, "UKTR", true);
        addPattern(PATTERN_SELECT, HHKN, "HHKN", false);


        lock(C_GaitousyaKbn.class);
    }

    private C_GaitousyaKbn(String value) {
        super(value);
    }

    public static C_GaitousyaKbn valueOf(String value) {
        return valueOf(C_GaitousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GaitousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GaitousyaKbn.class, patternId, value);
    }
}
