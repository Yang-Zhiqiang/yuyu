package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_NenkinInfo;

/**
 * 年金情報テーブル(JT_NenkinInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_NenkinInfoDao extends AbstractDao<JT_NenkinInfo> {

    public JT_NenkinInfoDao() {
        super(JT_NenkinInfo.class);
    }

    @Deprecated
    public JT_NenkinInfo getNenkinInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_NenkinInfo jT_NenkinInfo =  new JT_NenkinInfo();
        jT_NenkinInfo.setSkno(pSkno);
        jT_NenkinInfo.setSyono(pSyono);
        jT_NenkinInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_NenkinInfo);
    }

    @Override
    @Deprecated
    public List<JT_NenkinInfo> selectAll() {
        return super.selectAll();
    }
}
