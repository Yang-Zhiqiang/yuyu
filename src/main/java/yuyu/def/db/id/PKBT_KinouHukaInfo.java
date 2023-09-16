package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.mapping.GenBT_KinouHukaInfo;
import yuyu.def.db.meta.GenQBT_KinouHukaInfo;
import yuyu.def.db.meta.QBT_KinouHukaInfo;

/**
 * 機能付加情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KinouHukaInfo}</td><td colspan="3">機能付加情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tjttrkskahi</td><td>当日取消可否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>kensuuhyoujijyun</td><td>件数表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BT_KinouHukaInfo
 * @see     GenBT_KinouHukaInfo
 * @see     QBT_KinouHukaInfo
 * @see     GenQBT_KinouHukaInfo
 */
public class PKBT_KinouHukaInfo extends AbstractExDBPrimaryKey<BT_KinouHukaInfo, PKBT_KinouHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_KinouHukaInfo() {
    }

    public PKBT_KinouHukaInfo(String pKinouId) {
        kinouId = pKinouId;
    }

    @Transient
    @Override
    public Class<BT_KinouHukaInfo> getEntityClass() {
        return BT_KinouHukaInfo.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

}