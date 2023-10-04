package yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit.dba.DrtenMinyuKykTaisyoBean;
import yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit.dba.KhDrtenMinyuuKykDtlEditDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.interf.ConvBossRnkKoumoku;
import yuyu.common.biz.interf.ConvBossRnkKoumokuBean;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;


/**
 * 契約保全 案内収納 代理店未入明細共通編集処理
 */
public class KhDrtenMinyuuKykDtlEditBatch implements Batch{

    private static final String TABLEID = IT_DrtenMinyuKykTaisyo.TABLE_NAME;

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhDrtenMinyuuKykDtlEditDao khDrtenMinyuuKykDtlEditDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @SuppressWarnings("null")
    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            bzBatchParam.getSyoriYmd().toString()));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        Long syoriKensuu = 0L;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouid = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        try (ExDBResults<DrtenMinyuKykTaisyoBean> drtenMinyuKykTaisyoBean =
            khDrtenMinyuuKykDtlEditDao.getDrtenMinyuKykTaisyos(bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());
            EntityInserter<IT_DrtenMinyuKykNaiyou> entityInserter = new EntityInserter<>();) {

            for (DrtenMinyuKykTaisyoBean dataBean : drtenMinyuKykTaisyoBean) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(dataBean.getSyono());

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(dataBean.getSyono());
                IT_KykSyouhn kykSyouhn = null;
                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                if (kykSyouhnLst.size() > 0) {

                    kykSyouhn = kykSyouhnLst.get(0);
                }

                BM_SyouhnZokusei syouhnZokusei =
                    bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

                BizDateYM syoriYm = null;

                if(C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())){

                    if (dataBean.getRyousyuuymd().getDay() < 27) {

                        syoriYm = dataBean.getRyousyuuymd().getBizDateYM();
                    }

                    else {

                        syoriYm = dataBean.getRyousyuuymd().getBizDateYM().addMonths(1);
                    }
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                    syoriYm = dataBean.getRyousyuuymd().getBizDateYM().addMonths(1);
                }

                else {

                }

                int minyuKaisuu = 0;
                String syuukeiKbn = "";

                if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    minyuKaisuu= (dataBean.getJkipjytym().getYear() - kykSyouhn.getKykymd().getYear()) + 1;

                    if (minyuKaisuu <= 2) {

                        syuukeiKbn = "1";
                    }
                    else if (minyuKaisuu == 3) {

                        syuukeiKbn = "2";
                    }
                    else {

                        syuukeiKbn = "3";
                    }
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    int getuSuu = BizDateUtil.calcDifferenceMonths(dataBean.getJkipjytym(), kykSyouhn.getKykymd().getBizDateYM()) + 6 ;

                    minyuKaisuu =  getuSuu / 6;

                    if (getuSuu % 6 > 0) {
                        minyuKaisuu++;
                    }

                    if (minyuKaisuu <= 3) {

                        syuukeiKbn = "1";
                    }
                    else if (minyuKaisuu <= 5) {

                        syuukeiKbn = "2";
                    }
                    else {

                        syuukeiKbn = "3";
                    }
                }
                else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    minyuKaisuu= BizDateUtil.calcDifferenceMonths(dataBean.getJkipjytym(), kykSyouhn.getKykymd().getBizDateYM()) + 1;

                    if (minyuKaisuu <= 13) {

                        syuukeiKbn = "1";
                    }
                    else if (minyuKaisuu <= 25) {

                        syuukeiKbn = "2";
                    }
                    else {

                        syuukeiKbn = "3";
                    }
                }

                ConvBossRnkKoumoku convBossRnkKoumoku = SWAKInjector.getInstance(ConvBossRnkKoumoku.class);
                ConvBossRnkKoumokuBean convBossRnkKoumokuBean =
                    convBossRnkKoumoku.execAll(syouhnZokusei, kykKihon.getHrkkeiro(), kykSyouhn.getKyktuukasyu());

                BizDate nexthurikaeYmd = null;

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
                    setHurikaebi.exec(dataBean.getSyoriYmd());

                    nexthurikaeYmd = setHurikaebi.getTyokugoHurikaebi();
                }
                else if (C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())) {

                    SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);
                    setCreditUriageSeikyuubi.exec(dataBean.getSyoriYmd());

                    nexthurikaeYmd = setCreditUriageSeikyuubi.getJikaiUrskbi();
                }

                BizCurrency hrkp = null;
                int jyuutounensuu = 0;
                int jyuutoutukisuu =0;

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.BLNK.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.NONE.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutoutukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        jyuutoutukisuu =  Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue());
                    }
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {

                    jyuutoutukisuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    jyuutounensuu = 1;
                }

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                C_ErrorKbn errorKbn = keisanRsgaku.exec(
                    kykKihon,
                    dataBean.getNykkeiro(),
                    dataBean.getNyknaiyouKbn(),
                    nexthurikaeYmd,
                    dataBean.getJkipjytym(),
                    jyuutounensuu,
                    jyuutoutukisuu);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException("領収金額計算エラー");
                }

                KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();
                hrkp = keisanRsgkOutBean.getRsgakuGoukei();

                BizCurrency misyuuP = BizCurrency.valueOf(0);

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        misyuuP = dataBean.getRsgakuYen();

                    }
                    else {

                        List<IT_AnsyuRireki> ansyuRirek = new ArrayList<IT_AnsyuRireki>();

                        if(C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())){

                            ansyuRirek = khDrtenMinyuuKykDtlEditDao.getAnsyuRirekis(
                                dataBean.getSyono(),
                                dataBean.getNyknaiyouKbn(),
                                dataBean.getNykkeiro(),
                                dataBean.getRyousyuuymd());
                        }
                        else if(C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())){
                            ansyuRirek = khDrtenMinyuuKykDtlEditDao.getAnsyuRirekis2(
                                dataBean.getSyono(),
                                dataBean.getNyknaiyouKbn(),
                                dataBean.getNykkeiro(),
                                dataBean.getRyousyuuymd());
                        }
                        else {

                        }

                    	
                        if(ansyuRirek.size() > 0 ){

                            misyuuP = BizCurrency.valueOf(0, ansyuRirek.get(0).getRsgaku().getType());
                        }

                        for (int i = 0 ; i <= ansyuRirek.size() - 1 ; i++) {

                            misyuuP = misyuuP.add(ansyuRirek.get(i).getRsgaku());
                        }
                    }
                }
                else {

                    misyuuP = dataBean.getRsgakuYen();
                }

                BzGetAgInfoBean bzGetAgInfoBean1 = SWAKInjector.getInstance(BzGetAgInfoBean.class);
                BzGetAgInfoBean bzGetAgInfoBean2 = SWAKInjector.getInstance(BzGetAgInfoBean.class);
                C_BosyuuDairitenAtkiKeitaiKbn bosyuuDairitenAtkiKeitaiKbn = C_BosyuuDairitenAtkiKeitaiKbn.TANDOKU;
                String kydatkiKbn = "";
                String bosyuuCd1 = "";
                String bosyuuCd2 = "";

                List<IT_KykDairiten> kykDairitenList = kykKihon.getKykDairitens();

                for (int j = 0 ; j <= kykDairitenList.size() - 1 ; j++) {

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(kykDairitenList.get(j).getDrtencd());

                    for (int k = 0 ; k <= bzGetAgInfoBeanLst.size() - 1 ; k++) {

                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBeanLst.get(k).getDiritenJyouhouKbn())) {

                            if (j == 0) {

                                bzGetAgInfoBean1 = bzGetAgInfoBeanLst.get(k);
                            }
                            else {

                                bzGetAgInfoBean2 = bzGetAgInfoBeanLst.get(k);
                                bosyuuDairitenAtkiKeitaiKbn = C_BosyuuDairitenAtkiKeitaiKbn.DAIRITENKYOUDOU;
                            }

                            break;
                        }
                    }

                    if (j == 0) {

                        bosyuuCd1 = kykDairitenList.get(j).getBosyuucd();
                    }
                    else {

                        bosyuuCd2 = kykDairitenList.get(j).getBosyuucd();
                    }
                }

                if (C_BosyuuDairitenAtkiKeitaiKbn.DAIRITENKYOUDOU.eq(bosyuuDairitenAtkiKeitaiKbn)) {

                    if (bzGetAgInfoBean1.getOyadrtenCd().equals(bzGetAgInfoBean2.getOyadrtenCd())) {

                        kydatkiKbn = "２";
                    }
                    else {

                        kydatkiKbn = "３";
                    }
                }

                C_IkkatubaraiKbn ikkatubaraiKbn = null;
                C_IkkatubaraiKaisuuKbn ikkatubaraiKaisuuKbn = null;

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                    C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())){

                    ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                    ikkatubaraiKaisuuKbn = C_IkkatubaraiKaisuuKbn.IKKATU6;
                }
                else if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu()) &&
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                    ikkatubaraiKbn = C_IkkatubaraiKbn.TEIKIIKKATU;
                    ikkatubaraiKaisuuKbn = C_IkkatubaraiKaisuuKbn.IKKATU12;
                }
                else {

                    ikkatubaraiKbn = C_IkkatubaraiKbn.BLNK;
                    ikkatubaraiKaisuuKbn = C_IkkatubaraiKaisuuKbn.BLNK;
                }

                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);

                setYuuyokknmanryobi.exec(kykKihon.getSyono(), dataBean.getJkipjytym());
                BizDate tksnYuuyokknMnryBi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();
                IT_KykSya kykSya = kykKihon.getKykSya();

                IT_HhknSya hhknSya = kykKihon.getHhknSya();

                String bankcd = "";
                String sitencd = "";
                C_YokinKbn yokinkbn = null;
                String kouzano = "";
                String kzmeiginmkn ="";
                IT_Kouza Kouza = SWAKInjector.getInstance(IT_Kouza.class);

                if(C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())){

                    Kouza = kykKihon.getKouza();
                    bankcd = Kouza.getBankcd();
                    sitencd = Kouza.getSitencd();
                    yokinkbn = Kouza.getYokinkbn();
                    kouzano = Kouza.getKouzano();
                    kzmeiginmkn = Kouza.getKzmeiginmkn();
                }
                else if(C_Hrkkeiro.CREDIT.eq(kykKihon.getHrkkeiro())){

                    bankcd = "";
                    sitencd = "";
                    yokinkbn = C_YokinKbn.BLNK;
                    kouzano = "";
                    kzmeiginmkn ="";
                }
                else {

                }

                IT_DrtenMinyuKykNaiyou drtenMinyuKykNaiyou = new IT_DrtenMinyuKykNaiyou();

                drtenMinyuKykNaiyou.setKbnkey(dataBean.getKbnkey());
                drtenMinyuKykNaiyou.setSyono(dataBean.getSyono());
                drtenMinyuKykNaiyou.setSyoriym(syoriYm);
                drtenMinyuKykNaiyou.setKeiyakuymd(kykSyouhn.getKykymd());
                drtenMinyuKykNaiyou.setBosyuuym(kykKihon.getBosyuuym());
                drtenMinyuKykNaiyou.setHrkkaisuu(kykKihon.getHrkkaisuu());
                drtenMinyuKykNaiyou.setHrkkeiro(kykKihon.getHrkkeiro());
                drtenMinyuKykNaiyou.setSyuukeikbn(syuukeiKbn);
                drtenMinyuKykNaiyou.setMinyukaisuu(minyuKaisuu);
                drtenMinyuKykNaiyou.setHrkp(hrkp);
                drtenMinyuKykNaiyou.setHukkatutyuuikbn("1");
                drtenMinyuKykNaiyou.setHknsyukigou(kykSyouhn.getSyouhncd().substring(0, 2));
                drtenMinyuKykNaiyou.setJkipjytym(dataBean.getJkipjytym());
                drtenMinyuKykNaiyou.setHurihunokbn(dataBean.getHurihunoKbn());
                drtenMinyuKykNaiyou.setBosyuudairitenatkikeitaikbn(bosyuuDairitenAtkiKeitaiKbn);
                drtenMinyuKykNaiyou.setDairitencd1(bzGetAgInfoBean1.getDrtenCd());
                drtenMinyuKykNaiyou.setDairitencd2(bzGetAgInfoBean2.getDrtenCd());
                drtenMinyuKykNaiyou.setDrtenkanrisosikicd1(bzGetAgInfoBean1.getDrtKanrisosikiCd1());
                drtenMinyuKykNaiyou.setDrtenkanrisosikicd2(bzGetAgInfoBean2.getDrtKanrisosikiCd1());
                drtenMinyuKykNaiyou.setDrtenchannelsyuruikbn1(bzGetAgInfoBean1.getDrtenChannelSyurui());
                drtenMinyuKykNaiyou.setDrtenchannelsyuruikbn2(bzGetAgInfoBean2.getDrtenChannelSyurui());
                drtenMinyuKykNaiyou.setBosyuucd1(bosyuuCd1);
                drtenMinyuKykNaiyou.setBosyuucd2(bosyuuCd2);
                drtenMinyuKykNaiyou.setKydatkikbnkj(kydatkiKbn);
                drtenMinyuKykNaiyou.setIkkatubaraikbn(ikkatubaraiKbn);
                drtenMinyuKykNaiyou.setIkkatubaraikaisuu(ikkatubaraiKaisuuKbn);
                drtenMinyuKykNaiyou.setCifcd(kykKihon.getCifcd());
                drtenMinyuKykNaiyou.setYykknmnryymd(tksnYuuyokknMnryBi);

                drtenMinyuKykNaiyou.setSyouhinbunruikbn(convBossRnkKoumokuBean.getSyouhinBunruiKbn());

                drtenMinyuKykNaiyou.setSyouhnnmkbn(convBossRnkKoumokuBean.getSyouhnNmKbn());

                if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {

                    drtenMinyuKykNaiyou.setKyknm35keta(kykSya.getKyknmkn());
                }
                else {

                    drtenMinyuKykNaiyou.setKyknm35keta(kykSya.getKyknmkj());
                }

                drtenMinyuKykNaiyou.setTsinkihontikucd(kykSya.getTsinyno());
                String tsinadr = kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj() + kykSya.getTsinadr3kj();
                if (tsinadr.length() > 62) {
                    tsinadr = tsinadr.substring(0, 62);
                }
                drtenMinyuKykNaiyou.setKanjitsinkaiadr(tsinadr);

                drtenMinyuKykNaiyou.setTsintelno(kykSya.getTsintelno());
                drtenMinyuKykNaiyou.setDai2tsintelno(kykSya.getDai2tsintelno());
                drtenMinyuKykNaiyou.setHhknnmkj(hhknSya.getHhknnmkj());
                drtenMinyuKykNaiyou.setNexthurikaeymd(nexthurikaeYmd);
                drtenMinyuKykNaiyou.setMinyusyoriymd(dataBean.getSyoriYmd());
                drtenMinyuKykNaiyou.setJyuutouym(dataBean.getJyuutouym());
                drtenMinyuKykNaiyou.setBankcd(bankcd);
                drtenMinyuKykNaiyou.setSitencd(sitencd);
                drtenMinyuKykNaiyou.setYokinkbn(yokinkbn);
                drtenMinyuKykNaiyou.setKouzano(kouzano);
                drtenMinyuKykNaiyou.setKzmeiginmkn(kzmeiginmkn);
                drtenMinyuKykNaiyou.setTikiktbrisyuruikbn(dataBean.getTikiktbrisyuruikbn());
                drtenMinyuKykNaiyou.setJkiannaikg(dataBean.getJkiannaikg());
                drtenMinyuKykNaiyou.setMisyuup(misyuuP);
                drtenMinyuKykNaiyou.setGyoumuKousinKinou(kinouid);
                drtenMinyuKykNaiyou.setGyoumuKousinsyaId(userId);
                drtenMinyuKykNaiyou.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(drtenMinyuKykNaiyou);

                entityInserter.add(drtenMinyuKykNaiyou);

                kykKihon.detach();

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }


        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
