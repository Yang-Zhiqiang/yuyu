package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Znnkaisuukekka;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 前納回数判定
 */
public class HanteiZennouKaisuu {

    public HanteiZennouKaisuu() {
        super();
    }

    public C_Znnkaisuukekka exec(MosnaiCheckParam pMp) {

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        int zennoKaisuu = mosKihon.getZnnkai();
        C_Hrkkaisuu hrkKaisuu = mosKihon.getHrkkaisuu();
        int hhknNen = mosKihon.getHhknnen();

        List<HT_MosSyouhn> syuMosSyouhnParamLst = new ArrayList<>();
        List<HT_MosSyouhn> tokMosSyouhnParamLst = new ArrayList<>();
        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

        syuMosSyouhnParamLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuMosSyouhnParamLst.size() == 0) {

            throw new CommonBizAppException("申込商品テーブルが存在しません。");
        }

        int syuZennoKkn = 0;
        int syuZennoKaisuu = 0;

        C_ErrorKbn syuConvNenSaiMankiResult = convNenSaiManki.convHrkkknNen(syuMosSyouhnParamLst.get(0).getHrkkkn(),
                                                                             syuMosSyouhnParamLst.get(0).getHrkkknsmnkbn(),
                                                                             hhknNen);

        if (C_ErrorKbn.OK.eq(syuConvNenSaiMankiResult)) {
            syuZennoKkn = convNenSaiManki.getHrkkknNen();
        }else{
            syuZennoKkn = 0;
        }

        if (syuZennoKkn != 0) {
            syuZennoKaisuu = syuZennoKkn - 1;
        }

        tokMosSyouhnParamLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        int tokMinZennoKkn = 0;
        int tokZennoKaisuu  = 0;

        if (tokMosSyouhnParamLst.size() > 0) {

            int tokZennoKkn = 0;
            int count = 0;

            for (HT_MosSyouhn mosSyouhnParam : tokMosSyouhnParamLst) {

                if (mosSyouhnParam.getHrkkkn() != 0) {
                    count = count + 1;

                    C_ErrorKbn tokConvNenSaiMankiResult = convNenSaiManki.convHrkkknNen(mosSyouhnParam.getHrkkkn(),
                                                                                         mosSyouhnParam.getHrkkknsmnkbn(),
                                                                                         hhknNen);

                    if (C_ErrorKbn.OK.eq(tokConvNenSaiMankiResult)) {
                        tokZennoKkn = convNenSaiManki.getHrkkknNen();
                    }else{
                        tokZennoKkn = 0;
                    }

                    if (count == 1) {

                        tokMinZennoKkn = tokZennoKkn;
                    }
                    else {
                        if (tokMinZennoKkn > tokZennoKkn) {
                            tokMinZennoKkn = tokZennoKkn;
                        }
                    }
                }
            }

            if (tokMinZennoKkn != 0) {
                tokZennoKaisuu = tokMinZennoKkn - 1;
            }
        }

        C_BlnktkumuKbn zenkizennouumu = mosKihon.getZenkizennouumu();

        if (tokMinZennoKkn == 0 || syuZennoKkn <= tokMinZennoKkn) {

            if (C_BlnktkumuKbn.ARI.eq(zenkizennouumu)  && syuZennoKaisuu != zennoKaisuu) {

                return C_Znnkaisuukekka.ZENKI_ARI_HUITTI;
            }
            else if (C_BlnktkumuKbn.NONE.eq(zenkizennouumu) && syuZennoKaisuu == zennoKaisuu) {

                return C_Znnkaisuukekka.ZENKI_NASI_ITTI;
            }
            else if (syuZennoKaisuu == zennoKaisuu) {

                return C_Znnkaisuukekka.ZENKI;
            }
            else if (syuZennoKaisuu > zennoKaisuu) {

                return C_Znnkaisuukekka.ITIBU;
            }
            else {

                return C_Znnkaisuukekka.OVER;
            }
        }

        if (C_BlnktkumuKbn.ARI.eq(zenkizennouumu) && tokZennoKaisuu != zennoKaisuu) {

            return C_Znnkaisuukekka.TKZENKI_ARI_HUITTI;
        }
        else if (C_BlnktkumuKbn.NONE.eq(zenkizennouumu) && tokZennoKaisuu == zennoKaisuu) {

            return C_Znnkaisuukekka.TKZENKI_NASI_ITTI;
        }
        else if (tokZennoKaisuu >= zennoKaisuu) {

            return C_Znnkaisuukekka.ITIBU;
        }

        return C_Znnkaisuukekka.TKOVER;
    }
}
