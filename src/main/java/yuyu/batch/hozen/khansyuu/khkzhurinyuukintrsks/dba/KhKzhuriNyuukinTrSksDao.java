package yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.typesafe.AbstractExDBEntity;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KhSyuunouKekkaData;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 口座振替入金ＴＲ作成DAOクラスです。
 */
public class KhKzhuriNyuukinTrSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<SyuunouKekkaDataBean> getKhSyuunouKekkaData1(String pKakutyoujobcd, String pKbnkey) {

        QIT_KhSyuunouKekkaData qIT_KhSyuunouKekkaData = new QIT_KhSyuunouKekkaData("q");

        String strSql = $SELECT + $NEW(SyuunouKekkaDataBean.class,
            qIT_KhSyuunouKekkaData.ansyuusyskbn,
            qIT_KhSyuunouKekkaData.syoriYmd,
            qIT_KhSyuunouKekkaData.syono,
            qIT_KhSyuunouKekkaData.bankcd,
            qIT_KhSyuunouKekkaData.sitencd,
            qIT_KhSyuunouKekkaData.yokinkbn,
            qIT_KhSyuunouKekkaData.kouzano,
            qIT_KhSyuunouKekkaData.hurikaeymd,
            qIT_KhSyuunouKekkaData.jyuutouym,
            qIT_KhSyuunouKekkaData.rsgaku.getTypeFieldName(),
            qIT_KhSyuunouKekkaData.rsgaku.getValueFieldName(),
            qIT_KhSyuunouKekkaData.jyutoukaisuuy,
            qIT_KhSyuunouKekkaData.jyutoukaisuum,
            qIT_KhSyuunouKekkaData.nyknaiyoukbn,
            qIT_KhSyuunouKekkaData.hrkkaisuu,
            qIT_KhSyuunouKekkaData.hurihunokbn,
            qIT_KhSyuunouKekkaData.syuudaikocd) +
            $FROM(qIT_KhSyuunouKekkaData) +
            $WHERE + qIT_KhSyuunouKekkaData.kbnkey.in(pKbnkey) +
            $ORDER_BY(qIT_KhSyuunouKekkaData.syono.asc(),
                qIT_KhSyuunouKekkaData.jyuutouym.asc());

        ExDBResults<SyuunouKekkaDataBean> exDBResults =
            exDBEntityManager.createJPQL(strSql, SyuunouKekkaDataBean.class).bind(qIT_KhSyuunouKekkaData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<SyuunouKekkaData2Bean> getKhSyuunouKekkaData2(String pKakutyoujobcd, String pKbnkey) {

        QIT_KhSyuunouKekkaData qIT_KhSyuunouKekkaData = new QIT_KhSyuunouKekkaData("qIT_KhSyuunouKekkaData");
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strSql = $SELECT + $NEW(SyuunouKekkaData2Bean.class,
            qIT_KhSyuunouKekkaData.ansyuusyskbn,
            qIT_KhSyuunouKekkaData.syoriYmd,
            qIT_KhSyuunouKekkaData.syono,
            qIT_KhSyuunouKekkaData.bankcd,
            qIT_KhSyuunouKekkaData.sitencd,
            qIT_KhSyuunouKekkaData.yokinkbn,
            qIT_KhSyuunouKekkaData.kouzano,
            qIT_KhSyuunouKekkaData.hurikaeymd,
            qIT_KhSyuunouKekkaData.rsgaku.getTypeFieldName(),
            qIT_KhSyuunouKekkaData.rsgaku.getValueFieldName(),
            qIT_KhSyuunouKekkaData.hurihunokbn,
            qIT_KhSyuunouKekkaData.kzhurikaetkbtannaihyj,
            qIT_KhSyuunouKekkaData.dantaikobetukbn,
            qIT_KhSyuunouKekkaData.syuudaikocd,
            qIT_AnsyuRireki.jyuutouym,
            qIT_AnsyuRireki.jyutoukaisuuy,
            qIT_AnsyuRireki.jyutoukaisuum,
            qIT_AnsyuRireki.nyknaiyoukbn,
            qIT_AnsyuRireki.hrkkaisuu,
            qIT_AnsyuRireki.tikiktbrisyuruikbn,
            qIT_AnsyuRireki.nykkeiro) +
            $FROM(qIT_KhSyuunouKekkaData, qIT_AnsyuRireki) +
            $WHERE + qIT_KhSyuunouKekkaData.kbnkey.in(pKbnkey) +
            $AND + qIT_KhSyuunouKekkaData.syono.eq(qIT_AnsyuRireki.syono) +
            $AND + qIT_KhSyuunouKekkaData.hurikaeymd.eq(qIT_AnsyuRireki.hurikaeymd) +
            $AND + qIT_KhSyuunouKekkaData.jyuutouym.eq(qIT_AnsyuRireki.jyuutouym) +
            $AND + qIT_KhSyuunouKekkaData.nyknaiyoukbn.eq(qIT_AnsyuRireki.nyknaiyoukbn);


        ExDBResults<SyuunouKekkaData2Bean> exDBResults =
            exDBEntityManager.createJPQL(strSql, SyuunouKekkaData2Bean.class).bind(qIT_KhSyuunouKekkaData, qIT_AnsyuRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KhSyuunouKekkaData getKhSyuunouKekkaData3(C_AnsyuusysKbn pAnsyuusysKbn,
        BizDate pSyoriymd, String pSyoNo, BizDateYM pJyuutouYm) {

        IT_KhSyuunouKekkaData khSyuunouKekkaData = hozenDomManager.getKhSyuunouKekkaData(pAnsyuusysKbn,
            pSyoriymd, pSyoNo, pJyuutouYm);

        return khSyuunouKekkaData;
    }

    public void addUpdateEntity(EntityUpdater<IT_KhSyuunouKekkaData> pEntityUpdater,
        IT_KhSyuunouKekkaData pKhSyuunouKekkaData) {

        pEntityUpdater.add(pKhSyuunouKekkaData);
    }

    public void addMultipleInsertEntity(MultipleEntityInserter pMultipleEntityInserter,
        AbstractExDBEntity<?, ?> pKhSyuunouKekkaData) {

        pMultipleEntityInserter.add(pKhSyuunouKekkaData);
    }
}
