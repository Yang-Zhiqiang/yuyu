
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * チャネルコード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Channelcd</td><td colspan="3">チャネルコード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMBC}</td><td>&quot;01&quot;</td><td>SMBC</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIZUHO}</td><td>&quot;02&quot;</td><td>みずほ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SMTB}</td><td>&quot;03&quot;</td><td>SMTB</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHOP}</td><td>&quot;30&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIGIN}</td><td>&quot;52&quot;</td><td>地銀</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIN}</td><td>&quot;54&quot;</td><td>信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKANPO}</td><td>&quot;71&quot;</td><td>郵政（かんぽ生命）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIGINKOU}</td><td>&quot;72&quot;</td><td>郵政（ゆうちょ銀行）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKAISYA}</td><td>&quot;73&quot;</td><td>郵政（郵便局会社）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUSEIKANI}</td><td>&quot;74&quot;</td><td>郵政（簡易郵便局）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAMADOHAN}</td><td>&quot;90&quot;</td><td>その他窓販</td></tr>
 * </table>
 */
public class C_Channelcd extends Classification<C_Channelcd> {

    private static final long serialVersionUID = 1L;


    public static final C_Channelcd BLNK = new C_Channelcd("00");

    public static final C_Channelcd SMBC = new C_Channelcd("01");

    public static final C_Channelcd MIZUHO = new C_Channelcd("02");

    public static final C_Channelcd SMTB = new C_Channelcd("03");

    public static final C_Channelcd SHOP = new C_Channelcd("30");

    public static final C_Channelcd TIGIN = new C_Channelcd("52");

    public static final C_Channelcd SINKIN = new C_Channelcd("54");

    public static final C_Channelcd YUUSEIKANPO = new C_Channelcd("71");

    public static final C_Channelcd YUUSEIGINKOU = new C_Channelcd("72");

    public static final C_Channelcd YUUSEIKAISYA = new C_Channelcd("73");

    public static final C_Channelcd YUUSEIKANI = new C_Channelcd("74");

    public static final C_Channelcd SONOTAMADOHAN = new C_Channelcd("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SMBC, "SMBC", false);
        addPattern(PATTERN_DEFAULT, MIZUHO, "MIZUHO", false);
        addPattern(PATTERN_DEFAULT, SMTB, "SMTB", false);
        addPattern(PATTERN_DEFAULT, SHOP, "SHOP", false);
        addPattern(PATTERN_DEFAULT, TIGIN, "TIGIN", false);
        addPattern(PATTERN_DEFAULT, SINKIN, "SINKIN", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKANPO, "YUUSEIKANPO", false);
        addPattern(PATTERN_DEFAULT, YUUSEIGINKOU, "YUUSEIGINKOU", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKAISYA, "YUUSEIKAISYA", false);
        addPattern(PATTERN_DEFAULT, YUUSEIKANI, "YUUSEIKANI", false);
        addPattern(PATTERN_DEFAULT, SONOTAMADOHAN, "SONOTAMADOHAN", false);


        lock(C_Channelcd.class);
    }

    private C_Channelcd(String value) {
        super(value);
    }

    public static C_Channelcd valueOf(String value) {
        return valueOf(C_Channelcd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Channelcd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Channelcd.class, patternId, value);
    }
}
