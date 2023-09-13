package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;
import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import yuyu.def.db.dao.MT_KhHenkouUktkYykDao;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.direct.sorter.SortMT_KhHenkouUktkYyk;


/**
 * HozenRenndouInfoDomマネージャー<br />
 * HozenRenndouInfoにおける、DB操作を提供する。<br />
 */
class HozenRenndouInfoDomManager {

    @Inject
    private MT_KhHenkouUktkYykDao khHenkouUktkYykDao;

    List<MT_KhHenkouUktkYyk> getAllKhHenkouUktkYyk(){
        SortMT_KhHenkouUktkYyk sortMT_KhHenkouUktkYyk = new SortMT_KhHenkouUktkYyk();
        return sortMT_KhHenkouUktkYyk.OrderMT_KhHenkouUktkYykByPkAsc(khHenkouUktkYykDao.selectAll());
    }

    MT_KhHenkouUktkYyk getKhHenkouUktkYyk(String pSyono, Integer pHozenhenkouuktkrenno) {

        return khHenkouUktkYykDao.getKhHenkouUktkYyk(pSyono, pHozenhenkouuktkrenno);
    }

}
