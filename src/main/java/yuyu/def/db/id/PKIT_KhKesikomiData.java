package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.mapping.GenIT_KhKesikomiData;
import yuyu.def.db.meta.GenQIT_KhKesikomiData;
import yuyu.def.db.meta.QIT_KhKesikomiData;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 消込データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhKesikomiData}</td><td colspan="3">消込データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyuukinkakusyouno nyuukinkakusyouno}</td><td>入金確証番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyknaiyoukbn</td><td>入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyknaiyouKbn C_NyknaiyouKbn}</td></tr>
 *  <tr><td>nyuuryokukbn</td><td>入力区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuuryokuKbn C_NyuuryokuKbn}</td></tr>
 *  <tr><td>nykkeiro</td><td>入金経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nykkeiro C_Nykkeiro}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>nyuukinkakusyounrkymd</td><td>入金確証入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rsgaku</td><td>領収金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nykdenymd</td><td>入金伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyuukinkakusyounrkno</td><td>入金確証入力番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taisyakukbn</td><td>貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyakuKbn C_TaisyakuKbn}</td></tr>
 *  <tr><td>suitono</td><td>出納番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>suitoubumoncd</td><td>出納部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>karikanjyono</td><td>仮勘定番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaebankcd</td><td>口座振替銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmyousinkkbn</td><td>振込用紙入金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn C_KrkPayEasyHrkmyousiNkKbn}</td></tr>
 *  <tr><td>suitososhikicd</td><td>出納組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardhrkskmkbn</td><td>クレ払消込区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditcardHrKskmKbn C_CreditcardHrKskmKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 * </table>
 * @see     IT_KhKesikomiData
 * @see     GenIT_KhKesikomiData
 * @see     QIT_KhKesikomiData
 * @see     GenQIT_KhKesikomiData
 */
public class PKIT_KhKesikomiData extends AbstractExDBPrimaryKey<IT_KhKesikomiData, PKIT_KhKesikomiData> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhKesikomiData() {
    }

    public PKIT_KhKesikomiData(
        String pKbnkey,
        String pNyuukinkakusyouno,
        String pSyono
    ) {
        kbnkey = pKbnkey;
        nyuukinkakusyouno = pNyuukinkakusyouno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_KhKesikomiData> getEntityClass() {
        return IT_KhKesikomiData.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String nyuukinkakusyouno;

    public String getNyuukinkakusyouno() {
        return nyuukinkakusyouno;
    }

    public void setNyuukinkakusyouno(String pNyuukinkakusyouno) {
        nyuukinkakusyouno = pNyuukinkakusyouno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}