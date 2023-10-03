package yuyu.batch.suuri.srkessan.srskoikmkaikeityusyutu;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.ST_SkOikmKaikei;

/**
 * バッチ機能の項目編集クラス
 */
public class SrSkOikmKaikeiTyusyutuItemEditor {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Execute
    @Transactional
    public void editKoumoku(Iterator<BT_DenpyoData> pDenpyoDataLst,
        SrSkOikmKaikeiTyusyutuBatchParam pSrSkOikmKaikeiTyusyutuBatchParam) {

        try (EntityInserter<ST_SkOikmKaikei> skOikmKaikeiLst = new EntityInserter<>()) {

            while (pDenpyoDataLst.hasNext()) {

                BT_DenpyoData denpyoData = pDenpyoDataLst.next();

                ST_SkOikmKaikei skOikmKaikei = new ST_SkOikmKaikei();

                skOikmKaikei.setDensyskbn(denpyoData.getDensyskbn());

                skOikmKaikei.setDenrenno(denpyoData.getDenrenno());

                skOikmKaikei.setEdano(denpyoData.getEdano());

                skOikmKaikei.setMosno(denpyoData.getKeirisyono());

                skOikmKaikei.setHuridenatesakicd(denpyoData.getHuridenatesakicd());

                skOikmKaikei.setTantocd(denpyoData.getTantocd());

                skOikmKaikei.setDenymd(denpyoData.getDenymd());

                skOikmKaikei.setTaisyakukbn(denpyoData.getTaisyakukbn());

                skOikmKaikei.setKanjyoukmkcd(denpyoData.getKanjyoukmkcd());

                skOikmKaikei.setSuitoubumoncd(denpyoData.getSuitoubumoncd());

                skOikmKaikei.setTuukasyu(denpyoData.getTuukasyu());

                skOikmKaikei.setDengaikagk(denpyoData.getDengaikagk());

                skOikmKaikei.setDenkawaserate(denpyoData.getDenkawaserate());

                skOikmKaikei.setDenyenkagk(denpyoData.getDenyenkagk());

                skOikmKaikei.setSyoriYmd(denpyoData.getSyoriYmd());

                skOikmKaikei.setSyoricd(denpyoData.getSyoricd());

                skOikmKaikei.setSyorisosikicd(denpyoData.getSyorisosikicd());

                skOikmKaikei.setSeg1cd(denpyoData.getSeg1cd());

                skOikmKaikei.setSeg2cd(denpyoData.getSeg2cd());

                skOikmKaikei.setKessantyouseikbn(denpyoData.getKessantyouseikbn());

                skOikmKaikei.setNaibukeiyakukbn(denpyoData.getNaibukeiyakukbn());

                skOikmKaikei.setTekiyoukbn(denpyoData.getTekiyoukbn());

                skOikmKaikei.setDensyorikbn(denpyoData.getDensyorikbn());

                skOikmKaikei.setAatsukaishasuitososhikicd(denpyoData.getAatsukaishasuitososhikicd());

                skOikmKaikei.setHnknriyuukbn(denpyoData.getHnknriyuukbn());

                skOikmKaikei.setFstpryosyuymd(denpyoData.getFstpryosyuymd());

                skOikmKaikei.setBosyuuym(denpyoData.getBosyuuym());

                skOikmKaikei.setMosymd(denpyoData.getMosymd());

                skOikmKaikei.setKykymd(denpyoData.getKykymd());

                skOikmKaikei.setSknnkaisiymd(denpyoData.getSknnkaisiymd());

                skOikmKaikei.setSyusyouhncd(denpyoData.getSyusyouhncd());

                skOikmKaikei.setRyouritusdno(denpyoData.getRyouritusdno());

                skOikmKaikei.setHrkkaisuu(denpyoData.getHrkkaisuu());

                skOikmKaikei.setHrkkeiro(denpyoData.getHrkkeiro());

                skOikmKaikei.setSdpdkbn(denpyoData.getSdpdkbn());

                skOikmKaikei.setAatsukaishasoshikicd(denpyoData.getAatsukaishasoshikicd());

                skOikmKaikei.setAatkisyadaibosyuucd(denpyoData.getAatkisyadaibosyuucd());

                skOikmKaikei.setAatkisyabosyuucd(denpyoData.getAatkisyabosyuucd());

                skOikmKaikei.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                skOikmKaikei.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(skOikmKaikei);

                skOikmKaikeiLst.add(skOikmKaikei);

                pSrSkOikmKaikeiTyusyutuBatchParam.setSyorikensuu(
                    pSrSkOikmKaikeiTyusyutuBatchParam.getSyorikensuu() + 1);
            }
        }
    }
}
