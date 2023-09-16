package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.def.db.meta.QHT_JigyouIkkatuNyuukin;

/**
 * 事業一括入金テーブル(HT_JigyouIkkatuNyuukinDao) アクセス用の DAO クラスです。<br />
 */
public class HT_JigyouIkkatuNyuukinDao extends AbstractDao<HT_JigyouIkkatuNyuukin> {

    public HT_JigyouIkkatuNyuukinDao() {
        super(HT_JigyouIkkatuNyuukin.class);
    }

    @Deprecated
    public HT_JigyouIkkatuNyuukin getJigyouIkkatuNyuukin(String pDaimosno,
            Integer pRenno){
        HT_JigyouIkkatuNyuukin hT_JigyouIkkatuNyuukin =  new HT_JigyouIkkatuNyuukin();
        hT_JigyouIkkatuNyuukin.setDaimosno(pDaimosno);
        hT_JigyouIkkatuNyuukin.setRenno(pRenno);
        return this.selectOne(hT_JigyouIkkatuNyuukin);
    }

    public Integer getJigyouIkkatuNyuukinMaxRennoByDaimosno(String pDaimosno) {


        QHT_JigyouIkkatuNyuukin qHT_JigyouIkkatuNyuukin = new QHT_JigyouIkkatuNyuukin();


        String quertSql = $SELECT + $MAX(qHT_JigyouIkkatuNyuukin.renno) +
                $FROM + qHT_JigyouIkkatuNyuukin.HT_JigyouIkkatuNyuukin() +
                $WHERE + qHT_JigyouIkkatuNyuukin.daimosno.eq(pDaimosno);


        return em.createJPQL(quertSql).bind(qHT_JigyouIkkatuNyuukin).getSingleResult();
    }

    @Override
    @Deprecated
    public List<HT_JigyouIkkatuNyuukin> selectAll() {
        return super.selectAll();
    }
}
