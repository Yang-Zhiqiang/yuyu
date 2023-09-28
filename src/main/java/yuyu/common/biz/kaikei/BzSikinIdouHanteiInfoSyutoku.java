package yuyu.common.biz.kaikei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.kaikei.dba4bzsikinidouhanteiinfosyutoku.BzSikinIdouHanteiInfoSyutokuDao;
import yuyu.common.biz.kaikei.dba4bzsikinidouhanteiinfosyutoku.SikinIdouHanteiInfoBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.entity.BM_SyouhnZokusei;

/**
 * 業務共通 経理・会計 資金移動判定情報取得
 */
public class BzSikinIdouHanteiInfoSyutoku {

    private Map<C_Segcd, SikinIdouHanteiInfoBean> sikinIdouHanteiInfoDataMap;

    @Inject
    private BzSikinIdouHanteiInfoSyutokuDao bzSikinIdouHanteiInfoSyutokuDao;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public BzSikinIdouHanteiInfoSyutoku() {
        super();
    }

    public SikinIdouHanteiInfoDataBean getSikinIdouHanteiInfoDataBean(C_Segcd pSegCd) {

        logger.debug("▽ 資金移動判定情報Bean取得 開始");

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = SWAKInjector.getInstance(SikinIdouHanteiInfoDataBean.class);

        sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.ERROR);

        BM_SegmentSikinidou segmentSikinidou = bizDomManager.getSegmentSikinidou(pSegCd);

        if (segmentSikinidou != null) {

            BM_SyouhnZokusei syouhnZokusei = bzSikinIdouHanteiInfoSyutokuDao.getSyouhnZokusei(segmentSikinidou.getDaihyousyouhncd());

            if (syouhnZokusei != null) {

                sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
                sikinIdouHanteiInfoDataBean.setSegCd(segmentSikinidou.getSegcd());
                sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(segmentSikinidou.getHijynnykzndkkouzakbn());
                sikinIdouHanteiInfoDataBean.setFstpGkhnkzidouRt(segmentSikinidou.getFstpgkhnkzidourt());
                sikinIdouHanteiInfoDataBean.setZenkiZennouGkhnkzidouRt(segmentSikinidou.getZenkizennougkhnkzidourt());
                sikinIdouHanteiInfoDataBean.setKeizokupGkhnkzidouRt(segmentSikinidou.getKeizokupgkhnkzidourt());
                sikinIdouHanteiInfoDataBean.setSeiymdSeitstuityouhnknUmu(segmentSikinidou.getSeiymdseitstuityouhnknumu());
                sikinIdouHanteiInfoDataBean.setZeiseiTekikakuUmu(syouhnZokusei.getZeiseitekikakuumu());
                sikinIdouHanteiInfoDataBean.setItijibrUmu(syouhnZokusei.getItijibrumu());
                sikinIdouHanteiInfoDataBean.setSbHkuktUmu(syouhnZokusei.getSbhkuktumu());
                sikinIdouHanteiInfoDataBean.setSbKyuuhukinuktUmu(syouhnZokusei.getSbkyuuhukinuktumu());
            }
        }

        logger.debug("△ 資金移動判定情報Bean取得 終了");

        return sikinIdouHanteiInfoDataBean;
    }

    public void initSikinIdouHanteiInfoData() {

        logger.debug("▽ 資金移動判定情報大量データ初期処理 開始");

        sikinIdouHanteiInfoDataMap = new HashMap<C_Segcd, SikinIdouHanteiInfoBean>();

        List<SikinIdouHanteiInfoBean> sikinIdouHanteiInfoBeanLst = bzSikinIdouHanteiInfoSyutokuDao.getSikinIdouHanteiInfoBeans();

        for (SikinIdouHanteiInfoBean sikinIdouHanteiInfoBean : sikinIdouHanteiInfoBeanLst) {

            sikinIdouHanteiInfoDataMap.put(sikinIdouHanteiInfoBean.getSegCd(), sikinIdouHanteiInfoBean);
        }

        logger.debug("△ 資金移動判定情報大量データ初期処理 終了");
    }

    public SikinIdouHanteiInfoDataBean getMultipleSikinIdouHanteiInfoDataBean(C_Segcd pSegCd) {

        logger.debug("▽ 資金移動判定情報Bean取得（大量データ） 開始");

        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = SWAKInjector.getInstance(SikinIdouHanteiInfoDataBean.class);

        sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.ERROR);

        if (sikinIdouHanteiInfoDataMap.containsKey(pSegCd)) {

            SikinIdouHanteiInfoBean sikinIdouHanteiInfoBean = sikinIdouHanteiInfoDataMap.get(pSegCd);

            sikinIdouHanteiInfoDataBean.setErrorKbn(C_ErrorKbn.OK);
            sikinIdouHanteiInfoDataBean.setSegCd(sikinIdouHanteiInfoBean.getSegCd());
            sikinIdouHanteiInfoDataBean.setHijynnykZndkkouzaKbn(sikinIdouHanteiInfoBean.getHijynnykZndkkouzaKbn());
            sikinIdouHanteiInfoDataBean.setFstpGkhnkzidouRt(sikinIdouHanteiInfoBean.getFstpGkhnkzidouRt());
            sikinIdouHanteiInfoDataBean.setZenkiZennouGkhnkzidouRt(sikinIdouHanteiInfoBean.getZenkiZennouGkhnkzidouRt());
            sikinIdouHanteiInfoDataBean.setKeizokupGkhnkzidouRt(sikinIdouHanteiInfoBean.getKeizokupGkhnkzidouRt());
            sikinIdouHanteiInfoDataBean.setSeiymdSeitstuityouhnknUmu(sikinIdouHanteiInfoBean.getSeiymdSeitstuityouhnknUmu());
            sikinIdouHanteiInfoDataBean.setZeiseiTekikakuUmu(sikinIdouHanteiInfoBean.getZeiseiTekikakuUmu());
            sikinIdouHanteiInfoDataBean.setItijibrUmu(sikinIdouHanteiInfoBean.getItijibrUmu());
            sikinIdouHanteiInfoDataBean.setSbHkuktUmu(sikinIdouHanteiInfoBean.getSbHkuktUmu());
            sikinIdouHanteiInfoDataBean.setSbKyuuhukinuktUmu(sikinIdouHanteiInfoBean.getSbKyuuhukinuktUmu());
        }

        logger.debug("△ 資金移動判定情報Bean取得（大量データ） 終了");

        return sikinIdouHanteiInfoDataBean;
    }
}
