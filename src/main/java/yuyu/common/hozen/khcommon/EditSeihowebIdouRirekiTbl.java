package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 生保Ｗｅｂ用異動履歴ＴＢＬ編集
 */

public class EditSeihowebIdouRirekiTbl {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    private static final String JYUUSYOHENKOU = "住所変更";

    private static final String MEIGIHENKOU = "名義変更";

    private static final String KAIYAKUSYOUMETU = "解約消滅";

    private static final String GENGAKU = "減額";

    private static final String KEIYAKUNAIYOUHENKOU = "契約内容変更";

    private static final String SEINENNGAPPISYOUTEISEI = "生年月日性訂正";

    private static final String HOKENKINNSHIHARAISYOUMETU = "保険金等支払消滅";

    private static final String SYOUKENSAIHAKKOU = "証券再発行";

    private static final String KHKEIYAKUTORIKESI = "契約取消";

    private static final String YENDTHENKOUTARGETGETNIYORUHENKOU = "円建変更（目標到達による変更）";

    private static final String YENDTHENKOUSEIKYUUNIYORUHENKOU = "円建変更（請求による変更）";

    private static final String YENDTHENKOUTORIKESI = "円建変更取消";

    private static final String TMTTKNITENTORIKESI = "積立金移転取消";

    private static final String PHRKHOUHENKOU = "保険料払込方法変更";

    private static final String DATTAIHRKHOUHOUHEN = "脱退（払込方法変更）";

    private static final String DATTAIKEIYAKUHENKOU = "脱退（契約変更）";

    private static final String DATTAIKAIYAKUTOU = "脱退（解約等）";

    private static final String DATTAIOTHER = "脱退（その他）";

    private static final String HAITOUSIHARAI = "配当支払";

    private static final String TMTTKNITEN = "積立金移転";

