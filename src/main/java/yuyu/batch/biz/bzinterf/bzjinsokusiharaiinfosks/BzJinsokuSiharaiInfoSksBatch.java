package yuyu.batch.biz.bzinterf.bzjinsokusiharaiinfosks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_TanmatuSyuruiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.entity.ZT_JinsokuShrTtdkInfoTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 インターフェイス 迅速支払情報ファイル作成
 */
public class BzJinsokuSiharaiInfoSksBatch implements Batch {

    private long syuturyokuKensu;

    private BizDate syoriKaisiYmd;

    private BizDate syoriSyuuryouYmd;

    private final String KH_KAIYAKU = "khkaiyaku";

    private final String KH_BATCHKAIYAKU = "khbatchkaiyaku";

    private final String SYORICDKH_KAIYK = "RB30";

    private final String SYORICDKH_BATCHKAIYK = "RBA2";

    private final int KEIKA_EIGYOUBISUU_JYGN = 30;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        syuturyokuKensu = 0;
        syoriKaisiYmd = BizDate.valueOf(syoriYmd.addMonths(-1).getBizDateYM(), 1);
        syoriSyuuryouYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();

        khJnskSiInfoSks(KH_KAIYAKU);

        khJnskSiInfoSks(KH_BATCHKAIYAKU);

