package yuyu.batch.suuri.srkessan.srskkessanoikmdata;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.batch.suuri.srkessan.srskkessanoikmdata.SrSkKessanOikmDataBatchParam;

/**
 * バッチ機能の項目編集クラス
 */
public class SrSkKessanOikmDataItemEditor {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Execute
    @Transactional
    public void editKoumoku(Iterator<ST_SkOikmTyouseiDenpyou> pSkOikmTyouseiDenpyouLst,
        SrSkKessanOikmDataBatchParam pSrSkKessanOikmDataBatchParam) {

        try (EntityInserter<ST_SkKessanSyukei> skKessanSyukeiLst = new EntityInserter<>()) {

            while (pSkOikmTyouseiDenpyouLst.hasNext()) {

                ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou = pSkOikmTyouseiDenpyouLst.next();

                BizDate denYMD = pSrSkKessanOikmDataBatchParam.getIbKsnsaisyueigyoubiymd();

                C_KeirisysKbn keiriSysKbn = C_KeirisysKbn.KESSANSINKEIYAKU;

                ST_SkKessanSyukei skKessanSyukeiTkmDen = new ST_SkKessanSyukei();

                skKessanSyukeiTkmDen.setMosno(skOikmTyouseiDenpyou.getMosno());

                skKessanSyukeiTkmDen.setDenymd(denYMD);

                skKessanSyukeiTkmDen.setKanjyoukmkcd(skOikmTyouseiDenpyou.getKanjyoukmkcd());

                skKessanSyukeiTkmDen.setTaisyakukbn(skOikmTyouseiDenpyou.getTaisyakukbn());

                skKessanSyukeiTkmDen.setNaibukeiyakukbn(skOikmTyouseiDenpyou.getNaibukeiyakukbn());

                skKessanSyukeiTkmDen.setTekiyoukbn(skOikmTyouseiDenpyou.getTekiyoukbn());

                skKessanSyukeiTkmDen.setSeg1cd(skOikmTyouseiDenpyou.getSeg1cd());

                skKessanSyukeiTkmDen.setKeirisyskbn(keiriSysKbn);

                skKessanSyukeiTkmDen.setHuridenatesakicd(skOikmTyouseiDenpyou.getHuridenatesakicd());

                skKessanSyukeiTkmDen.setTantocd(skOikmTyouseiDenpyou.getTantocd());

                skKessanSyukeiTkmDen.setDenkanjokamokucd(skOikmTyouseiDenpyou.getDenkanjokamokucd());

                skKessanSyukeiTkmDen.setTekiyoucd(skOikmTyouseiDenpyou.getTekiyoucd());

                skKessanSyukeiTkmDen.setSuitoubumoncd(skOikmTyouseiDenpyou.getSuitoubumoncd());

                skKessanSyukeiTkmDen.setDenyenkagk(skOikmTyouseiDenpyou.getDenyenkagk());

                skKessanSyukeiTkmDen.setHuridenpagekbn(skOikmTyouseiDenpyou.getHuridenpagekbn());

                skKessanSyukeiTkmDen.setSyoriYmd(pSrSkKessanOikmDataBatchParam.getSyoriYmd());

                skKessanSyukeiTkmDen.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                skKessanSyukeiTkmDen.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skKessanSyukeiTkmDen);

                skKessanSyukeiLst.add(skKessanSyukeiTkmDen);

                pSrSkKessanOikmDataBatchParam.setIbSyorikensuu(pSrSkKessanOikmDataBatchParam.getIbSyorikensuu() + 1);

                ST_SkKessanSyukei skKessanSyukeiGkDen = new ST_SkKessanSyukei();

                denYMD = pSrSkKessanOikmDataBatchParam.getIbKsnyokugetu1steigyoubiymd();

                keiriSysKbn = C_KeirisysKbn.KESSANSINKEIYAKU;

                C_TaisyakuKbn taisyakuKbn = C_TaisyakuKbn.BLNK;

                if (C_TaisyakuKbn.KARIKATA.eq(skOikmTyouseiDenpyou.getTaisyakukbn())) {

                    taisyakuKbn = C_TaisyakuKbn.KASIKATA;
                }
                else {

                    taisyakuKbn = C_TaisyakuKbn.KARIKATA;
                }

                skKessanSyukeiGkDen.setMosno(skOikmTyouseiDenpyou.getMosno());

                skKessanSyukeiGkDen.setDenymd(denYMD);

                skKessanSyukeiGkDen.setKanjyoukmkcd(skOikmTyouseiDenpyou.getKanjyoukmkcd());

                skKessanSyukeiGkDen.setTaisyakukbn(taisyakuKbn);

                skKessanSyukeiGkDen.setNaibukeiyakukbn(skOikmTyouseiDenpyou.getNaibukeiyakukbn());

                skKessanSyukeiGkDen.setTekiyoukbn(skOikmTyouseiDenpyou.getTekiyoukbn());

                skKessanSyukeiGkDen.setSeg1cd(skOikmTyouseiDenpyou.getSeg1cd());

                skKessanSyukeiGkDen.setKeirisyskbn(keiriSysKbn);

                skKessanSyukeiGkDen.setHuridenatesakicd(skOikmTyouseiDenpyou.getHuridenatesakicd());

                skKessanSyukeiGkDen.setTantocd(skOikmTyouseiDenpyou.getTantocd());

                skKessanSyukeiGkDen.setDenkanjokamokucd(skOikmTyouseiDenpyou.getDenkanjokamokucd());

                skKessanSyukeiGkDen.setTekiyoucd(skOikmTyouseiDenpyou.getTekiyoucd());

                skKessanSyukeiGkDen.setSuitoubumoncd(skOikmTyouseiDenpyou.getSuitoubumoncd());

                skKessanSyukeiGkDen.setDenyenkagk(skOikmTyouseiDenpyou.getDenyenkagk());

                skKessanSyukeiGkDen.setHuridenpagekbn(skOikmTyouseiDenpyou.getHuridenpagekbn());

                skKessanSyukeiGkDen.setSyoriYmd(pSrSkKessanOikmDataBatchParam.getSyoriYmd());

                skKessanSyukeiGkDen.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                skKessanSyukeiGkDen.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skKessanSyukeiGkDen);

                skKessanSyukeiLst.add(skKessanSyukeiGkDen);

                pSrSkKessanOikmDataBatchParam.setIbSyorikensuu(pSrSkKessanOikmDataBatchParam.getIbSyorikensuu() + 1);
            }
        }
    }
}
