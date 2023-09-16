
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店消滅事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtensymtjiyuuKbn</td><td colspan="3">代理店消滅事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOTUGOU}</td><td>&quot;01&quot;</td><td>自己都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;02&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJNSYMT_TSN}</td><td>&quot;03&quot;</td><td>法人消滅（倒産等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKADOU}</td><td>&quot;04&quot;</td><td>未稼働</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSYJIKO}</td><td>&quot;05&quot;</td><td>不祥事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTENKYSSYMT}</td><td>&quot;06&quot;</td><td>代理店継承による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTENTGSYMT}</td><td>&quot;07&quot;</td><td>代理店統合による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSKHNK_HJN}</td><td>&quot;08&quot;</td><td>組織変更（法人化等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUDOKURITU}</td><td>&quot;09&quot;</td><td>募集人独立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKHKNHNK}</td><td>&quot;10&quot;</td><td>所属保険会社変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKDRTENHNK}</td><td>&quot;11&quot;</td><td>所属代理店変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_DrtensymtjiyuuKbn extends Classification<C_DrtensymtjiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtensymtjiyuuKbn BLNK = new C_DrtensymtjiyuuKbn("00");

    public static final C_DrtensymtjiyuuKbn JIKOTUGOU = new C_DrtensymtjiyuuKbn("01");

    public static final C_DrtensymtjiyuuKbn SIBOU = new C_DrtensymtjiyuuKbn("02");

    public static final C_DrtensymtjiyuuKbn HJNSYMT_TSN = new C_DrtensymtjiyuuKbn("03");

    public static final C_DrtensymtjiyuuKbn MIKADOU = new C_DrtensymtjiyuuKbn("04");

    public static final C_DrtensymtjiyuuKbn HSYJIKO = new C_DrtensymtjiyuuKbn("05");

    public static final C_DrtensymtjiyuuKbn DRTENKYSSYMT = new C_DrtensymtjiyuuKbn("06");

    public static final C_DrtensymtjiyuuKbn DRTENTGSYMT = new C_DrtensymtjiyuuKbn("07");

    public static final C_DrtensymtjiyuuKbn SSKHNK_HJN = new C_DrtensymtjiyuuKbn("08");

    public static final C_DrtensymtjiyuuKbn BOSYUUDOKURITU = new C_DrtensymtjiyuuKbn("09");

    public static final C_DrtensymtjiyuuKbn SYZKHKNHNK = new C_DrtensymtjiyuuKbn("10");

    public static final C_DrtensymtjiyuuKbn SYZKDRTENHNK = new C_DrtensymtjiyuuKbn("11");

    public static final C_DrtensymtjiyuuKbn SONOTA = new C_DrtensymtjiyuuKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIKOTUGOU, "JIKOTUGOU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, HJNSYMT_TSN, "HJNSYMT_TSN", false);
        addPattern(PATTERN_DEFAULT, MIKADOU, "MIKADOU", false);
        addPattern(PATTERN_DEFAULT, HSYJIKO, "HSYJIKO", false);
        addPattern(PATTERN_DEFAULT, DRTENKYSSYMT, "DRTENKYSSYMT", false);
        addPattern(PATTERN_DEFAULT, DRTENTGSYMT, "DRTENTGSYMT", false);
        addPattern(PATTERN_DEFAULT, SSKHNK_HJN, "SSKHNK_HJN", false);
        addPattern(PATTERN_DEFAULT, BOSYUUDOKURITU, "BOSYUUDOKURITU", false);
        addPattern(PATTERN_DEFAULT, SYZKHKNHNK, "SYZKHKNHNK", false);
        addPattern(PATTERN_DEFAULT, SYZKDRTENHNK, "SYZKDRTENHNK", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_DrtensymtjiyuuKbn.class);
    }

    private C_DrtensymtjiyuuKbn(String value) {
        super(value);
    }

    public static C_DrtensymtjiyuuKbn valueOf(String value) {
        return valueOf(C_DrtensymtjiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtensymtjiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtensymtjiyuuKbn.class, patternId, value);
    }
}
