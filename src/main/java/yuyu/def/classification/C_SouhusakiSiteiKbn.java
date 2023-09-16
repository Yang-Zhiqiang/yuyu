
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送付先指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SouhusakiSiteiKbn</td><td colspan="3">送付先指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUSINSAKISIYOU}</td><td>&quot;1&quot;</td><td>通信先使用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>指定</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(画面用（ブランクなし）)</td><td align="center">&nbsp;</td><td>{@link #TUUSINSAKISIYOU}</td><td>&quot;1&quot;</td><td>通信先使用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>指定</td></tr>
 * </table>
 */
public class C_SouhusakiSiteiKbn extends Classification<C_SouhusakiSiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SouhusakiSiteiKbn BLNK = new C_SouhusakiSiteiKbn("0");

    public static final C_SouhusakiSiteiKbn TUUSINSAKISIYOU = new C_SouhusakiSiteiKbn("1");

    public static final C_SouhusakiSiteiKbn SITEI = new C_SouhusakiSiteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUSINSAKISIYOU, "TUUSINSAKISIYOU", false);
        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);


        addPattern(PATTERN_NOBLNK, TUUSINSAKISIYOU, "TUUSINSAKISIYOU", false);
        addPattern(PATTERN_NOBLNK, SITEI, "SITEI", false);


        lock(C_SouhusakiSiteiKbn.class);
    }

    private C_SouhusakiSiteiKbn(String value) {
        super(value);
    }

    public static C_SouhusakiSiteiKbn valueOf(String value) {
        return valueOf(C_SouhusakiSiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SouhusakiSiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SouhusakiSiteiKbn.class, patternId, value);
    }
}
