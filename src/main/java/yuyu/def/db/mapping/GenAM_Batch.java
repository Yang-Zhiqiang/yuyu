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
import yuyu.def.classification.C_BatchHeisouKbn;
import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.id.PKAM_Batch;
import yuyu.def.db.meta.GenQAM_Batch;
import yuyu.def.db.meta.QAM_Batch;
import yuyu.def.db.type.UserType_C_BatchHeisouKbn;
import yuyu.def.db.type.UserType_C_BatchModeKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * バッチマスタ テーブルのマッピング情報クラスで、 {@link AM_Batch} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_Batch}</td><td colspan="3">バッチマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAM_Batch ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchClass batchClass}</td><td>バッチクラス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getParamBeanClass paramBeanClass}</td><td>パラメータビーンクラス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTajuukidouKahiKbn tajuukidouKahiKbn}</td><td>多重起動可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getBatchMode batchMode}</td><td>バッチ起動モード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchModeKbn}</td></tr>
 *  <tr><td>{@link #getTyuudanKahi tyuudanKahi}</td><td>中断可否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getOnlineHeisouKahiKbn onlineHeisouKahiKbn}</td><td>オンライン並走可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getBatchHeisouKbn batchHeisouKbn}</td><td>バッチ並走区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchHeisouKbn}</td></tr>
 * </table>
 * @see     AM_Batch
 * @see     PKAM_Batch
 * @see     QAM_Batch
 * @see     GenQAM_Batch
 */
@MappedSuperclass
@Table(name=GenAM_Batch.TABLE_NAME)
@IdClass(value=PKAM_Batch.class)
@TypeDefs({
    @TypeDef(name="UserType_C_BatchHeisouKbn", typeClass=UserType_C_BatchHeisouKbn.class),
    @TypeDef(name="UserType_C_BatchModeKbn", typeClass=UserType_C_BatchModeKbn.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class)
})
public abstract class GenAM_Batch extends AbstractExDBEntity<AM_Batch, PKAM_Batch> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_Batch";
    public static final String KINOUID                  = "kinouId";
    public static final String BATCHCLASS               = "batchClass";
    public static final String PARAMBEANCLASS           = "paramBeanClass";
    public static final String TAJUUKIDOUKAHIKBN        = "tajuukidouKahiKbn";
    public static final String BATCHMODE                = "batchMode";
    public static final String TYUUDANKAHI              = "tyuudanKahi";
    public static final String ONLINEHEISOUKAHIKBN      = "onlineHeisouKahiKbn";
    public static final String BATCHHEISOUKBN           = "batchHeisouKbn";

    private final PKAM_Batch primaryKey;

    public GenAM_Batch() {
        primaryKey = new PKAM_Batch();
    }

    public GenAM_Batch(String pKinouId) {
        primaryKey = new PKAM_Batch(pKinouId);
    }

    @Transient
    @Override
    public PKAM_Batch getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_Batch> getMetaClass() {
        return QAM_Batch.class;
    }

    @Id
    @Column(name=GenAM_Batch.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private String batchClass;

    @Column(name=GenAM_Batch.BATCHCLASS)
    public String getBatchClass() {
        return batchClass;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchClass(String pBatchClass) {
        batchClass = pBatchClass;
    }

    private String paramBeanClass;

    @Column(name=GenAM_Batch.PARAMBEANCLASS)
    public String getParamBeanClass() {
        return paramBeanClass;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setParamBeanClass(String pParamBeanClass) {
        paramBeanClass = pParamBeanClass;
    }

    private C_KahiKbn tajuukidouKahiKbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenAM_Batch.TAJUUKIDOUKAHIKBN)
    public C_KahiKbn getTajuukidouKahiKbn() {
        return tajuukidouKahiKbn;
    }

    public void setTajuukidouKahiKbn(C_KahiKbn pTajuukidouKahiKbn) {
        tajuukidouKahiKbn = pTajuukidouKahiKbn;
    }

    private C_BatchModeKbn batchMode;

    @Type(type="UserType_C_BatchModeKbn")
    @Column(name=GenAM_Batch.BATCHMODE)
    public C_BatchModeKbn getBatchMode() {
        return batchMode;
    }

    public void setBatchMode(C_BatchModeKbn pBatchMode) {
        batchMode = pBatchMode;
    }

    private C_KahiKbn tyuudanKahi;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenAM_Batch.TYUUDANKAHI)
    public C_KahiKbn getTyuudanKahi() {
        return tyuudanKahi;
    }

    public void setTyuudanKahi(C_KahiKbn pTyuudanKahi) {
        tyuudanKahi = pTyuudanKahi;
    }

    private C_KahiKbn onlineHeisouKahiKbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenAM_Batch.ONLINEHEISOUKAHIKBN)
    public C_KahiKbn getOnlineHeisouKahiKbn() {
        return onlineHeisouKahiKbn;
    }

    public void setOnlineHeisouKahiKbn(C_KahiKbn pOnlineHeisouKahiKbn) {
        onlineHeisouKahiKbn = pOnlineHeisouKahiKbn;
    }

    private C_BatchHeisouKbn batchHeisouKbn;

    @Type(type="UserType_C_BatchHeisouKbn")
    @Column(name=GenAM_Batch.BATCHHEISOUKBN)
    public C_BatchHeisouKbn getBatchHeisouKbn() {
        return batchHeisouKbn;
    }

    public void setBatchHeisouKbn(C_BatchHeisouKbn pBatchHeisouKbn) {
        batchHeisouKbn = pBatchHeisouKbn;
    }
}
