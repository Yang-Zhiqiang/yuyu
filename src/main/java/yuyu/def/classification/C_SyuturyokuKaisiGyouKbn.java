
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 出力開始行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyuturyokuKaisiGyouKbn</td><td colspan="3">出力開始行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIGYOUME}</td><td>&quot;1&quot;</td><td>１行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIGYOUME}</td><td>&quot;2&quot;</td><td>２行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANGYOUME}</td><td>&quot;3&quot;</td><td>３行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YONGYOUME}</td><td>&quot;4&quot;</td><td>４行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOGYOUME}</td><td>&quot;5&quot;</td><td>５行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROKUGYOUME}</td><td>&quot;6&quot;</td><td>６行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NANAGYOUME}</td><td>&quot;7&quot;</td><td>７行目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HATIGYOUME}</td><td>&quot;8&quot;</td><td>８行目</td></tr>
 * </table>
 */
public class C_SyuturyokuKaisiGyouKbn extends Classification<C_SyuturyokuKaisiGyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyuturyokuKaisiGyouKbn ITIGYOUME = new C_SyuturyokuKaisiGyouKbn("1");

    public static final C_SyuturyokuKaisiGyouKbn NIGYOUME = new C_SyuturyokuKaisiGyouKbn("2");

    public static final C_SyuturyokuKaisiGyouKbn SANGYOUME = new C_SyuturyokuKaisiGyouKbn("3");

    public static final C_SyuturyokuKaisiGyouKbn YONGYOUME = new C_SyuturyokuKaisiGyouKbn("4");

    public static final C_SyuturyokuKaisiGyouKbn GOGYOUME = new C_SyuturyokuKaisiGyouKbn("5");

    public static final C_SyuturyokuKaisiGyouKbn ROKUGYOUME = new C_SyuturyokuKaisiGyouKbn("6");

    public static final C_SyuturyokuKaisiGyouKbn NANAGYOUME = new C_SyuturyokuKaisiGyouKbn("7");

    public static final C_SyuturyokuKaisiGyouKbn HATIGYOUME = new C_SyuturyokuKaisiGyouKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIGYOUME, "ITIGYOUME", true);
        addPattern(PATTERN_DEFAULT, NIGYOUME, "NIGYOUME", false);
        addPattern(PATTERN_DEFAULT, SANGYOUME, "SANGYOUME", false);
        addPattern(PATTERN_DEFAULT, YONGYOUME, "YONGYOUME", false);
        addPattern(PATTERN_DEFAULT, GOGYOUME, "GOGYOUME", false);
        addPattern(PATTERN_DEFAULT, ROKUGYOUME, "ROKUGYOUME", false);
        addPattern(PATTERN_DEFAULT, NANAGYOUME, "NANAGYOUME", false);
        addPattern(PATTERN_DEFAULT, HATIGYOUME, "HATIGYOUME", false);


        lock(C_SyuturyokuKaisiGyouKbn.class);
    }

    private C_SyuturyokuKaisiGyouKbn(String value) {
        super(value);
    }

    public static C_SyuturyokuKaisiGyouKbn valueOf(String value) {
        return valueOf(C_SyuturyokuKaisiGyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyuturyokuKaisiGyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyuturyokuKaisiGyouKbn.class, patternId, value);
    }
}
