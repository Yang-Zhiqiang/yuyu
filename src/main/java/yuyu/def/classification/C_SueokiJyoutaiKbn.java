
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 据置状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SueokiJyoutaiKbn</td><td colspan="3">据置状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;0&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;1&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANRYOU}</td><td>&quot;2&quot;</td><td>満了</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_SueokiJyoutaiKbn extends Classification<C_SueokiJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SueokiJyoutaiKbn YUUKOU = new C_SueokiJyoutaiKbn("0");

    public static final C_SueokiJyoutaiKbn KAIYAKU = new C_SueokiJyoutaiKbn("1");

    public static final C_SueokiJyoutaiKbn MANRYOU = new C_SueokiJyoutaiKbn("2");

    public static final C_SueokiJyoutaiKbn BLNK = new C_SueokiJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, MANRYOU, "MANRYOU", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_SueokiJyoutaiKbn.class);
    }

    private C_SueokiJyoutaiKbn(String value) {
        super(value);
    }

    public static C_SueokiJyoutaiKbn valueOf(String value) {
        return valueOf(C_SueokiJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SueokiJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SueokiJyoutaiKbn.class, patternId, value);
    }
}
