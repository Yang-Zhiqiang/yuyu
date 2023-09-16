package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * 新契約伝票データテーブル(HT_SkDenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkDenpyoDataDao extends AbstractDao<HT_SkDenpyoData> {

    public HT_SkDenpyoDataDao() {
        super(HT_SkDenpyoData.class);
    }

    public HT_SkDenpyoData getSkDenpyoData(String pDenrenno,
        Integer pEdano){
        HT_SkDenpyoData hT_SkDenpyoData =  new HT_SkDenpyoData();
        hT_SkDenpyoData.setDenrenno(pDenrenno);
        hT_SkDenpyoData.setEdano(pEdano);
        return this.selectOne(hT_SkDenpyoData);
    }

    public List<HT_SkDenpyoData> getSkDenpyoDatasByDenrenno(String pDenrenno) {
        HT_SkDenpyoData hT_SkDenpyoData =  new HT_SkDenpyoData();
        hT_SkDenpyoData.setDenrenno(pDenrenno);
        return this.select(hT_SkDenpyoData);
    }

    public List<HT_SkDenpyoData> getSkDenpyoDatasBySyono(String pSyono) {

        HT_SkDenpyoData hT_SkDenpyoData = new HT_SkDenpyoData();
        hT_SkDenpyoData.setSyono(pSyono);

        return this.select(hT_SkDenpyoData);
    }

    public ExDBUpdatableResults<HT_SkDenpyoData> getSkDenpyoDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();


        String strSql = $SELECT + qHT_SkDenpyoData +
            $FROM + qHT_SkDenpyoData.HT_SkDenpyoData() +
            $WHERE + qHT_SkDenpyoData.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qHT_SkDenpyoData.denrenno.asc(),
                qHT_SkDenpyoData.edano.asc());


        return em.createJPQL(strSql).bind(qHT_SkDenpyoData).getUpdatableResults();
    }

    public List<HT_SkDenpyoData> getSkDenpyoDatasByMosno(String pMosno) {
        HT_SkDenpyoData hT_SkDenpyoData =  new HT_SkDenpyoData();
        hT_SkDenpyoData.setMosno(pMosno);
        return this.select(hT_SkDenpyoData);
    }

    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByNyksyoriymd(String pMosno, C_Tuukasyu pRstuukasyu,
        BizDate pNyksyoriymd) {


        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = $SELECT + $NEW(BizCurrencySum.class,
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName())) +
            $FROM + qHT_SkDenpyoData.HT_SkDenpyoData() + "," +
            qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Nyuukin.nyksyoriymd.lt(pNyksyoriymd) +
            $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
            $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano) +
            $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() +
            $ORDER_BY (qHT_SkDenpyoData.denyenkagk.typeAsc());


        List<BizCurrencySum> results = em.createJPQL(strSql, BizCurrencySum.class).bind(qHT_SkDenpyoData, qHT_Nyuukin).getResultList();

        List<BizCurrency> currencies = Lists.transform(results, new Function<BizCurrencySum, BizCurrency>() {
            @Override
            public BizCurrency apply(BizCurrencySum sum) {
                return sum.toBizCurrency();
            }});
        return currencies;
    }

    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByPkakinsyoriymd(String pMosno, C_Tuukasyu pHnkntuukasyu,
        BizDate pPkakinsyoriymd) {


        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();


        QHT_Henkin qHT_Henkin = new QHT_Henkin();


        String strSql = $SELECT + $NEW(BizCurrencySum.class,
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName())) +
            $FROM + qHT_SkDenpyoData.HT_SkDenpyoData() + "," +
            qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
            $AND + qHT_Henkin.pkakinsyoriymd.lt(pPkakinsyoriymd) +
            $AND + qHT_Henkin.pkakindenrenno.eq(qHT_SkDenpyoData.denrenno) +
            $AND + qHT_Henkin.pkakindenedano.eq(qHT_SkDenpyoData.edano) +
            $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() +
            $ORDER_BY (qHT_SkDenpyoData.denyenkagk.typeAsc());


        List<BizCurrencySum> results = em.createJPQL(strSql, BizCurrencySum.class).bind(qHT_SkDenpyoData, qHT_Henkin).getResultList();

        List<BizCurrency> currencies = Lists.transform(results, new Function<BizCurrencySum, BizCurrency>() {
            @Override
            public BizCurrency apply(BizCurrencySum sum) {
                return sum.toBizCurrency();
            }});

        return currencies;
    }

    public List<BizCurrency> getSkDenpyoDataSumDenyenkagkByHenkin(String pMosno, Integer pRenno, C_Tuukasyu pHnkntuukasyu,
        BizDate pPkakinsyoriymd, BizDate pHnknsyoriymd) {


        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();


        QHT_Henkin qHT_Henkin = new QHT_Henkin();


        String strSql = $SELECT + $NEW(BizCurrencySum.class,
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName())) +
            $FROM + qHT_SkDenpyoData.HT_SkDenpyoData() + "," +
            qHT_Henkin.HT_Henkin() +
            $WHERE + qHT_Henkin.mosno.eq(pMosno) +
            $AND + qHT_Henkin.renno.eq(pRenno) +
            $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
            $AND + qHT_Henkin.pkakinsyoriymd.lt(pPkakinsyoriymd) +
            $AND + $(qHT_Henkin.hnknsyoriymd.isNull() +
                $OR + qHT_Henkin.hnknsyoriymd.ge(pHnknsyoriymd)) +
                $AND + qHT_Henkin.pkakindenrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Henkin.pkakindenedano.eq(qHT_SkDenpyoData.edano) +
                $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() +
                $ORDER_BY (qHT_SkDenpyoData.denyenkagk.typeAsc());


        List<BizCurrencySum> results = em.createJPQL(strSql, BizCurrencySum.class).bind(qHT_SkDenpyoData, qHT_Henkin).getResultList();

        List<BizCurrency> currencies = Lists.transform(results, new Function<BizCurrencySum, BizCurrency>() {
            @Override
            public BizCurrency apply(BizCurrencySum sum) {
                return sum.toBizCurrency();
            }});
        return currencies;
    }
}
