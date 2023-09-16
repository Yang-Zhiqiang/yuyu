
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 大区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DaiKbn</td><td colspan="3">大区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;11&quot;</td><td>終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN}</td><td>&quot;16&quot;</td><td>指定通貨建終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN_SISUU}</td><td>&quot;56&quot;</td><td>指定通貨建個人年金（定額）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NNKNTKYK_SISUURENDOU}</td><td>&quot;57&quot;</td><td>年金特約（指数連動型）</td></tr>
 * </table>
 */
public class C_DaiKbn extends Classification<C_DaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DaiKbn BLNK = new C_DaiKbn("0");

    public static final C_DaiKbn SYSN = new C_DaiKbn("11");

    public static final C_DaiKbn SITEITUKASYSN = new C_DaiKbn("16");

    public static final C_DaiKbn KOJINNENKIN_SISUU = new C_DaiKbn("56");

    public static final C_DaiKbn NNKNTKYK_SISUURENDOU = new C_DaiKbn("57");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYSN, "SYSN", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN, "SITEITUKASYSN", false);
        addPattern(PATTERN_DEFAULT, KOJINNENKIN_SISUU, "KOJINNENKIN_SISUU", false);
        addPattern(PATTERN_DEFAULT, NNKNTKYK_SISUURENDOU, "NNKNTKYK_SISUURENDOU", false);


        lock(C_DaiKbn.class);
    }

    private C_DaiKbn(String value) {
        super(value);
    }

    public static C_DaiKbn valueOf(String value) {
        return valueOf(C_DaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DaiKbn.class, patternId, value);
    }
}
