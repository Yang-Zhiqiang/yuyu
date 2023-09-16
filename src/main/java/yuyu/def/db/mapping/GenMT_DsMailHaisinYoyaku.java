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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsHaisinYoyakuStatusKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.id.PKMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.GenQMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;
import yuyu.def.db.type.UserType_C_DsHaisinYoyakuStatusKbn;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信予約テーブル テーブルのマッピング情報クラスで、 {@link MT_DsMailHaisinYoyaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisinYoyaku}</td><td colspan="3">ＤＳメール配信予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsmailhaisinyoyakuskbtkey dsmailhaisinyoyakuskbtkey}</td><td>ＤＳメール配信予約識別キー</td><td align="center">{@link PKMT_DsMailHaisinYoyaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailhaisinyoteiymd dsmailhaisinyoteiymd}</td><td>ＤＳメール配信（予定）日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getDshaisinyoyakustatuskbn dshaisinyoyakustatuskbn}</td><td>ＤＳ配信予約ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsHaisinYoyakuStatusKbn}</td></tr>
 *  <tr><td>{@link #getDsmailhaisintourokuymd dsmailhaisintourokuymd}</td><td>ＤＳメール配信登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsmailhaisinsyouninymd dsmailhaisinsyouninymd}</td><td>ＤＳメール配信承認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsmailhaisintourokusyaid dsmailhaisintourokusyaid}</td><td>ＤＳメール配信登録者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailhaisinsyouninsyaid dsmailhaisinsyouninsyaid}</td><td>ＤＳメール配信承認者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisinYoyaku
 * @see     PKMT_DsMailHaisinYoyaku
 * @see     QMT_DsMailHaisinYoyaku
 * @see     GenQMT_DsMailHaisinYoyaku
 */
@MappedSuperclass
@Table(name=GenMT_DsMailHaisinYoyaku.TABLE_NAME)
@IdClass(value=PKMT_DsMailHaisinYoyaku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsHaisinYoyakuStatusKbn", typeClass=UserType_C_DsHaisinYoyakuStatusKbn.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMT_DsMailHaisinYoyaku extends AbstractExDBEntity<MT_DsMailHaisinYoyaku, PKMT_DsMailHaisinYoyaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsMailHaisinYoyaku";
    public static final String DSMAILHAISINYOYAKUSKBTKEY = "dsmailhaisinyoyakuskbtkey";
    public static final String DSMAILHAISINYOTEIYMD     = "dsmailhaisinyoteiymd";
    public static final String DSSOUSINMAILSYUBETUKBN   = "dssousinmailsyubetukbn";
    public static final String DSHAISINYOYAKUSTATUSKBN  = "dshaisinyoyakustatuskbn";
    public static final String DSMAILHAISINTOUROKUYMD   = "dsmailhaisintourokuymd";
    public static final String DSMAILHAISINSYOUNINYMD   = "dsmailhaisinsyouninymd";
    public static final String DSMAILHAISINTOUROKUSYAID = "dsmailhaisintourokusyaid";
    public static final String DSMAILHAISINSYOUNINSYAID = "dsmailhaisinsyouninsyaid";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsMailHaisinYoyaku primaryKey;

    public GenMT_DsMailHaisinYoyaku() {
        primaryKey = new PKMT_DsMailHaisinYoyaku();
    }

    public GenMT_DsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {
        primaryKey = new PKMT_DsMailHaisinYoyaku(pDsmailhaisinyoyakuskbtkey);
    }

    @Transient
    @Override
    public PKMT_DsMailHaisinYoyaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsMailHaisinYoyaku> getMetaClass() {
        return QMT_DsMailHaisinYoyaku.class;
    }

    @Id
    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINYOYAKUSKBTKEY)
    public String getDsmailhaisinyoyakuskbtkey() {
        return getPrimaryKey().getDsmailhaisinyoyakuskbtkey();
    }

    public void setDsmailhaisinyoyakuskbtkey(String pDsmailhaisinyoyakuskbtkey) {
        getPrimaryKey().setDsmailhaisinyoyakuskbtkey(pDsmailhaisinyoyakuskbtkey);
    }

    private BizDate dsmailhaisinyoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINYOTEIYMD)
    @ValidDate
    public BizDate getDsmailhaisinyoteiymd() {
        return dsmailhaisinyoteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailhaisinyoteiymd(BizDate pDsmailhaisinyoteiymd) {
        dsmailhaisinyoteiymd = pDsmailhaisinyoteiymd;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMT_DsMailHaisinYoyaku.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    private C_DsHaisinYoyakuStatusKbn dshaisinyoyakustatuskbn;

    @Type(type="UserType_C_DsHaisinYoyakuStatusKbn")
    @Column(name=GenMT_DsMailHaisinYoyaku.DSHAISINYOYAKUSTATUSKBN)
    public C_DsHaisinYoyakuStatusKbn getDshaisinyoyakustatuskbn() {
        return dshaisinyoyakustatuskbn;
    }

    public void setDshaisinyoyakustatuskbn(C_DsHaisinYoyakuStatusKbn pDshaisinyoyakustatuskbn) {
        dshaisinyoyakustatuskbn = pDshaisinyoyakustatuskbn;
    }

    private BizDate dsmailhaisintourokuymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINTOUROKUYMD)
    public BizDate getDsmailhaisintourokuymd() {
        return dsmailhaisintourokuymd;
    }

    public void setDsmailhaisintourokuymd(BizDate pDsmailhaisintourokuymd) {
        dsmailhaisintourokuymd = pDsmailhaisintourokuymd;
    }

    private BizDate dsmailhaisinsyouninymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINSYOUNINYMD)
    public BizDate getDsmailhaisinsyouninymd() {
        return dsmailhaisinsyouninymd;
    }

    public void setDsmailhaisinsyouninymd(BizDate pDsmailhaisinsyouninymd) {
        dsmailhaisinsyouninymd = pDsmailhaisinsyouninymd;
    }

    private String dsmailhaisintourokusyaid;

    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINTOUROKUSYAID)
    public String getDsmailhaisintourokusyaid() {
        return dsmailhaisintourokusyaid;
    }

    public void setDsmailhaisintourokusyaid(String pDsmailhaisintourokusyaid) {
        dsmailhaisintourokusyaid = pDsmailhaisintourokusyaid;
    }

    private String dsmailhaisinsyouninsyaid;

    @Column(name=GenMT_DsMailHaisinYoyaku.DSMAILHAISINSYOUNINSYAID)
    public String getDsmailhaisinsyouninsyaid() {
        return dsmailhaisinsyouninsyaid;
    }

    public void setDsmailhaisinsyouninsyaid(String pDsmailhaisinsyouninsyaid) {
        dsmailhaisinsyouninsyaid = pDsmailhaisinsyouninsyaid;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsMailHaisinYoyaku.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsMailHaisinYoyaku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsMailHaisinYoyaku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}