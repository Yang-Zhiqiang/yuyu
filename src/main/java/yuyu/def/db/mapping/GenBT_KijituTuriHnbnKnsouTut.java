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
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.id.PKBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.GenQBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTut;

/**
 * 期日到来本番検証用通知テーブル テーブルのマッピング情報クラスで、 {@link BT_KijituTuriHnbnKnsouTut} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTuriHnbnKnsouTut}</td><td colspan="3">期日到来本番検証用通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_KijituTuriHnbnKnsouTut ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKBT_KijituTuriHnbnKnsouTut ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">{@link PKBT_KijituTuriHnbnKnsouTut ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTuriHnbnKnsouTut
 * @see     PKBT_KijituTuriHnbnKnsouTut
 * @see     QBT_KijituTuriHnbnKnsouTut
 * @see     GenQBT_KijituTuriHnbnKnsouTut
 */
@MappedSuperclass
@Table(name=GenBT_KijituTuriHnbnKnsouTut.TABLE_NAME)
@IdClass(value=PKBT_KijituTuriHnbnKnsouTut.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBT_KijituTuriHnbnKnsouTut extends AbstractExDBEntity<BT_KijituTuriHnbnKnsouTut, PKBT_KijituTuriHnbnKnsouTut> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_KijituTuriHnbnKnsouTut";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String TYSYTNO                  = "tysytno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_KijituTuriHnbnKnsouTut primaryKey;

    public GenBT_KijituTuriHnbnKnsouTut() {
        primaryKey = new PKBT_KijituTuriHnbnKnsouTut();
    }

    public GenBT_KijituTuriHnbnKnsouTut(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno
    ) {
        primaryKey = new PKBT_KijituTuriHnbnKnsouTut(
            pSyoriYmd,
            pSubSystemId,
            pTysytno
        );
    }

    @Transient
    @Override
    public PKBT_KijituTuriHnbnKnsouTut getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_KijituTuriHnbnKnsouTut> getMetaClass() {
        return QBT_KijituTuriHnbnKnsouTut.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_KijituTuriHnbnKnsouTut.SYORIYMD)
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
    @Column(name=GenBT_KijituTuriHnbnKnsouTut.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    @Id
    @Column(name=GenBT_KijituTuriHnbnKnsouTut.TYSYTNO)
    public Integer getTysytno() {
        return getPrimaryKey().getTysytno();
    }

    public void setTysytno(Integer pTysytno) {
        getPrimaryKey().setTysytno(pTysytno);
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_KijituTuriHnbnKnsouTut.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_KijituTuriHnbnKnsouTut.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_KijituTuriHnbnKnsouTut.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}