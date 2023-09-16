package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.def.db.id.PKAS_BatchHeisouList;
import yuyu.def.db.meta.GenQAS_BatchHeisouList;
import yuyu.def.db.meta.QAS_BatchHeisouList;

/**
 * バッチ並走リスト基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_BatchHeisouList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_BatchHeisouList}</td><td colspan="3">バッチ並走リスト基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSelfKinouId selfKinouId}</td><td>自機能ＩＤ</td><td align="center">{@link PKAS_BatchHeisouList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTargetKinouId targetKinouId}</td><td>対象機能ＩＤ</td><td align="center">{@link PKAS_BatchHeisouList ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_BatchHeisouList
 * @see     PKAS_BatchHeisouList
 * @see     QAS_BatchHeisouList
 * @see     GenQAS_BatchHeisouList
 */
@MappedSuperclass
@Table(name=GenAS_BatchHeisouList.TABLE_NAME)
@IdClass(value=PKAS_BatchHeisouList.class)
public abstract class GenAS_BatchHeisouList extends AbstractExDBEntity<AS_BatchHeisouList, PKAS_BatchHeisouList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_BatchHeisouList";
    public static final String SELFKINOUID              = "selfKinouId";
    public static final String TARGETKINOUID            = "targetKinouId";

    private final PKAS_BatchHeisouList primaryKey;

    public GenAS_BatchHeisouList() {
        primaryKey = new PKAS_BatchHeisouList();
    }

    public GenAS_BatchHeisouList(String pSelfKinouId, String pTargetKinouId) {
        primaryKey = new PKAS_BatchHeisouList(pSelfKinouId, pTargetKinouId);
    }

    @Transient
    @Override
    public PKAS_BatchHeisouList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_BatchHeisouList> getMetaClass() {
        return QAS_BatchHeisouList.class;
    }

    @Id
    @Column(name=GenAS_BatchHeisouList.SELFKINOUID)
    public String getSelfKinouId() {
        return getPrimaryKey().getSelfKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSelfKinouId(String pSelfKinouId) {
        getPrimaryKey().setSelfKinouId(pSelfKinouId);
    }

    @Id
    @Column(name=GenAS_BatchHeisouList.TARGETKINOUID)
    public String getTargetKinouId() {
        return getPrimaryKey().getTargetKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargetKinouId(String pTargetKinouId) {
        getPrimaryKey().setTargetKinouId(pTargetKinouId);
    }
}
