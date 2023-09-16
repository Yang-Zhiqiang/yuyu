package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;

/**
 * 年収倍率チェックマスタ(BM_ChkNensyuuBairituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNensyuuBairituDao extends AbstractDao<BM_ChkNensyuuBairitu> {

    public BM_ChkNensyuuBairituDao() {
        super(BM_ChkNensyuuBairitu.class);
    }

    public BM_ChkNensyuuBairitu getChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {
        BM_ChkNensyuuBairitu bM_ChkNensyuuBairitu =  new BM_ChkNensyuuBairitu();
        bM_ChkNensyuuBairitu.setNensyuukbn(pNensyuukbn);
        return this.selectOne(bM_ChkNensyuuBairitu);
    }

}
