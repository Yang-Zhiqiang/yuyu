package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;

/**
 * 査定告反情報テーブル(JT_SateiKokuhanInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiKokuhanInfoDao extends AbstractDao<JT_SateiKokuhanInfo> {

    public JT_SateiKokuhanInfoDao() {
        super(JT_SateiKokuhanInfo.class);
    }

    @Deprecated
    public JT_SateiKokuhanInfo getSateiKokuhanInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SateiKokuhanInfo jT_SateiKokuhanInfo =  new JT_SateiKokuhanInfo();
        jT_SateiKokuhanInfo.setSkno(pSkno);
        jT_SateiKokuhanInfo.setSyono(pSyono);
        jT_SateiKokuhanInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SateiKokuhanInfo);
    }

    @Override
    @Deprecated
    public List<JT_SateiKokuhanInfo> selectAll() {
        return super.selectAll();
    }
}
