package yuyu.batch.suuri.srkessan.srskoikmtyouseidenpyotyusyutu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;

/**
 * バッチ機能の項目編集クラス
 */
public class SrSkOikmTyouseiDenpyoTyusyutuItemEditor {

    private String mosNo = "";

    private C_Kanjyoukmkcd kanjyouKmkCd = C_Kanjyoukmkcd.BLNK;

    private C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;

    private C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;

    private C_Segcd seg1Cd = C_Segcd.BLNK;

    private String huriDenAtesakiCd = "";

    private C_TantouCdKbn tantoCd = C_TantouCdKbn.BLNK0;

    private String suitouBumonCd = "";

    private SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean skOikmKaikeiKarikata =
        new SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(mosNo, kanjyouKmkCd, C_TaisyakuKbn.BLNK, naibuKeiyakuKbn,
            tekiyouKbn, seg1Cd, huriDenAtesakiCd, tantoCd, suitouBumonCd, "YEN", BigDecimal.valueOf(0), "");

    private SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean skOikmKaikeiKasikata =
        new SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(mosNo, kanjyouKmkCd, C_TaisyakuKbn.BLNK, naibuKeiyakuKbn,
            tekiyouKbn, seg1Cd, huriDenAtesakiCd, tantoCd, suitouBumonCd, "YEN", BigDecimal.valueOf(0), "");

    @Inject
    private SuuriDomManager suuriDomManager;

    @Execute
    @Transactional
    public List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> changeKanjyoukmkcd(
        Iterator<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> pSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst,
        List<ST_ConvertKanjyouKamoku> pConvertKanjyouKamokuLst) {

        List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean>
        skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanList = new ArrayList<>();

        while (pSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.hasNext()) {

            SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean =
                pSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.next();

            ST_ConvertKanjyouKamoku convertKanjyouKamoku =
                suuriDomManager.getConvertKanjyouKamoku(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getKanjyoukmkcd(),
                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTaisyakukbn());

            if (convertKanjyouKamoku != null) {

                BM_KanjyouKamoku kanjyouKamoku = convertKanjyouKamoku.getKanjyouKamokuConverted();

                skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.setKanjyoukmkcd(kanjyouKamoku.getKanjyoukmkcd());
            }

            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanList.add(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean);
        }

        return skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanList;
    }

    @Execute
    @Transactional
    public List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> editKoumoku(
        List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> pSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst) {

        List<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean>
        skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst = new ArrayList<>();

        for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean :
            pSkOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst) {

            if (mosNo.equals(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getMosno()) &&
                kanjyouKmkCd.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getKanjyoukmkcd()) &&
                naibuKeiyakuKbn.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getNaibukeiyakukbn()) &&
                tekiyouKbn.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTekiyoukbn()) &&
                seg1Cd.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSeg1cd()) &&
                huriDenAtesakiCd.equals(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getHuridenatesakicd()) &&
                tantoCd.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTantocd()) &&
                suitouBumonCd.equals(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSuitoubumoncd())) {

                if (C_TaisyakuKbn.KARIKATA.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTaisyakukbn())) {

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.setDenyenkagk(
                        skOikmKaikeiKarikata.getDenyenkagk().add(
                            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getDenyenkagk()));

                    skOikmKaikeiKarikata = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
                }
                else if (C_TaisyakuKbn.KASIKATA.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTaisyakukbn())) {

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.setDenyenkagk(
                        skOikmKaikeiKasikata.getDenyenkagk().add(
                            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getDenyenkagk()));

                    skOikmKaikeiKasikata = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
                }
            }
            else {

                if (skOikmKaikeiKarikata.getDenyenkagk().compareTo(skOikmKaikeiKasikata.getDenyenkagk()) > 0) {

                    skOikmKaikeiKarikata.setDenyenkagk(
                        skOikmKaikeiKarikata.getDenyenkagk().subtract(skOikmKaikeiKasikata.getDenyenkagk()));

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.add(skOikmKaikeiKarikata);
                }
                else if (skOikmKaikeiKarikata.getDenyenkagk().compareTo(skOikmKaikeiKasikata.getDenyenkagk()) < 0) {

                    skOikmKaikeiKasikata.setDenyenkagk(
                        skOikmKaikeiKasikata.getDenyenkagk().subtract(skOikmKaikeiKarikata.getDenyenkagk()));

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.add(skOikmKaikeiKasikata);
                }

                mosNo = "";

                kanjyouKmkCd = C_Kanjyoukmkcd.BLNK;

                naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;

                tekiyouKbn = C_TekiyouKbn.BLNK;

                seg1Cd = C_Segcd.BLNK;

                huriDenAtesakiCd = "";

                tantoCd = C_TantouCdKbn.BLNK0;

                suitouBumonCd = "";

                skOikmKaikeiKarikata = new SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(mosNo, kanjyouKmkCd,
                    C_TaisyakuKbn.BLNK, naibuKeiyakuKbn, tekiyouKbn, seg1Cd, huriDenAtesakiCd, tantoCd,
                    suitouBumonCd, "YEN", BigDecimal.valueOf(0), "");

                skOikmKaikeiKasikata = new SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean(mosNo, kanjyouKmkCd,
                    C_TaisyakuKbn.BLNK, naibuKeiyakuKbn, tekiyouKbn, seg1Cd, huriDenAtesakiCd, tantoCd,
                    suitouBumonCd, "YEN", BigDecimal.valueOf(0), "");

                if (C_TaisyakuKbn.KARIKATA.eq(skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTaisyakukbn())) {

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.setDenyenkagk(
                        skOikmKaikeiKarikata.getDenyenkagk().add(
                            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getDenyenkagk()));

                    skOikmKaikeiKarikata = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
                }
                else {

                    skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.setDenyenkagk(
                        skOikmKaikeiKasikata.getDenyenkagk().add(
                            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getDenyenkagk()));

                    skOikmKaikeiKasikata = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
                }

                mosNo = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getMosno();

                kanjyouKmkCd = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getKanjyoukmkcd();

                naibuKeiyakuKbn = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getNaibukeiyakukbn();

                tekiyouKbn = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTekiyoukbn();

                seg1Cd = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSeg1cd();

                huriDenAtesakiCd = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getHuridenatesakicd();

                tantoCd = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getTantocd();

                suitouBumonCd = skOikmKaikeiTyouseiDensByDenymdSyoriYmdBean.getSuitoubumoncd();
            }
        }

        if (skOikmKaikeiKarikata.getDenyenkagk().compareTo(skOikmKaikeiKasikata.getDenyenkagk()) > 0) {

            skOikmKaikeiKarikata.setDenyenkagk(
                skOikmKaikeiKarikata.getDenyenkagk().subtract(skOikmKaikeiKasikata.getDenyenkagk()));

            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.add(skOikmKaikeiKarikata);
        }
        else if (skOikmKaikeiKarikata.getDenyenkagk().compareTo(skOikmKaikeiKasikata.getDenyenkagk()) < 0) {

            skOikmKaikeiKasikata.setDenyenkagk(
                skOikmKaikeiKasikata.getDenyenkagk().subtract(skOikmKaikeiKarikata.getDenyenkagk()));

            skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst.add(skOikmKaikeiKasikata);
        }

        return skOikmKaikeiTyouseiDensByDenymdSyoriYmdBeanLst;
    }
}
