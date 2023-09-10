package yuyu.def.sinkeiyaku.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_ImusateirankKbn;
import yuyu.def.classification.C_KnksateirankKbn;
import yuyu.def.classification.C_MostenkenRankKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.dao.HM_KetteiSyaDao;
import yuyu.def.db.dao.HT_DakuhiKetteiDao;
import yuyu.def.db.dao.HT_ImusateiRirekiDao;
import yuyu.def.db.dao.HT_KnksateiRirekiDao;
import yuyu.def.db.dao.HT_KykKakDao;
import yuyu.def.db.dao.HT_MostenkenRirekiDao;
import yuyu.def.db.dao.HT_TokuninDao;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.sinkeiyaku.sorter.SortHM_KetteiSya;


/**
 * SateiKetInfoDomマネージャー<br />
 * SateiKetInfoにおける、DB操作を提供する。<br />
 */
class SateiKetInfoDomManager {


    @Inject
    private HM_KetteiSyaDao ketteiSyaDao;


    @Inject
    private HT_DakuhiKetteiDao dakuhiKetteiDao;


    @Inject
    private HT_ImusateiRirekiDao imusateiRirekiDao;


    @Inject
    private HT_KnksateiRirekiDao knksateiRirekiDao;


    @Inject
    private HT_KykKakDao kykKakDao;


    @Inject
    private HT_MostenkenRirekiDao mostenkenRirekiDao;


    @Inject
    private HT_TokuninDao tokuninDao;


    List<HM_KetteiSya> getAllKetteiSya(){
        SortHM_KetteiSya sortHM_KetteiSya = new SortHM_KetteiSya();
        return sortHM_KetteiSya.OrderHM_KetteiSyaByPkAsc(ketteiSyaDao.selectAll());
    }


    HM_KetteiSya getKetteiSya(String pKetsyacd) {

        return ketteiSyaDao.getKetteiSya(pKetsyacd);
    }


    HT_MostenkenRireki getMostenkenRirekiByMosnoMaxRenno(String pMosno) {

        return mostenkenRirekiDao.getMostenkenRirekiByMosnoMaxRenno(pMosno);
    }


    Long getMostenkenRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {

        return mostenkenRirekiDao.getMostenkenRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    BizDate getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(String pMosno) {

        return mostenkenRirekiDao.getMostenkenRirekiMinSyoriYmdByMosnoMostenkenkekkakbn(pMosno);
    }


    List<HM_KetteiSya> getKetteiSyasByKetsyacdMostenkenrankkbns(String pKetsyacd, C_MostenkenRankKbn... pMostenkenrankkbn) {

        return ketteiSyaDao.getKetteiSyasByKetsyacdMostenkenrankkbns(pKetsyacd,pMostenkenrankkbn);
    }


    List<HM_KetteiSya> getKetteiSyasByKetsyacdImusateirankkbns(String pKetsyacd, C_ImusateirankKbn... pImusateirankkbn) {

        return ketteiSyaDao.getKetteiSyasByKetsyacdImusateirankkbns(pKetsyacd, pImusateirankkbn);
    }


    List<HM_KetteiSya> getKetteiSyasByKetsyacdKnksateirankkbns(String pKetsyacd, C_KnksateirankKbn... pKnksateirankkbn) {

        return ketteiSyaDao.getKetteiSyasByKetsyacdKnksateirankkbns(pKetsyacd, pKnksateirankkbn);
    }


    List<HM_KetteiSya> getKetteiSyasByKetsyacdKetsyanm(String pKetsyacd, String pKetsyanm) {

        return ketteiSyaDao.getKetteiSyasByKetsyacdKetsyanm(pKetsyacd,pKetsyanm);
    }


    Integer getImusateiRirekiMaxRennoByMosno(String pMosno) {

        return imusateiRirekiDao.getImusateiRirekiMaxRennoByMosno(pMosno);
    }


    Long getImusateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {

        return imusateiRirekiDao.getImusateiRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    HT_ImusateiRireki getImusateiRirekiByMosnoMaxRenno(String pMosno) {

        return imusateiRirekiDao.getImusateiRirekiByMosnoMaxRenno(pMosno);
    }


    HT_ImusateiRireki getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(String pMosno, C_SyorikekkaKbn pImusateikekkakbn) {

        return imusateiRirekiDao.getImusateiRirekiByMosnoImusateikekkakbnMaxRenno(pMosno, pImusateikekkakbn);
    }


    BizDate getSkDenpyoDataMinDenymdByMosnoRstuukasyu(String pMosno, C_Tuukasyu pRstuukasyu) {

        return imusateiRirekiDao.getSkDenpyoDataMinDenymdByMosnoRstuukasyu(pMosno,pRstuukasyu);
    }


    HT_KnksateiRireki getKnksateiRirekiByMosnoMaxRenno(String pMosno) {

        return knksateiRirekiDao.getKnksateiRirekiByMosnoMaxRenno(pMosno);
    }


    Long getKnksateiRirekiCountByKetsyacdTnsketsyacd(String pKetsyacd) {

        return knksateiRirekiDao.getKnksateiRirekiCountByKetsyacdTnsketsyacd(pKetsyacd);
    }


    Integer getDakuhiKetteiMaxDakuhiktrennoByMosno(String pMosno) {

        return dakuhiKetteiDao.getDakuhiKetteiMaxDakuhiktrennoByMosno(pMosno);
    }


    HT_DakuhiKettei getDakuhiKetteiByMosnoMaxDakuhiktrenno(String pMosno) {

        return dakuhiKetteiDao.getDakuhiKetteiByMosnoMaxDakuhiktrenno(pMosno);
    }


    HT_DakuhiKettei getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(String pMosno, C_DakuhiktbunruiKbn pDakuhiktbunruikbn) {

        return dakuhiKetteiDao.getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(pMosno, pDakuhiktbunruikbn);
    }


    HT_KykKak getKykKakByMosnoMaxRenno(String pMosno) {

        return kykKakDao.getKykKakByMosnoMaxRenno(pMosno);
    }


    Integer getKykKakMaxRennoByMosno(String pMosno) {

        return kykKakDao.getKykKakMaxRennoByMosno(pMosno);
    }


    List<HT_DakuhiKettei> getDakuhiKetteisByKetsyacd(String pKetsyacd) {

        return dakuhiKetteiDao.getDakuhiKetteisByKetsyacd(pKetsyacd);
    }


    List<HT_Tokunin> getTokuninsByKetsyacd(String pKetsyacd) {

        return tokuninDao.getTokuninsByKetsyacd(pKetsyacd);
    }


    HT_MostenkenRireki getMostenkenRirekiByMosnoKanryouMaxRenno(String pMosno) {

        return mostenkenRirekiDao.getMostenkenRirekiByMosnoKanryouMaxRenno(pMosno);
    }

}
