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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_NykntratkiKbn;
import yuyu.def.classification.C_TrksskssouhuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.id.PKHM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.GenQHM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.QHM_SkDairitenKobetuJyouhou;
import yuyu.def.db.type.UserType_C_DrtenRnrkhouKbn;
import yuyu.def.db.type.UserType_C_NykntratkiKbn;
import yuyu.def.db.type.UserType_C_TrksskssouhuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 代理店個別情報マスタ テーブルのマッピング情報クラスで、 {@link HM_SkDairitenKobetuJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkDairitenKobetuJyouhou}</td><td colspan="3">代理店個別情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">{@link PKHM_SkDairitenKobetuJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenRnrkhouKbn drtenRnrkhouKbn}</td><td>代理店連絡方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtenRnrkhouKbn}</td></tr>
 *  <tr><td>{@link #getUtdskknnm1kj utdskknnm1kj}</td><td>打出機関名１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUtdskknnm2kj utdskknnm2kj}</td><td>打出機関名２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykntratkikbn nykntratkikbn}</td><td>入金取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NykntratkiKbn}</td></tr>
 *  <tr><td>{@link #getTrksskssouhukbn trksskssouhukbn}</td><td>取消請求書送付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrksskssouhuKbn}</td></tr>
 *  <tr><td>{@link #getTkhjnkinyuucd tkhjnkinyuucd}</td><td>特定関係法人金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtentrkno drtentrkno}</td><td>代理店登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcdcheckyouhi cifcdcheckyouhi}</td><td>ＣＩＦコードチェック要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getCifcdsiteiketasuu cifcdsiteiketasuu}</td><td>ＣＩＦコード指定桁数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcdmaezeroumeyouhi cifcdmaezeroumeyouhi}</td><td>ＣＩＦコード前ゼロ埋め要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getKosymd kosymd}</td><td>更新日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SkDairitenKobetuJyouhou
 * @see     PKHM_SkDairitenKobetuJyouhou
 * @see     QHM_SkDairitenKobetuJyouhou
 * @see     GenQHM_SkDairitenKobetuJyouhou
 */
@MappedSuperclass
@Table(name=GenHM_SkDairitenKobetuJyouhou.TABLE_NAME)
@IdClass(value=PKHM_SkDairitenKobetuJyouhou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DrtenRnrkhouKbn", typeClass=UserType_C_DrtenRnrkhouKbn.class),
    @TypeDef(name="UserType_C_NykntratkiKbn", typeClass=UserType_C_NykntratkiKbn.class),
    @TypeDef(name="UserType_C_TrksskssouhuKbn", typeClass=UserType_C_TrksskssouhuKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class),
    @TypeDef(name="UserType_C_YouhiblnkKbn", typeClass=UserType_C_YouhiblnkKbn.class)
})
public abstract class GenHM_SkDairitenKobetuJyouhou extends AbstractExDBEntity<HM_SkDairitenKobetuJyouhou, PKHM_SkDairitenKobetuJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkDairitenKobetuJyouhou";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String DRTENRNRKHOUKBN          = "drtenRnrkhouKbn";
    public static final String UTDSKKNNM1KJ             = "utdskknnm1kj";
    public static final String UTDSKKNNM2KJ             = "utdskknnm2kj";
    public static final String NYKNTRATKIKBN            = "nykntratkikbn";
    public static final String TRKSSKSSOUHUKBN          = "trksskssouhukbn";
    public static final String TKHJNKINYUUCD            = "tkhjnkinyuucd";
    public static final String DRTENTRKNO               = "drtentrkno";
    public static final String CIFCDCHECKYOUHI          = "cifcdcheckyouhi";
    public static final String CIFCDSITEIKETASUU        = "cifcdsiteiketasuu";
    public static final String CIFCDMAEZEROUMEYOUHI     = "cifcdmaezeroumeyouhi";
    public static final String KOSYMD                   = "kosymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHM_SkDairitenKobetuJyouhou primaryKey;

    public GenHM_SkDairitenKobetuJyouhou() {
        primaryKey = new PKHM_SkDairitenKobetuJyouhou();
    }

    public GenHM_SkDairitenKobetuJyouhou(String pOyadrtencd) {
        primaryKey = new PKHM_SkDairitenKobetuJyouhou(pOyadrtencd);
    }

    @Transient
    @Override
    public PKHM_SkDairitenKobetuJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkDairitenKobetuJyouhou> getMetaClass() {
        return QHM_SkDairitenKobetuJyouhou.class;
    }

    @Id
    @Column(name=GenHM_SkDairitenKobetuJyouhou.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return getPrimaryKey().getOyadrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        getPrimaryKey().setOyadrtencd(pOyadrtencd);
    }

    private C_DrtenRnrkhouKbn drtenRnrkhouKbn;

    @Type(type="UserType_C_DrtenRnrkhouKbn")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.DRTENRNRKHOUKBN)
    public C_DrtenRnrkhouKbn getDrtenRnrkhouKbn() {
        return drtenRnrkhouKbn;
    }

    public void setDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {
        drtenRnrkhouKbn = pDrtenRnrkhouKbn;
    }

    private String utdskknnm1kj;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.UTDSKKNNM1KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    private String utdskknnm2kj;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.UTDSKKNNM2KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    private C_NykntratkiKbn nykntratkikbn;

    @Type(type="UserType_C_NykntratkiKbn")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.NYKNTRATKIKBN)
    public C_NykntratkiKbn getNykntratkikbn() {
        return nykntratkikbn;
    }

    public void setNykntratkikbn(C_NykntratkiKbn pNykntratkikbn) {
        nykntratkikbn = pNykntratkikbn;
    }

    private C_TrksskssouhuKbn trksskssouhukbn;

    @Type(type="UserType_C_TrksskssouhuKbn")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.TRKSSKSSOUHUKBN)
    public C_TrksskssouhuKbn getTrksskssouhukbn() {
        return trksskssouhukbn;
    }

    public void setTrksskssouhukbn(C_TrksskssouhuKbn pTrksskssouhukbn) {
        trksskssouhukbn = pTrksskssouhukbn;
    }

    private String tkhjnkinyuucd;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.TKHJNKINYUUCD)
    @AlphaDigit
    @MaxLength(max=4)
    public String getTkhjnkinyuucd() {
        return tkhjnkinyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhjnkinyuucd(String pTkhjnkinyuucd) {
        tkhjnkinyuucd = pTkhjnkinyuucd;
    }

    private String drtentrkno;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.DRTENTRKNO)
    @Length(length=13)
    @SingleByteStrings
    @AlphaDigit
    public String getDrtentrkno() {
        return drtentrkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtentrkno(String pDrtentrkno) {
        drtentrkno = pDrtentrkno;
    }

    private C_YouhiKbn cifcdcheckyouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.CIFCDCHECKYOUHI)
    public C_YouhiKbn getCifcdcheckyouhi() {
        return cifcdcheckyouhi;
    }

    public void setCifcdcheckyouhi(C_YouhiKbn pCifcdcheckyouhi) {
        cifcdcheckyouhi = pCifcdcheckyouhi;
    }

    private String cifcdsiteiketasuu;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.CIFCDSITEIKETASUU)
    @MaxLength(max=2)
    @SingleByteStrings
    @Digit
    public String getCifcdsiteiketasuu() {
        return cifcdsiteiketasuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcdsiteiketasuu(String pCifcdsiteiketasuu) {
        cifcdsiteiketasuu = pCifcdsiteiketasuu;
    }

    private C_YouhiblnkKbn cifcdmaezeroumeyouhi;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.CIFCDMAEZEROUMEYOUHI)
    public C_YouhiblnkKbn getCifcdmaezeroumeyouhi() {
        return cifcdmaezeroumeyouhi;
    }

    public void setCifcdmaezeroumeyouhi(C_YouhiblnkKbn pCifcdmaezeroumeyouhi) {
        cifcdmaezeroumeyouhi = pCifcdmaezeroumeyouhi;
    }

    private BizDate kosymd;

    @Type(type="BizDateType")
    @Column(name=GenHM_SkDairitenKobetuJyouhou.KOSYMD)
    public BizDate getKosymd() {
        return kosymd;
    }

    public void setKosymd(BizDate pKosymd) {
        kosymd = pKosymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHM_SkDairitenKobetuJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}