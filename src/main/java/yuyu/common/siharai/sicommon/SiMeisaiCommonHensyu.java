package yuyu.common.siharai.sicommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 支払明細書共通編集
 */
public class SiMeisaiCommonHensyu {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private List<SiMeisaiCommonHensyuResultBean> siMeisaiCommonHensyuResultBeanLst;

    private List<SiMeisaiCommonHensyuResultBean>[] sisansyoHensyuResult;

    private boolean shrdtlsyoHanteiFlg;

    private C_KanryotuutioutKbn kanryoTuutioutKbn;

    private JM_SiSyouhnZokusei siSyouhnZokusei;

    private static final String KNSN_GAIKAGK = "knsn_gaikagk";

    private static final String KNSN_HAITOUKIN = "knsn_haitoukin";

    private static final String KNSN_HOKENRYOU = "knsn_hokenryou";

    private static final String KNSN_AZUKARIKINGK = "knsn_azukarikingk";

    private static final String KNSN_SONOTASEISAN = "knsn_sonotaseisan";

    private static final String[] KNSNINFOHUYOMOJI = {"（Ａ）","（Ｂ）","（Ｃ）","（Ｄ）"};

    private static final String KNSNINFOHUGO_PURASU = "＋";

    private static final String KNSNINFOHUGO_MINUS = "－";

    private static final String SAKAKKO = "（";

    private static final String MIGIKAKKO = "）";

    private static final String SSHKINFOPREFIX = "【差引金額";

    private static final String SSHKINFOSAFIX = "】";

    private static final Integer RENDOUSHRKNGKMEISAIHUGOU_SEI = 0;

    private static final Integer RENDOUSHRKNGKMEISAIHUGOU_HU = 1;

    private static final String HANKAKUSPACE = " ";

    private static final String ZENKAKUSPACE  = "　";

    public SiMeisaiCommonHensyu() {
        super();
    }

