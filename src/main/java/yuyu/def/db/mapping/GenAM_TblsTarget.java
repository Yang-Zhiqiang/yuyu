package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.AM_TblsTarget;
import yuyu.def.db.id.PKAM_TblsTarget;
import yuyu.def.db.meta.GenQAM_TblsTarget;
import yuyu.def.db.meta.QAM_TblsTarget;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * テーブル照会対象マスタ テーブルのマッピング情報クラスで、 {@link AM_TblsTarget} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsTarget}</td><td colspan="3">テーブル照会対象マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">{@link PKAM_TblsTarget ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBaseTableNm baseTableNm}</td><td>（ベース）テーブル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_TblsTarget
 * @see     PKAM_TblsTarget
 * @see     QAM_TblsTarget
 * @see     GenQAM_TblsTarget
 */
@MappedSuperclass
@Table(name=GenAM_TblsTarget.TABLE_NAME)
@IdClass(value=PKAM_TblsTarget.class)
public abstract class GenAM_TblsTarget extends AbstractExDBEntity<AM_TblsTarget, PKAM_TblsTarget> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_TblsTarget";
    public static final String BASETABLEID              = "baseTableId";
    public static final String BASETABLENM              = "baseTableNm";
    public static final String SUBSYSTEMID              = "subSystemId";

    private final PKAM_TblsTarget primaryKey;

    public GenAM_TblsTarget() {
        primaryKey = new PKAM_TblsTarget();
    }

    public GenAM_TblsTarget(String pBaseTableId) {
        primaryKey = new PKAM_TblsTarget(pBaseTableId);
    }

    @Transient
    @Override
    public PKAM_TblsTarget getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_TblsTarget> getMetaClass() {
        return QAM_TblsTarget.class;
    }

    @Id
    @Column(name=GenAM_TblsTarget.BASETABLEID)
    @SingleByteStrings
    public String getBaseTableId() {
        return getPrimaryKey().getBaseTableId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseTableId(String pBaseTableId) {
        getPrimaryKey().setBaseTableId(pBaseTableId);
    }

    private String baseTableNm;

    @Column(name=GenAM_TblsTarget.BASETABLENM)
    @InvalidCharacter
    public String getBaseTableNm() {
        return baseTableNm;
    }

    @Trim("both")
    public void setBaseTableNm(String pBaseTableNm) {
        baseTableNm = pBaseTableNm;
    }

    private String subSystemId;

    @Column(name=GenAM_TblsTarget.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
}