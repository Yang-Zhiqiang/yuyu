package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_AnsyuKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_Zennou;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

/**
 * 前納充当・満了処理 の機能DAOクラス
 */
public class KhZennouJyuutouManryouDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZennouJyuutouManryouDataBean> getZennouJyuutouManryouDataBeans(BizDateYM pSyoriymd, String pIbKakutyoujobcd) {

        QIT_AnsyuKihon qIT_AnsyuKihon = new QIT_AnsyuKihon("q1");

        QIT_Zennou qIT_Zennou1 = new QIT_Zennou("q2");

        QIT_Zennou qIT_Zennou2 = new QIT_Zennou("q3");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("q4");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("q5");

        String strSubSql = $SELECT + $MAX(qIT_Zennou1.zennoukaisiymd) + $AS + "zennoustartymd" +
            $FROM(qIT_Zennou1) +
            $WHERE + qIT_Zennou1.syono.eq(qIT_AnsyuKihon.syono);

        String strSql = $SELECT + $NEW(ZennouJyuutouManryouDataBean.class,
            qIT_AnsyuKihon.syono,
            qIT_AnsyuKihon.kbnkey,
            qIT_AnsyuKihon.jkipjytym,
            qIT_KykSyouhn.syouhncd,
            qIT_KykSyouhn.syouhnsdno,
            qIT_Zennou2.zennoukaisiymd,
            qIT_Zennou2.renno,
            qIT_Zennou2.annaisaikaiym) +
            $FROM(qIT_AnsyuKihon, qIT_Zennou2, qIT_KykKihon, qIT_KykSyouhn) +
            $WHERE + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.ZENNOU) +
            $AND + qIT_KykSyouhn.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_AnsyuKihon.syono.eq(qIT_KykKihon.syono) +
            $AND + qIT_Zennou2.syono.eq(qIT_AnsyuKihon.syono) +
            $AND + qIT_Zennou2.zennouseisankbn.eq(C_ZennouSeisanKbn.MISEISAN) +
            $AND + qIT_Zennou2.zennoukaisiymd + $EQ + "(" + strSubSql + ")" +
            $AND + $(qIT_AnsyuKihon.jkipjytym.le(pSyoriymd.addMonths(1)) +
                    $AND + qIT_AnsyuKihon.jkipjytym.ge(pSyoriymd.addMonths(-3)));

        ExDBResults<ZennouJyuutouManryouDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, ZennouJyuutouManryouDataBean.class)
            .bind(qIT_AnsyuKihon, qIT_Zennou1, qIT_Zennou2, qIT_KykKihon, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }

    public IT_NyknJissekiRireki getNyknJissekiRirekiMaxRenno(IT_KykKihon pKykKihon, BizDateYM pJyutoustartym){

        List<IT_NyknJissekiRireki> nyknJissekiRirekiList = pKykKihon.getNyknJissekiRirekisByJyutoustartym(pJyutoustartym);

        IT_NyknJissekiRireki maxnyknJissekiRireki = null;

        if (nyknJissekiRirekiList.size() > 0) {

            SortKhZennouJyuutouManryou sortKhZennouJyuutouManryou = new SortKhZennouJyuutouManryou();

            maxnyknJissekiRireki =
                sortKhZennouJyuutouManryou.OrderIT_NyknJissekiRirekiByRennoDesc(nyknJissekiRirekiList).get(0);
        }

        return maxnyknJissekiRireki;
    }

    public IT_Zennou getZennou(IT_AnsyuKihon pAnsyuKihon, BizDate pZennoukaisiymd, Integer pRenno){

        List<IT_Zennou> zennouList = new ArrayList<IT_Zennou>();
        zennouList.addAll(pAnsyuKihon.getZennous());

        FilterZennou1 filterZennou1 = new FilterZennou1(pZennoukaisiymd, pRenno);

        IT_Zennou zennou = Iterables.getFirst(Iterables.filter(zennouList, filterZennou1), null);

        return zennou;
    }

    public List<IT_KykSyouhn> getKykSyouhns(IT_KykKihon pKykKihon){

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();

        FilterKykSyouhn1 filterKykSyouhn1 = new FilterKykSyouhn1(
            C_SyutkKbn.SYU, C_YuukousyoumetuKbn.YUUKOU, C_Kykjyoutai.ZENNOU);

        return new ArrayList<IT_KykSyouhn>(Collections2.filter(kykSyouhnList, filterKykSyouhn1));
    }

}
