package yuyu.def.zdb.manager.impl;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.dao.ZT_AiKyuubuByoumeiRnDao;
import yuyu.def.db.dao.ZT_SiShrdetailRnDao;
import yuyu.def.db.dao.ZT_SiShrdetailTyDao;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.entity.ZT_SiShrdetailRn;
import yuyu.def.db.entity.ZT_SiShrdetailTy;


/**
 * SiharaidiskjyusinDomマネージャー<br />
 * Siharaidiskjyusinにおける、DB操作を提供する。<br />
 */
class SiharaidiskjyusinDomManager {

    @Inject
    private ZT_AiKyuubuByoumeiRnDao aiKyuubuByoumeiRnDao;

    @Inject
    private ZT_SiShrdetailRnDao siShrdetailRnDao;

    @Inject
    private ZT_SiShrdetailTyDao siShrdetailTyDao;

    ExDBResults<ZT_AiKyuubuByoumeiRn> getAllAiKyuubuByoumeiRn(){
        return aiKyuubuByoumeiRnDao.selectAllZT_AiKyuubuByoumeiRn();
    }


    ZT_AiKyuubuByoumeiRn getAiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {

        return aiKyuubuByoumeiRnDao.getAiKyuubuByoumeiRn(pZrnbyoumeitourokuno);
    }

    ExDBResults<ZT_SiShrdetailTy> getAllSiShrdetailTy(){
        return siShrdetailTyDao.selectAllZT_SiShrdetailTy();
    }


    ZT_SiShrdetailTy getSiShrdetailTy(String pZtytyouhyouymd, String pZtysyono, String pZtysikibetuno) {

        return siShrdetailTyDao.getSiShrdetailTy(pZtytyouhyouymd, pZtysyono, pZtysikibetuno);
    }

    ExDBResults<ZT_SiShrdetailRn> getAllSiShrdetailRn(){
        return siShrdetailRnDao.selectAllZT_SiShrdetailRn();
    }


    ZT_SiShrdetailRn getSiShrdetailRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {

        return siShrdetailRnDao.getSiShrdetailRn(pZrntyouhyouymd, pZrnsyono, pZrnsikibetuno);
    }

    Long getAiKyuubuByoumeiRnCount() {

        return aiKyuubuByoumeiRnDao.getAiKyuubuByoumeiRnCount();
    }

}
