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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_CreditdataKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.id.PKIT_TRDattai;
import yuyu.def.db.meta.GenQIT_TRDattai;
import yuyu.def.db.meta.QIT_TRDattai;
import yuyu.def.db.type.UserType_C_CardBrandKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_CreditdataKbn;
import yuyu.def.db.type.UserType_C_Dattaikeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 脱退ＴＲテーブル テーブルのマッピング情報クラスで、 {@link IT_TRDattai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRDattai}</td><td colspan="3">脱退ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_TRDattai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_TRDattai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKIT_TRDattai ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDattaitrrenno dattaitrrenno}</td><td>脱退TR連番</td><td align="center">{@link PKIT_TRDattai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDattaikeiro dattaikeiro}</td><td>脱退経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Dattaikeiro}</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHurihunokbn hurihunokbn}</td><td>振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HurihunoKbn}</td></tr>
 *  <tr><td>{@link #getHurikaeymd hurikaeymd}</td><td>振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCreditdatakbn creditdatakbn}</td><td>クレジットデータ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditdataKbn}</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditbrerrorcd creditbrerrorcd}</td><td>クレジット払エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Creditbrerrorcd}</td></tr>
 *  <tr><td>{@link #getDattaiym dattaiym}</td><td>脱退年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getJyutoukaisuuy jyutoukaisuuy}</td><td>充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getJyutoukaisuum jyutoukaisuum}</td><td>充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardbrandkbn cardbrandkbn}</td><td>カードブランド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CardBrandKbn}</td></tr>
 *  <tr><td>{@link #getCreditkaiinnosimo4keta creditkaiinnosimo4keta}</td><td>クレジット会員番号（下４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRDattai
 * @see     PKIT_TRDattai
 * @see     QIT_TRDattai
 * @see     GenQIT_TRDattai
 */
@MappedSuperclass
@Table(name=GenIT_TRDattai.TABLE_NAME)
@IdClass(value=PKIT_TRDattai.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_CardBrandKbn", typeClass=UserType_C_CardBrandKbn.class),
    @TypeDef(name="UserType_C_Creditbrerrorcd", typeClass=UserType_C_Creditbrerrorcd.class),
    @TypeDef(name="UserType_C_CreditdataKbn", typeClass=UserType_C_CreditdataKbn.class),
    @TypeDef(name="UserType_C_Dattaikeiro", typeClass=UserType_C_Dattaikeiro.class),
    @TypeDef(name="UserType_C_HurihunoKbn", typeClass=UserType_C_HurihunoKbn.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_TRDattai extends AbstractExDBEntity<IT_TRDattai, PKIT_TRDattai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_TRDattai";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String DATTAITRRENNO            = "dattaitrrenno";
    public static final String DATTAIKEIRO              = "dattaikeiro";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String HURIHUNOKBN              = "hurihunokbn";
    public static final String HURIKAEYMD               = "hurikaeymd";
    public static final String CREDITDATAKBN            = "creditdatakbn";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String CREDITBRERRORCD          = "creditbrerrorcd";
    public static final String DATTAIYM                 = "dattaiym";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String JYUTOUKAISUUY            = "jyutoukaisuuy";
    public static final String JYUTOUKAISUUM            = "jyutoukaisuum";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CARDBRANDKBN             = "cardbrandkbn";
    public static final String CREDITKAIINNOSIMO4KETA   = "creditkaiinnosimo4keta";

    private final PKIT_TRDattai primaryKey;

    public GenIT_TRDattai() {
        primaryKey = new PKIT_TRDattai();
    }

    public GenIT_TRDattai(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd,
        String pDattaitrrenno
    ) {
        primaryKey = new PKIT_TRDattai(
            pKbnkey,
            pSyono,
            pSyoriYmd,
            pDattaitrrenno
        );
    }

    @Transient
    @Override
    public PKIT_TRDattai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_TRDattai> getMetaClass() {
        return QIT_TRDattai.class;
    }

    @Id
    @Column(name=GenIT_TRDattai.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_TRDattai.SYONO)
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
    @Column(name=GenIT_TRDattai.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenIT_TRDattai.DATTAITRRENNO)
    public String getDattaitrrenno() {
        return getPrimaryKey().getDattaitrrenno();
    }

    public void setDattaitrrenno(String pDattaitrrenno) {
        getPrimaryKey().setDattaitrrenno(pDattaitrrenno);
    }

    private C_Dattaikeiro dattaikeiro;

    @Type(type="UserType_C_Dattaikeiro")
    @Column(name=GenIT_TRDattai.DATTAIKEIRO)
    public C_Dattaikeiro getDattaikeiro() {
        return dattaikeiro;
    }

    public void setDattaikeiro(C_Dattaikeiro pDattaikeiro) {
        dattaikeiro = pDattaikeiro;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenIT_TRDattai.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private String bankcd;

    @Column(name=GenIT_TRDattai.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_TRDattai.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_TRDattai.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_TRDattai.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_HurihunoKbn hurihunokbn;

    @Type(type="UserType_C_HurihunoKbn")
    @Column(name=GenIT_TRDattai.HURIHUNOKBN)
    public C_HurihunoKbn getHurihunokbn() {
        return hurihunokbn;
    }

    public void setHurihunokbn(C_HurihunoKbn pHurihunokbn) {
        hurihunokbn = pHurihunokbn;
    }

    private BizDate hurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_TRDattai.HURIKAEYMD)
    public BizDate getHurikaeymd() {
        return hurikaeymd;
    }

    public void setHurikaeymd(BizDate pHurikaeymd) {
        hurikaeymd = pHurikaeymd;
    }

    private C_CreditdataKbn creditdatakbn;

    @Type(type="UserType_C_CreditdataKbn")
    @Column(name=GenIT_TRDattai.CREDITDATAKBN)
    public C_CreditdataKbn getCreditdatakbn() {
        return creditdatakbn;
    }

    public void setCreditdatakbn(C_CreditdataKbn pCreditdatakbn) {
        creditdatakbn = pCreditdatakbn;
    }

    private String creditcardno1;

    @Column(name=GenIT_TRDattai.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIT_TRDattai.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIT_TRDattai.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIT_TRDattai.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private C_Creditbrerrorcd creditbrerrorcd;

    @Type(type="UserType_C_Creditbrerrorcd")
    @Column(name=GenIT_TRDattai.CREDITBRERRORCD)
    public C_Creditbrerrorcd getCreditbrerrorcd() {
        return creditbrerrorcd;
    }

    public void setCreditbrerrorcd(C_Creditbrerrorcd pCreditbrerrorcd) {
        creditbrerrorcd = pCreditbrerrorcd;
    }

    private BizDateYM dattaiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_TRDattai.DATTAIYM)
    public BizDateYM getDattaiym() {
        return dattaiym;
    }

    public void setDattaiym(BizDateYM pDattaiym) {
        dattaiym = pDattaiym;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenIT_TRDattai.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenIT_TRDattai.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private Integer jyutoukaisuuy;

    @Column(name=GenIT_TRDattai.JYUTOUKAISUUY)
    @Range(min="0", max="99")
    public Integer getJyutoukaisuuy() {
        return jyutoukaisuuy;
    }

    @Trim("both")
    public void setJyutoukaisuuy(Integer pJyutoukaisuuy) {
        jyutoukaisuuy = pJyutoukaisuuy;
    }

    private Integer jyutoukaisuum;

    @Column(name=GenIT_TRDattai.JYUTOUKAISUUM)
    @Range(min="0", max="12")
    public Integer getJyutoukaisuum() {
        return jyutoukaisuum;
    }

    @Trim("both")
    public void setJyutoukaisuum(Integer pJyutoukaisuum) {
        jyutoukaisuum = pJyutoukaisuum;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_TRDattai.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_TRDattai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_TRDattai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_TRDattai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIT_TRDattai.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private C_CardBrandKbn cardbrandkbn;

    @Type(type="UserType_C_CardBrandKbn")
    @Column(name=GenIT_TRDattai.CARDBRANDKBN)
    public C_CardBrandKbn getCardbrandkbn() {
        return cardbrandkbn;
    }

    public void setCardbrandkbn(C_CardBrandKbn pCardbrandkbn) {
        cardbrandkbn = pCardbrandkbn;
    }

    private String creditkaiinnosimo4keta;

    @Column(name=GenIT_TRDattai.CREDITKAIINNOSIMO4KETA)
    public String getCreditkaiinnosimo4keta() {
        return creditkaiinnosimo4keta;
    }

    public void setCreditkaiinnosimo4keta(String pCreditkaiinnosimo4keta) {
        creditkaiinnosimo4keta = pCreditkaiinnosimo4keta;
    }
}