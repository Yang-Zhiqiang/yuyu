package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.type.UserType_C_AisyoumeiChannelKbn;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * 新契約チャネルマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkChannel extends AbstractExDBTable<HM_SkChannel> {

    public GenQHM_SkChannel() {
        this("HM_SkChannel");
    }

    public GenQHM_SkChannel(String pAlias) {
        super("HM_SkChannel", HM_SkChannel.class, pAlias);
    }

    public String HM_SkChannel() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkChannel, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<HM_SkChannel, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HM_SkChannel, C_AisyoumeiChannelKbn> aisyoumeichannelkbn = new ExDBFieldString<>("aisyoumeichannelkbn", this, UserType_C_AisyoumeiChannelKbn.class);

    public final ExDBFieldString<HM_SkChannel, C_Channelcd> kiteichkchannelcd = new ExDBFieldString<>("kiteichkchannelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<HM_SkChannel, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldString<HM_SkChannel, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldNumber<HM_SkChannel, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);
}
