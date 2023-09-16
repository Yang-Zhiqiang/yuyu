package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;

/**
 * 新契約ＬＩＮＣ受信データテーブル(HT_SkLincJyusinDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincJyusinDataDao extends AbstractDao<HT_SkLincJyusinData> {

    public HT_SkLincJyusinDataDao() {
        super(HT_SkLincJyusinData.class);
    }

    public HT_SkLincJyusinData getSkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {
        HT_SkLincJyusinData hT_SkLincJyusinData =  new HT_SkLincJyusinData();
        hT_SkLincJyusinData.setSyoriYmd(pSyoriYmd);
        hT_SkLincJyusinData.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno);
        return this.selectOne(hT_SkLincJyusinData);
    }

    public HT_SkLincJyusinData getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno(String pMosno) {


        QHT_SkLincJyusinData qHT_SkLincJyusinData = new QHT_SkLincJyusinData("qHT_SkLincJyusinData");


        String strSpl = $SELECT + qHT_SkLincJyusinData +
            $FROM(qHT_SkLincJyusinData) +
            $WHERE + qHT_SkLincJyusinData.rendoumosnochknasi.eq(pMosno) +
            $AND + qHT_SkLincJyusinData.lincsoujyusinsyskbn.eq(C_LincsoujyusinsysKbn.SKEI) +
            $AND + $(qHT_SkLincJyusinData.lincrecordsyubetu.eq(6) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(16) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(26) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(50)) +
                $ORDER_BY(qHT_SkLincJyusinData.syoriYmd.desc(),
                    qHT_SkLincJyusinData.linckyknaiykekdatarenno.asc());


        return em.createJPQL(strSpl).setFirstResult(0).setMaxResults(1).bind(qHT_SkLincJyusinData).getSingleResult();
    }

    public List<HT_SkLincJyusinData> getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate pSyoriYmd, String pLinckyknaiykekdatarennooya) {


        QHT_SkLincJyusinData qHT_SkLincJyusinData = new QHT_SkLincJyusinData("qHT_SkLincJyusinData");


        String strSpl = $SELECT + qHT_SkLincJyusinData +
            $FROM(qHT_SkLincJyusinData) +
            $WHERE + qHT_SkLincJyusinData.linckyknaiykekdatarennooya.eq(pLinckyknaiykekdatarennooya) +
            $AND + qHT_SkLincJyusinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qHT_SkLincJyusinData.lincsousinmotokaisya.ne("20") +
            $AND + $(qHT_SkLincJyusinData.lincrecordsyubetu.eq(7) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(17) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(27) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(37) +
                $OR +qHT_SkLincJyusinData.lincrecordsyubetu.eq(51)) +
                $ORDER_BY(qHT_SkLincJyusinData.linckyknaiykekdatarenno.asc());


        return em.createJPQL(strSpl).bind(qHT_SkLincJyusinData).getResultList();
    }
}
