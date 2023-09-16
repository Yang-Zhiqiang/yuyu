package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_SueokikknsmnKbn;

/**
 * 据置期間チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSueokiKikan extends AbstractExDBTable<BM_ChkSueokiKikan> {

    public GenQBM_ChkSueokiKikan() {
        this("BM_ChkSueokiKikan");
    }

    public GenQBM_ChkSueokiKikan(String pAlias) {
        super("BM_ChkSueokiKikan", BM_ChkSueokiKikan.class, pAlias);
    }

    public String BM_ChkSueokiKikan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSueokiKikan, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_ChkSueokiKikan, Integer> syusyouhnsdnofrom = new ExDBFieldNumber<>("syusyouhnsdnofrom", this);

    public final ExDBFieldNumber<BM_ChkSueokiKikan, Integer> syusyouhnsdnoto = new ExDBFieldNumber<>("syusyouhnsdnoto", this);

    public final ExDBFieldString<BM_ChkSueokiKikan, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldNumber<BM_ChkSueokiKikan, Integer> sueokikkn = new ExDBFieldNumber<>("sueokikkn", this);

    public final ExDBFieldString<BM_ChkSueokiKikan, C_SueokikknsmnKbn> sueokikknsmnkbn = new ExDBFieldString<>("sueokikknsmnkbn", this, UserType_C_SueokikknsmnKbn.class);
}
