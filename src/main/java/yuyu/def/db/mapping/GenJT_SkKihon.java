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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.id.PKJT_SkKihon;
import yuyu.def.db.meta.GenQJT_SkKihon;
import yuyu.def.db.meta.QJT_SkKihon;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HubiJyoukyouKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_SaigaiHigaitouKbn;
import yuyu.def.db.type.UserType_C_SaisateiKbn;
import yuyu.def.db.type.UserType_C_SateiYouhiKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriJyoutaiKbn;
import yuyu.def.db.type.UserType_C_TyousaJyoukyouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求基本テーブル テーブルのマッピング情報クラスで、 {@link JT_SkKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkKihon}</td><td colspan="3">請求基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SkKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SkKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getSaisateikbn saisateikbn}</td><td>再査定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaisateiKbn}</td></tr>
 *  <tr><td>{@link #getSiboukaritrkymd siboukaritrkymd}</td><td>死亡仮受付登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getSyorijyoutaikbn syorijyoutaikbn}</td><td>処理状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getSateiyhkbn sateiyhkbn}</td><td>査定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SateiYouhiKbn}</td></tr>
 *  <tr><td>{@link #getKakninumukbn kakninumukbn}</td><td>確認有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHubijyoukyoukbn hubijyoukyoukbn}</td><td>不備状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubiJyoukyouKbn}</td></tr>
 *  <tr><td>{@link #getTyousajyoukyoukbn tyousajyoukyoukbn}</td><td>調査状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyousaJyoukyouKbn}</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSbjishrumukbn sbjishrumukbn}</td><td>死亡時支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaigaihigaitoukbn saigaihigaitoukbn}</td><td>災害非該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaigaiHigaitouKbn}</td></tr>
 *  <tr><td>{@link #getGaibuinsatuoutymd gaibuinsatuoutymd}</td><td>外部印刷出力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkKihon
 * @see     PKJT_SkKihon
 * @see     QJT_SkKihon
 * @see     GenQJT_SkKihon
 */
@MappedSuperclass
@Table(name=GenJT_SkKihon.TABLE_NAME)
@IdClass(value=PKJT_SkKihon.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HubiJyoukyouKbn", typeClass=UserType_C_HubiJyoukyouKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_SaigaiHigaitouKbn", typeClass=UserType_C_SaigaiHigaitouKbn.class),
    @TypeDef(name="UserType_C_SaisateiKbn", typeClass=UserType_C_SaisateiKbn.class),
    @TypeDef(name="UserType_C_SateiYouhiKbn", typeClass=UserType_C_SateiYouhiKbn.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_SyoriJyoutaiKbn", typeClass=UserType_C_SyoriJyoutaiKbn.class),
    @TypeDef(name="UserType_C_TyousaJyoukyouKbn", typeClass=UserType_C_TyousaJyoukyouKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SkKihon extends AbstractExDBEntity<JT_SkKihon, PKJT_SkKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SkKihon";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String SAISATEIKBN              = "saisateikbn";
    public static final String SIBOUKARITRKYMD          = "siboukaritrkymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKSEI                   = "kyksei";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String SYORIJYOUTAIKBN          = "syorijyoutaikbn";
    public static final String SATEIYHKBN               = "sateiyhkbn";
    public static final String KAKNINUMUKBN             = "kakninumukbn";
    public static final String HUBIJYOUKYOUKBN          = "hubijyoukyoukbn";
    public static final String TYOUSAJYOUKYOUKBN        = "tyousajyoukyoukbn";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String SBJISHRUMUKBN            = "sbjishrumukbn";
    public static final String SAIGAIHIGAITOUKBN        = "saigaihigaitoukbn";
    public static final String GAIBUINSATUOUTYMD        = "gaibuinsatuoutymd";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SkKihon primaryKey;

    public GenJT_SkKihon() {
        primaryKey = new PKJT_SkKihon();
    }

    public GenJT_SkKihon(String pSkno, String pSyono) {
        primaryKey = new PKJT_SkKihon(pSkno, pSyono);
    }

    @Transient
    @Override
    public PKJT_SkKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SkKihon> getMetaClass() {
        return QJT_SkKihon.class;
    }

    @Id
    @Column(name=GenJT_SkKihon.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SkKihon.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJT_SkKihon.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_SaisateiKbn saisateikbn;

    @Type(type="UserType_C_SaisateiKbn")
    @Column(name=GenJT_SkKihon.SAISATEIKBN)
    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;
    }

    private BizDate siboukaritrkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKihon.SIBOUKARITRKYMD)
    @ValidDate
    public BizDate getSiboukaritrkymd() {
        return siboukaritrkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiboukaritrkymd(BizDate pSiboukaritrkymd) {
        siboukaritrkymd = pSiboukaritrkymd;
    }

    private String kyknmkj;

    @Column(name=GenJT_SkKihon.KYKNMKJ)
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

    private String kyknmkn;

    @Column(name=GenJT_SkKihon.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKihon.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenJT_SkKihon.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private String hhknnmkj;

    @Column(name=GenJT_SkKihon.HHKNNMKJ)
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

    private String hhknnmkn;

    @Column(name=GenJT_SkKihon.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKihon.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenJT_SkKihon.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private C_SyoriJyoutaiKbn syorijyoutaikbn;

    @Type(type="UserType_C_SyoriJyoutaiKbn")
    @Column(name=GenJT_SkKihon.SYORIJYOUTAIKBN)
    public C_SyoriJyoutaiKbn getSyorijyoutaikbn() {
        return syorijyoutaikbn;
    }

    public void setSyorijyoutaikbn(C_SyoriJyoutaiKbn pSyorijyoutaikbn) {
        syorijyoutaikbn = pSyorijyoutaikbn;
    }

    private C_SateiYouhiKbn sateiyhkbn;

    @Type(type="UserType_C_SateiYouhiKbn")
    @Column(name=GenJT_SkKihon.SATEIYHKBN)
    public C_SateiYouhiKbn getSateiyhkbn() {
        return sateiyhkbn;
    }

    public void setSateiyhkbn(C_SateiYouhiKbn pSateiyhkbn) {
        sateiyhkbn = pSateiyhkbn;
    }

    private C_UmuKbn kakninumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SkKihon.KAKNINUMUKBN)
    public C_UmuKbn getKakninumukbn() {
        return kakninumukbn;
    }

    public void setKakninumukbn(C_UmuKbn pKakninumukbn) {
        kakninumukbn = pKakninumukbn;
    }

    private C_HubiJyoukyouKbn hubijyoukyoukbn;

    @Type(type="UserType_C_HubiJyoukyouKbn")
    @Column(name=GenJT_SkKihon.HUBIJYOUKYOUKBN)
    public C_HubiJyoukyouKbn getHubijyoukyoukbn() {
        return hubijyoukyoukbn;
    }

    public void setHubijyoukyoukbn(C_HubiJyoukyouKbn pHubijyoukyoukbn) {
        hubijyoukyoukbn = pHubijyoukyoukbn;
    }

    private C_TyousaJyoukyouKbn tyousajyoukyoukbn;

    @Type(type="UserType_C_TyousaJyoukyouKbn")
    @Column(name=GenJT_SkKihon.TYOUSAJYOUKYOUKBN)
    public C_TyousaJyoukyouKbn getTyousajyoukyoukbn() {
        return tyousajyoukyoukbn;
    }

    public void setTyousajyoukyoukbn(C_TyousaJyoukyouKbn pTyousajyoukyoukbn) {
        tyousajyoukyoukbn = pTyousajyoukyoukbn;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJT_SkKihon.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private C_UmuKbn sbjishrumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SkKihon.SBJISHRUMUKBN)
    public C_UmuKbn getSbjishrumukbn() {
        return sbjishrumukbn;
    }

    public void setSbjishrumukbn(C_UmuKbn pSbjishrumukbn) {
        sbjishrumukbn = pSbjishrumukbn;
    }

    private C_SaigaiHigaitouKbn saigaihigaitoukbn;

    @Type(type="UserType_C_SaigaiHigaitouKbn")
    @Column(name=GenJT_SkKihon.SAIGAIHIGAITOUKBN)
    public C_SaigaiHigaitouKbn getSaigaihigaitoukbn() {
        return saigaihigaitoukbn;
    }

    public void setSaigaihigaitoukbn(C_SaigaiHigaitouKbn pSaigaihigaitoukbn) {
        saigaihigaitoukbn = pSaigaihigaitoukbn;
    }

    private BizDate gaibuinsatuoutymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SkKihon.GAIBUINSATUOUTYMD)
    @ValidDate
    public BizDate getGaibuinsatuoutymd() {
        return gaibuinsatuoutymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaibuinsatuoutymd(BizDate pGaibuinsatuoutymd) {
        gaibuinsatuoutymd = pGaibuinsatuoutymd;
    }

    private String kossyoricd;

    @Column(name=GenJT_SkKihon.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SkKihon.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SkKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SkKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}