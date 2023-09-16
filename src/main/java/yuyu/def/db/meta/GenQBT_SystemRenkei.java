package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.def.db.type.UserType_C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.db.type.UserType_C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.type.UserType_C_SystemRenkeiSyoriHousikiKbn;

/**
 * システム間連携制御テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SystemRenkei extends AbstractExDBTable<BT_SystemRenkei> {

    public GenQBT_SystemRenkei() {
        this("BT_SystemRenkei");
    }

    public GenQBT_SystemRenkei(String pAlias) {
        super("BT_SystemRenkei", BT_SystemRenkei.class, pAlias);
    }

    public String BT_SystemRenkei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SystemRenkei, String> interfaceid = new ExDBFieldString<>("interfaceid", this);

    public final ExDBFieldString<BT_SystemRenkei, C_SystemRenkeiSyoriHousikiKbn> syorihousiki = new ExDBFieldString<>("syorihousiki", this, UserType_C_SystemRenkeiSyoriHousikiKbn.class);

    public final ExDBFieldString<BT_SystemRenkei, C_SystemRenkeiHenkanHoukouKbn> henkanhoukou = new ExDBFieldString<>("henkanhoukou", this, UserType_C_SystemRenkeiHenkanHoukouKbn.class);

    public final ExDBFieldString<BT_SystemRenkei, String> henkanmaelayoutid = new ExDBFieldString<>("henkanmaelayoutid", this);

    public final ExDBFieldString<BT_SystemRenkei, String> henkanmaelayoutname = new ExDBFieldString<>("henkanmaelayoutname", this);

    public final ExDBFieldString<BT_SystemRenkei, String> henkangolayoutid = new ExDBFieldString<>("henkangolayoutid", this);

    public final ExDBFieldString<BT_SystemRenkei, String> henkangolayoutname = new ExDBFieldString<>("henkangolayoutname", this);

    public final ExDBFieldString<BT_SystemRenkei, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BT_SystemRenkei, String> renkeifiledirectory = new ExDBFieldString<>("renkeifiledirectory", this);

    public final ExDBFieldString<BT_SystemRenkei, String> renkeifilenm = new ExDBFieldString<>("renkeifilenm", this);

    public final ExDBFieldString<BT_SystemRenkei, C_SystemRenkeiFileSyubetuKbn> renkeifiletype = new ExDBFieldString<>("renkeifiletype", this, UserType_C_SystemRenkeiFileSyubetuKbn.class);
}
