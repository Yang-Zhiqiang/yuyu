package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.db.id.PKIW_CifcdIktHnkWk;
import yuyu.def.db.meta.GenQIW_CifcdIktHnkWk;
import yuyu.def.db.meta.QIW_CifcdIktHnkWk;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＣＩＦコード一括変更ワークテーブル テーブルのマッピング情報クラスで、 {@link IW_CifcdIktHnkWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_CifcdIktHnkWk}</td><td colspan="3">ＣＩＦコード一括変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIW_CifcdIktHnkWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIW_CifcdIktHnkWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_CifcdIktHnkWk
 * @see     PKIW_CifcdIktHnkWk
 * @see     QIW_CifcdIktHnkWk
 * @see     GenQIW_CifcdIktHnkWk
 */
@MappedSuperclass
@Table(name=GenIW_CifcdIktHnkWk.TABLE_NAME)
@IdClass(value=PKIW_CifcdIktHnkWk.class)
public abstract class GenIW_CifcdIktHnkWk extends AbstractExDBEntity<IW_CifcdIktHnkWk, PKIW_CifcdIktHnkWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IW_CifcdIktHnkWk";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String CIFCD                    = "cifcd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIW_CifcdIktHnkWk primaryKey;

    public GenIW_CifcdIktHnkWk() {
        primaryKey = new PKIW_CifcdIktHnkWk();
    }

    public GenIW_CifcdIktHnkWk(String pKbnkey, String pSyono) {
        primaryKey = new PKIW_CifcdIktHnkWk(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIW_CifcdIktHnkWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIW_CifcdIktHnkWk> getMetaClass() {
        return QIW_CifcdIktHnkWk.class;
    }

    @Id
    @Column(name=GenIW_CifcdIktHnkWk.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIW_CifcdIktHnkWk.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String cifcd;

    @Column(name=GenIW_CifcdIktHnkWk.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIW_CifcdIktHnkWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIW_CifcdIktHnkWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIW_CifcdIktHnkWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}