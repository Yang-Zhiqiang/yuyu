package yuyu.batch.hozen.khinterf.khtyouhyouttdkkanjyuuhen;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 手続完了（住所変更）Ｆ作成
 */
public class KhTyouhyouTtdkKanJyuuHenBatch implements Batch {

    private final String TABLEID = "IT_TtdkKan";

    private final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        try (ExDBResults<IT_TtdkKan> itTtdkkanLst =
            hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCd(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd(), C_SyoruiCdKbn.KK_ADRHNK_TTDKKR)) {

            try (EntityInserter<ZT_TtdkKanAdHenkouTy> ztTtdkKanAdHenkouTyyLst = new EntityInserter<>()) {

                long syoriKensuu = 0;

                String sakuseiNo = "";

                for (IT_TtdkKan tTdkkan : itTtdkkanLst) {

                    BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean =
                        SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tTdkkan.getKbnkey());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(tTdkkan.getSyono());

                    String sukuranpuruSyono =
                        tTdkkan.getSyono().substring(3,11).concat(tTdkkan.getSyono().substring(0,3));

                    sakuseiNo = String.valueOf(syoriKensuu + 1);

                    sakuseiNo = BizUtil.zeroNum(sakuseiNo, 7, 0);

                    ZT_TtdkKanAdHenkouTy ztTtdkKanAdHenkouTyy = new ZT_TtdkKanAdHenkouTy();

                    ztTtdkKanAdHenkouTyy.setZtysyoruicd(String.valueOf(tTdkkan.getSyoruiCd()));
                    if (tTdkkan.getTyouhyouymd() != null) {
                        ztTtdkKanAdHenkouTyy.setZtytyouhyouymd(String.valueOf(tTdkkan.getTyouhyouymd()));
                    }
                    ztTtdkKanAdHenkouTyy.setZtysyono(tTdkkan.getSyono());
                    ztTtdkKanAdHenkouTyy.setZtyhassoukbn(String.valueOf(tTdkkan.getHassoukbn()));
                    ztTtdkKanAdHenkouTyy.setZtysyodouhuukbn(String.valueOf(tTdkkan.getSyoukendhumukbn()));
                    ztTtdkKanAdHenkouTyy.setZtysyoruicd2(String.valueOf(tTdkkan.getSyoruiCd()));
                    if (tTdkkan.getTyouhyouymd() != null) {
                        ztTtdkKanAdHenkouTyy.setZtytyouhyouymd2(String.valueOf(tTdkkan.getTyouhyouymd()));
                    }
                    ztTtdkKanAdHenkouTyy.setZtysyono2(tTdkkan.getSyono());
                    ztTtdkKanAdHenkouTyy.setZtyhassoukbn2(String.valueOf(tTdkkan.getHassoukbn()));
                    ztTtdkKanAdHenkouTyy.setZtysyodouhuukbn2(String.valueOf(tTdkkan.getSyoukendhumukbn()));
                    ztTtdkKanAdHenkouTyy.setZtysikibetuno(tTdkkan. getHenkousikibetukey());
                    ztTtdkKanAdHenkouTyy.setZtyshskyno(tTdkkan.getShskyno());
                    ztTtdkKanAdHenkouTyy.setZtyshskadr1kj(tTdkkan.getShsadr1kj());
                    ztTtdkKanAdHenkouTyy.setZtyshskadr2kj(tTdkkan.getShsadr2kj());
                    ztTtdkKanAdHenkouTyy.setZtyshskadr3kj(tTdkkan.getShsadr3kj());
                    ztTtdkKanAdHenkouTyy.setZtyshsnmkjttdk(tTdkkan.getShsnmkj());
                    ztTtdkKanAdHenkouTyy.setZtytawsosikikj(tTdkkan.getToiawasesosikinmkj());
                    ztTtdkKanAdHenkouTyy.setZtytawyno(tTdkkan.getToiawaseyno());
                    ztTtdkKanAdHenkouTyy.setZtytawadr1kj(tTdkkan.getToiawaseadr1kj());
                    ztTtdkKanAdHenkouTyy.setZtytawadr2kj(tTdkkan.getToiawaseadr2kj());
                    ztTtdkKanAdHenkouTyy.setZtytawadr3kj(tTdkkan.getToiawaseadr3kj());
                    ztTtdkKanAdHenkouTyy.setZtytawtelno(tTdkkan.getToiawasetelno());
                    ztTtdkKanAdHenkouTyy.setZtytawteluktkkanou1(tTdkkan.getToiawaseteluktkkanou1());
                    ztTtdkKanAdHenkouTyy.setZtytawteluktkkanou2(tTdkkan.getToiawaseteluktkkanou2());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    ztTtdkKanAdHenkouTyy.setZtydai2tawsosikinmkj(tTdkkan.getToiawasesosikinmkj2());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    ztTtdkKanAdHenkouTyy.setZtydai2tawtelno(tTdkkan.getToiawasetelno2());
                    ztTtdkKanAdHenkouTyy.setZtysclatosyono(sukuranpuruSyono);
                    ztTtdkKanAdHenkouTyy.setZtysakunm(sakuseiNo);
                    ztTtdkKanAdHenkouTyy.setZtysyono3(tTdkkan.getSyono());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    ztTtdkKanAdHenkouTyy.setZtytetudukisyunm(tTdkkan.getTetudukisyunm());
                    ztTtdkKanAdHenkouTyy.setZtykyknmkj(tTdkkan.getKyknmkj());
                    ztTtdkKanAdHenkouTyy.setZtyhhknnmkj(tTdkkan.getHhknnmkj());

                    BizPropertyInitializer.initialize(ztTtdkKanAdHenkouTyy);

                    ztTtdkKanAdHenkouTyyLst.add(ztTtdkKanAdHenkouTyy);

                    syoriKensuu = syoriKensuu + 1;
                }

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
            }
        }
    }
}
