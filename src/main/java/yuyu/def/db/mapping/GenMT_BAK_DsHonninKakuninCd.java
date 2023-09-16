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
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.db.entity.MT_BAK_DsHonninKakuninCd;
import yuyu.def.db.id.PKMT_BAK_DsHonninKakuninCd;
import yuyu.def.db.meta.GenQMT_BAK_DsHonninKakuninCd;
import yuyu.def.db.meta.QMT_BAK_DsHonninKakuninCd;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdSetKbn;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.db.type.UserType_C_DsKrHnnKakCdTtYhKbn;

/**
 * ＤＳ本人確認コードバックアップテーブル テーブルのマッピング情報クラスで、 {@link MT_BAK_DsHonninKakuninCd} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsHonninKakuninCd}</td><td colspan="3">ＤＳ本人確認コードバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_BAK_DsHonninKakuninCd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKMT_BAK_DsHonninKakuninCd ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcd dskrhnnkakcd}</td><td>ＤＳ仮本人確認コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdsetkbn dskrhnnkakcdsetkbn}</td><td>ＤＳ仮本人確認コード設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsKrHnnKakCdSetKbn}</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdsetymd dskrhnnkakcdsetymd}</td><td>ＤＳ仮本人確認コード設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdyuukouymd dskrhnnkakcdyuukouymd}</td><td>ＤＳ仮本人確認コード有効年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDshnnkakcd dshnnkakcd}</td><td>ＤＳ本人確認コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDshnnkakcdsetymd dshnnkakcdsetymd}</td><td>ＤＳ本人確認コード設定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZenkaidskrhnnkakcd zenkaidskrhnnkakcd}</td><td>前回ＤＳ仮本人確認コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdttshjyhsymd dskrhnnkakcdttshjyhsymd}</td><td>ＤＳ仮本人確認コード通知送付事由発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdttyhkbn dskrhnnkakcdttyhkbn}</td><td>ＤＳ仮本人確認コード通知要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsKrHnnKakCdTtYhKbn}</td></tr>
 *  <tr><td>{@link #getDskrhnnkakcdtttydnjykbn dskrhnnkakcdtttydnjykbn}</td><td>ＤＳ仮本人確認コード通知中断事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsKrHnnKakCdTtTydnJyKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsHonninKakuninCd
 * @see     PKMT_BAK_DsHonninKakuninCd
 * @see     QMT_BAK_DsHonninKakuninCd
 * @see     GenQMT_BAK_DsHonninKakuninCd
 */
