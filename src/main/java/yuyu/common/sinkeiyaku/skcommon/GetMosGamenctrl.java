package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_SyouhnZokusei;

import com.google.common.collect.Lists;

/**
 * 新契約 新契約共通 申込書入力画面制御リスト取得
 */
public class GetMosGamenctrl {

    @Inject
    private BizDomManager bizDomManager;

    public GetMosGamenctrl() {
    }

    public List<GetSyouhnZokuseiCtrlOutBean> getGamenctrl(List<GetSyouhnZokuseiCtrlInBean> pSyouhnzokuseiCtrlGetInBeanLst) {
        List<GetSyouhnZokuseiCtrlOutBean> syouhnzokuseiCtrlGetOutBeanLst = Lists.newArrayList();
        GetSyouhnZokuseiCtrlOutBean syouhnzokuseiCtrlGetOutBean;
        SetMosGamenctrl setMosGamenctrl = SWAKInjector.getInstance(SetMosGamenctrl.class);

        for (GetSyouhnZokuseiCtrlInBean syouhnzokuseiCtrlGetInBean : pSyouhnzokuseiCtrlGetInBeanLst) {
            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                syouhnzokuseiCtrlGetInBean.getInputctrlSyouhnCd(), syouhnzokuseiCtrlGetInBean.getInputctrlSyouhnSdNo());
            if (syouhnZokusei != null) {
                syouhnzokuseiCtrlGetOutBean = SWAKInjector.getInstance(GetSyouhnZokuseiCtrlOutBean.class);
                syouhnzokuseiCtrlGetOutBean.setHknsyuruino(syouhnzokuseiCtrlGetInBean.getHknsyuruino());
                syouhnzokuseiCtrlGetOutBean.setHknsyuruinosd(syouhnzokuseiCtrlGetInBean.getHknsyuruinosd());
                syouhnzokuseiCtrlGetOutBean.setInputctrlsyouhncd(syouhnzokuseiCtrlGetInBean.getInputctrlSyouhnCd());
                syouhnzokuseiCtrlGetOutBean.setMos2hyoujiumuKbn(syouhnzokuseiCtrlGetInBean.getMos2hyoujiumuKbn());
                syouhnzokuseiCtrlGetOutBean.setSbuktumu(syouhnZokusei.getSbuktumu());
                syouhnzokuseiCtrlGetOutBean.setKktumu(syouhnZokusei.getKktumu());
                syouhnzokuseiCtrlGetOutBean.setMusenumu(syouhnZokusei.getMusenumu());
                syouhnzokuseiCtrlGetOutBean.setSyokugyoukktumu(syouhnZokusei.getSyokugyoukktumu());
                syouhnzokuseiCtrlGetOutBean.setHaitoukbn(syouhnZokusei.getHaitoukbn());
                syouhnzokuseiCtrlGetOutBean.setTeikisiharaikinumu(syouhnZokusei.getTeikisiharaikinumu());
                syouhnzokuseiCtrlGetOutBean.setItijibrumu(syouhnZokusei.getItijibrumu());
                syouhnzokuseiCtrlGetOutBean.setGaikatatkiumu(syouhnZokusei.getGaikatatkiumu());
                syouhnzokuseiCtrlGetOutBean.setHengakuumu(syouhnZokusei.getHengakuumu());
                syouhnzokuseiCtrlGetOutBean.setNstkumu(syouhnZokusei.getNstkumu());
                syouhnzokuseiCtrlGetOutBean.setKykdrtentuusanumu(syouhnZokusei.getKykdrtentuusanumu());
                syouhnzokuseiCtrlGetOutBean.setPyennykntktekiumu(syouhnZokusei.getPyennykntktekiumu());
                syouhnzokuseiCtrlGetOutBean.setGaikanyuukintktekiumu(syouhnZokusei.getGaikanyuukintktekiumu());
                syouhnzokuseiCtrlGetOutBean.setSyuusinhknumu(syouhnZokusei.getSyuusinhknumu());
                syouhnzokuseiCtrlGetOutBean.setNkhknumu(syouhnZokusei.getNkhknumu());
                syouhnzokuseiCtrlGetOutBean.setSyksbyensitihsyutktekiumu(syouhnZokusei.getSyksbyensitihsyutktekiumu());
                syouhnzokuseiCtrlGetOutBean.setJyudkaigomehrtktekiumu(syouhnZokusei.getJyudkaigomehrtktekiumu());
                syouhnzokuseiCtrlGetOutBean.setStdrsktkumu(syouhnZokusei.getStdrsktkumu());
                syouhnzokuseiCtrlGetOutBean.setTuukasyu(syouhnZokusei.getTuukasyu());
                syouhnzokuseiCtrlGetOutBean.setAeoitaisyouumu(syouhnZokusei.getAeoitaisyouumu());
                syouhnzokuseiCtrlGetOutBean.setHokenkngkyakujyouumu(syouhnZokusei.getHokenkngkyakujyouumu());
                syouhnzokuseiCtrlGetOutBean.setTargettkhukakanoukbn(syouhnZokusei.getTargettkhukakanoukbn());
                syouhnzokuseiCtrlGetOutBean.setTmttknhaibunwarisiteiumu(syouhnZokusei.getTmttknhaibunwarisiteiumu());
                syouhnzokuseiCtrlGetOutBean.setNkuktumu(syouhnZokusei.getNkuktumu());
                syouhnzokuseiCtrlGetOutBean.setHeijyunbaraiumu(syouhnZokusei.getHeijyunbaraiumu());
                syouhnzokuseiCtrlGetOutBean.setZennouumu(syouhnZokusei.getZennouumu());
                syouhnzokuseiCtrlGetOutBean.setItibuzennoutekiumu(syouhnZokusei.getItibuzennoutekiumu());
                syouhnzokuseiCtrlGetOutBean.setKouzahurikaebaraitekiumu(syouhnZokusei.getKouzahurikaebaraitekiumu());
                syouhnzokuseiCtrlGetOutBean.setZeiseitekikakuumu(syouhnZokusei.getZeiseitekikakuumu());
                syouhnzokuseiCtrlGetOutBean.setTeikiikkatubaraiumu(syouhnZokusei.getTeikiikkatubaraiumu());
                syouhnzokuseiCtrlGetOutBean.setKzktourokuserviceumu(syouhnZokusei.getKzktourokuserviceumu());
                syouhnzokuseiCtrlGetOutBean.setKykdrtkykumu(syouhnZokusei.getKykdrtkykumu());
                syouhnzokuseiCtrlGetOutBean.setPtratkituukasiteikbn(syouhnZokusei.getPtratkituukasiteikbn());
                syouhnzokuseiCtrlGetOutBean.setDai1HknkknSelect(setMosGamenctrl.getDai1HknkknSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setTargettkmkhtSelect(setMosGamenctrl.getTargettkmkhtSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setNenkinsyuSelect(setMosGamenctrl.getNenkinsyuSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setSueokikknSelect(setMosGamenctrl.getSueokikknSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setHknkknsmnKbn(setMosGamenctrl.getHknkknsmnKbn(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setHrktuukaSelect(setMosGamenctrl.getHrktuukasyuSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setHrkkeiroSelect(setMosGamenctrl.getHrkkeiroSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setHrkkknsmnkbn(setMosGamenctrl.getHrkkknsmnKbn(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setMos2hyoujiumuKbn(setMosGamenctrl.getMos2hyoujiumuKbn(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setKyktuukasyuSelect(setMosGamenctrl.getKyktuukasyuSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setKyktuukasyu2Select(setMosGamenctrl.getKyktuukasyu2Select(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setHrkkaisuuSelect(setMosGamenctrl.getHrkkaisuuSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setIkkatubaraikaisuuSelect(setMosGamenctrl.getIkkatubaraikaisuuSelect(syouhnzokuseiCtrlGetOutBean));
                syouhnzokuseiCtrlGetOutBean.setZenkizennouSelect(setMosGamenctrl.getZenkizennouSelect(syouhnzokuseiCtrlGetOutBean));

                syouhnzokuseiCtrlGetOutBeanLst.add(syouhnzokuseiCtrlGetOutBean);
            }
        }

        return syouhnzokuseiCtrlGetOutBeanLst;
    }
}