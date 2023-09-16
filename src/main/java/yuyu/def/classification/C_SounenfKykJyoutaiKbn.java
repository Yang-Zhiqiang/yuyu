
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 総年Ｆ契約状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SounenfKykJyoutaiKbn</td><td colspan="3">総年Ｆ契約状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;0&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU_SIBOU}</td><td>&quot;1&quot;</td><td>消滅または死亡</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_SounenfKykJyoutaiKbn extends Classification<C_SounenfKykJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SounenfKykJyoutaiKbn YUUKOU = new C_SounenfKykJyoutaiKbn("0");

    public static final C_SounenfKykJyoutaiKbn SYOUMETU_SIBOU = new C_SounenfKykJyoutaiKbn("1");

    public static final C_SounenfKykJyoutaiKbn BLNK = new C_SounenfKykJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU_SIBOU, "SYOUMETU_SIBOU", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_SounenfKykJyoutaiKbn.class);
    }

    private C_SounenfKykJyoutaiKbn(String value) {
        super(value);
    }

    public static C_SounenfKykJyoutaiKbn valueOf(String value) {
        return valueOf(C_SounenfKykJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SounenfKykJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SounenfKykJyoutaiKbn.class, patternId, value);
    }
}
