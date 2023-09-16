package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.AM_TblsRefLimitSosiki;
import yuyu.def.db.mapping.GenAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.GenQAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.QAM_TblsRefLimitSosiki;

/**
 * テーブル照会参照組織限定マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsRefLimitSosiki}</td><td colspan="3">テーブル照会参照組織限定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseDdId baseDdId}</td><td>（ベース）項目ID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTanmatusettisosikicd tanmatusettisosikicd}</td><td>端末設置組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_TblsRefLimitSosiki
 * @see     GenAM_TblsRefLimitSosiki
 * @see     QAM_TblsRefLimitSosiki
 * @see     GenQAM_TblsRefLimitSosiki
 */
public class PKAM_TblsRefLimitSosiki extends AbstractExDBPrimaryKey<AM_TblsRefLimitSosiki, PKAM_TblsRefLimitSosiki> {

    private static final long serialVersionUID = 1L;

    public PKAM_TblsRefLimitSosiki() {
    }

    public PKAM_TblsRefLimitSosiki(
        String pBaseTableId,
        String pBaseDdId,
        String pTanmatusettisosikicd
    ) {
        baseTableId = pBaseTableId;
        baseDdId = pBaseDdId;
        tanmatusettisosikicd = pTanmatusettisosikicd;
    }

    @Transient
    @Override
    public Class<AM_TblsRefLimitSosiki> getEntityClass() {
        return AM_TblsRefLimitSosiki.class;
    }

    private String baseTableId;

    public String getBaseTableId() {
        return baseTableId;
    }

    public void setBaseTableId(String pBaseTableId) {
        baseTableId = pBaseTableId;
    }
    private String baseDdId;

    public String getBaseDdId() {
        return baseDdId;
    }

    public void setBaseDdId(String pBaseDdId) {
        baseDdId = pBaseDdId;
    }
    private String tanmatusettisosikicd;

    public String getTanmatusettisosikicd() {
        return tanmatusettisosikicd;
    }

    public void setTanmatusettisosikicd(String pTanmatusettisosikicd) {
        tanmatusettisosikicd = pTanmatusettisosikicd;
    }

}