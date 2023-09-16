package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

import com.google.common.base.Strings;

/**
 * 帳票検索テーブル(T_TyouhyouKensaku) テーブルアクセス用の DAO クラスです。
 */
public class AT_TyouhyouKensakuDao extends AbstractDao<AT_TyouhyouKensaku> {

    protected AT_TyouhyouKensakuDao() {
        super(AT_TyouhyouKensaku.class);
    }

    public AT_TyouhyouKensaku getAT_TyouhyouKensaku(String pKensakuId) {
        AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();
        tyouhyouKensaku.setUniqueId(pKensakuId);
        return selectOne(tyouhyouKensaku);
    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakuListByCategoryIdSousasya(String pCategoryId, String pSousasya) {
        AT_TyouhyouKensaku tyouhyouKensaku = new AT_TyouhyouKensaku();
        if (!Strings.isNullOrEmpty(pCategoryId)) {
            tyouhyouKensaku.setCategoryId(pCategoryId);
        }
        if (!Strings.isNullOrEmpty(pSousasya)) {
            tyouhyouKensaku.setKousinsyaId(pSousasya);
        }
        return select(tyouhyouKensaku);
    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySyoruiCdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {

        QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();


        String query =
            $SELECT + kensaku +
            $FROM + kensaku.AT_TyouhyouKensaku() +
            $WHERE +
            makeWhereBySyoruiCdSyoriYmdOutCount(kensaku, pSyoruiCd, pSyoriYmd, pOutCount) +
            $ORDER_BY(
                kensaku.syoruiCd.asc(),
                kensaku.pageCount.desc(),
                kensaku.kensakuKey1.asc(),
                kensaku.kensakuKey2.asc(),
                kensaku.kensakuKey3.asc(),
                kensaku.kensakuKey4.asc(),
                kensaku.kensakuKey5.asc()
                );


        return select(query, kensaku);
    }

    public long getTyouhyouKensakuCountBySyoruiCdSyoriYmdOutCount(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {

        QAT_TyouhyouKensaku qKensaku = new QAT_TyouhyouKensaku();


        String query =
            $SELECT + $COUNT(qKensaku.uniqueId) +
            $FROM + qKensaku.AT_TyouhyouKensaku() +
            $WHERE +
            makeWhereBySyoruiCdSyoriYmdOutCount(qKensaku, pSyoruiCd, pSyoriYmd, pOutCount);


        return em.createJPQL(query).bind(qKensaku).<Long>getSingleResult();

    }

    public List<AT_TyouhyouKensaku> getTyouhyouKensakuListBySubSystemSyoriYmdOutCount(String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {

        QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();


        String query =
            $SELECT + kensaku +
            $FROM + kensaku.AT_TyouhyouKensaku() +
            $WHERE +
            makeWhereBySubSystemSyoriYmdOutCount(kensaku, pSubSystemId, pSyoriYmd, pOutCount) +
            $ORDER_BY(
                kensaku.syoruiCd.asc(),
                kensaku.pageCount.desc(),
                kensaku.kensakuKey1.asc(),
                kensaku.kensakuKey2.asc(),
                kensaku.kensakuKey3.asc(),
                kensaku.kensakuKey4.asc(),
                kensaku.kensakuKey5.asc()
                );


        return select(query, kensaku);
    }

    public long getTyouhyouKensakuCountBySubSystemSyoriYmdOutCount(String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {

        QAT_TyouhyouKensaku kensaku = new QAT_TyouhyouKensaku();


        String query =
            $SELECT + $COUNT(kensaku.uniqueId) +
            $FROM + kensaku.AT_TyouhyouKensaku() +
            $WHERE +
            makeWhereBySubSystemSyoriYmdOutCount(kensaku, pSubSystemId, pSyoriYmd, pOutCount);


        return em.createJPQL(query).bind(kensaku).<Long>getSingleResult();

    }

    private String makeWhereBySyoruiCdSyoriYmdOutCount(QAT_TyouhyouKensaku pKensaku, C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd, String pOutCount) {
        StringBuilder where = new StringBuilder();


        where.append(pKensaku.syoriYmd.eq(pSyoriYmd));


        if (pSyoruiCd != null) {

            where.append($AND);

            where.append(pKensaku.syoruiCd.eq(pSyoruiCd));
        }


        if (!Strings.isNullOrEmpty(pOutCount)) {

            where.append($AND);

            where.append(pKensaku.outCount.ge(Integer.parseInt(pOutCount)));
        }

        return where.toString();
    }

    private String makeWhereBySubSystemSyoriYmdOutCount(QAT_TyouhyouKensaku pKensaku, String pSubSystemId, BizDate pSyoriYmd, String pOutCount) {
        StringBuilder where = new StringBuilder();


        where.append(pKensaku.syoriYmd.eq(pSyoriYmd));


        if (!Strings.isNullOrEmpty(pSubSystemId)) {

            where.append($AND);

            where.append(pKensaku.subSystemId.eq(pSubSystemId));
        }


        if (!Strings.isNullOrEmpty(pOutCount)) {

            where.append($AND);

            where.append(pKensaku.outCount.ge(Integer.parseInt(pOutCount)));
        }

        return where.toString();
    }
}
