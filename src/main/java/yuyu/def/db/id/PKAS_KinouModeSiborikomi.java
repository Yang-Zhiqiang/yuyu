package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.mapping.GenAS_KinouModeSiborikomi;
import yuyu.def.db.meta.GenQAS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;

/**
 * 機能モード絞込み基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_KinouModeSiborikomi}</td><td colspan="3">機能モード絞込み基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSiborikomiId siborikomiId}</td><td>絞込みＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siborikomiNm</td><td>絞込み名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_KinouModeSiborikomi
 * @see     GenAS_KinouModeSiborikomi
 * @see     QAS_KinouModeSiborikomi
 * @see     GenQAS_KinouModeSiborikomi
 */
public class PKAS_KinouModeSiborikomi extends AbstractExDBPrimaryKey<AS_KinouModeSiborikomi, PKAS_KinouModeSiborikomi> {

    private static final long serialVersionUID = 1L;

    public PKAS_KinouModeSiborikomi() {
    }

    public PKAS_KinouModeSiborikomi(
        String pKinouId,
        String pKinouModeId,
        String pSiborikomiId
    ) {
        kinouId = pKinouId;
        kinouModeId = pKinouModeId;
        siborikomiId = pSiborikomiId;
    }

    @Transient
    @Override
    public Class<AS_KinouModeSiborikomi> getEntityClass() {
        return AS_KinouModeSiborikomi.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String kinouModeId;

    public String getKinouModeId() {
        return kinouModeId;
    }

    public void setKinouModeId(String pKinouModeId) {
        kinouModeId = pKinouModeId;
    }
    private String siborikomiId;

    public String getSiborikomiId() {
        return siborikomiId;
    }

    public void setSiborikomiId(String pSiborikomiId) {
        siborikomiId = pSiborikomiId;
    }

}