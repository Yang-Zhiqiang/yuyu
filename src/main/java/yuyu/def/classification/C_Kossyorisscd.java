
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新処理詳細コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kossyorisscd</td><td colspan="3">更新処理詳細コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TYOUSAKAISYOU_SBSH}</td><td>&quot;tyousakaisyou_sbsh&quot;</td><td>（死亡）調査解消</td></tr>
 * </table>
 */
public class C_Kossyorisscd extends Classification<C_Kossyorisscd> {

    private static final long serialVersionUID = 1L;


    public static final C_Kossyorisscd TYOUSAKAISYOU_SBSH = new C_Kossyorisscd("tyousakaisyou_sbsh");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TYOUSAKAISYOU_SBSH, "TYOUSAKAISYOU_SBSH", true);


        lock(C_Kossyorisscd.class);
    }

    private C_Kossyorisscd(String value) {
        super(value);
    }

    public static C_Kossyorisscd valueOf(String value) {
        return valueOf(C_Kossyorisscd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kossyorisscd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kossyorisscd.class, patternId, value);
    }
}
