package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.JT_SiTyousyo;

/**
 * 保険金給付金支払調書テーブル(JT_SiTyousyoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiTyousyoDao extends AbstractDao<JT_SiTyousyo> {

    public JT_SiTyousyoDao() {
        super(JT_SiTyousyo.class);
    }

    public JT_SiTyousyo getSiTyousyo(String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno){
        JT_SiTyousyo jT_SiTyousyo =  new JT_SiTyousyo();
        jT_SiTyousyo.setSyono(pSyono);
        jT_SiTyousyo.setTyouhyouymd(pTyouhyouymd);
        jT_SiTyousyo.setShrtysyrenno(pShrtysyrenno);
        return this.selectOne(jT_SiTyousyo);
    }
}
