
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金不一致理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyuukinHuittiriyuuKbn</td><td colspan="3">入金不一致理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MOSNO}</td><td>&quot;1&quot;</td><td>申込番号不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNOHUKUSUU}</td><td>&quot;2&quot;</td><td>申込番号不一致（該当申込番号複数あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KNKYKNM}</td><td>&quot;3&quot;</td><td>カナ契約者氏名不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUKA}</td><td>&quot;4&quot;</td><td>通貨不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINGAKU}</td><td>&quot;5&quot;</td><td>金額不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYADRTENCD}</td><td>&quot;6&quot;</td><td>親代理店コード不一致</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINERROR}</td><td>&quot;7&quot;</td><td>入金エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITUMOSNO}</td><td>&quot;8&quot;</td><td>同一申込番号あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRGONYKN}</td><td>&quot;9&quot;</td><td>成立後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSRGONYKN}</td><td>&quot;10&quot;</td><td>不成立後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKANYUUKIN}</td><td>&quot;11&quot;</td><td>２回目以降追加入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYADRTENCDERROR}</td><td>&quot;12&quot;</td><td>親代理店コードエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUPKEISAN}</td><td>&quot;13&quot;</td><td>前納保険料計算エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTPHRKKEIRO}</td><td>&quot;14&quot;</td><td>初回保険料払込経路不一致</td></tr>
 * </table>
 */
public class C_NyuukinHuittiriyuuKbn extends Classification<C_NyuukinHuittiriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyuukinHuittiriyuuKbn MOSNO = new C_NyuukinHuittiriyuuKbn("1");

    public static final C_NyuukinHuittiriyuuKbn MOSNOHUKUSUU = new C_NyuukinHuittiriyuuKbn("2");

    public static final C_NyuukinHuittiriyuuKbn KNKYKNM = new C_NyuukinHuittiriyuuKbn("3");

    public static final C_NyuukinHuittiriyuuKbn TUUKA = new C_NyuukinHuittiriyuuKbn("4");

    public static final C_NyuukinHuittiriyuuKbn KINGAKU = new C_NyuukinHuittiriyuuKbn("5");

    public static final C_NyuukinHuittiriyuuKbn OYADRTENCD = new C_NyuukinHuittiriyuuKbn("6");

    public static final C_NyuukinHuittiriyuuKbn NYUUKINERROR = new C_NyuukinHuittiriyuuKbn("7");

    public static final C_NyuukinHuittiriyuuKbn DOUITUMOSNO = new C_NyuukinHuittiriyuuKbn("8");

    public static final C_NyuukinHuittiriyuuKbn SRGONYKN = new C_NyuukinHuittiriyuuKbn("9");

    public static final C_NyuukinHuittiriyuuKbn HSRGONYKN = new C_NyuukinHuittiriyuuKbn("10");

    public static final C_NyuukinHuittiriyuuKbn TUIKANYUUKIN = new C_NyuukinHuittiriyuuKbn("11");

    public static final C_NyuukinHuittiriyuuKbn OYADRTENCDERROR = new C_NyuukinHuittiriyuuKbn("12");

    public static final C_NyuukinHuittiriyuuKbn ZENNOUPKEISAN = new C_NyuukinHuittiriyuuKbn("13");

    public static final C_NyuukinHuittiriyuuKbn FSTPHRKKEIRO = new C_NyuukinHuittiriyuuKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MOSNO, "MOSNO", true);
        addPattern(PATTERN_DEFAULT, MOSNOHUKUSUU, "MOSNOHUKUSUU", false);
        addPattern(PATTERN_DEFAULT, KNKYKNM, "KNKYKNM", false);
        addPattern(PATTERN_DEFAULT, TUUKA, "TUUKA", false);
        addPattern(PATTERN_DEFAULT, KINGAKU, "KINGAKU", false);
        addPattern(PATTERN_DEFAULT, OYADRTENCD, "OYADRTENCD", false);
        addPattern(PATTERN_DEFAULT, NYUUKINERROR, "NYUUKINERROR", false);
        addPattern(PATTERN_DEFAULT, DOUITUMOSNO, "DOUITUMOSNO", false);
        addPattern(PATTERN_DEFAULT, SRGONYKN, "SRGONYKN", false);
        addPattern(PATTERN_DEFAULT, HSRGONYKN, "HSRGONYKN", false);
        addPattern(PATTERN_DEFAULT, TUIKANYUUKIN, "TUIKANYUUKIN", false);
        addPattern(PATTERN_DEFAULT, OYADRTENCDERROR, "OYADRTENCDERROR", false);
        addPattern(PATTERN_DEFAULT, ZENNOUPKEISAN, "ZENNOUPKEISAN", false);
        addPattern(PATTERN_DEFAULT, FSTPHRKKEIRO, "FSTPHRKKEIRO", false);


        lock(C_NyuukinHuittiriyuuKbn.class);
    }

    private C_NyuukinHuittiriyuuKbn(String value) {
        super(value);
    }

    public static C_NyuukinHuittiriyuuKbn valueOf(String value) {
        return valueOf(C_NyuukinHuittiriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyuukinHuittiriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyuukinHuittiriyuuKbn.class, patternId, value);
    }
}
