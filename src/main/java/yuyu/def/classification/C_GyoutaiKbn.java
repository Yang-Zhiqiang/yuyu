
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GyoutaiKbn</td><td colspan="3">業態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="19">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOSIGINKO}</td><td>&quot;01&quot;</td><td>都市銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINYOUGINKO}</td><td>&quot;02&quot;</td><td>長期信用銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTAKUGINKO}</td><td>&quot;03&quot;</td><td>信託銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIHOUGINKO}</td><td>&quot;04&quot;</td><td>地方銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIHOUGINKO2}</td><td>&quot;05&quot;</td><td>第２地方銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKOUKUMIAI}</td><td>&quot;06&quot;</td><td>商工組合中央金庫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINYOUKINKO}</td><td>&quot;07&quot;</td><td>信用金庫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINYOUKUMIAI}</td><td>&quot;08&quot;</td><td>信用組合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUDOUKINKO}</td><td>&quot;09&quot;</td><td>労働金庫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINYOUNOUKYOUREN}</td><td>&quot;15&quot;</td><td>信用農業協同組合連合会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINYOUGYOKYOUREN}</td><td>&quot;20&quot;</td><td>信用漁業協同組合連合会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUGINKO}</td><td>&quot;50&quot;</td><td>外国銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOUKYOUKUMIAI}</td><td>&quot;80&quot;</td><td>農業協同組合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOURINKINKO}</td><td>&quot;86&quot;</td><td>農林中央金庫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENSINYOUKINKOREN}</td><td>&quot;87&quot;</td><td>全国信用金庫連合会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENSINYOUKUMIAIREN}</td><td>&quot;88&quot;</td><td>全国信用共同組合連合会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ROUDOUKINKOREN}</td><td>&quot;89&quot;</td><td>労働金庫連合会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_GyoutaiKbn extends Classification<C_GyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GyoutaiKbn BLNK = new C_GyoutaiKbn("0");

    public static final C_GyoutaiKbn TOSIGINKO = new C_GyoutaiKbn("01");

    public static final C_GyoutaiKbn SINYOUGINKO = new C_GyoutaiKbn("02");

    public static final C_GyoutaiKbn SINTAKUGINKO = new C_GyoutaiKbn("03");

    public static final C_GyoutaiKbn TIHOUGINKO = new C_GyoutaiKbn("04");

    public static final C_GyoutaiKbn TIHOUGINKO2 = new C_GyoutaiKbn("05");

    public static final C_GyoutaiKbn SYOUKOUKUMIAI = new C_GyoutaiKbn("06");

    public static final C_GyoutaiKbn SINYOUKINKO = new C_GyoutaiKbn("07");

    public static final C_GyoutaiKbn SINYOUKUMIAI = new C_GyoutaiKbn("08");

    public static final C_GyoutaiKbn ROUDOUKINKO = new C_GyoutaiKbn("09");

    public static final C_GyoutaiKbn SINYOUNOUKYOUREN = new C_GyoutaiKbn("15");

    public static final C_GyoutaiKbn SINYOUGYOKYOUREN = new C_GyoutaiKbn("20");

    public static final C_GyoutaiKbn GAIKOKUGINKO = new C_GyoutaiKbn("50");

    public static final C_GyoutaiKbn NOUKYOUKUMIAI = new C_GyoutaiKbn("80");

    public static final C_GyoutaiKbn NOURINKINKO = new C_GyoutaiKbn("86");

    public static final C_GyoutaiKbn ZENSINYOUKINKOREN = new C_GyoutaiKbn("87");

    public static final C_GyoutaiKbn ZENSINYOUKUMIAIREN = new C_GyoutaiKbn("88");

    public static final C_GyoutaiKbn ROUDOUKINKOREN = new C_GyoutaiKbn("89");

    public static final C_GyoutaiKbn SONOTA = new C_GyoutaiKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOSIGINKO, "TOSIGINKO", false);
        addPattern(PATTERN_DEFAULT, SINYOUGINKO, "SINYOUGINKO", false);
        addPattern(PATTERN_DEFAULT, SINTAKUGINKO, "SINTAKUGINKO", false);
        addPattern(PATTERN_DEFAULT, TIHOUGINKO, "TIHOUGINKO", false);
        addPattern(PATTERN_DEFAULT, TIHOUGINKO2, "TIHOUGINKO2", false);
        addPattern(PATTERN_DEFAULT, SYOUKOUKUMIAI, "SYOUKOUKUMIAI", false);
        addPattern(PATTERN_DEFAULT, SINYOUKINKO, "SINYOUKINKO", false);
        addPattern(PATTERN_DEFAULT, SINYOUKUMIAI, "SINYOUKUMIAI", false);
        addPattern(PATTERN_DEFAULT, ROUDOUKINKO, "ROUDOUKINKO", false);
        addPattern(PATTERN_DEFAULT, SINYOUNOUKYOUREN, "SINYOUNOUKYOUREN", false);
        addPattern(PATTERN_DEFAULT, SINYOUGYOKYOUREN, "SINYOUGYOKYOUREN", false);
        addPattern(PATTERN_DEFAULT, GAIKOKUGINKO, "GAIKOKUGINKO", false);
        addPattern(PATTERN_DEFAULT, NOUKYOUKUMIAI, "NOUKYOUKUMIAI", false);
        addPattern(PATTERN_DEFAULT, NOURINKINKO, "NOURINKINKO", false);
        addPattern(PATTERN_DEFAULT, ZENSINYOUKINKOREN, "ZENSINYOUKINKOREN", false);
        addPattern(PATTERN_DEFAULT, ZENSINYOUKUMIAIREN, "ZENSINYOUKUMIAIREN", false);
        addPattern(PATTERN_DEFAULT, ROUDOUKINKOREN, "ROUDOUKINKOREN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_GyoutaiKbn.class);
    }

    private C_GyoutaiKbn(String value) {
        super(value);
    }

    public static C_GyoutaiKbn valueOf(String value) {
        return valueOf(C_GyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GyoutaiKbn.class, patternId, value);
    }
}
