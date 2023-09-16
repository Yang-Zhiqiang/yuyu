package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ChkNenkinSaiteiS;

/**
 * 年金支払特約最低Ｓチェックマスタ(BM_ChkNenkinSaiteiSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkNenkinSaiteiSDao extends AbstractDao<BM_ChkNenkinSaiteiS> {

    public BM_ChkNenkinSaiteiSDao() {
        super(BM_ChkNenkinSaiteiS.class);
    }

    public BM_ChkNenkinSaiteiS getChkNenkinSaiteiS(Integer pNenkinkkn,
         String pNenkinsyu){
        BM_ChkNenkinSaiteiS bM_ChkNenkinSaiteiS =  new BM_ChkNenkinSaiteiS();
        bM_ChkNenkinSaiteiS.setNenkinkkn(pNenkinkkn);
        bM_ChkNenkinSaiteiS.setNenkinsyu(pNenkinsyu);
        return this.selectOne(bM_ChkNenkinSaiteiS);
    }
}
