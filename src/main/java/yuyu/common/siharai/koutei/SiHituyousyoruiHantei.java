package yuyu.common.siharai.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;

/**
 * 保険金給付金支払 工程 支払必要書類判定
 */
public class SiHituyousyoruiHantei {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    public SiHituyousyoruiHantei() {
        super();
    }

    public List<C_SyoruiCdKbn> exec(SiHituyousyoruiHanteiInBean pSiHituyousyoruiHanteiInBean) {

        List<C_SyoruiCdKbn> syoruiCdLst = new ArrayList<>();

        C_SeikyuuSyubetu seikyuuSyubetu = pSiHituyousyoruiHanteiInBean.getSeikyuuSyubetu();

        C_SbjiShrKbn sbjiShrKbn = pSiHituyousyoruiHanteiInBean.getSbjiShrKbn();

        C_UmuKbn dhysntdkUmuKbn = pSiHituyousyoruiHanteiInBean.getDhysntdkUmuKbn();

        C_UmuKbn jisatumensekiumukbn = pSiHituyousyoruiHanteiInBean.getJisatumensekiumukbn();

        C_KyksyaSibouUmuKbn kyksyaSibouUmuKbn = pSiHituyousyoruiHanteiInBean.getKyksyasibouumukbn();

        C_UmuKbn jikojksumukbn = pSiHituyousyoruiHanteiInBean.getJikojksumukbn();

        C_UmuKbn mynumbersinkokuumukbn = pSiHituyousyoruiHanteiInBean.getMynumbersinkokuumukbn();

        C_Tdk kkkyktdk = pSiHituyousyoruiHanteiInBean.getKkkyktdk();

        String kouteiKanriId = pSiHituyousyoruiHanteiInBean.getKouteiKanriId();

        if (C_SeikyuuSyubetu.SB.eq(seikyuuSyubetu)) {

            if (C_SbjiShrKbn.SBHOKENKIN.eq(sbjiShrKbn)) {

                syoruiCdLst.add(C_SyoruiCdKbn.HK_STI_KAS);

                if (C_UmuKbn.ARI.eq(jisatumensekiumukbn)&&
                    C_KyksyaSibouUmuKbn.BLNK.eq(kyksyaSibouUmuKbn)&&
                    !C_Tdk.HONNIN.eq(kkkyktdk)) {


                }else{

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_SB_KOSEKI);
                }

                syoruiCdLst.add(C_SyoruiCdKbn.HK_SB_HONNINSR);

                if (C_UmuKbn.ARI.eq(jisatumensekiumukbn)) {

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

                }else{

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
                }

                if (C_UmuKbn.ARI.eq(dhysntdkUmuKbn)) {

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_SB_DAIHYOU);
                }

                if (C_UmuKbn.ARI.eq(jikojksumukbn)) {

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_JIKOJKS);
                }

                if (C_UmuKbn.ARI.eq(mynumbersinkokuumukbn)) {

                    syoruiCdLst.add(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);
                }
            }
        }

        /*
        else if (C_SeikyuuSyubetu.KOUSG.eq(seikyuuSyubetu)) {

            if (C_UmuKbn.NONE.eq(nstkhukaumukbn)) {

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_SKS);
            }
            else {

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_NKHK_SKS);
            }

            syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_SDS);

            syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_HKNSYKN);

            if (C_GeninKbn.SG.eq(geninKbn)) {

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_JIKOJKS);

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_KTJKSMS);
            }

            syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_HONNINSR);

            if (C_MousideninKbn.STDRNIN.eq(mousideninKbn)) {

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_SITEIDAIRISK);

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_JYUUMIN);

                syoruiCdLst.add(C_SyoruiCdKbn.HK_KD_KOSEKI);
            }
        }
         */

        if (syoruiCdLst.size() > 0) {

            BT_GyoumuKouteiInfo gyoumuKouteiInfo = bizDomManager.getGyoumuKouteiInfo(kouteiKanriId);

            for (C_SyoruiCdKbn syoruiCd : syoruiCdLst) {

                BT_HituyouSyoruiKanri hituyouSyoruiKanri = gyoumuKouteiInfo.createHituyouSyoruiKanri();

                hituyouSyoruiKanri.setSyoruiCd(syoruiCd);

                hituyouSyoruiKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                hituyouSyoruiKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(hituyouSyoruiKanri);
            }

            bizDomManager.update(gyoumuKouteiInfo);
        }

        return syoruiCdLst;
    }
}
