package yuyu.common.hozen.khcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.IT_Zennou;

/**
 * 契約保全 契約保全共通 推移表ＴＢＬ編集（終身３）
 */
public class EditSuiihyouTblSyuusin3 {

    private static final String MSGHIKISUU = "解約返戻金計算拡張情報作成が実行できませんでした。";

    private static final String DUMMYSUIIHYOUSYUBETU = "00";

    private static final int DUMMYKEIKANEN = 99;

    private List<SibouSBean> sibouSBeanList = new ArrayList<>();

    @Inject
    private static Logger logger;

    public EditSuiihyouTblSyuusin3() {
        super();
    }

    public void editTBL(KhozenCommonParam pKkanriCommonParam,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        BizDate pSyoriYmd,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        C_SinsaihkKbn pCSinsaihkKbn,
        IT_Zennou pZennou) {

        logger.debug("▽ 推移表TBL編集（終身３） 開始");

        C_SinsaihkKbn csinsaihkKbn = C_SinsaihkKbn.BLNK;

        if (C_SinsaihkKbn.SIN.eq(pCSinsaihkKbn) ||
            (C_SinsaihkKbn.SAI.eq(pCSinsaihkKbn) && C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pEditHokenSyoukenParam.getSyoukenSaihk()))) {
            csinsaihkKbn = C_SinsaihkKbn.SIN;
        }
        else {
            csinsaihkKbn = C_SinsaihkKbn.SAI;
        }

