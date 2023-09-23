package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import org.slf4j.Logger;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 契約保全 契約保全共通 ＰＡＬ別口索引照会
 */
public class PALBetuSakuinSyoukai {

    @Inject
    private static Logger logger;

    private PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean;

    private boolean worningFlag;

    private List<String> worningMsgIdList;

    private List<String> worningMsgList;

    public PALBetuSakuinSyoukai() {
        super();
    }

    public boolean exec(String pSyono, C_SakuintsnTaisyouKbn pCSakuintsnTaisyouKbn,
        C_SakuintaisyoukykKbn pCSakuintaisyoukykKbn) {

        logger.debug("▽ ＰＡＬ別口索引照会 開始");

        palBetuSakuinSyoukaiKekkaBean = SWAKInjector.getInstance(PALBetuSakuinSyoukaiKekkaBean.class);

        worningFlag = true;

        worningMsgIdList = new ArrayList<>();

        worningMsgList = new ArrayList<>();

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean =
            SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);

        BizDate sysDate = BizDate.getSysDate();

        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);

        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);

        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pSyono);

        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(pCSakuintsnTaisyouKbn);

        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.YOU);

        bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(pCSakuintaisyoukykKbn);

        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.SYONO);

        bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kykno(pSyono);

        bzSakuinTsnSyoukaiYokenBean.setSkinkijyunymd(sysDate);

        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kykno("");

        bzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(null);

        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        bzSakuinTsnSyoukaiYokenBean.setDrtentsntsghuho2kykno("");

        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnkijyunymd(null);

        bzSakuinTsnSyoukaiYokenBean.setDairitencd1("");

        bzSakuinTsnSyoukaiYokenBean.setDairitencd2("");

        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);

        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        BzSakuinTsnSyoukaiMq sakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = sakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        if (C_MQSyorikekkaKbn.ERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {

            setSakuinSyoukaiInfo(MessageId.WIA1004);

            logger.debug("△ ＰＡＬ別口索引照会 終了");

            return true;
        }
        else if (C_MQSyorikekkaKbn.SEIJYOU.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())) {

            if (C_PalSyoukaiJissiumuKbn.NONE.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {

                setSakuinSyoukaiInfo(MessageId.WIA1005);

                logger.debug("△ ＰＡＬ別口索引照会 終了");

                return true;
            }
            else if (C_PalSyoukaiJissiumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {

                if (C_MQSyoukaiErrorKbn.SYOUKAIERROR.eq(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn())) {

                    setSakuinSyoukaiInfo(MessageId.WIA1006);

                    logger.debug("△ ＰＡＬ別口索引照会 終了");

                    return true;
                }
                else if (C_MQSyoukaiErrorKbn.SYOUKAIOK.eq(bzSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn())) {

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu())
                        || C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu())
                        || C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu())
                        || C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu())
                        || C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu())) {

                        worningFlag = false;

                        worningMsgIdList.add(MessageId.WBA0012);

                        worningMsgList.add(MessageUtil.getMessage(MessageId.WBA0012));
                    }

                    palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu());

                    palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu());

                    palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu());

                    palBetuSakuinSyoukaiKekkaBean.setKkkensuu(bzSakuinTsnSyoukaiKekkaBean.getKhkensuu());

                    palBetuSakuinSyoukaiKekkaBean.setNkkensuu(bzSakuinTsnSyoukaiKekkaBean.getNkkensuu());

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuutyoukaumu())) {

                        palBetuSakuinSyoukaiKekkaBean.setPalkykmfkensuutyoukaumu(C_UmuKbn.ARI);
                    }
                    else {

                        palBetuSakuinSyoukaiKekkaBean.setPalkykmfkensuutyoukaumu(C_UmuKbn.NONE);
                    }

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuutyoukaumu())) {

                        palBetuSakuinSyoukaiKekkaBean.setPalsueokifkensuutyoukaumu(C_UmuKbn.ARI);
                    }
                    else {

                        palBetuSakuinSyoukaiKekkaBean.setPalsueokifkensuutyoukaumu(C_UmuKbn.NONE);
                    }

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getNkfkensuutyoukaumu())) {

                        palBetuSakuinSyoukaiKekkaBean.setPalnkfkensuutyoukaumu(C_UmuKbn.ARI);
                    }
                    else {

                        palBetuSakuinSyoukaiKekkaBean.setPalnkfkensuutyoukaumu(C_UmuKbn.NONE);
                    }

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getKhkensuutyoukaumu())) {

                        palBetuSakuinSyoukaiKekkaBean.setHozenkensuutyoukaumu(C_UmuKbn.ARI);
                    }
                    else {

                        palBetuSakuinSyoukaiKekkaBean.setHozenkensuutyoukaumu(C_UmuKbn.NONE);
                    }

                    if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getNkkensuutyoukaumu())) {

                        palBetuSakuinSyoukaiKekkaBean.setNkkensuutyoukaumu(C_UmuKbn.ARI);
                    }
                    else {

                        palBetuSakuinSyoukaiKekkaBean.setNkkensuutyoukaumu(C_UmuKbn.NONE);
                    }

                    List<PALKykMFSakuinKekkaBean> palKykMFSakuinKekkaBeanList = new ArrayList<>();

                    List<PALSueokiFSakuinKekkaBean> palSueokiFSakuinKekkaBeanList = new ArrayList<>();

                    List<PALSouNenkinFSakuinKekkaBean> palSouNenkinFSakuinKekkaBeanList = new ArrayList<>();

                    List<KykSakuinKekkaBean> kykSakuinKekkaBeanList = new ArrayList<>();

                    List<NenkinSakuinKekkaBean> nenkinSakuinKekkaBeanList = new ArrayList<>();

                    int kensu = bzSakuinTsnSyoukaiKekkaBean.getKykmfkensuu();

                    for (int i = 0; i < kensu; i++) {

                        PALKykMFSakuinKekkaBean palKykMFSakuinKekkaBean =
                            SWAKInjector.getInstance(PALKykMFSakuinKekkaBean.class);

                        palKykMFSakuinKekkaBean.setPalBtkykSyoNo(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().
                            get(i).getKykmfsyono());

                        palKykMFSakuinKekkaBean.setPalBtkykKykYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().
                            get(i).getKykmfkykymd());

                        palKykMFSakuinKekkaBean.setPalBtkykSymtCd(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().
                            get(i).getKykmfsyoumetucd());

                        palKykMFSakuinKekkaBean.setPalBtkykSymtYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().
                            get(i).getKykmfsyoumetuymd());

                        palKykMFSakuinKekkaBeanList.add(palKykMFSakuinKekkaBean);
                    }

                    palBetuSakuinSyoukaiKekkaBean.setPalKykMFSakuinKekkaBeanList(palKykMFSakuinKekkaBeanList);

                    kensu = bzSakuinTsnSyoukaiKekkaBean.getSueokifkensuu();

                    for (int i = 0; i < kensu; i++) {

                        PALSueokiFSakuinKekkaBean paLSueokiFSakuinKekkaBean =
                            SWAKInjector.getInstance(PALSueokiFSakuinKekkaBean.class);

                        paLSueokiFSakuinKekkaBean.setPalBtkykSosysyNo(
                            bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().
                            get(i).getSueokifsysyno());

                        paLSueokiFSakuinKekkaBean.setPalBtkykSosYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzhokenkinsueokifsakuinkekkabeanlist().
                            get(i).getSueokifsueokikaisiymd());

                        palSueokiFSakuinKekkaBeanList.add(paLSueokiFSakuinKekkaBean);
                    }

                    palBetuSakuinSyoukaiKekkaBean.setPalSueokiFSakuinKekkaBeanList(palSueokiFSakuinKekkaBeanList);

                    kensu = bzSakuinTsnSyoukaiKekkaBean.getNkfkensuu();

                    for (int i = 0 ; i < kensu; i++) {

                        PALSouNenkinFSakuinKekkaBean palSouNenkinFSakuinKekkaBean =
                            SWAKInjector.getInstance(PALSouNenkinFSakuinKekkaBean.class);

                        palSouNenkinFSakuinKekkaBean.setPalBtkykNkSysyNo(
                            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().
                            get(i).getSounenfnksysyno());

                        palSouNenkinFSakuinKekkaBean.setPalBtkykNkShrYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().
                            get(i).getSounenfsyokainkshrymd());

                        palSouNenkinFSakuinKekkaBean.setPalBtkykNkSymtCd(
                            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().
                            get(i).getSounenfnksyoumetucd());

                        palSouNenkinFSakuinKekkaBean.setPalBtkykNkSymtYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzsougounenkinsiharaifsakuinkekkabeanlist().
                            get(i).getSounenfsyoumetuymd());

                        palSouNenkinFSakuinKekkaBeanList.add(palSouNenkinFSakuinKekkaBean);
                    }

                    palBetuSakuinSyoukaiKekkaBean.setPalSouNenkinFSakuinKekkaBeanList(palSouNenkinFSakuinKekkaBeanList);

                    kensu = bzSakuinTsnSyoukaiKekkaBean.getKhkensuu();

                    for (int i = 0; i < kensu; i++) {

                        KykSakuinKekkaBean kykSakuinKekkaBean = SWAKInjector.getInstance(KykSakuinKekkaBean.class);

                        kykSakuinKekkaBean.setKykSyoNo(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhsyono());

                        kykSakuinKekkaBean.setKykYuukSumtKbn(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhyuukousyoumetukbn());

                        kykSakuinKekkaBean.setKykKykJyoutai(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhkykjyoutai());

                        kykSakuinKekkaBean.setKykKykYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhkykymd());

                        kykSakuinKekkaBean.setKykSumetuJiyuu(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhsyoumetujiyuu());

                        kykSakuinKekkaBean.setKykSyoumetuYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhsyoumetuymd());

                        kykSakuinKekkaBean.setKhSyouhnCd(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhsyouhncd());

                        kykSakuinKekkaBean.setKhsyouhnsdno(
                            bzSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().
                            get(i).getKhsyouhnsdno());

                        kykSakuinKekkaBeanList.add(kykSakuinKekkaBean);
                    }

                    palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(kykSakuinKekkaBeanList);

                    kensu = bzSakuinTsnSyoukaiKekkaBean.getNkkensuu();

                    for (int i = 0; i < kensu; i++) {

                        NenkinSakuinKekkaBean nenkinSakuinKekkaBean =
                            SWAKInjector.getInstance(NenkinSakuinKekkaBean.class);

                        nenkinSakuinKekkaBean.setKykNkSysyNo(
                            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().
                            get(i).getNknksysyno());

                        nenkinSakuinKekkaBean.setKykNkShrsYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().
                            get(i).getNknkshrstartymd());

                        nenkinSakuinKekkaBean.setKykNkSymtJiyuu(
                            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().
                            get(i).getNknksyoumetucd());

                        nenkinSakuinKekkaBean.setKykNkSymtYMD(
                            bzSakuinTsnSyoukaiKekkaBean.getBznenkinsiharaisakuinkekkabeanlist().
                            get(i).getNksyoumetuymd());

                        nenkinSakuinKekkaBeanList.add(nenkinSakuinKekkaBean);
                    }

                    palBetuSakuinSyoukaiKekkaBean.setNenkinSakuinKekkaBeanList(nenkinSakuinKekkaBeanList);
                }
            }
        }

        logger.debug("△ ＰＡＬ別口索引照会 終了");

        return true;
    }

    private void setSakuinSyoukaiInfo(String pMsgId) {

        worningFlag = false;

        worningMsgIdList.add(pMsgId);

        worningMsgList.add(MessageUtil.getMessage(pMsgId));

        palBetuSakuinSyoukaiKekkaBean.setKykmfkensuu(0);

        palBetuSakuinSyoukaiKekkaBean.setSueokifkensuu(0);

        palBetuSakuinSyoukaiKekkaBean.setNkfkensuu(0);

        palBetuSakuinSyoukaiKekkaBean.setKkkensuu(0);

        palBetuSakuinSyoukaiKekkaBean.setNkkensuu(0);

        palBetuSakuinSyoukaiKekkaBean.setPalkykmfkensuutyoukaumu(C_UmuKbn.NONE);

        palBetuSakuinSyoukaiKekkaBean.setPalsueokifkensuutyoukaumu(C_UmuKbn.NONE);

        palBetuSakuinSyoukaiKekkaBean.setPalnkfkensuutyoukaumu(C_UmuKbn.NONE);

        palBetuSakuinSyoukaiKekkaBean.setHozenkensuutyoukaumu(C_UmuKbn.NONE);

        palBetuSakuinSyoukaiKekkaBean.setNkkensuutyoukaumu(C_UmuKbn.NONE);

        palBetuSakuinSyoukaiKekkaBean.setPalKykMFSakuinKekkaBeanList(null);

        palBetuSakuinSyoukaiKekkaBean.setPalSueokiFSakuinKekkaBeanList(null);

        palBetuSakuinSyoukaiKekkaBean.setPalSouNenkinFSakuinKekkaBeanList(null);

        palBetuSakuinSyoukaiKekkaBean.setKykSakuinKekkaBeanList(null);

        palBetuSakuinSyoukaiKekkaBean.setNenkinSakuinKekkaBeanList(null);
    }

    public boolean getWarningUmuFlg() {
        return this.worningFlag;
    }

    public List<String> getWarningMsgIdList() {
        return this.worningMsgIdList;
    }

    public List<String> getWarningMsgList() {
        return this.worningMsgList;
    }

    public PALBetuSakuinSyoukaiKekkaBean getPALBetuSakuinSyoukaiKekkaBean() {
        return this.palBetuSakuinSyoukaiKekkaBean;
    }
}
