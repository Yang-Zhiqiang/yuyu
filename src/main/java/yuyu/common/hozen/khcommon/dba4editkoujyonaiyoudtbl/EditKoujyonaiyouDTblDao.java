package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoudtbl;

import javax.inject.Inject;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QIT_KoujyoSymNaiyouD;

/**
 * 控除証明内容ＤＴＢＬ編集DAOクラス
 */
public class EditKoujyonaiyouDTblDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Integer getEditKoujyonaiyouDMaxRenno3keta(String pSyoNo, String pSyouhnCd) {

        QIT_KoujyoSymNaiyouD qIT_KoujyoSymNaiyouD = new QIT_KoujyoSymNaiyouD("qIT_KoujyoSymNaiyouD");

        String sql = $SELECT + $MAX(qIT_KoujyoSymNaiyouD.renno3keta) +
            $FROM(qIT_KoujyoSymNaiyouD) +
            $WHERE + qIT_KoujyoSymNaiyouD.syono.eq(pSyoNo) +
            $AND + qIT_KoujyoSymNaiyouD.syouhncd.eq(pSyouhnCd);

        return exDBEntityManager.createJPQL(sql).bind(qIT_KoujyoSymNaiyouD).getSingleResult();

    }
}