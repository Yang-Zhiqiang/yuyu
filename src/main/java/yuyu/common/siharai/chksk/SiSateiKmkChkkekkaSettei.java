package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.siharai.manager.SiharaiDomManager;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 請求内容チェック 査定項目チェック結果設定処理
 */
public class SiSateiKmkChkkekkaSettei {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager manager;

    public SiSateiKmkChkkekkaSettei() {
        super();
    }

    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu, String pYobidasiMotoKinouID,
        C_SikinouModeIdKbn pYobidasiMotoTaskID,
        CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean, CheckKdSkNaiyouKekkaBean pCheckKdSkNaiyouKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 査定項目チェック結果設定処理 開始");
        C_YobidasimotoTaskKbn yobidasimotoTaskKbn = null;
        List<String> sateiMsgLst = Lists.newArrayList();
        C_YouhiKbn sateiKaisouYouhiKbn = pCheckSbSkNaiyouKekkaBean.getSateiKaisouYouhiKbn();
        C_KahiKbn keisanKahiKbn = pCheckSbSkNaiyouKekkaBean.getKeisanKahiKbn();

        if (TeisuuSiharai.SISEIKYUUUKETUKESB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.INPUT.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.TENKEN.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SKUKE;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.SATEI1.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI2.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI3.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI4.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.HUBIKANRITYUU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAKUNINIRAITYUU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SATEI;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.TETUDUKI_SYOUNIN;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.SESSYOU1.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SESSYOU2.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SESYOU_KAIKETU;
        }
        for (ChkKekkaBean chkKekkaBean : pChkKekkaBeanLst) {
            JM_SkNaiyouChk skNaiyouChk = manager.getSkNaiyouChk(chkKekkaBean.getSKNaiyouChkKbn(), yobidasimotoTaskKbn);
            if (skNaiyouChk != null) {
                SiMsgHikisuuSettei siMsgHikisuuSettei = SWAKInjector.getInstance(SiMsgHikisuuSettei.class);
                List<String> msgLst = siMsgHikisuuSettei.exec(skNaiyouChk, chkKekkaBean.getMsgHikisuu1(),
                    chkKekkaBean.getMsgHikisuu2(), chkKekkaBean.getMsgHikisuu3(),
                    chkKekkaBean.getMsgHikisuu4(), chkKekkaBean.getMsgHikisuu5());
                String msgBugenn = MessageUtil.getMessage(skNaiyouChk.getMessageId(), msgLst.get(0),
                    msgLst.get(1), msgLst.get(2), msgLst.get(3), msgLst.get(4));
                sateiMsgLst.add(msgBugenn);

                if (C_YouhiKbn.YOU.eq(skNaiyouChk.getSateikaisouyouhikbn())) {
                    sateiKaisouYouhiKbn = skNaiyouChk.getSateikaisouyouhikbn();
                }
                if (C_KahiKbn.HUKA.eq(skNaiyouChk.getKeisankahikbn())) {
                    keisanKahiKbn = skNaiyouChk.getKeisankahikbn();
                }
            }
            else {
                throw new BizAppException(MessageId.EBS0004, "JM_SkNaiyouChk", "C_SKNaiyouChkKbn",
                    chkKekkaBean.getSKNaiyouChkKbn().getValue());
            }
        }
        List<ChkKekkaBean> listTemp = Lists.newArrayList();
        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {
            pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(sateiKaisouYouhiKbn);
            pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(keisanKahiKbn);

            for (int n = 0; n < sateiMsgLst.size(); n++) {
                ChkKekkaBean chkKekkaBeanTemp = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBeanTemp.setSKNaiyouChkKbn(pChkKekkaBeanLst.get(n).getSKNaiyouChkKbn());
                listTemp.add(chkKekkaBeanTemp);
                pCheckSbSkNaiyouKekkaBean.setChkKekkaBeanList(listTemp);
            }
            pCheckSbSkNaiyouKekkaBean.setSateiKoumokuMessage(Joiner.on("　").join(sateiMsgLst));
        }
        else if (C_SeikyuuSyubetu.KOUSG.eq(pSeikyuuSyubetu)) {
            for (int n = 0; n < sateiMsgLst.size(); n++) {
                ChkKekkaBean chkKekkaBeanTemp = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBeanTemp.setSKNaiyouChkKbn(pChkKekkaBeanLst.get(n).getSKNaiyouChkKbn());
                listTemp.add(chkKekkaBeanTemp);
                pCheckKdSkNaiyouKekkaBean.setChkKekkaBeanList(listTemp);
            }
            pCheckKdSkNaiyouKekkaBean.setSateiKoumokuMessage(Joiner.on("　").join(sateiMsgLst));
        }
        logger.debug("△ 査定項目チェック結果設定処理 終了");
    }
}
