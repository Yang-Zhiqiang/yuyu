
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受付経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UkeKeiro</td><td colspan="3">受付経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMEN_ARI}</td><td>&quot;1&quot;</td><td>書面（証書有）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMEN_NASI}</td><td>&quot;2&quot;</td><td>書面（証書無)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CALLCENTER}</td><td>&quot;3&quot;</td><td>コールセンター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUIGON}</td><td>&quot;4&quot;</td><td>遺言</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAINKOUTOU}</td><td>&quot;5&quot;</td><td>社員口頭</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_UkeKeiro extends Classification<C_UkeKeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_UkeKeiro BLNK = new C_UkeKeiro("0");

    public static final C_UkeKeiro SYOMEN_ARI = new C_UkeKeiro("1");

    public static final C_UkeKeiro SYOMEN_NASI = new C_UkeKeiro("2");

    public static final C_UkeKeiro CALLCENTER = new C_UkeKeiro("3");

    public static final C_UkeKeiro YUIGON = new C_UkeKeiro("4");

    public static final C_UkeKeiro SYAINKOUTOU = new C_UkeKeiro("5");

    public static final C_UkeKeiro OTHER = new C_UkeKeiro("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOMEN_ARI, "SYOMEN_ARI", false);
        addPattern(PATTERN_DEFAULT, SYOMEN_NASI, "SYOMEN_NASI", false);
        addPattern(PATTERN_DEFAULT, CALLCENTER, "CALLCENTER", false);
        addPattern(PATTERN_DEFAULT, YUIGON, "YUIGON", false);
        addPattern(PATTERN_DEFAULT, SYAINKOUTOU, "SYAINKOUTOU", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        lock(C_UkeKeiro.class);
    }

    private C_UkeKeiro(String value) {
        super(value);
    }

    public static C_UkeKeiro valueOf(String value) {
        return valueOf(C_UkeKeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UkeKeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UkeKeiro.class, patternId, value);
    }
}