@MappedSuperclass
@Table(name=GenMT_BAK_DsHonninKakuninCd.TABLE_NAME)
@IdClass(value=PKMT_BAK_DsHonninKakuninCd.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsKrHnnKakCdSetKbn", typeClass=UserType_C_DsKrHnnKakCdSetKbn.class),
    @TypeDef(name="UserType_C_DsKrHnnKakCdTtTydnJyKbn", typeClass=UserType_C_DsKrHnnKakCdTtTydnJyKbn.class),
    @TypeDef(name="UserType_C_DsKrHnnKakCdTtYhKbn", typeClass=UserType_C_DsKrHnnKakCdTtYhKbn.class)
})
public abstract class GenMT_BAK_DsHonninKakuninCd extends AbstractExDBEntity<MT_BAK_DsHonninKakuninCd, PKMT_BAK_DsHonninKakuninCd> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_BAK_DsHonninKakuninCd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DSKRHNNKAKCD             = "dskrhnnkakcd";
    public static final String DSKRHNNKAKCDSETKBN       = "dskrhnnkakcdsetkbn";
    public static final String DSKRHNNKAKCDSETYMD       = "dskrhnnkakcdsetymd";
    public static final String DSKRHNNKAKCDYUUKOUYMD    = "dskrhnnkakcdyuukouymd";
    public static final String DSHNNKAKCD               = "dshnnkakcd";
    public static final String DSHNNKAKCDSETYMD         = "dshnnkakcdsetymd";
    public static final String ZENKAIDSKRHNNKAKCD       = "zenkaidskrhnnkakcd";
    public static final String DSKRHNNKAKCDTTSHJYHSYMD  = "dskrhnnkakcdttshjyhsymd";
    public static final String DSKRHNNKAKCDTTYHKBN      = "dskrhnnkakcdttyhkbn";
    public static final String DSKRHNNKAKCDTTTYDNJYKBN  = "dskrhnnkakcdtttydnjykbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_BAK_DsHonninKakuninCd primaryKey;

    public GenMT_BAK_DsHonninKakuninCd() {
        primaryKey = new PKMT_BAK_DsHonninKakuninCd();
    }

    public GenMT_BAK_DsHonninKakuninCd(String pDskokno, String pTrkssikibetukey) {
        primaryKey = new PKMT_BAK_DsHonninKakuninCd(pDskokno, pTrkssikibetukey);
    }

    @Transient
    @Override
    public PKMT_BAK_DsHonninKakuninCd getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_BAK_DsHonninKakuninCd> getMetaClass() {
        return QMT_BAK_DsHonninKakuninCd.class;
    }

    @Id
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_BAK_DsHonninKakuninCd.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private String dskrhnnkakcd;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCD)
    public String getDskrhnnkakcd() {
        return dskrhnnkakcd;
    }

    public void setDskrhnnkakcd(String pDskrhnnkakcd) {
        dskrhnnkakcd = pDskrhnnkakcd;
    }

    private C_DsKrHnnKakCdSetKbn dskrhnnkakcdsetkbn;

    @Type(type="UserType_C_DsKrHnnKakCdSetKbn")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDSETKBN)
    public C_DsKrHnnKakCdSetKbn getDskrhnnkakcdsetkbn() {
        return dskrhnnkakcdsetkbn;
    }

    public void setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn pDskrhnnkakcdsetkbn) {
        dskrhnnkakcdsetkbn = pDskrhnnkakcdsetkbn;
    }

    private BizDate dskrhnnkakcdsetymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDSETYMD)
    public BizDate getDskrhnnkakcdsetymd() {
        return dskrhnnkakcdsetymd;
    }

    public void setDskrhnnkakcdsetymd(BizDate pDskrhnnkakcdsetymd) {
        dskrhnnkakcdsetymd = pDskrhnnkakcdsetymd;
    }

    private BizDate dskrhnnkakcdyuukouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDYUUKOUYMD)
    public BizDate getDskrhnnkakcdyuukouymd() {
        return dskrhnnkakcdyuukouymd;
    }

    public void setDskrhnnkakcdyuukouymd(BizDate pDskrhnnkakcdyuukouymd) {
        dskrhnnkakcdyuukouymd = pDskrhnnkakcdyuukouymd;
    }

    private String dshnnkakcd;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSHNNKAKCD)
    public String getDshnnkakcd() {
        return dshnnkakcd;
    }

    public void setDshnnkakcd(String pDshnnkakcd) {
        dshnnkakcd = pDshnnkakcd;
    }

    private BizDate dshnnkakcdsetymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSHNNKAKCDSETYMD)
    public BizDate getDshnnkakcdsetymd() {
        return dshnnkakcdsetymd;
    }

    public void setDshnnkakcdsetymd(BizDate pDshnnkakcdsetymd) {
        dshnnkakcdsetymd = pDshnnkakcdsetymd;
    }

    private String zenkaidskrhnnkakcd;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.ZENKAIDSKRHNNKAKCD)
    public String getZenkaidskrhnnkakcd() {
        return zenkaidskrhnnkakcd;
    }

    public void setZenkaidskrhnnkakcd(String pZenkaidskrhnnkakcd) {
        zenkaidskrhnnkakcd = pZenkaidskrhnnkakcd;
    }

    private BizDate dskrhnnkakcdttshjyhsymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDTTSHJYHSYMD)
    public BizDate getDskrhnnkakcdttshjyhsymd() {
        return dskrhnnkakcdttshjyhsymd;
    }

    public void setDskrhnnkakcdttshjyhsymd(BizDate pDskrhnnkakcdttshjyhsymd) {
        dskrhnnkakcdttshjyhsymd = pDskrhnnkakcdttshjyhsymd;
    }

    private C_DsKrHnnKakCdTtYhKbn dskrhnnkakcdttyhkbn;

    @Type(type="UserType_C_DsKrHnnKakCdTtYhKbn")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDTTYHKBN)
    public C_DsKrHnnKakCdTtYhKbn getDskrhnnkakcdttyhkbn() {
        return dskrhnnkakcdttyhkbn;
    }

    public void setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn) {
        dskrhnnkakcdttyhkbn = pDskrhnnkakcdttyhkbn;
    }

    private C_DsKrHnnKakCdTtTydnJyKbn dskrhnnkakcdtttydnjykbn;

    @Type(type="UserType_C_DsKrHnnKakCdTtTydnJyKbn")
    @Column(name=GenMT_BAK_DsHonninKakuninCd.DSKRHNNKAKCDTTTYDNJYKBN)
    public C_DsKrHnnKakCdTtTydnJyKbn getDskrhnnkakcdtttydnjykbn() {
        return dskrhnnkakcdtttydnjykbn;
    }

    public void setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn pDskrhnnkakcdtttydnjykbn) {
        dskrhnnkakcdtttydnjykbn = pDskrhnnkakcdtttydnjykbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_BAK_DsHonninKakuninCd.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}