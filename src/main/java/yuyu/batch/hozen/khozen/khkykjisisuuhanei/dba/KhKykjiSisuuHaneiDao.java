package yuyu.batch.hozen.khozen.khkykjisisuuhanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KykSyouhn;

import com.google.common.collect.Collections2;

/**
 * 契約保全 契約保全 契約時指数反映の機能DAOクラス
 */
public class KhKykjiSisuuHaneiDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<SisuuHaneiBean> getSisuuHanei(BizDate pSyoriYokueigyoYmd, String pKakutyoujobcd) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + $NEW(SisuuHaneiBean.class,
            qIT_KykSyouhn.kykymd,
            qIT_KykSyouhn.sisuukbn,
            qIT_KhSisuurendoTmttkn.kbnkey,
            qIT_KhSisuurendoTmttkn.syono,
            qIT_KhSisuurendoTmttkn.tmttkntaisyouym,
            qIT_KhSisuurendoTmttkn.renno) +
            $FROM(qIT_KykSyouhn
                , qIT_KhSisuurendoTmttkn) +
                $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.eq(qIT_KykSyouhn.kykymd) +
                $AND + qIT_KykSyouhn.kykymd.le(pSyoriYokueigyoYmd) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.tmttknhaibunjyoutai.in
                (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY, C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU) +
                $AND + qIT_KhSisuurendoTmttkn.tmttknhaneitmmshanteiymd.isNull();

        ExDBResults<SisuuHaneiBean> exDBResults = exDBEntityManager.createJPQL(strSql, SisuuHaneiBean.class)
            .bind(qIT_KykSyouhn, qIT_KhSisuurendoTmttkn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttknByTmttkntaisyouymRenno(IT_KykKihon pKykKihon,
        BizDateYM pTmttkntaisyouym, Integer pRenno) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList = pKykKihon.getKhSisuurendoTmttkns();

        return new ArrayList<IT_KhSisuurendoTmttkn>(Collections2.filter(khSisuurendoTmttknList,
            new FilterKhSisuurendoTmttkn1(pTmttkntaisyouym, pRenno))).get(0);
    }
}