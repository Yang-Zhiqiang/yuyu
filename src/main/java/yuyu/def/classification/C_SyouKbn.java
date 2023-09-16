
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 小区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouKbn</td><td colspan="3">小区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTAKUTUKASYSN_JPY}</td><td>&quot;1119&quot;</td><td>低解約返戻金型選択通貨建特別終身保険（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN}</td><td>&quot;1611&quot;</td><td>指定通貨建終身保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN_19_2GATA}</td><td>&quot;1612&quot;</td><td>指定通貨建終身保険（一時払い）（１９）（Ⅱ型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTAKUTUKASYSN_USD}</td><td>&quot;1613&quot;</td><td>低解約返戻金型選択通貨建特別終身保険（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN_HNK}</td><td>&quot;1621&quot;</td><td>指定通貨建終身保険（一時払い）　円建終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKASYSN_19_2GATA_HNK}</td><td>&quot;1622&quot;</td><td>指定通貨建終身保険（一時払い）（１９）（Ⅱ型）　円建終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKANNKN}</td><td>&quot;5611&quot;</td><td>指定通貨建個人年金（一時払い）（指数連動型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEITUKANNKN_20}</td><td>&quot;5612&quot;</td><td>指定通貨建個人年金（一時払い）（２０）（指数連動型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOTEIRRT_SITEITUKANNKN}</td><td>&quot;5621&quot;</td><td>予定利率変動型指定通貨建個人年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKATEIGAKUNNKN}</td><td>&quot;5701&quot;</td><td>円貨定額年金</td></tr>
 * </table>
 */
public class C_SyouKbn extends Classification<C_SyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouKbn BLNK = new C_SyouKbn("0");

    public static final C_SyouKbn SENTAKUTUKASYSN_JPY = new C_SyouKbn("1119");

    public static final C_SyouKbn SITEITUKASYSN = new C_SyouKbn("1611");

    public static final C_SyouKbn SITEITUKASYSN_19_2GATA = new C_SyouKbn("1612");

    public static final C_SyouKbn SENTAKUTUKASYSN_USD = new C_SyouKbn("1613");

    public static final C_SyouKbn SITEITUKASYSN_HNK = new C_SyouKbn("1621");

    public static final C_SyouKbn SITEITUKASYSN_19_2GATA_HNK = new C_SyouKbn("1622");

    public static final C_SyouKbn SITEITUKANNKN = new C_SyouKbn("5611");

    public static final C_SyouKbn SITEITUKANNKN_20 = new C_SyouKbn("5612");

    public static final C_SyouKbn YOTEIRRT_SITEITUKANNKN = new C_SyouKbn("5621");

    public static final C_SyouKbn ENKATEIGAKUNNKN = new C_SyouKbn("5701");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SENTAKUTUKASYSN_JPY, "SENTAKUTUKASYSN_JPY", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN, "SITEITUKASYSN", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN_19_2GATA, "SITEITUKASYSN_19_2GATA", false);
        addPattern(PATTERN_DEFAULT, SENTAKUTUKASYSN_USD, "SENTAKUTUKASYSN_USD", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN_HNK, "SITEITUKASYSN_HNK", false);
        addPattern(PATTERN_DEFAULT, SITEITUKASYSN_19_2GATA_HNK, "SITEITUKASYSN_19_2GATA_HNK", false);
        addPattern(PATTERN_DEFAULT, SITEITUKANNKN, "SITEITUKANNKN", false);
        addPattern(PATTERN_DEFAULT, SITEITUKANNKN_20, "SITEITUKANNKN_20", false);
        addPattern(PATTERN_DEFAULT, YOTEIRRT_SITEITUKANNKN, "YOTEIRRT_SITEITUKANNKN", false);
        addPattern(PATTERN_DEFAULT, ENKATEIGAKUNNKN, "ENKATEIGAKUNNKN", false);


        lock(C_SyouKbn.class);
    }

    private C_SyouKbn(String value) {
        super(value);
    }

    public static C_SyouKbn valueOf(String value) {
        return valueOf(C_SyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouKbn.class, patternId, value);
    }
}
