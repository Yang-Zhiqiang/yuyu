
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * システム間連携用処理方式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SystemRenkeiSyoriHousikiKbn</td><td colspan="3">システム間連携用処理方式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KYOUYUU_DISC}</td><td>&quot;1&quot;</td><td>共有ディスク方式</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_RENKEI}</td><td>&quot;2&quot;</td><td>ファイル連携方式</td></tr>
 * </table>
 */
public class C_SystemRenkeiSyoriHousikiKbn extends Classification<C_SystemRenkeiSyoriHousikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SystemRenkeiSyoriHousikiKbn KYOUYUU_DISC = new C_SystemRenkeiSyoriHousikiKbn("1");

    public static final C_SystemRenkeiSyoriHousikiKbn FILE_RENKEI = new C_SystemRenkeiSyoriHousikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KYOUYUU_DISC, "KYOUYUU_DISC", true);
        addPattern(PATTERN_DEFAULT, FILE_RENKEI, "FILE_RENKEI", false);


        lock(C_SystemRenkeiSyoriHousikiKbn.class);
    }

    private C_SystemRenkeiSyoriHousikiKbn(String value) {
        super(value);
    }

    public static C_SystemRenkeiSyoriHousikiKbn valueOf(String value) {
        return valueOf(C_SystemRenkeiSyoriHousikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SystemRenkeiSyoriHousikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SystemRenkeiSyoriHousikiKbn.class, patternId, value);
    }
}
