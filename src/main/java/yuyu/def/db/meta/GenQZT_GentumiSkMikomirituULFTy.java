package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_GentumiSkMikomirituULFTy extends AbstractExDBTable<ZT_GentumiSkMikomirituULFTy> {

    public GenQZT_GentumiSkMikomirituULFTy() {
        this("ZT_GentumiSkMikomirituULFTy");
    }

    public GenQZT_GentumiSkMikomirituULFTy(String pAlias) {
        super("ZT_GentumiSkMikomirituULFTy", ZT_GentumiSkMikomirituULFTy.class, pAlias);
    }

    public String ZT_GentumiSkMikomirituULFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFTy, String> ztykhsyoumetujiyuu = new ExDBFieldString<>("ztykhsyoumetujiyuu", this);

    public final ExDBFieldString<ZT_GentumiSkMikomirituULFTy, String> ztysymtymd = new ExDBFieldString<>("ztysymtymd", this);
}
