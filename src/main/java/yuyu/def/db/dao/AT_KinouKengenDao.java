package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_KinouKengen;

/**
 * 機能権限テーブル( AT_KinouKengen ) に対するDB操作を提供する。
 */
public class AT_KinouKengenDao extends AbstractDao<AT_KinouKengen> {

    protected AT_KinouKengenDao() {
        super(AT_KinouKengen.class);
    }

    public AT_KinouKengen getKinouKengenByKinouIdKinouModeIdRoleCd(String pKinouId, String pKinouModeId, String pRoleCd){
        AT_KinouKengen kinoukengen = new AT_KinouKengen();
        kinoukengen.setKinouId(pKinouId);
        kinoukengen.setKinouModeId(pKinouModeId);
        kinoukengen.setRoleCd(pRoleCd);

        return selectOne(kinoukengen);
    }

    public List<AT_KinouKengen> getKinouKengenBySiborikomiId(String pSiborikomiId){
        AT_KinouKengen kinoukengen = new AT_KinouKengen();
        kinoukengen.setSiborikomiId(pSiborikomiId);

        return select(kinoukengen);
    }

}
