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
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.id.PKWT_KengenKoutei;
import yuyu.def.db.meta.GenQWT_KengenKoutei;
import yuyu.def.db.meta.QWT_KengenKoutei;

/**
 * 権限明細（工程）テーブル テーブルのマッピング情報クラスで、 {@link WT_KengenKoutei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WT_KengenKoutei}</td><td colspan="3">権限明細（工程）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRoleCd roleCd}</td><td>ロールコード</td><td align="center">{@link PKWT_KengenKoutei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">{@link PKWT_KengenKoutei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeId nodeId}</td><td>ノードＩＤ</td><td align="center">{@link PKWT_KengenKoutei ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WT_KengenKoutei
 * @see     PKWT_KengenKoutei
 * @see     QWT_KengenKoutei
 * @see     GenQWT_KengenKoutei
 */
@MappedSuperclass
@Table(name=GenWT_KengenKoutei.TABLE_NAME)
@IdClass(value=PKWT_KengenKoutei.class)
public abstract class GenWT_KengenKoutei extends AbstractExDBEntity<WT_KengenKoutei, PKWT_KengenKoutei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WT_KengenKoutei";
    public static final String ROLECD                   = "roleCd";
    public static final String FLOWID                   = "flowId";
    public static final String NODEID                   = "nodeId";

    private final PKWT_KengenKoutei primaryKey;

    public GenWT_KengenKoutei() {
        primaryKey = new PKWT_KengenKoutei();
    }

    public GenWT_KengenKoutei(
        String pRoleCd,
        String pFlowId,
        String pNodeId
    ) {
        primaryKey = new PKWT_KengenKoutei(
            pRoleCd,
            pFlowId,
            pNodeId
        );
    }

    @Transient
    @Override
    public PKWT_KengenKoutei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWT_KengenKoutei> getMetaClass() {
        return QWT_KengenKoutei.class;
    }

    @Id
    @Column(name=GenWT_KengenKoutei.ROLECD)
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
    @Column(name=GenWT_KengenKoutei.FLOWID)
    public String getFlowId() {
        return getPrimaryKey().getFlowId();
    }

    public void setFlowId(String pFlowId) {
        getPrimaryKey().setFlowId(pFlowId);
    }

    @Id
    @Column(name=GenWT_KengenKoutei.NODEID)
    public String getNodeId() {
        return getPrimaryKey().getNodeId();
    }

    public void setNodeId(String pNodeId) {
        getPrimaryKey().setNodeId(pNodeId);
    }
}
