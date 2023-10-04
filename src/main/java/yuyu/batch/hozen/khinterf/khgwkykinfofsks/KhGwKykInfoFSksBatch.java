package yuyu.batch.hozen.khinterf.khgwkykinfofsks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khgwkykinfofsks.dba.GwKykInfosBean;
import yuyu.batch.hozen.khinterf.khgwkykinfofsks.dba.KhGwKykInfoFSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanNkNengk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import yuyu.def.hozen.detacher.IT_AnsyuKihonDetacher;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 共同ＧＷ用契約情報Ｆ作成クラス</BR>
 */
public class KhGwKykInfoFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    private static final String GWHOSYUCD_BORERO_YEM = "0011300";

    private static final int DATASYUBETU_HOZEN = 1;

    private static final int DATASYUBETU_HKNKN = 2;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhGwKykInfoFSksDao khGwKykInfoFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String[] kinouIds = new String[27];
        BizDate syoriYmd = batchParam.getSyoriYmd();
        String kakutyoujobcd = batchParam.getIbKakutyoujobcd();

        long kensuCountHozen = 0;
        long kensuCountHknkn = 0;

        kinouIds[0] = IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU;
        kinouIds[1] = IKhozenCommonConstants.KINOUID_MEIGIHENKOU;
        kinouIds[2] = IKhozenCommonConstants.KINOUID_KANAKANJITEISEI;
        kinouIds[3] = IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA;
        kinouIds[4] = IKhozenCommonConstants.KINOUID_KAIYAKU;
        kinouIds[5] = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;
        kinouIds[6] = IKhozenCommonConstants.KINOUID_GENGAKU;
        kinouIds[7] = IKhozenCommonConstants.KINOUID_SEINENGAPPISEI;
        kinouIds[8] = IKhozenCommonConstants.KINOUID_DAIRITENINFOSYUUSEI;
        kinouIds[9] = IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU;
        kinouIds[10] = IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI;
        kinouIds[11] = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
        kinouIds[12] = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;
        kinouIds[13] = IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI;
        kinouIds[14] = IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU;
        kinouIds[15] = IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK;
        kinouIds[16] = IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU;
        kinouIds[17] = IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN;
        kinouIds[18] = IKhozenCommonConstants.KINOUID_DATTAI;
        kinouIds[19] = IKhozenCommonConstants.KINOUID_ONLINEDATTAI;
        kinouIds[20] = IKhozenCommonConstants.KINOUID_KZSEIBI;
        kinouIds[21] = IKhozenCommonConstants.KINOUID_DSHR;
        kinouIds[22] = IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI;
        kinouIds[23] = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;
        kinouIds[24] = IKhozenCommonConstants.KINOUID_CIFCDIKKATUHENKOU;
        kinouIds[25] = IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK;
        kinouIds[26] = IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU;

        try (ExDBResults<KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean>
        rsHozen = hozenDomManager.getKeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinous(
            kakutyoujobcd, syoriYmd, C_SyutkKbn.SYU, kinouIds);
            EntityInserter<ZT_KydGWKykInfoTy> kydGWKykInfoTyInserterHozen = new EntityInserter<>()) {

            kensuCountHozen = editKydGWKykInfoTy(DATASYUBETU_HOZEN, rsHozen.iterator(), kydGWKykInfoTyInserterHozen);
        }

        try (ExDBResults<GwKykInfosBean>
        rsHknkn = khGwKykInfoFSksDao.getSmbcSibouInfoRendouInfosByKakutyoujobcdSyoriYmdSyutkkbn(
            kakutyoujobcd, syoriYmd, C_SeikyuuSyubetu.SBKRUKTK, C_SyutkKbn.SYU);
            EntityInserter<ZT_KydGWKykInfoTy> kydGWKykInfoTyInserterHknkn = new EntityInserter<>()) {

            kensuCountHknkn = editKydGWKykInfoTy(DATASYUBETU_HKNKN, rsHknkn.iterator(), kydGWKykInfoTyInserterHknkn);
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCountHozen + kensuCountHknkn)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kensuCountHozen), "（保全異動）"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kensuCountHknkn), "（保険金異動）"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private long editKydGWKykInfoTy(int pDataSyubetu, Iterator<?> pIterator, EntityInserter<ZT_KydGWKykInfoTy> pInserter) {

        long kensuCount = 0;

        BizDate syoriYmd = batchParam.getSyoriYmd();

        String kakutyoujobcd = batchParam.getIbKakutyoujobcd();

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

        KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        KeisanNkNengk keisanNkNengk = SWAKInjector.getInstance(KeisanNkNengk.class);

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        SortIT_NyknJissekiRireki nyknJissekiRireki = SWAKInjector.getInstance(SortIT_NyknJissekiRireki.class);

        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

        String syonoMae = null;

        List<String> khosyucdList = new ArrayList<>();

        List<String> tknmList = new ArrayList<>();

        List<String> sbuktnmknList = new ArrayList<>();

        List<String> mnkuktnmknList = new ArrayList<>();

        List<IT_KykUkt> kykUktList = new ArrayList<>();

        List<IT_KykUkt> kykUktNkList = new ArrayList<>();

        while (pIterator.hasNext()) {

            GwKykInfosBean bean = null;

            if (pDataSyubetu == DATASYUBETU_HOZEN) {

                KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean khTtdkRirekiBean =
                    (KeiyakuHozenTetuzukiRirekiInfosByKakutyoujobcdSyoriYmdSyutkkbnGyoumuKousinKinousBean)pIterator.next();

                bean = new GwKykInfosBean(
                    khGwKykInfoFSksDao.getSmbcSibouInfoRendouBySyonoSyoriymd(
                        khTtdkRirekiBean.getIT_KhTtdkRireki().getSyono(), syoriYmd),
                        khTtdkRirekiBean.getIT_KykDairiten(),
                        khTtdkRirekiBean.getIT_KykKihon(),
                        khTtdkRirekiBean.getIT_KykSyouhn(),
                        khTtdkRirekiBean.getIT_KykSonotaTkyk(),
                        khTtdkRirekiBean.getIT_KykSya(),
                        khTtdkRirekiBean.getIT_HhknSya(),
                        khTtdkRirekiBean.getIT_KhTtdkRireki());
            }
            else {
                bean = (GwKykInfosBean)pIterator.next();
            }

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);

            bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bean.getIT_KhTtdkRireki().getKbnkey());

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bean.getIT_KhTtdkRireki().getSyono());

            if (pDataSyubetu == DATASYUBETU_HOZEN) {

                boolean hanteiKekka = tysytTaisyouIdouHantei(
                    bean.getIT_KhTtdkRireki().getGyoumuKousinKinou(),
                    bean.getIT_KhTtdkRireki().getSyorikbn(),
                    bean.getIT_KykSyouhn().getSyoumetujiyuu());

                if (!hanteiKekka) {

                    continue;
                }
            }

            String hknsyukigou = "";

            String sinkeizkkbn = "0";

            Long goukeip2 = null;

            Long itijibrp = null;

            BizCurrency syus = null;

            BizCurrency sibous = null;

            String syuhknkknkbn = "";

            String nidojiyu = "99";

            BizCurrency idoukaiyakup = null;

            String idokaiyakuymd = "";

            String sbuktkbn = "";

            String mnkuktkbn = "0";

            int tksuu = 0;

            String tktyuutohukahyj = "";

            String syoumetucd = "";

            String hknkkn = "00";

            BizDate hknkknmanryouymd = BizDate.valueOf("99999999");

            String haitoukbn = "";

            String sinsakbn = "";

            String kisokyknkshrhsykn = "00";

            String nkshrkknkbn = "";

            String kshrkknnen = "000";

            BizNumber nksueokikn = BizNumber.ZERO;

            String nkshrstartymd = "00000000";

            String uktkbn = "0";

            String tratkisyacd2 = "000000";

            String dairitencd2 = "";

            String bosyuudairitenatkikeitaikbn = "1";

            Long bsyudiritnatkiwari2 = 0L;

            String kyksyaseikbn = "";

            String hhknseikbn = "";

            String hhkntdk = "99";

            String tsinkihontikucd = "";

            String tsinkaiadr = "";

            BizCurrency rsgaku = BizCurrency.valueOf(0);

            String hrkkeiroKbn = "";

            String hrkhouhoukbn = "";

            String hrkymd = "";

            String bnkaisuu = "";

            String bnsyuruikbn = "";

            BizCurrency bnkyk1kaip = BizCurrency.valueOf(0);

            String syuhrkkknkbn = "";

            String syuhrkkkn = "";

            String syukinkbn = "";

            String zeiseitekikakuhyj = "";

            BizCurrency zennoup = BizCurrency.valueOf(0);

            String zennouendym = "";

            String kzsyurui = "";

            String kouzano7keta = "";

            String bankcd = "";

            String shitencd = "";

            String kyksiboumeighnkhyj = "0";

            long kykmfksnctrlkh = 0L;

            String mkhtoutatuymd = "00000000";

            C_Tuukasyu rstuukasyu = C_Tuukasyu.BLNK;

            String ikkatubaraikbn = "";

            String ikkatubaraikaisuu = "";

            BizDate calckijyunymd = BizDate.valueOf("00000000");

            BizNumber fstpnyknYmdKawaserate = BizNumber.valueOf(0);

            BizNumber tousyokykjiYenNyknRate = BizNumber.valueOf(0);

            BizNumber rendouritu = BizNumber.valueOf(0);

            String kosyasbskttdkstartflg = "";

            String kosyasbukthukusuflg = "";

            String kosyahhknsbymd = "";

            String kosyassksjyuriymd = "";

            String kosyasshrkanryoymd = "";

            String kosyasbuktseiymd = "";

            String kosyasbuktkjadr = "";

            String kosyasbukttelno = "";

            C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

            C_UmuKbn iktnyuukinnumu = C_UmuKbn.NONE;

            if (!BizUtil.isBlank(syonoMae)) {
                khosyucdList = new ArrayList<>();

                tknmList = new ArrayList<>();

                sbuktnmknList = new ArrayList<>();
            }

            BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

            String syouhncd = bean.getIT_KykSyouhn().getSyouhncd();

            Integer syouhnsdno = bean.getIT_KykSyouhn().getSyouhnsdno();

            syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhncd, syouhnsdno);
            if (syouhnZokusei == null) {

                throw new CommonBizAppException(
                    MessageUtil.getMessage(MessageId.EBS0005,
                        BM_SyouhnZokusei.TABLE_NAME,
                        BM_SyouhnZokusei.SYOUHNCD,
                        syouhncd,
                        BM_SyouhnZokusei.SYOUHNSDNO,
                        syouhnsdno.toString()));
            }

            CurrencyType keiyakuType = henkanTuuka.henkanTuukaKbnToType(bean.getIT_KykSyouhn().getKyktuukasyu());

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(bean.getIT_KhTtdkRireki().getSyono());

            kykKihon = IT_KykKihonDetacher.detachKhGwKykInfotouched(kykKihon);

            if (C_UmuKbn.ARI.eq(bean.getIT_KykDairiten().getDrtenbunumu())) {

                IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(2);

                if (kykDairiten == null) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1048,
                            IT_KykDairiten.TABLE_NAME,
                            bean.getIT_KykDairiten().getSyono() + "　代理店連番：2"));
                }

                tratkisyacd2 = kykDairiten.getBosyuucd();

                dairitencd2 = kykDairiten.getDrtencd();

                bosyuudairitenatkikeitaikbn = "3";

                bsyudiritnatkiwari2 = new BigDecimal(kykDairiten.getBunwari().toString()).longValue();
            }

            kykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

            kykUktNkList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

            if (kykUktNkList.size() > 0) {
                uktkbn = kykUktNkList.get(0).getUktkbn().getValue();
            }

            List<IT_NyknJissekiRireki> nyknJissekiRirekiList =  kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

            if (nyknJissekiRirekiList.size() == 0) {

                throw new CommonBizAppException(
                    MessageUtil.getMessage(MessageId.EIA1048,
                        IT_NyknJissekiRireki.TABLE_NAME,
                        bean.getIT_KhTtdkRireki().getSyono()));
            }

            nyknJissekiRirekiList = nyknJissekiRireki.OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiList);

            rsgaku = nyknJissekiRirekiList.get(0).getRsgaku();

            rstuukasyu = nyknJissekiRirekiList.get(0).getRstuukasyu();

            hrkkaisuu = nyknJissekiRirekiList.get(0).getHrkkaisuu();

            iktnyuukinnumu = nyknJissekiRirekiList.get(0).getIktnyuukinnumu();

            if (!BizUtil.isBlank(bean.getIT_KykSyouhn().getSyouhncd())
                && bean.getIT_KykSyouhn().getSyouhncd().length() >= 2) {

                hknsyukigou = bean.getIT_KykSyouhn().getSyouhncd().substring(0, 2);
            }

            int syohinHanteiKeika = SyouhinUtil.hantei(bean.getIT_KykSyouhn().getSyouhncd());

            C_Hrkkeiro henkanmaehrkkeiro = bean.getIT_KykKihon().getHrkkeiro();
            if (C_Hrkkeiro.HURIKAE.eq(henkanmaehrkkeiro)) {
                henkanmaehrkkeiro = C_Hrkkeiro.KOUHURI;
            }

            KbnInfoBean kbnInfoBean1 = bzKbnHenkanUtil.convKbn(
                henkanmaehrkkeiro.getValue(),
                C_Hrkkeiro.class,
                C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

            if (kbnInfoBean1.isHenkanFlg()) {

                hrkkeiroKbn = kbnInfoBean1.getKbnData();
            }
            else {

                throw new CommonBizAppException(
                    MessageUtil.getMessage(MessageId.EIA1046,
                        IT_KykKihon.HRKKEIRO,
                        bean.getIT_KykKihon().getHrkkeiro().getValue()));
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())
                || C_Kykjyoutai.ZENNOU.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                hrkhouhoukbn = "1";
            }
            else {

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.HALFY.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    hrkhouhoukbn = "6";
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.NEN.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    hrkhouhoukbn = "5";
                }
                else {

                    hrkhouhoukbn = "8";
                }
            }

            if (C_Hrkkeiro.KOUHURI.eq(henkanmaehrkkeiro) || C_Hrkkeiro.CREDIT.eq(henkanmaehrkkeiro)) {

                hrkymd = "BK";
            }


            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                bnkyk1kaip = BizCurrency.valueOf(0);

                if (C_Tuukasyu.JPY.eq(bean.getIT_KykSyouhn().getKyktuukasyu())) {
                    if ((syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) ||
                        (syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19)) {

                        itijibrp = new BigDecimal(bean.getIT_KykSyouhn().getKihons().toAdsoluteString()).longValue();

                        goukeip2 = new BigDecimal(bean.getIT_KykSyouhn().getKihons().toAdsoluteString()).longValue();

                    }
                    else {
                        BizDate yendthnkymd = bean.getIT_KykSyouhn().getYendthnkymd();

                        BizDateYM kijunYm = keisanWKijunYM.exec(
                            bean.getIT_KykSyouhn().getKykymd(),
                            yendthnkymd,
                            null,
                            null,
                            bean.getIT_KykSyouhn().getKykjyoutai(),
                            bean.getIT_KykSyouhn().getSyouhncd(),
                            yendthnkymd);

                        C_ErrorKbn errorKbn = keisanWExt.exec(
                            bean.getIT_KhTtdkRireki().getSyono(),
                            yendthnkymd);

                        if (!C_ErrorKbn.OK.eq(errorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010,
                                    "解約返戻金計算拡張情報作成",
                                    bean.getIT_KhTtdkRireki().getSyono()));
                        }

                        keisanWExtBean = keisanWExt.getKeisanWExtBean();

                        C_ErrorKbn keisanWErrorKbn = keisanW.exec(
                            yendthnkymd,
                            kijunYm,
                            keisanWExtBean);

                        if (!C_ErrorKbn.OK.eq(keisanWErrorKbn)) {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010,
                                    "解約返戻金計算",
                                    bean.getIT_KhTtdkRireki().getSyono()));
                        }

                        itijibrp = new BigDecimal(keisanW.getV().toAdsoluteString()).longValue();

                        goukeip2 = new BigDecimal(keisanW.getV().toAdsoluteString()).longValue();

                    }

                }
                else {

                    itijibrp = new BigDecimal(bean.getIT_KykKihon().getHrkp().toValidValue().toAdsoluteString())
                    .longValue();

                    goukeip2 = new BigDecimal(bean.getIT_KykKihon().getHrkp().toValidValue().toAdsoluteString())
                    .longValue();
                }
            }
            else {
                if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                    KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
                    List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
                    KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
                    KeisanTukiIkkatuNyuukinGk KeisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

                    keisanIkkatuNkgSyouhnBean.setSyouhnCd(bean.getIT_KykSyouhn().getSyouhncd());
                    keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(bean.getIT_KykSyouhn().getSyouhnsdno());
                    keisanIkkatuNkgSyouhnBean.setRyouritusdNo(bean.getIT_KykSyouhn().getRyouritusdno());
                    keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.valueOf(0));
                    keisanIkkatuNkgSyouhnBean.setHokenryou(bean.getIT_KykKihon().getHrkp());

                    keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

                    keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
                    keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(bean.getIT_KykKihon().getTikiktbrisyuruikbn().toString()));
                    keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(bean.getIT_KykKihon().getTikiktbrisyuruikbn());
                    keisanIkkatuNkgBean.setRstuukasyu(rstuukasyu);
                    keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                    keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
                    keisanIkkatuNkgBean.setSyokaiprsYmd(null);
                    keisanIkkatuNkgBean.setJyutoustartYm(null);

                    C_ErrorKbn errorKbn = KeisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1010,
                                "月払一括入金額計算",
                                bean.getIT_KhTtdkRireki().getSyono()));
                    }

                    bnkyk1kaip = KeisanTukiIkkatuNyuukinGk.getIktnyknkgk();

                }
                else {
                    bnkyk1kaip = bean.getIT_KykSyouhn().getHokenryou();
                }

                if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.NEN.eq(bean.getIT_KykKihon().getHrkkaisuu())) {
                    goukeip2 = new BigDecimal(bnkyk1kaip.toAdsoluteString()).longValue();
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.HALFY.eq(bean.getIT_KykKihon().getHrkkaisuu())) {
                    goukeip2 = new BigDecimal(bnkyk1kaip.multiply(2).toAdsoluteString()).longValue();
                }
                else {
                    goukeip2 = new BigDecimal(bnkyk1kaip.multiply(12).toAdsoluteString()).longValue();
                }
            }

            if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                if (BizDateUtil.compareYmd(
                    bean.getIT_KykSyouhn().getKykymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER) {

                    calckijyunymd = bean.getIT_KykSyouhn().getKykymd();
                }
                else {

                    calckijyunymd = syoriYmd;
                }

                if (!C_Tuukasyu.JPY.eq(bean.getIT_KykSyouhn().getKyktuukasyu())) {

                    C_ErrorKbn errorKbn = getKawaseRate.exec(
                        bean.getIT_KykKihon().getFstpnyknymd().getPreviousDay().getBusinessDay(CHolidayAdjustingMode.PREVIOUS) ,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        bean.getIT_KykSyouhn().getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException(
                            MessageUtil.getMessage(MessageId.EIA1047,
                                bean.getIT_KykKihon().getFstpnyknymd().getPreviousDay().
                                getBusinessDay(CHolidayAdjustingMode.PREVIOUS).toString(),
                                C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                                bean.getIT_KykSyouhn().getKyktuukasyu().getValue(),
                                C_Tuukasyu.JPY.getValue(),
                                C_KawasetekiyoKbn.TTM.getValue(),
                                C_KawasetsryKbn.NYUKINRATE.getValue(),
                                C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                                C_YouhiKbn.HUYOU.getValue()));
                    }

                    fstpnyknYmdKawaserate = getKawaseRate.getKawaserate();
                }
                else {

                    fstpnyknYmdKawaserate = BizNumber.valueOf(0);
                }

                C_ErrorKbn errorKbn = keisanWExt.exec(bean.getIT_KhTtdkRireki().getSyono(), calckijyunymd);

                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    keisanWExtBean = keisanWExt.getKeisanWExtBean();
                }
                else {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1010,
                            "解約返戻金計算拡張情報作成",
                            bean.getIT_KhTtdkRireki().getSyono()));
                }

                GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

                GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

                getYoteirirituBean.setSyouhncd(keisanWExtBean.getSyouhncd());
                getYoteirirituBean.setKijyunymd(keisanWExtBean.getKykymd());
                getYoteirirituBean.setSknnkaisiymd(keisanWExtBean.getKykymd());
                getYoteirirituBean.setKykymd(keisanWExtBean.getKykymd());
                getYoteirirituBean.setHknkkn(keisanWExtBean.getHknkkn());
                getYoteirirituBean.setHknkknsmnkbn(keisanWExtBean.getHknkknsmnkbn());
                getYoteirirituBean.setHhknnen(keisanWExtBean.getHhknnen());
                getYoteirirituBean.setSitihsyuriritu(keisanWExtBean.getYoteirrthendohosyurrt());
                getYoteirirituBean.setTuukasyu(keisanWExtBean.getTuukasyu());

                C_ErrorKbn yoteirirituErrorKbn = getYoteiriritu.exec(getYoteirirituBean);

                if (C_ErrorKbn.ERROR.eq(yoteirirituErrorKbn)) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010,
                        "予定利率取得",
                        bean.getIT_KhTtdkRireki().getSyono()));
                }

                keisanVHeijyunBean.setSyouhncd(keisanWExtBean.getSyouhncd());

                keisanVHeijyunBean.setRyouritusdno(keisanWExtBean.getRyouritusdno());

                keisanVHeijyunBean.setCalckijyunYm(bean.getIT_KykSyouhn().getHknkknmanryouymd().getBizDateYM());

                keisanVHeijyunBean.setKykymd(keisanWExtBean.getKykymd());

                keisanVHeijyunBean.setHokenryou(keisanWExtBean.getHokenryou());

                keisanVHeijyunBean.setKyktuukasyu(keisanWExtBean.getTuukasyu());

                keisanVHeijyunBean.setHhknsei(keisanWExtBean.getHhknsei());

                keisanVHeijyunBean.setHhknnen(keisanWExtBean.getHhknnen());

                keisanVHeijyunBean.setHknkkn(keisanWExtBean.getHknkkn());

                keisanVHeijyunBean.setHknkknsmnkbn(keisanWExtBean.getHknkknsmnkbn());

                keisanVHeijyunBean.setHrkkkn(keisanWExtBean.getHrkkkn());

                keisanVHeijyunBean.setHrkkknsmnkbn(keisanWExtBean.getHrkkknsmnkbn());

                keisanVHeijyunBean.setHrkkaisuu(keisanWExtBean.getHrkkaisuu());

                keisanVHeijyunBean.setFstpryosyu(keisanWExtBean.getFstpryosyuymd());

                keisanVHeijyunBean.setSitihsyuriritu(keisanWExtBean.getYoteirrthendohosyurrt());

                keisanVHeijyunBean.setTmttkntaisyouym(null);

                keisanVHeijyunBean.setCalckaisiYmjitenv(BizCurrency.valueOf(0, keiyakuType));

                keisanVHeijyunBean.setCalckaisiYmjitensump(BizCurrency.valueOf(0, keiyakuType));

                keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);

                keisanVHeijyunBean.setSisansyoriYmd(bean.getIT_KykSyouhn().getKykymd());

                keisanVHeijyunBean.setSisanyoteiriritu(getYoteiriritu.getYoteiriritu());

                keisanVHeijyunBean.setSisankawaserate(fstpnyknYmdKawaserate);

                C_ErrorKbn errorKbn1 = keisanVHeijyun.exec(keisanVHeijyunBean);

                if (!C_ErrorKbn.OK.eq(errorKbn1)) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1010,
                            "平準払用保険料積立金計算",
                            bean.getIT_KykKihon().getSyono()));
                }

                int nkshrstartnen = setNenrei.exec(
                    bean.getIT_KykSyouhn().getHknkknmanryouymd(),
                    bean.getIT_KykSyouhn().getHhknseiymd());

                C_Seibetu seibetu = C_Seibetu.BLNK;

                if (C_Hhknsei.MALE.eq(keisanWExtBean.getHhknsei())) {

                    seibetu = C_Seibetu.MALE;
                }
                else if (C_Hhknsei.FEMALE.eq(keisanWExtBean.getHhknsei())) {

                    seibetu = C_Seibetu.FEMALE;
                }

                C_ErrorKbn errorKbn2 = keisanNkNengk.exec(
                    bean.getIT_KykSyouhn().getNksyukbn(),
                    keisanWExtBean.getRyouritusdno(),
                    keisanWExtBean.getTuukasyu(),
                    bean.getIT_KykSyouhn().getNenkinkkn(),
                    nkshrstartnen,
                    seibetu,
                    keisanVHeijyun.getV());

                if (!C_ErrorKbn.OK.eq(errorKbn2)) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1049,
                            "年金年額計算",
                            bean.getIT_KykSyouhn().getNksyukbn().getValue(),
                            keisanWExtBean.getRyouritusdno(),
                            keisanWExtBean.getTuukasyu().getValue(),
                            bean.getIT_KykSyouhn().getNenkinkkn().toString(),
                            String.valueOf(nkshrstartnen),
                            keisanWExtBean.getHhknsei().getValue(),
                            keisanVHeijyun.getV().toString()));
                }

                syus = keisanNkNengk.getNkNengk();

                sibous = keisanNkNengk.getNkNengk();
            }
            else {

                if (C_Tuukasyu.JPY.eq(bean.getIT_KykSyouhn().getKyktuukasyu())) {

                    if (syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
                        BizDate calckiJyunYmd = syoriYmd;

                        if (bean.getIT_KykSyouhn().getYendthnkymd() != null) {
                            if (BizDateUtil.compareYmd(syoriYmd,bean.getIT_KykSyouhn().getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                                calckiJyunYmd = bean.getIT_KykSyouhn().getYendthnkymd();
                            }
                        }

                        C_ErrorKbn errorKbnHkShrKngk = calcHkShrKngk.execByKeisanWExt(
                            bean.getIT_KhTtdkRireki().getSyono(),
                            calckiJyunYmd,
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBHOKENKIN,
                            bean.getIT_KykKihon().getSdpdkbn(),
                            bean.getIT_KykKihon().getHrkkeiro());

                        if (!C_ErrorKbn.OK.eq(errorKbnHkShrKngk)) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "保険金額計算",
                                bean.getIT_KhTtdkRireki().getSyono()));
                        }

                        CalcHkShrKngkBean wkCalcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();
                        syus = wkCalcHkShrKngkBean.getHokenknGk();
                        sibous = wkCalcHkShrKngkBean.getHokenknGk();
                    }
                    else {
                        syus = bean.getIT_KykSyouhn().getKihons();

                        sibous = bean.getIT_KykSyouhn().getKihons();
                    }
                }
                else{

                    syus = bean.getIT_KykSyouhn().getKihons().toValidValue();

                    sibous = bean.getIT_KykSyouhn().getKihons().toValidValue();
                }
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())
                || C_Kykjyoutai.ZENNOU.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                bnkaisuu = "00";
            }
            else {

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.HALFY.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    bnkaisuu = "02";
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.NEN.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    bnkaisuu = "01";
                }
                else {

                    bnkaisuu = "12";
                }
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())
                || C_Kykjyoutai.ZENNOU.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                bnsyuruikbn = "00";
            }
            else {

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.HALFY.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    bnsyuruikbn = "14";
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn()) ||
                    C_Hrkkaisuu.NEN.eq(bean.getIT_KykKihon().getHrkkaisuu())) {

                    bnsyuruikbn = "15";
                }
                else {

                    bnsyuruikbn = "01";
                }
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {

                syuhknkknkbn = "3";
            }
            else if (C_HknkknsmnKbn.NENMANKI.eq(bean.getIT_KykSyouhn().getHknkknsmnkbn())) {

                syuhknkknkbn = "1";
            }
            else if (C_HknkknsmnKbn.SAIMANKI.eq(bean.getIT_KykSyouhn().getHknkknsmnkbn())) {

                syuhknkknkbn = "2";
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                syuhrkkknkbn = "";
            }
            else {

                syuhrkkknkbn = "2";
            }

            if ("2".equals(syuhrkkknkbn)) {

                syuhrkkkn = bean.getIT_KykSyouhn().getHrkkkn().toString();
            }
            else {

                syuhrkkkn = "";
            }

            if (!C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {
                if (bean.getIT_KykSyouhn().getHknkkn() != null) {
                    hknkkn = bean.getIT_KykSyouhn().getHknkkn().toString();
                }

                hknkknmanryouymd = bean.getIT_KykSyouhn().getHknkknmanryouymd().addDays(-1).getRekijyou();
            }

            syoumetucd = syoumetucdHantei(bean.getIT_KykSyouhn().getSyoumetujiyuu());

            if (bean.getIT_KykSyouhn().getSyoumetuymd() != null) {
                idokaiyakuymd = bean.getIT_KykSyouhn().getSyoumetuymd().toString();
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                syukinkbn = "1";
            }
            else {

                syukinkbn = "2";
            }

            KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(bean.getIT_KykKihon().getHaitoukbn()
                .getValue(),
                C_HaitouKbn.class,
                C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

            if (kbnInfoBean.isHenkanFlg()) {
                haitoukbn = kbnInfoBean.getKbnData();
            }
            else {

                throw new CommonBizAppException(
                    MessageUtil.getMessage(MessageId.EIA1046,
                        IT_KykKihon.HAITOUKBN,
                        bean.getIT_KykKihon().getHaitoukbn().getValue()));
            }

            String creditcardhrkbn = "";
            if (C_Hrkkeiro.CREDIT.eq(bean.getIT_KykKihon().getHrkkeiro())) {
                creditcardhrkbn = "1";
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getMusenumu())) {
                sinsakbn = "A";
            }
            else {

                if (C_SntkhouKbn.KKT.eq(bean.getIT_KykKihon().getSntkhoukbn())) {
                    sinsakbn = "1";
                }
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getZeiseitkkktkykhukaumu())) {

                zeiseitekikakuhyj = "1";
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                if (bean.getIT_KykSyouhn().getHknkkn() != null) {

                    nksueokikn = BizNumber.valueOf(bean.getIT_KykSyouhn().getHknkkn()).subtract(BizNumber.valueOf(bean.getIT_KykSyouhn().getHrkkkn()));
                }

                if (bean.getIT_KykSyouhn().getHknkknmanryouymd() != null) {

                    nkshrstartymd = bean.getIT_KykSyouhn().getHknkknmanryouymd().toString();
                }

                if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(bean.getIT_KykSyouhn().getNksyukbn())) {

                    nkshrkknkbn = "3";
                    kshrkknnen = "999";
                }
                else {

                    kisokyknkshrhsykn = bean.getIT_KykSyouhn().getNenkinkkn().toString();

                    nkshrkknkbn = "1";

                    kshrkknnen = bean.getIT_KykSyouhn().getNenkinkkn().toString();
                }
            }

            zennoup = BizCurrency.valueOf(0);
            zennouendym = "000000";

            if (C_Kykjyoutai.ZENNOU.eq(bean.getIT_KykSyouhn().getKykjyoutai())) {

                IT_AnsyuKihon itansyuKihon = hozenDomManager.getAnsyuKihon(bean.getIT_KhTtdkRireki().getSyono());
                itansyuKihon = IT_AnsyuKihonDetacher.detachZennoustouched(itansyuKihon);

                List<IT_Zennou> itzennouLst = itansyuKihon.getZennous();

                if (itzennouLst.size() == 0) {
                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1048,
                            IT_Zennou.TABLE_NAME,
                            bean.getIT_KhTtdkRireki().getSyono()));
                }

                SortIT_Zennou sortIT_Zennou = SWAKInjector.getInstance(SortIT_Zennou.class);
                itzennouLst = sortIT_Zennou.OrderIT_ZennouByPkDesc(itzennouLst);
                IT_Zennou itzennou = itzennouLst.get(0);

                zennoup = itzennou.getZennounyuukinkgk();

                zennouendym = itzennou.getAnnaisaikaiym().toString();

                itzennou = itzennouLst.get(itzennouLst.size() - 1);

                if (syohinHanteiKeika == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                    rsgaku = itzennou.getZennounyuukinkgk().add(itzennou.getZennoujihrkp());
                }
                else {
                    rsgaku = itzennou.getZennounyuukinkgkrstk().add(rsgaku);
                }
            }

            if (bean.getIT_KykSyouhn().getYendthnkymd() != null) {

                tksuu++;
                khosyucdList.add("60Z01  ");

                if (C_UmuKbn.ARI.eq(syouhnZokusei.getNkhknumu())) {

                    tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTNKIKOU);
                }
                else {

                    tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTSYSNIKOU);
                }

            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getKykdrtkykhukaumu())) {
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KYKDRTKYK);

            }


            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getStdrsktkyhkumu())) {
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU);

            }
            List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();

            if (itTrkKzkList.size() > 0){
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KZKTOUROKUSERVICE);
            }


            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getInitsbjiyensitihsytkhukaumu())) {
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENDTSBSAITEIHOSYOU);
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getJyudkaigomeharaitkhukaumu())) {
                tksuu++;


                if (!bean.getIT_KykSonotaTkyk().getJyudkaigomeharaitkhukaymd()
                    .equals(bean.getIT_KykSyouhn().getKykymd())) {

                    tktyuutohukahyj = "1";
                }

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_KAIGOMAEHRTKYK);
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getTargettkhkumu())) {
                tksuu++;
                String mokuhyouti = "";

                if (bean.getIT_KykSonotaTkyk().getTargettkmokuhyouti() == 0) {

                    mokuhyouti = "目標値　　０％";
                }
                else {
                    mokuhyouti = "目標額" + bean.getIT_KykSonotaTkyk().getTargettkmokuhyouti() + "％";
                }

                khosyucdList.add("60Z01  ");

                tknmList.add(mokuhyouti);
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getYennykntkhkumu())) {
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_YENKHRIKMTK);
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getGaikanykntkhkumu())) {
                tksuu++;

                khosyucdList.add("60Z01  ");

                tknmList.add(IKhozenCommonConstants.TOKUYAKUNM_TAIGRENDRYAKU_STIGITUUKAHRK);
            }


            if (khosyucdList.size() + 2 <= 6 &&
                (syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) &&
                (bean.getIT_KykSyouhn().getYendthnkymd() == null)) {

                String jygn;
                if (bean.getIT_KykSyouhn().getTmttknzoukaritujygn().compareTo(BizNumber.valueOf(0.1)) < 0) {
                    jygn = "上限 " + BizUtil.zeroNum(String.valueOf(
                        bean.getIT_KykSyouhn().getTmttknzoukaritujygn().multiply(100)), 1, 2) + "％";
                }
                else {
                    jygn = "上限" + BizUtil.zeroNum(String.valueOf(
                        bean.getIT_KykSyouhn().getTmttknzoukaritujygn().multiply(100)), 2, 2) + "％";
                }

                String bairitu = "倍率" + BizUtil.zeroNum(String.valueOf(
                    bean.getIT_KykSyouhn().getSetteibairitu()),1, 2)+ "倍";

                khosyucdList.add("60Z01  ");

                tknmList.add(bairitu);

                khosyucdList.add("60Z01  ");

                tknmList.add(jygn);
            }

            if (khosyucdList.size() + 1 <= 6 &&
                (syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                (bean.getIT_KykSyouhn().getYendthnkymd() == null)) {

                String rendouRitu_tokuyakumei = "";
                if (bean.getIT_KykSyouhn().getRendouritu().compareTo(BizNumber.valueOf(0.1)) < 0) {
                    rendouRitu_tokuyakumei = "連動  " + BizUtil.zeroNum(String.valueOf(
                        bean.getIT_KykSyouhn().getRendouritu().multiply(100)), 1, 2);
                }
                else if (bean.getIT_KykSyouhn().getRendouritu().compareTo(BizNumber.valueOf(1)) < 0) {
                    rendouRitu_tokuyakumei = "連動 " + BizUtil.zeroNum(String.valueOf(
                        bean.getIT_KykSyouhn().getRendouritu().multiply(100)), 2, 2);
                }
                else {
                    rendouRitu_tokuyakumei = "連動" + BizUtil.zeroNum(String.valueOf(
                        bean.getIT_KykSyouhn().getRendouritu().multiply(100)), 3, 2);
                }

                khosyucdList.add("60Z01  ");

                tknmList.add(rendouRitu_tokuyakumei);
            }

            while (khosyucdList.size() < 6 ) {
                khosyucdList.add("");

                tknmList.add("");
            }

            if (C_Tdk.HONNIN.eq(bean.getIT_KykSya().getKkkyktdk())) {
                hhkntdk = "01";
                kbnInfoBean = bzKbnHenkanUtil.convKbn(bean.getIT_KykSya().getKyksei().getValue(),
                    C_Kyksei.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {
                    kyksyaseikbn = kbnInfoBean.getKbnData();
                }
                else {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046,
                        IT_KykSya.KYKSEI, bean.getIT_KykSya().getKyksei().toString()));
                }
            }

            tsinkihontikucd = Strings.padEnd(bean.getIT_KykSya().getTsinyno(), 8, ' ');

            tsinkaiadr = bean.getIT_KykSya().getTsinadr1kj()
                + bean.getIT_KykSya().getTsinadr2kj()
                + bean.getIT_KykSya().getTsinadr3kj();

            if (!BizUtil.isBlank(tsinkaiadr) && tsinkaiadr.length() >= 50) {
                tsinkaiadr = tsinkaiadr.substring(0, 50);
            }

            kbnInfoBean = bzKbnHenkanUtil.convKbn(bean.getIT_HhknSya().getHhknsei().getValue(),
                C_Hhknsei.class,
                C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

            if (kbnInfoBean.isHenkanFlg()) {
                hhknseikbn = kbnInfoBean.getKbnData();
            }
            else {

                throw new CommonBizAppException(
                    MessageUtil.getMessage(MessageId.EIA1046,
                        IT_HhknSya.HHKNSEI,
                        bean.getIT_KykSya().getKyksei().getValue()));
            }

            if (C_Hrkkeiro.KOUHURI.eq(bean.getIT_KykKihon().getHrkkeiro())) {

                IT_Kouza kouza = kykKihon.getKouza();

                if (kouza == null) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1048,
                            IT_Kouza.TABLE_NAME,
                            bean.getIT_KhTtdkRireki().getSyono()));
                }

                if (C_YokinKbn.TOUZA.eq(kouza.getYokinkbn())) {

                    kzsyurui = "0";
                }
                else if (C_YokinKbn.HUTUU.eq(kouza.getYokinkbn())) {

                    kzsyurui = "1";
                }
                else {

                    kzsyurui = "";
                }

                kouzano7keta = kouza.getKouzano();

                bankcd = kouza.getBankcd();

                shitencd = kouza.getSitencd();
            }
            else {

                kzsyurui = "";

                kouzano7keta = "";

                bankcd = "0000";

                shitencd = "000";
            }

            String sbUktnmKn = "";
            String sbUktnmKj = "";
            String sbUktTdk = "99";

            if (bean.getIT_KykKihon().getSbuktnin() == 1) {

                kbnInfoBean = bzKbnHenkanUtil.convKbn(kykUktList.get(0).getUktkbn().getValue(),
                    C_UktKbn.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {
                    sbuktkbn = kbnInfoBean.getKbnData();
                }
                else {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1046,
                            IT_KykUkt.UKTKBN,
                            kykUktList.get(0).getUktkbn().getValue()));
                }

            }
            else if (bean.getIT_KykKihon().getSbuktnin() > 1) {
                sbuktkbn = "4";
            }

            for (int m = 0; m <= 3; m++) {

                if (m < kykUktList.size()) {

                    if (C_UktKbn.KYK.eq(kykUktList.get(m).getUktkbn())) {
                        sbuktnmknList.add(bean.getIT_KykSya().getKyknmkn());
                    }
                    else if (C_UktKbn.HHKN.eq(kykUktList.get(m).getUktkbn())) {
                        sbuktnmknList.add(bean.getIT_HhknSya().getHhknnmkn());
                    }
                    else {
                        sbuktnmknList.add(kykUktList.get(m).getUktnmkn());
                    }
                }
                else {
                    sbuktnmknList.add("");
                }
            }

            if (bean.getIT_KykKihon().getSbuktnin() < 5) {
                sbUktnmKn = sbuktnmknList.get(0);

                if (C_UktKbn.KYK.eq(kykUktList.get(0).getUktkbn())) {
                    if (C_KjkhukaKbn.BLNK.eq(bean.getIT_KykSya().getKyknmkjkhukakbn())) {
                        sbUktnmKj = bean.getIT_KykSya().getKyknmkj();
                    }

                    if (bean.getIT_KykKihon().getSbuktnin() == 1) {
                        sbUktTdk = "01";
                    }
                }
                else if (C_UktKbn.HHKN.eq(kykUktList.get(0).getUktkbn())) {
                    if (C_KjkhukaKbn.BLNK.eq(bean.getIT_HhknSya().getHhknnmkjkhukakbn())) {
                        sbUktnmKj = bean.getIT_HhknSya().getHhknnmkj();
                    }
                }
                else {
                    if (C_KjkhukaKbn.BLNK.eq(kykUktList.get(0).getUktnmkjkhukakbn())) {
                        sbUktnmKj = kykUktList.get(0).getUktnmkj();
                    }
                }
            }

            if (kykUktNkList.size() == 1) {
                kbnInfoBean = bzKbnHenkanUtil.convKbn(kykUktNkList.get(0).getUktkbn().getValue(),
                    C_UktKbn.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

                if (kbnInfoBean.isHenkanFlg()) {

                    mnkuktkbn = kbnInfoBean.getKbnData();
                }
                else {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1046,
                            IT_KykUkt.UKTKBN,
                            kykUktNkList.get(0).getUktkbn().getValue()));
                }

            }
            else if (kykUktNkList.size() > 1) {

                mnkuktkbn = "4";
            }

            for (int m = 0; m <= 3; m++) {

                if (m < kykUktNkList.size()) {

                    if (C_UktKbn.KYK.eq(kykUktNkList.get(m).getUktkbn())) {
                        mnkuktnmknList.add(bean.getIT_KykSya().getKyknmkn());
                    }
                    else if (C_UktKbn.HHKN.eq(kykUktNkList.get(m).getUktkbn())) {
                        mnkuktnmknList.add(bean.getIT_HhknSya().getHhknnmkn());
                    }
                    else {
                        mnkuktnmknList.add("");
                    }
                }
                else {
                    mnkuktnmknList.add("");
                }
            }


            String mdhnaisyoumeicd = bean.getIT_KykKihon().getAisyoumeikbn().getValue();
            if (bean.getIT_KykSyouhn().getTmttknitenymd() != null) {
                if (C_AisyoumeiKbn.GAIKAINDEXNK_MDHN.eq(bean.getIT_KykKihon().getAisyoumeikbn())) {

                    mdhnaisyoumeicd = C_AisyoumeiKbn.GAIKAINDEXNK_TR_MDHN.getValue();
                }
                else if (C_AisyoumeiKbn.GAIKAINDEXNK_SINKIN.eq(bean.getIT_KykKihon().getAisyoumeikbn())) {

                    mdhnaisyoumeicd = C_AisyoumeiKbn.GAIKAINDEXNK_TR_SINKIN.getValue();
                }
                else if (C_AisyoumeiKbn.GAIKAINDEXNK_20_MDHN.eq(bean.getIT_KykKihon().getAisyoumeikbn())) {

                    mdhnaisyoumeicd = C_AisyoumeiKbn.GAIKAINDEXNK_TR_20_MDHN.getValue();
                }
                else if (C_AisyoumeiKbn.GAIKAINDEXNK_20_SINKIN.eq(bean.getIT_KykKihon().getAisyoumeikbn())) {

                    mdhnaisyoumeicd = C_AisyoumeiKbn.GAIKAINDEXNK_TR_20_SINKIN.getValue();
                }
            }

            long tks1 = 0L;

            String yendthnkMaeGwhosyucd = "";

            C_Tuukasyu wkKyktuukasyu = bean.getIT_KykSyouhn().getKyktuukasyu();

            if (bean.getIT_KykSyouhn().getYendthnkymd() != null) {

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = hozenDomManager.getKykSyouhnHnkmaeBySyono(bean.getIT_KhTtdkRireki().getSyono());

                if (kykSyouhnHnkmae == null) {

                    throw new CommonBizAppException(
                        MessageUtil.getMessage(MessageId.EIA1048,
                            IT_KykSyouhnHnkmae.TABLE_NAME,
                            bean.getIT_KhTtdkRireki().getSyono()));
                }
                tks1 = Long.parseLong(kykSyouhnHnkmae.getKihons().toAdsoluteString());
                wkKyktuukasyu = kykSyouhnHnkmae.getKyktuukasyu();

                BM_SyouhnZokusei syouhnZokuseiYendthnkmae = bizDomManager.getSyouhnZokusei(
                    kykSyouhnHnkmae.getSyouhncd(), kykSyouhnHnkmae.getSyouhnsdno());

                yendthnkMaeGwhosyucd = syouhnZokuseiYendthnkmae.getGwhosyucd();
            }

            String kykhrkmtuuka = "     ";

            String keiyakusyaHurikomiKngk = "0";

            if (C_Tuukasyu.JPY.eq(rstuukasyu)) {

                kykhrkmtuuka = "     ";

                keiyakusyaHurikomiKngk = rsgaku.toAdsoluteString();
            }
            else {

                if (C_Tuukasyu.USD.eq(rstuukasyu)) {

                    kykhrkmtuuka = "00001";
                }
                else if (C_Tuukasyu.AUD.eq(rstuukasyu)) {

                    kykhrkmtuuka = "00003";
                }

                keiyakusyaHurikomiKngk = rsgaku.toValidValue().toAdsoluteString();
            }

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn())
                || C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn())) {

                ikkatubaraikbn = "2";
            }
            else{

                ikkatubaraikbn = "0";
            }

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn())) {

                ikkatubaraikaisuu = "06";
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(bean.getIT_KykKihon().getTikiktbrisyuruikbn())) {

                ikkatubaraikaisuu = "12";
            }
            else {

                ikkatubaraikaisuu = "00";
            }

            if (C_UmuKbn.ARI.eq(bean.getIT_KykSonotaTkyk().getYennykntkhkumu()) &&
                C_YennykntksyuruiKbn.PYENHRKM.eq(bean.getIT_KykSonotaTkyk().getYennyknsyuruikbn())) {

                C_UmuKbn zennouMousideumu = C_UmuKbn.NONE;
                C_IkkatubaraiKbn ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;

                if(C_Kykjyoutai.ZENNOU.eq(bean.getIT_KykSyouhn().getKykjyoutai())){
                    zennouMousideumu = C_UmuKbn.ARI;
                }
                if(C_UmuKbn.ARI.eq(iktnyuukinnumu)){
                    ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                }

                C_ErrorKbn kekkaKbn = getKawaseRate.execFstPNyuukin(
                    bean.getIT_KykKihon().getFstpnyknymd(),
                    wkKyktuukasyu,
                    C_Tuukasyu.JPY,
                    C_YouhiKbn.HUYOU,
                    hrkkaisuu,
                    C_SysKbn.SKEI,
                    zennouMousideumu,
                    ikkatubaraiKbn);

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1021,
                        getKawaseRate.getKwsrateKjYmd().toString(),
                        wkKyktuukasyu.getValue(),
                        C_Tuukasyu.JPY.getValue()));
                }

                tousyokykjiYenNyknRate = getKawaseRate.getKawaserate();

            }

            if (syohinHanteiKeika == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                rendouritu = bean.getIT_KykSyouhn().getRendouritu();
            }

            if (bean.getJV_SmbcSibouInfoRendou() != null) {

                kosyasbskttdkstartflg = "1";
                kosyahhknsbymd = bean.getJV_SmbcSibouInfoRendou().getSibouymd().toString();

                if (C_SeikyuuSyubetu.SBKRUKTK.eq(bean.getJV_SmbcSibouInfoRendou().getSeikyuusyubetu())&&
                    bean.getIT_KykSyouhn().getSyoumetuymd() == null) {
                    if (bean.getJV_SmbcSibouInfoRendou().getSyoriYmd() != null) {
                        idokaiyakuymd = bean.getJV_SmbcSibouInfoRendou().getSyoriYmd().toString();
                    }
                }

                if (C_SeikyuuSyubetu.SB.eq(bean.getJV_SmbcSibouInfoRendou().getSeikyuusyubetu())
                    && C_ShrKekkaKbn.SHR.eq(bean.getJV_SmbcSibouInfoRendou().getShrkekkakbn())) {

                    sbUktnmKn = bean.getJV_SmbcSibouInfoRendou().getSeikyuusyanmkn();

                    sbUktnmKj = bean.getJV_SmbcSibouInfoRendou().getSeikyuusyanmkj();

                    kosyasshrkanryoymd = bean.getJV_SmbcSibouInfoRendou().getShrsyoriymd().toString();

                    kosyasbukttelno = bean.getJV_SmbcSibouInfoRendou().getTsintelno().replace("-", "");

                    kosyasbuktkjadr = bean.getJV_SmbcSibouInfoRendou().getTsinadr1kj()
                        + bean.getJV_SmbcSibouInfoRendou().getTsinadr2kj()
                        + bean.getJV_SmbcSibouInfoRendou().getTsinadr3kj();
                    if (!BizUtil.isBlank(kosyasbuktkjadr) && kosyasbuktkjadr.length() >= 25) {
                        kosyasbuktkjadr = kosyasbuktkjadr.substring(0, 25);
                    }

                    if (C_UktKbn.KYK.eq(bean.getJV_SmbcSibouInfoRendou().getUktkbn()) &&
                        C_SeikyuusyaKbn.UKTHONNIN.eq(bean.getJV_SmbcSibouInfoRendou().getSeikyuusyakbn())) {
                        sbUktTdk = "01";
                    }
                    else {
                        sbUktTdk = "99";
                    }

                    if (bean.getJV_SmbcSibouInfoRendou().getSbuktnin() > 1) {
                        kosyasbukthukusuflg = "1";
                    }
                    if (bean.getJV_SmbcSibouInfoRendou().getHubikanryouymd() != null) {
                        kosyassksjyuriymd = bean.getJV_SmbcSibouInfoRendou().getHubikanryouymd().toString();
                    }
                    else {
                        kosyassksjyuriymd = bean.getJV_SmbcSibouInfoRendou().getSyoruiukeymd().toString();
                    }

                    if(bean.getJV_SmbcSibouInfoRendou().getSeikyuusyaseiymd() != null){
                        kosyasbuktseiymd = bean.getJV_SmbcSibouInfoRendou().getSeikyuusyaseiymd().toString();
                    }
                }
            }

            if (pDataSyubetu == DATASYUBETU_HOZEN) {

                if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou())) {
                    sinkeizkkbn = "1";
                }

                nidojiyu = idouJiyuHantei(
                    bean.getIT_KhTtdkRireki().getGyoumuKousinKinou(),
                    bean.getIT_KhTtdkRireki().getSyorikbn(),
                    syouhnZokusei);

                if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou()) ||
                    IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou()) ||
                    IKhozenCommonConstants.KINOUID_GENGAKU.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou()) ||
                    IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou())) {

                    IT_KhShrRireki khShrRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(bean
                        .getIT_KhTtdkRireki().getHenkousikibetukey()).getKhShrRireki();

                    if (khShrRireki != null) {
                        if (C_Tuukasyu.JPY.eq(khShrRireki.getShrtuukasyu())) {
                            idoukaiyakup = khShrRireki.getShrtuukashrgkgoukei();
                        }
                        else {
                            idoukaiyakup = khShrRireki.getShrtuukashrgkgoukei().toValidValue();
                        }
                    }
                }

                if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(bean.getIT_KhTtdkRireki().getGyoumuKousinKinou()) &&
                    C_SyoriKbn.MEIHEN_KYKSIBOU.eq(bean.getIT_KhTtdkRireki().getSyorikbn())) {
                    kyksiboumeighnkhyj = "1";
                }

                if (!BizUtil.isBlank(bean.getIT_KhTtdkRireki().getHenkousikibetukey())
                    && bean.getIT_KhTtdkRireki().getHenkousikibetukey().length() >= 17) {
                    kykmfksnctrlkh = new BigDecimal(bean.getIT_KhTtdkRireki().getHenkousikibetukey().substring(11, 18)).longValue();
                }

                if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(bean.getIT_KhTtdkRireki().getSyorikbn())) {
                    mkhtoutatuymd = bean.getIT_KykSyouhn().getYendthnkymd().getPreviousDay().toString();
                }
            }
            else{
                idoukaiyakup = BizCurrency.valueOf(0);
                if (!BizUtil.isBlank(bean.getIT_KhTtdkRireki().getHenkousikibetukey())
                    && bean.getIT_KhTtdkRireki().getHenkousikibetukey().length() >= 17) {
                    kykmfksnctrlkh = new BigDecimal(bean.getIT_KhTtdkRireki().getHenkousikibetukey().substring(11, 18))
                    .add(BigDecimal.valueOf(1)).longValue();
                }
            }

            ZT_KydGWKykInfoTy kydGWKykInfoTy = new ZT_KydGWKykInfoTy();

            kydGWKykInfoTy.setZtysyono(bean.getIT_KhTtdkRireki().getSyono());

            kydGWKykInfoTy.setZtyhknsyurui2keta(syouhnZokusei.getGwhknsyurui());

            kydGWKykInfoTy.setZtyhknsyukigou(hknsyukigou);

            kydGWKykInfoTy.setZtysinkeizkkbn(sinkeizkkbn);

            if (bean.getIT_KykSyouhn().getYendthnkymd() == null) {
                if (C_Tuukasyu.JPY.eq(bean.getIT_KykSyouhn().getKyktuukasyu())) {
                    kydGWKykInfoTy.setZtysyuhosyucd(GWHOSYUCD_BORERO_YEM);
                }
                else {
                    kydGWKykInfoTy.setZtysyuhosyucd(syouhnZokusei.getGwhosyucd());
                }
            }
            else {
                kydGWKykInfoTy.setZtysyuhosyucd(yendthnkMaeGwhosyucd);
            }

            kydGWKykInfoTy.setZtymdhnaisyoumeicd(mdhnaisyoumeicd);

            kydGWKykInfoTy.setZtysyouhncd("");

            if (bean.getIT_KykKihon().getMosymd() != null) {
                kydGWKykInfoTy.setZtymusymd(bean.getIT_KykKihon().getMosymd().toString());
            }

            if (bean.getIT_KykSyouhn().getKykymd() != null) {
                kydGWKykInfoTy.setZtykykymd(bean.getIT_KykSyouhn().getKykymd().toString());
            }

            if (bean.getIT_KykKihon().getSeirituymd() != null) {
                kydGWKykInfoTy.setZtykykseirituymd(bean.getIT_KykKihon().getSeirituymd().toString());
            }

            if (bean.getIT_KykSyouhn().getSknnkaisiymd() != null) {
                kydGWKykInfoTy.setZtysekininkaisiymd(bean.getIT_KykSyouhn().getSknnkaisiymd().toString());
            }

            if (bean.getIT_KykKihon().getFstpnyknymd() != null) {
                kydGWKykInfoTy.setZtysyokaipymd(bean.getIT_KykKihon().getFstpnyknymd().toString());
            }

            kydGWKykInfoTy.setZtyhjnkojinkbn("2");

            kydGWKykInfoTy.setZtyhrkkeirokbn(hrkkeiroKbn);

            kydGWKykInfoTy.setZtyhrkhuhukbn(hrkhouhoukbn);

            kydGWKykInfoTy.setZtyhrkymd(hrkymd);

            kydGWKykInfoTy.setZtygoukeip2(goukeip2);

            kydGWKykInfoTy.setZtyitijibrp(itijibrp);

            kydGWKykInfoTy.setZtybnkaisuu(bnkaisuu);

            kydGWKykInfoTy.setZtybnsyuruikbn(bnsyuruikbn);

            kydGWKykInfoTy.setZtybnkyk1kaip(new BigDecimal(bnkyk1kaip.toAdsoluteString()).longValue());

            kydGWKykInfoTy.setZtyyobiv20("");

            kydGWKykInfoTy.setZtysyuhknkknkbn(syuhknkknkbn);

            kydGWKykInfoTy.setZtysyuhknkkn(BizUtil.num(hknkkn, 0, 2));

            kydGWKykInfoTy.setZtysyuhrkkknkbn(syuhrkkknkbn);

            if (BizUtil.isBlank(syuhrkkkn)) {
                kydGWKykInfoTy.setZtysyuhrkkkn("  ");
            } else {

                kydGWKykInfoTy.setZtysyuhrkkkn(BizUtil.num(syuhrkkkn, 0, 2));
            }

            kydGWKykInfoTy.setZtysyus(new BigDecimal(syus.toAdsoluteString()).longValue());

            kydGWKykInfoTy.setZtysyunm("");

            kydGWKykInfoTy.setZtyidojiyukbn(nidojiyu);

            kydGWKykInfoTy.setZtysyoumetucd(syoumetucd);

            kydGWKykInfoTy.setZtyidokaiyakuymd(idokaiyakuymd);

            kydGWKykInfoTy.setZtymankiymd(hknkknmanryouymd.toString());

            kydGWKykInfoTy.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());

            if (idoukaiyakup != null) {
                kydGWKykInfoTy.setZtyidoukaiyakup(new BigDecimal(idoukaiyakup.toAdsoluteString()).longValue());
            }

            kydGWKykInfoTy.setZtysyukinkbn(syukinkbn);

            kydGWKykInfoTy.setZtyhaitoukbn(haitoukbn);

            kydGWKykInfoTy.setZtycreditcardhrkbn(creditcardhrkbn);

            kydGWKykInfoTy.setZtytkjykbn("0");

            kydGWKykInfoTy.setZtysinsakbn(sinsakbn);

            kydGWKykInfoTy.setZtyzeiseitekikakuhyj(zeiseitekikakuhyj);

            kydGWKykInfoTy.setZtylivhukauhyj("");

            kydGWKykInfoTy.setZtyhrizmentyouhyj("");

            kydGWKykInfoTy.setZtykisokyknkshrhsykn(BizUtil.num(kisokyknkshrhsykn, 0, 2));

            kydGWKykInfoTy.setZtynkshrkknkbn(nkshrkknkbn);

            kydGWKykInfoTy.setZtynkshrkknnen(BizUtil.num(kshrkknnen, 0, 3));

            kydGWKykInfoTy.setZtynksueokikn(BizUtil.num(nksueokikn.toString(), 0, 2));

            kydGWKykInfoTy.setZtynkshrstartymd(nkshrstartymd);

            kydGWKykInfoTy.setZtynkuketorininkbn(uktkbn);

            kydGWKykInfoTy.setZtyzennoup(new BigDecimal(zennoup.toAdsoluteString()).longValue());

            kydGWKykInfoTy.setZtyzennouendym(zennouendym);

            kydGWKykInfoTy.setZtyteikaiyakuhrkn("");

            kydGWKykInfoTy.setZtymosno(bean.getIT_KykKihon().getSkjmosno());

            kydGWKykInfoTy.setZtytratkisyacd1(bean.getIT_KykDairiten().getBosyuucd());

            kydGWKykInfoTy.setZtytratkisyacd2(tratkisyacd2);

            kydGWKykInfoTy.setZtydairiten1cd(bean.getIT_KykDairiten().getDrtencd());

            kydGWKykInfoTy.setZtydairiten2cd(dairitencd2);

            kydGWKykInfoTy.setZtybsudirtnatkikeitaikbn(bosyuudairitenatkikeitaikbn);

            kydGWKykInfoTy.setZtybsyudiritnatkiwari1(new BigDecimal(bean.getIT_KykDairiten().getBunwari()
                .toString()).longValue());

            kydGWKykInfoTy.setZtybsyudiritnatkiwari2(bsyudiritnatkiwari2);

            kydGWKykInfoTy.setZtyyobiv20x2("");

            kydGWKykInfoTy.setZtytktyuutohukahyj(tktyuutohukahyj);

            kydGWKykInfoTy.setZtytksuu(BizUtil.num(String.valueOf(tksuu), 0, 3));

            kydGWKykInfoTy.setZtytkhosyucd1(khosyucdList.get(0));

            kydGWKykInfoTy.setZtytknm1(tknmList.get(0));

            kydGWKykInfoTy.setZtytks1(tks1);

            kydGWKykInfoTy.setZtytkhknkknkbn1("");

            kydGWKykInfoTy.setZtytkhknkkn1("");

            kydGWKykInfoTy.setZtytkhrkkknkbn1("");

            kydGWKykInfoTy.setZtytkhrkkkn1("");

            kydGWKykInfoTy.setZtytkhosyucd2(khosyucdList.get(1));

            kydGWKykInfoTy.setZtytknm2(tknmList.get(1));

            kydGWKykInfoTy.setZtytks2(0L);

            kydGWKykInfoTy.setZtytkhknkknkbn2("");

            kydGWKykInfoTy.setZtytkhknkkn2("");

            kydGWKykInfoTy.setZtytkhrkkknkbn2("");

            kydGWKykInfoTy.setZtytkhrkkkn2("");

            kydGWKykInfoTy.setZtytkhosyucd3(khosyucdList.get(2));

            kydGWKykInfoTy.setZtytknm3(tknmList.get(2));

            kydGWKykInfoTy.setZtytks3(0L);

            kydGWKykInfoTy.setZtytkhknkknkbn3("");

            kydGWKykInfoTy.setZtytkhknkkn3("");

            kydGWKykInfoTy.setZtytkhrkkknkbn3("");

            kydGWKykInfoTy.setZtytkhrkkkn3("");

            kydGWKykInfoTy.setZtytkhosyucd4(khosyucdList.get(3));

            kydGWKykInfoTy.setZtytknm4(tknmList.get(3));

            kydGWKykInfoTy.setZtytks4(0L);

            kydGWKykInfoTy.setZtytkhknkknkbn4("");

            kydGWKykInfoTy.setZtytkhknkkn4("");

            kydGWKykInfoTy.setZtytkhrkkknkbn4("");

            kydGWKykInfoTy.setZtytkhrkkkn4("");

            kydGWKykInfoTy.setZtytkhosyucd5(khosyucdList.get(4));

            kydGWKykInfoTy.setZtytknm5(tknmList.get(4));

            kydGWKykInfoTy.setZtytks5(0L);

            kydGWKykInfoTy.setZtytkhknkknkbn5("");

            kydGWKykInfoTy.setZtytkhknkkn5("");

            kydGWKykInfoTy.setZtytkhrkkknkbn5("");

            kydGWKykInfoTy.setZtytkhrkkkn5("");

            kydGWKykInfoTy.setZtytkhosyucd6(khosyucdList.get(5));

            kydGWKykInfoTy.setZtytknm6(tknmList.get(5));

            kydGWKykInfoTy.setZtytks6(0L);

            kydGWKykInfoTy.setZtytkhknkknkbn6("");

            kydGWKykInfoTy.setZtytkhknkkn6("");

            kydGWKykInfoTy.setZtytkhrkkknkbn6("");

            kydGWKykInfoTy.setZtytkhrkkkn6("");

            kydGWKykInfoTy.setZtysbuktnm(sbUktnmKn);

            kydGWKykInfoTy.setZtykjsbuktnm(sbUktnmKj);

            kydGWKykInfoTy.setZtysbukttdk(sbUktTdk);

            kydGWKykInfoTy.setZtysbuktnin(BizUtil.num(bean.getIT_KykKihon().getSbuktnin().toString(), 0, 2));

            kydGWKykInfoTy.setZtyyobiv28("");

            kydGWKykInfoTy.setZtyyno7keta(bean.getIT_KykSya().getTsinyno());

            kydGWKykInfoTy.setZtytelnokydgw(bean.getIT_KykSya().getTsintelno());

            kydGWKykInfoTy.setZtykyknmknkydgw(bean.getIT_KykSya().getKyknmkn());

            if (bean.getIT_KykSya().getKykseiymd() != null) {
                kydGWKykInfoTy.setZtykyksyaseiymd(bean.getIT_KykSya().getKykseiymd().toString());
            }

            kydGWKykInfoTy.setZtykyksyaseikbn(kyksyaseikbn);

            kydGWKykInfoTy.setZtytsinkihontikucd(tsinkihontikucd);

            kydGWKykInfoTy.setZtykykadrkj50(tsinkaiadr);

            kydGWKykInfoTy.setZtykyknmkjkydgw(bean.getIT_KykSya().getKyknmkj());

            kydGWKykInfoTy.setZtyhhknmei(bean.getIT_HhknSya().getHhknnmkn());

            kydGWKykInfoTy.setZtyhhknnmkj(bean.getIT_HhknSya().getHhknnmkj());

            if (bean.getIT_HhknSya().getHhknseiymd() != null) {
                kydGWKykInfoTy.setZtyhhknseiymd(bean.getIT_HhknSya().getHhknseiymd().toString());
            }

            if (bean.getIT_HhknSya().getHhknseiymd() != null) {
                kydGWKykInfoTy.setZtyhhknnen(BizUtil.num(bean.getIT_KykSyouhn().getHhknnen().toString(), 0, 3));
            }

            kydGWKykInfoTy.setZtyhhknseikbn(hhknseikbn);

            kydGWKykInfoTy.setZtyhhkntdk(hhkntdk);

            kydGWKykInfoTy.setZtykzsyurui(kzsyurui);

            kydGWKykInfoTy.setZtykouzano7keta(kouzano7keta);

            kydGWKykInfoTy.setZtykzhurikaebankcd(bankcd);

            kydGWKykInfoTy.setZtykzhurikaesitencd(shitencd);

            kydGWKykInfoTy.setZtykanyuusyaknrno(bean.getIT_KykKihon().getCifcd());

            kydGWKykInfoTy.setZtykyksiboumeighnkhyj(kyksiboumeighnkhyj);

            kydGWKykInfoTy.setZtyyobiv11("");

            kydGWKykInfoTy.setZtymnkuktkbn(mnkuktkbn);

            kydGWKykInfoTy.setZtymnkuktnm1(mnkuktnmknList.get(0));

            kydGWKykInfoTy.setZtymnkuktnm2(mnkuktnmknList.get(1));

            kydGWKykInfoTy.setZtymnkuktnm3(mnkuktnmknList.get(2));

            kydGWKykInfoTy.setZtymnkuktnm4(mnkuktnmknList.get(3));

            kydGWKykInfoTy.setZtysbuktkbn(sbuktkbn);

            kydGWKykInfoTy.setZtysbuktnm1(sbuktnmknList.get(0));

            kydGWKykInfoTy.setZtysbuktnm2(sbuktnmknList.get(1));

            kydGWKykInfoTy.setZtysbuktnm3(sbuktnmknList.get(2));

            kydGWKykInfoTy.setZtysbuktnm4(sbuktnmknList.get(3));

            kydGWKykInfoTy.setZtyyobiv20x3("");

            kydGWKykInfoTy.setZtysyoriymd(syoriYmd.toString());

            kydGWKykInfoTy.setZtykykmfksnctrlkh(kykmfksnctrlkh);

            kydGWKykInfoTy.setZtymkhtoutatuymd(mkhtoutatuymd);

            kydGWKykInfoTy.setZtykykhrkmtuuka(kykhrkmtuuka);

            kydGWKykInfoTy.setZtykykhrkmgk(new BigDecimal(keiyakusyaHurikomiKngk).longValue());

            kydGWKykInfoTy.setZtyikkatubaraikbn(ikkatubaraikbn);

            kydGWKykInfoTy.setZtyikkatubaraikaisuu(ikkatubaraikaisuu);

            kydGWKykInfoTy.setZtytousyokykjiyennyknrate(tousyokykjiYenNyknRate);

            kydGWKykInfoTy.setZtyrendouritu(rendouritu);

            kydGWKykInfoTy.setZtyteikishrritu(BizNumber.valueOf(0));

            kydGWKykInfoTy.setZtykosyasbskttdkstartflg(kosyasbskttdkstartflg);

            kydGWKykInfoTy.setZtykosyasbukthukusuflg(kosyasbukthukusuflg);

            kydGWKykInfoTy.setZtykosyahhknsbymd(kosyahhknsbymd);

            kydGWKykInfoTy.setZtykosyassksjyuriymd(kosyassksjyuriymd);

            kydGWKykInfoTy.setZtykosyasshrkanryoymd(kosyasshrkanryoymd);

            kydGWKykInfoTy.setZtykosyasbuktseiymd(kosyasbuktseiymd);

            kydGWKykInfoTy.setZtykosyasbuktkjadr(kosyasbuktkjadr);

            kydGWKykInfoTy.setZtykosyasbukttelno(kosyasbukttelno);

            kydGWKykInfoTy.setZtyyobiv252("");

            BizPropertyInitializer.initialize(kydGWKykInfoTy);

            pInserter.add(kydGWKykInfoTy);

            syonoMae = bean.getIT_KhTtdkRireki().getSyono();

            khosyucdList = new ArrayList<>();

            tknmList = new ArrayList<>();

            sbuktnmknList = new ArrayList<>();

            mnkuktnmknList = new ArrayList<>();

            kensuCount++;
        }
        return kensuCount;
    }

    private boolean tysytTaisyouIdouHantei(String pKinouId, C_SyoriKbn pSyoriKbn, C_Syoumetujiyuu pSyoumetujiyuu) {

        boolean hanteiKekka = true;

        if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pKinouId)
            && !C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(pSyoriKbn)
            && !C_SyoriKbn.ZEISEITEKIKAKUHUKA.eq(pSyoriKbn)
            && !C_SyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(pSyoriKbn)
            && !C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(pSyoriKbn)) {

            hanteiKekka = false;
        }

        if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pKinouId)
            && !C_SyoriKbn.TMTTKNHANEI_ITEN.eq(pSyoriKbn)) {

            hanteiKekka = false;
        }

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pKinouId)
            && !C_Syoumetujiyuu.KAIYAKU.eq(pSyoumetujiyuu)) {

            hanteiKekka = false;
        }

        return hanteiKekka;
    }

    private String syoumetucdHantei(C_Syoumetujiyuu pSyoumetujiyuu) {

        String syoumetucd = "";

        if (C_Syoumetujiyuu.KYKTORIKESI.eq(pSyoumetujiyuu)
            || C_Syoumetujiyuu.CLGOFF.eq(pSyoumetujiyuu)
            || C_Syoumetujiyuu.MUKOU.eq(pSyoumetujiyuu)) {
            syoumetucd = "0350";
        }
        else if (C_Syoumetujiyuu.KAIJO.eq(pSyoumetujiyuu)) {
            syoumetucd = "0351";
        }
        else if (C_Syoumetujiyuu.SIBOU.eq(pSyoumetujiyuu)) {
            syoumetucd = "3090";
        }
        else if (C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(pSyoumetujiyuu)) {
            syoumetucd = "3091";
        }
        else if (C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(pSyoumetujiyuu)) {
            syoumetucd = "3092";
        }
        else if (C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(pSyoumetujiyuu)) {
            syoumetucd = "3093";
        }
        else if (C_Syoumetujiyuu.KOUDOSYOUGAI.eq(pSyoumetujiyuu)) {
            syoumetucd = "3120";
        }
        else if (C_Syoumetujiyuu.SBKAIJO.eq(pSyoumetujiyuu)) {
            syoumetucd = "3250";
        }
        else if (C_Syoumetujiyuu.MENSEKI.eq(pSyoumetujiyuu)) {
            syoumetucd = "3251";
        }
        else if (C_Syoumetujiyuu.SBMUKOU.eq(pSyoumetujiyuu)) {
            syoumetucd = "3252";
        }
        else if (C_Syoumetujiyuu.KAIYAKU.eq(pSyoumetujiyuu)) {
            syoumetucd = "5010";
        }
        else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(pSyoumetujiyuu)
            || C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(pSyoumetujiyuu)) {
            syoumetucd = "6020";
        }
        else if (C_Syoumetujiyuu.JIKOU.eq(pSyoumetujiyuu)) {
            syoumetucd = "0100";
        }
        return syoumetucd;
    }

    private String idouJiyuHantei(String pKinouId, C_SyoriKbn pSyoriKbn, BM_SyouhnZokusei pSyouhnZokusei) {

        String nidojiyu = "99";

        if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pKinouId) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pKinouId)) {
            nidojiyu = "21";
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pKinouId)) {
            nidojiyu = "01";
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(pKinouId)) {
            if (C_SyoriKbn.CLGOFF.eq(pSyoriKbn)) {
                nidojiyu = "22";
            }
            else if (C_SyoriKbn.KYKTORIKESI.eq(pSyoriKbn) || C_SyoriKbn.KAIJO.eq(pSyoriKbn)) {
                nidojiyu = "24";
            }
            else if (C_SyoriKbn.SBKAIJO.eq(pSyoriKbn)
                || C_SyoriKbn.SBMENSEKI.eq(pSyoriKbn)
                || C_SyoriKbn.SBMENSEKI_SHRNASI.eq(pSyoriKbn)
                || C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pSyoriKbn)
                || C_SyoriKbn.SBMUKOU_SHRNASI.eq(pSyoriKbn)) {
                nidojiyu = "25";
            }
        }
        else if (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(pKinouId)) {
            if (C_SyoriKbn.SIBOU.eq(pSyoriKbn)
                || C_SyoriKbn.SBKYUUHUSHR.eq(pSyoriKbn)
                || C_SyoriKbn.SBMUKOU.eq(pSyoriKbn)
                || C_SyoriKbn.SBKAIJO.eq(pSyoriKbn)
                || C_SyoriKbn.MENSEKI.eq(pSyoriKbn)) {
                nidojiyu = "25";
            }
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pKinouId)) {
            nidojiyu = "31";
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKinouId)) {
            nidojiyu = "23";
        }
        else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(pKinouId)) {
            if (C_UmuKbn.ARI.eq(pSyouhnZokusei.getNkhknumu())) {
                nidojiyu = "11";
            }
        }

        return nidojiyu;
    }
}
