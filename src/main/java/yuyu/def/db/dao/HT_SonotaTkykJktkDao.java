package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.HT_SonotaTkykJktk;

/**
 * その他特約条件付テーブル(HT_SonotaTkykJktkDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SonotaTkykJktkDao extends AbstractDao<HT_SonotaTkykJktk> {

    public HT_SonotaTkykJktkDao() {
        super(HT_SonotaTkykJktk.class);
    }

    @Deprecated
    public HT_SonotaTkykJktk getSonotaTkykJktk(String pMosno,
         C_PmnjtkKbn pPmnjtkkbn){
        HT_SonotaTkykJktk hT_SonotaTkykJktk =  new HT_SonotaTkykJktk();
        hT_SonotaTkykJktk.setMosno(pMosno);
        hT_SonotaTkykJktk.setPmnjtkkbn(pPmnjtkkbn);
        return this.selectOne(hT_SonotaTkykJktk);
    }

    @Override
    @Deprecated
    public List<HT_SonotaTkykJktk> selectAll() {
        return super.selectAll();
    }
}
