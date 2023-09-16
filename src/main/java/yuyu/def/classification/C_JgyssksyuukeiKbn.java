
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 事業成績表集計パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JgyssksyuukeiKbn</td><td colspan="3">事業成績表集計パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NENSI}</td><td>&quot;10&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENSI_HENSOKU}</td><td>&quot;15&quot;</td><td>なし（変則）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEGKBN}</td><td>&quot;20&quot;</td><td>セグメント区分　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEGKBN_HENSOKU}</td><td>&quot;25&quot;</td><td>セグメント区分（変則）　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTKKBN}</td><td>&quot;30&quot;</td><td>主契約特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEGKBN_SYUTKKBN}</td><td>&quot;40&quot;</td><td>セグメント区分・主契約特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURISYURUICD1}</td><td>&quot;A3&quot;</td><td>数理種類コード１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURISYURUICD2}</td><td>&quot;A4&quot;</td><td>数理種類コード２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURISYURUICD3}</td><td>&quot;A5&quot;</td><td>数理種類コード３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSEI}</td><td>&quot;B1&quot;</td><td>被保険者性別</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSEI_SYUTKKBN}</td><td>&quot;B2&quot;</td><td>被保険者性別・主契約特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSEI_SUURISYURUICD1}</td><td>&quot;B3&quot;</td><td>被保険者性別・数理種類コード１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSEI_SUURISYURUICD2}</td><td>&quot;B4&quot;</td><td>被保険者性別・数理種類コード２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSEI_SUURISYURUICD3}</td><td>&quot;B5&quot;</td><td>被保険者性別・数理種類コード３</td></tr>
 * </table>
 */
public class C_JgyssksyuukeiKbn extends Classification<C_JgyssksyuukeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JgyssksyuukeiKbn NENSI = new C_JgyssksyuukeiKbn("10");

    public static final C_JgyssksyuukeiKbn NENSI_HENSOKU = new C_JgyssksyuukeiKbn("15");

    public static final C_JgyssksyuukeiKbn SEGKBN = new C_JgyssksyuukeiKbn("20");

    public static final C_JgyssksyuukeiKbn SEGKBN_HENSOKU = new C_JgyssksyuukeiKbn("25");

    public static final C_JgyssksyuukeiKbn SYUTKKBN = new C_JgyssksyuukeiKbn("30");

    public static final C_JgyssksyuukeiKbn SEGKBN_SYUTKKBN = new C_JgyssksyuukeiKbn("40");

    public static final C_JgyssksyuukeiKbn SUURISYURUICD1 = new C_JgyssksyuukeiKbn("A3");

    public static final C_JgyssksyuukeiKbn SUURISYURUICD2 = new C_JgyssksyuukeiKbn("A4");

    public static final C_JgyssksyuukeiKbn SUURISYURUICD3 = new C_JgyssksyuukeiKbn("A5");

    public static final C_JgyssksyuukeiKbn HHKNSEI = new C_JgyssksyuukeiKbn("B1");

    public static final C_JgyssksyuukeiKbn HHKNSEI_SYUTKKBN = new C_JgyssksyuukeiKbn("B2");

    public static final C_JgyssksyuukeiKbn HHKNSEI_SUURISYURUICD1 = new C_JgyssksyuukeiKbn("B3");

    public static final C_JgyssksyuukeiKbn HHKNSEI_SUURISYURUICD2 = new C_JgyssksyuukeiKbn("B4");

    public static final C_JgyssksyuukeiKbn HHKNSEI_SUURISYURUICD3 = new C_JgyssksyuukeiKbn("B5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NENSI, "NENSI", true);
        addPattern(PATTERN_DEFAULT, NENSI_HENSOKU, "NENSI_HENSOKU", false);
        addPattern(PATTERN_DEFAULT, SEGKBN, "SEGKBN", false);
        addPattern(PATTERN_DEFAULT, SEGKBN_HENSOKU, "SEGKBN_HENSOKU", false);
        addPattern(PATTERN_DEFAULT, SYUTKKBN, "SYUTKKBN", false);
        addPattern(PATTERN_DEFAULT, SEGKBN_SYUTKKBN, "SEGKBN_SYUTKKBN", false);
        addPattern(PATTERN_DEFAULT, SUURISYURUICD1, "SUURISYURUICD1", false);
        addPattern(PATTERN_DEFAULT, SUURISYURUICD2, "SUURISYURUICD2", false);
        addPattern(PATTERN_DEFAULT, SUURISYURUICD3, "SUURISYURUICD3", false);
        addPattern(PATTERN_DEFAULT, HHKNSEI, "HHKNSEI", false);
        addPattern(PATTERN_DEFAULT, HHKNSEI_SYUTKKBN, "HHKNSEI_SYUTKKBN", false);
        addPattern(PATTERN_DEFAULT, HHKNSEI_SUURISYURUICD1, "HHKNSEI_SUURISYURUICD1", false);
        addPattern(PATTERN_DEFAULT, HHKNSEI_SUURISYURUICD2, "HHKNSEI_SUURISYURUICD2", false);
        addPattern(PATTERN_DEFAULT, HHKNSEI_SUURISYURUICD3, "HHKNSEI_SUURISYURUICD3", false);


        lock(C_JgyssksyuukeiKbn.class);
    }

    private C_JgyssksyuukeiKbn(String value) {
        super(value);
    }

    public static C_JgyssksyuukeiKbn valueOf(String value) {
        return valueOf(C_JgyssksyuukeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JgyssksyuukeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JgyssksyuukeiKbn.class, patternId, value);
    }
}
