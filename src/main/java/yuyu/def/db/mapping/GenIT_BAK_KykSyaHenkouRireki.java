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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_KykSyaHenkouRireki;
import yuyu.def.db.id.PKIT_BAK_KykSyaHenkouRireki;
import yuyu.def.db.meta.GenQIT_BAK_KykSyaHenkouRireki;
import yuyu.def.db.meta.QIT_BAK_KykSyaHenkouRireki;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 契約者変更履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KykSyaHenkouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KykSyaHenkouRireki}</td><td colspan="3">契約者変更履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KykSyaHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KykSyaHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KykSyaHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_KykSyaHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMeighnksyoriymd meighnksyoriymd}</td><td>名義変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMeigihnkjiyuu meigihnkjiyuu}</td><td>名義変更事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Meigihnkjiyuu}</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOldkyksibouymd oldkyksibouymd}</td><td>（旧）契約者死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOldkyknmkn oldkyknmkn}</td><td>（旧）契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyknmkj oldkyknmkj}</td><td>（旧）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyknmkjkhukakbn oldkyknmkjkhukakbn}</td><td>（旧）契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getOldkykseiymd oldkykseiymd}</td><td>（旧）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOldkyksei oldkyksei}</td><td>（旧）契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getOldkkkyktdk oldkkkyktdk}</td><td>（旧）契約管理契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getOldtsinyno oldtsinyno}</td><td>（旧）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr1kj oldtsinadr1kj}</td><td>（旧）通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr2kj oldtsinadr2kj}</td><td>（旧）通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr3kj oldtsinadr3kj}</td><td>（旧）通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsintelno oldtsintelno}</td><td>（旧）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOlddai2tsintelno olddai2tsintelno}</td><td>（旧）第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKaiyakuhrstgk kaiyakuhrstgk}</td><td>解約返戻金相当額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaiyakuhrstgk yenkaiyakuhrstgk}</td><td>円換算解約返戻金相当額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrateymd yenkansantkykwsrateymd}</td><td>円換算適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKihrkmpsgk kihrkmpsgk}</td><td>既払込保険料総額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOldkykkihrkmp oldkykkihrkmp}</td><td>（旧）契約者既払込保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotashrkngkyen sonotashrkngkyen}</td><td>その他支払金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_KykSyaHenkouRireki
 * @see     PKIT_BAK_KykSyaHenkouRireki
 * @see     QIT_BAK_KykSyaHenkouRireki
 * @see     GenQIT_BAK_KykSyaHenkouRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KykSyaHenkouRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_KykSyaHenkouRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Meigihnkjiyuu", typeClass=UserType_C_Meigihnkjiyuu.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenIT_BAK_KykSyaHenkouRireki extends AbstractExDBEntity<IT_BAK_KykSyaHenkouRireki, PKIT_BAK_KykSyaHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KykSyaHenkouRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String MEIGHNKSYORIYMD          = "meighnksyoriymd";
    public static final String MEIGIHNKJIYUU            = "meigihnkjiyuu";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String OLDKYKSIBOUYMD           = "oldkyksibouymd";
    public static final String OLDKYKNMKN               = "oldkyknmkn";
    public static final String OLDKYKNMKJ               = "oldkyknmkj";
    public static final String OLDKYKNMKJKHUKAKBN       = "oldkyknmkjkhukakbn";
    public static final String OLDKYKSEIYMD             = "oldkykseiymd";
    public static final String OLDKYKSEI                = "oldkyksei";
    public static final String OLDKKKYKTDK              = "oldkkkyktdk";
    public static final String OLDTSINYNO               = "oldtsinyno";
    public static final String OLDTSINADR1KJ            = "oldtsinadr1kj";
    public static final String OLDTSINADR2KJ            = "oldtsinadr2kj";
    public static final String OLDTSINADR3KJ            = "oldtsinadr3kj";
    public static final String OLDTSINTELNO             = "oldtsintelno";
    public static final String OLDDAI2TSINTELNO         = "olddai2tsintelno";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String KAIYAKUHRSTGK            = "kaiyakuhrstgk";
    public static final String YENKAIYAKUHRSTGK         = "yenkaiyakuhrstgk";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String YENKANSANTKYKWSRATEYMD   = "yenkansantkykwsrateymd";
    public static final String KIHRKMPSGK               = "kihrkmpsgk";
    public static final String OLDKYKKIHRKMP            = "oldkykkihrkmp";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SONOTASHRKNGKYEN         = "sonotashrkngkyen";

    private final PKIT_BAK_KykSyaHenkouRireki primaryKey;

    public GenIT_BAK_KykSyaHenkouRireki() {
        primaryKey = new PKIT_BAK_KykSyaHenkouRireki();
    }

    public GenIT_BAK_KykSyaHenkouRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_KykSyaHenkouRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KykSyaHenkouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KykSyaHenkouRireki> getMetaClass() {
        return QIT_BAK_KykSyaHenkouRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.SYONO)
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
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate meighnksyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.MEIGHNKSYORIYMD)
    public BizDate getMeighnksyoriymd() {
        return meighnksyoriymd;
    }

    public void setMeighnksyoriymd(BizDate pMeighnksyoriymd) {
        meighnksyoriymd = pMeighnksyoriymd;
    }

    private C_Meigihnkjiyuu meigihnkjiyuu;

    @Type(type="UserType_C_Meigihnkjiyuu")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.MEIGIHNKJIYUU)
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkjiyuu = pMeigihnkjiyuu;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate oldkyksibouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKSIBOUYMD)
    @ValidDate
    public BizDate getOldkyksibouymd() {
        return oldkyksibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkyksibouymd(BizDate pOldkyksibouymd) {
        oldkyksibouymd = pOldkyksibouymd;
    }

    private String oldkyknmkn;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getOldkyknmkn() {
        return oldkyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setOldkyknmkn(String pOldkyknmkn) {
        oldkyknmkn = pOldkyknmkn;
    }

    private String oldkyknmkj;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKNMKJ)
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

    private C_KjkhukaKbn oldkyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getOldkyknmkjkhukakbn() {
        return oldkyknmkjkhukakbn;
    }

    public void setOldkyknmkjkhukakbn(C_KjkhukaKbn pOldkyknmkjkhukakbn) {
        oldkyknmkjkhukakbn = pOldkyknmkjkhukakbn;
    }

    private BizDate oldkykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKSEIYMD)
    @ValidDate
    public BizDate getOldkykseiymd() {
        return oldkykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOldkykseiymd(BizDate pOldkykseiymd) {
        oldkykseiymd = pOldkykseiymd;
    }

    private C_Kyksei oldkyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKYKSEI)
    public C_Kyksei getOldkyksei() {
        return oldkyksei;
    }

    public void setOldkyksei(C_Kyksei pOldkyksei) {
        oldkyksei = pOldkyksei;
    }

    private C_Tdk oldkkkyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDKKKYKTDK)
    public C_Tdk getOldkkkyktdk() {
        return oldkkkyktdk;
    }

    public void setOldkkkyktdk(C_Tdk pOldkkkyktdk) {
        oldkkkyktdk = pOldkkkyktdk;
    }

    private String oldtsinyno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDTSINYNO)
    public String getOldtsinyno() {
        return oldtsinyno;
    }

    public void setOldtsinyno(String pOldtsinyno) {
        oldtsinyno = pOldtsinyno;
    }

    private String oldtsinadr1kj;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDTSINADR1KJ)
    public String getOldtsinadr1kj() {
        return oldtsinadr1kj;
    }

    public void setOldtsinadr1kj(String pOldtsinadr1kj) {
        oldtsinadr1kj = pOldtsinadr1kj;
    }

    private String oldtsinadr2kj;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDTSINADR2KJ)
    public String getOldtsinadr2kj() {
        return oldtsinadr2kj;
    }

    public void setOldtsinadr2kj(String pOldtsinadr2kj) {
        oldtsinadr2kj = pOldtsinadr2kj;
    }

    private String oldtsinadr3kj;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDTSINADR3KJ)
    public String getOldtsinadr3kj() {
        return oldtsinadr3kj;
    }

    public void setOldtsinadr3kj(String pOldtsinadr3kj) {
        oldtsinadr3kj = pOldtsinadr3kj;
    }

    private String oldtsintelno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDTSINTELNO)
    public String getOldtsintelno() {
        return oldtsintelno;
    }

    public void setOldtsintelno(String pOldtsintelno) {
        oldtsintelno = pOldtsintelno;
    }

    private String olddai2tsintelno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.OLDDAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getOlddai2tsintelno() {
        return olddai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOlddai2tsintelno(String pOlddai2tsintelno) {
        olddai2tsintelno = pOlddai2tsintelno;
    }

    private String tsinyno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TSINYNO)
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

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TSINADR1KJ)
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

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TSINADR2KJ)
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

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TSINADR3KJ)
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

    private String tsintelno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dai2tsintelno;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
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

    private BizCurrency yenkaiyakuhrstgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaiyakuhrstgk() {
        return yenkaiyakuhrstgk;
    }

    public void setYenkaiyakuhrstgk(BizCurrency pYenkaiyakuhrstgk) {
        yenkaiyakuhrstgk = pYenkaiyakuhrstgk;
        yenkaiyakuhrstgkValue = null;
        yenkaiyakuhrstgkType  = null;
    }

    transient private BigDecimal yenkaiyakuhrstgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAIYAKUHRSTGK, nullable=true)
    protected BigDecimal getYenkaiyakuhrstgkValue() {
        if (yenkaiyakuhrstgkValue == null && yenkaiyakuhrstgk != null) {
            if (yenkaiyakuhrstgk.isOptional()) return null;
            return yenkaiyakuhrstgk.absolute();
        }
        return yenkaiyakuhrstgkValue;
    }

    protected void setYenkaiyakuhrstgkValue(BigDecimal value) {
        yenkaiyakuhrstgkValue = value;
        yenkaiyakuhrstgk = Optional.fromNullable(toCurrencyType(yenkaiyakuhrstgkType))
            .transform(bizCurrencyTransformer(getYenkaiyakuhrstgkValue()))
            .orNull();
    }

    transient private String yenkaiyakuhrstgkType = null;

    @Column(name=YENKAIYAKUHRSTGK + "$", nullable=true)
    protected String getYenkaiyakuhrstgkType() {
        if (yenkaiyakuhrstgkType == null && yenkaiyakuhrstgk != null) return yenkaiyakuhrstgk.getType().toString();
        if (yenkaiyakuhrstgkType == null && getYenkaiyakuhrstgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaiyakuhrstgk$' should not be NULL."));
        }
        return yenkaiyakuhrstgkType;
    }

    protected void setYenkaiyakuhrstgkType(String type) {
        yenkaiyakuhrstgkType = type;
        yenkaiyakuhrstgk = Optional.fromNullable(toCurrencyType(yenkaiyakuhrstgkType))
            .transform(bizCurrencyTransformer(getYenkaiyakuhrstgkValue()))
            .orNull();
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private BizDate yenkansantkykwsrateymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KykSyaHenkouRireki.YENKANSANTKYKWSRATEYMD)
    public BizDate getYenkansantkykwsrateymd() {
        return yenkansantkykwsrateymd;
    }

    public void setYenkansantkykwsrateymd(BizDate pYenkansantkykwsrateymd) {
        yenkansantkykwsrateymd = pYenkansantkykwsrateymd;
    }

    private BizCurrency kihrkmpsgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmpsgk() {
        return kihrkmpsgk;
    }

    public void setKihrkmpsgk(BizCurrency pKihrkmpsgk) {
        kihrkmpsgk = pKihrkmpsgk;
        kihrkmpsgkValue = null;
        kihrkmpsgkType  = null;
    }

    transient private BigDecimal kihrkmpsgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMPSGK, nullable=true)
    protected BigDecimal getKihrkmpsgkValue() {
        if (kihrkmpsgkValue == null && kihrkmpsgk != null) {
            if (kihrkmpsgk.isOptional()) return null;
            return kihrkmpsgk.absolute();
        }
        return kihrkmpsgkValue;
    }

    protected void setKihrkmpsgkValue(BigDecimal value) {
        kihrkmpsgkValue = value;
        kihrkmpsgk = Optional.fromNullable(toCurrencyType(kihrkmpsgkType))
            .transform(bizCurrencyTransformer(getKihrkmpsgkValue()))
            .orNull();
    }

    transient private String kihrkmpsgkType = null;

    @Column(name=KIHRKMPSGK + "$", nullable=true)
    protected String getKihrkmpsgkType() {
        if (kihrkmpsgkType == null && kihrkmpsgk != null) return kihrkmpsgk.getType().toString();
        if (kihrkmpsgkType == null && getKihrkmpsgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmpsgk$' should not be NULL."));
        }
        return kihrkmpsgkType;
    }

    protected void setKihrkmpsgkType(String type) {
        kihrkmpsgkType = type;
        kihrkmpsgk = Optional.fromNullable(toCurrencyType(kihrkmpsgkType))
            .transform(bizCurrencyTransformer(getKihrkmpsgkValue()))
            .orNull();
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

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KykSyaHenkouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizCurrency sonotashrkngkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotashrkngkyen() {
        return sonotashrkngkyen;
    }

    public void setSonotashrkngkyen(BizCurrency pSonotashrkngkyen) {
        sonotashrkngkyen = pSonotashrkngkyen;
        sonotashrkngkyenValue = null;
        sonotashrkngkyenType  = null;
    }

    transient private BigDecimal sonotashrkngkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASHRKNGKYEN, nullable=true)
    protected BigDecimal getSonotashrkngkyenValue() {
        if (sonotashrkngkyenValue == null && sonotashrkngkyen != null) {
            if (sonotashrkngkyen.isOptional()) return null;
            return sonotashrkngkyen.absolute();
        }
        return sonotashrkngkyenValue;
    }

    protected void setSonotashrkngkyenValue(BigDecimal value) {
        sonotashrkngkyenValue = value;
        sonotashrkngkyen = Optional.fromNullable(toCurrencyType(sonotashrkngkyenType))
            .transform(bizCurrencyTransformer(getSonotashrkngkyenValue()))
            .orNull();
    }

    transient private String sonotashrkngkyenType = null;

    @Column(name=SONOTASHRKNGKYEN + "$", nullable=true)
    protected String getSonotashrkngkyenType() {
        if (sonotashrkngkyenType == null && sonotashrkngkyen != null) return sonotashrkngkyen.getType().toString();
        if (sonotashrkngkyenType == null && getSonotashrkngkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotashrkngkyen$' should not be NULL."));
        }
        return sonotashrkngkyenType;
    }

    protected void setSonotashrkngkyenType(String type) {
        sonotashrkngkyenType = type;
        sonotashrkngkyen = Optional.fromNullable(toCurrencyType(sonotashrkngkyenType))
            .transform(bizCurrencyTransformer(getSonotashrkngkyenValue()))
            .orNull();
    }
}