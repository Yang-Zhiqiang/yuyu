package yuyu.batch.hozen.khinterf.khtyouhyouttdkkankaiyaku;

import java.math.BigDecimal;

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
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.entity.ZT_TtdkKanKiykTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 手続完了（解約）Ｆ作成
 */
public class KhTyouhyouTtdkKanKaiyakuBatch implements Batch {

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
                bzBatchParam.getSyoriYmd(), C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR)) {

            try (EntityInserter<ZT_TtdkKanKiykTy> zTTtdkKanKiykTyLst = new EntityInserter<>()) {

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

                    String ztyosirasemongon1 = "";
                    String ztyosirasemongon2 = "";
                    String ztyosirasemongon3 = "";
                    String ztyosirasemongon4 = "";
                    String ztyosirasemongon5 = "";
                    String ztyosirasemongon6 = "";
                    String ztyosirasemongon7 = "";
                    String ztyosirasemongon8 = "";
                    String ztyosirasemongon9 = "";
                    String ztyosirasemongon10 = "";
                    String ztyosirasemongon11 = "";
                    String ztyosirasemongon12 = "";
                    String ztyosirasemongon13 = "";
                    String ztyosirasemongon14 = "";
                    String ztyzeimumongon1 = "";
                    String ztyzeimumongon2 = "";
                    String ztyzeimumongon3 = "";
                    String ztyzeimumongon4 = "";

                    ZT_TtdkKanKiykTy tTdkKanKiykTy = new ZT_TtdkKanKiykTy();

                    String sukuranpuruSyono = tTdkkan.getSyono().substring(3, 11)
                        .concat(tTdkkan.getSyono().substring(0, 3));

                    sakuseiNo = String.valueOf(syoriKensuu + 1);

                    sakuseiNo = BizUtil.zeroNum(sakuseiNo, 7, 0);

                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    if (C_UmuKbn.ARI.eq(tTdkkan.getGsbunritaisyou())) {
                    if (C_UmuKbn.ARI.eq(C_UmuKbn.NONE)) {

                        ztyosirasemongon1 = "いつもお引き立ていただきありがとうございます。";
                        ztyosirasemongon2 = "さて、ご請求いただきました解約手続きを完了し、右記のと";
                        ztyosirasemongon3 = "おりお支払い申し上げましたので、お知らせいたします。";
                        ztyosirasemongon4 = "今後とも変わらぬご愛顧を賜りますようお願いいたします。";
                        ztyosirasemongon6 = "【解約返戻金に対する税務のご説明】";
                        ztyosirasemongon7 = "税法上、源泉分離課税の対象となります。";
                        ztyosirasemongon8 = "お支払額から差引していますからこれ以外の課税は発生し";
                        ztyosirasemongon9 = "ません。本ご契約の必要経費、差益は右記のとおりです。";
                        ztyzeimumongon1 = "源泉分離課税対象の必要経費";
                        ztyzeimumongon2 = "源泉分離課税対象の差益";

                    }
                    else {
                        ztyosirasemongon1 = "ご請求いただいた解約手続きが完了しましたので、";
                        ztyosirasemongon2 = "お知らせいたします。";
                        ztyosirasemongon4 = "【解約返戻金に対する税務のご説明】";
                        ztyosirasemongon5 = "　一時所得として総所得に算入される金額＝";
                        ztyosirasemongon6 = "｛収入金額－必要経費－特別控除（５０万円）｝×１／２";
                        ztyosirasemongon7 = "○計算結果がプラスの場合、他の所得と合算され所得税の";
                        ztyosirasemongon8 = "　課税対象となります。確定申告が必要な場合は、本書を";
                        ztyosirasemongon9 = "　申告の資料としてください。";
                        ztyosirasemongon10 = "○収入金額・必要経費は右記お支払明細書のとおりです。";
                        ztyosirasemongon11 = "○一時所得の特別控除は、年間の一時所得（収入金額－";
                        ztyosirasemongon12 = "　必要経費）の合計額に対して５０万円です。";
                        ztyzeimumongon1 = "＜一時所得内容＞　　　　　　　収入金額";
                        ztyzeimumongon2 = "　　　　　　　　　　　　　　　　　　　必要経費";
                        ztyzeimumongon3 = "この明細書は確定申告の際の資料となりますので、";
                        ztyzeimumongon4 = "大切に保管してください。";

                        // TODO:テーブルレイアウト変更に伴う暫定対応として[getYenkaiykhmk]をコメントアウト（商品CU対応時に修正してください）
                        //if (tTdkkan.getYenkaiykhmk().compareTo(YuyuBizConfig.getInstance().getShrtysyTsytHuyou()) > 0) {

                        ztyosirasemongon14 = "なお、所轄税務署あてに、支払調書を送付しています。";
                        //}
                    }

                    tTdkKanKiykTy.setZtysyoruicd(String.valueOf(tTdkkan.getSyoruiCd()));
                    if (tTdkkan.getTyouhyouymd() != null) {
                        tTdkKanKiykTy.setZtytyouhyouymd(String.valueOf(tTdkkan.getTyouhyouymd()));
                    }
                    tTdkKanKiykTy.setZtysyono(tTdkkan.getSyono());
                    tTdkKanKiykTy.setZtyhassoukbn(String.valueOf(tTdkkan.getHassoukbn()));
                    tTdkKanKiykTy.setZtysyodouhuukbn(String.valueOf(tTdkkan.getSyoukendhumukbn()));
                    tTdkKanKiykTy.setZtysyoruicd2(String.valueOf(tTdkkan.getSyoruiCd()));
                    if (tTdkkan.getTyouhyouymd() != null) {
                        tTdkKanKiykTy.setZtytyouhyouymd2(String.valueOf(tTdkkan.getTyouhyouymd()));
                    }
                    tTdkKanKiykTy.setZtysyono2(tTdkkan.getSyono());
                    tTdkKanKiykTy.setZtyhassoukbn2(String.valueOf(tTdkkan.getHassoukbn()));
                    tTdkKanKiykTy.setZtysyodouhuukbn2(String.valueOf(tTdkkan.getSyoukendhumukbn()));
                    tTdkKanKiykTy.setZtysikibetuno(tTdkkan.getHenkousikibetukey());
                    tTdkKanKiykTy.setZtyshskyno(tTdkkan.getShskyno());
                    tTdkKanKiykTy.setZtyshskadr1kj(tTdkkan.getShsadr1kj());
                    tTdkKanKiykTy.setZtyshskadr2kj(tTdkkan.getShsadr2kj());
                    tTdkKanKiykTy.setZtyshskadr3kj(tTdkkan.getShsadr3kj());
                    tTdkKanKiykTy.setZtyshsnmkjttdk(tTdkkan.getShsnmkj());
                    tTdkKanKiykTy.setZtytawsosikikj(tTdkkan.getToiawasesosikinmkj());
                    tTdkKanKiykTy.setZtytawyno(tTdkkan.getToiawaseyno());
                    tTdkKanKiykTy.setZtytawadr1kj(tTdkkan.getToiawaseadr1kj());
                    tTdkKanKiykTy.setZtytawadr2kj(tTdkkan.getToiawaseadr2kj());
                    tTdkKanKiykTy.setZtytawadr3kj(tTdkkan.getToiawaseadr3kj());
                    tTdkKanKiykTy.setZtytawtelno(tTdkkan.getToiawasetelno());
                    tTdkKanKiykTy.setZtytawteluktkkanou1(tTdkkan.getToiawaseteluktkkanou1());
                    tTdkKanKiykTy.setZtytawteluktkkanou2(tTdkkan.getToiawaseteluktkkanou2());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtydai2tawsosikinmkj(tTdkkan.getToiawasesosikinmkj2());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtydai2tawtelno(tTdkkan.getToiawasetelno2());
                    tTdkKanKiykTy.setZtysclatosyono(sukuranpuruSyono);
                    tTdkKanKiykTy.setZtysakunm(sakuseiNo);
                    tTdkKanKiykTy.setZtysyono3(tTdkkan.getSyono());
                    if (tTdkkan.getShrymd() != null) {
                        tTdkKanKiykTy.setZtyshrymd(String.valueOf(tTdkkan.getShrymd()));
                    }
                    if (tTdkkan.getCalckijyunymd() != null) {
                        tTdkKanKiykTy.setZtykeisankijyunymd(String.valueOf(tTdkkan.getCalckijyunymd()));
                    }
                    tTdkKanKiykTy.setZtyhhknnmkj(tTdkkan.getHhknnmkj());
                    tTdkKanKiykTy.setZtykyknmkj(tTdkkan.getKyknmkj());
                    tTdkKanKiykTy.setZtytekiyou1(tTdkkan.getTekiyou1());
                    BigDecimal kngkmeisai1 = new BigDecimal(tTdkkan.getKngkmeisai1().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai1(kngkmeisai1.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou2(tTdkkan.getTekiyou2());
                    BigDecimal kngkmeisai2 = new BigDecimal(tTdkkan.getKngkmeisai2().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai2(kngkmeisai2.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou3(tTdkkan.getTekiyou3());
                    BigDecimal kngkmeisai3 = new BigDecimal(tTdkkan.getKngkmeisai3().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai3(kngkmeisai3.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou4(tTdkkan.getTekiyou4());
                    BigDecimal kngkmeisai4 = new BigDecimal(tTdkkan.getKngkmeisai4().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai4(kngkmeisai4.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou5(tTdkkan.getTekiyou5());
                    BigDecimal kngkmeisai5 = new BigDecimal(tTdkkan.getKngkmeisai5().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai5(kngkmeisai5.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou6(tTdkkan.getTekiyou6());
                    BigDecimal kngkmeisai6 = new BigDecimal(tTdkkan.getKngkmeisai6().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai6(kngkmeisai6.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou7(tTdkkan.getTekiyou7());
                    BigDecimal kngkmeisai7 = new BigDecimal(tTdkkan.getKngkmeisai7().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai7(kngkmeisai7.doubleValue());
                    tTdkKanKiykTy.setZtytekiyou8(tTdkkan.getTekiyou8());
                    BigDecimal kngkmeisai8 = new BigDecimal(tTdkkan.getKngkmeisai8().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkmeisai8(kngkmeisai8.doubleValue());
                    BigDecimal shrgkkei = new BigDecimal(tTdkkan.getShrgkkei().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyshrgkgoukei(shrgkkei.doubleValue());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    BigDecimal yenshrgkgoukei = new BigDecimal(tTdkkan.getYenshrgkgoukei().toString());
                    //                    tTdkKanKiykTy.setZtyshrgkkeiknsngo(yenshrgkgoukei.doubleValue());
                    tTdkKanKiykTy.setZtytuukasyu(tTdkkan.getShrtuukasyu().getContent());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtynykntuukasyu(tTdkkan.getKyktuukasyu().getContent());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    BigDecimal shrkwsrate = new BigDecimal(tTdkkan.getShrkwsrate().toString());
                    //                    tTdkKanKiykTy.setZtyshrtkykwsrate(shrkwsrate.doubleValue());
                    tTdkKanKiykTy.setZtytkytuukasyuryk(tTdkkan.getShrtuukasyuryk());
                    tTdkKanKiykTy.setZtybanknmkj(tTdkkan.getBanknmkj());
                    tTdkKanKiykTy.setZtysitennmkj(tTdkkan.getSitennmkj());
                    tTdkKanKiykTy.setZtyyokinkbn(String.valueOf(tTdkkan.getYokinkbn()));
                    tTdkKanKiykTy.setZtykouzano12keta(tTdkkan.getKouzano());
                    tTdkKanKiykTy.setZtykzmeiginmkn(tTdkkan.getKzmeiginmkn());
                    tTdkKanKiykTy.setZtykouzasyuruikbn(String.valueOf(tTdkkan.getKzsyuruikbn()));
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyyenshrtkumu(String.valueOf(tTdkkan.getYenshrtkumu()));
                    BigDecimal htykeihi = new BigDecimal(tTdkkan.getHtykeihi().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtyhtykeihi(htykeihi.longValue());
                    BigDecimal saeki = new BigDecimal(tTdkkan.getHtykeihi().toString());
                    tTdkKanKiykTy.setZtysaeki(saeki.longValue());
                    BigDecimal synykngk = new BigDecimal(tTdkkan.getSynykngk().toString());
                    // TODO:テーブルレイアウト変更に伴う暫定対応としてコメントアウト（商品CU対応時に修正してください）
                    //                    tTdkKanKiykTy.setZtysynykngk(synykngk.longValue());
                    tTdkKanKiykTy.setZtyosirasemongon1(ztyosirasemongon1);
                    tTdkKanKiykTy.setZtyosirasemongon2(ztyosirasemongon2);
                    tTdkKanKiykTy.setZtyosirasemongon3(ztyosirasemongon3);
                    tTdkKanKiykTy.setZtyosirasemongon4(ztyosirasemongon4);
                    tTdkKanKiykTy.setZtyosirasemongon5(ztyosirasemongon5);
                    tTdkKanKiykTy.setZtyosirasemongon6(ztyosirasemongon6);
                    tTdkKanKiykTy.setZtyosirasemongon7(ztyosirasemongon7);
                    tTdkKanKiykTy.setZtyosirasemongon8(ztyosirasemongon8);
                    tTdkKanKiykTy.setZtyosirasemongon9(ztyosirasemongon9);
                    tTdkKanKiykTy.setZtyosirasemongon10(ztyosirasemongon10);
                    tTdkKanKiykTy.setZtyosirasemongon11(ztyosirasemongon11);
                    tTdkKanKiykTy.setZtyosirasemongon12(ztyosirasemongon12);
                    tTdkKanKiykTy.setZtyosirasemongon13(ztyosirasemongon13);
                    tTdkKanKiykTy.setZtyosirasemongon14(ztyosirasemongon14);
                    tTdkKanKiykTy.setZtyzeimumongon1(ztyzeimumongon1);
                    tTdkKanKiykTy.setZtyzeimumongon2(ztyzeimumongon2);
                    tTdkKanKiykTy.setZtyzeimumongon3(ztyzeimumongon3);
                    tTdkKanKiykTy.setZtyzeimumongon4(ztyzeimumongon4);

                    BizPropertyInitializer.initialize(tTdkKanKiykTy);

                    zTTtdkKanKiykTyLst.add(tTdkKanKiykTy);

                    syoriKensuu = syoriKensuu + 1;
                }

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
            }
        }
    }
}
