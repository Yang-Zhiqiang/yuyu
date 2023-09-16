package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.id.PKIT_KhIdouTyousyo;
import yuyu.def.db.meta.GenQIT_KhIdouTyousyo;
import yuyu.def.db.meta.QIT_KhIdouTyousyo;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全異動調書テーブル テーブルのマッピング情報クラスで、 {@link IT_KhIdouTyousyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhIdouTyousyo}</td><td colspan="3">契約保全異動調書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhIdouTyousyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_KhIdouTyousyo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtysyrenno shrtysyrenno}</td><td>支払調書連番</td><td align="center">{@link PKIT_KhIdouTyousyo ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getKacd kacd}</td><td>課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysysyuruicd shrtysysyuruicd}</td><td>支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoritaisyoukbn syoritaisyoukbn}</td><td>処理対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTblsakuseihunodisp tblsakuseihunodisp}</td><td>テープ作成不能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinyno oldtsinyno}</td><td>（旧）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr1kj oldtsinadr1kj}</td><td>（旧）通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr2kj oldtsinadr2kj}</td><td>（旧）通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr3kj oldtsinadr3kj}</td><td>（旧）通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyknmkj oldkyknmkj}</td><td>（旧）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyksibouymd oldkyksibouymd}</td><td>（旧）契約者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksiboumeighnksyoriymd kyksiboumeighnksyoriymd}</td><td>契約者死亡名義変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaiyakuhrstgk kaiyakuhrstgk}</td><td>解約返戻金相当額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihrkmp kihrkmp}</td><td>既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldkykkihrkmpyouhyj oldkykkihrkmpyouhyj}</td><td>（旧）契約者既払込保険料要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkykkihrkmp oldkykkihrkmp}</td><td>（旧）契約者既払込保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHuho2kykdisp huho2kykdisp}</td><td>普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysyhknsyukbn shrtysyhknsyukbn}</td><td>支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhIdouTyousyo
 * @see     PKIT_KhIdouTyousyo
 * @see     QIT_KhIdouTyousyo
 * @see     GenQIT_KhIdouTyousyo
 */
