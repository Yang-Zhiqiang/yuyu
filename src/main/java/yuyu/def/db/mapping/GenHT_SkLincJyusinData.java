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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.id.PKHT_SkLincJyusinData;
import yuyu.def.db.meta.GenQHT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_LincsoujyusinsysKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 新契約ＬＩＮＣ受信データテーブル テーブルのマッピング情報クラスで、 {@link HT_SkLincJyusinData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincJyusinData}</td><td colspan="3">新契約ＬＩＮＣ受信データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkLincJyusinData ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckyknaiykekdatarenno linckyknaiykekdatarenno}</td><td>ＬＩＮＣ契約内容結果データ連番</td><td align="center">{@link PKHT_SkLincJyusinData ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckyknaiykekdatarennooya linckyknaiykekdatarennooya}</td><td>ＬＩＮＣ契約内容結果データ連番（親）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsousinymd lincsousinymd}</td><td>ＬＩＮＣ＿送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLincdatasyubetu lincdatasyubetu}</td><td>ＬＩＮＣ＿データ種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsoujyusinsyskbn lincsoujyusinsyskbn}</td><td>ＬＩＮＣ送受信用システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_LincsoujyusinsysKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRendoumosnochknasi rendoumosnochknasi}</td><td>連動用申込番号（チェックなし）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getLinchhknseiymd linchhknseiymd}</td><td>ＬＩＮＣ＿被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinchhknadrkn linchhknadrkn}</td><td>ＬＩＮＣ＿被保険者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckeihidjnhyouji linckeihidjnhyouji}</td><td>ＬＩＮＣ＿契被同人表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getLinckyknmkn linckyknmkn}</td><td>ＬＩＮＣ＿契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckyknmkj linckyknmkj}</td><td>ＬＩＮＣ＿契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckyksei linckyksei}</td><td>ＬＩＮＣ＿契約者性別</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinckykseiymd linckykseiymd}</td><td>ＬＩＮＣ＿契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckykadrkn linckykadrkn}</td><td>ＬＩＮＣ＿契約者住所（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckjhngflg linckjhngflg}</td><td>ＬＩＮＣ＿漢字範囲外フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinctrkmousideymd linctrkmousideymd}</td><td>ＬＩＮＣ＿登録申出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckykytymd linckykytymd}</td><td>ＬＩＮＣ＿契約予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckykymd linckykymd}</td><td>ＬＩＮＣ＿契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinchozenytymd linchozenytymd}</td><td>ＬＩＮＣ＿保全予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinchozenymd linchozenymd}</td><td>ＬＩＮＣ＿保全年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLincsousinmotokaisya lincsousinmotokaisya}</td><td>ＬＩＮＣ＿送信元会社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincsgnyukyhng lincsgnyukyhng}</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsipnyukyhng lincsipnyukyhng}</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsjnyukyhng lincsjnyukyhng}</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsonotanyukyhng lincsonotanyukyhng}</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLinchutuusbs linchutuusbs}</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLincsgsbksns lincsgsbksns}</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLinc15sai1000manflg linc15sai1000manflg}</td><td>ＬＩＮＣ＿１５歳未満１０００万超フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinclincsyoriymd linclincsyoriymd}</td><td>ＬＩＮＣ＿ＬＩＮＣ処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckykkanrino linckykkanrino}</td><td>ＬＩＮＣ＿契約管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLinckakusyasiyouran linckakusyasiyouran}</td><td>ＬＩＮＣ＿各社使用欄</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLincmousideflg lincmousideflg}</td><td>ＬＩＮＣ＿申出フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLincmousideflgsetymd lincmousideflgsetymd}</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLincmousideflgkaijyoymd lincmousideflgkaijyoymd}</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLincjgyhknflg lincjgyhknflg}</td><td>ＬＩＮＣ＿事業保険フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinctenkanflg linctenkanflg}</td><td>ＬＩＮＣ＿転換フラグ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincJyusinData
 * @see     PKHT_SkLincJyusinData
 * @see     QHT_SkLincJyusinData
 * @see     GenQHT_SkLincJyusinData
 */
