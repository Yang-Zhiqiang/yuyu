package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_FatcaInfo;

/**
 * ＦＡＴＣＡ情報バックアップテーブル(IT_BAK_FatcaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_FatcaInfoDao extends AbstractDao<IT_BAK_FatcaInfo> {

    public IT_BAK_FatcaInfoDao() {
        super(IT_BAK_FatcaInfo.class);
    }

    @Deprecated
    public IT_BAK_FatcaInfo getBAKFatcaInfo(String pSyono,
         String pTrkssikibetukey,
         Integer pRenno){
        IT_BAK_FatcaInfo iT_BAK_FatcaInfo =  new IT_BAK_FatcaInfo();
        iT_BAK_FatcaInfo.setSyono(pSyono);
        iT_BAK_FatcaInfo.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_FatcaInfo.setRenno(pRenno);
        return this.selectOne(iT_BAK_FatcaInfo);
    }

    @Override
    @Deprecated
    public List<IT_BAK_FatcaInfo> selectAll() {
        return super.selectAll();
    }
}
