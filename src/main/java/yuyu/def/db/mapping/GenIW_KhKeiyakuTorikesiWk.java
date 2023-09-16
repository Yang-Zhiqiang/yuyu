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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhKeiyakuTorikesiWk;
import yuyu.def.db.id.PKIW_KhKeiyakuTorikesiWk;
import yuyu.def.db.meta.GenQIW_KhKeiyakuTorikesiWk;
import yuyu.def.db.meta.QIW_KhKeiyakuTorikesiWk;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KyktrksKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約取消ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_KhKeiyakuTorikesiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhKeiyakuTorikesiWk}</td><td colspan="3">契約取消ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">{@link PKIW_KhKeiyakuTorikesiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktrkskbn kyktrkskbn}</td><td>契約取消区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyktrksKbn}</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaijyokessaiymd kaijyokessaiymd}</td><td>解除決裁日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaijyotuutiymd kaijyotuutiymd}</td><td>解除通知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHubikanryouymd hubikanryouymd}</td><td>不備完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSinsagendokknkbn sinsagendokknkbn}</td><td>審査限度期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>{@link #getRikoukityuutuudannissuu rikoukityuutuudannissuu}</td><td>履行期中断日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSoukinsakisiteikbn soukinsakisiteikbn}</td><td>送金先指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakisiteiKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakinmkn soukinsakinmkn}</td><td>送金先氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakinmkj soukinsakinmkj}</td><td>送金先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiyno soukinsakiyno}</td><td>送金先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr1kj soukinsakiadr1kj}</td><td>送金先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr2kj soukinsakiadr2kj}</td><td>送金先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr3kj soukinsakiadr3kj}</td><td>送金先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkn kyksyaszknmkn}</td><td>契約者相続人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkj kyksyaszknmkj}</td><td>契約者相続人氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkyno kyksyaszkyno}</td><td>契約者相続人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr1kj kyksyaszkadr1kj}</td><td>契約者相続人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr2kj kyksyaszkadr2kj}</td><td>契約者相続人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr3kj kyksyaszkadr3kj}</td><td>契約者相続人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenshrtkumu yenshrtkumu}</td><td>円支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonninkakninkekkakbn honninkakninkekkakbn}</td><td>本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getZenkaisyorikekkakbn zenkaisyorikekkakbn}</td><td>前回処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakikbn soukinsakikbn}</td><td>送金先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakiKbn}</td></tr>
 * </table>
 * @see     IW_KhKeiyakuTorikesiWk
 * @see     PKIW_KhKeiyakuTorikesiWk
 * @see     QIW_KhKeiyakuTorikesiWk
 * @see     GenQIW_KhKeiyakuTorikesiWk
 */
