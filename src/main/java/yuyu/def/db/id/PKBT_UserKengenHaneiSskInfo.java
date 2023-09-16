package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_UserKengenHaneiSskInfo;
import yuyu.def.db.mapping.GenBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.GenQBT_UserKengenHaneiSskInfo;
import yuyu.def.db.meta.QBT_UserKengenHaneiSskInfo;

/**
 * ユーザー権限自動反映組織情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_UserKengenHaneiSskInfo}</td><td colspan="3">ユーザー権限自動反映組織情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSosikicdkami3 sosikicdkami3}</td><td>組織コード上３桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hnsyasosikikengenkbn</td><td>本社組織権限区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnsyaSosikiKengenKbn C_HnsyaSosikiKengenKbn}</td></tr>
 * </table>
 * @see     BT_UserKengenHaneiSskInfo
 * @see     GenBT_UserKengenHaneiSskInfo
 * @see     QBT_UserKengenHaneiSskInfo
 * @see     GenQBT_UserKengenHaneiSskInfo
 */
public class PKBT_UserKengenHaneiSskInfo extends AbstractExDBPrimaryKey<BT_UserKengenHaneiSskInfo, PKBT_UserKengenHaneiSskInfo> {

    private static final long serialVersionUID = 1L;

    public PKBT_UserKengenHaneiSskInfo() {
    }

    public PKBT_UserKengenHaneiSskInfo(String pSosikicdkami3) {
        sosikicdkami3 = pSosikicdkami3;
    }

    @Transient
    @Override
    public Class<BT_UserKengenHaneiSskInfo> getEntityClass() {
        return BT_UserKengenHaneiSskInfo.class;
    }

    private String sosikicdkami3;

    public String getSosikicdkami3() {
        return sosikicdkami3;
    }

    public void setSosikicdkami3(String pSosikicdkami3) {
        sosikicdkami3 = pSosikicdkami3;
    }

}