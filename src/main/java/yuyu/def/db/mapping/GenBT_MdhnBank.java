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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KydsskkinyuukntkyKbn;
import yuyu.def.classification.C_MdhncifcdknrKbn;
import yuyu.def.classification.C_MdhnhontensitenKbn;
import yuyu.def.classification.C_MdhntyhyhrtkKbn;
import yuyu.def.classification.C_TkrtkkinyuukntkyKbn;
import yuyu.def.db.entity.BT_MdhnBank;
import yuyu.def.db.id.PKBT_MdhnBank;
import yuyu.def.db.meta.GenQBT_MdhnBank;
import yuyu.def.db.meta.QBT_MdhnBank;
import yuyu.def.db.type.UserType_C_KydsskkinyuukntkyKbn;
import yuyu.def.db.type.UserType_C_MdhncifcdknrKbn;
import yuyu.def.db.type.UserType_C_MdhnhontensitenKbn;
import yuyu.def.db.type.UserType_C_MdhntyhyhrtkKbn;
import yuyu.def.db.type.UserType_C_TkrtkkinyuukntkyKbn;

/**
 * 窓販銀行テーブル テーブルのマッピング情報クラスで、 {@link BT_MdhnBank} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_MdhnBank}</td><td colspan="3">窓販銀行テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBT_MdhnBank ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMdhnbankcd mdhnbankcd}</td><td>窓販銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMdhnhontensitenkbn mdhnhontensitenkbn}</td><td>窓販本店支店区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MdhnhontensitenKbn}</td></tr>
 *  <tr><td>{@link #getMdhnsitencd mdhnsitencd}</td><td>窓販支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMdhncifcdknrkbn mdhncifcdknrkbn}</td><td>窓販ＣＩＦコード管理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MdhncifcdknrKbn}</td></tr>
 *  <tr><td>{@link #getTkrtkkinyuukntkykbn tkrtkkinyuukntkykbn}</td><td>特例地域金融機関適用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkrtkkinyuukntkyKbn}</td></tr>
 *  <tr><td>{@link #getTkrtkkinyuukntkyymd tkrtkkinyuukntkyymd}</td><td>特例地域金融機関適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKydsskkinyuukntkykbn kydsskkinyuukntkykbn}</td><td>協同組織金融機関適用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KydsskkinyuukntkyKbn}</td></tr>
 *  <tr><td>{@link #getKydsskkinyuukntkyymd kydsskkinyuukntkyymd}</td><td>協同組織金融機関適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMdhntyhyhrtkkbn mdhntyhyhrtkkbn}</td><td>窓販帳票配列区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MdhntyhyhrtkKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_MdhnBank
 * @see     PKBT_MdhnBank
 * @see     QBT_MdhnBank
 * @see     GenQBT_MdhnBank
 */
