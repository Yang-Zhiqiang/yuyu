package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_JigyouIkkatuHenkin;

/**
 * 事業一括返金テーブル(HT_JigyouIkkatuHenkinDao) アクセス用の DAO クラスです。<br />
 */
public class HT_JigyouIkkatuHenkinDao extends AbstractDao<HT_JigyouIkkatuHenkin> {

    public HT_JigyouIkkatuHenkinDao() {
        super(HT_JigyouIkkatuHenkin.class);
    }

    @Deprecated
    public HT_JigyouIkkatuHenkin getJigyouIkkatuHenkin(String pDaimosno,
         Integer pRenno){
        HT_JigyouIkkatuHenkin hT_JigyouIkkatuHenkin =  new HT_JigyouIkkatuHenkin();
        hT_JigyouIkkatuHenkin.setDaimosno(pDaimosno);
        hT_JigyouIkkatuHenkin.setRenno(pRenno);
        return this.selectOne(hT_JigyouIkkatuHenkin);
    }

    @Override
    @Deprecated
    public List<HT_JigyouIkkatuHenkin> selectAll() {
        return super.selectAll();
    }
}
