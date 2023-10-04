package yuyu.batch.sinkeiyaku.skkessan.skiktnknkwsseklistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HT_GrossNykn;
import yuyu.def.db.meta.QHT_GrossNykn;

/**
 * 新契約 決算 一括入金為替差益リスト作成の機能DAOクラスです。
 */
public class SkIktNknKwsSekListSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_GrossNykn> getGrossNyukinInfoBySyoriYmd(BizDate pNyksyoriYmd) {

        QHT_GrossNykn qHT_GrossNykn = new QHT_GrossNykn("qHT_GrossNykn");

        String strSql = $SELECT + qHT_GrossNykn +
            $FROM(qHT_GrossNykn) +
            $WHERE + qHT_GrossNykn.nyksyoriymd.eq(pNyksyoriYmd) +
             $ORDER_BY(qHT_GrossNykn.hrktuukasyu.desc(),
               qHT_GrossNykn.ryosyuymd.asc(),
               qHT_GrossNykn.oyadrtencd.asc(),
                qHT_GrossNykn.kyktuukasyu.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_GrossNykn).getResults();
    }

    public ExDBResults<HT_GrossNykn> getGrossNyukinInfoByRyosyuYmd(BizDate pRyosyuFromYmd, BizDate pRyosyuToYmd) {

        QHT_GrossNykn qHT_GrossNykn = new QHT_GrossNykn("qHT_GrossNykn");

        String strSql = $SELECT + qHT_GrossNykn +
            $FROM(qHT_GrossNykn) +
            $WHERE + qHT_GrossNykn.ryosyuymd.ge(pRyosyuFromYmd) +
            $AND + qHT_GrossNykn.ryosyuymd.le(pRyosyuToYmd) +
            $ORDER_BY(qHT_GrossNykn.hrktuukasyu.desc(),
                qHT_GrossNykn.ryosyuymd.asc(),
                qHT_GrossNykn.oyadrtencd.asc(),
                qHT_GrossNykn.kyktuukasyu.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qHT_GrossNykn).getResults();
    }
}
