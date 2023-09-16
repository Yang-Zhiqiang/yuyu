
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 確定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KktjyoutaiKbn</td><td colspan="3">確定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEHUMEI}</td><td>&quot;1&quot;</td><td>名寄せ不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKAUNIN}</td><td>&quot;2&quot;</td><td>名寄せ未確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAUTEI}</td><td>&quot;3&quot;</td><td>確定</td></tr>
 * </table>
 */
public class C_KktjyoutaiKbn extends Classification<C_KktjyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KktjyoutaiKbn BLNK = new C_KktjyoutaiKbn("0");

    public static final C_KktjyoutaiKbn NAYOSEHUMEI = new C_KktjyoutaiKbn("1");

    public static final C_KktjyoutaiKbn MIKAUNIN = new C_KktjyoutaiKbn("2");

    public static final C_KktjyoutaiKbn KAUTEI = new C_KktjyoutaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NAYOSEHUMEI, "NAYOSEHUMEI", false);
        addPattern(PATTERN_DEFAULT, MIKAUNIN, "MIKAUNIN", false);
        addPattern(PATTERN_DEFAULT, KAUTEI, "KAUTEI", false);


        lock(C_KktjyoutaiKbn.class);
    }

    private C_KktjyoutaiKbn(String value) {
        super(value);
    }

    public static C_KktjyoutaiKbn valueOf(String value) {
        return valueOf(C_KktjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KktjyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KktjyoutaiKbn.class, patternId, value);
    }
}
