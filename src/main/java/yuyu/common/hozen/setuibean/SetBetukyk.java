package yuyu.common.hozen.setuibean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSakuinKekkaBean;
import yuyu.common.hozen.khcommon.NenkinSakuinKekkaBean;
import yuyu.common.hozen.khcommon.PALBetuSakuinSyoukai;
import yuyu.common.hozen.khcommon.PALBetuSakuinSyoukaiKekkaBean;
import yuyu.common.hozen.khcommon.PALKykMFSakuinKekkaBean;
import yuyu.common.hozen.khcommon.PALSouNenkinFSakuinKekkaBean;
import yuyu.common.hozen.khcommon.PALSueokiFSakuinKekkaBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.biz.manager.BizDomManager;

/**
 * 契約保全 UiBean設定 別契約情報設定
 */
public class SetBetukyk {

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    public boolean exec(KhozenCommonParam pKhCParm, SetBetukykExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        PALBetuSakuinSyoukai pALBetuSakuinSyoukai = SWAKInjector.getInstance(PALBetuSakuinSyoukai.class);

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(kinou.getKinouId())){

            pALBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.HHKN, C_SakuintaisyoukykKbn.TAISYOU_HHKN);

            pUiBean.setWarningMessageIdList(pALBetuSakuinSyoukai.getWarningMsgIdList());

