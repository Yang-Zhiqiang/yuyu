
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解消対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KaisyoutaisyouKbn</td><td colspan="3">解消対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOUGAI}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU}</td><td>&quot;1&quot;</td><td>●</td></tr>
 * </table>
 */
public class C_KaisyoutaisyouKbn extends Classification<C_KaisyoutaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KaisyoutaisyouKbn TAISYOUGAI = new C_KaisyoutaisyouKbn("0");

    public static final C_KaisyoutaisyouKbn TAISYOU = new C_KaisyoutaisyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", true);
        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", false);


        lock(C_KaisyoutaisyouKbn.class);
    }

    private C_KaisyoutaisyouKbn(String value) {
        super(value);
    }

    public static C_KaisyoutaisyouKbn valueOf(String value) {
        return valueOf(C_KaisyoutaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KaisyoutaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KaisyoutaisyouKbn.class, patternId, value);
    }
}
