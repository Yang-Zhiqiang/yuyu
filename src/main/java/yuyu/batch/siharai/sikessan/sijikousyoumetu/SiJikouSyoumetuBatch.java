package yuyu.batch.siharai.sikessan.sijikousyoumetu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_Sk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Iterables;

/**
 * 保険金給付金支払 決算 時効消滅
 */
public class SiJikouSyoumetuBatch implements Batch {

    private static final String JT_SIKEKKA = "時効消滅　支払処理結果テーブル";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    private BizDate syoriYmd;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = batchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        int shrSyoriKekkaTblKensuu = 0;

        BizDate kessanKijyunYmd = null;

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }
        else {
            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }

        try (
            EntityInserter<JT_SiKekka> siKekkaEntityInserter = new EntityInserter<>();
            EntityUpdater<JT_SkKihon> skKihonEntityUpdater = new EntityUpdater<>();
            ExDBResults<JT_SiBikinkanri> siBikinkanriExDBResults = siharaiDomManager
                .getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(kessanKijyunYmd, C_BknJkuKbn.JIKOU, C_BknrigiKbn.DEL)) {

            for (JT_SiBikinkanri siBikinkanri : siBikinkanriExDBResults) {

                JT_SkKihon skKihon = siharaiDomManager.getSkKihon(siBikinkanri.getSkno(), siBikinkanri.getSyono());

                int updCount = updateTbl(skKihon, kessanKijyunYmd, siKekkaEntityInserter, skKihonEntityUpdater);

                shrSyoriKekkaTblKensuu = shrSyoriKekkaTblKensuu + updCount;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(shrSyoriKekkaTblKensuu), JT_SIKEKKA));
    }

    private int updateTbl(JT_SkKihon pSkKihon, BizDate pKessanKijyunYmd,
        EntityInserter<JT_SiKekka> pSiKekkaEntityInserter, EntityUpdater<JT_SkKihon> pSkKihonEntityUpdater) {

        int count = 0;
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        List<JT_SiKekka> siKekkaLst = siharaiDomManager.getSiKekkasBySyono(pSkKihon.getSyono());

        if (siKekkaLst.size() != 0) {

            return count;
        }

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(pSkKihon.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);
        List<JT_SiKykSyouhn> siKykSyouhnLst = siKykKihon.getSiKykSyouhns();

        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

        for (int i = 0; i < siKykSyouhnLst.size(); i++) {

            if (C_SyutkKbn.SYU.eq(siKykSyouhnLst.get(i).getSyutkkbn())) {

                siKykSyouhn = siKykSyouhnLst.get(i);
                break;
            }
        }

        JT_SiKekka siKekka = new JT_SiKekka();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(siKykSyouhn.getKyktuukasyu());

        siKekka.setShiharaikekkadatakbn(C_ShiharaikekkadataKbn.SYOUMETU);
        siKekka.setSyono(pSkKihon.getSyono());
        siKekka.setSyouhncd(siKykSyouhn.getSyouhncd());
        siKekka.setSyouhnsdno(siKykSyouhn.getSyouhnsdno());
        siKekka.setKyksyouhnrenno(siKykSyouhn.getKyksyouhnrenno());
        siKekka.setSyutkkbn(siKykSyouhn.getSyutkkbn());
        siKekka.setNexthrkym(null);
        siKekka.setKouryokuhasseiymd(pKessanKijyunYmd);
        siKekka.setSyoumetujiyuu(C_Syoumetujiyuu.JIKOU);
        siKekka.setGansindankakuteiymd("");
        siKekka.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKekka.setDenymd(null);
        siKekka.setMisyuumikeikakbn(C_MisyuumikeikaKbn.BLNK);
        siKekka.setJyuutouym(null);
        siKekka.setJyutoukaisuuy(0);
        siKekka.setJyutoukaisuum(0);
        siKekka.setSeisanpgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKekka.setHushrgeninkbn(C_HushrGeninKbn.BLNK);
        siKekka.setSyoriYmd(syoriYmd);
        siKekka.setZennouseisankgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKekka.setZennouseisankgkshrtk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKekka.setZitkazukarikingksiteituuka(BizCurrency.valueOf(0, currencyType));
        siKekka.setZitkazukarikingkyen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKekka.setShrtuukasyu(C_Tuukasyu.BLNK);
        siKekka.setShrkwsratekjnymd(null);
        siKekka.setShrkwsrate(BizNumber.ZERO);
        siKekka.setZeimukwsrate(BizNumber.ZERO);
        siKekka.setKossyoricd(kinou.getKinouId());
        siKekka.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());
        siKekka.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        siKekka.setGyoumuKousinTime(sysDateTimeMilli);

        BizPropertyInitializer.initialize(siKekka);
        pSiKekkaEntityInserter.add(siKekka);

        pSkKihon.setKossyoricd(kinou.getKinouId());
        pSkKihon.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());
        pSkKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pSkKihon.setGyoumuKousinTime(sysDateTimeMilli);

        String ttdkrrkskbtKey = SaibanBiz.getTetudukirirekiSikibetukey(pSkKihon.getSyono());

        int seikyuuRirekiNo = 0;
        List<JT_Sk> skLst = pSkKihon.getSks();
        if (skLst.size() > 0) {
            SortJT_Sk sortSk = SWAKInjector.getInstance(SortJT_Sk.class);
            JT_Sk sk = sortSk.OrderJT_SkByPkDesc(skLst).get(0);
            seikyuuRirekiNo = sk.getSeikyuurirekino();
        }

        JT_TtdkRireki ttdkRireki = pSkKihon.createTtdkRireki();
        ttdkRireki.setTtdkrrkskbtkey(ttdkrrkskbtKey);
        ttdkRireki.setSyoriYmd(syoriYmd);
        ttdkRireki.setSyorisosikicd("");
        ttdkRireki.setJimukakuteiumukbn(C_JimukakuteiKbn.KAKUTEI);
        ttdkRireki.setSeikyuurirekino(seikyuuRirekiNo);
        ttdkRireki.setShrsikibetukey("");
        ttdkRireki.setSateisyouninskbtkey("");
        ttdkRireki.setSyanaicomment("");
        ttdkRireki.setKossyoricd(kinou.getKinouId());
        ttdkRireki.setKossyorisscd(Iterables.getFirst(kinou.getKinouModes(), null).getKinouModeId());
        ttdkRireki.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        ttdkRireki.setGyoumuKousinTime(sysDateTimeMilli);

        BizPropertyInitializer.initialize(ttdkRireki);
        pSkKihonEntityUpdater.add(pSkKihon);

        count = 1;

        return count;
    }
}