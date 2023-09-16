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
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.id.PKIT_KhLincKihon;
import yuyu.def.db.meta.GenQIT_KhLincKihon;
import yuyu.def.db.meta.QIT_KhLincKihon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全ＬＩＮＣ基本テーブル テーブルのマッピング情報クラスで、 {@link IT_KhLincKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhLincKihon}</td><td colspan="3">契約保全ＬＩＮＣ基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhLincKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhLincKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLinckanyuusyano linckanyuusyano}</td><td>ＬＩＮＣ＿加入者番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhLincKihon
 * @see     PKIT_KhLincKihon
 * @see     QIT_KhLincKihon
 * @see     GenQIT_KhLincKihon
 */
@MappedSuperclass
@Table(name=GenIT_KhLincKihon.TABLE_NAME)
@IdClass(value=PKIT_KhLincKihon.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenIT_KhLincKihon extends AbstractExDBEntity<IT_KhLincKihon, PKIT_KhLincKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhLincKihon";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String KYKYMD                   = "kykymd";
    public static final String LINCKANYUUSYANO          = "linckanyuusyano";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhLincKihon primaryKey;

    public GenIT_KhLincKihon() {
        primaryKey = new PKIT_KhLincKihon();
    }

    public GenIT_KhLincKihon(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_KhLincKihon(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_KhLincKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhLincKihon> getMetaClass() {
        return QIT_KhLincKihon.class;
    }

    @Id
    @Column(name=GenIT_KhLincKihon.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhLincKihon.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KhLincKihon.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private Long linckanyuusyano;

    @Column(name=GenIT_KhLincKihon.LINCKANYUUSYANO)
    public Long getLinckanyuusyano() {
        return linckanyuusyano;
    }

    public void setLinckanyuusyano(Long pLinckanyuusyano) {
        linckanyuusyano = pLinckanyuusyano;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhLincKihon.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhLincKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhLincKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}