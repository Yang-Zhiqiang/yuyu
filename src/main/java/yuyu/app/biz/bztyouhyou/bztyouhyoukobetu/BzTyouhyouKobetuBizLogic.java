package yuyu.app.biz.bztyouhyou.bztyouhyoukobetu;

import static yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.BzTyouhyouKobetuConstants.*;
import static yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.GenBzTyouhyouKobetuConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.app.workflow.processkanri.lockkyouseikaijyo.LockKyouseiKaijyoConstants;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.SyoruiZokuseiMasterInfoBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.infr.report.OutputReport;

/**
 * 帳票個別出力 のビジネスロジックです。
 */
public class BzTyouhyouKobetuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzTyouhyouKobetuUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private OutputReport outputReport;

    @Inject
    private BaseUserInfo baseUser;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseDomManager baseDomManager;

    String init() {

        BizPropertyInitializer.initialize(uiBean);

        YuyuBizConfig config = YuyuBizConfig.getInstance();

        List<String> hisiyouSubSystemList = config.getHisiyouSubsystemList();

        List<String> kensakuIdList = config.getKensakuIdList();

        List<String> kensakunmList = config.getKensakunmList();

        List<AT_UserRole> userRoleList = baseUser.getUser().getUserRoles();
        String[] arrRoles = new String[userRoleList.size()];

        for (int i = 0; i < userRoleList.size(); i++) {
            arrRoles[i] = userRoleList.get(i).getRoleCd();
        }

        List<SyoruiZokuseiMasterInfoBean> syoruiZokuseiMasterInfoBeanList = bizDomManager.getSyoruiZokuseiMasterInfoByRoleCdsSubSystemIds(
            arrRoles,
            hisiyouSubSystemList.toArray(new String[]{}));
        UserDefsList subSystemIdList = new UserDefsList();
        UserDefsList syoruiCdList = new UserDefsList();
        List<String> subIdLst = new ArrayList<String>();
        List<String> syoruiCdCheckLst = new ArrayList<String>();

        if (syoruiZokuseiMasterInfoBeanList.size() == 0) {
            messageManager.addMessageId(MessageId.IBA0009);

            return FORWARDNAME_EXERROR;
        }
        for (SyoruiZokuseiMasterInfoBean bean : syoruiZokuseiMasterInfoBeanList) {
            if (!subIdLst.contains(bean.getSubSystemId())) {
                LabelValuePair subSystemIdLp = new LabelValuePair(bean.getSubSystemNm(), bean.getSubSystemId());

                subSystemIdList.add(subSystemIdLp);
                subIdLst.add(bean.getSubSystemId());
            }
            if (!syoruiCdCheckLst.contains(bean.getSyoruiCd().getValue())) {
                LabelValuePair subSyoruiMei = new LabelValuePair(bean.getSyoruinm(), bean.getSubSystemId() + SPLITTER
                    + bean.getSyoruiCd().getValue());

                syoruiCdList.add(subSyoruiMei);
                syoruiCdCheckLst.add(bean.getSyoruiCd().getValue());
            }
        }

        String knskkmkname= "";
        Map<String,String> map =new HashMap<String, String>();
        for (SyoruiZokuseiMasterInfoBean bean : syoruiZokuseiMasterInfoBeanList) {
            knskkmkname = "";
            if (!BizUtil.isBlank(bean.getKensakuKey1())) {
                for (int count = 0 ; count < kensakuIdList.size(); count++) {
                    if (bean.getKensakuKey1().equals(kensakuIdList.get(count))) {
                        knskkmkname = knskkmkname + kensakunmList.get(count) + "#";
                        break;
                    }
                }
            }

            if (!BizUtil.isBlank(bean.getKensakuKey2())) {
                for (int count = 0 ; count < kensakuIdList.size(); count++) {
                    if (bean.getKensakuKey2().equals(kensakuIdList.get(count))) {
                        knskkmkname = knskkmkname + kensakunmList.get(count) + "#";
                        break;
                    }
                }
            }

            if (!BizUtil.isBlank(bean.getKensakuKey3())) {
                for (int count = 0 ; count < kensakuIdList.size(); count++) {
                    if (bean.getKensakuKey3().equals(kensakuIdList.get(count))) {
                        knskkmkname = knskkmkname + kensakunmList.get(count) + "#";
                        break;
                    }
                }
            }

            if (!BizUtil.isBlank(bean.getKensakuKey4())) {
                for (int count = 0 ; count < kensakuIdList.size(); count++) {
                    if (bean.getKensakuKey4().equals(kensakuIdList.get(count))) {
                        knskkmkname = knskkmkname + kensakunmList.get(count) + "#";
                        break;
                    }
                }
            }

            if (!BizUtil.isBlank(bean.getKensakuKey5())) {
                for (int count = 0 ; count < kensakuIdList.size(); count++) {
                    if (bean.getKensakuKey5().equals(kensakuIdList.get(count))) {
                        knskkmkname = knskkmkname + kensakunmList.get(count) + "#";
                        break;
                    }
                }
            }

            if (!BizUtil.isBlank(knskkmkname)) {
                knskkmkname = knskkmkname.substring(0,knskkmkname.length()-1);
            }

            map.put(bean.getSyoruiCd().getValue(), knskkmkname);
        }

        uiBean.setKensakunmMap(map);

        uiBean.setDispsyoruicd(syoruiZokuseiMasterInfoBeanList.get(0).getSyoruiCd().getValue());

        uiBean.setSrchsubsystemidOptionBeanList(subSystemIdList);
        uiBean.setSrchsyoruicdOptionBeanList(syoruiCdList);

        return FORWARDNAME_INPUTKEY;
    }

    void clear() {
    }

    void pushKensaku() {

        String subSystemId = uiBean.getSrchsubsystemid();

        String srchsyoruicd =uiBean.getSrchsyoruicd().substring(
            uiBean.getSrchsyoruicd().lastIndexOf(LockKyouseiKaijyoConstants.SPLITTER) + 1);

        C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.valueOf(srchsyoruicd);

        uiBean.setDispsyoruicd(uiBean.getSrchsyoruicd());

        String kensakuKey1 = uiBean.getKnskkmkid1();
        String kensakuKey2 = uiBean.getKnskkmkid2();
        String kensakuKey3 = uiBean.getKnskkmkid3();
        String kensakuKey4 = uiBean.getKnskkmkid4();
        String kensakuKey5 = uiBean.getKnskkmkid5();
        BizDate tyouhyouymdfrom = uiBean.getTyouhyouymdfrom();
        BizDate tyouhyouymdto = uiBean.getTyouhyouymdto();

        AM_SyoruiZokusei syoruiZokusei = baseDomManager.getSyoruiZokusei(syoruiCdKbn);
        List<String> kensakuIdList = YuyuBizConfig.getInstance().getKensakuIdList();
        List<String> kensakuNmList = YuyuBizConfig.getInstance().getKensakunmList();
        uiBean.setDispkensakukii1("");
        uiBean.setDispkensakukii2("");
        uiBean.setDispkensakukii3("");
        uiBean.setDispkensakukii4("");
        uiBean.setDispkensakukii5("");
        for (int idx = 0; idx < kensakuIdList.size(); idx++) {
            if (kensakuIdList.get(idx).equals(syoruiZokusei.getKensakuKey1())) {
                uiBean.setDispkensakukii1(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(syoruiZokusei.getKensakuKey2())) {
                uiBean.setDispkensakukii2(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(syoruiZokusei.getKensakuKey3())) {
                uiBean.setDispkensakukii3(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(syoruiZokusei.getKensakuKey4())) {
                uiBean.setDispkensakukii4(kensakuNmList.get(idx));
            }
            else if (kensakuIdList.get(idx).equals(syoruiZokusei.getKensakuKey5())) {
                uiBean.setDispkensakukii5(kensakuNmList.get(idx));
            }
        }

        Long cnt = bizDomManager.getTyouhyouKensakuCountByKensakuInfo(subSystemId, syoruiCdKbn, kensakuKey1,
            kensakuKey2, kensakuKey3, kensakuKey4, kensakuKey5, tyouhyouymdfrom, tyouhyouymdto);

        if (cnt <= DATA_NONE) {
            throw new BizLogicException(MessageId.EBA0014);
        } else if (cnt >= DATA_LIMIT_COUNT){
            throw new BizLogicException(MessageId.EHA0361, String.valueOf(DATA_LIMIT_COUNT));
        }

        List<AT_TyouhyouKensaku>tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo(subSystemId, syoruiCdKbn,
            kensakuKey1, kensakuKey2, kensakuKey3, kensakuKey4, kensakuKey5, tyouhyouymdfrom, tyouhyouymdto);

        setKensakuKekkaList(tyouhyouKensakuLst);

    }

    void pushOutBL() {

        updateKensakuKekkaList();

        uiBean.setPrintOutFlg(true);
    }

    void print() {
        outputReport.outputPDFSingle(uiBean.getReportKey());
    }


    private void setKensakuKekkaList(List<AT_TyouhyouKensaku> pTyouhyouKensakuLst) {

        List<KensakuKekkaItiranListDataSourceBean> displaySrcResult = new ArrayList<>();

        for (AT_TyouhyouKensaku tyouhyouKensaku: pTyouhyouKensakuLst) {
            KensakuKekkaItiranListDataSourceBean data = new KensakuKekkaItiranListDataSourceBean();
            data.setTyouhyouSyuturyokuLink(MessageUtil.getMessage(DDID_KENSAKUKEKKAITIRANLIST_TYOUHYOUSYUTURYOKULINK.getErrorResourceKey()));
            data.setDisptyouhyoukey(tyouhyouKensaku.getReportKey());
            data.setKnskkmknm1(tyouhyouKensaku.getKensakuKey1());
            data.setKnskkmknm2(tyouhyouKensaku.getKensakuKey2());
            data.setKnskkmknm3(tyouhyouKensaku.getKensakuKey3());
            data.setKnskkmknm4(tyouhyouKensaku.getKensakuKey4());
            data.setKnskkmknm5(tyouhyouKensaku.getKensakuKey5());
            data.setDisptyouhyousakuseiymd(tyouhyouKensaku.getSyoriYmd());
            data.setDispoutkaisuu(tyouhyouKensaku.getOutCount().longValue());
            data.setDispfstoutymd(tyouhyouKensaku.getFirstOutYmd());
            data.setDisplstoutymd(tyouhyouKensaku.getLastOutYmd());
            displaySrcResult.add(data);
        }
        uiBean.setKensakuKekkaItiranList(displaySrcResult);
    }

    private void updateKensakuKekkaList() {

        KensakuKekkaItiranListDataSourceBean bean = uiBean.getKensakuKekkaItiranListDataSource().getSelectedBean();

        uiBean.setReportKey(bean.getDisptyouhyoukey());
        bean.setDispoutkaisuu(bean.getDispoutkaisuu() + 1);
        if (null == bean.getDispfstoutymd()) {
            bean.setDispfstoutymd(BizDate.getSysDate());
        }
        bean.setDisplstoutymd(BizDate.getSysDate());

    }
}
