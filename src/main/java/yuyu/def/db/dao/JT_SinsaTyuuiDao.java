package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SinsaTyuui;

/**
 * 審査注意テーブル(JT_SinsaTyuuiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SinsaTyuuiDao extends AbstractDao<JT_SinsaTyuui> {

    public JT_SinsaTyuuiDao() {
        super(JT_SinsaTyuui.class);
    }

    public JT_SinsaTyuui getSinsaTyuui(String pSyono){
        JT_SinsaTyuui jT_SinsaTyuui =  new JT_SinsaTyuui();
        jT_SinsaTyuui.setSyono(pSyono);
        return this.selectOne(jT_SinsaTyuui);
    }
}
