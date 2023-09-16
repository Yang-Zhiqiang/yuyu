package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TuutiJkKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.id.PKBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.type.UserType_C_TuutiJkKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 期日到来本番検証用通知状況テーブル テーブルのマッピング情報クラスで、 {@link BT_KijituTuriHnbnKnsouTutJk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTuriHnbnKnsouTutJk}</td><td colspan="3">期日到来本番検証用通知状況テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKBT_KijituTuriHnbnKnsouTutJk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">{@link PKBT_KijituTuriHnbnKnsouTutJk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNikaimeikoutuutiyouhi nikaimeikoutuutiyouhi}</td><td>２回目以降通知要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getTuutijkkbn tuutijkkbn}</td><td>通知状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TuutiJkKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTuriHnbnKnsouTutJk
 * @see     PKBT_KijituTuriHnbnKnsouTutJk
 * @see     QBT_KijituTuriHnbnKnsouTutJk
 * @see     GenQBT_KijituTuriHnbnKnsouTutJk
 */
@MappedSuperclass
@Table(name=GenBT_KijituTuriHnbnKnsouTutJk.TABLE_NAME)
@IdClass(value=PKBT_KijituTuriHnbnKnsouTutJk.class)
@TypeDefs({
    @TypeDef(name="UserType_C_TuutiJkKbn", typeClass=UserType_C_TuutiJkKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenBT_KijituTuriHnbnKnsouTutJk extends AbstractExDBEntity<BT_KijituTuriHnbnKnsouTutJk, PKBT_KijituTuriHnbnKnsouTutJk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KijituTuriHnbnKnsouTutJk";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String TYSYTNO                  = "tysytno";
    public static final String NIKAIMEIKOUTUUTIYOUHI    = "nikaimeikoutuutiyouhi";
    public static final String TUUTIJKKBN               = "tuutijkkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_KijituTuriHnbnKnsouTutJk primaryKey;

    public GenBT_KijituTuriHnbnKnsouTutJk() {
        primaryKey = new PKBT_KijituTuriHnbnKnsouTutJk();
    }

    public GenBT_KijituTuriHnbnKnsouTutJk(String pSubSystemId, Integer pTysytno) {
        primaryKey = new PKBT_KijituTuriHnbnKnsouTutJk(pSubSystemId, pTysytno);
    }

    @Transient
    @Override
    public PKBT_KijituTuriHnbnKnsouTutJk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KijituTuriHnbnKnsouTutJk> getMetaClass() {
        return QBT_KijituTuriHnbnKnsouTutJk.class;
    }

    @Id
    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.TYSYTNO)
    public Integer getTysytno() {
        return getPrimaryKey().getTysytno();
    }

    public void setTysytno(Integer pTysytno) {
        getPrimaryKey().setTysytno(pTysytno);
    }

    private C_YouhiKbn nikaimeikoutuutiyouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.NIKAIMEIKOUTUUTIYOUHI)
    public C_YouhiKbn getNikaimeikoutuutiyouhi() {
        return nikaimeikoutuutiyouhi;
    }

    public void setNikaimeikoutuutiyouhi(C_YouhiKbn pNikaimeikoutuutiyouhi) {
        nikaimeikoutuutiyouhi = pNikaimeikoutuutiyouhi;
    }

    private C_TuutiJkKbn tuutijkkbn;

    @Type(type="UserType_C_TuutiJkKbn")
    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.TUUTIJKKBN)
    public C_TuutiJkKbn getTuutijkkbn() {
        return tuutijkkbn;
    }

    public void setTuutijkkbn(C_TuutiJkKbn pTuutijkkbn) {
        tuutijkkbn = pTuutijkkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_KijituTuriHnbnKnsouTutJk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}