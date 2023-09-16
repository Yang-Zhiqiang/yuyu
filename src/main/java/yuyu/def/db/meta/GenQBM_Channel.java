package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DrtensikibetuKbn;
import yuyu.def.classification.C_GwdrtensikibetuKbn;
import yuyu.def.classification.C_JimuschemeKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Channel;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_DrtensikibetuKbn;
import yuyu.def.db.type.UserType_C_GwdrtensikibetuKbn;
import yuyu.def.db.type.UserType_C_JimuschemeKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * チャネルマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Channel extends AbstractExDBTable<BM_Channel> {

    public GenQBM_Channel() {
        this("BM_Channel");
    }

    public GenQBM_Channel(String pAlias) {
        super("BM_Channel", BM_Channel.class, pAlias);
    }

    public String BM_Channel() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Channel, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_Channel, String> channelnm = new ExDBFieldString<>("channelnm", this);

    public final ExDBFieldString<BM_Channel, C_JimuschemeKbn> jimuschemekbn = new ExDBFieldString<>("jimuschemekbn", this, UserType_C_JimuschemeKbn.class);

    public final ExDBFieldString<BM_Channel, C_DrtensikibetuKbn> drtensikibetukbn = new ExDBFieldString<>("drtensikibetukbn", this, UserType_C_DrtensikibetuKbn.class);

    public final ExDBFieldString<BM_Channel, C_GwdrtensikibetuKbn> gwdrtensikibetukbn = new ExDBFieldString<>("gwdrtensikibetukbn", this, UserType_C_GwdrtensikibetuKbn.class);

    public final ExDBFieldString<BM_Channel, String> gwsousinsakisikibetusi = new ExDBFieldString<>("gwsousinsakisikibetusi", this);

    public final ExDBFieldString<BM_Channel, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldNumber<BM_Channel, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);
}
