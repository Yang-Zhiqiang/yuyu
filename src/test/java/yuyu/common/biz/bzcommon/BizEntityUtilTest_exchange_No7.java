package yuyu.common.biz.bzcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.entity.YuyuEntityUtil;
import yuyu.testinfr.TestOrder;

/**
 * BizEntityUtilのexchangeのテストクラス<br />
 *
 *テストケースの内容は以下の３パターンを検証
 *④両方のリストに主キーが同じエンティティが存在する場合は、ソースエンティティをターゲットエンティティに上書きします。（削除して追加ではない）
 *⑤ターゲットのみ存在するエンティティは、削除します。
 *⑥ソースのみ存在するエンティティは、ターゲットのリストに追加します。
 */
@RunWith(SWAKTestRunner.class)
public class BizEntityUtilTest_exchange_No7 {

    @Inject
    private static Logger logger = LoggerFactory.getLogger(YuyuEntityUtil.class);

    private static IT_KykKihon kykKihon1;

    @BeforeClass
    @Transactional
    public static void insertTestData_db() {

        kykKihon1 = new IT_KykKihon("10000000010");
        kykKihon1.createKykSya();
        kykKihon1.createHhknSya();
        kykKihon1.createKykSonotaTkyk();
        IT_KoujyoSymKanri koujyoSymKanri111 = kykKihon1.createKoujyoSymKanri();
        koujyoSymKanri111.setNendo("2010");
        IT_KoujyoSymKanri koujyoSymKanri222 = kykKihon1.createKoujyoSymKanri();
        koujyoSymKanri222.setNendo("2011");
        IT_KoujyoSymKanri koujyoSymKanri333 = kykKihon1.createKoujyoSymKanri();
        koujyoSymKanri333.setNendo("2012");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.insert(kykKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void srcEmpty() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<IT_KoujyoSymKanri>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<IT_KoujyoSymKanri>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000010");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        srcEntitys = new ArrayList<IT_KoujyoSymKanri>(kykKihon.getKoujyoSymKanris());
        srcEntitys.clear();

        BizEntityUtil.exchange(targetEntitys, srcEntitys);

        traceLogging("マージ結果リスト", targetEntitys);

        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void targetEmpty() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<IT_KoujyoSymKanri>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<IT_KoujyoSymKanri>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000010");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        srcEntitys = new ArrayList<IT_KoujyoSymKanri>(kykKihon.getKoujyoSymKanris());

        targetEntitys.clear();

        BizEntityUtil.exchange(targetEntitys, srcEntitys);

        traceLogging("マージ結果リスト", targetEntitys);

        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void allPartten() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<IT_KoujyoSymKanri>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<IT_KoujyoSymKanri>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000010");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        srcEntitys = new ArrayList<IT_KoujyoSymKanri>(kykKihon.getKoujyoSymKanris());

        BizEntityUtil.exchange(targetEntitys, srcEntitys);

        traceLogging("マージ結果リスト", targetEntitys);

        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void noUpd() {
        List<IT_KoujyoSymKanri> targetEntitys = new ArrayList<IT_KoujyoSymKanri>();
        List<IT_KoujyoSymKanri> srcEntitys = new ArrayList<IT_KoujyoSymKanri>();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000010");
        targetEntitys = kykKihon.getKoujyoSymKanris();

        srcEntitys = new ArrayList<IT_KoujyoSymKanri>(kykKihon.getKoujyoSymKanris());
        srcEntitys.remove(kykKihon.getKoujyoSymKanriByNendo("2010"));

        BizEntityUtil.exchange(targetEntitys, srcEntitys);

        traceLogging("マージ結果リスト", targetEntitys);

        hozenDomManager.update(kykKihon);
    }

    private static void traceLogging(String logPrefix, List<IT_KoujyoSymKanri> pList){

        logger.trace("◇ " + logPrefix);

        for(IT_KoujyoSymKanri entity : pList){
            logger.trace("｜ " + entity.getSyono().toString());
            logger.trace("｜ " + entity.getNendo().toString());
        }

        logger.trace("◇ 終了");
    }

}