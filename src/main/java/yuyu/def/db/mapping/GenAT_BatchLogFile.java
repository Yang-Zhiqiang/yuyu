package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_BatchLogFile;
import yuyu.def.db.id.PKAT_BatchLogFile;
import yuyu.def.db.meta.GenQAT_BatchLogFile;
import yuyu.def.db.meta.QAT_BatchLogFile;

/**
 * バッチログファイルテーブル テーブルのマッピング情報クラスで、 {@link AT_BatchLogFile} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchLogFile}</td><td colspan="3">バッチログファイルテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchJobId batchJobId}</td><td>バッチジョブＩＤ</td><td align="center">{@link PKAT_BatchLogFile ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_BatchLogFile ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchSyoriYmd batchSyoriYmd}</td><td>バッチ処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchLogFile
 * @see     PKAT_BatchLogFile
 * @see     QAT_BatchLogFile
 * @see     GenQAT_BatchLogFile
 */
@MappedSuperclass
@Table(name=GenAT_BatchLogFile.TABLE_NAME)
@IdClass(value=PKAT_BatchLogFile.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAT_BatchLogFile extends AbstractExDBEntity<AT_BatchLogFile, PKAT_BatchLogFile> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_BatchLogFile";
    public static final String BATCHJOBID               = "batchJobId";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String BATCHSYORIYMD            = "batchSyoriYmd";

    private final PKAT_BatchLogFile primaryKey;

    public GenAT_BatchLogFile() {
        primaryKey = new PKAT_BatchLogFile();
    }

    public GenAT_BatchLogFile(String pBatchJobId, String pUniqueId) {
        primaryKey = new PKAT_BatchLogFile(pBatchJobId, pUniqueId);
    }

    @Transient
    @Override
    public PKAT_BatchLogFile getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_BatchLogFile> getMetaClass() {
        return QAT_BatchLogFile.class;
    }

    @Id
    @Column(name=GenAT_BatchLogFile.BATCHJOBID)
    public String getBatchJobId() {
        return getPrimaryKey().getBatchJobId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchJobId(String pBatchJobId) {
        getPrimaryKey().setBatchJobId(pBatchJobId);
    }

    @Id
    @Column(name=GenAT_BatchLogFile.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private BizDate batchSyoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_BatchLogFile.BATCHSYORIYMD)
    @ValidDate
    public BizDate getBatchSyoriYmd() {
        return batchSyoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchSyoriYmd(BizDate pBatchSyoriYmd) {
        batchSyoriYmd = pBatchSyoriYmd;
    }
}
