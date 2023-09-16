package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.mapping.GenAS_KinouMode;
import yuyu.def.db.meta.GenQAS_KinouMode;
import yuyu.def.db.meta.QAS_KinouMode;

/**
 * 機能モード基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_KinouMode}</td><td colspan="3">機能モード基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouModeNm</td><td>機能モード名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yuukouKbn</td><td>有効区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukouKbn C_YuukouKbn}</td></tr>
 *  <tr><td>yuukouKaisiYmd</td><td>有効開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kadouTimeGroupCd</td><td>稼働時間グループコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>batchHeisouKahiKbn</td><td>バッチ並走可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 * </table>
 * @see     AS_KinouMode
 * @see     GenAS_KinouMode
 * @see     QAS_KinouMode
 * @see     GenQAS_KinouMode
 */
public class PKAS_KinouMode extends AbstractExDBPrimaryKey<AS_KinouMode, PKAS_KinouMode> {

    private static final long serialVersionUID = 1L;

    public PKAS_KinouMode() {
    }

    public PKAS_KinouMode(String pKinouId, String pKinouModeId) {
        kinouId = pKinouId;
        kinouModeId = pKinouModeId;
    }

    @Transient
    @Override
    public Class<AS_KinouMode> getEntityClass() {
        return AS_KinouMode.class;
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

}