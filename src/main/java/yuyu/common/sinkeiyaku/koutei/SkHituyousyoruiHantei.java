package yuyu.common.sinkeiyaku.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.infr.entity.YuyuEntityUtil;

/**
 * 新契約 工程 新契約必要書類判定
 */
public class SkHituyousyoruiHantei {

    @Inject
    private static Logger logger;

    @Inject
    private BaseUserInfo baseUserInfo;

    private List<String> huyousyoruiValueList;

    public SkHituyousyoruiHantei() {
        super();
    }

    public List<String> getHuyousyoruiValueList () {
        return huyousyoruiValueList;
    }

    public void exec(MosnaiCheckParam pMP) {

        logger.debug("▽ 新契約必要書類判定 開始");

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();

        C_SkeijimuKbn skijimuKbn = syoriCTL.getSkeijimukbn();

        List<HT_Uketorinin> sibouUketorininLst = new ArrayList<>();

        C_UktKbn uktKbn = C_UktKbn.BLNK;

        C_Tdk uktTdk = C_Tdk.BLNK;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        List<C_SyoruiCdKbn> syoruiCdKbnLst = new ArrayList<>();

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriLst = new ArrayList<>();

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = pMP.getGyoumuKouteiInfo();

        C_SntkhouKbn sntkhouKbn = C_SntkhouKbn.BLNK;

        C_FatcasnsiKbn fatcasnsiKbn = C_FatcasnsiKbn.BLNK;

        C_BikkjnssinfoKbn bikkjnssinfoKbn = C_BikkjnssinfoKbn.BLNK;

        C_AeoisnsiKbn aeoiSnsiKbn = C_AeoisnsiKbn.BLNK;

        C_Tdk kykTdk = C_Tdk.BLNK;

        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_PplessrendoukouhurikousouKbn pplessrendoukouhurikousouKbn = null;

        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();

        C_KzhuritourokuhouKbn kzhuritourokuhouKbn = C_KzhuritourokuhouKbn.BLNK;

        C_UmuKbn daihituUmukbn = C_UmuKbn.NONE;

        if (gyoumuKouteiInfo != null) {

            if (uketorininLst.size() > 0) {

                for (HT_Uketorinin uketorinin : uketorininLst) {

                    C_UktsyuKbn uktsyuKbn = uketorinin.getUktsyukbn();

                    if (C_UktsyuKbn.SBUKT.eq(uktsyuKbn)) {

                        sibouUketorininLst.add(uketorinin);
                    }
                }
            }

            C_MosUketukeKbn mosUketukeKbn = syoriCTL.getMosuketukekbn();

            C_KykkakjkKbn kykkakjkKbn = syoriCTL.getKykkakjkkbn();

            if (kouzaJyouhou != null) {

                kzhuritourokuhouKbn = kouzaJyouhou.getKzhuritourokuhoukbn();
            }

            if (mosKihon != null) {
                sntkhouKbn = mosKihon.getSntkhoukbn();

                fatcasnsiKbn = mosKihon.getFatcasnsikbn();

                bikkjnssinfoKbn = mosKihon.getBikkjnssinfokbn();

                aeoiSnsiKbn = mosKihon.getAeoisnsikbn();

                kykTdk = mosKihon.getKyktdk();

                hrkkeiro = mosKihon.getHrkkeiro();

                pplessrendoukouhurikousouKbn = mosKihon.getPplsrendoukouhurikousoukbn();

                daihituUmukbn = mosKihon.getDaihituumukbn();

            }

            if (C_MosUketukeKbn.PAPERLESS.eq(mosUketukeKbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO);
                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO);

                if (C_SntkhouKbn.KKT.eq(sntkhouKbn)) {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_PPLESSKOKUSYO);

                }

                if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

                    if (C_KzhuritourokuhouKbn.SYOMEN.eq(kzhuritourokuhouKbn) ||
                        (C_KzhuritourokuhouKbn.BLNK.eq(kzhuritourokuhouKbn) &&
                            !C_PplessrendoukouhurikousouKbn.NONE.eq(pplessrendoukouhurikousouKbn))) {

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO);
                    }
                }
            }
            if (!C_MosUketukeKbn.PAPERLESS.eq(mosUketukeKbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_MOSSYO);
                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_TORIHOUSYO);
                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_IKOUKAKSYO);

                if (C_SntkhouKbn.KKT.eq(sntkhouKbn)) {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_KOKUSYO);

                }

                if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO);
                }
            }

            if (C_KykkakjkKbn.KETMAE_KAKUNIN.eq(kykkakjkKbn)
                || C_KykkakjkKbn.KETHORYU_KAKUNIN.eq(kykkakjkKbn)
                || C_KykkakjkKbn.KAKUNIN_SUMI.eq(kykkakjkKbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO);
            }

            if (C_FatcasnsiKbn.GAITOU.eq(fatcasnsiKbn) || C_BikkjnssinfoKbn.ARI.eq(bikkjnssinfoKbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_FATCAKAKUNINSYO);

            }

            if (C_AeoisnsiKbn.GAITOU.eq(aeoiSnsiKbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_AEOISINKITODOKEDESYO);
            }


            if (mosKihon != null) {
                if (mosKihon.getSbuktnin() >= 5) {

                    syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI);
                }
            }

            for (HT_Uketorinin sibouUketorinin : sibouUketorininLst) {

                uktKbn = sibouUketorinin.getUktkbn();

                uktTdk = sibouUketorinin.getUkttdk();

                if (C_Tdk.SONOTA.eq(uktTdk) || (C_UktKbn.KYK.eq(uktKbn) && C_Tdk.SONOTA.eq(kykTdk))) {

                    if(C_SkeijimuKbn.SMBC.eq(skijimuKbn)) {

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_DAISANSYAUKTHOUSYO);
                    }
                    else if (!C_SkeijimuKbn.BLNK.eq(skijimuKbn)) {

                        syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_UKTJIZENSYOUKAI);
                    }

                    break;
                }

            }

            if (C_UmuKbn.ARI.eq(daihituUmukbn)) {

                syoruiCdKbnLst.add(C_SyoruiCdKbn.SK_DAIHITUHOUKOKUSYO);
            }

            if (syoruiCdKbnLst.size() > 0) {

                for (C_SyoruiCdKbn syoruiCdKbn : syoruiCdKbnLst) {

                    BT_HituyouSyoruiKanri hituyouSyoruiKanri = new BT_HituyouSyoruiKanri();

                    hituyouSyoruiKanri.setKouteikanriid(gyoumuKouteiInfo.getKouteikanriid());

                    hituyouSyoruiKanri.setSyoruiCd(syoruiCdKbn);

                    hituyouSyoruiKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    hituyouSyoruiKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    hituyouSyoruiKanriLst.add(hituyouSyoruiKanri);
                }
            }

            YuyuEntityUtil.entityReplace(gyoumuKouteiInfo.getHituyouSyoruiKanris(), hituyouSyoruiKanriLst);

        }

        huyousyoruiValueList = new ArrayList<String>();

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            huyousyoruiValueList.add(C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue());
        }

        logger.debug("△ 新契約必要書類判定 終了");
    }

}
