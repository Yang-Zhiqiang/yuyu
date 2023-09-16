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
import yuyu.def.db.entity.MT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.db.id.PKMT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.GenQMT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.QMT_BAK_DsTorihikiyouAnsyono;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ特定取引用暗証番号バックアップテーブル テーブルのマッピング情報クラスで、 {@link MT_BAK_DsTorihikiyouAnsyono} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsTorihikiyouAnsyono}</td><td colspan="3">ＤＳ特定取引用暗証番号バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_BAK_DsTorihikiyouAnsyono ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_BAK_DsTorihikiyouAnsyono ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKMT_BAK_DsTorihikiyouAnsyono ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokuteitrhkansyono tokuteitrhkansyono}</td><td>特定取引用暗証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTktrhkansyonoerrorkaisuu tktrhkansyonoerrorkaisuu}</td><td>特定取引用暗証番号エラー回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSetymd setymd}</td><td>設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsTorihikiyouAnsyono
 * @see     PKMT_BAK_DsTorihikiyouAnsyono
 * @see     QMT_BAK_DsTorihikiyouAnsyono
 * @see     GenQMT_BAK_DsTorihikiyouAnsyono
 */
@MappedSuperclass
@Table(name=GenMT_BAK_DsTorihikiyouAnsyono.TABLE_NAME)
@IdClass(value=PKMT_BAK_DsTorihikiyouAnsyono.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenMT_BAK_DsTorihikiyouAnsyono extends AbstractExDBEntity<MT_BAK_DsTorihikiyouAnsyono, PKMT_BAK_DsTorihikiyouAnsyono> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_BAK_DsTorihikiyouAnsyono";
    public static final String DSKOKNO                  = "dskokno";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TOKUTEITRHKANSYONO       = "tokuteitrhkansyono";
    public static final String TKTRHKANSYONOERRORKAISUU = "tktrhkansyonoerrorkaisuu";
    public static final String SETYMD                   = "setymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_BAK_DsTorihikiyouAnsyono primaryKey;

    public GenMT_BAK_DsTorihikiyouAnsyono() {
        primaryKey = new PKMT_BAK_DsTorihikiyouAnsyono();
    }

    public GenMT_BAK_DsTorihikiyouAnsyono(
        String pDskokno,
        String pSyono,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKMT_BAK_DsTorihikiyouAnsyono(
            pDskokno,
            pSyono,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKMT_BAK_DsTorihikiyouAnsyono getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_BAK_DsTorihikiyouAnsyono> getMetaClass() {
        return QMT_BAK_DsTorihikiyouAnsyono.class;
    }

    @Id
    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private String tokuteitrhkansyono;

    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.TOKUTEITRHKANSYONO)
    public String getTokuteitrhkansyono() {
        return tokuteitrhkansyono;
    }

    public void setTokuteitrhkansyono(String pTokuteitrhkansyono) {
        tokuteitrhkansyono = pTokuteitrhkansyono;
    }

    private Integer tktrhkansyonoerrorkaisuu;

    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.TKTRHKANSYONOERRORKAISUU)
    public Integer getTktrhkansyonoerrorkaisuu() {
        return tktrhkansyonoerrorkaisuu;
    }

    public void setTktrhkansyonoerrorkaisuu(Integer pTktrhkansyonoerrorkaisuu) {
        tktrhkansyonoerrorkaisuu = pTktrhkansyonoerrorkaisuu;
    }

    private BizDate setymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.SETYMD)
    public BizDate getSetymd() {
        return setymd;
    }

    public void setSetymd(BizDate pSetymd) {
        setymd = pSetymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_BAK_DsTorihikiyouAnsyono.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}