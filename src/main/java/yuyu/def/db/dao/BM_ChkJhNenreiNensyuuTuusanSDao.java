package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkJhNenreiNensyuuTuusanS;

/**
 * 年齢年収制限通算限度Ｓ事方書チェックマスタ(BM_ChkJhNenreiNensyuuTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhNenreiNensyuuTuusanSDao extends AbstractDao<BM_ChkJhNenreiNensyuuTuusanS> {

    public BM_ChkJhNenreiNensyuuTuusanSDao() {
        super(BM_ChkJhNenreiNensyuuTuusanS.class);
    }

    public BM_ChkJhNenreiNensyuuTuusanS getChkJhNenreiNensyuuTuusanS(BizNumber pHhknfromnen,
         BizNumber pHhkntonen,
         Integer pHhknfromnensyuu,
         Integer pHhkntonensyuu){
        BM_ChkJhNenreiNensyuuTuusanS bM_ChkJhNenreiNensyuuTuusanS =  new BM_ChkJhNenreiNensyuuTuusanS();
        bM_ChkJhNenreiNensyuuTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkJhNenreiNensyuuTuusanS.setHhkntonen(pHhkntonen);
        bM_ChkJhNenreiNensyuuTuusanS.setHhknfromnensyuu(pHhknfromnensyuu);
        bM_ChkJhNenreiNensyuuTuusanS.setHhkntonensyuu(pHhkntonensyuu);
        return this.selectOne(bM_ChkJhNenreiNensyuuTuusanS);
    }
}
