package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;

/**
 * 支払帳票メッセージマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SiTyouhyoumsg extends AbstractExDBTable<JM_SiTyouhyoumsg> {

    public GenQJM_SiTyouhyoumsg() {
        this("JM_SiTyouhyoumsg");
    }

    public GenQJM_SiTyouhyoumsg(String pAlias) {
        super("JM_SiTyouhyoumsg", JM_SiTyouhyoumsg.class, pAlias);
    }

    public String JM_SiTyouhyoumsg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SiTyouhyoumsg, String> bunrui1 = new ExDBFieldString<>("bunrui1", this);

    public final ExDBFieldString<JM_SiTyouhyoumsg, String> bunrui2 = new ExDBFieldString<>("bunrui2", this);

    public final ExDBFieldNumber<JM_SiTyouhyoumsg, Integer> tyouhyoulineno = new ExDBFieldNumber<>("tyouhyoulineno", this);

    public final ExDBFieldString<JM_SiTyouhyoumsg, String> setteikasyo = new ExDBFieldString<>("setteikasyo", this);

    public final ExDBFieldString<JM_SiTyouhyoumsg, String> tyouhyoumsg = new ExDBFieldString<>("tyouhyoumsg", this);
}
