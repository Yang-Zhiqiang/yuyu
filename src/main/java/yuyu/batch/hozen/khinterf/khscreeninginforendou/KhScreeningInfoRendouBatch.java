package yuyu.batch.hozen.khinterf.khscreeninginforendou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.ZT_HnsyScrMeigiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェース スクリーニング情報連動。
 */
public class KhScreeningInfoRendouBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERID = "Kh001";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String tysyttaisyouTableId = TYSYTTAISYOUTABLEID;
        String recoveryFilterId = RECOVERYFILTERID;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        int kensuCount = 0;
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
        int syoriDay = syoriYmd.getDay();
        BizDateYM preSyoriYm = syoriYmd.addMonths(-1).getRekijyou().getBizDateYM();
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        BizDate preSyoriYmOne = BizDate.valueOf(preSyoriYm, 1).getRekijyou();
        BizDate preSyoriYmFif = BizDate.valueOf(preSyoriYm, 15).getRekijyou();
        BizDate syoriYmOne = BizDate.valueOf(syoriYm, 1).getRekijyou();
        BizDate syoriYmFif = BizDate.valueOf(syoriYm, 15).getRekijyou();
        BizDate preSyoriYmEnd = syoriYmOne.addDays(-1).getRekijyou();

        try (ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> exDBResults =
                hozenDomManager.getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(ibKakutyoujobCd, C_SyutkKbn.SYU);
                EntityInserter<ZT_HnsyScrMeigiTy> ztHnsyScrMeigiTyList = new EntityInserter<>()) {

            List<String> sosikiCdList = new ArrayList<>();
            List<String> kankeiNmKnList = new ArrayList<>();
            List<String> kankeiNmKjList = new ArrayList<>();
            List<String> kankeiSeiYmdList = new ArrayList<>();

            for (SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean
                    sukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean : exDBResults) {

                IT_KykKihon kykKihon = sukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean.getKykKihon();

                IT_KykSyouhn kykSyouhn = sukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean.getKykSyouhn();

                IT_HhknSya khknSya = sukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean.getKhknSya();

                IT_KykSya kykSya = sukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean.getKykSya();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(tysyttaisyouTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(recoveryFilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(kykKihon.getSyono());

                if (kykSya != null && khknSya != null) {

                    String syono = kykKihon.getSyono();
                    sosikiCdList.clear();
                    kankeiNmKnList.clear();
                    kankeiNmKjList.clear();
                    kankeiSeiYmdList.clear();
                    IT_KykKihon kykKihonSyono = new IT_KykKihon();

                    kykKihonSyono = hozenDomManager.getKykKihon(syono);

                    kykKihonSyono = IT_KykKihonDetacher.detachKykUkttouched(kykKihonSyono);

                    List<IT_KykUkt> kykUktSbuktList = kykKihonSyono.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

                    List<IT_KykUkt> kykUktStdrskList = kykKihonSyono.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);

                    List<IT_KykUkt> kykUktNkuktList = kykKihonSyono.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

                    kykKihonSyono = hozenDomManager.getKykKihon(syono);

                    kykKihonSyono = IT_KykKihonDetacher.detachKykDairitentouched(kykKihonSyono);

                    List<IT_KykDairiten> itKykDairitenList = kykKihonSyono.getKykDairitens();

                    kykKihonSyono = hozenDomManager.getKykKihon(syono);

                    kykKihonSyono = IT_KykKihonDetacher.detachKhTtdkRirekitouched(kykKihonSyono);

                    List<IT_KhTtdkRireki> itKhTtdkRirekiList = kykKihonSyono.getKhTtdkRirekis();

                    SortIT_KhTtdkRireki sortItKhTtdkRireki = SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);

                    itKhTtdkRirekiList = sortItKhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(itKhTtdkRirekiList);

                    List<IT_KhTtdkRireki> itKhTtdkRirekiSyonoList =
                            kykKihonSyono.getKhTtdkRirekisByGyoumuKousinKinou(
                                    IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU);

                    itKhTtdkRirekiSyonoList = sortItKhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(
                            itKhTtdkRirekiSyonoList);

                    for (IT_KykDairiten itKykDairiten : itKykDairitenList) {

                        sosikiCdList.add(itKykDairiten.getDrtenkanrisosikicd());
                    }

                    for (IT_KhTtdkRireki itKhTtdkRireki : itKhTtdkRirekiSyonoList) {
                        sosikiCdList.add(itKhTtdkRireki.getSyorisosikicd());
                    }

                    for (IT_KhTtdkRireki itKhTtdkRireki : itKhTtdkRirekiList) {

                        if (!IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU.equals(
                                itKhTtdkRireki.getGyoumuKousinKinou())) {

                            if (!BizUtil.isBlank(itKhTtdkRireki.getSyorisosikicd())) {
                                sosikiCdList.add(itKhTtdkRireki.getSyorisosikicd());
                            }
                        }
                    }

                    for (int i = sosikiCdList.size(); i < 5; i++) {

                        sosikiCdList.add("0000000");
                    }

                    String kyknmkj = "";

                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        kyknmkj = "";
                    }
                    else {
                        kyknmkj = kykSya.getKyknmkj();
                    }

                    kankeiNmKnList.add(kykSya.getKyknmkn());

                    kankeiNmKjList.add(kyknmkj);

                    for (IT_KykUkt itKykUkt : kykUktSbuktList) {

                        if (C_UktKbn.TOKUTEIMEIGI.eq(itKykUkt.getUktkbn())) {

                            String uktnmkj = "";

                            if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                                uktnmkj = "";
                            }
                            else {
                                uktnmkj = itKykUkt.getUktnmkj();
                            }

                            kankeiNmKnList.add(itKykUkt.getUktnmkn());

                            kankeiNmKjList.add(uktnmkj);

                            if (kankeiNmKnList.size() >= 5) {

                                break;
                            }

                        }

                    }

                    if (kankeiNmKnList.size() < 5) {

                        for (IT_KykUkt itKykUkt : kykUktStdrskList) {

                            if (C_UktKbn.TOKUTEIMEIGI.eq(itKykUkt.getUktkbn())) {

                                String uktnmkj = "";

                                if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                                    uktnmkj = "";
                                }
                                else {
                                    uktnmkj = itKykUkt.getUktnmkj();
                                }

                                kankeiNmKnList.add(itKykUkt.getUktnmkn());

                                kankeiNmKjList.add(uktnmkj);

                            }

                            if (kankeiNmKnList.size() >= 5) {

                                break;
                            }

                        }
                    }

                    for (int i = kankeiNmKnList.size(); i < 5; i++) {

                        kankeiNmKnList.add("");

                        kankeiNmKjList.add("");

                    }

                    String hrkkeiroKbn = "";

                    KbnInfoBean kbnInfoBean =bzKbnHenkanUtil.convKbn(kykKihon.getHrkkeiro().getValue(),
                            C_Hrkkeiro.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER );

                    if (kbnInfoBean.isHenkanFlg()) {

                        hrkkeiroKbn = kbnInfoBean.getKbnData();

                    }
                    else {

                        throw new CommonBizAppException("区分名：払込経路区分　　区分値：" +
                                kykKihon.getHrkkeiro().getValue());

                    }

                    String kzhurikaebankcd = null;
                    String kzhurikaesitencd = null;
                    String kzhurikaeyokinkbn = null;
                    String kzhurikaekouzano = null;

                    if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                        IT_Kouza kouza = hozenDomManager.getKouza(syono);

                        if (kouza != null) {
                            kzhurikaebankcd = kouza.getBankcd();
                            kzhurikaesitencd = kouza.getSitencd();
                            kzhurikaeyokinkbn = kouza.getYokinkbn().getValue();
                            kzhurikaekouzano = kouza.getKouzano();

                        } else {
                            kzhurikaebankcd = "0000";
                            kzhurikaesitencd = "000";
                            kzhurikaeyokinkbn = "0";
                            kzhurikaekouzano = "0000000";

                        }
                    } else {
                        kzhurikaebankcd = "0000";
                        kzhurikaesitencd = "000";
                        kzhurikaeyokinkbn = "0";
                        kzhurikaekouzano = "0000000";

                    }

                    ConvertPALSyoumetucd convertPALSyoumetucd = SWAKInjector.getInstance(ConvertPALSyoumetucd.class);

                    String syoumetuCd = "";

                    if(!C_Syoumetujiyuu.BLNK.eq(kykSyouhn.getSyoumetujiyuu())){

                        syoumetuCd = convertPALSyoumetucd.exec(kykSyouhn.getSyoumetujiyuu());
                    }

                    BizDate lastmeihenYmd = kykKihon.getLastmeihenymd();

                    BizDate meihenYmd = null;

                    if (lastmeihenYmd != null) {

                        if (syoriDay < 15 && BizDateUtil.compareYmd(lastmeihenYmd, preSyoriYmFif) > 0
                                && BizDateUtil.compareYmd(lastmeihenYmd, preSyoriYmEnd) <= 0) {

                            meihenYmd = lastmeihenYmd;

                        }
                        else if (syoriDay >= 15 && BizDateUtil.compareYmd(lastmeihenYmd, syoriYmOne) >= 0
                                && BizDateUtil.compareYmd(lastmeihenYmd, syoriYmFif) <= 0) {

                            meihenYmd = lastmeihenYmd;

                        }
                        else {

                            meihenYmd = BizDate.valueOf("00000000");
                        }

                    }

                    else {

                        meihenYmd = BizDate.valueOf("00000000");

                    }

                    List<IT_KhTtdkRireki> itKhTtdkRirekiSyonoList1 =
                            kykKihonSyono.getKhTtdkRirekisByGyoumuKousinKinou(
                                    IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

                    itKhTtdkRirekiSyonoList1 = sortItKhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(
                            itKhTtdkRirekiSyonoList1);

                    BizDate seiymdseitsYmd =  null;

                    if (itKhTtdkRirekiSyonoList1.size() > 0) {

                        BizDate seiymdseitsSyoriYmd =  itKhTtdkRirekiSyonoList1.get(0).getSyoriYmd();

                        if (syoriDay < 15 && BizDateUtil.compareYmd(seiymdseitsSyoriYmd, preSyoriYmFif) > 0
                                && BizDateUtil.compareYmd(seiymdseitsSyoriYmd, preSyoriYmEnd) <= 0) {

                            seiymdseitsYmd = seiymdseitsSyoriYmd;

                        }
                        else if (syoriDay >= 15 && BizDateUtil.compareYmd(seiymdseitsSyoriYmd, syoriYmOne) >= 0
                                && BizDateUtil.compareYmd(seiymdseitsSyoriYmd, syoriYmFif) <= 0) {

                            seiymdseitsYmd = seiymdseitsSyoriYmd;

                        }
                        else {

                            seiymdseitsYmd = BizDate.valueOf("00000000");
                        }

                    }
                    else {

                        seiymdseitsYmd = BizDate.valueOf("00000000");

                    }

                    String kykmfkykkjnm = "";
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        kykmfkykkjnm = "";
                    }
                    else {
                        kykmfkykkjnm = kykSya.getKyknmkj();
                    }

                    String kykmfhhkkjnm = "";
                    if (C_KjkhukaKbn.KJKHUKA.eq(khknSya.getHhknnmkjkhukakbn())) {
                        kykmfhhkkjnm = "";
                    }
                    else {
                        kykmfhhkkjnm = khknSya.getHhknnmkj();
                    }

                    String kykmfsbuktknNm = null;
                    String kykmfsbuktkjNm = null;
                    BizDate kykmfsbuktseiYmd = null;
                    if (kykKihon.getSbuktnin() >= 5) {

                        kykmfsbuktknNm = "";
                        kykmfsbuktkjNm = "";
                        kykmfsbuktseiYmd = BizDate.valueOf("00000000");

                    }
                    else {

                        if (kykUktSbuktList.size() > 0) {

                            C_UktKbn uktKbn = kykUktSbuktList.get(0).getUktkbn();

                            if (C_UktKbn.KYK.eq(uktKbn)) {

                                kykmfsbuktknNm = kykSya.getKyknmkn();
                                kykmfsbuktseiYmd = kykSya.getKykseiymd();

                                if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                                    kykmfsbuktkjNm = "";
                                }
                                else {
                                    kykmfsbuktkjNm = kykSya.getKyknmkj();
                                }

                            }
                            else if (C_UktKbn.HHKN.eq(uktKbn)) {

                                kykmfsbuktknNm = khknSya.getHhknnmkn();
                                kykmfsbuktseiYmd = khknSya.getHhknseiymd();

                                if (C_KjkhukaKbn.KJKHUKA.eq(khknSya.getHhknnmkjkhukakbn())) {
                                    kykmfsbuktkjNm = "";
                                }
                                else {
                                    kykmfsbuktkjNm = khknSya.getHhknnmkj();
                                }

                            }
                            else if (C_UktKbn.TOKUTEIMEIGI.eq(uktKbn)) {

                                kykmfsbuktknNm = kykUktSbuktList.get(0).getUktnmkn();
                                kykmfsbuktseiYmd = kykUktSbuktList.get(0).getUktseiymd();

                                if (C_KjkhukaKbn.KJKHUKA.eq(kykUktSbuktList.get(0).getUktnmkjkhukakbn())) {
                                    kykmfsbuktkjNm = "";
                                }
                                else {
                                    kykmfsbuktkjNm = kykUktSbuktList.get(0).getUktnmkj();
                                }

                            }
                            else if (C_UktKbn.SOUZOKUNIN.eq(uktKbn)) {

                                kykmfsbuktknNm = "ソウゾクニン";
                                kykmfsbuktkjNm = "相続人";
                                kykmfsbuktseiYmd = BizDate.valueOf("00000000");

                            }
                            else {

                                kykmfsbuktknNm = "";
                                kykmfsbuktkjNm = "";
                                kykmfsbuktseiYmd = BizDate.valueOf("00000000");

                            }

                        }
                        else {

                            kykmfsbuktknNm = "";
                            kykmfsbuktkjNm = "";
                            kykmfsbuktseiYmd = BizDate.valueOf("00000000");

                        }

                    }

                    String kykmfmnkktknNm = null;
                    String kykmfmnkktkjNm = null;
                    BizDate kykmfmnkktseiYmd = null;
                    if (kykUktNkuktList.size() > 0) {

                        C_UktKbn uktKbn = kykUktNkuktList.get(0).getUktkbn();

                        if (C_UktKbn.KYK.eq(uktKbn)) {

                            kykmfmnkktknNm = kykSya.getKyknmkn();
                            kykmfmnkktseiYmd = kykSya.getKykseiymd();

                            if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                                kykmfmnkktkjNm = "";
                            }
                            else {
                                kykmfmnkktkjNm = kykSya.getKyknmkj();
                            }

                        }
                        else if (C_UktKbn.HHKN.eq(uktKbn)) {

                            kykmfmnkktknNm = khknSya.getHhknnmkn();
                            kykmfmnkktseiYmd = khknSya.getHhknseiymd();

                            if (C_KjkhukaKbn.KJKHUKA.eq(khknSya.getHhknnmkjkhukakbn())) {
                                kykmfmnkktkjNm = "";
                            }
                            else {
                                kykmfmnkktkjNm = khknSya.getHhknnmkj();
                            }

                        }
                        else {

                            kykmfmnkktknNm = "";
                            kykmfmnkktkjNm = "";
                            kykmfmnkktseiYmd = BizDate.valueOf("00000000");

                        }

                    }
                    else {

                        kykmfmnkktknNm = "";
                        kykmfmnkktkjNm = "";
                        kykmfmnkktseiYmd = BizDate.valueOf("00000000");

                    }

                    C_UmuKbn sbuktumuFlag = C_UmuKbn.NONE;

                    for (IT_KykUkt itKykUkt : kykUktSbuktList) {

                        if (C_UktsyuKbn.SBUKT.eq(itKykUkt.getUktsyukbn())
                                && C_UktKbn.TOKUTEIMEIGI.eq(itKykUkt.getUktkbn())) {

                            sbuktumuFlag = C_UmuKbn.ARI;

                            break;

                        }

                    }


                    String taisyouNmkn = kykSya.getKyknmkn();
                    BizDate khtaisyouseiymd = kykSya.getKykseiymd();
                    String kanjitsinkaiAdr = kykSya.getTsinadr1kj().concat(kykSya.getTsinadr2kj()).
                            concat(kykSya.getTsinadr3kj());
                    String sosikiCd1 = sosikiCdList.get(0);
                    String sosikiCd2 = sosikiCdList.get(1);
                    String sosikiCd3 = sosikiCdList.get(2);
                    String sosikiCd4 = sosikiCdList.get(3);
                    String sosikiCd5 = sosikiCdList.get(4);
                    String kankeiNmkn1 = kankeiNmKnList.get(0);
                    String kankeiNmkn2 = kankeiNmKnList.get(1);
                    String kankeiNmkn3 = kankeiNmKnList.get(2);
                    String kankeiNmkn4 = kankeiNmKnList.get(3);
                    String kankeiNmkn5 = kankeiNmKnList.get(4);
                    String kankeiNmkj1 = kankeiNmKjList.get(0);
                    String kankeiNmkj2 = kankeiNmKjList.get(1);
                    String kankeiNmkj3 = kankeiNmKjList.get(2);
                    String kankeiNmkj4 = kankeiNmKjList.get(3);
                    String kankeiNmkj5 = kankeiNmKjList.get(4);
                    String tsintelNo = kykSya.getTsintelno();
                    String hjnCd = "000000000";
                    BizDate syoumetuYmd = kykSyouhn.getSyoumetuymd();
                    String syokugyouCd = kykKihon.getHhknsykgycd();
                    String nayosetaisyousegKbn = "02";

                    String taisyouNmkj = "";

                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        taisyouNmkj = "";
                    }
                    else {
                        taisyouNmkj = kykSya.getKyknmkj();
                    }

                    ZT_HnsyScrMeigiTy ztHnsyScrMeigiTy = new ZT_HnsyScrMeigiTy();

                    ztHnsyScrMeigiTy.setZtyhnsyrecordkbn("100");
                    ztHnsyScrMeigiTy.setZtykijyunym(kykKihon.getBosyuuym().toString());
                    ztHnsyScrMeigiTy.setZtytaisyounmkn(taisyouNmkn);
                    ztHnsyScrMeigiTy.setZtytaisyounmkj(taisyouNmkj);
                    ztHnsyScrMeigiTy.setZtytaisyouseiymd(khtaisyouseiymd.toString());
                    ztHnsyScrMeigiTy.setZtytsnsknewyno(kykSya.getTsinyno());
                    ztHnsyScrMeigiTy.setZtytsnsknewtikucd("");
                    ztHnsyScrMeigiTy.setZtyhhknnewyno(khknSya.getHhknyno());
                    ztHnsyScrMeigiTy.setZtyhhknnewtikucd("");
                    ztHnsyScrMeigiTy.setZtykstkannisknewyno("");
                    ztHnsyScrMeigiTy.setZtykstkannisknewtikucd("");
                    ztHnsyScrMeigiTy.setZtydntnewyno("");
                    ztHnsyScrMeigiTy.setZtydntnewtikucd("");
                    ztHnsyScrMeigiTy.setZtykanjitsinkaiadr(kanjitsinkaiAdr);
                    ztHnsyScrMeigiTy.setZtytodouhukennm("");
                    ztHnsyScrMeigiTy.setZtysigunnm("");
                    ztHnsyScrMeigiTy.setZtysosikicd1(sosikiCd1);
                    ztHnsyScrMeigiTy.setZtysosikicd2(sosikiCd2);
                    ztHnsyScrMeigiTy.setZtysosikicd3(sosikiCd3);
                    ztHnsyScrMeigiTy.setZtysosikicd4(sosikiCd4);
                    ztHnsyScrMeigiTy.setZtysosikicd5(sosikiCd5);
                    ztHnsyScrMeigiTy.setZtyhhknhnsktodouhukencd("00");
                    ztHnsyScrMeigiTy.setZtykankeinmkn1(kankeiNmkn1);
                    ztHnsyScrMeigiTy.setZtykankeinmkn2(kankeiNmkn2);
                    ztHnsyScrMeigiTy.setZtykankeinmkn3(kankeiNmkn3);
                    ztHnsyScrMeigiTy.setZtykankeinmkn4(kankeiNmkn4);
                    ztHnsyScrMeigiTy.setZtykankeinmkn5(kankeiNmkn5);
                    ztHnsyScrMeigiTy.setZtykankeinmkj1(kankeiNmkj1);
                    ztHnsyScrMeigiTy.setZtykankeinmkj2(kankeiNmkj2);
                    ztHnsyScrMeigiTy.setZtykankeinmkj3(kankeiNmkj3);
                    ztHnsyScrMeigiTy.setZtykankeinmkj4(kankeiNmkj4);
                    ztHnsyScrMeigiTy.setZtykankeinmkj5(kankeiNmkj5);
                    ztHnsyScrMeigiTy.setZtyhrkkeirokbn(hrkkeiroKbn);
                    ztHnsyScrMeigiTy.setZtydntcd("00000000");
                    ztHnsyScrMeigiTy.setZtydntnm("");
                    ztHnsyScrMeigiTy.setZtydntsyzkcd("");
                    ztHnsyScrMeigiTy.setZtydntkojincd("");
                    ztHnsyScrMeigiTy.setZtykzhurikaebankcd(kzhurikaebankcd);
                    ztHnsyScrMeigiTy.setZtykzhurikaesitencd(kzhurikaesitencd);
                    ztHnsyScrMeigiTy.setZtykzhurikaeyokinkbn(kzhurikaeyokinkbn);
                    ztHnsyScrMeigiTy.setZtykzhurikaekouzano(kzhurikaekouzano);
                    ztHnsyScrMeigiTy.setZtytsintelno(tsintelNo);
                    ztHnsyScrMeigiTy.setZtyhjncd(hjnCd);
                    ztHnsyScrMeigiTy.setZtyhjnjigyosyocd("");
                    if (syoumetuYmd == null) {
                        ztHnsyScrMeigiTy.setZtysymtymd("00000000");
                    }
                    else {
                        ztHnsyScrMeigiTy.setZtysymtymd(syoumetuYmd.toString());
                    }
                    ztHnsyScrMeigiTy.setZtysyokugyoucd(syokugyouCd);
                    ztHnsyScrMeigiTy.setZtydai2hhknyno("");
                    ztHnsyScrMeigiTy.setZtydai2hhknnewtikucd("");
                    ztHnsyScrMeigiTy.setZtydai2hhkntodouhukencd("00");
                    ztHnsyScrMeigiTy.setZtysyokugyoucd2("000");
                    ztHnsyScrMeigiTy.setZtyyobiv118("");
                    ztHnsyScrMeigiTy.setZtyskinnm("");
                    ztHnsyScrMeigiTy.setZtyyobiv40("");
                    ztHnsyScrMeigiTy.setZtynayosetaisyousegkbn(nayosetaisyousegKbn);
                    ztHnsyScrMeigiTy.setZtynayosetaisyoukojinkbn("00");
                    ztHnsyScrMeigiTy.setZtyyobiv46("");
                    ztHnsyScrMeigiTy.setZtytodouhukencd1(kykKihon.getDrtenkanritodoufukencd());
                    ztHnsyScrMeigiTy.setZtytodouhukencd2("00");
                    ztHnsyScrMeigiTy.setZtytodouhukencd3("00");
                    ztHnsyScrMeigiTy.setZtyyobiv34("");
                    ztHnsyScrMeigiTy.setZtysyono(kykKihon.getSyono());
                    ztHnsyScrMeigiTy.setZtysyoumetucd(syoumetuCd);
                    if (kykSyouhn.getSyoumetuymd() == null) {
                        ztHnsyScrMeigiTy.setZtysymtymd2("00000000");
                    }
                    else {
                        ztHnsyScrMeigiTy.setZtysymtymd2(kykSyouhn.getSyoumetuymd().toString());
                    }
                    ztHnsyScrMeigiTy.setZtybohaiyakkandisp("1");
                    ztHnsyScrMeigiTy.setZtymeihenymd(meihenYmd.toString());
                    ztHnsyScrMeigiTy.setZtyseiymdseitsymd(seiymdseitsYmd.toString());
                    ztHnsyScrMeigiTy.setZtykzkmrtityuutohukaymd("00000000");
                    ztHnsyScrMeigiTy.setZtykykmfkykknnm(kykSya.getKyknmkn());
                    ztHnsyScrMeigiTy.setZtykykmfkykkjnm(kykmfkykkjnm);
                    ztHnsyScrMeigiTy.setZtykykmfkykseiymd(kykSya.getKykseiymd().toString());
                    ztHnsyScrMeigiTy.setZtykykmfhhkknnm(khknSya.getHhknnmkn());
                    ztHnsyScrMeigiTy.setZtykykmfhhkkjnm(kykmfhhkkjnm);
                    ztHnsyScrMeigiTy.setZtykykmfhhkseiymd(khknSya.getHhknseiymd().toString());
                    ztHnsyScrMeigiTy.setZtykykmfdai2knnm("");
                    ztHnsyScrMeigiTy.setZtykykmfdai2kjnm("");
                    ztHnsyScrMeigiTy.setZtykykmfdai2seiymd("00000000");
                    ztHnsyScrMeigiTy.setZtykykmfsbuktknnm(kykmfsbuktknNm);
                    ztHnsyScrMeigiTy.setZtykykmfsbuktkjnm(kykmfsbuktkjNm);
                    ztHnsyScrMeigiTy.setZtykykmfsbuktseiymd(kykmfsbuktseiYmd.toString());
                    ztHnsyScrMeigiTy.setZtykykmfdai2ktknnm("");
                    ztHnsyScrMeigiTy.setZtykykmfdai2ktkjnm("");
                    ztHnsyScrMeigiTy.setZtykykmfdai2ktseiymd("00000000");
                    ztHnsyScrMeigiTy.setZtykykmfmnkktknnm(kykmfmnkktknNm);
                    ztHnsyScrMeigiTy.setZtykykmfmnkktkjnm(kykmfmnkktkjNm);
                    ztHnsyScrMeigiTy.setZtykykmfmnkktseiymd(kykmfmnkktseiYmd.toString());
                    ztHnsyScrMeigiTy.setZtydntcd2("00000000");
                    ztHnsyScrMeigiTy.setZtykjdntnm("");
                    ztHnsyScrMeigiTy.setZtyrinjikaisouhyouji("0");
                    ztHnsyScrMeigiTy.setZtyyobiv34x2("");
                    ztHnsyScrMeigiTy.setZtysgtaisyoukbn("3");
                    ztHnsyScrMeigiTy.setZtyyobiv39("");
                    ztHnsyScrMeigiTy.setZtysyuuseihjnnm("");
                    ztHnsyScrMeigiTy.setZtyyobiv75("");
                    ztHnsyScrMeigiTy.setZtysysyno("00000000000");
                    ztHnsyScrMeigiTy.setZtysueokikaisiymd("00000000");
                    ztHnsyScrMeigiTy.setZtyhasseiriyuukbnscreen("0");
                    ztHnsyScrMeigiTy.setZtysueokijtkbn("0");
                    ztHnsyScrMeigiTy.setZtytaisyoufilekbn("0");
                    ztHnsyScrMeigiTy.setZtybohaiyakkandisp2("0");
                    ztHnsyScrMeigiTy.setZtymeihenymd2("00000000");
                    ztHnsyScrMeigiTy.setZtynksyoumetucd("00");
                    ztHnsyScrMeigiTy.setZtyyobiv7("");
                    ztHnsyScrMeigiTy.setZtyyobiv20("");

                    BizPropertyInitializer.initialize(ztHnsyScrMeigiTy);

                    ztHnsyScrMeigiTyList.add(ztHnsyScrMeigiTy);

                    kensuCount ++;

                    String taisyouNmkn1 = khknSya.getHhknnmkn();
                    BizDate khtaisyouseiymd1 = khknSya.getHhknseiymd();
                    BizDate syoumetuYmd1 = BizDate.valueOf("00000000");
                    String nayosetaisyousegKbn1 = "";

                    if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

                        nayosetaisyousegKbn1 = "03";

                    }
                    else {

                        nayosetaisyousegKbn1 = "01";

                    }

                    String taisyouNmkj1 = "";

                    if (C_KjkhukaKbn.KJKHUKA.eq(khknSya.getHhknnmkjkhukakbn())) {
                        taisyouNmkj1 = "";
                    }
                    else {
                        taisyouNmkj1 = khknSya.getHhknnmkj();
                    }

                    ZT_HnsyScrMeigiTy ztHnsyScrMeigiTy1 = new ZT_HnsyScrMeigiTy();

                    ztHnsyScrMeigiTy1.setZtyhnsyrecordkbn("100");
                    ztHnsyScrMeigiTy1.setZtykijyunym(kykKihon.getBosyuuym().toString());
                    ztHnsyScrMeigiTy1.setZtytaisyounmkn(taisyouNmkn1);
                    ztHnsyScrMeigiTy1.setZtytaisyounmkj(taisyouNmkj1);
                    ztHnsyScrMeigiTy1.setZtytaisyouseiymd(khtaisyouseiymd1.toString());
                    ztHnsyScrMeigiTy1.setZtytsnsknewyno(kykSya.getTsinyno());
                    ztHnsyScrMeigiTy1.setZtytsnsknewtikucd("");
                    ztHnsyScrMeigiTy1.setZtyhhknnewyno(khknSya.getHhknyno());
                    ztHnsyScrMeigiTy1.setZtyhhknnewtikucd("");
                    ztHnsyScrMeigiTy1.setZtykstkannisknewyno("");
                    ztHnsyScrMeigiTy1.setZtykstkannisknewtikucd("");
                    ztHnsyScrMeigiTy1.setZtydntnewyno("");
                    ztHnsyScrMeigiTy1.setZtydntnewtikucd("");
                    ztHnsyScrMeigiTy1.setZtykanjitsinkaiadr(kanjitsinkaiAdr);
                    ztHnsyScrMeigiTy1.setZtytodouhukennm("");
                    ztHnsyScrMeigiTy1.setZtysigunnm("");
                    ztHnsyScrMeigiTy1.setZtysosikicd1(sosikiCd1);
                    ztHnsyScrMeigiTy1.setZtysosikicd2(sosikiCd2);
                    ztHnsyScrMeigiTy1.setZtysosikicd3(sosikiCd3);
                    ztHnsyScrMeigiTy1.setZtysosikicd4(sosikiCd4);
                    ztHnsyScrMeigiTy1.setZtysosikicd5(sosikiCd5);
                    ztHnsyScrMeigiTy1.setZtyhhknhnsktodouhukencd("00");
                    ztHnsyScrMeigiTy1.setZtykankeinmkn1(kankeiNmkn1);
                    ztHnsyScrMeigiTy1.setZtykankeinmkn2(kankeiNmkn2);
                    ztHnsyScrMeigiTy1.setZtykankeinmkn3(kankeiNmkn3);
                    ztHnsyScrMeigiTy1.setZtykankeinmkn4(kankeiNmkn4);
                    ztHnsyScrMeigiTy1.setZtykankeinmkn5(kankeiNmkn5);
                    ztHnsyScrMeigiTy1.setZtykankeinmkj1(kankeiNmkj1);
                    ztHnsyScrMeigiTy1.setZtykankeinmkj2(kankeiNmkj2);
                    ztHnsyScrMeigiTy1.setZtykankeinmkj3(kankeiNmkj3);
                    ztHnsyScrMeigiTy1.setZtykankeinmkj4(kankeiNmkj4);
                    ztHnsyScrMeigiTy1.setZtykankeinmkj5(kankeiNmkj5);
                    ztHnsyScrMeigiTy1.setZtyhrkkeirokbn(hrkkeiroKbn);
                    ztHnsyScrMeigiTy1.setZtydntcd("00000000");
                    ztHnsyScrMeigiTy1.setZtydntnm("");
                    ztHnsyScrMeigiTy1.setZtydntsyzkcd("");
                    ztHnsyScrMeigiTy1.setZtydntkojincd("");
                    ztHnsyScrMeigiTy1.setZtykzhurikaebankcd(kzhurikaebankcd);
                    ztHnsyScrMeigiTy1.setZtykzhurikaesitencd(kzhurikaesitencd);
                    ztHnsyScrMeigiTy1.setZtykzhurikaeyokinkbn(kzhurikaeyokinkbn);
                    ztHnsyScrMeigiTy1.setZtykzhurikaekouzano(kzhurikaekouzano);
                    ztHnsyScrMeigiTy1.setZtytsintelno(tsintelNo);
                    ztHnsyScrMeigiTy1.setZtyhjncd(hjnCd);
                    ztHnsyScrMeigiTy1.setZtyhjnjigyosyocd("");
                    if (syoumetuYmd1 == null) {
                        ztHnsyScrMeigiTy1.setZtysymtymd("00000000");
                    }
                    else {
                        ztHnsyScrMeigiTy1.setZtysymtymd(syoumetuYmd1.toString());
                    }
                    ztHnsyScrMeigiTy1.setZtysyokugyoucd(syokugyouCd);
                    ztHnsyScrMeigiTy1.setZtydai2hhknyno("");
                    ztHnsyScrMeigiTy1.setZtydai2hhknnewtikucd("");
                    ztHnsyScrMeigiTy1.setZtydai2hhkntodouhukencd("00");
                    ztHnsyScrMeigiTy1.setZtysyokugyoucd2("000");
                    ztHnsyScrMeigiTy1.setZtyyobiv118("");
                    ztHnsyScrMeigiTy1.setZtyskinnm("");
                    ztHnsyScrMeigiTy1.setZtyyobiv40("");
                    ztHnsyScrMeigiTy1.setZtynayosetaisyousegkbn(nayosetaisyousegKbn1);
                    ztHnsyScrMeigiTy1.setZtynayosetaisyoukojinkbn("00");
                    ztHnsyScrMeigiTy1.setZtyyobiv46("");
                    ztHnsyScrMeigiTy1.setZtytodouhukencd1(kykKihon.getDrtenkanritodoufukencd());
                    ztHnsyScrMeigiTy1.setZtytodouhukencd2("00");
                    ztHnsyScrMeigiTy1.setZtytodouhukencd3("00");
                    ztHnsyScrMeigiTy1.setZtyyobiv34("");
                    ztHnsyScrMeigiTy1.setZtysyono(kykKihon.getSyono());
                    ztHnsyScrMeigiTy1.setZtysyoumetucd(syoumetuCd);
                    if (kykSyouhn.getSyoumetuymd() == null) {
                        ztHnsyScrMeigiTy1.setZtysymtymd2("00000000");
                    }
                    else {
                        ztHnsyScrMeigiTy1.setZtysymtymd2(kykSyouhn.getSyoumetuymd().toString());
                    }
                    ztHnsyScrMeigiTy1.setZtybohaiyakkandisp("1");
                    ztHnsyScrMeigiTy1.setZtymeihenymd(meihenYmd.toString());
                    ztHnsyScrMeigiTy1.setZtyseiymdseitsymd(seiymdseitsYmd.toString());
                    ztHnsyScrMeigiTy1.setZtykzkmrtityuutohukaymd("00000000");
                    ztHnsyScrMeigiTy1.setZtykykmfkykknnm(kykSya.getKyknmkn());
                    ztHnsyScrMeigiTy1.setZtykykmfkykkjnm(kykmfkykkjnm);
                    ztHnsyScrMeigiTy1.setZtykykmfkykseiymd(kykSya.getKykseiymd().toString());
                    ztHnsyScrMeigiTy1.setZtykykmfhhkknnm(khknSya.getHhknnmkn());
                    ztHnsyScrMeigiTy1.setZtykykmfhhkkjnm(kykmfhhkkjnm);
                    ztHnsyScrMeigiTy1.setZtykykmfhhkseiymd(khknSya.getHhknseiymd().toString());
                    ztHnsyScrMeigiTy1.setZtykykmfdai2knnm("");
                    ztHnsyScrMeigiTy1.setZtykykmfdai2kjnm("");
                    ztHnsyScrMeigiTy1.setZtykykmfdai2seiymd("00000000");
                    ztHnsyScrMeigiTy1.setZtykykmfsbuktknnm(kykmfsbuktknNm);
                    ztHnsyScrMeigiTy1.setZtykykmfsbuktkjnm(kykmfsbuktkjNm);
                    ztHnsyScrMeigiTy1.setZtykykmfsbuktseiymd(kykmfsbuktseiYmd.toString());
                    ztHnsyScrMeigiTy1.setZtykykmfdai2ktknnm("");
                    ztHnsyScrMeigiTy1.setZtykykmfdai2ktkjnm("");
                    ztHnsyScrMeigiTy1.setZtykykmfdai2ktseiymd("00000000");
                    ztHnsyScrMeigiTy1.setZtykykmfmnkktknnm(kykmfmnkktknNm);
                    ztHnsyScrMeigiTy1.setZtykykmfmnkktkjnm(kykmfmnkktkjNm);
                    ztHnsyScrMeigiTy1.setZtykykmfmnkktseiymd(kykmfmnkktseiYmd.toString());
                    ztHnsyScrMeigiTy1.setZtydntcd2("00000000");
                    ztHnsyScrMeigiTy1.setZtykjdntnm("");
                    ztHnsyScrMeigiTy1.setZtyrinjikaisouhyouji("0");
                    ztHnsyScrMeigiTy1.setZtyyobiv34x2("");
                    ztHnsyScrMeigiTy1.setZtysgtaisyoukbn("3");
                    ztHnsyScrMeigiTy1.setZtyyobiv39("");
                    ztHnsyScrMeigiTy1.setZtysyuuseihjnnm("");
                    ztHnsyScrMeigiTy1.setZtyyobiv75("");
                    ztHnsyScrMeigiTy1.setZtysysyno("00000000000");
                    ztHnsyScrMeigiTy1.setZtysueokikaisiymd("00000000");
                    ztHnsyScrMeigiTy1.setZtyhasseiriyuukbnscreen("0");
                    ztHnsyScrMeigiTy1.setZtysueokijtkbn("0");
                    ztHnsyScrMeigiTy1.setZtytaisyoufilekbn("0");
                    ztHnsyScrMeigiTy1.setZtybohaiyakkandisp2("0");
                    ztHnsyScrMeigiTy1.setZtymeihenymd2("00000000");
                    ztHnsyScrMeigiTy1.setZtynksyoumetucd("00");
                    ztHnsyScrMeigiTy1.setZtyyobiv7("");
                    ztHnsyScrMeigiTy1.setZtyyobiv20("");

                    BizPropertyInitializer.initialize(ztHnsyScrMeigiTy1);

                    ztHnsyScrMeigiTyList.add(ztHnsyScrMeigiTy1);

                    kensuCount ++;

                    if (C_UmuKbn.ARI.eq(sbuktumuFlag)) {

                        for (IT_KykUkt itKykUkt : kykUktSbuktList) {

                            if (C_UktsyuKbn.SBUKT.eq(itKykUkt.getUktsyukbn())
                                    && C_UktKbn.TOKUTEIMEIGI.eq(itKykUkt.getUktkbn())) {

                                String taisyouNmknSbukt = itKykUkt.getUktnmkn();
                                BizDate khtaisyouseiymdSbukt = itKykUkt.getUktseiymd();
                                String kanjitsinkaiAdrSbukt = "";
                                String sosikiCd1Sbukt = "0000000";
                                String sosikiCd2Sbukt = "0000000";
                                String sosikiCd3Sbukt = "0000000";
                                String sosikiCd4Sbukt = "0000000";
                                String sosikiCd5Sbukt = "0000000";
                                String kankeiNmkn1Sbukt = "";
                                String kankeiNmkn2Sbukt = "";
                                String kankeiNmkn3Sbukt = "";
                                String kankeiNmkn4Sbukt = "";
                                String kankeiNmkn5Sbukt = "";
                                String kankeiNmkj1Sbukt = "";
                                String kankeiNmkj2Sbukt = "";
                                String kankeiNmkj3Sbukt = "";
                                String kankeiNmkj4Sbukt = "";
                                String kankeiNmkj5Sbukt = "";
                                String hrkkeiroKbnSbukt = "";
                                String tsintelNoSbukt = "";
                                String hjnCdSbukt = "000000000";
                                String syoumetuYmdSbukt = "00000000";
                                String syokugyouCdSbukt = "000";
                                String nayosetaisyousegKbnSbukt = "00";

                                String taisyouNmkjSbukt = "";

                                if (C_KjkhukaKbn.KJKHUKA.eq(itKykUkt.getUktnmkjkhukakbn())) {
                                    taisyouNmkjSbukt = "";
                                }
                                else {
                                    taisyouNmkjSbukt = itKykUkt.getUktnmkj();
                                }

                                ZT_HnsyScrMeigiTy ztHnsyScrMeigiTy2 = new ZT_HnsyScrMeigiTy();

                                ztHnsyScrMeigiTy2.setZtyhnsyrecordkbn("100");
                                ztHnsyScrMeigiTy2.setZtykijyunym(kykKihon.getBosyuuym().toString());
                                ztHnsyScrMeigiTy2.setZtytaisyounmkn(taisyouNmknSbukt);
                                ztHnsyScrMeigiTy2.setZtytaisyounmkj(taisyouNmkjSbukt);
                                ztHnsyScrMeigiTy2.setZtytaisyouseiymd(khtaisyouseiymdSbukt.toString());
                                ztHnsyScrMeigiTy2.setZtytsnsknewyno(kykSya.getTsinyno());
                                ztHnsyScrMeigiTy2.setZtytsnsknewtikucd("");
                                ztHnsyScrMeigiTy2.setZtyhhknnewyno(khknSya.getHhknyno());
                                ztHnsyScrMeigiTy2.setZtyhhknnewtikucd("");
                                ztHnsyScrMeigiTy2.setZtykstkannisknewyno("");
                                ztHnsyScrMeigiTy2.setZtykstkannisknewtikucd("");
                                ztHnsyScrMeigiTy2.setZtydntnewyno("");
                                ztHnsyScrMeigiTy2.setZtydntnewtikucd("");
                                ztHnsyScrMeigiTy2.setZtykanjitsinkaiadr(kanjitsinkaiAdrSbukt);
                                ztHnsyScrMeigiTy2.setZtytodouhukennm("");
                                ztHnsyScrMeigiTy2.setZtysigunnm("");
                                ztHnsyScrMeigiTy2.setZtysosikicd1(sosikiCd1Sbukt);
                                ztHnsyScrMeigiTy2.setZtysosikicd2(sosikiCd2Sbukt);
                                ztHnsyScrMeigiTy2.setZtysosikicd3(sosikiCd3Sbukt);
                                ztHnsyScrMeigiTy2.setZtysosikicd4(sosikiCd4Sbukt);
                                ztHnsyScrMeigiTy2.setZtysosikicd5(sosikiCd5Sbukt);
                                ztHnsyScrMeigiTy2.setZtyhhknhnsktodouhukencd("00");
                                ztHnsyScrMeigiTy2.setZtykankeinmkn1(kankeiNmkn1Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkn2(kankeiNmkn2Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkn3(kankeiNmkn3Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkn4(kankeiNmkn4Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkn5(kankeiNmkn5Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkj1(kankeiNmkj1Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkj2(kankeiNmkj2Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkj3(kankeiNmkj3Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkj4(kankeiNmkj4Sbukt);
                                ztHnsyScrMeigiTy2.setZtykankeinmkj5(kankeiNmkj5Sbukt);
                                ztHnsyScrMeigiTy2.setZtyhrkkeirokbn(hrkkeiroKbnSbukt);
                                ztHnsyScrMeigiTy2.setZtydntcd("00000000");
                                ztHnsyScrMeigiTy2.setZtydntnm("");
                                ztHnsyScrMeigiTy2.setZtydntsyzkcd("");
                                ztHnsyScrMeigiTy2.setZtydntkojincd("");
                                ztHnsyScrMeigiTy2.setZtykzhurikaebankcd("0000");
                                ztHnsyScrMeigiTy2.setZtykzhurikaesitencd("000");
                                ztHnsyScrMeigiTy2.setZtykzhurikaeyokinkbn("0");
                                ztHnsyScrMeigiTy2.setZtykzhurikaekouzano("0000000");
                                ztHnsyScrMeigiTy2.setZtytsintelno(tsintelNoSbukt);
                                ztHnsyScrMeigiTy2.setZtyhjncd(hjnCdSbukt);
                                ztHnsyScrMeigiTy2.setZtyhjnjigyosyocd("");
                                ztHnsyScrMeigiTy2.setZtysymtymd(syoumetuYmdSbukt);
                                ztHnsyScrMeigiTy2.setZtysyokugyoucd(syokugyouCdSbukt);
                                ztHnsyScrMeigiTy2.setZtydai2hhknyno("");
                                ztHnsyScrMeigiTy2.setZtydai2hhknnewtikucd("");
                                ztHnsyScrMeigiTy2.setZtydai2hhkntodouhukencd("00");
                                ztHnsyScrMeigiTy2.setZtysyokugyoucd2("000");
                                ztHnsyScrMeigiTy2.setZtyyobiv118("");
                                ztHnsyScrMeigiTy2.setZtyskinnm("");
                                ztHnsyScrMeigiTy2.setZtyyobiv40("");
                                ztHnsyScrMeigiTy2.setZtynayosetaisyousegkbn(nayosetaisyousegKbnSbukt);
                                ztHnsyScrMeigiTy2.setZtynayosetaisyoukojinkbn("00");
                                ztHnsyScrMeigiTy2.setZtyyobiv46("");
                                ztHnsyScrMeigiTy2.setZtytodouhukencd1(kykKihon.getDrtenkanritodoufukencd());
                                ztHnsyScrMeigiTy2.setZtytodouhukencd2("00");
                                ztHnsyScrMeigiTy2.setZtytodouhukencd3("00");
                                ztHnsyScrMeigiTy2.setZtyyobiv34("");
                                ztHnsyScrMeigiTy2.setZtysyono(kykKihon.getSyono());
                                ztHnsyScrMeigiTy2.setZtysyoumetucd(syoumetuCd);
                                if (kykSyouhn.getSyoumetuymd() == null) {
                                    ztHnsyScrMeigiTy2.setZtysymtymd2("00000000");
                                }
                                else {
                                    ztHnsyScrMeigiTy2.setZtysymtymd2(kykSyouhn.getSyoumetuymd().toString());
                                }
                                ztHnsyScrMeigiTy2.setZtybohaiyakkandisp("1");
                                ztHnsyScrMeigiTy2.setZtymeihenymd(meihenYmd.toString());
                                ztHnsyScrMeigiTy2.setZtyseiymdseitsymd(seiymdseitsYmd.toString());
                                ztHnsyScrMeigiTy2.setZtykzkmrtityuutohukaymd("00000000");
                                ztHnsyScrMeigiTy2.setZtykykmfkykknnm(kykSya.getKyknmkn());
                                ztHnsyScrMeigiTy2.setZtykykmfkykkjnm(kykmfkykkjnm);
                                ztHnsyScrMeigiTy2.setZtykykmfkykseiymd(kykSya.getKykseiymd().toString());
                                ztHnsyScrMeigiTy2.setZtykykmfhhkknnm(khknSya.getHhknnmkn());
                                ztHnsyScrMeigiTy2.setZtykykmfhhkkjnm(kykmfhhkkjnm);
                                ztHnsyScrMeigiTy2.setZtykykmfhhkseiymd(khknSya.getHhknseiymd().toString());
                                ztHnsyScrMeigiTy2.setZtykykmfdai2knnm("");
                                ztHnsyScrMeigiTy2.setZtykykmfdai2kjnm("");
                                ztHnsyScrMeigiTy2.setZtykykmfdai2seiymd("00000000");
                                ztHnsyScrMeigiTy2.setZtykykmfsbuktknnm(kykmfsbuktknNm);
                                ztHnsyScrMeigiTy2.setZtykykmfsbuktkjnm(kykmfsbuktkjNm);
                                ztHnsyScrMeigiTy2.setZtykykmfsbuktseiymd(kykmfsbuktseiYmd.toString());
                                ztHnsyScrMeigiTy2.setZtykykmfdai2ktknnm("");
                                ztHnsyScrMeigiTy2.setZtykykmfdai2ktkjnm("");
                                ztHnsyScrMeigiTy2.setZtykykmfdai2ktseiymd("00000000");
                                ztHnsyScrMeigiTy2.setZtykykmfmnkktknnm(kykmfmnkktknNm);
                                ztHnsyScrMeigiTy2.setZtykykmfmnkktkjnm(kykmfmnkktkjNm);
                                ztHnsyScrMeigiTy2.setZtykykmfmnkktseiymd(kykmfmnkktseiYmd.toString());
                                ztHnsyScrMeigiTy2.setZtydntcd2("00000000");
                                ztHnsyScrMeigiTy2.setZtykjdntnm("");
                                ztHnsyScrMeigiTy2.setZtyrinjikaisouhyouji("0");
                                ztHnsyScrMeigiTy2.setZtyyobiv34x2("");
                                ztHnsyScrMeigiTy2.setZtysgtaisyoukbn("3");
                                ztHnsyScrMeigiTy2.setZtyyobiv39("");
                                ztHnsyScrMeigiTy2.setZtysyuuseihjnnm("");
                                ztHnsyScrMeigiTy2.setZtyyobiv75("");
                                ztHnsyScrMeigiTy2.setZtysysyno("00000000000");
                                ztHnsyScrMeigiTy2.setZtysueokikaisiymd("00000000");
                                ztHnsyScrMeigiTy2.setZtyhasseiriyuukbnscreen("0");
                                ztHnsyScrMeigiTy2.setZtysueokijtkbn("0");
                                ztHnsyScrMeigiTy2.setZtytaisyoufilekbn("0");
                                ztHnsyScrMeigiTy2.setZtybohaiyakkandisp2("0");
                                ztHnsyScrMeigiTy2.setZtymeihenymd2("00000000");
                                ztHnsyScrMeigiTy2.setZtynksyoumetucd("00");
                                ztHnsyScrMeigiTy2.setZtyyobiv7("");
                                ztHnsyScrMeigiTy2.setZtyyobiv20("");

                                BizPropertyInitializer.initialize(ztHnsyScrMeigiTy2);

                                ztHnsyScrMeigiTyList.add(ztHnsyScrMeigiTy2);

                                kensuCount ++;

                            }

                        }

                    }

                }

            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
                SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

}
