
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通知作成対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TuutisakuseitaisyouKbn</td><td colspan="3">通知作成対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;1&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;2&quot;</td><td>登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK1}</td><td>&quot;3&quot;</td><td>旧登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK2}</td><td>&quot;4&quot;</td><td>旧登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNDRNIN}</td><td>&quot;5&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDHHKNDRNIN}</td><td>&quot;6&quot;</td><td>旧被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRN}</td><td>&quot;7&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDKYKDRN}</td><td>&quot;8&quot;</td><td>旧契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;9&quot;</td><td>被保険者</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_TYOKUSOU TYOKUSOU}<br />(直送通知作成対象者)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK1}</td><td>&quot;1&quot;</td><td>登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKZK2}</td><td>&quot;2&quot;</td><td>登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK1}</td><td>&quot;3&quot;</td><td>旧登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK2}</td><td>&quot;4&quot;</td><td>旧登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDHHKNDRNIN}</td><td>&quot;6&quot;</td><td>旧被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDKYKDRN}</td><td>&quot;8&quot;</td><td>旧契約者代理人</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DOUHUU DOUHUU}<br />(同封通知作成対象者)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK1}</td><td>&quot;3&quot;</td><td>旧登録家族（１人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDTRKKZK2}</td><td>&quot;4&quot;</td><td>旧登録家族（２人目）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDHHKNDRNIN}</td><td>&quot;6&quot;</td><td>旧被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDKYKDRN}</td><td>&quot;8&quot;</td><td>旧契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;9&quot;</td><td>被保険者</td></tr>
 * </table>
 */
public class C_TuutisakuseitaisyouKbn extends Classification<C_TuutisakuseitaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TuutisakuseitaisyouKbn BLNK = new C_TuutisakuseitaisyouKbn("0");

    public static final C_TuutisakuseitaisyouKbn TRKKZK1 = new C_TuutisakuseitaisyouKbn("1");

    public static final C_TuutisakuseitaisyouKbn TRKKZK2 = new C_TuutisakuseitaisyouKbn("2");

    public static final C_TuutisakuseitaisyouKbn OLDTRKKZK1 = new C_TuutisakuseitaisyouKbn("3");

    public static final C_TuutisakuseitaisyouKbn OLDTRKKZK2 = new C_TuutisakuseitaisyouKbn("4");

    public static final C_TuutisakuseitaisyouKbn HHKNDRNIN = new C_TuutisakuseitaisyouKbn("5");

    public static final C_TuutisakuseitaisyouKbn OLDHHKNDRNIN = new C_TuutisakuseitaisyouKbn("6");

    public static final C_TuutisakuseitaisyouKbn KYKDRN = new C_TuutisakuseitaisyouKbn("7");

    public static final C_TuutisakuseitaisyouKbn OLDKYKDRN = new C_TuutisakuseitaisyouKbn("8");

    public static final C_TuutisakuseitaisyouKbn HHKN = new C_TuutisakuseitaisyouKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TYOKUSOU = "2";

    public static final String PATTERN_DOUHUU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_DEFAULT, TRKKZK2, "TRKKZK2", false);
        addPattern(PATTERN_DEFAULT, OLDTRKKZK1, "OLDTRKKZK1", false);
        addPattern(PATTERN_DEFAULT, OLDTRKKZK2, "OLDTRKKZK2", false);
        addPattern(PATTERN_DEFAULT, HHKNDRNIN, "HHKNDRNIN", false);
        addPattern(PATTERN_DEFAULT, OLDHHKNDRNIN, "OLDHHKNDRNIN", false);
        addPattern(PATTERN_DEFAULT, KYKDRN, "KYKDRN", false);
        addPattern(PATTERN_DEFAULT, OLDKYKDRN, "OLDKYKDRN", false);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);


        addPattern(PATTERN_TYOKUSOU, BLNK, "BLNK", true);
        addPattern(PATTERN_TYOKUSOU, TRKKZK1, "TRKKZK1", false);
        addPattern(PATTERN_TYOKUSOU, TRKKZK2, "TRKKZK2", false);
        addPattern(PATTERN_TYOKUSOU, OLDTRKKZK1, "OLDTRKKZK1", false);
        addPattern(PATTERN_TYOKUSOU, OLDTRKKZK2, "OLDTRKKZK2", false);
        addPattern(PATTERN_TYOKUSOU, OLDHHKNDRNIN, "OLDHHKNDRNIN", false);
        addPattern(PATTERN_TYOKUSOU, OLDKYKDRN, "OLDKYKDRN", false);


        addPattern(PATTERN_DOUHUU, BLNK, "BLNK", true);
        addPattern(PATTERN_DOUHUU, OLDTRKKZK1, "OLDTRKKZK1", false);
        addPattern(PATTERN_DOUHUU, OLDTRKKZK2, "OLDTRKKZK2", false);
        addPattern(PATTERN_DOUHUU, OLDHHKNDRNIN, "OLDHHKNDRNIN", false);
        addPattern(PATTERN_DOUHUU, OLDKYKDRN, "OLDKYKDRN", false);
        addPattern(PATTERN_DOUHUU, HHKN, "HHKN", false);


        lock(C_TuutisakuseitaisyouKbn.class);
    }

    private C_TuutisakuseitaisyouKbn(String value) {
        super(value);
    }

    public static C_TuutisakuseitaisyouKbn valueOf(String value) {
        return valueOf(C_TuutisakuseitaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TuutisakuseitaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TuutisakuseitaisyouKbn.class, patternId, value);
    }
}
