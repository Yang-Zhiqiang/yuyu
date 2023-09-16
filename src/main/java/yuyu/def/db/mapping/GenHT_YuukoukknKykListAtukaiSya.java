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
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.id.PKHT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.GenQHT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.QHT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.type.UserType_C_KeikaKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 有効期間経過契約リスト扱者テーブル テーブルのマッピング情報クラスで、 {@link HT_YuukoukknKykListAtukaiSya} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_YuukoukknKykListAtukaiSya}</td><td colspan="3">有効期間経過契約リスト扱者テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_YuukoukknKykListAtukaiSya ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKHT_YuukoukknKykListAtukaiSya ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeikakbn keikakbn}</td><td>経過区分</td><td align="center">{@link PKHT_YuukoukknKykListAtukaiSya ○}</td><td align="center">V</td><td>{@link C_KeikaKbn}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_YuukoukknKykListAtukaiSya ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKinyuucd kinyuucd}</td><td>金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuusitencd kinyuusitencd}</td><td>金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennm drtennm}</td><td>代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagnm tratkiagnm}</td><td>取扱代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtennm oyadrtennm}</td><td>親代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimusyocd jimusyocd}</td><td>事務所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuutrkno bosyuutrkno}</td><td>募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuunm bosyuunm}</td><td>募集人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_YuukoukknKykListAtukaiSya
 * @see     PKHT_YuukoukknKykListAtukaiSya
 * @see     QHT_YuukoukknKykListAtukaiSya
 * @see     GenQHT_YuukoukknKykListAtukaiSya
 */
@MappedSuperclass
@Table(name=GenHT_YuukoukknKykListAtukaiSya.TABLE_NAME)
@IdClass(value=PKHT_YuukoukknKykListAtukaiSya.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KeikaKbn", typeClass=UserType_C_KeikaKbn.class)
})
public abstract class GenHT_YuukoukknKykListAtukaiSya extends AbstractExDBEntity<HT_YuukoukknKykListAtukaiSya, PKHT_YuukoukknKykListAtukaiSya> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_YuukoukknKykListAtukaiSya";
    public static final String MOSNO                    = "mosno";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String KEIKAKBN                 = "keikakbn";
    public static final String RENNO                    = "renno";
    public static final String KINYUUCD                 = "kinyuucd";
    public static final String KINYUUSITENCD            = "kinyuusitencd";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENNM                  = "drtennm";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String TRATKIAGNM               = "tratkiagnm";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String OYADRTENNM               = "oyadrtennm";
    public static final String JIMUSYOCD                = "jimusyocd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String BOSYUUTRKNO              = "bosyuutrkno";
    public static final String BOSYUUNM                 = "bosyuunm";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_YuukoukknKykListAtukaiSya primaryKey;

    public GenHT_YuukoukknKykListAtukaiSya() {
        primaryKey = new PKHT_YuukoukknKykListAtukaiSya();
    }

    public GenHT_YuukoukknKykListAtukaiSya(
        String pMosno,
        BizDate pTyouhyouymd,
        C_KeikaKbn pKeikakbn,
        Integer pRenno
    ) {
        primaryKey = new PKHT_YuukoukknKykListAtukaiSya(
            pMosno,
            pTyouhyouymd,
            pKeikakbn,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHT_YuukoukknKykListAtukaiSya getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_YuukoukknKykListAtukaiSya> getMetaClass() {
        return QHT_YuukoukknKykListAtukaiSya.class;
    }

    @Id
    @Column(name=GenHT_YuukoukknKykListAtukaiSya.MOSNO)
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
    @Column(name=GenHT_YuukoukknKykListAtukaiSya.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Type(type="UserType_C_KeikaKbn")
    @Column(name=GenHT_YuukoukknKykListAtukaiSya.KEIKAKBN)
    public C_KeikaKbn getKeikakbn() {
        return getPrimaryKey().getKeikakbn();
    }

    public void setKeikakbn(C_KeikaKbn pKeikakbn) {
        getPrimaryKey().setKeikakbn(pKeikakbn);
    }

    @Id
    @Column(name=GenHT_YuukoukknKykListAtukaiSya.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String kinyuucd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.KINYUUCD)
    public String getKinyuucd() {
        return kinyuucd;
    }

    public void setKinyuucd(String pKinyuucd) {
        kinyuucd = pKinyuucd;
    }

    private String kinyuusitencd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.KINYUUSITENCD)
    public String getKinyuusitencd() {
        return kinyuusitencd;
    }

    public void setKinyuusitencd(String pKinyuusitencd) {
        kinyuusitencd = pKinyuusitencd;
    }

    private String drtencd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtennm;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.DRTENNM)
    public String getDrtennm() {
        return drtennm;
    }

    public void setDrtennm(String pDrtennm) {
        drtennm = pDrtennm;
    }

    private String tratkiagcd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private String tratkiagnm;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.TRATKIAGNM)
    public String getTratkiagnm() {
        return tratkiagnm;
    }

    public void setTratkiagnm(String pTratkiagnm) {
        tratkiagnm = pTratkiagnm;
    }

    private String oyadrtencd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String oyadrtennm;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.OYADRTENNM)
    public String getOyadrtennm() {
        return oyadrtennm;
    }

    public void setOyadrtennm(String pOyadrtennm) {
        oyadrtennm = pOyadrtennm;
    }

    private String jimusyocd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.JIMUSYOCD)
    @Length(length=4)
    @AlphaDigit
    public String getJimusyocd() {
        return jimusyocd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimusyocd(String pJimusyocd) {
        jimusyocd = pJimusyocd;
    }

    private String bosyuucd;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    private String bosyuutrkno;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.BOSYUUTRKNO)
    public String getBosyuutrkno() {
        return bosyuutrkno;
    }

    public void setBosyuutrkno(String pBosyuutrkno) {
        bosyuutrkno = pBosyuutrkno;
    }

    private String bosyuunm;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.BOSYUUNM)
    public String getBosyuunm() {
        return bosyuunm;
    }

    public void setBosyuunm(String pBosyuunm) {
        bosyuunm = pBosyuunm;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_YuukoukknKykListAtukaiSya.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}