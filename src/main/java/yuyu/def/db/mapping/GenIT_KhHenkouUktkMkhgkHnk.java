package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.id.PKIT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.GenQIT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.meta.QIT_KhHenkouUktkMkhgkHnk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（目標額変更）テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHenkouUktkMkhgkHnk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouUktkMkhgkHnk}</td><td colspan="3">契約保全変更受付内容（目標額変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhHenkouUktkMkhgkHnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhHenkouUktkMkhgkHnk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">{@link PKIT_KhHenkouUktkMkhgkHnk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHenkouUktkMkhgkHnk
 * @see     PKIT_KhHenkouUktkMkhgkHnk
 * @see     QIT_KhHenkouUktkMkhgkHnk
 * @see     GenQIT_KhHenkouUktkMkhgkHnk
 */
@MappedSuperclass
@Table(name=GenIT_KhHenkouUktkMkhgkHnk.TABLE_NAME)
@IdClass(value=PKIT_KhHenkouUktkMkhgkHnk.class)
public abstract class GenIT_KhHenkouUktkMkhgkHnk extends AbstractExDBEntity<IT_KhHenkouUktkMkhgkHnk, PKIT_KhHenkouUktkMkhgkHnk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHenkouUktkMkhgkHnk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HOZENHENKOUUKTKRENNO     = "hozenhenkouuktkrenno";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHenkouUktkMkhgkHnk primaryKey;

    public GenIT_KhHenkouUktkMkhgkHnk() {
        primaryKey = new PKIT_KhHenkouUktkMkhgkHnk();
    }

    public GenIT_KhHenkouUktkMkhgkHnk(
        String pKbnkey,
        String pSyono,
        Integer pHozenhenkouuktkrenno
    ) {
        primaryKey = new PKIT_KhHenkouUktkMkhgkHnk(
            pKbnkey,
            pSyono,
            pHozenhenkouuktkrenno
        );
    }

    @Transient
    @Override
    public PKIT_KhHenkouUktkMkhgkHnk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHenkouUktkMkhgkHnk> getMetaClass() {
        return QIT_KhHenkouUktkMkhgkHnk.class;
    }

    @Id
    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.SYONO)
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
    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.HOZENHENKOUUKTKRENNO)
    public Integer getHozenhenkouuktkrenno() {
        return getPrimaryKey().getHozenhenkouuktkrenno();
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        getPrimaryKey().setHozenhenkouuktkrenno(pHozenhenkouuktkrenno);
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHenkouUktkMkhgkHnk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}