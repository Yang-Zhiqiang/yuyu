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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.id.PKHT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.meta.GenQHT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.meta.QHT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 申込未確定情報管理テーブル テーブルのマッピング情報クラスで、 {@link HT_MosMikakuteiJyouhouKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosMikakuteiJyouhouKanri}</td><td colspan="3">申込未確定情報管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MosMikakuteiJyouhouKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getMosuketukekbn mosuketukekbn}</td><td>申込受付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosUketukeKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimuyoucd jimuyoucd}</td><td>事務用コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDoujimosumu doujimosumu}</td><td>同時申込有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getSakujoyoteiymd sakujoyoteiymd}</td><td>削除予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSetmosno1 setmosno1}</td><td>セット申込番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosMikakuteiJyouhouKanri
 * @see     PKHT_MosMikakuteiJyouhouKanri
 * @see     QHT_MosMikakuteiJyouhouKanri
 * @see     GenQHT_MosMikakuteiJyouhouKanri
 */
@MappedSuperclass
@Table(name=GenHT_MosMikakuteiJyouhouKanri.TABLE_NAME)
@IdClass(value=PKHT_MosMikakuteiJyouhouKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_MosUketukeKbn", typeClass=UserType_C_MosUketukeKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenHT_MosMikakuteiJyouhouKanri extends AbstractExDBEntity<HT_MosMikakuteiJyouhouKanri, PKHT_MosMikakuteiJyouhouKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosMikakuteiJyouhouKanri";
    public static final String MOSNO                    = "mosno";
    public static final String JIMUTETUZUKICD           = "jimutetuzukicd";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String MOSUKETUKEKBN            = "mosuketukekbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String JIMUYOUCD                = "jimuyoucd";
    public static final String DOUJIMOSUMU              = "doujimosumu";
    public static final String SYONO                    = "syono";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String SAKUJOYOTEIYMD           = "sakujoyoteiymd";
    public static final String SETMOSNO1                = "setmosno1";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosMikakuteiJyouhouKanri primaryKey;

    public GenHT_MosMikakuteiJyouhouKanri() {
        primaryKey = new PKHT_MosMikakuteiJyouhouKanri();
    }

    public GenHT_MosMikakuteiJyouhouKanri(String pMosno) {
        primaryKey = new PKHT_MosMikakuteiJyouhouKanri(pMosno);
    }

    @Transient
    @Override
    public PKHT_MosMikakuteiJyouhouKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosMikakuteiJyouhouKanri> getMetaClass() {
        return QHT_MosMikakuteiJyouhouKanri.class;
    }

    @Id
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String jimutetuzukicd;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.JIMUTETUZUKICD)
    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }

    private C_SkeijimuKbn skeijimukbn;

    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_MosUketukeKbn mosuketukekbn;

    @Type(type="UserType_C_MosUketukeKbn")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.MOSUKETUKEKBN)
    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private C_HknsyuruiNo hknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private String dairitencd1;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String dairitencd2;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String jimuyoucd;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.JIMUYOUCD)
    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private C_UmuKbn doujimosumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.DOUJIMOSUMU)
    public C_UmuKbn getDoujimosumu() {
        return doujimosumu;
    }

    public void setDoujimosumu(C_UmuKbn pDoujimosumu) {
        doujimosumu = pDoujimosumu;
    }

    private String syono;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private BizDate sakujoyoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosMikakuteiJyouhouKanri.SAKUJOYOTEIYMD)
    public BizDate getSakujoyoteiymd() {
        return sakujoyoteiymd;
    }

    public void setSakujoyoteiymd(BizDate pSakujoyoteiymd) {
        sakujoyoteiymd = pSakujoyoteiymd;
    }

    private String setmosno1;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.SETMOSNO1)
    @MousikomiNo
    public String getSetmosno1() {
        return setmosno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetmosno1(String pSetmosno1) {
        setmosno1 = pSetmosno1;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosMikakuteiJyouhouKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}