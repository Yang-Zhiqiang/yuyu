package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;

/**
 * 口座振替案内データテーブル(IT_KhKouzahuriAnnaiDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhKouzahuriAnnaiDataDao extends AbstractDao<IT_KhKouzahuriAnnaiData> {

    public IT_KhKouzahuriAnnaiDataDao() {
        super(IT_KhKouzahuriAnnaiData.class);
    }

    public IT_KhKouzahuriAnnaiData getKhKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn,
         BizDate pSyoriYmd,
         String pSyono,
         C_NyknaiyouKbn pNyknaiyoukbn,
         BizDateYM pJyuutouym){
        IT_KhKouzahuriAnnaiData iT_KhKouzahuriAnnaiData =  new IT_KhKouzahuriAnnaiData();
        iT_KhKouzahuriAnnaiData.setAnsyuusyskbn(pAnsyuusyskbn);
        iT_KhKouzahuriAnnaiData.setSyoriYmd(pSyoriYmd);
        iT_KhKouzahuriAnnaiData.setSyono(pSyono);
        iT_KhKouzahuriAnnaiData.setNyknaiyoukbn(pNyknaiyoukbn);
        iT_KhKouzahuriAnnaiData.setJyuutouym(pJyuutouym);
        return this.selectOne(iT_KhKouzahuriAnnaiData);
    }
}