@MappedSuperclass
@Table(name=GenHT_SkLincJyusinData.TABLE_NAME)
@IdClass(value=PKHT_SkLincJyusinData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_LincsoujyusinsysKbn", typeClass=UserType_C_LincsoujyusinsysKbn.class)
})
public abstract class GenHT_SkLincJyusinData extends AbstractExDBEntity<HT_SkLincJyusinData, PKHT_SkLincJyusinData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkLincJyusinData";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String LINCKYKNAIYKEKDATARENNO  = "linckyknaiykekdatarenno";
    public static final String LINCKYKNAIYKEKDATARENNOOYA = "linckyknaiykekdatarennooya";
    public static final String LINCSOUSINYMD            = "lincsousinymd";
    public static final String LINCDATASYUBETU          = "lincdatasyubetu";
    public static final String LINCSOUJYUSINSYSKBN      = "lincsoujyusinsyskbn";
    public static final String SYONO                    = "syono";
    public static final String RENDOUMOSNOCHKNASI       = "rendoumosnochknasi";
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

    private final PKHT_SkLincJyusinData primaryKey;

    public GenHT_SkLincJyusinData() {
        primaryKey = new PKHT_SkLincJyusinData();
    }

    public GenHT_SkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {
        primaryKey = new PKHT_SkLincJyusinData(pSyoriYmd, pLinckyknaiykekdatarenno);
    }

    @Transient
    @Override
    public PKHT_SkLincJyusinData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkLincJyusinData> getMetaClass() {
        return QHT_SkLincJyusinData.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.SYORIYMD)
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
    @Column(name=GenHT_SkLincJyusinData.LINCKYKNAIYKEKDATARENNO)
    public String getLinckyknaiykekdatarenno() {
        return getPrimaryKey().getLinckyknaiykekdatarenno();
    }

    public void setLinckyknaiykekdatarenno(String pLinckyknaiykekdatarenno) {
        getPrimaryKey().setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno);
    }

    private String linckyknaiykekdatarennooya;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKNAIYKEKDATARENNOOYA)
    public String getLinckyknaiykekdatarennooya() {
        return linckyknaiykekdatarennooya;
    }

    public void setLinckyknaiykekdatarennooya(String pLinckyknaiykekdatarennooya) {
        linckyknaiykekdatarennooya = pLinckyknaiykekdatarennooya;
    }

    private BizDate lincsousinymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCSOUSINYMD)
    public BizDate getLincsousinymd() {
        return lincsousinymd;
    }

    public void setLincsousinymd(BizDate pLincsousinymd) {
        lincsousinymd = pLincsousinymd;
    }

    private String lincdatasyubetu;

    @Column(name=GenHT_SkLincJyusinData.LINCDATASYUBETU)
    public String getLincdatasyubetu() {
        return lincdatasyubetu;
    }

    public void setLincdatasyubetu(String pLincdatasyubetu) {
        lincdatasyubetu = pLincdatasyubetu;
    }

    private C_LincsoujyusinsysKbn lincsoujyusinsyskbn;

    @Type(type="UserType_C_LincsoujyusinsysKbn")
    @Column(name=GenHT_SkLincJyusinData.LINCSOUJYUSINSYSKBN)
    public C_LincsoujyusinsysKbn getLincsoujyusinsyskbn() {
        return lincsoujyusinsyskbn;
    }

    public void setLincsoujyusinsyskbn(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn) {
        lincsoujyusinsyskbn = pLincsoujyusinsyskbn;
    }

    private String syono;

    @Column(name=GenHT_SkLincJyusinData.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String rendoumosnochknasi;

    @Column(name=GenHT_SkLincJyusinData.RENDOUMOSNOCHKNASI)
    public String getRendoumosnochknasi() {
        return rendoumosnochknasi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRendoumosnochknasi(String pRendoumosnochknasi) {
        rendoumosnochknasi = pRendoumosnochknasi;
    }

    private Integer lincrecordsyubetu;

    @Column(name=GenHT_SkLincJyusinData.LINCRECORDSYUBETU)
    public Integer getLincrecordsyubetu() {
        return lincrecordsyubetu;
    }

    public void setLincrecordsyubetu(Integer pLincrecordsyubetu) {
        lincrecordsyubetu = pLincrecordsyubetu;
    }

    private String linchenkoutype;

    @Column(name=GenHT_SkLincJyusinData.LINCHENKOUTYPE)
    public String getLinchenkoutype() {
        return linchenkoutype;
    }

    public void setLinchenkoutype(String pLinchenkoutype) {
        linchenkoutype = pLinchenkoutype;
    }

    private Integer lincsyorikekkakekkacd;

    @Column(name=GenHT_SkLincJyusinData.LINCSYORIKEKKAKEKKACD)
    public Integer getLincsyorikekkakekkacd() {
        return lincsyorikekkakekkacd;
    }

    public void setLincsyorikekkakekkacd(Integer pLincsyorikekkakekkacd) {
        lincsyorikekkakekkacd = pLincsyorikekkakekkacd;
    }

    private Integer lincsyorikekkakekkajiyu;

    @Column(name=GenHT_SkLincJyusinData.LINCSYORIKEKKAKEKKAJIYU)
    public Integer getLincsyorikekkakekkajiyu() {
        return lincsyorikekkakekkajiyu;
    }

    public void setLincsyorikekkakekkajiyu(Integer pLincsyorikekkakekkajiyu) {
        lincsyorikekkakekkajiyu = pLincsyorikekkakekkajiyu;
    }

    private Integer lincsyorikekkaerrkouban;

    @Column(name=GenHT_SkLincJyusinData.LINCSYORIKEKKAERRKOUBAN)
    public Integer getLincsyorikekkaerrkouban() {
        return lincsyorikekkaerrkouban;
    }

    public void setLincsyorikekkaerrkouban(Integer pLincsyorikekkaerrkouban) {
        lincsyorikekkaerrkouban = pLincsyorikekkaerrkouban;
    }

    private Integer lincnayoserecordsuu;

    @Column(name=GenHT_SkLincJyusinData.LINCNAYOSERECORDSUU)
    public Integer getLincnayoserecordsuu() {
        return lincnayoserecordsuu;
    }

    public void setLincnayoserecordsuu(Integer pLincnayoserecordsuu) {
        lincnayoserecordsuu = pLincnayoserecordsuu;
    }

    private Long linckanyuusyano;

    @Column(name=GenHT_SkLincJyusinData.LINCKANYUUSYANO)
    public Long getLinckanyuusyano() {
        return linckanyuusyano;
    }

    public void setLinckanyuusyano(Long pLinckanyuusyano) {
        linckanyuusyano = pLinckanyuusyano;
    }

    private String lincnayoseyomiknnm;

    @Column(name=GenHT_SkLincJyusinData.LINCNAYOSEYOMIKNNM)
    public String getLincnayoseyomiknnm() {
        return lincnayoseyomiknnm;
    }

    public void setLincnayoseyomiknnm(String pLincnayoseyomiknnm) {
        lincnayoseyomiknnm = pLincnayoseyomiknnm;
    }

    private String linchhknnmkn;

    @Column(name=GenHT_SkLincJyusinData.LINCHHKNNMKN)
    public String getLinchhknnmkn() {
        return linchhknnmkn;
    }

    public void setLinchhknnmkn(String pLinchhknnmkn) {
        linchhknnmkn = pLinchhknnmkn;
    }

    private String linchhknnmkj;

    @Column(name=GenHT_SkLincJyusinData.LINCHHKNNMKJ)
    public String getLinchhknnmkj() {
        return linchhknnmkj;
    }

    public void setLinchhknnmkj(String pLinchhknnmkj) {
        linchhknnmkj = pLinchhknnmkj;
    }

    private Integer linchhknsei;

    @Column(name=GenHT_SkLincJyusinData.LINCHHKNSEI)
    public Integer getLinchhknsei() {
        return linchhknsei;
    }

    public void setLinchhknsei(Integer pLinchhknsei) {
        linchhknsei = pLinchhknsei;
    }

    private BizDate linchhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCHHKNSEIYMD)
    public BizDate getLinchhknseiymd() {
        return linchhknseiymd;
    }

    public void setLinchhknseiymd(BizDate pLinchhknseiymd) {
        linchhknseiymd = pLinchhknseiymd;
    }

    private String linchhknadrkn;

    @Column(name=GenHT_SkLincJyusinData.LINCHHKNADRKN)
    public String getLinchhknadrkn() {
        return linchhknadrkn;
    }

    public void setLinchhknadrkn(String pLinchhknadrkn) {
        linchhknadrkn = pLinchhknadrkn;
    }

    private C_KykKbn linckeihidjnhyouji;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenHT_SkLincJyusinData.LINCKEIHIDJNHYOUJI)
    public C_KykKbn getLinckeihidjnhyouji() {
        return linckeihidjnhyouji;
    }

    public void setLinckeihidjnhyouji(C_KykKbn pLinckeihidjnhyouji) {
        linckeihidjnhyouji = pLinckeihidjnhyouji;
    }

    private String linckyknmkn;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKNMKN)
    public String getLinckyknmkn() {
        return linckyknmkn;
    }

    public void setLinckyknmkn(String pLinckyknmkn) {
        linckyknmkn = pLinckyknmkn;
    }

    private String linckyknmkj;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKNMKJ)
    public String getLinckyknmkj() {
        return linckyknmkj;
    }

    public void setLinckyknmkj(String pLinckyknmkj) {
        linckyknmkj = pLinckyknmkj;
    }

    private Integer linckyksei;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKSEI)
    public Integer getLinckyksei() {
        return linckyksei;
    }

    public void setLinckyksei(Integer pLinckyksei) {
        linckyksei = pLinckyksei;
    }

    private BizDate linckykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCKYKSEIYMD)
    public BizDate getLinckykseiymd() {
        return linckykseiymd;
    }

    public void setLinckykseiymd(BizDate pLinckykseiymd) {
        linckykseiymd = pLinckykseiymd;
    }

    private String linckykadrkn;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKADRKN)
    public String getLinckykadrkn() {
        return linckykadrkn;
    }

    public void setLinckykadrkn(String pLinckykadrkn) {
        linckykadrkn = pLinckykadrkn;
    }

    private Integer linckjhngflg;

    @Column(name=GenHT_SkLincJyusinData.LINCKJHNGFLG)
    public Integer getLinckjhngflg() {
        return linckjhngflg;
    }

    public void setLinckjhngflg(Integer pLinckjhngflg) {
        linckjhngflg = pLinckjhngflg;
    }

    private BizDate linctrkmousideymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCTRKMOUSIDEYMD)
    public BizDate getLinctrkmousideymd() {
        return linctrkmousideymd;
    }

    public void setLinctrkmousideymd(BizDate pLinctrkmousideymd) {
        linctrkmousideymd = pLinctrkmousideymd;
    }

    private BizDate linckykytymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCKYKYTYMD)
    public BizDate getLinckykytymd() {
        return linckykytymd;
    }

    public void setLinckykytymd(BizDate pLinckykytymd) {
        linckykytymd = pLinckykytymd;
    }

    private BizDate linckykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCKYKYMD)
    public BizDate getLinckykymd() {
        return linckykymd;
    }

    public void setLinckykymd(BizDate pLinckykymd) {
        linckykymd = pLinckykymd;
    }

    private BizDate linchozenytymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCHOZENYTYMD)
    public BizDate getLinchozenytymd() {
        return linchozenytymd;
    }

    public void setLinchozenytymd(BizDate pLinchozenytymd) {
        linchozenytymd = pLinchozenytymd;
    }

    private BizDate linchozenymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCHOZENYMD)
    public BizDate getLinchozenymd() {
        return linchozenymd;
    }

    public void setLinchozenymd(BizDate pLinchozenymd) {
        linchozenymd = pLinchozenymd;
    }

    private String lincsousinmotokaisya;

    @Column(name=GenHT_SkLincJyusinData.LINCSOUSINMOTOKAISYA)
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

    @Column(name=GenHT_SkLincJyusinData.LINC15SAI1000MANFLG)
    public Integer getLinc15sai1000manflg() {
        return linc15sai1000manflg;
    }

    public void setLinc15sai1000manflg(Integer pLinc15sai1000manflg) {
        linc15sai1000manflg = pLinc15sai1000manflg;
    }

    private BizDate linclincsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCLINCSYORIYMD)
    public BizDate getLinclincsyoriymd() {
        return linclincsyoriymd;
    }

    public void setLinclincsyoriymd(BizDate pLinclincsyoriymd) {
        linclincsyoriymd = pLinclincsyoriymd;
    }

    private String linckykkanrino;

    @Column(name=GenHT_SkLincJyusinData.LINCKYKKANRINO)
    public String getLinckykkanrino() {
        return linckykkanrino;
    }

    public void setLinckykkanrino(String pLinckykkanrino) {
        linckykkanrino = pLinckykkanrino;
    }

    private String linckakusyasiyouran;

    @Column(name=GenHT_SkLincJyusinData.LINCKAKUSYASIYOURAN)
    public String getLinckakusyasiyouran() {
        return linckakusyasiyouran;
    }

    public void setLinckakusyasiyouran(String pLinckakusyasiyouran) {
        linckakusyasiyouran = pLinckakusyasiyouran;
    }

    private Integer lincmousideflg;

    @Column(name=GenHT_SkLincJyusinData.LINCMOUSIDEFLG)
    public Integer getLincmousideflg() {
        return lincmousideflg;
    }

    public void setLincmousideflg(Integer pLincmousideflg) {
        lincmousideflg = pLincmousideflg;
    }

    private BizDate lincmousideflgsetymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCMOUSIDEFLGSETYMD)
    public BizDate getLincmousideflgsetymd() {
        return lincmousideflgsetymd;
    }

    public void setLincmousideflgsetymd(BizDate pLincmousideflgsetymd) {
        lincmousideflgsetymd = pLincmousideflgsetymd;
    }

    private BizDate lincmousideflgkaijyoymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkLincJyusinData.LINCMOUSIDEFLGKAIJYOYMD)
    public BizDate getLincmousideflgkaijyoymd() {
        return lincmousideflgkaijyoymd;
    }

    public void setLincmousideflgkaijyoymd(BizDate pLincmousideflgkaijyoymd) {
        lincmousideflgkaijyoymd = pLincmousideflgkaijyoymd;
    }

    private Integer lincjgyhknflg;

    @Column(name=GenHT_SkLincJyusinData.LINCJGYHKNFLG)
    public Integer getLincjgyhknflg() {
        return lincjgyhknflg;
    }

    public void setLincjgyhknflg(Integer pLincjgyhknflg) {
        lincjgyhknflg = pLincjgyhknflg;
    }

    private Integer linctenkanflg;

    @Column(name=GenHT_SkLincJyusinData.LINCTENKANFLG)
    public Integer getLinctenkanflg() {
        return linctenkanflg;
    }

    public void setLinctenkanflg(Integer pLinctenkanflg) {
        linctenkanflg = pLinctenkanflg;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkLincJyusinData.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkLincJyusinData.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}