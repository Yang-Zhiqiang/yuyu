
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ実施結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NayoseJissiKekkaKbn</td><td colspan="3">名寄せ実施結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITUARI}</td><td>&quot;1&quot;</td><td>同一人あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITUNONE}</td><td>&quot;2&quot;</td><td>同一人なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEHUMEI}</td><td>&quot;3&quot;</td><td>名寄せ不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HINDOOVERSYORIHUNOU}</td><td>&quot;4&quot;</td><td>頻度オーバー処理不能</td></tr>
 * </table>
 */
public class C_NayoseJissiKekkaKbn extends Classification<C_NayoseJissiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NayoseJissiKekkaKbn BLNK = new C_NayoseJissiKekkaKbn("0");

    public static final C_NayoseJissiKekkaKbn DOUITUARI = new C_NayoseJissiKekkaKbn("1");

    public static final C_NayoseJissiKekkaKbn DOUITUNONE = new C_NayoseJissiKekkaKbn("2");

    public static final C_NayoseJissiKekkaKbn NAYOSEHUMEI = new C_NayoseJissiKekkaKbn("3");

    public static final C_NayoseJissiKekkaKbn HINDOOVERSYORIHUNOU = new C_NayoseJissiKekkaKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DOUITUARI, "DOUITUARI", false);
        addPattern(PATTERN_DEFAULT, DOUITUNONE, "DOUITUNONE", false);
        addPattern(PATTERN_DEFAULT, NAYOSEHUMEI, "NAYOSEHUMEI", false);
        addPattern(PATTERN_DEFAULT, HINDOOVERSYORIHUNOU, "HINDOOVERSYORIHUNOU", false);


        lock(C_NayoseJissiKekkaKbn.class);
    }

    private C_NayoseJissiKekkaKbn(String value) {
        super(value);
    }

    public static C_NayoseJissiKekkaKbn valueOf(String value) {
        return valueOf(C_NayoseJissiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NayoseJissiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NayoseJissiKekkaKbn.class, patternId, value);
    }
}