            pUiBean.setWarningMessageList(pALBetuSakuinSyoukai.getWarningMsgList());
        }
        else
        {
            pALBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

            pUiBean.setWarningMessageIdList(pALBetuSakuinSyoukai.getWarningMsgIdList());

            pUiBean.setWarningMessageList(pALBetuSakuinSyoukai.getWarningMsgList());
        }

        PALBetuSakuinSyoukaiKekkaBean pALBetuSakuinSyoukaiKekkaBean =
            pALBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanList = new ArrayList<>();

        if (pALBetuSakuinSyoukaiKekkaBean.getKkkensuu() == 0){

            pUiBean.convertKikeiyakuInfoForCommonParam(kikeiyakuInfoDataSourceBeanList);
        }
        else
        {
            for (int i = 0; i < pALBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().size(); i++) {

                KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean =
                    pUiBean.createKikeiyakuInfoDataSourceBean();

                KykSakuinKekkaBean kykSakuinKekkaBean =
                    pALBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(i);

                BM_SyouhnZokusei syouhnZokusei =
                     bizDomManager.getSyouhnZokusei(kykSakuinKekkaBean.getKhSyouhnCd(), kykSakuinKekkaBean.getKhsyouhnsdno());

                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksyono(kykSakuinKekkaBean.getKykSyoNo());
                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkykyuuksumtkbn(kykSakuinKekkaBean.getKykYuukSumtKbn());
                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkykkykjyoutai(kykSakuinKekkaBean.getKykKykJyoutai());
                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkykkykymd(kykSakuinKekkaBean.getKykKykYMD());
                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksumetujiyuu(kykSakuinKekkaBean.getKykSumetuJiyuu());
                kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksyoumetuymd(kykSakuinKekkaBean.getKykSyoumetuYMD());

                if(syouhnZokusei != null) {
                     kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksyouhnnm(syouhnZokusei.getSyouhnnm());
                }else{
                     kikeiyakuInfoDataSourceBean.setVbtkkdispbtkyksyouhnnm("");
                }

                kikeiyakuInfoDataSourceBeanList.add(kikeiyakuInfoDataSourceBean);
            }

            pUiBean.convertKikeiyakuInfoForCommonParam(kikeiyakuInfoDataSourceBeanList);
        }

        List<NenkinsiharaiInfoDataSourceBeanCommonParam> nenkinsiharaiInfoDataSourceBeanList
        = new ArrayList<>();

        if (pALBetuSakuinSyoukaiKekkaBean.getNkkensuu() == 0){

            pUiBean.convertNenkinsiharaiInfoForCommonParam(nenkinsiharaiInfoDataSourceBeanList);
        }
        else
        {
            for (int i = 0; i < pALBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().size(); i++) {

                NenkinsiharaiInfoDataSourceBeanCommonParam nenkinsiharaiInfoDataSourceBean =
                    pUiBean.createNenkinsiharaiInfoDataSourceBean();

                NenkinSakuinKekkaBean nenkinSakuinKekkaBean =
                    pALBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().get(i);

                nenkinsiharaiInfoDataSourceBean.setVbtkkdispbtkyknksysyno
                (nenkinSakuinKekkaBean.getKykNkSysyNo());
                nenkinsiharaiInfoDataSourceBean.setVbtkkdispbtkyknkshrsymd
                (nenkinSakuinKekkaBean.getKykNkShrsYMD());
                nenkinsiharaiInfoDataSourceBean.setVbtkkdispbtkyknksymtjiyuu
                (nenkinSakuinKekkaBean.getKykNkSymtJiyuu());
                nenkinsiharaiInfoDataSourceBean.setVbtkkdispbtkyknksymtymd
                (nenkinSakuinKekkaBean.getKykNkSymtYMD());

                nenkinsiharaiInfoDataSourceBeanList.add(nenkinsiharaiInfoDataSourceBean);
            }

            pUiBean.convertNenkinsiharaiInfoForCommonParam(nenkinsiharaiInfoDataSourceBeanList);
        }

        List<PalkikeiyakuInfoDataSourceBeanCommonParam> palkikeiyakuInfoDataSourceBeanList
        = new ArrayList<>();

        if (pALBetuSakuinSyoukaiKekkaBean.getKykmfkensuu() == 0){

            pUiBean.convertPalkikeiyakuInfoForCommonParam(palkikeiyakuInfoDataSourceBeanList);
        }
        else
        {
            for (int i = 0; i < pALBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().size(); i++) {

                PalkikeiyakuInfoDataSourceBeanCommonParam palkikeiyakuInfoDataSourceBean =
                    pUiBean.createPalkikeiyakuInfoDataSourceBean();

                PALKykMFSakuinKekkaBean pALKykMFSakuinKekkaBean =
                    pALBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().get(i);

                palkikeiyakuInfoDataSourceBean.setVbtkkdisppalbtkyksyono
                (pALKykMFSakuinKekkaBean.getPalBtkykSyoNo());
                palkikeiyakuInfoDataSourceBean.setVbtkkdisppalbtkykkykymd
                (pALKykMFSakuinKekkaBean.getPalBtkykKykYMD());
                palkikeiyakuInfoDataSourceBean.setVbtkkdisppalbtkyksymtcd
                (pALKykMFSakuinKekkaBean.getPalBtkykSymtCd());
                palkikeiyakuInfoDataSourceBean.setVbtkkdisppalbtkyksymtymd
                (pALKykMFSakuinKekkaBean.getPalBtkykSymtYMD());

                palkikeiyakuInfoDataSourceBeanList.add(palkikeiyakuInfoDataSourceBean);
            }

            pUiBean.convertPalkikeiyakuInfoForCommonParam(palkikeiyakuInfoDataSourceBeanList);
        }

        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> palNenkinsiharaiInfoDataSourceBeanList
        = new ArrayList<>();

        if (pALBetuSakuinSyoukaiKekkaBean.getNkfkensuu() == 0){

            pUiBean.convertPalNenkinsiharaiInfoForCommonParam(palNenkinsiharaiInfoDataSourceBeanList);
        }
        else
        {
            for (int i = 0; i < pALBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().size(); i++) {

                PalNenkinsiharaiInfoDataSourceBeanCommonParam palNenkinsiharaiInfoDataSourceBean
                = pUiBean.createPalNenkinsiharaiInfoDataSourceBean();

                PALSouNenkinFSakuinKekkaBean pALSouNenkinFSakuinKekkaBean =
                    pALBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().get(i);

                palNenkinsiharaiInfoDataSourceBean.setVbtkkdisppalbtkyknksysyno
                (pALSouNenkinFSakuinKekkaBean.getPalBtkykNkSysyNo());
                palNenkinsiharaiInfoDataSourceBean.setVbtkkdisppalbtkyknkshrymd
                (pALSouNenkinFSakuinKekkaBean.getPalBtkykNkShrYMD());
                palNenkinsiharaiInfoDataSourceBean.setVbtkkdisppalbtkyknksymtcd
                (pALSouNenkinFSakuinKekkaBean.getPalBtkykNkSymtCd());
                palNenkinsiharaiInfoDataSourceBean.setVbtkkdisppalbtkyknksymtymd
                (pALSouNenkinFSakuinKekkaBean.getPalBtkykNkSymtYMD());

                palNenkinsiharaiInfoDataSourceBeanList.add(palNenkinsiharaiInfoDataSourceBean);
            }
            pUiBean.convertPalNenkinsiharaiInfoForCommonParam(palNenkinsiharaiInfoDataSourceBeanList);
        }

        List<PalsueokiInfoDataSourceBeanCommonParam> palsueokiInfoDataSourceBeanList
        = new ArrayList<>();

        if (pALBetuSakuinSyoukaiKekkaBean.getSueokifkensuu() == 0){

            pUiBean.convertPalsueokiInfoForCommonParam(palsueokiInfoDataSourceBeanList);
        }
        else
        {
            for (int i = 0; i < pALBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList().size(); i++) {

                PalsueokiInfoDataSourceBeanCommonParam palsueokiInfoDataSourceBean =
                    pUiBean.createPalsueokiInfoDataSourceBean();

                PALSueokiFSakuinKekkaBean pALSueokiFSakuinKekkaBean =
                    pALBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList().get(i);

                palsueokiInfoDataSourceBean.setVbtkkdisppalbtkyksosysyno
                (pALSueokiFSakuinKekkaBean.getPalBtkykSosysyNo());
                palsueokiInfoDataSourceBean.setVbtkkdisppalbtkyksosymd
                (pALSueokiFSakuinKekkaBean.getPalBtkykSosYMD());

                palsueokiInfoDataSourceBeanList.add(palsueokiInfoDataSourceBean);
            }

            pUiBean.convertPalsueokiInfoForCommonParam(palsueokiInfoDataSourceBeanList);
        }

        return true;
    }

    public void init(SetBetukykExecUiBeanParam pUiBean) {

        List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanList = new ArrayList<>();
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> nenkinsiharaiInfoDataSourceBeanList = new ArrayList<>();
        List<PalkikeiyakuInfoDataSourceBeanCommonParam> palkikeiyakuInfoDataSourceBeanList = new ArrayList<>();
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> palNenkinsiharaiInfoDataSourceBeanList = new ArrayList<>();
        List<PalsueokiInfoDataSourceBeanCommonParam> palsueokiInfoDataSourceBeanList = new ArrayList<>();
        pUiBean.setWarningMessageIdList(new ArrayList<String>());
        pUiBean.setWarningMessageList(new ArrayList<String>());

        pUiBean.convertKikeiyakuInfoForCommonParam(kikeiyakuInfoDataSourceBeanList);
        pUiBean.convertNenkinsiharaiInfoForCommonParam(nenkinsiharaiInfoDataSourceBeanList);
        pUiBean.convertPalkikeiyakuInfoForCommonParam(palkikeiyakuInfoDataSourceBeanList);
        pUiBean.convertPalNenkinsiharaiInfoForCommonParam(palNenkinsiharaiInfoDataSourceBeanList);
        pUiBean.convertPalsueokiInfoForCommonParam(palsueokiInfoDataSourceBeanList);
    }
}
