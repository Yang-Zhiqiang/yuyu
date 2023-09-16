package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnToriatukaiTuuka;
import yuyu.def.db.meta.QBM_SyouhnToriatukaiTuuka;

/**
 * 商品取扱通貨マスタ(BM_SyouhnToriatukaiTuukaDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyouhnToriatukaiTuukaDao extends AbstractDao<BM_SyouhnToriatukaiTuuka> {

    public BM_SyouhnToriatukaiTuukaDao() {
        super(BM_SyouhnToriatukaiTuuka.class);
    }

    public BM_SyouhnToriatukaiTuuka getSyouhnToriatukaiTuuka(String pSyouhncd, BizDate pTkyfromymd, BizDate pTkytoymd, C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu, C_Tuukasyu pHrktuukasyu) {
        BM_SyouhnToriatukaiTuuka bM_SyouhnToriatukaiTuuka =  new BM_SyouhnToriatukaiTuuka();
        bM_SyouhnToriatukaiTuuka.setSyouhncd(pSyouhncd);
        bM_SyouhnToriatukaiTuuka.setTkyfromymd(pTkyfromymd);
        bM_SyouhnToriatukaiTuuka.setTkytoymd(pTkytoymd);
        bM_SyouhnToriatukaiTuuka.setZenkizennouumu(pZenkizennouumu);
        bM_SyouhnToriatukaiTuuka.setKyktuukasyu(pKyktuukasyu);
        bM_SyouhnToriatukaiTuuka.setHrktuukasyu(pHrktuukasyu);
        return this.selectOne(bM_SyouhnToriatukaiTuuka);
    }

    public List<BM_SyouhnToriatukaiTuuka> getSyouhnToriatukaiTuukasByPk(String pSyouhncd, BizDate pTekiyouYmd
        , C_BlnktkumuKbn pZenkizennouumu, C_Tuukasyu pKyktuukasyu , C_Tuukasyu pHrktuukasyu) {


        QBM_SyouhnToriatukaiTuuka qBM_SyouhnToriatukaiTuuka = new QBM_SyouhnToriatukaiTuuka("qBM_SyouhnToriatukaiTuuka");


        String strSql = $SELECT + qBM_SyouhnToriatukaiTuuka +
            $FROM(qBM_SyouhnToriatukaiTuuka) +
            $WHERE + qBM_SyouhnToriatukaiTuuka.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnToriatukaiTuuka.tkyfromymd.le(pTekiyouYmd) +
            $AND + qBM_SyouhnToriatukaiTuuka.tkytoymd.ge(pTekiyouYmd) +
            $AND + qBM_SyouhnToriatukaiTuuka.zenkizennouumu.eq(pZenkizennouumu) +
            $AND + qBM_SyouhnToriatukaiTuuka.kyktuukasyu.eq(pKyktuukasyu) +
            $AND + qBM_SyouhnToriatukaiTuuka.hrktuukasyu.eq(pHrktuukasyu);

        return em.createJPQL(strSql).bind(qBM_SyouhnToriatukaiTuuka).getResultList();
    }
}
