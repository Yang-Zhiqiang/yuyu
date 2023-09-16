
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金給付金書類作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SiSyoruisakuseiKbn</td><td colspan="3">保険金給付金書類作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB_HOKEN_SKS}</td><td>&quot;11&quot;</td><td>死亡保険金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANKINHRKM_IRAIS}</td><td>&quot;12&quot;</td><td>精算金振込依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB_DAIHYOU}</td><td>&quot;13&quot;</td><td>代表選任届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KD_JIKOJKS}</td><td>&quot;14&quot;</td><td>事故状況報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_SYOTOKU}</td><td>&quot;21&quot;</td><td>マイナンバー帳票（所得税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_SOUZOKU}</td><td>&quot;22&quot;</td><td>マイナンバー帳票（相続税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_ZOUYO}</td><td>&quot;23&quot;</td><td>マイナンバー帳票（贈与税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_HUKUSUU}</td><td>&quot;24&quot;</td><td>マイナンバー帳票（受取人複数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_MENSEKI}</td><td>&quot;25&quot;</td><td>マイナンバー帳票（免責）</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SB SB}<br />(死亡)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB_HOKEN_SKS}</td><td>&quot;11&quot;</td><td>死亡保険金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANKINHRKM_IRAIS}</td><td>&quot;12&quot;</td><td>精算金振込依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB_DAIHYOU}</td><td>&quot;13&quot;</td><td>代表選任届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KD_JIKOJKS}</td><td>&quot;14&quot;</td><td>事故状況報告書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_SYOTOKU}</td><td>&quot;21&quot;</td><td>マイナンバー帳票（所得税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_SOUZOKU}</td><td>&quot;22&quot;</td><td>マイナンバー帳票（相続税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_ZOUYO}</td><td>&quot;23&quot;</td><td>マイナンバー帳票（贈与税）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_HUKUSUU}</td><td>&quot;24&quot;</td><td>マイナンバー帳票（受取人複数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MYNUMBER_CHYOU_MENSEKI}</td><td>&quot;25&quot;</td><td>マイナンバー帳票（免責）</td></tr>
 * </table>
 */
public class C_SiSyoruisakuseiKbn extends Classification<C_SiSyoruisakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SiSyoruisakuseiKbn BLNK = new C_SiSyoruisakuseiKbn("0");

    public static final C_SiSyoruisakuseiKbn SB_HOKEN_SKS = new C_SiSyoruisakuseiKbn("11");

    public static final C_SiSyoruisakuseiKbn SEISANKINHRKM_IRAIS = new C_SiSyoruisakuseiKbn("12");

    public static final C_SiSyoruisakuseiKbn SB_DAIHYOU = new C_SiSyoruisakuseiKbn("13");

    public static final C_SiSyoruisakuseiKbn KD_JIKOJKS = new C_SiSyoruisakuseiKbn("14");

    public static final C_SiSyoruisakuseiKbn MYNUMBER_CHYOU_SYOTOKU = new C_SiSyoruisakuseiKbn("21");

    public static final C_SiSyoruisakuseiKbn MYNUMBER_CHYOU_SOUZOKU = new C_SiSyoruisakuseiKbn("22");

    public static final C_SiSyoruisakuseiKbn MYNUMBER_CHYOU_ZOUYO = new C_SiSyoruisakuseiKbn("23");

    public static final C_SiSyoruisakuseiKbn MYNUMBER_CHYOU_HUKUSUU = new C_SiSyoruisakuseiKbn("24");

    public static final C_SiSyoruisakuseiKbn MYNUMBER_CHYOU_MENSEKI = new C_SiSyoruisakuseiKbn("25");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SB = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SB_HOKEN_SKS, "SB_HOKEN_SKS", false);
        addPattern(PATTERN_DEFAULT, SEISANKINHRKM_IRAIS, "SEISANKINHRKM_IRAIS", false);
        addPattern(PATTERN_DEFAULT, SB_DAIHYOU, "SB_DAIHYOU", false);
        addPattern(PATTERN_DEFAULT, KD_JIKOJKS, "KD_JIKOJKS", false);
        addPattern(PATTERN_DEFAULT, MYNUMBER_CHYOU_SYOTOKU, "MYNUMBER_CHYOU_SYOTOKU", false);
        addPattern(PATTERN_DEFAULT, MYNUMBER_CHYOU_SOUZOKU, "MYNUMBER_CHYOU_SOUZOKU", false);
        addPattern(PATTERN_DEFAULT, MYNUMBER_CHYOU_ZOUYO, "MYNUMBER_CHYOU_ZOUYO", false);
        addPattern(PATTERN_DEFAULT, MYNUMBER_CHYOU_HUKUSUU, "MYNUMBER_CHYOU_HUKUSUU", false);
        addPattern(PATTERN_DEFAULT, MYNUMBER_CHYOU_MENSEKI, "MYNUMBER_CHYOU_MENSEKI", false);


        addPattern(PATTERN_SB, BLNK, "BLNK", true);
        addPattern(PATTERN_SB, SB_HOKEN_SKS, "SB_HOKEN_SKS", false);
        addPattern(PATTERN_SB, SEISANKINHRKM_IRAIS, "SEISANKINHRKM_IRAIS", false);
        addPattern(PATTERN_SB, SB_DAIHYOU, "SB_DAIHYOU", false);
        addPattern(PATTERN_SB, KD_JIKOJKS, "KD_JIKOJKS", false);
        addPattern(PATTERN_SB, MYNUMBER_CHYOU_SYOTOKU, "MYNUMBER_CHYOU_SYOTOKU", false);
        addPattern(PATTERN_SB, MYNUMBER_CHYOU_SOUZOKU, "MYNUMBER_CHYOU_SOUZOKU", false);
        addPattern(PATTERN_SB, MYNUMBER_CHYOU_ZOUYO, "MYNUMBER_CHYOU_ZOUYO", false);
        addPattern(PATTERN_SB, MYNUMBER_CHYOU_HUKUSUU, "MYNUMBER_CHYOU_HUKUSUU", false);
        addPattern(PATTERN_SB, MYNUMBER_CHYOU_MENSEKI, "MYNUMBER_CHYOU_MENSEKI", false);


        lock(C_SiSyoruisakuseiKbn.class);
    }

    private C_SiSyoruisakuseiKbn(String value) {
        super(value);
    }

    public static C_SiSyoruisakuseiKbn valueOf(String value) {
        return valueOf(C_SiSyoruisakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SiSyoruisakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SiSyoruisakuseiKbn.class, patternId, value);
    }
}
