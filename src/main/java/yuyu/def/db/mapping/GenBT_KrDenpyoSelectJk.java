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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_KrDenpyoSelectJk;
import yuyu.def.db.id.PKBT_KrDenpyoSelectJk;
import yuyu.def.db.meta.GenQBT_KrDenpyoSelectJk;
import yuyu.def.db.meta.QBT_KrDenpyoSelectJk;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 経理伝票データ抽出条件テーブル テーブルのマッピング情報クラスで、 {@link BT_KrDenpyoSelectJk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KrDenpyoSelectJk}</td><td colspan="3">経理伝票データ抽出条件テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_KrDenpyoSelectJk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriymdrenno syoriymdrenno}</td><td>処理日連番</td><td align="center">{@link PKBT_KrDenpyoSelectJk ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTaisyoukknfrom taisyoukknfrom}</td><td>対象期間（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTaisyoukknto taisyoukknto}</td><td>対象期間（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd1 kanjyoukmkcd1}</td><td>勘定科目コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd2 kanjyoukmkcd2}</td><td>勘定科目コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd3 kanjyoukmkcd3}</td><td>勘定科目コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd4 kanjyoukmkcd4}</td><td>勘定科目コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd5 kanjyoukmkcd5}</td><td>勘定科目コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd6 kanjyoukmkcd6}</td><td>勘定科目コード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd7 kanjyoukmkcd7}</td><td>勘定科目コード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd8 kanjyoukmkcd8}</td><td>勘定科目コード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd9 kanjyoukmkcd9}</td><td>勘定科目コード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd10 kanjyoukmkcd10}</td><td>勘定科目コード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd11 kanjyoukmkcd11}</td><td>勘定科目コード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd12 kanjyoukmkcd12}</td><td>勘定科目コード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd13 kanjyoukmkcd13}</td><td>勘定科目コード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd14 kanjyoukmkcd14}</td><td>勘定科目コード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd15 kanjyoukmkcd15}</td><td>勘定科目コード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd16 kanjyoukmkcd16}</td><td>勘定科目コード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd17 kanjyoukmkcd17}</td><td>勘定科目コード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd18 kanjyoukmkcd18}</td><td>勘定科目コード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd19 kanjyoukmkcd19}</td><td>勘定科目コード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd20 kanjyoukmkcd20}</td><td>勘定科目コード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd21 kanjyoukmkcd21}</td><td>勘定科目コード２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd22 kanjyoukmkcd22}</td><td>勘定科目コード２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd23 kanjyoukmkcd23}</td><td>勘定科目コード２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd24 kanjyoukmkcd24}</td><td>勘定科目コード２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd25 kanjyoukmkcd25}</td><td>勘定科目コード２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd26 kanjyoukmkcd26}</td><td>勘定科目コード２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd27 kanjyoukmkcd27}</td><td>勘定科目コード２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd28 kanjyoukmkcd28}</td><td>勘定科目コード２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd29 kanjyoukmkcd29}</td><td>勘定科目コード２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd30 kanjyoukmkcd30}</td><td>勘定科目コード３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd31 kanjyoukmkcd31}</td><td>勘定科目コード３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd32 kanjyoukmkcd32}</td><td>勘定科目コード３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd33 kanjyoukmkcd33}</td><td>勘定科目コード３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd34 kanjyoukmkcd34}</td><td>勘定科目コード３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd35 kanjyoukmkcd35}</td><td>勘定科目コード３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd36 kanjyoukmkcd36}</td><td>勘定科目コード３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd37 kanjyoukmkcd37}</td><td>勘定科目コード３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd38 kanjyoukmkcd38}</td><td>勘定科目コード３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd39 kanjyoukmkcd39}</td><td>勘定科目コード３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd40 kanjyoukmkcd40}</td><td>勘定科目コード４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd41 kanjyoukmkcd41}</td><td>勘定科目コード４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd42 kanjyoukmkcd42}</td><td>勘定科目コード４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd43 kanjyoukmkcd43}</td><td>勘定科目コード４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd44 kanjyoukmkcd44}</td><td>勘定科目コード４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd45 kanjyoukmkcd45}</td><td>勘定科目コード４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd46 kanjyoukmkcd46}</td><td>勘定科目コード４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd47 kanjyoukmkcd47}</td><td>勘定科目コード４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd48 kanjyoukmkcd48}</td><td>勘定科目コード４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd49 kanjyoukmkcd49}</td><td>勘定科目コード４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd50 kanjyoukmkcd50}</td><td>勘定科目コード５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 * </table>
 * @see     BT_KrDenpyoSelectJk
 * @see     PKBT_KrDenpyoSelectJk
 * @see     QBT_KrDenpyoSelectJk
 * @see     GenQBT_KrDenpyoSelectJk
 */
