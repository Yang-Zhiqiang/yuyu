package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkNenreiNensyuuTuusanS;

/**
 * 年齢年収制限通算限度Ｓチェックマスタ(BM_ChkNenreiNensyuuTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNenreiNensyuuTuusanSDao extends AbstractDao<BM_ChkNenreiNensyuuTuusanS> {

    public BM_ChkNenreiNensyuuTuusanSDao() {
        super(BM_ChkNenreiNensyuuTuusanS.class);
    }

    public BM_ChkNenreiNensyuuTuusanS getChkNenreiNensyuuTuusanS(BizNumber pHhknfromnen,
         BizNumber pHhkntonen,
         Integer pHhknfromnensyuu,
         Integer pHhkntonensyuu){
        BM_ChkNenreiNensyuuTuusanS bM_ChkNenreiNensyuuTuusanS =  new BM_ChkNenreiNensyuuTuusanS();
        bM_ChkNenreiNensyuuTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkNenreiNensyuuTuusanS.setHhkntonen(pHhkntonen);
        bM_ChkNenreiNensyuuTuusanS.setHhknfromnensyuu(pHhknfromnensyuu);
        bM_ChkNenreiNensyuuTuusanS.setHhkntonensyuu(pHhkntonensyuu);
        return this.selectOne(bM_ChkNenreiNensyuuTuusanS);
    }
}
