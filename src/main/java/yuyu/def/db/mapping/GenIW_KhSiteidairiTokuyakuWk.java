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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.id.PKIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.GenQIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.QIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 指定代理請求特約中途付加ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhSiteidairiTokuyakuWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhSiteidairiTokuyakuWk}</td><td colspan="3">指定代理請求特約中途付加ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhSiteidairiTokuyakuWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStdruktkbn stdruktkbn}</td><td>指定代理受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getStdrsknmkn stdrsknmkn}</td><td>指定代理請求人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkjhukakbn stdrsknmkjhukakbn}</td><td>指定代理請求人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrskseiymd stdrskseiymd}</td><td>指定代理請求人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     IW_KhSiteidairiTokuyakuWk
 * @see     PKIW_KhSiteidairiTokuyakuWk
 * @see     QIW_KhSiteidairiTokuyakuWk
 * @see     GenQIW_KhSiteidairiTokuyakuWk
 */
@MappedSuperclass
@Table(name=GenIW_KhSiteidairiTokuyakuWk.TABLE_NAME)
@IdClass(value=PKIW_KhSiteidairiTokuyakuWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class)
})
public abstract class GenIW_KhSiteidairiTokuyakuWk extends AbstractExDBEntity<IW_KhSiteidairiTokuyakuWk, PKIW_KhSiteidairiTokuyakuWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhSiteidairiTokuyakuWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String STDRUKTKBN               = "stdruktkbn";
    public static final String STDRSKNMKN               = "stdrsknmkn";
    public static final String STDRSKNMKJ               = "stdrsknmkj";
    public static final String STDRSKNMKJHUKAKBN        = "stdrsknmkjhukakbn";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String STDRSKSEIYMD             = "stdrskseiymd";

    private final PKIW_KhSiteidairiTokuyakuWk primaryKey;

    public GenIW_KhSiteidairiTokuyakuWk() {
        primaryKey = new PKIW_KhSiteidairiTokuyakuWk();
    }

    public GenIW_KhSiteidairiTokuyakuWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhSiteidairiTokuyakuWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhSiteidairiTokuyakuWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhSiteidairiTokuyakuWk> getMetaClass() {
        return QIW_KhSiteidairiTokuyakuWk.class;
    }

    @Id
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SYONO)
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
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_UktKbn stdruktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.STDRUKTKBN)
    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktkbn = pStdruktkbn;
    }

    private String stdrsknmkn;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.STDRSKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getStdrsknmkn() {
        return stdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrsknmkn = pStdrsknmkn;
    }

    private String stdrsknmkj;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.STDRSKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }

    private C_KjkhukaKbn stdrsknmkjhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.STDRSKNMKJHUKAKBN)
    public C_KjkhukaKbn getStdrsknmkjhukakbn() {
        return stdrsknmkjhukakbn;
    }

    public void setStdrsknmkjhukakbn(C_KjkhukaKbn pStdrsknmkjhukakbn) {
        stdrsknmkjhukakbn = pStdrsknmkjhukakbn;
    }

    private String shsnmkj;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String shskyno;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhSiteidairiTokuyakuWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizDate stdrskseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhSiteidairiTokuyakuWk.STDRSKSEIYMD)
    @ValidDate
    public BizDate getStdrskseiymd() {
        return stdrskseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setStdrskseiymd(BizDate pStdrskseiymd) {
        stdrskseiymd = pStdrskseiymd;
    }
}