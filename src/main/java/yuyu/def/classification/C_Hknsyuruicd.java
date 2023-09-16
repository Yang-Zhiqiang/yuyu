
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険種類コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hknsyuruicd</td><td colspan="3">保険種類コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUSIN}</td><td>&quot;S&quot;</td><td>終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKI}</td><td>&quot;T&quot;</td><td>定期保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUROU}</td><td>&quot;Y&quot;</td><td>養老保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOTIKU}</td><td>&quot;C&quot;</td><td>貯蓄保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKU}</td><td>&quot;H&quot;</td><td>変額保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;N&quot;</td><td>年金保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIPPEIIRYOU}</td><td>&quot;M&quot;</td><td>疾病・医療保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNIT}</td><td>&quot;U&quot;</td><td>ユニット型保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;Z&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Hknsyuruicd extends Classification<C_Hknsyuruicd> {

    private static final long serialVersionUID = 1L;


    public static final C_Hknsyuruicd BLNK = new C_Hknsyuruicd("0");

    public static final C_Hknsyuruicd SYUUSIN = new C_Hknsyuruicd("S");

    public static final C_Hknsyuruicd TEIKI = new C_Hknsyuruicd("T");

    public static final C_Hknsyuruicd YOUROU = new C_Hknsyuruicd("Y");

    public static final C_Hknsyuruicd TYOTIKU = new C_Hknsyuruicd("C");

    public static final C_Hknsyuruicd HENGAKU = new C_Hknsyuruicd("H");

    public static final C_Hknsyuruicd NENKIN = new C_Hknsyuruicd("N");

    public static final C_Hknsyuruicd SIPPEIIRYOU = new C_Hknsyuruicd("M");

    public static final C_Hknsyuruicd UNIT = new C_Hknsyuruicd("U");

    public static final C_Hknsyuruicd SONOTA = new C_Hknsyuruicd("Z");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYUUSIN, "SYUUSIN", false);
        addPattern(PATTERN_DEFAULT, TEIKI, "TEIKI", false);
        addPattern(PATTERN_DEFAULT, YOUROU, "YOUROU", false);
        addPattern(PATTERN_DEFAULT, TYOTIKU, "TYOTIKU", false);
        addPattern(PATTERN_DEFAULT, HENGAKU, "HENGAKU", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);
        addPattern(PATTERN_DEFAULT, SIPPEIIRYOU, "SIPPEIIRYOU", false);
        addPattern(PATTERN_DEFAULT, UNIT, "UNIT", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Hknsyuruicd.class);
    }

    private C_Hknsyuruicd(String value) {
        super(value);
    }

    public static C_Hknsyuruicd valueOf(String value) {
        return valueOf(C_Hknsyuruicd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hknsyuruicd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hknsyuruicd.class, patternId, value);
    }
}
