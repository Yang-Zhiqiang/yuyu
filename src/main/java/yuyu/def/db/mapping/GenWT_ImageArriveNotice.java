package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.db.id.PKWT_ImageArriveNotice;
import yuyu.def.db.meta.GenQWT_ImageArriveNotice;
import yuyu.def.db.meta.QWT_ImageArriveNotice;

/**
 * 到着予定通知情報テーブル テーブルのマッピング情報クラスで、 {@link WT_ImageArriveNotice} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_ImageArriveNotice}</td><td colspan="3">到着予定通知情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getArriveKey arriveKey}</td><td>到着キー</td><td align="center">{@link PKWT_ImageArriveNotice ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKey gyoumuKey}</td><td>業務キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_ImageArriveNotice
 * @see     PKWT_ImageArriveNotice
 * @see     QWT_ImageArriveNotice
 * @see     GenQWT_ImageArriveNotice
 */
@MappedSuperclass
@Table(name=GenWT_ImageArriveNotice.TABLE_NAME)
@IdClass(value=PKWT_ImageArriveNotice.class)
public abstract class GenWT_ImageArriveNotice extends AbstractExDBEntity<WT_ImageArriveNotice, PKWT_ImageArriveNotice> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_ImageArriveNotice";
    public static final String ARRIVEKEY                = "arriveKey";
    public static final String TORIKOMISYORUICD         = "torikomiSyoruiCd";
    public static final String GYOUMUKEY                = "gyoumuKey";
    public static final String FLOWID                   = "flowId";
    public static final String SUBSYSTEMID              = "subSystemId";

    private final PKWT_ImageArriveNotice primaryKey;

    public GenWT_ImageArriveNotice() {
        primaryKey = new PKWT_ImageArriveNotice();
    }

    public GenWT_ImageArriveNotice(String pArriveKey) {
        primaryKey = new PKWT_ImageArriveNotice(pArriveKey);
    }

    @Transient
    @Override
    public PKWT_ImageArriveNotice getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_ImageArriveNotice> getMetaClass() {
        return QWT_ImageArriveNotice.class;
    }

    @Id
    @Column(name=GenWT_ImageArriveNotice.ARRIVEKEY)
    public String getArriveKey() {
        return getPrimaryKey().getArriveKey();
    }

    public void setArriveKey(String pArriveKey) {
        getPrimaryKey().setArriveKey(pArriveKey);
    }

    private String torikomiSyoruiCd;

    @Column(name=GenWT_ImageArriveNotice.TORIKOMISYORUICD)
    public String getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    private String gyoumuKey;

    @Column(name=GenWT_ImageArriveNotice.GYOUMUKEY)
    public String getGyoumuKey() {
        return gyoumuKey;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setGyoumuKey(String pGyoumuKey) {
        gyoumuKey = pGyoumuKey;
    }

    private String flowId;

    @Column(name=GenWT_ImageArriveNotice.FLOWID)
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    private String subSystemId;

    @Column(name=GenWT_ImageArriveNotice.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
}
