package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNo;

/**
 * 保険種類番号マスタ(HM_SkHokenSyuruiNoDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkHokenSyuruiNoDao extends AbstractDao<HM_SkHokenSyuruiNo> {

    public HM_SkHokenSyuruiNoDao() {
        super(HM_SkHokenSyuruiNo.class);
    }

    public HM_SkHokenSyuruiNo getSkHokenSyuruiNo(C_HknsyuruiNo pHknsyuruino,
        Integer pHknsyuruinosd){
        HM_SkHokenSyuruiNo hM_SkHokenSyuruiNo =  new HM_SkHokenSyuruiNo();
        hM_SkHokenSyuruiNo.setHknsyuruino(pHknsyuruino);
        hM_SkHokenSyuruiNo.setHknsyuruinosd(pHknsyuruinosd);
        return this.selectOne(hM_SkHokenSyuruiNo);
    }

    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosBySysdate(BizDate pSysdate) {


        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo1 = new QHM_SkHokenSyuruiNo("q1");

        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo2 = new QHM_SkHokenSyuruiNo("q2");


        String subQuerry = $SELECT + qHM_SkHokenSyuruiNo1.hknsyuruino +  "," +
            $MAX(qHM_SkHokenSyuruiNo1.hknsyuruinosd) +
            $FROM + qHM_SkHokenSyuruiNo1.HM_SkHokenSyuruiNo() +
            $WHERE + qHM_SkHokenSyuruiNo1.hknsyuruino.eq(qHM_SkHokenSyuruiNo2.hknsyuruino)+
            $AND + qHM_SkHokenSyuruiNo1.hyoujifromymd.le(pSysdate) +
            $AND + qHM_SkHokenSyuruiNo1.hyoujitoymd.ge(pSysdate) +
            $GROUP_BY + qHM_SkHokenSyuruiNo1.hknsyuruino +
            $HAVING + $MAX(qHM_SkHokenSyuruiNo1.hknsyuruinosd) + $EQ + qHM_SkHokenSyuruiNo2.hknsyuruinosd;


        String queryStr = $SELECT + qHM_SkHokenSyuruiNo2 +
            $FROM + qHM_SkHokenSyuruiNo2.HM_SkHokenSyuruiNo() +
            $WHERE + $EXISTS(subQuerry) +
            $ORDER_BY(qHM_SkHokenSyuruiNo2.syohnsortno.asc());

        return em.createJPQL(queryStr).bind(qHM_SkHokenSyuruiNo1, qHM_SkHokenSyuruiNo2).getResultList();
    }

    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujitoymdGt(BizDate pHyoujitoymd) {


        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo1 = new QHM_SkHokenSyuruiNo("q1");

        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo2 = new QHM_SkHokenSyuruiNo("q2");


        String subQuerry = $SELECT + qHM_SkHokenSyuruiNo1.hknsyuruino +  "," +
            $MAX(qHM_SkHokenSyuruiNo1.hknsyuruinosd) +
            $FROM + qHM_SkHokenSyuruiNo1.HM_SkHokenSyuruiNo() +
            $WHERE + qHM_SkHokenSyuruiNo1.hyoujitoymd.gt(pHyoujitoymd) +
            $GROUP_BY + qHM_SkHokenSyuruiNo1.hknsyuruino +
            $HAVING + qHM_SkHokenSyuruiNo1.hknsyuruino + $EQ + (qHM_SkHokenSyuruiNo2.hknsyuruino) +
            $AND + $MAX(qHM_SkHokenSyuruiNo1.hknsyuruinosd) + $EQ + qHM_SkHokenSyuruiNo2.hknsyuruinosd;


        String queryStr = $SELECT + qHM_SkHokenSyuruiNo2 +
            $FROM + qHM_SkHokenSyuruiNo2.HM_SkHokenSyuruiNo() +
            $WHERE + $EXISTS(subQuerry) +
            $ORDER_BY(qHM_SkHokenSyuruiNo2.syohnsortno.asc());

        return em.createJPQL(queryStr).bind(qHM_SkHokenSyuruiNo1, qHM_SkHokenSyuruiNo2).getResultList();

    }

    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHyoujidate(BizDate pHyoujidate) {


        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo = new QHM_SkHokenSyuruiNo();


        String strsql = $SELECT + qHM_SkHokenSyuruiNo +
            $FROM + qHM_SkHokenSyuruiNo.HM_SkHokenSyuruiNo() +
            $WHERE + qHM_SkHokenSyuruiNo.hyoujifromymd.le(pHyoujidate) +
            $AND + qHM_SkHokenSyuruiNo.hyoujitoymd.ge(pHyoujidate) +
            $ORDER_BY(qHM_SkHokenSyuruiNo.syohnsortno.asc());


        return em.createJPQL(strsql).bind(qHM_SkHokenSyuruiNo).getResultList();
    }

    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruino(C_HknsyuruiNo pHknsyuruino) {

        HM_SkHokenSyuruiNo hM_SkHokenSyuruiNo = new HM_SkHokenSyuruiNo();
        hM_SkHokenSyuruiNo.setHknsyuruino(pHknsyuruino);
        return this.select(hM_SkHokenSyuruiNo);
    }

    public List<HM_SkHokenSyuruiNo> getSkHokenSyuruiNosByHknsyuruinoHyoujidate(C_HknsyuruiNo pHknsyuruino,
        BizDate pHyoujidate) {


        QHM_SkHokenSyuruiNo qHM_SkHokenSyuruiNo = new QHM_SkHokenSyuruiNo();


        String strsql = $SELECT + qHM_SkHokenSyuruiNo +
            $FROM + qHM_SkHokenSyuruiNo.HM_SkHokenSyuruiNo() +
            $WHERE  + qHM_SkHokenSyuruiNo.hknsyuruino.eq(pHknsyuruino) +
            $AND + qHM_SkHokenSyuruiNo.hyoujifromymd.le(pHyoujidate) +
            $AND + qHM_SkHokenSyuruiNo.hyoujitoymd.ge(pHyoujidate);

        return em.createJPQL(strsql).bind(qHM_SkHokenSyuruiNo).getResultList();
    }
}
