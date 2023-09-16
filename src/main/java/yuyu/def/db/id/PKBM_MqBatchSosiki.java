package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_MqBatchSosiki;
import yuyu.def.db.mapping.GenBM_MqBatchSosiki;
import yuyu.def.db.meta.GenQBM_MqBatchSosiki;
import yuyu.def.db.meta.QBM_MqBatchSosiki;

/**
 * ＭＱ用バッチ処理担当組織マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_MqBatchSosiki}</td><td colspan="3">ＭＱ用バッチ処理担当組織マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikicd</td><td>組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_MqBatchSosiki
 * @see     GenBM_MqBatchSosiki
 * @see     QBM_MqBatchSosiki
 * @see     GenQBM_MqBatchSosiki
 */
public class PKBM_MqBatchSosiki extends AbstractExDBPrimaryKey<BM_MqBatchSosiki, PKBM_MqBatchSosiki> {

    private static final long serialVersionUID = 1L;

    public PKBM_MqBatchSosiki() {
    }

    public PKBM_MqBatchSosiki(String pKinouId) {
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<BM_MqBatchSosiki> getEntityClass() {
        return BM_MqBatchSosiki.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}