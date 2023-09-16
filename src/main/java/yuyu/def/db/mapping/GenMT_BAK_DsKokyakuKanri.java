package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.id.PKMT_BAK_DsKokyakuKanri;
import yuyu.def.db.meta.GenQMT_BAK_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_BAK_DsKokyakuKanri;
import yuyu.def.db.type.UserType_C_DsKanyuuKeiroKbn;
import yuyu.def.db.type.UserType_C_DsKokyakuJtKbn;
import yuyu.def.db.type.UserType_C_DsTeisiRiyuuKbn;
import yuyu.def.db.type.UserType_C_SeisaHuyouHyj;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * ＤＳ顧客管理バックアップテーブル テーブルのマッピング情報クラスで、 {@link MT_BAK_DsKokyakuKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsKokyakuKanri}</td><td colspan="3">ＤＳ顧客管理バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_BAK_DsKokyakuKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKMT_BAK_DsKokyakuKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokyakujtkbn dskokyakujtkbn}</td><td>ＤＳ顧客状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsKokyakuJtKbn}</td></tr>
 *  <tr><td>{@link #getDskokyakusakuseiymd dskokyakusakuseiymd}</td><td>ＤＳ顧客作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsteisiriyuukbn dsteisiriyuukbn}</td><td>ＤＳ停止理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsTeisiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getDskokyakumukouymd dskokyakumukouymd}</td><td>ＤＳ顧客無効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisahuyouhyj seisahuyouhyj}</td><td>精査不要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisaHuyouHyj}</td></tr>
 *  <tr><td>{@link #getDskokyakunmkn dskokyakunmkn}</td><td>ＤＳ顧客名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokyakunmkj dskokyakunmkj}</td><td>ＤＳ顧客名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokyakuseiymd dskokyakuseiymd}</td><td>ＤＳ顧客生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokyakuyno dskokyakuyno}</td><td>ＤＳ顧客郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskanyuukeirokbn dskanyuukeirokbn}</td><td>ＤＳ加入経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsKanyuuKeiroKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsKokyakuKanri
 * @see     PKMT_BAK_DsKokyakuKanri
 * @see     QMT_BAK_DsKokyakuKanri
 * @see     GenQMT_BAK_DsKokyakuKanri
 */
@MappedSuperclass
@Table(name=GenMT_BAK_DsKokyakuKanri.TABLE_NAME)
@IdClass(value=PKMT_BAK_DsKokyakuKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsKanyuuKeiroKbn", typeClass=UserType_C_DsKanyuuKeiroKbn.class),
    @TypeDef(name="UserType_C_DsKokyakuJtKbn", typeClass=UserType_C_DsKokyakuJtKbn.class),
    @TypeDef(name="UserType_C_DsTeisiRiyuuKbn", typeClass=UserType_C_DsTeisiRiyuuKbn.class),
    @TypeDef(name="UserType_C_SeisaHuyouHyj", typeClass=UserType_C_SeisaHuyouHyj.class)
})
public abstract class GenMT_BAK_DsKokyakuKanri extends AbstractExDBEntity<MT_BAK_DsKokyakuKanri, PKMT_BAK_DsKokyakuKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_BAK_DsKokyakuKanri";
    public static final String DSKOKNO                  = "dskokno";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DSKOKYAKUJTKBN           = "dskokyakujtkbn";
    public static final String DSKOKYAKUSAKUSEIYMD      = "dskokyakusakuseiymd";
    public static final String DSTEISIRIYUUKBN          = "dsteisiriyuukbn";
    public static final String DSKOKYAKUMUKOUYMD        = "dskokyakumukouymd";
    public static final String SEISAHUYOUHYJ            = "seisahuyouhyj";
    public static final String DSKOKYAKUNMKN            = "dskokyakunmkn";
    public static final String DSKOKYAKUNMKJ            = "dskokyakunmkj";
    public static final String DSKOKYAKUSEIYMD          = "dskokyakuseiymd";
    public static final String DSKOKYAKUYNO             = "dskokyakuyno";
    public static final String DSKANYUUKEIROKBN         = "dskanyuukeirokbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_BAK_DsKokyakuKanri primaryKey;

    public GenMT_BAK_DsKokyakuKanri() {
        primaryKey = new PKMT_BAK_DsKokyakuKanri();
    }

    public GenMT_BAK_DsKokyakuKanri(String pDskokno, String pTrkssikibetukey) {
        primaryKey = new PKMT_BAK_DsKokyakuKanri(pDskokno, pTrkssikibetukey);
    }

    @Transient
    @Override
    public PKMT_BAK_DsKokyakuKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_BAK_DsKokyakuKanri> getMetaClass() {
        return QMT_BAK_DsKokyakuKanri.class;
    }

    @Id
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_BAK_DsKokyakuKanri.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private C_DsKokyakuJtKbn dskokyakujtkbn;

    @Type(type="UserType_C_DsKokyakuJtKbn")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUJTKBN)
    public C_DsKokyakuJtKbn getDskokyakujtkbn() {
        return dskokyakujtkbn;
    }

    public void setDskokyakujtkbn(C_DsKokyakuJtKbn pDskokyakujtkbn) {
        dskokyakujtkbn = pDskokyakujtkbn;
    }

    private BizDate dskokyakusakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUSAKUSEIYMD)
    public BizDate getDskokyakusakuseiymd() {
        return dskokyakusakuseiymd;
    }

    public void setDskokyakusakuseiymd(BizDate pDskokyakusakuseiymd) {
        dskokyakusakuseiymd = pDskokyakusakuseiymd;
    }

    private C_DsTeisiRiyuuKbn dsteisiriyuukbn;

    @Type(type="UserType_C_DsTeisiRiyuuKbn")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSTEISIRIYUUKBN)
    public C_DsTeisiRiyuuKbn getDsteisiriyuukbn() {
        return dsteisiriyuukbn;
    }

    public void setDsteisiriyuukbn(C_DsTeisiRiyuuKbn pDsteisiriyuukbn) {
        dsteisiriyuukbn = pDsteisiriyuukbn;
    }

    private BizDate dskokyakumukouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUMUKOUYMD)
    public BizDate getDskokyakumukouymd() {
        return dskokyakumukouymd;
    }

    public void setDskokyakumukouymd(BizDate pDskokyakumukouymd) {
        dskokyakumukouymd = pDskokyakumukouymd;
    }

    private C_SeisaHuyouHyj seisahuyouhyj;

    @Type(type="UserType_C_SeisaHuyouHyj")
    @Column(name=GenMT_BAK_DsKokyakuKanri.SEISAHUYOUHYJ)
    public C_SeisaHuyouHyj getSeisahuyouhyj() {
        return seisahuyouhyj;
    }

    public void setSeisahuyouhyj(C_SeisaHuyouHyj pSeisahuyouhyj) {
        seisahuyouhyj = pSeisahuyouhyj;
    }

    private String dskokyakunmkn;

    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUNMKN)
    @HostInvalidCharacter
    public String getDskokyakunmkn() {
        return dskokyakunmkn;
    }

    public void setDskokyakunmkn(String pDskokyakunmkn) {
        dskokyakunmkn = pDskokyakunmkn;
    }

    private String dskokyakunmkj;

    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUNMKJ)
    public String getDskokyakunmkj() {
        return dskokyakunmkj;
    }

    public void setDskokyakunmkj(String pDskokyakunmkj) {
        dskokyakunmkj = pDskokyakunmkj;
    }

    private BizDate dskokyakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUSEIYMD)
    public BizDate getDskokyakuseiymd() {
        return dskokyakuseiymd;
    }

    public void setDskokyakuseiymd(BizDate pDskokyakuseiymd) {
        dskokyakuseiymd = pDskokyakuseiymd;
    }

    private String dskokyakuyno;

    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKOKYAKUYNO)
    public String getDskokyakuyno() {
        return dskokyakuyno;
    }

    public void setDskokyakuyno(String pDskokyakuyno) {
        dskokyakuyno = pDskokyakuyno;
    }

    private C_DsKanyuuKeiroKbn dskanyuukeirokbn;

    @Type(type="UserType_C_DsKanyuuKeiroKbn")
    @Column(name=GenMT_BAK_DsKokyakuKanri.DSKANYUUKEIROKBN)
    public C_DsKanyuuKeiroKbn getDskanyuukeirokbn() {
        return dskanyuukeirokbn;
    }

    public void setDskanyuukeirokbn(C_DsKanyuuKeiroKbn pDskanyuukeirokbn) {
        dskanyuukeirokbn = pDskanyuukeirokbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_BAK_DsKokyakuKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_BAK_DsKokyakuKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_BAK_DsKokyakuKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}