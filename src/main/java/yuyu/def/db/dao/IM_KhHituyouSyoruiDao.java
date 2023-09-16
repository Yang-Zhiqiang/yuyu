package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IM_KhHituyouSyorui;

/**
 * 契約保全必要書類マスタ(IM_KhHituyouSyoruiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_KhHituyouSyoruiDao extends AbstractDao<IM_KhHituyouSyorui> {

    public IM_KhHituyouSyoruiDao() {
        super(IM_KhHituyouSyorui.class);
    }

    public IM_KhHituyouSyorui getKhHituyouSyorui(String pKinouId,
        Integer pHanteikbn1,
        Integer pHanteikbn2,
        Integer pHanteikbn3,
        Integer pHtysrirenno){
        IM_KhHituyouSyorui iM_KhHituyouSyorui =  new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui.setKinouId(pKinouId);
        iM_KhHituyouSyorui.setHanteikbn1(pHanteikbn1);
        iM_KhHituyouSyorui.setHanteikbn2(pHanteikbn2);
        iM_KhHituyouSyorui.setHanteikbn3(pHanteikbn3);
        iM_KhHituyouSyorui.setHtysrirenno(pHtysrirenno);
        return this.selectOne(iM_KhHituyouSyorui);
    }

    public List<IM_KhHituyouSyorui> getKhHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2Hanteikbn3(String pKinouId,
        Integer pHanteikbn1, Integer pHanteikbn2, Integer pHanteikbn3) {
        IM_KhHituyouSyorui iM_KhHituyouSyorui = new IM_KhHituyouSyorui();
        iM_KhHituyouSyorui.setKinouId(pKinouId);
        iM_KhHituyouSyorui.setHanteikbn1(pHanteikbn1);
        iM_KhHituyouSyorui.setHanteikbn2(pHanteikbn2);
        iM_KhHituyouSyorui.setHanteikbn3(pHanteikbn3);

        return this.select(iM_KhHituyouSyorui);
    }
}
