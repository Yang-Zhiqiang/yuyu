package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_MassitknKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyorisimetknKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.id.PKHT_Tokunin;
import yuyu.def.db.meta.GenQHT_Tokunin;
import yuyu.def.db.meta.QHT_Tokunin;
import yuyu.def.db.type.UserType_C_IkkatuyouptknKbn;
import yuyu.def.db.type.UserType_C_KakoymdkyytknKbn;
import yuyu.def.db.type.UserType_C_KzmeigitknKbn;
import yuyu.def.db.type.UserType_C_MassitknKbn;
import yuyu.def.db.type.UserType_C_NenkkntknKbn;
import yuyu.def.db.type.UserType_C_NenreiuptknKbn;
import yuyu.def.db.type.UserType_C_SaiteiptknKbn;
import yuyu.def.db.type.UserType_C_SentakuinfotknKbn;
import yuyu.def.db.type.UserType_C_SignalkaihiKbn;
import yuyu.def.db.type.UserType_C_SonotaTokuninKbn;
import yuyu.def.db.type.UserType_C_SpgndtknKbn;
import yuyu.def.db.type.UserType_C_SyorisimetknKbn;
import yuyu.def.db.type.UserType_C_TsngndtknKbn;
import yuyu.def.db.type.UserType_C_YoteiriritutknKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 特認テーブル テーブルのマッピング情報クラスで、 {@link HT_Tokunin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Tokunin}</td><td colspan="3">特認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_Tokunin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSpgndtknkbn spgndtknkbn}</td><td>ＳＰ限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SpgndtknKbn}</td></tr>
 *  <tr><td>{@link #getNenkkntknkbn nenkkntknkbn}</td><td>年齢期間特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkkntknKbn}</td></tr>
 *  <tr><td>{@link #getTsngndtknkbn tsngndtknkbn}</td><td>通算限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsngndtknKbn}</td></tr>
 *  <tr><td>{@link #getSentakuinfotknkbn sentakuinfotknkbn}</td><td>選択情報特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SentakuinfotknKbn}</td></tr>
 *  <tr><td>{@link #getSyorisimetknkbn syorisimetknkbn}</td><td>処理締切日特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorisimetknKbn}</td></tr>
 *  <tr><td>{@link #getKzmeigitknkbn kzmeigitknkbn}</td><td>口座名義人特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzmeigitknKbn}</td></tr>
 *  <tr><td>{@link #getMassitknkbn massitknkbn}</td><td>末子特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MassitknKbn}</td></tr>
 *  <tr><td>{@link #getKakoymdkyytknkbn kakoymdkyytknkbn}</td><td>過去日付許容特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KakoymdkyytknKbn}</td></tr>
 *  <tr><td>{@link #getSaiteiptknkbn saiteiptknkbn}</td><td>最低P特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaiteiptknKbn}</td></tr>
 *  <tr><td>{@link #getYoteiriritutknkbn yoteiriritutknkbn}</td><td>予定利率特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YoteiriritutknKbn}</td></tr>
 *  <tr><td>{@link #getNenreiuptknkbn nenreiuptknkbn}</td><td>年齢アップ特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenreiuptknKbn}</td></tr>
 *  <tr><td>{@link #getSignalkaihikbn signalkaihikbn}</td><td>シグナル回避区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SignalkaihiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatuyouptknkbn ikkatuyouptknkbn}</td><td>一括要Ｐ特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatuyouptknKbn}</td></tr>
 *  <tr><td>{@link #getSonotatknkbn sonotatknkbn}</td><td>その他特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SonotaTokuninKbn}</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Tokunin
 * @see     PKHT_Tokunin
 * @see     QHT_Tokunin
 * @see     GenQHT_Tokunin
 */
@MappedSuperclass
@Table(name=GenHT_Tokunin.TABLE_NAME)
@IdClass(value=PKHT_Tokunin.class)
@TypeDefs({
    @TypeDef(name="UserType_C_IkkatuyouptknKbn", typeClass=UserType_C_IkkatuyouptknKbn.class),
    @TypeDef(name="UserType_C_KakoymdkyytknKbn", typeClass=UserType_C_KakoymdkyytknKbn.class),
    @TypeDef(name="UserType_C_KzmeigitknKbn", typeClass=UserType_C_KzmeigitknKbn.class),
    @TypeDef(name="UserType_C_MassitknKbn", typeClass=UserType_C_MassitknKbn.class),
    @TypeDef(name="UserType_C_NenkkntknKbn", typeClass=UserType_C_NenkkntknKbn.class),
    @TypeDef(name="UserType_C_NenreiuptknKbn", typeClass=UserType_C_NenreiuptknKbn.class),
    @TypeDef(name="UserType_C_SaiteiptknKbn", typeClass=UserType_C_SaiteiptknKbn.class),
    @TypeDef(name="UserType_C_SentakuinfotknKbn", typeClass=UserType_C_SentakuinfotknKbn.class),
    @TypeDef(name="UserType_C_SignalkaihiKbn", typeClass=UserType_C_SignalkaihiKbn.class),
    @TypeDef(name="UserType_C_SonotaTokuninKbn", typeClass=UserType_C_SonotaTokuninKbn.class),
    @TypeDef(name="UserType_C_SpgndtknKbn", typeClass=UserType_C_SpgndtknKbn.class),
    @TypeDef(name="UserType_C_SyorisimetknKbn", typeClass=UserType_C_SyorisimetknKbn.class),
    @TypeDef(name="UserType_C_TsngndtknKbn", typeClass=UserType_C_TsngndtknKbn.class),
    @TypeDef(name="UserType_C_YoteiriritutknKbn", typeClass=UserType_C_YoteiriritutknKbn.class)
})
public abstract class GenHT_Tokunin extends AbstractExDBEntity<HT_Tokunin, PKHT_Tokunin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_Tokunin";
    public static final String MOSNO                    = "mosno";
    public static final String SPGNDTKNKBN              = "spgndtknkbn";
    public static final String NENKKNTKNKBN             = "nenkkntknkbn";
    public static final String TSNGNDTKNKBN             = "tsngndtknkbn";
    public static final String SENTAKUINFOTKNKBN        = "sentakuinfotknkbn";
    public static final String SYORISIMETKNKBN          = "syorisimetknkbn";
    public static final String KZMEIGITKNKBN            = "kzmeigitknkbn";
    public static final String MASSITKNKBN              = "massitknkbn";
    public static final String KAKOYMDKYYTKNKBN         = "kakoymdkyytknkbn";
    public static final String SAITEIPTKNKBN            = "saiteiptknkbn";
    public static final String YOTEIRIRITUTKNKBN        = "yoteiriritutknkbn";
    public static final String NENREIUPTKNKBN           = "nenreiuptknkbn";
    public static final String SIGNALKAIHIKBN           = "signalkaihikbn";
    public static final String IKKATUYOUPTKNKBN         = "ikkatuyouptknkbn";
    public static final String SONOTATKNKBN             = "sonotatknkbn";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_Tokunin primaryKey;

    public GenHT_Tokunin() {
        primaryKey = new PKHT_Tokunin();
    }

    public GenHT_Tokunin(String pMosno) {
        primaryKey = new PKHT_Tokunin(pMosno);
    }

    @Transient
    @Override
    public PKHT_Tokunin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_Tokunin> getMetaClass() {
        return QHT_Tokunin.class;
    }

    @Id
    @Column(name=GenHT_Tokunin.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private C_SpgndtknKbn spgndtknkbn;

    @Type(type="UserType_C_SpgndtknKbn")
    @Column(name=GenHT_Tokunin.SPGNDTKNKBN)
    public C_SpgndtknKbn getSpgndtknkbn() {
        return spgndtknkbn;
    }

    public void setSpgndtknkbn(C_SpgndtknKbn pSpgndtknkbn) {
        spgndtknkbn = pSpgndtknkbn;
    }

    private C_NenkkntknKbn nenkkntknkbn;

    @Type(type="UserType_C_NenkkntknKbn")
    @Column(name=GenHT_Tokunin.NENKKNTKNKBN)
    public C_NenkkntknKbn getNenkkntknkbn() {
        return nenkkntknkbn;
    }

    public void setNenkkntknkbn(C_NenkkntknKbn pNenkkntknkbn) {
        nenkkntknkbn = pNenkkntknkbn;
    }

    private C_TsngndtknKbn tsngndtknkbn;

    @Type(type="UserType_C_TsngndtknKbn")
    @Column(name=GenHT_Tokunin.TSNGNDTKNKBN)
    public C_TsngndtknKbn getTsngndtknkbn() {
        return tsngndtknkbn;
    }

    public void setTsngndtknkbn(C_TsngndtknKbn pTsngndtknkbn) {
        tsngndtknkbn = pTsngndtknkbn;
    }

    private C_SentakuinfotknKbn sentakuinfotknkbn;

    @Type(type="UserType_C_SentakuinfotknKbn")
    @Column(name=GenHT_Tokunin.SENTAKUINFOTKNKBN)
    public C_SentakuinfotknKbn getSentakuinfotknkbn() {
        return sentakuinfotknkbn;
    }

    public void setSentakuinfotknkbn(C_SentakuinfotknKbn pSentakuinfotknkbn) {
        sentakuinfotknkbn = pSentakuinfotknkbn;
    }

    private C_SyorisimetknKbn syorisimetknkbn;

    @Type(type="UserType_C_SyorisimetknKbn")
    @Column(name=GenHT_Tokunin.SYORISIMETKNKBN)
    public C_SyorisimetknKbn getSyorisimetknkbn() {
        return syorisimetknkbn;
    }

    public void setSyorisimetknkbn(C_SyorisimetknKbn pSyorisimetknkbn) {
        syorisimetknkbn = pSyorisimetknkbn;
    }

    private C_KzmeigitknKbn kzmeigitknkbn;

    @Type(type="UserType_C_KzmeigitknKbn")
    @Column(name=GenHT_Tokunin.KZMEIGITKNKBN)
    public C_KzmeigitknKbn getKzmeigitknkbn() {
        return kzmeigitknkbn;
    }

    public void setKzmeigitknkbn(C_KzmeigitknKbn pKzmeigitknkbn) {
        kzmeigitknkbn = pKzmeigitknkbn;
    }

    private C_MassitknKbn massitknkbn;

    @Type(type="UserType_C_MassitknKbn")
    @Column(name=GenHT_Tokunin.MASSITKNKBN)
    public C_MassitknKbn getMassitknkbn() {
        return massitknkbn;
    }

    public void setMassitknkbn(C_MassitknKbn pMassitknkbn) {
        massitknkbn = pMassitknkbn;
    }

    private C_KakoymdkyytknKbn kakoymdkyytknkbn;

    @Type(type="UserType_C_KakoymdkyytknKbn")
    @Column(name=GenHT_Tokunin.KAKOYMDKYYTKNKBN)
    public C_KakoymdkyytknKbn getKakoymdkyytknkbn() {
        return kakoymdkyytknkbn;
    }

    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn pKakoymdkyytknkbn) {
        kakoymdkyytknkbn = pKakoymdkyytknkbn;
    }

    private C_SaiteiptknKbn saiteiptknkbn;

    @Type(type="UserType_C_SaiteiptknKbn")
    @Column(name=GenHT_Tokunin.SAITEIPTKNKBN)
    public C_SaiteiptknKbn getSaiteiptknkbn() {
        return saiteiptknkbn;
    }

    public void setSaiteiptknkbn(C_SaiteiptknKbn pSaiteiptknkbn) {
        saiteiptknkbn = pSaiteiptknkbn;
    }

    private C_YoteiriritutknKbn yoteiriritutknkbn;

    @Type(type="UserType_C_YoteiriritutknKbn")
    @Column(name=GenHT_Tokunin.YOTEIRIRITUTKNKBN)
    public C_YoteiriritutknKbn getYoteiriritutknkbn() {
        return yoteiriritutknkbn;
    }

    public void setYoteiriritutknkbn(C_YoteiriritutknKbn pYoteiriritutknkbn) {
        yoteiriritutknkbn = pYoteiriritutknkbn;
    }

    private C_NenreiuptknKbn nenreiuptknkbn;

    @Type(type="UserType_C_NenreiuptknKbn")
    @Column(name=GenHT_Tokunin.NENREIUPTKNKBN)
    public C_NenreiuptknKbn getNenreiuptknkbn() {
        return nenreiuptknkbn;
    }

    public void setNenreiuptknkbn(C_NenreiuptknKbn pNenreiuptknkbn) {
        nenreiuptknkbn = pNenreiuptknkbn;
    }

    private C_SignalkaihiKbn signalkaihikbn;

    @Type(type="UserType_C_SignalkaihiKbn")
    @Column(name=GenHT_Tokunin.SIGNALKAIHIKBN)
    public C_SignalkaihiKbn getSignalkaihikbn() {
        return signalkaihikbn;
    }

    public void setSignalkaihikbn(C_SignalkaihiKbn pSignalkaihikbn) {
        signalkaihikbn = pSignalkaihikbn;
    }

    private C_IkkatuyouptknKbn ikkatuyouptknkbn;

    @Type(type="UserType_C_IkkatuyouptknKbn")
    @Column(name=GenHT_Tokunin.IKKATUYOUPTKNKBN)
    public C_IkkatuyouptknKbn getIkkatuyouptknkbn() {
        return ikkatuyouptknkbn;
    }

    public void setIkkatuyouptknkbn(C_IkkatuyouptknKbn pIkkatuyouptknkbn) {
        ikkatuyouptknkbn = pIkkatuyouptknkbn;
    }

    private C_SonotaTokuninKbn sonotatknkbn;

    @Type(type="UserType_C_SonotaTokuninKbn")
    @Column(name=GenHT_Tokunin.SONOTATKNKBN)
    public C_SonotaTokuninKbn getSonotatknkbn() {
        return sonotatknkbn;
    }

    public void setSonotatknkbn(C_SonotaTokuninKbn pSonotatknkbn) {
        sonotatknkbn = pSonotatknkbn;
    }

    private String ketsyacd;

    @Column(name=GenHT_Tokunin.KETSYACD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getKetsyacd() {
        return ketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetsyacd(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_Tokunin.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_Tokunin.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}