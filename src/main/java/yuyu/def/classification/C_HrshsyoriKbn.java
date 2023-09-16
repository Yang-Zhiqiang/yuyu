
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 返戻金支払処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrshsyoriKbn</td><td colspan="3">返戻金支払処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="23">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;10&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHNK}</td><td>&quot;20&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;30&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO_REIGETUKJ}</td><td>&quot;40&quot;</td><td>死亡解除（例月計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO_KESSANKIKJ}</td><td>&quot;41&quot;</td><td>死亡解除（決算期計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO_KKANRINOMI}</td><td>&quot;42&quot;</td><td>死亡解除（契約管理のみ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_REIGETUKJ}</td><td>&quot;50&quot;</td><td>死亡免責（例月計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_KESSANKIKJ}</td><td>&quot;51&quot;</td><td>死亡免責（決算期計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI_KKANRINOMI}</td><td>&quot;52&quot;</td><td>死亡免責（契約管理のみ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;60&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;70&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;80&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;90&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANMUKOU}</td><td>&quot;100&quot;</td><td>がん無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEMUKOU_3DAISIPPMEN}</td><td>&quot;110&quot;</td><td>申出無効（３大疾病Ｐ免）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JSMENSEKI_REIGETUKJ}</td><td>&quot;120&quot;</td><td>自殺免責（例月計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JSMENSEKI_KESSANKIKJ}</td><td>&quot;121&quot;</td><td>自殺免責（決算期計上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDSG}</td><td>&quot;130&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIP}</td><td>&quot;140&quot;</td><td>３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;150&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEMUKOU_3DAISIPHOKNKN}</td><td>&quot;160&quot;</td><td>申出無効（３大疾病保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYKTRKS}</td><td>&quot;170&quot;</td><td>入金取消</td></tr>
 * </table>
 */
public class C_HrshsyoriKbn extends Classification<C_HrshsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrshsyoriKbn BLNK = new C_HrshsyoriKbn("0");

    public static final C_HrshsyoriKbn KAIYAKU = new C_HrshsyoriKbn("10");

    public static final C_HrshsyoriKbn KYKHNK = new C_HrshsyoriKbn("20");

    public static final C_HrshsyoriKbn KAIJYO = new C_HrshsyoriKbn("30");

    public static final C_HrshsyoriKbn SBKAIJO_REIGETUKJ = new C_HrshsyoriKbn("40");

    public static final C_HrshsyoriKbn SBKAIJO_KESSANKIKJ = new C_HrshsyoriKbn("41");

    public static final C_HrshsyoriKbn SBKAIJO_KKANRINOMI = new C_HrshsyoriKbn("42");

    public static final C_HrshsyoriKbn SBMENSEKI_REIGETUKJ = new C_HrshsyoriKbn("50");

    public static final C_HrshsyoriKbn SBMENSEKI_KESSANKIKJ = new C_HrshsyoriKbn("51");

    public static final C_HrshsyoriKbn SBMENSEKI_KKANRINOMI = new C_HrshsyoriKbn("52");

    public static final C_HrshsyoriKbn SIBOU = new C_HrshsyoriKbn("60");

    public static final C_HrshsyoriKbn PMEN = new C_HrshsyoriKbn("70");

    public static final C_HrshsyoriKbn KYKTORIKESI = new C_HrshsyoriKbn("80");

    public static final C_HrshsyoriKbn SEINENGAPPISEI = new C_HrshsyoriKbn("90");

    public static final C_HrshsyoriKbn GANMUKOU = new C_HrshsyoriKbn("100");

    public static final C_HrshsyoriKbn MOUSIDEMUKOU_3DAISIPPMEN = new C_HrshsyoriKbn("110");

    public static final C_HrshsyoriKbn JSMENSEKI_REIGETUKJ = new C_HrshsyoriKbn("120");

    public static final C_HrshsyoriKbn JSMENSEKI_KESSANKIKJ = new C_HrshsyoriKbn("121");

    public static final C_HrshsyoriKbn KDSG = new C_HrshsyoriKbn("130");

    public static final C_HrshsyoriKbn SANDAISIP = new C_HrshsyoriKbn("140");

    public static final C_HrshsyoriKbn TSNGNDTYOUKA = new C_HrshsyoriKbn("150");

    public static final C_HrshsyoriKbn MOUSIDEMUKOU_3DAISIPHOKNKN = new C_HrshsyoriKbn("160");

    public static final C_HrshsyoriKbn NYKTRKS = new C_HrshsyoriKbn("170");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KYKHNK, "KYKHNK", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO_REIGETUKJ, "SBKAIJO_REIGETUKJ", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO_KESSANKIKJ, "SBKAIJO_KESSANKIKJ", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO_KKANRINOMI, "SBKAIJO_KKANRINOMI", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI_REIGETUKJ, "SBMENSEKI_REIGETUKJ", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI_KESSANKIKJ, "SBMENSEKI_KESSANKIKJ", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI_KKANRINOMI, "SBMENSEKI_KKANRINOMI", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, GANMUKOU, "GANMUKOU", false);
        addPattern(PATTERN_DEFAULT, MOUSIDEMUKOU_3DAISIPPMEN, "MOUSIDEMUKOU_3DAISIPPMEN", false);
        addPattern(PATTERN_DEFAULT, JSMENSEKI_REIGETUKJ, "JSMENSEKI_REIGETUKJ", false);
        addPattern(PATTERN_DEFAULT, JSMENSEKI_KESSANKIKJ, "JSMENSEKI_KESSANKIKJ", false);
        addPattern(PATTERN_DEFAULT, KDSG, "KDSG", false);
        addPattern(PATTERN_DEFAULT, SANDAISIP, "SANDAISIP", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, MOUSIDEMUKOU_3DAISIPHOKNKN, "MOUSIDEMUKOU_3DAISIPHOKNKN", false);
        addPattern(PATTERN_DEFAULT, NYKTRKS, "NYKTRKS", false);


        lock(C_HrshsyoriKbn.class);
    }

    private C_HrshsyoriKbn(String value) {
        super(value);
    }

    public static C_HrshsyoriKbn valueOf(String value) {
        return valueOf(C_HrshsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrshsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrshsyoriKbn.class, patternId, value);
    }
}
