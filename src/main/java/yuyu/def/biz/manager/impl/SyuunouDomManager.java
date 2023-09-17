package yuyu.def.biz.manager.impl;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.biz.sorter.SortBM_CreditCardKaisya;
import yuyu.def.biz.sorter.SortBM_Ginkou;
import yuyu.def.biz.sorter.SortBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.dao.BM_CreditCardKaisyaDao;
import yuyu.def.db.dao.BM_GinkouDao;
import yuyu.def.db.dao.BM_KinyuuKikanHuhoyofuriInfoDao;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;


/**
 * SyuunouDomマネージャー<br />
 * Syuunouにおける、DB操作を提供する。<br />
 */
class SyuunouDomManager {

    @Inject
    private BM_CreditCardKaisyaDao creditCardKaisyaDao;

    @Inject
    private BM_GinkouDao ginkouDao;

    @Inject
    private BM_KinyuuKikanHuhoyofuriInfoDao kinyuuKikanHuhoyofuriInfoDao;

    List<BM_Ginkou> getAllGinkou(){
        SortBM_Ginkou sortBM_Ginkou = new SortBM_Ginkou();
        return sortBM_Ginkou.OrderBM_GinkouByPkAsc(ginkouDao.selectAll());
    }

    BM_Ginkou getGinkou(String pBankcd, String pSitencd) {

        return ginkouDao.getGinkou(pBankcd, pSitencd);
    }

    Long getGinkouCountByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn) {

        return ginkouDao.getGinkouCountByBankcdSitencdBanknmknSitennmkn(pBankcd, pSitencd, pBanknmkn, pSitennmkn);
    }

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmknSitennmkn(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn) {

        return ginkouDao.getGinkousByBankcdSitencdBanknmknSitennmkn(pBankcd, pSitencd, pBanknmkn, pSitennmkn);
    }

    Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj) {

        return ginkouDao.getGinkouCountByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj);
    }

    Long getGinkouCountByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt) {

        return ginkouDao.getGinkouCountByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj, pTysyttaisyougaibankcdhrt);
    }

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj) {

        return ginkouDao.getGinkousByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj);
    }

    List<BM_Ginkou> getGinkousByBankcdSitencdBanknmSitennm(String pBankcd, String pSitencd, String pBanknmkn, String pSitennmkn, String pBanknmkj, String pSitennmkj
        , String[] pTysyttaisyougaibankcdhrt) {

        return ginkouDao.getGinkousByBankcdSitencdBanknmSitennm(pBankcd, pSitencd, pBanknmkn, pSitennmkn, pBanknmkj, pSitennmkj, pTysyttaisyougaibankcdhrt);
    }

    List<BM_CreditCardKaisya> getAllCreditCardKaisya(){
        SortBM_CreditCardKaisya sortBM_CreditCardKaisya = new SortBM_CreditCardKaisya();
        return sortBM_CreditCardKaisya.OrderBM_CreditCardKaisyaByPkAsc(creditCardKaisyaDao.selectAll());
    }

    BM_CreditCardKaisya getCreditCardKaisya(String pCardkaisyacd) {

        return creditCardKaisyaDao.getCreditCardKaisya(pCardkaisyacd);
    }

    List<BM_KinyuuKikanHuhoyofuriInfo> getAllKinyuuKikanHuhoyofuriInfo(){
        SortBM_KinyuuKikanHuhoyofuriInfo sortBM_KinyuuKikanHuhoyofuriInfo = new SortBM_KinyuuKikanHuhoyofuriInfo();
        return sortBM_KinyuuKikanHuhoyofuriInfo.OrderBM_KinyuuKikanHuhoyofuriInfoByPkAsc(kinyuuKikanHuhoyofuriInfoDao.selectAll());
    }

    BM_KinyuuKikanHuhoyofuriInfo getKinyuuKikanHuhoyofuriInfo(String pBankcd) {

        return kinyuuKikanHuhoyofuriInfoDao.getKinyuuKikanHuhoyofuriInfo(pBankcd);
    }

    Long getGinkousCountByBankcdBanknmkn(String pBankcd, String pBanknmkn) {

        return ginkouDao.getGinkousCountByBankcdBanknmkn(pBankcd, pBanknmkn);
    }

    List<BM_Ginkou> getGinkousByBankcdBanknmknOrderByBankcdAsc(String pBankcd, String pBanknmkn) {

        return ginkouDao.getGinkousByBankcdBanknmknOrderByBankcdAsc(pBankcd, pBanknmkn);
    }

}
