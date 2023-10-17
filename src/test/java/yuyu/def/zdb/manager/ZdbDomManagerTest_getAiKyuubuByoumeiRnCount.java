package yuyu.def.zdb.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ZdbDomManagerクラスの、<br />
 * getAiKyuubuByoumeiRnCount() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getAiKyuubuByoumeiRnCount {

    @Inject
    ZdbDomManager zdbDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        Long count = zdbDomManager.getAiKyuubuByoumeiRnCount();
        Assert.assertEquals(new Long(0), count);

        ZT_AiKyuubuByoumeiRn aiKyuubuByoumeiRn1 = new ZT_AiKyuubuByoumeiRn("100001");
        aiKyuubuByoumeiRn1.setZrnbyoumei("癌の末期");
        aiKyuubuByoumeiRn1.setZrnbyoumeizenkaku("癌症晚期");
        aiKyuubuByoumeiRn1.setZrnbyoumeihurigana("フリガナ");
        aiKyuubuByoumeiRn1.setZrnbyoumeihuriganakensaku("フリガナ検索用");
        aiKyuubuByoumeiRn1.setZrnbyoumeicd("1001");
        aiKyuubuByoumeiRn1.setZrnbyoumeibuicd("111");
        aiKyuubuByoumeiRn1.setZrngaitoukbn1("1");
        aiKyuubuByoumeiRn1.setZrngaitoukbn2("2");
        aiKyuubuByoumeiRn1.setZrngaitoukbn3("3");
        aiKyuubuByoumeiRn1.setZrngaitoukbn4("4");
        aiKyuubuByoumeiRn1.setZrngaitoukbn5("5");
        aiKyuubuByoumeiRn1.setZrntyuuimongon("変更履歴");

        zdbDomManager.insert(aiKyuubuByoumeiRn1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_AiKyuubuByoumeiRn qZT_AiKyuubuByoumeiRn = new QZT_AiKyuubuByoumeiRn("qZT_AiKyuubuByoumeiRn");
        String jpql2 = $DELETE_FROM(qZT_AiKyuubuByoumeiRn) ;
        em.createJPQL(jpql2).bind(qZT_AiKyuubuByoumeiRn).executeUpdate();
    }
    @Test
    @TestOrder(10)
    public void normal1(){

        Long count = zdbDomManager.getAiKyuubuByoumeiRnCount();
        Assert.assertEquals(new Long(1), count);

    }
}


