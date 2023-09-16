package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_TyouhyouHozon;

import com.google.common.base.Strings;

/**
 * 帳票保存テーブル(T_TyouhyouHozon) テーブルアクセス用の DAO クラスです。
 */
public class AT_TyouhyouHozonDao extends AbstractDao<AT_TyouhyouHozon> {

    protected AT_TyouhyouHozonDao() {
        super(AT_TyouhyouHozon.class);
    }

    public AT_TyouhyouHozon getAT_TyouhyouHozon(String pReportKey) {
        AT_TyouhyouHozon tyouhyouHozon = new AT_TyouhyouHozon();
        tyouhyouHozon.setReportKey(pReportKey);
        return selectOne(tyouhyouHozon);
    }

    public List<AT_TyouhyouHozon> getTyouhyouHozonList(String pTyouhyouJoinKey, String pSousasya) {
        AT_TyouhyouHozon tyouhyouHozon = new AT_TyouhyouHozon();
        if (!Strings.isNullOrEmpty(pTyouhyouJoinKey)) {
            tyouhyouHozon.setTyouhyouJoinKey(pTyouhyouJoinKey);
        }
        if (!Strings.isNullOrEmpty(pSousasya)) {
            tyouhyouHozon.setKousinsyaId(pSousasya);
        }
        return select(tyouhyouHozon);
    }
}
