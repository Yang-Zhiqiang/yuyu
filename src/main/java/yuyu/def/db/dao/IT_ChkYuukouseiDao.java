package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_ChkYuukousei;

/**
 * 有効性確認データテーブル(IT_ChkYuukouseiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ChkYuukouseiDao extends AbstractDao<IT_ChkYuukousei> {

    public IT_ChkYuukouseiDao() {
        super(IT_ChkYuukousei.class);
    }

    public IT_ChkYuukousei getChkYuukousei(C_AnsyuusysKbn pAnsyuusyskbn,
         BizDate pSyoriYmd,
         String pSyono){
        IT_ChkYuukousei iT_ChkYuukousei =  new IT_ChkYuukousei();
        iT_ChkYuukousei.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_ChkYuukousei.setSyoriYmd(pSyoriYmd);
        iT_ChkYuukousei.setSyono(pSyono);
        return this.selectOne(iT_ChkYuukousei);
    }
}
