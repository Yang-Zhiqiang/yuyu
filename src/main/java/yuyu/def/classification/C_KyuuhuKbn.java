
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyuuhuKbn</td><td colspan="3">給付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUIN}</td><td>&quot;1&quot;</td><td>入院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUJYUTU}</td><td>&quot;2&quot;</td><td>手術</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSIN}</td><td>&quot;3&quot;</td><td>先進医療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;4&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSG}</td><td>&quot;5&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LN}</td><td>&quot;6&quot;</td><td>ＬＮ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUINITIJIKN}</td><td>&quot;7&quot;</td><td>入院一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUIN}</td><td>&quot;8&quot;</td><td>通院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSINITIJIKN}</td><td>&quot;9&quot;</td><td>先進医療一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSNDNKH}</td><td>&quot;10&quot;</td><td>がん診断給付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTRY}</td><td>&quot;11&quot;</td><td>腫瘍用薬治療</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIPHOKENKIN}</td><td>&quot;12&quot;</td><td>３大疾病保険金</td></tr>
 * </table>
 */
public class C_KyuuhuKbn extends Classification<C_KyuuhuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyuuhuKbn BLNK = new C_KyuuhuKbn("0");

    public static final C_KyuuhuKbn NYUUIN = new C_KyuuhuKbn("1");

    public static final C_KyuuhuKbn SYUJYUTU = new C_KyuuhuKbn("2");

    public static final C_KyuuhuKbn SENSIN = new C_KyuuhuKbn("3");

    public static final C_KyuuhuKbn SIBOU = new C_KyuuhuKbn("4");

    public static final C_KyuuhuKbn KOUSG = new C_KyuuhuKbn("5");

    public static final C_KyuuhuKbn LN = new C_KyuuhuKbn("6");

    public static final C_KyuuhuKbn NYUUINITIJIKN = new C_KyuuhuKbn("7");

    public static final C_KyuuhuKbn TUUIN = new C_KyuuhuKbn("8");

    public static final C_KyuuhuKbn SENSINITIJIKN = new C_KyuuhuKbn("9");

    public static final C_KyuuhuKbn GANSNDNKH = new C_KyuuhuKbn("10");

    public static final C_KyuuhuKbn SYUTRY = new C_KyuuhuKbn("11");

    public static final C_KyuuhuKbn SANDAISIPHOKENKIN = new C_KyuuhuKbn("12");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUUIN, "NYUUIN", false);
        addPattern(PATTERN_DEFAULT, SYUJYUTU, "SYUJYUTU", false);
        addPattern(PATTERN_DEFAULT, SENSIN, "SENSIN", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, KOUSG, "KOUSG", false);
        addPattern(PATTERN_DEFAULT, LN, "LN", false);
        addPattern(PATTERN_DEFAULT, NYUUINITIJIKN, "NYUUINITIJIKN", false);
        addPattern(PATTERN_DEFAULT, TUUIN, "TUUIN", false);
        addPattern(PATTERN_DEFAULT, SENSINITIJIKN, "SENSINITIJIKN", false);
        addPattern(PATTERN_DEFAULT, GANSNDNKH, "GANSNDNKH", false);
        addPattern(PATTERN_DEFAULT, SYUTRY, "SYUTRY", false);
        addPattern(PATTERN_DEFAULT, SANDAISIPHOKENKIN, "SANDAISIPHOKENKIN", false);


        lock(C_KyuuhuKbn.class);
    }

    private C_KyuuhuKbn(String value) {
        super(value);
    }

    public static C_KyuuhuKbn valueOf(String value) {
        return valueOf(C_KyuuhuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyuuhuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyuuhuKbn.class, patternId, value);
    }
}
