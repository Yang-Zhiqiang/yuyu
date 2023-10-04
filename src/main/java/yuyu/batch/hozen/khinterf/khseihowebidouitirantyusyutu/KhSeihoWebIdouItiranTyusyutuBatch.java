package yuyu.batch.hozen.khinterf.khseihowebidouitirantyusyutu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 生保Ｗｅｂ異動一覧抽出
 */
public class KhSeihoWebIdouItiranTyusyutuBatch implements Batch {

    public final String TABLE_ID = "IT_SeihowebIdouRireki";

    public final String FILTER_ID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;

        BizDate syoriYmd = batchParam.getSyoriYmd();

        String ibKakutyoujobcd = batchParam.getIbKakutyoujobcd();

        String breakKeySyono = "";

        BizDate breakKeySyoriYmd = null;

        List<String> breakKeySeihowebidoukbnnaiyou1Lst = new ArrayList<>();

        String sakuseiYm = syoriYmd.getBizDateYM().toString();

        String dbskyoteiYm = syoriYmd.addMonths(3).getBizDateYM().toString();

        KhSeihoWebIdouItiranTyusyutuDao khSeihoWebIdouItiranTyusyutuDao =
            SWAKInjector.getInstance(KhSeihoWebIdouItiranTyusyutuDao.class);

        try (ExDBResults<IT_SeihowebIdouRireki> khTtdkRirekiList = khSeihoWebIdouItiranTyusyutuDao
            .getKhSeihowebIdouRirekisByKakutyoujobcdSyoriYmd(ibKakutyoujobcd, syoriYmd.addMonths(-1).getBizDateYM());

            EntityInserter<ZT_SeihoWebIdouListTy> seihoWebIdouListTyLst = new EntityInserter<>();) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

