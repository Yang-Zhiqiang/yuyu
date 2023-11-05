package yuyu.def.base.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（組織マスタ）<br />
 * 翻訳対象外組織コードマスタ全データの件数取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getHonyakutsgSosikiCdCount {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Long lCount = baseDomManager.getHonyakutsgSosikiCdCount();
        Assert.assertEquals(0, lCount.intValue());

        AM_HonyakutsgSosikiCd honyakutsgSosikiCd1 = new AM_HonyakutsgSosikiCd("1000001");

        baseDomManager.insert(honyakutsgSosikiCd1);

        AM_HonyakutsgSosikiCd honyakutsgSosikiCd2 = new AM_HonyakutsgSosikiCd("1000002");

        baseDomManager.insert(honyakutsgSosikiCd2);

        AM_HonyakutsgSosikiCd honyakutsgSosikiCd3 = new AM_HonyakutsgSosikiCd("1000003");

        baseDomManager.insert(honyakutsgSosikiCd3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllHonyakutsgSosikiCd());
    }
    @Test
    @TestOrder(10)
    public void normal1(){

        Long lCount = baseDomManager.getHonyakutsgSosikiCdCount();

        Assert.assertEquals(3, lCount.intValue());
    }
}

