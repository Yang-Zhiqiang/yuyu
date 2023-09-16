package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.HT_SkUriageData;

/**
 * 新契約売上データテーブル(HT_SkUriageDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkUriageDataDao extends AbstractDao<HT_SkUriageData> {

    public HT_SkUriageDataDao() {
        super(HT_SkUriageData.class);
    }

    public HT_SkUriageData getSkUriageData(C_AnsyuusysKbn pAnsyuusyskbn,
            BizDate pSyoriYmd,
            String pMosno,
            Integer pAuthorikaisuu){
        HT_SkUriageData hT_SkUriageData =  new HT_SkUriageData();
        hT_SkUriageData.setAnsyuusyskbn(pAnsyuusyskbn);
        hT_SkUriageData.setSyoriYmd(pSyoriYmd);
        hT_SkUriageData.setMosno(pMosno);
        hT_SkUriageData.setAuthorikaisuu(pAuthorikaisuu);
        return this.selectOne(hT_SkUriageData);
    }

    public List<HT_SkUriageData> getSkUriageDatasByMosno(String pMosno) {
        HT_SkUriageData hT_SkUriageData =new HT_SkUriageData();
        hT_SkUriageData.setMosno(pMosno);
        return this.select(hT_SkUriageData);
    }
}
