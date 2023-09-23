package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSks;
import yuyu.common.biz.kaikei.BzGkfbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.biz.kaikei.SikinIdouRirekiDataBean;
import yuyu.common.hozen.khcommon.dba4editkaiyakutblupdate.EditKaiyakuTblUpdateDao;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_Zennou;

/**
 * 契約保全 契約保全共通 解約処理テーブル更新値編集
 */
public class EditKaiyakuTblUpdate {

    private IT_KykKihon kykKihon;

    private List<IT_KhDenpyoData> khDenpyoDatas;

    private IT_KhFBSoukinData khFBSoukinData;

    private IT_KhGaikaFBSoukinData khGaikaFBSoukinData;

    private IT_AnsyuKihon ansyuKihonData;

    private IT_KhDshrTuki khDshrTukiData;

    private BT_SikinIdouRireki sikinIdouRirekiData;

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private EditKaiyakuTblUpdateDao editKaiyakuTblUpdateDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public EditKaiyakuTblUpdate() {
        super();
    }

    public C_ErrorKbn exec(KhozenCommonParam pKhozenCommonParam, IT_KykKihon pKykKihon, BizDate pSyoriYmd,
        EditKaiyakuTblUpdateBean pEditKaiyakuTblUpdateBean, IT_BAK_KykKihon pBakKykKihon) {

        logger.debug("▽ 解約処理テーブル更新値編集 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();
        kykKihon = null;
        khDenpyoDatas = new ArrayList<>();
        khFBSoukinData = null;
        khGaikaFBSoukinData = null;
        ansyuKihonData = null;

        String henkousikibetukey = pKhozenCommonParam.getSikibetuKey(pEditKaiyakuTblUpdateBean.getSyono());

        pKykKihon.setSyhenkouymd(pSyoriYmd);
        pKykKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        pKykKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        pKykKihon.setGyoumuKousinTime(gyoumuKousinTime);

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(henkousikibetukey);

        BizPropertyInitializer.initialize(khTtdkRireki);

        if (C_KinouKbn.BATCH.eq(kinou.getKinouKbn())) {
            pKhozenCommonParam.setBatchKeiyakuKihon(pKykKihon);
            pKhozenCommonParam.setBatchAnsyuKihon(pEditKaiyakuTblUpdateBean.getAnsyuKihon());
        }

        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);

        editKykSyhnRirekiTbl.exec(pKhozenCommonParam, pEditKaiyakuTblUpdateBean.getSyono());

        IT_KykKihon kykKihonTemp = pKykKihon;

        List<IT_KykSyouhn> kykSyouhnList = kykKihonTemp.getKykSyouhns();

        for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {

            kykSyouhn.setHenkousikibetukey(henkousikibetukey);
            kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

            if (C_Syoumetujiyuu.SIKKOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.SIKKOUKAIYAKU);
            }
            else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKhozenCommonParam.getFunctionId())) {
                kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM);
            }
            else if (C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhn.getSyoumetujiyuu())) {
                kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM);
            }
            else {
                kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.KAIYAKU);
            }
            if (!C_Syoumetujiyuu.SIKKOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                kykSyouhn.setSyoumetuymd(pEditKaiyakuTblUpdateBean.getKaiykymd());
            }

            kykSyouhn.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            kykSyouhn.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            kykSyouhn.setGyoumuKousinTime(gyoumuKousinTime);
        }

        List<IT_SyouhnTokujou> syouhnTokujouList = kykKihonTemp.getSyouhnTokujous();

        for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouList) {

            syouhnTokujou.setHenkousikibetukey(henkousikibetukey);
            syouhnTokujou.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            syouhnTokujou.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            syouhnTokujou.setGyoumuKousinTime(gyoumuKousinTime);
        }

        List<IT_KykSyouhn> kykSyohnSyuList = kykKihonTemp.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSyouhn kykSyouhnSyu = new IT_KykSyouhn();

        if (kykSyohnSyuList.size() > 0) {
            kykSyouhnSyu = kykSyohnSyuList.get(0);
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhnSyu.getSyouhncd());

        BizDate ryosyuymd = null;
        IT_AnsyuKihon ansyuKihon = pEditKaiyakuTblUpdateBean.getAnsyuKihon();
        IT_Zennou zennou = new IT_Zennou();
        List<IT_Zennou> zennouLst = new ArrayList<>();

        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnSyu.getKykjyoutai())) {

            zennouLst = ansyuKihon.getZennouMsisnsBySyono();

            SortIT_Zennou sortZennou = SWAKInjector.getInstance(SortIT_Zennou.class);

            zennouLst = sortZennou.OrderIT_ZennouByPkDesc(zennouLst);

            zennou = zennouLst.get(0);

            ryosyuymd = zennou.getRyosyuymd();
        }

        HenkanTuuka HenkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CommonSiwakeOutBean commonSiwakeOutBean = SWAKInjector.getInstance(CommonSiwakeOutBean.class);

        CurrencyType syuKyktuukaType = HenkanTuuka.henkanTuukaKbnToType(kykSyouhnSyu.getKyktuukasyu());
        String denrenNo = "";

        if (pEditKaiyakuTblUpdateBean.getShrgkkei().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getShrgkkei().getType())) > 0
            || pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei().compareTo(
                BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei().getType())) > 0) {
            TaisyouGkBean taisyouGkBeanKaiyakuHrkin = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanShrtienrsk = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanGstsgk = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanShrgk = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanKrkgk = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanHaitoukin = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanSyonendokmkoup = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanSyonendo2kmkoup = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanJinendoikoup = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanSonotakhr = SWAKInjector.getInstance(TaisyouGkBean.class);
            TaisyouGkBean taisyouGkBeanYendthnkhr = SWAKInjector.getInstance(TaisyouGkBean.class);
            List<TaisyouGkBean> taisyouGkBeanList = new ArrayList<>();
            CommonSiwakeInBean commonSiwakeInBean = SWAKInjector.getInstance(CommonSiwakeInBean.class);
            CommonSiwake commonSiwake = SWAKInjector.getInstance(CommonSiwake.class);
            CommonSiwakeUtil commonSiwakeUtil = SWAKInjector.getInstance(CommonSiwakeUtil.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            BizCurrency jpyTkgkSonotaHenreikin = BizCurrency.valueOf(0);
            BizCurrency kykTkgkSonotaHenreikin = BizCurrency.valueOf(0, syuKyktuukaType);
            C_UmuKbn azukarikinUmu = C_UmuKbn.NONE;

            if(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
                BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0){
                azukarikinUmu = C_UmuKbn.ARI;
            }

            BizCurrency zennouseisankgk = null;
            BizCurrency mikeikap = null;

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn &&
                !C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {

                zennouseisankgk = pEditKaiyakuTblUpdateBean.getZennouseisankgk();
                mikeikap = pEditKaiyakuTblUpdateBean.getMikeikap();

            }
            else {

                zennouseisankgk = pEditKaiyakuTblUpdateBean.getJpyzennouseisankgk();
                mikeikap = pEditKaiyakuTblUpdateBean.getJpymikeikap();

            }

            commonSiwakeUtil.execPKanjokamokuHantei(
                pEditKaiyakuTblUpdateBean.getShrymd(),
                kykSyouhnSyu.getKykymd(),
                zennouseisankgk,
                ryosyuymd,
                pEditKaiyakuTblUpdateBean.getAnsyuKihon().getJkipjytym(),
                mikeikap,
                pEditKaiyakuTblUpdateBean.getMikeikapjyutouym(),
                pEditKaiyakuTblUpdateBean.getMiKeikaPBeanHrt(),
                pKhozenCommonParam.getFunctionId(),
                C_SyoriKbn.BLNK,
                kykKihonTemp.getHrkkaisuu(),
                kykKihonTemp.getTikiktbrisyuruikbn());

            if (C_UmuKbn.NONE.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu())) {
                if(C_UmuKbn.ARI.eq(azukarikinUmu)){
                    jpyTkgkSonotaHenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin().add(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap());

                    if(jpyTkgkSonotaHenreikin.compareTo(BizCurrency.valueOf(0,jpyTkgkSonotaHenreikin.getType())) > 0){
                        kykTkgkSonotaHenreikin = keisanGaikakanzan.execDivide(
                            kykSyouhnSyu.getKyktuukasyu(),
                            jpyTkgkSonotaHenreikin,
                            pEditKaiyakuTblUpdateBean.getGkshrrate(),
                            C_HasuusyoriKbn.AGE)
                            .add(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr());
                    }
                    else {
                        kykTkgkSonotaHenreikin = pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr();
                    }
                }
                else if(C_UmuKbn.NONE.eq(azukarikinUmu)){
                    kykTkgkSonotaHenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();
                }

                taisyouGkBeanKaiyakuHrkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                taisyouGkBeanKaiyakuHrkin.setTaisyouGk(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
                taisyouGkBeanKaiyakuHrkin.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
                taisyouGkBeanList.add(taisyouGkBeanKaiyakuHrkin);

                taisyouGkBeanShrtienrsk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                taisyouGkBeanShrtienrsk.setTaisyouGk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getShrtienrsk()));
                taisyouGkBeanShrtienrsk.setKeiyakutuukaGk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getShrtienrsk()));
                taisyouGkBeanList.add(taisyouGkBeanShrtienrsk);

                taisyouGkBeanGstsgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
                if (C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                    taisyouGkBeanGstsgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpygstszeigk());
                    taisyouGkBeanGstsgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getJpygstszeigk());
                }
                else {
                    taisyouGkBeanGstsgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getGstszeigk());
                    taisyouGkBeanGstsgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getGstszeigk());
                }
                taisyouGkBeanList.add(taisyouGkBeanGstsgk);

                taisyouGkBeanShrgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                if (C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                    taisyouGkBeanShrgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                    taisyouGkBeanShrgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                }
                else {
                    taisyouGkBeanShrgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getShrgkkei());
                    taisyouGkBeanShrgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getShrgkkei());
                }
                taisyouGkBeanList.add(taisyouGkBeanShrgk);

                taisyouGkBeanKrkgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                taisyouGkBeanKrkgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpykariukekin());
                taisyouGkBeanKrkgk.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuKyktuukaType));
                taisyouGkBeanList.add(taisyouGkBeanKrkgk);

                taisyouGkBeanHaitoukin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                taisyouGkBeanHaitoukin.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpyhaitoukin().add(
                    pEditKaiyakuTblUpdateBean.getJpytkbthaitoukin()));
                taisyouGkBeanHaitoukin.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuKyktuukaType));
                taisyouGkBeanList.add(taisyouGkBeanHaitoukin);

                taisyouGkBeanSyonendokmkoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                taisyouGkBeanSyonendokmkoup.setTaisyouGk(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip());
                taisyouGkBeanSyonendokmkoup.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkSyonendoSyokaip());
                taisyouGkBeanList.add(taisyouGkBeanSyonendokmkoup);

                taisyouGkBeanSyonendo2kmkoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                taisyouGkBeanSyonendo2kmkoup.setTaisyouGk(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup());
                taisyouGkBeanSyonendo2kmkoup.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup());
                taisyouGkBeanList.add(taisyouGkBeanSyonendo2kmkoup);

                taisyouGkBeanJinendoikoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                taisyouGkBeanJinendoikoup.setTaisyouGk(commonSiwakeUtil.getTaisyouGkJinendoikoup());
                taisyouGkBeanJinendoikoup.setKeiyakutuukaGk(commonSiwakeUtil.getTaisyouGkJinendoikoup());
                taisyouGkBeanList.add(taisyouGkBeanJinendoikoup);

                taisyouGkBeanSonotakhr.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                taisyouGkBeanSonotakhr.setTaisyouGk(kykTkgkSonotaHenreikin);
                taisyouGkBeanSonotakhr.setKeiyakutuukaGk(kykTkgkSonotaHenreikin);
                taisyouGkBeanList.add(taisyouGkBeanSonotakhr);

                taisyouGkBeanYendthnkhr.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR);
                taisyouGkBeanYendthnkhr.setTaisyouGk(pEditKaiyakuTblUpdateBean.getYendthnkhr());
                taisyouGkBeanYendthnkhr.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getYendthnkhr());
                taisyouGkBeanYendthnkhr.setSeg1cd(pEditKaiyakuTblUpdateBean.getSeg1cd());
                taisyouGkBeanYendthnkhr.setSeg2cd(pEditKaiyakuTblUpdateBean.getSeg2cd());
                taisyouGkBeanList.add(taisyouGkBeanYendthnkhr);
            }
            else {
                if (pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
                    BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0) {

                    jpyTkgkSonotaHenreikin = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr(),
                        pEditKaiyakuTblUpdateBean.getYenshrrate(),
                        C_HasuusyoriKbn.AGE)
                        .add(commonSiwakeUtil.getTaisyouGkSonotahenreikin())
                        .add(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap());
                }
                else {

                    if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn) {

                        kykTkgkSonotaHenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin();

                        if (kykTkgkSonotaHenreikin.compareTo(BizCurrency.valueOf(0, kykTkgkSonotaHenreikin.getType())) > 0) {
                            jpyTkgkSonotaHenreikin = keisanGaikakanzan.exec(
                                C_Tuukasyu.JPY,
                                kykTkgkSonotaHenreikin,
                                pEditKaiyakuTblUpdateBean.getYenshrrate(),
                                C_HasuusyoriKbn.AGE);
                        }
                    }
                    else {
                        jpyTkgkSonotaHenreikin = commonSiwakeUtil.getTaisyouGkSonotahenreikin()
                            .add(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap());
                    }
                }

                BizCurrency jpyTkgkSyonendoSyokaip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency jpyTkgkSyonendo2kaimeikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency jpyTkgkJinendoikoup = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency kykTkgkSyonendoSyokaip = BizCurrency.valueOf(0, syuKyktuukaType);
                BizCurrency kykTkgkSyonendo2kaimeikoup = BizCurrency.valueOf(0, syuKyktuukaType);
                BizCurrency kykTkgkJinendoikoup = BizCurrency.valueOf(0, syuKyktuukaType);

                if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn) {

                    kykTkgkSyonendoSyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                    kykTkgkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                    kykTkgkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();

                    if (kykTkgkSyonendoSyokaip.compareTo(BizCurrency.valueOf(0, kykTkgkSyonendoSyokaip.getType())) > 0) {
                        jpyTkgkSyonendoSyokaip = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            kykTkgkSyonendoSyokaip, pEditKaiyakuTblUpdateBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                    }

                    if (kykTkgkSyonendo2kaimeikoup.compareTo(BizCurrency.valueOf(0, kykTkgkSyonendo2kaimeikoup.getType())) > 0) {
                        jpyTkgkSyonendo2kaimeikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            kykTkgkSyonendo2kaimeikoup, pEditKaiyakuTblUpdateBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                    }

                    if (kykTkgkJinendoikoup.compareTo(BizCurrency.valueOf(0, kykTkgkJinendoikoup.getType())) > 0) {
                        jpyTkgkJinendoikoup = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            kykTkgkJinendoikoup, pEditKaiyakuTblUpdateBean.getYenshrrate(), C_HasuusyoriKbn.AGE);
                    }
                }
                else {
                    jpyTkgkSyonendoSyokaip = commonSiwakeUtil.getTaisyouGkSyonendoSyokaip();
                    jpyTkgkSyonendo2kaimeikoup = commonSiwakeUtil.getTaisyouGkSyonendo2kaimeikoup();
                    jpyTkgkJinendoikoup = commonSiwakeUtil.getTaisyouGkJinendoikoup();
                }

                taisyouGkBeanKaiyakuHrkin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
                taisyouGkBeanKaiyakuHrkin.setTaisyouGk(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
                taisyouGkBeanKaiyakuHrkin.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
                taisyouGkBeanList.add(taisyouGkBeanKaiyakuHrkin);

                taisyouGkBeanShrtienrsk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
                taisyouGkBeanShrtienrsk.setTaisyouGk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getJpyshrtienrsk()));
                taisyouGkBeanList.add(taisyouGkBeanShrtienrsk);

                taisyouGkBeanGstsgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
                taisyouGkBeanGstsgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpygstszeigk());
                taisyouGkBeanGstsgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getGstszeigk());
                taisyouGkBeanList.add(taisyouGkBeanGstsgk);

                taisyouGkBeanShrgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
                taisyouGkBeanShrgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                taisyouGkBeanShrgk.setKeiyakutuukaGk(pEditKaiyakuTblUpdateBean.getShrgkkei());
                taisyouGkBeanList.add(taisyouGkBeanShrgk);

                taisyouGkBeanKrkgk.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
                taisyouGkBeanKrkgk.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpykariukekin());
                taisyouGkBeanKrkgk.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuKyktuukaType));
                taisyouGkBeanList.add(taisyouGkBeanKrkgk);

                taisyouGkBeanHaitoukin.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);
                taisyouGkBeanHaitoukin.setTaisyouGk(pEditKaiyakuTblUpdateBean.getJpyhaitoukin().add(
                    pEditKaiyakuTblUpdateBean.getJpytkbthaitoukin()));
                taisyouGkBeanHaitoukin.setKeiyakutuukaGk(BizCurrency.valueOf(0, syuKyktuukaType));
                taisyouGkBeanList.add(taisyouGkBeanHaitoukin);

                taisyouGkBeanSyonendokmkoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
                taisyouGkBeanSyonendokmkoup.setTaisyouGk(jpyTkgkSyonendoSyokaip);
                taisyouGkBeanSyonendokmkoup.setKeiyakutuukaGk(kykTkgkSyonendoSyokaip);
                taisyouGkBeanList.add(taisyouGkBeanSyonendokmkoup);

                taisyouGkBeanSyonendo2kmkoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
                taisyouGkBeanSyonendo2kmkoup.setTaisyouGk(jpyTkgkSyonendo2kaimeikoup);
                taisyouGkBeanSyonendo2kmkoup.setKeiyakutuukaGk(kykTkgkSyonendo2kaimeikoup);
                taisyouGkBeanList.add(taisyouGkBeanSyonendo2kmkoup);

                taisyouGkBeanJinendoikoup.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
                taisyouGkBeanJinendoikoup.setTaisyouGk(jpyTkgkJinendoikoup);
                taisyouGkBeanJinendoikoup.setKeiyakutuukaGk(kykTkgkJinendoikoup);
                taisyouGkBeanList.add(taisyouGkBeanJinendoikoup);

                taisyouGkBeanSonotakhr.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
                taisyouGkBeanSonotakhr.setTaisyouGk(jpyTkgkSonotaHenreikin);
                taisyouGkBeanSonotakhr.setKeiyakutuukaGk(kykTkgkSonotaHenreikin);
                taisyouGkBeanList.add(taisyouGkBeanSonotakhr);
            }

            commonSiwakeInBean.setKinouId(pKhozenCommonParam.getFunctionId());
            commonSiwakeInBean.setDenYmd(pEditKaiyakuTblUpdateBean.getShrymd());
            commonSiwakeInBean.setTuukasyu(pEditKaiyakuTblUpdateBean.getShrtuukasyu());
            commonSiwakeInBean.setSyoriYmd(pSyoriYmd);
            commonSiwakeInBean.setKykYmd(kykSyouhnSyu.getKykymd());
            commonSiwakeInBean.setSyouhnCd(kykSyouhnSyu.getSyouhncd());
            commonSiwakeInBean.setSyouhnsdNo(kykSyouhnSyu.getSyouhnsdno());
            commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);
            commonSiwakeInBean.setShrhousiteiKbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
            commonSiwakeInBean.setKyktuukaSyu(kykSyouhnSyu.getKyktuukasyu());
            commonSiwakeInBean.setTuukasyuKansanKawaserate(pEditKaiyakuTblUpdateBean.getYenshrrate());
            commonSiwakeInBean.setGstszeigkUmuKbn(pEditKaiyakuTblUpdateBean.getGsbunritaisyouflg());
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn) {
                commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
            }
            else {
                commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);
            }
            commonSiwakeInBean.setAzukarikinUmuKbn(azukarikinUmu);
            commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanList);

            commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

            if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhnSyu.getKykjyoutai())) {

                List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = commonSiwakeUtil.execTaisyakuTyousei(
                    commonSiwakeOutBean.getTuukasyu(), commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());
                commonSiwakeOutBean.setBzSiwakeMeisaiBeanLst(bzSiwakeMeisaiBeanLst);
            }

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean =
                SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);

            bzDenpyouDataTourokuBean.setIbSyono(pEditKaiyakuTblUpdateBean.getSyono());
            bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
            bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
            bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
            bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
            bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
            bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
            bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
            bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
            bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
            if (C_KinouKbn.ONLINE.eq(kinou.getKinouKbn())) {
                bzDenpyouDataTourokuBean.setIbSyorisosikicd(pKhozenCommonParam.getTmSosikiCd());
            }
            else {
                bzDenpyouDataTourokuBean.setIbSyorisosikicd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
            }
            bzDenpyouDataTourokuBean.setIbKyktuukasyu(kykSyouhnSyu.getKyktuukasyu());
            bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            if (C_Tuukasyu.JPY.eq(pEditKaiyakuTblUpdateBean.getShrtuukasyu())) {
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
            }
            else {
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(true);
                bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(pEditKaiyakuTblUpdateBean.getSyoruiukeymd());
            }
            bzDenpyouDataTourokuBean.setIbShrhousiteiKbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
            bzDenpyouDataTourokuBean.setIbSyouhncd(kykSyouhnSyu.getSyouhncd());
            bzDenpyouDataTourokuBean.setIbSyouhnsdno(kykSyouhnSyu.getSyouhnsdno());
            bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());

            khDenpyoDatas = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);
            denrenNo = khDenpyoDatas.get(0).getDenrenno();
            String dengyoumuCd = khDenpyoDatas.get(0).getDengyoumucd();

            if (C_ShrhousiteiKbn.FB_YOKUJITU.eq(pEditKaiyakuTblUpdateBean.getShrhousiteikbn()) ||
                C_ShrhousiteiKbn.FB_2EIGYOUBI.eq(pEditKaiyakuTblUpdateBean.getShrhousiteikbn()) ||
                C_ShrhousiteiKbn.FB_3EIGYOUBI.eq(pEditKaiyakuTblUpdateBean.getShrhousiteikbn())) {
                if (C_Tuukasyu.JPY.eq(pEditKaiyakuTblUpdateBean.getShrtuukasyu())) {
                    BzFbSoukinDataSks bzFbSoukinDataSks = SWAKInjector.getInstance(BzFbSoukinDataSks.class);
                    BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);

                    bzFbSoukinDataSksBean.setDenbyouyouDataRenbon(denrenNo);
                    bzFbSoukinDataSksBean.setEdaNo(bzDenpyouDataSks.getEdano());
                    bzFbSoukinDataSksBean.setDenSysKbn(commonSiwakeOutBean.getDensysKbn());
                    bzFbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                    if (C_KinouKbn.ONLINE.eq(kinou.getKinouKbn())) {
                        bzFbSoukinDataSksBean.setSyoriSosikiCd(pKhozenCommonParam.getTmSosikiCd());
                    }
                    else {
                        bzFbSoukinDataSksBean.setSyoriSosikiCd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
                    }
                    bzFbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                    bzFbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                    bzFbSoukinDataSksBean.setSyoNo(pEditKaiyakuTblUpdateBean.getSyono());
                    bzFbSoukinDataSksBean.setShrHouSiteiKbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
                    bzFbSoukinDataSksBean.setBankCd(pEditKaiyakuTblUpdateBean.getBankcd());
                    bzFbSoukinDataSksBean.setSitenCd(pEditKaiyakuTblUpdateBean.getSitencd());
                    bzFbSoukinDataSksBean.setYokinKbn(pEditKaiyakuTblUpdateBean.getYokinkbn());
                    bzFbSoukinDataSksBean.setKouzaNo(pEditKaiyakuTblUpdateBean.getKouzano());
                    bzFbSoukinDataSksBean.setKzMeigiNmKn(pEditKaiyakuTblUpdateBean.getKzmeiginmkn());
                    bzFbSoukinDataSksBean.setSouKingk(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                    bzFbSoukinDataSksBean.setKykTuukasyu(kykSyouhnSyu.getKyktuukasyu());
                    bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                    bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                    bzFbSoukinDataSksBean.setKinouId(pKhozenCommonParam.getFunctionId());
                    bzFbSoukinDataSksBean.setUserId(pKhozenCommonParam.getUserID());
                    bzFbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                    khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);
                }
                else {
                    BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                    BzGkfbSoukinDataSks bzGkfbSoukinDataSks = SWAKInjector.getInstance(BzGkfbSoukinDataSks.class);
                    BzGkfbSoukinDataSksBean bzGkfbSoukinDataSksBean =
                        SWAKInjector.getInstance(BzGkfbSoukinDataSksBean.class);
                    BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pEditKaiyakuTblUpdateBean.getBankcd(),
                        pEditKaiyakuTblUpdateBean.getSitencd());

                    String kzmeiginmei = ConvertUtil.toHanAll(pEditKaiyakuTblUpdateBean.getKzmeiginmkn(), 0, 0);

                    bzGkfbSoukinDataSksBean.setDenRenno(denrenNo);
                    bzGkfbSoukinDataSksBean.setEdaNo(bzDenpyouDataSks.getEdano());
                    bzGkfbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.HOZEN);
                    bzGkfbSoukinDataSksBean.setSyoriCd(commonSiwakeOutBean.getSyoriCd());
                    if (C_KinouKbn.ONLINE.eq(kinou.getKinouKbn())) {
                        bzGkfbSoukinDataSksBean.setSyoriSosikiCd(pKhozenCommonParam.getTmSosikiCd());
                    }
                    else {
                        bzGkfbSoukinDataSksBean.setSyoriSosikiCd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
                    }
                    bzGkfbSoukinDataSksBean.setSyoriYmd(commonSiwakeOutBean.getSyoriYmd());
                    bzGkfbSoukinDataSksBean.setDenYmd(commonSiwakeOutBean.getDenyMd());
                    bzGkfbSoukinDataSksBean.setSyono(pEditKaiyakuTblUpdateBean.getSyono());
                    bzGkfbSoukinDataSksBean.setShrHouSiteiKbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
                    bzGkfbSoukinDataSksBean.setBankCd(pEditKaiyakuTblUpdateBean.getBankcd());
                    bzGkfbSoukinDataSksBean.setBankNmEj(bzGetBankDataBean.getBankNmEj());
                    bzGkfbSoukinDataSksBean.setSitenCd(pEditKaiyakuTblUpdateBean.getSitencd());
                    bzGkfbSoukinDataSksBean.setSitenNmEj(bzGetBankDataBean.getSitenNmEj());
                    bzGkfbSoukinDataSksBean.setKouzaNo(pEditKaiyakuTblUpdateBean.getKouzano());
                    bzGkfbSoukinDataSksBean.setKzMeigiNmEi(kzmeiginmei);
                    bzGkfbSoukinDataSksBean.setShrTuukaSyu(kykSyouhnSyu.getKyktuukasyu());
                    bzGkfbSoukinDataSksBean.setGaikaShrgk(pEditKaiyakuTblUpdateBean.getShrgkkei());
                    bzGkfbSoukinDataSksBean.setKykTuukaSyu(kykSyouhnSyu.getKyktuukasyu());
                    bzGkfbSoukinDataSksBean.setCrossRateShrgk(BizCurrency.valueOf(0));
                    bzGkfbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(0));
                    bzGkfbSoukinDataSksBean.setKinouId(pKhozenCommonParam.getFunctionId());
                    bzGkfbSoukinDataSksBean.setUserId(pKhozenCommonParam.getUserID());
                    bzGkfbSoukinDataSksBean.setDengyoumuCd(dengyoumuCd);

                    khGaikaFBSoukinData = bzGkfbSoukinDataSks.execKh(bzGkfbSoukinDataSksBean);
                }
            }

            String tsinyNo = "";
            if (C_Kaiyakujiyuu.KYKSB.eq(pEditKaiyakuTblUpdateBean.getKaiyakujiyuu())) {
                tsinyNo = pEditKaiyakuTblUpdateBean.getKyksyaszkyno();
            }
            else {
                tsinyNo = pKhozenCommonParam.getKeiyakusya(pEditKaiyakuTblUpdateBean.getSyono()).getTsinyno();
            }

            IT_KhShrRireki khShrRireki = khTtdkRireki.createKhShrRireki();

            khShrRireki.setShrymd(pEditKaiyakuTblUpdateBean.getShrymd());
            khShrRireki.setShrsyoriymd(pSyoriYmd);

            if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKhozenCommonParam.getFunctionId())) {
                khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
            }
            else {
                khShrRireki.setShrsyorikbn(C_ShrsyoriKbn.KAIYAKU);
            }

            khShrRireki.setSyoruiukeymd(pEditKaiyakuTblUpdateBean.getSyoruiukeymd());
            khShrRireki.setKouryokuhasseiymd(pEditKaiyakuTblUpdateBean.getKaiykymd());
            if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu())) {
                khShrRireki.setShrtienrskkisanymd(pEditKaiyakuTblUpdateBean.getJpytienrisokukisanymd());
                khShrRireki.setTienrsknissuu(pEditKaiyakuTblUpdateBean.getJpytienrsknissuu());
                khShrRireki.setShrtuukashrtienrsk(pEditKaiyakuTblUpdateBean.getJpyshrtienrsk());
            }
            else {
                khShrRireki.setShrtienrskkisanymd(pEditKaiyakuTblUpdateBean.getShrtienrskkisanymd());
                khShrRireki.setTienrsknissuu(pEditKaiyakuTblUpdateBean.getTienrsknissuu());
                khShrRireki.setShrtuukashrtienrsk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getShrtienrsk()));
            }
            khShrRireki.setSinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
            khShrRireki.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
            khShrRireki.setGsbunritaisyou(pEditKaiyakuTblUpdateBean.getGsbunritaisyouflg());
            khShrRireki.setYenshrtkumu(pEditKaiyakuTblUpdateBean.getYenshrtkumu());
            khShrRireki.setKyktuukasyu(kykSyouhnSyu.getKyktuukasyu());
            khShrRireki.setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn.W);
            khShrRireki.setSyushrgkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn ||
                C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                khShrRireki.setYenmikeikap(pEditKaiyakuTblUpdateBean.getJpymikeikap());
                khShrRireki.setYenzennomikeikap(pEditKaiyakuTblUpdateBean.getJpyzennouseisankgk());
            }
            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn &&
                !C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                khShrRireki.setMikeikap(pEditKaiyakuTblUpdateBean.getMikeikap());
                khShrRireki.setZennomikeikap(pEditKaiyakuTblUpdateBean.getZennouseisankgk());
            }
            else {
                khShrRireki.setMikeikap(BizCurrency.valueOf(0, syuKyktuukaType));
                khShrRireki.setZennomikeikap(BizCurrency.valueOf(0, syuKyktuukaType));
            }
            khShrRireki.setShrtuukasyu(pEditKaiyakuTblUpdateBean.getShrtuukasyu());
            if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu()) ||
                C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                khShrRireki.setShrtuukashrgkgoukei(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                khShrRireki.setShrtuukasyushrgkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
            }
            else {
                khShrRireki.setShrtuukashrgkgoukei(pEditKaiyakuTblUpdateBean.getShrgkkei());
                khShrRireki.setShrtuukasyushrgkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
            }
            khShrRireki.setShrtuukasonotaseisangk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getYendthnkhr()));
            if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu()) ||
                C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                khShrRireki.setYenshrgkgoukei(pEditKaiyakuTblUpdateBean.getJpyshrgkgoukei());
                khShrRireki.setYensyushrgkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
                khShrRireki.setYenshrtienrsk(pEditKaiyakuTblUpdateBean.getJpyshrtienrsk());
                khShrRireki.setShrtuukagstszeigk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getJpygstszeigk()));
            }
            else {
                khShrRireki.setYenshrgkgoukei(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    pEditKaiyakuTblUpdateBean.getShrgkkei(),
                    pEditKaiyakuTblUpdateBean.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE));
                khShrRireki.setYensyushrgkkei(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    pEditKaiyakuTblUpdateBean.getKaiyakuhr(),
                    pEditKaiyakuTblUpdateBean.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE));
                khShrRireki.setYenshrtienrsk(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                    doKingakuHenkan(pEditKaiyakuTblUpdateBean.getShrtienrsk()),
                    pEditKaiyakuTblUpdateBean.getZeimukwsrate(),
                    C_HasuusyoriKbn.SUTE));
                khShrRireki.setShrtuukagstszeigk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getGstszeigk()));
            }
            khShrRireki.setYenkansanhaitoukin(pEditKaiyakuTblUpdateBean.getJpyhaitoukin());
            khShrRireki.setYenkansansonotaseisangk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getYendthnkhr()));
            khShrRireki.setYengstszeigk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getJpygstszeigk()));
            khShrRireki.setYengstszeigknationaltax(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getYengstszeigknationaltax()));
            khShrRireki.setYengstszeigklocaltax(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getYengstszeigklocaltax()));
            if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getGsbunritaisyouflg())) {
                BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);
                bzGetAdrData.execTodouhukenCdByPostalcd(tsinyNo);
                String todouhukenCd = BizUtil.num(bzGetAdrData.getTodouhukenCd().getValue(), BizUtil.ZERO_FILL, 2);
                khShrRireki.setNztodouhukencd(todouhukenCd);
            }
            khShrRireki.setYenhtykeihi(pEditKaiyakuTblUpdateBean.getHtykeihi());
            khShrRireki.setYenkztgk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getYengststaisyousaeki()));
            khShrRireki.setShrkwsratekjnymd(pEditKaiyakuTblUpdateBean.getYenshrratetekiymd());
            khShrRireki.setShrkwsrate(pEditKaiyakuTblUpdateBean.getYenshrrate());
            khShrRireki.setZeimukwsratekjnymd(pEditKaiyakuTblUpdateBean.getZeimukwsratekjnymd());
            khShrRireki.setZeimukwsrate(pEditKaiyakuTblUpdateBean.getZeimukwsrate());
            khShrRireki.setKyksyaszknmkn(pEditKaiyakuTblUpdateBean.getKyksyaszknmkn());
            khShrRireki.setKyksyaszknmkj(pEditKaiyakuTblUpdateBean.getKyksyaszknmkj());
            khShrRireki.setKyksyaszkyno(pEditKaiyakuTblUpdateBean.getKyksyaszkyno());
            khShrRireki.setKyksyaszkadr1kj(pEditKaiyakuTblUpdateBean.getKyksyaszkadr1kj());
            khShrRireki.setKyksyaszkadr2kj(pEditKaiyakuTblUpdateBean.getKyksyaszkadr2kj());
            khShrRireki.setKyksyaszkadr3kj(pEditKaiyakuTblUpdateBean.getKyksyaszkadr3kj());
            khShrRireki.setSaikennmkj(pEditKaiyakuTblUpdateBean.getSaikennmkj());
            khShrRireki.setSaikennyno(pEditKaiyakuTblUpdateBean.getSaikennyno());
            khShrRireki.setSaikenadr1kj(pEditKaiyakuTblUpdateBean.getSaikenadr1kj());
            khShrRireki.setSaikenadr2kj(pEditKaiyakuTblUpdateBean.getSaikenadr2kj());
            khShrRireki.setSaikenadr3kj(pEditKaiyakuTblUpdateBean.getSaikenadr3kj());
            khShrRireki.setInputshrhousiteikbn(pEditKaiyakuTblUpdateBean.getInputshrhousiteikbn());
            khShrRireki.setShrhousiteikbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
            khShrRireki.setKzsyuruikbn(pEditKaiyakuTblUpdateBean.getKzsyuruikbn());
            khShrRireki.setBankcd(pEditKaiyakuTblUpdateBean.getBankcd());
            khShrRireki.setSitencd(pEditKaiyakuTblUpdateBean.getSitencd());
            khShrRireki.setYokinkbn(pEditKaiyakuTblUpdateBean.getYokinkbn());
            khShrRireki.setKouzano(pEditKaiyakuTblUpdateBean.getKouzano());
            khShrRireki.setKzdoukbn(pEditKaiyakuTblUpdateBean.getKzdoukbn());
            khShrRireki.setKzmeiginmkn(pEditKaiyakuTblUpdateBean.getKzmeiginmkn());
            khShrRireki.setKykmnmeigibangou(pEditKaiyakuTblUpdateBean.getKykmnmeigibangou());
            if (C_Kaiyakujiyuu.TUUJYOU.eq(pEditKaiyakuTblUpdateBean.getKaiyakujiyuu())
                || C_Kaiyakujiyuu.SKS.eq(pEditKaiyakuTblUpdateBean.getKaiyakujiyuu())) {
                khShrRireki.setUktmnmeigibangou(pEditKaiyakuTblUpdateBean.getKykmnmeigibangou());
            }
            else if (C_Kaiyakujiyuu.KYKSB.eq(pEditKaiyakuTblUpdateBean.getKaiyakujiyuu())) {
                khShrRireki.setUktmnmeigibangou(pEditKaiyakuTblUpdateBean.getUktmnmeigibangou());
            }
            khShrRireki.setShrtysysyuruikbn(pEditKaiyakuTblUpdateBean.getShrtysysyuruikbn());
            khShrRireki.setDenrenno(denrenNo);
            khShrRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khShrRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khShrRireki.setGyoumuKousinTime(gyoumuKousinTime);
            khShrRireki.setYenshrkykhtykeihi(pEditKaiyakuTblUpdateBean.getYenshrkykhtykeihi());
            khShrRireki.setKykhnkkaisuu(pEditKaiyakuTblUpdateBean.getKykhnkkaisuu());
            khShrRireki.setZitkazukarikingksiteituuka(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr());
            khShrRireki.setZitkazukarikingkyen(pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap());
            khShrRireki.setYensonotahaitoukin(pEditKaiyakuTblUpdateBean.getJpytkbthaitoukin());
            khShrRireki.setYenkrkgk(pEditKaiyakuTblUpdateBean.getJpykariukekin());
            khShrRireki.setGaikashrkwsratekjnymd(pEditKaiyakuTblUpdateBean.getGkshrratetekiymd());
            khShrRireki.setGaikashrkwsrate(pEditKaiyakuTblUpdateBean.getGkshrrate());
            khShrRireki.setYensynykngk(pEditKaiyakuTblUpdateBean.getSynykngk());

            if (C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                if (kykSyouhnSyu.getYendthnkymd() != null) {

                    BizCurrency yendthnkSonotashrgk = pEditKaiyakuTblUpdateBean.getJpyhaitoukin()
                        .add(pEditKaiyakuTblUpdateBean.getJpytkbthaitoukin())
                        .add(pEditKaiyakuTblUpdateBean.getYendthnkhr());

                    khShrRireki.setKaiyakuhrkngkkeisiteituuka(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
                    khShrRireki.setShrtuukakaiyakuhrkngkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
                    khShrRireki.setKaiyakuhrkngkkeiyen(pEditKaiyakuTblUpdateBean.getKaiyakuhryen());
                    khShrRireki.setSonotashrkngksiteituuka(yendthnkSonotashrgk);
                    khShrRireki.setShrtuukasonotashrkngk(yendthnkSonotashrgk);
                    khShrRireki.setSonotashrkngkyen(yendthnkSonotashrgk);

                }
                else {

                    khShrRireki.setKaiyakuhrkngkkeisiteituuka(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukeiyen());
                    khShrRireki.setShrtuukakaiyakuhrkngkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukeiyen());
                    khShrRireki.setKaiyakuhrkngkkeiyen(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukeiyen());
                    khShrRireki.setSonotashrkngksiteituuka(pEditKaiyakuTblUpdateBean.getJpysonotashrgk());
                    khShrRireki.setShrtuukasonotashrkngk(pEditKaiyakuTblUpdateBean.getJpysonotashrgk());
                    khShrRireki.setSonotashrkngkyen(pEditKaiyakuTblUpdateBean.getJpysonotashrgk());

                }
            }
            else {

                khShrRireki.setKaiyakuhrkngkkeisiteituuka(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukei());
                khShrRireki.setKaiyakuhrkngkkeiyen(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukeiyen());
                khShrRireki.setSonotashrkngksiteituuka(pEditKaiyakuTblUpdateBean.getGksonotashrgk());
                khShrRireki.setSonotashrkngkyen(pEditKaiyakuTblUpdateBean.getJpysonotashrgk());

                if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu())) {
                    khShrRireki.setShrtuukakaiyakuhrkngkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukeiyen());
                    khShrRireki.setShrtuukasonotashrkngk(pEditKaiyakuTblUpdateBean.getJpysonotashrgk());
                }
                else {
                    khShrRireki.setShrtuukakaiyakuhrkngkkei(pEditKaiyakuTblUpdateBean.getKaiyakuhrgoukei());
                    khShrRireki.setShrtuukasonotashrkngk(pEditKaiyakuTblUpdateBean.getGksonotashrgk());
                }
            }

            if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKhozenCommonParam.getFunctionId())) {
                khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.HUYOU);
            }
            else {
                if (C_NaiteiKakuteiKbn.NAITEI.eq(pEditKaiyakuTblUpdateBean.getNaiteikakuteikbn()) &&
                    !C_HtsiryosyuKbn.BLNK.eq(pEditKaiyakuTblUpdateBean.getShrtysysyuruikbn())) {
                    khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.YOU);
                }
                else {
                    khShrRireki.setShrtysykurikosiyouhi(C_YouhiKbn.HUYOU);
                }
            }

            BizPropertyInitializer.initialize(khShrRireki);

            IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.createKhShrRirekiDetail();

            khShrRirekiDetail.setSyouhncd(kykSyouhnSyu.getSyouhncd());
            khShrRirekiDetail.setSyouhnsdno(kykSyouhnSyu.getSyouhnsdno());
            khShrRirekiDetail.setKyksyouhnrenno(kykSyouhnSyu.getKyksyouhnrenno());
            khShrRirekiDetail.setSyushrgk(pEditKaiyakuTblUpdateBean.getKaiyakuhr());
            khShrRirekiDetail.setShrtstmttkin(pEditKaiyakuTblUpdateBean.getKiykhrsyousaiptumitatekin());
            khShrRirekiDetail.setSjkkktyouseigk(pEditKaiyakuTblUpdateBean.getKiykhrsyousaisjkkktyouseigk());
            khShrRirekiDetail.setKaiyakusjkkktyouseiritu(pEditKaiyakuTblUpdateBean.getSjkkktyouseiritu());
            khShrRirekiDetail.setKaiyakusjkkktyouseiriritu(pEditKaiyakuTblUpdateBean.getKaiyakusjkkktyouseiriritu());
            khShrRirekiDetail.setKaiyakukjgk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getKaiyakukjgk()));
            khShrRirekiDetail.setKaiyakukoujyoritu(pEditKaiyakuTblUpdateBean.getKaiyakukoujyoritu());
            khShrRirekiDetail.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khShrRirekiDetail.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khShrRirekiDetail.setGyoumuKousinTime(gyoumuKousinTime);
            khShrRirekiDetail.setTeiritutmttkngk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getTeiritutmttkngk()));
            khShrRirekiDetail.setSisuurendoutmttkngk(doKingakuHenkan(pEditKaiyakuTblUpdateBean.getSisuurendoutmttkngk()));

            BizPropertyInitializer.initialize(khShrRirekiDetail);
        }

        if (pEditKaiyakuTblUpdateBean.getYendthnkhr().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getYendthnkhr().getType())) > 0) {

            IT_KhHenreikin khHenreikin = editKaiyakuTblUpdateDao.getKhHenreikinYendtMbrsBySyono(kykKihonTemp).get(0);

            khHenreikin.setShrymd(pEditKaiyakuTblUpdateBean.getShrymd());
            khHenreikin.setShrsyoriymd(pSyoriYmd);
            khHenreikin.setHrsiharaijyoutaikbn(C_Siharaijyoutaikbn.SIHARAIZUMI);
            khHenreikin.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            khHenreikin.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            khHenreikin.setGyoumuKousinTime(gyoumuKousinTime);
        }

        if (pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkkaiyakuhr().getType())) > 0
            || pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap().compareTo(
                BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getAzukarikinkykhnkmikeikap().getType())) > 0) {

            List<IT_Azukarikin> azukarikinLst = editKaiyakuTblUpdateDao.getAzukarikinsBySyono(kykKihonTemp);

            for (IT_Azukarikin azukarikin : azukarikinLst) {
                azukarikin.setShrymd(commonSiwakeOutBean.getDenyMd());
                azukarikin.setShrsyoriymd(pSyoriYmd);
                azukarikin.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                azukarikin.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                azukarikin.setGyoumuKousinTime(gyoumuKousinTime);
            }
        }

        if (pEditKaiyakuTblUpdateBean.getJpykariukekin().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getJpykariukekin().getType())) > 0) {

            List<IT_Kariukekin> kariukekinLst = editKaiyakuTblUpdateDao.getKariukekinsBySyono(kykKihonTemp);

            for (IT_Kariukekin kariukekin : kariukekinLst) {
                kariukekin.setSeisandenymd(commonSiwakeOutBean.getDenyMd());
                kariukekin.setKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
                kariukekin.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                kariukekin.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                kariukekin.setGyoumuKousinTime(gyoumuKousinTime);
            }
        }

        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);

        int nyknKaisuuY = 0;
        int nyknKaisuuM = 0;
        C_TsrysyoriKbn tsrysyoriKbn;

        if ((pEditKaiyakuTblUpdateBean.getJpymikeikap().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getJpymikeikap().getType())) > 0) ||
            (pEditKaiyakuTblUpdateBean.getMikeikap().compareTo(
                BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getMikeikap().getType())) > 0)) {

            nyknKaisuuY = pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuuy();
            nyknKaisuuM = pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuum();
        }

        BizCurrency mikeikap = null;

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn ||
            C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
            mikeikap = pEditKaiyakuTblUpdateBean.getJpymikeikap();
        }
        else {
            mikeikap = pEditKaiyakuTblUpdateBean.getMikeikap();
        }

        if (C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhnSyu.getSyoumetujiyuu())) {
            tsrysyoriKbn = C_TsrysyoriKbn.KAIYAKU;
        }
        else {
            tsrysyoriKbn = C_TsrysyoriKbn.SIKKOU;
        }

        editDairitenTesuuryouTbl.exec(pKhozenCommonParam, pEditKaiyakuTblUpdateBean.getSyono(), tsrysyoriKbn,
            null, nyknKaisuuY, nyknKaisuuM, mikeikap,
            BizCurrency.valueOf(0, syuKyktuukaType), pBakKykKihon);

        if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnSyu.getKykjyoutai())) {

            ansyuKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            ansyuKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            ansyuKihon.setGyoumuKousinTime(gyoumuKousinTime);
            BizDateYM zennouseisankgkStartYmd = pEditKaiyakuTblUpdateBean.getLastPJyuutouYm().addYears(1);

            if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(),
                zennouseisankgkStartYmd) == BizDateUtil.COMPARE_GREATER) {
                KykHenkoujiZnnJytTrksKsn kykHenkoujiZnnJytTrksKsn = SWAKInjector.getInstance(KykHenkoujiZnnJytTrksKsn.class);

                kykHenkoujiZnnJytTrksKsn.exec(pKhozenCommonParam, pEditKaiyakuTblUpdateBean.getSyono(), pSyoriYmd,
                    zennouseisankgkStartYmd, C_ZennouSeisanSyoriKbn.SYOUMETU);
            }

            for (IT_Zennou zennouTemp : zennouLst) {

                zennouTemp.setZennouseisankbn(C_ZennouSeisanKbn.SEISANZUMI);
                zennouTemp.setZennouseisansyoriymd(pSyoriYmd);
                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  == syohinHanteiKbn ||
                    C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                    zennouTemp.setZennouseisankgk(pEditKaiyakuTblUpdateBean.getJpyzennouseisankgk());
                }
                else {
                    zennouTemp.setZennouseisankgk(pEditKaiyakuTblUpdateBean.getZennouseisankgk());
                }
                zennouTemp.setZennouseisankijyunymd(pEditKaiyakuTblUpdateBean.getKaiykymd());
                if ((pEditKaiyakuTblUpdateBean.getJpymikeikap().compareTo(
                    BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getJpymikeikap().getType())) > 0) ||
                    (pEditKaiyakuTblUpdateBean.getMikeikap().compareTo(
                        BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getMikeikap().getType())) > 0)) {
                    zennouTemp.setZennouseisandenymd(commonSiwakeOutBean.getDenyMd());
                }
                zennouTemp.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                zennouTemp.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                zennouTemp.setGyoumuKousinTime(gyoumuKousinTime);
            }
        }

        if ((pEditKaiyakuTblUpdateBean.getJpymikeikap().compareTo(
            BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getJpymikeikap().getType())) > 0) ||
            (pEditKaiyakuTblUpdateBean.getMikeikap().compareTo(
                BizCurrency.valueOf(0, pEditKaiyakuTblUpdateBean.getMikeikap().getType())) > 0)) {

            Integer renNo = hozenDomManager.getKihrkmpSeisanRirekiMaxRennoBySyono(pEditKaiyakuTblUpdateBean.getSyono());

            if (renNo != null) {

                renNo = renNo + 1;
            }
            else {

                renNo = 1;
            }

            IT_KihrkmpSeisanRireki kihrkmpSeisanRireki = kykKihonTemp.createKihrkmpSeisanRireki();
            kihrkmpSeisanRireki.setRenno(renNo);
            kihrkmpSeisanRireki.setHenkousikibetukey(henkousikibetukey);
            kihrkmpSeisanRireki.setKouryokuhasseiymd(pEditKaiyakuTblUpdateBean.getKaiykymd());
            kihrkmpSeisanRireki.setKihrkpssnaiyoukbn(C_KiharaiPseisanNaiyouKbn.SEISANP);
            kihrkmpSeisanRireki.setJyuutouym(pEditKaiyakuTblUpdateBean.getMikeikapjyutouym());
            kihrkmpSeisanRireki.setSeijyutoukaisuum(pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuum());
            kihrkmpSeisanRireki.setSeijyutoukaisuuy(pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuuy());
            kihrkmpSeisanRireki.setMisyuumikeikakbn(C_MisyuumikeikaKbn.MIKEIKAP);

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn) {
                kihrkmpSeisanRireki.setRstuukasyu(kykSyouhnSyu.getKyktuukasyu());
            }

            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN  == syohinHanteiKbn &&
                !C_Tuukasyu.JPY.eq(kykSyouhnSyu.getKyktuukasyu())) {
                if (C_UmuKbn.ARI.eq(pEditKaiyakuTblUpdateBean.getYenshrtkumu())) {
                    kihrkmpSeisanRireki.setZeimukwsratekjnymd(pEditKaiyakuTblUpdateBean.getYenshrratetekiymd());
                    kihrkmpSeisanRireki.setZeimukwsrate(pEditKaiyakuTblUpdateBean.getYenshrrate());
                }
                else {
                    kihrkmpSeisanRireki.setZeimukwsratekjnymd(pEditKaiyakuTblUpdateBean.getZeimukwsratekjnymd());
                    kihrkmpSeisanRireki.setZeimukwsrate(pEditKaiyakuTblUpdateBean.getZeimukwsrate());
                }
            }

            kihrkmpSeisanRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            kihrkmpSeisanRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            kihrkmpSeisanRireki.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(kihrkmpSeisanRireki);

            EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);
            List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
            kykSyouhnCommonParamList.addAll(kykSyouhnList);

            if (C_Kykjyoutai.ZENNOU.eq(kykSyouhnSyu.getKykjyoutai())) {

                ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector
                    .getInstance(ZennouKoujyogakuKeisanParam.class);

                zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
                zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
                zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
                zennouKoujyogakuKeisanParam.setHrkp(pKykKihon.getHrkp());
                zennouKoujyogakuKeisanParam.setHrkkaisuu(pKykKihon.getHrkkaisuu());
                zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
                zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());
                zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());

                editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
            }
            editKoujyonaiyouTbl.setCalcKjnYmd(pEditKaiyakuTblUpdateBean.getKaiykymd());
            editKoujyonaiyouTbl.setHenmaeJkipJytYm(ansyuKihon.getJkipjytym());
            editKoujyonaiyouTbl.setHenmaeHenkousikibetukey(henkousikibetukey);
            editKoujyonaiyouTbl.setKihrkpSeisanRenno(renNo);
            editKoujyonaiyouTbl.setKihrkpSeisanJytYm(pEditKaiyakuTblUpdateBean.getMikeikapjyutouym());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuY(pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuuy());
            editKoujyonaiyouTbl.setKihrkpSeisanJytKaisuuM(pEditKaiyakuTblUpdateBean.getMikeikapjyutoukaisuum());
            editKoujyonaiyouTbl.setMkkp(pEditKaiyakuTblUpdateBean.getMikeikap());
            if (C_Tuukasyu.JPY.eq(pEditKaiyakuTblUpdateBean.getShrtuukasyu())) {
                editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(pEditKaiyakuTblUpdateBean.getYenshrrate());
            }
            else {
                editKoujyonaiyouTbl.setSeisanjiYenkansanKwsrate(pEditKaiyakuTblUpdateBean.getZeimukwsrate());
            }
            editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParamList);

            editKoujyonaiyouTbl.exec(pKhozenCommonParam, pEditKaiyakuTblUpdateBean.getSyono(),
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU, pSyoriYmd);
        }

        SetKhDshrTukiKykInfo setKhDshrTukiKykInfo = SWAKInjector.getInstance(SetKhDshrTukiKykInfo.class);
        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(kykKihonTemp, pKhozenCommonParam,
            pEditKaiyakuTblUpdateBean.getShrymd(), pSyoriYmd);

        editDshrTukiTanKoumokuBean.setHenkousikibetuKey(henkousikibetukey);
        editDshrTukiTanKoumokuBean.setSiharaid(pEditKaiyakuTblUpdateBean.getJpyhaitoukin());

        SrDshrTukiDataSks srDshrTukiDataSks = SWAKInjector.getInstance(SrDshrTukiDataSks.class);
        IT_KhDshrTuki khDshrTuki = srDshrTukiDataSks.execKhKsnAri(editDshrTukiTanKoumokuBean, pEditKaiyakuTblUpdateBean.getEditDshrTukiDKoumokuBean());

        SikinIdouRirekiDataBean sikinIdouRirekiDataBean = SWAKInjector.getInstance(SikinIdouRirekiDataBean.class);

        sikinIdouRirekiDataBean.setSyoriYmd(pSyoriYmd);
        sikinIdouRirekiDataBean.setSyono(pEditKaiyakuTblUpdateBean.getSyono());
        sikinIdouRirekiDataBean.setHenkouSikibetuKey(henkousikibetukey);
        sikinIdouRirekiDataBean.setTargetKinouId(pKhozenCommonParam.getFunctionId());
        sikinIdouRirekiDataBean.setNykshrKbn(C_NykshrKbn.SIHARAI);
        sikinIdouRirekiDataBean.setSyoricd(commonSiwakeOutBean.getSyoriCd());
        sikinIdouRirekiDataBean.setDensysKbn(commonSiwakeOutBean.getDensysKbn());
        sikinIdouRirekiDataBean.setDenrenno(denrenNo);
        sikinIdouRirekiDataBean.setSeg1cd(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd());
        sikinIdouRirekiDataBean.setKykTuukasyu(kykSyouhnSyu.getKyktuukasyu());
        sikinIdouRirekiDataBean.setSyutkKbn(C_SyutkKbn.SYU);
        sikinIdouRirekiDataBean.setHrkkaisuu(kykKihonTemp.getHrkkaisuu());
        sikinIdouRirekiDataBean.setSyouhnCd(kykSyouhnSyu.getSyouhncd());
        sikinIdouRirekiDataBean.setSyouhnSdno(kykSyouhnSyu.getSyouhnsdno());
        sikinIdouRirekiDataBean.setKykSyouhnRenno(kykSyouhnSyu.getKyksyouhnrenno());
        sikinIdouRirekiDataBean.setShrhousiteiKbn(pEditKaiyakuTblUpdateBean.getShrhousiteikbn());
        sikinIdouRirekiDataBean.setKykYmd(kykSyouhnSyu.getKykymd());
        sikinIdouRirekiDataBean.setSeirituYmd(kykKihonTemp.getSeirituymd());
        sikinIdouRirekiDataBean.setSyoumetuYmd(pEditKaiyakuTblUpdateBean.getKaiykymd());
        if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKhozenCommonParam.getFunctionId())) {
            sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
        }
        else {
            sikinIdouRirekiDataBean.setShrsyoriKbn(C_ShrsyoriKbn.KAIYAKU);
        }
        if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pKhozenCommonParam.getFunctionId())) {
            sikinIdouRirekiDataBean.setSyoumetuJiyuu(C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM);
        }
        else if (C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhnSyu.getSyoumetujiyuu())) {
            sikinIdouRirekiDataBean.setSyoumetuJiyuu(C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM);
        }
        else {
            sikinIdouRirekiDataBean.setSyoumetuJiyuu(C_Syoumetujiyuu.KAIYAKU);
        }

        BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);

        BT_SikinIdouRireki sikinIdouRireki = bzSikinIdouRirekiTblSakusei.editSikinIdouRirekiTblEntity(sikinIdouRirekiDataBean);

        Long lincKanyuusyaNo = null;

        IT_KhLincKihon khLincKihon = kykKihonTemp.getKhLincKihon();

        if (khLincKihon != null) {
            lincKanyuusyaNo = khLincKihon.getLinckanyuusyano();
        }

        HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);

        hanteiLincBean.setSyoriYmd(pSyoriYmd);
        hanteiLincBean.setBakKykKihon(pBakKykKihon);
        hanteiLincBean.setKykKihon(kykKihonTemp);
        hanteiLincBean.setKanyuusyaNo(lincKanyuusyaNo);

        HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);

        hanteiLinc.exec(hanteiLincBean, pKhozenCommonParam);

        khDshrTukiData = khDshrTuki;

        kykKihon = kykKihonTemp;

        ansyuKihonData = ansyuKihon;

        sikinIdouRirekiData = sikinIdouRireki;

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 解約処理テーブル更新値編集 終了");

        return errorKbn;
    }

    public IT_KykKihon getKykKihon() {

        return kykKihon;
    }

    public List<IT_KhDenpyoData> getKhDenpyoDatas() {

        return khDenpyoDatas;
    }

    public IT_KhFBSoukinData getKhFBSoukinData() {

        return khFBSoukinData;
    }

    public IT_KhGaikaFBSoukinData getKhGaikaFBSoukinData() {

        return khGaikaFBSoukinData;
    }

    public IT_AnsyuKihon getAnsyuKihon() {

        return ansyuKihonData;
    }

    public IT_KhDshrTuki getKhDshrTuki() {

        return khDshrTukiData;
    }

    public BT_SikinIdouRireki getSikinIdouRireki() {

        return sikinIdouRirekiData;
    }

    private BizCurrency doKingakuHenkan(BizCurrency pHenkanZenGk) {

        if (pHenkanZenGk.isOptional()) {
            return BizCurrency.valueOf(0, pHenkanZenGk.getType());
        }
        return pHenkanZenGk;
    }

}
