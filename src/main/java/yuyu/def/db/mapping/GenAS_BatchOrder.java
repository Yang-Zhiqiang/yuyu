package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_OrderStatusuKbn;
import yuyu.def.db.entity.AS_BatchOrder;
import yuyu.def.db.id.PKAS_BatchOrder;
import yuyu.def.db.meta.GenQAS_BatchOrder;
import yuyu.def.db.meta.QAS_BatchOrder;
import yuyu.def.db.type.UserType_C_OrderStatusuKbn;

/**
 * バッチ予約テーブル テーブルのマッピング情報クラスで、 {@link AS_BatchOrder} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_BatchOrder}</td><td colspan="3">バッチ予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">{@link PKAS_BatchOrder ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOrderStatus orderStatus}</td><td>予約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_OrderStatusuKbn}</td></tr>
 *  <tr><td>{@link #getOrderTime orderTime}</td><td>予約時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_BatchOrder
 * @see     PKAS_BatchOrder
 * @see     QAS_BatchOrder
 * @see     GenQAS_BatchOrder
 */
@MappedSuperclass
@Table(name=GenAS_BatchOrder.TABLE_NAME)
@IdClass(value=PKAS_BatchOrder.class)
@TypeDefs({
    @TypeDef(name="UserType_C_OrderStatusuKbn", typeClass=UserType_C_OrderStatusuKbn.class)
})
public abstract class GenAS_BatchOrder extends AbstractExDBEntity<AS_BatchOrder, PKAS_BatchOrder> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_BatchOrder";
    public static final String BATCHJOBID               = "batchJobId";
    public static final String KINOUID                  = "kinouId";
    public static final String ORDERSTATUS              = "orderStatus";
    public static final String ORDERTIME                = "orderTime";

    private final PKAS_BatchOrder primaryKey;

    public GenAS_BatchOrder() {
        primaryKey = new PKAS_BatchOrder();
    }

    public GenAS_BatchOrder(String pBatchJobId) {
        primaryKey = new PKAS_BatchOrder(pBatchJobId);
    }

    @Transient
    @Override
    public PKAS_BatchOrder getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_BatchOrder> getMetaClass() {
        return QAS_BatchOrder.class;
    }

    @Id
    @Column(name=GenAS_BatchOrder.BATCHJOBID)
    public String getBatchJobId() {
        return getPrimaryKey().getBatchJobId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchJobId(String pBatchJobId) {
        getPrimaryKey().setBatchJobId(pBatchJobId);
    }

    private String kinouId;

    @Column(name=GenAS_BatchOrder.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private C_OrderStatusuKbn orderStatus;

    @Type(type="UserType_C_OrderStatusuKbn")
    @Column(name=GenAS_BatchOrder.ORDERSTATUS)
    public C_OrderStatusuKbn getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(C_OrderStatusuKbn pOrderStatus) {
        orderStatus = pOrderStatus;
    }

    private String orderTime;

    @Column(name=GenAS_BatchOrder.ORDERTIME)
    public String getOrderTime() {
        return orderTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOrderTime(String pOrderTime) {
        orderTime = pOrderTime;
    }
}
