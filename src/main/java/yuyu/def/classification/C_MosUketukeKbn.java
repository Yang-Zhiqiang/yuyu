
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込受付区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosUketukeKbn</td><td colspan="3">申込受付区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSKIT}</td><td>&quot;1&quot;</td><td>申込キット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIHOWEB}</td><td>&quot;2&quot;</td><td>生保Ｗｅｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESS}</td><td>&quot;3&quot;</td><td>ペーパーレス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOUSEIKYUU}</td><td>&quot;4&quot;</td><td>資料請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECT}</td><td>&quot;5&quot;</td><td>ダイレクト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESSNIT}</td><td>&quot;6&quot;</td><td>ペーパーレス（ＮＩＴ）</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #MOSKIT}</td><td>&quot;1&quot;</td><td>申込キット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIHOWEB}</td><td>&quot;2&quot;</td><td>生保Ｗｅｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESS}</td><td>&quot;3&quot;</td><td>ペーパーレス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESSNIT}</td><td>&quot;6&quot;</td><td>ペーパーレス（ＮＩＴ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRYOUSEIKYUU}</td><td>&quot;4&quot;</td><td>資料請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECT}</td><td>&quot;5&quot;</td><td>ダイレクト</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DISP DISP}<br />(工程ワークリスト表示用)</td><td align="center">&nbsp;</td><td>{@link #MOSKIT}</td><td>&quot;1&quot;</td><td>申込キット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIHOWEB}</td><td>&quot;2&quot;</td><td>Ｗｅｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESS}</td><td>&quot;3&quot;</td><td>ペーパーレス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESSNIT}</td><td>&quot;6&quot;</td><td>ペーパーレス（ＮＩＴ）</td></tr>
 * </table>
 */
public class C_MosUketukeKbn extends Classification<C_MosUketukeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosUketukeKbn BLNK = new C_MosUketukeKbn("0");

    public static final C_MosUketukeKbn MOSKIT = new C_MosUketukeKbn("1");

    public static final C_MosUketukeKbn SEIHOWEB = new C_MosUketukeKbn("2");

    public static final C_MosUketukeKbn PAPERLESS = new C_MosUketukeKbn("3");

    public static final C_MosUketukeKbn SIRYOUSEIKYUU = new C_MosUketukeKbn("4");

    public static final C_MosUketukeKbn DIRECT = new C_MosUketukeKbn("5");

    public static final C_MosUketukeKbn PAPERLESSNIT = new C_MosUketukeKbn("6");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_DISP = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOSKIT, "MOSKIT", false);
        addPattern(PATTERN_DEFAULT, SEIHOWEB, "SEIHOWEB", false);
        addPattern(PATTERN_DEFAULT, PAPERLESS, "PAPERLESS", false);
        addPattern(PATTERN_DEFAULT, SIRYOUSEIKYUU, "SIRYOUSEIKYUU", false);
        addPattern(PATTERN_DEFAULT, DIRECT, "DIRECT", false);
        addPattern(PATTERN_DEFAULT, PAPERLESSNIT, "PAPERLESSNIT", false);


        addPattern(PATTERN_NOBLNK, MOSKIT, "MOSKIT", true);
        addPattern(PATTERN_NOBLNK, SEIHOWEB, "SEIHOWEB", false);
        addPattern(PATTERN_NOBLNK, PAPERLESS, "PAPERLESS", false);
        addPattern(PATTERN_NOBLNK, PAPERLESSNIT, "PAPERLESSNIT", false);
        addPattern(PATTERN_NOBLNK, SIRYOUSEIKYUU, "SIRYOUSEIKYUU", false);
        addPattern(PATTERN_NOBLNK, DIRECT, "DIRECT", false);


        addPattern(PATTERN_DISP, MOSKIT, "MOSKIT", false);
        addPattern(PATTERN_DISP, SEIHOWEB, "SEIHOWEB", false);
        addPattern(PATTERN_DISP, PAPERLESS, "PAPERLESS", false);
        addPattern(PATTERN_DISP, PAPERLESSNIT, "PAPERLESSNIT", false);


        lock(C_MosUketukeKbn.class);
    }

    private C_MosUketukeKbn(String value) {
        super(value);
    }

    public static C_MosUketukeKbn valueOf(String value) {
        return valueOf(C_MosUketukeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosUketukeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosUketukeKbn.class, patternId, value);
    }
}
