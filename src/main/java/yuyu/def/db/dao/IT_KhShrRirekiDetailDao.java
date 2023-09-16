package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;

/**
 * 契約保全支払履歴明細テーブル(IT_KhShrRirekiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhShrRirekiDetailDao extends AbstractDao<IT_KhShrRirekiDetail> {

    public IT_KhShrRirekiDetailDao() {
        super(IT_KhShrRirekiDetail.class);
    }

    @Deprecated
    public IT_KhShrRirekiDetail getKhShrRirekiDetail(String pSyono,
        String pHenkousikibetukey,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno){
        IT_KhShrRirekiDetail iT_KhShrRirekiDetail =  new IT_KhShrRirekiDetail();
        iT_KhShrRirekiDetail.setSyono(pSyono);
        iT_KhShrRirekiDetail.setHenkousikibetukey(pHenkousikibetukey);
        iT_KhShrRirekiDetail.setSyouhncd(pSyouhncd);
        iT_KhShrRirekiDetail.setSyouhnsdno(pSyouhnsdno);
        iT_KhShrRirekiDetail.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_KhShrRirekiDetail);
    }

    @Override
    @Deprecated
    public List<IT_KhShrRirekiDetail> selectAll() {
        return super.selectAll();
    }

    public List<IT_KhShrRirekiDetail> getKhShrRirekiDetailSumDataBySyonoHenkousikibetukey(String pSyono,
        String pHenkousikibetukey) {

        IT_KhShrRirekiDetail iT_KhShrRirekiDetail = new IT_KhShrRirekiDetail();
        iT_KhShrRirekiDetail.setSyono(pSyono);
        iT_KhShrRirekiDetail.setHenkousikibetukey(pHenkousikibetukey);

        return this.select(iT_KhShrRirekiDetail);
    }
}
