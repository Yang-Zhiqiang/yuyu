package yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks;

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
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks.dba.KhSeihowebMizuhoMinyuuDtlSksBean;
import yuyu.batch.hozen.khansyuu.khseihowebmizuhominyuudtlsks.dba.KhSeihowebMizuhoMinyuuDtlSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_DrtenMinyuKykNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 生保Ｗｅｂ・みずほ用未入明細作成のバッチクラスです。
 */
public class KhSeihowebMizuhoMinyuuDtlSksBatch implements Batch {

    private static final String TABLEID = IT_DrtenMinyuKykNaiyou.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSeihowebMizuhoMinyuuDtlSksDao khSeihowebMizuhoMinyuuDtlSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

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

        BizDate syoribiYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoribiYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        Long count = 0L;
        BizDateYM syoribiYm = syoribiYmd.getBizDateYM();

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

        BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String gyoumuKousinKinou = khozenCommonParam.getFunctionId();

        String gyoumuKousinsyaId = khozenCommonParam.getUserID();

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN);

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(tantouCd.getBusitucd() + "0000");

        String hasshinKa = ("　　　　　　　　　　" + YuyuBizConfig.getInstance().getHokenKaisyaNmKanji() + "　"
            + null2blank(bzGetSosikiDataBean.getKanjisosikinm20()));

        hasshinKa = editString(hasshinKa, 31);

        BizDate maeSyoribiYmd = syoribiYmd.getPreviousMonth();

        setHurikaebi.exec(maeSyoribiYmd);

        BizDate tykgoHurikaeYmd = setHurikaebi.getTyokugoHurikaebi();

        String ztyminyuujyutuymdyofuri = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(tykgoHurikaeYmd)
            + "振替結果";

        String ztyminyuujyutuymdyofuriigi = FixedDateFormatter.formatYMZenkakuSeirekiKanji(maeSyoribiYmd)
            + "未入";

        try (ExDBResults<KhSeihowebMizuhoMinyuuDtlSksBean> khSeihowebMizuhoMinyuuDtlSksBeanList =
            khSeihowebMizuhoMinyuuDtlSksDao.getKhSeihowebMizuhoMinyuuDtlSksBeans(kakutyouJobCd, syoribiYm);

            EntityInserter<IT_SeihowebMizuhoMinyuuDtl> entityInserter = new EntityInserter<>();) {

            for (KhSeihowebMizuhoMinyuuDtlSksBean khSeihowebMizuhoMinyuuDtlSksBean : khSeihowebMizuhoMinyuuDtlSksBeanList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khSeihowebMizuhoMinyuuDtlSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khSeihowebMizuhoMinyuuDtlSksBean.getSyono());

                count = count + 1;

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(khSeihowebMizuhoMinyuuDtlSksBean.getSyono());

                List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                IT_KykSyouhn kykSyouhn = null;
                if (kykSyouhnList.size() > 0) {
                    kykSyouhn = kykSyouhnList.get(0);
                }

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getSyouhnsdno());

                String hHrkkaisuuKanji = "";

                if (C_Hrkkaisuu.NEN.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkaisuu())) {
                    hHrkkaisuuKanji = "年１回";
                }
                else if (C_Hrkkaisuu.HALFY.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkaisuu())) {
                    hHrkkaisuuKanji = "年２回";
                }
                else if (C_Hrkkaisuu.TUKI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkaisuu())) {
                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(khSeihowebMizuhoMinyuuDtlSksBean.getTikiktbrisyuruikbn())) {
                        hHrkkaisuuKanji = "月６　";
                    }
                    else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(khSeihowebMizuhoMinyuuDtlSksBean
                        .getTikiktbrisyuruikbn())) {
                        hHrkkaisuuKanji = "月１２";
                    }
                    else {
                        hHrkkaisuuKanji = "月払　";
                    }
                }

                String hrkkeiroKanji = "";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    hrkkeiroKanji = "預振　";
                }
                else if (C_Hrkkeiro.CREDIT.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    hrkkeiroKanji = "クレカ";
                }

                String knkimnyuuryu = "";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    if (C_HurihunoKbn.SIKINHUSOKU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        knkimnyuuryu = "預金不足　";
                    }
                    else if (C_HurihunoKbn.YKNSYATUGOU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        knkimnyuuryu = "預金者都合";
                    }
                    else if (C_HurihunoKbn.NOKOUHURIIRAI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        knkimnyuuryu = "依頼書なし";
                    }
                    else if (C_HurihunoKbn.ITKTUGOU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        knkimnyuuryu = "委託者都合";
                    }
                    else {
                        knkimnyuuryu = "　その他　";
                    }
                }
                else {
                    knkimnyuuryu = "　その他　";
                }

                String hrkkeirobtjhmidasi = "";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    hrkkeirobtjhmidasi = "預振口座　";
                }
                else if (C_Hrkkeiro.CREDIT.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    hrkkeirobtjhmidasi = "クレジット";
                }

                String hrkkeirobtjh = "";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(khSeihowebMizuhoMinyuuDtlSksBean.getBankcd())) {
                        hrkkeirobtjh = "郵便貯金　通帳番号１"
                            + ConvertUtil.toZenAll(khSeihowebMizuhoMinyuuDtlSksBean.getSitencd(), 0, 1) + "０"
                            + ConvertUtil.toZenAll(khSeihowebMizuhoMinyuuDtlSksBean.getKouzano(), 0, 1) + "１";
                    }
                    else {
                        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(
                            khSeihowebMizuhoMinyuuDtlSksBean.getBankcd(),
                            khSeihowebMizuhoMinyuuDtlSksBean.getSitencd(), syoribiYmd);

                        if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {
                            String yokinKbn = "";
                            if (C_YokinKbn.HUTUU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getYokinkbn())) {
                                yokinKbn = "フツウ";
                            }
                            else {
                                yokinKbn = "トウザ";
                            }

                            String bankNmKn = bzGetBankDataBean.getBankNmKn();
                            String sitenNmKn = bzGetBankDataBean.getSitenNmKn();

                            bankNmKn = editString(bankNmKn, 23);
                            sitenNmKn = editString(sitenNmKn, 22);

                            hrkkeirobtjh = bankNmKn + "　" + sitenNmKn + "　" + yokinKbn + "　"
                                + ConvertUtil.toZenAll(khSeihowebMizuhoMinyuuDtlSksBean.getKouzano(), 0, 1);
                        }
                    }
                }

                String misyuujiyuu = "  ";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    if (C_HurihunoKbn.SIKINHUSOKU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        misyuujiyuu = "01";
                    }
                    else if (C_HurihunoKbn.YKNSYATUGOU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        misyuujiyuu = "03";
                    }
                    else if (C_HurihunoKbn.NOKOUHURIIRAI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        misyuujiyuu = "04";
                    }
                    else if (C_HurihunoKbn.ITKTUGOU.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHurihunokbn())) {
                        misyuujiyuu = "08";
                    }
                }
                else if (C_Hrkkeiro.CREDIT.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    misyuujiyuu = "  ";
                }
                else {
                }

                String bankCd = "";
                String sitenCd = "";
                C_YokinKbn yokinKbn = null;
                String kouzaNo = "";
                if (C_Hrkkeiro.KOUHURI.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    bankCd = khSeihowebMizuhoMinyuuDtlSksBean.getBankcd();
                    sitenCd = khSeihowebMizuhoMinyuuDtlSksBean.getSitencd();
                    yokinKbn = khSeihowebMizuhoMinyuuDtlSksBean.getYokinkbn();
                    kouzaNo = khSeihowebMizuhoMinyuuDtlSksBean.getKouzano();
                }
                else if (C_Hrkkeiro.CREDIT.eq(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkeiro())) {
                    bankCd = "0000";
                    sitenCd = "000";
                    yokinKbn = C_YokinKbn.BLNK;
                    kouzaNo = "0000000";
                }
                else {
                }

                List<String> dairitencdList = new ArrayList<String>();

                dairitencdList.add(khSeihowebMizuhoMinyuuDtlSksBean.getDairitencd1());

                if (!BizUtil.isBlank(khSeihowebMizuhoMinyuuDtlSksBean.getDairitencd2())) {
                    dairitencdList.add(khSeihowebMizuhoMinyuuDtlSksBean.getDairitencd2());
                }

                for (int j = 0; j < dairitencdList.size(); j++) {
                    String tntnm10keta = "";

                    String tntusygyouhaiinfo = "";

                    BzGetBsInfoBean bzGetBsInfoBean = null;

                    String drtencd = "";

                    String bosyuucd = "";

                    String drtenkanrisosikicd = "";

                    C_DrtenChannelSyurui bosyuudairitengyousyukbn = C_DrtenChannelSyurui.BLNK;

                    BzGetAgInfoBean bzGetAgInfoBean = null;

                    String atesakinm = "";

                    if (j == 0) {
                        drtencd = khSeihowebMizuhoMinyuuDtlSksBean.getDairitencd1();

                        bosyuucd = khSeihowebMizuhoMinyuuDtlSksBean.getBosyuucd1();

                        drtenkanrisosikicd = khSeihowebMizuhoMinyuuDtlSksBean.getDrtenkanrisosikicd1();

                        bosyuudairitengyousyukbn = khSeihowebMizuhoMinyuuDtlSksBean.getDrtenchannelsyuruikbn1();
                    }
                    else {
                        drtencd = khSeihowebMizuhoMinyuuDtlSksBean.getDairitencd2();

                        bosyuucd = khSeihowebMizuhoMinyuuDtlSksBean.getBosyuucd2();

                        drtenkanrisosikicd = khSeihowebMizuhoMinyuuDtlSksBean.getDrtenkanrisosikicd2();

                        bosyuudairitengyousyukbn = khSeihowebMizuhoMinyuuDtlSksBean.getDrtenchannelsyuruikbn2();
                    }

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtencd);

                    for (BzGetAgInfoBean bzGetAgInfoBean2 : bzGetAgInfoBeanList) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean2.getDiritenJyouhouKbn())) {
                            bzGetAgInfoBean = bzGetAgInfoBean2;
                            atesakinm = editString(null2blank(bzGetAgInfoBean.getKanjiDairitenNm()) + "代理店", 20);

                            break;
                        }
                    }

                    bzGetBsInfoBean = bzGetBsInfo.exec(bosyuucd);

                    if (bzGetBsInfoBean != null) {
                        tntnm10keta = editString(bzGetBsInfoBean.getKanjiBosyuuninNm(), 10);
                        if (bzGetBsInfoBean.getBosyuuninGyouhaiYmd() != null) {
                            tntusygyouhaiinfo = "（退社）";
                        }
                    }

                    IT_SeihowebMizuhoMinyuuDtl seihowebMizuhoMinyuuDtl = new IT_SeihowebMizuhoMinyuuDtl();

                    seihowebMizuhoMinyuuDtl.setKbnkey(khSeihowebMizuhoMinyuuDtlSksBean.getKbnkey());

                    seihowebMizuhoMinyuuDtl.setSyono(khSeihowebMizuhoMinyuuDtlSksBean.getSyono());

                    seihowebMizuhoMinyuuDtl.setDrtencd(drtencd);

                    seihowebMizuhoMinyuuDtl.setBosyuucd(bosyuucd);

                    seihowebMizuhoMinyuuDtl.setSyoriym(syoribiYm);

                    seihowebMizuhoMinyuuDtl.setMinyusyoriymd(khSeihowebMizuhoMinyuuDtlSksBean.getMinyusyoriymd());

                    seihowebMizuhoMinyuuDtl.setBosyuuym(khSeihowebMizuhoMinyuuDtlSksBean.getBosyuuym());

                    seihowebMizuhoMinyuuDtl.setKydatkikbnkj(khSeihowebMizuhoMinyuuDtlSksBean.getKydatkikbnkj());

                    seihowebMizuhoMinyuuDtl.setKyknm35keta(khSeihowebMizuhoMinyuuDtlSksBean.getKyknm35keta());

                    seihowebMizuhoMinyuuDtl.setCifcd(khSeihowebMizuhoMinyuuDtlSksBean.getCifcd());

                    seihowebMizuhoMinyuuDtl.setPjytym(khSeihowebMizuhoMinyuuDtlSksBean.getJyuutouym());

                    seihowebMizuhoMinyuuDtl.setAtesakinm(atesakinm);

                    seihowebMizuhoMinyuuDtl.setMinyujytymdyofuri(ztyminyuujyutuymdyofuri);

                    seihowebMizuhoMinyuuDtl.setMinyujytymdyofuriigi(ztyminyuujyutuymdyofuriigi);

                    seihowebMizuhoMinyuuDtl.setHassinka(hasshinKa);

                    seihowebMizuhoMinyuuDtl.setTntnm10keta(tntnm10keta);

                    seihowebMizuhoMinyuuDtl.setHrkkaisuukj(hHrkkaisuuKanji);

                    seihowebMizuhoMinyuuDtl.setHrkkeirokj(hrkkeiroKanji);

                    seihowebMizuhoMinyuuDtl.setHrkp(khSeihowebMizuhoMinyuuDtlSksBean.getHrkp());

                    seihowebMizuhoMinyuuDtl.setKnkimnyuuryu(knkimnyuuryu);

                    seihowebMizuhoMinyuuDtl.setTntusygyouhaiinfo(tntusygyouhaiinfo);

                    seihowebMizuhoMinyuuDtl.setHrkkeirobtjhmidasi(hrkkeirobtjhmidasi);

                    seihowebMizuhoMinyuuDtl.setHrkkeirobtjh(hrkkeirobtjh);

                    seihowebMizuhoMinyuuDtl.setHknsyuruinm30keta(editString(syouhnZokusei.getSyouhnnmsyouken(), 30));

                    seihowebMizuhoMinyuuDtl.setDrtenkanrisosikicd(drtenkanrisosikicd);

                    seihowebMizuhoMinyuuDtl.setDbskyoteiym(syoribiYm.addMonths(3));

                    seihowebMizuhoMinyuuDtl.setKeiyakuymd(khSeihowebMizuhoMinyuuDtlSksBean.getKeiyakuymd());

                    seihowebMizuhoMinyuuDtl.setHhknnmkj(khSeihowebMizuhoMinyuuDtlSksBean.getHhknnmkj());

                    seihowebMizuhoMinyuuDtl.setTsintelno(khSeihowebMizuhoMinyuuDtlSksBean.getTsintelno());

                    seihowebMizuhoMinyuuDtl.setDai2tsintelno(khSeihowebMizuhoMinyuuDtlSksBean.getDai2tsintelno());

                    seihowebMizuhoMinyuuDtl.setBankcd(bankCd);

                    seihowebMizuhoMinyuuDtl.setSitencd(sitenCd);

                    seihowebMizuhoMinyuuDtl.setYokinkbn(yokinKbn);

                    seihowebMizuhoMinyuuDtl.setKouzano(kouzaNo);

                    seihowebMizuhoMinyuuDtl.setHrkkaisuu(khSeihowebMizuhoMinyuuDtlSksBean.getHrkkaisuu());

                    seihowebMizuhoMinyuuDtl.setHjnkykhyj("0");

                    seihowebMizuhoMinyuuDtl.setKykjyutikbn("1");

                    seihowebMizuhoMinyuuDtl.setTsinkihontikucd(khSeihowebMizuhoMinyuuDtlSksBean.getTsinkihontikucd());

                    seihowebMizuhoMinyuuDtl.setKanjitsinkaiadr(khSeihowebMizuhoMinyuuDtlSksBean.getKanjitsinkaiadr());

                    seihowebMizuhoMinyuuDtl.setKzmeiginmkn(khSeihowebMizuhoMinyuuDtlSksBean.getKzmeiginmkn());

                    seihowebMizuhoMinyuuDtl.setJkiannaikg(khSeihowebMizuhoMinyuuDtlSksBean.getJkiannaikg());

                    seihowebMizuhoMinyuuDtl.setYykknmnryymd(khSeihowebMizuhoMinyuuDtlSksBean.getYykknmnryymd());

                    seihowebMizuhoMinyuuDtl.setJhurikstkkahikbn("2");

                    seihowebMizuhoMinyuuDtl.setHukkatumoskahikbn("2");

                    seihowebMizuhoMinyuuDtl.setKeikamon3keta(syoribiYm.subtractMonths(
                        khSeihowebMizuhoMinyuuDtlSksBean.getKeiyakuymd().getBizDateYM()));

                    seihowebMizuhoMinyuuDtl.setMisyuuhasseiym(syoribiYm.getPreviousMonth());

                    seihowebMizuhoMinyuuDtl.setMisyuujiyuu(misyuujiyuu);

                    seihowebMizuhoMinyuuDtl.setNexthurikaeymd(khSeihowebMizuhoMinyuuDtlSksBean.getNexthurikaeymd());

                    seihowebMizuhoMinyuuDtl.setIkkatubaraikbn(khSeihowebMizuhoMinyuuDtlSksBean.getIkkatubaraikbn());

                    seihowebMizuhoMinyuuDtl.setIkkatubaraikaisuu(khSeihowebMizuhoMinyuuDtlSksBean.getIkkatubaraikaisuu());

                    seihowebMizuhoMinyuuDtl.setBosyuudairitengyousyukbn(bosyuudairitengyousyukbn);

                    seihowebMizuhoMinyuuDtl.setGyoumuKousinKinou(gyoumuKousinKinou);

                    seihowebMizuhoMinyuuDtl.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                    seihowebMizuhoMinyuuDtl.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(seihowebMizuhoMinyuuDtl);

                    entityInserter.add(seihowebMizuhoMinyuuDtl);
                }

                kykKihon.detach();
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private String editString(String pEditString, int pNum) {
        String editString = pEditString;

        if (pEditString == null) {
            editString = "";
        }
        else if (pEditString.length() > pNum) {
            editString = pEditString.substring(0, pNum);
        }

        return editString;
    }


    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private String null2blank(String psValue) {
        if (psValue == null) {
            return "";
        }

        return psValue;
    }
}
