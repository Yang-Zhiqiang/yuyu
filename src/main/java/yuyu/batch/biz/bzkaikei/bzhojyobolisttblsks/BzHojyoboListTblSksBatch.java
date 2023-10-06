package yuyu.batch.biz.bzkaikei.bzhojyobolisttblsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.ZengetubunDenpyouDatasByDenymdFromDenymdToBean;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 補助簿リスト用テーブル作成クラス
 */
public class BzHojyoboListTblSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    private final String ZERO_3KETA = "000";

    private final String KEIYAKU_TORIKESI = "RB31";

    private final String NYUUKIN_SYORI = "RDHU";

    private final String  HAITOUKINTUIBARA = "RBD4";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        long syoriKensuu = 0;
        String wkHjybtantositucd = null;
        String wkSyorisyokantantcd = null;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        List<TyouhyouOutNasiInfoBean> tyouhyouOutNasiInfoBeanLst = new ArrayList<>();

        ZengetubunDenpyouDatasByDenymdFromDenymdToBean prevDenpyouDataBean = null;
        BT_Hjyblist hjybList = null;
        String prevHjybtantositucd = null;
        String prevSyorisyokantantcd = null;

        try (EntityInserter<BT_Hjyblist> hjyblistEntityInserter = new EntityInserter<>();
            EntityUpdater<BT_Hjyblist> hjyblistEntityUpdater = new EntityUpdater<>();
            ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> denpyouDatasBeanLst =
                bizDomManager.getZengetubunDenpyouDatasByDenymdFromDenymdTo(
                    syoriYmd.getBizDateYM().getPreviousMonth().getFirstDay(),
                    syoriYmd.getBizDateYM().getPreviousMonth().getLastDay())) {

            for (ZengetubunDenpyouDatasByDenymdFromDenymdToBean denpyouDatasBean : denpyouDatasBeanLst) {

                boolean tyouhyouOutUmu = tyouhyouOutUmuCheck(denpyouDatasBean.getSyorisosikicd().substring(0,3));

                if (!tyouhyouOutUmu) {

                    TyouhyouOutNasiInfoBean tyouhyouOutNasiInfoBean = SWAKInjector.getInstance(TyouhyouOutNasiInfoBean.class);

                    tyouhyouOutNasiInfoBean.setHjybTantosituCd(denpyouDatasBean.getHjybtantositucd());
                    tyouhyouOutNasiInfoBean.setKanjyoukmkCd(denpyouDatasBean.getKanjyoukmkcd());
                    tyouhyouOutNasiInfoBean.setBusituCd(denpyouDatasBean.getBusitucd());
                    tyouhyouOutNasiInfoBean.setDenYmd(denpyouDatasBean.getDenymd());
                    tyouhyouOutNasiInfoBean.setKarikataGk(denpyouDatasBean.getKarikatagk());
                    tyouhyouOutNasiInfoBean.setKasikataGk(denpyouDatasBean.getKasikatagk());
                    tyouhyouOutNasiInfoBean.setSyoricd(denpyouDatasBean.getSyoricd());
                    tyouhyouOutNasiInfoBean.setHuridenatesakicd(denpyouDatasBean.getHuridenatesakicd());

                    tyouhyouOutNasiInfoBeanLst.add(tyouhyouOutNasiInfoBean);

                    continue;
                }

                if (ZERO_3KETA.equals(denpyouDatasBean.getHjybtantositucd())) {

                    wkHjybtantositucd = denpyouDatasBean.getSyorisosikicd().substring(0,3);
                    wkSyorisyokantantcd = ZERO_3KETA;
                }
                else {

                    wkHjybtantositucd = denpyouDatasBean.getHjybtantositucd();
                    wkSyorisyokantantcd = denpyouDatasBean.getSyorisosikicd().substring(0,3);
                }

                if (hjybList == null) {
                    hjybList = new BT_Hjyblist();
                    hjybList.setHjybtantositucd(wkHjybtantositucd);
                    hjybList.setKanjyoukmkcd(denpyouDatasBean.getKanjyoukmkcd());
                    hjybList.setSyorisyokantantcd(wkSyorisyokantantcd);
                    hjybList.setDenymd(denpyouDatasBean.getDenymd());
                    hjybList.setKarikatagk(denpyouDatasBean.getKarikatagk());
                    hjybList.setKasikatagk(denpyouDatasBean.getKasikatagk());
                }
                else if (wkHjybtantositucd.equals(prevHjybtantositucd) &&
                    wkSyorisyokantantcd.equals(prevSyorisyokantantcd) &&
                    denpyouDatasBean.getKanjyoukmkcd().equals(prevDenpyouDataBean.getKanjyoukmkcd()) &&
                    denpyouDatasBean.getDenymd().equals(prevDenpyouDataBean.getDenymd())) {
                    hjybList.setKarikatagk(
                        hjybList.getKarikatagk().add(denpyouDatasBean.getKarikatagk()));
                    hjybList.setKasikatagk(
                        hjybList.getKasikatagk().add(denpyouDatasBean.getKasikatagk()));
                }
                else {
                    BizPropertyInitializer.initialize(hjybList);

                    hjyblistEntityInserter.add(hjybList);

                    hjybList = new BT_Hjyblist();

                    hjybList.setHjybtantositucd(wkHjybtantositucd);
                    hjybList.setKanjyoukmkcd(denpyouDatasBean.getKanjyoukmkcd());
                    hjybList.setSyorisyokantantcd(wkSyorisyokantantcd);
                    hjybList.setDenymd(denpyouDatasBean.getDenymd());
                    hjybList.setKarikatagk(denpyouDatasBean.getKarikatagk());
                    hjybList.setKasikatagk(denpyouDatasBean.getKasikatagk());
                }

                prevDenpyouDataBean = denpyouDatasBean;
                prevHjybtantositucd = wkHjybtantositucd;
                prevSyorisyokantantcd = wkSyorisyokantantcd;

                syoriKensuu++;
            }

            if(hjybList != null) {
                BizPropertyInitializer.initialize(hjybList);

                hjyblistEntityInserter.add(hjybList);

                bizDomManager.flush();
            }

            for (TyouhyouOutNasiInfoBean tyouhyouOutNasiInfoBean : tyouhyouOutNasiInfoBeanLst) {

                String hjybTantosituCd = "";
                String syoriSyokanTantCd = "";

                if (ZERO_3KETA.equals(tyouhyouOutNasiInfoBean.getHjybTantosituCd())) {

                    if (KEIYAKU_TORIKESI.equals(tyouhyouOutNasiInfoBean.getSyoricd()) ||
                        NYUUKIN_SYORI.equals(tyouhyouOutNasiInfoBean.getSyoricd()) ||
                        HAITOUKINTUIBARA.equals(tyouhyouOutNasiInfoBean.getSyoricd())) {

                        hjybTantosituCd = tyouhyouOutNasiInfoBean.getHuridenatesakicd();
                    }
                    else {

                        hjybTantosituCd = tyouhyouOutNasiInfoBean.getBusituCd();
                    }

                    syoriSyokanTantCd = ZERO_3KETA;
                }
                else {

                    hjybTantosituCd = tyouhyouOutNasiInfoBean.getHjybTantosituCd();

                    if (KEIYAKU_TORIKESI.equals(tyouhyouOutNasiInfoBean.getSyoricd()) ||
                        NYUUKIN_SYORI.equals(tyouhyouOutNasiInfoBean.getSyoricd()) ||
                        HAITOUKINTUIBARA.equals(tyouhyouOutNasiInfoBean.getSyoricd())) {

                        syoriSyokanTantCd = tyouhyouOutNasiInfoBean.getHuridenatesakicd();
                    }
                    else {

                        syoriSyokanTantCd = tyouhyouOutNasiInfoBean.getBusituCd();
                    }
                }

                BT_Hjyblist hjyblist = bizDomManager.getHjyblist(hjybTantosituCd,
                    tyouhyouOutNasiInfoBean.getKanjyoukmkCd(), syoriSyokanTantCd, tyouhyouOutNasiInfoBean.getDenYmd());

                if (hjyblist == null) {

                    hjyblist = new BT_Hjyblist();

                    hjyblist.setHjybtantositucd(hjybTantosituCd);
                    hjyblist.setKanjyoukmkcd(tyouhyouOutNasiInfoBean.getKanjyoukmkCd());
                    hjyblist.setSyorisyokantantcd(syoriSyokanTantCd);
                    hjyblist.setDenymd(tyouhyouOutNasiInfoBean.getDenYmd());
                    hjyblist.setKarikatagk(tyouhyouOutNasiInfoBean.getKarikataGk());
                    hjyblist.setKasikatagk(tyouhyouOutNasiInfoBean.getKasikataGk());

                    BizPropertyInitializer.initialize(hjyblist);

                    hjyblistEntityInserter.add(hjyblist);

                    syoriKensuu++;
                }
                else {

                    hjyblist.setKarikatagk(hjyblist.getKarikatagk().add(tyouhyouOutNasiInfoBean.getKarikataGk()));
                    hjyblist.setKasikatagk(hjyblist.getKasikatagk().add(tyouhyouOutNasiInfoBean.getKasikataGk()));

                    hjyblistEntityUpdater.add(hjyblist);
                }

            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private boolean tyouhyouOutUmuCheck(String pSyorisosikicd) {

        if (YuyuBizConfig.getInstance().getHjybtantositucd1().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd2().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd3().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd4().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd5().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd6().equals(pSyorisosikicd) ||
            YuyuBizConfig.getInstance().getHjybtantositucd7().equals(pSyorisosikicd)) {

            return true;
        }
        return false;
    }

}
