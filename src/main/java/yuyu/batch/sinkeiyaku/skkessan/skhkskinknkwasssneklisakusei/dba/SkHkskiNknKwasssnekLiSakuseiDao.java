package yuyu.batch.sinkeiyaku.skkessan.skhkskinknkwasssneklisakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.db.meta.QHT_SyoriCTL;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 新契約 決算 複数回入金為替差損益リスト作成の機能DAOクラスです
 */
public class SkHkskiNknKwasssnekLiSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HT_SyoriCTL> getHkskiNknKwasssnekData(BizDate pKijyunFromYmd,
        BizDate pKijyunToYmd, C_Tuukasyu pRstuukasyu, BizDate pPkakinKijyunFromYmd, BizDate pPkakinKijyunToYmd) {

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");
        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");

        String subSql = $SELECT + qHT_Nyuukin.mosno +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.tyakkinymd.ge(pKijyunFromYmd) +
            $AND + qHT_Nyuukin.tyakkinymd.le(pKijyunToYmd) +
            $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Nyuukin.mosno.eq(qHT_SyoriCTL.mosno);

        String subSql2 = $SELECT + qHT_Nyuukin.mosno +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Nyuukin.mosno.eq(qHT_SyoriCTL.mosno) +
            $GROUP_BY + qHT_Nyuukin.mosno +
            $HAVING + $COUNT + "(*)" + $GE + "2";

        String subSql3 = $SELECT + qHT_Henkin.mosno +
            $FROM(qHT_Henkin) +
            $WHERE + qHT_Henkin.pkakinsyoriymd.ge(pPkakinKijyunFromYmd) +
            $AND + qHT_Henkin.pkakinsyoriymd.lt(pPkakinKijyunToYmd) +
            $AND + qHT_Henkin.hnkntuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Henkin.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU);


        String sql = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL) +
            $WHERE + $($EXISTS (subSql) +
                $AND + $EXISTS (subSql2)) +
                $OR + $EXISTS (subSql3) +
                $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return exDBEntityManager.createJPQL(sql).bind(qHT_SyoriCTL, qHT_Nyuukin, qHT_Henkin).getResults();
    }

    public List<HT_Nyuukin> getNyuukins(String pMosno, C_Tuukasyu pRstuukasyu) {

        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");

        String sql = $SELECT + qHT_Nyuukin +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $ORDER_BY(qHT_Nyuukin.nyksyoriymd.asc()
                ,qHT_Nyuukin.tyakkinymd.asc());

        return exDBEntityManager.createJPQL(sql).bind(qHT_Nyuukin).getResultList();
    }

    public List<HT_SkDenpyoData> getSkDenpyoDatas(String pMosno, C_DensyoriKbn pDensyoriKbn, Integer pEdano) {

        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");

        String sql = $SELECT + qHT_SkDenpyoData +
            $FROM(qHT_SkDenpyoData) +
            $WHERE + qHT_SkDenpyoData.mosno.eq(pMosno) +
            $AND + qHT_SkDenpyoData.densyorikbn.eq(pDensyoriKbn) +
            $AND + qHT_SkDenpyoData.edano.eq(pEdano);

        return exDBEntityManager.createJPQL(sql).bind(qHT_SkDenpyoData).getResultList();
    }
}
