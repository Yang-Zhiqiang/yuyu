package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_MqBatchSosiki;
import yuyu.def.db.id.PKBM_MqBatchSosiki;
import yuyu.def.db.meta.GenQBM_MqBatchSosiki;
import yuyu.def.db.meta.QBM_MqBatchSosiki;

/**
 * ＭＱ用バッチ処理担当組織マスタ テーブルのマッピング情報クラスで、 {@link BM_MqBatchSosiki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_MqBatchSosiki}</td><td colspan="3">ＭＱ用バッチ処理担当組織マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKBM_MqBatchSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_MqBatchSosiki
 * @see     PKBM_MqBatchSosiki
 * @see     QBM_MqBatchSosiki
 * @see     GenQBM_MqBatchSosiki
 */
@MappedSuperclass
@Table(name=GenBM_MqBatchSosiki.TABLE_NAME)
@IdClass(value=PKBM_MqBatchSosiki.class)
public abstract class GenBM_MqBatchSosiki extends AbstractExDBEntity<BM_MqBatchSosiki, PKBM_MqBatchSosiki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_MqBatchSosiki";
    public static final String KINOUID                  = "kinouId";
    public static final String SOSIKICD                 = "sosikicd";

    private final PKBM_MqBatchSosiki primaryKey;

    public GenBM_MqBatchSosiki() {
        primaryKey = new PKBM_MqBatchSosiki();
    }

    public GenBM_MqBatchSosiki(String pKinouId) {
        primaryKey = new PKBM_MqBatchSosiki(pKinouId);
    }

    @Transient
    @Override
    public PKBM_MqBatchSosiki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_MqBatchSosiki> getMetaClass() {
        return QBM_MqBatchSosiki.class;
    }

    @Id
    @Column(name=GenBM_MqBatchSosiki.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private String sosikicd;

    @Column(name=GenBM_MqBatchSosiki.SOSIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSosikicd() {
        return sosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSosikicd(String pSosikicd) {
        sosikicd = pSosikicd;
    }
}
