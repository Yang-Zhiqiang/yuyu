
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 証券再発行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukensaihkKbn</td><td colspan="3">証券再発行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKENSAIHAKKOU}</td><td>&quot;1&quot;</td><td>証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUSAISAKUSEI}</td><td>&quot;2&quot;</td><td>新契約証券再作成</td></tr>
 * </table>
 */
public class C_SyoukensaihkKbn extends Classification<C_SyoukensaihkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukensaihkKbn BLNK = new C_SyoukensaihkKbn("0");

    public static final C_SyoukensaihkKbn SYOUKENSAIHAKKOU = new C_SyoukensaihkKbn("1");

    public static final C_SyoukensaihkKbn SINKEIYAKUSAISAKUSEI = new C_SyoukensaihkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKENSAIHAKKOU, "SYOUKENSAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUSAISAKUSEI, "SINKEIYAKUSAISAKUSEI", false);


        lock(C_SyoukensaihkKbn.class);
    }

    private C_SyoukensaihkKbn(String value) {
        super(value);
    }

    public static C_SyoukensaihkKbn valueOf(String value) {
        return valueOf(C_SyoukensaihkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukensaihkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukensaihkKbn.class, patternId, value);
    }
}