    public void exec(BizDate pIdouhasseiYmd,
        C_SyoriKbn pSyoriKbn,
        String pHenkousikibetukey,
        String pGyoumuKousinKinou,
        String pGyoumuKousinsyaId,
        String pGyoumuKousinTime,
        IT_KykKihon pKykKihon,
        IT_AnsyuKihon pAnsyuKihon) {

        logger.debug("▽ 生保Ｗｅｂ用異動履歴ＴＢＬ編集 開始");

        String seihowebidoukbnNaiyou1 = getSeihowebIdouKbnNaiyou(pGyoumuKousinKinou,
            pSyoriKbn,
            pAnsyuKihon);

        if (seihowebidoukbnNaiyou1 == null) {

            logger.debug("△ 生保Ｗｅｂ用異動履歴ＴＢＬ編集 終了");
            return;
        }

        List<IT_KykSyouhn> kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizCurrency hokenryou = BizCurrency.valueOf(0);
        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

            KeisanIkkatuPGkBean pKeisanIkkatuPGkBean = new KeisanIkkatuPGkBean();
            pKeisanIkkatuPGkBean.setSyouhnCd(kykSyouhn.get(0).getSyouhncd());
            pKeisanIkkatuPGkBean.setSyouhnsdNo(kykSyouhn.get(0).getSyouhnsdno());
            pKeisanIkkatuPGkBean.setRyouritusdNo(kykSyouhn.get(0).getRyouritusdno());
            pKeisanIkkatuPGkBean.setHokenryou(kykSyouhn.get(0).getHokenryou());
            pKeisanIkkatuPGkBean.setKeikamon(Integer.parseInt(pKykKihon.getTikiktbrisyuruikbn().getValue()));
            pKeisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
            pKeisanIkkatuPGkBean.setTkiktbrisyuruiKbn(pKykKihon.getTikiktbrisyuruikbn());

            KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
            C_ErrorKbn errorKbn= keisanIkkatuPGk.exec(pKeisanIkkatuPGkBean, false);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                logger.warn("一括払Ｐ計算が実行できませんでした。");
                logger.warn("証券番号＝" + pKykKihon.getSyono());

                hokenryou = kykSyouhn.get(0).getHokenryou();
            }
            else {
                hokenryou = keisanIkkatuPGk.getIkkatuP();
            }
        }
        else {
            hokenryou = kykSyouhn.get(0).getHokenryou();
        }
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        C_Tuukasyu tuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(hokenryou.getType());

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);
        IT_SeihowebIdouRireki seihowebIdouRireki = khTtdkRireki.createSeihowebIdouRireki();

        seihowebIdouRireki.setIdouhasseiym(pIdouhasseiYmd.getBizDateYM());
        seihowebIdouRireki.setIdouhasseiymd(pIdouhasseiYmd);
        seihowebIdouRireki.setSeihowebidoukbnnaiyou1(seihowebidoukbnNaiyou1);
        seihowebIdouRireki.setSeihowebidoukbnnaiyou2("");
        seihowebIdouRireki.setDairitencd1(pKykKihon.getKykDairitens().get(0).getDrtencd());
        seihowebIdouRireki.setBosyuucd1(pKykKihon.getKykDairitens().get(0).getBosyuucd());
        seihowebIdouRireki.setDrtenbunumu(pKykKihon.getKykDairitens().get(0).getDrtenbunumu());
        if (C_UmuKbn.ARI.eq(seihowebIdouRireki.getDrtenbunumu())) {
            seihowebIdouRireki.setDairitencd2(pKykKihon.getKykDairitens().get(1).getDrtencd());
            seihowebIdouRireki.setBosyuucd2(pKykKihon.getKykDairitens().get(1).getBosyuucd());
        }
        seihowebIdouRireki.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        seihowebIdouRireki.setTikiktbrisyuruikbn(pKykKihon.getTikiktbrisyuruikbn());
        seihowebIdouRireki.setHrkkeiro(pKykKihon.getHrkkeiro());
        seihowebIdouRireki.setBosyuuym(pKykKihon.getBosyuuym());
        seihowebIdouRireki.setCifcd(pKykKihon.getCifcd());
        if (pKykKihon.getKouza() != null) {
            seihowebIdouRireki.setBankcd(pKykKihon.getKouza().getBankcd());
        }
        seihowebIdouRireki.setJkipjytym(pAnsyuKihon.getJkipjytym());
        seihowebIdouRireki.setKyknmkj(pKykKihon.getKykSya().getKyknmkj());
        seihowebIdouRireki.setSyouhncd(kykSyouhn.get(0).getSyouhncd());
        seihowebIdouRireki.setSyouhnsdno(kykSyouhn.get(0).getSyouhnsdno());
        seihowebIdouRireki.setKykymd(kykSyouhn.get(0).getKykymd());
        seihowebIdouRireki.setHokenryou(hokenryou);
        seihowebIdouRireki.setTuukasyu(tuukaSyu);
        seihowebIdouRireki.setGyoumuKousinKinou(pGyoumuKousinKinou);
        seihowebIdouRireki.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
        seihowebIdouRireki.setGyoumuKousinTime(pGyoumuKousinTime);

        BizPropertyInitializer.initialize(seihowebIdouRireki);
        hozenDomManager.update(pKykKihon);

        logger.debug("△ 生保Ｗｅｂ用異動履歴ＴＢＬ編集 終了");
    }

    private String getSeihowebIdouKbnNaiyou(String pGyoumuKousinKinou,
        C_SyoriKbn pSyoriKbn,
        IT_AnsyuKihon pAnsyuKihon) {

        String seihowebidoukbnNaiyou1 = null;

        if (IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = JYUUSYOHENKOU;
        }
        else if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = MEIGIHENKOU;
        }
        else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pGyoumuKousinKinou) ||
            IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = KAIYAKUSYOUMETU;
        }
        else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = GENGAKU;
        }
        else if (IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA.equals(pGyoumuKousinKinou) ||
            IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK.equals(pGyoumuKousinKinou)){
            seihowebidoukbnNaiyou1 = KEIYAKUNAIYOUHENKOU;
        }
        else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = SEINENNGAPPISYOUTEISEI;
        }
        else if (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(pGyoumuKousinKinou)) {
            if (!C_SyoriKbn.JIKOU.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = HOKENKINNSHIHARAISYOUMETU;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_SYOUKENSAIHAKKOU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = SYOUKENSAIHAKKOU;
        }
        else if (IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = KEIYAKUNAIYOUHENKOU;
        }
        else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = KHKEIYAKUTORIKESI;
        }
        else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(pGyoumuKousinKinou)) {
            if (C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = YENDTHENKOUTARGETGETNIYORUHENKOU;
            }
            else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = YENDTHENKOUSEIKYUUNIYORUHENKOU;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pGyoumuKousinKinou)) {
            if (C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = YENDTHENKOUTORIKESI;
            }
            else if (C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = TMTTKNITENTORIKESI;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(pGyoumuKousinKinou) ||
            IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN .equals(pGyoumuKousinKinou)){

            if(!(C_SyoriKbn.YYKIDOUUKE.eq(pSyoriKbn)) &&
                !(C_SyoriKbn.HRIHENNONE.eq(pSyoriKbn)) &&
                !(C_SyoriKbn.YYKIDOUTORIKESI.eq(pSyoriKbn))){

                seihowebidoukbnNaiyou1 = PHRKHOUHENKOU;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_ONLINEDATTAI.equals(pGyoumuKousinKinou) &&
            C_SyoriKbn.DATTAIUKE.eq(pSyoriKbn)) {

            C_DattairiyuuKbn dattairiyuuKbn = pAnsyuKihon.getDattaiUktk().getDattairiyuukbn();

            if (C_DattairiyuuKbn.HRHENKIBOU.eq(dattairiyuuKbn)) {
                seihowebidoukbnNaiyou1 = DATTAIHRKHOUHOUHEN;
            }
            else if (C_DattairiyuuKbn.KEIYAKUHENKOUARI.eq(dattairiyuuKbn)) {
                seihowebidoukbnNaiyou1 = DATTAIKEIYAKUHENKOU;
            }
            else if (C_DattairiyuuKbn.KAIYAKUKIBOU.eq(dattairiyuuKbn)) {
                seihowebidoukbnNaiyou1 = DATTAIKAIYAKUTOU;
            }
            else {
                seihowebidoukbnNaiyou1 = DATTAIOTHER;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_DATTAI.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = DATTAIHRKHOUHOUHEN;
        }
        else if (IKhozenCommonConstants.KINOUID_DSHR.equals(pGyoumuKousinKinou)) {
            seihowebidoukbnNaiyou1 = HAITOUSIHARAI;
        }
        else if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pGyoumuKousinKinou)) {
            if (C_SyoriKbn.TMTTKNHANEI_ITEN.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = TMTTKNITEN;
            }
        }
        else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pGyoumuKousinKinou)) {
            if (C_SyoriKbn.JIDOUSOUKINSEISANZUMI.eq(pSyoriKbn)) {
                seihowebidoukbnNaiyou1 = KAIYAKUSYOUMETU;
            }
        }

        return seihowebidoukbnNaiyou1;
    }
}
