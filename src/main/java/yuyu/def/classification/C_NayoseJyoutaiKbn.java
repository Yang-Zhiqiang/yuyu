
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NayoseJyoutaiKbn</td><td colspan="3">名寄せ状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #MIRYOU}</td><td>&quot;0&quot;</td><td>未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEZUMI}</td><td>&quot;1&quot;</td><td>名寄せ済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEHUMEI}</td><td>&quot;2&quot;</td><td>名寄せ不明</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_NayoseJyoutaiKbn extends Classification<C_NayoseJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NayoseJyoutaiKbn MIRYOU = new C_NayoseJyoutaiKbn("0");

    public static final C_NayoseJyoutaiKbn NAYOSEZUMI = new C_NayoseJyoutaiKbn("1");

    public static final C_NayoseJyoutaiKbn NAYOSEHUMEI = new C_NayoseJyoutaiKbn("2");

    public static final C_NayoseJyoutaiKbn BLNK = new C_NayoseJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIRYOU, "MIRYOU", false);
        addPattern(PATTERN_DEFAULT, NAYOSEZUMI, "NAYOSEZUMI", false);
        addPattern(PATTERN_DEFAULT, NAYOSEHUMEI, "NAYOSEHUMEI", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_NayoseJyoutaiKbn.class);
    }

    private C_NayoseJyoutaiKbn(String value) {
        super(value);
    }

    public static C_NayoseJyoutaiKbn valueOf(String value) {
        return valueOf(C_NayoseJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NayoseJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NayoseJyoutaiKbn.class, patternId, value);
    }
}
