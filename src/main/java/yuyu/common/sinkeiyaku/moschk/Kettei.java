package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_ImusateijyouKbn;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TkjysydksyhyKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_ImusateiRireki;
import yuyu.def.sinkeiyaku.sorter.SortHT_KnksateiRireki;

/**
 * 新契約 申込内容チェック 決定処理
 */
public class Kettei {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private static Logger logger;

    public Kettei() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 決定処理 開始");
            logger.debug("｜ MP処理コントロールTBL・決定状態区分 = " +
                pMP.getDataSyoriControl().getKetteikbn());
        }
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        String daimosNo = syoriCTL.getDaimosno();
        C_SntkhouKbn sntkHouKbn = syoriCTL.getMosKihon().getSntkhoukbn();
        C_KetteiKbn ketteiKbn = syoriCTL.getKetteikbn();
        C_KnkysateijyouKbn knkySateiJyouKbn = syoriCTL.getKnkysateijyoukbn();
        C_ImusateijyouKbn imuSateiJyouKbn = syoriCTL.getImusateijyoukbn();

        if (C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {
            int renNo_Max = 0;

            List<HT_DakuhiKettei> dakuhiKetteiLst = syoriCTL.getDakuhiKetteis();
            if (dakuhiKetteiLst == null || dakuhiKetteiLst.size() == 0) {
                renNo_Max = 1;
            }
            else {
                renNo_Max = dakuhiKetteiLst.size() + 1;
            }

            syoriCTL.setKetteikbn(C_KetteiKbn.KETTEI_SUMI);

            HT_DakuhiKettei dakuhiKettei = syoriCTL.createDakuhiKettei();

            C_Ketkekkacd ketkekkaCd = null;
            C_Ketriyuucd ketriyuuCd1 = null;
            C_Ketriyuucd ketriyuuCd2 = null;
            C_Ketriyuucd ketriyuuCd3 = null;
            C_Ketriyuucd ketriyuuCd4 = null;
            String syoubyouCd1 = null;
            C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn1 = null;
            BizDateYM kantiYm1 = null;
            String syoubyouCd2 = null;
            C_SyoubyoujyoutaiKbn syoubyouJyoutaiKbn2 = null;
            BizDateYM kantiYm2 = null;
            String ketsyaCd = null;
            String palKetsyaCd = null;
            Integer tkjysydkNo = null;
            BizDate tkjysydkYmd = null;
            C_TkjysydksyhyKbn tkjysydksyhyKbn = null;
            C_SntkinfosakuseiyhKbn sntkinfosakuseiyhKbn = null;
            C_TorikesisyousairiyuuCd torikesiSyousairiyuuCd = null;
            C_MrRiyuucdKbn mrRiyuucdKbn = null;

            if (C_KnkysateijyouKbn.NONE.eq(knkySateiJyouKbn) && C_ImusateijyouKbn.NONE.eq(imuSateiJyouKbn)) {
                ketkekkaCd = C_Ketkekkacd.MUJYOUKEN;
                ketriyuuCd1 = C_Ketriyuucd.BLNK;
                ketriyuuCd2 = C_Ketriyuucd.BLNK;
                ketriyuuCd3 = C_Ketriyuucd.BLNK;
                ketriyuuCd4 = C_Ketriyuucd.BLNK;
                syoubyouCd1 = "";
                syoubyouJyoutaiKbn1 = C_SyoubyoujyoutaiKbn.BLNK;
                kantiYm1 = null;
                syoubyouCd2 = "";
                syoubyouJyoutaiKbn2 = C_SyoubyoujyoutaiKbn.BLNK;
                kantiYm2 = null;
                ketsyaCd = "";
                palKetsyaCd = ISkCommonKoumoku.PALKETSYACD_KIKAIKETTEI;
                tkjysydkNo = 0;
                tkjysydkYmd = null;
                tkjysydksyhyKbn = C_TkjysydksyhyKbn.BLNK;
                sntkinfosakuseiyhKbn = C_SntkinfosakuseiyhKbn.SAKUSEIHUYOU;
                torikesiSyousairiyuuCd = C_TorikesisyousairiyuuCd.BLNK;
                mrRiyuucdKbn = C_MrRiyuucdKbn.BLNK;
            }

            if (C_KnkysateijyouKbn.SATEIZUMI.eq(knkySateiJyouKbn) && C_ImusateijyouKbn.NONE.eq(imuSateiJyouKbn)) {
                List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();
                knksateiRirekiLst = new SortHT_KnksateiRireki().OrderHT_KnksateiRirekiByPkDesc(knksateiRirekiLst);

                HT_KnksateiRireki knksateiRireki = knksateiRirekiLst.get(0);
                ketkekkaCd = knksateiRireki.getKetkekkacd();

                if (C_Ketkekkacd.MUJYOUKEN.eq(ketkekkaCd)) {
                    ketriyuuCd1 = knksateiRireki.getKetriyuucd1();
                    ketriyuuCd2 = knksateiRireki.getKetriyuucd2();
                    ketriyuuCd3 = knksateiRireki.getKetriyuucd3();
                    ketriyuuCd4 = knksateiRireki.getKetriyuucd4();
                    syoubyouCd1 = "";
                    syoubyouJyoutaiKbn1 = C_SyoubyoujyoutaiKbn.BLNK;
                    kantiYm1 = null;
                    syoubyouCd2 = "";
                    syoubyouJyoutaiKbn2 = C_SyoubyoujyoutaiKbn.BLNK;
                    kantiYm2 = null;
                    ketsyaCd = knksateiRireki.getKetsyacd();
                    palKetsyaCd = knksateiRireki.getPalketsyacd();
                    tkjysydkNo = 0;
                    tkjysydkYmd = null;
                    tkjysydksyhyKbn = C_TkjysydksyhyKbn.BLNK;
                    sntkinfosakuseiyhKbn = C_SntkinfosakuseiyhKbn.SAKUSEIHUYOU;
                    torikesiSyousairiyuuCd = knksateiRireki.getTorikesisyousairiyuucd();
                    mrRiyuucdKbn = knksateiRireki.getMrriyuucdkbn();
                }
            }

            if (C_KnkysateijyouKbn.NONE.eq(knkySateiJyouKbn) && C_ImusateijyouKbn.SATEIZUMI.eq(imuSateiJyouKbn)) {
                List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();
                imusateiRirekiLst = new SortHT_ImusateiRireki().OrderHT_ImusateiRirekiByPkDesc(imusateiRirekiLst);

                HT_ImusateiRireki imusateiRireki = imusateiRirekiLst.get(0);
                ketkekkaCd = imusateiRireki.getKetkekkacd();

                if (C_Ketkekkacd.MUJYOUKEN.eq(ketkekkaCd) || C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ketkekkaCd)) {
                    ketriyuuCd1 = imusateiRireki.getKetriyuucd1();
                    ketriyuuCd2 = imusateiRireki.getKetriyuucd2();
                    ketriyuuCd3 = imusateiRireki.getKetriyuucd3();
                    ketriyuuCd4 = imusateiRireki.getKetriyuucd4();
                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    syoubyouJyoutaiKbn1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    kantiYm1 = imusateiRireki.getKantiym1();
                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    syoubyouJyoutaiKbn2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    kantiYm2 = imusateiRireki.getKantiym2();
                    ketsyaCd = imusateiRireki.getKetsyacd();
                    palKetsyaCd = imusateiRireki.getPalketsyacd();
                    tkjysydkNo = 0;
                    tkjysydkYmd = null;
                    tkjysydksyhyKbn = C_TkjysydksyhyKbn.BLNK;
                    sntkinfosakuseiyhKbn = imusateiRireki.getSntkinfosakuseiyhkbn();
                    torikesiSyousairiyuuCd = C_TorikesisyousairiyuuCd.BLNK;
                    mrRiyuucdKbn = C_MrRiyuucdKbn.BLNK;
                }
            }

            if (C_KnkysateijyouKbn.SATEIZUMI.eq(knkySateiJyouKbn) && C_ImusateijyouKbn.SATEIZUMI.eq(imuSateiJyouKbn)) {
                List<HT_KnksateiRireki> knksateiRirekiLst = syoriCTL.getKnksateiRirekis();
                knksateiRirekiLst = new SortHT_KnksateiRireki().OrderHT_KnksateiRirekiByPkDesc(knksateiRirekiLst);

                HT_KnksateiRireki knksateiRireki = knksateiRirekiLst.get(0);
                C_Ketkekkacd ketkekkaCdKnk = knksateiRireki.getKetkekkacd();

                List<HT_ImusateiRireki> imusateiRirekiLst = syoriCTL.getImusateiRirekis();
                imusateiRirekiLst = new SortHT_ImusateiRireki().OrderHT_ImusateiRirekiByPkDesc(imusateiRirekiLst);

                HT_ImusateiRireki imusateiRireki = imusateiRirekiLst.get(0);
                C_Ketkekkacd ketkekkaCdImu = imusateiRireki.getKetkekkacd();

                if (C_Ketkekkacd.MUJYOUKEN.eq(ketkekkaCdKnk) &&
                    (C_Ketkekkacd.MUJYOUKEN.eq(ketkekkaCdImu) || C_Ketkekkacd.GENKAITAI_SYOUDAKU.eq(ketkekkaCdImu))) {
                    ketkekkaCd = imusateiRireki.getKetkekkacd();
                    ketriyuuCd1 = imusateiRireki.getKetriyuucd1();
                    ketriyuuCd2 = imusateiRireki.getKetriyuucd2();
                    ketriyuuCd3 = imusateiRireki.getKetriyuucd3();
                    ketriyuuCd4 = imusateiRireki.getKetriyuucd4();
                    syoubyouCd1 = imusateiRireki.getSyoubyoucd1();
                    syoubyouJyoutaiKbn1 = imusateiRireki.getSyoubyoujyoutaikbn1();
                    kantiYm1 = imusateiRireki.getKantiym1();
                    syoubyouCd2 = imusateiRireki.getSyoubyoucd2();
                    syoubyouJyoutaiKbn2 = imusateiRireki.getSyoubyoujyoutaikbn2();
                    kantiYm2 = imusateiRireki.getKantiym2();
                    ketsyaCd = imusateiRireki.getKetsyacd();
                    palKetsyaCd = imusateiRireki.getPalketsyacd();
                    tkjysydkNo = 0;
                    tkjysydkYmd = null;
                    tkjysydksyhyKbn = C_TkjysydksyhyKbn.BLNK;
                    sntkinfosakuseiyhKbn = imusateiRireki.getSntkinfosakuseiyhkbn();
                    torikesiSyousairiyuuCd = C_TorikesisyousairiyuuCd.BLNK;
                    mrRiyuucdKbn = C_MrRiyuucdKbn.BLNK;
                }
            }

            dakuhiKettei.setDakuhiktrenno(renNo_Max);
            dakuhiKettei.setKetymd(pMP.getSysDate());
            dakuhiKettei.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.DAKUHIKETTEI);
            dakuhiKettei.setKetkekkacd(ketkekkaCd);
            dakuhiKettei.setKetriyuucd1(ketriyuuCd1);
            dakuhiKettei.setKetriyuucd2(ketriyuuCd2);
            dakuhiKettei.setKetriyuucd3(ketriyuuCd3);
            dakuhiKettei.setKetriyuucd4(ketriyuuCd4);
            dakuhiKettei.setSyoubyoucd1(syoubyouCd1);
            dakuhiKettei.setSyoubyoujyoutaikbn1(syoubyouJyoutaiKbn1);
            dakuhiKettei.setKantiym1(kantiYm1);
            dakuhiKettei.setSyoubyoucd2(syoubyouCd2);
            dakuhiKettei.setSyoubyoujyoutaikbn2(syoubyouJyoutaiKbn2);
            dakuhiKettei.setKantiym2(kantiYm2);
            dakuhiKettei.setKetsyacd(ketsyaCd);
            dakuhiKettei.setPalketsyacd(palKetsyaCd);
            dakuhiKettei.setTkjysydkno(tkjysydkNo);
            dakuhiKettei.setTkjysydkymd(tkjysydkYmd);
            dakuhiKettei.setTkjysydksyhykbn(tkjysydksyhyKbn);
            dakuhiKettei.setSntkinfosakuseiyhkbn(sntkinfosakuseiyhKbn);
            dakuhiKettei.setTorikesisyousairiyuucd(torikesiSyousairiyuuCd);
            dakuhiKettei.setMrriyuucdkbn(mrRiyuucdKbn);
            dakuhiKettei.setGyoumuKousinsyaId(pMP.getKosID());
            dakuhiKettei.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(dakuhiKettei);
        }

        if (daimosNo.equals(mosNo)) {
            HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(daimosNo);
            if (jigyouIkkatu == null) {
                throw new CommonBizAppException("代表申込番号=" + daimosNo);
            }
            C_JiketteiKbn jgyIkt_JiKetteiKbn = jigyouIkkatu.getJiketteikbn();
            C_UmuKbn jgyIkt_MosNrkUmu = jigyouIkkatu.getMosnrkumu();
            C_UmuKbn jgyIkt_ItijiKetNrkUmu = jigyouIkkatu.getItijiketnrkumu();
            C_UmuKbn jgyIkt_HjyNrkUmu = jigyouIkkatu.getHjynrkumu();
            C_UmuKbn jgyIkt_KktNrkUmu = jigyouIkkatu.getKktnrkumu();

            if (C_JiketteiKbn.NONE.eq(jgyIkt_JiKetteiKbn) &&
                C_UmuKbn.ARI.eq(jgyIkt_MosNrkUmu) &&
                C_UmuKbn.ARI.eq(jgyIkt_ItijiKetNrkUmu) &&
                ((C_SntkhouKbn.HJY.eq(sntkHouKbn) && C_UmuKbn.ARI.eq(jgyIkt_HjyNrkUmu)) ||
                    (C_SntkhouKbn.KKT.eq(sntkHouKbn) && C_UmuKbn.ARI.eq(jgyIkt_KktNrkUmu)))) {

                jigyouIkkatu.setJiketteikbn(C_JiketteiKbn.KETTEI_MATI);
                jigyouIkkatu.setGyoumuKousinsyaId(pMP.getKosID());
                jigyouIkkatu.setGyoumuKousinTime(pMP.getKosTime());
                sinkeiyakuDomManager.update(jigyouIkkatu);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 決定処理 終了");
        }
    }
}