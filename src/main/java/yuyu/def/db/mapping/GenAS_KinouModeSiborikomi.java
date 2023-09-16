package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.id.PKAS_KinouModeSiborikomi;
import yuyu.def.db.meta.GenQAS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;

/**
 * 機能モード絞込み基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_KinouModeSiborikomi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_KinouModeSiborikomi}</td><td colspan="3">機能モード絞込み基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAS_KinouModeSiborikomi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">{@link PKAS_KinouModeSiborikomi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiborikomiId siborikomiId}</td><td>絞込みＩＤ</td><td align="center">{@link PKAS_KinouModeSiborikomi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiborikomiNm siborikomiNm}</td><td>絞込み名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_KinouModeSiborikomi
 * @see     PKAS_KinouModeSiborikomi
 * @see     QAS_KinouModeSiborikomi
 * @see     GenQAS_KinouModeSiborikomi
 */
@MappedSuperclass
@Table(name=GenAS_KinouModeSiborikomi.TABLE_NAME)
@IdClass(value=PKAS_KinouModeSiborikomi.class)
public abstract class GenAS_KinouModeSiborikomi extends AbstractExDBEntity<AS_KinouModeSiborikomi, PKAS_KinouModeSiborikomi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_KinouModeSiborikomi";
    public static final String KINOUID                  = "kinouId";
    public static final String KINOUMODEID              = "kinouModeId";
    public static final String SIBORIKOMIID             = "siborikomiId";
    public static final String SIBORIKOMINM             = "siborikomiNm";

    private final PKAS_KinouModeSiborikomi primaryKey;

    public GenAS_KinouModeSiborikomi() {
        primaryKey = new PKAS_KinouModeSiborikomi();
    }

    public GenAS_KinouModeSiborikomi(
        String pKinouId,
        String pKinouModeId,
        String pSiborikomiId
    ) {
        primaryKey = new PKAS_KinouModeSiborikomi(
            pKinouId,
            pKinouModeId,
            pSiborikomiId
        );
    }

    @Transient
    @Override
    public PKAS_KinouModeSiborikomi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_KinouModeSiborikomi> getMetaClass() {
        return QAS_KinouModeSiborikomi.class;
    }

    @Id
    @Column(name=GenAS_KinouModeSiborikomi.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenAS_KinouModeSiborikomi.KINOUMODEID)
    public String getKinouModeId() {
        return getPrimaryKey().getKinouModeId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouModeId(String pKinouModeId) {
        getPrimaryKey().setKinouModeId(pKinouModeId);
    }

    @Id
    @Column(name=GenAS_KinouModeSiborikomi.SIBORIKOMIID)
    public String getSiborikomiId() {
        return getPrimaryKey().getSiborikomiId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiborikomiId(String pSiborikomiId) {
        getPrimaryKey().setSiborikomiId(pSiborikomiId);
    }

    private String siborikomiNm;

    @Column(name=GenAS_KinouModeSiborikomi.SIBORIKOMINM)
    public String getSiborikomiNm() {
        return siborikomiNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSiborikomiNm(String pSiborikomiNm) {
        siborikomiNm = pSiborikomiNm;
    }
}
