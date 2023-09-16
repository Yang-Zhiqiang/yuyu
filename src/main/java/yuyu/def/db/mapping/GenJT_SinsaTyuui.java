package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.db.id.PKJT_SinsaTyuui;
import yuyu.def.db.meta.GenQJT_SinsaTyuui;
import yuyu.def.db.meta.QJT_SinsaTyuui;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 審査注意テーブル テーブルのマッピング情報クラスで、 {@link JT_SinsaTyuui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SinsaTyuui}</td><td colspan="3">審査注意テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SinsaTyuui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinsatyuui sinsatyuui}</td><td>審査注意</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSosikinm sosikinm}</td><td>組織名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SinsaTyuui
 * @see     PKJT_SinsaTyuui
 * @see     QJT_SinsaTyuui
 * @see     GenQJT_SinsaTyuui
 */
@MappedSuperclass
@Table(name=GenJT_SinsaTyuui.TABLE_NAME)
@IdClass(value=PKJT_SinsaTyuui.class)
public abstract class GenJT_SinsaTyuui extends AbstractExDBEntity<JT_SinsaTyuui, PKJT_SinsaTyuui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SinsaTyuui";
    public static final String SYONO                    = "syono";
    public static final String SINSATYUUI               = "sinsatyuui";
    public static final String SOSIKINM                 = "sosikinm";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SinsaTyuui primaryKey;

    public GenJT_SinsaTyuui() {
        primaryKey = new PKJT_SinsaTyuui();
    }

    public GenJT_SinsaTyuui(String pSyono) {
        primaryKey = new PKJT_SinsaTyuui(pSyono);
    }

    @Transient
    @Override
    public PKJT_SinsaTyuui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SinsaTyuui> getMetaClass() {
        return QJT_SinsaTyuui.class;
    }

    @Id
    @Column(name=GenJT_SinsaTyuui.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String sinsatyuui;

    @Column(name=GenJT_SinsaTyuui.SINSATYUUI)
    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getSinsatyuui() {
        return sinsatyuui;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSinsatyuui(String pSinsatyuui) {
        sinsatyuui = pSinsatyuui;
    }

    private String sosikinm;

    @Column(name=GenJT_SinsaTyuui.SOSIKINM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSosikinm() {
        return sosikinm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSosikinm(String pSosikinm) {
        sosikinm = pSosikinm;
    }

    private String kossyoricd;

    @Column(name=GenJT_SinsaTyuui.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SinsaTyuui.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SinsaTyuui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SinsaTyuui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}