package yuyu.def.hozen.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.dao.IT_BAK_KhHenkouUktkDao;
import yuyu.def.db.dao.IT_KhHenkouUktkDao;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;
import yuyu.def.hozen.sorter.SortIT_BAK_KhHenkouUktk;
import yuyu.def.hozen.sorter.SortIT_KhHenkouUktk;


/**
 * HenkouUktkDomマネージャー<br />
 * HenkouUktkにおける、DB操作を提供する。<br />
 */
class HenkouUktkDomManager {

    @Inject
    private IT_BAK_KhHenkouUktkDao bAK_KhHenkouUktkDao;

    @Inject
    private IT_KhHenkouUktkDao khHenkouUktkDao;

    List<IT_KhHenkouUktk> getAllKhHenkouUktk(){
        SortIT_KhHenkouUktk sortIT_KhHenkouUktk = new SortIT_KhHenkouUktk();
        return sortIT_KhHenkouUktk.OrderIT_KhHenkouUktkByPkAsc(khHenkouUktkDao.selectAll());
    }

    IT_KhHenkouUktk getKhHenkouUktk(String pSyono, Integer pHozenhenkouuktkrenno) {

        return khHenkouUktkDao.getKhHenkouUktk(pSyono, pHozenhenkouuktkrenno);
    }

    List<IT_BAK_KhHenkouUktk> getAllBAKKhHenkouUktk(){
        SortIT_BAK_KhHenkouUktk sortIT_BAK_KhHenkouUktk = new SortIT_BAK_KhHenkouUktk();
        return sortIT_BAK_KhHenkouUktk.OrderIT_BAK_KhHenkouUktkByPkAsc(bAK_KhHenkouUktkDao.selectAll());
    }

    IT_BAK_KhHenkouUktk getBAKKhHenkouUktk(String pSyono, String pTrkssikibetukey, Integer pHozenhenkouuktkrenno) {

        return bAK_KhHenkouUktkDao.getBAKKhHenkouUktk(pSyono, pTrkssikibetukey, pHozenhenkouuktkrenno);
    }

    List<IT_KhHenkouUktk> getKhHenkouUktksBySyono(String pSyono) {

        return khHenkouUktkDao.getKhHenkouUktksBySyono(pSyono);
    }

    List<IT_KhHenkouUktk> getKhHenkouUktksBySyono1(String pSyono) {

        return khHenkouUktkDao.getKhHenkouUktksBySyono1(pSyono);
    }

    List<IT_BAK_KhHenkouUktk> getBAKKhHenkouUktksBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        return bAK_KhHenkouUktkDao.getBAKKhHenkouUktksBySyonoTrkssikibetukey(pSyono, pTrkssikibetukey);
    }


    List<KhHenkouUktkBean> getKhHenkouUktkBySyonoUktkjyoutaiKbn(String pSyono, C_UktkJyoutaiKbn[] pUktkjyoutaikbn) {

        return khHenkouUktkDao.getKhHenkouUktkBySyonoUktkjyoutaiKbn(pSyono, pUktkjyoutaikbn);
    }

    IT_KhHenkouUktk getKykHozenHenkoUkt(String pSyono, C_UktkSyoriKbn pUktksyorikbn, C_UktkJyoutaiKbn pUktkjyoutaikbn, BizDate pKouryokuhasseiymd) {

        return khHenkouUktkDao.getKykHozenHenkoUkt(pSyono, pUktksyorikbn, pUktkjyoutaikbn, pKouryokuhasseiymd);
    }

}
