package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;


/**
 * 新契約 新契約共通 新契約申込未確定情報作成
 */
public class SkMosMikakuteiInfoSks {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public SkMosMikakuteiInfoSks() {
        super();
    }

    public void mosMikakuteiInfoSksOne(SkMosMikakuteiJyouhouKanriSksInBean pSkMosMikakuteiJyouhouKanriSksInBean) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 新契約申込未確定情報作成 開始");
        }

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri =
            sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(pSkMosMikakuteiJyouhouKanriSksInBean.getMosNo());
        if (mosMikakuteiJyouhouKanri == null) {
            mosMikakuteiJyouhouKanri = editMosMikakuteiInfo(pSkMosMikakuteiJyouhouKanriSksInBean);

            sinkeiyakuDomManager.insert(mosMikakuteiJyouhouKanri);
        }

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = editMosMikakuteiSyorui(pSkMosMikakuteiJyouhouKanriSksInBean);

        if (mosMikakuteiSyoruiLst.size() > 0) {

            sinkeiyakuDomManager.insert(mosMikakuteiSyoruiLst);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 新契約申込未確定情報作成 終了");
        }
    }

    public void mosMikakuteiInfoSksMany(
        ArrayList<SkMosMikakuteiJyouhouKanriSksInBean> pskMosMikakuteiJyouhouKanriSksInBeanLst) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 新契約申込未確定情報作成 開始");
        }

        if (pskMosMikakuteiJyouhouKanriSksInBeanLst != null && pskMosMikakuteiJyouhouKanriSksInBeanLst.size() != 0) {
            try (EntityInserter<HT_MosMikakuteiJyouhouKanri> entityInserterMosMikakuteiJyouhouKanri = new EntityInserter<>()) {
                for (SkMosMikakuteiJyouhouKanriSksInBean skMosMikakuteiJyouhouKanriSksInBean
                    : pskMosMikakuteiJyouhouKanriSksInBeanLst) {
                    HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri =
                        editMosMikakuteiInfo(skMosMikakuteiJyouhouKanriSksInBean);
                    entityInserterMosMikakuteiJyouhouKanri.add(mosMikakuteiJyouhouKanri);

                    List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst =
                        editMosMikakuteiSyorui(skMosMikakuteiJyouhouKanriSksInBean);

                    try (EntityInserter<HT_MosMikakuteiSyorui> entityInserterMosMikakuteiSyorui = new EntityInserter<>()){
                        for (HT_MosMikakuteiSyorui mosMikakuteiSyorui : mosMikakuteiSyoruiLst) {
                            entityInserterMosMikakuteiSyorui.add(mosMikakuteiSyorui);
                        }
                    }
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 新契約申込未確定情報作成 終了");
        }
    }

    private HT_MosMikakuteiJyouhouKanri editMosMikakuteiInfo(
        SkMosMikakuteiJyouhouKanriSksInBean pSkMosMikakuteiJyouhouKanriSksInBean) {

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = new HT_MosMikakuteiJyouhouKanri();

        BizDate sakujyoYoteiYmd = pSkMosMikakuteiJyouhouKanriSksInBean.getSyoriYmd();
        sakujyoYoteiYmd = sakujyoYoteiYmd.addDays(YuyuSinkeiyakuConfig.getInstance().getMosmikakuteiinfoKanriNissu());

        mosMikakuteiJyouhouKanri.setMosno(pSkMosMikakuteiJyouhouKanriSksInBean.getMosNo());
        mosMikakuteiJyouhouKanri.setJimutetuzukicd(pSkMosMikakuteiJyouhouKanriSksInBean.getJimuTetuzukiCd());
        mosMikakuteiJyouhouKanri.setSkeijimukbn(pSkMosMikakuteiJyouhouKanriSksInBean.getSkeijimuKbn());
        mosMikakuteiJyouhouKanri.setMosuketukekbn(pSkMosMikakuteiJyouhouKanriSksInBean.getMosUketukeKbn());
        mosMikakuteiJyouhouKanri.setHknsyuruino(pSkMosMikakuteiJyouhouKanriSksInBean.getHknsyuruiNo());
        mosMikakuteiJyouhouKanri.setDairitencd1(pSkMosMikakuteiJyouhouKanriSksInBean.getDairitenCd1());
        mosMikakuteiJyouhouKanri.setDairitencd2(pSkMosMikakuteiJyouhouKanriSksInBean.getDairitenCd2());
        mosMikakuteiJyouhouKanri.setJimuyoucd(pSkMosMikakuteiJyouhouKanriSksInBean.getJimuyouCd());
        mosMikakuteiJyouhouKanri.setDoujimosumu(pSkMosMikakuteiJyouhouKanriSksInBean.getDoujiMosUmu());
        mosMikakuteiJyouhouKanri.setSyono(pSkMosMikakuteiJyouhouKanriSksInBean.getSyoNo());
        mosMikakuteiJyouhouKanri.setSyorizumiflg(C_Syorizumiflg.MISYORI);
        mosMikakuteiJyouhouKanri.setSakujoyoteiymd(sakujyoYoteiYmd);
        mosMikakuteiJyouhouKanri.setSetmosno1(pSkMosMikakuteiJyouhouKanriSksInBean.getSetMosno1());
        mosMikakuteiJyouhouKanri.setGyoumuKousinsyaId(pSkMosMikakuteiJyouhouKanriSksInBean.getGyoumuKousinsyaId());
        mosMikakuteiJyouhouKanri.setGyoumuKousinTime(pSkMosMikakuteiJyouhouKanriSksInBean.getGyoumuKousinTime());

        BizPropertyInitializer.initialize(mosMikakuteiJyouhouKanri);

        return mosMikakuteiJyouhouKanri;
    }

    private List<HT_MosMikakuteiSyorui> editMosMikakuteiSyorui(
        SkMosMikakuteiJyouhouKanriSksInBean pSkMosMikakuteiJyouhouKanriSksInBean) {

        ArrayList<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = new ArrayList<>();

        for (SkMosMikakuteiSyoruiSksInBean skMosMikakuteiSyoruiSksInBean
            : pSkMosMikakuteiJyouhouKanriSksInBean.getSkMosMikakuteiSyoruiSksInBeanLst()) {

            HT_MosMikakuteiSyorui mosMikakuteiSyorui = new HT_MosMikakuteiSyorui();
            mosMikakuteiSyorui.setDocumentid(skMosMikakuteiSyoruiSksInBean.getDocumentId());
            mosMikakuteiSyorui.setMosno(pSkMosMikakuteiJyouhouKanriSksInBean.getMosNo());
            mosMikakuteiSyorui.setSyoruiCd(skMosMikakuteiSyoruiSksInBean.getSyoruiCd());
            mosMikakuteiSyorui.setGyoumuKousinsyaId(pSkMosMikakuteiJyouhouKanriSksInBean.getGyoumuKousinsyaId());
            mosMikakuteiSyorui.setGyoumuKousinTime(pSkMosMikakuteiJyouhouKanriSksInBean.getGyoumuKousinTime());

            BizPropertyInitializer.initialize(mosMikakuteiSyorui);
            mosMikakuteiSyoruiLst.add(mosMikakuteiSyorui);
        }

        return mosMikakuteiSyoruiLst;
    }
}
