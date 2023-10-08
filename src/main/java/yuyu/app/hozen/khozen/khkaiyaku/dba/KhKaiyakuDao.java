package yuyu.app.hozen.khozen.khkaiyaku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.db.meta.QIT_KhHasseijiKazeiRireki;

/**
 * 契約保全 契約保全 解約機能DAOクラス
 */
public class KhKaiyakuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getPMinyuuSyoumetuHasseijiKazeiRirekiCountBySyono(String pSyono) {

        QIT_KhHasseijiKazeiRireki qIT_KhHasseijiKazeiRireki = new QIT_KhHasseijiKazeiRireki("qIT_KhHasseijiKazeiRireki");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhHasseijiKazeiRireki) +
            $WHERE + qIT_KhHasseijiKazeiRireki.syono.eq(pSyono) +
            $AND + qIT_KhHasseijiKazeiRireki.hasseijikazeisyorikbn.eq(C_HasseijikazeisyoriKbn.PMINYUUSYOUMETU) +
            $AND + qIT_KhHasseijiKazeiRireki.shrtysysyuruikbn.ne(C_HtsiryosyuKbn.BLNK);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHasseijiKazeiRireki).getSingleResult();
    }
}