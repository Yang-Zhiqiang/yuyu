package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.IM_KhHituyouSyorui;
import yuyu.def.db.id.PKIM_KhHituyouSyorui;
import yuyu.def.db.meta.GenQIM_KhHituyouSyorui;
import yuyu.def.db.meta.QIM_KhHituyouSyorui;

/**
 * 契約保全必要書類マスタ テーブルのマッピング情報クラスで、 {@link IM_KhHituyouSyorui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhHituyouSyorui}</td><td colspan="3">契約保全必要書類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKIM_KhHituyouSyorui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHanteikbn1 hanteikbn1}</td><td>判定区分１</td><td align="center">{@link PKIM_KhHituyouSyorui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHanteikbn2 hanteikbn2}</td><td>判定区分２</td><td align="center">{@link PKIM_KhHituyouSyorui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHanteikbn3 hanteikbn3}</td><td>判定区分３</td><td align="center">{@link PKIM_KhHituyouSyorui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHtysrirenno htysrirenno}</td><td>必要書類連番</td><td align="center">{@link PKIM_KhHituyouSyorui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHtysyorui htysyorui}</td><td>必要書類メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhHituyouSyorui
 * @see     PKIM_KhHituyouSyorui
 * @see     QIM_KhHituyouSyorui
 * @see     GenQIM_KhHituyouSyorui
 */
@MappedSuperclass
@Table(name=GenIM_KhHituyouSyorui.TABLE_NAME)
@IdClass(value=PKIM_KhHituyouSyorui.class)
public abstract class GenIM_KhHituyouSyorui extends AbstractExDBEntity<IM_KhHituyouSyorui, PKIM_KhHituyouSyorui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_KhHituyouSyorui";
    public static final String KINOUID                  = "kinouId";
    public static final String HANTEIKBN1               = "hanteikbn1";
    public static final String HANTEIKBN2               = "hanteikbn2";
    public static final String HANTEIKBN3               = "hanteikbn3";
    public static final String HTYSRIRENNO              = "htysrirenno";
    public static final String HTYSYORUI                = "htysyorui";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_KhHituyouSyorui primaryKey;

    public GenIM_KhHituyouSyorui() {
        primaryKey = new PKIM_KhHituyouSyorui();
    }

    public GenIM_KhHituyouSyorui(
        String pKinouId,
        Integer pHanteikbn1,
        Integer pHanteikbn2,
        Integer pHanteikbn3,
        Integer pHtysrirenno
    ) {
        primaryKey = new PKIM_KhHituyouSyorui(
            pKinouId,
            pHanteikbn1,
            pHanteikbn2,
            pHanteikbn3,
            pHtysrirenno
        );
    }

    @Transient
    @Override
    public PKIM_KhHituyouSyorui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_KhHituyouSyorui> getMetaClass() {
        return QIM_KhHituyouSyorui.class;
    }

    @Id
    @Column(name=GenIM_KhHituyouSyorui.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenIM_KhHituyouSyorui.HANTEIKBN1)
    public Integer getHanteikbn1() {
        return getPrimaryKey().getHanteikbn1();
    }

    public void setHanteikbn1(Integer pHanteikbn1) {
        getPrimaryKey().setHanteikbn1(pHanteikbn1);
    }

    @Id
    @Column(name=GenIM_KhHituyouSyorui.HANTEIKBN2)
    public Integer getHanteikbn2() {
        return getPrimaryKey().getHanteikbn2();
    }

    public void setHanteikbn2(Integer pHanteikbn2) {
        getPrimaryKey().setHanteikbn2(pHanteikbn2);
    }

    @Id
    @Column(name=GenIM_KhHituyouSyorui.HANTEIKBN3)
    public Integer getHanteikbn3() {
        return getPrimaryKey().getHanteikbn3();
    }

    public void setHanteikbn3(Integer pHanteikbn3) {
        getPrimaryKey().setHanteikbn3(pHanteikbn3);
    }

    @Id
    @Column(name=GenIM_KhHituyouSyorui.HTYSRIRENNO)
    public Integer getHtysrirenno() {
        return getPrimaryKey().getHtysrirenno();
    }

    public void setHtysrirenno(Integer pHtysrirenno) {
        getPrimaryKey().setHtysrirenno(pHtysrirenno);
    }

    private String htysyorui;

    @Column(name=GenIM_KhHituyouSyorui.HTYSYORUI)
    public String getHtysyorui() {
        return htysyorui;
    }

    public void setHtysyorui(String pHtysyorui) {
        htysyorui = pHtysyorui;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_KhHituyouSyorui.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_KhHituyouSyorui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_KhHituyouSyorui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
