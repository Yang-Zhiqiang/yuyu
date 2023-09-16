
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備工程結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HubiKouteiKekkaKbn</td><td colspan="3">不備工程結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;2&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENSOU}</td><td>&quot;3&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;4&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITYUUSI}</td><td>&quot;5&quot;</td><td>不備処理中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUMATI}</td><td>&quot;6&quot;</td><td>回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;7&quot;</td><td>不備</td></tr>
 * </table>
 */
public class C_HubiKouteiKekkaKbn extends Classification<C_HubiKouteiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HubiKouteiKekkaKbn BLNK = new C_HubiKouteiKekkaKbn("0");

    public static final C_HubiKouteiKekkaKbn KANRYOU = new C_HubiKouteiKekkaKbn("1");

    public static final C_HubiKouteiKekkaKbn HORYUU = new C_HubiKouteiKekkaKbn("2");

    public static final C_HubiKouteiKekkaKbn TENSOU = new C_HubiKouteiKekkaKbn("3");

    public static final C_HubiKouteiKekkaKbn SASIMODOSI = new C_HubiKouteiKekkaKbn("4");

    public static final C_HubiKouteiKekkaKbn HUBITYUUSI = new C_HubiKouteiKekkaKbn("5");

    public static final C_HubiKouteiKekkaKbn KAITOUMATI = new C_HubiKouteiKekkaKbn("6");

    public static final C_HubiKouteiKekkaKbn HUBI = new C_HubiKouteiKekkaKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, TENSOU, "TENSOU", false);
        addPattern(PATTERN_DEFAULT, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_DEFAULT, HUBITYUUSI, "HUBITYUUSI", false);
        addPattern(PATTERN_DEFAULT, KAITOUMATI, "KAITOUMATI", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);


        lock(C_HubiKouteiKekkaKbn.class);
    }

    private C_HubiKouteiKekkaKbn(String value) {
        super(value);
    }

    public static C_HubiKouteiKekkaKbn valueOf(String value) {
        return valueOf(C_HubiKouteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HubiKouteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HubiKouteiKekkaKbn.class, patternId, value);
    }
}
