
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syorijk</td><td colspan="3">処理状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDETAIOUTYUU}</td><td>&quot;00&quot;</td><td>申出対応中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIKANRYOU}</td><td>&quot;90&quot;</td><td>処理完了</td></tr>
 * </table>
 */
public class C_Syorijk extends Classification<C_Syorijk> {

    private static final long serialVersionUID = 1L;


    public static final C_Syorijk BLNK = new C_Syorijk("0");

    public static final C_Syorijk MOUSIDETAIOUTYUU = new C_Syorijk("00");

    public static final C_Syorijk SYORIKANRYOU = new C_Syorijk("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOUSIDETAIOUTYUU, "MOUSIDETAIOUTYUU", false);
        addPattern(PATTERN_DEFAULT, SYORIKANRYOU, "SYORIKANRYOU", false);


        lock(C_Syorijk.class);
    }

    private C_Syorijk(String value) {
        super(value);
    }

    public static C_Syorijk valueOf(String value) {
        return valueOf(C_Syorijk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syorijk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syorijk.class, patternId, value);
    }
}
