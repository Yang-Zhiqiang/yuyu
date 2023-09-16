package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.WM_TorikomiSyouBunrui;
import yuyu.def.db.id.PKWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.GenQWM_TorikomiSyouBunrui;
import yuyu.def.db.meta.QWM_TorikomiSyouBunrui;

/**
 * 取込書類小分類マスタ テーブルのマッピング情報クラスで、 {@link WM_TorikomiSyouBunrui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiSyouBunrui}</td><td colspan="3">取込書類小分類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyzkSyouBunruiId syzkSyouBunruiId}</td><td>所属小分類ＩＤ</td><td align="center">{@link PKWM_TorikomiSyouBunrui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyzkSyouBunruiNm syzkSyouBunruiNm}</td><td>所属小分類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyzkDaiBunruiId syzkDaiBunruiId}</td><td>所属大分類ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiSyouBunrui
 * @see     PKWM_TorikomiSyouBunrui
 * @see     QWM_TorikomiSyouBunrui
 * @see     GenQWM_TorikomiSyouBunrui
 */
@MappedSuperclass
@Table(name=GenWM_TorikomiSyouBunrui.TABLE_NAME)
@IdClass(value=PKWM_TorikomiSyouBunrui.class)
public abstract class GenWM_TorikomiSyouBunrui extends AbstractExDBEntity<WM_TorikomiSyouBunrui, PKWM_TorikomiSyouBunrui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WM_TorikomiSyouBunrui";
    public static final String SYZKSYOUBUNRUIID         = "syzkSyouBunruiId";
    public static final String SYZKSYOUBUNRUINM         = "syzkSyouBunruiNm";
    public static final String SYZKDAIBUNRUIID          = "syzkDaiBunruiId";

    private final PKWM_TorikomiSyouBunrui primaryKey;

    public GenWM_TorikomiSyouBunrui() {
        primaryKey = new PKWM_TorikomiSyouBunrui();
    }

    public GenWM_TorikomiSyouBunrui(String pSyzkSyouBunruiId) {
        primaryKey = new PKWM_TorikomiSyouBunrui(pSyzkSyouBunruiId);
    }

    @Transient
    @Override
    public PKWM_TorikomiSyouBunrui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWM_TorikomiSyouBunrui> getMetaClass() {
        return QWM_TorikomiSyouBunrui.class;
    }

    @Id
    @Column(name=GenWM_TorikomiSyouBunrui.SYZKSYOUBUNRUIID)
    public String getSyzkSyouBunruiId() {
        return getPrimaryKey().getSyzkSyouBunruiId();
    }

    public void setSyzkSyouBunruiId(String pSyzkSyouBunruiId) {
        getPrimaryKey().setSyzkSyouBunruiId(pSyzkSyouBunruiId);
    }

    private String syzkSyouBunruiNm;

    @Column(name=GenWM_TorikomiSyouBunrui.SYZKSYOUBUNRUINM)
    public String getSyzkSyouBunruiNm() {
        return syzkSyouBunruiNm;
    }

    public void setSyzkSyouBunruiNm(String pSyzkSyouBunruiNm) {
        syzkSyouBunruiNm = pSyzkSyouBunruiNm;
    }

    private String syzkDaiBunruiId;

    @Column(name=GenWM_TorikomiSyouBunrui.SYZKDAIBUNRUIID)
    public String getSyzkDaiBunruiId() {
        return syzkDaiBunruiId;
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }
}
