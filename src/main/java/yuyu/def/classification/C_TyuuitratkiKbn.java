
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 注意取扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyuuitratkiKbn</td><td colspan="3">注意取扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DENGON}</td><td>&quot;1&quot;</td><td>伝言メモ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;2&quot;</td><td>処理停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUUI}</td><td>&quot;3&quot;</td><td>案内注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITEISI}</td><td>&quot;4&quot;</td><td>案内停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUTEISI}</td><td>&quot;5&quot;</td><td>自動支払停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENTEISI}</td><td>&quot;6&quot;</td><td>全処理停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTORIKESI}</td><td>&quot;7&quot;</td><td>年金取消</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_RADIO RADIO}<br />(画面)</td><td align="center">○</td><td>{@link #DENGON}</td><td>&quot;1&quot;</td><td>伝言メモ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;2&quot;</td><td>処理停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUUI}</td><td>&quot;3&quot;</td><td>案内注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITEISI}</td><td>&quot;4&quot;</td><td>案内停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUTEISI}</td><td>&quot;5&quot;</td><td>自動支払停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENTEISI}</td><td>&quot;6&quot;</td><td>全処理停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTORIKESI}</td><td>&quot;7&quot;</td><td>年金取消</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_TORIKESI TORIKESI}<br />(画面（取消なし）)</td><td align="center">○</td><td>{@link #DENGON}</td><td>&quot;1&quot;</td><td>伝言メモ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;2&quot;</td><td>処理停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITYUUI}</td><td>&quot;3&quot;</td><td>案内注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAITEISI}</td><td>&quot;4&quot;</td><td>案内停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUTEISI}</td><td>&quot;5&quot;</td><td>自動支払停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENTEISI}</td><td>&quot;6&quot;</td><td>全処理停止</td></tr>
 * </table>
 */
public class C_TyuuitratkiKbn extends Classification<C_TyuuitratkiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyuuitratkiKbn BLNK = new C_TyuuitratkiKbn("0");

    public static final C_TyuuitratkiKbn DENGON = new C_TyuuitratkiKbn("1");

    public static final C_TyuuitratkiKbn TEISI = new C_TyuuitratkiKbn("2");

    public static final C_TyuuitratkiKbn ANNAITYUUI = new C_TyuuitratkiKbn("3");

    public static final C_TyuuitratkiKbn ANNAITEISI = new C_TyuuitratkiKbn("4");

    public static final C_TyuuitratkiKbn JIDOUTEISI = new C_TyuuitratkiKbn("5");

    public static final C_TyuuitratkiKbn ZENTEISI = new C_TyuuitratkiKbn("6");

    public static final C_TyuuitratkiKbn NKTORIKESI = new C_TyuuitratkiKbn("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";

    public static final String PATTERN_TORIKESI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DENGON, "DENGON", false);
        addPattern(PATTERN_DEFAULT, TEISI, "TEISI", false);
        addPattern(PATTERN_DEFAULT, ANNAITYUUI, "ANNAITYUUI", false);
        addPattern(PATTERN_DEFAULT, ANNAITEISI, "ANNAITEISI", false);
        addPattern(PATTERN_DEFAULT, JIDOUTEISI, "JIDOUTEISI", false);
        addPattern(PATTERN_DEFAULT, ZENTEISI, "ZENTEISI", false);
        addPattern(PATTERN_DEFAULT, NKTORIKESI, "NKTORIKESI", false);


        addPattern(PATTERN_RADIO, DENGON, "DENGON", true);
        addPattern(PATTERN_RADIO, TEISI, "TEISI", false);
        addPattern(PATTERN_RADIO, ANNAITYUUI, "ANNAITYUUI", false);
        addPattern(PATTERN_RADIO, ANNAITEISI, "ANNAITEISI", false);
        addPattern(PATTERN_RADIO, JIDOUTEISI, "JIDOUTEISI", false);
        addPattern(PATTERN_RADIO, ZENTEISI, "ZENTEISI", false);
        addPattern(PATTERN_RADIO, NKTORIKESI, "NKTORIKESI", false);


        addPattern(PATTERN_TORIKESI, DENGON, "DENGON", true);
        addPattern(PATTERN_TORIKESI, TEISI, "TEISI", false);
        addPattern(PATTERN_TORIKESI, ANNAITYUUI, "ANNAITYUUI", false);
        addPattern(PATTERN_TORIKESI, ANNAITEISI, "ANNAITEISI", false);
        addPattern(PATTERN_TORIKESI, JIDOUTEISI, "JIDOUTEISI", false);
        addPattern(PATTERN_TORIKESI, ZENTEISI, "ZENTEISI", false);


        lock(C_TyuuitratkiKbn.class);
    }

    private C_TyuuitratkiKbn(String value) {
        super(value);
    }

    public static C_TyuuitratkiKbn valueOf(String value) {
        return valueOf(C_TyuuitratkiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyuuitratkiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyuuitratkiKbn.class, patternId, value);
    }
}
