package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;

/**
 * 契約保全伝票データバックアップテーブル(IT_BAK_KhDenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhDenpyoDataDao extends AbstractDao<IT_BAK_KhDenpyoData> {

    public IT_BAK_KhDenpyoDataDao() {
        super(IT_BAK_KhDenpyoData.class);
    }

    public IT_BAK_KhDenpyoData getBAKKhDenpyoData(String pDenrenno,
        String pTrkssikibetukey,
        Integer pEdano){
        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData =  new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData.setDenrenno(pDenrenno);
        iT_BAK_KhDenpyoData.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhDenpyoData.setEdano(pEdano);
        return this.selectOne(iT_BAK_KhDenpyoData);
    }

    public List<IT_BAK_KhDenpyoData> getBAKKhDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData.setSyono(pSyono);
        iT_BAK_KhDenpyoData.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(iT_BAK_KhDenpyoData);
    }
}