        IT_KykSyouhn kykSyouhn = pKykSyohnSyuLst.get(0);
        C_Tuukasyu keiyakuTuukasyu = kykSyouhn.getKyktuukasyu();
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        if (C_SinsaihkKbn.SIN.eq(csinsaihkKbn)) {

            keisanWExtBean.setSyouhncd(kykSyouhn.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(kykSyouhn.getYoteiriritu());
            keisanWExtBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
            keisanWExtBean.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());
            keisanWExtBean.setHknkkn(kykSyouhn.getHknkkn());
            keisanWExtBean.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());
            keisanWExtBean.setHrkkkn(kykSyouhn.getHrkkkn());
            keisanWExtBean.setHhknnen(kykSyouhn.getHhknnen());
            keisanWExtBean.setHhknsei(kykSyouhn.getHhknsei());
            keisanWExtBean.setKihons(kykSyouhn.getKihons());
            keisanWExtBean.setHokenryou(kykSyouhn.getHokenryou());
            keisanWExtBean.setKykymd(kykSyouhn.getKykymd());
            keisanWExtBean.setTuukasyu(keiyakuTuukasyu);
            keisanWExtBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(kykSyouhn.getKykjyoutai());

        } else {
            KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
            C_ErrorKbn errorKbn = keisanWExt.exec(pKykKihon.getSyono(), pSyoriYmd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(MSGHIKISUU);
            }
            keisanWExtBean = keisanWExt.getKeisanWExtBean();
        }

        C_UmuKbn zennouumu = C_UmuKbn.NONE;
        BizCurrency zennoujihrkp = BizCurrency.valueOf(BigDecimal.ZERO);
        BizDate zennoukaisiymd = null;
        BizDate ryosyuymd = null;
        BizCurrency zennounyuukinkgk = BizCurrency.valueOf(BigDecimal.ZERO);

        if (pZennou != null) {
            zennouumu = C_UmuKbn.ARI;
            zennoujihrkp = pZennou.getZennoujihrkp();
            zennoukaisiymd = pZennou.getZennoukaisiymd();
            ryosyuymd = pZennou.getRyosyuymd();
            zennounyuukinkgk = pZennou.getZennounyuukinkgk();
        }

        WSuiihyouSyuusin3 wSuiihyouSyuusin3 = SWAKInjector.getInstance(WSuiihyouSyuusin3.class);
        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        List<IT_Suiihyou> wsuiihyouLst = new ArrayList<>();

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setKwsratekjymd(pKykKihon.getFstpnyknymd());
        wSuiihyouParam.setCalcKijyunYmd(pEditHokenSyoukenParam.getCalckijyunYMD());
        wSuiihyouParam.setSinsaihkKbn(csinsaihkKbn);
        wSuiihyouParam.setSyoukensaihkKbn(pEditHokenSyoukenParam.getSyoukenSaihk());
        wSuiihyouParam.setZennouUmuKbn(zennouumu);
        wSuiihyouParam.setZennoujiHrkP(zennoujihrkp);
        wSuiihyouParam.setZennouKaisiYmd(zennoukaisiymd);
        wSuiihyouParam.setRyosyuYmd(ryosyuymd);
        wSuiihyouParam.setZennouNyuukingk(zennounyuukinkgk);
        wSuiihyouParam.setSdpd(pKykKihon.getSdpdkbn());
        wSuiihyouParam.setHrkkeiro(pKykKihon.getHrkkeiro());

        if (C_Tuukasyu.JPY.eq(keiyakuTuukasyu)) {
            wSuiihyouSyuusin3.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        }
        wsuiihyouLst = wSuiihyouSyuusin3.exec(wSuiihyouParam);
        sibouSBeanList = wSuiihyouSyuusin3.getSibouSBeanList();

        BizDate syoribiYmd = pSyoriYmd;
        String kinouId = pKkanriCommonParam.getFunctionId();
        String kosinsyaId = pKkanriCommonParam.getUserID();
        String sysTime = BizDate.getSysDateTimeMilli();
        int renzokuSytrykGyo = 10;
        int keikanenKijun_10 = 0;

        if(wsuiihyouLst.size() > 0 &&
            BizDateUtil.compareYmd(wsuiihyouLst.get(0).getCalckijyunymd(), kykSyouhn.getHaraimanymd()) == BizDateUtil.COMPARE_LESSER){
            renzokuSytrykGyo = renzokuSytrykGyo + 1;
        }

        keikanenKijun_10 = renzokuSytrykGyo + 10 - 1;

        for (int index = 0; index < wsuiihyouLst.size(); index++) {

            IT_Suiihyou suiihyou = wsuiihyouLst.get(index);

            if (index < renzokuSytrykGyo) {
                setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
            }
            else if(index == keikanenKijun_10){
                setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, keiyakuTuukasyu, kinouId, kosinsyaId, sysTime);
                keikanenKijun_10 = keikanenKijun_10 + 10;
            }
        }

        if(wsuiihyouLst.size()==0){
            IT_Suiihyou suiihyou = new IT_Suiihyou();

            suiihyou.setSuiihyousyubetu(DUMMYSUIIHYOUSYUBETU);
            suiihyou.setKeikanensuu(DUMMYKEIKANEN);

            setSuiihyouTbl(pKykKihon, suiihyou, syoribiYmd, null, kinouId, kosinsyaId, sysTime);
        }

        logger.debug("△ 推移表TBL編集（終身３） 終了");
    }

    private void setSuiihyouTbl(IT_KykKihon pKykKihon,
        IT_Suiihyou pSuiihyou,
        BizDate pSyoribiYmd,
        C_Tuukasyu pKeiyakuTuukasyu,
        String pKinouId,
        String pKosinsyaId,
        String pSysTime) {

        IT_Suiihyou suiihyou = pKykKihon.createSuiihyou();

        suiihyou.setTyouhyouymd(pSyoribiYmd);
        suiihyou.setKyktuukasyu(pKeiyakuTuukasyu);
        suiihyou.setKeikanensuu(pSuiihyou.getKeikanensuu());
        suiihyou.setCalckijyunymd(pSuiihyou.getCalckijyunymd());
        suiihyou.setCalcym(pSuiihyou.getCalcym());
        suiihyou.setSuiihyousyubetu(pSuiihyou.getSuiihyousyubetu());
        suiihyou.setHrkkknmnryumukbn(pSuiihyou.getHrkkknmnryumukbn());
        suiihyou.setYenknsnkwsrateyendaka(pSuiihyou.getYenknsnkwsrateyendaka());
        suiihyou.setYenknsnkwsrateyenkijyun(pSuiihyou.getYenknsnkwsrateyenkijyun());
        suiihyou.setYenknsnkwsrateyenyasu(pSuiihyou.getYenknsnkwsrateyenyasu());
        suiihyou.setYenknsnkwsrategkyendaka(pSuiihyou.getYenknsnkwsrategkyendaka());
        suiihyou.setYenknsnkwsrategkyenyasu(pSuiihyou.getYenknsnkwsrategkyenyasu());
        suiihyou.setZennouzndkyen1(pSuiihyou.getZennouzndkyen1());
        suiihyou.setZennouzndk1(pSuiihyou.getZennouzndk1());
        suiihyou.setKihrkmpyen1(pSuiihyou.getKihrkmpyen1());
        suiihyou.setKihrkmp1(pSuiihyou.getKihrkmp1());
        suiihyou.setMvanonewsame(pSuiihyou.getMvanonewsame());
        suiihyou.setMvanonewyensameyendaka(pSuiihyou.getMvanonewyensameyendaka());
        suiihyou.setMvanonewyensameyenkijyun(pSuiihyou.getMvanonewyensameyenkijyun());
        suiihyou.setMvanonewyensameyenyasu(pSuiihyou.getMvanonewyensameyenyasu());
        suiihyou.setKaiyakujuktrgk(pSuiihyou.getKaiyakujuktrgk());
        suiihyou.setKaiyakujuktrgkyendaka(pSuiihyou.getKaiyakujuktrgkyendaka());
        suiihyou.setKaiyakujuktrgkyenkijyun(pSuiihyou.getKaiyakujuktrgkyenkijyun());
        suiihyou.setKaiyakujuktrgkyenyasu(pSuiihyou.getKaiyakujuktrgkyenyasu());
        suiihyou.setGyoumuKousinKinou(pKinouId);
        suiihyou.setGyoumuKousinsyaId(pKosinsyaId);
        suiihyou.setGyoumuKousinTime(pSysTime);

        BizPropertyInitializer.initialize(suiihyou);
    }

    public List<SibouSBean> getSibouSBeanList() {
        return sibouSBeanList;
    }

}
