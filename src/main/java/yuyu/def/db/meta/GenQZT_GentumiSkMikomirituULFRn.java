package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFRn;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GentumiSkMikomirituULFRn extends AbstractExDBTable<ZT_GentumiSkMikomirituULFRn> {

    public GenQZT_GentumiSkMikomirituULFRn() {
        this("ZT_GentumiSkMikomirituULFRn");
    }

    public GenQZT_GentumiSkMikomirituULFRn(String pAlias) {
        super("ZT_GentumiSkMikomirituULFRn", ZT_GentumiSkMikomirituULFRn.class, pAlias);
    }

    public String ZT_GentumiSkMikomirituULFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFRn, String> zrnkhsyoumetujiyuu = new ExDBFieldString<>("zrnkhsyoumetujiyuu", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);
}
