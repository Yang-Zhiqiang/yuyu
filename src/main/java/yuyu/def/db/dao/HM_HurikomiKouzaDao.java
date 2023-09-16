package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.meta.QHM_HurikomiKouza;

/**
 * 振込口座マスタ(HM_HurikomiKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class HM_HurikomiKouzaDao extends AbstractDao<HM_HurikomiKouza> {

    public HM_HurikomiKouzaDao() {
        super(HM_HurikomiKouza.class);
    }

    public HM_HurikomiKouza getHurikomiKouza(String pBankcd,
        String pSitencd,
        String pKouzano,
        C_Tuukasyu pTuukasyu,
        String pHrkmirnincd){
        HM_HurikomiKouza hM_HurikomiKouza =  new HM_HurikomiKouza();
        hM_HurikomiKouza.setBankcd(pBankcd);
        hM_HurikomiKouza.setSitencd(pSitencd);
        hM_HurikomiKouza.setKouzano(pKouzano);
        hM_HurikomiKouza.setTuukasyu(pTuukasyu);
        hM_HurikomiKouza.setHrkmirnincd(pHrkmirnincd);
        return this.selectOne(hM_HurikomiKouza);
    }

    public List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyuYokinkbn(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu, C_YokinKbn pYokinkbn) {


        HM_HurikomiKouza hM_HurikomiKouza = new HM_HurikomiKouza();

        hM_HurikomiKouza.setBankcd(pBankcd);

        hM_HurikomiKouza.setSitencd(pSitencd);

        hM_HurikomiKouza.setKouzano(pKouzano);

        hM_HurikomiKouza.setTuukasyu(pTuukasyu);

        hM_HurikomiKouza.setYokinkbn(pYokinkbn);

        return select(hM_HurikomiKouza);

    }

    public List<HM_HurikomiKouza> getHurikomiKouzasByBankcdSitencdKouzanoTuukasyu(String pBankcd, String pSitencd, String pKouzano, C_Tuukasyu pTuukasyu) {

        QHM_HurikomiKouza qHM_HurikomiKouza = new QHM_HurikomiKouza();

        String strSql = $SELECT + qHM_HurikomiKouza +
            $FROM + qHM_HurikomiKouza.HM_HurikomiKouza() +
            $WHERE + qHM_HurikomiKouza.bankcd.eq(pBankcd) +
            $AND + qHM_HurikomiKouza.sitencd.eq(pSitencd) +
            $AND + "LPAD("+ qHM_HurikomiKouza.kouzano+ ",10,'0')" + $EQ + "'" + pKouzano + "'" +
            $AND + qHM_HurikomiKouza.tuukasyu.eq(pTuukasyu);

        return em.createJPQL(strSql).bind(qHM_HurikomiKouza).getResultList();
    }

    public  List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyuNe(C_Tuukasyu  pTuukasyu) {

        QHM_HurikomiKouza qHM_HurikomiKouza = new QHM_HurikomiKouza();

        String strSql = $SELECT + qHM_HurikomiKouza +
            $FROM + qHM_HurikomiKouza.HM_HurikomiKouza() +
            $WHERE + qHM_HurikomiKouza.tuukasyu.ne(pTuukasyu);

        return em.createJPQL(strSql).bind(qHM_HurikomiKouza).getResultList();
    }

    public List<HM_HurikomiKouza> getHurikomiKouzasByTuukasyu(C_Tuukasyu pTuukasyu) {


        HM_HurikomiKouza hM_HurikomiKouza = new HM_HurikomiKouza();

        hM_HurikomiKouza.setTuukasyu(pTuukasyu);
        return select(hM_HurikomiKouza);
    }
}
