
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医査統計用保険種類コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IsatoukeiHokensyuruicd</td><td colspan="3">医査統計用保険種類コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN}</td><td>&quot;39&quot;</td><td>外貨建て一時払終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIHENGAKUNENKIN}</td><td>&quot;40&quot;</td><td>外貨建て一時払変額年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN}</td><td>&quot;42&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAHEIJYUNNENKIN}</td><td>&quot;43&quot;</td><td>外貨建平準払年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN19NIGATA}</td><td>&quot;44&quot;</td><td>外貨建一時払終身（１９）Ⅱ型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN20}</td><td>&quot;50&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN}</td><td>&quot;51&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 * </table>
 */
public class C_IsatoukeiHokensyuruicd extends Classification<C_IsatoukeiHokensyuruicd> {

    private static final long serialVersionUID = 1L;


    public static final C_IsatoukeiHokensyuruicd BLNK = new C_IsatoukeiHokensyuruicd("0");

    public static final C_IsatoukeiHokensyuruicd GAIKAITIJISYUUSIN = new C_IsatoukeiHokensyuruicd("39");

    public static final C_IsatoukeiHokensyuruicd GAIKAITIJIHENGAKUNENKIN = new C_IsatoukeiHokensyuruicd("40");

    public static final C_IsatoukeiHokensyuruicd GAIKAITIJIINDEXNENKIN = new C_IsatoukeiHokensyuruicd("42");

    public static final C_IsatoukeiHokensyuruicd GAIKAHEIJYUNNENKIN = new C_IsatoukeiHokensyuruicd("43");

    public static final C_IsatoukeiHokensyuruicd GAIKAITIJISYUUSIN19NIGATA = new C_IsatoukeiHokensyuruicd("44");

    public static final C_IsatoukeiHokensyuruicd GAIKAITIJIINDEXNENKIN20 = new C_IsatoukeiHokensyuruicd("50");

    public static final C_IsatoukeiHokensyuruicd TEIKAIYAKUHRKNSYSN = new C_IsatoukeiHokensyuruicd("51");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAIKAITIJISYUUSIN, "GAIKAITIJISYUUSIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIHENGAKUNENKIN, "GAIKAITIJIHENGAKUNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIINDEXNENKIN, "GAIKAITIJIINDEXNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAHEIJYUNNENKIN, "GAIKAHEIJYUNNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJISYUUSIN19NIGATA, "GAIKAITIJISYUUSIN19NIGATA", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIINDEXNENKIN20, "GAIKAITIJIINDEXNENKIN20", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN, "TEIKAIYAKUHRKNSYSN", false);


        lock(C_IsatoukeiHokensyuruicd.class);
    }

    private C_IsatoukeiHokensyuruicd(String value) {
        super(value);
    }

    public static C_IsatoukeiHokensyuruicd valueOf(String value) {
        return valueOf(C_IsatoukeiHokensyuruicd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IsatoukeiHokensyuruicd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IsatoukeiHokensyuruicd.class, patternId, value);
    }
}
