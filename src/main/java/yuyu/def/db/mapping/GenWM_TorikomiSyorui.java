package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AngoukaHousikiKbn;
import yuyu.def.classification.C_KouteiSeigyoUmuKbn;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.WM_TorikomiSyorui;
import yuyu.def.db.id.PKWM_TorikomiSyorui;
import yuyu.def.db.meta.GenQWM_TorikomiSyorui;
import yuyu.def.db.meta.QWM_TorikomiSyorui;
import yuyu.def.db.type.UserType_C_AngoukaHousikiKbn;
import yuyu.def.db.type.UserType_C_KouteiSeigyoUmuKbn;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * 取込書類マスタ テーブルのマッピング情報クラスで、 {@link WM_TorikomiSyorui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link WM_TorikomiSyorui}</td><td colspan="3">取込書類マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTorikomiSyoruiCd torikomiSyoruiCd}</td><td>取込書類コード</td><td align="center">{@link PKWM_TorikomiSyorui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSyoruiNm torikomiSyoruiNm}</td><td>取込書類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTorikomiSyoruiRyaku torikomiSyoruiRyaku}</td><td>取込書類略称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyzkDaiBunruiId syzkDaiBunruiId}</td><td>所属大分類ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyzkSyouBunruiId syzkSyouBunruiId}</td><td>所属小分類ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAngoukaKbn angoukaKbn}</td><td>暗号化区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getAngoukaHousikiKbn angoukaHousikiKbn}</td><td>暗号化方式区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AngoukaHousikiKbn}</td></tr>
 *  <tr><td>{@link #getZipHozonKbn zipHozonKbn}</td><td>ＺＩＰ保存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 *  <tr><td>{@link #getKouteiSeigyoUmuKbn kouteiSeigyoUmuKbn}</td><td>工程制御有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouteiSeigyoUmuKbn}</td></tr>
 *  <tr><td>{@link #getFlowId flowId}</td><td>フローＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNodeId nodeId}</td><td>ノードＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     WM_TorikomiSyorui
 * @see     PKWM_TorikomiSyorui
 * @see     QWM_TorikomiSyorui
 * @see     GenQWM_TorikomiSyorui
 */
@MappedSuperclass
@Table(name=GenWM_TorikomiSyorui.TABLE_NAME)
@IdClass(value=PKWM_TorikomiSyorui.class)
@TypeDefs({
    @TypeDef(name="UserType_C_AngoukaHousikiKbn", typeClass=UserType_C_AngoukaHousikiKbn.class),
    @TypeDef(name="UserType_C_KouteiSeigyoUmuKbn", typeClass=UserType_C_KouteiSeigyoUmuKbn.class),
    @TypeDef(name="UserType_C_YesNoKbn", typeClass=UserType_C_YesNoKbn.class)
})
public abstract class GenWM_TorikomiSyorui extends AbstractExDBEntity<WM_TorikomiSyorui, PKWM_TorikomiSyorui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "WM_TorikomiSyorui";
    public static final String TORIKOMISYORUICD         = "torikomiSyoruiCd";
    public static final String TORIKOMISYORUINM         = "torikomiSyoruiNm";
    public static final String TORIKOMISYORUIRYAKU      = "torikomiSyoruiRyaku";
    public static final String SYZKDAIBUNRUIID          = "syzkDaiBunruiId";
    public static final String SYZKSYOUBUNRUIID         = "syzkSyouBunruiId";
    public static final String ANGOUKAKBN               = "angoukaKbn";
    public static final String ANGOUKAHOUSIKIKBN        = "angoukaHousikiKbn";
    public static final String ZIPHOZONKBN              = "zipHozonKbn";
    public static final String KOUTEISEIGYOUMUKBN       = "kouteiSeigyoUmuKbn";
    public static final String FLOWID                   = "flowId";
    public static final String NODEID                   = "nodeId";

    private final PKWM_TorikomiSyorui primaryKey;

    public GenWM_TorikomiSyorui() {
        primaryKey = new PKWM_TorikomiSyorui();
    }

    public GenWM_TorikomiSyorui(String pTorikomiSyoruiCd) {
        primaryKey = new PKWM_TorikomiSyorui(pTorikomiSyoruiCd);
    }

    @Transient
    @Override
    public PKWM_TorikomiSyorui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QWM_TorikomiSyorui> getMetaClass() {
        return QWM_TorikomiSyorui.class;
    }

    @Id
    @Column(name=GenWM_TorikomiSyorui.TORIKOMISYORUICD)
    public String getTorikomiSyoruiCd() {
        return getPrimaryKey().getTorikomiSyoruiCd();
    }

    public void setTorikomiSyoruiCd(String pTorikomiSyoruiCd) {
        getPrimaryKey().setTorikomiSyoruiCd(pTorikomiSyoruiCd);
    }

    private String torikomiSyoruiNm;

    @Column(name=GenWM_TorikomiSyorui.TORIKOMISYORUINM)
    public String getTorikomiSyoruiNm() {
        return torikomiSyoruiNm;
    }

    public void setTorikomiSyoruiNm(String pTorikomiSyoruiNm) {
        torikomiSyoruiNm = pTorikomiSyoruiNm;
    }

    private String torikomiSyoruiRyaku;

    @Column(name=GenWM_TorikomiSyorui.TORIKOMISYORUIRYAKU)
    public String getTorikomiSyoruiRyaku() {
        return torikomiSyoruiRyaku;
    }

    public void setTorikomiSyoruiRyaku(String pTorikomiSyoruiRyaku) {
        torikomiSyoruiRyaku = pTorikomiSyoruiRyaku;
    }

    private String syzkDaiBunruiId;

    @Column(name=GenWM_TorikomiSyorui.SYZKDAIBUNRUIID)
    public String getSyzkDaiBunruiId() {
        return syzkDaiBunruiId;
    }

    public void setSyzkDaiBunruiId(String pSyzkDaiBunruiId) {
        syzkDaiBunruiId = pSyzkDaiBunruiId;
    }

    private String syzkSyouBunruiId;

    @Column(name=GenWM_TorikomiSyorui.SYZKSYOUBUNRUIID)
    public String getSyzkSyouBunruiId() {
        return syzkSyouBunruiId;
    }

    public void setSyzkSyouBunruiId(String pSyzkSyouBunruiId) {
        syzkSyouBunruiId = pSyzkSyouBunruiId;
    }

    private C_YesNoKbn angoukaKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenWM_TorikomiSyorui.ANGOUKAKBN)
    public C_YesNoKbn getAngoukaKbn() {
        return angoukaKbn;
    }

    public void setAngoukaKbn(C_YesNoKbn pAngoukaKbn) {
        angoukaKbn = pAngoukaKbn;
    }

    private C_AngoukaHousikiKbn angoukaHousikiKbn;

    @Type(type="UserType_C_AngoukaHousikiKbn")
    @Column(name=GenWM_TorikomiSyorui.ANGOUKAHOUSIKIKBN)
    public C_AngoukaHousikiKbn getAngoukaHousikiKbn() {
        return angoukaHousikiKbn;
    }

    public void setAngoukaHousikiKbn(C_AngoukaHousikiKbn pAngoukaHousikiKbn) {
        angoukaHousikiKbn = pAngoukaHousikiKbn;
    }

    private C_YesNoKbn zipHozonKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenWM_TorikomiSyorui.ZIPHOZONKBN)
    public C_YesNoKbn getZipHozonKbn() {
        return zipHozonKbn;
    }

    public void setZipHozonKbn(C_YesNoKbn pZipHozonKbn) {
        zipHozonKbn = pZipHozonKbn;
    }

    private C_KouteiSeigyoUmuKbn kouteiSeigyoUmuKbn;

    @Type(type="UserType_C_KouteiSeigyoUmuKbn")
    @Column(name=GenWM_TorikomiSyorui.KOUTEISEIGYOUMUKBN)
    public C_KouteiSeigyoUmuKbn getKouteiSeigyoUmuKbn() {
        return kouteiSeigyoUmuKbn;
    }

    public void setKouteiSeigyoUmuKbn(C_KouteiSeigyoUmuKbn pKouteiSeigyoUmuKbn) {
        kouteiSeigyoUmuKbn = pKouteiSeigyoUmuKbn;
    }

    private String flowId;

    @Column(name=GenWM_TorikomiSyorui.FLOWID)
    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String pFlowId) {
        flowId = pFlowId;
    }

    private String nodeId;

    @Column(name=GenWM_TorikomiSyorui.NODEID)
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String pNodeId) {
        nodeId = pNodeId;
    }
}