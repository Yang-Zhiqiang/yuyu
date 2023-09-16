
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動口座区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidoukouzaKbn</td><td colspan="3">資金移動口座区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENHONKZ}</td><td>&quot;10&quot;</td><td>円本口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKSIKINUKEIREYENKZ}</td><td>&quot;11&quot;</td><td>外貨資金受入用円口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDHONKZ}</td><td>&quot;20&quot;</td><td>米ドル本口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDHONKZ}</td><td>&quot;30&quot;</td><td>豪ドル本口座</td></tr>
 * </table>
 */
public class C_SikinidoukouzaKbn extends Classification<C_SikinidoukouzaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidoukouzaKbn BLNK = new C_SikinidoukouzaKbn("00");

    public static final C_SikinidoukouzaKbn YENHONKZ = new C_SikinidoukouzaKbn("10");

    public static final C_SikinidoukouzaKbn GKSIKINUKEIREYENKZ = new C_SikinidoukouzaKbn("11");

    public static final C_SikinidoukouzaKbn USDHONKZ = new C_SikinidoukouzaKbn("20");

    public static final C_SikinidoukouzaKbn AUDHONKZ = new C_SikinidoukouzaKbn("30");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENHONKZ, "YENHONKZ", false);
        addPattern(PATTERN_DEFAULT, GKSIKINUKEIREYENKZ, "GKSIKINUKEIREYENKZ", false);
        addPattern(PATTERN_DEFAULT, USDHONKZ, "USDHONKZ", false);
        addPattern(PATTERN_DEFAULT, AUDHONKZ, "AUDHONKZ", false);


        lock(C_SikinidoukouzaKbn.class);
    }

    private C_SikinidoukouzaKbn(String value) {
        super(value);
    }

    public static C_SikinidoukouzaKbn valueOf(String value) {
        return valueOf(C_SikinidoukouzaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidoukouzaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidoukouzaKbn.class, patternId, value);
    }
}
