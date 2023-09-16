
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * セグメントコード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Segcd</td><td colspan="3">セグメントコード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINITIJIBARAIJYUNYUUHAI}</td><td>&quot;2801&quot;</td><td>米ドル建終身保険（一時払）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSYUUSINITIJIBARAIJYUNYUUHAI}</td><td>&quot;2901&quot;</td><td>豪ドル建終身保険（一時払）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSISUURENDOUNENKINITIJIJYUNYUU}</td><td>&quot;2601&quot;</td><td>米ドル建個人年金（一時払）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSISUURENDOUNENKINITIJIJYUNYUU}</td><td>&quot;2701&quot;</td><td>豪ドル建個人年金（一時払）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSIN}</td><td>&quot;0214&quot;</td><td>円建終身変更（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDKOJINNENKINHIJYNBRJYUNYUUHAI}</td><td>&quot;2602&quot;</td><td>米ドル建個人年金（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDKOJINNENKINHIJYNBRJYUNYUUHAI}</td><td>&quot;2702&quot;</td><td>豪ドル建個人年金（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYNENKIN}</td><td>&quot;0906&quot;</td><td>円建年金変更（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINITIJIBARAI19JYUNYUUHAI}</td><td>&quot;2802&quot;</td><td>米ドル建終身保険（一時払１９）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSYUUSINITIJIBARAI19JYUNYUUHAI}</td><td>&quot;2902&quot;</td><td>豪ドル建終身保険（一時払１９）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDKOJINNENKINITIJIBARAI20JYUNYUUHAI}</td><td>&quot;2603&quot;</td><td>米ドル建個人年金（一時払２０）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI}</td><td>&quot;2703&quot;</td><td>豪ドル建個人年金（一時払２０）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSIN19}</td><td>&quot;0215&quot;</td><td>円建終身変更（１９）（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI}</td><td>&quot;0216&quot;</td><td>低解約返戻金型特別終身（準有配）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI}</td><td>&quot;2803&quot;</td><td>米ドル建低解約返戻金型特別終身（準有配）</td></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_RYAKUSYOU RYAKUSYOU}<br />(略称)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINITIJIBARAIJYUNYUUHAI}</td><td>&quot;2801&quot;</td><td>米終１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSYUUSINITIJIBARAIJYUNYUUHAI}</td><td>&quot;2901&quot;</td><td>豪終１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSISUURENDOUNENKINITIJIJYUNYUU}</td><td>&quot;2601&quot;</td><td>米年１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSISUURENDOUNENKINITIJIJYUNYUU}</td><td>&quot;2701&quot;</td><td>豪年１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSIN}</td><td>&quot;0214&quot;</td><td>円終１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDKOJINNENKINHIJYNBRJYUNYUUHAI}</td><td>&quot;2602&quot;</td><td>米年平</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDKOJINNENKINHIJYNBRJYUNYUUHAI}</td><td>&quot;2702&quot;</td><td>豪年平</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYNENKIN}</td><td>&quot;0906&quot;</td><td>円年１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINITIJIBARAI19JYUNYUUHAI}</td><td>&quot;2802&quot;</td><td>米終２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDSYUUSINITIJIBARAI19JYUNYUUHAI}</td><td>&quot;2902&quot;</td><td>豪終２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDKOJINNENKINITIJIBARAI20JYUNYUUHAI}</td><td>&quot;2603&quot;</td><td>米年２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI}</td><td>&quot;2703&quot;</td><td>豪年２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSIN19}</td><td>&quot;0215&quot;</td><td>円終２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI}</td><td>&quot;0216&quot;</td><td>円終３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI}</td><td>&quot;2803&quot;</td><td>米終３</td></tr>
 * </table>
 */
public class C_Segcd extends Classification<C_Segcd> {

    private static final long serialVersionUID = 1L;


    public static final C_Segcd BLNK = new C_Segcd("0000");

    public static final C_Segcd USDSYUUSINITIJIBARAIJYUNYUUHAI = new C_Segcd("2801");

    public static final C_Segcd AUDSYUUSINITIJIBARAIJYUNYUUHAI = new C_Segcd("2901");

    public static final C_Segcd USDSISUURENDOUNENKINITIJIJYUNYUU = new C_Segcd("2601");

    public static final C_Segcd AUDSISUURENDOUNENKINITIJIJYUNYUU = new C_Segcd("2701");

    public static final C_Segcd JPYSYUUSIN = new C_Segcd("0214");

    public static final C_Segcd USDKOJINNENKINHIJYNBRJYUNYUUHAI = new C_Segcd("2602");

    public static final C_Segcd AUDKOJINNENKINHIJYNBRJYUNYUUHAI = new C_Segcd("2702");

