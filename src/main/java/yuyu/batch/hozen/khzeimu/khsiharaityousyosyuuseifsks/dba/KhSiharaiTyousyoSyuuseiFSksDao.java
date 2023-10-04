package yuyu.batch.hozen.khzeimu.khsiharaityousyosyuuseifsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_DSeisanShrTysySyusei;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 新契約 契約保全支払調書修正Ｆ作成機能DAOクラスです。
 */
public class KhSiharaiTyousyoSyuuseiFSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSiharaiTyousyoSyuuseiFSksBean> getDSeisanShrTysySyuseiBySyoriYmd(
        String pKakutyouJobCd,
        BizDate pSyoriYmd) {

        QIT_DSeisanShrTysySyusei qIT_DSeisanShrTysySyusei  = new QIT_DSeisanShrTysySyusei ("qIT_DSeisanShrTysySyusei ");

        String strSql = $SELECT + $NEW( KhSiharaiTyousyoSyuuseiFSksBean.class,
            qIT_DSeisanShrTysySyusei.kbnkey,
            qIT_DSeisanShrTysySyusei.syono,
            qIT_DSeisanShrTysySyusei.syoriYmd,
            qIT_DSeisanShrTysySyusei.seisandshrymd,
            qIT_DSeisanShrTysySyusei.seisand.getTypeFieldName(),
            qIT_DSeisanShrTysySyusei.seisand.getValueFieldName(),
            qIT_DSeisanShrTysySyusei.tyouseid.getTypeFieldName(),
            qIT_DSeisanShrTysySyusei.tyouseid.getValueFieldName()) +
            $FROM (qIT_DSeisanShrTysySyusei) +
            $WHERE + qIT_DSeisanShrTysySyusei.syoriYmd.eq(pSyoriYmd);

        ExDBResults<KhSiharaiTyousyoSyuuseiFSksBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhSiharaiTyousyoSyuuseiFSksBean.class).bind(
            qIT_DSeisanShrTysySyusei).getResults();
        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobCd));

        return exDBResults;

    }

}