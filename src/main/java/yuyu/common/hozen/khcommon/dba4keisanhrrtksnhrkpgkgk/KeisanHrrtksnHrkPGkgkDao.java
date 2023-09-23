package yuyu.common.hozen.khcommon.dba4keisanhrrtksnhrkpgkgk;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_Zennou;

/**
 * 契約保全 契約保全共通 返戻率計算用払込保険料合計額計算Daoクラス
 */
public class KeisanHrrtksnHrkPGkgkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<C_UmuKbn> getShrRirekiBySyono(String pSyono) {

        QIT_KhShrRireki qIT_ShrRireki = new QIT_KhShrRireki("t1");

        String strSql = $SELECT + qIT_ShrRireki.zeitekiazukarikinkjumu +
            $FROM(qIT_ShrRireki) +
            $WHERE + qIT_ShrRireki.syono.eq(pSyono) +
            $AND + qIT_ShrRireki.shrsyorikbn.eq(C_ShrsyoriKbn.GENGAKU) +
            $AND + qIT_ShrRireki.torikesiflg.eq(C_UmuKbn.NONE);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_ShrRireki).getResultList();
    }

    public IT_Zennou getZennouBySyono(String pSyono) {

        QIT_Zennou qIT_Zennou = new QIT_Zennou("t1");

        String strSql = $SELECT + qIT_Zennou +
            $FROM(qIT_Zennou) +
            $WHERE + qIT_Zennou.syono.eq(pSyono) +
            $AND + qIT_Zennou.zennouseisankbn.eq(C_ZennouSeisanKbn.MISEISAN) +
            $ORDER_BY(qIT_Zennou.renno.desc());

        List<IT_Zennou> zennous = exDBEntityManager.createJPQL(strSql).bind(qIT_Zennou).getResultList();

        if (zennous.size() == 0) {
            return null;
        }

        return zennous.get(0);

    }
}
