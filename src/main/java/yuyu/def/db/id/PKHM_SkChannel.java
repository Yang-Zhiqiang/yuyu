package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.mapping.GenHM_SkChannel;
import yuyu.def.db.meta.GenQHM_SkChannel;
import yuyu.def.db.meta.QHM_SkChannel;

/**
 * 新契約チャネルマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SkChannel}</td><td colspan="3">新契約チャネルマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisyoumeichannelkbn</td><td>愛称名チャネル区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiChannelKbn C_AisyoumeiChannelKbn}</td></tr>
 *  <tr><td>kiteichkchannelcd</td><td>規定チェック用チャネルコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Channelcd C_Channelcd}</td></tr>
 *  <tr><td>skeijimukbn</td><td>新契約事務区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkeijimuKbn C_SkeijimuKbn}</td></tr>
 *  <tr><td>tyhyrenrakusikibetukbn</td><td>帳票連絡先識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhyrenrakusikibetuKbn C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_SkChannel
 * @see     GenHM_SkChannel
 * @see     QHM_SkChannel
 * @see     GenQHM_SkChannel
 */
public class PKHM_SkChannel extends AbstractExDBPrimaryKey<HM_SkChannel, PKHM_SkChannel> {

    private static final long serialVersionUID = 1L;

    public PKHM_SkChannel() {
    }

    public PKHM_SkChannel(C_Channelcd pChannelcd, String pOyadrtencd) {
        channelcd = pChannelcd;
        oyadrtencd = pOyadrtencd;
    }

    @Transient
    @Override
    public Class<HM_SkChannel> getEntityClass() {
        return HM_SkChannel.class;
    }

    private C_Channelcd channelcd;

    @org.hibernate.annotations.Type(type="UserType_C_Channelcd")
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

}