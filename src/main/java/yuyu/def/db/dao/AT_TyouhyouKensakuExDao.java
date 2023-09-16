package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

/**
 * 帳票検索テーブル(T_TyouhyouKensaku) テーブルアクセス用の DAO クラスです。
 */
public class AT_TyouhyouKensakuExDao extends AbstractDao<AT_TyouhyouKensaku> {

    protected AT_TyouhyouKensakuExDao() {
        super(AT_TyouhyouKensaku.class);
    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd,
        String pSubSystemId, BizDate pSyoriYmd, Integer pOutCount) {


        QAT_TyouhyouKensaku qAT_TyouhyouKensaku = new QAT_TyouhyouKensaku();
        String mainQuerryStr = $SELECT + qAT_TyouhyouKensaku +
            $FROM + qAT_TyouhyouKensaku.AT_TyouhyouKensaku() +
            $WHERE + qAT_TyouhyouKensaku.syoruiCd.eq(pSyoruiCd) +
            $AND + qAT_TyouhyouKensaku.subSystemId.eq(pSubSystemId) +
            $AND + qAT_TyouhyouKensaku.syoriYmd.eq(pSyoriYmd) +
            $AND + qAT_TyouhyouKensaku.outCount.eq(pOutCount) +
            $ORDER_BY(qAT_TyouhyouKensaku.syoriYmd.desc(),
                qAT_TyouhyouKensaku.kensakuKey1.asc(),
                qAT_TyouhyouKensaku.kensakuKey2.asc(),
                qAT_TyouhyouKensaku.kensakuKey3.asc(),
                qAT_TyouhyouKensaku.kensakuKey4.asc(),
                qAT_TyouhyouKensaku.kensakuKey5.asc());

        return em.createJPQL(mainQuerryStr).bind(qAT_TyouhyouKensaku).getResultList();

    }

    public Long getTyouhyouKensakuCountByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd, String pKensakuKey1,
        String pKensakuKey2, String pKensakuKey3, String pKensakuKey4, String pKensakuKey5, BizDate pTyouhyouymdfrom,
        BizDate pTyouhyouymdto) {


        QAT_TyouhyouKensaku qAT_TyouhyouKensaku = new QAT_TyouhyouKensaku();

        String mainQuerryStr = $SELECT + $COUNT + "(*)" +
            $FROM + qAT_TyouhyouKensaku.AT_TyouhyouKensaku() +
            $WHERE + qAT_TyouhyouKensaku.subSystemId.eq(pSubSystemId) +
            $AND + qAT_TyouhyouKensaku.syoruiCd.eq(pSyoruiCd);


        if(!BizUtil.isBlank(pKensakuKey1)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey1.eq(pKensakuKey1);
        }

        if(!BizUtil.isBlank(pKensakuKey2)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey2.eq(pKensakuKey2);
        }

        if(!BizUtil.isBlank(pKensakuKey3)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey3.eq(pKensakuKey3);
        }

        if(!BizUtil.isBlank(pKensakuKey4)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey4.eq(pKensakuKey4);
        }

        if(!BizUtil.isBlank(pKensakuKey5)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey5.eq(pKensakuKey5);

        }

        if (pTyouhyouymdto == null) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.syoriYmd.eq(pTyouhyouymdfrom);
        }
        else {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.syoriYmd.ge(pTyouhyouymdfrom) +
                $AND + qAT_TyouhyouKensaku.syoriYmd.le(pTyouhyouymdto);
        }

        return em.createJPQL(mainQuerryStr).bind(qAT_TyouhyouKensaku).getSingleResult();
    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakusByKensakuInfo(String pSubSystemId, C_SyoruiCdKbn pSyoruiCd,
        String pKensakuKey1, String pKensakuKey2, String pKensakuKey3, String pKensakuKey4, String pKensakuKey5,
        BizDate pTyouhyouymdfrom, BizDate pTyouhyouymdto) {


        QAT_TyouhyouKensaku qAT_TyouhyouKensaku = new QAT_TyouhyouKensaku();

        String mainQuerryStr = $SELECT + qAT_TyouhyouKensaku +
            $FROM + qAT_TyouhyouKensaku.AT_TyouhyouKensaku() +
            $WHERE + qAT_TyouhyouKensaku.subSystemId.eq(pSubSystemId) +
            $AND + qAT_TyouhyouKensaku.syoruiCd.eq(pSyoruiCd);


        if(!BizUtil.isBlank(pKensakuKey1)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey1.eq(pKensakuKey1);
        }

        if(!BizUtil.isBlank(pKensakuKey2)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey2.eq(pKensakuKey2);
        }

        if(!BizUtil.isBlank(pKensakuKey3)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey3.eq(pKensakuKey3);
        }

        if(!BizUtil.isBlank(pKensakuKey4)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey4.eq(pKensakuKey4);
        }

        if(!BizUtil.isBlank(pKensakuKey5)) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.kensakuKey5.eq(pKensakuKey5);

        }

        if (pTyouhyouymdto == null) {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.syoriYmd.eq(pTyouhyouymdfrom);
        }
        else {

            mainQuerryStr = mainQuerryStr + $AND + qAT_TyouhyouKensaku.syoriYmd.ge(pTyouhyouymdfrom) +
                $AND + qAT_TyouhyouKensaku.syoriYmd.le(pTyouhyouymdto);
        }

        mainQuerryStr = mainQuerryStr + $ORDER_BY(qAT_TyouhyouKensaku.syoriYmd.desc(),
            qAT_TyouhyouKensaku.kensakuKey1.asc(),
            qAT_TyouhyouKensaku.kensakuKey2.asc(),
            qAT_TyouhyouKensaku.kensakuKey3.asc(),
            qAT_TyouhyouKensaku.kensakuKey4.asc(),
            qAT_TyouhyouKensaku.kensakuKey5.asc());


        return em.createJPQL(mainQuerryStr).bind(qAT_TyouhyouKensaku).getResultList();
    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakusByTyouhyouJoinKey(String pTyouhyouJoinKey) {

        QAT_TyouhyouHozon qAT_TyouhyouHozon = new QAT_TyouhyouHozon();


        QAT_TyouhyouKensaku qAT_TyouhyouKensaku = new QAT_TyouhyouKensaku();

        String mainQuerryStr = $SELECT + qAT_TyouhyouKensaku +
            $FROM + qAT_TyouhyouHozon.AT_TyouhyouHozon() + "," +
            qAT_TyouhyouKensaku.AT_TyouhyouKensaku() +
            $WHERE + qAT_TyouhyouHozon.tyouhyouJoinKey.eq(pTyouhyouJoinKey) +
            $AND + qAT_TyouhyouHozon.reportKey.eq(qAT_TyouhyouKensaku.reportKey) +
            $ORDER_BY(qAT_TyouhyouKensaku.reportKey.asc());

        return em.createJPQL(mainQuerryStr).bind(qAT_TyouhyouHozon, qAT_TyouhyouKensaku).getResultList();
    }
}
