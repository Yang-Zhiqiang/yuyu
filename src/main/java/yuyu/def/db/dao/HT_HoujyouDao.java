package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.db.entity.HT_Houjyou;

/**
 * 報状テーブル(HT_HoujyouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HoujyouDao extends AbstractDao<HT_Houjyou> {

    public HT_HoujyouDao() {
        super(HT_Houjyou.class);
    }

    @Deprecated
    public HT_Houjyou getHoujyou(String pMosno,
         C_SyosaiKbn pSyosaikbn){
        HT_Houjyou hT_Houjyou =  new HT_Houjyou();
        hT_Houjyou.setMosno(pMosno);
        hT_Houjyou.setSyosaikbn(pSyosaikbn);
        return this.selectOne(hT_Houjyou);
    }

    @Override
    @Deprecated
    public List<HT_Houjyou> selectAll() {
        return super.selectAll();
    }
}
