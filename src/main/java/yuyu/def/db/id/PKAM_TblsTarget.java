package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.AM_TblsTarget;
import yuyu.def.db.mapping.GenAM_TblsTarget;
import yuyu.def.db.meta.GenQAM_TblsTarget;
import yuyu.def.db.meta.QAM_TblsTarget;

/**
 * テーブル照会対象マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsTarget}</td><td colspan="3">テーブル照会対象マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>baseTableNm</td><td>（ベース）テーブル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_TblsTarget
 * @see     GenAM_TblsTarget
 * @see     QAM_TblsTarget
 * @see     GenQAM_TblsTarget
 */
public class PKAM_TblsTarget extends AbstractExDBPrimaryKey<AM_TblsTarget, PKAM_TblsTarget> {

    private static final long serialVersionUID = 1L;

    public PKAM_TblsTarget() {
    }

    public PKAM_TblsTarget(String pBaseTableId) {
        baseTableId = pBaseTableId;
    }

    @Transient
    @Override
    public Class<AM_TblsTarget> getEntityClass() {
        return AM_TblsTarget.class;
    }

    private String baseTableId;

    public String getBaseTableId() {
        return baseTableId;
    }

    public void setBaseTableId(String pBaseTableId) {
        baseTableId = pBaseTableId;
    }

}