
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送金用口座入力チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SoukinyoukzinputchkkekkaKbn</td><td colspan="3">送金用口座入力チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKINMINYUURYOKU}</td><td>&quot;1&quot;</td><td>預金種目未入力エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUTYOGINKOUDATOUSEI}</td><td>&quot;2&quot;</td><td>ゆうちょ銀行妥当性エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANGOUMINYUURYOKU}</td><td>&quot;3&quot;</td><td>口座番号未入力エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANGOUKETASUU}</td><td>&quot;4&quot;</td><td>口座番号桁数エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANGOUKYOKAMOJI}</td><td>&quot;5&quot;</td><td>口座番号許可文字エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGININMINYUURYOKU}</td><td>&quot;6&quot;</td><td>口座名義人未入力エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGININKETASUU}</td><td>&quot;7&quot;</td><td>口座名義人桁数エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGININKYOKAMOJI}</td><td>&quot;8&quot;</td><td>口座名義人許可文字エラー</td></tr>
 * </table>
 */
public class C_SoukinyoukzinputchkkekkaKbn extends Classification<C_SoukinyoukzinputchkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SoukinyoukzinputchkkekkaKbn BLNK = new C_SoukinyoukzinputchkkekkaKbn("0");

    public static final C_SoukinyoukzinputchkkekkaKbn YOKINMINYUURYOKU = new C_SoukinyoukzinputchkkekkaKbn("1");

    public static final C_SoukinyoukzinputchkkekkaKbn YUTYOGINKOUDATOUSEI = new C_SoukinyoukzinputchkkekkaKbn("2");

    public static final C_SoukinyoukzinputchkkekkaKbn BANGOUMINYUURYOKU = new C_SoukinyoukzinputchkkekkaKbn("3");

    public static final C_SoukinyoukzinputchkkekkaKbn BANGOUKETASUU = new C_SoukinyoukzinputchkkekkaKbn("4");

    public static final C_SoukinyoukzinputchkkekkaKbn BANGOUKYOKAMOJI = new C_SoukinyoukzinputchkkekkaKbn("5");

    public static final C_SoukinyoukzinputchkkekkaKbn MEIGININMINYUURYOKU = new C_SoukinyoukzinputchkkekkaKbn("6");

    public static final C_SoukinyoukzinputchkkekkaKbn MEIGININKETASUU = new C_SoukinyoukzinputchkkekkaKbn("7");

    public static final C_SoukinyoukzinputchkkekkaKbn MEIGININKYOKAMOJI = new C_SoukinyoukzinputchkkekkaKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOKINMINYUURYOKU, "YOKINMINYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, YUTYOGINKOUDATOUSEI, "YUTYOGINKOUDATOUSEI", false);
        addPattern(PATTERN_DEFAULT, BANGOUMINYUURYOKU, "BANGOUMINYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, BANGOUKETASUU, "BANGOUKETASUU", false);
        addPattern(PATTERN_DEFAULT, BANGOUKYOKAMOJI, "BANGOUKYOKAMOJI", false);
        addPattern(PATTERN_DEFAULT, MEIGININMINYUURYOKU, "MEIGININMINYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, MEIGININKETASUU, "MEIGININKETASUU", false);
        addPattern(PATTERN_DEFAULT, MEIGININKYOKAMOJI, "MEIGININKYOKAMOJI", false);


        lock(C_SoukinyoukzinputchkkekkaKbn.class);
    }

    private C_SoukinyoukzinputchkkekkaKbn(String value) {
        super(value);
    }

    public static C_SoukinyoukzinputchkkekkaKbn valueOf(String value) {
        return valueOf(C_SoukinyoukzinputchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SoukinyoukzinputchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SoukinyoukzinputchkkekkaKbn.class, patternId, value);
    }
}
