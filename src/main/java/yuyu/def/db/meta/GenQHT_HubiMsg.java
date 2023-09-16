package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.type.UserType_C_HubisyubetuKbn;
import yuyu.def.db.type.UserType_C_HubisyubetusyousaiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 不備メッセージテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_HubiMsg extends AbstractExDBTable<HT_HubiMsg> {

    public GenQHT_HubiMsg() {
        this("HT_HubiMsg");
    }

    public GenQHT_HubiMsg(String pAlias) {
        super("HT_HubiMsg", HT_HubiMsg.class, pAlias);
    }

    public String HT_HubiMsg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_HubiMsg, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_HubiMsg, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_HubiMsg, String> messageId = new ExDBFieldString<>("messageId", this);

    public final ExDBFieldString<HT_HubiMsg, String> hubimsg = new ExDBFieldString<>("hubimsg", this);

    public final ExDBFieldString<HT_HubiMsg, C_HubisyubetuKbn> hubisyubetukbn = new ExDBFieldString<>("hubisyubetukbn", this, UserType_C_HubisyubetuKbn.class);

    public final ExDBFieldString<HT_HubiMsg, C_HubisyubetusyousaiKbn> hubisyubetusyousaikbn = new ExDBFieldString<>("hubisyubetusyousaikbn", this, UserType_C_HubisyubetusyousaiKbn.class);

    public final ExDBFieldString<HT_HubiMsg, C_SyoruiCdKbn> hituyousyoruicd = new ExDBFieldString<>("hituyousyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<HT_HubiMsg, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_HubiMsg, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
