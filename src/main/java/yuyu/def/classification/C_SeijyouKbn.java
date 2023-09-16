
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 正常区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeijyouKbn</td><td colspan="3">正常区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IJYOU}</td><td>&quot;1&quot;</td><td>異常</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IJYOU}</td><td>&quot;1&quot;</td><td>NG</td></tr>
 * </table>
 */
public class C_SeijyouKbn extends Classification<C_SeijyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeijyouKbn SEIJYOU = new C_SeijyouKbn("0");

    public static final C_SeijyouKbn IJYOU = new C_SeijyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REPORT = "2";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, IJYOU, "IJYOU", false);


        addPattern(PATTERN_REPORT, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_REPORT, IJYOU, "IJYOU", false);


        lock(C_SeijyouKbn.class);
    }

    private C_SeijyouKbn(String value) {
        super(value);
    }

    public static C_SeijyouKbn valueOf(String value) {
        return valueOf(C_SeijyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeijyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeijyouKbn.class, patternId, value);
    }
}
