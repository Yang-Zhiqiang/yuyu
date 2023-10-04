package yuyu.batch.hozen.khkessan.khbikintyusyutu;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khbikintyusyutu.dba.KhBikinTyusyutuDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.BizDateFormatUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全備金抽出クラス
 */
public class KhBikinTyusyutuBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhBikinTyusyutuBatchParam batchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhBikinTyusyutuDao khBikinTyusyutuDao;

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void Execute() {

        int seqCount = 0;

        int kensuCount = 0;

        String syono1 = null;

        String syono2 = null;

        BizDate kessankijyunymd1 = null;

        BizDate kessankijyunymd2 = null;

        C_ShrsyoriKbn bkncdkbn1 = null;

        C_ShrsyoriKbn bkncdkbn2 = null;

        BizDate syoruiukeymd1 = null;

        BizDate syoruiukeymd2 = null;

        int seq = 0;

        IT_KhBikinkanri khBikinkanriTemp = null;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            BizDateFormatUtil.toFormatedYmd(batchParam.getSyoriYmd())));

        C_BkncdKbn[] bkncdKbn = new C_BkncdKbn[2];

        bkncdKbn[0] = C_BkncdKbn.GENGK;
        bkncdKbn[1] = C_BkncdKbn.KAIYAKU;

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(
            batchParam.getKessanYmd(), bkncdKbn);

        hozenDomManager.delete(khBikinkanriList);

        hozenDomManager.flush();

        try (ExDBResults<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean>
        khBikinkanriInfosByKakuchojobcdKsnbiymdBeanList = hozenDomManager
        .getKhBikinkanriInfosByKakutyoujobcdKsnbiymd(batchParam.getIbKakutyoujobcd(),
            batchParam.getKessanYmd());
            EntityInserter<IT_KhBikinkanri> khBikinkanriInserter = new EntityInserter<>()) {
            Iterator<KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean> iterator =
                khBikinkanriInfosByKakuchojobcdKsnbiymdBeanList.iterator();

            while (iterator.hasNext()) {

                BizNumber kawaserate = BizNumber.valueOf(0);

                BizDate kwsratekjymd = null;

                BizCurrency kanzanGaku = BizCurrency.valueOf(0);

                BizCurrency gaikazennouseisankgk = BizCurrency.optional();

                BizCurrency zennouseisank = BizCurrency.valueOf(0);

                BizCurrency gaikamikeikap = BizCurrency.optional();

                BizCurrency yenkazennouseisankgk = BizCurrency.optional();

                BizCurrency yenkamikeikap = BizCurrency.optional();

                BizCurrency mikeikap = BizCurrency.valueOf(0);

                BizNumber shrkwsrate = BizNumber.ZERO;

                BizDate shrkwsratekjnymd = null;

                BizNumber gaikashrkwsrate = BizNumber.ZERO;

                BizDate gaikashrkwsratekjnymd = null;

                KhBikinkanriInfosByKakutyoujobcdKsnbiymdBean khBikinkanriInfosByKakutyoujobcdKsnbiymdBean =
                    iterator.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(batchParam.getIbKakutyoujobcd());

                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean
                    .getIT_KykKihon().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean
                    .getIT_KykKihon().getSyono());

                if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(
                    khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykSyouhn().getSyoumetujiyuu())) {
                    continue;
                }

                if (!C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getKyktuukasyu())) {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    getKawaseRate.exec(batchParam.getKessanYmd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    kawaserate = getKawaseRate.getKawaserate();

                    kwsratekjymd = getKawaseRate.getKwsrateKjYmd();
                }

                if (!C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getKyktuukasyu())) {
                    if (C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getShrtuukasyu())) {

                        shrkwsratekjnymd = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getShrkwsratekjnymd();
                        shrkwsrate = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrkwsrate();
                    }
                    else {

                        shrkwsratekjnymd = kwsratekjymd;
                        shrkwsrate = kawaserate;
                        gaikashrkwsratekjnymd = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getGaikashrkwsratekjnymd();
                        gaikashrkwsrate = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getGaikashrkwsrate();
                    }
                }

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                if (C_ShrsyoriKbn.KAIYAKU.eq(
                    khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrsyorikbn())) {
                    if (!C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getKyktuukasyu())) {

                        kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykSyouhn().getKihons(),
                            kawaserate,
                            C_HasuusyoriKbn.SUTE);
                    } else {
                        kanzanGaku = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykSyouhn().getKihons();
                    }
                }
                else {
                    kanzanGaku = BizCurrency.valueOf(0);
                }

                if (C_Tuukasyu.JPY
                    .eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getKyktuukasyu())) {

                    yenkazennouseisankgk = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getYenzennomikeikap();
                    zennouseisank = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getYenzennomikeikap();
                    yenkamikeikap = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getYenmikeikap();
                    mikeikap = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getYenmikeikap();
                }
                else {
                    IT_KykKihon kykKihon = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykKihon();

                    IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

                    if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {

                        yenkazennouseisankgk = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getYenzennomikeikap();
                        yenkamikeikap = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getYenmikeikap();

                        if (C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getShrtuukasyu())) {

                            zennouseisank = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                                .getYenzennomikeikap();
                            mikeikap = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                                .getYenmikeikap();
                        }
                        else {
                            gaikazennouseisankgk = keisanGaikakanzan.execDivide(
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrtuukasyu(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getYenzennomikeikap(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getGaikashrkwsrate(),
                                C_HasuusyoriKbn.AGE);

                            zennouseisank = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikazennouseisankgk,
                                kawaserate, C_HasuusyoriKbn.SUTE);

                            gaikamikeikap = keisanGaikakanzan.execDivide(
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrtuukasyu(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getYenmikeikap(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getGaikashrkwsrate(),
                                C_HasuusyoriKbn.AGE);

                            mikeikap = keisanGaikakanzan.exec(C_Tuukasyu.JPY, gaikamikeikap,
                                kawaserate, C_HasuusyoriKbn.SUTE);
                        }
                    }
                    else {
                        gaikazennouseisankgk = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getZennomikeikap();
                        gaikamikeikap = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getMikeikap();

                        if (C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                            .getShrtuukasyu())) {

                            zennouseisank = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getZennomikeikap(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrkwsrate(),
                                C_HasuusyoriKbn.AGE);

                            mikeikap = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getMikeikap(),
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrkwsrate(),
                                C_HasuusyoriKbn.AGE);

                        }
                        else {

                            zennouseisank = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getZennomikeikap(),
                                kawaserate,
                                C_HasuusyoriKbn.SUTE);

                            mikeikap = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getMikeikap(),
                                kawaserate,
                                C_HasuusyoriKbn.SUTE);
                        }
                    }
                }

                BizCurrency bkngk;

                if (!C_Tuukasyu.JPY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrtuukasyu())) {
                    bkngk = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrtuukasyushrgkkei(),
                        kawaserate,
                        C_HasuusyoriKbn.SUTE);
                }

                else {

                    bkngk = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getShrtuukasyushrgkkei();
                }

                String syouhncd = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykSyouhn().getSyouhncd();
                C_Tuukasyu tuukasyu = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykSyouhn().getKyktuukasyu();

                if (C_ShrsyoriKbn.GENGAKU.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrsyorikbn())) {

                    IT_KykSyouhnRireki kykSyouhnRireki = khBikinTyusyutuDao.getKykSyouhnRirekiBySyonoHenkousikibetukey(
                        khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getSyono(),
                        khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getHenkousikibetukey());

                    if (kykSyouhnRireki != null) {

                        syouhncd = kykSyouhnRireki.getSyouhncd();

                        tuukasyu = kykSyouhnRireki.getKyktuukasyu();
                    }
                }

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(syouhncd, tuukasyu);
                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(
                            MessageId.EIA1010,
                            "契約保全備金抽出",
                            khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getSyono()));
                }

                C_Segcd kbnkeirisegcd = syouhinbetuSegmentBean.getSegcd1();
                if (seqCount == 0) {
                    syono1 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getSyono();

                    kessankijyunymd1 = batchParam.getKessanYmd();

                    bkncdkbn1 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrsyorikbn();

                    syoruiukeymd1 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getSyoruiukeymd();

                    seqCount = 1;

                    seq = 1;

                }
                else {
                    syono2 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getSyono();

                    kessankijyunymd2 = batchParam.getKessanYmd();

                    bkncdkbn2 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki().getShrsyorikbn();

                    syoruiukeymd2 = khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                        .getSyoruiukeymd();

                    if (syono1.equals(syono2)
                        && kessankijyunymd1.equals(kessankijyunymd2)
                        && bkncdkbn1.eq(bkncdkbn2)
                        && syoruiukeymd1.equals(syoruiukeymd2)) {

                        seqCount = seqCount + 1;
                        seq = seq + 1;
                    }
                    else {
                        seqCount = 0;
                        seq = 1;
                    }
                }

                C_BkncdKbn bkncdkbn = C_BkncdKbn.BLNK;

                C_UmuKbn gngkkiykumukbn = C_UmuKbn.NONE;

                C_UmuKbn shrumu = C_UmuKbn.NONE;

                C_UmuKbn sinsaumukbn = C_UmuKbn.NONE;

                if (C_ShrsyoriKbn.KAIYAKU.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrsyorikbn())) {
                    bkncdkbn = C_BkncdKbn.KAIYAKU;

                    gngkkiykumukbn = C_UmuKbn.NONE;

                    shrumu = C_UmuKbn.ARI;

                    if (C_SntkhouKbn.HJY.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KykKihon()
                        .getSntkhoukbn())) {
                        sinsaumukbn = C_UmuKbn.ARI;
                    }

                    else {

                        sinsaumukbn = C_UmuKbn.NONE;
                    }
                }
                else if (C_ShrsyoriKbn.GENGAKU.eq(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrsyorikbn())) {
                    bkncdkbn = C_BkncdKbn.GENGK;

                    gngkkiykumukbn = C_UmuKbn.ARI;

                    shrumu = C_UmuKbn.NONE;

                    sinsaumukbn = C_UmuKbn.NONE;
                }

                khBikinkanriTemp = new IT_KhBikinkanri();

                khBikinkanriTemp.setSyono(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getSyono());

                khBikinkanriTemp.setKessankijyunymd(batchParam.getKessanYmd());

                khBikinkanriTemp.setBkncdkbn(bkncdkbn);

                khBikinkanriTemp.setBknkktymd(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getSyoruiukeymd());

                khBikinkanriTemp.setRenno(seq);

                khBikinkanriTemp.setBknrigikbn(C_BknrigiKbn.BLNK);

                khBikinkanriTemp.setHenkousikibetukey(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean
                    .getIT_KhShrRireki().getHenkousikibetukey());

                khBikinkanriTemp.setCalckijyunymd(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getSyoruiukeymd());

                if (!BizUtil.isBlank(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean
                    .getIT_KhTtdkRireki().getSyorisosikicd())
                    && khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhTtdkRireki().getSyorisosikicd()
                    .length() >= 3) {
                    khBikinkanriTemp.setSisyacd(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean
                        .getIT_KhTtdkRireki().getSyorisosikicd().substring(0, 3));
                }

                khBikinkanriTemp.setKbnkeirisegcd(kbnkeirisegcd);

                khBikinkanriTemp.setSyouhncd(syouhncd);

                khBikinkanriTemp.setBknsyutkkbn(C_BknsyutkKbn.SYU);

                khBikinkanriTemp.setBkngk(bkngk);

                khBikinkanriTemp.setKihons(kanzanGaku);

                khBikinkanriTemp.setGngkkiykumukbn(gngkkiykumukbn);

                khBikinkanriTemp.setShrumu(shrumu);

                khBikinkanriTemp.setSinsaumukbn(sinsaumukbn);

                khBikinkanriTemp.setBknjkukbn(C_BknJkuKbn.SINBI);

                khBikinkanriTemp.setShrsyoriymd(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrsyoriymd());

                khBikinkanriTemp.setTyakkinymd(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrymd());

                khBikinkanriTemp.setKyktuukasyu(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getKyktuukasyu());

                khBikinkanriTemp.setShrtuukasyu(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrtuukasyu());

                khBikinkanriTemp.setShrgk(khBikinkanriInfosByKakutyoujobcdKsnbiymdBean.getIT_KhShrRireki()
                    .getShrtuukasyushrgkkei());

                khBikinkanriTemp.setShrkwsratekjnymd(shrkwsratekjnymd);

                khBikinkanriTemp.setShrkwsrate(shrkwsrate);

                khBikinkanriTemp.setGyoumuKousinKinou(kinou.getKinouId());

                khBikinkanriTemp.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                khBikinkanriTemp.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                khBikinkanriTemp.setGaikashrkwsratekjnymd(gaikashrkwsratekjnymd);

                khBikinkanriTemp.setGaikashrkwsrate(gaikashrkwsrate);

                khBikinkanriTemp.setYenkazennouseisankgk(yenkazennouseisankgk);

                khBikinkanriTemp.setGaikazennouseisankgk(gaikazennouseisankgk);

                khBikinkanriTemp.setZennouseisankgk(zennouseisank);

                khBikinkanriTemp.setYenkamikeikap(yenkamikeikap);

                khBikinkanriTemp.setGaikamikeikap(gaikamikeikap);

                khBikinkanriTemp.setMikeikap(mikeikap);

                BizPropertyInitializer.initialize(khBikinkanriTemp);

                khBikinkanriInserter.add(khBikinkanriTemp);

                kensuCount++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002,
            String.valueOf(kensuCount),
            "<<契約保全備金管理TBL>>"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}