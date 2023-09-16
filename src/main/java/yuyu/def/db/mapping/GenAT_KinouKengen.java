package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_KinouKengen;
import yuyu.def.db.id.PKAT_KinouKengen;
import yuyu.def.db.meta.GenQAT_KinouKengen;
import yuyu.def.db.meta.QAT_KinouKengen;

/**
 * 機能権限テーブル テーブルのマッピング情報クラスで、 {@link AT_KinouKengen} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KinouKengen}</td><td colspan="3">機能権限テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAT_KinouKengen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">{@link PKAT_KinouKengen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKAT_KinouKengen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiborikomiId siborikomiId}</td><td>絞込みＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KinouKengen
 * @see     PKAT_KinouKengen
 * @see     QAT_KinouKengen
 * @see     GenQAT_KinouKengen
 */
@MappedSuperclass
@Table(name=GenAT_KinouKengen.TABLE_NAME)
@IdClass(value=PKAT_KinouKengen.class)
public abstract class GenAT_KinouKengen extends AbstractExDBEntity<AT_KinouKengen, PKAT_KinouKengen> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_KinouKengen";
    public static final String KINOUID                  = "kinouId";
    public static final String KINOUMODEID              = "kinouModeId";
    public static final String ROLECD                   = "roleCd";
    public static final String SIBORIKOMIID             = "siborikomiId";

    private final PKAT_KinouKengen primaryKey;

    public GenAT_KinouKengen() {
        primaryKey = new PKAT_KinouKengen();
    }

    public GenAT_KinouKengen(
        String pKinouId,
        String pKinouModeId,
        String pRoleCd
    ) {
        primaryKey = new PKAT_KinouKengen(
            pKinouId,
            pKinouModeId,
            pRoleCd
        );
    }

    @Transient
    @Override
    public PKAT_KinouKengen getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_KinouKengen> getMetaClass() {
        return QAT_KinouKengen.class;
    }

    @Id
    @Column(name=GenAT_KinouKengen.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenAT_KinouKengen.KINOUMODEID)
    public String getKinouModeId() {
        return getPrimaryKey().getKinouModeId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouModeId(String pKinouModeId) {
        getPrimaryKey().setKinouModeId(pKinouModeId);
    }

    @Id
    @Column(name=GenAT_KinouKengen.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return getPrimaryKey().getRoleCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        getPrimaryKey().setRoleCd(pRoleCd);
    }

    private String siborikomiId;

    @Column(name=GenAT_KinouKengen.SIBORIKOMIID)
    public String getSiborikomiId() {
        return siborikomiId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiborikomiId(String pSiborikomiId) {
        siborikomiId = pSiborikomiId;
    }
}
