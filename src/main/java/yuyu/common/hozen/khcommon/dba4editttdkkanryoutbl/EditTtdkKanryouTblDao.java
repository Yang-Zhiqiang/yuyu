package yuyu.common.hozen.khcommon.dba4editttdkkanryoutbl;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.meta.QIT_Kariukekin;

/**
 * 契約保全 契約保全共通 手続完了TBL編集Daoクラス
 */
public class EditTtdkKanryouTblDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Integer getKhSeisansumiKariukekinCountBySyonoKrkno(String pSyono, Integer pKrkno) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String sql = $SELECT + qIT_Kariukekin +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono) +
            $AND + qIT_Kariukekin.krkno.eq(pKrkno) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.eq(C_Krkseisanzumiflg.SUMI) +
            $AND + (qIT_Kariukekin.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KAIYAKU) +
                $OR  + qIT_Kariukekin.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU)) ;

        List<QIT_Kariukekin> kariukekinList = exDBEntityManager.createJPQL(sql).bind(qIT_Kariukekin).getResultList();

        return kariukekinList.size();
    }

}
