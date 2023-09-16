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
import yuyu.def.classification.C_BnktAnnaiHouhouKbn;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.id.PKIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.meta.GenQIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.meta.QIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.type.UserType_C_BnktAnnaiHouhouKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 被災害分割案内方法管理テーブル テーブルのマッピング情報クラスで、 {@link IT_HsgbnktAnnaihouhoukanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HsgbnktAnnaihouhoukanri}</td><td colspan="3">被災害分割案内方法管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HsgbnktAnnaihouhoukanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HsgbnktAnnaihouhoukanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHsgymd hsgymd}</td><td>被災害年月日</td><td align="center">{@link PKIT_HsgbnktAnnaihouhoukanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBnktannaihouhoukbn bnktannaihouhoukbn}</td><td>分割案内方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BnktAnnaiHouhouKbn}</td></tr>
 *  <tr><td>{@link #getBnktannaikaisiymd bnktannaikaisiymd}</td><td>分割案内開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBnktannaiendymd bnktannaiendymd}</td><td>分割案内終了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHsgtkbtymd1 hsgtkbtymd1}</td><td>被災害特別年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHsgtkbtymd2 hsgtkbtymd2}</td><td>被災害特別年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHsgtkbtkbn1 hsgtkbtkbn1}</td><td>被災害特別区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHsgtkbtkbn2 hsgtkbtkbn2}</td><td>被災害特別区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HsgbnktAnnaihouhoukanri
 * @see     PKIT_HsgbnktAnnaihouhoukanri
 * @see     QIT_HsgbnktAnnaihouhoukanri
 * @see     GenQIT_HsgbnktAnnaihouhoukanri
 */
@MappedSuperclass
@Table(name=GenIT_HsgbnktAnnaihouhoukanri.TABLE_NAME)
@IdClass(value=PKIT_HsgbnktAnnaihouhoukanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_BnktAnnaiHouhouKbn", typeClass=UserType_C_BnktAnnaiHouhouKbn.class)
})
public abstract class GenIT_HsgbnktAnnaihouhoukanri extends AbstractExDBEntity<IT_HsgbnktAnnaihouhoukanri, PKIT_HsgbnktAnnaihouhoukanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HsgbnktAnnaihouhoukanri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HSGYMD                   = "hsgymd";
    public static final String BNKTANNAIHOUHOUKBN       = "bnktannaihouhoukbn";
    public static final String BNKTANNAIKAISIYMD        = "bnktannaikaisiymd";
    public static final String BNKTANNAIENDYMD          = "bnktannaiendymd";
    public static final String HSGTKBTYMD1              = "hsgtkbtymd1";
    public static final String HSGTKBTYMD2              = "hsgtkbtymd2";
    public static final String HSGTKBTKBN1              = "hsgtkbtkbn1";
    public static final String HSGTKBTKBN2              = "hsgtkbtkbn2";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HsgbnktAnnaihouhoukanri primaryKey;

    public GenIT_HsgbnktAnnaihouhoukanri() {
        primaryKey = new PKIT_HsgbnktAnnaihouhoukanri();
    }

    public GenIT_HsgbnktAnnaihouhoukanri(
        String pKbnkey,
        String pSyono,
        BizDate pHsgymd
    ) {
        primaryKey = new PKIT_HsgbnktAnnaihouhoukanri(
            pKbnkey,
            pSyono,
            pHsgymd
        );
    }

    @Transient
    @Override
    public PKIT_HsgbnktAnnaihouhoukanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HsgbnktAnnaihouhoukanri> getMetaClass() {
        return QIT_HsgbnktAnnaihouhoukanri.class;
    }

    @Id
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.HSGYMD)
    @ValidDate
    public BizDate getHsgymd() {
        return getPrimaryKey().getHsgymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHsgymd(BizDate pHsgymd) {
        getPrimaryKey().setHsgymd(pHsgymd);
    }

    private C_BnktAnnaiHouhouKbn bnktannaihouhoukbn;

    @Type(type="UserType_C_BnktAnnaiHouhouKbn")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.BNKTANNAIHOUHOUKBN)
    public C_BnktAnnaiHouhouKbn getBnktannaihouhoukbn() {
        return bnktannaihouhoukbn;
    }

    public void setBnktannaihouhoukbn(C_BnktAnnaiHouhouKbn pBnktannaihouhoukbn) {
        bnktannaihouhoukbn = pBnktannaihouhoukbn;
    }

    private BizDate bnktannaikaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.BNKTANNAIKAISIYMD)
    public BizDate getBnktannaikaisiymd() {
        return bnktannaikaisiymd;
    }

    public void setBnktannaikaisiymd(BizDate pBnktannaikaisiymd) {
        bnktannaikaisiymd = pBnktannaikaisiymd;
    }

    private BizDate bnktannaiendymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.BNKTANNAIENDYMD)
    public BizDate getBnktannaiendymd() {
        return bnktannaiendymd;
    }

    public void setBnktannaiendymd(BizDate pBnktannaiendymd) {
        bnktannaiendymd = pBnktannaiendymd;
    }

    private BizDate hsgtkbtymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.HSGTKBTYMD1)
    public BizDate getHsgtkbtymd1() {
        return hsgtkbtymd1;
    }

    public void setHsgtkbtymd1(BizDate pHsgtkbtymd1) {
        hsgtkbtymd1 = pHsgtkbtymd1;
    }

    private BizDate hsgtkbtymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.HSGTKBTYMD2)
    public BizDate getHsgtkbtymd2() {
        return hsgtkbtymd2;
    }

    public void setHsgtkbtymd2(BizDate pHsgtkbtymd2) {
        hsgtkbtymd2 = pHsgtkbtymd2;
    }

    private String hsgtkbtkbn1;

    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.HSGTKBTKBN1)
    public String getHsgtkbtkbn1() {
        return hsgtkbtkbn1;
    }

    public void setHsgtkbtkbn1(String pHsgtkbtkbn1) {
        hsgtkbtkbn1 = pHsgtkbtkbn1;
    }

    private String hsgtkbtkbn2;

    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.HSGTKBTKBN2)
    public String getHsgtkbtkbn2() {
        return hsgtkbtkbn2;
    }

    public void setHsgtkbtkbn2(String pHsgtkbtkbn2) {
        hsgtkbtkbn2 = pHsgtkbtkbn2;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HsgbnktAnnaihouhoukanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}