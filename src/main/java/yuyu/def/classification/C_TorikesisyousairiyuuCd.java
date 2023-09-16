
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取消詳細理由コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TorikesisyousairiyuuCd</td><td colspan="3">取消詳細理由コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUHINNAIYOU}</td><td>&quot;21&quot;</td><td>商品内容を再検討したい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUHANTAI}</td><td>&quot;22&quot;</td><td>家族からの反対</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYAHOKEN}</td><td>&quot;23&quot;</td><td>他社の保険に加入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKIN}</td><td>&quot;24&quot;</td><td>資金が必要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_MADOHAN}</td><td>&quot;25&quot;</td><td>その他（窓販）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI_MADOHAN}</td><td>&quot;99&quot;</td><td>理由不明（窓販）</td></tr>
 * </table>
 */
public class C_TorikesisyousairiyuuCd extends Classification<C_TorikesisyousairiyuuCd> {

    private static final long serialVersionUID = 1L;


    public static final C_TorikesisyousairiyuuCd BLNK = new C_TorikesisyousairiyuuCd("0");

    public static final C_TorikesisyousairiyuuCd SYOUHINNAIYOU = new C_TorikesisyousairiyuuCd("21");

    public static final C_TorikesisyousairiyuuCd KAZOKUHANTAI = new C_TorikesisyousairiyuuCd("22");

    public static final C_TorikesisyousairiyuuCd TASYAHOKEN = new C_TorikesisyousairiyuuCd("23");

    public static final C_TorikesisyousairiyuuCd SIKIN = new C_TorikesisyousairiyuuCd("24");

    public static final C_TorikesisyousairiyuuCd SONOTA_MADOHAN = new C_TorikesisyousairiyuuCd("25");

    public static final C_TorikesisyousairiyuuCd HUMEI_MADOHAN = new C_TorikesisyousairiyuuCd("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUHINNAIYOU, "SYOUHINNAIYOU", false);
        addPattern(PATTERN_DEFAULT, KAZOKUHANTAI, "KAZOKUHANTAI", false);
        addPattern(PATTERN_DEFAULT, TASYAHOKEN, "TASYAHOKEN", false);
        addPattern(PATTERN_DEFAULT, SIKIN, "SIKIN", false);
        addPattern(PATTERN_DEFAULT, SONOTA_MADOHAN, "SONOTA_MADOHAN", false);
        addPattern(PATTERN_DEFAULT, HUMEI_MADOHAN, "HUMEI_MADOHAN", false);


        lock(C_TorikesisyousairiyuuCd.class);
    }

    private C_TorikesisyousairiyuuCd(String value) {
        super(value);
    }

    public static C_TorikesisyousairiyuuCd valueOf(String value) {
        return valueOf(C_TorikesisyousairiyuuCd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TorikesisyousairiyuuCd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TorikesisyousairiyuuCd.class, patternId, value);
    }
}
