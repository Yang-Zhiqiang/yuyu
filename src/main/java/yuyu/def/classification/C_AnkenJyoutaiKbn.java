
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案件状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AnkenJyoutaiKbn</td><td colspan="3">案件状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYA}</td><td>&quot;1&quot;</td><td>他社照会中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;2&quot;</td><td>有効中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;3&quot;</td><td>消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUJIN}</td><td>&quot;4&quot;</td><td>別人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REFORM}</td><td>&quot;5&quot;</td><td>リフォーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ASTERISK}</td><td>&quot;6&quot;</td><td>＊</td></tr>
 * </table>
 */
public class C_AnkenJyoutaiKbn extends Classification<C_AnkenJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AnkenJyoutaiKbn BLNK = new C_AnkenJyoutaiKbn("0");

    public static final C_AnkenJyoutaiKbn TASYA = new C_AnkenJyoutaiKbn("1");

    public static final C_AnkenJyoutaiKbn YUUKOU = new C_AnkenJyoutaiKbn("2");

    public static final C_AnkenJyoutaiKbn SYOUMETU = new C_AnkenJyoutaiKbn("3");

    public static final C_AnkenJyoutaiKbn BETUJIN = new C_AnkenJyoutaiKbn("4");

    public static final C_AnkenJyoutaiKbn REFORM = new C_AnkenJyoutaiKbn("5");

    public static final C_AnkenJyoutaiKbn ASTERISK = new C_AnkenJyoutaiKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TASYA, "TASYA", false);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, BETUJIN, "BETUJIN", false);
        addPattern(PATTERN_DEFAULT, REFORM, "REFORM", false);
        addPattern(PATTERN_DEFAULT, ASTERISK, "ASTERISK", false);


        lock(C_AnkenJyoutaiKbn.class);
    }

    private C_AnkenJyoutaiKbn(String value) {
        super(value);
    }

    public static C_AnkenJyoutaiKbn valueOf(String value) {
        return valueOf(C_AnkenJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AnkenJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AnkenJyoutaiKbn.class, patternId, value);
    }
}
