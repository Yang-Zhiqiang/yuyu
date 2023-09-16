package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.mapping.GenHT_BosKouzaJyouhou;
import yuyu.def.db.meta.GenQHT_BosKouzaJyouhou;
import yuyu.def.db.meta.QHT_BosKouzaJyouhou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集口座情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKouzaJyouhou}</td><td colspan="3">募集口座情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouzakakuniniraikbn</td><td>口座確認依頼区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>kzhuritourokuhoukbn</td><td>口座振替登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzhuritourokuhouKbn C_KzhuritourokuhouKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKouzaJyouhou
 * @see     GenHT_BosKouzaJyouhou
 * @see     QHT_BosKouzaJyouhou
 * @see     GenQHT_BosKouzaJyouhou
 */
public class PKHT_BosKouzaJyouhou extends AbstractExDBPrimaryKey<HT_BosKouzaJyouhou, PKHT_BosKouzaJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosKouzaJyouhou() {
    }

    public PKHT_BosKouzaJyouhou(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_BosKouzaJyouhou> getEntityClass() {
        return HT_BosKouzaJyouhou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}