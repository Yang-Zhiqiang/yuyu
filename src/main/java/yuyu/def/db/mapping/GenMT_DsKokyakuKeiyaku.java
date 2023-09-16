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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.id.PKMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.GenQMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.type.UserType_C_DsSyomenTtdkHyouji;
import yuyu.def.db.type.UserType_C_MukouHyj;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ顧客契約テーブル テーブルのマッピング情報クラスで、 {@link MT_DsKokyakuKeiyaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsKokyakuKeiyaku}</td><td colspan="3">ＤＳ顧客契約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsKokyakuKeiyaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsKokyakuKeiyaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskykkanyuuymd dskykkanyuuymd}</td><td>ＤＳ契約加入年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskykhenkouymd dskykhenkouymd}</td><td>ＤＳ契約変更年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskykmukouhyj dskykmukouhyj}</td><td>ＤＳ契約無効表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MukouHyj}</td></tr>
 *  <tr><td>{@link #getDskykmukouymd dskykmukouymd}</td><td>ＤＳ契約無効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPplessrenjidssymenttdkhyj pplessrenjidssymenttdkhyj}</td><td>ペーパーレス連動時ＤＳ書面手続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyomenTtdkHyouji}</td></tr>
 * </table>
 * @see     MT_DsKokyakuKeiyaku
 * @see     PKMT_DsKokyakuKeiyaku
 * @see     QMT_DsKokyakuKeiyaku
 * @see     GenQMT_DsKokyakuKeiyaku
 */
@MappedSuperclass
@Table(name=GenMT_DsKokyakuKeiyaku.TABLE_NAME)
@IdClass(value=PKMT_DsKokyakuKeiyaku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSyomenTtdkHyouji", typeClass=UserType_C_DsSyomenTtdkHyouji.class),
    @TypeDef(name="UserType_C_MukouHyj", typeClass=UserType_C_MukouHyj.class)
})
public abstract class GenMT_DsKokyakuKeiyaku extends AbstractExDBEntity<MT_DsKokyakuKeiyaku, PKMT_DsKokyakuKeiyaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsKokyakuKeiyaku";
    public static final String DSKOKNO                  = "dskokno";
    public static final String SYONO                    = "syono";
    public static final String DSKYKKANYUUYMD           = "dskykkanyuuymd";
    public static final String DSKYKHENKOUYMD           = "dskykhenkouymd";
    public static final String DSKYKMUKOUHYJ            = "dskykmukouhyj";
    public static final String DSKYKMUKOUYMD            = "dskykmukouymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String PPLESSRENJIDSSYMENTTDKHYJ = "pplessrenjidssymenttdkhyj";

    private final PKMT_DsKokyakuKeiyaku primaryKey;

    public GenMT_DsKokyakuKeiyaku() {
        primaryKey = new PKMT_DsKokyakuKeiyaku();
    }

    public GenMT_DsKokyakuKeiyaku(String pDskokno, String pSyono) {
        primaryKey = new PKMT_DsKokyakuKeiyaku(pDskokno, pSyono);
    }

    @Transient
    @Override
    public PKMT_DsKokyakuKeiyaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsKokyakuKeiyaku> getMetaClass() {
        return QMT_DsKokyakuKeiyaku.class;
    }

    @Id
    @Column(name=GenMT_DsKokyakuKeiyaku.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsKokyakuKeiyaku.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate dskykkanyuuymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsKokyakuKeiyaku.DSKYKKANYUUYMD)
    public BizDate getDskykkanyuuymd() {
        return dskykkanyuuymd;
    }

    public void setDskykkanyuuymd(BizDate pDskykkanyuuymd) {
        dskykkanyuuymd = pDskykkanyuuymd;
    }

    private BizDate dskykhenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsKokyakuKeiyaku.DSKYKHENKOUYMD)
    public BizDate getDskykhenkouymd() {
        return dskykhenkouymd;
    }

    public void setDskykhenkouymd(BizDate pDskykhenkouymd) {
        dskykhenkouymd = pDskykhenkouymd;
    }

    private C_MukouHyj dskykmukouhyj;

    @Type(type="UserType_C_MukouHyj")
    @Column(name=GenMT_DsKokyakuKeiyaku.DSKYKMUKOUHYJ)
    public C_MukouHyj getDskykmukouhyj() {
        return dskykmukouhyj;
    }

    public void setDskykmukouhyj(C_MukouHyj pDskykmukouhyj) {
        dskykmukouhyj = pDskykmukouhyj;
    }

    private BizDate dskykmukouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsKokyakuKeiyaku.DSKYKMUKOUYMD)
    public BizDate getDskykmukouymd() {
        return dskykmukouymd;
    }

    public void setDskykmukouymd(BizDate pDskykmukouymd) {
        dskykmukouymd = pDskykmukouymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsKokyakuKeiyaku.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsKokyakuKeiyaku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsKokyakuKeiyaku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private C_DsSyomenTtdkHyouji pplessrenjidssymenttdkhyj;

    @Type(type="UserType_C_DsSyomenTtdkHyouji")
    @Column(name=GenMT_DsKokyakuKeiyaku.PPLESSRENJIDSSYMENTTDKHYJ)
    public C_DsSyomenTtdkHyouji getPplessrenjidssymenttdkhyj() {
        return pplessrenjidssymenttdkhyj;
    }

    public void setPplessrenjidssymenttdkhyj(C_DsSyomenTtdkHyouji pPplessrenjidssymenttdkhyj) {
        pplessrenjidssymenttdkhyj = pPplessrenjidssymenttdkhyj;
    }
}