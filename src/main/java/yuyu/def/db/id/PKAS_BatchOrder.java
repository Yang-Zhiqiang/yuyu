package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.mapping.GenAS_BatchOrder;
import yuyu.def.db.meta.GenQAS_BatchOrder;
import yuyu.def.db.meta.QAS_BatchOrder;

/**
 * バッチ予約テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_BatchOrder}</td><td colspan="3">バッチ予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouId</td><td>機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>orderStatus</td><td>予約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_OrderStatusuKbn C_OrderStatusuKbn}</td></tr>
 *  <tr><td>orderTime</td><td>予約時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_BatchOrder
 * @see     GenAS_BatchOrder
 * @see     QAS_BatchOrder
 * @see     GenQAS_BatchOrder
 */
public class PKAS_BatchOrder extends AbstractExDBPrimaryKey<AS_BatchOrder, PKAS_BatchOrder> {

    private static final long serialVersionUID = 1L;

    public PKAS_BatchOrder() {
    }

    public PKAS_BatchOrder(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

    @Transient
    @Override
    public Class<AS_BatchOrder> getEntityClass() {
        return AS_BatchOrder.class;
    }

    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

}