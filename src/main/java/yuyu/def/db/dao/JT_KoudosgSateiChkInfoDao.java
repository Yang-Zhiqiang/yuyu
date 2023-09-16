package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_KoudosgSateiChkInfo;

/**
 * 高度障害査定チェック情報テーブル(JT_KoudosgSateiChkInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_KoudosgSateiChkInfoDao extends AbstractDao<JT_KoudosgSateiChkInfo> {

    public JT_KoudosgSateiChkInfoDao() {
        super(JT_KoudosgSateiChkInfo.class);
    }

    @Deprecated
    public JT_KoudosgSateiChkInfo getKoudosgSateiChkInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_KoudosgSateiChkInfo jT_KoudosgSateiChkInfo =  new JT_KoudosgSateiChkInfo();
        jT_KoudosgSateiChkInfo.setSkno(pSkno);
        jT_KoudosgSateiChkInfo.setSyono(pSyono);
        jT_KoudosgSateiChkInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_KoudosgSateiChkInfo);
    }

    @Override
    @Deprecated
    public List<JT_KoudosgSateiChkInfo> selectAll() {
        return super.selectAll();
    }
}
