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
import yuyu.def.db.entity.AM_TblsRefLimitSosiki;
import yuyu.def.db.id.PKAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.GenQAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.QAM_TblsRefLimitSosiki;

/**
 * テーブル照会参照組織限定マスタ テーブルのマッピング情報クラスで、 {@link AM_TblsRefLimitSosiki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsRefLimitSosiki}</td><td colspan="3">テーブル照会参照組織限定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">{@link PKAM_TblsRefLimitSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBaseDdId baseDdId}</td><td>（ベース）項目ID</td><td align="center">{@link PKAM_TblsRefLimitSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTanmatusettisosikicd tanmatusettisosikicd}</td><td>端末設置組織コード</td><td align="center">{@link PKAM_TblsRefLimitSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_TblsRefLimitSosiki
 * @see     PKAM_TblsRefLimitSosiki
 * @see     QAM_TblsRefLimitSosiki
 * @see     GenQAM_TblsRefLimitSosiki
 */
@MappedSuperclass
@Table(name=GenAM_TblsRefLimitSosiki.TABLE_NAME)
@IdClass(value=PKAM_TblsRefLimitSosiki.class)
public abstract class GenAM_TblsRefLimitSosiki extends AbstractExDBEntity<AM_TblsRefLimitSosiki, PKAM_TblsRefLimitSosiki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_TblsRefLimitSosiki";
    public static final String BASETABLEID              = "baseTableId";
    public static final String BASEDDID                 = "baseDdId";
    public static final String TANMATUSETTISOSIKICD     = "tanmatusettisosikicd";

    private final PKAM_TblsRefLimitSosiki primaryKey;

    public GenAM_TblsRefLimitSosiki() {
        primaryKey = new PKAM_TblsRefLimitSosiki();
    }

    public GenAM_TblsRefLimitSosiki(
        String pBaseTableId,
        String pBaseDdId,
        String pTanmatusettisosikicd
    ) {
        primaryKey = new PKAM_TblsRefLimitSosiki(
            pBaseTableId,
            pBaseDdId,
            pTanmatusettisosikicd
        );
    }

    @Transient
    @Override
    public PKAM_TblsRefLimitSosiki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_TblsRefLimitSosiki> getMetaClass() {
        return QAM_TblsRefLimitSosiki.class;
    }

    @Id
    @Column(name=GenAM_TblsRefLimitSosiki.BASETABLEID)
    @SingleByteStrings
    public String getBaseTableId() {
        return getPrimaryKey().getBaseTableId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseTableId(String pBaseTableId) {
        getPrimaryKey().setBaseTableId(pBaseTableId);
    }

    @Id
    @Column(name=GenAM_TblsRefLimitSosiki.BASEDDID)
    public String getBaseDdId() {
        return getPrimaryKey().getBaseDdId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseDdId(String pBaseDdId) {
        getPrimaryKey().setBaseDdId(pBaseDdId);
    }

    @Id
    @Column(name=GenAM_TblsRefLimitSosiki.TANMATUSETTISOSIKICD)
    public String getTanmatusettisosikicd() {
        return getPrimaryKey().getTanmatusettisosikicd();
    }

    public void setTanmatusettisosikicd(String pTanmatusettisosikicd) {
        getPrimaryKey().setTanmatusettisosikicd(pTanmatusettisosikicd);
    }
}