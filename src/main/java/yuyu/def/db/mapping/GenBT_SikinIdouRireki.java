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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.id.PKBT_SikinIdouRireki;
import yuyu.def.db.meta.GenQBT_SikinIdouRireki;
import yuyu.def.db.meta.QBT_SikinIdouRireki;
import yuyu.def.db.type.UserType_C_Delflag;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Nykkeiro;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_NykshrKbn;
import yuyu.def.db.type.UserType_C_Nyktrksflg;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrsyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 資金移動用履歴テーブル テーブルのマッピング情報クラスで、 {@link BT_SikinIdouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SikinIdouRireki}</td><td colspan="3">資金移動用履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_SikinIdouRireki ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeirisyorirenno keirisyorirenno}</td><td>経理用処理連番</td><td align="center">{@link PKBT_SikinIdouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTargetKinouId targetKinouId}</td><td>対象機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSakujyoflg sakujyoflg}</td><td>削除フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Delflag}</td></tr>
 *  <tr><td>{@link #getNykshrkbn nykshrkbn}</td><td>入金支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NykshrKbn}</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno kyksyouhnrenno}</td><td>契約商品連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getPhendoukaisiym phendoukaisiym}</td><td>Ｐ変動開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getPhendoumaegk phendoumaegk}</td><td>Ｐ変動前金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPhendougogk phendougogk}</td><td>Ｐ変動後金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeirituymd seirituymd}</td><td>成立日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutouym misyuupjyuutouym}</td><td>未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getShrsyorikbn shrsyorikbn}</td><td>支払処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrsyoriKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuu syoumetujiyuu}</td><td>消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syoumetujiyuu}</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutoustartym jyutoustartym}</td><td>充当開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getJyutouendym jyutouendym}</td><td>充当終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getNykkeiro nykkeiro}</td><td>入金経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nykkeiro}</td></tr>
 *  <tr><td>{@link #getNyknaiyoukbn nyknaiyoukbn}</td><td>入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NyknaiyouKbn}</td></tr>
 *  <tr><td>{@link #getNyktrksflg nyktrksflg}</td><td>入金取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nyktrksflg}</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BT_SikinIdouRireki
 * @see     PKBT_SikinIdouRireki
 * @see     QBT_SikinIdouRireki
 * @see     GenQBT_SikinIdouRireki
 */
@MappedSuperclass
@Table(name=GenBT_SikinIdouRireki.TABLE_NAME)
@IdClass(value=PKBT_SikinIdouRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Delflag", typeClass=UserType_C_Delflag.class),
    @TypeDef(name="UserType_C_DensysKbn", typeClass=UserType_C_DensysKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Nykkeiro", typeClass=UserType_C_Nykkeiro.class),
    @TypeDef(name="UserType_C_NyknaiyouKbn", typeClass=UserType_C_NyknaiyouKbn.class),
    @TypeDef(name="UserType_C_NykshrKbn", typeClass=UserType_C_NykshrKbn.class),
    @TypeDef(name="UserType_C_Nyktrksflg", typeClass=UserType_C_Nyktrksflg.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_ShrsyoriKbn", typeClass=UserType_C_ShrsyoriKbn.class),
    @TypeDef(name="UserType_C_Syoumetujiyuu", typeClass=UserType_C_Syoumetujiyuu.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenBT_SikinIdouRireki extends AbstractExDBEntity<BT_SikinIdouRireki, PKBT_SikinIdouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SikinIdouRireki";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String KEIRISYORIRENNO          = "keirisyorirenno";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String TARGETKINOUID            = "targetKinouId";
    public static final String SKNO                     = "skno";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SAKUJYOFLG               = "sakujyoflg";
    public static final String NYKSHRKBN                = "nykshrkbn";
    public static final String SYORICD                  = "syoricd";
    public static final String DENSYSKBN                = "densyskbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String SEG1CD                   = "seg1cd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKSYOUHNRENNO           = "kyksyouhnrenno";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String PHENDOUKAISIYM           = "phendoukaisiym";
    public static final String PHENDOUMAEGK             = "phendoumaegk";
    public static final String PHENDOUGOGK              = "phendougogk";
    public static final String KYKYMD                   = "kykymd";
    public static final String SEIRITUYMD               = "seirituymd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String MISYUUPJYUUTOUYM         = "misyuupjyuutouym";
    public static final String SHRSYORIKBN              = "shrsyorikbn";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String SYOUMETUJIYUU            = "syoumetujiyuu";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String JYUTOUSTARTYM            = "jyutoustartym";
    public static final String JYUTOUENDYM              = "jyutouendym";
    public static final String NYKKEIRO                 = "nykkeiro";
    public static final String NYKNAIYOUKBN             = "nyknaiyoukbn";
    public static final String NYKTRKSFLG               = "nyktrksflg";
    public static final String HRKP                     = "hrkp";
    public static final String HOKENRYOU                = "hokenryou";

    private final PKBT_SikinIdouRireki primaryKey;

    public GenBT_SikinIdouRireki() {
        primaryKey = new PKBT_SikinIdouRireki();
    }

    public GenBT_SikinIdouRireki(BizDate pSyoriYmd, String pKeirisyorirenno) {
        primaryKey = new PKBT_SikinIdouRireki(pSyoriYmd, pKeirisyorirenno);
    }

    @Transient
    @Override
    public PKBT_SikinIdouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SikinIdouRireki> getMetaClass() {
        return QBT_SikinIdouRireki.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouRireki.SYORIYMD)
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
    @Column(name=GenBT_SikinIdouRireki.KEIRISYORIRENNO)
    public String getKeirisyorirenno() {
        return getPrimaryKey().getKeirisyorirenno();
    }

    public void setKeirisyorirenno(String pKeirisyorirenno) {
        getPrimaryKey().setKeirisyorirenno(pKeirisyorirenno);
    }

    private String syono;

    @Column(name=GenBT_SikinIdouRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String henkousikibetukey;

    @Column(name=GenBT_SikinIdouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String targetKinouId;

    @Column(name=GenBT_SikinIdouRireki.TARGETKINOUID)
    public String getTargetKinouId() {
        return targetKinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargetKinouId(String pTargetKinouId) {
        targetKinouId = pTargetKinouId;
    }

    private String skno;

    @Column(name=GenBT_SikinIdouRireki.SKNO)
    public String getSkno() {
        return skno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    private Integer seikyuurirekino;

    @Column(name=GenBT_SikinIdouRireki.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    private C_Delflag sakujyoflg;

    @Type(type="UserType_C_Delflag")
    @Column(name=GenBT_SikinIdouRireki.SAKUJYOFLG)
    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }

    private C_NykshrKbn nykshrkbn;

    @Type(type="UserType_C_NykshrKbn")
    @Column(name=GenBT_SikinIdouRireki.NYKSHRKBN)
    public C_NykshrKbn getNykshrkbn() {
        return nykshrkbn;
    }

    public void setNykshrkbn(C_NykshrKbn pNykshrkbn) {
        nykshrkbn = pNykshrkbn;
    }

    private String syoricd;

    @Column(name=GenBT_SikinIdouRireki.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }

    private C_DensysKbn densyskbn;

    @Type(type="UserType_C_DensysKbn")
    @Column(name=GenBT_SikinIdouRireki.DENSYSKBN)
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
    }

    private String denrenno;

    @Column(name=GenBT_SikinIdouRireki.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBT_SikinIdouRireki.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_SikinIdouRireki.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenBT_SikinIdouRireki.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenBT_SikinIdouRireki.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String syouhncd;

    @Column(name=GenBT_SikinIdouRireki.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private Integer syouhnsdno;

    @Column(name=GenBT_SikinIdouRireki.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private Integer kyksyouhnrenno;

    @Column(name=GenBT_SikinIdouRireki.KYKSYOUHNRENNO)
    public Integer getKyksyouhnrenno() {
        return kyksyouhnrenno;
    }

    public void setKyksyouhnrenno(Integer pKyksyouhnrenno) {
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenBT_SikinIdouRireki.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private BizDateYM phendoukaisiym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_SikinIdouRireki.PHENDOUKAISIYM)
    public BizDateYM getPhendoukaisiym() {
        return phendoukaisiym;
    }

    public void setPhendoukaisiym(BizDateYM pPhendoukaisiym) {
        phendoukaisiym = pPhendoukaisiym;
    }

    private BizCurrency phendoumaegk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPhendoumaegk() {
        return phendoumaegk;
    }

    public void setPhendoumaegk(BizCurrency pPhendoumaegk) {
        phendoumaegk = pPhendoumaegk;
        phendoumaegkValue = null;
        phendoumaegkType  = null;
    }

    transient private BigDecimal phendoumaegkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PHENDOUMAEGK, nullable=true)
    protected BigDecimal getPhendoumaegkValue() {
        if (phendoumaegkValue == null && phendoumaegk != null) {
            if (phendoumaegk.isOptional()) return null;
            return phendoumaegk.absolute();
        }
        return phendoumaegkValue;
    }

    protected void setPhendoumaegkValue(BigDecimal value) {
        phendoumaegkValue = value;
        phendoumaegk = Optional.fromNullable(toCurrencyType(phendoumaegkType))
            .transform(bizCurrencyTransformer(getPhendoumaegkValue()))
            .orNull();
    }

    transient private String phendoumaegkType = null;

    @Column(name=PHENDOUMAEGK + "$", nullable=true)
    protected String getPhendoumaegkType() {
        if (phendoumaegkType == null && phendoumaegk != null) return phendoumaegk.getType().toString();
        if (phendoumaegkType == null && getPhendoumaegkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'phendoumaegk$' should not be NULL."));
        }
        return phendoumaegkType;
    }

    protected void setPhendoumaegkType(String type) {
        phendoumaegkType = type;
        phendoumaegk = Optional.fromNullable(toCurrencyType(phendoumaegkType))
            .transform(bizCurrencyTransformer(getPhendoumaegkValue()))
            .orNull();
    }

    private BizCurrency phendougogk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPhendougogk() {
        return phendougogk;
    }

    public void setPhendougogk(BizCurrency pPhendougogk) {
        phendougogk = pPhendougogk;
        phendougogkValue = null;
        phendougogkType  = null;
    }

    transient private BigDecimal phendougogkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PHENDOUGOGK, nullable=true)
    protected BigDecimal getPhendougogkValue() {
        if (phendougogkValue == null && phendougogk != null) {
            if (phendougogk.isOptional()) return null;
            return phendougogk.absolute();
        }
        return phendougogkValue;
    }

    protected void setPhendougogkValue(BigDecimal value) {
        phendougogkValue = value;
        phendougogk = Optional.fromNullable(toCurrencyType(phendougogkType))
            .transform(bizCurrencyTransformer(getPhendougogkValue()))
            .orNull();
    }

    transient private String phendougogkType = null;

    @Column(name=PHENDOUGOGK + "$", nullable=true)
    protected String getPhendougogkType() {
        if (phendougogkType == null && phendougogk != null) return phendougogk.getType().toString();
        if (phendougogkType == null && getPhendougogkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'phendougogk$' should not be NULL."));
        }
        return phendougogkType;
    }

    protected void setPhendougogkType(String type) {
        phendougogkType = type;
        phendougogk = Optional.fromNullable(toCurrencyType(phendougogkType))
            .transform(bizCurrencyTransformer(getPhendougogkValue()))
            .orNull();
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouRireki.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate seirituymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouRireki.SEIRITUYMD)
    public BizDate getSeirituymd() {
        return seirituymd;
    }

    @Trim("both")
    public void setSeirituymd(BizDate pSeirituymd) {
        seirituymd = pSeirituymd;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_SikinIdouRireki.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDateYM misyuupjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_SikinIdouRireki.MISYUUPJYUUTOUYM)
    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    private C_ShrsyoriKbn shrsyorikbn;

    @Type(type="UserType_C_ShrsyoriKbn")
    @Column(name=GenBT_SikinIdouRireki.SHRSYORIKBN)
    public C_ShrsyoriKbn getShrsyorikbn() {
        return shrsyorikbn;
    }

    public void setShrsyorikbn(C_ShrsyoriKbn pShrsyorikbn) {
        shrsyorikbn = pShrsyorikbn;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenBT_SikinIdouRireki.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_Syoumetujiyuu syoumetujiyuu;

    @Type(type="UserType_C_Syoumetujiyuu")
    @Column(name=GenBT_SikinIdouRireki.SYOUMETUJIYUU)
    public C_Syoumetujiyuu getSyoumetujiyuu() {
        return syoumetujiyuu;
    }

    public void setSyoumetujiyuu(C_Syoumetujiyuu pSyoumetujiyuu) {
        syoumetujiyuu = pSyoumetujiyuu;
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_SikinIdouRireki.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private BizDateYM jyutoustartym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_SikinIdouRireki.JYUTOUSTARTYM)
    public BizDateYM getJyutoustartym() {
        return jyutoustartym;
    }

    public void setJyutoustartym(BizDateYM pJyutoustartym) {
        jyutoustartym = pJyutoustartym;
    }

    private BizDateYM jyutouendym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_SikinIdouRireki.JYUTOUENDYM)
    public BizDateYM getJyutouendym() {
        return jyutouendym;
    }

    public void setJyutouendym(BizDateYM pJyutouendym) {
        jyutouendym = pJyutouendym;
    }

    private C_Nykkeiro nykkeiro;

    @Type(type="UserType_C_Nykkeiro")
    @Column(name=GenBT_SikinIdouRireki.NYKKEIRO)
    public C_Nykkeiro getNykkeiro() {
        return nykkeiro;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    private C_NyknaiyouKbn nyknaiyoukbn;

    @Type(type="UserType_C_NyknaiyouKbn")
    @Column(name=GenBT_SikinIdouRireki.NYKNAIYOUKBN)
    public C_NyknaiyouKbn getNyknaiyoukbn() {
        return nyknaiyoukbn;
    }

    public void setNyknaiyoukbn(C_NyknaiyouKbn pNyknaiyoukbn) {
        nyknaiyoukbn = pNyknaiyoukbn;
    }

    private C_Nyktrksflg nyktrksflg;

    @Type(type="UserType_C_Nyktrksflg")
    @Column(name=GenBT_SikinIdouRireki.NYKTRKSFLG)
    public C_Nyktrksflg getNyktrksflg() {
        return nyktrksflg;
    }

    public void setNyktrksflg(C_Nyktrksflg pNyktrksflg) {
        nyktrksflg = pNyktrksflg;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }
}