    public C_ErrorKbn siMeisaiHensyu(JT_Sk pJtSk, List<JT_SiDetail> pSiDetailLst, BizDate pSibouYmd,
        C_KanryotuutioutKbn pKanryoTuutioutKbn) {

        if (pJtSk == null || pSiDetailLst == null || pSiDetailLst.size() == 0 || pSibouYmd == null
            || pKanryoTuutioutKbn == null) {

            return C_ErrorKbn.ERROR;

        }

        shrdtlsyoHanteiFlg = true;

        kanryoTuutioutKbn = pKanryoTuutioutKbn;

        SiMeisaiCommonHensyuBean siMeisaiCommonHensyuBean = new SiMeisaiCommonHensyuBean();

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        HasuuMsyPHensyu hasuuMsyPHensyu = SWAKInjector.getInstance(HasuuMsyPHensyu.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(pJtSk.getMisyuupjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(pJtSk.getMisyuupjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(pJtSk.getMisyuupjyuutouym());
        hasuuMsyPHensyuBean.setMisyuup(pJtSk.getMisyuup());
        hasuuMsyPHensyuBean.setYenkamisyuup(pJtSk.getYenkamisyuup());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(pJtSk.getMikeikapjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(pJtSk.getMikeikapjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(pJtSk.getMikeikapjyuutouym());
        hasuuMsyPHensyuBean.setMikeikap(pJtSk.getMikeikap());
        hasuuMsyPHensyuBean.setYenkamikeikap(pJtSk.getYenkamikeikap());
        hasuuMsyPHensyuBean.setKyktuukasyu(pJtSk.getKyktuukasyu());
        hasuuMsyPHensyuBean.setKwsrate(pJtSk.getShrkwsrate());

        hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        siMeisaiCommonHensyuBean.setKykTuukaSyu(pJtSk.getKyktuukasyu());
        siMeisaiCommonHensyuBean.setKnsnKijyunYmd(pJtSk.getShrkwsratekjnymd());
        siMeisaiCommonHensyuBean.setKawaseRate(pJtSk.getShrkwsrate());
        siMeisaiCommonHensyuBean.setGaikaKnsnKwsRate(pJtSk.getGaikaknsnkwsrate());
        siMeisaiCommonHensyuBean.setSibouYmd(pSibouYmd);
        siMeisaiCommonHensyuBean.setHokenKngk(null);
        siMeisaiCommonHensyuBean.setYenHokenKngk(null);
        siMeisaiCommonHensyuBean.setHaitouKin(pJtSk.getHaitoukin());
        siMeisaiCommonHensyuBean.setYenkaHaitouKin(pJtSk.getYenkahaitoukin());
        siMeisaiCommonHensyuBean.setSonotaHaitouKin(pJtSk.getSonotahaitoukin());
        siMeisaiCommonHensyuBean.setYenkaSonotaHaitouKin(pJtSk.getYenkasonotahaitoukin());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouKaisuuY(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouKaisuuM(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouYm(hasuuMsyPHensyu.getMisyuupjyuutouym());
        siMeisaiCommonHensyuBean.setMisyuuP(hasuuMsyPHensyu.getMisyuup());
        siMeisaiCommonHensyuBean.setYenkaMisyuuP(hasuuMsyPHensyu.getYenkamisyuup());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouKaisuuY(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouKaisuuM(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouYm(hasuuMsyPHensyu.getMikeikapjyuutouym());
        siMeisaiCommonHensyuBean.setMikeikaP(hasuuMsyPHensyu.getMikeikap());
        siMeisaiCommonHensyuBean.setYenkaMikeikaP(hasuuMsyPHensyu.getYenkamikeikap());
        siMeisaiCommonHensyuBean.setZennouSeisankGk(pJtSk.getZennouseisankgk());
        siMeisaiCommonHensyuBean.setYenkaZennouSeisankGk(pJtSk.getYenkazennouseisankgk());
        siMeisaiCommonHensyuBean.setZitkazukaRikinGkSiteiTuuka(pJtSk.getZitkazukarikingksiteituuka());
        siMeisaiCommonHensyuBean.setZitkazukaRikinGkYen(pJtSk.getZitkazukarikingkyen());
        siMeisaiCommonHensyuBean.setKrkGk(pJtSk.getKrkgk());
        siMeisaiCommonHensyuBean.setYenkaKrkGk(pJtSk.getYenkakrkgk());
        siMeisaiCommonHensyuBean.setTienRsk(pJtSk.getShrtienrsk());
        siMeisaiCommonHensyuBean.setYenTienRsk(pJtSk.getYenshrtienrsk());
        siMeisaiCommonHensyuBean.setSinsaGendokKnKbn(pJtSk.getSinsagendokknkbn());
        siMeisaiCommonHensyuBean.setTienRskNissuu(pJtSk.getTienrsknissuu());
        siMeisaiCommonHensyuBean.setGaikaKnsntkGk(pJtSk.getGaikaknsntkgk());
        siMeisaiCommonHensyuBean.setGaikaKnsnKekkaGk(pJtSk.getGaikaknsnkekkakgk());
        siMeisaiCommonHensyuBean.setYenkaKnsntkGk(pJtSk.getYenkaknsntkgk());
        siMeisaiCommonHensyuBean.setYenkaKnsnKekkaGk(pJtSk.getYenkaknsnkekkakgk());

        siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(pSiDetailLst.get(0).getSyouhncd());

        if (C_Tuukasyu.JPY.eq(pJtSk.getShrtuukasyu())) {

            siMeisaiCommonHensyuResultBeanLst = yenhrkDetailCommonHensyu(siMeisaiCommonHensyuBean, pSiDetailLst, null);
        }
        else {

            siMeisaiCommonHensyuResultBeanLst = gaikaHrkDetailCommonHensyu(siMeisaiCommonHensyuBean, pSiDetailLst, null);
        }

        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn sisansyoHensyu(SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean,
        List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {


        if (pSiHkkingakuSisanParamBean == null || pSiSiDetailParamBeanLst == null
            || pSiSiDetailParamBeanLst.size() == 0) {
            return C_ErrorKbn.ERROR;
        }

        shrdtlsyoHanteiFlg = false;

        SiMeisaiCommonHensyuBean siMeisaiCommonHensyuBean = new SiMeisaiCommonHensyuBean();

        HasuuMsyPHensyuBean hasuuMsyPHensyuBean = SWAKInjector.getInstance(HasuuMsyPHensyuBean.class);

        HasuuMsyPHensyu hasuuMsyPHensyu = SWAKInjector.getInstance(HasuuMsyPHensyu.class);

        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuuy(pSiHkkingakuSisanParamBean.getMisyuupjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMisyuupjyuutoukaisuum(pSiHkkingakuSisanParamBean.getMisyuupjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMisyuupjyuutouym(pSiHkkingakuSisanParamBean.getMisyuupjyuutouym());
        hasuuMsyPHensyuBean.setMisyuup(pSiHkkingakuSisanParamBean.getBunkatugomisyuup());
        hasuuMsyPHensyuBean.setYenkamisyuup(pSiHkkingakuSisanParamBean.getBunkatugoyenkamisyuup());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuuy(pSiHkkingakuSisanParamBean.getMikeikapjyuutoukaisuuy());
        hasuuMsyPHensyuBean.setMikeikapjyuutoukaisuum(pSiHkkingakuSisanParamBean.getMikeikapjyuutoukaisuum());
        hasuuMsyPHensyuBean.setMikeikapjyuutouym(pSiHkkingakuSisanParamBean.getMikeikapjyuutouym());
        hasuuMsyPHensyuBean.setMikeikap(pSiHkkingakuSisanParamBean.getBunkatugomikeikap());
        hasuuMsyPHensyuBean.setYenkamikeikap(pSiHkkingakuSisanParamBean.getBunkatugoyenkamikeikap());
        hasuuMsyPHensyuBean.setKyktuukasyu(pSiHkkingakuSisanParamBean.getKykTuukasyu());
        hasuuMsyPHensyuBean.setKwsrate(pSiHkkingakuSisanParamBean.getKawaseRate());

        hasuuMsyPHensyu.exec(hasuuMsyPHensyuBean);

        siMeisaiCommonHensyuBean.setKykTuukaSyu(pSiHkkingakuSisanParamBean.getKykTuukasyu());
        siMeisaiCommonHensyuBean.setKnsnKijyunYmd(pSiHkkingakuSisanParamBean.getKnsnKijyunYmd());
        siMeisaiCommonHensyuBean.setKawaseRate(pSiHkkingakuSisanParamBean.getKawaseRate());
        siMeisaiCommonHensyuBean.setGaikaKnsnKwsRate(pSiHkkingakuSisanParamBean.getGaikaknsnkwsrate());
        siMeisaiCommonHensyuBean.setSibouYmd(null);
        siMeisaiCommonHensyuBean.setHokenKngk(pSiHkkingakuSisanParamBean.getBunkatugoHokenKngk());
        siMeisaiCommonHensyuBean.setYenHokenKngk(pSiHkkingakuSisanParamBean.getBunkatugoYenHokenKngk());
        siMeisaiCommonHensyuBean.setHaitouKin(pSiHkkingakuSisanParamBean.getBunkatugohaitoukin());
        siMeisaiCommonHensyuBean.setYenkaHaitouKin(pSiHkkingakuSisanParamBean.getBunkatugoyenkahaitoukin());
        siMeisaiCommonHensyuBean.setSonotaHaitouKin(pSiHkkingakuSisanParamBean.getBunkatugosonotahaitoukin());
        siMeisaiCommonHensyuBean.setYenkaSonotaHaitouKin(pSiHkkingakuSisanParamBean.getBunkatugoyenkasonotahaitoukin());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouKaisuuY(hasuuMsyPHensyu.getMisyuupjyuutoukaisuuy());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouKaisuuM(hasuuMsyPHensyu.getMisyuupjyuutoukaisuum());
        siMeisaiCommonHensyuBean.setMisyuupJyuutouYm(hasuuMsyPHensyu.getMisyuupjyuutouym());
        siMeisaiCommonHensyuBean.setMisyuuP(hasuuMsyPHensyu.getMisyuup());
        siMeisaiCommonHensyuBean.setYenkaMisyuuP(hasuuMsyPHensyu.getYenkamisyuup());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouKaisuuY(hasuuMsyPHensyu.getMikeikapjyuutoukaisuuy());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouKaisuuM(hasuuMsyPHensyu.getMikeikapjyuutoukaisuum());
        siMeisaiCommonHensyuBean.setMikeikapJyuutouYm(hasuuMsyPHensyu.getMikeikapjyuutouym());
        siMeisaiCommonHensyuBean.setMikeikaP(hasuuMsyPHensyu.getMikeikap());
        siMeisaiCommonHensyuBean.setYenkaMikeikaP(hasuuMsyPHensyu.getYenkamikeikap());
        siMeisaiCommonHensyuBean.setZennouSeisankGk(pSiHkkingakuSisanParamBean.getBunkatugozennouseisank());
        siMeisaiCommonHensyuBean.setYenkaZennouSeisankGk(pSiHkkingakuSisanParamBean.getBunkatugoyenkazennouseisank());
        siMeisaiCommonHensyuBean.setZitkazukaRikinGkSiteiTuuka(pSiHkkingakuSisanParamBean.getBunkatugoZitkazukarikingksiteituuka());
        siMeisaiCommonHensyuBean.setZitkazukaRikinGkYen(pSiHkkingakuSisanParamBean.getBunkatugoZitkazukarikingkyen());
        siMeisaiCommonHensyuBean.setKrkGk(pSiHkkingakuSisanParamBean.getBunkatugokrkgk());
        siMeisaiCommonHensyuBean.setYenkaKrkGk(pSiHkkingakuSisanParamBean.getBunkatugoyenkakrkgk());
        siMeisaiCommonHensyuBean.setTienRsk(null);
        siMeisaiCommonHensyuBean.setYenTienRsk(null);
        siMeisaiCommonHensyuBean.setSinsaGendokKnKbn(null);
        siMeisaiCommonHensyuBean.setTienRskNissuu(null);
        siMeisaiCommonHensyuBean.setGaikaKnsntkGk(pSiHkkingakuSisanParamBean.getBunkatugoGaikaknsntskgk());
        siMeisaiCommonHensyuBean.setGaikaKnsnKekkaGk(pSiHkkingakuSisanParamBean.getBunkatugoGaikaknsnkkkgk());
        siMeisaiCommonHensyuBean.setYenkaKnsntkGk(pSiHkkingakuSisanParamBean.getBunkatugoYenkaknsntskgk());
        siMeisaiCommonHensyuBean.setYenkaKnsnKekkaGk(pSiHkkingakuSisanParamBean.getBunkatugoYenkaknsnkkkgk());

        siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokuseisBySyouhncd(pSiSiDetailParamBeanLst.get(0).getSyouhncd());

        List<SiMeisaiCommonHensyuResultBean> sisansyoSiteituukaHensyuKekka = new ArrayList<>();

        if (!C_Tuukasyu.JPY.eq(siMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            sisansyoSiteituukaHensyuKekka = gaikaHrkDetailCommonHensyu(siMeisaiCommonHensyuBean, null,
                pSiSiDetailParamBeanLst);
        }

        List<SiMeisaiCommonHensyuResultBean> sisansyoYenHensyuKekka = yenhrkDetailCommonHensyu(
            siMeisaiCommonHensyuBean, null, pSiSiDetailParamBeanLst);

        if (!C_Tuukasyu.JPY.eq(siMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            sisansyoHensyuResult = new ArrayList[2];
            sisansyoHensyuResult[0] = sisansyoSiteituukaHensyuKekka;
            sisansyoHensyuResult[1] = sisansyoYenHensyuKekka;
        }
        else {

            sisansyoHensyuResult = new ArrayList[1];
            sisansyoHensyuResult[0] = sisansyoYenHensyuKekka;
        }

        return C_ErrorKbn.OK;
    }

    public List<SiMeisaiCommonHensyuResultBean> getSiMeisaiHensyuResult() {

        return siMeisaiCommonHensyuResultBeanLst;
    }

    public List<SiMeisaiCommonHensyuResultBean>[] getSisansyoHensyuResult() {

        return sisansyoHensyuResult;
    }

    private List<SiMeisaiCommonHensyuResultBean> gaikaHrkDetailCommonHensyu(SiMeisaiCommonHensyuBean pSiMeisaiCommonHensyuBean,
        List<JT_SiDetail> pSiDetailLst, List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {

        List<SiMeisaiCommonHensyuResultBean> wkSiMeisaiCommonHensyuResultBeanLst = new ArrayList<>();

        if (shrdtlsyoHanteiFlg) {

            for (int idx = 0; idx < pSiDetailLst.size(); idx++){

                JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(pSiDetailLst.get(idx).getKyuuhucd());
                String kyuuHuName = kyuuhu.getKyuuhunamegamen();

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBean = new SiMeisaiCommonHensyuResultBean();

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBean.setTekiYou(kyuuHuName);
                    siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiDetailLst.get(idx).getKyhkg());
                    siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(
                        Long.parseLong(pSiDetailLst.get(idx).getKyhkg().multiply(100).toString()));
                    siMeisaiCommonHensyuResultBean.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
                    siMeisaiCommonHensyuResultBean.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);
                    siMeisaiCommonHensyuResultBean.setDetailBikou(
                        MessageUtil.getMessage(
                            MessageId.IJC1034,
                            ConvertUtil.toZenAll(
                                DateFormatUtil.dateKANJISeirekiNoZero(pSiMeisaiCommonHensyuBean.getSibouYmd()), 0, 0)));
                }

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBean);

                siMeisaiCommonHensyuResultBean = new SiMeisaiCommonHensyuResultBean();
                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBean);
            }
        }
        else {

            for (int idx = 0; idx < pSiSiDetailParamBeanLst.size(); idx++){

                JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(pSiSiDetailParamBeanLst.get(idx).getKyuuhucd());
                String kyuuHuName = kyuuhu.getKyuuhunamegamen();

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBean = new SiMeisaiCommonHensyuResultBean();

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBean.setTekiYou(kyuuHuName);
                    siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getHokenKngk());
                }

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBean);
            }
        }

        if (pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka().getType())) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanRikinGk = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanRikinGk.setTekiYou(MessageUtil.getMessage(MessageId.IJW1096));
            siMeisaiCommonHensyuResultBeanRikinGk.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka());
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrGkMeisai(
                Long.parseLong(pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka().multiply(100).toString()));
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanRikinGk);
        }

        if (pSiMeisaiCommonHensyuBean.getMisyuuP().compareTo(BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMisyuuP().getType())) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanP = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanP.setTekiYou(MessageUtil.getMessage(MessageId.IJW1097));
            siMeisaiCommonHensyuResultBeanP.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getMisyuuP().multiply(-1));
            siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisai(
                Long.parseLong(pSiMeisaiCommonHensyuBean.getMisyuuP().multiply(100).toString()));
            siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
            siMeisaiCommonHensyuResultBeanP.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_HU);

            siMeisaiCommonHensyuResultBeanP.setDetailBikou(pGaitoukknHensyu(
                pSiMeisaiCommonHensyuBean.getMisyuupJyuutouYm(),
                pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuY(),
                pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuM()));

            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanP);
        }

        if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
            C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
            if (pSiMeisaiCommonHensyuBean.getMikeikaP().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMikeikaP().getType())) > 0 ||
                pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

