package yuyu.batch.hozen.khansyuu.khnyuukin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.meta.QIT_TRNyuukin;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 入金処理 の機能DAOクラス
 */
public class KhNyuukinDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<IT_TRNyuukinBean> getTRNyuukin(String pKakutyoujobcd, String pHeisoukbn) {

        QIT_TRNyuukin qIT_TRNyuukin = new QIT_TRNyuukin("qIT_TRNyuukin");

        String where = "";
        if (!BizUtil.isBlank(pHeisoukbn)) {
            where = $WHERE + qIT_TRNyuukin.kbnkey.eq(pHeisoukbn);
        }

        String strSql = $SELECT + $NEW(IT_TRNyuukinBean.class,
            qIT_TRNyuukin.syono,
            qIT_TRNyuukin.kbnkey,
            qIT_TRNyuukin.syoriYmd,
            qIT_TRNyuukin.nyktrrenno,
            qIT_TRNyuukin.datarenno,
            qIT_TRNyuukin.nykkeiro,
            qIT_TRNyuukin.hrkkaisuu,
            qIT_TRNyuukin.nyknaiyoukbn,
            qIT_TRNyuukin.jyuutouym,
            qIT_TRNyuukin.jyutoukaisuuy,
            qIT_TRNyuukin.jyutoukaisuum,
            qIT_TRNyuukin.rsgaku.getTypeFieldName(),
            qIT_TRNyuukin.rsgaku.getValueFieldName(),
            qIT_TRNyuukin.ryosyuymd,
            qIT_TRNyuukin.iktnyuukinnumu,
            qIT_TRNyuukin.kzhurikaebankcd,
            qIT_TRNyuukin.kzhurikaesitencd,
            qIT_TRNyuukin.nykdenymd,
            qIT_TRNyuukin.tikiktbrisyuruikbn,
            qIT_TRNyuukin.nyknkwsratekijyunymd,
            qIT_TRNyuukin.creditkessaiyouno,
            qIT_TRNyuukin.syuudaikocd,
            qIT_TRNyuukin.credituriageseikyuukbn) +
            $FROM(qIT_TRNyuukin) +
            where +
            $ORDER_BY(qIT_TRNyuukin.nykkeiro.desc(),
                qIT_TRNyuukin.credituriageseikyuukbn.asc(),
                qIT_TRNyuukin.nyknaiyoukbn.desc(),
                qIT_TRNyuukin.syono.asc(),
                qIT_TRNyuukin.jyuutouym.asc(),
                qIT_TRNyuukin.nyktrrenno.asc(),
                qIT_TRNyuukin.datarenno.asc());

        ExDBResults<IT_TRNyuukinBean> exDBResults = exDBEntityManager.createJPQL(strSql, IT_TRNyuukinBean.class)
            .bind(qIT_TRNyuukin).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_TRNyuukin getTRNyuukin2(String pSyono, BizDate pSyoriYmd, String pNyktrrenno, Integer pDatarenno) {

        QIT_TRNyuukin qIT_TRNyuukin = new QIT_TRNyuukin("qIT_TRNyuukin");

        String sql = $SELECT + qIT_TRNyuukin +
            $FROM(qIT_TRNyuukin) +
            $WHERE + qIT_TRNyuukin.syono.eq(pSyono) +
            $AND + qIT_TRNyuukin.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_TRNyuukin.nyktrrenno.eq(pNyktrrenno) +
            $AND + qIT_TRNyuukin.datarenno.eq(pDatarenno);

        return exDBEntityManager.createJPQL(sql).bind(qIT_TRNyuukin).getSingleResult();

    }

    public IT_KykKihon getKykKihon(String pSyono) {

        return hozenDomManager.getKykKihon(pSyono);
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        return hozenDomManager.getAnsyuKihon(pSyono);
    }

    public void addMultipleUpdateEntity(MultipleEntityUpdater pMultipleEntityUpdater,
        AbstractExDBEntity<?, ?> pTblEntity) {

        pMultipleEntityUpdater.add(pTblEntity);
    }

    public void addMultipleInserterEntity(MultipleEntityInserter pMultipleEntityInserter,
        AbstractExDBEntity<?, ?> pTblEntity) {

        pMultipleEntityInserter.add(pTblEntity);
    }

    public IT_KhTtdkRireki createKhTtdkRireki(IT_KykKihon pKykKihon) {
        return pKykKihon.createKhTtdkRireki();

    }


}
