package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_HengakuCfDenpyo;

/**
 * 変額ＣＦ伝票テーブル(IT_HengakuCfDenpyoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HengakuCfDenpyoDao extends AbstractDao<IT_HengakuCfDenpyo> {

    public IT_HengakuCfDenpyoDao() {
        super(IT_HengakuCfDenpyo.class);
    }

    public IT_HengakuCfDenpyo getHengakuCfDenpyo(String pDenrenno,
         Integer pEdano){
        IT_HengakuCfDenpyo iT_HengakuCfDenpyo =  new IT_HengakuCfDenpyo();
        iT_HengakuCfDenpyo.setDenrenno(pDenrenno);
        iT_HengakuCfDenpyo.setEdano(pEdano);
        return this.selectOne(iT_HengakuCfDenpyo);
    }
}
