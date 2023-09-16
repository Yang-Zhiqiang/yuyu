package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.id.PKIT_KoujyoSymKanri;
import yuyu.def.db.meta.GenQIT_KoujyoSymKanri;
import yuyu.def.db.meta.QIT_KoujyoSymKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明書管理テーブル テーブルのマッピング情報クラスで、 {@link IT_KoujyoSymKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSymKanri}</td><td colspan="3">控除証明書管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KoujyoSymKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KoujyoSymKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNendo nendo}</td><td>年度</td><td align="center">{@link PKIT_KoujyoSymKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getLastsyoumeiendym lastsyoumeiendym}</td><td>最終証明終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KoujyoSymKanri
 * @see     PKIT_KoujyoSymKanri
 * @see     QIT_KoujyoSymKanri
 * @see     GenQIT_KoujyoSymKanri
 */
@MappedSuperclass
@Table(name=GenIT_KoujyoSymKanri.TABLE_NAME)
@IdClass(value=PKIT_KoujyoSymKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class)
})
public abstract class GenIT_KoujyoSymKanri extends AbstractExDBEntity<IT_KoujyoSymKanri, PKIT_KoujyoSymKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KoujyoSymKanri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String NENDO                    = "nendo";
    public static final String LASTSYOUMEIENDYM         = "lastsyoumeiendym";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KoujyoSymKanri primaryKey;

    public GenIT_KoujyoSymKanri() {
        primaryKey = new PKIT_KoujyoSymKanri();
    }

    public GenIT_KoujyoSymKanri(
        String pKbnkey,
        String pSyono,
        String pNendo
    ) {
        primaryKey = new PKIT_KoujyoSymKanri(
            pKbnkey,
            pSyono,
            pNendo
        );
    }

    @Transient
    @Override
    public PKIT_KoujyoSymKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KoujyoSymKanri> getMetaClass() {
        return QIT_KoujyoSymKanri.class;
    }

    @Id
    @Column(name=GenIT_KoujyoSymKanri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KoujyoSymKanri.SYONO)
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
    @Column(name=GenIT_KoujyoSymKanri.NENDO)
    public String getNendo() {
        return getPrimaryKey().getNendo();
    }

    public void setNendo(String pNendo) {
        getPrimaryKey().setNendo(pNendo);
    }

    private BizDateYM lastsyoumeiendym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KoujyoSymKanri.LASTSYOUMEIENDYM)
    public BizDateYM getLastsyoumeiendym() {
        return lastsyoumeiendym;
    }

    @Trim("both")
    public void setLastsyoumeiendym(BizDateYM pLastsyoumeiendym) {
        lastsyoumeiendym = pLastsyoumeiendym;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KoujyoSymKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KoujyoSymKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KoujyoSymKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}