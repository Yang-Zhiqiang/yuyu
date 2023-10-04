package yuyu.batch.hozen.khinterf.khseihowebidouitirantyusyutu;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.db.meta.QIT_SeihowebIdouRireki;

/**
 * 生保Ｗｅｂ異動一覧抽出Daoクラスです。
 */
public class KhSeihoWebIdouItiranTyusyutuDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<IT_SeihowebIdouRireki> getKhSeihowebIdouRirekisByKakutyoujobcdSyoriYmd(String pKakutyoujobcd,BizDateYM pKijunym){

        QIT_SeihowebIdouRireki qIT_SeihowebIdouRireki = new QIT_SeihowebIdouRireki("q1");

        String strSql = $SELECT + qIT_SeihowebIdouRireki +
            $FROM + qIT_SeihowebIdouRireki.IT_SeihowebIdouRireki() +
            $WHERE + qIT_SeihowebIdouRireki.idouhasseiym.eq(pKijunym) +
            $ORDER_BY(qIT_SeihowebIdouRireki.syono.asc(),
                qIT_SeihowebIdouRireki.idouhasseiymd.asc(),
                qIT_SeihowebIdouRireki.henkousikibetukey.desc());

        ExDBResults<IT_SeihowebIdouRireki> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIT_SeihowebIdouRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}

