package yuyu.app.hozen.khozen.khgengaku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_KhSisuurendoTmttkn;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全 減額機能DAOクラス
 */
public class KhGengakuDao {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getSisuurendoTmttknCountBySyonoTmttkntaisyouym(String pSyono, BizDateYM pTmttknTaisyouYm) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttkntaisyouym.eq(pTmttknTaisyouYm);


        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSisuurendoTmttkn).getSingleResult();
    }

    public List<IT_KhSisuurendoTmttkn> getSisuurendoTmttknsBySyonoTmttkntaisyouym(String pSyoNo, BizDateYM pTmttknTaisyouYm) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = kykKihon.getKhSisuurendoTmttkns();

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList2 = new ArrayList<IT_KhSisuurendoTmttkn>(Collections2.filter(
            khSisuurendoTmttknList, new FilterKhSisuurendoTmttkn1(pTmttknTaisyouYm)));

        SortIT_KhSisuurendoTmttkn sortIT_KhSisuurendoTmttkn = new SortIT_KhSisuurendoTmttkn();

        return sortIT_KhSisuurendoTmttkn.OrderIT_KhSisuurendoTmttknByPkDesc(khSisuurendoTmttknList2);

    }

    public IT_KhTtdkRireki getKhTtdkRirekisMkhgktttYendthnktorikesiBySyono(String pSyoNo) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        List<IT_KhTtdkRireki> khTtdkRirekiList = kykKihon.getKhTtdkRirekis();

        List<IT_KhTtdkRireki> khTtdkRirekiList2 = new ArrayList<IT_KhTtdkRireki>(Collections2.filter(
            khTtdkRirekiList, new FilterKhTtdkRireki1(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI)));

        if (khTtdkRirekiList2.size() == 0) {
            return null;
        }

        SortIT_KhTtdkRireki sortIT_KhTtdkRireki = new SortIT_KhTtdkRireki();

        List<IT_KhTtdkRireki> KhTtdkRirekiList3 = sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(khTtdkRirekiList2);

        return KhTtdkRirekiList3.get(0);
    }

    public List<IT_KhTtdkRireki> getSeiteiseiKhTtdkRirekisBySyonoSyoriymd(String pSyono,BizDate pSyoriYmd) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM(qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoriYmd) +
            $AND + qIT_KhTtdkRireki.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI) +
            $AND + qIT_KhTtdkRireki.syorikbn.eq(C_SyoriKbn.SEIBETUHENKOU) ;

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki).getResultList();
    }
}
