package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DrtensikibetuKbn;
import yuyu.def.classification.C_GwdrtensikibetuKbn;
import yuyu.def.classification.C_JimuschemeKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Channel;
import yuyu.def.db.id.PKBM_Channel;
import yuyu.def.db.meta.GenQBM_Channel;
import yuyu.def.db.meta.QBM_Channel;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_DrtensikibetuKbn;
import yuyu.def.db.type.UserType_C_GwdrtensikibetuKbn;
import yuyu.def.db.type.UserType_C_JimuschemeKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * チャネルマスタ テーブルのマッピング情報クラスで、 {@link BM_Channel} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Channel}</td><td colspan="3">チャネルマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_Channel ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getChannelnm channelnm}</td><td>チャネル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimuschemekbn jimuschemekbn}</td><td>事務スキーム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JimuschemeKbn}</td></tr>
 *  <tr><td>{@link #getDrtensikibetukbn drtensikibetukbn}</td><td>代理店識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtensikibetuKbn}</td></tr>
 *  <tr><td>{@link #getGwdrtensikibetukbn gwdrtensikibetukbn}</td><td>ＧＷ代理店識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GwdrtensikibetuKbn}</td></tr>
 *  <tr><td>{@link #getGwsousinsakisikibetusi gwsousinsakisikibetusi}</td><td>ＧＷ送信先識別子</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_Channel
 * @see     PKBM_Channel
 * @see     QBM_Channel
 * @see     GenQBM_Channel
 */
@MappedSuperclass
@Table(name=GenBM_Channel.TABLE_NAME)
@IdClass(value=PKBM_Channel.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_DrtensikibetuKbn", typeClass=UserType_C_DrtensikibetuKbn.class),
    @TypeDef(name="UserType_C_GwdrtensikibetuKbn", typeClass=UserType_C_GwdrtensikibetuKbn.class),
    @TypeDef(name="UserType_C_JimuschemeKbn", typeClass=UserType_C_JimuschemeKbn.class),
    @TypeDef(name="UserType_C_TyhyrenrakusikibetuKbn", typeClass=UserType_C_TyhyrenrakusikibetuKbn.class)
})
public abstract class GenBM_Channel extends AbstractExDBEntity<BM_Channel, PKBM_Channel> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Channel";
    public static final String CHANNELCD                = "channelcd";
    public static final String CHANNELNM                = "channelnm";
    public static final String JIMUSCHEMEKBN            = "jimuschemekbn";
    public static final String DRTENSIKIBETUKBN         = "drtensikibetukbn";
    public static final String GWDRTENSIKIBETUKBN       = "gwdrtensikibetukbn";
    public static final String GWSOUSINSAKISIKIBETUSI   = "gwsousinsakisikibetusi";
    public static final String TYHYRENRAKUSIKIBETUKBN   = "tyhyrenrakusikibetukbn";
    public static final String SORTNO                   = "sortNo";

    private final PKBM_Channel primaryKey;

    public GenBM_Channel() {
        primaryKey = new PKBM_Channel();
    }

    public GenBM_Channel(C_Channelcd pChannelcd) {
        primaryKey = new PKBM_Channel(pChannelcd);
    }

    @Transient
    @Override
    public PKBM_Channel getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Channel> getMetaClass() {
        return QBM_Channel.class;
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_Channel.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    private String channelnm;

    @Column(name=GenBM_Channel.CHANNELNM)
    public String getChannelnm() {
        return channelnm;
    }

    public void setChannelnm(String pChannelnm) {
        channelnm = pChannelnm;
    }

    private C_JimuschemeKbn jimuschemekbn;

    @Type(type="UserType_C_JimuschemeKbn")
    @Column(name=GenBM_Channel.JIMUSCHEMEKBN)
    public C_JimuschemeKbn getJimuschemekbn() {
        return jimuschemekbn;
    }

    public void setJimuschemekbn(C_JimuschemeKbn pJimuschemekbn) {
        jimuschemekbn = pJimuschemekbn;
    }

    private C_DrtensikibetuKbn drtensikibetukbn;

    @Type(type="UserType_C_DrtensikibetuKbn")
    @Column(name=GenBM_Channel.DRTENSIKIBETUKBN)
    public C_DrtensikibetuKbn getDrtensikibetukbn() {
        return drtensikibetukbn;
    }

    public void setDrtensikibetukbn(C_DrtensikibetuKbn pDrtensikibetukbn) {
        drtensikibetukbn = pDrtensikibetukbn;
    }

    private C_GwdrtensikibetuKbn gwdrtensikibetukbn;

    @Type(type="UserType_C_GwdrtensikibetuKbn")
    @Column(name=GenBM_Channel.GWDRTENSIKIBETUKBN)
    public C_GwdrtensikibetuKbn getGwdrtensikibetukbn() {
        return gwdrtensikibetukbn;
    }

    public void setGwdrtensikibetukbn(C_GwdrtensikibetuKbn pGwdrtensikibetukbn) {
        gwdrtensikibetukbn = pGwdrtensikibetukbn;
    }

    private String gwsousinsakisikibetusi;

    @Column(name=GenBM_Channel.GWSOUSINSAKISIKIBETUSI)
    public String getGwsousinsakisikibetusi() {
        return gwsousinsakisikibetusi;
    }

    public void setGwsousinsakisikibetusi(String pGwsousinsakisikibetusi) {
        gwsousinsakisikibetusi = pGwsousinsakisikibetusi;
    }

    private C_TyhyrenrakusikibetuKbn tyhyrenrakusikibetukbn;

    @Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    @Column(name=GenBM_Channel.TYHYRENRAKUSIKIBETUKBN)
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyrenrakusikibetukbn;
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

    private Integer sortNo;

    @Column(name=GenBM_Channel.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }
}
