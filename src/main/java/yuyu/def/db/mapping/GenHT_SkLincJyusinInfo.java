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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinInfo;
import yuyu.def.db.id.PKHT_SkLincJyusinInfo;
import yuyu.def.db.meta.GenQHT_SkLincJyusinInfo;
import yuyu.def.db.meta.QHT_SkLincJyusinInfo;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ受信情報テーブル テーブルのマッピング情報クラスで、 {@link HT_SkLincJyusinInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincJyusinInfo}</td><td colspan="3">新契約ＬＩＮＣ受信情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getLincsoujyusinsyskbn lincsoujyusinsyskbn}</td><td>ＬＩＮＣ送受信用システム区分</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">V</td><td>{@link C_LincsoujyusinsysKbn}</td></tr>
 *  <tr><td>{@link #getLinckyknaiykekdatarenno linckyknaiykekdatarenno}</td><td>ＬＩＮＣ契約内容結果データ連番</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno2 renno2}</td><td>連番２</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSousinymd sousinymd}</td><td>送信日</td><td align="center">{@link PKHT_SkLincJyusinInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLincrecordsyubetu lincrecordsyubetu}</td><td>ＬＩＮＣ＿レコード種別</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinchenkoutype linchenkoutype}</td><td>ＬＩＮＣ＿変更タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsyorikekkakekkacd lincsyorikekkakekkacd}</td><td>ＬＩＮＣ＿処理結果_結果コード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincsyorikekkakekkajiyu lincsyorikekkakekkajiyu}</td><td>ＬＩＮＣ＿処理結果_結果事由</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincsyorikekkaerrkouban lincsyorikekkaerrkouban}</td><td>ＬＩＮＣ＿処理結果_エラー項番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincnayoserecordsuu lincnayoserecordsuu}</td><td>ＬＩＮＣ＿名寄せレコード数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckanyuusyano linckanyuusyano}</td><td>ＬＩＮＣ＿加入者番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getLincnayoseyomiknnm lincnayoseyomiknnm}</td><td>ＬＩＮＣ＿名寄せ読みカナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinchhknnmkn linchhknnmkn}</td><td>ＬＩＮＣ＿被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinchhknnmkj linchhknnmkj}</td><td>ＬＩＮＣ＿被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinchhknsei linchhknsei}</td><td>ＬＩＮＣ＿被保険者性別</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinchhknseiymd linchhknseiymd}</td><td>ＬＩＮＣ＿被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinchhknadrkn linchhknadrkn}</td><td>ＬＩＮＣ＿被保険者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckeihidjnhyouji linckeihidjnhyouji}</td><td>ＬＩＮＣ＿契被同人表示</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckyknmkn linckyknmkn}</td><td>ＬＩＮＣ＿契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckyknmkj linckyknmkj}</td><td>ＬＩＮＣ＿契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckyksei linckyksei}</td><td>ＬＩＮＣ＿契約者性別</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykseiymd linckykseiymd}</td><td>ＬＩＮＣ＿契約者生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykadrkn linckykadrkn}</td><td>ＬＩＮＣ＿契約者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckjhngflg linckjhngflg}</td><td>ＬＩＮＣ＿漢字範囲外フラッグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinctrkmousideymd linctrkmousideymd}</td><td>ＬＩＮＣ＿登録申出年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykytymd linckykytymd}</td><td>ＬＩＮＣ＿契約予定年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykymd linckykymd}</td><td>ＬＩＮＣ＿契約年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinchozenytymd linchozenytymd}</td><td>ＬＩＮＣ＿保全予定年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinchozenymd linchozenymd}</td><td>ＬＩＮＣ＿保全年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincsousinmotokaisya lincsousinmotokaisya}</td><td>ＬＩＮＣ＿送信元会社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsgnyukyhng lincsgnyukyhng}</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsipnyukyhng lincsipnyukyhng}</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsjnyukyhng lincsjnyukyhng}</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsonotanyukyhng lincsonotanyukyhng}</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLinchutuusbs linchutuusbs}</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsgsbksns lincsgsbksns}</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLinc15sai1000manflg linc15sai1000manflg}</td><td>ＬＩＮＣ＿１５歳未満１０００万超フラッグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinclincsyoriymd linclincsyoriymd}</td><td>ＬＩＮＣ＿ＬＩＮＣ処理日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykkanrino linckykkanrino}</td><td>ＬＩＮＣ＿契約管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckakusyasiyouran linckakusyasiyouran}</td><td>ＬＩＮＣ＿各社使用欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincmousideflg lincmousideflg}</td><td>ＬＩＮＣ＿申出フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincmousideflgsetymd lincmousideflgsetymd}</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincmousideflgkaijyoymd lincmousideflgkaijyoymd}</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincjgyhknflg lincjgyhknflg}</td><td>ＬＩＮＣ＿事業保険フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinctenkanflg linctenkanflg}</td><td>ＬＩＮＣ＿転換フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincJyusinInfo
 * @see     PKHT_SkLincJyusinInfo
 * @see     QHT_SkLincJyusinInfo
 * @see     GenQHT_SkLincJyusinInfo
 */
@MappedSuperclass
@Table(name=GenHT_SkLincJyusinInfo.TABLE_NAME)
@IdClass(value=PKHT_SkLincJyusinInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_LincsoujyusinsysKbn", typeClass=UserType_C_LincsoujyusinsysKbn.class)
})
public abstract class GenHT_SkLincJyusinInfo extends AbstractExDBEntity<HT_SkLincJyusinInfo, PKHT_SkLincJyusinInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkLincJyusinInfo";
    public static final String LINCSOUJYUSINSYSKBN      = "lincsoujyusinsyskbn";
    public static final String LINCKYKNAIYKEKDATARENNO  = "linckyknaiykekdatarenno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO2                   = "renno2";
    public static final String SOUSINYMD                = "sousinymd";
    public static final String LINCRECORDSYUBETU        = "lincrecordsyubetu";
    public static final String LINCHENKOUTYPE           = "linchenkoutype";
    public static final String LINCSYORIKEKKAKEKKACD    = "lincsyorikekkakekkacd";
    public static final String LINCSYORIKEKKAKEKKAJIYU  = "lincsyorikekkakekkajiyu";
    public static final String LINCSYORIKEKKAERRKOUBAN  = "lincsyorikekkaerrkouban";
    public static final String LINCNAYOSERECORDSUU      = "lincnayoserecordsuu";
    public static final String LINCKANYUUSYANO          = "linckanyuusyano";
    public static final String LINCNAYOSEYOMIKNNM       = "lincnayoseyomiknnm";
    public static final String LINCHHKNNMKN             = "linchhknnmkn";
    public static final String LINCHHKNNMKJ             = "linchhknnmkj";
    public static final String LINCHHKNSEI              = "linchhknsei";
    public static final String LINCHHKNSEIYMD           = "linchhknseiymd";
    public static final String LINCHHKNADRKN            = "linchhknadrkn";
    public static final String LINCKEIHIDJNHYOUJI       = "linckeihidjnhyouji";
    public static final String LINCKYKNMKN              = "linckyknmkn";
    public static final String LINCKYKNMKJ              = "linckyknmkj";
    public static final String LINCKYKSEI               = "linckyksei";
    public static final String LINCKYKSEIYMD            = "linckykseiymd";
    public static final String LINCKYKADRKN             = "linckykadrkn";
    public static final String LINCKJHNGFLG             = "linckjhngflg";
    public static final String LINCTRKMOUSIDEYMD        = "linctrkmousideymd";
    public static final String LINCKYKYTYMD             = "linckykytymd";
    public static final String LINCKYKYMD               = "linckykymd";
    public static final String LINCHOZENYTYMD           = "linchozenytymd";
    public static final String LINCHOZENYMD             = "linchozenymd";
    public static final String LINCSOUSINMOTOKAISYA     = "lincsousinmotokaisya";
    public static final String LINCSGNYUKYHNG           = "lincsgnyukyhng";
    public static final String LINCSIPNYUKYHNG          = "lincsipnyukyhng";
    public static final String LINCSJNYUKYHNG           = "lincsjnyukyhng";
    public static final String LINCSONOTANYUKYHNG       = "lincsonotanyukyhng";
    public static final String LINCHUTUUSBS             = "linchutuusbs";
    public static final String LINCSGSBKSNS             = "lincsgsbksns";
    public static final String LINC15SAI1000MANFLG      = "linc15sai1000manflg";
    public static final String LINCLINCSYORIYMD         = "linclincsyoriymd";
    public static final String LINCKYKKANRINO           = "linckykkanrino";
    public static final String LINCKAKUSYASIYOURAN      = "linckakusyasiyouran";
    public static final String LINCMOUSIDEFLG           = "lincmousideflg";
    public static final String LINCMOUSIDEFLGSETYMD     = "lincmousideflgsetymd";
    public static final String LINCMOUSIDEFLGKAIJYOYMD  = "lincmousideflgkaijyoymd";
    public static final String LINCJGYHKNFLG            = "lincjgyhknflg";
    public static final String LINCTENKANFLG            = "linctenkanflg";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkLincJyusinInfo primaryKey;

    public GenHT_SkLincJyusinInfo() {
        primaryKey = new PKHT_SkLincJyusinInfo();
    }

    public GenHT_SkLincJyusinInfo(
        C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
        String pLinckyknaiykekdatarenno,
        BizDate pSyoriYmd,
        String pMosno,
        BizNumber pRenno2,
        BizDate pSousinymd
    ) {
        primaryKey = new PKHT_SkLincJyusinInfo(
            pLincsoujyusinsyskbn,
            pLinckyknaiykekdatarenno,
            pSyoriYmd,
            pMosno,
            pRenno2,
            pSousinymd
        );
    }

    @Transient
    @Override
    public PKHT_SkLincJyusinInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkLincJyusinInfo> getMetaClass() {
        return QHT_SkLincJyusinInfo.class;
    }

    @Id
    @Type(type="UserType_C_LincsoujyusinsysKbn")
    @Column(name=GenHT_SkLincJyusinInfo.LINCSOUJYUSINSYSKBN)
    public C_LincsoujyusinsysKbn getLincsoujyusinsyskbn() {
        return getPrimaryKey().getLincsoujyusinsyskbn();
    }

    public void setLincsoujyusinsyskbn(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn) {
        getPrimaryKey().setLincsoujyusinsyskbn(pLincsoujyusinsyskbn);
    }

    @Id
    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKNAIYKEKDATARENNO)
    public String getLinckyknaiykekdatarenno() {
        return getPrimaryKey().getLinckyknaiykekdatarenno();
    }

    public void setLinckyknaiykekdatarenno(String pLinckyknaiykekdatarenno) {
        getPrimaryKey().setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinInfo.SYORIYMD)
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
    @Column(name=GenHT_SkLincJyusinInfo.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenHT_SkLincJyusinInfo.RENNO2)
    public BizNumber getRenno2() {
        return getPrimaryKey().getRenno2();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRenno2(BizNumber pRenno2) {
        getPrimaryKey().setRenno2(pRenno2);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinInfo.SOUSINYMD)
    public BizDate getSousinymd() {
        return getPrimaryKey().getSousinymd();
    }

    public void setSousinymd(BizDate pSousinymd) {
        getPrimaryKey().setSousinymd(pSousinymd);
    }

    private Integer lincrecordsyubetu;

    @Column(name=GenHT_SkLincJyusinInfo.LINCRECORDSYUBETU)
    public Integer getLincrecordsyubetu() {
        return lincrecordsyubetu;
    }

    public void setLincrecordsyubetu(Integer pLincrecordsyubetu) {
        lincrecordsyubetu = pLincrecordsyubetu;
    }

    private String linchenkoutype;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHENKOUTYPE)
    public String getLinchenkoutype() {
        return linchenkoutype;
    }

    public void setLinchenkoutype(String pLinchenkoutype) {
        linchenkoutype = pLinchenkoutype;
    }

    private Integer lincsyorikekkakekkacd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCSYORIKEKKAKEKKACD)
    public Integer getLincsyorikekkakekkacd() {
        return lincsyorikekkakekkacd;
    }

    public void setLincsyorikekkakekkacd(Integer pLincsyorikekkakekkacd) {
        lincsyorikekkakekkacd = pLincsyorikekkakekkacd;
    }

    private Integer lincsyorikekkakekkajiyu;

    @Column(name=GenHT_SkLincJyusinInfo.LINCSYORIKEKKAKEKKAJIYU)
    public Integer getLincsyorikekkakekkajiyu() {
        return lincsyorikekkakekkajiyu;
    }

    public void setLincsyorikekkakekkajiyu(Integer pLincsyorikekkakekkajiyu) {
        lincsyorikekkakekkajiyu = pLincsyorikekkakekkajiyu;
    }

    private Integer lincsyorikekkaerrkouban;

    @Column(name=GenHT_SkLincJyusinInfo.LINCSYORIKEKKAERRKOUBAN)
    public Integer getLincsyorikekkaerrkouban() {
        return lincsyorikekkaerrkouban;
    }

    public void setLincsyorikekkaerrkouban(Integer pLincsyorikekkaerrkouban) {
        lincsyorikekkaerrkouban = pLincsyorikekkaerrkouban;
    }

    private Integer lincnayoserecordsuu;

    @Column(name=GenHT_SkLincJyusinInfo.LINCNAYOSERECORDSUU)
    public Integer getLincnayoserecordsuu() {
        return lincnayoserecordsuu;
    }

    public void setLincnayoserecordsuu(Integer pLincnayoserecordsuu) {
        lincnayoserecordsuu = pLincnayoserecordsuu;
    }

    private Long linckanyuusyano;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKANYUUSYANO)
    public Long getLinckanyuusyano() {
        return linckanyuusyano;
    }

    public void setLinckanyuusyano(Long pLinckanyuusyano) {
        linckanyuusyano = pLinckanyuusyano;
    }

    private String lincnayoseyomiknnm;

    @Column(name=GenHT_SkLincJyusinInfo.LINCNAYOSEYOMIKNNM)
    public String getLincnayoseyomiknnm() {
        return lincnayoseyomiknnm;
    }

    public void setLincnayoseyomiknnm(String pLincnayoseyomiknnm) {
        lincnayoseyomiknnm = pLincnayoseyomiknnm;
    }

    private String linchhknnmkn;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHHKNNMKN)
    public String getLinchhknnmkn() {
        return linchhknnmkn;
    }

    public void setLinchhknnmkn(String pLinchhknnmkn) {
        linchhknnmkn = pLinchhknnmkn;
    }

    private String linchhknnmkj;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHHKNNMKJ)
    public String getLinchhknnmkj() {
        return linchhknnmkj;
    }

    public void setLinchhknnmkj(String pLinchhknnmkj) {
        linchhknnmkj = pLinchhknnmkj;
    }

    private Integer linchhknsei;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHHKNSEI)
    public Integer getLinchhknsei() {
        return linchhknsei;
    }

    public void setLinchhknsei(Integer pLinchhknsei) {
        linchhknsei = pLinchhknsei;
    }

    private Integer linchhknseiymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHHKNSEIYMD)
    public Integer getLinchhknseiymd() {
        return linchhknseiymd;
    }

    public void setLinchhknseiymd(Integer pLinchhknseiymd) {
        linchhknseiymd = pLinchhknseiymd;
    }

    private String linchhknadrkn;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHHKNADRKN)
    public String getLinchhknadrkn() {
        return linchhknadrkn;
    }

    public void setLinchhknadrkn(String pLinchhknadrkn) {
        linchhknadrkn = pLinchhknadrkn;
    }

    private Integer linckeihidjnhyouji;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKEIHIDJNHYOUJI)
    public Integer getLinckeihidjnhyouji() {
        return linckeihidjnhyouji;
    }

    public void setLinckeihidjnhyouji(Integer pLinckeihidjnhyouji) {
        linckeihidjnhyouji = pLinckeihidjnhyouji;
    }

    private String linckyknmkn;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKNMKN)
    public String getLinckyknmkn() {
        return linckyknmkn;
    }

    public void setLinckyknmkn(String pLinckyknmkn) {
        linckyknmkn = pLinckyknmkn;
    }

    private String linckyknmkj;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKNMKJ)
    public String getLinckyknmkj() {
        return linckyknmkj;
    }

    public void setLinckyknmkj(String pLinckyknmkj) {
        linckyknmkj = pLinckyknmkj;
    }

    private Integer linckyksei;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKSEI)
    public Integer getLinckyksei() {
        return linckyksei;
    }

    public void setLinckyksei(Integer pLinckyksei) {
        linckyksei = pLinckyksei;
    }

    private Integer linckykseiymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKSEIYMD)
    public Integer getLinckykseiymd() {
        return linckykseiymd;
    }

    public void setLinckykseiymd(Integer pLinckykseiymd) {
        linckykseiymd = pLinckykseiymd;
    }

    private String linckykadrkn;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKADRKN)
    public String getLinckykadrkn() {
        return linckykadrkn;
    }

    public void setLinckykadrkn(String pLinckykadrkn) {
        linckykadrkn = pLinckykadrkn;
    }

    private Integer linckjhngflg;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKJHNGFLG)
    public Integer getLinckjhngflg() {
        return linckjhngflg;
    }

    public void setLinckjhngflg(Integer pLinckjhngflg) {
        linckjhngflg = pLinckjhngflg;
    }

    private Integer linctrkmousideymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCTRKMOUSIDEYMD)
    public Integer getLinctrkmousideymd() {
        return linctrkmousideymd;
    }

    public void setLinctrkmousideymd(Integer pLinctrkmousideymd) {
        linctrkmousideymd = pLinctrkmousideymd;
    }

    private Integer linckykytymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKYTYMD)
    public Integer getLinckykytymd() {
        return linckykytymd;
    }

    public void setLinckykytymd(Integer pLinckykytymd) {
        linckykytymd = pLinckykytymd;
    }

    private Integer linckykymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKYMD)
    public Integer getLinckykymd() {
        return linckykymd;
    }

    public void setLinckykymd(Integer pLinckykymd) {
        linckykymd = pLinckykymd;
    }

    private Integer linchozenytymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHOZENYTYMD)
    public Integer getLinchozenytymd() {
        return linchozenytymd;
    }

    public void setLinchozenytymd(Integer pLinchozenytymd) {
        linchozenytymd = pLinchozenytymd;
    }

    private Integer linchozenymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCHOZENYMD)
    public Integer getLinchozenymd() {
        return linchozenymd;
    }

    public void setLinchozenymd(Integer pLinchozenymd) {
        linchozenymd = pLinchozenymd;
    }

    private String lincsousinmotokaisya;

    @Column(name=GenHT_SkLincJyusinInfo.LINCSOUSINMOTOKAISYA)
    public String getLincsousinmotokaisya() {
        return lincsousinmotokaisya;
    }

    public void setLincsousinmotokaisya(String pLincsousinmotokaisya) {
        lincsousinmotokaisya = pLincsousinmotokaisya;
    }

    private BizCurrency lincsgnyukyhng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLincsgnyukyhng() {
        return lincsgnyukyhng;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLincsgnyukyhng(BizCurrency pLincsgnyukyhng) {
        lincsgnyukyhng = pLincsgnyukyhng;
        lincsgnyukyhngValue = null;
        lincsgnyukyhngType  = null;
    }

    transient private BigDecimal lincsgnyukyhngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCSGNYUKYHNG, nullable=true)
    protected BigDecimal getLincsgnyukyhngValue() {
        if (lincsgnyukyhngValue == null && lincsgnyukyhng != null) {
            if (lincsgnyukyhng.isOptional()) return null;
            return lincsgnyukyhng.absolute();
        }
        return lincsgnyukyhngValue;
    }

    protected void setLincsgnyukyhngValue(BigDecimal value) {
        lincsgnyukyhngValue = value;
        lincsgnyukyhng = Optional.fromNullable(toCurrencyType(lincsgnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsgnyukyhngValue()))
            .orNull();
    }

    transient private String lincsgnyukyhngType = null;

    @Column(name=LINCSGNYUKYHNG + "$", nullable=true)
    protected String getLincsgnyukyhngType() {
        if (lincsgnyukyhngType == null && lincsgnyukyhng != null) return lincsgnyukyhng.getType().toString();
        if (lincsgnyukyhngType == null && getLincsgnyukyhngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lincsgnyukyhng$' should not be NULL."));
        }
        return lincsgnyukyhngType;
    }

    protected void setLincsgnyukyhngType(String type) {
        lincsgnyukyhngType = type;
        lincsgnyukyhng = Optional.fromNullable(toCurrencyType(lincsgnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsgnyukyhngValue()))
            .orNull();
    }

    private BizCurrency lincsipnyukyhng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLincsipnyukyhng() {
        return lincsipnyukyhng;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLincsipnyukyhng(BizCurrency pLincsipnyukyhng) {
        lincsipnyukyhng = pLincsipnyukyhng;
        lincsipnyukyhngValue = null;
        lincsipnyukyhngType  = null;
    }

    transient private BigDecimal lincsipnyukyhngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCSIPNYUKYHNG, nullable=true)
    protected BigDecimal getLincsipnyukyhngValue() {
        if (lincsipnyukyhngValue == null && lincsipnyukyhng != null) {
            if (lincsipnyukyhng.isOptional()) return null;
            return lincsipnyukyhng.absolute();
        }
        return lincsipnyukyhngValue;
    }

    protected void setLincsipnyukyhngValue(BigDecimal value) {
        lincsipnyukyhngValue = value;
        lincsipnyukyhng = Optional.fromNullable(toCurrencyType(lincsipnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsipnyukyhngValue()))
            .orNull();
    }

    transient private String lincsipnyukyhngType = null;

    @Column(name=LINCSIPNYUKYHNG + "$", nullable=true)
    protected String getLincsipnyukyhngType() {
        if (lincsipnyukyhngType == null && lincsipnyukyhng != null) return lincsipnyukyhng.getType().toString();
        if (lincsipnyukyhngType == null && getLincsipnyukyhngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lincsipnyukyhng$' should not be NULL."));
        }
        return lincsipnyukyhngType;
    }

    protected void setLincsipnyukyhngType(String type) {
        lincsipnyukyhngType = type;
        lincsipnyukyhng = Optional.fromNullable(toCurrencyType(lincsipnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsipnyukyhngValue()))
            .orNull();
    }

    private BizCurrency lincsjnyukyhng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLincsjnyukyhng() {
        return lincsjnyukyhng;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLincsjnyukyhng(BizCurrency pLincsjnyukyhng) {
        lincsjnyukyhng = pLincsjnyukyhng;
        lincsjnyukyhngValue = null;
        lincsjnyukyhngType  = null;
    }

    transient private BigDecimal lincsjnyukyhngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCSJNYUKYHNG, nullable=true)
    protected BigDecimal getLincsjnyukyhngValue() {
        if (lincsjnyukyhngValue == null && lincsjnyukyhng != null) {
            if (lincsjnyukyhng.isOptional()) return null;
            return lincsjnyukyhng.absolute();
        }
        return lincsjnyukyhngValue;
    }

    protected void setLincsjnyukyhngValue(BigDecimal value) {
        lincsjnyukyhngValue = value;
        lincsjnyukyhng = Optional.fromNullable(toCurrencyType(lincsjnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsjnyukyhngValue()))
            .orNull();
    }

    transient private String lincsjnyukyhngType = null;

    @Column(name=LINCSJNYUKYHNG + "$", nullable=true)
    protected String getLincsjnyukyhngType() {
        if (lincsjnyukyhngType == null && lincsjnyukyhng != null) return lincsjnyukyhng.getType().toString();
        if (lincsjnyukyhngType == null && getLincsjnyukyhngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lincsjnyukyhng$' should not be NULL."));
        }
        return lincsjnyukyhngType;
    }

    protected void setLincsjnyukyhngType(String type) {
        lincsjnyukyhngType = type;
        lincsjnyukyhng = Optional.fromNullable(toCurrencyType(lincsjnyukyhngType))
            .transform(bizCurrencyTransformer(getLincsjnyukyhngValue()))
            .orNull();
    }

    private BizCurrency lincsonotanyukyhng;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLincsonotanyukyhng() {
        return lincsonotanyukyhng;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLincsonotanyukyhng(BizCurrency pLincsonotanyukyhng) {
        lincsonotanyukyhng = pLincsonotanyukyhng;
        lincsonotanyukyhngValue = null;
        lincsonotanyukyhngType  = null;
    }

    transient private BigDecimal lincsonotanyukyhngValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCSONOTANYUKYHNG, nullable=true)
    protected BigDecimal getLincsonotanyukyhngValue() {
        if (lincsonotanyukyhngValue == null && lincsonotanyukyhng != null) {
            if (lincsonotanyukyhng.isOptional()) return null;
            return lincsonotanyukyhng.absolute();
        }
        return lincsonotanyukyhngValue;
    }

    protected void setLincsonotanyukyhngValue(BigDecimal value) {
        lincsonotanyukyhngValue = value;
        lincsonotanyukyhng = Optional.fromNullable(toCurrencyType(lincsonotanyukyhngType))
            .transform(bizCurrencyTransformer(getLincsonotanyukyhngValue()))
            .orNull();
    }

    transient private String lincsonotanyukyhngType = null;

    @Column(name=LINCSONOTANYUKYHNG + "$", nullable=true)
    protected String getLincsonotanyukyhngType() {
        if (lincsonotanyukyhngType == null && lincsonotanyukyhng != null) return lincsonotanyukyhng.getType().toString();
        if (lincsonotanyukyhngType == null && getLincsonotanyukyhngValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lincsonotanyukyhng$' should not be NULL."));
        }
        return lincsonotanyukyhngType;
    }

    protected void setLincsonotanyukyhngType(String type) {
        lincsonotanyukyhngType = type;
        lincsonotanyukyhng = Optional.fromNullable(toCurrencyType(lincsonotanyukyhngType))
            .transform(bizCurrencyTransformer(getLincsonotanyukyhngValue()))
            .orNull();
    }

    private BizCurrency linchutuusbs;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLinchutuusbs() {
        return linchutuusbs;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLinchutuusbs(BizCurrency pLinchutuusbs) {
        linchutuusbs = pLinchutuusbs;
        linchutuusbsValue = null;
        linchutuusbsType  = null;
    }

    transient private BigDecimal linchutuusbsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCHUTUUSBS, nullable=true)
    protected BigDecimal getLinchutuusbsValue() {
        if (linchutuusbsValue == null && linchutuusbs != null) {
            if (linchutuusbs.isOptional()) return null;
            return linchutuusbs.absolute();
        }
        return linchutuusbsValue;
    }

    protected void setLinchutuusbsValue(BigDecimal value) {
        linchutuusbsValue = value;
        linchutuusbs = Optional.fromNullable(toCurrencyType(linchutuusbsType))
            .transform(bizCurrencyTransformer(getLinchutuusbsValue()))
            .orNull();
    }

    transient private String linchutuusbsType = null;

    @Column(name=LINCHUTUUSBS + "$", nullable=true)
    protected String getLinchutuusbsType() {
        if (linchutuusbsType == null && linchutuusbs != null) return linchutuusbs.getType().toString();
        if (linchutuusbsType == null && getLinchutuusbsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'linchutuusbs$' should not be NULL."));
        }
        return linchutuusbsType;
    }

    protected void setLinchutuusbsType(String type) {
        linchutuusbsType = type;
        linchutuusbs = Optional.fromNullable(toCurrencyType(linchutuusbsType))
            .transform(bizCurrencyTransformer(getLinchutuusbsValue()))
            .orNull();
    }

    private BizCurrency lincsgsbksns;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getLincsgsbksns() {
        return lincsgsbksns;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLincsgsbksns(BizCurrency pLincsgsbksns) {
        lincsgsbksns = pLincsgsbksns;
        lincsgsbksnsValue = null;
        lincsgsbksnsType  = null;
    }

    transient private BigDecimal lincsgsbksnsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=LINCSGSBKSNS, nullable=true)
    protected BigDecimal getLincsgsbksnsValue() {
        if (lincsgsbksnsValue == null && lincsgsbksns != null) {
            if (lincsgsbksns.isOptional()) return null;
            return lincsgsbksns.absolute();
        }
        return lincsgsbksnsValue;
    }

    protected void setLincsgsbksnsValue(BigDecimal value) {
        lincsgsbksnsValue = value;
        lincsgsbksns = Optional.fromNullable(toCurrencyType(lincsgsbksnsType))
            .transform(bizCurrencyTransformer(getLincsgsbksnsValue()))
            .orNull();
    }

    transient private String lincsgsbksnsType = null;

    @Column(name=LINCSGSBKSNS + "$", nullable=true)
    protected String getLincsgsbksnsType() {
        if (lincsgsbksnsType == null && lincsgsbksns != null) return lincsgsbksns.getType().toString();
        if (lincsgsbksnsType == null && getLincsgsbksnsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'lincsgsbksns$' should not be NULL."));
        }
        return lincsgsbksnsType;
    }

    protected void setLincsgsbksnsType(String type) {
        lincsgsbksnsType = type;
        lincsgsbksns = Optional.fromNullable(toCurrencyType(lincsgsbksnsType))
            .transform(bizCurrencyTransformer(getLincsgsbksnsValue()))
            .orNull();
    }

    private Integer linc15sai1000manflg;

    @Column(name=GenHT_SkLincJyusinInfo.LINC15SAI1000MANFLG)
    public Integer getLinc15sai1000manflg() {
        return linc15sai1000manflg;
    }

    public void setLinc15sai1000manflg(Integer pLinc15sai1000manflg) {
        linc15sai1000manflg = pLinc15sai1000manflg;
    }

    private Integer linclincsyoriymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCLINCSYORIYMD)
    public Integer getLinclincsyoriymd() {
        return linclincsyoriymd;
    }

    public void setLinclincsyoriymd(Integer pLinclincsyoriymd) {
        linclincsyoriymd = pLinclincsyoriymd;
    }

    private String linckykkanrino;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKYKKANRINO)
    public String getLinckykkanrino() {
        return linckykkanrino;
    }

    public void setLinckykkanrino(String pLinckykkanrino) {
        linckykkanrino = pLinckykkanrino;
    }

    private String linckakusyasiyouran;

    @Column(name=GenHT_SkLincJyusinInfo.LINCKAKUSYASIYOURAN)
    public String getLinckakusyasiyouran() {
        return linckakusyasiyouran;
    }

    public void setLinckakusyasiyouran(String pLinckakusyasiyouran) {
        linckakusyasiyouran = pLinckakusyasiyouran;
    }

    private Integer lincmousideflg;

    @Column(name=GenHT_SkLincJyusinInfo.LINCMOUSIDEFLG)
    public Integer getLincmousideflg() {
        return lincmousideflg;
    }

    public void setLincmousideflg(Integer pLincmousideflg) {
        lincmousideflg = pLincmousideflg;
    }

    private Integer lincmousideflgsetymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCMOUSIDEFLGSETYMD)
    public Integer getLincmousideflgsetymd() {
        return lincmousideflgsetymd;
    }

    public void setLincmousideflgsetymd(Integer pLincmousideflgsetymd) {
        lincmousideflgsetymd = pLincmousideflgsetymd;
    }

    private Integer lincmousideflgkaijyoymd;

    @Column(name=GenHT_SkLincJyusinInfo.LINCMOUSIDEFLGKAIJYOYMD)
    public Integer getLincmousideflgkaijyoymd() {
        return lincmousideflgkaijyoymd;
    }

    public void setLincmousideflgkaijyoymd(Integer pLincmousideflgkaijyoymd) {
        lincmousideflgkaijyoymd = pLincmousideflgkaijyoymd;
    }

    private Integer lincjgyhknflg;

    @Column(name=GenHT_SkLincJyusinInfo.LINCJGYHKNFLG)
    public Integer getLincjgyhknflg() {
        return lincjgyhknflg;
    }

    public void setLincjgyhknflg(Integer pLincjgyhknflg) {
        lincjgyhknflg = pLincjgyhknflg;
    }

    private Integer linctenkanflg;

    @Column(name=GenHT_SkLincJyusinInfo.LINCTENKANFLG)
    public Integer getLinctenkanflg() {
        return linctenkanflg;
    }

    public void setLinctenkanflg(Integer pLinctenkanflg) {
        linctenkanflg = pLinctenkanflg;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkLincJyusinInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkLincJyusinInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}