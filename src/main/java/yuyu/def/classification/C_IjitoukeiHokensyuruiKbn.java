
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医事統計用保険種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IjitoukeiHokensyuruiKbn</td><td colspan="3">医事統計用保険種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN}</td><td>&quot;35&quot;</td><td>外貨建て一時払終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIHENGAKUNENKIN}</td><td>&quot;36&quot;</td><td>外貨建て一時払変額年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN}</td><td>&quot;41&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAHEIJYUNNENKIN}</td><td>&quot;42&quot;</td><td>外貨建平準払年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN19NIGATA}</td><td>&quot;43&quot;</td><td>外貨建一時払終身（１９）Ⅱ型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN20}</td><td>&quot;46&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN}</td><td>&quot;47&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DAIHYOUSYURUI DAIHYOUSYURUI}<br />(代表種類)</td><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN}</td><td>&quot;35&quot;</td><td>01</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN}</td><td>&quot;41&quot;</td><td>03</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAHEIJYUNNENKIN}</td><td>&quot;42&quot;</td><td>03</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJISYUUSIN19NIGATA}</td><td>&quot;43&quot;</td><td>01</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIINDEXNENKIN20}</td><td>&quot;46&quot;</td><td>03</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN}</td><td>&quot;47&quot;</td><td>01</td></tr>
 * </table>
 */
public class C_IjitoukeiHokensyuruiKbn extends Classification<C_IjitoukeiHokensyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IjitoukeiHokensyuruiKbn BLNK = new C_IjitoukeiHokensyuruiKbn("0");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAITIJISYUUSIN = new C_IjitoukeiHokensyuruiKbn("35");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAITIJIHENGAKUNENKIN = new C_IjitoukeiHokensyuruiKbn("36");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAITIJIINDEXNENKIN = new C_IjitoukeiHokensyuruiKbn("41");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAHEIJYUNNENKIN = new C_IjitoukeiHokensyuruiKbn("42");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAITIJISYUUSIN19NIGATA = new C_IjitoukeiHokensyuruiKbn("43");

    public static final C_IjitoukeiHokensyuruiKbn GAIKAITIJIINDEXNENKIN20 = new C_IjitoukeiHokensyuruiKbn("46");

    public static final C_IjitoukeiHokensyuruiKbn TEIKAIYAKUHRKNSYSN = new C_IjitoukeiHokensyuruiKbn("47");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DAIHYOUSYURUI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAIKAITIJISYUUSIN, "GAIKAITIJISYUUSIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIHENGAKUNENKIN, "GAIKAITIJIHENGAKUNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIINDEXNENKIN, "GAIKAITIJIINDEXNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAHEIJYUNNENKIN, "GAIKAHEIJYUNNENKIN", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJISYUUSIN19NIGATA, "GAIKAITIJISYUUSIN19NIGATA", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIINDEXNENKIN20, "GAIKAITIJIINDEXNENKIN20", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN, "TEIKAIYAKUHRKNSYSN", false);


        addPattern(PATTERN_DAIHYOUSYURUI, GAIKAITIJISYUUSIN, "GAIKAITIJISYUUSIN", false);
        addPattern(PATTERN_DAIHYOUSYURUI, GAIKAITIJIINDEXNENKIN, "GAIKAITIJIINDEXNENKIN", false);
        addPattern(PATTERN_DAIHYOUSYURUI, GAIKAHEIJYUNNENKIN, "GAIKAHEIJYUNNENKIN", false);
        addPattern(PATTERN_DAIHYOUSYURUI, GAIKAITIJISYUUSIN19NIGATA, "GAIKAITIJISYUUSIN19NIGATA", false);
        addPattern(PATTERN_DAIHYOUSYURUI, GAIKAITIJIINDEXNENKIN20, "GAIKAITIJIINDEXNENKIN20", false);
        addPattern(PATTERN_DAIHYOUSYURUI, TEIKAIYAKUHRKNSYSN, "TEIKAIYAKUHRKNSYSN", false);


        lock(C_IjitoukeiHokensyuruiKbn.class);
    }

    private C_IjitoukeiHokensyuruiKbn(String value) {
        super(value);
    }

    public static C_IjitoukeiHokensyuruiKbn valueOf(String value) {
        return valueOf(C_IjitoukeiHokensyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IjitoukeiHokensyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IjitoukeiHokensyuruiKbn.class, patternId, value);
    }
}
