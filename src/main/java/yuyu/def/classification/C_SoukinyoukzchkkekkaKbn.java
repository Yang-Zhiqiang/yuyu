
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送金用口座正当性チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SoukinyoukzchkkekkaKbn</td><td colspan="3">送金用口座正当性チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUMASTERSONZAI}</td><td>&quot;1&quot;</td><td>銀行マスタ存在チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUYUUKOUHANTEI}</td><td>&quot;2&quot;</td><td>銀行有効判定チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYOGINKOUSOUKINKAHI}</td><td>&quot;3&quot;</td><td>ゆうちょ銀行送金可否（国内為替制度加盟）チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAKOUZASOUKINKAHI}</td><td>&quot;4&quot;</td><td>外貨口座送金可否エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAMEIGININ}</td><td>&quot;5&quot;</td><td>口座名義人チェックエラー</td></tr>
 * </table>
 */
public class C_SoukinyoukzchkkekkaKbn extends Classification<C_SoukinyoukzchkkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SoukinyoukzchkkekkaKbn BLNK = new C_SoukinyoukzchkkekkaKbn("0");

    public static final C_SoukinyoukzchkkekkaKbn GINKOUMASTERSONZAI = new C_SoukinyoukzchkkekkaKbn("1");

    public static final C_SoukinyoukzchkkekkaKbn GINKOUYUUKOUHANTEI = new C_SoukinyoukzchkkekkaKbn("2");

    public static final C_SoukinyoukzchkkekkaKbn YUUTYOGINKOUSOUKINKAHI = new C_SoukinyoukzchkkekkaKbn("3");

    public static final C_SoukinyoukzchkkekkaKbn GAIKAKOUZASOUKINKAHI = new C_SoukinyoukzchkkekkaKbn("4");

    public static final C_SoukinyoukzchkkekkaKbn KOUZAMEIGININ = new C_SoukinyoukzchkkekkaKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GINKOUMASTERSONZAI, "GINKOUMASTERSONZAI", false);
        addPattern(PATTERN_DEFAULT, GINKOUYUUKOUHANTEI, "GINKOUYUUKOUHANTEI", false);
        addPattern(PATTERN_DEFAULT, YUUTYOGINKOUSOUKINKAHI, "YUUTYOGINKOUSOUKINKAHI", false);
        addPattern(PATTERN_DEFAULT, GAIKAKOUZASOUKINKAHI, "GAIKAKOUZASOUKINKAHI", false);
        addPattern(PATTERN_DEFAULT, KOUZAMEIGININ, "KOUZAMEIGININ", false);


        lock(C_SoukinyoukzchkkekkaKbn.class);
    }

    private C_SoukinyoukzchkkekkaKbn(String value) {
        super(value);
    }

    public static C_SoukinyoukzchkkekkaKbn valueOf(String value) {
        return valueOf(C_SoukinyoukzchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SoukinyoukzchkkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SoukinyoukzchkkekkaKbn.class, patternId, value);
    }
}
