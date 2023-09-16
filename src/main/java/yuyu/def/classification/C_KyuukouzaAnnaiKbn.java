
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 旧口座案内区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyuukouzaAnnaiKbn</td><td colspan="3">旧口座案内区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>旧口座案内なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUKOUZAANNAI}</td><td>&quot;1&quot;</td><td>旧口座案内</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUKOUZAANNAI}</td><td>&quot;1&quot;</td><td>旧口座案内</td></tr>
 * </table>
 */
public class C_KyuukouzaAnnaiKbn extends Classification<C_KyuukouzaAnnaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyuukouzaAnnaiKbn BLNK = new C_KyuukouzaAnnaiKbn("0");

    public static final C_KyuukouzaAnnaiKbn KYUUKOUZAANNAI = new C_KyuukouzaAnnaiKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYUUKOUZAANNAI, "KYUUKOUZAANNAI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, KYUUKOUZAANNAI, "KYUUKOUZAANNAI", false);


        lock(C_KyuukouzaAnnaiKbn.class);
    }

    private C_KyuukouzaAnnaiKbn(String value) {
        super(value);
    }

    public static C_KyuukouzaAnnaiKbn valueOf(String value) {
        return valueOf(C_KyuukouzaAnnaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyuukouzaAnnaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyuukouzaAnnaiKbn.class, patternId, value);
    }
}
