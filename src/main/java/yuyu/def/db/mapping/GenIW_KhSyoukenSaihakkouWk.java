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
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;
import yuyu.def.db.id.PKIW_KhSyoukenSaihakkouWk;
import yuyu.def.db.meta.GenQIW_KhSyoukenSaihakkouWk;
import yuyu.def.db.meta.QIW_KhSyoukenSaihakkouWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InsizeiShryouhiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_SyoukensaihkKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 証券再発行ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhSyoukenSaihakkouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhSyoukenSaihakkouWk}</td><td colspan="3">証券再発行ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhSyoukenSaihakkouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoukensaihkkbn syoukensaihkkbn}</td><td>証券再発行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukensaihkKbn}</td></tr>
 *  <tr><td>{@link #getInsizeishryouhikbn insizeishryouhikbn}</td><td>印紙税支払要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InsizeiShryouhiKbn}</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhSyoukenSaihakkouWk
 * @see     PKIW_KhSyoukenSaihakkouWk
 * @see     QIW_KhSyoukenSaihakkouWk
 * @see     GenQIW_KhSyoukenSaihakkouWk
 */
@MappedSuperclass
@Table(name=GenIW_KhSyoukenSaihakkouWk.TABLE_NAME)
@IdClass(value=PKIW_KhSyoukenSaihakkouWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_InsizeiShryouhiKbn", typeClass=UserType_C_InsizeiShryouhiKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_SyoukensaihkKbn", typeClass=UserType_C_SyoukensaihkKbn.class)
})
public abstract class GenIW_KhSyoukenSaihakkouWk extends AbstractExDBEntity<IW_KhSyoukenSaihakkouWk, PKIW_KhSyoukenSaihakkouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhSyoukenSaihakkouWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String SYOUKENSAIHKKBN          = "syoukensaihkkbn";
    public static final String INSIZEISHRYOUHIKBN       = "insizeishryouhikbn";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_KhSyoukenSaihakkouWk primaryKey;

    public GenIW_KhSyoukenSaihakkouWk() {
        primaryKey = new PKIW_KhSyoukenSaihakkouWk();
    }

    public GenIW_KhSyoukenSaihakkouWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhSyoukenSaihakkouWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhSyoukenSaihakkouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhSyoukenSaihakkouWk> getMetaClass() {
        return QIW_KhSyoukenSaihakkouWk.class;
    }

    @Id
    @Column(name=GenIW_KhSyoukenSaihakkouWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhSyoukenSaihakkouWk.SYONO)
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
    @Column(name=GenIW_KhSyoukenSaihakkouWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_SyoukensaihkKbn syoukensaihkkbn;

    @Type(type="UserType_C_SyoukensaihkKbn")
    @Column(name=GenIW_KhSyoukenSaihakkouWk.SYOUKENSAIHKKBN)
    public C_SyoukensaihkKbn getSyoukensaihkkbn() {
        return syoukensaihkkbn;
    }

    public void setSyoukensaihkkbn(C_SyoukensaihkKbn pSyoukensaihkkbn) {
        syoukensaihkkbn = pSyoukensaihkkbn;
    }

    private C_InsizeiShryouhiKbn insizeishryouhikbn;

    @Type(type="UserType_C_InsizeiShryouhiKbn")
    @Column(name=GenIW_KhSyoukenSaihakkouWk.INSIZEISHRYOUHIKBN)
    public C_InsizeiShryouhiKbn getInsizeishryouhikbn() {
        return insizeishryouhikbn;
    }

    public void setInsizeishryouhikbn(C_InsizeiShryouhiKbn pInsizeishryouhikbn) {
        insizeishryouhikbn = pInsizeishryouhikbn;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhSyoukenSaihakkouWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhSyoukenSaihakkouWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhSyoukenSaihakkouWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhSyoukenSaihakkouWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhSyoukenSaihakkouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhSyoukenSaihakkouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}