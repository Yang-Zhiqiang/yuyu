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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SyssrhKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.id.PKHT_YuukoukknKykList;
import yuyu.def.db.meta.GenQHT_YuukoukknKykList;
import yuyu.def.db.meta.QHT_YuukoukknKykList;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_JimusrhKbn;
import yuyu.def.db.type.UserType_C_KeikaKbn;
import yuyu.def.db.type.UserType_C_KetteiKbn;
import yuyu.def.db.type.UserType_C_SyssrhKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 有効期間経過契約リストテーブル テーブルのマッピング情報クラスで、 {@link HT_YuukoukknKykList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_YuukoukknKykList}</td><td colspan="3">有効期間経過契約リストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_YuukoukknKykList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKHT_YuukoukknKykList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDaimosno daimosno}</td><td>代表申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnnm syusyouhnnm}</td><td>主契約商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDntnm dntnm}</td><td>団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSsyukeymd ssyukeymd}</td><td>支社受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktkktymd kktkktymd}</td><td>告知書告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHjkktymd hjkktymd}</td><td>報状告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKthhbkbn kthhbkbn}</td><td>決定保留不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSrhhbkbn srhhbkbn}</td><td>成立保留不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJimusrhkbn jimusrhkbn}</td><td>事務成立保留区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JimusrhKbn}</td></tr>
 *  <tr><td>{@link #getSyssrhkbn syssrhkbn}</td><td>システム成立保留区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyssrhKbn}</td></tr>
 *  <tr><td>{@link #getKhnhbkbn khnhbkbn}</td><td>基本不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKetteikbn ketteikbn}</td><td>決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KetteiKbn}</td></tr>
 *  <tr><td>{@link #getRfstphrkkeiro rfstphrkkeiro}</td><td>（帳票用）初回保険料払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstphrkkeirokbn fstphrkkeirokbn}</td><td>初回保険料払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>{@link #getKeikakbn keikakbn}</td><td>経過区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KeikaKbn}</td></tr>
 *  <tr><td>{@link #getFstnyknrsymd fstnyknrsymd}</td><td>初回入金領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_YuukoukknKykList
 * @see     PKHT_YuukoukknKykList
 * @see     QHT_YuukoukknKykList
 * @see     GenQHT_YuukoukknKykList
 */
@MappedSuperclass
@Table(name=GenHT_YuukoukknKykList.TABLE_NAME)
@IdClass(value=PKHT_YuukoukknKykList.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_FstphrkkeiroKbn", typeClass=UserType_C_FstphrkkeiroKbn.class),
    @TypeDef(name="UserType_C_JimusrhKbn", typeClass=UserType_C_JimusrhKbn.class),
    @TypeDef(name="UserType_C_KeikaKbn", typeClass=UserType_C_KeikaKbn.class),
    @TypeDef(name="UserType_C_KetteiKbn", typeClass=UserType_C_KetteiKbn.class),
    @TypeDef(name="UserType_C_SyssrhKbn", typeClass=UserType_C_SyssrhKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHT_YuukoukknKykList extends AbstractExDBEntity<HT_YuukoukknKykList, PKHT_YuukoukknKykList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_YuukoukknKykList";
    public static final String MOSNO                    = "mosno";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String DAIMOSNO                 = "daimosno";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String SYUSYOUHNNM              = "syusyouhnnm";
    public static final String DNTCD                    = "dntcd";
    public static final String DNTNM                    = "dntnm";
    public static final String MOSYMD                   = "mosymd";
    public static final String SSYUKEYMD                = "ssyukeymd";
    public static final String KKTKKTYMD                = "kktkktymd";
    public static final String HJKKTYMD                 = "hjkktymd";
    public static final String KTHHBKBN                 = "kthhbkbn";
    public static final String SRHHBKBN                 = "srhhbkbn";
    public static final String JIMUSRHKBN               = "jimusrhkbn";
    public static final String SYSSRHKBN                = "syssrhkbn";
    public static final String KHNHBKBN                 = "khnhbkbn";
    public static final String KETTEIKBN                = "ketteikbn";
    public static final String RFSTPHRKKEIRO            = "rfstphrkkeiro";
    public static final String FSTPHRKKEIROKBN          = "fstphrkkeirokbn";
    public static final String KEIKAKBN                 = "keikakbn";
    public static final String FSTNYKNRSYMD             = "fstnyknrsymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_YuukoukknKykList primaryKey;

    public GenHT_YuukoukknKykList() {
        primaryKey = new PKHT_YuukoukknKykList();
    }

    public GenHT_YuukoukknKykList(String pMosno, BizDate pTyouhyouymd) {
        primaryKey = new PKHT_YuukoukknKykList(pMosno, pTyouhyouymd);
    }

    @Transient
    @Override
    public PKHT_YuukoukknKykList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_YuukoukknKykList> getMetaClass() {
        return QHT_YuukoukknKykList.class;
    }

    @Id
    @Column(name=GenHT_YuukoukknKykList.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String daimosno;

    @Column(name=GenHT_YuukoukknKykList.DAIMOSNO)
    @MousikomiNo
    public String getDaimosno() {
        return daimosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

    private String hhknnmkj;

    @Column(name=GenHT_YuukoukknKykList.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private String kyknmkj;

    @Column(name=GenHT_YuukoukknKykList.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private String syusyouhncd;

    @Column(name=GenHT_YuukoukknKykList.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
    }

    private String syusyouhnnm;

    @Column(name=GenHT_YuukoukknKykList.SYUSYOUHNNM)
    public String getSyusyouhnnm() {
        return syusyouhnnm;
    }

    public void setSyusyouhnnm(String pSyusyouhnnm) {
        syusyouhnnm = pSyusyouhnnm;
    }

    private String dntcd;

    @Column(name=GenHT_YuukoukknKykList.DNTCD)
    @MaxLength(max=8)
    @AlphaDigit
    public String getDntcd() {
        return dntcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDntcd(String pDntcd) {
        dntcd = pDntcd;
    }

    private String dntnm;

    @Column(name=GenHT_YuukoukknKykList.DNTNM)
    public String getDntnm() {
        return dntnm;
    }

    public void setDntnm(String pDntnm) {
        dntnm = pDntnm;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate ssyukeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.SSYUKEYMD)
    @ValidDate
    public BizDate getSsyukeymd() {
        return ssyukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSsyukeymd(BizDate pSsyukeymd) {
        ssyukeymd = pSsyukeymd;
    }

    private BizDate kktkktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.KKTKKTYMD)
    public BizDate getKktkktymd() {
        return kktkktymd;
    }

    public void setKktkktymd(BizDate pKktkktymd) {
        kktkktymd = pKktkktymd;
    }

    private BizDate hjkktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.HJKKTYMD)
    public BizDate getHjkktymd() {
        return hjkktymd;
    }

    public void setHjkktymd(BizDate pHjkktymd) {
        hjkktymd = pHjkktymd;
    }

    private C_UmuKbn kthhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_YuukoukknKykList.KTHHBKBN)
    public C_UmuKbn getKthhbkbn() {
        return kthhbkbn;
    }

    public void setKthhbkbn(C_UmuKbn pKthhbkbn) {
        kthhbkbn = pKthhbkbn;
    }

    private C_UmuKbn srhhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_YuukoukknKykList.SRHHBKBN)
    public C_UmuKbn getSrhhbkbn() {
        return srhhbkbn;
    }

    public void setSrhhbkbn(C_UmuKbn pSrhhbkbn) {
        srhhbkbn = pSrhhbkbn;
    }

    private C_JimusrhKbn jimusrhkbn;

    @Type(type="UserType_C_JimusrhKbn")
    @Column(name=GenHT_YuukoukknKykList.JIMUSRHKBN)
    public C_JimusrhKbn getJimusrhkbn() {
        return jimusrhkbn;
    }

    public void setJimusrhkbn(C_JimusrhKbn pJimusrhkbn) {
        jimusrhkbn = pJimusrhkbn;
    }

    private C_SyssrhKbn syssrhkbn;

    @Type(type="UserType_C_SyssrhKbn")
    @Column(name=GenHT_YuukoukknKykList.SYSSRHKBN)
    public C_SyssrhKbn getSyssrhkbn() {
        return syssrhkbn;
    }

    public void setSyssrhkbn(C_SyssrhKbn pSyssrhkbn) {
        syssrhkbn = pSyssrhkbn;
    }

    private C_UmuKbn khnhbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_YuukoukknKykList.KHNHBKBN)
    public C_UmuKbn getKhnhbkbn() {
        return khnhbkbn;
    }

    public void setKhnhbkbn(C_UmuKbn pKhnhbkbn) {
        khnhbkbn = pKhnhbkbn;
    }

    private C_KetteiKbn ketteikbn;

    @Type(type="UserType_C_KetteiKbn")
    @Column(name=GenHT_YuukoukknKykList.KETTEIKBN)
    public C_KetteiKbn getKetteikbn() {
        return ketteikbn;
    }

    public void setKetteikbn(C_KetteiKbn pKetteikbn) {
        ketteikbn = pKetteikbn;
    }

    private String rfstphrkkeiro;

    @Column(name=GenHT_YuukoukknKykList.RFSTPHRKKEIRO)
    public String getRfstphrkkeiro() {
        return rfstphrkkeiro;
    }

    public void setRfstphrkkeiro(String pRfstphrkkeiro) {
        rfstphrkkeiro = pRfstphrkkeiro;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    @Type(type="UserType_C_FstphrkkeiroKbn")
    @Column(name=GenHT_YuukoukknKykList.FSTPHRKKEIROKBN)
    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private C_KeikaKbn keikakbn;

    @Type(type="UserType_C_KeikaKbn")
    @Column(name=GenHT_YuukoukknKykList.KEIKAKBN)
    public C_KeikaKbn getKeikakbn() {
        return keikakbn;
    }

    public void setKeikakbn(C_KeikaKbn pKeikakbn) {
        keikakbn = pKeikakbn;
    }

    private BizDate fstnyknrsymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_YuukoukknKykList.FSTNYKNRSYMD)
    public BizDate getFstnyknrsymd() {
        return fstnyknrsymd;
    }

    @Trim("both")
    public void setFstnyknrsymd(BizDate pFstnyknrsymd) {
        fstnyknrsymd = pFstnyknrsymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_YuukoukknKykList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_YuukoukknKykList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}