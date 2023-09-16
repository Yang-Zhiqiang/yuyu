
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業廃事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GyhjiyuuKbn</td><td colspan="3">業廃事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOTUGOU}</td><td>&quot;01&quot;</td><td>自己都合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;02&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJNSYMT_TSN}</td><td>&quot;03&quot;</td><td>法人消滅（倒産等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKADOU}</td><td>&quot;04&quot;</td><td>未稼働</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSYJIKO}</td><td>&quot;05&quot;</td><td>不祥事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTENKYS}</td><td>&quot;06&quot;</td><td>代理店継承</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;09&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSKHNK_HJN}</td><td>&quot;11&quot;</td><td>組織変更（法人化等）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUDOKURITU}</td><td>&quot;12&quot;</td><td>募集人独立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKHKNHNK}</td><td>&quot;13&quot;</td><td>所属保険会社変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYZKDRTENHNK}</td><td>&quot;14&quot;</td><td>所属代理店変更</td></tr>
 * </table>
 */
public class C_GyhjiyuuKbn extends Classification<C_GyhjiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GyhjiyuuKbn NONE = new C_GyhjiyuuKbn("00");

    public static final C_GyhjiyuuKbn JIKOTUGOU = new C_GyhjiyuuKbn("01");

    public static final C_GyhjiyuuKbn SIBOU = new C_GyhjiyuuKbn("02");

    public static final C_GyhjiyuuKbn HJNSYMT_TSN = new C_GyhjiyuuKbn("03");

    public static final C_GyhjiyuuKbn MIKADOU = new C_GyhjiyuuKbn("04");

    public static final C_GyhjiyuuKbn HSYJIKO = new C_GyhjiyuuKbn("05");

    public static final C_GyhjiyuuKbn DRTENKYS = new C_GyhjiyuuKbn("06");

    public static final C_GyhjiyuuKbn SONOTA = new C_GyhjiyuuKbn("09");

    public static final C_GyhjiyuuKbn SSKHNK_HJN = new C_GyhjiyuuKbn("11");

    public static final C_GyhjiyuuKbn BOSYUUDOKURITU = new C_GyhjiyuuKbn("12");

    public static final C_GyhjiyuuKbn SYZKHKNHNK = new C_GyhjiyuuKbn("13");

    public static final C_GyhjiyuuKbn SYZKDRTENHNK = new C_GyhjiyuuKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, JIKOTUGOU, "JIKOTUGOU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, HJNSYMT_TSN, "HJNSYMT_TSN", false);
        addPattern(PATTERN_DEFAULT, MIKADOU, "MIKADOU", false);
        addPattern(PATTERN_DEFAULT, HSYJIKO, "HSYJIKO", false);
        addPattern(PATTERN_DEFAULT, DRTENKYS, "DRTENKYS", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, SSKHNK_HJN, "SSKHNK_HJN", false);
        addPattern(PATTERN_DEFAULT, BOSYUUDOKURITU, "BOSYUUDOKURITU", false);
        addPattern(PATTERN_DEFAULT, SYZKHKNHNK, "SYZKHKNHNK", false);
        addPattern(PATTERN_DEFAULT, SYZKDRTENHNK, "SYZKDRTENHNK", false);


        lock(C_GyhjiyuuKbn.class);
    }

    private C_GyhjiyuuKbn(String value) {
        super(value);
    }

    public static C_GyhjiyuuKbn valueOf(String value) {
        return valueOf(C_GyhjiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GyhjiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GyhjiyuuKbn.class, patternId, value);
    }
}
