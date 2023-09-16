package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRNyuukin;

/**
 * 入金ＴＲテーブル(IT_TRNyuukinDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRNyuukinDao extends AbstractDao<IT_TRNyuukin> {

    public IT_TRNyuukinDao() {
        super(IT_TRNyuukin.class);
    }

    public IT_TRNyuukin getTRNyuukin(String pSyono,
         BizDate pSyoriYmd,
         String pNyktrrenno,
         Integer pDatarenno){
        IT_TRNyuukin iT_TRNyuukin =  new IT_TRNyuukin();
        iT_TRNyuukin.setSyono(pSyono);
        iT_TRNyuukin.setSyoriYmd(pSyoriYmd);
        iT_TRNyuukin.setNyktrrenno(pNyktrrenno);
        iT_TRNyuukin.setDatarenno(pDatarenno);
        return this.selectOne(iT_TRNyuukin);
    }
}
