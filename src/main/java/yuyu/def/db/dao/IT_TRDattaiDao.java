package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_TRDattai;

/**
 * 脱退ＴＲテーブル(IT_TRDattaiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TRDattaiDao extends AbstractDao<IT_TRDattai> {

    public IT_TRDattaiDao() {
        super(IT_TRDattai.class);
    }

    public IT_TRDattai getTRDattai(String pSyono,
         BizDate pSyoriYmd,
         String pDattaitrrenno){
        IT_TRDattai iT_TRDattai =  new IT_TRDattai();
        iT_TRDattai.setSyono(pSyono);
        iT_TRDattai.setSyoriYmd(pSyoriYmd);
        iT_TRDattai.setDattaitrrenno(pDattaitrrenno);
        return this.selectOne(iT_TRDattai);
    }
}