    public static final C_Segcd JPYNENKIN = new C_Segcd("0906");

    public static final C_Segcd USDSYUUSINITIJIBARAI19JYUNYUUHAI = new C_Segcd("2802");

    public static final C_Segcd AUDSYUUSINITIJIBARAI19JYUNYUUHAI = new C_Segcd("2902");

    public static final C_Segcd USDKOJINNENKINITIJIBARAI20JYUNYUUHAI = new C_Segcd("2603");

    public static final C_Segcd AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI = new C_Segcd("2703");

    public static final C_Segcd JPYSYUUSIN19 = new C_Segcd("0215");

    public static final C_Segcd JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI = new C_Segcd("0216");

    public static final C_Segcd USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI = new C_Segcd("2803");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RYAKUSYOU = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, USDSYUUSINITIJIBARAIJYUNYUUHAI, "USDSYUUSINITIJIBARAIJYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, AUDSYUUSINITIJIBARAIJYUNYUUHAI, "AUDSYUUSINITIJIBARAIJYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, USDSISUURENDOUNENKINITIJIJYUNYUU, "USDSISUURENDOUNENKINITIJIJYUNYUU", false);
        addPattern(PATTERN_DEFAULT, AUDSISUURENDOUNENKINITIJIJYUNYUU, "AUDSISUURENDOUNENKINITIJIJYUNYUU", false);
        addPattern(PATTERN_DEFAULT, JPYSYUUSIN, "JPYSYUUSIN", false);
        addPattern(PATTERN_DEFAULT, USDKOJINNENKINHIJYNBRJYUNYUUHAI, "USDKOJINNENKINHIJYNBRJYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "AUDKOJINNENKINHIJYNBRJYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, JPYNENKIN, "JPYNENKIN", false);
        addPattern(PATTERN_DEFAULT, USDSYUUSINITIJIBARAI19JYUNYUUHAI, "USDSYUUSINITIJIBARAI19JYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, AUDSYUUSINITIJIBARAI19JYUNYUUHAI, "AUDSYUUSINITIJIBARAI19JYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, USDKOJINNENKINITIJIBARAI20JYUNYUUHAI, "USDKOJINNENKINITIJIBARAI20JYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI, "AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, JPYSYUUSIN19, "JPYSYUUSIN19", false);
        addPattern(PATTERN_DEFAULT, JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI, "JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI", false);
        addPattern(PATTERN_DEFAULT, USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI, "USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI", false);


        addPattern(PATTERN_RYAKUSYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_RYAKUSYOU, USDSYUUSINITIJIBARAIJYUNYUUHAI, "USDSYUUSINITIJIBARAIJYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, AUDSYUUSINITIJIBARAIJYUNYUUHAI, "AUDSYUUSINITIJIBARAIJYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, USDSISUURENDOUNENKINITIJIJYUNYUU, "USDSISUURENDOUNENKINITIJIJYUNYUU", false);
        addPattern(PATTERN_RYAKUSYOU, AUDSISUURENDOUNENKINITIJIJYUNYUU, "AUDSISUURENDOUNENKINITIJIJYUNYUU", false);
        addPattern(PATTERN_RYAKUSYOU, JPYSYUUSIN, "JPYSYUUSIN", false);
        addPattern(PATTERN_RYAKUSYOU, USDKOJINNENKINHIJYNBRJYUNYUUHAI, "USDKOJINNENKINHIJYNBRJYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "AUDKOJINNENKINHIJYNBRJYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, JPYNENKIN, "JPYNENKIN", false);
        addPattern(PATTERN_RYAKUSYOU, USDSYUUSINITIJIBARAI19JYUNYUUHAI, "USDSYUUSINITIJIBARAI19JYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, AUDSYUUSINITIJIBARAI19JYUNYUUHAI, "AUDSYUUSINITIJIBARAI19JYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, USDKOJINNENKINITIJIBARAI20JYUNYUUHAI, "USDKOJINNENKINITIJIBARAI20JYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI, "AUDKOJINNENKINITIJIBARAI20JYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, JPYSYUUSIN19, "JPYSYUUSIN19", false);
        addPattern(PATTERN_RYAKUSYOU, JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI, "JPYSYUUSINTEIKAIYAKUHRJYUNYUUHAI", false);
        addPattern(PATTERN_RYAKUSYOU, USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI, "USDSYUUSINTEIKAIYAKUHRJYUNYUUHAI", false);


        lock(C_Segcd.class);
    }

    private C_Segcd(String value) {
        super(value);
    }

    public static C_Segcd valueOf(String value) {
        return valueOf(C_Segcd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Segcd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Segcd.class, patternId, value);
    }
}
