package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_UketorininVrf;

/**
 * 受取人ベリファイテーブル(HT_UketorininVrfDao) アクセス用の DAO クラスです。<br />
 */
public class HT_UketorininVrfDao extends AbstractDao<HT_UketorininVrf> {

    public HT_UketorininVrfDao() {
        super(HT_UketorininVrf.class);
    }

    @Deprecated
    public HT_UketorininVrf getUketorininVrf(String pMosno,
         C_UktsyuKbn pUktsyukbn,
         Integer pUktsyurenno){
        HT_UketorininVrf hT_UketorininVrf =  new HT_UketorininVrf();
        hT_UketorininVrf.setMosno(pMosno);
        hT_UketorininVrf.setUktsyukbn(pUktsyukbn);
        hT_UketorininVrf.setUktsyurenno(pUktsyurenno);
        return this.selectOne(hT_UketorininVrf);
    }

    @Override
    @Deprecated
    public List<HT_UketorininVrf> selectAll() {
        return super.selectAll();
    }
}