@MappedSuperclass
@Table(name=GenIW_KhKeiyakuTorikesiWk.TABLE_NAME)
@IdClass(value=PKIW_KhKeiyakuTorikesiWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HonninKakninKekkaKbn", typeClass=UserType_C_HonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_KyktrksKbn", typeClass=UserType_C_KyktrksKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_SinsaGendoKknKbn", typeClass=UserType_C_SinsaGendoKknKbn.class),
    @TypeDef(name="UserType_C_SoukinsakiKbn", typeClass=UserType_C_SoukinsakiKbn.class),
    @TypeDef(name="UserType_C_SoukinsakisiteiKbn", typeClass=UserType_C_SoukinsakisiteiKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIW_KhKeiyakuTorikesiWk extends AbstractExDBEntity<IW_KhKeiyakuTorikesiWk, PKIW_KhKeiyakuTorikesiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_KhKeiyakuTorikesiWk";
    public static final String KOUTEIKANRIID            = "kouteikanriid";
    public static final String SYONO                    = "syono";
    public static final String KYKTRKSKBN               = "kyktrkskbn";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String KAIJYOKESSAIYMD          = "kaijyokessaiymd";
    public static final String KAIJYOTUUTIYMD           = "kaijyotuutiymd";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String HUBIKANRYOUYMD           = "hubikanryouymd";
    public static final String SINSAGENDOKKNKBN         = "sinsagendokknkbn";
    public static final String RIKOUKITYUUTUUDANNISSUU  = "rikoukityuutuudannissuu";
    public static final String SOUKINSAKISITEIKBN       = "soukinsakisiteikbn";
    public static final String SOUKINSAKINMKN           = "soukinsakinmkn";
    public static final String SOUKINSAKINMKJ           = "soukinsakinmkj";
    public static final String SOUKINSAKIYNO            = "soukinsakiyno";
    public static final String SOUKINSAKIADR1KJ         = "soukinsakiadr1kj";
    public static final String SOUKINSAKIADR2KJ         = "soukinsakiadr2kj";
    public static final String SOUKINSAKIADR3KJ         = "soukinsakiadr3kj";
    public static final String KYKSYASZKNMKN            = "kyksyaszknmkn";
    public static final String KYKSYASZKNMKJ            = "kyksyaszknmkj";
    public static final String KYKSYASZKYNO             = "kyksyaszkyno";
    public static final String KYKSYASZKADR1KJ          = "kyksyaszkadr1kj";
    public static final String KYKSYASZKADR2KJ          = "kyksyaszkadr2kj";
    public static final String KYKSYASZKADR3KJ          = "kyksyaszkadr3kj";
    public static final String YENSHRTKUMU              = "yenshrtkumu";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String HONNINKAKNINKEKKAKBN     = "honninkakninkekkakbn";
    public static final String ZENKAISYORIKEKKAKBN      = "zenkaisyorikekkakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SOUKINSAKIKBN            = "soukinsakikbn";

    private final PKIW_KhKeiyakuTorikesiWk primaryKey;

    public GenIW_KhKeiyakuTorikesiWk() {
        primaryKey = new PKIW_KhKeiyakuTorikesiWk();
    }

    public GenIW_KhKeiyakuTorikesiWk(String pKouteikanriid) {
        primaryKey = new PKIW_KhKeiyakuTorikesiWk(pKouteikanriid);
    }

    @Transient
    @Override
    public PKIW_KhKeiyakuTorikesiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_KhKeiyakuTorikesiWk> getMetaClass() {
        return QIW_KhKeiyakuTorikesiWk.class;
    }

    @Id
    @Column(name=GenIW_KhKeiyakuTorikesiWk.KOUTEIKANRIID)
    public String getKouteikanriid() {
        return getPrimaryKey().getKouteikanriid();
    }

    public void setKouteikanriid(String pKouteikanriid) {
        getPrimaryKey().setKouteikanriid(pKouteikanriid);
    }

    private String syono;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_KyktrksKbn kyktrkskbn;

    @Type(type="UserType_C_KyktrksKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKTRKSKBN)
    public C_KyktrksKbn getKyktrkskbn() {
        return kyktrkskbn;
    }

    public void setKyktrkskbn(C_KyktrksKbn pKyktrkskbn) {
        kyktrkskbn = pKyktrkskbn;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private BizDate kaijyokessaiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.KAIJYOKESSAIYMD)
    @ValidDate
    public BizDate getKaijyokessaiymd() {
        return kaijyokessaiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaijyokessaiymd(BizDate pKaijyokessaiymd) {
        kaijyokessaiymd = pKaijyokessaiymd;
    }

    private BizDate kaijyotuutiymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.KAIJYOTUUTIYMD)
    @ValidDate
    public BizDate getKaijyotuutiymd() {
        return kaijyotuutiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaijyotuutiymd(BizDate pKaijyotuutiymd) {
        kaijyotuutiymd = pKaijyotuutiymd;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate hubikanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.HUBIKANRYOUYMD)
    @ValidDate
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    @Type(type="UserType_C_SinsaGendoKknKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.SINSAGENDOKKNKBN)
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    private Integer rikoukityuutuudannissuu;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.RIKOUKITYUUTUUDANNISSUU)
    @Range(min="0", max="999")
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    private C_SoukinsakisiteiKbn soukinsakisiteikbn;

    @Type(type="UserType_C_SoukinsakisiteiKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKISITEIKBN)
    public C_SoukinsakisiteiKbn getSoukinsakisiteikbn() {
        return soukinsakisiteikbn;
    }

    public void setSoukinsakisiteikbn(C_SoukinsakisiteiKbn pSoukinsakisiteikbn) {
        soukinsakisiteikbn = pSoukinsakisiteikbn;
    }

    private String soukinsakinmkn;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKINMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSoukinsakinmkn() {
        return soukinsakinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakinmkn(String pSoukinsakinmkn) {
        soukinsakinmkn = pSoukinsakinmkn;
    }

    private String soukinsakinmkj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakinmkj() {
        return soukinsakinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakinmkj(String pSoukinsakinmkj) {
        soukinsakinmkj = pSoukinsakinmkj;
    }

    private String soukinsakiyno;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKIYNO)
    @Digit
    @Length(length=7)
    public String getSoukinsakiyno() {
        return soukinsakiyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSoukinsakiyno(String pSoukinsakiyno) {
        soukinsakiyno = pSoukinsakiyno;
    }

    private String soukinsakiadr1kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKIADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr1kj() {
        return soukinsakiadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr1kj(String pSoukinsakiadr1kj) {
        soukinsakiadr1kj = pSoukinsakiadr1kj;
    }

    private String soukinsakiadr2kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKIADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr2kj() {
        return soukinsakiadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr2kj(String pSoukinsakiadr2kj) {
        soukinsakiadr2kj = pSoukinsakiadr2kj;
    }

    private String soukinsakiadr3kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKIADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr3kj() {
        return soukinsakiadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr3kj(String pSoukinsakiadr3kj) {
        soukinsakiadr3kj = pSoukinsakiadr3kj;
    }

    private String kyksyaszknmkn;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyksyaszknmkn() {
        return kyksyaszknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkn(String pKyksyaszknmkn) {
        kyksyaszknmkn = pKyksyaszknmkn;
    }

    private String kyksyaszknmkj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszknmkj() {
        return kyksyaszknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkj(String pKyksyaszknmkj) {
        kyksyaszknmkj = pKyksyaszknmkj;
    }

    private String kyksyaszkyno;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKYNO)
    @Digit
    @Length(length=7)
    public String getKyksyaszkyno() {
        return kyksyaszkyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksyaszkyno(String pKyksyaszkyno) {
        kyksyaszkyno = pKyksyaszkyno;
    }

    private String kyksyaszkadr1kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr1kj() {
        return kyksyaszkadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr1kj(String pKyksyaszkadr1kj) {
        kyksyaszkadr1kj = pKyksyaszkadr1kj;
    }

    private String kyksyaszkadr2kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr2kj() {
        return kyksyaszkadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr2kj(String pKyksyaszkadr2kj) {
        kyksyaszkadr2kj = pKyksyaszkadr2kj;
    }

    private String kyksyaszkadr3kj;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKSYASZKADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr3kj() {
        return kyksyaszkadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr3kj(String pKyksyaszkadr3kj) {
        kyksyaszkadr3kj = pKyksyaszkadr3kj;
    }

    private C_UmuKbn yenshrtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.YENSHRTKUMU)
    public C_UmuKbn getYenshrtkumu() {
        return yenshrtkumu;
    }

    public void setYenshrtkumu(C_UmuKbn pYenshrtkumu) {
        yenshrtkumu = pYenshrtkumu;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.BANKCD)
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

    @Column(name=GenIW_KhKeiyakuTorikesiWk.SITENCD)
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
    @Column(name=GenIW_KhKeiyakuTorikesiWk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KOUZANO)
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

    private C_Kzdou kzdoukbn;

    @Type(type="UserType_C_Kzdou")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KZMEIGINMKN)
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

    private String kykmnmeigibangou;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.KYKMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    private String uktmnmeigibangou;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.UKTMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    private C_HonninKakninKekkaKbn honninkakninkekkakbn;

    @Type(type="UserType_C_HonninKakninKekkaKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.HONNINKAKNINKEKKAKBN)
    public C_HonninKakninKekkaKbn getHonninkakninkekkakbn() {
        return honninkakninkekkakbn;
    }

    public void setHonninkakninkekkakbn(C_HonninKakninKekkaKbn pHonninkakninkekkakbn) {
        honninkakninkekkakbn = pHonninkakninkekkakbn;
    }

    private C_SyorikekkaKbn zenkaisyorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.ZENKAISYORIKEKKAKBN)
    public C_SyorikekkaKbn getZenkaisyorikekkakbn() {
        return zenkaisyorikekkakbn;
    }

    public void setZenkaisyorikekkakbn(C_SyorikekkaKbn pZenkaisyorikekkakbn) {
        zenkaisyorikekkakbn = pZenkaisyorikekkakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_KhKeiyakuTorikesiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    @Type(type="UserType_C_SoukinsakiKbn")
    @Column(name=GenIW_KhKeiyakuTorikesiWk.SOUKINSAKIKBN)
    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
    }
}