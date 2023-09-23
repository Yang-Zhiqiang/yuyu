package yuyu.common.hozen.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Hubidataumu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;

/**
 * 契約保全 工程 契約保全必要書類判定
 */
public class KhHituyousyoruiHantei {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    public KhHituyousyoruiHantei() {
        super();
    }

    public List<C_SyoruiCdKbn> exec(KhHituyousyoruiHanteiInBean pKhHituyousyoruiHanteiInBean) {

        List<C_SyoruiCdKbn> syoruiCdList = new ArrayList<>();

        String jimuTetuzukiCd = pKhHituyousyoruiHanteiInBean.getJimutetuzukiCd();

        if (IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_ADRHNK_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_ADRHNK_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_MEIGIHNK_SKS);

                if (C_UmuKbn.ARI.eq(pKhHituyousyoruiHanteiInBean.getDaisennintdkUmuKbn())) {

                    syoruiCdList.add(C_SyoruiCdKbn.KK_MEIGIHNK_DAIHYOUSN);
                }

                if (C_UmuKbn.ARI.eq(pKhHituyousyoruiHanteiInBean.getTrhkjikakUmuKbn())) {

                    syoruiCdList.add(C_SyoruiCdKbn.KK_MEIGIHNK_TORIHIKIKAK);
                }
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_MEIGIHNK_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KAIYAKU_SKS);

                if (C_UmuKbn.ARI.eq(pKhHituyousyoruiHanteiInBean.getDaisennintdkUmuKbn())) {

                    syoruiCdList.add(C_SyoruiCdKbn.KK_KAIYAKU_DAIHYOUSN);
                }
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KAIYAKU_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_GENGAKU_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_GENGAKU_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_SEINENGAPPISEI_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_SYOSAIHK_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_SYOSAIHK_HB);
            }
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO.equals(jimuTetuzukiCd)) {

            if (C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_SBKAIJYO_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(jimuTetuzukiCd)) {

            if (C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KYKTORIKESI_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO.equals(jimuTetuzukiCd)) {

            if (C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KAIJYO_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF.equals(jimuTetuzukiCd)) {

            if (C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_CLGOFF_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU.equals(jimuTetuzukiCd)) {

            if (C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_MUKOU_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_STDRHNK_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_STDRHNK_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU.equals(jimuTetuzukiCd)) {
            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_MKHGKHNK_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_MKHGKHNK_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_TUMITATEKINITEN_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_TUMITATEKINITEN_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_SKS);

                if (C_UmuKbn.ARI.eq(pKhHituyousyoruiHanteiInBean.getDaisennintdkUmuKbn())) {

                    syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_DAIHYOUSN);
                }
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                syoruiCdList.add(C_SyoruiCdKbn.KK_DSHR_SKS);
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.KK_DSHR_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU.equals(jimuTetuzukiCd)) {

            if (!C_Hubidataumu.ARI.eq(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {

                if (C_UmuKbn.ARI.eq(pKhHituyousyoruiHanteiInBean.getHrkkeirohnkUmuKbn())) {

                    if (C_Hrkkeiro.KOUHURI.eq(pKhHituyousyoruiHanteiInBean.getHenkougoHrkkeiro())) {

                        syoruiCdList.add(C_SyoruiCdKbn.AS_PKZHRIKEIRAI);
                    }
                    else if (C_Hrkkeiro.CREDIT.eq(pKhHituyousyoruiHanteiInBean.getHenkougoHrkkeiro())) {

                        syoruiCdList.add(C_SyoruiCdKbn.AS_CREDITCARDMOS);
                    }
                }
                else {

                    syoruiCdList.add(C_SyoruiCdKbn.AS_PHRKKAISUUHENKOUMOS);
                }
            }
            else {

                syoruiCdList.add(C_SyoruiCdKbn.AS_HRHN_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI.equals(jimuTetuzukiCd)) {
            if (!C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_SKS);
            }
            else {
                syoruiCdList.add(C_SyoruiCdKbn.KK_YENDTHNK_NINI_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI.equals(jimuTetuzukiCd)) {
            if (C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_SBMUKOU_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI.equals(jimuTetuzukiCd)) {
            if (C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK.equals(jimuTetuzukiCd)) {
            if (C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_SBMENSEKI_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI.equals(jimuTetuzukiCd)) {
            if (C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HB);
            }
        }
        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK.equals(jimuTetuzukiCd)) {
            if (!C_Hubidataumu.ARI.equals(pKhHituyousyoruiHanteiInBean.getHubidataUmu())) {
                syoruiCdList.add(C_SyoruiCdKbn.KK_KZKTRKKYKDRTKYKHNK_SKS);
            }
            else {
                syoruiCdList.add(C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HB);
            }
        }

        if (syoruiCdList.size() > 0) {

            BT_GyoumuKouteiInfo gyoumuKouteiInfo =
                bizDomManager.getGyoumuKouteiInfo(pKhHituyousyoruiHanteiInBean.getKouteikanriId());

            for (C_SyoruiCdKbn syoruiCd : syoruiCdList) {

                BT_HituyouSyoruiKanri hituyouSyoruiKanri = gyoumuKouteiInfo.createHituyouSyoruiKanri();

                hituyouSyoruiKanri.setSyoruiCd(syoruiCd);
                hituyouSyoruiKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                hituyouSyoruiKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(hituyouSyoruiKanri);
            }

            bizDomManager.update(gyoumuKouteiInfo);
        }

        return syoruiCdList;
    }
}
