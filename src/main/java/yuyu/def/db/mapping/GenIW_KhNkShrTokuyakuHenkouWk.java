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
import jp.co.slcs.swak.validation.constraints.Range;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.IW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.id.PKIW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.meta.GenQIW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.meta.QIW_KhNkShrTokuyakuHenkouWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_NstkhKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 年金支払特約変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhNkShrTokuyakuHenkouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhNkShrTokuyakuHenkouWk}</td><td colspan="3">年金支払特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhNkShrTokuyakuHenkouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrtkykhnkkbn nkshrtkykhnkkbn}</td><td>年金支払特約変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NstkhKbn}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukbn nkshrtkyknksyukbn}</td><td>年金支払特約年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNkshrtkyknksyukkn nkshrtkyknksyukkn}</td><td>年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhNkShrTokuyakuHenkouWk
 * @see     PKIW_KhNkShrTokuyakuHenkouWk
 * @see     QIW_KhNkShrTokuyakuHenkouWk
 * @see     GenQIW_KhNkShrTokuyakuHenkouWk
 */
@MappedSuperclass
@Table(name=GenIW_KhNkShrTokuyakuHenkouWk.TABLE_NAME)
@IdClass(value=PKIW_KhNkShrTokuyakuHenkouWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_NstkhKbn", typeClass=UserType_C_NstkhKbn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class)
})
public abstract class GenIW_KhNkShrTokuyakuHenkouWk extends AbstractExDBEntity<IW_KhNkShrTokuyakuHenkouWk, PKIW_KhNkShrTokuyakuHenkouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhNkShrTokuyakuHenkouWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String NKSHRTKYKHNKKBN          = "nkshrtkykhnkkbn";
    public static final String NKSHRTKYKNKSYUKBN        = "nkshrtkyknksyukbn";
    public static final String NKSHRTKYKNKSYUKKN        = "nkshrtkyknksyukkn";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhNkShrTokuyakuHenkouWk primaryKey;

    public GenIW_KhNkShrTokuyakuHenkouWk() {
        primaryKey = new PKIW_KhNkShrTokuyakuHenkouWk();
    }

    public GenIW_KhNkShrTokuyakuHenkouWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhNkShrTokuyakuHenkouWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhNkShrTokuyakuHenkouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhNkShrTokuyakuHenkouWk> getMetaClass() {
        return QIW_KhNkShrTokuyakuHenkouWk.class;
    }

    @Id
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.SYONO)
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
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_NstkhKbn nkshrtkykhnkkbn;

    @Type(type="UserType_C_NstkhKbn")
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.NKSHRTKYKHNKKBN)
    public C_NstkhKbn getNkshrtkykhnkkbn() {
        return nkshrtkykhnkkbn;
    }

    public void setNkshrtkykhnkkbn(C_NstkhKbn pNkshrtkykhnkkbn) {
        nkshrtkykhnkkbn = pNkshrtkykhnkkbn;
    }

    private C_Nstknsyu nkshrtkyknksyukbn;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.NKSHRTKYKNKSYUKBN)
    public C_Nstknsyu getNkshrtkyknksyukbn() {
        return nkshrtkyknksyukbn;
    }

    public void setNkshrtkyknksyukbn(C_Nstknsyu pNkshrtkyknksyukbn) {
        nkshrtkyknksyukbn = pNkshrtkyknksyukbn;
    }

    private Integer nkshrtkyknksyukkn;

    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.NKSHRTKYKNKSYUKKN)
    @Range(min="0", max="99")
    public Integer getNkshrtkyknksyukkn() {
        return nkshrtkyknksyukkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkshrtkyknksyukkn(Integer pNkshrtkyknksyukkn) {
        nkshrtkyknksyukkn = pNkshrtkyknksyukkn;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhNkShrTokuyakuHenkouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}