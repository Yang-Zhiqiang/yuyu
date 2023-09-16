package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.mapping.GenZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.GenQZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFTy;

/**
 * 限積用失効見込率算出用ＵＬＦテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_GentumiSkMikomirituULFTy} の JavaDoc を参照してください。
 * @see     GenZT_GentumiSkMikomirituULFTy
 * @see     PKZT_GentumiSkMikomirituULFTy
 * @see     QZT_GentumiSkMikomirituULFTy
 * @see     GenQZT_GentumiSkMikomirituULFTy
 */
@Entity
public class ZT_GentumiSkMikomirituULFTy extends GenZT_GentumiSkMikomirituULFTy {

    private static final long serialVersionUID = 1L;

    public ZT_GentumiSkMikomirituULFTy() {
    }

    public ZT_GentumiSkMikomirituULFTy(String pZtydatakanrino) {
        super(pZtydatakanrino);
    }

}
