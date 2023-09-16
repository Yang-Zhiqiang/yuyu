
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約取消区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyktrksKbn</td><td colspan="3">契約取消区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;1&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;2&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;3&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;4&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;5&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;6&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHARAIP}</td><td>&quot;7&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_SIHARAI_NASI}</td><td>&quot;8&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI}</td><td>&quot;9&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_SIHARAI_NASI}</td><td>&quot;10&quot;</td><td>死亡免責（支払なし）</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;1&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;2&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;4&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;3&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHARAIP}</td><td>&quot;7&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_SIHARAI_NASI}</td><td>&quot;8&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;5&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI}</td><td>&quot;9&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_SIHARAI_NASI}</td><td>&quot;10&quot;</td><td>死亡免責（支払なし）</td></tr>
 * </table>
 */
public class C_KyktrksKbn extends Classification<C_KyktrksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyktrksKbn BLNK = new C_KyktrksKbn("0");

    public static final C_KyktrksKbn CLGOFF = new C_KyktrksKbn("1");

    public static final C_KyktrksKbn KYKTORIKESI = new C_KyktrksKbn("2");

    public static final C_KyktrksKbn KAIJO = new C_KyktrksKbn("3");

    public static final C_KyktrksKbn MUKOU = new C_KyktrksKbn("4");

    public static final C_KyktrksKbn SBKAIJO = new C_KyktrksKbn("5");

    public static final C_KyktrksKbn MENSEKI = new C_KyktrksKbn("6");

    public static final C_KyktrksKbn SBMUKOU_KIHARAIP = new C_KyktrksKbn("7");

    public static final C_KyktrksKbn SBMUKOU_SIHARAI_NASI = new C_KyktrksKbn("8");

    public static final C_KyktrksKbn SBMENSEKI = new C_KyktrksKbn("9");

    public static final C_KyktrksKbn SBMENSEKI_SIHARAI_NASI = new C_KyktrksKbn("10");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_KIHARAIP, "SBMUKOU_KIHARAIP", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_SIHARAI_NASI, "SBMUKOU_SIHARAI_NASI", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI, "SBMENSEKI", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI_SIHARAI_NASI, "SBMENSEKI_SIHARAI_NASI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_SELECT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_SELECT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_SELECT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_SELECT, SBMUKOU_KIHARAIP, "SBMUKOU_KIHARAIP", false);
        addPattern(PATTERN_SELECT, SBMUKOU_SIHARAI_NASI, "SBMUKOU_SIHARAI_NASI", false);
        addPattern(PATTERN_SELECT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_SELECT, SBMENSEKI, "SBMENSEKI", false);
        addPattern(PATTERN_SELECT, SBMENSEKI_SIHARAI_NASI, "SBMENSEKI_SIHARAI_NASI", false);


        lock(C_KyktrksKbn.class);
    }

    private C_KyktrksKbn(String value) {
        super(value);
    }

    public static C_KyktrksKbn valueOf(String value) {
        return valueOf(C_KyktrksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyktrksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyktrksKbn.class, patternId, value);
    }
}
