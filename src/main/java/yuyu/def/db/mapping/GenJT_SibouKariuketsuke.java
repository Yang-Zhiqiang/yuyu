package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.id.PKJT_SibouKariuketsuke;
import yuyu.def.db.meta.GenQJT_SibouKariuketsuke;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡仮受付テーブル テーブルのマッピング情報クラスで、 {@link JT_SibouKariuketsuke} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SibouKariuketsuke}</td><td colspan="3">死亡仮受付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SibouKariuketsuke ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SibouKariuketsuke ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiflg torikesiflg}</td><td>取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SibouKariuketsuke
 * @see     PKJT_SibouKariuketsuke
 * @see     QJT_SibouKariuketsuke
 * @see     GenQJT_SibouKariuketsuke
 */
@MappedSuperclass
@Table(name=GenJT_SibouKariuketsuke.TABLE_NAME)
@IdClass(value=PKJT_SibouKariuketsuke.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SibouKariuketsuke extends AbstractExDBEntity<JT_SibouKariuketsuke, PKJT_SibouKariuketsuke> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SibouKariuketsuke";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String GENINKBN                 = "geninkbn";
    public static final String TORIKESIFLG              = "torikesiflg";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SibouKariuketsuke primaryKey;

    public GenJT_SibouKariuketsuke() {
        primaryKey = new PKJT_SibouKariuketsuke();
    }

    public GenJT_SibouKariuketsuke(String pSkno, String pSyono) {
        primaryKey = new PKJT_SibouKariuketsuke(pSkno, pSyono);
    }

    @Transient
    @Override
    public PKJT_SibouKariuketsuke getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SibouKariuketsuke> getMetaClass() {
        return QJT_SibouKariuketsuke.class;
    }

    @Id
    @Column(name=GenJT_SibouKariuketsuke.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SibouKariuketsuke.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SibouKariuketsuke.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJT_SibouKariuketsuke.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private C_UmuKbn torikesiflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SibouKariuketsuke.TORIKESIFLG)
    public C_UmuKbn getTorikesiflg() {
        return torikesiflg;
    }

    public void setTorikesiflg(C_UmuKbn pTorikesiflg) {
        torikesiflg = pTorikesiflg;
    }

    private String kossyoricd;

    @Column(name=GenJT_SibouKariuketsuke.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SibouKariuketsuke.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SibouKariuketsuke.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SibouKariuketsuke.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}