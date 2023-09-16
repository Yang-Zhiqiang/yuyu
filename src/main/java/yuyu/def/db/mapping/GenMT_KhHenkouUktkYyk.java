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
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.id.PKMT_KhHenkouUktkYyk;
import yuyu.def.db.meta.GenQMT_KhHenkouUktkYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;
import yuyu.def.db.type.UserType_C_TourokuRouteKbn;
import yuyu.def.db.type.UserType_C_UktkJyoutaiKbn;
import yuyu.def.db.type.UserType_C_UktkSyoriKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付予約テーブル テーブルのマッピング情報クラスで、 {@link MT_KhHenkouUktkYyk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_KhHenkouUktkYyk}</td><td colspan="3">契約保全変更受付予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKMT_KhHenkouUktkYyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_KhHenkouUktkYyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">{@link PKMT_KhHenkouUktkYyk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktkymd uktkymd}</td><td>受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTourokuroute tourokuroute}</td><td>登録ルート</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TourokuRouteKbn}</td></tr>
 *  <tr><td>{@link #getUktksyorikbn uktksyorikbn}</td><td>受付処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkSyoriKbn}</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriyoteiymd syoriyoteiymd}</td><td>処理予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUktkjyoutaikbn uktkjyoutaikbn}</td><td>受付状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktkJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_KhHenkouUktkYyk
 * @see     PKMT_KhHenkouUktkYyk
 * @see     QMT_KhHenkouUktkYyk
 * @see     GenQMT_KhHenkouUktkYyk
 */
@MappedSuperclass
@Table(name=GenMT_KhHenkouUktkYyk.TABLE_NAME)
@IdClass(value=PKMT_KhHenkouUktkYyk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_TourokuRouteKbn", typeClass=UserType_C_TourokuRouteKbn.class),
    @TypeDef(name="UserType_C_UktkJyoutaiKbn", typeClass=UserType_C_UktkJyoutaiKbn.class),
    @TypeDef(name="UserType_C_UktkSyoriKbn", typeClass=UserType_C_UktkSyoriKbn.class)
})
public abstract class GenMT_KhHenkouUktkYyk extends AbstractExDBEntity<MT_KhHenkouUktkYyk, PKMT_KhHenkouUktkYyk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_KhHenkouUktkYyk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HOZENHENKOUUKTKRENNO     = "hozenhenkouuktkrenno";
    public static final String UKTKYMD                  = "uktkymd";
    public static final String TOUROKUROUTE             = "tourokuroute";
    public static final String UKTKSYORIKBN             = "uktksyorikbn";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String SYORIYOTEIYMD            = "syoriyoteiymd";
    public static final String UKTKJYOUTAIKBN           = "uktkjyoutaikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_KhHenkouUktkYyk primaryKey;

    public GenMT_KhHenkouUktkYyk() {
        primaryKey = new PKMT_KhHenkouUktkYyk();
    }

    public GenMT_KhHenkouUktkYyk(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
    ) {
        primaryKey = new PKMT_KhHenkouUktkYyk(
            pKbnkey,
            pSyono,
            pHozenhenkouuktkrenno
        );
    }

    @Transient
    @Override
    public PKMT_KhHenkouUktkYyk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_KhHenkouUktkYyk> getMetaClass() {
        return QMT_KhHenkouUktkYyk.class;
    }

    @Id
    @Column(name=GenMT_KhHenkouUktkYyk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenMT_KhHenkouUktkYyk.SYONO)
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
    @Column(name=GenMT_KhHenkouUktkYyk.HOZENHENKOUUKTKRENNO)
    public Integer getHozenhenkouuktkrenno() {
        return getPrimaryKey().getHozenhenkouuktkrenno();
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        getPrimaryKey().setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
    }

    private BizDate uktkymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_KhHenkouUktkYyk.UKTKYMD)
    public BizDate getUktkymd() {
        return uktkymd;
    }

    public void setUktkymd(BizDate pUktkymd) {
        uktkymd = pUktkymd;
    }

    private C_TourokuRouteKbn tourokuroute;

    @Type(type="UserType_C_TourokuRouteKbn")
    @Column(name=GenMT_KhHenkouUktkYyk.TOUROKUROUTE)
    public C_TourokuRouteKbn getTourokuroute() {
        return tourokuroute;
    }

    public void setTourokuroute(C_TourokuRouteKbn pTourokuroute) {
        tourokuroute = pTourokuroute;
    }

    private C_UktkSyoriKbn uktksyorikbn;

    @Type(type="UserType_C_UktkSyoriKbn")
    @Column(name=GenMT_KhHenkouUktkYyk.UKTKSYORIKBN)
    public C_UktkSyoriKbn getUktksyorikbn() {
        return uktksyorikbn;
    }

    public void setUktksyorikbn(C_UktkSyoriKbn pUktksyorikbn) {
        uktksyorikbn = pUktksyorikbn;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_KhHenkouUktkYyk.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate syoriyoteiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_KhHenkouUktkYyk.SYORIYOTEIYMD)
    public BizDate getSyoriyoteiymd() {
        return syoriyoteiymd;
    }

    public void setSyoriyoteiymd(BizDate pSyoriyoteiymd) {
        syoriyoteiymd = pSyoriyoteiymd;
    }

    private C_UktkJyoutaiKbn uktkjyoutaikbn;

    @Type(type="UserType_C_UktkJyoutaiKbn")
    @Column(name=GenMT_KhHenkouUktkYyk.UKTKJYOUTAIKBN)
    public C_UktkJyoutaiKbn getUktkjyoutaikbn() {
        return uktkjyoutaikbn;
    }

    public void setUktkjyoutaikbn(C_UktkJyoutaiKbn pUktkjyoutaikbn) {
        uktkjyoutaikbn = pUktkjyoutaikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_KhHenkouUktkYyk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_KhHenkouUktkYyk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_KhHenkouUktkYyk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}