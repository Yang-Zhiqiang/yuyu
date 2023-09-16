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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AuthorikakyhKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import yuyu.def.db.id.PKIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.GenQIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.QIW_KhHaraikataHenkouWk;
import yuyu.def.db.type.UserType_C_AuthorikakyhKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_KyuukouzaAnnaiKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YykidouuktkKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 払方変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhHaraikataHenkouWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhHaraikataHenkouWk}</td><td colspan="3">払方変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhHaraikataHenkouWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNewhrkkeiro newhrkkeiro}</td><td>（変更後）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getNewhrkkaisuu newhrkkaisuu}</td><td>（変更後）払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getNewtikiktbrisyuruikbn newtikiktbrisyuruikbn}</td><td>（変更後）定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getHenkouyoteiym henkouyoteiym}</td><td>変更（予定）年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkykdoukbn kzkykdoukbn}</td><td>口座名義契約者同一人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkykdouKbn}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno1 creditcardno1}</td><td>クレジットカード番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno2 creditcardno2}</td><td>クレジットカード番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno3 creditcardno3}</td><td>クレジットカード番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditcardno4 creditcardno4}</td><td>クレジットカード番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYkkigenyy ykkigenyy}</td><td>有効期限（ＹＹ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYkkigenmm ykkigenmm}</td><td>有効期限（ＭＭ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditmeiginmkn creditmeiginmkn}</td><td>クレジットカード名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAuthorikakyhkbn authorikakyhkbn}</td><td>オーソリ確認要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AuthorikakyhKbn}</td></tr>
 *  <tr><td>{@link #getYykidouuktkkbn yykidouuktkkbn}</td><td>予約異動受付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YykidouuktkKbn}</td></tr>
 *  <tr><td>{@link #getKyuukouzaannaikbn kyuukouzaannaikbn}</td><td>旧口座案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyuukouzaAnnaiKbn}</td></tr>
 *  <tr><td>{@link #getKanryotuutioutkbn kanryotuutioutkbn}</td><td>完了通知出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KanryotuutioutKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getKyuukouzahurikaeymd kyuukouzahurikaeymd}</td><td>旧口座振替日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhHaraikataHenkouWk
 * @see     PKIW_KhHaraikataHenkouWk
 * @see     QIW_KhHaraikataHenkouWk
 * @see     GenQIW_KhHaraikataHenkouWk
 */
@MappedSuperclass
@Table(name=GenIW_KhHaraikataHenkouWk.TABLE_NAME)
@IdClass(value=PKIW_KhHaraikataHenkouWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_AuthorikakyhKbn", typeClass=UserType_C_AuthorikakyhKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_KanryotuutioutKbn", typeClass=UserType_C_KanryotuutioutKbn.class),
    @TypeDef(name="UserType_C_KyuukouzaAnnaiKbn", typeClass=UserType_C_KyuukouzaAnnaiKbn.class),
    @TypeDef(name="UserType_C_KzkykdouKbn", typeClass=UserType_C_KzkykdouKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YykidouuktkKbn", typeClass=UserType_C_YykidouuktkKbn.class)
})
public abstract class GenIW_KhHaraikataHenkouWk extends AbstractExDBEntity<IW_KhHaraikataHenkouWk, PKIW_KhHaraikataHenkouWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhHaraikataHenkouWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String NEWHRKKEIRO              = "newhrkkeiro";
    public static final String NEWHRKKAISUU             = "newhrkkaisuu";
    public static final String NEWTIKIKTBRISYURUIKBN    = "newtikiktbrisyuruikbn";
    public static final String HENKOUYOTEIYM            = "henkouyoteiym";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZKYKDOUKBN              = "kzkykdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String CARDKAISYACD             = "cardkaisyacd";
    public static final String CREDITCARDNO1            = "creditcardno1";
    public static final String CREDITCARDNO2            = "creditcardno2";
    public static final String CREDITCARDNO3            = "creditcardno3";
    public static final String CREDITCARDNO4            = "creditcardno4";
    public static final String YKKIGENYY                = "ykkigenyy";
    public static final String YKKIGENMM                = "ykkigenmm";
    public static final String CREDITMEIGINMKN          = "creditmeiginmkn";
    public static final String AUTHORIKAKYHKBN          = "authorikakyhkbn";
    public static final String YYKIDOUUKTKKBN           = "yykidouuktkkbn";
    public static final String KYUUKOUZAANNAIKBN        = "kyuukouzaannaikbn";
    public static final String KANRYOTUUTIOUTKBN        = "kanryotuutioutkbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String KYUUKOUZAHURIKAEYMD      = "kyuukouzahurikaeymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";

    private final PKIW_KhHaraikataHenkouWk primaryKey;

    public GenIW_KhHaraikataHenkouWk() {
        primaryKey = new PKIW_KhHaraikataHenkouWk();
    }

    public GenIW_KhHaraikataHenkouWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhHaraikataHenkouWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhHaraikataHenkouWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhHaraikataHenkouWk> getMetaClass() {
        return QIW_KhHaraikataHenkouWk.class;
    }

    @Id
    @Column(name=GenIW_KhHaraikataHenkouWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhHaraikataHenkouWk.SYONO)
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
    @Column(name=GenIW_KhHaraikataHenkouWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_Hrkkeiro newhrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIW_KhHaraikataHenkouWk.NEWHRKKEIRO)
    public C_Hrkkeiro getNewhrkkeiro() {
        return newhrkkeiro;
    }

    public void setNewhrkkeiro(C_Hrkkeiro pNewhrkkeiro) {
        newhrkkeiro = pNewhrkkeiro;
    }

    private C_Hrkkaisuu newhrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIW_KhHaraikataHenkouWk.NEWHRKKAISUU)
    public C_Hrkkaisuu getNewhrkkaisuu() {
        return newhrkkaisuu;
    }

    public void setNewhrkkaisuu(C_Hrkkaisuu pNewhrkkaisuu) {
        newhrkkaisuu = pNewhrkkaisuu;
    }

    private C_TkiktbrisyuruiKbn newtikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.NEWTIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getNewtikiktbrisyuruikbn() {
        return newtikiktbrisyuruikbn;
    }

    public void setNewtikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pNewtikiktbrisyuruikbn) {
        newtikiktbrisyuruikbn = pNewtikiktbrisyuruikbn;
    }

    private BizDateYM henkouyoteiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIW_KhHaraikataHenkouWk.HENKOUYOTEIYM)
    @ValidDateYm
    public BizDateYM getHenkouyoteiym() {
        return henkouyoteiym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHenkouyoteiym(BizDateYM pHenkouyoteiym) {
        henkouyoteiym = pHenkouyoteiym;
    }

    private String bankcd;

    @Column(name=GenIW_KhHaraikataHenkouWk.BANKCD)
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

    @Column(name=GenIW_KhHaraikataHenkouWk.SITENCD)
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
    @Column(name=GenIW_KhHaraikataHenkouWk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIW_KhHaraikataHenkouWk.KOUZANO)
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

    private C_KzkykdouKbn kzkykdoukbn;

    @Type(type="UserType_C_KzkykdouKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.KZKYKDOUKBN)
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIW_KhHaraikataHenkouWk.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private String cardkaisyacd;

    @Column(name=GenIW_KhHaraikataHenkouWk.CARDKAISYACD)
    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    private String creditcardno1;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITCARDNO1)
    public String getCreditcardno1() {
        return creditcardno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno1(String pCreditcardno1) {
        creditcardno1 = pCreditcardno1;
    }

    private String creditcardno2;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITCARDNO2)
    public String getCreditcardno2() {
        return creditcardno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno2(String pCreditcardno2) {
        creditcardno2 = pCreditcardno2;
    }

    private String creditcardno3;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITCARDNO3)
    public String getCreditcardno3() {
        return creditcardno3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno3(String pCreditcardno3) {
        creditcardno3 = pCreditcardno3;
    }

    private String creditcardno4;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITCARDNO4)
    public String getCreditcardno4() {
        return creditcardno4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCreditcardno4(String pCreditcardno4) {
        creditcardno4 = pCreditcardno4;
    }

    private String ykkigenyy;

    @Column(name=GenIW_KhHaraikataHenkouWk.YKKIGENYY)
    public String getYkkigenyy() {
        return ykkigenyy;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYkkigenyy(String pYkkigenyy) {
        ykkigenyy = pYkkigenyy;
    }

    private String ykkigenmm;

    @Column(name=GenIW_KhHaraikataHenkouWk.YKKIGENMM)
    public String getYkkigenmm() {
        return ykkigenmm;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYkkigenmm(String pYkkigenmm) {
        ykkigenmm = pYkkigenmm;
    }

    private String creditmeiginmkn;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITMEIGINMKN)
    public String getCreditmeiginmkn() {
        return creditmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCreditmeiginmkn(String pCreditmeiginmkn) {
        creditmeiginmkn = pCreditmeiginmkn;
    }

    private C_AuthorikakyhKbn authorikakyhkbn;

    @Type(type="UserType_C_AuthorikakyhKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.AUTHORIKAKYHKBN)
    public C_AuthorikakyhKbn getAuthorikakyhkbn() {
        return authorikakyhkbn;
    }

    public void setAuthorikakyhkbn(C_AuthorikakyhKbn pAuthorikakyhkbn) {
        authorikakyhkbn = pAuthorikakyhkbn;
    }

    private C_YykidouuktkKbn yykidouuktkkbn;

    @Type(type="UserType_C_YykidouuktkKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.YYKIDOUUKTKKBN)
    public C_YykidouuktkKbn getYykidouuktkkbn() {
        return yykidouuktkkbn;
    }

    public void setYykidouuktkkbn(C_YykidouuktkKbn pYykidouuktkkbn) {
        yykidouuktkkbn = pYykidouuktkkbn;
    }

    private C_KyuukouzaAnnaiKbn kyuukouzaannaikbn;

    @Type(type="UserType_C_KyuukouzaAnnaiKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.KYUUKOUZAANNAIKBN)
    public C_KyuukouzaAnnaiKbn getKyuukouzaannaikbn() {
        return kyuukouzaannaikbn;
    }

    public void setKyuukouzaannaikbn(C_KyuukouzaAnnaiKbn pKyuukouzaannaikbn) {
        kyuukouzaannaikbn = pKyuukouzaannaikbn;
    }

    private C_KanryotuutioutKbn kanryotuutioutkbn;

    @Type(type="UserType_C_KanryotuutioutKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.KANRYOTUUTIOUTKBN)
    public C_KanryotuutioutKbn getKanryotuutioutkbn() {
        return kanryotuutioutkbn;
    }

    public void setKanryotuutioutkbn(C_KanryotuutioutKbn pKanryotuutioutkbn) {
        kanryotuutioutkbn = pKanryotuutioutkbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhHaraikataHenkouWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private BizDate kyuukouzahurikaeymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhHaraikataHenkouWk.KYUUKOUZAHURIKAEYMD)
    public BizDate getKyuukouzahurikaeymd() {
        return kyuukouzahurikaeymd;
    }

    public void setKyuukouzahurikaeymd(BizDate pKyuukouzahurikaeymd) {
        kyuukouzahurikaeymd = pKyuukouzahurikaeymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhHaraikataHenkouWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhHaraikataHenkouWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhHaraikataHenkouWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String creditkessaiyouno;

    @Column(name=GenIW_KhHaraikataHenkouWk.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}