        try (ExDBResults<JT_SiJinsokuShrTtdkInfo> siJinsokuShrTtdkInfoLst = siharaiDomManager.
            getSiJinsokuShrTtdkInfosBySyoriYmd(syoriKaisiYmd, syoriSyuuryouYmd);
            EntityInserter<ZT_JinsokuShrTtdkInfoTy> jinsokuShrTtdkInfoTyEILst = new EntityInserter<>()) {

            for (JT_SiJinsokuShrTtdkInfo siJinsokuShrTtdkInfo : siJinsokuShrTtdkInfoLst) {
                ZT_JinsokuShrTtdkInfoTy jinsokuShrTtdkInfoTyUC = new ZT_JinsokuShrTtdkInfoTy();
                jinsokuShrTtdkInfoTyUC.setZtysyorisosikicd(siJinsokuShrTtdkInfo.getSyorisosikicd());
                jinsokuShrTtdkInfoTyUC.setZtysyoricd(siJinsokuShrTtdkInfo.getSyoricd());
                jinsokuShrTtdkInfoTyUC.setZtyhknknshrsntkno(siJinsokuShrTtdkInfo.getHknknshrsntkno());
                jinsokuShrTtdkInfoTyUC.setZtysyoruiukeymd(String.valueOf(siJinsokuShrTtdkInfo.getSyoruiukeymd()));
                jinsokuShrTtdkInfoTyUC.setZtysyoriymd(String.valueOf(siJinsokuShrTtdkInfo.getSyoriYmd()));
                jinsokuShrTtdkInfoTyUC.setZtydenymd(String.valueOf(siJinsokuShrTtdkInfo.getDenymd()));
                jinsokuShrTtdkInfoTyUC.setZtysyoruikeikaeigyoubisuu(String.valueOf(siJinsokuShrTtdkInfo.
                    getSyoruikeikaeigyoubisuu()));
                jinsokuShrTtdkInfoTyUC.setZtysyorikeikaeigyoubisuu(String.valueOf(siJinsokuShrTtdkInfo.
                    getSyorikeikaeigyoubisuu()));
                jinsokuShrTtdkInfoTyUC.setZtytoritugisosikicd(siJinsokuShrTtdkInfo.getToritugisosikicd());
                jinsokuShrTtdkInfoTyUC.setZtytanmatusyuruikbn(siJinsokuShrTtdkInfo.
                    getTanmatusyuruikbn().getValue());
                jinsokuShrTtdkInfoTyUC.setZtysyono(siJinsokuShrTtdkInfo.getSyono());
                if (siJinsokuShrTtdkInfo.getKykymd() != null) {
                    jinsokuShrTtdkInfoTyUC.setZtykeiyakuymd(String.valueOf(siJinsokuShrTtdkInfo.getKykymd()));
                }
                else {
                    jinsokuShrTtdkInfoTyUC.setZtykeiyakuymd("");
                }
                BizPropertyInitializer.initialize(jinsokuShrTtdkInfoTyUC);

                jinsokuShrTtdkInfoTyEILst.add(jinsokuShrTtdkInfoTyUC);

                syuturyokuKensu = syuturyokuKensu + 1;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syuturyokuKensu),
            kinou.getKinouNm()));
    }

    private void khJnskSiInfoSks(String pKinouId) {

        try (ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean>
        hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanLst = hozenDomManager.
        getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(syoriKaisiYmd, syoriSyuuryouYmd, pKinouId);
            EntityInserter<ZT_JinsokuShrTtdkInfoTy> jinsokuShrTtdkInfoTyEiLst = new EntityInserter<>()) {

            for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean :
                hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanLst) {
                IT_KykKihon kykKihon = hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean.getIT_KykSyouhn();
                IT_KhTtdkRireki khTtdkRireki = hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean.getIT_KhTtdkRireki();
                IT_KhShrRireki khShrRireki = hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean.getIT_KhShrRireki();

                BizDate eigyoKijyunYmd = khShrRireki.getSyoruiukeymd();
                long syoruiKeikaEigyoubisuu = 0;

                if (eigyoKijyunYmd != null) {
                    while (BizDateUtil.compareYmd(eigyoKijyunYmd, khShrRireki.getShrymd()) ==
                        BizDateUtil.COMPARE_LESSER) {
                        eigyoKijyunYmd = eigyoKijyunYmd.addBusinessDays(1);
                        syoruiKeikaEigyoubisuu = syoruiKeikaEigyoubisuu + 1;
                    }
                }

                if (syoruiKeikaEigyoubisuu > KEIKA_EIGYOUBISUU_JYGN) {
                    syoruiKeikaEigyoubisuu = KEIKA_EIGYOUBISUU_JYGN;
                }

                eigyoKijyunYmd = khShrRireki.getShrsyoriymd();
                long syoriKeikaEigyoubisuu = 0;

                if (eigyoKijyunYmd != null) {
                    while (BizDateUtil.compareYmd(eigyoKijyunYmd, khShrRireki.getShrymd()) ==
                        BizDateUtil.COMPARE_LESSER) {
                        eigyoKijyunYmd = eigyoKijyunYmd.addBusinessDays(1);
                        syoriKeikaEigyoubisuu = syoriKeikaEigyoubisuu + 1;
                    }
                }

                if (syoriKeikaEigyoubisuu > KEIKA_EIGYOUBISUU_JYGN) {
                    syoriKeikaEigyoubisuu = KEIKA_EIGYOUBISUU_JYGN;
                }

                ZT_JinsokuShrTtdkInfoTy jinsokuShrTtdkInfoTy = new ZT_JinsokuShrTtdkInfoTy();

                if (KH_KAIYAKU.equals(pKinouId)) {
                    jinsokuShrTtdkInfoTy.setZtysyoricd(SYORICDKH_KAIYK);
                }

                if (KH_BATCHKAIYAKU.equals(pKinouId)) {
                    jinsokuShrTtdkInfoTy.setZtysyoricd(SYORICDKH_BATCHKAIYK);
                }

                jinsokuShrTtdkInfoTy.setZtysyorisosikicd(khTtdkRireki.getSyorisosikicd());
                jinsokuShrTtdkInfoTy.setZtyhknknshrsntkno("");
                if (khShrRireki.getSyoruiukeymd() != null) {
                    jinsokuShrTtdkInfoTy.setZtysyoruiukeymd(String.valueOf(khShrRireki.getSyoruiukeymd()));
                }
                else {
                    jinsokuShrTtdkInfoTy.setZtysyoruiukeymd("");
                }
                if (khShrRireki.getShrsyoriymd() != null) {
                    jinsokuShrTtdkInfoTy.setZtysyoriymd(String.valueOf(khShrRireki.getShrsyoriymd()));
                }
                else {
                    jinsokuShrTtdkInfoTy.setZtysyoriymd("");
                }
                if (khShrRireki.getShrymd() != null) {
                    jinsokuShrTtdkInfoTy.setZtydenymd(String.valueOf(khShrRireki.getShrymd()));
                }
                else {
                    jinsokuShrTtdkInfoTy.setZtydenymd("");
                }
                jinsokuShrTtdkInfoTy.setZtysyoruikeikaeigyoubisuu(String.valueOf(syoruiKeikaEigyoubisuu));
                jinsokuShrTtdkInfoTy.setZtysyorikeikaeigyoubisuu(String.valueOf(syoriKeikaEigyoubisuu));
                jinsokuShrTtdkInfoTy.setZtytoritugisosikicd("");
                jinsokuShrTtdkInfoTy.setZtytanmatusyuruikbn(C_TanmatuSyuruiKbn.RAY.getValue());
                jinsokuShrTtdkInfoTy.setZtysyono(kykKihon.getSyono());
                if (kykSyouhn.getKykymd() != null) {
                    jinsokuShrTtdkInfoTy.setZtykeiyakuymd(String.valueOf(kykSyouhn.getKykymd()));
                }
                else {
                    jinsokuShrTtdkInfoTy.setZtykeiyakuymd("");
                }
                BizPropertyInitializer.initialize(jinsokuShrTtdkInfoTy);

                jinsokuShrTtdkInfoTyEiLst.add(jinsokuShrTtdkInfoTy);

                syuturyokuKensu = syuturyokuKensu + 1;
            }
        }

    }
}