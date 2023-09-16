
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者登録区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyktrkKbn</td><td colspan="3">契約者登録区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI_KJN}</td><td>&quot;1&quot;</td><td>新規（個人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI_HJN}</td><td>&quot;2&quot;</td><td>新規（法人）</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_MI MI}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SINKI_KJN}</td><td>&quot;1&quot;</td><td>新規（個人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI_HJN}</td><td>&quot;2&quot;</td><td>新規（法人）</td></tr>
 * </table>
 */
public class C_KyktrkKbn extends Classification<C_KyktrkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyktrkKbn BLNK = new C_KyktrkKbn("0");

    public static final C_KyktrkKbn SINKI_KJN = new C_KyktrkKbn("1");

    public static final C_KyktrkKbn SINKI_HJN = new C_KyktrkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKI_KJN, "SINKI_KJN", false);
        addPattern(PATTERN_DEFAULT, SINKI_HJN, "SINKI_HJN", false);


        addPattern(PATTERN_MI, SINKI_KJN, "SINKI_KJN", true);
        addPattern(PATTERN_MI, SINKI_HJN, "SINKI_HJN", false);


        lock(C_KyktrkKbn.class);
    }

    private C_KyktrkKbn(String value) {
        super(value);
    }

    public static C_KyktrkKbn valueOf(String value) {
        return valueOf(C_KyktrkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyktrkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyktrkKbn.class, patternId, value);
    }
}
