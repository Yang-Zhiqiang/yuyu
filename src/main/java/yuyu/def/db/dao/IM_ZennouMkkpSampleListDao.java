package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;

/**
 * 前納未経過Ｐ検証サンプルリストパターンマスタ(IM_ZennouMkkpSampleListDao) アクセス用の DAO クラスです。<br />
 */
public class IM_ZennouMkkpSampleListDao extends AbstractDao<IM_ZennouMkkpSampleList> {

    public IM_ZennouMkkpSampleListDao() {
        super(IM_ZennouMkkpSampleList.class);
    }

    public IM_ZennouMkkpSampleList getZennouMkkpSampleList(C_ZennouToukeiListKbn pZennoutoukeilistkbn, C_ZennouKbn pZennoukbn, C_Segcd pKbnkeirisegcd) {
        IM_ZennouMkkpSampleList iM_ZennouMkkpSampleList =  new IM_ZennouMkkpSampleList();
        iM_ZennouMkkpSampleList.setZennoutoukeilistkbn(pZennoutoukeilistkbn);
        iM_ZennouMkkpSampleList.setZennoukbn(pZennoukbn);
        iM_ZennouMkkpSampleList.setKbnkeirisegcd(pKbnkeirisegcd);
        return this.selectOne(iM_ZennouMkkpSampleList);
    }

}
