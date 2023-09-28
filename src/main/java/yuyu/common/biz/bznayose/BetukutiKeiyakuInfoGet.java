package yuyu.common.biz.bznayose;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;

import com.google.common.collect.Ordering;

/**
 * 業務共通 名寄せ 別口契約情報取得クラス <br>
 * 指定した条件で別口契約情報を取得し、画面表示用にBeanを編集し返却する。
 */
public class BetukutiKeiyakuInfoGet {

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BetukutiKeiyakuInfoResultBean exec(BetukutiKeiyakuInfoGetParam pBetukutiKeiyakuInfoGetParam) {

        logger.debug("▽ 別口契約情報取得 開始");

        BetukutiKeiyakuInfoResultBean betukutiKeiyakuInfoResultBean = SWAKInjector
            .getInstance(BetukutiKeiyakuInfoResultBean.class);
        List<BetukutiKeiyakuInfoBean> betukutiKeiyakuInfoBeanLst = new ArrayList<>();
        List<String> betuKeiyakuSynoLst = new ArrayList<>();
        List<C_SysCdKbn> syscdKbnLst = new ArrayList<>();
        List<C_BetukutiKeiyakuKbn> betukutiKeiyakuKbnLst = new ArrayList<>();
        List<String> kankeisyaKbnLst = new ArrayList<>();
        List<Integer> syouhnsdnoLst  = new ArrayList<>();
        List<BizDate> syoumetuymdLst = new ArrayList<>();
        List<String> syoumetucdLst = new ArrayList<>();
        List<String> syouhncdLst = new ArrayList<>();
        List<String> syoumetujiyuunameLst = new ArrayList<>();
        List<String> syouhnNameLst = new ArrayList<>();
        List<BetukutiKeiyakuInfoBean> sortedRoleInfoDataSourceBeanList = new ArrayList<>();

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
            .getInstance(BzSakuinTsnSyoukaiYokenBean.class);
        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(pBetukutiKeiyakuInfoGetParam.getHuho2kyknokbn());
        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pBetukutiKeiyakuInfoGetParam.getHuho2kykno());
        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(pBetukutiKeiyakuInfoGetParam.getSkintsntaisyoukbn());
        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);
        bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN);
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(pBetukutiKeiyakuInfoGetParam.getHuho2kyknokbn());
        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno(pBetukutiKeiyakuInfoGetParam.getHuho2kykno());
        bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(BizDate.getSysDate());
        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq
            .exec(bzSakuinTsnSyoukaiYokenBean);
        C_MQSyorikekkaKbn mqSyorikekkaKbn = bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn();
        C_PalSyoukaiJissiumuKbn palSyoukaiJissiumuKbn = bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn();

        if (!C_MQSyorikekkaKbn.ERROR.eq(mqSyorikekkaKbn) && !C_PalSyoukaiJissiumuKbn.NONE.eq(palSyoukaiJissiumuKbn)) {

            for (int i = 0; i < bzSakuinTsnSyoukaiKekkaBean.getKhkensuu(); i++) {
                betuKeiyakuSynoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhsyono());
                syscdKbnLst.add(C_SysCdKbn.RAY);
                betukutiKeiyakuKbnLst.add(C_BetukutiKeiyakuKbn.KEIYAKU);
                kankeisyaKbnLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhkykkankeisyakbn().getContent());
                syouhnsdnoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhsyouhnsdno());
                syoumetuymdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhsyoumetuymd());
                syoumetucdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhsyoumetujiyuu().getValue());
                syouhncdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(i)
                    .getKhsyouhncd());
            }

            for (int i = 0; i < bzSakuinTsnSyoukaiKekkaBean.getNkkensuu(); i++) {
                betuKeiyakuSynoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNknksysyno());
                syscdKbnLst.add(C_SysCdKbn.RAY);
                betukutiKeiyakuKbnLst.add(C_BetukutiKeiyakuKbn.NENKIN);
                kankeisyaKbnLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNknkkankeisyakbn().getContent());
                syouhnsdnoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNksyouhnsdno());
                syoumetuymdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNksyoumetuymd());
                syoumetucdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNknksyoumetucd().getValue());
                syouhncdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().get(i)
                    .getNksyouhncd());
            }

            for (int i = 0; i < bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(); i++) {
                betuKeiyakuSynoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(i)
                    .getKykmfsyono());
                syscdKbnLst.add(C_SysCdKbn.PAL);
                betukutiKeiyakuKbnLst.add(C_BetukutiKeiyakuKbn.KEIYAKU);
                kankeisyaKbnLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(i)
                    .getKykmfkykkankeisyakbn().getContent());
                syouhnsdnoLst.add(null);
                syoumetuymdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(i)
                    .getKykmfsyoumetuymd());
                syoumetucdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(i)
                    .getKykmfsyoumetucd());
                syouhncdLst.add(null);
            }

            for (int i = 0; i < bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu(); i++) {
                betuKeiyakuSynoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist()
                    .get(i).getSounenfnksysyno());
                syscdKbnLst.add(C_SysCdKbn.PAL);
                betukutiKeiyakuKbnLst.add(C_BetukutiKeiyakuKbn.NENKIN);
                kankeisyaKbnLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().get(i)
                    .getSounenfnkkankeisyakbn().getContent());
                syouhnsdnoLst.add(null);
                syoumetuymdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().get(i)
                    .getSounenfsyoumetuymd());
                syoumetucdLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().get(i)
                    .getSounenfnksyoumetucd());
                syouhncdLst.add(null);

            }

            for (int i = 0; i < bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu(); i++) {
                betuKeiyakuSynoLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().get(i)
                    .getSueokifsysyno());
                syscdKbnLst.add(C_SysCdKbn.PAL);
                betukutiKeiyakuKbnLst.add(C_BetukutiKeiyakuKbn.SUEOKI);
                kankeisyaKbnLst.add(bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().get(i)
                    .getSueokifhknkinkankeisyakbn().getContent());
                syouhnsdnoLst.add(null);
                syoumetuymdLst.add(null);
                syoumetucdLst.add(null);
                syouhncdLst.add(null);
            }

            for (int idx3 = 0; idx3 < betuKeiyakuSynoLst.size(); idx3++) {

                if (C_SysCdKbn.RAY.eq(syscdKbnLst.get(idx3))) {

                    BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
                        syouhncdLst.get(idx3),syouhnsdnoLst.get(idx3));
                    syouhnNameLst.add(syouhnZokusei.getSyouhnnm());


                    if (!BizUtil.isBlank(syoumetucdLst.get(idx3))) {
                        if (C_BetukutiKeiyakuKbn.NENKIN.eq(betukutiKeiyakuKbnLst.get(idx3))) {
                            syoumetujiyuunameLst.add(C_NkSyoumetuCd.getContentByValue(syoumetucdLst.get(idx3)));
                        }
                        else {
                            syoumetujiyuunameLst.add(C_Syoumetujiyuu.getContentByValue(syoumetucdLst.get(idx3)));
                        }
                    }
                    else {
                        syoumetujiyuunameLst.add("");
                    }
                }
                else {
                    syouhnNameLst.add("");
                    if (!BizUtil.isBlank(syoumetucdLst.get(idx3)) && (syoumetuymdLst.get(idx3) != null)) {
                        BzPalSyoumetujiyuuNameGet bzPalSyoumetujiyuuNameGet = SWAKInjector
                            .getInstance(BzPalSyoumetujiyuuNameGet.class);
                        syoumetujiyuunameLst.add(bzPalSyoumetujiyuuNameGet.exec(syoumetucdLst.get(idx3),
                            betukutiKeiyakuKbnLst.get(idx3)));
                    }
                    else {
                        syoumetujiyuunameLst.add("");
                    }
                }
            }
            for (int idx4 = 0; idx4 < betuKeiyakuSynoLst.size(); idx4++) {
                BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean = SWAKInjector
                    .getInstance(BetukutiKeiyakuInfoBean.class);
                betukutiKeiyakuInfoBean.setBtkyksyono(betuKeiyakuSynoLst.get(idx4));
                betukutiKeiyakuInfoBean.setSyscdkbn(syscdKbnLst.get(idx4));
                betukutiKeiyakuInfoBean.setBetukutikeiyakukbn(betukutiKeiyakuKbnLst.get(idx4));
                betukutiKeiyakuInfoBean.setKankeisyakbnname(kankeisyaKbnLst.get(idx4));
                betukutiKeiyakuInfoBean.setSyoumetuymd(syoumetuymdLst.get(idx4));
                betukutiKeiyakuInfoBean.setSyoumetujiyuuname(syoumetujiyuunameLst.get(idx4));
                betukutiKeiyakuInfoBean.setSyouhnnm(syouhnNameLst.get(idx4));

                betukutiKeiyakuInfoBeanLst.add(betukutiKeiyakuInfoBean);
            }

            Ordering<BetukutiKeiyakuInfoBean> ordering = Ordering.natural().nullsLast()
                .onResultOf(new SearchBetukutiKeiyakuInfoSortFunction());
            sortedRoleInfoDataSourceBeanList = ordering.sortedCopy(betukutiKeiyakuInfoBeanLst);
        }

        betukutiKeiyakuInfoResultBean.setBetukutiKeiyakuInfoBeanLst(sortedRoleInfoDataSourceBeanList);

        betukutiKeiyakuInfoResultBean.setMqsyorikekkakbn(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn());
        betukutiKeiyakuInfoResultBean.setPalsyoukaijissiumukbn(bzSakuinTsnSyoukaiKekkaBean
            .getPalsyoukaijissiumukbn());
        betukutiKeiyakuInfoResultBean.setSakuininfosyoukaierrkbn(bzSakuinTsnSyoukaiKekkaBean
            .getSakuininfosyoukaierrkbn());
        betukutiKeiyakuInfoResultBean.setKykensuutyoukaumu(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu());
        betukutiKeiyakuInfoResultBean.setNkkensuutyoukaumu(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu());
        betukutiKeiyakuInfoResultBean.setKykmfkensuutyoukaumu(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu());
        betukutiKeiyakuInfoResultBean.setNkfkensuutyoukaumu(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu());
        betukutiKeiyakuInfoResultBean.setSueokifkensuutyoukaumu(bzSakuinTsnSyoukaiKekkaBean
            .getSueokifkensuutyoukaumu());

        logger.debug("△ 別口契約情報取得 終了");

        return betukutiKeiyakuInfoResultBean;
    }
}
