package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_KhShrRirekiDetail;

/**
 * 契約保全支払履歴明細バックアップテーブル(IT_BAK_KhShrRirekiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_KhShrRirekiDetailDao extends AbstractDao<IT_BAK_KhShrRirekiDetail> {

    public IT_BAK_KhShrRirekiDetailDao() {
        super(IT_BAK_KhShrRirekiDetail.class);
    }

    @Deprecated
    public IT_BAK_KhShrRirekiDetail getBAKKhShrRirekiDetail(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_BAK_KhShrRirekiDetail iT_BAK_KhShrRirekiDetail =  new IT_BAK_KhShrRirekiDetail();
        iT_BAK_KhShrRirekiDetail.setSyono(pSyono);
        iT_BAK_KhShrRirekiDetail.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_KhShrRirekiDetail.setHenkousikibetukey(pHenkousikibetukey);
        iT_BAK_KhShrRirekiDetail.setSyouhncd(pSyouhncd);
        iT_BAK_KhShrRirekiDetail.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_KhShrRirekiDetail.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_BAK_KhShrRirekiDetail);
    }

    @Override
    @Deprecated
    public List<IT_BAK_KhShrRirekiDetail> selectAll() {
        return super.selectAll();
    }
}
