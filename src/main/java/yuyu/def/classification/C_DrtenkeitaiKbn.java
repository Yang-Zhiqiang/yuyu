
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店形態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtenkeitaiKbn</td><td colspan="3">代理店形態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJIN}</td><td>&quot;01&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJIN}</td><td>&quot;02&quot;</td><td>個人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIKIN}</td><td>&quot;03&quot;</td><td>内勤職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOU}</td><td>&quot;04&quot;</td><td>営業職員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSYUU}</td><td>&quot;05&quot;</td><td>研修生</td></tr>
 * </table>
 */
public class C_DrtenkeitaiKbn extends Classification<C_DrtenkeitaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtenkeitaiKbn BLNK = new C_DrtenkeitaiKbn("00");

    public static final C_DrtenkeitaiKbn HOUJIN = new C_DrtenkeitaiKbn("01");

    public static final C_DrtenkeitaiKbn KOJIN = new C_DrtenkeitaiKbn("02");

    public static final C_DrtenkeitaiKbn NAIKIN = new C_DrtenkeitaiKbn("03");

    public static final C_DrtenkeitaiKbn EIGYOU = new C_DrtenkeitaiKbn("04");

    public static final C_DrtenkeitaiKbn KENSYUU = new C_DrtenkeitaiKbn("05");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOUJIN, "HOUJIN", false);
        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", false);
        addPattern(PATTERN_DEFAULT, NAIKIN, "NAIKIN", false);
        addPattern(PATTERN_DEFAULT, EIGYOU, "EIGYOU", false);
        addPattern(PATTERN_DEFAULT, KENSYUU, "KENSYUU", false);


        lock(C_DrtenkeitaiKbn.class);
    }

    private C_DrtenkeitaiKbn(String value) {
        super(value);
    }

    public static C_DrtenkeitaiKbn valueOf(String value) {
        return valueOf(C_DrtenkeitaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtenkeitaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtenkeitaiKbn.class, patternId, value);
    }
}
