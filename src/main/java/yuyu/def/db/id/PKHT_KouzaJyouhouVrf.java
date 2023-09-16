package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_KouzaJyouhouVrf;
import yuyu.def.db.mapping.GenHT_KouzaJyouhouVrf;
import yuyu.def.db.meta.GenQHT_KouzaJyouhouVrf;
import yuyu.def.db.meta.QHT_KouzaJyouhouVrf;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 口座情報ベリファイテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KouzaJyouhouVrf}</td><td colspan="3">口座情報ベリファイテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinkeizkkbn</td><td>新規継続区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinkeizkKbn C_SinkeizkKbn}</td></tr>
 *  <tr><td>hbcmnt</td><td>不備コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuudaikocd</td><td>収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syuudaikocd C_Syuudaikocd}</td></tr>
 *  <tr><td>kouzakakuniniraikbn</td><td>口座確認依頼区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>kouzakakuniniraiymd</td><td>口座確認依頼日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouzajyouhounyuuryokuymd</td><td>口座情報入力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kzhuritourokuhoukbn</td><td>口座振替登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzhuritourokuhouKbn C_KzhuritourokuhouKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KouzaJyouhouVrf
 * @see     GenHT_KouzaJyouhouVrf
 * @see     QHT_KouzaJyouhouVrf
 * @see     GenQHT_KouzaJyouhouVrf
 */
public class PKHT_KouzaJyouhouVrf extends AbstractExDBPrimaryKey<HT_KouzaJyouhouVrf, PKHT_KouzaJyouhouVrf> {

    private static final long serialVersionUID = 1L;

    public PKHT_KouzaJyouhouVrf() {
    }

    public PKHT_KouzaJyouhouVrf(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_KouzaJyouhouVrf> getEntityClass() {
        return HT_KouzaJyouhouVrf.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}