@MappedSuperclass
@Table(name=GenIT_KhIdouTyousyo.TABLE_NAME)
@IdClass(value=PKIT_KhIdouTyousyo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_ShrtysyhknsyuKbn", typeClass=UserType_C_ShrtysyhknsyuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class)
})
public abstract class GenIT_KhIdouTyousyo extends AbstractExDBEntity<IT_KhIdouTyousyo, PKIT_KhIdouTyousyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhIdouTyousyo";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SHRTYSYRENNO             = "shrtysyrenno";
    public static final String KACD                     = "kacd";
    public static final String TANTOCD                  = "tantocd";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SHRTYSYSYURUICD          = "shrtysysyuruicd";
    public static final String SYORITAISYOUKBN          = "syoritaisyoukbn";
    public static final String TBLSAKUSEIHUNODISP       = "tblsakuseihunodisp";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String OLDTSINYNO               = "oldtsinyno";
    public static final String OLDTSINADR1KJ            = "oldtsinadr1kj";
    public static final String OLDTSINADR2KJ            = "oldtsinadr2kj";
    public static final String OLDTSINADR3KJ            = "oldtsinadr3kj";
    public static final String OLDKYKNMKJ               = "oldkyknmkj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String OLDKYKSIBOUYMD           = "oldkyksibouymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String KYKSIBOUMEIGHNKSYORIYMD  = "kyksiboumeighnksyoriymd";
    public static final String KAIYAKUHRSTGK            = "kaiyakuhrstgk";
    public static final String KIHRKMP                  = "kihrkmp";
    public static final String OLDKYKKIHRKMPYOUHYJ      = "oldkykkihrkmpyouhyj";
    public static final String OLDKYKKIHRKMP            = "oldkykkihrkmp";
    public static final String SAKUSEIYMD               = "sakuseiymd";
    public static final String HUHO2KYKDISP             = "huho2kykdisp";
    public static final String SHRTYSYHKNSYUKBN         = "shrtysyhknsyukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhIdouTyousyo primaryKey;

    public GenIT_KhIdouTyousyo() {
        primaryKey = new PKIT_KhIdouTyousyo();
    }

    public GenIT_KhIdouTyousyo(
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        primaryKey = new PKIT_KhIdouTyousyo(
            pSyono,
            pTyouhyouymd,
            pShrtysyrenno
        );
    }

    @Transient
    @Override
    public PKIT_KhIdouTyousyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhIdouTyousyo> getMetaClass() {
        return QIT_KhIdouTyousyo.class;
    }

    @Id
    @Column(name=GenIT_KhIdouTyousyo.SYONO)
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
    @Column(name=GenIT_KhIdouTyousyo.TYOUHYOUYMD)
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
    @Column(name=GenIT_KhIdouTyousyo.SHRTYSYRENNO)
    public Long getShrtysyrenno() {
        return getPrimaryKey().getShrtysyrenno();
    }

    public void setShrtysyrenno(Long pShrtysyrenno) {
        getPrimaryKey().setShrtysyrenno(pShrtysyrenno);
    }

    private String kacd;

    @Column(name=GenIT_KhIdouTyousyo.KACD)
    public String getKacd() {
        return kacd;
    }

    public void setKacd(String pKacd) {
        kacd = pKacd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_KhIdouTyousyo.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String hknsyukigou;

    @Column(name=GenIT_KhIdouTyousyo.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private String syorisosikicd;

    @Column(name=GenIT_KhIdouTyousyo.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private String shrtysysyuruicd;

    @Column(name=GenIT_KhIdouTyousyo.SHRTYSYSYURUICD)
    public String getShrtysysyuruicd() {
        return shrtysysyuruicd;
    }

    public void setShrtysysyuruicd(String pShrtysysyuruicd) {
        shrtysysyuruicd = pShrtysysyuruicd;
    }

    private String syoritaisyoukbn;

    @Column(name=GenIT_KhIdouTyousyo.SYORITAISYOUKBN)
    public String getSyoritaisyoukbn() {
        return syoritaisyoukbn;
    }

    public void setSyoritaisyoukbn(String pSyoritaisyoukbn) {
        syoritaisyoukbn = pSyoritaisyoukbn;
    }

    private String tblsakuseihunodisp;

    @Column(name=GenIT_KhIdouTyousyo.TBLSAKUSEIHUNODISP)
    public String getTblsakuseihunodisp() {
        return tblsakuseihunodisp;
    }

    public void setTblsakuseihunodisp(String pTblsakuseihunodisp) {
        tblsakuseihunodisp = pTblsakuseihunodisp;
    }

    private String tsinyno;

    @Column(name=GenIT_KhIdouTyousyo.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_KhIdouTyousyo.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_KhIdouTyousyo.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_KhIdouTyousyo.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String kyknmkj;

    @Column(name=GenIT_KhIdouTyousyo.KYKNMKJ)
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

    private String oldtsinyno;

    @Column(name=GenIT_KhIdouTyousyo.OLDTSINYNO)
    public String getOldtsinyno() {
        return oldtsinyno;
    }

    public void setOldtsinyno(String pOldtsinyno) {
        oldtsinyno = pOldtsinyno;
    }

    private String oldtsinadr1kj;

    @Column(name=GenIT_KhIdouTyousyo.OLDTSINADR1KJ)
    public String getOldtsinadr1kj() {
        return oldtsinadr1kj;
    }

    public void setOldtsinadr1kj(String pOldtsinadr1kj) {
        oldtsinadr1kj = pOldtsinadr1kj;
    }

    private String oldtsinadr2kj;

    @Column(name=GenIT_KhIdouTyousyo.OLDTSINADR2KJ)
    public String getOldtsinadr2kj() {
        return oldtsinadr2kj;
    }

    public void setOldtsinadr2kj(String pOldtsinadr2kj) {
        oldtsinadr2kj = pOldtsinadr2kj;
    }

    private String oldtsinadr3kj;

    @Column(name=GenIT_KhIdouTyousyo.OLDTSINADR3KJ)
    public String getOldtsinadr3kj() {
        return oldtsinadr3kj;
    }

    public void setOldtsinadr3kj(String pOldtsinadr3kj) {
        oldtsinadr3kj = pOldtsinadr3kj;
    }

    private String oldkyknmkj;

    @Column(name=GenIT_KhIdouTyousyo.OLDKYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getOldkyknmkj() {
        return oldkyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setOldkyknmkj(String pOldkyknmkj) {
        oldkyknmkj = pOldkyknmkj;
    }

    private String hhknnmkj;

    @Column(name=GenIT_KhIdouTyousyo.HHKNNMKJ)
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

    private BizDate oldkyksibouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhIdouTyousyo.OLDKYKSIBOUYMD)
    @ValidDate
    public BizDate getOldkyksibouymd() {
        return oldkyksibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkyksibouymd(BizDate pOldkyksibouymd) {
        oldkyksibouymd = pOldkyksibouymd;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhIdouTyousyo.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate kyksiboumeighnksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhIdouTyousyo.KYKSIBOUMEIGHNKSYORIYMD)
    public BizDate getKyksiboumeighnksyoriymd() {
        return kyksiboumeighnksyoriymd;
    }

    public void setKyksiboumeighnksyoriymd(BizDate pKyksiboumeighnksyoriymd) {
        kyksiboumeighnksyoriymd = pKyksiboumeighnksyoriymd;
    }

    private BizCurrency kaiyakuhrstgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrstgk() {
        return kaiyakuhrstgk;
    }

    public void setKaiyakuhrstgk(BizCurrency pKaiyakuhrstgk) {
        kaiyakuhrstgk = pKaiyakuhrstgk;
        kaiyakuhrstgkValue = null;
        kaiyakuhrstgkType  = null;
    }

    transient private BigDecimal kaiyakuhrstgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRSTGK, nullable=true)
    protected BigDecimal getKaiyakuhrstgkValue() {
        if (kaiyakuhrstgkValue == null && kaiyakuhrstgk != null) {
            if (kaiyakuhrstgk.isOptional()) return null;
            return kaiyakuhrstgk.absolute();
        }
        return kaiyakuhrstgkValue;
    }

    protected void setKaiyakuhrstgkValue(BigDecimal value) {
        kaiyakuhrstgkValue = value;
        kaiyakuhrstgk = Optional.fromNullable(toCurrencyType(kaiyakuhrstgkType))
            .transform(bizCurrencyTransformer(getKaiyakuhrstgkValue()))
            .orNull();
    }

    transient private String kaiyakuhrstgkType = null;

    @Column(name=KAIYAKUHRSTGK + "$", nullable=true)
    protected String getKaiyakuhrstgkType() {
        if (kaiyakuhrstgkType == null && kaiyakuhrstgk != null) return kaiyakuhrstgk.getType().toString();
        if (kaiyakuhrstgkType == null && getKaiyakuhrstgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrstgk$' should not be NULL."));
        }
        return kaiyakuhrstgkType;
    }

    protected void setKaiyakuhrstgkType(String type) {
        kaiyakuhrstgkType = type;
        kaiyakuhrstgk = Optional.fromNullable(toCurrencyType(kaiyakuhrstgkType))
            .transform(bizCurrencyTransformer(getKaiyakuhrstgkValue()))
            .orNull();
    }

    private BizCurrency kihrkmp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmp() {
        return kihrkmp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp(BizCurrency pKihrkmp) {
        kihrkmp = pKihrkmp;
        kihrkmpValue = null;
        kihrkmpType  = null;
    }

    transient private BigDecimal kihrkmpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMP, nullable=true)
    protected BigDecimal getKihrkmpValue() {
        if (kihrkmpValue == null && kihrkmp != null) {
            if (kihrkmp.isOptional()) return null;
            return kihrkmp.absolute();
        }
        return kihrkmpValue;
    }

    protected void setKihrkmpValue(BigDecimal value) {
        kihrkmpValue = value;
        kihrkmp = Optional.fromNullable(toCurrencyType(kihrkmpType))
            .transform(bizCurrencyTransformer(getKihrkmpValue()))
            .orNull();
    }

    transient private String kihrkmpType = null;

    @Column(name=KIHRKMP + "$", nullable=true)
    protected String getKihrkmpType() {
        if (kihrkmpType == null && kihrkmp != null) return kihrkmp.getType().toString();
        if (kihrkmpType == null && getKihrkmpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmp$' should not be NULL."));
        }
        return kihrkmpType;
    }

    protected void setKihrkmpType(String type) {
        kihrkmpType = type;
        kihrkmp = Optional.fromNullable(toCurrencyType(kihrkmpType))
            .transform(bizCurrencyTransformer(getKihrkmpValue()))
            .orNull();
    }

    private String oldkykkihrkmpyouhyj;

    @Column(name=GenIT_KhIdouTyousyo.OLDKYKKIHRKMPYOUHYJ)
    public String getOldkykkihrkmpyouhyj() {
        return oldkykkihrkmpyouhyj;
    }

    public void setOldkykkihrkmpyouhyj(String pOldkykkihrkmpyouhyj) {
        oldkykkihrkmpyouhyj = pOldkykkihrkmpyouhyj;
    }

    private BizCurrency oldkykkihrkmp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getOldkykkihrkmp() {
        return oldkykkihrkmp;
    }

    public void setOldkykkihrkmp(BizCurrency pOldkykkihrkmp) {
        oldkykkihrkmp = pOldkykkihrkmp;
        oldkykkihrkmpValue = null;
        oldkykkihrkmpType  = null;
    }

    transient private BigDecimal oldkykkihrkmpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=OLDKYKKIHRKMP, nullable=true)
    protected BigDecimal getOldkykkihrkmpValue() {
        if (oldkykkihrkmpValue == null && oldkykkihrkmp != null) {
            if (oldkykkihrkmp.isOptional()) return null;
            return oldkykkihrkmp.absolute();
        }
        return oldkykkihrkmpValue;
    }

    protected void setOldkykkihrkmpValue(BigDecimal value) {
        oldkykkihrkmpValue = value;
        oldkykkihrkmp = Optional.fromNullable(toCurrencyType(oldkykkihrkmpType))
            .transform(bizCurrencyTransformer(getOldkykkihrkmpValue()))
            .orNull();
    }

    transient private String oldkykkihrkmpType = null;

    @Column(name=OLDKYKKIHRKMP + "$", nullable=true)
    protected String getOldkykkihrkmpType() {
        if (oldkykkihrkmpType == null && oldkykkihrkmp != null) return oldkykkihrkmp.getType().toString();
        if (oldkykkihrkmpType == null && getOldkykkihrkmpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'oldkykkihrkmp$' should not be NULL."));
        }
        return oldkykkihrkmpType;
    }

    protected void setOldkykkihrkmpType(String type) {
        oldkykkihrkmpType = type;
        oldkykkihrkmp = Optional.fromNullable(toCurrencyType(oldkykkihrkmpType))
            .transform(bizCurrencyTransformer(getOldkykkihrkmpValue()))
            .orNull();
    }

    private BizDate sakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhIdouTyousyo.SAKUSEIYMD)
    @ValidDate
    public BizDate getSakuseiymd() {
        return sakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiymd(BizDate pSakuseiymd) {
        sakuseiymd = pSakuseiymd;
    }

    private String huho2kykdisp;

    @Column(name=GenIT_KhIdouTyousyo.HUHO2KYKDISP)
    public String getHuho2kykdisp() {
        return huho2kykdisp;
    }

    public void setHuho2kykdisp(String pHuho2kykdisp) {
        huho2kykdisp = pHuho2kykdisp;
    }

    private C_ShrtysyhknsyuKbn shrtysyhknsyukbn;

    @Type(type="UserType_C_ShrtysyhknsyuKbn")
    @Column(name=GenIT_KhIdouTyousyo.SHRTYSYHKNSYUKBN)
    public C_ShrtysyhknsyuKbn getShrtysyhknsyukbn() {
        return shrtysyhknsyukbn;
    }

    public void setShrtysyhknsyukbn(C_ShrtysyhknsyuKbn pShrtysyhknsyukbn) {
        shrtysyhknsyukbn = pShrtysyhknsyukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhIdouTyousyo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhIdouTyousyo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhIdouTyousyo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}