@MappedSuperclass
@Table(name=GenBT_KrDenpyoSelectJk.TABLE_NAME)
@IdClass(value=PKBT_KrDenpyoSelectJk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class)
})
public abstract class GenBT_KrDenpyoSelectJk extends AbstractExDBEntity<BT_KrDenpyoSelectJk, PKBT_KrDenpyoSelectJk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KrDenpyoSelectJk";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORIYMDRENNO            = "syoriymdrenno";
    public static final String TAISYOUKKNFROM           = "taisyoukknfrom";
    public static final String TAISYOUKKNTO             = "taisyoukknto";
    public static final String KANJYOUKMKCD1            = "kanjyoukmkcd1";
    public static final String KANJYOUKMKCD2            = "kanjyoukmkcd2";
    public static final String KANJYOUKMKCD3            = "kanjyoukmkcd3";
    public static final String KANJYOUKMKCD4            = "kanjyoukmkcd4";
    public static final String KANJYOUKMKCD5            = "kanjyoukmkcd5";
    public static final String KANJYOUKMKCD6            = "kanjyoukmkcd6";
    public static final String KANJYOUKMKCD7            = "kanjyoukmkcd7";
    public static final String KANJYOUKMKCD8            = "kanjyoukmkcd8";
    public static final String KANJYOUKMKCD9            = "kanjyoukmkcd9";
    public static final String KANJYOUKMKCD10           = "kanjyoukmkcd10";
    public static final String KANJYOUKMKCD11           = "kanjyoukmkcd11";
    public static final String KANJYOUKMKCD12           = "kanjyoukmkcd12";
    public static final String KANJYOUKMKCD13           = "kanjyoukmkcd13";
    public static final String KANJYOUKMKCD14           = "kanjyoukmkcd14";
    public static final String KANJYOUKMKCD15           = "kanjyoukmkcd15";
    public static final String KANJYOUKMKCD16           = "kanjyoukmkcd16";
    public static final String KANJYOUKMKCD17           = "kanjyoukmkcd17";
    public static final String KANJYOUKMKCD18           = "kanjyoukmkcd18";
    public static final String KANJYOUKMKCD19           = "kanjyoukmkcd19";
    public static final String KANJYOUKMKCD20           = "kanjyoukmkcd20";
    public static final String KANJYOUKMKCD21           = "kanjyoukmkcd21";
    public static final String KANJYOUKMKCD22           = "kanjyoukmkcd22";
    public static final String KANJYOUKMKCD23           = "kanjyoukmkcd23";
    public static final String KANJYOUKMKCD24           = "kanjyoukmkcd24";
    public static final String KANJYOUKMKCD25           = "kanjyoukmkcd25";
    public static final String KANJYOUKMKCD26           = "kanjyoukmkcd26";
    public static final String KANJYOUKMKCD27           = "kanjyoukmkcd27";
    public static final String KANJYOUKMKCD28           = "kanjyoukmkcd28";
    public static final String KANJYOUKMKCD29           = "kanjyoukmkcd29";
    public static final String KANJYOUKMKCD30           = "kanjyoukmkcd30";
    public static final String KANJYOUKMKCD31           = "kanjyoukmkcd31";
    public static final String KANJYOUKMKCD32           = "kanjyoukmkcd32";
    public static final String KANJYOUKMKCD33           = "kanjyoukmkcd33";
    public static final String KANJYOUKMKCD34           = "kanjyoukmkcd34";
    public static final String KANJYOUKMKCD35           = "kanjyoukmkcd35";
    public static final String KANJYOUKMKCD36           = "kanjyoukmkcd36";
    public static final String KANJYOUKMKCD37           = "kanjyoukmkcd37";
    public static final String KANJYOUKMKCD38           = "kanjyoukmkcd38";
    public static final String KANJYOUKMKCD39           = "kanjyoukmkcd39";
    public static final String KANJYOUKMKCD40           = "kanjyoukmkcd40";
    public static final String KANJYOUKMKCD41           = "kanjyoukmkcd41";
    public static final String KANJYOUKMKCD42           = "kanjyoukmkcd42";
    public static final String KANJYOUKMKCD43           = "kanjyoukmkcd43";
    public static final String KANJYOUKMKCD44           = "kanjyoukmkcd44";
    public static final String KANJYOUKMKCD45           = "kanjyoukmkcd45";
    public static final String KANJYOUKMKCD46           = "kanjyoukmkcd46";
    public static final String KANJYOUKMKCD47           = "kanjyoukmkcd47";
    public static final String KANJYOUKMKCD48           = "kanjyoukmkcd48";
    public static final String KANJYOUKMKCD49           = "kanjyoukmkcd49";
    public static final String KANJYOUKMKCD50           = "kanjyoukmkcd50";

    private final PKBT_KrDenpyoSelectJk primaryKey;

    public GenBT_KrDenpyoSelectJk() {
        primaryKey = new PKBT_KrDenpyoSelectJk();
    }

    public GenBT_KrDenpyoSelectJk(BizDate pSyoriYmd, BizNumber pSyoriymdrenno) {
        primaryKey = new PKBT_KrDenpyoSelectJk(pSyoriYmd, pSyoriymdrenno);
    }

    @Transient
    @Override
    public PKBT_KrDenpyoSelectJk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KrDenpyoSelectJk> getMetaClass() {
        return QBT_KrDenpyoSelectJk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_KrDenpyoSelectJk.SYORIYMD)
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
    @Type(type="BizNumberType")
    @Column(name=GenBT_KrDenpyoSelectJk.SYORIYMDRENNO)
    public BizNumber getSyoriymdrenno() {
        return getPrimaryKey().getSyoriymdrenno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriymdrenno(BizNumber pSyoriymdrenno) {
        getPrimaryKey().setSyoriymdrenno(pSyoriymdrenno);
    }

    private BizDate taisyoukknfrom;

    @Type(type="BizDateType")
    @Column(name=GenBT_KrDenpyoSelectJk.TAISYOUKKNFROM)
    @ValidDate
    public BizDate getTaisyoukknfrom() {
        return taisyoukknfrom;
    }

    public void setTaisyoukknfrom(BizDate pTaisyoukknfrom) {
        taisyoukknfrom = pTaisyoukknfrom;
    }

    private BizDate taisyoukknto;

    @Type(type="BizDateType")
    @Column(name=GenBT_KrDenpyoSelectJk.TAISYOUKKNTO)
    @ValidDate
    public BizDate getTaisyoukknto() {
        return taisyoukknto;
    }

    public void setTaisyoukknto(BizDate pTaisyoukknto) {
        taisyoukknto = pTaisyoukknto;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd1;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD1)
    public C_Kanjyoukmkcd getKanjyoukmkcd1() {
        return kanjyoukmkcd1;
    }

    public void setKanjyoukmkcd1(C_Kanjyoukmkcd pKanjyoukmkcd1) {
        kanjyoukmkcd1 = pKanjyoukmkcd1;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd2;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD2)
    public C_Kanjyoukmkcd getKanjyoukmkcd2() {
        return kanjyoukmkcd2;
    }

    public void setKanjyoukmkcd2(C_Kanjyoukmkcd pKanjyoukmkcd2) {
        kanjyoukmkcd2 = pKanjyoukmkcd2;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd3;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD3)
    public C_Kanjyoukmkcd getKanjyoukmkcd3() {
        return kanjyoukmkcd3;
    }

    public void setKanjyoukmkcd3(C_Kanjyoukmkcd pKanjyoukmkcd3) {
        kanjyoukmkcd3 = pKanjyoukmkcd3;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd4;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD4)
    public C_Kanjyoukmkcd getKanjyoukmkcd4() {
        return kanjyoukmkcd4;
    }

    public void setKanjyoukmkcd4(C_Kanjyoukmkcd pKanjyoukmkcd4) {
        kanjyoukmkcd4 = pKanjyoukmkcd4;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd5;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD5)
    public C_Kanjyoukmkcd getKanjyoukmkcd5() {
        return kanjyoukmkcd5;
    }

    public void setKanjyoukmkcd5(C_Kanjyoukmkcd pKanjyoukmkcd5) {
        kanjyoukmkcd5 = pKanjyoukmkcd5;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd6;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD6)
    public C_Kanjyoukmkcd getKanjyoukmkcd6() {
        return kanjyoukmkcd6;
    }

    public void setKanjyoukmkcd6(C_Kanjyoukmkcd pKanjyoukmkcd6) {
        kanjyoukmkcd6 = pKanjyoukmkcd6;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd7;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD7)
    public C_Kanjyoukmkcd getKanjyoukmkcd7() {
        return kanjyoukmkcd7;
    }

    public void setKanjyoukmkcd7(C_Kanjyoukmkcd pKanjyoukmkcd7) {
        kanjyoukmkcd7 = pKanjyoukmkcd7;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd8;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD8)
    public C_Kanjyoukmkcd getKanjyoukmkcd8() {
        return kanjyoukmkcd8;
    }

    public void setKanjyoukmkcd8(C_Kanjyoukmkcd pKanjyoukmkcd8) {
        kanjyoukmkcd8 = pKanjyoukmkcd8;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd9;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD9)
    public C_Kanjyoukmkcd getKanjyoukmkcd9() {
        return kanjyoukmkcd9;
    }

    public void setKanjyoukmkcd9(C_Kanjyoukmkcd pKanjyoukmkcd9) {
        kanjyoukmkcd9 = pKanjyoukmkcd9;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd10;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD10)
    public C_Kanjyoukmkcd getKanjyoukmkcd10() {
        return kanjyoukmkcd10;
    }

    public void setKanjyoukmkcd10(C_Kanjyoukmkcd pKanjyoukmkcd10) {
        kanjyoukmkcd10 = pKanjyoukmkcd10;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd11;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD11)
    public C_Kanjyoukmkcd getKanjyoukmkcd11() {
        return kanjyoukmkcd11;
    }

    public void setKanjyoukmkcd11(C_Kanjyoukmkcd pKanjyoukmkcd11) {
        kanjyoukmkcd11 = pKanjyoukmkcd11;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd12;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD12)
    public C_Kanjyoukmkcd getKanjyoukmkcd12() {
        return kanjyoukmkcd12;
    }

    public void setKanjyoukmkcd12(C_Kanjyoukmkcd pKanjyoukmkcd12) {
        kanjyoukmkcd12 = pKanjyoukmkcd12;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd13;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD13)
    public C_Kanjyoukmkcd getKanjyoukmkcd13() {
        return kanjyoukmkcd13;
    }

    public void setKanjyoukmkcd13(C_Kanjyoukmkcd pKanjyoukmkcd13) {
        kanjyoukmkcd13 = pKanjyoukmkcd13;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd14;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD14)
    public C_Kanjyoukmkcd getKanjyoukmkcd14() {
        return kanjyoukmkcd14;
    }

    public void setKanjyoukmkcd14(C_Kanjyoukmkcd pKanjyoukmkcd14) {
        kanjyoukmkcd14 = pKanjyoukmkcd14;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd15;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD15)
    public C_Kanjyoukmkcd getKanjyoukmkcd15() {
        return kanjyoukmkcd15;
    }

    public void setKanjyoukmkcd15(C_Kanjyoukmkcd pKanjyoukmkcd15) {
        kanjyoukmkcd15 = pKanjyoukmkcd15;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd16;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD16)
    public C_Kanjyoukmkcd getKanjyoukmkcd16() {
        return kanjyoukmkcd16;
    }

    public void setKanjyoukmkcd16(C_Kanjyoukmkcd pKanjyoukmkcd16) {
        kanjyoukmkcd16 = pKanjyoukmkcd16;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd17;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD17)
    public C_Kanjyoukmkcd getKanjyoukmkcd17() {
        return kanjyoukmkcd17;
    }

    public void setKanjyoukmkcd17(C_Kanjyoukmkcd pKanjyoukmkcd17) {
        kanjyoukmkcd17 = pKanjyoukmkcd17;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd18;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD18)
    public C_Kanjyoukmkcd getKanjyoukmkcd18() {
        return kanjyoukmkcd18;
    }

    public void setKanjyoukmkcd18(C_Kanjyoukmkcd pKanjyoukmkcd18) {
        kanjyoukmkcd18 = pKanjyoukmkcd18;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd19;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD19)
    public C_Kanjyoukmkcd getKanjyoukmkcd19() {
        return kanjyoukmkcd19;
    }

    public void setKanjyoukmkcd19(C_Kanjyoukmkcd pKanjyoukmkcd19) {
        kanjyoukmkcd19 = pKanjyoukmkcd19;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd20;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD20)
    public C_Kanjyoukmkcd getKanjyoukmkcd20() {
        return kanjyoukmkcd20;
    }

    public void setKanjyoukmkcd20(C_Kanjyoukmkcd pKanjyoukmkcd20) {
        kanjyoukmkcd20 = pKanjyoukmkcd20;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd21;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD21)
    public C_Kanjyoukmkcd getKanjyoukmkcd21() {
        return kanjyoukmkcd21;
    }

    public void setKanjyoukmkcd21(C_Kanjyoukmkcd pKanjyoukmkcd21) {
        kanjyoukmkcd21 = pKanjyoukmkcd21;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd22;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD22)
    public C_Kanjyoukmkcd getKanjyoukmkcd22() {
        return kanjyoukmkcd22;
    }

    public void setKanjyoukmkcd22(C_Kanjyoukmkcd pKanjyoukmkcd22) {
        kanjyoukmkcd22 = pKanjyoukmkcd22;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd23;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD23)
    public C_Kanjyoukmkcd getKanjyoukmkcd23() {
        return kanjyoukmkcd23;
    }

    public void setKanjyoukmkcd23(C_Kanjyoukmkcd pKanjyoukmkcd23) {
        kanjyoukmkcd23 = pKanjyoukmkcd23;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd24;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD24)
    public C_Kanjyoukmkcd getKanjyoukmkcd24() {
        return kanjyoukmkcd24;
    }

    public void setKanjyoukmkcd24(C_Kanjyoukmkcd pKanjyoukmkcd24) {
        kanjyoukmkcd24 = pKanjyoukmkcd24;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd25;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD25)
    public C_Kanjyoukmkcd getKanjyoukmkcd25() {
        return kanjyoukmkcd25;
    }

    public void setKanjyoukmkcd25(C_Kanjyoukmkcd pKanjyoukmkcd25) {
        kanjyoukmkcd25 = pKanjyoukmkcd25;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd26;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD26)
    public C_Kanjyoukmkcd getKanjyoukmkcd26() {
        return kanjyoukmkcd26;
    }

    public void setKanjyoukmkcd26(C_Kanjyoukmkcd pKanjyoukmkcd26) {
        kanjyoukmkcd26 = pKanjyoukmkcd26;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd27;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD27)
    public C_Kanjyoukmkcd getKanjyoukmkcd27() {
        return kanjyoukmkcd27;
    }

    public void setKanjyoukmkcd27(C_Kanjyoukmkcd pKanjyoukmkcd27) {
        kanjyoukmkcd27 = pKanjyoukmkcd27;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd28;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD28)
    public C_Kanjyoukmkcd getKanjyoukmkcd28() {
        return kanjyoukmkcd28;
    }

    public void setKanjyoukmkcd28(C_Kanjyoukmkcd pKanjyoukmkcd28) {
        kanjyoukmkcd28 = pKanjyoukmkcd28;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd29;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD29)
    public C_Kanjyoukmkcd getKanjyoukmkcd29() {
        return kanjyoukmkcd29;
    }

    public void setKanjyoukmkcd29(C_Kanjyoukmkcd pKanjyoukmkcd29) {
        kanjyoukmkcd29 = pKanjyoukmkcd29;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd30;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD30)
    public C_Kanjyoukmkcd getKanjyoukmkcd30() {
        return kanjyoukmkcd30;
    }

    public void setKanjyoukmkcd30(C_Kanjyoukmkcd pKanjyoukmkcd30) {
        kanjyoukmkcd30 = pKanjyoukmkcd30;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd31;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD31)
    public C_Kanjyoukmkcd getKanjyoukmkcd31() {
        return kanjyoukmkcd31;
    }

    public void setKanjyoukmkcd31(C_Kanjyoukmkcd pKanjyoukmkcd31) {
        kanjyoukmkcd31 = pKanjyoukmkcd31;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd32;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD32)
    public C_Kanjyoukmkcd getKanjyoukmkcd32() {
        return kanjyoukmkcd32;
    }

    public void setKanjyoukmkcd32(C_Kanjyoukmkcd pKanjyoukmkcd32) {
        kanjyoukmkcd32 = pKanjyoukmkcd32;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd33;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD33)
    public C_Kanjyoukmkcd getKanjyoukmkcd33() {
        return kanjyoukmkcd33;
    }

    public void setKanjyoukmkcd33(C_Kanjyoukmkcd pKanjyoukmkcd33) {
        kanjyoukmkcd33 = pKanjyoukmkcd33;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd34;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD34)
    public C_Kanjyoukmkcd getKanjyoukmkcd34() {
        return kanjyoukmkcd34;
    }

    public void setKanjyoukmkcd34(C_Kanjyoukmkcd pKanjyoukmkcd34) {
        kanjyoukmkcd34 = pKanjyoukmkcd34;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd35;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD35)
    public C_Kanjyoukmkcd getKanjyoukmkcd35() {
        return kanjyoukmkcd35;
    }

    public void setKanjyoukmkcd35(C_Kanjyoukmkcd pKanjyoukmkcd35) {
        kanjyoukmkcd35 = pKanjyoukmkcd35;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd36;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD36)
    public C_Kanjyoukmkcd getKanjyoukmkcd36() {
        return kanjyoukmkcd36;
    }

    public void setKanjyoukmkcd36(C_Kanjyoukmkcd pKanjyoukmkcd36) {
        kanjyoukmkcd36 = pKanjyoukmkcd36;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd37;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD37)
    public C_Kanjyoukmkcd getKanjyoukmkcd37() {
        return kanjyoukmkcd37;
    }

    public void setKanjyoukmkcd37(C_Kanjyoukmkcd pKanjyoukmkcd37) {
        kanjyoukmkcd37 = pKanjyoukmkcd37;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd38;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD38)
    public C_Kanjyoukmkcd getKanjyoukmkcd38() {
        return kanjyoukmkcd38;
    }

    public void setKanjyoukmkcd38(C_Kanjyoukmkcd pKanjyoukmkcd38) {
        kanjyoukmkcd38 = pKanjyoukmkcd38;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd39;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD39)
    public C_Kanjyoukmkcd getKanjyoukmkcd39() {
        return kanjyoukmkcd39;
    }

    public void setKanjyoukmkcd39(C_Kanjyoukmkcd pKanjyoukmkcd39) {
        kanjyoukmkcd39 = pKanjyoukmkcd39;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd40;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD40)
    public C_Kanjyoukmkcd getKanjyoukmkcd40() {
        return kanjyoukmkcd40;
    }

    public void setKanjyoukmkcd40(C_Kanjyoukmkcd pKanjyoukmkcd40) {
        kanjyoukmkcd40 = pKanjyoukmkcd40;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd41;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD41)
    public C_Kanjyoukmkcd getKanjyoukmkcd41() {
        return kanjyoukmkcd41;
    }

    public void setKanjyoukmkcd41(C_Kanjyoukmkcd pKanjyoukmkcd41) {
        kanjyoukmkcd41 = pKanjyoukmkcd41;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd42;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD42)
    public C_Kanjyoukmkcd getKanjyoukmkcd42() {
        return kanjyoukmkcd42;
    }

    public void setKanjyoukmkcd42(C_Kanjyoukmkcd pKanjyoukmkcd42) {
        kanjyoukmkcd42 = pKanjyoukmkcd42;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd43;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD43)
    public C_Kanjyoukmkcd getKanjyoukmkcd43() {
        return kanjyoukmkcd43;
    }

    public void setKanjyoukmkcd43(C_Kanjyoukmkcd pKanjyoukmkcd43) {
        kanjyoukmkcd43 = pKanjyoukmkcd43;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd44;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD44)
    public C_Kanjyoukmkcd getKanjyoukmkcd44() {
        return kanjyoukmkcd44;
    }

    public void setKanjyoukmkcd44(C_Kanjyoukmkcd pKanjyoukmkcd44) {
        kanjyoukmkcd44 = pKanjyoukmkcd44;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd45;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD45)
    public C_Kanjyoukmkcd getKanjyoukmkcd45() {
        return kanjyoukmkcd45;
    }

    public void setKanjyoukmkcd45(C_Kanjyoukmkcd pKanjyoukmkcd45) {
        kanjyoukmkcd45 = pKanjyoukmkcd45;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd46;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD46)
    public C_Kanjyoukmkcd getKanjyoukmkcd46() {
        return kanjyoukmkcd46;
    }

    public void setKanjyoukmkcd46(C_Kanjyoukmkcd pKanjyoukmkcd46) {
        kanjyoukmkcd46 = pKanjyoukmkcd46;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd47;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD47)
    public C_Kanjyoukmkcd getKanjyoukmkcd47() {
        return kanjyoukmkcd47;
    }

    public void setKanjyoukmkcd47(C_Kanjyoukmkcd pKanjyoukmkcd47) {
        kanjyoukmkcd47 = pKanjyoukmkcd47;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd48;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD48)
    public C_Kanjyoukmkcd getKanjyoukmkcd48() {
        return kanjyoukmkcd48;
    }

    public void setKanjyoukmkcd48(C_Kanjyoukmkcd pKanjyoukmkcd48) {
        kanjyoukmkcd48 = pKanjyoukmkcd48;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd49;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD49)
    public C_Kanjyoukmkcd getKanjyoukmkcd49() {
        return kanjyoukmkcd49;
    }

    public void setKanjyoukmkcd49(C_Kanjyoukmkcd pKanjyoukmkcd49) {
        kanjyoukmkcd49 = pKanjyoukmkcd49;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd50;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenBT_KrDenpyoSelectJk.KANJYOUKMKCD50)
    public C_Kanjyoukmkcd getKanjyoukmkcd50() {
        return kanjyoukmkcd50;
    }

    public void setKanjyoukmkcd50(C_Kanjyoukmkcd pKanjyoukmkcd50) {
        kanjyoukmkcd50 = pKanjyoukmkcd50;
    }
}