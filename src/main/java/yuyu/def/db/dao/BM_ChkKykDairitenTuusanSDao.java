package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.db.entity.BM_ChkKykDairitenTuusanS;

/**
 * 契約者同一代理店通算Ｓチェックマスタ(BM_ChkKykDairitenTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKykDairitenTuusanSDao extends AbstractDao<BM_ChkKykDairitenTuusanS> {

    public BM_ChkKykDairitenTuusanSDao() {
        super(BM_ChkKykDairitenTuusanS.class);
    }

    public BM_ChkKykDairitenTuusanS getChkKykDairitenTuusanS(C_KihonssyuruiKbn pKihonssyuruikbn) {
        BM_ChkKykDairitenTuusanS bM_ChkKykDairitenTuusanS =  new BM_ChkKykDairitenTuusanS();
        bM_ChkKykDairitenTuusanS.setKihonssyuruikbn(pKihonssyuruikbn);
        return this.selectOne(bM_ChkKykDairitenTuusanS);
    }
}
