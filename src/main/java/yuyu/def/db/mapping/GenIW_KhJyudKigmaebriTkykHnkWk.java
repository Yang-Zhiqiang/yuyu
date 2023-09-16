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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.id.PKIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.GenQIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.QIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 重度介護前払特約変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhJyudKigmaebriTkykHnkWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhJyudKigmaebriTkykHnkWk}</td><td colspan="3">重度介護前払特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhJyudKigmaebriTkykHnkWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJyudkaigomaebaraitkykhnkkbn jyudkaigomaebaraitkykhnkkbn}</td><td>重度介護前払特約変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JyudkaigomaebaraiTkykhnkKbn}</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhJyudKigmaebriTkykHnkWk
 * @see     PKIW_KhJyudKigmaebriTkykHnkWk
 * @see     QIW_KhJyudKigmaebriTkykHnkWk
 * @see     GenQIW_KhJyudKigmaebriTkykHnkWk
 */
@MappedSuperclass
@Table(name=GenIW_KhJyudKigmaebriTkykHnkWk.TABLE_NAME)
@IdClass(value=PKIW_KhJyudKigmaebriTkykHnkWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_JyudkaigomaebaraiTkykhnkKbn", typeClass=UserType_C_JyudkaigomaebaraiTkykhnkKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class)
})
public abstract class GenIW_KhJyudKigmaebriTkykHnkWk extends AbstractExDBEntity<IW_KhJyudKigmaebriTkykHnkWk, PKIW_KhJyudKigmaebriTkykHnkWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhJyudKigmaebriTkykHnkWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String JYUDKAIGOMAEBARAITKYKHNKKBN = "jyudkaigomaebaraitkykhnkkbn";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhJyudKigmaebriTkykHnkWk primaryKey;

    public GenIW_KhJyudKigmaebriTkykHnkWk() {
        primaryKey = new PKIW_KhJyudKigmaebriTkykHnkWk();
    }

    public GenIW_KhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhJyudKigmaebriTkykHnkWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhJyudKigmaebriTkykHnkWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhJyudKigmaebriTkykHnkWk> getMetaClass() {
        return QIW_KhJyudKigmaebriTkykHnkWk.class;
    }

    @Id
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate skssakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_JyudkaigomaebaraiTkykhnkKbn jyudkaigomaebaraitkykhnkkbn;

    @Type(type="UserType_C_JyudkaigomaebaraiTkykhnkKbn")
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.JYUDKAIGOMAEBARAITKYKHNKKBN)
    public C_JyudkaigomaebaraiTkykhnkKbn getJyudkaigomaebaraitkykhnkkbn() {
        return jyudkaigomaebaraitkykhnkkbn;
    }

    public void setJyudkaigomaebaraitkykhnkkbn(C_JyudkaigomaebaraiTkykhnkKbn pJyudkaigomaebaraitkykhnkkbn) {
        jyudkaigomaebaraitkykhnkkbn = pJyudkaigomaebaraitkykhnkkbn;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhJyudKigmaebriTkykHnkWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}