                if (shrdtlsyoHanteiFlg && count == 1) {

                    wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
                }

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanP = new SiMeisaiCommonHensyuResultBean();
                BizCurrency hokenRyou = pSiMeisaiCommonHensyuBean.getMikeikaP().add(pSiMeisaiCommonHensyuBean.getZennouSeisankGk());

                siMeisaiCommonHensyuResultBeanP.setTekiYou(MessageUtil.getMessage(MessageId.IJW1097));
                siMeisaiCommonHensyuResultBeanP.setShrGkMeisai(hokenRyou);
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisai(Long.parseLong(hokenRyou.multiply(100).toString()));
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
                siMeisaiCommonHensyuResultBeanP.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

                if (pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) == 0) {

                    siMeisaiCommonHensyuResultBeanP.setDetailBikou(pGaitoukknHensyu(
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouYm(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuY(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuM()));
                }
                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanP);
            }
        }

        if (pSiMeisaiCommonHensyuBean.getGaikaKnsnKekkaGk().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getGaikaKnsnKekkaGk().getType())) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanSonota = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanSonota.setTekiYou(MessageUtil.getMessage(MessageId.IJW1100));
            siMeisaiCommonHensyuResultBeanSonota.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getGaikaKnsnKekkaGk());
            siMeisaiCommonHensyuResultBeanSonota.setRendouShrGkMeisai(
                Long.parseLong(pSiMeisaiCommonHensyuBean.getGaikaKnsnKekkaGk().multiply(100).toString()));
            siMeisaiCommonHensyuResultBeanSonota.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
            siMeisaiCommonHensyuResultBeanSonota.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

            List<String> bikouLst = sonotaShrKinBikouHensyu(pSiMeisaiCommonHensyuBean);

            for (int idx = 0; idx < bikouLst.size(); idx++) {

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBeanSonota.setDetailBikou(bikouLst.get(idx));

                    wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanSonota);
                }
                else if (idx > 0) {

                    SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanSonotaBikou = new SiMeisaiCommonHensyuResultBean();

                    siMeisaiCommonHensyuResultBeanSonotaBikou.setDetailBikou(bikouLst.get(idx));

                    wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanSonotaBikou);
                }
            }
        }

        if (shrdtlsyoHanteiFlg) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (pSiMeisaiCommonHensyuBean.getTienRsk().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getTienRsk().getType())) > 0) {

                if (count == 1) {

                    wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
                }

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanRsk = new SiMeisaiCommonHensyuResultBean();

                siMeisaiCommonHensyuResultBeanRsk.setTekiYou(MessageUtil.getMessage(MessageId.IJC1039));
                siMeisaiCommonHensyuResultBeanRsk.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getTienRsk());
                siMeisaiCommonHensyuResultBeanRsk.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getTienRsk().multiply(100).toString()));
                siMeisaiCommonHensyuResultBeanRsk.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
                siMeisaiCommonHensyuResultBeanRsk.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

                siMeisaiCommonHensyuResultBeanRsk.setDetailBikou(MessageUtil.getMessage(MessageId.IJC1040,
                    pSiMeisaiCommonHensyuBean.getSinsaGendokKnKbn().getContent(),
                    ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getTienRskNissuu().toString(), 0, 0)));

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanRsk);

            }
        }

        return wkSiMeisaiCommonHensyuResultBeanLst;
    }

    private List<String> sonotaShrKinBikouHensyu(SiMeisaiCommonHensyuBean pSiMeisaiCommonHensyuBean) {

        List<String> bikouLst = new ArrayList<>();
        List<SiMeisaiCommonHensyuKnsnBean> siMeisaiCommonHensyuKnsnBeanLst = new ArrayList<>();

        if (pSiMeisaiCommonHensyuBean.getHaitouKin().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getHaitouKin().getType())) > 0) {

            SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanHaitoukin = new SiMeisaiCommonHensyuKnsnBean();

            String haitouKin = pSiMeisaiCommonHensyuBean.getYenkaHaitouKin().toFormatString();
            String haitouKinInfo = "";

            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                haitouKinInfo = MessageUtil.getMessage(MessageId.IJC1054, ConvertUtil.toZenAll(haitouKin, 0, 0)
                    + C_Tuukasyu.JPY.getContent());
            }
            else {

                haitouKinInfo = MessageUtil.getMessage(MessageId.IJC1054, haitouKin + HANKAKUSPACE + C_Tuukasyu.JPY.getContent());
            }

            siMeisaiCommonHensyuKnsnBeanHaitoukin.setKnsnInfo(KNSN_HAITOUKIN);
            siMeisaiCommonHensyuKnsnBeanHaitoukin.setBikouOutputInfo(haitouKinInfo);
            siMeisaiCommonHensyuKnsnBeanHaitoukin.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);
            siMeisaiCommonHensyuKnsnBeanHaitoukin.setZennouSeisankGkUmuFlg(false);

            siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanHaitoukin);
        }

        if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
            C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

            if (pSiMeisaiCommonHensyuBean.getMikeikaP().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMikeikaP().getType())) > 0
                || pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanP = new SiMeisaiCommonHensyuKnsnBean();

                BizCurrency hokenRyou = pSiMeisaiCommonHensyuBean.getYenkaMikeikaP().add(
                    pSiMeisaiCommonHensyuBean.getYenkaZennouSeisankGk());
                String hokenRyouInfo = "";

                if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                    hokenRyouInfo = MessageUtil.getMessage(MessageId.IJC1053,
                        ConvertUtil.toZenAll(hokenRyou.toFormatString(), 0, 0) + C_Tuukasyu.JPY.getContent());
                }
                else {

                    hokenRyouInfo = MessageUtil.getMessage(MessageId.IJC1053, hokenRyou.toFormatString() + HANKAKUSPACE
                        + C_Tuukasyu.JPY.getContent());
                }

                siMeisaiCommonHensyuKnsnBeanP.setKnsnInfo(KNSN_HOKENRYOU);
                siMeisaiCommonHensyuKnsnBeanP.setBikouOutputInfo(hokenRyouInfo);
                siMeisaiCommonHensyuKnsnBeanP.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);

                if (pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                    siMeisaiCommonHensyuKnsnBeanP.setZennouSeisankGkUmuFlg(true);
                }
                else {

                    siMeisaiCommonHensyuKnsnBeanP.setZennouSeisankGkUmuFlg(false);
                }

                siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanP);
            }
        }

        if (pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkYen().compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {

            SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanRikinGk = new SiMeisaiCommonHensyuKnsnBean();

            String zitkazukaRikinGkYen = pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkYen().toFormatString();
            String rikinGkInfo = "";

            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                rikinGkInfo = MessageUtil.getMessage(MessageId.IJC1052, ConvertUtil.toZenAll(zitkazukaRikinGkYen, 0, 0)
                    + C_Tuukasyu.JPY.getContent());
            }
            else {

                rikinGkInfo = MessageUtil.getMessage(MessageId.IJC1052, zitkazukaRikinGkYen + HANKAKUSPACE + C_Tuukasyu.JPY.getContent());
            }

            siMeisaiCommonHensyuKnsnBeanRikinGk.setKnsnInfo(KNSN_AZUKARIKINGK);
            siMeisaiCommonHensyuKnsnBeanRikinGk.setBikouOutputInfo(rikinGkInfo);
            siMeisaiCommonHensyuKnsnBeanRikinGk.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);
            siMeisaiCommonHensyuKnsnBeanRikinGk.setZennouSeisankGkUmuFlg(false);

            siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanRikinGk);
        }

        if (pSiMeisaiCommonHensyuBean.getKrkGk().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getKrkGk().getType())) > 0) {

            SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanSonota = new SiMeisaiCommonHensyuKnsnBean();

            String yenKaKrkGk = pSiMeisaiCommonHensyuBean.getYenkaKrkGk().toFormatString();
            String sonotaGkInfo = "";

            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                sonotaGkInfo = MessageUtil.getMessage(MessageId.IJC1055, ConvertUtil.toZenAll(yenKaKrkGk, 0, 0)
                    + C_Tuukasyu.JPY.getContent());
            }
            else {

                sonotaGkInfo = MessageUtil.getMessage(MessageId.IJC1055, yenKaKrkGk + HANKAKUSPACE + C_Tuukasyu.JPY.getContent());
            }

            siMeisaiCommonHensyuKnsnBeanSonota.setKnsnInfo(KNSN_SONOTASEISAN);
            siMeisaiCommonHensyuKnsnBeanSonota.setBikouOutputInfo(sonotaGkInfo);
            siMeisaiCommonHensyuKnsnBeanSonota.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);
            siMeisaiCommonHensyuKnsnBeanSonota.setZennouSeisankGkUmuFlg(false);

            siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanSonota);
        }

        if (siMeisaiCommonHensyuKnsnBeanLst.size() == 1) {

            bikouLst.add(siMeisaiCommonHensyuKnsnBeanLst.get(0).getBikouOutputInfo());

            if (KNSN_HOKENRYOU.equals(siMeisaiCommonHensyuKnsnBeanLst.get(0).getKnsnInfo())
                && !siMeisaiCommonHensyuKnsnBeanLst.get(0).getZennouSeisankGkUmuFlg()) {

                bikouLst.add(pGaitoukknHensyuKakko(pSiMeisaiCommonHensyuBean.getMikeikapJyuutouYm(),
                    pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuY(),
                    pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuM()));
            }
        }
        else if (siMeisaiCommonHensyuKnsnBeanLst.size() > 1) {

            String sshkgkInfo = "";

            for (int idx = 0; idx < siMeisaiCommonHensyuKnsnBeanLst.size(); idx++) {

                bikouLst.add(KNSNINFOHUYOMOJI[idx] + siMeisaiCommonHensyuKnsnBeanLst.get(idx).getBikouOutputInfo());

                if (KNSN_HOKENRYOU.equals(siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfo())
                    && !siMeisaiCommonHensyuKnsnBeanLst.get(idx).getZennouSeisankGkUmuFlg()) {

                    bikouLst.add(pGaitoukknHensyuKakko(pSiMeisaiCommonHensyuBean.getMikeikapJyuutouYm(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuY(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuM()));
                }

                if (idx == 0) {

                    sshkgkInfo = KNSNINFOHUYOMOJI[idx];
                }
                else if (idx > 0) {

                    sshkgkInfo = sshkgkInfo + siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfoHugo() + KNSNINFOHUYOMOJI[idx];
                }
            }

            bikouLst.add(SSHKINFOPREFIX + sshkgkInfo + SSHKINFOSAFIX);

            String sshkGk = "";

            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                sshkGk = ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getGaikaKnsntkGk().toFormatString(), 0, 0)
                    + C_Tuukasyu.JPY.getContent();
            }
            else {

                sshkGk = pSiMeisaiCommonHensyuBean.getGaikaKnsntkGk().toFormatString() + HANKAKUSPACE
                    + C_Tuukasyu.JPY.getContent();
            }

            sshkGk = ZENKAKUSPACE + ZENKAKUSPACE + sshkGk;

            bikouLst.add(sshkGk);
        }

        String kawaseRate = "";
        String kawaseRateInfo = "";

        if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

            kawaseRate = ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getGaikaKnsnKwsRate().toString(), 0, 0);
        }
        else {

            kawaseRate = pSiMeisaiCommonHensyuBean.getGaikaKnsnKwsRate().toString();
        }

        if (C_Tuukasyu.USD.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            kawaseRateInfo = MessageUtil.getMessage(MessageId.IJC1037, kawaseRate);
        }
        else if (C_Tuukasyu.AUD.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            kawaseRateInfo = MessageUtil.getMessage(MessageId.IJC1038, kawaseRate);
        }

        bikouLst.add(kawaseRateInfo);

        String knsnKijyunYmd = ConvertUtil.toZenAll(
            DateFormatUtil.dateKANJISeirekiNoZero(pSiMeisaiCommonHensyuBean.getKnsnKijyunYmd()), 0, 0);

        if (shrdtlsyoHanteiFlg) {

            String knsnKijyunYmdInfo = MessageUtil.getMessage(MessageId.IJC1036, knsnKijyunYmd);

            bikouLst.add(knsnKijyunYmdInfo);
        }

        return bikouLst;
    }

    private List<SiMeisaiCommonHensyuResultBean> yenhrkDetailCommonHensyu(SiMeisaiCommonHensyuBean pSiMeisaiCommonHensyuBean,
        List<JT_SiDetail> pSiDetailLst, List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {

        boolean yenSitiHsyutkTekiUmuFlg = false;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        BizCurrency kyhkg = BizCurrency.valueOf(0,
            henkanTuuka.henkanTuukaKbnToType(pSiMeisaiCommonHensyuBean.getKykTuukaSyu()));

        List<SiMeisaiCommonHensyuResultBean> wkSiMeisaiCommonHensyuResultBeanLst = new ArrayList<>();

        SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBean = new SiMeisaiCommonHensyuResultBean();

        if (shrdtlsyoHanteiFlg) {

            for (int idx = 0; idx < pSiDetailLst.size(); idx++) {

                JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(pSiDetailLst.get(idx).getKyuuhucd());
                String kyuuHuName = kyuuhu.getKyuuhunamegamen();

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBean.setTekiYou(kyuuHuName);
                    siMeisaiCommonHensyuResultBean.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                    siMeisaiCommonHensyuResultBean.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

                    if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                        siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiDetailLst.get(idx).getKyhkg());
                        siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(
                            Long.parseLong(pSiDetailLst.get(idx).getKyhkg().toAdsoluteString()));
                    }
                    else {

                        if (pSiDetailLst.get(idx).getSitihsyutkyumaeyenhknkngk().compareTo(
                            BizCurrency.valueOf(0, pSiDetailLst.get(idx).getSitihsyutkyumaeyenhknkngk().getType())) > 0) {

                            siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiDetailLst.get(idx).getYenkyhgk());
                            siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(
                                Long.parseLong(pSiDetailLst.get(idx).getYenkyhgk().toAdsoluteString()));

                            yenSitiHsyutkTekiUmuFlg = true;
                        }
                        else {

                            siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenkaKnsnKekkaGk());
                            siMeisaiCommonHensyuResultBean.setRendouShrGkMeisai(
                                Long.parseLong(pSiMeisaiCommonHensyuBean.getYenkaKnsnKekkaGk().toAdsoluteString()));
                        }

                        kyhkg = pSiDetailLst.get(idx).getKyhkg();
                    }
                }
            }
        }
        else {

            for (int idx = 0; idx < pSiSiDetailParamBeanLst.size(); idx++) {

                JM_Kyuuhu kyuuhu = siharaiDomManager.getKyuuhu(pSiSiDetailParamBeanLst.get(idx).getKyuuhucd());
                String kyuuHuName = kyuuhu.getKyuuhunamegamen();

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBean.setTekiYou(kyuuHuName);

                    if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                        siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getHokenKngk());
                    }
                    else {

                        if (pSiSiDetailParamBeanLst.get(idx).getSitihsyutkyumaeyenhknkngk().compareTo(
                            BizCurrency.valueOf(0, pSiSiDetailParamBeanLst.get(idx).getSitihsyutkyumaeyenhknkngk().getType())) > 0) {

                            siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenHokenKngk());

                            yenSitiHsyutkTekiUmuFlg = true;
                        }
                        else {

                            siMeisaiCommonHensyuResultBean.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenkaKnsnKekkaGk());
                        }

                        kyhkg = pSiMeisaiCommonHensyuBean.getHokenKngk();
                    }
                }
            }
        }

        List<String> bikouLst = yenShrBikouHensyu(pSiMeisaiCommonHensyuBean, yenSitiHsyutkTekiUmuFlg, kyhkg);

        if (bikouLst.size() == 0) {
            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBean);
        } else {
            for (int idx = 0; idx < bikouLst.size(); idx++) {

                if (idx == 0) {

                    siMeisaiCommonHensyuResultBean.setDetailBikou(bikouLst.get(idx));
                    wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBean);
                }
                else if (idx > 0) {

                    SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanBikou = new SiMeisaiCommonHensyuResultBean();
                    siMeisaiCommonHensyuResultBeanBikou.setDetailBikou(bikouLst.get(idx));
                    wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanBikou);
                }
            }
        }

        if (pSiMeisaiCommonHensyuBean.getHaitouKin().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getHaitouKin().getType())) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanHaitouKin = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanHaitouKin.setTekiYou(MessageUtil.getMessage(MessageId.IJW1098));
            siMeisaiCommonHensyuResultBeanHaitouKin.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
            siMeisaiCommonHensyuResultBeanHaitouKin.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

            if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                siMeisaiCommonHensyuResultBeanHaitouKin.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getHaitouKin());
                siMeisaiCommonHensyuResultBeanHaitouKin.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getHaitouKin().toAdsoluteString()));
            }
            else {

                siMeisaiCommonHensyuResultBeanHaitouKin.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenkaHaitouKin());
                siMeisaiCommonHensyuResultBeanHaitouKin.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getYenkaHaitouKin().toAdsoluteString()));
            }

            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanHaitouKin);
        }

        if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            if (pSiMeisaiCommonHensyuBean.getMisyuuP().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMisyuuP().getType())) > 0) {

                int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

                if (shrdtlsyoHanteiFlg && count == 1) {

                    wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
                }

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanP = new SiMeisaiCommonHensyuResultBean();

                siMeisaiCommonHensyuResultBeanP.setTekiYou(MessageUtil.getMessage(MessageId.IJW1097));
                siMeisaiCommonHensyuResultBeanP.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getMisyuuP().multiply(-1));
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getMisyuuP().multiply(100).toString()));
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisaiTuukasyu(pSiMeisaiCommonHensyuBean.getKykTuukaSyu());
                siMeisaiCommonHensyuResultBeanP.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_HU);

                siMeisaiCommonHensyuResultBeanP.setDetailBikou(pGaitoukknHensyu(
                    pSiMeisaiCommonHensyuBean.getMisyuupJyuutouYm(),
                    pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuY(),
                    pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuM()));

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanP);
            }
        }

        if ((C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
            C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) ||
            C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

            if (pSiMeisaiCommonHensyuBean.getMikeikaP().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMikeikaP().getType())) > 0
                || pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

                if (shrdtlsyoHanteiFlg && count == 1) {

                    wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
                }

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanP = new SiMeisaiCommonHensyuResultBean();

                if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    siMeisaiCommonHensyuResultBeanP.setTekiYou(MessageUtil.getMessage(MessageId.IJW1097));
                }
                else if (C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                    C_SeisankinKanritukaKbn.YENKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {

                    siMeisaiCommonHensyuResultBeanP.setTekiYou(MessageUtil.getMessage(MessageId.IJW1102));
                }
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuResultBeanP.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

                BizCurrency hokenRyou;
                if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                    hokenRyou = pSiMeisaiCommonHensyuBean.getMikeikaP().add(pSiMeisaiCommonHensyuBean.getZennouSeisankGk());
                }
                else {

                    hokenRyou = pSiMeisaiCommonHensyuBean.getYenkaMikeikaP().add(
                        pSiMeisaiCommonHensyuBean.getYenkaZennouSeisankGk());
                }

                siMeisaiCommonHensyuResultBeanP.setShrGkMeisai(hokenRyou);
                siMeisaiCommonHensyuResultBeanP.setRendouShrGkMeisai(Long.parseLong(hokenRyou.toAdsoluteString()));

                if (pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) == 0) {

                    siMeisaiCommonHensyuResultBeanP.setDetailBikou(pGaitoukknHensyu(
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouYm(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuY(),
                        pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuM()));
                }

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanP);

            }
        }

        if (pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkYen().compareTo(BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanRikinGk = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanRikinGk.setTekiYou(MessageUtil.getMessage(MessageId.IJW1096));
            siMeisaiCommonHensyuResultBeanRikinGk.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkYen());
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrGkMeisai(
                Long.parseLong(pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkYen().toAdsoluteString()));
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
            siMeisaiCommonHensyuResultBeanRikinGk.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanRikinGk);
        }

        if (pSiMeisaiCommonHensyuBean.getKrkGk().compareTo(
            BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getKrkGk().getType())) > 0) {

            int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

            if (shrdtlsyoHanteiFlg && count == 1) {

                wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
            }

            SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanSonota = new SiMeisaiCommonHensyuResultBean();

            siMeisaiCommonHensyuResultBeanSonota.setTekiYou(MessageUtil.getMessage(MessageId.IJW1099));
            siMeisaiCommonHensyuResultBeanSonota.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
            siMeisaiCommonHensyuResultBeanSonota.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

            if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                siMeisaiCommonHensyuResultBeanSonota.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getKrkGk());
                siMeisaiCommonHensyuResultBeanSonota.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getKrkGk().toAdsoluteString()));
            }
            else {

                siMeisaiCommonHensyuResultBeanSonota.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenkaKrkGk());
                siMeisaiCommonHensyuResultBeanSonota.setRendouShrGkMeisai(
                    Long.parseLong(pSiMeisaiCommonHensyuBean.getYenkaKrkGk().toAdsoluteString()));
            }

            wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanSonota);
        }

        if (shrdtlsyoHanteiFlg) {

            if (pSiMeisaiCommonHensyuBean.getTienRsk().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getTienRsk().getType())) > 0) {

                int count = wkSiMeisaiCommonHensyuResultBeanLst.size() % 2;

                if (count == 1) {

                    wkSiMeisaiCommonHensyuResultBeanLst.add(new SiMeisaiCommonHensyuResultBean());
                }

                SiMeisaiCommonHensyuResultBean siMeisaiCommonHensyuResultBeanRsk = new SiMeisaiCommonHensyuResultBean();

                siMeisaiCommonHensyuResultBeanRsk.setTekiYou(MessageUtil.getMessage(MessageId.IJC1039));
                siMeisaiCommonHensyuResultBeanRsk.setRendouShrGkMeisaiTuukasyu(C_Tuukasyu.JPY);
                siMeisaiCommonHensyuResultBeanRsk.setRendouShrknGkMeisaiHugou(RENDOUSHRKNGKMEISAIHUGOU_SEI);

                if (C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                    siMeisaiCommonHensyuResultBeanRsk.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getTienRsk());
                    siMeisaiCommonHensyuResultBeanRsk.setRendouShrGkMeisai(
                        Long.parseLong(pSiMeisaiCommonHensyuBean.getTienRsk().toAdsoluteString()));
                }
                else {

                    siMeisaiCommonHensyuResultBeanRsk.setShrGkMeisai(pSiMeisaiCommonHensyuBean.getYenTienRsk());
                    siMeisaiCommonHensyuResultBeanRsk.setRendouShrGkMeisai(
                        Long.parseLong(pSiMeisaiCommonHensyuBean.getYenTienRsk().toAdsoluteString()));
                }

                siMeisaiCommonHensyuResultBeanRsk.setDetailBikou(MessageUtil.getMessage(MessageId.IJC1040,
                    pSiMeisaiCommonHensyuBean.getSinsaGendokKnKbn().getContent(),
                    ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getTienRskNissuu().toString(), 0, 0)));

                wkSiMeisaiCommonHensyuResultBeanLst.add(siMeisaiCommonHensyuResultBeanRsk);

            }
        }

        return wkSiMeisaiCommonHensyuResultBeanLst;
    }

    private List<String> yenShrBikouHensyu(SiMeisaiCommonHensyuBean pSiMeisaiCommonHensyuBean, boolean pYenSitiHsyutkTekiUmuFlg, BizCurrency pKyhkg) {

        List<String> bikouLst = new ArrayList<>();

        if (shrdtlsyoHanteiFlg) {

            String bikouSibouYmd = MessageUtil.getMessage(MessageId.IJC1034,
                ConvertUtil.toZenAll(DateFormatUtil.dateKANJISeirekiNoZero(pSiMeisaiCommonHensyuBean.getSibouYmd()), 0, 0));

            bikouLst.add(bikouSibouYmd);
        }

        String KyhkgZenkaku = ConvertUtil.toZenAll(pKyhkg.toFormatString(), 0, 0);

        String KyhkgHankaku = pKyhkg.toFormatString();

        if (!C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu()) && pYenSitiHsyutkTekiUmuFlg) {

            String yenSitiHsyutkTekiGaikaGk;

            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                yenSitiHsyutkTekiGaikaGk = MessageUtil.getMessage(MessageId.IJC1035, KyhkgZenkaku
                    + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
            }
            else {

                yenSitiHsyutkTekiGaikaGk = MessageUtil.getMessage(MessageId.IJC1035, KyhkgHankaku + HANKAKUSPACE
                    + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
            }

            bikouLst.add(yenSitiHsyutkTekiGaikaGk);

            String yenkasaiteiHsyTkykSetsumei1 =  MessageUtil.getMessage(MessageId.IJC1042);

            bikouLst.add(yenkasaiteiHsyTkykSetsumei1);

            String yenkasaiteiHsyTkykSetsumei2 =  MessageUtil.getMessage(MessageId.IJC1043);

            bikouLst.add(yenkasaiteiHsyTkykSetsumei2);

        }

        else if (!C_Tuukasyu.JPY.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu()) && !pYenSitiHsyutkTekiUmuFlg) {

            List<SiMeisaiCommonHensyuKnsnBean> siMeisaiCommonHensyuKnsnBeanLst = new ArrayList<>();

            SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanGaika = new SiMeisaiCommonHensyuKnsnBean();

            String gaikaGkInfo;
            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                gaikaGkInfo = MessageUtil.getMessage(MessageId.IJC1035, KyhkgZenkaku
                    + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
            }
            else {

                gaikaGkInfo = MessageUtil.getMessage(MessageId.IJC1035, KyhkgHankaku + HANKAKUSPACE
                    + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
            }

            siMeisaiCommonHensyuKnsnBeanGaika.setKnsnInfo(KNSN_GAIKAGK);
            siMeisaiCommonHensyuKnsnBeanGaika.setBikouOutputInfo(gaikaGkInfo);
            siMeisaiCommonHensyuKnsnBeanGaika.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);
            siMeisaiCommonHensyuKnsnBeanGaika.setZennouSeisankGkUmuFlg(false);

            siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanGaika);

            if (pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka().getType())) > 0) {

                SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanRikinGk = new SiMeisaiCommonHensyuKnsnBean();

                String rikinGkInfo;
                if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                    String zitkazukaRikinGkSiteiTuukaZenAll = ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean
                        .getZitkazukaRikinGkSiteiTuuka().toFormatString(), 0, 0);

                    rikinGkInfo = MessageUtil.getMessage(MessageId.IJC1052, zitkazukaRikinGkSiteiTuukaZenAll
                        + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                }
                else {

                    String zitkazukaRikinGkSiteiTuuka = pSiMeisaiCommonHensyuBean.getZitkazukaRikinGkSiteiTuuka()
                        .toFormatString();

                    rikinGkInfo = MessageUtil.getMessage(MessageId.IJC1052, zitkazukaRikinGkSiteiTuuka + HANKAKUSPACE
                        + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                }

                siMeisaiCommonHensyuKnsnBeanRikinGk.setKnsnInfo(KNSN_AZUKARIKINGK);
                siMeisaiCommonHensyuKnsnBeanRikinGk.setBikouOutputInfo(rikinGkInfo);
                siMeisaiCommonHensyuKnsnBeanRikinGk.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);
                siMeisaiCommonHensyuKnsnBeanRikinGk.setZennouSeisankGkUmuFlg(false);

                siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanRikinGk);

            }

            if (pSiMeisaiCommonHensyuBean.getMisyuuP().compareTo(
                BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMisyuuP().getType())) > 0) {

                SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanP = new SiMeisaiCommonHensyuKnsnBean();

                String pInfo;

                if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                    String misyuuPZenAll = ConvertUtil.toZenAll(
                        pSiMeisaiCommonHensyuBean.getMisyuuP().toFormatString(), 0, 0);

                    pInfo = MessageUtil.getMessage(
                        MessageId.IJC1053, misyuuPZenAll + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                }
                else {

                    String misyuuP = pSiMeisaiCommonHensyuBean.getMisyuuP().toFormatString();

                    pInfo = MessageUtil.getMessage(MessageId.IJC1053, misyuuP + HANKAKUSPACE
                        + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                }

                siMeisaiCommonHensyuKnsnBeanP.setKnsnInfo(KNSN_HOKENRYOU);
                siMeisaiCommonHensyuKnsnBeanP.setBikouOutputInfo(pInfo);
                siMeisaiCommonHensyuKnsnBeanP.setKnsnInfoHugo(KNSNINFOHUGO_MINUS);
                siMeisaiCommonHensyuKnsnBeanP.setZennouSeisankGkUmuFlg(false);

                siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanP);
            }

            if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getMikeikapknrtuukakbn()) &&
                C_SeisankinKanritukaKbn.SITEITUUKA.eq(siSyouhnZokusei.getZnnusisnkinknrtuukakbn())) {
                if (pSiMeisaiCommonHensyuBean.getMikeikaP().compareTo(
                    BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getMikeikaP().getType())) > 0 ||
                    pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                        BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                    SiMeisaiCommonHensyuKnsnBean siMeisaiCommonHensyuKnsnBeanP = new SiMeisaiCommonHensyuKnsnBean();
                    BizCurrency hokenRyou = pSiMeisaiCommonHensyuBean.getMikeikaP().add(
                        pSiMeisaiCommonHensyuBean.getZennouSeisankGk());

                    String pInfo = "";

                    if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                        pInfo = MessageUtil.getMessage(MessageId.IJC1053,
                            ConvertUtil.toZenAll(hokenRyou.toFormatString(), 0, 0) +
                            pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                    }
                    else {

                        pInfo = MessageUtil.getMessage(MessageId.IJC1053, hokenRyou.toFormatString() + HANKAKUSPACE
                            + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent());
                    }

                    siMeisaiCommonHensyuKnsnBeanP.setKnsnInfo(KNSN_HOKENRYOU);
                    siMeisaiCommonHensyuKnsnBeanP.setBikouOutputInfo(pInfo);
                    siMeisaiCommonHensyuKnsnBeanP.setKnsnInfoHugo(KNSNINFOHUGO_PURASU);

                    if (pSiMeisaiCommonHensyuBean.getZennouSeisankGk().compareTo(
                        BizCurrency.valueOf(0, pSiMeisaiCommonHensyuBean.getZennouSeisankGk().getType())) > 0) {

                        siMeisaiCommonHensyuKnsnBeanP.setZennouSeisankGkUmuFlg(true);
                    }
                    else {

                        siMeisaiCommonHensyuKnsnBeanP.setZennouSeisankGkUmuFlg(false);
                    }

                    siMeisaiCommonHensyuKnsnBeanLst.add(siMeisaiCommonHensyuKnsnBeanP);
                }
            }

            if (siMeisaiCommonHensyuKnsnBeanLst.size() == 1) {

                bikouLst.add(siMeisaiCommonHensyuKnsnBeanLst.get(0).getBikouOutputInfo());
            }
            else if (siMeisaiCommonHensyuKnsnBeanLst.size() > 1) {

                String sshkGkInfo = "";

                for (int idx = 0; idx < siMeisaiCommonHensyuKnsnBeanLst.size(); idx++){

                    bikouLst.add(KNSNINFOHUYOMOJI[idx] + siMeisaiCommonHensyuKnsnBeanLst.get(idx).getBikouOutputInfo());

                    if (KNSN_HOKENRYOU.equals(siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfo())) {

                        if (KNSNINFOHUGO_MINUS.equals(siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfoHugo())) {

                            String pGaitoukknKaku = pGaitoukknHensyuKakko(pSiMeisaiCommonHensyuBean.getMisyuupJyuutouYm(),
                                pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuY(),
                                pSiMeisaiCommonHensyuBean.getMisyuupJyuutouKaisuuM());

                            bikouLst.add(pGaitoukknKaku);
                        }
                        else if (KNSNINFOHUGO_PURASU.equals(siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfoHugo())) {

                            if (!siMeisaiCommonHensyuKnsnBeanLst.get(idx).getZennouSeisankGkUmuFlg()) {

                                String pGaitoukknKaku = pGaitoukknHensyuKakko(pSiMeisaiCommonHensyuBean.getMikeikapJyuutouYm(),
                                    pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuY(),
                                    pSiMeisaiCommonHensyuBean.getMikeikapJyuutouKaisuuM());

                                bikouLst.add(pGaitoukknKaku);
                            }
                        }
                    }

                    if (idx == 0) {

                        sshkGkInfo = KNSNINFOHUYOMOJI[idx];
                    }
                    else {

                        sshkGkInfo = sshkGkInfo + siMeisaiCommonHensyuKnsnBeanLst.get(idx).getKnsnInfoHugo() + KNSNINFOHUYOMOJI[idx];
                    }
                }

                bikouLst.add(SSHKINFOPREFIX + sshkGkInfo + SSHKINFOSAFIX);

                String sshkGk = "";
                if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                    sshkGk = ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getYenkaKnsntkGk().toFormatString(), 0, 0)
                        + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent();
                }
                else {

                    sshkGk = pSiMeisaiCommonHensyuBean.getYenkaKnsntkGk().toFormatString() + HANKAKUSPACE
                        + pSiMeisaiCommonHensyuBean.getKykTuukaSyu().getContent();
                }

                sshkGk = ZENKAKUSPACE+ ZENKAKUSPACE + sshkGk;

                bikouLst.add(sshkGk);

            }

            String kawaseRate = "";
            String kawaseRateInfo = "";
            if (shrdtlsyoHanteiFlg && C_KanryotuutioutKbn.GAIBU.eq(kanryoTuutioutKbn)) {

                kawaseRate = ConvertUtil.toZenAll(pSiMeisaiCommonHensyuBean.getKawaseRate().toString(), 0, 0);
            }
            else {

                kawaseRate = pSiMeisaiCommonHensyuBean.getKawaseRate().toString();
            }

            if (C_Tuukasyu.USD.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                kawaseRateInfo = MessageUtil.getMessage(MessageId.IJC1037, kawaseRate);
            }
            else if (C_Tuukasyu.AUD.eq(pSiMeisaiCommonHensyuBean.getKykTuukaSyu())) {

                kawaseRateInfo = MessageUtil.getMessage(MessageId.IJC1038, kawaseRate);
            }

            bikouLst.add(kawaseRateInfo);

            if (shrdtlsyoHanteiFlg) {

                String knsnKijyunYmd = ConvertUtil.toZenAll(
                    DateFormatUtil.dateKANJISeirekiNoZero(pSiMeisaiCommonHensyuBean.getKnsnKijyunYmd()), 0, 0);

                String knsnKijyunYmdInfo = MessageUtil.getMessage(MessageId.IJC1036, knsnKijyunYmd);

                bikouLst.add(knsnKijyunYmdInfo);
            }
        }

        return bikouLst;
    }

    private String pGaitoukknHensyu(BizDateYM pJyuutouYm, Integer pJyuutouKaisuuY, Integer pJyuutouKaisuuM) {

        String jyuutouYmStrHankaku = DateFormatUtil.dateYmKANJI(pJyuutouYm);
        String jyuutouYmStrZenkaku = ConvertUtil.toZenAll(jyuutouYmStrHankaku, 0, 0);
        String jyuutouKaisuuYStr = "";
        String jyuutouKaisuuMStr = "";

        if (pJyuutouKaisuuY != 0) {

            jyuutouKaisuuYStr = ConvertUtil.toZenAll(pJyuutouKaisuuY.toString(), 0, 0);

            if(jyuutouKaisuuYStr.length() == 1) {

                jyuutouKaisuuYStr = ZENKAKUSPACE + jyuutouKaisuuYStr;
            }
        }

        if (pJyuutouKaisuuM != 0) {

            jyuutouKaisuuMStr = ConvertUtil.toZenAll(pJyuutouKaisuuM.toString(), 0, 0);

            if(jyuutouKaisuuMStr.length() == 1) {

                jyuutouKaisuuMStr = ZENKAKUSPACE + jyuutouKaisuuMStr;
            }
        }

        String pGaitoukkn = "";
        if (pJyuutouKaisuuY != 0 && pJyuutouKaisuuM != 0) {

            pGaitoukkn = MessageUtil.getMessage(MessageId.IJA1001, jyuutouYmStrZenkaku, jyuutouKaisuuYStr, jyuutouKaisuuMStr);
        }
        else if (pJyuutouKaisuuY != 0 && pJyuutouKaisuuM == 0) {

            pGaitoukkn = MessageUtil.getMessage(MessageId.IJA1002, jyuutouYmStrZenkaku, jyuutouKaisuuYStr);
        }
        else if (pJyuutouKaisuuY == 0 && pJyuutouKaisuuM != 0) {

            pGaitoukkn = MessageUtil.getMessage(MessageId.IJA1003, jyuutouYmStrZenkaku, jyuutouKaisuuMStr);
        }

        return pGaitoukkn;
    }

    private String pGaitoukknHensyuKakko(BizDateYM pJyuutouYm, Integer pJyuutouKaisuuY, Integer pJyuutouKaisuuM) {

        String pGaitoukknKakko = SAKAKKO + pGaitoukknHensyu(pJyuutouYm, pJyuutouKaisuuY, pJyuutouKaisuuM) + MIGIKAKKO;

        return pGaitoukknKakko;
    }
}