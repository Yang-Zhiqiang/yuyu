
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 提出書類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsytsyoruiKbn</td><td colspan="3">提出書類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUU}</td><td>&quot;1&quot;</td><td>年金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKYOU}</td><td>&quot;2&quot;</td><td>現況届出書</td></tr>
 * </table>
 */
public class C_TsytsyoruiKbn extends Classification<C_TsytsyoruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsytsyoruiKbn BLNK = new C_TsytsyoruiKbn("0");

    public static final C_TsytsyoruiKbn SEIKYUU = new C_TsytsyoruiKbn("1");

    public static final C_TsytsyoruiKbn GENKYOU = new C_TsytsyoruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIKYUU, "SEIKYUU", false);
        addPattern(PATTERN_DEFAULT, GENKYOU, "GENKYOU", false);


        lock(C_TsytsyoruiKbn.class);
    }

    private C_TsytsyoruiKbn(String value) {
        super(value);
    }

    public static C_TsytsyoruiKbn valueOf(String value) {
        return valueOf(C_TsytsyoruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsytsyoruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsytsyoruiKbn.class, patternId, value);
    }
}
