package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_KoudosgKeizenChkInfo;

/**
 * 高度障害契前チェック情報テーブル(JT_KoudosgKeizenChkInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_KoudosgKeizenChkInfoDao extends AbstractDao<JT_KoudosgKeizenChkInfo> {

    public JT_KoudosgKeizenChkInfoDao() {
        super(JT_KoudosgKeizenChkInfo.class);
    }

    @Deprecated
    public JT_KoudosgKeizenChkInfo getKoudosgKeizenChkInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_KoudosgKeizenChkInfo jT_KoudosgKeizenChkInfo =  new JT_KoudosgKeizenChkInfo();
        jT_KoudosgKeizenChkInfo.setSkno(pSkno);
        jT_KoudosgKeizenChkInfo.setSyono(pSyono);
        jT_KoudosgKeizenChkInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_KoudosgKeizenChkInfo);
    }

    @Override
    @Deprecated
    public List<JT_KoudosgKeizenChkInfo> selectAll() {
        return super.selectAll();
    }
}
