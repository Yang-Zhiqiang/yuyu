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
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.id.PKMT_DsTorihikiServiceKanri;
import yuyu.def.db.meta.GenQMT_DsTorihikiServiceKanri;
import yuyu.def.db.meta.QMT_DsTorihikiServiceKanri;
import yuyu.def.db.type.UserType_C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.db.type.UserType_C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.db.type.UserType_C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ取引サービス管理テーブル テーブルのマッピング情報クラスで、 {@link MT_DsTorihikiServiceKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTorihikiServiceKanri}</td><td colspan="3">ＤＳ取引サービス管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsTorihikiServiceKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsTorihikiServiceKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDstrhkserviceriyoujkkbn dstrhkserviceriyoujkkbn}</td><td>ＤＳ取引サービス利用状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsTrhkserviceRiyoujkKbn}</td></tr>
 *  <tr><td>{@link #getDstrhkserviceteisiriyuukbn dstrhkserviceteisiriyuukbn}</td><td>ＤＳ取引サービス停止理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsTrhkserviceTeisiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getDstrhkservicetourokuymd dstrhkservicetourokuymd}</td><td>ＤＳ取引サービス登録年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDstrhkservicemukouymd dstrhkservicemukouymd}</td><td>ＤＳ取引サービス無効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDstrhkservicekanyukeirokbn dstrhkservicekanyukeirokbn}</td><td>ＤＳ取引サービス加入経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsTrhkserviceKanyukeiroKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTorihikiServiceKanri
 * @see     PKMT_DsTorihikiServiceKanri
 * @see     QMT_DsTorihikiServiceKanri
 * @see     GenQMT_DsTorihikiServiceKanri
 */
@MappedSuperclass
@Table(name=GenMT_DsTorihikiServiceKanri.TABLE_NAME)
@IdClass(value=PKMT_DsTorihikiServiceKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsTrhkserviceKanyukeiroKbn", typeClass=UserType_C_DsTrhkserviceKanyukeiroKbn.class),
    @TypeDef(name="UserType_C_DsTrhkserviceRiyoujkKbn", typeClass=UserType_C_DsTrhkserviceRiyoujkKbn.class),
    @TypeDef(name="UserType_C_DsTrhkserviceTeisiRiyuuKbn", typeClass=UserType_C_DsTrhkserviceTeisiRiyuuKbn.class)
})
public abstract class GenMT_DsTorihikiServiceKanri extends AbstractExDBEntity<MT_DsTorihikiServiceKanri, PKMT_DsTorihikiServiceKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsTorihikiServiceKanri";
    public static final String DSKOKNO                  = "dskokno";
    public static final String SYONO                    = "syono";
    public static final String DSTRHKSERVICERIYOUJKKBN  = "dstrhkserviceriyoujkkbn";
    public static final String DSTRHKSERVICETEISIRIYUUKBN = "dstrhkserviceteisiriyuukbn";
    public static final String DSTRHKSERVICETOUROKUYMD  = "dstrhkservicetourokuymd";
    public static final String DSTRHKSERVICEMUKOUYMD    = "dstrhkservicemukouymd";
    public static final String DSTRHKSERVICEKANYUKEIROKBN = "dstrhkservicekanyukeirokbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsTorihikiServiceKanri primaryKey;

    public GenMT_DsTorihikiServiceKanri() {
        primaryKey = new PKMT_DsTorihikiServiceKanri();
    }

    public GenMT_DsTorihikiServiceKanri(String pDskokno, String pSyono) {
        primaryKey = new PKMT_DsTorihikiServiceKanri(pDskokno, pSyono);
    }

    @Transient
    @Override
    public PKMT_DsTorihikiServiceKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsTorihikiServiceKanri> getMetaClass() {
        return QMT_DsTorihikiServiceKanri.class;
    }

    @Id
    @Column(name=GenMT_DsTorihikiServiceKanri.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsTorihikiServiceKanri.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private C_DsTrhkserviceRiyoujkKbn dstrhkserviceriyoujkkbn;

    @Type(type="UserType_C_DsTrhkserviceRiyoujkKbn")
    @Column(name=GenMT_DsTorihikiServiceKanri.DSTRHKSERVICERIYOUJKKBN)
    public C_DsTrhkserviceRiyoujkKbn getDstrhkserviceriyoujkkbn() {
        return dstrhkserviceriyoujkkbn;
    }

    public void setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn pDstrhkserviceriyoujkkbn) {
        dstrhkserviceriyoujkkbn = pDstrhkserviceriyoujkkbn;
    }

    private C_DsTrhkserviceTeisiRiyuuKbn dstrhkserviceteisiriyuukbn;

    @Type(type="UserType_C_DsTrhkserviceTeisiRiyuuKbn")
    @Column(name=GenMT_DsTorihikiServiceKanri.DSTRHKSERVICETEISIRIYUUKBN)
    public C_DsTrhkserviceTeisiRiyuuKbn getDstrhkserviceteisiriyuukbn() {
        return dstrhkserviceteisiriyuukbn;
    }

    public void setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn pDstrhkserviceteisiriyuukbn) {
        dstrhkserviceteisiriyuukbn = pDstrhkserviceteisiriyuukbn;
    }

    private BizDate dstrhkservicetourokuymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTorihikiServiceKanri.DSTRHKSERVICETOUROKUYMD)
    public BizDate getDstrhkservicetourokuymd() {
        return dstrhkservicetourokuymd;
    }

    public void setDstrhkservicetourokuymd(BizDate pDstrhkservicetourokuymd) {
        dstrhkservicetourokuymd = pDstrhkservicetourokuymd;
    }

    private BizDate dstrhkservicemukouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTorihikiServiceKanri.DSTRHKSERVICEMUKOUYMD)
    public BizDate getDstrhkservicemukouymd() {
        return dstrhkservicemukouymd;
    }

    public void setDstrhkservicemukouymd(BizDate pDstrhkservicemukouymd) {
        dstrhkservicemukouymd = pDstrhkservicemukouymd;
    }

    private C_DsTrhkserviceKanyukeiroKbn dstrhkservicekanyukeirokbn;

    @Type(type="UserType_C_DsTrhkserviceKanyukeiroKbn")
    @Column(name=GenMT_DsTorihikiServiceKanri.DSTRHKSERVICEKANYUKEIROKBN)
    public C_DsTrhkserviceKanyukeiroKbn getDstrhkservicekanyukeirokbn() {
        return dstrhkservicekanyukeirokbn;
    }

    public void setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn pDstrhkservicekanyukeirokbn) {
        dstrhkservicekanyukeirokbn = pDstrhkservicekanyukeirokbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsTorihikiServiceKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsTorihikiServiceKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsTorihikiServiceKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}