@MappedSuperclass
@Table(name=GenBT_MdhnBank.TABLE_NAME)
@IdClass(value=PKBT_MdhnBank.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KydsskkinyuukntkyKbn", typeClass=UserType_C_KydsskkinyuukntkyKbn.class),
    @TypeDef(name="UserType_C_MdhncifcdknrKbn", typeClass=UserType_C_MdhncifcdknrKbn.class),
    @TypeDef(name="UserType_C_MdhnhontensitenKbn", typeClass=UserType_C_MdhnhontensitenKbn.class),
    @TypeDef(name="UserType_C_MdhntyhyhrtkKbn", typeClass=UserType_C_MdhntyhyhrtkKbn.class),
    @TypeDef(name="UserType_C_TkrtkkinyuukntkyKbn", typeClass=UserType_C_TkrtkkinyuukntkyKbn.class)
})
public abstract class GenBT_MdhnBank extends AbstractExDBEntity<BT_MdhnBank, PKBT_MdhnBank> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_MdhnBank";
    public static final String DRTENCD                  = "drtencd";
    public static final String MDHNBANKCD               = "mdhnbankcd";
    public static final String MDHNHONTENSITENKBN       = "mdhnhontensitenkbn";
    public static final String MDHNSITENCD              = "mdhnsitencd";
    public static final String MDHNCIFCDKNRKBN          = "mdhncifcdknrkbn";
    public static final String TKRTKKINYUUKNTKYKBN      = "tkrtkkinyuukntkykbn";
    public static final String TKRTKKINYUUKNTKYYMD      = "tkrtkkinyuukntkyymd";
    public static final String KYDSSKKINYUUKNTKYKBN     = "kydsskkinyuukntkykbn";
    public static final String KYDSSKKINYUUKNTKYYMD     = "kydsskkinyuukntkyymd";
    public static final String MDHNTYHYHRTKKBN          = "mdhntyhyhrtkkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_MdhnBank primaryKey;

    public GenBT_MdhnBank() {
        primaryKey = new PKBT_MdhnBank();
    }

    public GenBT_MdhnBank(String pDrtencd) {
        primaryKey = new PKBT_MdhnBank(pDrtencd);
    }

    @Transient
    @Override
    public PKBT_MdhnBank getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_MdhnBank> getMetaClass() {
        return QBT_MdhnBank.class;
    }

    @Id
    @Column(name=GenBT_MdhnBank.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    private String mdhnbankcd;

    @Column(name=GenBT_MdhnBank.MDHNBANKCD)
    @Length(length=4)
    @SingleByteStrings
    @Digit
    public String getMdhnbankcd() {
        return mdhnbankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMdhnbankcd(String pMdhnbankcd) {
        mdhnbankcd = pMdhnbankcd;
    }

    private C_MdhnhontensitenKbn mdhnhontensitenkbn;

    @Type(type="UserType_C_MdhnhontensitenKbn")
    @Column(name=GenBT_MdhnBank.MDHNHONTENSITENKBN)
    public C_MdhnhontensitenKbn getMdhnhontensitenkbn() {
        return mdhnhontensitenkbn;
    }

    public void setMdhnhontensitenkbn(C_MdhnhontensitenKbn pMdhnhontensitenkbn) {
        mdhnhontensitenkbn = pMdhnhontensitenkbn;
    }

    private String mdhnsitencd;

    @Column(name=GenBT_MdhnBank.MDHNSITENCD)
    @Length(length=3)
    @SingleByteStrings
    @Digit
    public String getMdhnsitencd() {
        return mdhnsitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMdhnsitencd(String pMdhnsitencd) {
        mdhnsitencd = pMdhnsitencd;
    }

    private C_MdhncifcdknrKbn mdhncifcdknrkbn;

    @Type(type="UserType_C_MdhncifcdknrKbn")
    @Column(name=GenBT_MdhnBank.MDHNCIFCDKNRKBN)
    public C_MdhncifcdknrKbn getMdhncifcdknrkbn() {
        return mdhncifcdknrkbn;
    }

    public void setMdhncifcdknrkbn(C_MdhncifcdknrKbn pMdhncifcdknrkbn) {
        mdhncifcdknrkbn = pMdhncifcdknrkbn;
    }

    private C_TkrtkkinyuukntkyKbn tkrtkkinyuukntkykbn;

    @Type(type="UserType_C_TkrtkkinyuukntkyKbn")
    @Column(name=GenBT_MdhnBank.TKRTKKINYUUKNTKYKBN)
    public C_TkrtkkinyuukntkyKbn getTkrtkkinyuukntkykbn() {
        return tkrtkkinyuukntkykbn;
    }

    public void setTkrtkkinyuukntkykbn(C_TkrtkkinyuukntkyKbn pTkrtkkinyuukntkykbn) {
        tkrtkkinyuukntkykbn = pTkrtkkinyuukntkykbn;
    }

    private BizDate tkrtkkinyuukntkyymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_MdhnBank.TKRTKKINYUUKNTKYYMD)
    @ValidDate
    public BizDate getTkrtkkinyuukntkyymd() {
        return tkrtkkinyuukntkyymd;
    }

    @Trim("both")
    public void setTkrtkkinyuukntkyymd(BizDate pTkrtkkinyuukntkyymd) {
        tkrtkkinyuukntkyymd = pTkrtkkinyuukntkyymd;
    }

    private C_KydsskkinyuukntkyKbn kydsskkinyuukntkykbn;

    @Type(type="UserType_C_KydsskkinyuukntkyKbn")
    @Column(name=GenBT_MdhnBank.KYDSSKKINYUUKNTKYKBN)
    public C_KydsskkinyuukntkyKbn getKydsskkinyuukntkykbn() {
        return kydsskkinyuukntkykbn;
    }

    public void setKydsskkinyuukntkykbn(C_KydsskkinyuukntkyKbn pKydsskkinyuukntkykbn) {
        kydsskkinyuukntkykbn = pKydsskkinyuukntkykbn;
    }

    private BizDate kydsskkinyuukntkyymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_MdhnBank.KYDSSKKINYUUKNTKYYMD)
    @ValidDate
    public BizDate getKydsskkinyuukntkyymd() {
        return kydsskkinyuukntkyymd;
    }

    @Trim("both")
    public void setKydsskkinyuukntkyymd(BizDate pKydsskkinyuukntkyymd) {
        kydsskkinyuukntkyymd = pKydsskkinyuukntkyymd;
    }

    private C_MdhntyhyhrtkKbn mdhntyhyhrtkkbn;

    @Type(type="UserType_C_MdhntyhyhrtkKbn")
    @Column(name=GenBT_MdhnBank.MDHNTYHYHRTKKBN)
    public C_MdhntyhyhrtkKbn getMdhntyhyhrtkkbn() {
        return mdhntyhyhrtkkbn;
    }

    public void setMdhntyhyhrtkkbn(C_MdhntyhyhrtkKbn pMdhntyhyhrtkkbn) {
        mdhntyhyhrtkkbn = pMdhntyhyhrtkkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_MdhnBank.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_MdhnBank.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_MdhnBank.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
