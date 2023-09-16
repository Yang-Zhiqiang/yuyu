
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱ更新取消依頼区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MqkousintrksiraiKbn</td><td colspan="3">ＭＱ更新取消依頼区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MQ_KOUSIN}</td><td>&quot;1&quot;</td><td>ＭＱ更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MQ_TRKSIRAI}</td><td>&quot;2&quot;</td><td>ＭＱ取消依頼</td></tr>
 * </table>
 */
public class C_MqkousintrksiraiKbn extends Classification<C_MqkousintrksiraiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MqkousintrksiraiKbn MQ_KOUSIN = new C_MqkousintrksiraiKbn("1");

    public static final C_MqkousintrksiraiKbn MQ_TRKSIRAI = new C_MqkousintrksiraiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MQ_KOUSIN, "MQ_KOUSIN", true);
        addPattern(PATTERN_DEFAULT, MQ_TRKSIRAI, "MQ_TRKSIRAI", false);


        lock(C_MqkousintrksiraiKbn.class);
    }

    private C_MqkousintrksiraiKbn(String value) {
        super(value);
    }

    public static C_MqkousintrksiraiKbn valueOf(String value) {
        return valueOf(C_MqkousintrksiraiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MqkousintrksiraiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MqkousintrksiraiKbn.class, patternId, value);
    }
}
