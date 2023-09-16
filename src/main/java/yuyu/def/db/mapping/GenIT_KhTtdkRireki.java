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
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.id.PKIT_KhTtdkRireki;
import yuyu.def.db.meta.GenQIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全手続履歴テーブル テーブルのマッピング情報クラスで、 {@link IT_KhTtdkRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTtdkRireki}</td><td colspan="3">契約保全手続履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhTtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhTtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_KhTtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrsyousaiumu shrsyousaiumu}</td><td>支払詳細有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyorikbn syorikbn}</td><td>処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriKbn}</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHenkourrkumu henkourrkumu}</td><td>変更履歴有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSmbckanriid smbckanriid}</td><td>ＳＭＢＣ受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNayosekihontblskbtkey nayosekihontblskbtkey}</td><td>名寄せ基本テーブル識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTtdkRireki
 * @see     PKIT_KhTtdkRireki
 * @see     QIT_KhTtdkRireki
 * @see     GenQIT_KhTtdkRireki
 */
@MappedSuperclass
@Table(name=GenIT_KhTtdkRireki.TABLE_NAME)
@IdClass(value=PKIT_KhTtdkRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_SyoriKbn", typeClass=UserType_C_SyoriKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_KhTtdkRireki extends AbstractExDBEntity<IT_KhTtdkRireki, PKIT_KhTtdkRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhTtdkRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SHRSYOUSAIUMU            = "shrsyousaiumu";
    public static final String SYORIKBN                 = "syorikbn";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String HENKOURRKUMU             = "henkourrkumu";
    public static final String SMBCKANRIID              = "smbckanriid";
    public static final String NAYOSEKIHONTBLSKBTKEY    = "nayosekihontblskbtkey";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String YOUKYUUNO                = "youkyuuno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhTtdkRireki primaryKey;

    public GenIT_KhTtdkRireki() {
        primaryKey = new PKIT_KhTtdkRireki();
    }

    public GenIT_KhTtdkRireki(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_KhTtdkRireki(
            pKbnkey,
            pSyono,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_KhTtdkRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhTtdkRireki> getMetaClass() {
        return QIT_KhTtdkRireki.class;
    }

    @Id
    @Column(name=GenIT_KhTtdkRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhTtdkRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_KhTtdkRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhTtdkRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syorisosikicd;

    @Column(name=GenIT_KhTtdkRireki.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_UmuKbn shrsyousaiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhTtdkRireki.SHRSYOUSAIUMU)
    public C_UmuKbn getShrsyousaiumu() {
        return shrsyousaiumu;
    }

    public void setShrsyousaiumu(C_UmuKbn pShrsyousaiumu) {
        shrsyousaiumu = pShrsyousaiumu;
    }

    private C_SyoriKbn syorikbn;

    @Type(type="UserType_C_SyoriKbn")
    @Column(name=GenIT_KhTtdkRireki.SYORIKBN)
    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIT_KhTtdkRireki.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_UmuKbn henkourrkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KhTtdkRireki.HENKOURRKUMU)
    public C_UmuKbn getHenkourrkumu() {
        return henkourrkumu;
    }

    public void setHenkourrkumu(C_UmuKbn pHenkourrkumu) {
        henkourrkumu = pHenkourrkumu;
    }

    private String smbckanriid;

    @Column(name=GenIT_KhTtdkRireki.SMBCKANRIID)
    public String getSmbckanriid() {
        return smbckanriid;
    }

    public void setSmbckanriid(String pSmbckanriid) {
        smbckanriid = pSmbckanriid;
    }

    private String nayosekihontblskbtkey;

    @Column(name=GenIT_KhTtdkRireki.NAYOSEKIHONTBLSKBTKEY)
    public String getNayosekihontblskbtkey() {
        return nayosekihontblskbtkey;
    }

    public void setNayosekihontblskbtkey(String pNayosekihontblskbtkey) {
        nayosekihontblskbtkey = pNayosekihontblskbtkey;
    }

    private String kouteikanriid;

    @Column(name=GenIT_KhTtdkRireki.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    private String youkyuuno;

    @Column(name=GenIT_KhTtdkRireki.YOUKYUUNO)
    public String getYoukyuuno() {
        return youkyuuno;
    }

    public void setYoukyuuno(String pYoukyuuno) {
        youkyuuno = pYoukyuuno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhTtdkRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhTtdkRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhTtdkRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}