            for (IT_SeihowebIdouRireki seihowebIdouRireki : khTtdkRirekiList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(seihowebIdouRireki.getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(seihowebIdouRireki.getSyono());

                String syoNo = seihowebIdouRireki.getSyono();

                BizDate idouhasseiYmd = seihowebIdouRireki.getIdouhasseiymd();

                if (breakKeySyono.equals(syoNo)
                    && (BizDateUtil.compareYmd(breakKeySyoriYmd, idouhasseiYmd) == BizDateUtil.COMPARE_EQUAL)) {
                    if (breakKeySeihowebidoukbnnaiyou1Lst.contains(seihowebIdouRireki.getSeihowebidoukbnnaiyou1())) {
                        continue;
                    }
                }
                else {
                    breakKeySeihowebidoukbnnaiyou1Lst.clear();
                }

                breakKeySyono = syoNo;

                breakKeySyoriYmd = idouhasseiYmd;

                breakKeySeihowebidoukbnnaiyou1Lst.add(seihowebIdouRireki.getSeihowebidoukbnnaiyou1());

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(seihowebIdouRireki.getSyouhncd(),
                    seihowebIdouRireki.getSyouhnsdno());

                String syouhnnmsyoukenNm = syouhnZokusei.getSyouhnnmsyouken();
                if (syouhnnmsyoukenNm != null && syouhnnmsyoukenNm.length() > 30) {
                    syouhnnmsyoukenNm = syouhnnmsyoukenNm.substring(0,30);
                }

                String jkipjytym = "";

                String hrkkaisuu = "";

                String hrkkeiro = "";

                if (C_Hrkkaisuu.ITIJI.eq(seihowebIdouRireki.getHrkkaisuu())) {
                    jkipjytym = "****";
                    hrkkaisuu = "＊＊＊";
                    hrkkeiro = "＊＊＊";
                }
                else {
                    jkipjytym = new BizDateFormat("GyyMM", FillStyle.Zero).format(seihowebIdouRireki.getJkipjytym())
                        .toString().substring(1, 5);

                    if(C_Hrkkaisuu.TUKI.eq(seihowebIdouRireki.getHrkkaisuu())) {
                        if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(seihowebIdouRireki.getTikiktbrisyuruikbn())) {
                            hrkkaisuu = "月１２";
                        }
                        else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(seihowebIdouRireki.getTikiktbrisyuruikbn())) {
                            hrkkaisuu = "月６";
                        }
                        else {
                            hrkkaisuu = "月払";
                        }
                    }
                    else if(C_Hrkkaisuu.NEN .eq(seihowebIdouRireki.getHrkkaisuu())) {
                        hrkkaisuu = "年１回";
                    }
                    else if(C_Hrkkaisuu.HALFY.eq(seihowebIdouRireki.getHrkkaisuu())) {
                        hrkkaisuu = "年２回";
                    }

                    if (C_Hrkkeiro.KOUHURI.eq(seihowebIdouRireki.getHrkkeiro())) {
                        if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(seihowebIdouRireki.getBankcd())) {
                            hrkkeiro = "郵貯";
                        }
                        else {
                            hrkkeiro = "預振";
                        }
                    }
                    else if(C_Hrkkeiro.HURIKAE.eq(seihowebIdouRireki.getHrkkeiro())){
                        hrkkeiro = "振替";
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(seihowebIdouRireki.getHrkkeiro())) {
                        hrkkeiro = "クレ払";
                    }
                    else{
                        hrkkeiro = "＊＊＊";
                    }
                }
                String kykTuukaKbn = "";
                if (C_Tuukasyu.JPY.eq(seihowebIdouRireki.getTuukasyu())) {
                    kykTuukaKbn = "1";
                }
                else if (C_Tuukasyu.USD.eq(seihowebIdouRireki.getTuukasyu())) {
                    kykTuukaKbn = "2";
                }
                else if (C_Tuukasyu.EUR.eq(seihowebIdouRireki.getTuukasyu())) {
                    kykTuukaKbn = "3";
                }
                else {
                    kykTuukaKbn = "4";
                }

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(seihowebIdouRireki.getDairitencd1());
                String kanjiDairitenNm = "";
                if (bzGetAgInfoBeanList.size() > 0) {
                    kanjiDairitenNm = bzGetAgInfoBeanList.get(2).getKanjiDairitenNm() + "代理店";
                    if (kanjiDairitenNm.length() > 20) {
                        kanjiDairitenNm = kanjiDairitenNm.substring(0,20);
                    }
                }

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(seihowebIdouRireki.getBosyuucd1());
                String kanjiBosyuuninNm = "";
                if (bzGetBsInfoBean != null) {
                    kanjiBosyuuninNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
                    if (kanjiBosyuuninNm != null && kanjiBosyuuninNm.length() > 10) {
                        kanjiBosyuuninNm = kanjiBosyuuninNm.substring(0, 10);
                    }
                }

                ZT_SeihoWebIdouListTy seihoWebIdouListTy = new ZT_SeihoWebIdouListTy();

                seihoWebIdouListTy.setZtysakuseiymd7keta(sakuseiYm);

                seihoWebIdouListTy.setZtybsydrtencd(seihowebIdouRireki.getDairitencd1());

                seihoWebIdouListTy.setZtytntusycd(seihowebIdouRireki.getBosyuucd1());

                seihoWebIdouListTy.setZtysyono(seihowebIdouRireki.getSyono());

                seihoWebIdouListTy.setZtyhasseiymd(ConvertUtil.toZenAll(
                    DateFormatUtil.dateKANJIWarekiNoEx(seihowebIdouRireki.getIdouhasseiymd()), 0, 0));

                seihoWebIdouListTy.setZtyidoukbn1(seihowebIdouRireki.getSeihowebidoukbnnaiyou1());

                seihoWebIdouListTy.setZtykydatkikbnkj("");

                seihoWebIdouListTy.setZtykykyymm(new BizDateFormat("GyyMM", FillStyle.Zero)
                .format(seihowebIdouRireki.getKykymd()).toString().substring(1, 5));

                seihoWebIdouListTy.setZtycifcd(seihowebIdouRireki.getCifcd());

                seihoWebIdouListTy.setZtyatesakinm(kanjiDairitenNm);

                seihoWebIdouListTy.setZtybsyyymm(new BizDateFormat("GyyMM", FillStyle.Zero)
                .format(seihowebIdouRireki.getBosyuuym()).toString().substring(1, 5));

                seihoWebIdouListTy.setZtytntusynm(kanjiBosyuuninNm);

                seihoWebIdouListTy.setZtykyknmkjseihoweb(seihowebIdouRireki.getKyknmkj());

                seihoWebIdouListTy.setZtypjyuutouyymm(jkipjytym);

                seihoWebIdouListTy.setZtyhrkkaisuukj(hrkkaisuu);

                if (C_Tuukasyu.JPY.eq(seihowebIdouRireki.getTuukasyu())) {
                    seihoWebIdouListTy.setZtyp11keta(Long.parseLong(
                        seihowebIdouRireki.getHokenryou().toString()));
                }

                seihoWebIdouListTy.setZtyhrkkeirokj(hrkkeiro);

                seihoWebIdouListTy.setZtyhknsyuruimei(syouhnnmsyoukenNm);

                seihoWebIdouListTy.setZtyidoukbn2("");

                seihoWebIdouListTy.setZtydbskyoteiymd7keta(dbskyoteiYm);

                if (!C_Tuukasyu.JPY.eq(seihowebIdouRireki.getTuukasyu())) {
                    seihoWebIdouListTy.setZtygaikakykhrkp(BizNumber.valueOf(new BigDecimal(seihowebIdouRireki
                        .getHokenryou().toString())));
                }

                seihoWebIdouListTy.setZtykyktuukasyukbn(kykTuukaKbn);

                BizPropertyInitializer.initialize(seihoWebIdouListTy);

                seihoWebIdouListTyLst.add(seihoWebIdouListTy);

                syoriKensuu++;

                if (C_UmuKbn.ARI.eq(seihowebIdouRireki.getDrtenbunumu())) {
                    List<BzGetAgInfoBean> bzGetAgInfoBeanList2 = bzGetAgInfo.exec(seihowebIdouRireki
                        .getDairitencd2());
                    String kanjiDairitenNm2 = "";
                    if (bzGetAgInfoBeanList2.size() > 0) {
                        kanjiDairitenNm2 = bzGetAgInfoBeanList2.get(2).getKanjiDairitenNm() + "代理店";
                        if (kanjiDairitenNm2.length() > 20) {
                            kanjiDairitenNm2 = kanjiDairitenNm2.substring(0,20);
                        }
                    }

                    BzGetBsInfoBean bzGetBsInfoBean2 = bzGetBsInfo.exec(seihowebIdouRireki.getBosyuucd2());
                    String kanjiBosyuuninNm2 = "";
                    if(bzGetBsInfoBean2 != null) {
                        kanjiBosyuuninNm2 = bzGetBsInfoBean2.getKanjiBosyuuninNm();
                        if (kanjiBosyuuninNm2 != null && kanjiBosyuuninNm2.length() > 10) {
                            kanjiBosyuuninNm2 = kanjiBosyuuninNm2.substring(0, 10);
                        }
                    }

                    ZT_SeihoWebIdouListTy seihoWebIdouListTy2 = new ZT_SeihoWebIdouListTy();

                    seihoWebIdouListTy2.setZtysakuseiymd7keta(sakuseiYm);

                    seihoWebIdouListTy2.setZtybsydrtencd(seihowebIdouRireki.getDairitencd2());

                    seihoWebIdouListTy2.setZtytntusycd(seihowebIdouRireki.getBosyuucd2());

                    seihoWebIdouListTy2.setZtysyono(seihowebIdouRireki.getSyono());

                    seihoWebIdouListTy2.setZtyhasseiymd(ConvertUtil.toZenAll(
                        DateFormatUtil.dateKANJIWarekiNoEx(seihowebIdouRireki.getIdouhasseiymd()), 0, 0));

                    seihoWebIdouListTy2.setZtyidoukbn1(seihowebIdouRireki.getSeihowebidoukbnnaiyou1());

                    seihoWebIdouListTy2.setZtykydatkikbnkj("");

                    seihoWebIdouListTy2.setZtykykyymm(new BizDateFormat("GyyMM", FillStyle.Zero)
                    .format(seihowebIdouRireki.getKykymd()).toString().substring(1, 5));

                    seihoWebIdouListTy2.setZtycifcd(seihowebIdouRireki.getCifcd());

                    seihoWebIdouListTy2.setZtyatesakinm(kanjiDairitenNm2);

                    seihoWebIdouListTy2.setZtybsyyymm(new BizDateFormat("GyyMM", FillStyle.Zero)
                    .format(seihowebIdouRireki.getBosyuuym()).toString().substring(1, 5));

                    seihoWebIdouListTy2.setZtytntusynm(kanjiBosyuuninNm2);

                    seihoWebIdouListTy2.setZtykyknmkjseihoweb(seihowebIdouRireki.getKyknmkj());

                    seihoWebIdouListTy2.setZtypjyuutouyymm(jkipjytym);

                    seihoWebIdouListTy2.setZtyhrkkaisuukj(hrkkaisuu);

                    if (C_Tuukasyu.JPY.eq(seihowebIdouRireki.getTuukasyu())) {
                        seihoWebIdouListTy2.setZtyp11keta(Long.parseLong(
                            seihowebIdouRireki.getHokenryou().toString()));
                    }

                    seihoWebIdouListTy2.setZtyhrkkeirokj(hrkkeiro);

                    seihoWebIdouListTy2.setZtyhknsyuruimei(syouhnnmsyoukenNm);

                    seihoWebIdouListTy2.setZtyidoukbn2("");

                    seihoWebIdouListTy2.setZtydbskyoteiymd7keta(dbskyoteiYm);

                    if (!C_Tuukasyu.JPY.eq(seihowebIdouRireki.getTuukasyu())) {
                        seihoWebIdouListTy2.setZtygaikakykhrkp(BizNumber.valueOf(
                            new BigDecimal(seihowebIdouRireki.getHokenryou().toString())));
                    }

                    seihoWebIdouListTy2.setZtykyktuukasyukbn(kykTuukaKbn);

                    BizPropertyInitializer.initialize(seihoWebIdouListTy2);

                    seihoWebIdouListTyLst.add(seihoWebIdouListTy2);

                    syoriKensuu++;
                }

            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
