package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_Channel;
import yuyu.def.db.mapping.GenBM_Channel;
import yuyu.def.db.meta.GenQBM_Channel;
import yuyu.def.db.meta.QBM_Channel;

/**
 * チャネルマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Channel}</td><td colspan="3">チャネルマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>channelnm</td><td>チャネル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimuschemekbn</td><td>事務スキーム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JimuschemeKbn C_JimuschemeKbn}</td></tr>
 *  <tr><td>drtensikibetukbn</td><td>代理店識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtensikibetuKbn C_DrtensikibetuKbn}</td></tr>
 *  <tr><td>gwdrtensikibetukbn</td><td>ＧＷ代理店識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GwdrtensikibetuKbn C_GwdrtensikibetuKbn}</td></tr>
 *  <tr><td>gwsousinsakisikibetusi</td><td>ＧＷ送信先識別子</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyhyrenrakusikibetukbn</td><td>帳票連絡先識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhyrenrakusikibetuKbn C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_Channel
 * @see     GenBM_Channel
 * @see     QBM_Channel
 * @see     GenQBM_Channel
 */
public class PKBM_Channel extends AbstractExDBPrimaryKey<BM_Channel, PKBM_Channel> {

    private static final long serialVersionUID = 1L;

    public PKBM_Channel() {
    }

    public PKBM_Channel(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }

    @Transient
    @Override
    public Class<BM_Channel> getEntityClass() {
        return BM_Channel.class;
    }

    private C_Channelcd channelcd;

    @org.hibernate.annotations.Type(type="UserType_C_Channelcd")
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }

}