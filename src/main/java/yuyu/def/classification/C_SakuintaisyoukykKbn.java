
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 索引対象契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuintaisyoukykKbn</td><td colspan="3">索引対象契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU_KYK}</td><td>&quot;1&quot;</td><td>対象者が契約者の契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU_HHKN}</td><td>&quot;2&quot;</td><td>対象者が被保険者の契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU_KYK_HHKN}</td><td>&quot;3&quot;</td><td>対象者が契約者または被保険者の契約</td></tr>
 * </table>
 */
public class C_SakuintaisyoukykKbn extends Classification<C_SakuintaisyoukykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuintaisyoukykKbn BLNK = new C_SakuintaisyoukykKbn("0");

    public static final C_SakuintaisyoukykKbn TAISYOU_KYK = new C_SakuintaisyoukykKbn("1");

    public static final C_SakuintaisyoukykKbn TAISYOU_HHKN = new C_SakuintaisyoukykKbn("2");

    public static final C_SakuintaisyoukykKbn TAISYOU_KYK_HHKN = new C_SakuintaisyoukykKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TAISYOU_KYK, "TAISYOU_KYK", false);
        addPattern(PATTERN_DEFAULT, TAISYOU_HHKN, "TAISYOU_HHKN", false);
        addPattern(PATTERN_DEFAULT, TAISYOU_KYK_HHKN, "TAISYOU_KYK_HHKN", false);


        lock(C_SakuintaisyoukykKbn.class);
    }

    private C_SakuintaisyoukykKbn(String value) {
        super(value);
    }

    public static C_SakuintaisyoukykKbn valueOf(String value) {
        return valueOf(C_SakuintaisyoukykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuintaisyoukykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuintaisyoukykKbn.class, patternId, value);
    }
}
