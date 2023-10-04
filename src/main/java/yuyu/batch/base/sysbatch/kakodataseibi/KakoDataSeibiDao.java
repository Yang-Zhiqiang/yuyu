package yuyu.batch.base.sysbatch.kakodataseibi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.exception.ExIllegalArgumentException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.meta.QAT_TyouhyouHozon;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;

import com.google.common.base.Strings;

/**
 * 過去データ整備機能DAOクラス。<br />
 */
public class KakoDataSeibiDao {

    @Inject
    private ExDBEntityManager em;

    public <T> ExDBResults<T> getDataByKey(String pTableId, String pSakujyoKey, String pSakujyokijyunYmd) {

        try {
            String PREFIX = "yuyu.def.db.id.PK";
            String className = PREFIX.concat(pTableId);
            Class<?> clazz = Class.forName(className);
            Field[] fs = clazz.getDeclaredFields();

            List<String> sortKeyArr = new ArrayList<String>() ;
            for (int i = 1; fs.length > i; i ++) {
                sortKeyArr.add(fs[i].getName());
            }

            StringBuilder sb = new StringBuilder();
            sb.append($SELECT);
            sb.append("T1");
            sb.append($FROM);
            sb.append(pTableId);
            sb.append($AS);
            sb.append("T1");
            if (!Strings.isNullOrEmpty(pSakujyoKey)) {
                sb.append($WHERE);
                sb.append(pSakujyoKey);
                sb.append($LE);
                sb.append("'");
                sb.append(pSakujyokijyunYmd);
                sb.append("'");
            }

            sb.append($ORDER_BY(sortKeyArr.toArray()));

            return em.createJPQL(sb.toString()).getResults();
        } catch (ClassNotFoundException e) {
            throw new ExIllegalArgumentException(e, "指定されたテーブルID[" + pTableId + "]は不正です。");
        }

    }

    public long delDataByKey(String pTableId, String pSakujyoKey, String pSakujyokijyunYmd) {

        StringBuilder sb = new StringBuilder();
        sb.append($DELETE_FROM);
        sb.append(pTableId);
        if (!Strings.isNullOrEmpty(pSakujyoKey)) {
            sb.append($WHERE);
            sb.append(pSakujyoKey);
            sb.append($LE);
            sb.append("'");
            sb.append(pSakujyokijyunYmd);
            sb.append("'");
        }
        return em.createJPQL(sb.toString()).executeUpdate();
    }

    public Long getDataCountByKey(String pTableId, String pSakujyoKey, String pSakujyokijyunYmd) {

        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append($COUNT);
        sb.append($("*"));
        sb.append($FROM);
        sb.append(pTableId);
        sb.append($AS);
        sb.append("T1");
        if (!Strings.isNullOrEmpty(pSakujyoKey)) {
            sb.append($WHERE);
            sb.append(pSakujyoKey);
            sb.append($LE);
            sb.append("'");
            sb.append(pSakujyokijyunYmd);
            sb.append("'");
        }
        return em.createJPQL(sb.toString()).getSingleResult();
    }

    public <T> ExDBResults<T> getTyouhyouKensakuListBySyoruiCdSyoriYmd(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd) {

        QAT_TyouhyouKensaku qTyouhyouKensaku = new QAT_TyouhyouKensaku();

        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append(qTyouhyouKensaku);
        sb.append($FROM);
        sb.append(qTyouhyouKensaku.AT_TyouhyouKensaku());
        sb.append($WHERE);
        sb.append(qTyouhyouKensaku.syoruiCd.eq(pSyoruiCd));
        sb.append($AND);
        sb.append(qTyouhyouKensaku.syoriYmd.le(pSyoriYmd));
        sb.append($ORDER_BY(qTyouhyouKensaku.syoriYmd,qTyouhyouKensaku.uniqueId));

        return em.createJPQL(sb.toString()).bind(qTyouhyouKensaku).getResults();
    }

    public Long getCountTyouhyouKensakuListBySyoruiCdSyoriYmd(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd) {

        QAT_TyouhyouKensaku qTyouhyouKensaku = new QAT_TyouhyouKensaku();

        StringBuilder sb = new StringBuilder();
        sb.append($SELECT);
        sb.append($COUNT);
        sb.append($("*"));
        sb.append($FROM);
        sb.append(qTyouhyouKensaku.AT_TyouhyouKensaku());
        sb.append($WHERE);
        sb.append(qTyouhyouKensaku.syoruiCd.eq(pSyoruiCd));
        if (pSyoriYmd != null) {
            sb.append($AND);
            sb.append(qTyouhyouKensaku.syoriYmd.le(pSyoriYmd));
        }
        return em.createJPQL(sb.toString()).bind(qTyouhyouKensaku).getSingleResult();
    }

    public long deleteTyouhyouHozonByReportKey(String pReportKey) {

        QAT_TyouhyouHozon qTyouhyouHozon = new QAT_TyouhyouHozon();

        StringBuilder sb = new StringBuilder();
        sb.append($DELETE_FROM);
        sb.append(qTyouhyouHozon.AT_TyouhyouHozon());
        sb.append($WHERE);
        sb.append(qTyouhyouHozon.reportKey.eq(pReportKey));
        return em.createJPQL(sb.toString()).bind(qTyouhyouHozon).executeUpdate();

    }

    public long deleteTyouhyouKensakuListBySyoruiCdSyoriYmd(C_SyoruiCdKbn pSyoruiCd, BizDate pSyoriYmd) {

        QAT_TyouhyouKensaku qTyouhyouKensaku = new QAT_TyouhyouKensaku();

        StringBuilder sb = new StringBuilder();
        sb.append($DELETE_FROM);
        sb.append(qTyouhyouKensaku.AT_TyouhyouKensaku());
        sb.append($WHERE);
        sb.append(qTyouhyouKensaku.syoruiCd.eq(pSyoruiCd));
        sb.append($AND);
        sb.append(qTyouhyouKensaku.syoriYmd.le(pSyoriYmd));

        return em.createJPQL(sb.toString()).bind(qTyouhyouKensaku).executeUpdate();
    }
}

