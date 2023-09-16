
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者死亡有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyksyaSibouUmuKbn</td><td colspan="3">契約者死亡有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSBARI}</td><td>&quot;1&quot;</td><td>契約者死亡あり</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #KYKSBARI}</td><td>&quot;1&quot;</td><td>契約者死亡あり</td></tr>
 * </table>
 */
public class C_KyksyaSibouUmuKbn extends Classification<C_KyksyaSibouUmuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyksyaSibouUmuKbn BLNK = new C_KyksyaSibouUmuKbn("0");

    public static final C_KyksyaSibouUmuKbn KYKSBARI = new C_KyksyaSibouUmuKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKSBARI, "KYKSBARI", false);


        addPattern(PATTERN_NOBLNK, KYKSBARI, "KYKSBARI", true);


        lock(C_KyksyaSibouUmuKbn.class);
    }

    private C_KyksyaSibouUmuKbn(String value) {
        super(value);
    }

    public static C_KyksyaSibouUmuKbn valueOf(String value) {
        return valueOf(C_KyksyaSibouUmuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyksyaSibouUmuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyksyaSibouUmuKbn.class, patternId, value);
    }
}
