
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 緊急停止フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kinkyuuteisiflag</td><td colspan="3">緊急停止フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KADOU}</td><td>&quot;0&quot;</td><td>通常稼動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;1&quot;</td><td>緊急停止中</td></tr>
 * </table>
 */
public class C_Kinkyuuteisiflag extends Classification<C_Kinkyuuteisiflag> {

    private static final long serialVersionUID = 1L;


    public static final C_Kinkyuuteisiflag KADOU = new C_Kinkyuuteisiflag("0");

    public static final C_Kinkyuuteisiflag TEISI = new C_Kinkyuuteisiflag("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KADOU, "KADOU", true);
        addPattern(PATTERN_DEFAULT, TEISI, "TEISI", false);


        lock(C_Kinkyuuteisiflag.class);
    }

    private C_Kinkyuuteisiflag(String value) {
        super(value);
    }

    public static C_Kinkyuuteisiflag valueOf(String value) {
        return valueOf(C_Kinkyuuteisiflag.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kinkyuuteisiflag.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kinkyuuteisiflag.class, patternId, value);
    }
}
