package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHT_IjitoukeiMeisai;

/**
 * 医事統計明細テーブル(HT_IjitoukeiMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_IjitoukeiMeisaiDao extends AbstractDao<HT_IjitoukeiMeisai> {

    public HT_IjitoukeiMeisaiDao() {
        super(HT_IjitoukeiMeisai.class);
    }

    public HT_IjitoukeiMeisai getIjitoukeiMeisai(String pSyono,
        Integer pRenno8keta){
        HT_IjitoukeiMeisai hT_IjitoukeiMeisai =  new HT_IjitoukeiMeisai();
        hT_IjitoukeiMeisai.setSyono(pSyono);
        hT_IjitoukeiMeisai.setRenno8keta(pRenno8keta);
        return this.selectOne(hT_IjitoukeiMeisai);
    }

    public ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(BizDate pSyoumetuymdFrom,
        BizDate pSyoumetuymdTo) {


        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai1 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai1");

        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai2 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai2");


        String subQuerry = $SELECT + qHT_IjitoukeiMeisai1.syono + "," +
            $MAX(qHT_IjitoukeiMeisai1.renno8keta) +
            $FROM + qHT_IjitoukeiMeisai1.HT_IjitoukeiMeisai() +
            $GROUP_BY + qHT_IjitoukeiMeisai1.syono +
            $HAVING + qHT_IjitoukeiMeisai1.syono + $EQ + qHT_IjitoukeiMeisai2.syono +
            $AND + $MAX(qHT_IjitoukeiMeisai1.renno8keta) + $EQ + qHT_IjitoukeiMeisai2.renno8keta;

        String strSql = $SELECT + qHT_IjitoukeiMeisai2 +
            $FROM + qHT_IjitoukeiMeisai2.HT_IjitoukeiMeisai() +
            $WHERE + $EXISTS(subQuerry) +
            $AND + qHT_IjitoukeiMeisai2.syoumetuymd.ge(pSyoumetuymdFrom) +
            $AND + qHT_IjitoukeiMeisai2.syoumetuymd.lt(pSyoumetuymdTo) +
            $AND + $(qHT_IjitoukeiMeisai2.siincd.isNull() +
                $OR + qHT_IjitoukeiMeisai2.siincd.eq("")) +
                $AND + $(qHT_IjitoukeiMeisai2.symtgenincd.substring(1,1).eq("4") +
                    $OR + qHT_IjitoukeiMeisai2.symtgenincd.substring(1,1).eq("5") +
                    $OR + qHT_IjitoukeiMeisai2.symtgenincd.substring(1,1).eq("9")) +
                    $ORDER_BY(qHT_IjitoukeiMeisai2.idousyoriymd.asc(),
                        qHT_IjitoukeiMeisai2.syoumetuymd.asc());


        return em.createJPQL(strSql).bind(qHT_IjitoukeiMeisai1, qHT_IjitoukeiMeisai2).getResults();
    }

    public List<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyono(String pSyono) {

        HT_IjitoukeiMeisai hT_IjitoukeiMeisai =  new HT_IjitoukeiMeisai();
        hT_IjitoukeiMeisai.setSyono(pSyono);
        return this.select(hT_IjitoukeiMeisai);
    }

    public ExDBResults<HT_IjitoukeiMeisai> getIjitoukeiMeisaisBySyuSibouToukeiSksSyoriTaisyou(BizDate pSyoumetuymdFrom, BizDate pSyoumetuymdTo, BizDateYM pBosyuuymTo, BizDate pIdousyoriymdTo) {


        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai1 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai1");
        QHT_IjitoukeiMeisai qHT_IjitoukeiMeisai2 = new QHT_IjitoukeiMeisai("qHT_IjitoukeiMeisai2");


        String strSubSql = $SELECT + qHT_IjitoukeiMeisai1.syono +
            $FROM + qHT_IjitoukeiMeisai1.HT_IjitoukeiMeisai() +
            $WHERE + qHT_IjitoukeiMeisai1.syono.eq(qHT_IjitoukeiMeisai2.syono) +
            $GROUP_BY + qHT_IjitoukeiMeisai1.syono +
            $HAVING + $MAX(qHT_IjitoukeiMeisai1.renno8keta) + $EQ + qHT_IjitoukeiMeisai2.renno8keta;


        String strMainSql = $SELECT + qHT_IjitoukeiMeisai2 +
            $FROM + qHT_IjitoukeiMeisai2.HT_IjitoukeiMeisai() +
            $WHERE + $EXISTS(strSubSql) +
            $AND + qHT_IjitoukeiMeisai2.syoumetuymd.ge(pSyoumetuymdFrom) +
            $AND + qHT_IjitoukeiMeisai2.syoumetuymd.le(pSyoumetuymdTo) +
            $AND + qHT_IjitoukeiMeisai2.idousyoriymd.le(pIdousyoriymdTo) +
            $AND + qHT_IjitoukeiMeisai2.bosyuuym.le(pBosyuuymTo) +
            $AND + "(" + qHT_IjitoukeiMeisai2.ijitoukeikaijyokbn.eq(C_IjitoukeiKaijyoKbn.SEIZONKAIJYO) +
            $OR + qHT_IjitoukeiMeisai2.symtgenincd.substring(1, 1).in("4", "5", "9") +
            $OR + qHT_IjitoukeiMeisai2.symtgenincd.substring(1, 2).eq("13") + ")";



        return em.createJPQL(strMainSql).bind(qHT_IjitoukeiMeisai1, qHT_IjitoukeiMeisai2).getResults();
    }
}