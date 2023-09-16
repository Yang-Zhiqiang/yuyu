package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;

/**
 * ＡＫＳ連動済請求契約情報テーブル(JT_AksrendouzumiSkKykInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_AksrendouzumiSkKykInfoDao extends AbstractDao<JT_AksrendouzumiSkKykInfo> {

    public JT_AksrendouzumiSkKykInfoDao() {
        super(JT_AksrendouzumiSkKykInfo.class);
    }

    public JT_AksrendouzumiSkKykInfo getAksrendouzumiSkKykInfo(String pSkno, String pSyono) {
        JT_AksrendouzumiSkKykInfo jT_AksrendouzumiSkKykInfo =  new JT_AksrendouzumiSkKykInfo();
        jT_AksrendouzumiSkKykInfo.setSkno(pSkno);
        jT_AksrendouzumiSkKykInfo.setSyono(pSyono);
        return this.selectOne(jT_AksrendouzumiSkKykInfo);
    }

}
