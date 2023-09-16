package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;

/**
 * 査定名義変更情報テーブル(JT_SateiMeigihenkouInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SateiMeigihenkouInfoDao extends AbstractDao<JT_SateiMeigihenkouInfo> {

    public JT_SateiMeigihenkouInfoDao() {
        super(JT_SateiMeigihenkouInfo.class);
    }

    @Deprecated
    public JT_SateiMeigihenkouInfo getSateiMeigihenkouInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SateiMeigihenkouInfo jT_SateiMeigihenkouInfo =  new JT_SateiMeigihenkouInfo();
        jT_SateiMeigihenkouInfo.setSkno(pSkno);
        jT_SateiMeigihenkouInfo.setSyono(pSyono);
        jT_SateiMeigihenkouInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SateiMeigihenkouInfo);
    }

    @Override
    @Deprecated
    public List<JT_SateiMeigihenkouInfo> selectAll() {
        return super.selectAll();
    }
}
