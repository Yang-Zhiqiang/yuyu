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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TeiseiKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.id.PKIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.GenQIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.QIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KykdrtkykttdkKbn;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TeiseiKbn;
import yuyu.def.db.type.UserType_C_TrkkzkttdkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_TyhysakuseiyhKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 家族登録契約者代理特約変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhKzktrkKykDrHnkWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKzktrkKykDrHnkWk}</td><td colspan="3">家族登録契約者代理特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhKzktrkKykDrHnkWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkssakuseiymd skssakuseiymd}</td><td>請求書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMousideninkbn mousideninkbn}</td><td>申出人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MousideninKbn}</td></tr>
 *  <tr><td>{@link #getTeiseikbn teiseikbn}</td><td>訂正区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TeiseiKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkttdkkbn1 trkkzkttdkkbn1}</td><td>登録家族手続区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrkkzkttdkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkn1 trkkzknmkn1}</td><td>登録家族名（カナ）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj1 trkkzknmkj1}</td><td>登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkjkhukakbn1 trkkzknmkjkhukakbn1}</td><td>登録家族名漢字化不可区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd1 trkkzkseiymd1}</td><td>登録家族生年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzksei1 trkkzksei1}</td><td>登録家族性別１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzkyno1 trkkzkyno1}</td><td>登録家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj1 trkkzkadr1kj1}</td><td>登録家族住所１（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj1 trkkzkadr2kj1}</td><td>登録家族住所２（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj1 trkkzkadr3kj1}</td><td>登録家族住所３（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno1 trkkzktelno1}</td><td>登録家族電話番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktdk1 trkkzktdk1}</td><td>登録家族続柄１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTrkkzkttdkkbn2 trkkzkttdkkbn2}</td><td>登録家族手続区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrkkzkttdkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkn2 trkkzknmkn2}</td><td>登録家族名（カナ）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj2 trkkzknmkj2}</td><td>登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkjkhukakbn2 trkkzknmkjkhukakbn2}</td><td>登録家族名漢字化不可区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd2 trkkzkseiymd2}</td><td>登録家族生年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzksei2 trkkzksei2}</td><td>登録家族性別２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzktdk2 trkkzktdk2}</td><td>登録家族続柄２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTrkkzkyno2 trkkzkyno2}</td><td>登録家族郵便番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj2 trkkzkadr1kj2}</td><td>登録家族住所１（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj2 trkkzkadr2kj2}</td><td>登録家族住所２（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj2 trkkzkadr3kj2}</td><td>登録家族住所３（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno2 trkkzktelno2}</td><td>登録家族電話番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrtkykttdkkbn kykdrtkykttdkkbn}</td><td>契約者代理特約手続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykdrtkykttdkKbn}</td></tr>
 *  <tr><td>{@link #getKykdrkbn kykdrkbn}</td><td>契約者代理人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getKykdairinmkn kykdairinmkn}</td><td>契約者代理人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinmkj kykdairinmkj}</td><td>契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrnmkjkhukakbn kykdrnmkjkhukakbn}</td><td>契約者代理人名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykdrseiymd kykdrseiymd}</td><td>契約者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdryno kykdryno}</td><td>契約者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr1kj kykdradr1kj}</td><td>契約者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr2kj kykdradr2kj}</td><td>契約者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr3kj kykdradr3kj}</td><td>契約者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getTyhysakuseiyhkbn tyhysakuseiyhkbn}</td><td>帳票作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhysakuseiyhKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktsindousiteikbn1 trkkzktsindousiteikbn1}</td><td>登録家族通信先同一指定区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzktsindousiteikbn2 trkkzktsindousiteikbn2}</td><td>登録家族通信先同一指定区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 * </table>
 * @see     IW_KhKzktrkKykDrHnkWk
 * @see     PKIW_KhKzktrkKykDrHnkWk
 * @see     QIW_KhKzktrkKykDrHnkWk
 * @see     GenQIW_KhKzktrkKykDrHnkWk
 */
@MappedSuperclass
@Table(name=GenIW_KhKzktrkKykDrHnkWk.TABLE_NAME)
@IdClass(value=PKIW_KhKzktrkKykDrHnkWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_KykdrtkykttdkKbn", typeClass=UserType_C_KykdrtkykttdkKbn.class),
    @TypeDef(name="UserType_C_MousideninKbn", typeClass=UserType_C_MousideninKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TeiseiKbn", typeClass=UserType_C_TeiseiKbn.class),
    @TypeDef(name="UserType_C_TrkkzkttdkKbn", typeClass=UserType_C_TrkkzkttdkKbn.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class),
    @TypeDef(name="UserType_C_TyhysakuseiyhKbn", typeClass=UserType_C_TyhysakuseiyhKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class)
})
public abstract class GenIW_KhKzktrkKykDrHnkWk extends AbstractExDBEntity<IW_KhKzktrkKykDrHnkWk, PKIW_KhKzktrkKykDrHnkWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhKzktrkKykDrHnkWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String SKSSAKUSEIYMD            = "skssakuseiymd";
    public static final String MOUSIDENINKBN            = "mousideninkbn";
    public static final String TEISEIKBN                = "teiseikbn";
    public static final String TRKKZKTTDKKBN1           = "trkkzkttdkkbn1";
    public static final String TRKKZKNMKN1              = "trkkzknmkn1";
    public static final String TRKKZKNMKJ1              = "trkkzknmkj1";
    public static final String TRKKZKNMKJKHUKAKBN1      = "trkkzknmkjkhukakbn1";
    public static final String TRKKZKSEIYMD1            = "trkkzkseiymd1";
    public static final String TRKKZKSEI1               = "trkkzksei1";
    public static final String TRKKZKYNO1               = "trkkzkyno1";
    public static final String TRKKZKADR1KJ1            = "trkkzkadr1kj1";
    public static final String TRKKZKADR2KJ1            = "trkkzkadr2kj1";
    public static final String TRKKZKADR3KJ1            = "trkkzkadr3kj1";
    public static final String TRKKZKTELNO1             = "trkkzktelno1";
    public static final String TRKKZKTDK1               = "trkkzktdk1";
    public static final String TRKKZKTTDKKBN2           = "trkkzkttdkkbn2";
    public static final String TRKKZKNMKN2              = "trkkzknmkn2";
    public static final String TRKKZKNMKJ2              = "trkkzknmkj2";
    public static final String TRKKZKNMKJKHUKAKBN2      = "trkkzknmkjkhukakbn2";
    public static final String TRKKZKSEIYMD2            = "trkkzkseiymd2";
    public static final String TRKKZKSEI2               = "trkkzksei2";
    public static final String TRKKZKTDK2               = "trkkzktdk2";
    public static final String TRKKZKYNO2               = "trkkzkyno2";
    public static final String TRKKZKADR1KJ2            = "trkkzkadr1kj2";
    public static final String TRKKZKADR2KJ2            = "trkkzkadr2kj2";
    public static final String TRKKZKADR3KJ2            = "trkkzkadr3kj2";
    public static final String TRKKZKTELNO2             = "trkkzktelno2";
    public static final String KYKDRTKYKTTDKKBN         = "kykdrtkykttdkkbn";
    public static final String KYKDRKBN                 = "kykdrkbn";
    public static final String KYKDAIRINMKN             = "kykdairinmkn";
    public static final String KYKDAIRINMKJ             = "kykdairinmkj";
    public static final String KYKDRNMKJKHUKAKBN        = "kykdrnmkjkhukakbn";
    public static final String KYKDRSEIYMD              = "kykdrseiymd";
    public static final String KYKDRYNO                 = "kykdryno";
    public static final String KYKDRADR1KJ              = "kykdradr1kj";
    public static final String KYKDRADR2KJ              = "kykdradr2kj";
    public static final String KYKDRADR3KJ              = "kykdradr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String TYHYSAKUSEIYHKBN         = "tyhysakuseiyhkbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String TRKKZKTSINDOUSITEIKBN1   = "trkkzktsindousiteikbn1";
    public static final String TRKKZKTSINDOUSITEIKBN2   = "trkkzktsindousiteikbn2";

    private final PKIW_KhKzktrkKykDrHnkWk primaryKey;

    public GenIW_KhKzktrkKykDrHnkWk() {
        primaryKey = new PKIW_KhKzktrkKykDrHnkWk();
    }

    public GenIW_KhKzktrkKykDrHnkWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhKzktrkKykDrHnkWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhKzktrkKykDrHnkWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhKzktrkKykDrHnkWk> getMetaClass() {
        return QIW_KhKzktrkKykDrHnkWk.class;
    }

    @Id
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SYONO)
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
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SKSSAKUSEIYMD)
    public BizDate getSkssakuseiymd() {
        return skssakuseiymd;
    }

    public void setSkssakuseiymd(BizDate pSkssakuseiymd) {
        skssakuseiymd = pSkssakuseiymd;
    }

    private C_MousideninKbn mousideninkbn;

    @Type(type="UserType_C_MousideninKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.MOUSIDENINKBN)
    public C_MousideninKbn getMousideninkbn() {
        return mousideninkbn;
    }

    public void setMousideninkbn(C_MousideninKbn pMousideninkbn) {
        mousideninkbn = pMousideninkbn;
    }

    private C_TeiseiKbn teiseikbn;

    @Type(type="UserType_C_TeiseiKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TEISEIKBN)
    public C_TeiseiKbn getTeiseikbn() {
        return teiseikbn;
    }

    public void setTeiseikbn(C_TeiseiKbn pTeiseikbn) {
        teiseikbn = pTeiseikbn;
    }

    private C_TrkkzkttdkKbn trkkzkttdkkbn1;

    @Type(type="UserType_C_TrkkzkttdkKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTTDKKBN1)
    public C_TrkkzkttdkKbn getTrkkzkttdkkbn1() {
        return trkkzkttdkkbn1;
    }

    public void setTrkkzkttdkkbn1(C_TrkkzkttdkKbn pTrkkzkttdkkbn1) {
        trkkzkttdkkbn1 = pTrkkzkttdkkbn1;
    }

    private String trkkzknmkn1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKN1)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getTrkkzknmkn1() {
        return trkkzknmkn1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn1(String pTrkkzknmkn1) {
        trkkzknmkn1 = pTrkkzknmkn1;
    }

    private String trkkzknmkj1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKJ1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj1(String pTrkkzknmkj1) {
        trkkzknmkj1 = pTrkkzknmkj1;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn1;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKJKHUKAKBN1)
    public C_KjkhukaKbn getTrkkzknmkjkhukakbn1() {
        return trkkzknmkjkhukakbn1;
    }

    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn pTrkkzknmkjkhukakbn1) {
        trkkzknmkjkhukakbn1 = pTrkkzknmkjkhukakbn1;
    }

    private BizDate trkkzkseiymd1;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKSEIYMD1)
    @ValidDate
    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd1(BizDate pTrkkzkseiymd1) {
        trkkzkseiymd1 = pTrkkzkseiymd1;
    }

    private C_Seibetu trkkzksei1;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKSEI1)
    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private String trkkzkyno1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKYNO1)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno1(String pTrkkzkyno1) {
        trkkzkyno1 = pTrkkzkyno1;
    }

    private String trkkzkadr1kj1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR1KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    private String trkkzkadr2kj1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR2KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    private String trkkzkadr3kj1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR3KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    private String trkkzktelno1;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTELNO1)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno1(String pTrkkzktelno1) {
        trkkzktelno1 = pTrkkzktelno1;
    }

    private C_Tdk trkkzktdk1;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTDK1)
    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    private C_TrkkzkttdkKbn trkkzkttdkkbn2;

    @Type(type="UserType_C_TrkkzkttdkKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTTDKKBN2)
    public C_TrkkzkttdkKbn getTrkkzkttdkkbn2() {
        return trkkzkttdkkbn2;
    }

    public void setTrkkzkttdkkbn2(C_TrkkzkttdkKbn pTrkkzkttdkkbn2) {
        trkkzkttdkkbn2 = pTrkkzkttdkkbn2;
    }

    private String trkkzknmkn2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKN2)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getTrkkzknmkn2() {
        return trkkzknmkn2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkn2(String pTrkkzknmkn2) {
        trkkzknmkn2 = pTrkkzknmkn2;
    }

    private String trkkzknmkj2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzknmkj2() {
        return trkkzknmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj2(String pTrkkzknmkj2) {
        trkkzknmkj2 = pTrkkzknmkj2;
    }

    private C_KjkhukaKbn trkkzknmkjkhukakbn2;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKNMKJKHUKAKBN2)
    public C_KjkhukaKbn getTrkkzknmkjkhukakbn2() {
        return trkkzknmkjkhukakbn2;
    }

    public void setTrkkzknmkjkhukakbn2(C_KjkhukaKbn pTrkkzknmkjkhukakbn2) {
        trkkzknmkjkhukakbn2 = pTrkkzknmkjkhukakbn2;
    }

    private BizDate trkkzkseiymd2;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKSEIYMD2)
    @ValidDate
    public BizDate getTrkkzkseiymd2() {
        return trkkzkseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd2(BizDate pTrkkzkseiymd2) {
        trkkzkseiymd2 = pTrkkzkseiymd2;
    }

    private C_Seibetu trkkzksei2;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKSEI2)
    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private C_Tdk trkkzktdk2;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTDK2)
    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    private String trkkzkyno2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKYNO2)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno2(String pTrkkzkyno2) {
        trkkzkyno2 = pTrkkzkyno2;
    }

    private String trkkzkadr1kj2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR1KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    private String trkkzkadr2kj2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR2KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    private String trkkzkadr3kj2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKADR3KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    private String trkkzktelno2;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTELNO2)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTrkkzktelno2() {
        return trkkzktelno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno2(String pTrkkzktelno2) {
        trkkzktelno2 = pTrkkzktelno2;
    }

    private C_KykdrtkykttdkKbn kykdrtkykttdkkbn;

    @Type(type="UserType_C_KykdrtkykttdkKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRTKYKTTDKKBN)
    public C_KykdrtkykttdkKbn getKykdrtkykttdkkbn() {
        return kykdrtkykttdkkbn;
    }

    public void setKykdrtkykttdkkbn(C_KykdrtkykttdkKbn pKykdrtkykttdkkbn) {
        kykdrtkykttdkkbn = pKykdrtkykttdkkbn;
    }

    private C_UktKbn kykdrkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRKBN)
    public C_UktKbn getKykdrkbn() {
        return kykdrkbn;
    }

    public void setKykdrkbn(C_UktKbn pKykdrkbn) {
        kykdrkbn = pKykdrkbn;
    }

    private String kykdairinmkn;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDAIRINMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKykdairinmkn() {
        return kykdairinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkn(String pKykdairinmkn) {
        kykdairinmkn = pKykdairinmkn;
    }

    private String kykdairinmkj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDAIRINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    private C_KjkhukaKbn kykdrnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRNMKJKHUKAKBN)
    public C_KjkhukaKbn getKykdrnmkjkhukakbn() {
        return kykdrnmkjkhukakbn;
    }

    public void setKykdrnmkjkhukakbn(C_KjkhukaKbn pKykdrnmkjkhukakbn) {
        kykdrnmkjkhukakbn = pKykdrnmkjkhukakbn;
    }

    private BizDate kykdrseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRSEIYMD)
    @ValidDate
    public BizDate getKykdrseiymd() {
        return kykdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrseiymd(BizDate pKykdrseiymd) {
        kykdrseiymd = pKykdrseiymd;
    }

    private String kykdryno;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRYNO)
    @Length(length=7)
    @Digit
    public String getKykdryno() {
        return kykdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdryno(String pKykdryno) {
        kykdryno = pKykdryno;
    }

    private String kykdradr1kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr1kj(String pKykdradr1kj) {
        kykdradr1kj = pKykdradr1kj;
    }

    private String kykdradr2kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr2kj(String pKykdradr2kj) {
        kykdradr2kj = pKykdradr2kj;
    }

    private String kykdradr3kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.KYKDRADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr3kj(String pKykdradr3kj) {
        kykdradr3kj = pKykdradr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String shskyno;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_TyhysakuseiyhKbn tyhysakuseiyhkbn;

    @Type(type="UserType_C_TyhysakuseiyhKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TYHYSAKUSEIYHKBN)
    public C_TyhysakuseiyhKbn getTyhysakuseiyhkbn() {
        return tyhysakuseiyhkbn;
    }

    public void setTyhysakuseiyhkbn(C_TyhysakuseiyhKbn pTyhysakuseiyhkbn) {
        tyhysakuseiyhkbn = pTyhysakuseiyhkbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhKzktrkKykDrHnkWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn1;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTSINDOUSITEIKBN1)
    public C_TsindousiteiKbn getTrkkzktsindousiteikbn1() {
        return trkkzktsindousiteikbn1;
    }

    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        trkkzktsindousiteikbn1 = pTrkkzktsindousiteikbn1;
    }

    private C_TsindousiteiKbn trkkzktsindousiteikbn2;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenIW_KhKzktrkKykDrHnkWk.TRKKZKTSINDOUSITEIKBN2)
    public C_TsindousiteiKbn getTrkkzktsindousiteikbn2() {
        return trkkzktsindousiteikbn2;
    }

    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        trkkzktsindousiteikbn2 = pTrkkzktsindousiteikbn2;
    }
}