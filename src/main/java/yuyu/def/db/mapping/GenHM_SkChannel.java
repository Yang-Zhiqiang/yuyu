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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.id.PKHM_SkChannel;
import yuyu.def.db.meta.GenQHM_SkChannel;
import yuyu.def.db.meta.QHM_SkChannel;
import yuyu.def.db.type.UserType_C_AisyoumeiChannelKbn;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * 新契約チャネルマスタ テーブルのマッピング情報クラスで、 {@link HM_SkChannel} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkChannel}</td><td colspan="3">新契約チャネルマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKHM_SkChannel ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">{@link PKHM_SkChannel ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisyoumeichannelkbn aisyoumeichannelkbn}</td><td>愛称名チャネル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiChannelKbn}</td></tr>
 *  <tr><td>{@link #getKiteichkchannelcd kiteichkchannelcd}</td><td>規定チェック用チャネルコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_SkChannel
 * @see     PKHM_SkChannel
 * @see     QHM_SkChannel
 * @see     GenQHM_SkChannel
 */
@MappedSuperclass
@Table(name=GenHM_SkChannel.TABLE_NAME)
@IdClass(value=PKHM_SkChannel.class)
@TypeDefs({
    @TypeDef(name="UserType_C_AisyoumeiChannelKbn", typeClass=UserType_C_AisyoumeiChannelKbn.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_TyhyrenrakusikibetuKbn", typeClass=UserType_C_TyhyrenrakusikibetuKbn.class)
})
public abstract class GenHM_SkChannel extends AbstractExDBEntity<HM_SkChannel, PKHM_SkChannel> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SkChannel";
    public static final String CHANNELCD                = "channelcd";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String AISYOUMEICHANNELKBN      = "aisyoumeichannelkbn";
    public static final String KITEICHKCHANNELCD        = "kiteichkchannelcd";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String TYHYRENRAKUSIKIBETUKBN   = "tyhyrenrakusikibetukbn";
    public static final String SORTNO                   = "sortNo";

    private final PKHM_SkChannel primaryKey;

    public GenHM_SkChannel() {
        primaryKey = new PKHM_SkChannel();
    }

    public GenHM_SkChannel(C_Channelcd pChannelcd, String pOyadrtencd) {
        primaryKey = new PKHM_SkChannel(pChannelcd, pOyadrtencd);
    }

    @Transient
    @Override
    public PKHM_SkChannel getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SkChannel> getMetaClass() {
        return QHM_SkChannel.class;
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenHM_SkChannel.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Column(name=GenHM_SkChannel.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return getPrimaryKey().getOyadrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        getPrimaryKey().setOyadrtencd(pOyadrtencd);
    }

    private C_AisyoumeiChannelKbn aisyoumeichannelkbn;

    @Type(type="UserType_C_AisyoumeiChannelKbn")
    @Column(name=GenHM_SkChannel.AISYOUMEICHANNELKBN)
    public C_AisyoumeiChannelKbn getAisyoumeichannelkbn() {
        return aisyoumeichannelkbn;
    }

    public void setAisyoumeichannelkbn(C_AisyoumeiChannelKbn pAisyoumeichannelkbn) {
        aisyoumeichannelkbn = pAisyoumeichannelkbn;
    }

    private C_Channelcd kiteichkchannelcd;

    @Type(type="UserType_C_Channelcd")
    @Column(name=GenHM_SkChannel.KITEICHKCHANNELCD)
    public C_Channelcd getKiteichkchannelcd() {
        return kiteichkchannelcd;
    }

    public void setKiteichkchannelcd(C_Channelcd pKiteichkchannelcd) {
        kiteichkchannelcd = pKiteichkchannelcd;
    }

    private C_SkeijimuKbn skeijimukbn;

    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenHM_SkChannel.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_TyhyrenrakusikibetuKbn tyhyrenrakusikibetukbn;

    @Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    @Column(name=GenHM_SkChannel.TYHYRENRAKUSIKIBETUKBN)
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyrenrakusikibetukbn;
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

    private Integer sortNo;

    @Column(name=GenHM_SkChannel.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }
}