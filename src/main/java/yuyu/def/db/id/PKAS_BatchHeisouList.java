package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.mapping.GenAS_BatchHeisouList;
import yuyu.def.db.meta.GenQAS_BatchHeisouList;
import yuyu.def.db.meta.QAS_BatchHeisouList;

/**
 * バッチ並走リスト基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_BatchHeisouList}</td><td colspan="3">バッチ並走リスト基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSelfKinouId selfKinouId}</td><td>自機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTargetKinouId targetKinouId}</td><td>対象機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_BatchHeisouList
 * @see     GenAS_BatchHeisouList
 * @see     QAS_BatchHeisouList
 * @see     GenQAS_BatchHeisouList
 */
public class PKAS_BatchHeisouList extends AbstractExDBPrimaryKey<AS_BatchHeisouList, PKAS_BatchHeisouList> {

    private static final long serialVersionUID = 1L;

    public PKAS_BatchHeisouList() {
    }

    public PKAS_BatchHeisouList(String pSelfKinouId, String pTargetKinouId) {
        selfKinouId = pSelfKinouId;
        targetKinouId = pTargetKinouId;
    }

    @Transient
    @Override
    public Class<AS_BatchHeisouList> getEntityClass() {
        return AS_BatchHeisouList.class;
    }

    private String selfKinouId;

    public String getSelfKinouId() {
        return selfKinouId;
    }

    public void setSelfKinouId(String pSelfKinouId) {
        selfKinouId = pSelfKinouId;
    }
    private String targetKinouId;

    public String getTargetKinouId() {
        return targetKinouId;
    }

    public void setTargetKinouId(String pTargetKinouId) {
        targetKinouId = pTargetKinouId;
    }

}