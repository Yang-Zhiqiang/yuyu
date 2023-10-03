package yuyu.batch.suuri.srsuuritoukei.srdshrtoukeiloading;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QST_DshrTukiTyukeiyouItzHzn;

/**
 * Ｄ支払統計ローディング情報作成のDAOクラス
 */
public class SrDshrToukeiLoadingDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<StDshrTukiTyukeiyouItzHznBean> getSrDshrToukeiLoadingInfo() {

        QST_DshrTukiTyukeiyouItzHzn qST_DshrTukiTyukeiyouItzHzn = new QST_DshrTukiTyukeiyouItzHzn(
            "qST_DshrTukiTyukeiyouItzHzn");

        String queryStr = $SELECT + $NEW(StDshrTukiTyukeiyouItzHznBean.class,
            qST_DshrTukiTyukeiyouItzHzn.ztydshrym,
            qST_DshrTukiTyukeiyouItzHzn.ztykeiyakunendo,
            qST_DshrTukiTyukeiyouItzHzn.ztyannaikigetu,
            qST_DshrTukiTyukeiyouItzHzn.ztyhknsyruikbn,
            qST_DshrTukiTyukeiyouItzHzn.ztysegcd,
            qST_DshrTukiTyukeiyouItzHzn.ztyshrriyuukbn,
            qST_DshrTukiTyukeiyouItzHzn.ztyannaikbn,
            qST_DshrTukiTyukeiyouItzHzn.ztyduketorihouhoukbn,
            qST_DshrTukiTyukeiyouItzHzn.ztysyoumetukbn,
            qST_DshrTukiTyukeiyouItzHzn.ztybikinhyj,
            qST_DshrTukiTyukeiyouItzHzn.ztyskskbn,
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztysrkensuu) +                 $AS + "ztysrkensuu",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztysrhsys) +                   $AS + "ztysrhsys",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztytoujigyounendod) +          $AS + "ztytoujigyounendod",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztytoujigyounendohasseidrsk) + $AS + "ztytoujigyounendohasseidrsk",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztyzenjigyounendomatudzndk) +  $AS + "ztyzenjigyounendomatudzndk",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztyyokujigyounendod) +         $AS + "ztyyokujigyounendod",
            $SUM + $(qST_DshrTukiTyukeiyouItzHzn.ztyhushrtoujigyounendod) +     $AS + "ztyhushrtoujigyounendod") +

            $FROM (qST_DshrTukiTyukeiyouItzHzn) +
            $GROUP_BY + qST_DshrTukiTyukeiyouItzHzn.ztydshrym + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztykeiyakunendo + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyannaikigetu + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyhknsyruikbn + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztysegcd + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyshrriyuukbn + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyannaikbn + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyduketorihouhoukbn + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztysyoumetukbn + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztybikinhyj + "," +
            qST_DshrTukiTyukeiyouItzHzn.ztyskskbn +

            $ORDER_BY(qST_DshrTukiTyukeiyouItzHzn.ztydshrym.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztykeiyakunendo.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyannaikigetu.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyhknsyruikbn.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztysegcd.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyshrriyuukbn.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyannaikbn.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyduketorihouhoukbn.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztysyoumetukbn.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztybikinhyj.asc(),
                qST_DshrTukiTyukeiyouItzHzn.ztyskskbn.asc()
                );

        return exDBEntityManager.createJPQL(queryStr, StDshrTukiTyukeiyouItzHznBean.class)
            .bind(qST_DshrTukiTyukeiyouItzHzn).getResults();
    }
}
