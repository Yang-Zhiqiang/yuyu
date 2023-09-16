package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.meta.QHT_ImusateiRireki;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;

/**
 * 医務査定履歴テーブル(HT_ImusateiRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_ImusateiRirekiDao extends AbstractDao<HT_ImusateiRireki> {

    public HT_ImusateiRirekiDao() {
        super(HT_ImusateiRireki.class);
    }

    @Deprecated
    public HT_ImusateiRireki getImusateiRireki(String pMosno,
        Integer pRenno){
        HT_ImusateiRireki hT_ImusateiRireki =  new HT_ImusateiRireki();
        hT_ImusateiRireki.setMosno(pMosno);
        hT_ImusateiRireki.setRenno(pRenno);
        return this.selectOne(hT_ImusateiRireki);
    }

    @Override
    @Deprecated
    public List<HT_ImusateiRireki> selectAll() {
        return super.selectAll();
    }

    public HT_ImusateiRireki getImusateiRirekiByMosnoMaxRenno(String pMosno) {


        QHT_ImusateiRireki qHT_ImusateiRireki = new QHT_ImusateiRireki();


        String subQuerry = $SELECT + $MAX(qHT_ImusateiRireki.renno) +
            $FROM + qHT_ImusateiRireki.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki.mosno.eq(pMosno) +
            $GROUP_BY + qHT_ImusateiRireki.mosno;


        String mainQuerry = $SELECT + qHT_ImusateiRireki +
            $FROM + qHT_ImusateiRireki.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki.mosno.eq(pMosno) +
            $AND + qHT_ImusateiRireki.renno + $EQ +$(subQuerry);

        return em.createJPQL(mainQuerry).bind(qHT_ImusateiRireki).getSingleResult();
    }

    public Integer getImusateiRirekiMaxRennoByMosno(String pMosno) {


        QHT_ImusateiRireki qHT_ImusateiRireki = new QHT_ImusateiRireki();

        String subQuerry = $SELECT + $MAX(qHT_ImusateiRireki.renno) +
            $FROM + qHT_ImusateiRireki.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki.mosno.eq(pMosno);
        return em.createJPQL(subQuerry).bind(qHT_ImusateiRireki).getSingleResult();
    }

    public Long getImusateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {


        QHT_ImusateiRireki qHT_ImusateiRireki = new QHT_ImusateiRireki();

        String quertSql = $SELECT + $COUNT +"(*)"+
            $FROM + qHT_ImusateiRireki.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki.ketsyacd.eq(pKetsyacd) +
            $OR + qHT_ImusateiRireki.tnsketsyacd.eq(pKetsyacd);

        return em.createJPQL(quertSql).bind(qHT_ImusateiRireki).getSingleResult();
    }

    public HT_ImusateiRireki getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(String pMosno, C_SyorikekkaKbn pImusateikekkakbn) {


        QHT_ImusateiRireki qHT_ImusateiRireki1 = new QHT_ImusateiRireki("qHT_ImusateiRireki1");
        QHT_ImusateiRireki qHT_ImusateiRireki2 = new QHT_ImusateiRireki("qHT_ImusateiRireki2");


        String strSubSql = $SELECT + $MAX(qHT_ImusateiRireki2.renno) +
            $FROM + qHT_ImusateiRireki2.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki2.mosno.eq(pMosno) +
            $AND + qHT_ImusateiRireki2.imusateikekkakbn.eq(pImusateikekkakbn);


        String strMainSql = $SELECT + qHT_ImusateiRireki1 +
            $FROM + qHT_ImusateiRireki1.HT_ImusateiRireki() +
            $WHERE + qHT_ImusateiRireki1.mosno.eq(pMosno) +
            $AND + qHT_ImusateiRireki1.renno + $EQ +$(strSubSql);


        return em.createJPQL(strMainSql).bind(qHT_ImusateiRireki1, qHT_ImusateiRireki2).getSingleResult();
    }

    public BizDate getSkDenpyoDataMinDenymdByMosnoRstuukasyu(String pMosno, C_Tuukasyu pRstuukasyu) {


        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();

        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();

        String sql = $SELECT + $MIN(qHT_SkDenpyoData.denymd) +
            $FROM + qHT_SkDenpyoData.HT_SkDenpyoData() + "," +
            qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
            $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano);

        return em.createJPQL(sql).bind(qHT_SkDenpyoData, qHT_Nyuukin).getSingleResult();
    }
}
