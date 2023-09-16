package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.WM_TorikomiDaiBunrui;
import yuyu.def.db.id.PKWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiDaiBunrui;
import yuyu.def.db.meta.QWM_TorikomiDaiBunrui;

/**
 * 取込書類大分類マスタ テーブルのマッピング情報クラスで、 {@link WM_TorikomiDaiBunrui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiDaiBunrui}</td><td colspan="3">取込書類大分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyzkDaiBunruiId syzkDaiBunruiId}</td><td>所属大分類ＩＤ</td><td align="center">{@link PKWM_TorikomiDaiBunrui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyzkDaiBunruiNm syzkDaiBunruiNm}</td><td>所属大分類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiDaiBunrui
 * @see     PKWM_TorikomiDaiBunrui
 * @see     QWM_TorikomiDaiBunrui
 * @see     GenQWM_TorikomiDaiBunrui
 */
@MappedSuperclass
@Table(name=GenWM_TorikomiDaiBunrui.TABLE_NAME)
@IdClass(value=PKWM_TorikomiDaiBunrui.class)
public abstract class GenWM_TorikomiDaiBunrui extends AbstractExDBEntity<WM_TorikomiDaiBunrui, PKWM_TorikomiDaiBunrui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WM_TorikomiDaiBunrui";
    public static final String SYZKDAIBUNRUIID          = "syzkDaiBunruiId";
    public static final String SYZKDAIBUNRUINM          = "syzkDaiBunruiNm";

    private final PKWM_TorikomiDaiBunrui primaryKey;

    public GenWM_TorikomiDaiBunrui() {
        primaryKey = new PKWM_TorikomiDaiBunrui();
    }

    public GenWM_TorikomiDaiBunrui(String pSyzkDaiBunruiId) {
        primaryKey = new PKWM_TorikomiDaiBunrui(pSyzkDaiBunruiId);
    }

    @Transient
    @Override
    public PKWM_TorikomiDaiBunrui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWM_TorikomiDaiBunrui> getMetaClass() {
        return QWM_TorikomiDaiBunrui.class;
    }

    @Id
    @Column(name=GenWM_TorikomiDaiBunrui.SYZKDAIBUNRUIID)
    public String getSyzkDaiBunruiId() {
        return getPrimaryKey().getSyzkDaiBunruiId();
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        getPrimaryKey().setSyzkDaiBunruiId(pSyzkDaiBunruiId);
    }

    private String syzkDaiBunruiNm;

    @Column(name=GenWM_TorikomiDaiBunrui.SYZKDAIBUNRUINM)
    public String getSyzkDaiBunruiNm() {
        return syzkDaiBunruiNm;
    }

    public void setSyzkDaiBunruiNm(String pSyzkDaiBunruiNm) {
        syzkDaiBunruiNm = pSyzkDaiBunruiNm;
    }
}
