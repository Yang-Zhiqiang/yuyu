package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;

/**
 * 新契約口座振替案内データテーブル(HT_SkKouzahuriAnnaiDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkKouzahuriAnnaiDataDao extends AbstractDao<HT_SkKouzahuriAnnaiData> {

    public HT_SkKouzahuriAnnaiDataDao() {
        super(HT_SkKouzahuriAnnaiData.class);
    }

    public HT_SkKouzahuriAnnaiData getSkKouzahuriAnnaiData(C_AnsyuusysKbn pAnsyuusyskbn,
            BizDate pSyoriYmd,
            String pMosno,
            C_NyknaiyouKbn pNyknaiyoukbn,
            BizDateYM pJyuutouym){
        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData =  new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData.setAnsyuusyskbn(pAnsyuusyskbn);
        hT_SkKouzahuriAnnaiData.setSyoriYmd(pSyoriYmd);
        hT_SkKouzahuriAnnaiData.setMosno(pMosno);
        hT_SkKouzahuriAnnaiData.setNyknaiyoukbn(pNyknaiyoukbn);
        hT_SkKouzahuriAnnaiData.setJyuutouym(pJyuutouym);
        return this.selectOne(hT_SkKouzahuriAnnaiData);
    }

    public List<HT_SkKouzahuriAnnaiData> getSkKouzahuriAnnaiDatasByMosno(String pMosno) {
        HT_SkKouzahuriAnnaiData hT_SkKouzahuriAnnaiData =new HT_SkKouzahuriAnnaiData();
        hT_SkKouzahuriAnnaiData.setMosno(pMosno);
        return this.select(hT_SkKouzahuriAnnaiData);
    }
}
