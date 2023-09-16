package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.mapping.GenZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFRn;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GentumiSkMikomirituULFRn} の JavaDoc を参照してください。
 * @see     GenZT_GentumiSkMikomirituULFRn
 * @see     PKZT_GentumiSkMikomirituULFRn
 * @see     QZT_GentumiSkMikomirituULFRn
 * @see     GenQZT_GentumiSkMikomirituULFRn
 */
@Entity
public class ZT_GentumiSkMikomirituULFRn extends GenZT_GentumiSkMikomirituULFRn {

    private static final long serialVersionUID = 1L;

    public ZT_GentumiSkMikomirituULFRn() {
    }

    public ZT_GentumiSkMikomirituULFRn(String pZrndatakanrino) {
        super(pZrndatakanrino);
    }

}
