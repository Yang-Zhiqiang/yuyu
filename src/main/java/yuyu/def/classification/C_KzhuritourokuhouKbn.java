
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 口座振替登録方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzhuritourokuhouKbn</td><td colspan="3">口座振替登録方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMEN}</td><td>&quot;1&quot;</td><td>生命保険料支払申込書による登録（書面）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QR}</td><td>&quot;2&quot;</td><td>ＱＲコード方式での登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PPLESS}</td><td>&quot;3&quot;</td><td>代理店電子申込画面入力による登録</td></tr>
 * </table>
 */
public class C_KzhuritourokuhouKbn extends Classification<C_KzhuritourokuhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzhuritourokuhouKbn BLNK = new C_KzhuritourokuhouKbn("0");

    public static final C_KzhuritourokuhouKbn SYOMEN = new C_KzhuritourokuhouKbn("1");

    public static final C_KzhuritourokuhouKbn QR = new C_KzhuritourokuhouKbn("2");

    public static final C_KzhuritourokuhouKbn PPLESS = new C_KzhuritourokuhouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOMEN, "SYOMEN", false);
        addPattern(PATTERN_DEFAULT, QR, "QR", false);
        addPattern(PATTERN_DEFAULT, PPLESS, "PPLESS", false);


        lock(C_KzhuritourokuhouKbn.class);
    }

    private C_KzhuritourokuhouKbn(String value) {
        super(value);
    }

    public static C_KzhuritourokuhouKbn valueOf(String value) {
        return valueOf(C_KzhuritourokuhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzhuritourokuhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzhuritourokuhouKbn.class, patternId, value);
    }
}
