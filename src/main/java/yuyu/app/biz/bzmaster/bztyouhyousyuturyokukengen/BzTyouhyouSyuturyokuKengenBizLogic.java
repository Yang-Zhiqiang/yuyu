package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import static yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen.GenBzTyouhyouSyuturyokuKengenConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;

import com.google.common.collect.Lists;

/**
 * 帳票出力権限登録 のビジネスロジックです。
 */
public class BzTyouhyouSyuturyokuKengenBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzTyouhyouSyuturyokuKengenUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void getSubSystemId() {

        List<String> hisiyouSubsystemLst = Lists.newArrayList(YuyuBizConfig.getInstance().getHisiyouSubsystemList());

        List<AS_SubSystem> subSystemInfoLst =
                bizDomManager.getSubSystemsBySubSystemIds(hisiyouSubsystemLst.toArray(new String[0]));

        UserDefsList udList = new UserDefsList();
        udList.add(new LabelValuePair("", ""));

        for (AS_SubSystem subsystem : subSystemInfoLst) {
            udList.add(new LabelValuePair(subsystem.getSubSystemNm(), subsystem.getSubSystemId()));
        }

        uiBean.setSubSystemIdOptionBeanList(udList);
    }

    void checkRelation() {

        AM_Role role = baseDomManager.getRole(uiBean.getRoleCd());

        if (role == null) {
            throw new BizLogicException(MessageId.EBA0030, MessageUtil.getMessage(DDID_KEYINFO_ROLECD.getErrorResourceKey()));
        }

        uiBean.setRoleNm(role.getRoleNm());
    }

    void pushUpdBL() {

        String subSystemId = uiBean.getSubSystemId();
        UserDefsList udList = uiBean.getSubSystemIdOptionBeanList();

        String[] subSystemIds;
        if (BizUtil.isBlank(subSystemId)) {

            subSystemIds = new String[udList.size() ];
            for (int i = 0; i < udList.size(); i++) {
                subSystemIds[i] = udList.get(i).getValue();
            }
        }
        else {
            subSystemIds = new String[]{subSystemId};
        }

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiInfoLst = bizDomManager.
                getSyoruiZokuseiHukaInfosBySubSystemIds(subSystemIds);

        if (syoruiZokuseiInfoLst.isEmpty()) {
            throw new BizLogicException(MessageId.EBA0022);
        }

        List<TyouhyouListDataSourceBean> tyouhyouLst = new ArrayList<TyouhyouListDataSourceBean>();
        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = Lists.newArrayList();

        for (BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo : syoruiZokuseiInfoLst) {
            TyouhyouListDataSourceBean tyouhyouBean = new TyouhyouListDataSourceBean();
            tyouhyouBean.setDispsubsystemnm(syoruiZokuseiHukaInfo.getSubSystem().getSubSystemNm());
            tyouhyouBean.setDispsyoruinm(syoruiZokuseiHukaInfo.getSyoruiZokusei().getSyoruinm());
            tyouhyouBean.setSyoruiCd(syoruiZokuseiHukaInfo.getSyoruiCd());

            BT_TyouhyouOutputKengen tyouhyouOutputKengen =
                    bizDomManager.getTyouhyouOutputKengen(uiBean.getRoleCd(), syoruiZokuseiHukaInfo.getSyoruiCd());
            if (tyouhyouOutputKengen != null) {
                if (C_KahiKbn.KA.eq(tyouhyouOutputKengen.getIkkatuoutputkahikbn())) {
                    tyouhyouBean.setDispikkatuoutputchkbox(true);
                }
                if (C_KahiKbn.KA.eq(tyouhyouOutputKengen.getKobetuoutputkahikbn())) {
                    tyouhyouBean.setDispkobetuoutputchkbox(true);
                }

                tyouhyouOutputKengenLst.add(tyouhyouOutputKengen);

            }
            tyouhyouLst.add(tyouhyouBean);
        }

        uiBean.setTyouhyouList(tyouhyouLst);
        uiBean.setTyouhyouOutputKengenLst(tyouhyouOutputKengenLst);
    }

    void pushKakuninBL() {

        messageManager.addMessageId(MessageId.QHA0007);
    }

    @Transactional
    void pushKakuteiBL() {

        doUpdateTable();

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void doUpdateTable() {

        bizDomManager.delete(uiBean.getTyouhyouOutputKengenLst());
        bizDomManager.flush();

        List<TyouhyouListDataSourceBean> tyouhyouLst = uiBean.getTyouhyouListDataSource().getDatas();
        String sysTime = BizDate.getSysDateTimeMilli();
        for (TyouhyouListDataSourceBean tyouhyouBean : tyouhyouLst) {

            if (tyouhyouBean.getDispikkatuoutputchkbox() == true ||
                    tyouhyouBean.getDispkobetuoutputchkbox() == true) {
                BT_TyouhyouOutputKengen tyouhyouOutputKengen = new BT_TyouhyouOutputKengen();
                tyouhyouOutputKengen.setRoleCd(uiBean.getRoleCd());
                tyouhyouOutputKengen.setSyoruiCd(tyouhyouBean.getSyoruiCd());

                if (tyouhyouBean.getDispikkatuoutputchkbox() == true) {
                    tyouhyouOutputKengen.setIkkatuoutputkahikbn(C_KahiKbn.KA);
                }
                else {
                    tyouhyouOutputKengen.setIkkatuoutputkahikbn(C_KahiKbn.HUKA);
                }

                if (tyouhyouBean.getDispkobetuoutputchkbox() == true) {
                    tyouhyouOutputKengen.setKobetuoutputkahikbn(C_KahiKbn.KA);
                }
                else {
                    tyouhyouOutputKengen.setKobetuoutputkahikbn(C_KahiKbn.HUKA);
                }
                tyouhyouOutputKengen.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                tyouhyouOutputKengen.setGyoumuKousinTime(sysTime);
                BizPropertyInitializer.initialize(tyouhyouOutputKengen);
                bizDomManager.insert(tyouhyouOutputKengen);
            }
        }
    }
}
