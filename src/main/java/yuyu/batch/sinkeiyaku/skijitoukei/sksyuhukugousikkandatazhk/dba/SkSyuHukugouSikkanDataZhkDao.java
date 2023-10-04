package yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkandatazhk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHW_SyuHukugouSikkanZhkWk;

/**
 * 新契約 主契約複合疾患データ増幅の機能DAOクラスです。
 */
public class SkSyuHukugouSikkanDataZhkDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyuHukugouSikkanDataZhkSyoriTaisyou(String pSyono, BizDate pSyoritaisyouhanteiymdFrom, BizDate pSyoritaisyouhanteiymdTo) {

        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai1 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai1");
        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai2 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai2");

        String strSubSql = $SELECT + qHT_IjitoukeiMeisai1.syono +
            $FROM + qHT_IjitoukeiMeisai1.HT_IjitoukeiMeisai() +
            $WHERE + qHT_IjitoukeiMeisai1.syono.eq(qHT_IjitoukeiMeisai2.syono) +
            $AND + qHT_IjitoukeiMeisai1.syono.gt(pSyono) +
            $AND + qHT_IjitoukeiMeisai1.kykymd.gt(pSyoritaisyouhanteiymdFrom) +
            $AND  + qHT_IjitoukeiMeisai1.kykymd.le(pSyoritaisyouhanteiymdTo) +
            $AND + "(" + qHT_IjitoukeiMeisai1.syoumetuymd.isNull() +
            $OR + qHT_IjitoukeiMeisai1.syoumetuymd.le(pSyoritaisyouhanteiymdTo) + ")" +
            $GROUP_BY + qHT_IjitoukeiMeisai1.syono +
            $HAVING + $MAX(qHT_IjitoukeiMeisai1.renno8keta) + $EQ + qHT_IjitoukeiMeisai2.renno8keta;

        String strMainSql = $SELECT + qHT_IjitoukeiMeisai2 +
            $FROM + qHT_IjitoukeiMeisai2.HT_IjitoukeiMeisai() +
            $WHERE  + $EXISTS(strSubSql) +
        $ORDER_BY(qHT_IjitoukeiMeisai2.syono.asc());

        return exDBEntityManager.createJPQL(strMainSql).bind(qHT_IjitoukeiMeisai1, qHT_IjitoukeiMeisai2).getResults();
    }

    public void deleteSyuHukugouSikkanDataZhk() {

        QHW_SyuHukugouSikkanZhkWk qHW_SyuHukugouSikkanZhkWk = new QHW_SyuHukugouSikkanZhkWk("qHW_SyuHukugouSikkanZhkWk");

        String strSql = $DELETE_FROM(qHW_SyuHukugouSikkanZhkWk);

        exDBEntityManager.createJPQL(strSql).bind(qHW_SyuHukugouSikkanZhkWk).executeUpdate();
    }
}
