package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;

/**
 * 仮受金整備督促情報テーブル(IT_KrkknSeibiTokusokuInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KrkknSeibiTokusokuInfoDao extends AbstractDao<IT_KrkknSeibiTokusokuInfo> {

    public IT_KrkknSeibiTokusokuInfoDao() {
        super(IT_KrkknSeibiTokusokuInfo.class);
    }

    public IT_KrkknSeibiTokusokuInfo getKrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno) {
        IT_KrkknSeibiTokusokuInfo iT_KrkknSeibiTokusokuInfo =  new IT_KrkknSeibiTokusokuInfo();
        iT_KrkknSeibiTokusokuInfo.setSyono(pSyono);
        iT_KrkknSeibiTokusokuInfo.setKrkno(pKrkno);
        return this.selectOne(iT_KrkknSeibiTokusokuInfo);
    }

}
