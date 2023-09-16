
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 証券・証書区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukenSyousyoKbn</td><td colspan="3">証券・証書区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI}</td><td>&quot;N&quot;</td><td>新規発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI_YOUCHK}</td><td>&quot;C&quot;</td><td>新規発行（要内容チェック）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHK}</td><td>&quot;R&quot;</td><td>再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHKMDS}</td><td>&quot;S&quot;</td><td>再発行戻し</td></tr>
 * </table>
 */
public class C_SyoukenSyousyoKbn extends Classification<C_SyoukenSyousyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukenSyousyoKbn BLNK = new C_SyoukenSyousyoKbn("0");

    public static final C_SyoukenSyousyoKbn SINKI = new C_SyoukenSyousyoKbn("N");

    public static final C_SyoukenSyousyoKbn SINKI_YOUCHK = new C_SyoukenSyousyoKbn("C");

    public static final C_SyoukenSyousyoKbn SAIHK = new C_SyoukenSyousyoKbn("R");

    public static final C_SyoukenSyousyoKbn SAIHKMDS = new C_SyoukenSyousyoKbn("S");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKI, "SINKI", false);
        addPattern(PATTERN_DEFAULT, SINKI_YOUCHK, "SINKI_YOUCHK", false);
        addPattern(PATTERN_DEFAULT, SAIHK, "SAIHK", false);
        addPattern(PATTERN_DEFAULT, SAIHKMDS, "SAIHKMDS", false);


        lock(C_SyoukenSyousyoKbn.class);
    }

    private C_SyoukenSyousyoKbn(String value) {
        super(value);
    }

    public static C_SyoukenSyousyoKbn valueOf(String value) {
        return valueOf(C_SyoukenSyousyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukenSyousyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukenSyousyoKbn.class, patternId, value);
    }
}
