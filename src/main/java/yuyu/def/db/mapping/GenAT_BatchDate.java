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
import yuyu.def.db.entity.AT_BatchDate;
import yuyu.def.db.id.PKAT_BatchDate;
import yuyu.def.db.meta.GenQAT_BatchDate;
import yuyu.def.db.meta.QAT_BatchDate;

/**
 * バッチ日付テーブル テーブルのマッピング情報クラスで、 {@link AT_BatchDate} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_BatchDate}</td><td colspan="3">バッチ日付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBatchExecDate batchExecDate}</td><td>バッチ実行日</td><td align="center">{@link PKAT_BatchDate ○}</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     AT_BatchDate
 * @see     PKAT_BatchDate
 * @see     QAT_BatchDate
 * @see     GenQAT_BatchDate
 */
@MappedSuperclass
@Table(name=GenAT_BatchDate.TABLE_NAME)
@IdClass(value=PKAT_BatchDate.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAT_BatchDate extends AbstractExDBEntity<AT_BatchDate, PKAT_BatchDate> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_BatchDate";
    public static final String BATCHEXECDATE            = "batchExecDate";

    private final PKAT_BatchDate primaryKey;

    public GenAT_BatchDate() {
        primaryKey = new PKAT_BatchDate();
    }

    public GenAT_BatchDate(BizDate pBatchExecDate) {
        primaryKey = new PKAT_BatchDate(pBatchExecDate);
    }

    @Transient
    @Override
    public PKAT_BatchDate getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_BatchDate> getMetaClass() {
        return QAT_BatchDate.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenAT_BatchDate.BATCHEXECDATE)
    @ValidDate
    public BizDate getBatchExecDate() {
        return getPrimaryKey().getBatchExecDate();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBatchExecDate(BizDate pBatchExecDate) {
        getPrimaryKey().setBatchExecDate(pBatchExecDate);
    }
}
