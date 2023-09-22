package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 契約確認該当判定
 */
public class HanteiKykKakunin {

    private final String[] syokugyoucdList = {"060", "340", "620", "660", "670", "680", "710", "830", "840"};

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SetHutuuSibouS setHutuuSibouS;

    public HanteiKykKakunin() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        boolean sbSkjnFlg = false;
        String kykkakkjnSibouSComma = null;
        String msgSyokugyouCd = null;
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        C_KykkakjkKbn kykkakjkKbn = syoriCTL.getKykkakjkkbn();

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 契約確認該当判定 開始");
        }

        if (C_KykkakjkKbn.NONE.eq(kykkakjkKbn) || C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY.eq(kykkakjkKbn)) {

            HT_MosKihon mosKihon = syoriCTL.getMosKihon();
            List<HT_MosSyouhn> mosSyouhinLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

            if (mosSyouhinLst == null || mosSyouhinLst.size() == 0) {

                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(mosSyouhinLst.get(0).getSyouhncd(),
                mosSyouhinLst.get(0).getSyouhnsdno());

            if (C_UmuKbn.NONE.eq(mosKihon.getKakukisyouryakukbumukbn())
                && C_UmuKbn.NONE.eq(syouhnZokusei.getNkhknumu())
                && C_UmuKbn.NONE.eq(syouhnZokusei.getSougouiryhsyumu())) {

                BizCurrency kykKakKjnSbS = YuyuSinkeiyakuConfig.getInstance().getKykKakKjnSbS();
                kykkakkjnSibouSComma = BizUtil.comma(kykKakKjnSbS.toString(), 0, BizUtil.DECIMAL_KETASUU_ROUND);
                BizCurrency seitoufstpkei = mosKihon.getSeitoufstpkei();
                BizCurrency sibouSGoukei = setHutuuSibouS.exec(pMP);
                C_Tuukasyu tuukaSyu = mosKihon.getKyktuukasyu();
                BizDate mosYmd = mosKihon.getMosymd();
                BizCurrency hoshouGK = null;
                BizCurrency yenKansanHoshouGK = null;

                hoshouGK = sibouSGoukei.subtract(seitoufstpkei);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(tuukaSyu);

                if (hoshouGK.compareTo(BizCurrency.valueOf(0, currencyType)) < 0) {

                    hoshouGK = BizCurrency.valueOf(0, currencyType);
                }

                GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector.getInstance(GetKiteiCheckYenkansangk.class);

                yenKansanHoshouGK = getKiteiCheckYenkansangk.exec(mosYmd, hoshouGK, tuukaSyu);

                if (yenKansanHoshouGK.compareTo(kykKakKjnSbS) > 0 &&
                    !C_Hrkkaisuu.ITIJI.eq(mosKihon.getHrkkaisuu()) && !C_Hrkkaisuu.BLNK.eq(mosKihon.getHrkkaisuu())) {

                    for (String syokugyouCd : syokugyoucdList) {

                        if (syokugyouCd.equals(mosKihon.getHhknsykgycd())) {

                            sbSkjnFlg = true;
                            msgSyokugyouCd = syokugyouCd;
                            break;
                        }
                    }
                }

                if (sbSkjnFlg) {

                    syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN);

                    pMP.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.YOU);

                    List<String> kykKakuninMsgLst = pMP.getListKykKakuninMsg();

                    if (sbSkjnFlg) {

                        String msgSyokugyouNm = "";

                        BM_Syokugyou syokugyou = bizDomManager.getSyokugyou(msgSyokugyouCd);

                        if (syokugyou != null) {
                            msgSyokugyouNm = syokugyou.getSyokugyounm();
                        } else {
                            msgSyokugyouNm = msgSyokugyouCd;
                        }

                        kykKakuninMsgLst.add(MessageUtil.getMessage(MessageId.IHA1002, kykkakkjnSibouSComma, msgSyokugyouNm));

                        if (logger.isDebugEnabled()) {
                            logger.debug("→" + MessageUtil.getMessage(MessageId.IHA1002, kykkakkjnSibouSComma, msgSyokugyouNm));
                        }
                    }
                }
                else {

                    syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
                }
            }
            else {
                syoriCTL.setKykkakjkkbn(C_KykkakjkKbn.KETMAE_KAKUNIN_TAISY);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 契約確認該当判定 終了");
        }
    }
}
