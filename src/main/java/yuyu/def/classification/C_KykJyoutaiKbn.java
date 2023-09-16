
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykJyoutaiKbn</td><td colspan="3">契約状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;0&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;1&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_KykJyoutaiKbn extends Classification<C_KykJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykJyoutaiKbn YUUKOU = new C_KykJyoutaiKbn("0");

    public static final C_KykJyoutaiKbn SIKKOU = new C_KykJyoutaiKbn("1");

    public static final C_KykJyoutaiKbn SYOUMETU = new C_KykJyoutaiKbn("2");

    public static final C_KykJyoutaiKbn BLNK = new C_KykJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_KykJyoutaiKbn.class);
    }

    private C_KykJyoutaiKbn(String value) {
        super(value);
    }

    public static C_KykJyoutaiKbn valueOf(String value) {
        return valueOf(C_KykJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykJyoutaiKbn.class, patternId, value);
    }
}
