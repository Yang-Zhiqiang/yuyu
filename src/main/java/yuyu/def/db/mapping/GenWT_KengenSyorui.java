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
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.db.id.PKWT_KengenSyorui;
import yuyu.def.db.meta.GenQWT_KengenSyorui;
import yuyu.def.db.meta.QWT_KengenSyorui;

/**
 * 権限明細（書類）テーブル テーブルのマッピング情報クラスで、 {@link WT_KengenSyorui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KengenSyorui}</td><td colspan="3">権限明細（書類）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKWT_KengenSyorui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">{@link PKWT_KengenSyorui ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KengenSyorui
 * @see     PKWT_KengenSyorui
 * @see     QWT_KengenSyorui
 * @see     GenQWT_KengenSyorui
 */
@MappedSuperclass
@Table(name=GenWT_KengenSyorui.TABLE_NAME)
@IdClass(value=PKWT_KengenSyorui.class)
public abstract class GenWT_KengenSyorui extends AbstractExDBEntity<WT_KengenSyorui, PKWT_KengenSyorui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_KengenSyorui";
    public static final String ROLECD                   = "roleCd";
    public static final String TORIKOMISYORUICD         = "torikomiSyoruiCd";

    private final PKWT_KengenSyorui primaryKey;

    public GenWT_KengenSyorui() {
        primaryKey = new PKWT_KengenSyorui();
    }

    public GenWT_KengenSyorui(String pRoleCd, String pTorikomiSyoruiCd) {
        primaryKey = new PKWT_KengenSyorui(pRoleCd, pTorikomiSyoruiCd);
    }

    @Transient
    @Override
    public PKWT_KengenSyorui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_KengenSyorui> getMetaClass() {
        return QWT_KengenSyorui.class;
    }

    @Id
    @Column(name=GenWT_KengenSyorui.ROLECD)
    @MaxLength(max=30)
    @AlphaDigit
    public String getRoleCd() {
        return getPrimaryKey().getRoleCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRoleCd(String pRoleCd) {
        getPrimaryKey().setRoleCd(pRoleCd);
    }

    @Id
    @Column(name=GenWT_KengenSyorui.TORIKOMISYORUICD)
    public String getTorikomiSyoruiCd() {
        return getPrimaryKey().getTorikomiSyoruiCd();
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        getPrimaryKey().setTorikomiSyoruiCd(pTorikomiSyoruiCd);
    }
}
