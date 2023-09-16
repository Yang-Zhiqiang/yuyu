
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払計算用処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrksnsyoriKbn</td><td colspan="3">支払計算用処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;1&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKISYOUKAI}</td><td>&quot;2&quot;</td><td>先日付照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR_HRKE}</td><td>&quot;3&quot;</td><td>支払・振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOSHR}</td><td>&quot;4&quot;</td><td>自動支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOSHR_TEISI}</td><td>&quot;5&quot;</td><td>自動支払（自動支払停止）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMI}</td><td>&quot;6&quot;</td><td>取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEIKYUUUKETUKE}</td><td>&quot;7&quot;</td><td>未請求受付</td></tr>
 * </table>
 */
public class C_ShrksnsyoriKbn extends Classification<C_ShrksnsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrksnsyoriKbn BLNK = new C_ShrksnsyoriKbn("0");

    public static final C_ShrksnsyoriKbn SYOUKAI = new C_ShrksnsyoriKbn("1");

    public static final C_ShrksnsyoriKbn SAKISYOUKAI = new C_ShrksnsyoriKbn("2");

    public static final C_ShrksnsyoriKbn SHR_HRKE = new C_ShrksnsyoriKbn("3");

    public static final C_ShrksnsyoriKbn JIDOSHR = new C_ShrksnsyoriKbn("4");

    public static final C_ShrksnsyoriKbn JIDOSHR_TEISI = new C_ShrksnsyoriKbn("5");

    public static final C_ShrksnsyoriKbn TORIKOMI = new C_ShrksnsyoriKbn("6");

    public static final C_ShrksnsyoriKbn MISEIKYUUUKETUKE = new C_ShrksnsyoriKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, SAKISYOUKAI, "SAKISYOUKAI", false);
        addPattern(PATTERN_DEFAULT, SHR_HRKE, "SHR_HRKE", false);
        addPattern(PATTERN_DEFAULT, JIDOSHR, "JIDOSHR", false);
        addPattern(PATTERN_DEFAULT, JIDOSHR_TEISI, "JIDOSHR_TEISI", false);
        addPattern(PATTERN_DEFAULT, TORIKOMI, "TORIKOMI", false);
        addPattern(PATTERN_DEFAULT, MISEIKYUUUKETUKE, "MISEIKYUUUKETUKE", false);


        lock(C_ShrksnsyoriKbn.class);
    }

    private C_ShrksnsyoriKbn(String value) {
        super(value);
    }

    public static C_ShrksnsyoriKbn valueOf(String value) {
        return valueOf(C_ShrksnsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrksnsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrksnsyoriKbn.class, patternId, value);
    }
}
